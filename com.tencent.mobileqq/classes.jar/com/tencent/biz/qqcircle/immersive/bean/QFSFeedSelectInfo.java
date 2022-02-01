package com.tencent.biz.qqcircle.immersive.bean;

public class QFSFeedSelectInfo
{
  private int a = 0;
  private int b;
  
  public QFSFeedSelectInfo(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public QFSFeedSelectInfo a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QFSFeedSelectInfo{mStatus=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mPosition=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo
 * JD-Core Version:    0.7.0.1
 */