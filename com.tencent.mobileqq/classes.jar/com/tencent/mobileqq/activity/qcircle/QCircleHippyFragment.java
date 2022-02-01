package com.tencent.mobileqq.activity.qcircle;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentPresenter;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaUiDelegate;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.mobileqq.qcircle.api.data.QCircleHippyBean;
import com.tencent.mobileqq.qcircle.api.event.QCircleOpenRewardAdEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleRefreshHippyPageEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleRewardAdResultEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QCircleHippyFragment
  extends ViolaFragment
  implements SimpleEventReceiver
{
  private String a;
  private String b;
  private long c = 0L;
  private QCircleHippyBean d;
  
  public static FeedCloudCommon.Entry a(String paramString1, String paramString2)
  {
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    if (paramString1 != null) {
      localEntry.key.set(paramString1);
    }
    if (paramString2 != null) {
      localEntry.value.set(paramString2);
    }
    return localEntry;
  }
  
  private HashMap<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    Boolean localBoolean1 = Boolean.valueOf(true);
    localHashMap.put("title_hide", Integer.valueOf(1));
    localHashMap.put("title_status_color", localBoolean1);
    Boolean localBoolean2 = Boolean.valueOf(false);
    localHashMap.put("title_status_font_color", localBoolean2);
    localHashMap.put("bundle_is_splash_activity", localBoolean2);
    localHashMap.put("title_status_immersive", localBoolean1);
    return localHashMap;
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity = paramActivity.getWindow();
      paramActivity.clearFlags(67108864);
      paramActivity.getDecorView().setSystemUiVisibility(1280);
      paramActivity.addFlags(-2147483648);
      paramActivity.setStatusBarColor(paramInt);
      paramActivity.setNavigationBarColor(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(67108864);
    }
  }
  
  private void a(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = localJSONObject2;
    if (paramBundle != null)
    {
      localJSONObject1 = localJSONObject2;
      if (!paramBundle.containsKey("param")) {}
    }
    try
    {
      localJSONObject1 = new JSONObject(paramBundle.getString("param"));
      this.mPresenter.i().a(paramViewGroup, new QCircleHippyFragment.1(this));
      paramBundle = (ViewGroup)getContentView().findViewById(2131449905);
      this.mHippyQQEngine.initHippyInContainer(paramBundle, localJSONObject1, this.mPresenter.i().d(), new QCircleHippyFragment.2(this));
      return;
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        localJSONObject1 = localJSONObject2;
      }
    }
  }
  
  private void a(View paramView)
  {
    String str;
    if (TextUtils.equals(this.a, "WeZoneTask")) {
      str = "pg_xsj_mission_centre";
    } else if (TextUtils.equals(this.a, "WeZoneGift")) {
      str = "pg_xsj_gift_wall";
    } else {
      str = "small_world_base";
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(paramView, str);
    VideoReport.setPageParams(paramView, ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).buildPageParams("QCircleHippyFragment"));
  }
  
  private JSONObject b()
  {
    if (getQBaseActivity() != null)
    {
      TicketManager localTicketManager = (TicketManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(2);
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("uin", str);
        localJSONObject.put("p_uin", str);
        localJSONObject.put("skey", localTicketManager.getSkey(str));
        localJSONObject.put("p_skey", localTicketManager.getPskey(str, "qzone.qq.com"));
        if ((this.d != null) && (!TextUtils.isEmpty(this.d.getPersonalUin()))) {
          localJSONObject.put("host_uin", this.d.getPersonalUin());
        }
        if ((this.d != null) && (!TextUtils.isEmpty(this.d.getTheme())))
        {
          localJSONObject.put("theme", this.d.getTheme());
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return localJSONObject;
    }
    return null;
  }
  
  private void c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", this.b);
    QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.getContext(), "openwebview", localHashMap);
    if (getQBaseActivity() != null) {
      getQBaseActivity().finish();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleRefreshHippyPageEvent.class);
    localArrayList.add(QCircleOpenRewardAdEvent.class);
    localArrayList.add(QCircleRewardAdResultEvent.class);
    return localArrayList;
  }
  
  public void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    Object localObject = getResources();
    boolean bool = SubscribeUtils.a();
    int j = 2131167018;
    int i;
    if (bool) {
      i = 2131167018;
    } else {
      i = 2131167017;
    }
    paramViewGroup.setBackgroundColor(((Resources)localObject).getColor(i));
    ImmersiveUtils.setStatusTextColor(SubscribeUtils.a() ^ true, getQBaseActivity().getWindow());
    localObject = getQBaseActivity();
    Resources localResources = getQBaseActivity().getResources();
    if (SubscribeUtils.a()) {
      i = j;
    } else {
      i = 2131167017;
    }
    a((Activity)localObject, localResources.getColor(i));
    this.d = ((QCircleHippyBean)paramBundle.getSerializable("key_hippy_bean"));
    localObject = this.d;
    if (localObject != null)
    {
      this.a = ((QCircleHippyBean)localObject).getModuleName();
      this.b = this.d.getDefaultUrl();
      this.c = this.d.getStartTime();
      if (!TextUtils.isEmpty(this.a))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Hippy: moduleName=");
          ((StringBuilder)localObject).append(this.a);
          QLog.d("QCircleHippyFragment", 2, ((StringBuilder)localObject).toString());
        }
        if (this.mHippyQQEngine == null) {
          this.mHippyQQEngine = new HippyQQEngine(this, this.a, null);
        }
        this.mHippyQQEngine.setInitData(null, b());
        a(paramBundle, paramViewGroup);
      }
      else
      {
        c();
        ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { a("ret_code", "-2"), a("attach_info", "request module name is null!") }), false);
      }
      this.mPresenter.i().a(a(), paramViewGroup);
    }
    initFPS();
    a(paramViewGroup);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    super.onDetach();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleRefreshHippyPageEvent))
    {
      paramSimpleBaseEvent = (QCircleRefreshHippyPageEvent)paramSimpleBaseEvent;
      if ((!this.a.equals(paramSimpleBaseEvent.mModule)) || (this.mHippyQQEngine == null) || (this.mHippyQQEngine.getHippyEngine() == null)) {
        return;
      }
      try
      {
        paramSimpleBaseEvent = new HippyMap();
        paramSimpleBaseEvent.pushString("result", "call refresh hippy from native");
        ((EventDispatcher)this.mHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("refreshData", paramSimpleBaseEvent);
        paramSimpleBaseEvent = new StringBuilder();
        paramSimpleBaseEvent.append("notify hippy refresh page data success,module:");
        paramSimpleBaseEvent.append(this.a);
        QLog.d("QCircleHippyFragment", 1, paramSimpleBaseEvent.toString());
        return;
      }
      catch (Exception paramSimpleBaseEvent)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refresh hippy page fail!exception: ");
        localStringBuilder.append(paramSimpleBaseEvent.getMessage());
        localStringBuilder.append(",module:");
        localStringBuilder.append(this.a);
        QLog.e("QCircleHippyFragment", 1, localStringBuilder.toString());
        return;
      }
    }
    if ((paramSimpleBaseEvent instanceof QCircleOpenRewardAdEvent))
    {
      QCircleUtils.a().openRewardActivity(getQBaseActivity(), ((QCircleOpenRewardAdEvent)paramSimpleBaseEvent).mParams);
      return;
    }
    if (((paramSimpleBaseEvent instanceof QCircleRewardAdResultEvent)) && (!TextUtils.isEmpty(((QCircleRewardAdResultEvent)paramSimpleBaseEvent).mToast))) {
      new Handler(Looper.getMainLooper()).post(new QCircleHippyFragment.3(this, paramSimpleBaseEvent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment
 * JD-Core Version:    0.7.0.1
 */