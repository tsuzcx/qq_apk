package com.tencent.biz.pubaccount.readinjoy.activity;

import ajya;
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
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import baww;
import com.tencent.biz.pubaccount.readinjoy.view.LeftRedDotRadioButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import nuy;

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
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nuy(this);
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
    this.c = ((TextView)findViewById(2131368472));
    return this.c;
  }
  
  protected View a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368429));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a(this.jdField_a_of_type_AndroidWidgetTextView);
    if (AppSetting.d) {
      baww.b(this.jdField_a_of_type_AndroidWidgetTextView, Button.class.getName());
    }
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  protected ViewGroup a()
  {
    this.jdField_a_of_type_AndroidWidgetRadioGroup = ((RadioGroup)findViewById(2131368465));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton = ((LeftRedDotRadioButton)findViewById(2131368476));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewLeftRedDotRadioButton.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton = ((RedDotRadioButton)findViewById(2131368477));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.setFocusable(true);
    a(this.jdField_a_of_type_AndroidWidgetRadioGroup);
    return this.jdField_a_of_type_AndroidWidgetRadioGroup;
  }
  
  protected void a(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130849038));
    if (this.jdField_a_of_type_AndroidWidgetTextView == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375331));
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368441));
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
            if (((String)localObject).contains(ajya.a(2131713104))) {
              paramIntent = getString(2131690572);
            }
          }
        }
      }
      localObject = paramIntent;
      if (paramIntent == null) {
        localObject = getString(2131690572);
      }
      localTextView.setText((CharSequence)localObject);
      localTextView.setVisibility(0);
      if (AppSetting.d)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
        paramIntent = (Intent)localObject;
        if (!((String)localObject).contains(getString(2131690572))) {
          paramIntent = getString(2131690572) + (String)localObject;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
      }
      return;
    }
    catch (Exception paramIntent) {}
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
      this.jdField_a_of_type_Int = paramInt;
      getWindow().setFeatureInt(7, 2131558875);
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
      Object localObject1 = ((LayoutInflater)localObject2).inflate(2131559937, null);
      try
      {
        localObject2 = ((LayoutInflater)localObject2).inflate(paramInt, (ViewGroup)localObject1, false);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)((View)localObject1).findViewById(2131377452));
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(true);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        localObject1 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131375331);
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
    getWindow().setFeatureInt(7, 2131558875);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseActivity
 * JD-Core Version:    0.7.0.1
 */