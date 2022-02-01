package com.tencent.mobileqq.activity;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.adapter.SigCommentSessionListAdapter;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.app.SignatureObserver;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class SigCommentListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  SigCommentSessionListAdapter a;
  XListView b;
  View c;
  ImageView d;
  TextView e;
  Drawable f;
  SignatureObserver g = new SigCommentListActivity.1(this);
  private MqqWeakReferenceHandler h;
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      try
      {
        this.e.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131168125)));
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SigCommentListActivity", 2, localException1.toString());
        }
      }
      this.e.setText(HardCodeUtil.a(2131911512));
      this.d.setImageDrawable(this.f);
      this.f.setVisible(true, true);
      return;
    }
    try
    {
      this.e.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131168125)));
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SigCommentListActivity", 2, localException2.toString());
      }
    }
    this.f.setVisible(false, false);
    this.d.setImageResource(2130852641);
    if (paramInt == 3)
    {
      this.e.setText(HardCodeUtil.a(2131911513));
      return;
    }
    this.e.setText(HardCodeUtil.a(2131911509));
    try
    {
      this.e.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167467)));
    }
    catch (Exception localException3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SigCommentListActivity", 2, localException3.toString());
      }
    }
    this.e.setOnClickListener(new SigCommentListActivity.2(this));
    this.d.setOnClickListener(new SigCommentListActivity.3(this));
  }
  
  void a()
  {
    if (getTitleBarView() != null)
    {
      getTitleBarView().setBackgroundResource(0);
      getTitleBarView().setBackgroundColor(-1);
    }
    SystemBarCompact localSystemBarCompact = this.mSystemBarComp;
    if ((localSystemBarCompact != null) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      if (ThemeUtil.isInNightMode(getAppRuntime()))
      {
        if ((!SystemUtil.d()) && (!SystemUtil.g()))
        {
          localSystemBarCompact.setStatusBarColor(-7829368);
          return;
        }
        localSystemBarCompact.setStatusBarColor(-7829368);
        localSystemBarCompact.setStatusBarDarkMode(true);
        return;
      }
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.d()) && (!SystemUtil.g()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        localSystemBarCompact.setStatusBarColor(-1);
        return;
      }
      if (!SystemUtil.g())
      {
        localSystemBarCompact.setStatusBarColor(-2368549);
        return;
      }
      localSystemBarCompact.setStatusBarColor(-1);
      localSystemBarCompact.setStatusBarDarkMode(true);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(1);
    Object localObject;
    if (NetworkUtil.isNetSupport(this))
    {
      localObject = (SignatureHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
      if (localObject != null) {
        ((SignatureHandler)localObject).a(paramBoolean2);
      }
    }
    else
    {
      localObject = this.h.obtainMessage(1, 1, 0);
      this.h.sendMessageDelayed((Message)localObject, 1000L);
      this.a.b(2131916680);
    }
    if (paramBoolean1) {
      startTitleProgress();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131628470);
    super.setTitle(HardCodeUtil.a(2131911510));
    this.leftView.setTextColor(getResources().getColor(2131165564));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130841082));
    this.centerView.setTextColor(getResources().getColor(2131165564));
    a();
    this.c = LayoutInflater.from(this).inflate(2131629306, this.b, false);
    this.d = ((ImageView)this.c.findViewById(2131432506));
    this.e = ((TextView)this.c.findViewById(2131432517));
    this.f = getResources().getDrawable(2130839590);
    this.b = ((XListView)findViewById(2131445996));
    this.b.setScrollbarFadingEnabled(true);
    this.b.setDivider(null);
    this.a = new SigCommentSessionListAdapter(this, this.app, this.b, this.c);
    this.b.setAdapter(this.a);
    this.h = new MqqWeakReferenceHandler(this);
    this.app.setHandler(SigCommentListActivity.class, this.h);
    if (this.g != null) {
      this.app.addObserver(this.g);
    }
    paramBundle = this.h.obtainMessage(0, 1, 1);
    this.h.sendMessageDelayed(paramBundle, 500L);
    a(1);
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (this.g != null)
    {
      this.app.removeObserver(this.g);
      this.g = null;
    }
    this.app.removeHandler(SigCommentListActivity.class);
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool2 = false;
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      stopTitleProgress();
      if (1 == paramMessage.arg1)
      {
        if (isResume()) {
          QQToast.makeText(this, 0, getResources().getString(2131916681), 0).show(getTitleBarHeight());
        }
        a(2);
        return true;
      }
    }
    else
    {
      boolean bool1;
      if (paramMessage.arg1 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (paramMessage.arg2 == 1) {
        bool2 = true;
      }
      a(bool1, bool2);
    }
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SigCommentListActivity
 * JD-Core Version:    0.7.0.1
 */