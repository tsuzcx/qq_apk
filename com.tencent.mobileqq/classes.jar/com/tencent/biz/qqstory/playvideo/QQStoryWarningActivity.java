package com.tencent.biz.qqstory.playvideo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import nsf;

public class QQStoryWarningActivity
  extends QQStoryBaseActivity
{
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    paramBundle = new QQStoryVideoPlayerErrorView(this);
    super.setContentViewNoTitle(paramBundle);
    paramBundle.a(0);
    paramBundle.setCloseViewVisibility(true);
    paramBundle.setOnCloseClickListener(new nsf(this));
    String str = super.getIntent().getExtras().getString("tipsResource");
    if (TextUtils.isEmpty(str))
    {
      paramBundle.setTipsText("出错啦！");
      return true;
    }
    paramBundle.setTipsText(str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWarningActivity
 * JD-Core Version:    0.7.0.1
 */