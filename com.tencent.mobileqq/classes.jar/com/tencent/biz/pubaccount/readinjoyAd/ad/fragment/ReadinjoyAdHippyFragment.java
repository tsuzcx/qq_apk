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
import com.tencent.mobileqq.kandian.biz.common.api.IRIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaCreactPageObject;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseViewFactory;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegateFactory;
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
  protected int a;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public HippyQQEngine a;
  protected IViolaBaseView a;
  private IViolaUiDelegate jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaUiDelegate;
  protected String a;
  private String b;
  private String c;
  private String d = "func_tab";
  private boolean e = false;
  
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
  
  private String a(String paramString)
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
      paramBundle = (ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380915);
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.initHippyInContainer(paramBundle, paramViewGroup, false, new ReadinjoyAdHippyFragment.3(this));
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
  
  private void b(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    if ((!TextUtils.isEmpty(this.b)) && (this.b.contains("v_bundleName")))
    {
      String str1 = Uri.parse(this.b).getQueryParameter("v_bundleName");
      String str2 = Uri.parse(this.b).getQueryParameter("component");
      Object localObject = this.b;
      if (!TextUtils.isEmpty(this.d))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("&h5GameSource=");
        ((StringBuilder)localObject).append(this.d);
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
        if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine == null)
        {
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = new TkdAdHippyEngine(this, str1, (String)localObject);
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setJsBundleType("react");
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setPropsMap(a((String)localObject));
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setComponentName(str2);
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setViewCreator(new TkdAdHippyViewCreator());
        }
        a(paramBundle, paramViewGroup);
        return;
      }
      j();
      return;
    }
    j();
  }
  
  private void c(int paramInt)
  {
    try
    {
      if ((this.c != null) && (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine != null) && (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.getHippyEngine() != null) && (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager() != null))
      {
        if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class) == null) {
          return;
        }
        Object localObject = new HippyMap();
        ((HippyMap)localObject).pushString("url", this.c);
        ((HippyMap)localObject).pushInt("type", paramInt);
        ((EventDispatcher)this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("onActive", localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("send hippy url :");
        ((StringBuilder)localObject).append(this.c);
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
  
  private void i()
  {
    String str = a().getIntent().getStringExtra("url");
    if (!TextUtils.isEmpty(str)) {
      this.b = str;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      if (a() == null) {
        return;
      }
      QLog.d("ReadinjoyAdMiniGameFragment", 2, "Hippy: initHippy error initViola ui");
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaUiDelegate = ((IViolaUiDelegateFactory)QRoute.api(IViolaUiDelegateFactory.class)).create(this);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView = ((IViolaBaseViewFactory)QRoute.api(IViolaBaseViewFactory.class)).createViolaBaseView(a());
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380915)).addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView.a());
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaUiDelegate.b()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaUiDelegate.a();
      }
      k();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaUiDelegate.a(this.jdField_a_of_type_AndroidViewViewGroup, new ReadinjoyAdHippyFragment.1(this));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView.setListener(new ReadinjoyAdHippyFragment.2(this));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView.setPageStartTime(System.currentTimeMillis());
      IViolaBaseView localIViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView;
      String str = this.b;
      localIViolaBaseView.a(str, this, new IViolaBaseView.ViolaCreactPageObject(str, new JSONObject(), a(this.b), 1, null));
    }
  }
  
  private void k()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() == 8)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
  }
  
  private void l()
  {
    LinearLayout localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localLinearLayout != null) && (localLinearLayout.getVisibility() == 0)) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reload viola Page mChannelName :");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("; mChannelId :");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      QLog.d("ReadinjoyAdMiniGameFragment", 2, localStringBuilder.toString());
    }
    k();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView.a(new ReadinjoyAdHippyFragment.4(this));
  }
  
  public int a()
  {
    if ((this.e) && (a() != null)) {
      return ImmersiveUtils.getStatusBarHeight(a());
    }
    return super.a();
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
        this.d = Uri.parse((String)localObject2).getQueryParameter("h5GameSource");
        if (this.d != null)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.b);
          ((StringBuilder)localObject2).append("&h5GameSource=");
          ((StringBuilder)localObject2).append(this.d);
          this.c = ((StringBuilder)localObject2).toString();
          ((Intent)localObject1).removeExtra("key_channel_jump_scheme");
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append("&h5GameSource=");
        ((StringBuilder)localObject1).append("func_tab");
        this.c = ((StringBuilder)localObject1).toString();
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
    this.b = paramString;
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    a();
    c(2);
  }
  
  public boolean a()
  {
    return (this.e) || (super.a());
  }
  
  public int b()
  {
    return 41708;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559129, paramViewGroup, false));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131373730));
    paramLayoutInflater = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setOnClickListener(null);
    }
    i();
    b(getArguments(), paramViewGroup);
    k();
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    HippyQQEngine localHippyQQEngine = this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine;
    if (localHippyQQEngine != null)
    {
      localHippyQQEngine.onDestroy();
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = null;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView.onActivityDestroy();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onPause()
  {
    super.onPause();
    IViolaBaseView localIViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView;
    if (localIViolaBaseView != null)
    {
      boolean bool = localIViolaBaseView.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView.onActivityPause();
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView.a(false);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    IViolaBaseView localIViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView;
    if (localIViolaBaseView != null)
    {
      boolean bool = localIViolaBaseView.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView.onActivityResume();
      if ((bool) && (((IRIJXTabFrameUtils)QRoute.api(IRIJXTabFrameUtils.class)).isNowInKanDianTab()) && (b())) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView.a(true);
      }
    }
    c(1);
  }
  
  public void onStart()
  {
    super.onStart();
    IViolaBaseView localIViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView;
    if (localIViolaBaseView != null) {
      localIViolaBaseView.onActivityStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    IViolaBaseView localIViolaBaseView = this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView;
    if (localIViolaBaseView != null)
    {
      boolean bool = localIViolaBaseView.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView.onActivityStop();
      if (bool) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView.a(false);
      }
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment
 * JD-Core Version:    0.7.0.1
 */