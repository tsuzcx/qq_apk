package com.tencent.biz.qqstory.playvideo;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.VideoInfoObserver;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

final class StoryPlayerLauncher$1
  extends PlayModeUtils.VideoInfoObserver
{
  StoryPlayerLauncher$1(String paramString1, String paramString2, int paramInt, Context paramContext) {}
  
  public void a(int paramInt, String paramString, StoryVideoItem paramStoryVideoItem)
  {
    if ((paramInt == 0) && (paramStoryVideoItem != null))
    {
      paramString = new OpenPlayerBuilder(new VidListPlayInfo(this.d, this.e), this.f).f();
      OpenPlayerBuilder.UIStyle localUIStyle = paramString.mUIStyle;
      if (paramStoryVideoItem.mInteractStatus == 1) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      localUIStyle.bottomWidgetShowFlag = paramInt;
      paramString.mUIStyle.mPlayerRepeatMode = 1;
      StoryPlayerLauncher.a(this.g, paramString, null);
      return;
    }
    if (paramInt == 10100)
    {
      QQToast.makeText(this.g.getApplicationContext(), 1, HardCodeUtil.a(2131911858), 0).show();
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      QQToast.makeText(this.g.getApplicationContext(), 1, paramString, 0).show();
      return;
    }
    paramString = this.g.getApplicationContext();
    paramStoryVideoItem = new StringBuilder();
    paramStoryVideoItem.append(HardCodeUtil.a(2131911859));
    paramStoryVideoItem.append(paramInt);
    QQToast.makeText(paramString, 1, paramStoryVideoItem.toString(), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher.1
 * JD-Core Version:    0.7.0.1
 */