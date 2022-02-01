package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;

public class StoryPlayerVideoData
{
  public MsgTabNodeInfo a;
  @NonNull
  public final String b;
  public final String c;
  private String d;
  private ErrorMessage e;
  
  public StoryPlayerVideoData(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public static StoryPlayerVideoData a(String paramString1, String paramString2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (paramString1 == null) {
      paramString1 = "ERROR_NO_VID";
    }
    if (paramString2 == null) {
      paramString2 = "ERROR_NO_FEED";
    }
    paramString1 = new StoryPlayerVideoData(paramString1, paramString2);
    paramString1.e = paramErrorMessage;
    return paramString1;
  }
  
  public static StoryPlayerVideoData a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      paramString1 = "LOADING_NO_VID";
    }
    if (paramString2 == null) {
      paramString2 = "LOADING_NO_FEED";
    }
    paramString1 = new StoryPlayerVideoData(paramString1, paramString2);
    paramString1.d = paramString3;
    return paramString1;
  }
  
  public boolean a()
  {
    return this.d != null;
  }
  
  public boolean b()
  {
    return this.e != null;
  }
  
  public ErrorMessage c()
  {
    return this.e;
  }
  
  public boolean d()
  {
    return (!a()) && (!b());
  }
  
  public StoryVideoItem e()
  {
    return ((StoryManager)SuperManager.a(5)).b(this.b);
  }
  
  public VideoListFeedItem f()
  {
    if (TextUtils.isEmpty(this.c)) {
      return null;
    }
    FeedItem localFeedItem = ((FeedManager)SuperManager.a(11)).a(this.c, true);
    if (localFeedItem == null) {
      return null;
    }
    if ((localFeedItem instanceof VideoListFeedItem)) {
      return (VideoListFeedItem)localFeedItem;
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoData{");
    localStringBuilder.append("msgTabNodeType=");
    MsgTabNodeInfo localMsgTabNodeInfo = this.a;
    int i;
    if (localMsgTabNodeInfo == null) {
      i = 0;
    } else {
      i = localMsgTabNodeInfo.b;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(",");
    if (a())
    {
      localStringBuilder.append("loadingMessage='");
      localStringBuilder.append(this.d);
      localStringBuilder.append('\'');
    }
    else if (b())
    {
      localStringBuilder.append("errorMessage=");
      localStringBuilder.append(this.e);
    }
    else
    {
      localStringBuilder.append("vid='");
      localStringBuilder.append(this.b);
      localStringBuilder.append('\'');
      localStringBuilder.append(", feedId='");
      localStringBuilder.append(this.c);
      localStringBuilder.append('\'');
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData
 * JD-Core Version:    0.7.0.1
 */