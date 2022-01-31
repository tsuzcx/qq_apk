package com.tencent.biz.qqstory.playvideo;

import alud;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import vnh;

public class QQStoryWarningActivity
  extends QQStoryBaseActivity
{
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    paramBundle = new QQStoryVideoPlayerErrorView(this);
    super.setContentViewNoTitle(paramBundle);
    paramBundle.a(0);
    paramBundle.setCloseViewVisibility(true);
    paramBundle.setOnCloseClickListener(new vnh(this));
    String str = super.getIntent().getExtras().getString("tipsResource");
    if (TextUtils.isEmpty(str))
    {
      paramBundle.setTipsText(alud.a(2131711518));
      return true;
    }
    paramBundle.setTipsText(str);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryWarningActivity
 * JD-Core Version:    0.7.0.1
 */