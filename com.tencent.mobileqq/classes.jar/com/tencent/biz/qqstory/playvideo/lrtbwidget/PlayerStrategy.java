package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;

public class PlayerStrategy
{
  protected PlayerStrategy(StoryPlayerContext paramStoryPlayerContext) {}
  
  public static PlayerStrategy a(StoryPlayerContext paramStoryPlayerContext)
  {
    if (paramStoryPlayerContext.a().mReportData.from == 86) {
      return new SelectVideoPlayerStrategy(paramStoryPlayerContext);
    }
    return new PlayerStrategy(paramStoryPlayerContext);
  }
  
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder) {}
  
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder, int paramInt1, int paramInt2, StoryPlayerVideoData paramStoryPlayerVideoData) {}
  
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder, View paramView) {}
  
  public void a(SelectVideoVideoHolder paramSelectVideoVideoHolder, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayerStrategy
 * JD-Core Version:    0.7.0.1
 */