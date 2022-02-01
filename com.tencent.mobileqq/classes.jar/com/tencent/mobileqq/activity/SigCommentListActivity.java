package com.tencent.mobileqq.activity;

import Override;
import aexo;
import aexp;
import aexq;
import amjr;
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
import anvx;
import aods;
import bkyc;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
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
  public amjr a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  aods jdField_a_of_type_Aods = new aexo(this);
  private bkyc jdField_a_of_type_Bkyc;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      try
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167112)));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713554));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131167112)));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130850471);
      if (paramInt == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713555));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131713551));
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131166531)));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new aexp(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aexq(this));
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
      if ((!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme())) {
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
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.isMIUI()) && (!SystemUtil.isFlyme()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.isFlyme())
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
    if (NetworkUtil.isNetSupport(this))
    {
      localObject = (SignatureHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SIGNATURE_HANDLER);
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
      localObject = this.jdField_a_of_type_Bkyc.obtainMessage(1, 1, 0);
      this.jdField_a_of_type_Bkyc.sendMessageDelayed((Message)localObject, 1000L);
      this.jdField_a_of_type_Amjr.a(2131718899);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131562069);
    super.setTitle(anvx.a(2131713552));
    this.leftView.setTextColor(getResources().getColor(2131165357));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130840360));
    this.centerView.setTextColor(getResources().getColor(2131165357));
    a();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131562885, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366159));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366170));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839470);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131377751));
    this.jdField_a_of_type_ComTencentWidgetXListView.setScrollbarFadingEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_Amjr = new amjr(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amjr);
    this.jdField_a_of_type_Bkyc = new bkyc(this);
    this.app.setHandler(SigCommentListActivity.class, this.jdField_a_of_type_Bkyc);
    if (this.jdField_a_of_type_Aods != null) {
      this.app.addObserver(this.jdField_a_of_type_Aods);
    }
    paramBundle = this.jdField_a_of_type_Bkyc.obtainMessage(0, 1, 1);
    this.jdField_a_of_type_Bkyc.sendMessageDelayed(paramBundle, 500L);
    a(1);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Aods != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Aods);
      this.jdField_a_of_type_Aods = null;
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
      QQToast.a(this, 0, getResources().getString(2131718900), 0).b(getTitleBarHeight());
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