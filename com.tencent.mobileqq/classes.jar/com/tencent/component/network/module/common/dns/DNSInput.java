package com.tencent.component.network.module.common.dns;

public class DNSInput
{
  private byte[] array;
  private int end;
  private int pos;
  private int saved_end;
  private int saved_pos;
  
  public DNSInput(byte[] paramArrayOfByte)
  {
    this.array = paramArrayOfByte;
    this.pos = 0;
    this.end = this.array.length;
    this.saved_pos = -1;
    this.saved_end = -1;
  }
  
  private void require(int paramInt)
  {
    if (paramInt > remaining()) {
      throw new WireParseException("end of input");
    }
  }
  
  public void clearActive()
  {
    this.end = this.array.length;
  }
  
  public int current()
  {
    return this.pos;
  }
  
  public void jump(int paramInt)
  {
    if (paramInt >= this.array.length) {
      throw new IllegalArgumentException("cannot jump past end of input");
    }
    this.pos = paramInt;
    this.end = this.array.length;
  }
  
  public void readByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    require(paramInt2);
    System.arraycopy(this.array, this.pos, paramArrayOfByte, paramInt1, paramInt2);
    this.pos += paramInt2;
  }
  
  public byte[] readByteArray()
  {
    int i = remaining();
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.array, this.pos, arrayOfByte, 0, i);
    this.pos = (i + this.pos);
    this.end = (this.array.length - 1);
    return arrayOfByte;
  }
  
  public byte[] readByteArray(int paramInt)
  {
    require(paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(this.array, this.pos, arrayOfByte, 0, paramInt);
    this.pos += paramInt;
    return arrayOfByte;
  }
  
  public byte[] readCountedString()
  {
    require(1);
    byte[] arrayOfByte = this.array;
    int i = this.pos;
    this.pos = (i + 1);
    return readByteArray(arrayOfByte[i] & 0xFF);
  }
  
  public int readU16()
  {
    require(2);
    byte[] arrayOfByte = this.array;
    int i = this.pos;
    this.pos = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.array;
    int j = this.pos;
    this.pos = (j + 1);
    return ((i & 0xFF) << 8) + (arrayOfByte[j] & 0xFF);
  }
  
  public long readU32()
  {
    require(4);
    byte[] arrayOfByte = this.array;
    int i = this.pos;
    this.pos = (i + 1);
    i = arrayOfByte[i];
    arrayOfByte = this.array;
    int j = this.pos;
    this.pos = (j + 1);
    j = arrayOfByte[j];
    arrayOfByte = this.array;
    int k = this.pos;
    this.pos = (k + 1);
    k = arrayOfByte[k];
    arrayOfByte = this.array;
    int m = this.pos;
    this.pos = (m + 1);
    m = arrayOfByte[m];
    long l = i & 0xFF;
    return ((j & 0xFF) << 16) + (l << 24) + ((k & 0xFF) << 8) + (m & 0xFF);
  }
  
  public int readU8()
  {
    require(1);
    byte[] arrayOfByte = this.array;
    int i = this.pos;
    this.pos = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int remaining()
  {
    return this.end - this.pos;
  }
  
  public void restore()
  {
    if (this.saved_pos < 0) {
      throw new IllegalStateException("no previous state");
    }
    this.pos = this.saved_pos;
    this.end = this.saved_end;
    this.saved_pos = -1;
    this.saved_end = -1;
  }
  
  public void save()
  {
    this.saved_pos = this.pos;
    this.saved_end = this.end;
  }
  
  public void setActive(int paramInt)
  {
    if (paramInt > this.array.length - this.pos) {
      throw new IllegalArgumentException("cannot set active region past end of input");
    }
    this.end = (this.pos + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.DNSInput
 * JD-Core Version:    0.7.0.1
 */