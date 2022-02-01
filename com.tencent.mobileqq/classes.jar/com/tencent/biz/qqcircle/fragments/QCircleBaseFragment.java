package com.tencent.biz.qqcircle.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePopupWindowHelper;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.richframework.part.ReportBean;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.QCircleThemeUtil;
import com.tencent.biz.qqcircle.widgets.QCircleInteractiveLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.qcircle.api.event.HostActivityResultEvent;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.superplayer.api.ISPBandwidthPredictor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper.OnThemeUpdateListener;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReportHelper.LaunchParam;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class QCircleBaseFragment
  extends BasePartFragment
  implements ReportBean<QCircleReportBean>, SimpleEventReceiver, QCircleSkinHelper.OnThemeUpdateListener
{
  public static final ISPBandwidthPredictor b = SuperPlayerFactory.createBandwidthPredictor(HostUIHelper.getInstance().getHostApplicationContext());
  protected QCircleReportBean a;
  private QCircleInteractiveLayout c;
  private Runnable d = new QCircleBaseFragment.1(this);
  
  private View u()
  {
    if (this.c == null) {
      this.c = new QCircleInteractiveLayout(getContext());
    }
    this.c.addView(this.D);
    return this.c;
  }
  
  private void w()
  {
    Object localObject = HostUIHelper.getInstance().getHostApplicationContext();
    if (localObject == null) {
      return;
    }
    localObject = (InputMethodManager)((Context)localObject).getSystemService("input_method");
    if (localObject == null) {
      return;
    }
    try
    {
      Field localField = localObject.getClass().getDeclaredField("mLastSrvView");
      if (!localField.isAccessible()) {
        localField.setAccessible(true);
      }
      localField.set(localObject, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.w("QCircleBaseFragment", "[onDestroy]", localThrowable);
    }
  }
  
  public abstract int a();
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->doOnCreateView");
    QLog.d(str, 1, localStringBuilder.toString());
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    h();
  }
  
  public void a(View paramView)
  {
    QCircleInteractiveLayout localQCircleInteractiveLayout = this.c;
    if (localQCircleInteractiveLayout != null)
    {
      localQCircleInteractiveLayout.setExcludeInteractiveView(paramView);
      return;
    }
    QLog.e("QCircleBaseFragment", 1, "setExcludeInteractiveView  mInteractiveLayout == null");
  }
  
  public void a(QCircleReportBean paramQCircleReportBean)
  {
    this.a = QCircleReportBean.setReportBean(b(), paramQCircleReportBean);
  }
  
  public abstract String b();
  
  protected Map<String, Object> e()
  {
    return null;
  }
  
  protected String f()
  {
    return "";
  }
  
  public boolean g()
  {
    QCircleInteractiveLayout localQCircleInteractiveLayout = this.c;
    if (localQCircleInteractiveLayout != null) {
      return localQCircleInteractiveLayout.a();
    }
    return false;
  }
  
  @CallSuper
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(HostActivityResultEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    Object localObject;
    if (this.D == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportDaTongRegister  mContentView == null , subPage: ");
      ((StringBuilder)localObject).append(b());
      QLog.i("QCircleBaseFragment", 1, ((StringBuilder)localObject).toString());
      return;
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    if (!TextUtils.isEmpty(f())) {
      localObject = f();
    } else {
      localObject = "small_world_base";
    }
    VideoReport.setPageId(this.D, (String)localObject);
    VideoReport.setPageParams(this.D, new QCircleDTParamBuilder().buildPageParams(b(), e()));
    WinkDatongCurrentParams.params.put("xsj_camera_clck_ref_pgid", localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportDaTongRegister  subPage: ");
    localStringBuilder.append(b());
    localStringBuilder.append(", pageId: ");
    localStringBuilder.append((String)localObject);
    QLog.i("QCircleBaseFragment", 1, localStringBuilder.toString());
  }
  
  public void i()
  {
    if (this.D == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dtPageLogicDestroy  mContentView == null , subPage: ");
      localStringBuilder.append(b());
      QLog.i("QCircleBaseFragment", 1, localStringBuilder.toString());
      return;
    }
    VideoReport.pageLogicDestroy(this.D);
  }
  
  protected int j()
  {
    return QCircleSkinHelper.getInstance().getColor(2131167059);
  }
  
  public QCircleInitBean k()
  {
    if ((getActivity().getIntent() != null) && (getActivity().getIntent().hasExtra("key_bundle_common_init_bean"))) {
      return (QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    }
    return null;
  }
  
  protected void l()
  {
    boolean bool = QCircleReportHelper.getInstance().isPageStackEmpty();
    QCircleInitBean localQCircleInitBean = null;
    if (bool)
    {
      localObject = getActivity();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((FragmentActivity)localObject).getIntent();
      }
      if (localObject != null)
      {
        localObject = ((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
        break label52;
      }
    }
    Object localObject = null;
    label52:
    if ((localObject instanceof QCircleInitBean)) {
      localQCircleInitBean = (QCircleInitBean)localObject;
    }
    if (localQCircleInitBean != null) {
      QCircleReportHelper.getInstance().setLaunchParms(QCircleReportHelper.LaunchParam.wrap(localQCircleInitBean.getLaunchFrom(), localQCircleInitBean.getLaunchId(), localQCircleInitBean.getUin(), a(), localQCircleInitBean.getSchemeAttrs()));
    }
    QCircleReportHelper.getInstance().pushPageScene(a());
  }
  
  public void m()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onBackPressed");
    QLog.d(str, 1, localStringBuilder.toString());
  }
  
  public QCircleReportBean n()
  {
    if (this.a == null) {
      this.a = new QCircleReportBean();
    }
    o();
    return this.a.setPageId(a());
  }
  
  protected void o()
  {
    if (getActivity() == null) {
      return;
    }
    Object localObject = getActivity().getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("key_bundle_common_init_bean")))
    {
      localObject = (QCircleInitBean)((Intent)localObject).getSerializableExtra("key_bundle_common_init_bean");
      if ((localObject != null) && (((QCircleInitBean)localObject).getFromReportBean() != null))
      {
        QCircleReportBean localQCircleReportBean = this.a;
        if (localQCircleReportBean != null) {
          localQCircleReportBean.assembleFromReportData(((QCircleInitBean)localObject).getFromReportBean());
        }
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if ((getActivity() != null) && (getActivity().getIntent() != null) && (getActivity().getIntent().getLongExtra("key_bundle_open_page_time", -1L) != -1L) && (getActivity().getWindow() != null) && (getActivity().getWindow().getDecorView() != null)) {
      getActivity().getWindow().getDecorView().post(this.d);
    }
    QCircleSkinHelper.getInstance().registerOnThemeUpdateListener(this);
  }
  
  public void onAttach(Activity paramActivity)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onAttach");
    QLog.d(str, 1, localStringBuilder.toString());
    l();
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.D = paramLayoutInflater.inflate(c(), paramViewGroup, false);
    this.D.setTag(E, r());
    View localView;
    if ((QCircleConfigHelper.aj()) && (this.D != null)) {
      localView = u();
    } else {
      localView = this.D;
    }
    a(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, localView);
    return localView;
  }
  
  public void onDestroy()
  {
    Object localObject1 = b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(b());
    ((StringBuilder)localObject2).append("->onDestroy");
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    super.onDestroy();
    localObject1 = ((QCirclePartManager)p()).a;
    localObject2 = ((HashMap)localObject1).keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append((String)((HashMap)localObject1).get(str));
      QLog.d("PartInitLog", 4, ((StringBuilder)localObject3).toString());
      localObject3 = new ArrayList();
      ((List)localObject3).add(QCircleReportHelper.newEntry("refer", str));
      ((List)localObject3).add(QCircleReportHelper.newEntry("attach_info", (String)((HashMap)localObject1).get(str)));
      QCircleQualityReporter.reportQualityEvent("key_part_lifecycle_event", (List)localObject3, true);
    }
    if ((getActivity() != null) && (getActivity().getWindow() != null) && (getActivity().getWindow().getDecorView() != null)) {
      getActivity().getWindow().getDecorView().removeCallbacks(this.d);
    }
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    QCirclePopupWindowHelper.a().c();
    QCircleSkinHelper.getInstance().unregisterOnThemeUpdateListener(this);
    w();
  }
  
  public void onDetach()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onDetach");
    QLog.d(str, 1, localStringBuilder.toString());
    QCircleReportHelper.getInstance().popPageScene(a());
    super.onDetach();
  }
  
  public void onPause()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onPause");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onPause();
    if (getActivity() != null) {
      b.stop(getActivity());
    }
  }
  
  @CallSuper
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof HostActivityResultEvent))
    {
      paramSimpleBaseEvent = (HostActivityResultEvent)paramSimpleBaseEvent;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(hashCode());
      localStringBuilder.append(": onActivityResult receive event, currentHashCode:");
      localStringBuilder.append(hashCode());
      localStringBuilder.append(",hostHashCode:");
      localStringBuilder.append(getActivity().getBaseContext().hashCode());
      localStringBuilder.append(", shadowHashCode:");
      localStringBuilder.append(paramSimpleBaseEvent.getShadowTopContextHashCode());
      QLog.i("QCircleBaseFragment", 1, localStringBuilder.toString());
      onActivityResult(paramSimpleBaseEvent.getRequestCode(), paramSimpleBaseEvent.getResultCode(), paramSimpleBaseEvent.getIntent());
    }
  }
  
  public void onResume()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onResume");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onResume();
    if (getActivity() != null)
    {
      QCirclePluginGlobalInfo.a(Integer.valueOf(getActivity().hashCode()));
      b.start(getActivity());
    }
  }
  
  public void onStart()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onStart");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onStart();
  }
  
  public void onStop()
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->onStop");
    QLog.d(str, 1, localStringBuilder.toString());
    super.onStop();
  }
  
  public void onThemeUpdate()
  {
    if (v())
    {
      QCircleThemeUtil.a(getActivity(), QCircleSkinHelper.getInstance().getColor(2131167059));
      ImmersiveUtils.a(QCircleCommonUtil.isInNightMode() ^ true, getActivity().getWindow());
    }
  }
  
  public PartManager p()
  {
    if (this.C == null) {
      this.C = new QCirclePartManager(this, getView());
    }
    return this.C;
  }
  
  protected boolean q()
  {
    return QCircleCommonUtil.isInNightMode() ^ true;
  }
  
  protected Object r()
  {
    QCircleReportBean localQCircleReportBean = new QCircleReportBean(a());
    localQCircleReportBean.setDtPageId(f());
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      if (!getActivity().getIntent().hasExtra("key_bundle_common_init_bean")) {
        return localQCircleReportBean;
      }
      QCircleInitBean localQCircleInitBean = (QCircleInitBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (localQCircleInitBean.getFromReportBean() == null) {
        return localQCircleReportBean;
      }
      localQCircleReportBean.setFromPageId(localQCircleInitBean.getFromReportBean().getPageId());
      localQCircleReportBean.setDtFromPageId(localQCircleInitBean.getFromReportBean().getDtPageId());
    }
    return localQCircleReportBean;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    String str = b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append("->setUserVisibleHint:");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 1, localStringBuilder.toString());
    super.setUserVisibleHint(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
 * JD-Core Version:    0.7.0.1
 */