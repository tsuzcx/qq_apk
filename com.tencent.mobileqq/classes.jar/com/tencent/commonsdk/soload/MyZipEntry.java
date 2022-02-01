package com.tencent.commonsdk.soload;

import java.io.InputStream;
import java.nio.ByteOrder;

class MyZipEntry
  implements MyZipConstants, Cloneable
{
  public static final int DEFLATED = 8;
  public static final int STORED = 0;
  String comment;
  int commentLength = -1;
  long compressedSize = -1L;
  int compressionMethod = -1;
  long crc = -1L;
  int diskNumbers = -1;
  long externalFileAttri = -1L;
  byte[] extra;
  int extraLength = -1;
  int flags = -1;
  boolean hasDD = false;
  int internalFileAttri = -1;
  long mLocContentSize = -1L;
  long mLocalHeaderRelOffset = -1L;
  int modDate = -1;
  String name;
  byte[] nameBytes;
  int nameLength = -1;
  long size = -1L;
  int time = -1;
  int version = -1;
  int versionMinimum = -1;
  
  MyZipEntry(byte[] paramArrayOfByte, InputStream paramInputStream)
  {
    Streams.readFully(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = HeapBufferIterator.iterator(paramArrayOfByte, 0, paramArrayOfByte.length, ByteOrder.LITTLE_ENDIAN);
    paramArrayOfByte.readInt();
    this.version = paramArrayOfByte.readShort();
    this.versionMinimum = paramArrayOfByte.readShort();
    this.flags = paramArrayOfByte.readShort();
    this.compressionMethod = paramArrayOfByte.readShort();
    this.time = paramArrayOfByte.readShort();
    this.modDate = paramArrayOfByte.readShort();
    this.crc = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.compressedSize = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.size = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.nameLength = paramArrayOfByte.readShort();
    this.extraLength = paramArrayOfByte.readShort();
    this.commentLength = paramArrayOfByte.readShort();
    this.diskNumbers = paramArrayOfByte.readShort();
    this.internalFileAttri = paramArrayOfByte.readShort();
    this.externalFileAttri = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.mLocalHeaderRelOffset = (paramArrayOfByte.readInt() & 0xFFFFFFFF);
    this.nameBytes = new byte[this.nameLength];
    paramArrayOfByte = this.nameBytes;
    Streams.readFully(paramInputStream, paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = this.nameBytes;
    this.name = new String(paramArrayOfByte, 0, paramArrayOfByte.length, "UTF-8");
    int i = this.commentLength;
    if (i > 0)
    {
      paramArrayOfByte = new byte[i];
      Streams.readFully(paramInputStream, paramArrayOfByte, 0, i);
      this.comment = new String(paramArrayOfByte, 0, paramArrayOfByte.length, "UTF-8");
    }
    i = this.extraLength;
    if (i > 0)
    {
      this.extra = new byte[i];
      Streams.readFully(paramInputStream, this.extra, 0, i);
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.soload.MyZipEntry
 * JD-Core Version:    0.7.0.1
 */