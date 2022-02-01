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
    if (paramInt <= remaining()) {
      return;
    }
    throw new WireParseException("end of input");
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
    byte[] arrayOfByte = this.array;
    if (paramInt < arrayOfByte.length)
    {
      this.pos = paramInt;
      this.end = arrayOfByte.length;
      return;
    }
    throw new IllegalArgumentException("cannot jump past end of input");
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
    this.pos += i;
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
    int j = this.pos;
    this.pos = (j + 1);
    j = arrayOfByte[j];
    int k = this.pos;
    this.pos = (k + 1);
    k = arrayOfByte[k];
    int m = this.pos;
    this.pos = (m + 1);
    m = arrayOfByte[m];
    return ((i & 0xFF) << 24) + ((j & 0xFF) << 16) + ((k & 0xFF) << 8) + (m & 0xFF);
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
    int i = this.saved_pos;
    if (i >= 0)
    {
      this.pos = i;
      this.end = this.saved_end;
      this.saved_pos = -1;
      this.saved_end = -1;
      return;
    }
    throw new IllegalStateException("no previous state");
  }
  
  public void save()
  {
    this.saved_pos = this.pos;
    this.saved_end = this.end;
  }
  
  public void setActive(int paramInt)
  {
    int i = this.array.length;
    int j = this.pos;
    if (paramInt <= i - j)
    {
      this.end = (j + paramInt);
      return;
    }
    throw new IllegalArgumentException("cannot set active region past end of input");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.DNSInput
 * JD-Core Version:    0.7.0.1
 */