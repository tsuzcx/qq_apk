package com.tencent.biz.qqcircle.fragments.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCircleGpsHelper;
import com.tencent.biz.qqcircle.QCircleGpsHelper.IGetGpsInfoListener;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.adapter.QCircleBaseFeedBlock;
import com.tencent.biz.qqcircle.adapter.QCircleMessageNoticeBubbleBlock;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart;
import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.qqcircle.events.QCircleMessageNoticeEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCirclePermissionUtil;
import com.tencent.biz.qqcircle.viewmodels.QCircleAbsTabFeedViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabView;
import com.tencent.biz.qqcircle.widgets.QCircleNearbyTabStatusView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StGPSV2;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionCallback;

public class QCircleFolderNearbyTabFragment
  extends QCircleBaseTabFragment
  implements QCircleGpsHelper.IGetGpsInfoListener
{
  public static String B = "QCircleFolderNearbyTabFragment";
  private QCircleFolderTabView F;
  private boolean G;
  private int H = 0;
  private boolean I;
  private final QQPermissionCallback J = new QCircleFolderNearbyTabFragment.1(this);
  
  public QCircleFolderNearbyTabFragment(int paramInt)
  {
    super(paramInt);
  }
  
  private void ad()
  {
    this.F = t();
    if (this.F != null)
    {
      boolean bool = QCirclePluginConfig.a().E();
      if (bool) {
        this.F.f();
      }
      String str = B;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkNeedShowNewTips result:");
      localStringBuilder.append(bool);
      QLog.d(str, 1, localStringBuilder.toString());
      return;
    }
    getMainHandler().postDelayed(new QCircleFolderNearbyTabFragment.2(this), 100L);
  }
  
  private void ae()
  {
    if (this.p != null) {
      this.p.c();
    }
    X();
    QCircleGpsHelper.a().a(this);
    QLog.d(B, 1, "getLocationAndFetchData");
  }
  
  private boolean aj()
  {
    if (!QCircleGpsHelper.a().d())
    {
      ak();
      L();
      if (this.m != null) {
        this.m.notifyLoadingComplete(true);
      }
      return true;
    }
    return false;
  }
  
  private void ak()
  {
    if (QCircleGpsHelper.a().b())
    {
      ae();
      return;
    }
    if (bg_()) {
      am();
    }
    an();
  }
  
  private void al()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.I = false;
      String str;
      StringBuilder localStringBuilder;
      if (QCircleHostGlobalInfo.isCurrentTabActive())
      {
        this.I = HostUIHelper.getInstance().isDenyNotAsk();
        str = B;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("qcircle tab requestGetGpsPermission denyNotAsk:");
        localStringBuilder.append(this.I);
        QLog.d(str, 1, localStringBuilder.toString());
        HostUIHelper.getInstance().requestPermissions(this.J);
        return;
      }
      if (getActivity() != null)
      {
        this.I = (getActivity().shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION") ^ true);
        str = B;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestGetGpsPermission denyNotAsk:");
        localStringBuilder.append(this.I);
        QLog.d(str, 1, localStringBuilder.toString());
        QCirclePermissionUtil.a(getActivity(), this.J, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      }
    }
  }
  
  private void am()
  {
    QLog.d(B, 1, "showGetPermissionDialog");
    QCircleCustomDialog localQCircleCustomDialog = QCircleCustomDialog.a(getContext());
    localQCircleCustomDialog.a(null);
    localQCircleCustomDialog.a(QCircleConfigHelper.ac());
    localQCircleCustomDialog.a(HardCodeUtil.a(2131895747), new QCircleFolderNearbyTabFragment.6(this));
    localQCircleCustomDialog.b(HardCodeUtil.a(2131895749), new QCircleFolderNearbyTabFragment.7(this));
    localQCircleCustomDialog.setCanceledOnTouchOutside(false);
    localQCircleCustomDialog.show();
  }
  
  private void an()
  {
    QLog.d(B, 1, "showNoPermissionView");
    L();
    if ((this.p != null) && ((this.p instanceof QCircleNearbyTabStatusView))) {
      ((QCircleNearbyTabStatusView)this.p).a(new QCircleFolderNearbyTabFragment.8(this));
    }
  }
  
  private void ao()
  {
    QLog.d(B, 1, "showNoGpsInfoView");
    if ((this.p != null) && ((this.p instanceof QCircleNearbyTabStatusView))) {
      ((QCircleNearbyTabStatusView)this.p).b(new QCircleFolderNearbyTabFragment.9(this));
    }
  }
  
  private void ap()
  {
    QLog.d(B, 1, "jumpSystemSettingPage");
    if (QCircleHostGlobalInfo.isCurrentTabActive())
    {
      HostUIHelper.getInstance().jumpSystemSettingPage();
      this.G = true;
      return;
    }
    if (getActivity() != null)
    {
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", getActivity().getPackageName(), null));
      getActivity().startActivity(localIntent);
      this.G = true;
    }
  }
  
  protected int A()
  {
    return 2;
  }
  
  protected List<MultiViewBlock> B()
  {
    ArrayList localArrayList = new ArrayList();
    this.x = new QCircleMessageNoticeBubbleBlock(new Bundle());
    this.x.a(this.t);
    this.x.a(n());
    localArrayList.add(this.x);
    return localArrayList;
  }
  
  public void F()
  {
    super.F();
  }
  
  public String N()
  {
    return f;
  }
  
  public void O() {}
  
  protected void T()
  {
    super.T();
    ad();
  }
  
  protected void Z()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      Object localObject = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      int i = ((QCircleFolderBean)localObject).getQQCircleUnreadRedNum();
      boolean bool2 = false;
      boolean bool1;
      if (i > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.t = bool1;
      if (this.t)
      {
        bool1 = bool2;
        if (((QCircleFolderBean)localObject).getQQCircleUnreadRedNum() > EeveeRedpointUtil.getFolderMessageNoticeBubbleLastExposeNum()) {
          bool1 = true;
        }
        this.u = bool1;
      }
      this.A = ((QCircleFolderBean)localObject).getRedDotTransInfo();
      this.s = (this.u ^ true);
      localObject = B;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableMemCache:");
      localStringBuilder.append(this.s);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public int a()
  {
    return 91;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (!QCircleGpsHelper.a().b()) {
      am();
    }
    QCircleFolderTabView localQCircleFolderTabView = this.F;
    if (localQCircleFolderTabView != null) {
      localQCircleFolderTabView.g();
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(1).setExt2(String.valueOf(this.H)));
    QCirclePluginConfig.a().F();
  }
  
  public void a(FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    QLog.d(B, 1, "onGpsInfoSuccess");
    QCirclePeriodCollect.record(String.valueOf(5), "get_nearby_gpsinfo");
    W();
  }
  
  public String b()
  {
    return B;
  }
  
  protected void b(boolean paramBoolean)
  {
    S();
    T();
    if (aj())
    {
      QLog.d(B, 1, "refreshData not has gps info yet");
      return;
    }
    if (this.n != null) {
      this.n.a(paramBoolean, this.y, R());
    }
    QLog.d(B, 1, "refreshData direct");
  }
  
  public void bj_()
  {
    QLog.e(B, 1, "onGpsInfoError");
    ao();
  }
  
  protected void d(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    super.d(paramUIStateData);
    this.H = 0;
  }
  
  protected String f()
  {
    return "pg_xsj_nearby_page";
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(QCircleLazyLoadTabEvent.class);
    localArrayList.add(QCircleMessageNoticeEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QCircleLazyLoadTabEvent))
    {
      G();
      return;
    }
    if ((paramSimpleBaseEvent instanceof QCircleMessageNoticeEvent)) {
      a(((QCircleMessageNoticeEvent)paramSimpleBaseEvent).mMessageNoticeInfo);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.G) && (QCircleGpsHelper.a().b()))
    {
      ae();
      this.G = false;
      QLog.d(B, 1, "refresh data after location permission got");
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
  }
  
  protected void w()
  {
    QCircleNearbyTabStatusView localQCircleNearbyTabStatusView = new QCircleNearbyTabStatusView(getContext());
    localQCircleNearbyTabStatusView.setEmptyClickListener(new QCircleFolderNearbyTabFragment.3(this));
    MutableLiveData localMutableLiveData = localQCircleNearbyTabStatusView.getTabStatusObserver();
    if (localMutableLiveData != null) {
      localMutableLiveData.observe(this, new QCircleFolderNearbyTabFragment.4(this));
    }
    this.p = localQCircleNearbyTabStatusView;
    this.p.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
    this.p.setOnRetryClickListener(new QCircleFolderNearbyTabFragment.5(this));
    this.j.be_().setStatusViewInterface(this.p);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.main.QCircleFolderNearbyTabFragment
 * JD-Core Version:    0.7.0.1
 */