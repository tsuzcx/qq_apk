package com.tencent.biz.qqcircle.immersive.feed.event;

public class QFSVideoProgressChangeEvent
  extends QFSBaseFeedPresenterEvent
{
  private int a;
  private int b;
  
  public int a()
  {
    return this.b;
  }
  
  public QFSVideoProgressChangeEvent a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public QFSVideoProgressChangeEvent b(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoProgressChangeEvent
 * JD-Core Version:    0.7.0.1
 */