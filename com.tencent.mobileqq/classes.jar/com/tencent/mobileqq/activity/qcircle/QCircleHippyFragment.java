package com.tencent.mobileqq.activity.qcircle;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QQAppInterface;
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
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
  private long jdField_a_of_type_Long = 0L;
  private QCircleHippyBean jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
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
    localHashMap.put(ViolaUiDelegate.b, Integer.valueOf(1));
    localHashMap.put(ViolaUiDelegate.h, Boolean.valueOf(true));
    localHashMap.put(ViolaUiDelegate.i, Boolean.valueOf(false));
    localHashMap.put(ViolaUiDelegate.v, Boolean.valueOf(false));
    localHashMap.put(ViolaUiDelegate.j, Boolean.valueOf(true));
    return localHashMap;
  }
  
  private JSONObject a()
  {
    if (getActivity() != null)
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
        if ((this.jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean.getPersonalUin()))) {
          localJSONObject.put("host_uin", this.jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean.getPersonalUin());
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean.getTheme()))) {
          localJSONObject.put("theme", this.jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean.getTheme());
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
      return localJSONObject;
    }
    return null;
  }
  
  private void a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("url", this.b);
    QCircleUtils.a().enterBySchemeAction(BaseApplicationImpl.getContext(), "openwebview", localHashMap);
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {}
    do
    {
      return;
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
    } while (Build.VERSION.SDK_INT < 19);
    paramActivity.getWindow().addFlags(67108864);
  }
  
  private void a(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("param"));
        this.mViolaUiDelegate.a(paramViewGroup, new QCircleHippyFragment.1(this));
        this.mHippyQQEngine.initHippy(getContentView(), paramBundle, this.mViolaUiDelegate.b(), new QCircleHippyFragment.2(this));
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle = localJSONObject;
        continue;
      }
      paramBundle = localJSONObject;
    }
  }
  
  private void a(View paramView)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).registerDaTongReport("QCircleHippyFragment", paramView, getActivity());
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
    int j = 2131166270;
    Object localObject = getResources();
    int i;
    boolean bool;
    if (SubscribeUtils.a())
    {
      i = 2131166270;
      paramViewGroup.setBackgroundColor(((Resources)localObject).getColor(i));
      if (SubscribeUtils.a()) {
        break label256;
      }
      bool = true;
      label40:
      ImmersiveUtils.setStatusTextColor(bool, getActivity().getWindow());
      localObject = getActivity();
      Resources localResources = getActivity().getResources();
      if (!SubscribeUtils.a()) {
        break label262;
      }
      i = j;
      label77:
      a((Activity)localObject, localResources.getColor(i));
      this.jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean = ((QCircleHippyBean)paramBundle.getSerializable("key_hippy_bean"));
      if (this.jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean != null)
      {
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean.getModuleName();
        this.b = this.jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean.getDefaultUrl();
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqQcircleApiDataQCircleHippyBean.getStartTime();
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          break label269;
        }
        if (RFLog.isColorLevel()) {
          RFLog.d("QCircleHippyFragment", RFLog.CLR, "Hippy: moduleName=" + this.jdField_a_of_type_JavaLangString);
        }
        if (this.mHippyQQEngine == null) {
          this.mHippyQQEngine = new HippyQQEngine(this, this.jdField_a_of_type_JavaLangString, null);
        }
        this.mHippyQQEngine.setInitData(null, a());
        a(paramBundle, paramViewGroup);
      }
    }
    for (;;)
    {
      this.mViolaUiDelegate.a(a(), paramViewGroup);
      initFPS();
      return;
      i = 2131166269;
      break;
      label256:
      bool = false;
      break label40;
      label262:
      i = 2131166269;
      break label77;
      label269:
      a();
      ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportQualityEvent("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { a("ret_code", "-2"), a("attach_info", "request module name is null!") }), false);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a(paramLayoutInflater);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
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
      if ((!this.jdField_a_of_type_JavaLangString.equals(paramSimpleBaseEvent.mModule)) || (this.mHippyQQEngine == null) || (this.mHippyQQEngine.getHippyEngine() == null)) {}
    }
    do
    {
      try
      {
        paramSimpleBaseEvent = new HippyMap();
        paramSimpleBaseEvent.pushString("result", "call refresh hippy from native");
        ((EventDispatcher)this.mHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("refreshData", paramSimpleBaseEvent);
        RFLog.d("QCircleHippyFragment", RFLog.USR, "notify hippy refresh page data success,module:" + this.jdField_a_of_type_JavaLangString);
        return;
      }
      catch (Exception paramSimpleBaseEvent)
      {
        RFLog.e("QCircleHippyFragment", RFLog.USR, "refresh hippy page fail!exception: " + paramSimpleBaseEvent.getMessage() + ",module:" + this.jdField_a_of_type_JavaLangString);
        return;
      }
      if ((paramSimpleBaseEvent instanceof QCircleOpenRewardAdEvent))
      {
        QCircleUtils.a().openRewardActivity(getActivity(), ((QCircleOpenRewardAdEvent)paramSimpleBaseEvent).mParams);
        return;
      }
    } while ((!(paramSimpleBaseEvent instanceof QCircleRewardAdResultEvent)) || (TextUtils.isEmpty(((QCircleRewardAdResultEvent)paramSimpleBaseEvent).mToast)));
    new Handler(Looper.getMainLooper()).post(new QCircleHippyFragment.3(this, paramSimpleBaseEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleHippyFragment
 * JD-Core Version:    0.7.0.1
 */