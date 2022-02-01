package com.tencent.biz.qqcircle.immersive.feed.event;

public class QFSPicPositionChangeEvent
  extends QFSBaseFeedPresenterEvent
{
  private String a;
  private int b;
  
  public QFSPicPositionChangeEvent(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.event.QFSPicPositionChangeEvent
 * JD-Core Version:    0.7.0.1
 */