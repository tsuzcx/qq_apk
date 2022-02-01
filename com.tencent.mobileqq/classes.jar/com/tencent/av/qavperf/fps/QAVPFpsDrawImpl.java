package com.tencent.av.qavperf.fps;

public class QAVPFpsDrawImpl
  implements IFpsDrawCallback
{
  private int a = 0;
  
  public static QAVPFpsDrawImpl b()
  {
    return QAVPFpsDrawImpl.InnerHolder.a();
  }
  
  public void a()
  {
    this.a += 1;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.a = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qavperf.fps.QAVPFpsDrawImpl
 * JD-Core Version:    0.7.0.1
 */