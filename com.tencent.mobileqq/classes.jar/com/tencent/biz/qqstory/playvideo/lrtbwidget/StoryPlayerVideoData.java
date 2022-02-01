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
  private ErrorMessage a;
  public MsgTabNodeInfo a;
  @NonNull
  public final String a;
  public final String b;
  private String c;
  
  public StoryPlayerVideoData(@NonNull String paramString1, @NonNull String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
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
    paramString1.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = paramErrorMessage;
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
    paramString1.c = paramString3;
    return paramString1;
  }
  
  public ErrorMessage a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
  }
  
  public StoryVideoItem a()
  {
    return ((StoryManager)SuperManager.a(5)).b(this.jdField_a_of_type_JavaLangString);
  }
  
  public VideoListFeedItem a()
  {
    if (TextUtils.isEmpty(this.b)) {
      return null;
    }
    FeedItem localFeedItem = ((FeedManager)SuperManager.a(11)).a(this.b, true);
    if (localFeedItem == null) {
      return null;
    }
    if ((localFeedItem instanceof VideoListFeedItem)) {
      return (VideoListFeedItem)localFeedItem;
    }
    return null;
  }
  
  public boolean a()
  {
    return this.c != null;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage != null;
  }
  
  public boolean c()
  {
    return (!a()) && (!b());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoData{");
    localStringBuilder.append("msgTabNodeType=");
    MsgTabNodeInfo localMsgTabNodeInfo = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo;
    int i;
    if (localMsgTabNodeInfo == null) {
      i = 0;
    } else {
      i = localMsgTabNodeInfo.a;
    }
    localStringBuilder.append(i);
    localStringBuilder.append(",");
    if (a())
    {
      localStringBuilder.append("loadingMessage='");
      localStringBuilder.append(this.c);
      localStringBuilder.append('\'');
    }
    else if (b())
    {
      localStringBuilder.append("errorMessage=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    }
    else
    {
      localStringBuilder.append("vid='");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append('\'');
      localStringBuilder.append(", feedId='");
      localStringBuilder.append(this.b);
      localStringBuilder.append('\'');
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerVideoData
 * JD-Core Version:    0.7.0.1
 */