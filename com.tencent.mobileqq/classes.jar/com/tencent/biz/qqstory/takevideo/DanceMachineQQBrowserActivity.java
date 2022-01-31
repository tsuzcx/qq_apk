package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import wxn;

public class DanceMachineQQBrowserActivity
  extends QQTranslucentBrowserActivity
{
  public static void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DanceMachineQQBrowserActivity", 2, "startDialog :" + System.currentTimeMillis());
    }
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    if (paramInt4 == 0)
    {
      localIntent.setClass(paramActivity, DanceMachineQQBrowserActivity.class);
      if (paramInt4 != 0) {
        break label231;
      }
      localIntent.putExtra("isFullScreen", true);
      localIntent.putExtra("dance_machine_score", new Integer(paramInt5).toString());
      paramString = String.format("https://ti.qq.com/dance-rank/popup-738.html?_wv=536870912&_nav_alpha=true&_fv=0&new_record=%s&score=%s", new Object[] { paramInt2 + "", paramInt5 + "" });
      label154:
      if (QLog.isColorLevel()) {
        QLog.d("DanceMachineQQBrowserActivity", 2, "url : " + paramString);
      }
      localIntent.putExtra("url", paramString);
      if (!(paramActivity instanceof QQStoryBaseActivity)) {
        break label289;
      }
      ((QQStoryBaseActivity)paramActivity).a(localIntent, 9102040);
    }
    for (;;)
    {
      paramActivity.overridePendingTransition(0, 0);
      return;
      localIntent.setClass(paramActivity, QQBrowserActivity.class);
      break;
      label231:
      if ((paramInt1 == 3000) || (paramInt1 == 1))
      {
        if (paramInt1 == 3000) {}
        for (paramIntent = "tlz";; paramIntent = "qun")
        {
          paramString = String.format("https://ti.qq.com/dance-rank/index.html?_wv=2&type=%s&num=%s", new Object[] { paramIntent, paramString });
          break;
        }
      }
      paramString = "https://ti.qq.com/dance-rank/index.html?_wv=536870912&_nav_alpha=true";
      break label154;
      label289:
      paramActivity.startActivityForResult(localIntent, 9102040);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.a = DanceMachineQQBrowserActivity.DanceMachineQQBrowserFragment.class;
    super.doOnCreate(paramBundle);
    return true;
  }
  
  public void doOnResume()
  {
    getWindow().getDecorView().setSystemUiVisibility(2);
    getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new wxn(this));
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return paramInt == 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.DanceMachineQQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */