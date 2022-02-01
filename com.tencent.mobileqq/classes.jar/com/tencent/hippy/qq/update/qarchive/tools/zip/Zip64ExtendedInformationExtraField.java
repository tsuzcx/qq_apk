package com.tencent.hippy.qq.update.qarchive.tools.zip;

import java.util.zip.ZipException;

public class Zip64ExtendedInformationExtraField
  implements CentralDirectoryParsingZipExtraField
{
  private static final byte[] EMPTY = new byte[0];
  static final ZipShort HEADER_ID = new ZipShort(1);
  private static final String LFH_MUST_HAVE_BOTH_SIZES_MSG = "Zip64 extended information must contain both size values in the local file header.";
  private ZipEightByteInteger compressedSize;
  private ZipLong diskStart;
  private byte[] rawCentralDirectoryData;
  private ZipEightByteInteger relativeHeaderOffset;
  private ZipEightByteInteger size;
  
  public Zip64ExtendedInformationExtraField() {}
  
  public Zip64ExtendedInformationExtraField(ZipEightByteInteger paramZipEightByteInteger1, ZipEightByteInteger paramZipEightByteInteger2)
  {
    this(paramZipEightByteInteger1, paramZipEightByteInteger2, null, null);
  }
  
  public Zip64ExtendedInformationExtraField(ZipEightByteInteger paramZipEightByteInteger1, ZipEightByteInteger paramZipEightByteInteger2, ZipEightByteInteger paramZipEightByteInteger3, ZipLong paramZipLong)
  {
    this.size = paramZipEightByteInteger1;
    this.compressedSize = paramZipEightByteInteger2;
    this.relativeHeaderOffset = paramZipEightByteInteger3;
    this.diskStart = paramZipLong;
  }
  
  private int addSizes(byte[] paramArrayOfByte)
  {
    ZipEightByteInteger localZipEightByteInteger = this.size;
    int i;
    if (localZipEightByteInteger != null)
    {
      System.arraycopy(localZipEightByteInteger.getBytes(), 0, paramArrayOfByte, 0, 8);
      i = 8;
    }
    else
    {
      i = 0;
    }
    localZipEightByteInteger = this.compressedSize;
    int j = i;
    if (localZipEightByteInteger != null)
    {
      System.arraycopy(localZipEightByteInteger.getBytes(), 0, paramArrayOfByte, i, 8);
      j = i + 8;
    }
    return j;
  }
  
  public byte[] getCentralDirectoryData()
  {
    byte[] arrayOfByte = new byte[getCentralDirectoryLength().getValue()];
    int j = addSizes(arrayOfByte);
    Object localObject = this.relativeHeaderOffset;
    int i = j;
    if (localObject != null)
    {
      System.arraycopy(((ZipEightByteInteger)localObject).getBytes(), 0, arrayOfByte, j, 8);
      i = j + 8;
    }
    localObject = this.diskStart;
    if (localObject != null) {
      System.arraycopy(((ZipLong)localObject).getBytes(), 0, arrayOfByte, i, 4);
    }
    return arrayOfByte;
  }
  
  public ZipShort getCentralDirectoryLength()
  {
    ZipEightByteInteger localZipEightByteInteger = this.size;
    int k = 8;
    int m = 0;
    int i;
    if (localZipEightByteInteger != null) {
      i = 8;
    } else {
      i = 0;
    }
    int j;
    if (this.compressedSize != null) {
      j = 8;
    } else {
      j = 0;
    }
    if (this.relativeHeaderOffset == null) {
      k = 0;
    }
    if (this.diskStart != null) {
      m = 4;
    }
    return new ZipShort(i + j + k + m);
  }
  
  public ZipEightByteInteger getCompressedSize()
  {
    return this.compressedSize;
  }
  
  public ZipLong getDiskStartNumber()
  {
    return this.diskStart;
  }
  
  public ZipShort getHeaderId()
  {
    return HEADER_ID;
  }
  
  public byte[] getLocalFileDataData()
  {
    if ((this.size == null) && (this.compressedSize == null)) {
      return EMPTY;
    }
    if ((this.size != null) && (this.compressedSize != null))
    {
      byte[] arrayOfByte = new byte[16];
      addSizes(arrayOfByte);
      return arrayOfByte;
    }
    throw new IllegalArgumentException("Zip64 extended information must contain both size values in the local file header.");
  }
  
  public ZipShort getLocalFileDataLength()
  {
    int i;
    if (this.size != null) {
      i = 16;
    } else {
      i = 0;
    }
    return new ZipShort(i);
  }
  
  public ZipEightByteInteger getRelativeHeaderOffset()
  {
    return this.relativeHeaderOffset;
  }
  
  public ZipEightByteInteger getSize()
  {
    return this.size;
  }
  
  public void parseFromCentralDirectoryData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.rawCentralDirectoryData = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.rawCentralDirectoryData, 0, paramInt2);
    if (paramInt2 >= 28)
    {
      parseFromLocalFileData(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    if (paramInt2 == 24)
    {
      this.size = new ZipEightByteInteger(paramArrayOfByte, paramInt1);
      paramInt1 += 8;
      this.compressedSize = new ZipEightByteInteger(paramArrayOfByte, paramInt1);
      this.relativeHeaderOffset = new ZipEightByteInteger(paramArrayOfByte, paramInt1 + 8);
      return;
    }
    if (paramInt2 % 8 == 4) {
      this.diskStart = new ZipLong(paramArrayOfByte, paramInt1 + paramInt2 - 4);
    }
  }
  
  public void parseFromLocalFileData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    if (paramInt2 >= 16)
    {
      this.size = new ZipEightByteInteger(paramArrayOfByte, paramInt1);
      paramInt1 += 8;
      this.compressedSize = new ZipEightByteInteger(paramArrayOfByte, paramInt1);
      int i = paramInt1 + 8;
      int j = paramInt2 - 16;
      paramInt2 = i;
      paramInt1 = j;
      if (j >= 8)
      {
        this.relativeHeaderOffset = new ZipEightByteInteger(paramArrayOfByte, i);
        paramInt2 = i + 8;
        paramInt1 = j - 8;
      }
      if (paramInt1 >= 4) {
        this.diskStart = new ZipLong(paramArrayOfByte, paramInt2);
      }
      return;
    }
    throw new ZipException("Zip64 extended information must contain both size values in the local file header.");
  }
  
  public void reparseCentralDirectoryData(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (this.rawCentralDirectoryData != null)
    {
      int n = 0;
      if (paramBoolean1) {
        i = 8;
      } else {
        i = 0;
      }
      int j;
      if (paramBoolean2) {
        j = 8;
      } else {
        j = 0;
      }
      int k;
      if (paramBoolean3) {
        k = 8;
      } else {
        k = 0;
      }
      int m;
      if (paramBoolean4) {
        m = 4;
      } else {
        m = 0;
      }
      int i = i + j + k + m;
      Object localObject = this.rawCentralDirectoryData;
      if (localObject.length == i)
      {
        j = n;
        if (paramBoolean1)
        {
          this.size = new ZipEightByteInteger((byte[])localObject, 0);
          j = 8;
        }
        i = j;
        if (paramBoolean2)
        {
          this.compressedSize = new ZipEightByteInteger(this.rawCentralDirectoryData, j);
          i = j + 8;
        }
        j = i;
        if (paramBoolean3)
        {
          this.relativeHeaderOffset = new ZipEightByteInteger(this.rawCentralDirectoryData, i);
          j = i + 8;
        }
        if (paramBoolean4) {
          this.diskStart = new ZipLong(this.rawCentralDirectoryData, j);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("central directory zip64 extended information extra field's length doesn't match central directory data.  Expected length ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" but is ");
        ((StringBuilder)localObject).append(this.rawCentralDirectoryData.length);
        throw new ZipException(((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void setCompressedSize(ZipEightByteInteger paramZipEightByteInteger)
  {
    this.compressedSize = paramZipEightByteInteger;
  }
  
  public void setDiskStartNumber(ZipLong paramZipLong)
  {
    this.diskStart = paramZipLong;
  }
  
  public void setRelativeHeaderOffset(ZipEightByteInteger paramZipEightByteInteger)
  {
    this.relativeHeaderOffset = paramZipEightByteInteger;
  }
  
  public void setSize(ZipEightByteInteger paramZipEightByteInteger)
  {
    this.size = paramZipEightByteInteger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.qarchive.tools.zip.Zip64ExtendedInformationExtraField
 * JD-Core Version:    0.7.0.1
 */