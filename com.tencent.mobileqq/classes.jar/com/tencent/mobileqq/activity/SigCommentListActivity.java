package com.tencent.mobileqq.activity;

import abrv;
import abrw;
import abrx;
import aicr;
import ajjy;
import ajsf;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import azzu;
import badq;
import bbmy;
import beez;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class SigCommentListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public aicr a;
  ajsf jdField_a_of_type_Ajsf = new abrv(this);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private beez jdField_a_of_type_Beez;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      try
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131101338)));
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648313));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131101338)));
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849089);
      if (paramInt == 3)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648314));
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
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648310));
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(ColorStateList.createFromXml(getResources(), getResources().getXml(2131100778)));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new abrw(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new abrx(this));
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
      if ((!azzu.b()) && (!azzu.d())) {
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
    if ((Build.VERSION.SDK_INT >= 23) && (!azzu.b()) && (!azzu.d()))
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!azzu.d())
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
    if (badq.d(this))
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
      localObject = this.jdField_a_of_type_Beez.obtainMessage(1, 1, 0);
      this.jdField_a_of_type_Beez.sendMessageDelayed((Message)localObject, 1000L);
      this.jdField_a_of_type_Aicr.a(2131653753);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131496052);
    super.setTitle(ajjy.a(2131648311));
    this.leftView.setTextColor(getResources().getColor(2131099738));
    this.leftView.setBackgroundDrawable(getResources().getDrawable(2130839699));
    this.centerView.setTextColor(getResources().getColor(2131099738));
    a();
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131496841, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300058));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300070));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839117);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131310400));
    this.jdField_a_of_type_ComTencentWidgetXListView.setScrollbarFadingEnabled(true);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_Aicr = new aicr(this, this.app, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aicr);
    this.jdField_a_of_type_Beez = new beez(this);
    this.app.setHandler(SigCommentListActivity.class, this.jdField_a_of_type_Beez);
    if (this.jdField_a_of_type_Ajsf != null) {
      this.app.addObserver(this.jdField_a_of_type_Ajsf);
    }
    paramBundle = this.jdField_a_of_type_Beez.obtainMessage(0, 1, 1);
    this.jdField_a_of_type_Beez.sendMessageDelayed(paramBundle, 500L);
    a(1);
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_Ajsf != null)
    {
      this.app.removeObserver(this.jdField_a_of_type_Ajsf);
      this.jdField_a_of_type_Ajsf = null;
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
      bbmy.a(this, 0, getResources().getString(2131653754), 0).b(getTitleBarHeight());
    }
    a(2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SigCommentListActivity
 * JD-Core Version:    0.7.0.1
 */