package com.tencent.device.msg.activities;

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
import com.tencent.av.utils.BitmapTools;
import com.tencent.av.utils.UITools;
import com.tencent.av.widget.shimmer.ShimmerTextView;
import com.tencent.device.DeviceHeadMgr;
import com.tencent.device.JNICallCenter.DataPoint;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.device.utils.SmartDeviceUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Method;

public class DeviceTipActivity
  extends BaseActivity
{
  private static int H = 30000;
  public static String a = "DeviceTipActivity";
  public static boolean b = false;
  String A;
  DeviceInfo B;
  String C = "";
  Button D;
  Bitmap E;
  int F;
  Runnable G = new DeviceTipActivity.1(this);
  private final Handler I = new Handler();
  BroadcastReceiver c = null;
  int d;
  ImageView e = null;
  ImageView f = null;
  Button g = null;
  Button h = null;
  ShimmerTextView i = null;
  int j = 0;
  int k = 0;
  Rect l = null;
  Rect m = null;
  Rect n = null;
  ImageView o = null;
  View.OnTouchListener p = new DeviceTipActivity.FloatViewTouchListener(this);
  int q = 0;
  int r = 0;
  LinearLayout s = null;
  TextView t = null;
  ProgressBar u = null;
  TextView v;
  RelativeLayout w = null;
  ImageView x = null;
  TextView y = null;
  Bundle z = null;
  
  private void a(int paramInt)
  {
    DataPoint localDataPoint = new DataPoint();
    localDataPoint.mApiName = "set_data_point";
    localDataPoint.mDin = this.B.din;
    localDataPoint.mProperityId = 1600008;
    localDataPoint.mValue = String.valueOf(paramInt);
    localDataPoint.mValueType = "string";
    ((SmartDeviceProxyMgr)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(localDataPoint, 0, this.B.din, 3);
  }
  
  private void c()
  {
    this.c = new DeviceTipActivity.BroadcastHandler(this);
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_OFF");
    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
    ((IntentFilter)localObject1).addAction("SmartDevice_receiveDPMsg");
    ((IntentFilter)localObject1).addAction("SmartDevice_ReceiveDPACKMsg");
    ((IntentFilter)localObject1).addAction("On_OccupyMicrophoneNotify_Push");
    super.registerReceiver(this.c, (IntentFilter)localObject1);
    e();
    a();
    this.s = ((LinearLayout)super.findViewById(2131441291));
    this.t = ((TextView)this.s.findViewById(2131441286));
    this.u = ((ProgressBar)this.s.findViewById(2131441292));
    localObject1 = (ImageView)super.findViewById(2131449647);
    Object localObject2 = super.getResources();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    int i1 = this.F;
    if (i1 <= 320)
    {
      localLayoutParams1.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131298512);
      ((ImageView)localObject1).setLayoutParams(localLayoutParams1);
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
      localLayoutParams1.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131298683);
      this.s.setLayoutParams(localLayoutParams1);
    }
    else if (i1 <= 540)
    {
      localLayoutParams1 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      i1 = ((Resources)localObject2).getDimensionPixelSize(2131298511);
      localLayoutParams1.topMargin = (i1 - (i1 - i1 * 2 / 3));
      ((ImageView)localObject1).setLayoutParams(localLayoutParams1);
    }
    if ((FontSettingManager.getFontLevel() == 20.0F) || (FontSettingManager.getFontLevel() == 18.0F) || (FontSettingManager.getFontLevel() == 17.0F))
    {
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.v.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      if (this.F <= 540)
      {
        localLayoutParams1.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131298692);
        this.v.setLayoutParams(localLayoutParams1);
        localLayoutParams2.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131298514);
        ((ImageView)localObject1).setLayoutParams(localLayoutParams2);
      }
      else
      {
        localLayoutParams2.topMargin = ((Resources)localObject2).getDimensionPixelSize(2131298512);
        ((ImageView)localObject1).setLayoutParams(localLayoutParams2);
      }
      if (FontSettingManager.getFontLevel() == 20.0F)
      {
        localObject1 = (Button)super.findViewById(2131441182);
        localObject2 = (RelativeLayout.LayoutParams)((Button)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = super.getResources().getDimensionPixelSize(2131298330);
        ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = (Button)super.findViewById(2131441185);
        localObject2 = (RelativeLayout.LayoutParams)((Button)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = super.getResources().getDimensionPixelSize(2131298330);
        ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      if ((this.d <= 800) || ((d()) && (this.d <= 1280)))
      {
        localObject1 = (RelativeLayout)super.findViewById(2131441178);
        localObject2 = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = 0;
        ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    this.t.setText(this.C);
    this.t.setVisibility(0);
    b = true;
  }
  
  private boolean d()
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
      label47:
      break label47;
    }
    if ((!Build.DEVICE.equals("mx2")) && (!Build.DEVICE.equals("mx4pro")))
    {
      if ((!Build.DEVICE.equals("mx")) && (Build.DEVICE.equals("m9"))) {}
      return false;
    }
    return true;
  }
  
  private void e()
  {
    this.z = super.getIntent().getBundleExtra("key_params");
    if (this.z == null)
    {
      this.z = super.getIntent().getExtras();
      if (this.z == null)
      {
        ToastUtil.a().a(2131888544);
        return;
      }
    }
    this.A = this.z.getString("uin");
    this.C = this.z.getString("digest");
    this.B = ((SmartDeviceProxyMgr)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(Long.parseLong(this.A));
    this.E = DeviceHeadMgr.getInstance().getDeviceHeadByPID(this.B.productId);
  }
  
  private void f()
  {
    this.m = new Rect();
    this.m.top = this.e.getTop();
    this.m.bottom = this.e.getBottom();
    this.m.left = this.e.getLeft();
    this.m.right = this.e.getRight();
    this.l = new Rect();
    this.l.left = this.e.getLeft();
    this.l.right = this.e.getRight();
    this.n = new Rect();
    this.n.top = this.o.getTop();
    this.n.bottom = this.o.getBottom();
    this.n.left = this.o.getLeft();
    this.n.right = this.o.getRight();
  }
  
  protected void a()
  {
    this.w = ((RelativeLayout)super.findViewById(2131449634));
    this.o = ((ImageView)super.findViewById(2131441030));
    this.e = ((ImageView)super.findViewById(2131441179));
    this.e.setBackgroundResource(2130843175);
    this.e.setOnTouchListener(this.p);
    this.g = ((Button)super.findViewById(2131441185));
    this.h = ((Button)super.findViewById(2131441184));
    Object localObject = super.getResources().getDrawable(2130842969);
    this.h.setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject, null, null);
    this.h.setText(HardCodeUtil.a(2131901351));
    this.h.setOnClickListener(new DeviceTipActivity.3(this));
    this.q = super.getApplicationContext().getResources().getDimensionPixelSize(2131298524);
    this.i = ((ShimmerTextView)super.findViewById(2131441181));
    this.i.setText(HardCodeUtil.a(2131901352));
    this.f = ((ImageView)super.findViewById(2131441180));
    localObject = BitmapTools.a(super.getApplicationContext(), 2130843117);
    if (localObject != null) {
      this.w.setBackgroundDrawable((Drawable)localObject);
    } else {
      this.w.setBackgroundResource(2130843117);
    }
    this.x = ((ImageView)super.findViewById(2131449647));
    localObject = this.E;
    if (localObject != null) {
      this.x.setImageBitmap((Bitmap)localObject);
    }
    this.y = ((TextView)super.findViewById(2131449648));
    localObject = this.B;
    if (localObject != null) {
      this.y.setText(SmartDeviceUtil.a((DeviceInfo)localObject));
    }
    this.v = ((TextView)super.findViewById(2131441325));
    this.g.setVisibility(8);
    this.v.setVisibility(8);
    this.D = ((Button)super.findViewById(2131441182));
    this.D.setVisibility(8);
  }
  
  public void b()
  {
    if (this.B != null)
    {
      LightAppUtil localLightAppUtil = new LightAppUtil(this);
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("from_tip", true);
      localLightAppUtil.a(this.B, localBundle, false);
      ((SmartDeviceProxyMgr)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).b(this.B.din, this.B.productId);
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.F = UITools.a(super.getApplicationContext());
    this.d = UITools.b(super.getApplicationContext());
    super.setContentView(2131624702);
    super.getWindow().addFlags(524288);
    super.getWindow().addFlags(128);
    super.getWindow().addFlags(1024);
    super.getWindow().addFlags(2097152);
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (!PermissionUtils.isStorePermissionEnable(this)) {
        PermissionUtils.requestStorePermission(this, 3, new DeviceTipActivity.2(this));
      } else {
        c();
      }
    }
    else {
      c();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onDestroy");
    }
    AudioUtil.b();
    BroadcastReceiver localBroadcastReceiver = this.c;
    if (localBroadcastReceiver != null) {
      super.unregisterReceiver(localBroadcastReceiver);
    }
    b = false;
    this.c = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
    this.l = null;
    this.m = null;
    this.n = null;
    this.o = null;
    this.p = null;
    this.s = null;
    this.t = null;
    this.u = null;
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    AudioUtil.a(2131230814, -1, null);
    this.I.postDelayed(this.G, H);
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
    AudioUtil.b();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DeviceTipActivity
 * JD-Core Version:    0.7.0.1
 */