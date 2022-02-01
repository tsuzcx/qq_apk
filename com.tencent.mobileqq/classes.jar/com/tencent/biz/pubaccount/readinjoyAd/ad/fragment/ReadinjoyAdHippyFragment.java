package com.tencent.biz.pubaccount.readinjoyAd.ad.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdHippyEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdHippyViewCreator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.utils.HippyCommonUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaCreactPageObject;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseViewFactory;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegateFactory;
import com.tencent.mobileqq.kandian.biz.xtab.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadinjoyAdHippyFragment
  extends ReadInJoyBaseFragment
{
  public HippyQQEngine a;
  protected int b = -1;
  protected String c = "hippyGame";
  protected IViolaBaseView d;
  private ViewGroup m;
  private LinearLayout n;
  private String o;
  private String p;
  private String q = "func_tab";
  private IViolaUiDelegate r;
  private boolean s = false;
  
  private void A()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reload viola Page mChannelName :");
      localStringBuilder.append(this.c);
      localStringBuilder.append("; mChannelId :");
      localStringBuilder.append(this.b);
      QLog.d("ReadinjoyAdMiniGameFragment", 2, localStringBuilder.toString());
    }
    y();
    this.d.a(new ReadinjoyAdHippyFragment.4(this));
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
  
  private void a(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject = new JSONObject();
    paramViewGroup = localJSONObject;
    if (paramBundle != null)
    {
      paramViewGroup = localJSONObject;
      if (!paramBundle.containsKey("param")) {}
    }
    try
    {
      paramViewGroup = new JSONObject(paramBundle.getString("param"));
      paramBundle = (ViewGroup)this.m.findViewById(2131449905);
      this.a.initHippyInContainer(paramBundle, paramViewGroup, false, new ReadinjoyAdHippyFragment.3(this));
      return;
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramViewGroup = localJSONObject;
      }
    }
  }
  
  private String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = Uri.parse(paramString).getQueryParameter("_ckey");
    if (!TextUtils.isEmpty(paramString))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if (localAppRuntime == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("viola_cache_file_");
      localStringBuilder.append(paramString);
      localStringBuilder.append("_");
      localStringBuilder.append(localAppRuntime.getAccount());
      paramString = FileUtils.readObject(localStringBuilder.toString());
      if ((paramString instanceof String)) {
        return (String)paramString;
      }
    }
    return null;
  }
  
  private void b(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    if ((!TextUtils.isEmpty(this.o)) && (this.o.contains("v_bundleName")))
    {
      String str1 = Uri.parse(this.o).getQueryParameter("v_bundleName");
      String str2 = Uri.parse(this.o).getQueryParameter("component");
      Object localObject = this.o;
      if (!TextUtils.isEmpty(this.q))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.o);
        ((StringBuilder)localObject).append("&h5GameSource=");
        ((StringBuilder)localObject).append(this.q);
        localObject = ((StringBuilder)localObject).toString();
      }
      int i = HippyCommonUtils.getModuleOnlineConfig(str1);
      if ((!TextUtils.isEmpty(str1)) && (i == 1))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Hippy: url=");
          localStringBuilder.append((String)localObject);
          QLog.d("ReadinjoyAdMiniGameFragment", 2, localStringBuilder.toString());
        }
        if (this.a == null)
        {
          this.a = new TkdAdHippyEngine(this, str1, (String)localObject);
          this.a.setJsBundleType("react");
          this.a.setPropsMap(c((String)localObject));
          this.a.setComponentName(str2);
          this.a.setViewCreator(new TkdAdHippyViewCreator());
        }
        a(paramBundle, paramViewGroup);
        return;
      }
      x();
      return;
    }
    x();
  }
  
  private HippyMap c(String paramString)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushString("url", paramString);
    return localHippyMap;
  }
  
  private void d(int paramInt)
  {
    try
    {
      if ((this.p != null) && (this.a != null) && (this.a.getHippyEngine() != null) && (this.a.getHippyEngine().getEngineContext().getModuleManager() != null))
      {
        if (this.a.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class) == null) {
          return;
        }
        Object localObject = new HippyMap();
        ((HippyMap)localObject).pushString("url", this.p);
        ((HippyMap)localObject).pushInt("type", paramInt);
        ((EventDispatcher)this.a.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("onActive", localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("send hippy url :");
        ((StringBuilder)localObject).append(this.p);
        QLog.e("ReadinjoyAdMiniGameFragment", 2, ((StringBuilder)localObject).toString());
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send hippy event error:");
      localStringBuilder.append(localException.getMessage());
      QLog.d("ReadinjoyAdMiniGameFragment", 2, localStringBuilder.toString());
    }
  }
  
  private void w()
  {
    String str = v().getIntent().getStringExtra("url");
    if (!TextUtils.isEmpty(str)) {
      this.o = str;
    }
  }
  
  private void x()
  {
    if (this.m != null)
    {
      if (v() == null) {
        return;
      }
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "Hippy: initHippy error initViola ui");
      this.r = ((IViolaUiDelegateFactory)QRoute.api(IViolaUiDelegateFactory.class)).create(this);
      this.d = ((IViolaBaseViewFactory)QRoute.api(IViolaBaseViewFactory.class)).createViolaBaseView(v());
      ((ViewGroup)this.m.findViewById(2131449905)).addView(this.d.getView());
      if (this.r.e()) {
        this.r.a();
      }
      y();
      this.r.a(this.m, new ReadinjoyAdHippyFragment.1(this));
      this.d.setListener(new ReadinjoyAdHippyFragment.2(this));
      this.d.setPageStartTime(System.currentTimeMillis());
      IViolaBaseView localIViolaBaseView = this.d;
      String str = this.o;
      localIViolaBaseView.a(str, this, new IViolaBaseView.ViolaCreactPageObject(str, new JSONObject(), b(this.o), 1, null));
    }
  }
  
  private void y()
  {
    LinearLayout localLinearLayout = this.n;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() == 8)) {
      this.n.setVisibility(0);
    }
  }
  
  private void z()
  {
    LinearLayout localLinearLayout = this.n;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() == 0)) {
      this.n.setVisibility(8);
    }
  }
  
  public void a()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    try
    {
      Object localObject1 = BaseActivity.sTopActivity.getIntent();
      if (localObject1 == null) {
        return;
      }
      localObject2 = ((Intent)localObject1).getStringExtra("key_channel_jump_scheme");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
      if ((!bool) && (((String)localObject2).contains("h5GameSource")))
      {
        this.q = Uri.parse((String)localObject2).getQueryParameter("h5GameSource");
        if (this.q != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.o);
          ((StringBuilder)localObject2).append("&h5GameSource=");
          ((StringBuilder)localObject2).append(this.q);
          this.p = ((StringBuilder)localObject2).toString();
          ((Intent)localObject1).removeExtra("key_channel_jump_scheme");
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.o);
        ((StringBuilder)localObject1).append("&h5GameSource=");
        ((StringBuilder)localObject1).append("func_tab");
        this.p = ((StringBuilder)localObject1).toString();
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get hippy source error:");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.d("ReadinjoyAdMiniGameFragment", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hippy url = ");
    localStringBuilder.append(paramString);
    QLog.d("ReadinjoyAdMiniGameFragment", 2, localStringBuilder.toString());
    this.o = paramString;
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    a();
    d(2);
  }
  
  public int b()
  {
    if ((this.s) && (v() != null)) {
      return ImmersiveUtils.getStatusBarHeight(v());
    }
    return super.b();
  }
  
  public boolean c()
  {
    return (this.s) || (super.c());
  }
  
  public int d()
  {
    return 41708;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.e = LayoutInflater.from(v());
    this.m = ((ViewGroup)this.e.inflate(2131624873, paramViewGroup, false));
    this.n = ((LinearLayout)this.m.findViewById(2131441404));
    paramLayoutInflater = this.n;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setOnClickListener(null);
    }
    w();
    b(getArguments(), paramViewGroup);
    y();
    return this.m;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    HippyQQEngine localHippyQQEngine = this.a;
    if (localHippyQQEngine != null)
    {
      localHippyQQEngine.onDestroy();
      this.a = null;
    }
    try
    {
      if (this.d != null) {
        this.d.onActivityDestroy();
      }
      if (this.m != null) {
        this.m.removeAllViews();
      }
      this.d = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onPause()
  {
    super.onPause();
    IViolaBaseView localIViolaBaseView = this.d;
    if (localIViolaBaseView != null)
    {
      boolean bool = localIViolaBaseView.b();
      this.d.onActivityPause();
      if (bool) {
        this.d.a(false);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    IViolaBaseView localIViolaBaseView = this.d;
    if (localIViolaBaseView != null)
    {
      boolean bool = localIViolaBaseView.b();
      this.d.onActivityResume();
      if ((bool) && (((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isNowInKanDianTab()) && (e())) {
        this.d.a(true);
      }
    }
    d(1);
  }
  
  public void onStart()
  {
    super.onStart();
    IViolaBaseView localIViolaBaseView = this.d;
    if (localIViolaBaseView != null) {
      localIViolaBaseView.onActivityStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    IViolaBaseView localIViolaBaseView = this.d;
    if (localIViolaBaseView != null)
    {
      boolean bool = localIViolaBaseView.b();
      this.d.onActivityStop();
      if (bool) {
        this.d.a(false);
      }
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment
 * JD-Core Version:    0.7.0.1
 */