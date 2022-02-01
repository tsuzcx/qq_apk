package com.qq.wx.voice.vad;

public class EVad
{
  private long a = 0L;
  private EVadNative b = new EVadNative();
  
  public int AddData(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramInt / 2;
    short[] arrayOfShort = new short[j];
    int i = 0;
    for (;;)
    {
      if (i >= paramInt) {
        return AddData(arrayOfShort, j);
      }
      arrayOfShort[(i / 2)] = ((short)((paramArrayOfByte[(i + 1)] & 0xFF) << 8 | paramArrayOfByte[i] & 0xFF));
      i += 2;
    }
  }
  
  public int AddData(short[] paramArrayOfShort, int paramInt)
  {
    long l = this.a;
    if (l == 0L) {
      return 1;
    }
    return this.b.AddData(l, paramArrayOfShort, paramInt);
  }
  
  public int Init(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4)
  {
    if (this.a != 0L) {
      Release();
    }
    this.a = this.b.Init(paramInt1, paramInt2, paramFloat, paramInt3, paramInt4);
    if (this.a == 0L) {
      return 1;
    }
    return 0;
  }
  
  public int Release()
  {
    long l = this.a;
    if (l == 0L) {
      return 0;
    }
    int i = this.b.Release(l);
    this.a = 0L;
    return i;
  }
  
  public int Reset()
  {
    long l = this.a;
    if (l == 0L) {
      return 1;
    }
    return this.b.Reset(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.vad.EVad
 * JD-Core Version:    0.7.0.1
 */