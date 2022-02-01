package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta.StReply;

public class QCircleReplyItemInfo
{
  public int a;
  public FeedCloudMeta.StReply b;
  public int c;
  
  public QCircleReplyItemInfo(int paramInt, FeedCloudMeta.StReply paramStReply)
  {
    this.a = paramInt;
    this.b = paramStReply;
  }
  
  public QCircleReplyItemInfo(int paramInt1, FeedCloudMeta.StReply paramStReply, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramStReply;
    this.c = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCircleReplyItemInfo
 * JD-Core Version:    0.7.0.1
 */