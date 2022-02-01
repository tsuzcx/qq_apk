package com.tencent.biz.pubaccount.readinjoy.activity;

import Override;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import bgyd;
import com.tencent.biz.pubaccount.readinjoy.view.LeftRedDotRadioButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import oso;

public class ReadInJoyBaseActivity
  extends FragmentActivity
{
  protected float a;
  protected int a;
  protected View.OnClickListener a;
  protected View a;
  protected ViewGroup a;
  public ImageView a;
  public RadioGroup a;
  public RelativeLayout a;
  public TextView a;
  public LeftRedDotRadioButton a;
  public RedDotRadioButton a;
  public View b;
  public TextView b;
  public TextView c;
  public TextView d;
  
  public ReadInJoyBaseActivity()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new oso(this);
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
    this.c = ((TextView)findViewById(2131369278));
    return this.c;
  }
  
  protected View a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369231));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    if (AppSetting.c) {
      bgyd.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  protected ViewGroup a()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131369270));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton = ((LeftRedDotRadioButton)findViewById(2131369282));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)findViewById(2131369283));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setFocusable(true);
    a(this.jdField_a_of_type_AndroidWidgetRadioGroup);
    return this.jdField_a_of_type_AndroidWidgetRadioGroup;
  }
  
  protected void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130850115));
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376762));
      a(this.jdField_a_of_type_AndroidViewViewGroup);
      c();
      a();
      a();
      b();
      b(paramIntent);
    }
  }
  
  protected View b()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369245));
    a(this.jdField_a_of_type_AndroidWidgetImageView);
    return this.d;
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
            if (((String)localObject).contains(anvx.a(2131712555))) {
              paramIntent = getString(2131690676);
            }
          }
        }
      }
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = getString(2131690676);
      }
      localTextView.setText((CharSequence)localObject);
      localTextView.setVisibility(0);
      if (AppSetting.c)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        paramIntent = (Intent)localObject;
        if (!((String)localObject).contains(getString(2131690676))) {
          paramIntent = getString(2131690676) + (String)localObject;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
      }
      return;
    }
    catch (Exception paramIntent) {}
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
      this.jdField_a_of_type_Int = paramInt;
      getWindow().setFeatureInt(7, 2131559011);
    }
    do
    {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      a(getIntent());
      return;
      Object localObject2 = LayoutInflater.from(this);
      Object localObject1 = ((LayoutInflater)localObject2).inflate(2131560245, null);
      try
      {
        localObject2 = ((LayoutInflater)localObject2).inflate(paramInt, (ViewGroup)localObject1, false);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131379112));
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131376762);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_AndroidViewView = ((View)localObject2);
        super.setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
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
    this.jdField_a_of_type_Int = paramInt;
    getWindow().setFeatureInt(7, 2131559011);
    if (this.jdField_b_of_type_AndroidViewView != null) {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
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
      this.c.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseActivity
 * JD-Core Version:    0.7.0.1
 */