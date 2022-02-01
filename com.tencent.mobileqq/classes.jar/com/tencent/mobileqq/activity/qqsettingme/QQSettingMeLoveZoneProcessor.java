package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.MenumItem;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDynamicItemBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeLoveZoneBean;
import com.tencent.mobileqq.app.LoveZoneDynamicRedPointPathInterface;
import com.tencent.mobileqq.app.LoveZoneInfoObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.loverzone.LoverZoneUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vip.QQSettingConfigManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.lp.LpReportInfo_dc03950;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class QQSettingMeLoveZoneProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public MutableLiveData<String> b = new MutableLiveData();
  public MutableLiveData<QQSettingMeDynamicItemBean> i = new MutableLiveData();
  private boolean j;
  private final LoveZoneInfoObserver k = new QQSettingMeLoveZoneProcessor.1(this);
  
  private int a()
  {
    Object localObject = this.c;
    int m = 0;
    if (localObject != null)
    {
      localObject = this.c.getPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("love_state_for_current_uin");
      localStringBuilder.append(this.c.getCurrentUin());
      m = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    }
    return m;
  }
  
  private String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (StudyModeManager.h())
    {
      str = paramString;
      if (paramInt == 0) {
        str = "";
      }
    }
    return str;
  }
  
  private void a(int paramInt)
  {
    if ((!VasUtils.b()) && (this.d != null))
    {
      if (this.c == null) {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)this.c;
      QBaseActivity localQBaseActivity = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      LoverZoneUtils.a(localQQAppInterface, localQBaseActivity, 2066, "10", localStringBuilder.toString());
    }
  }
  
  private void l()
  {
    Object localObject1 = QQSettingConfigManager.a().a((QQAppInterface)this.c);
    Object localObject2 = Integer.valueOf(4);
    Object localObject3 = (MenumItem)((Map)localObject1).get(localObject2);
    if (localObject3 == null) {
      return;
    }
    localObject1 = new QQSettingMeDynamicItemBean();
    ((QQSettingMeDynamicItemBean)localObject1).a = QQSettingConfigManager.a().b((Integer)localObject2);
    if (!TextUtils.isEmpty(((MenumItem)localObject3).title)) {
      ((QQSettingMeDynamicItemBean)localObject1).b = ChatRoomUtil.a(((MenumItem)localObject3).title, 16);
    }
    if (!TextUtils.isEmpty(((MenumItem)localObject3).icon))
    {
      localObject2 = ((MenumItem)localObject3).icon;
      localObject3 = URLDrawableHelperConstants.a;
      ((QQSettingMeDynamicItemBean)localObject1).c = VasApngUtil.getApngURLDrawable((String)localObject2, new int[] { 1 }, (Drawable)localObject3, null, null);
    }
    this.i.postValue(localObject1);
  }
  
  private void m()
  {
    Iterator localIterator = ((IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "")).getRegisterInterfaces().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface localDynamicRedPointPathInterface = (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localIterator.next();
      if ((localDynamicRedPointPathInterface instanceof LoveZoneDynamicRedPointPathInterface)) {
        ((LoveZoneDynamicRedPointPathInterface)localDynamicRedPointPathInterface).a();
      }
    }
  }
  
  private void n()
  {
    if (this.c == null) {
      return;
    }
    Iterator localIterator = ((IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "")).getRegisterInterfaces().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface localDynamicRedPointPathInterface = (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localIterator.next();
      if ((localDynamicRedPointPathInterface instanceof LoveZoneDynamicRedPointPathInterface)) {
        ((LoveZoneDynamicRedPointPathInterface)localDynamicRedPointPathInterface).b();
      }
    }
  }
  
  public void a(View paramView)
  {
    int m = LoverZoneUtils.a(LoverZoneUtils.a((BusinessInfoCheckUpdate.AppInfo)this.a.getValue()));
    paramView = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
    Object localObject1 = paramView.getAppInfoByPath(String.valueOf(100066));
    if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0)) {
      paramView.reportLevelOneRedInfo(100066, 31);
    }
    boolean bool = QQSettingMe.c("d_lovespace").h();
    Object localObject2 = this.c;
    localObject1 = "1";
    if (bool) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0x800AAFB", "0x800AAFB", 0, 0, paramView, "", "", "");
    a(m);
    localObject2 = MobileReportManager.getInstance();
    long l = System.currentTimeMillis();
    paramView = (View)localObject1;
    if (a() == 1) {
      paramView = "0";
    }
    ((MobileReportManager)localObject2).reportAction("qq_drawer_qv", "4", "qzone_vip_lovers", "5", "", 102, 1, l, paramView);
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    super.a(paramQQSettingMe);
    this.b.observe(this.e, new QQSettingMeLoveZoneProcessor.2(this, paramQQSettingMe));
    this.i.observe(this.e, new QQSettingMeLoveZoneProcessor.3(this, paramQQSettingMe));
  }
  
  public String b()
  {
    return "d_lovespace";
  }
  
  protected void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if (QQSettingMe.b("d_lovespace").getVisibility() == 0)
    {
      paramAppInfo = LoverZoneUtils.a(paramAppInfo);
      int m = LoverZoneUtils.a(paramAppInfo);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(m);
      ((StringBuilder)localObject1).append("");
      Object localObject2 = ((StringBuilder)localObject1).toString();
      String str = LpReportInfo_dc03950.getReportUserType((QQAppInterface)this.c);
      localObject1 = "1";
      LoverZoneUtils.a("10", (String)localObject2, "1", str);
      localObject2 = this.c;
      if (!TextUtils.isEmpty(paramAppInfo)) {
        paramAppInfo = "1";
      } else {
        paramAppInfo = "2";
      }
      ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0x800AAFA", "0x800AAFA", 0, 0, paramAppInfo, "", "", "");
      localObject2 = MobileReportManager.getInstance();
      long l = System.currentTimeMillis();
      paramAppInfo = (BusinessInfoCheckUpdate.AppInfo)localObject1;
      if (a() == 1) {
        paramAppInfo = "0";
      }
      ((MobileReportManager)localObject2).reportAction("qq_drawer_qv", "4", "qzone_vip_lovers", "5", "", 101, 1, l, paramAppInfo);
    }
  }
  
  public void c()
  {
    l();
  }
  
  public void d()
  {
    super.d();
    if (!this.j)
    {
      ((QQAppInterface)this.c).addObserver(this.k, true);
      this.j = true;
    }
    l();
    i();
  }
  
  public void f()
  {
    if ((this.j) && (this.c != null)) {
      ((QQAppInterface)this.c).removeObserver(this.k);
    }
  }
  
  public void h()
  {
    l();
  }
  
  public void i()
  {
    QQSettingMeLoveZoneBean localQQSettingMeLoveZoneBean = new QQSettingMeLoveZoneBean();
    localQQSettingMeLoveZoneBean.a = QzoneConfig.getInstance().getConfig("sweet_miniapp", "entrance", "0");
    localQQSettingMeLoveZoneBean.b = a();
    if ((!TextUtils.isEmpty(localQQSettingMeLoveZoneBean.a)) && (!"0".equals(localQQSettingMeLoveZoneBean.a))) {
      localQQSettingMeLoveZoneBean.a = a(localQQSettingMeLoveZoneBean.a, localQQSettingMeLoveZoneBean.b);
    }
    if ((this.c != null) && (!TextUtils.isEmpty(localQQSettingMeLoveZoneBean.a)) && (!"0".equals(localQQSettingMeLoveZoneBean.a)))
    {
      if (localQQSettingMeLoveZoneBean.b == 1)
      {
        m();
        return;
      }
      n();
      return;
    }
    n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeLoveZoneProcessor
 * JD-Core Version:    0.7.0.1
 */