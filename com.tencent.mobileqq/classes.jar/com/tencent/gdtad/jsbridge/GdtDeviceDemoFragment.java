package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.ad.tangram.lbs.AdLocation;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public final class GdtDeviceDemoFragment
  extends PublicBaseFragment
{
  private TextView a;
  
  public static void a(Activity paramActivity, Class<? extends PublicFragmentActivity> paramClass)
  {
    GdtLog.b("GdtDeviceDemoFragment", "start");
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, paramClass, GdtDeviceDemoFragment.class);
  }
  
  private void a(String paramString)
  {
    AdThreadManager.INSTANCE.post(new GdtDeviceDemoFragment.5(this, paramString), 0);
  }
  
  private static AdLocation b(SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      AdLocation localAdLocation = new AdLocation();
      localAdLocation.latitude = paramSosoLbsInfo.mLocation.mLat02;
      localAdLocation.longitude = paramSosoLbsInfo.mLocation.mLon02;
      localAdLocation.timeMillis = paramSosoLbsInfo.mLocation.locationTime;
      return localAdLocation;
    }
    return null;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    GdtManager.a().a(getBaseActivity(), null);
    this.a = new TextView(getBaseActivity());
    a(String.format("processName:%s", new Object[] { AdProcessManager.INSTANCE.getCurrentProcessName(getBaseActivity()) }));
    paramViewGroup = new Button(getBaseActivity());
    paramViewGroup.setText("getDeviceInfo");
    paramViewGroup.setOnClickListener(new GdtDeviceDemoFragment.1(this));
    paramBundle = new Button(getBaseActivity());
    paramBundle.setText("AdLocationManager.getLocationCache");
    paramBundle.setOnClickListener(new GdtDeviceDemoFragment.2(this));
    Button localButton1 = new Button(getBaseActivity());
    localButton1.setText("LbsManagerService.getCachedLbsInfo");
    localButton1.setOnClickListener(new GdtDeviceDemoFragment.3(this));
    Button localButton2 = new Button(getBaseActivity());
    localButton2.setText("LbsManagerService.startLocation");
    localButton2.setOnClickListener(new GdtDeviceDemoFragment.4(this));
    paramLayoutInflater = new LinearLayout(getBaseActivity());
    paramLayoutInflater.setBackgroundColor(Color.parseColor("#DBDBDB"));
    paramLayoutInflater.setOrientation(1);
    paramLayoutInflater.addView(paramViewGroup);
    paramLayoutInflater.addView(paramBundle);
    paramLayoutInflater.addView(localButton1);
    paramLayoutInflater.addView(localButton2);
    paramLayoutInflater.addView(this.a);
    paramViewGroup = new ScrollView(getBaseActivity());
    paramViewGroup.addView(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment
 * JD-Core Version:    0.7.0.1
 */