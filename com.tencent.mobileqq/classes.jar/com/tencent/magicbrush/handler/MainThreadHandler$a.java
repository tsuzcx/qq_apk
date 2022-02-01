package com.tencent.magicbrush.handler;

class MainThreadHandler$a
  implements Runnable
{
  private int a;
  private long b;
  private long c;
  
  private MainThreadHandler$a(int paramInt, long paramLong1, long paramLong2)
  {
    this.a = paramInt;
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  public void run()
  {
    int i = this.a;
    if (i <= 1)
    {
      MainThreadHandler.access$000(this.b, this.c);
      return;
    }
    MainThreadHandler.post(this.b, this.c, i - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.handler.MainThreadHandler.a
 * JD-Core Version:    0.7.0.1
 */