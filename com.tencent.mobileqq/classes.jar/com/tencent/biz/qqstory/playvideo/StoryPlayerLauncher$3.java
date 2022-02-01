package com.tencent.biz.qqstory.playvideo;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.FeedShareInteractStatusObserver;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo;

final class StoryPlayerLauncher$3
  implements PlayModeUtils.FeedShareInteractStatusObserver
{
  StoryPlayerLauncher$3(ShareFromMemoryPlayInfo paramShareFromMemoryPlayInfo, int paramInt, Activity paramActivity, View paramView) {}
  
  public void a(int paramInt)
  {
    OpenPlayerBuilder.Data localData = new OpenPlayerBuilder(this.a, this.b).f();
    if (paramInt != -1)
    {
      OpenPlayerBuilder.UIStyle localUIStyle = localData.mUIStyle;
      int i = 1;
      if (paramInt == 1) {
        paramInt = i;
      } else {
        paramInt = 2;
      }
      localUIStyle.bottomWidgetShowFlag = paramInt;
    }
    StoryPlayerLauncher.a(this.c, localData, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher.3
 * JD-Core Version:    0.7.0.1
 */