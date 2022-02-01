package com.tencent.mobileqq.activity.shortvideo;

import android.app.Activity;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqfav.widget.FavoriteActionSheet;
import cooperation.qqfav.widget.FavoriteActionSheet.Actions;
import mqq.app.AppRuntime;

class ShortVideoPlayActivity$29
  extends FavoriteActionSheet
{
  ShortVideoPlayActivity$29(ShortVideoPlayActivity paramShortVideoPlayActivity, Activity paramActivity, FavoriteActionSheet.Actions paramActions, int paramInt1, int paramInt2, AppRuntime paramAppRuntime)
  {
    super(paramActivity, paramActions, paramInt1, paramInt2, paramAppRuntime);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.29
 * JD-Core Version:    0.7.0.1
 */