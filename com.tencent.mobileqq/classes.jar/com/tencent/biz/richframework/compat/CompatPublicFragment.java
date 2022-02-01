package com.tencent.biz.richframework.compat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CompatPublicFragment
  extends Fragment
{
  private Handler mMainHandler;
  
  public void beforeFinish() {}
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public Handler getMainHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity) {}
  
  public boolean isSupportScreenShot()
  {
    return true;
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onAccountChanged() {}
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public void onFinish() {}
  
  public void onMultiWindowModeChanged(boolean paramBoolean) {}
  
  public void onNewIntent(Intent paramIntent) {}
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public boolean overrideFinish()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.compat.CompatPublicFragment
 * JD-Core Version:    0.7.0.1
 */