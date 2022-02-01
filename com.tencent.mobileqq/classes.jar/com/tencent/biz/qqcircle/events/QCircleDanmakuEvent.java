package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StComment;
import java.util.List;

public class QCircleDanmakuEvent
  extends SimpleBaseEvent
{
  public static final int EVENT_CLOSE_DANMAKU = 2;
  public static final int EVENT_OPEN_DANMAKU = 1;
  public static final int EVENT_PAUSE_DANMAKU = 3;
  public static final int EVENT_RESUME_DANMAKU = 4;
  public static final int EVENT_SET_DANMAKU_GONE = 6;
  public static final int EVENT_SET_DANMAKU_GONE_PAUSE = 7;
  public static final int EVENT_SET_DANMAKU_VISIBLE = 5;
  public static final int EVENT_SET_DANMAKU_VISIBLE_RESUME = 8;
  public static final int EVENT_SWITCH_DANMAKU_CLOSE = 10;
  public static final int EVENT_SWITCH_DANMAKU_OPEN = 9;
  public List<FeedCloudMeta.StComment> commentList;
  public int commentTotalNum;
  public int contextHashCode;
  public final int eventStatus;
  public String feedId;
  public boolean isCommentPanelOpen;
  
  public QCircleDanmakuEvent(int paramInt)
  {
    this.eventStatus = paramInt;
  }
  
  public QCircleDanmakuEvent(int paramInt1, String paramString, List<FeedCloudMeta.StComment> paramList, int paramInt2, int paramInt3)
  {
    this.eventStatus = paramInt1;
    this.feedId = paramString;
    this.commentList = paramList;
    this.commentTotalNum = paramInt2;
    this.contextHashCode = paramInt3;
  }
  
  public QCircleDanmakuEvent(int paramInt, boolean paramBoolean)
  {
    this.eventStatus = paramInt;
    this.isCommentPanelOpen = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleDanmakuEvent
 * JD-Core Version:    0.7.0.1
 */