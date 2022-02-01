package com.tencent.hippy.qq.update.tool;

import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEntry;
import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipOutputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QarBody
  extends QIO
{
  public static final int TYPE_DIR = 2;
  public static final int TYPE_FILE = 1;
  public int countEx;
  public long crc = -1L;
  public List<ExtensionFiled> exs = null;
  public long fileLength = -1L;
  public String fileName = "";
  public int hasEx = -1;
  public int method = 8;
  public int type = -1;
  
  private boolean checkRequiredParam()
  {
    if ((this.type != -1) && (!this.fileName.equals("")))
    {
      if (this.hasEx == -1) {
        return false;
      }
      return (this.type != 1) || ((this.fileLength != -1L) && (this.crc != -1L));
    }
    return false;
  }
  
  public void md5Body(MessageDigest paramMessageDigest)
  {
    if (!checkRequiredParam()) {
      return;
    }
    md5Int(paramMessageDigest, this.type);
    md5String(paramMessageDigest, this.fileName);
    md5Long(paramMessageDigest, this.fileLength);
    md5Long(paramMessageDigest, this.crc);
    md5Int(paramMessageDigest, this.method);
    md5Int(paramMessageDigest, this.hasEx);
    if (this.hasEx == 1)
    {
      this.countEx = this.exs.size();
      md5Int(paramMessageDigest, this.countEx);
      Iterator localIterator = this.exs.iterator();
      while (localIterator.hasNext()) {
        ((ExtensionFiled)localIterator.next()).md5Ex(paramMessageDigest);
      }
    }
  }
  
  public void md5BodyData(MessageDigest paramMessageDigest, InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i <= 0) {
        break;
      }
      paramMessageDigest.update(paramArrayOfByte, 0, i);
    }
  }
  
  public QarBody readBody(InputStream paramInputStream)
  {
    this.type = readInt(paramInputStream);
    this.fileName = readString(paramInputStream);
    this.fileLength = readLong(paramInputStream);
    this.crc = readLong(paramInputStream);
    this.method = readInt(paramInputStream);
    this.hasEx = readInt(paramInputStream);
    if (this.hasEx == 1)
    {
      this.countEx = readInt(paramInputStream);
      this.exs = new ArrayList();
      int i = 0;
      while (i < this.countEx)
      {
        String str1 = readString(paramInputStream);
        String str2 = readString(paramInputStream);
        ExtensionFiled localExtensionFiled = new ExtensionFiled();
        localExtensionFiled.setEx(str1, str2);
        this.exs.add(localExtensionFiled);
        i += 1;
      }
    }
    return this;
  }
  
  public void readBodyData(InputStream paramInputStream, ZipOutputStream paramZipOutputStream, byte[] paramArrayOfByte)
  {
    ZipEntry localZipEntry = new ZipEntry(this.fileName);
    localZipEntry.setSize(this.fileLength);
    paramZipOutputStream.putNextEntry(localZipEntry);
    long l2;
    long l3;
    for (long l1 = 0L;; l1 = l2)
    {
      l2 = 32768L + l1;
      l3 = this.fileLength;
      if (l2 >= l3) {
        break;
      }
      paramInputStream.read(paramArrayOfByte);
      paramZipOutputStream.write(paramArrayOfByte, 0, 2048);
    }
    int i = (int)(l3 - l1);
    paramArrayOfByte = new byte[i];
    paramInputStream.read(paramArrayOfByte);
    paramZipOutputStream.write(paramArrayOfByte, 0, i);
  }
  
  public void setBody(int paramInt1, String paramString, long paramLong1, long paramLong2, int paramInt2)
  {
    this.type = paramInt1;
    this.fileLength = paramLong1;
    this.fileName = paramString;
    this.crc = paramLong2;
    this.method = paramInt2;
  }
  
  public void setExtensionFileds(List<ExtensionFiled> paramList)
  {
    this.exs = paramList;
    if ((paramList != null) && (paramList.size() != 0))
    {
      this.hasEx = 1;
      return;
    }
    this.hasEx = 0;
  }
  
  public void writeBody(BufferedOutputStream paramBufferedOutputStream)
  {
    if (!checkRequiredParam()) {
      return;
    }
    writeInt(paramBufferedOutputStream, this.type);
    writeString(paramBufferedOutputStream, this.fileName);
    writeLong(paramBufferedOutputStream, this.fileLength);
    writeLong(paramBufferedOutputStream, this.crc);
    writeInt(paramBufferedOutputStream, this.method);
    writeInt(paramBufferedOutputStream, this.hasEx);
    if (this.hasEx == 1)
    {
      this.countEx = this.exs.size();
      writeInt(paramBufferedOutputStream, this.countEx);
      Iterator localIterator = this.exs.iterator();
      while (localIterator.hasNext()) {
        ((ExtensionFiled)localIterator.next()).writeEx(paramBufferedOutputStream);
      }
    }
  }
  
  public void writeBodyData(BufferedOutputStream paramBufferedOutputStream, InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i <= 0) {
        break;
      }
      paramBufferedOutputStream.write(paramArrayOfByte, 0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.tool.QarBody
 * JD-Core Version:    0.7.0.1
 */