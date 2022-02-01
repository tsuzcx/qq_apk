package com.tencent.TMG.audio;

public class RingBuffer
{
  private final int DEFAULT_SIZE = 1000;
  public int c_totalSize = 1000;
  public boolean m_isEmpty = true;
  public byte[] m_pBuf;
  public int m_read = 0;
  public int m_write = 0;
  
  public RingBuffer()
  {
    this.m_pBuf = null;
    this.c_totalSize = 1000;
    this.m_isEmpty = true;
    this.m_read = 0;
    this.m_write = 0;
    this.m_pBuf = new byte[this.c_totalSize];
  }
  
  public RingBuffer(int paramInt)
  {
    this.c_totalSize = paramInt;
    this.m_isEmpty = true;
    this.m_read = 0;
    this.m_write = 0;
    this.m_pBuf = new byte[this.c_totalSize];
  }
  
  public void Clear()
  {
    this.m_write = 0;
    this.m_read = this.m_write;
    this.m_isEmpty = true;
  }
  
  public boolean Pop(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    if (this.m_pBuf == null) {}
    while ((RemainRead() < paramInt) || (paramInt <= 0)) {
      return false;
    }
    if (this.c_totalSize - this.m_read >= paramInt) {
      System.arraycopy(this.m_pBuf, this.m_read, paramArrayOfByte, 0, paramInt);
    }
    for (;;)
    {
      this.m_read = ((this.m_read + paramInt) % this.c_totalSize);
      if (this.m_read == this.m_write) {
        bool = true;
      }
      this.m_isEmpty = bool;
      return true;
      System.arraycopy(this.m_pBuf, this.m_read, paramArrayOfByte, 0, this.c_totalSize - this.m_read);
      System.arraycopy(this.m_pBuf, 0, paramArrayOfByte, this.c_totalSize - this.m_read, paramInt - (this.c_totalSize - this.m_read));
    }
  }
  
  public void Push(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.m_pBuf == null) {}
    while (RemainWrite() < paramInt) {
      return;
    }
    if (this.c_totalSize - this.m_write >= paramInt) {
      System.arraycopy(paramArrayOfByte, 0, this.m_pBuf, this.m_write, paramInt);
    }
    for (;;)
    {
      this.m_write = ((this.m_write + paramInt) % this.c_totalSize);
      this.m_isEmpty = false;
      return;
      System.arraycopy(paramArrayOfByte, 0, this.m_pBuf, this.m_write, this.c_totalSize - this.m_write);
      System.arraycopy(paramArrayOfByte, this.c_totalSize - this.m_write, this.m_pBuf, 0, paramInt - (this.c_totalSize - this.m_write));
    }
  }
  
  public int RemainRead()
  {
    if (this.m_write < this.m_read) {
      return this.c_totalSize - this.m_read + this.m_write;
    }
    if (this.m_write > this.m_read) {
      return this.m_write - this.m_read;
    }
    if (this.m_isEmpty) {
      return 0;
    }
    return this.c_totalSize;
  }
  
  public int RemainWrite()
  {
    return this.c_totalSize - RemainRead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.audio.RingBuffer
 * JD-Core Version:    0.7.0.1
 */