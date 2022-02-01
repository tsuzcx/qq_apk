package com.tencent.biz.qqcircle.beans;

import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StReply;

public class QCircleFeedCommentInfo
{
  public FeedCloudMeta.StFeed a;
  public FeedCloudMeta.StComment b;
  public FeedCloudMeta.StReply c;
  
  public QCircleFeedCommentInfo(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment)
  {
    this.a = paramStFeed;
    this.b = paramStComment;
  }
  
  public QCircleFeedCommentInfo(FeedCloudMeta.StFeed paramStFeed, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply)
  {
    this.a = paramStFeed;
    this.b = paramStComment;
    this.c = paramStReply;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo
 * JD-Core Version:    0.7.0.1
 */