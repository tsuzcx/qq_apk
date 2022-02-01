package com.tencent.mobileqq.activity.aio.stickerrecommended;

public class BaseEmoticonExposure
  implements IEmoticonExposure
{
  private long a;
  private long b;
  
  public long a()
  {
    return this.b;
  }
  
  public void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void b(long paramLong)
  {
    long l = this.a;
    if (l != 0L)
    {
      this.b += paramLong - l;
      this.a = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.BaseEmoticonExposure
 * JD-Core Version:    0.7.0.1
 */