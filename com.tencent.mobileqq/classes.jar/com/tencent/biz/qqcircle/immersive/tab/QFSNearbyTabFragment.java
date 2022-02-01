package com.tencent.biz.qqcircle.immersive.tab;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.QCircleGpsHelper;
import com.tencent.biz.qqcircle.QCircleGpsHelper.IGetGpsInfoListener;
import com.tencent.biz.qqcircle.QCirclePluginConfig;
import com.tencent.biz.qqcircle.adapter.QCircleBaseFeedBlock;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.bizparts.QCircleBaseBlockPart;
import com.tencent.biz.qqcircle.events.QCircleLazyLoadTabEvent;
import com.tencent.biz.qqcircle.events.QCircleMessageNoticeEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCirclePermissionUtil;
import com.tencent.biz.qqcircle.viewmodels.QCircleTabFeedViewModel;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.qqcircle.widgets.QCircleNearbyTabStatusView;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
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

public class QFSNearbyTabFragment
  extends QFSBaseFeedTabFragment
  implements QCircleGpsHelper.IGetGpsInfoListener
{
  public static String x = "QFSNearbyTabFragment";
  private boolean A;
  private final QQPermissionCallback B = new QFSNearbyTabFragment.1(this);
  private boolean y;
  private int z = 0;
  
  public QFSNearbyTabFragment(QCircleTabInfo paramQCircleTabInfo, int paramInt)
  {
    super(paramQCircleTabInfo, paramInt);
  }
  
  private void ab()
  {
    if (this.k != null) {
      this.k.c();
    }
    N();
    QCircleGpsHelper.a().a(this);
    QLog.d(x, 1, "getLocationAndFetchData");
  }
  
  private boolean ac()
  {
    if (!QCircleGpsHelper.a().d())
    {
      ad();
      T();
      if (this.i != null) {
        this.i.notifyLoadingComplete(true);
      }
      return true;
    }
    return false;
  }
  
  private void ad()
  {
    if (QCircleGpsHelper.a().b())
    {
      ab();
      return;
    }
    if (H()) {
      aj();
    }
    ak();
  }
  
  private void ae()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.A = false;
      String str;
      StringBuilder localStringBuilder;
      if (QCircleHostGlobalInfo.isCurrentTabActive())
      {
        this.A = HostUIHelper.getInstance().isDenyNotAsk();
        str = x;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("qcircle tab requestGetGpsPermission denyNotAsk:");
        localStringBuilder.append(this.A);
        QLog.d(str, 1, localStringBuilder.toString());
        HostUIHelper.getInstance().requestPermissions(this.B);
        return;
      }
      if (getActivity() != null)
      {
        this.A = (getActivity().shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION") ^ true);
        str = x;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestGetGpsPermission denyNotAsk:");
        localStringBuilder.append(this.A);
        QLog.d(str, 1, localStringBuilder.toString());
        QCirclePermissionUtil.a(getActivity(), this.B, 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      }
    }
  }
  
  private void aj()
  {
    if ((this.e) && (getContext() != null))
    {
      QLog.d(x, 1, "showGetPermissionDialog");
      localObject = QCircleCustomDialog.a(getContext());
      ((QCircleCustomDialog)localObject).a(null);
      ((QCircleCustomDialog)localObject).a(QCircleConfigHelper.ac());
      ((QCircleCustomDialog)localObject).a(HardCodeUtil.a(2131895747), new QFSNearbyTabFragment.5(this));
      ((QCircleCustomDialog)localObject).b(HardCodeUtil.a(2131895749), new QFSNearbyTabFragment.6(this));
      ((QCircleCustomDialog)localObject).setCanceledOnTouchOutside(false);
      ((QCircleCustomDialog)localObject).show();
      return;
    }
    Object localObject = x;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showGetPermissionDialog error!hasInit:");
    localStringBuilder.append(this.e);
    QLog.e((String)localObject, 1, localStringBuilder.toString());
  }
  
  private void ak()
  {
    T();
    QLog.d(x, 1, "showNoPermissionView");
    if ((this.k != null) && ((this.k instanceof QCircleNearbyTabStatusView))) {
      ((QCircleNearbyTabStatusView)this.k).a(new QFSNearbyTabFragment.7(this));
    }
  }
  
  private void al()
  {
    QLog.d(x, 1, "showNoGpsInfoView");
    if ((this.k != null) && ((this.k instanceof QCircleNearbyTabStatusView))) {
      ((QCircleNearbyTabStatusView)this.k).b(new QFSNearbyTabFragment.8(this));
    }
  }
  
  private void am()
  {
    QLog.d(x, 1, "jumpSystemSettingPage");
    if (QCircleHostGlobalInfo.isCurrentTabActive())
    {
      HostUIHelper.getInstance().jumpSystemSettingPage();
      this.y = true;
      return;
    }
    if (getActivity() != null)
    {
      Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent.setData(Uri.fromParts("package", getActivity().getPackageName(), null));
      getActivity().startActivity(localIntent);
      this.y = true;
    }
  }
  
  public void B()
  {
    super.B();
  }
  
  protected void C()
  {
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      Object localObject = (QCircleFolderBean)getActivity().getIntent().getSerializableExtra("key_bundle_common_init_bean");
      if (localObject == null)
      {
        QLog.i(x, 1, "checkEnablePageMemCache initBean is null");
        return;
      }
      int i = ((QCircleFolderBean)localObject).getQQCircleUnreadRedNum();
      boolean bool = false;
      if (i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (((QCircleFolderBean)localObject).getQQCircleUnreadRedNum() > EeveeRedpointUtil.getFolderMessageNoticeBubbleLastExposeNum()) {
          bool = true;
        }
        this.o = bool;
      }
      this.s = ((QCircleFolderBean)localObject).getRedDotTransInfo();
      this.n = (this.o ^ true);
      localObject = x;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableMemCache:");
      localStringBuilder.append(this.n);
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public String I()
  {
    return QCircleBaseTabFragment.f;
  }
  
  public int a()
  {
    return 591;
  }
  
  public void a(int paramInt)
  {
    if (!QCircleGpsHelper.a().b()) {
      aj();
    }
    super.a(paramInt);
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(94).setSubActionType(1).setExt2(String.valueOf(this.z)));
    QCirclePluginConfig.a().F();
  }
  
  public void a(FeedCloudMeta.StGPSV2 paramStGPSV2)
  {
    QLog.d(x, 1, "onGpsInfoSuccess");
    QCirclePeriodCollect.record(String.valueOf(5), "get_nearby_gpsinfo");
    M();
  }
  
  public String b()
  {
    return x;
  }
  
  protected void b(boolean paramBoolean)
  {
    G();
    K();
    if (ac())
    {
      QLog.d(x, 1, "refreshData not has gps info yet");
      return;
    }
    if (this.j != null) {
      this.j.a(paramBoolean, this.t, F());
    }
    QLog.d(x, 1, "refreshData direct");
  }
  
  public void bj_()
  {
    QLog.e(x, 1, "onGpsInfoError");
    al();
  }
  
  protected int c()
  {
    return 2131627127;
  }
  
  protected void d(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    super.d(paramUIStateData);
    this.z = 0;
  }
  
  protected String f()
  {
    return "pg_xsj_nearby_page";
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList2 = super.getEventClass();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(QCircleLazyLoadTabEvent.class);
    localArrayList1.add(QCircleMessageNoticeEvent.class);
    return localArrayList1;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof QCircleLazyLoadTabEvent)) {
      O();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.y) && (QCircleGpsHelper.a().b()))
    {
      ab();
      this.y = false;
      QLog.d(x, 1, "refresh data after location permission got");
    }
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setPageId(a()).setActionType(94).setSubActionType(1));
    }
  }
  
  protected void u()
  {
    QCircleNearbyTabStatusView localQCircleNearbyTabStatusView = new QCircleNearbyTabStatusView(getContext());
    localQCircleNearbyTabStatusView.setEmptyClickListener(new QFSNearbyTabFragment.2(this));
    MutableLiveData localMutableLiveData = localQCircleNearbyTabStatusView.getTabStatusObserver();
    if (localMutableLiveData != null) {
      localMutableLiveData.observe(this, new QFSNearbyTabFragment.3(this));
    }
    this.k = localQCircleNearbyTabStatusView;
    this.k.setBackgroundColor(QCircleSkinHelper.getInstance().getColor(2131167059));
    this.k.setOnRetryClickListener(new QFSNearbyTabFragment.4(this));
    this.f.be_().setStatusViewInterface(this.k);
  }
  
  protected int w()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.tab.QFSNearbyTabFragment
 * JD-Core Version:    0.7.0.1
 */