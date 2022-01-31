package com.tencent.biz.pubaccount.readinjoy.activity;

import alud;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import bczz;
import bdep;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import nxf;
import nzi;

public class ReadInJoyNewBaseActivity
  extends FragmentActivity
{
  protected float a;
  public int a;
  protected View.OnClickListener a;
  public View a;
  protected ViewGroup a;
  public ImageView a;
  public LinearLayout a;
  public TextView a;
  protected ImmersiveTitleBar2 a;
  protected boolean a;
  protected View b;
  public ViewGroup b;
  public ImageView b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public ReadInJoyNewBaseActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nzi(this);
  }
  
  @TargetApi(11)
  public static void a(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    paramView.setLayerType(0, null);
  }
  
  private View c()
  {
    this.c = ((TextView)findViewById(2131368670));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131368672));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368671));
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  protected View a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    if (AppSetting.c) {
      bczz.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidViewView = ((ViewStub)findViewById(2131378042)).inflate();
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (paramInt != this.jdField_b_of_type_AndroidWidgetImageView.getVisibility()))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(paramInt);
    }
  }
  
  protected void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130849542));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375865));
    a(this.jdField_a_of_type_AndroidViewViewGroup);
    c();
    a();
    b();
    b(paramIntent);
  }
  
  @TargetApi(23)
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getWindow().getDecorView().setSystemUiVisibility(9216);
      return;
    }
    getWindow().getDecorView().setSystemUiVisibility(0);
  }
  
  protected View b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368638));
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    return this.d;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_Int == paramInt) {}
    label188:
    label208:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyBaseActivity", 2, "setDisplayMode from " + paramInt + " to " + this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Int == 0)
      {
        if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
        {
          super.getWindow().addFlags(67108864);
          if (this.mSystemBarComp == null) {
            this.mSystemBarComp = new SystemBarCompact(this, true, -1);
          }
          this.mSystemBarComp.init();
          if (!this.jdField_a_of_type_Boolean) {
            break label208;
          }
          if ((bdep.b()) || (bdep.d())) {
            break label188;
          }
          this.mSystemBarComp.setStatusBarColor(-7829368);
        }
        for (;;)
        {
          this.c.setTextColor(-14408926);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-14408926);
          this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130848998);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848996);
          this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-1);
          return;
          this.mSystemBarComp.setStatusBarColor(-7829368);
          this.mSystemBarComp.setStatusBarDarkMode(true);
          continue;
          if ((Build.VERSION.SDK_INT >= 23) && (!bdep.b()) && (!bdep.d()))
          {
            a(true);
            this.mSystemBarComp.setStatusBarColor(-1);
          }
          else if (!bdep.d())
          {
            this.mSystemBarComp.setStatusBarColor(-2368549);
          }
          else
          {
            this.mSystemBarComp.setStatusBarColor(-1);
            this.mSystemBarComp.setStatusBarDarkMode(true);
          }
        }
      }
    } while (this.jdField_a_of_type_Int != 1);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null)
      {
        this.mSystemBarComp = new SystemBarCompact(this, true, -14408926);
        this.mSystemBarComp.init();
      }
      this.mSystemBarComp.setStatusBarDarkMode(false);
      if ((Build.VERSION.SDK_INT < 23) || (bdep.b()) || (bdep.d())) {
        break label427;
      }
      a(false);
      this.mSystemBarComp.setStatusBarColor(-14408926);
    }
    for (;;)
    {
      this.c.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130848999);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848997);
      this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(-14408926);
      return;
      label427:
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusBarColor(-14408926);
    }
  }
  
  public void b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && ((this.jdField_a_of_type_AndroidWidgetTextView instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
      if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
    try
    {
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      Object localObject = paramIntent.getExtras().getString("leftViewText");
      int i = paramIntent.getExtras().getInt("individuation_url_type");
      paramIntent = (Intent)localObject;
      if (i >= 40300)
      {
        paramIntent = (Intent)localObject;
        if (i <= 40313)
        {
          paramIntent = (Intent)localObject;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramIntent = (Intent)localObject;
            if (((String)localObject).contains(alud.a(2131713105))) {
              paramIntent = getString(2131690623);
            }
          }
        }
      }
      if (paramIntent != null)
      {
        localObject = paramIntent;
        if (!paramIntent.contains("http")) {}
      }
      else
      {
        localObject = getString(2131690623);
      }
      localTextView.setText((CharSequence)localObject);
      localTextView.setVisibility(0);
      if (AppSetting.c)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        paramIntent = (Intent)localObject;
        if (!((String)localObject).contains(getString(2131690623))) {
          paramIntent = getString(2131690623) + (String)localObject;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  protected void b(boolean paramBoolean)
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  protected void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(7);
  }
  
  public void setContentView(int paramInt)
  {
    if (!this.mNeedStatusTrans)
    {
      super.setContentView(paramInt);
      getWindow().setFeatureInt(7, 2131558911);
    }
    do
    {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      a(getIntent());
      return;
      Object localObject = LayoutInflater.from(this);
      View localView = ((LayoutInflater)localObject).inflate(2131560082, null);
      try
      {
        this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131378043));
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView.findViewById(2131378030));
        localObject = ((LayoutInflater)localObject).inflate(paramInt, this.jdField_b_of_type_AndroidViewViewGroup, false);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.jdField_b_of_type_AndroidViewViewGroup.addView((View)localObject, 0, localLayoutParams);
        super.setContentView(localView);
        this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(this.app);
        i = 0;
      }
      catch (InflateException localInflateException)
      {
        for (;;)
        {
          localInflateException.printStackTrace();
          i = 1;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          localRuntimeException.printStackTrace();
          int i = 1;
        }
      }
    } while (i == 0);
    if (QLog.isColorLevel()) {
      QLog.e("IphoneTitleBarActivity", 2, "layout with merge ,use framelayout to immersive" + getComponentName());
    }
    super.setContentView(paramInt);
    getWindow().setFeatureInt(7, 2131558911);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    a(getIntent());
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.c != null) && ((this.c instanceof TextView)))
    {
      TextView localTextView = this.c;
      int i = nxf.d;
      Object localObject = paramCharSequence;
      if (paramCharSequence.length() > i) {
        localObject = paramCharSequence.subSequence(0, i) + "...";
      }
      localTextView.setText((CharSequence)localObject);
      super.setTitle((CharSequence)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewBaseActivity
 * JD-Core Version:    0.7.0.1
 */