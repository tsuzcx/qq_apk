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
      paramString = new OpenPlayerBuilder(new VidListPlayInfo(this.jdField_a_of_type_JavaLangString, this.b), this.jdField_a_of_type_Int).a();
      OpenPlayerBuilder.UIStyle localUIStyle = paramString.mUIStyle;
      if (paramStoryVideoItem.mInteractStatus == 1) {
        paramInt = 1;
      } else {
        paramInt = 2;
      }
      localUIStyle.bottomWidgetShowFlag = paramInt;
      paramString.mUIStyle.mPlayerRepeatMode = 1;
      StoryPlayerLauncher.a(this.jdField_a_of_type_AndroidContentContext, paramString, null);
      return;
    }
    if (paramInt == 10100)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, HardCodeUtil.a(2131714344), 0).a();
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, paramString, 0).a();
      return;
    }
    paramString = this.jdField_a_of_type_AndroidContentContext.getApplicationContext();
    paramStoryVideoItem = new StringBuilder();
    paramStoryVideoItem.append(HardCodeUtil.a(2131714345));
    paramStoryVideoItem.append(paramInt);
    QQToast.a(paramString, 1, paramStoryVideoItem.toString(), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher.1
 * JD-Core Version:    0.7.0.1
 */