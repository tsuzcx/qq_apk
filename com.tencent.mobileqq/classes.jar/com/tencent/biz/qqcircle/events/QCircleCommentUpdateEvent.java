package com.tencent.biz.qqcircle.events;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StReply;
import java.util.List;

public class QCircleCommentUpdateEvent
  extends SimpleBaseEvent
{
  public static final int EVENT_ADD_COMMENT = 3;
  public static final int EVENT_ADD_COMMENT_FAILURE = 9;
  public static final int EVENT_ADD_REPLY = 5;
  public static final int EVENT_ADD_REPLY_FAILURE = 10;
  public static final int EVENT_CANCEL_STICKY_COMMENT = 8;
  public static final int EVENT_DELETE_COMMENT = 4;
  public static final int EVENT_DELETE_REPLY = 6;
  public static final int EVENT_GET_COMMENT_LIST = 1;
  public static final int EVENT_LOAD_MORE_COMMENT_LIST = 2;
  public static final int EVENT_STICKY_COMMENT = 7;
  public FeedCloudMeta.StComment comment;
  public List<FeedCloudMeta.StComment> commentList;
  public int commentTotalNum;
  public int contextHashCode;
  public int eventStatus;
  public String fakeCommentId;
  public String fakeReplyId;
  public String feedId;
  public boolean needShowCommentPanel;
  public FeedCloudMeta.StReply reply;
  
  public QCircleCommentUpdateEvent(int paramInt1, String paramString, FeedCloudMeta.StComment paramStComment, int paramInt2, int paramInt3)
  {
    this.eventStatus = paramInt1;
    this.feedId = paramString;
    this.comment = QCirclePluginUtil.b(paramStComment);
    this.commentTotalNum = paramInt2;
    this.contextHashCode = paramInt3;
  }
  
  public QCircleCommentUpdateEvent(int paramInt1, String paramString, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt2)
  {
    this.eventStatus = paramInt1;
    this.feedId = paramString;
    this.comment = QCirclePluginUtil.b(paramStComment);
    this.reply = QCirclePluginUtil.a(paramStReply);
    this.contextHashCode = paramInt2;
  }
  
  public QCircleCommentUpdateEvent(int paramInt1, String paramString, FeedCloudMeta.StComment paramStComment, FeedCloudMeta.StReply paramStReply, int paramInt2, int paramInt3)
  {
    this.eventStatus = paramInt1;
    this.feedId = paramString;
    this.comment = QCirclePluginUtil.b(paramStComment);
    this.reply = QCirclePluginUtil.a(paramStReply);
    this.commentTotalNum = paramInt2;
    this.contextHashCode = paramInt3;
  }
  
  public QCircleCommentUpdateEvent(int paramInt1, String paramString, List<FeedCloudMeta.StComment> paramList, int paramInt2, int paramInt3)
  {
    this.eventStatus = paramInt1;
    this.feedId = paramString;
    this.commentList = paramList;
    this.commentTotalNum = paramInt2;
    this.contextHashCode = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent
 * JD-Core Version:    0.7.0.1
 */