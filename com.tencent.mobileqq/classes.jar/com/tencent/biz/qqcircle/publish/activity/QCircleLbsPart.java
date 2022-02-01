package com.tencent.biz.qqcircle.publish.activity;

import android.app.Activity;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.QZoneContant;
import com.tencent.biz.qqcircle.QCircleGpsHelper;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.common.config.LocalConfig;
import com.tencent.biz.qqcircle.publish.report.QCirclePublishReport;
import com.tencent.biz.qqcircle.publish.view.HorizontalListView;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePoiAdapter;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePoiViewModel;
import com.tencent.biz.qqcircle.publish.viewmodel.QCirclePublishViewModel;
import com.tencent.biz.qqcircle.utils.QCirclePermissionUtil;
import com.tencent.biz.qqcircle.widgets.QCircleBubblePopupView;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.LbsDataV2.PoiInfo;

public class QCircleLbsPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private RelativeLayout a;
  private ViewGroup c;
  private HorizontalListView d;
  private QCirclePoiAdapter e;
  private QCirclePoiViewModel f;
  private QCirclePublishViewModel g;
  private TextView h = null;
  private TextView i;
  private ViewGroup j;
  private ImageView k;
  private QCircleBubblePopupView l;
  private boolean m = false;
  private final Runnable n = new QCircleLbsPart.2(this);
  
  private void a(LbsDataV2.PoiInfo paramPoiInfo)
  {
    if ((paramPoiInfo.poiId != null) && (paramPoiInfo.poiId.equals("invalide_poi_id")))
    {
      paramPoiInfo = this.f;
      if (paramPoiInfo != null) {
        paramPoiInfo.g = null;
      }
      paramPoiInfo = this.e;
      if (paramPoiInfo != null) {
        paramPoiInfo.a(null);
      }
      paramPoiInfo = this.c;
      if (paramPoiInfo != null) {
        paramPoiInfo.setVisibility(8);
      }
      paramPoiInfo = this.j;
      if (paramPoiInfo != null) {
        paramPoiInfo.setVisibility(8);
      }
      paramPoiInfo = this.h;
      if (paramPoiInfo != null) {
        paramPoiInfo.setVisibility(0);
      }
    }
  }
  
  private void a(LbsDataV2.PoiInfo paramPoiInfo, boolean paramBoolean)
  {
    Object localObject = this.e;
    if (localObject == null)
    {
      QLog.d("[QcirclePublish]QCircleLbsPart", 1, "[setPoiInfoSelected] poi adapter not is null.");
      return;
    }
    ((QCirclePoiAdapter)localObject).a(paramPoiInfo);
    if (paramPoiInfo == null)
    {
      localObject = this.j;
      if (localObject != null) {
        ((ViewGroup)localObject).setVisibility(8);
      }
      localObject = this.h;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(0);
      }
    }
    else
    {
      localObject = this.j;
      if (localObject != null)
      {
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.i;
        if (localObject != null)
        {
          ((TextView)localObject).setText(paramPoiInfo.poiName);
          this.i.post(new QCircleLbsPart.13(this));
        }
      }
      localObject = this.h;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(8);
      }
    }
    localObject = this.g;
    if (localObject != null)
    {
      ((QCirclePublishViewModel)localObject).a(paramBoolean);
      this.g.a(paramPoiInfo);
    }
  }
  
  private boolean b(LbsDataV2.PoiInfo paramPoiInfo)
  {
    QCirclePoiViewModel localQCirclePoiViewModel = this.f;
    int i1;
    if ((localQCirclePoiViewModel != null) && (localQCirclePoiViewModel.e())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      QLog.d("[QcirclePublish]QCircleLbsPart", 1, "[selectFirstPoiInfo] current not selected first poi info.");
      return false;
    }
    if (!r())
    {
      QLog.d("[QcirclePublish]QCircleLbsPart", 1, "[selectFirstPoiInfo] current not gps permission.");
      return false;
    }
    if (this.c.getVisibility() == 8) {
      this.c.setVisibility(0);
    }
    localQCirclePoiViewModel = this.f;
    if (localQCirclePoiViewModel != null) {
      localQCirclePoiViewModel.g = paramPoiInfo;
    }
    if (paramPoiInfo != null)
    {
      QLog.d("[QcirclePublish]QCircleLbsPart", 1, new Object[] { "[checkFirstPoiInfoSelected] poi id: ", paramPoiInfo.poiId, " | poiName: ", paramPoiInfo.poiName });
      a(paramPoiInfo, true);
      QCirclePublishReport.a(15, 29, 0, "", "");
    }
    return true;
  }
  
  private void i()
  {
    if (this.l == null) {
      this.l = new QCircleBubblePopupView(g());
    }
  }
  
  private void l()
  {
    if ((LocalConfig.b("key_sp_bubble_view_show", true, LoginData.a().b())) && (this.l != null)) {
      this.j.post(new QCircleLbsPart.3(this));
    }
  }
  
  private void m()
  {
    if (this.f == null)
    {
      QLog.d("[QcirclePublish]QCircleLbsPart", 1, "[reloadPublishPoiData] mPoiViewModel == null.");
      return;
    }
    if (!r())
    {
      QLog.i("[QcirclePublish]QCircleLbsPart", 1, "[reloadPublishPoiData] current not gps permission.");
      return;
    }
    this.f.a(null, true);
  }
  
  private void n()
  {
    this.f.b.observe(j(), new QCircleLbsPart.4(this));
    this.f.c.observe(j(), new QCircleLbsPart.5(this));
    this.f.d.observe(j(), new QCircleLbsPart.6(this));
    this.g.b.observe(j(), new QCircleLbsPart.7(this));
  }
  
  private void o()
  {
    if (!((LocationManager)c().getSystemService("location")).isProviderEnabled("gps")) {
      p();
    } else if (!QCircleGpsHelper.a().b())
    {
      if (Build.MODEL.toLowerCase().contains("mi")) {
        q();
      } else if (Build.VERSION.SDK_INT >= 23) {
        QCirclePermissionUtil.a(c(), new QCircleLbsPart.8(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
      }
    }
    else {
      this.f.a(j());
    }
    QCirclePublishReport.a(15, 5, 0, "", "");
  }
  
  private void p()
  {
    Object localObject = QCircleConfigHelper.a("QZoneTextSetting", "secondary_qcircle_no_gps_title", "无法定位");
    String str = QCircleConfigHelper.a("QZoneTextSetting", "secondary_qcircle_no_gps_content", "无法获取到你的位置信息，请打开定位服务。");
    localObject = QCircleCustomDialog.a(g(), (String)localObject, str, 2131887648, 2131890047, new QCircleLbsPart.9(this), new QCircleLbsPart.10(this));
    try
    {
      ((QCircleCustomDialog)localObject).show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[QcirclePublish]QCircleLbsPart", 1, "Exception:", localException);
    }
  }
  
  private void q()
  {
    Object localObject = QCircleConfigHelper.a("QZoneTextSetting", "secondary_qcircle_no_gps_title", "无法定位");
    String str = QCircleConfigHelper.a("QZoneTextSetting", "secondary_qcircle_no_application_gps_content", "你的位置权限被禁用，请到设置中授予QQ访问位置的权限。");
    localObject = QCircleCustomDialog.a(g(), (String)localObject, str, 2131887648, 2131890047, new QCircleLbsPart.11(this), new QCircleLbsPart.12(this));
    try
    {
      ((QCircleCustomDialog)localObject).show();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[QcirclePublish]QCircleLbsPart", 1, "Exception:", localException);
    }
  }
  
  private boolean r()
  {
    return (((LocationManager)c().getSystemService("location")).isProviderEnabled("gps")) && (QCircleGpsHelper.a().b());
  }
  
  public String a()
  {
    return "[QcirclePublish]QCircleLbsPart";
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    HostUIHelper.closeHostEnvironment();
    if ((paramInt1 == (QCircleHostConstants.QZoneContant.QZ_GET_LOCATION_FOR_POI() & 0xFFFF)) && (paramInt2 == -1) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      this.f.a(paramIntent);
      paramIntent = paramIntent.getExtras().getParcelable("key_select_poi");
      if ((paramIntent instanceof LbsDataV2.PoiInfo)) {
        a((LbsDataV2.PoiInfo)paramIntent);
      }
    }
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a = ((RelativeLayout)paramView.findViewById(2131441739));
    this.a.setOnClickListener(this);
    this.h = ((TextView)paramView.findViewById(2131441742));
    if (this.f != null) {
      this.h.setText(QCirclePoiViewModel.f());
    }
    if (this.c != null)
    {
      QLog.d("[QcirclePublish]QCircleLbsPart", 2, "[initPoiView] already inited");
      return;
    }
    this.c = ((ViewGroup)paramView.findViewById(2131441861));
    this.d = ((HorizontalListView)paramView.findViewById(2131441862));
    this.e = new QCirclePoiAdapter(c());
    this.d.setAdapter(this.e);
    this.d.setOnItemClickListener(new QCircleLbsPart.1(this));
    this.j = ((ViewGroup)paramView.findViewById(2131441868));
    this.i = ((TextView)paramView.findViewById(2131448651));
    this.j.setVisibility(8);
    this.k = ((ImageView)paramView.findViewById(2131436342));
    this.k.setOnClickListener(this);
    i();
    n();
    m();
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    if (this.f == null) {
      this.f = ((QCirclePoiViewModel)a(QCirclePoiViewModel.class));
    }
    if (this.g == null) {
      this.g = ((QCirclePublishViewModel)a(QCirclePublishViewModel.class));
    }
    SimpleEventBus.getInstance().registerReceiver(this.f);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    super.onActivityDestroyed(paramActivity);
    SimpleEventBus.getInstance().unRegisterReceiver(this.f);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441739)
    {
      o();
    }
    else if (paramView.getId() == 2131436342)
    {
      a(null, false);
      QCirclePoiViewModel localQCirclePoiViewModel = this.f;
      localQCirclePoiViewModel.g = null;
      localQCirclePoiViewModel.l = true;
      if (this.e.getCount() == 0) {
        this.c.setVisibility(8);
      } else {
        this.c.setVisibility(0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleLbsPart
 * JD-Core Version:    0.7.0.1
 */