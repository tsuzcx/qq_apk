package com.tencent.mobileqq.activity;

import aepi;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import bdeq;
import bdnm;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qphone.base.util.QLog;

public class ChatActivity
  extends FragmentActivity
{
  private View jdField_a_of_type_AndroidViewView;
  private String jdField_a_of_type_JavaLangString = "Q.aio.ChatActivity";
  
  public void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "switchToAio() called with: intent = [" + paramIntent + "]");
    }
    doOnNewIntent(paramIntent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    ThreadRegulator.a().a(1);
    bdnm.b(null, "AIO_Start_cost");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate strat ");
    }
    bdeq.a(true);
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    if (aepi.a(this, this.app, true, getIntent())) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    paramBundle = (ChatFragment)getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramBundle != null)
    {
      FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
      localFragmentTransaction.remove(paramBundle);
      localFragmentTransaction.add(16908290, ChatFragment.a(), ChatFragment.class.getName()).commit();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate f != null ");
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate end ");
      }
      return true;
      getSupportFragmentManager().beginTransaction().add(16908290, ChatFragment.a(), ChatFragment.class.getName()).commit();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnCreate f == null ");
      }
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnDestroy ");
      }
      if (QLog.isColorLevel())
      {
        int i = URLDrawable.getPoolSize();
        QLog.i("URLDrawableOptions", 2, "URLDrawableOptions main size " + i);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    ThreadRegulator.a().a(1);
    bdnm.b(null, "AIO_Start_cost");
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnNewIntent start ");
    }
    super.doOnNewIntent(paramIntent);
    if (aepi.a(this, this.app, false, getIntent())) {}
    for (;;)
    {
      return;
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
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnNewIntent !cf.isVisible()");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnNewIntent cf != null");
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnNewIntent end");
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "doOnNewIntent error cf == null");
        }
      }
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "doOnWindowFocusChanged");
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
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
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
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    getWindow().setFormat(-3);
  }
  
  public boolean showPreview()
  {
    SetSplash.a(this, null, true);
    getWindow().setFeatureInt(7, 2131558960);
    try
    {
      this.jdField_a_of_type_AndroidViewView = ((View)findViewById(2131366416).getParent());
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return true;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivity
 * JD-Core Version:    0.7.0.1
 */