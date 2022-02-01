package com.tencent.device.msg.activities;

import Override;
import abgm;
import abkm;
import abkn;
import abko;
import abkp;
import absn;
import absz;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import bhcl;
import bjkv;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Method;
import mrx;
import mvk;

public class DeviceTipActivity
  extends BaseActivity
{
  public static String a;
  public static boolean a;
  private static int g = 30000;
  int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Rect a;
  Bundle jdField_a_of_type_AndroidOsBundle = null;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new abkp(this);
  Button jdField_a_of_type_AndroidWidgetButton = null;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  public ShimmerTextView a;
  DeviceInfo jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo;
  Runnable jdField_a_of_type_JavaLangRunnable = new DeviceTipActivity.1(this);
  public int b;
  public Rect b;
  Button jdField_b_of_type_AndroidWidgetButton = null;
  public ImageView b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  int jdField_c_of_type_Int = 0;
  public Rect c;
  Button jdField_c_of_type_AndroidWidgetButton;
  public ImageView c;
  TextView jdField_c_of_type_AndroidWidgetTextView = null;
  String jdField_c_of_type_JavaLangString = "";
  public int d;
  ImageView d;
  public int e = 0;
  int f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "DeviceTipActivity";
  }
  
  public DeviceTipActivity()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_c_of_type_AndroidGraphicsRect = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_AndroidWidgetImageView = null;
  }
  
  private void a(int paramInt)
  {
    DataPoint localDataPoint = new DataPoint();
    localDataPoint.mApiName = "set_data_point";
    localDataPoint.mDin = this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din;
    localDataPoint.mProperityId = 1600008;
    localDataPoint.mValue = String.valueOf(paramInt);
    localDataPoint.mValueType = "string";
    ((abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(localDataPoint, 0, this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din, 3);
  }
  
  private boolean a()
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
      return false;
    }
    try
    {
      boolean bool = ((Boolean)Class.forName("android.os.Build").getMethod("hasSmartBar", new Class[0]).invoke(null, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      if ((Build.DEVICE.equals("mx2")) || (Build.DEVICE.equals("mx4pro"))) {
        return true;
      }
      if ((Build.DEVICE.equals("mx")) || (Build.DEVICE.equals("m9"))) {
        return false;
      }
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new abko(this);
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
    ((IntentFilter)localObject1).addAction("SmartDevice_receiveDPMsg");
    ((IntentFilter)localObject1).addAction("SmartDevice_ReceiveDPACKMsg");
    ((IntentFilter)localObject1).addAction("On_OccupyMicrophoneNotify_Push");
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject1);
    d();
    a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131373756));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373751));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373757));
    localObject1 = (ImageView)super.findViewById(2131380975);
    Object localObject2 = super.getResources();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2;
    if (this.f <= 320)
    {
      localLayoutParams1.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131297782);
      ((ImageView)localObject1).setLayoutParams(localLayoutParams1);
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams1.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131297952);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams1);
      if ((FontSettingManager.getFontLevel() == 20.0F) || (FontSettingManager.getFontLevel() == 18.0F) || (FontSettingManager.getFontLevel() == 17.0F))
      {
        localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        localLayoutParams2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        if (this.f > 540) {
          break label524;
        }
        localLayoutParams1.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131297961);
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
        localLayoutParams2.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131297784);
        ((ImageView)localObject1).setLayoutParams(localLayoutParams2);
      }
    }
    for (;;)
    {
      if (FontSettingManager.getFontLevel() == 20.0F)
      {
        localObject1 = (Button)super.findViewById(2131373624);
        localObject2 = (RelativeLayout.LayoutParams)((Button)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = super.getResources().getDimensionPixelSize(2131297607);
        ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (Button)super.findViewById(2131373627);
        localObject2 = (RelativeLayout.LayoutParams)((Button)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = super.getResources().getDimensionPixelSize(2131297607);
        ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((this.jdField_a_of_type_Int <= 800) || ((a()) && (this.jdField_a_of_type_Int <= 1280)))
      {
        localObject1 = (RelativeLayout)super.findViewById(2131373620);
        localObject2 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
        ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      jdField_a_of_type_Boolean = true;
      return;
      if (this.f > 540) {
        break;
      }
      localLayoutParams1 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      int i = ((Resources)localObject2).getDimensionPixelSize(2131297781);
      localLayoutParams1.topMargin = (i - (i - i * 2 / 3));
      ((ImageView)localObject1).setLayoutParams(localLayoutParams1);
      break;
      label524:
      localLayoutParams2.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131297782);
      ((ImageView)localObject1).setLayoutParams(localLayoutParams2);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getExtras();
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        bjkv.a().a(2131691547);
        return;
      }
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("digest");
    this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = ((abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_AndroidGraphicsBitmap = DeviceHeadMgr.getInstance().getDeviceHeadByPID(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_b_of_type_AndroidGraphicsRect.top = this.jdField_a_of_type_AndroidWidgetImageView.getTop();
    this.jdField_b_of_type_AndroidGraphicsRect.bottom = this.jdField_a_of_type_AndroidWidgetImageView.getBottom();
    this.jdField_b_of_type_AndroidGraphicsRect.left = this.jdField_a_of_type_AndroidWidgetImageView.getLeft();
    this.jdField_b_of_type_AndroidGraphicsRect.right = this.jdField_a_of_type_AndroidWidgetImageView.getRight();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsRect.left = this.jdField_a_of_type_AndroidWidgetImageView.getLeft();
    this.jdField_a_of_type_AndroidGraphicsRect.right = this.jdField_a_of_type_AndroidWidgetImageView.getRight();
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_c_of_type_AndroidGraphicsRect.top = this.jdField_c_of_type_AndroidWidgetImageView.getTop();
    this.jdField_c_of_type_AndroidGraphicsRect.bottom = this.jdField_c_of_type_AndroidWidgetImageView.getBottom();
    this.jdField_c_of_type_AndroidGraphicsRect.left = this.jdField_c_of_type_AndroidWidgetImageView.getLeft();
    this.jdField_c_of_type_AndroidGraphicsRect.right = this.jdField_c_of_type_AndroidWidgetImageView.getRight();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131380959));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131373472));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131373621));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842199);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131373627));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131373626));
    Drawable localDrawable = super.getResources().getDrawable(2130842008);
    this.jdField_b_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
    this.jdField_b_of_type_AndroidWidgetButton.setText(anvx.a(2131702711));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new abkn(this));
    this.jdField_d_of_type_Int = super.getApplicationContext().getResources().getDimensionPixelSize(2131297793);
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)super.findViewById(2131373623));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView.setText(anvx.a(2131702712));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131373622));
    localDrawable = mrx.a(super.getApplicationContext(), 2130842141);
    if (localDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localDrawable);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131380975));
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131380976));
      if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(absz.a(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo));
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131373783));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131373624));
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130842141);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null)
    {
      absn localabsn = new absn(this);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("from_tip", true);
      localabsn.a(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo, localBundle, false);
      ((abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din, this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
      a(1);
    }
    finish();
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
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.f = mvk.a(super.getApplicationContext());
    this.jdField_a_of_type_Int = mvk.b(super.getApplicationContext());
    super.setContentView(2131559114);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
    super.getWindow().addFlags(2097152);
    if (Build.VERSION.SDK_INT >= 23) {
      if (!PermissionUtils.isStorePermissionEnable(this)) {
        PermissionUtils.requestStorePermission(this, 3, new abkm(this));
      }
    }
    for (;;)
    {
      return true;
      c();
      continue;
      c();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy");
    }
    bhcl.a();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    this.jdField_b_of_type_AndroidWidgetButton = null;
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = null;
    this.jdField_a_of_type_AndroidGraphicsRect = null;
    this.jdField_b_of_type_AndroidGraphicsRect = null;
    this.jdField_c_of_type_AndroidGraphicsRect = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = null;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetProgressBar = null;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    bhcl.a(2131230742, -1, null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, g);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    bhcl.a();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceTipActivity
 * JD-Core Version:    0.7.0.1
 */