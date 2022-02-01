package com.tencent.biz.pubaccount.readinjoyAd.ad.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;
import tho;
import thu;
import tpa;
import tsa;
import tsb;
import tsc;
import tsd;
import tsr;
import tss;

public class ReadinjoyAdHippyFragment
  extends ReadInJoyBaseFragment
{
  protected int a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public ViolaBaseView a;
  public HippyQQEngine a;
  protected String a;
  private thu jdField_a_of_type_Thu;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  private String d = "func_tab";
  
  public ReadinjoyAdHippyFragment()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "hippyGame";
  }
  
  public static ReadinjoyAdHippyFragment a(int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt);
    localBundle.putString("channel_name", paramString1);
    localBundle.putString("channel_version", paramString2);
    paramString1 = new ReadinjoyAdHippyFragment();
    paramString1.setArguments(localBundle);
    return paramString1;
  }
  
  private HippyMap a(String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("url", paramString);
    return localHippyMap;
  }
  
  private void a(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    paramViewGroup = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("param"));
        this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.initHippy(this.jdField_a_of_type_AndroidViewViewGroup, paramBundle, false, new tsc(this));
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle = paramViewGroup;
        continue;
      }
      paramBundle = paramViewGroup;
    }
  }
  
  private void b()
  {
    String str = getActivity().getIntent().getStringExtra("url");
    if (!TextUtils.isEmpty(str)) {
      this.b = str;
    }
  }
  
  private void b(int paramInt)
  {
    try
    {
      if ((this.c != null) && (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine != null) && (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.getHippyEngine() != null) && (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager() != null))
      {
        if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class) == null) {
          return;
        }
        HippyMap localHippyMap = new HippyMap();
        localHippyMap.pushString("url", this.c);
        localHippyMap.pushInt("type", paramInt);
        ((EventDispatcher)this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("onActive", localHippyMap);
        QLog.e("ReadinjoyAdMiniGameFragment", 2, "send hippy url :" + this.c);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "send hippy event error:" + localException.getMessage());
    }
  }
  
  private void b(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    if ((!TextUtils.isEmpty(this.b)) && (this.b.contains("v_bundleName")))
    {
      String str2 = Uri.parse(this.b).getQueryParameter("v_bundleName");
      String str3 = Uri.parse(this.b).getQueryParameter("component");
      String str1 = this.b;
      if (!TextUtils.isEmpty(this.d)) {
        str1 = this.b + "&h5GameSource=" + this.d;
      }
      int i = HippyQQEngine.getModuleOnlineConfig(str2);
      if ((!TextUtils.isEmpty(str2)) && (i == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadinjoyAdMiniGameFragment", 2, "Hippy: url=" + str1);
        }
        if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine == null)
        {
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = new tsr(this, str2, str1);
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setJsBundleType("react");
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setPropsMap(a(str1));
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setComponentName(str3);
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setViewCreator(new tss());
        }
        a(paramBundle, paramViewGroup);
        return;
      }
      c();
      return;
    }
    c();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup == null) {
      return;
    }
    QLog.d("ReadinjoyAdMiniGameFragment", 2, "Hippy: initHippy error initViola ui");
    this.jdField_a_of_type_Thu = new thu(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = new ViolaBaseView(getActivity());
    ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380865)).addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    if (this.jdField_a_of_type_Thu.a()) {
      this.jdField_a_of_type_Thu.d();
    }
    d();
    this.jdField_a_of_type_Thu.a(this.jdField_a_of_type_AndroidViewViewGroup, new tsa(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setListener(new tsb(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setPageStartTime(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(this.b, this, new tpa(this.b, new JSONObject(), tho.a(this.b), 1, null));
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "reload viola Page mChannelName :" + this.jdField_a_of_type_JavaLangString + "; mChannelId :" + this.jdField_a_of_type_Int);
    }
    d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(new tsd(this));
  }
  
  public int a()
  {
    return 41708;
  }
  
  public void a()
  {
    if (BaseActivity.sTopActivity == null) {}
    for (;;)
    {
      return;
      try
      {
        Intent localIntent = BaseActivity.sTopActivity.getIntent();
        if (localIntent != null)
        {
          String str = localIntent.getStringExtra("key_channel_jump_scheme");
          if ((!TextUtils.isEmpty(str)) && (str.contains("h5GameSource")))
          {
            this.d = Uri.parse(str).getQueryParameter("h5GameSource");
            if (this.d == null) {
              continue;
            }
            this.c = (this.b + "&h5GameSource=" + this.d);
            localIntent.removeExtra("key_channel_jump_scheme");
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadinjoyAdMiniGameFragment", 2, "get hippy source error:" + localException.getMessage());
        return;
      }
    }
    this.c = (this.b + "&h5GameSource=" + "func_tab");
  }
  
  public void a(String paramString)
  {
    QLog.d("ReadinjoyAdMiniGameFragment", 2, "hippy url = " + paramString);
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    a();
    b(2);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) || (super.a());
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return ImmersiveUtils.getStatusBarHeight(getActivity());
    }
    return super.b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558462, paramViewGroup, false));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373643));
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(null);
    }
    b();
    b(getArguments(), paramViewGroup);
    d();
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine != null)
    {
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.onDestroy();
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = null;
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityDestroy();
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityPause();
      if (bool) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(false);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityResume();
      if ((bool) && (ReadinjoyTabFrame.d_()) && (c())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(true);
      }
    }
    b(1);
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityStop();
      if (bool) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment
 * JD-Core Version:    0.7.0.1
 */