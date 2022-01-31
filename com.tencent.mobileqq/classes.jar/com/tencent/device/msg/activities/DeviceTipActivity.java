package com.tencent.device.msg.activities;

import ajia;
import ajjy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
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
import baan;
import bcec;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import mfx;
import mjg;
import xrh;
import xvh;
import xvi;
import xvj;
import ydh;
import ydt;

public class DeviceTipActivity
  extends BaseActivity
{
  public static String a;
  public static boolean a;
  private static int f = 30000;
  int jdField_a_of_type_Int;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Rect a;
  Bundle jdField_a_of_type_AndroidOsBundle = null;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new xvj(this);
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
    ((xrh)this.app.a(51)).a(localDataPoint, 0, this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din, 3);
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
    this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getBundleExtra("key_params");
    if (this.jdField_a_of_type_AndroidOsBundle == null)
    {
      this.jdField_a_of_type_AndroidOsBundle = super.getIntent().getExtras();
      if (this.jdField_a_of_type_AndroidOsBundle == null)
      {
        bcec.a().a(2131626046);
        return;
      }
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("digest");
    this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = ((xrh)this.app.a(51)).a(Long.parseLong(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_AndroidGraphicsBitmap = DeviceHeadMgr.getInstance().getDeviceHeadByPID(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
  }
  
  private void d()
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131313187));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131306523));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131306667));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130841568);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131306673));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131306672));
    Drawable localDrawable = super.getResources().getDrawable(2130841398);
    this.jdField_b_of_type_AndroidWidgetButton.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
    this.jdField_b_of_type_AndroidWidgetButton.setText(ajjy.a(2131637441));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new xvh(this));
    this.jdField_d_of_type_Int = super.getApplicationContext().getResources().getDimensionPixelSize(2131166536);
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView = ((ShimmerTextView)super.findViewById(2131306669));
    this.jdField_a_of_type_ComTencentAvWidgetShimmerShimmerTextView.setText(ajjy.a(2131637442));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131306668));
    localDrawable = mfx.a(super.getApplicationContext(), 2130841513);
    if (localDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localDrawable);
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131313193));
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
        this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131313194));
      if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(ydt.a(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo));
      }
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131306821));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131306670));
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130841513);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null)
    {
      ydh localydh = new ydh(this);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("from_tip", true);
      localydh.a(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo, localBundle, false);
      ((xrh)this.app.a(51)).a(this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din, this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
      a(1);
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    int i = mjg.a(super.getApplicationContext());
    this.jdField_a_of_type_Int = mjg.b(super.getApplicationContext());
    super.setContentView(2131493412);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
    super.getWindow().addFlags(2097152);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new xvi(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("android.intent.action.SCREEN_ON");
    paramBundle.addAction("SmartDevice_receiveDPMsg");
    paramBundle.addAction("SmartDevice_ReceiveDPACKMsg");
    paramBundle.addAction("On_OccupyMicrophoneNotify_Push");
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    c();
    a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131306795));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131306790));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131306796));
    paramBundle = (ImageView)super.findViewById(2131313193);
    Object localObject = super.getResources();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2;
    if (i <= 320)
    {
      localLayoutParams1.topMargin = ((Resources)localObject).getDimensionPixelSize(2131166525);
      paramBundle.setLayoutParams(localLayoutParams1);
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams1.topMargin = ((Resources)localObject).getDimensionPixelSize(2131166691);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams1);
      if ((ajia.a() == 20.0F) || (ajia.a() == 18.0F) || (ajia.a() == 17.0F))
      {
        localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetTextView.getLayoutParams();
        localLayoutParams2 = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
        if (i > 540) {
          break label614;
        }
        localLayoutParams1.topMargin = ((Resources)localObject).getDimensionPixelSize(2131166700);
        this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams1);
        localLayoutParams2.topMargin = ((Resources)localObject).getDimensionPixelSize(2131166527);
        paramBundle.setLayoutParams(localLayoutParams2);
      }
    }
    for (;;)
    {
      if (ajia.a() == 20.0F)
      {
        paramBundle = (Button)super.findViewById(2131306670);
        localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).leftMargin = super.getResources().getDimensionPixelSize(2131166352);
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramBundle = (Button)super.findViewById(2131306673);
        localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).rightMargin = super.getResources().getDimensionPixelSize(2131166352);
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if ((this.jdField_a_of_type_Int <= 800) || ((a()) && (this.jdField_a_of_type_Int <= 1280)))
      {
        paramBundle = (RelativeLayout)super.findViewById(2131306666);
        localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
        paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      jdField_a_of_type_Boolean = true;
      return true;
      if (i > 540) {
        break;
      }
      localLayoutParams1 = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      int j = ((Resources)localObject).getDimensionPixelSize(2131166524);
      localLayoutParams1.topMargin = (j - (j - j * 2 / 3));
      paramBundle.setLayoutParams(localLayoutParams1);
      break;
      label614:
      localLayoutParams2.topMargin = ((Resources)localObject).getDimensionPixelSize(2131166525);
      paramBundle.setLayoutParams(localLayoutParams2);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy");
    }
    baan.a();
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
    baan.a(2131230742, -1, null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, f);
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    baan.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceTipActivity
 * JD-Core Version:    0.7.0.1
 */