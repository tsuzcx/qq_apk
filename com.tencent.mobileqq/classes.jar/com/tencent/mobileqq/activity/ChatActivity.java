package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.mobileqq.utils.StartupTrackerForAio;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;

@RoutePage(desc="AIO", path="/base/activity/ChatActivity")
public class ChatActivity
  extends BaseActivity
{
  private String TAG = "Q.aio.ChatActivity";
  private View mTitleView;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localFragment != null) {
      ((ChatFragment)localFragment).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    if (!onBackEvent()) {
      super.finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    ThreadRegulator.a().a(1);
    StartupTrackerForAio.a(null, "AIO_Start_cost");
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnCreate strat ");
    }
    ThreadPriorityManager.a(true);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (AIOUtils.a(this, this.app, true, getIntent())) {
      return false;
    }
    paramBundle = this.mTitleView;
    if (paramBundle != null) {
      paramBundle.setVisibility(0);
    }
    paramBundle = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramBundle != null)
    {
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.remove(paramBundle);
      localFragmentTransaction.add(16908290, ChatFragment.a(), ChatFragment.class.getName()).commitAllowingStateLoss();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "doOnCreate f != null ");
      }
    }
    else
    {
      getSupportFragmentManager().beginTransaction().add(16908290, ChatFragment.a(), ChatFragment.class.getName()).commitAllowingStateLoss();
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "doOnCreate f == null ");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnCreate end ");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnDestroy ");
    }
    if (QLog.isColorLevel())
    {
      int i = URLDrawable.getPoolSize();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("URLDrawableOptions main size ");
      localStringBuilder.append(i);
      QLog.i("URLDrawableOptions", 2, localStringBuilder.toString());
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    ThreadRegulator.a().a(1);
    StartupTrackerForAio.a(null, "AIO_Start_cost");
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnNewIntent start ");
    }
    super.doOnNewIntent(paramIntent);
    if (AIOUtils.a(this, this.app, false, getIntent())) {
      return;
    }
    super.setIntent(paramIntent);
    paramIntent = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramIntent != null)
    {
      paramIntent.d();
      if (!paramIntent.isVisible())
      {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.show(paramIntent);
        localFragmentTransaction.commitAllowingStateLoss();
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "doOnNewIntent !cf.isVisible()");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "doOnNewIntent cf != null");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e(this.TAG, 2, "doOnNewIntent error cf == null");
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnNewIntent end");
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "doOnWindowFocusChanged");
    }
    if (paramBoolean)
    {
      ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localChatFragment != null) {
        localChatFragment.b(2);
      }
    }
  }
  
  public void finish()
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.a(2);
    }
    super.finish();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    Intent localIntent = getIntent();
    if ((localChatFragment != null) && (localIntent != null))
    {
      if (localIntent.getIntExtra("entrance", 0) == 9) {
        setResult(0, localIntent);
      }
      return localChatFragment.a();
    }
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.a(paramInt);
    }
    return null;
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    Object localObject = getSupportFragmentManager();
    Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if (localFragment != null) {
      ((MainFragment)localFragment).h();
    }
    localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null) {
      ((ChatFragment)localObject).e();
    }
  }
  
  public void onPreThemeChanged()
  {
    super.onPreThemeChanged();
    Fragment localFragment = getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localFragment != null) {
      ((ChatFragment)localFragment).f();
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    ChatFragment localChatFragment = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localChatFragment != null) {
      localChatFragment.a(paramInt, paramDialog);
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  public boolean showPreview()
  {
    SetSplash.a(this, null, true);
    getWindow().setFeatureInt(7, 2131558998);
    try
    {
      this.mTitleView = ((View)findViewById(2131366900).getParent());
      this.mTitleView.setVisibility(8);
      return true;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return true;
  }
  
  public void switchToAio(Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchToAio() called with: intent = [");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("]");
      QLog.d(str, 2, localStringBuilder.toString());
    }
    doOnNewIntent(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivity
 * JD-Core Version:    0.7.0.1
 */