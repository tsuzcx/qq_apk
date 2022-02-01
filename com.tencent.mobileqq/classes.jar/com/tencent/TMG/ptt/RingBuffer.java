package com.tencent.TMG.ptt;

import android.util.Log;

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
    int i = RemainRead();
    boolean bool = false;
    if (i >= paramInt)
    {
      if (paramInt <= 0) {
        return false;
      }
      i = this.c_totalSize;
      int j = this.m_read;
      if (i - j >= paramInt)
      {
        System.arraycopy(this.m_pBuf, j, paramArrayOfByte, 0, paramInt);
      }
      else
      {
        System.arraycopy(this.m_pBuf, j, paramArrayOfByte, 0, i - j);
        localObject = this.m_pBuf;
        i = this.c_totalSize;
        j = this.m_read;
        System.arraycopy(localObject, 0, paramArrayOfByte, i - j, paramInt - (i - j));
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Pop pBuf: ");
      ((StringBuilder)localObject).append(paramArrayOfByte[0]);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramArrayOfByte[1]);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramArrayOfByte[2]);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramArrayOfByte[3]);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramArrayOfByte[4]);
      Log.d("WebRtcAudioRecord", ((StringBuilder)localObject).toString());
      this.m_read = ((this.m_read + paramInt) % this.c_totalSize);
      if (this.m_read == this.m_write) {
        bool = true;
      }
      this.m_isEmpty = bool;
      return true;
    }
    return false;
  }
  
  public void Push(byte[] paramArrayOfByte, int paramInt)
  {
    if (RemainWrite() < paramInt) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Push pBuf: ");
    localStringBuilder.append(paramArrayOfByte[0]);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramArrayOfByte[1]);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramArrayOfByte[2]);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramArrayOfByte[3]);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramArrayOfByte[4]);
    Log.d("WebRtcAudioRecord", localStringBuilder.toString());
    int i = this.c_totalSize;
    int j = this.m_write;
    if (i - j >= paramInt)
    {
      System.arraycopy(paramArrayOfByte, 0, this.m_pBuf, j, paramInt);
    }
    else
    {
      System.arraycopy(paramArrayOfByte, 0, this.m_pBuf, j, i - j);
      i = this.c_totalSize;
      j = this.m_write;
      System.arraycopy(paramArrayOfByte, i - j, this.m_pBuf, 0, paramInt - (i - j));
    }
    this.m_write = ((this.m_write + paramInt) % this.c_totalSize);
    this.m_isEmpty = false;
  }
  
  public int RemainRead()
  {
    int i = this.m_write;
    int j = this.m_read;
    if (i < j) {
      return this.c_totalSize - j + i;
    }
    if (i > j) {
      return i - j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.ptt.RingBuffer
 * JD-Core Version:    0.7.0.1
 */