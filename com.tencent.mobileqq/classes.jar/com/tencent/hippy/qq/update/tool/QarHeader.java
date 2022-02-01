package com.tencent.hippy.qq.update.tool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QarHeader
  extends QIO
{
  public static final int QAR_VERSION = 1;
  public final int QAR_MARK = 1233211;
  private int countEx;
  private List<ExtensionFiled> exs = null;
  private int hasEx;
  public int qarMark;
  public int version;
  
  public boolean isQBDAvabile()
  {
    return this.qarMark == 1233211;
  }
  
  public void md5Header(MessageDigest paramMessageDigest)
  {
    md5Int(paramMessageDigest, 1233211);
    md5Int(paramMessageDigest, this.version);
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
  
  public QarHeader readHeader(BufferedInputStream paramBufferedInputStream)
  {
    this.qarMark = readInt(paramBufferedInputStream);
    this.version = readInt(paramBufferedInputStream);
    this.hasEx = readInt(paramBufferedInputStream);
    if (this.hasEx == 1)
    {
      this.countEx = readInt(paramBufferedInputStream);
      this.exs = new ArrayList();
      int i = 0;
      while (i < this.countEx)
      {
        String str1 = readString(paramBufferedInputStream);
        String str2 = readString(paramBufferedInputStream);
        ExtensionFiled localExtensionFiled = new ExtensionFiled();
        localExtensionFiled.setEx(str1, str2);
        this.exs.add(localExtensionFiled);
        i += 1;
      }
    }
    return this;
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
  
  public void setHeader(int paramInt)
  {
    this.version = paramInt;
  }
  
  public void writeHeader(BufferedOutputStream paramBufferedOutputStream)
  {
    writeInt(paramBufferedOutputStream, 1233211);
    writeInt(paramBufferedOutputStream, this.version);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.tool.QarHeader
 * JD-Core Version:    0.7.0.1
 */