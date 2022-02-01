package com.tencent.mobileqq.activity;

import Override;
import afno;
import afnp;
import afnq;
import amqw;
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
import anzj;
import aoho;
import bhjr;
import bhnv;
import blha;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class SigCommentListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public amqw a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aoho jdField_a_of_type_Aoho = new afno(this);
  private blha jdField_a_of_type_Blha;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      try
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167076)));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131712975));
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, true);
        return;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SigCommentListActivity", 2, localException1.toString());
          }
        }
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167076)));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850440);
      if (paramInt == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131712976));
        return;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SigCommentListActivity", 2, localException2.toString());
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131712972));
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131166498)));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new afnp(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new afnq(this));
      return;
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SigCommentListActivity", 2, localException3.toString());
        }
      }
    }
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
      if (!ThemeUtil.isInNightMode(getAppRuntime())) {
        break label80;
      }
      if ((!bhjr.b()) && (!bhjr.d())) {
        localSystemBarCompact.setStatusBarColor(-7829368);
      }
    }
    else
    {
      return;
    }
    localSystemBarCompact.setStatusBarColor(-7829368);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label80:
    if ((Build.VERSION.SDK_INT >= 23) && (!bhjr.b()) && (!bhjr.d()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!bhjr.d())
    {
      localSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    localSystemBarCompact.setStatusBarColor(-1);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(1);
    Object localObject;
    if (bhnv.d(this))
    {
      localObject = (SignatureHandler)this.app.a(41);
      if (localObject != null) {
        ((SignatureHandler)localObject).a(paramBoolean2);
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        startTitleProgress();
      }
      return;
      localObject = this.jdField_a_of_type_Blha.obtainMessage(1, 1, 0);
      this.jdField_a_of_type_Blha.sendMessageDelayed((Message)localObject, 1000L);
      this.jdField_a_of_type_Amqw.a(2131718272);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562129);
    super.setTitle(anzj.a(2131712973));
    this.leftView.setTextColor(getResources().getColor(2131165343));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840286));
    this.centerView.setTextColor(getResources().getColor(2131165343));
    a();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562935, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366028));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366039));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839414);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377710));
    this.jdField_a_of_type_ComTencentWidgetXListView.setScrollbarFadingEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_Amqw = new amqw(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amqw);
    this.jdField_a_of_type_Blha = new blha(this);
    this.app.setHandler(SigCommentListActivity.class, this.jdField_a_of_type_Blha);
    if (this.jdField_a_of_type_Aoho != null) {
      this.app.addObserver(this.jdField_a_of_type_Aoho);
    }
    paramBundle = this.jdField_a_of_type_Blha.obtainMessage(0, 1, 1);
    this.jdField_a_of_type_Blha.sendMessageDelayed(paramBundle, 500L);
    a(1);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Aoho != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Aoho);
      this.jdField_a_of_type_Aoho = null;
    }
    this.app.removeHandler(SigCommentListActivity.class);
    super.doOnDestroy();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = false;
    switch (paramMessage.what)
    {
    }
    do
    {
      return true;
      if (paramMessage.arg1 == 1) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramMessage.arg2 == 1) {
          bool2 = true;
        }
        a(bool1, bool2);
        return true;
      }
      stopTitleProgress();
    } while (1 != paramMessage.arg1);
    if (isResume()) {
      QQToast.a(this, 0, getResources().getString(2131718273), 0).b(getTitleBarHeight());
    }
    a(2);
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SigCommentListActivity
 * JD-Core Version:    0.7.0.1
 */