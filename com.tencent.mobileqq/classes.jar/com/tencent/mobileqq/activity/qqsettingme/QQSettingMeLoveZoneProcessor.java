package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.MenumItem;
import android.content.Context;
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
  private final LoveZoneInfoObserver a;
  public MutableLiveData<String> b;
  private boolean b;
  public MutableLiveData<QQSettingMeDynamicItemBean> c = new MutableLiveData();
  
  public QQSettingMeLoveZoneProcessor()
  {
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_a_of_type_ComTencentMobileqqAppLoveZoneInfoObserver = new QQSettingMeLoveZoneProcessor.1(this);
  }
  
  private int a()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    int i = 0;
    if (localObject != null)
    {
      localObject = this.jdField_a_of_type_MqqAppAppRuntime.getPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("love_state_for_current_uin");
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin());
      i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0);
    }
    return i;
  }
  
  private String a(String paramString, int paramInt)
  {
    String str = paramString;
    if (StudyModeManager.a())
    {
      str = paramString;
      if (paramInt == 0) {
        str = "";
      }
    }
    return str;
  }
  
  private void j()
  {
    Object localObject1 = QQSettingConfigManager.a().a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    Object localObject2 = Integer.valueOf(4);
    Object localObject3 = (MenumItem)((Map)localObject1).get(localObject2);
    if (localObject3 == null) {
      return;
    }
    localObject1 = new QQSettingMeDynamicItemBean();
    ((QQSettingMeDynamicItemBean)localObject1).jdField_a_of_type_JavaLangString = QQSettingConfigManager.a().a((Integer)localObject2);
    if (!TextUtils.isEmpty(((MenumItem)localObject3).title)) {
      ((QQSettingMeDynamicItemBean)localObject1).jdField_a_of_type_ComTencentMobileqqTextQQText = ChatRoomUtil.a(((MenumItem)localObject3).title, 16);
    }
    if (!TextUtils.isEmpty(((MenumItem)localObject3).icon))
    {
      localObject2 = ((MenumItem)localObject3).icon;
      localObject3 = URLDrawableHelperConstants.a;
      ((QQSettingMeDynamicItemBean)localObject1).jdField_a_of_type_ComTencentImageURLDrawable = VasApngUtil.getApngURLDrawable((String)localObject2, new int[] { 1 }, (Drawable)localObject3, null, null);
    }
    this.c.postValue(localObject1);
  }
  
  private void k()
  {
    Iterator localIterator = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getRegisterInterfaces().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface localDynamicRedPointPathInterface = (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localIterator.next();
      if ((localDynamicRedPointPathInterface instanceof LoveZoneDynamicRedPointPathInterface)) {
        ((LoveZoneDynamicRedPointPathInterface)localDynamicRedPointPathInterface).a();
      }
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    Iterator localIterator = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getRegisterInterfaces().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface localDynamicRedPointPathInterface = (BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface)localIterator.next();
      if ((localDynamicRedPointPathInterface instanceof LoveZoneDynamicRedPointPathInterface)) {
        ((LoveZoneDynamicRedPointPathInterface)localDynamicRedPointPathInterface).b();
      }
    }
  }
  
  public String a()
  {
    return "d_lovespace";
  }
  
  public void a()
  {
    j();
  }
  
  public void a(View paramView)
  {
    int i = LoverZoneUtils.a(LoverZoneUtils.a((BusinessInfoCheckUpdate.AppInfo)this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.getValue()));
    paramView = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    Object localObject1 = paramView.getAppInfoByPath(String.valueOf(100066));
    if ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() != 0)) {
      paramView.reportLevelOneRedInfo(100066, 31);
    }
    boolean bool = QQSettingMe.a("d_lovespace").c();
    Object localObject2 = this.jdField_a_of_type_MqqAppAppRuntime;
    localObject1 = "1";
    if (bool) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0x800AAFB", "0x800AAFB", 0, 0, paramView, "", "", "");
    paramView = (QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    LoverZoneUtils.a(paramView, (Context)localObject2, 2066, "10", localStringBuilder.toString());
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
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeLoveZoneProcessor.2(this, paramQQSettingMe));
    this.c.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeLoveZoneProcessor.3(this, paramQQSettingMe));
  }
  
  public void b()
  {
    super.b();
    if (!this.jdField_b_of_type_Boolean)
    {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppLoveZoneInfoObserver, true);
      this.jdField_b_of_type_Boolean = true;
    }
    j();
    g();
  }
  
  protected void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    if (QQSettingMe.a("d_lovespace").getVisibility() == 0)
    {
      paramAppInfo = LoverZoneUtils.a(paramAppInfo);
      int i = LoverZoneUtils.a(paramAppInfo);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("");
      Object localObject2 = ((StringBuilder)localObject1).toString();
      String str = LpReportInfo_dc03950.getReportUserType((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
      localObject1 = "1";
      LoverZoneUtils.a("10", (String)localObject2, "1", str);
      localObject2 = this.jdField_a_of_type_MqqAppAppRuntime;
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
  
  public void d()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_MqqAppAppRuntime != null)) {
      ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLoveZoneInfoObserver);
    }
  }
  
  public void f()
  {
    j();
  }
  
  public void g()
  {
    QQSettingMeLoveZoneBean localQQSettingMeLoveZoneBean = new QQSettingMeLoveZoneBean();
    localQQSettingMeLoveZoneBean.jdField_a_of_type_JavaLangString = QzoneConfig.getInstance().getConfig("sweet_miniapp", "entrance", "0");
    localQQSettingMeLoveZoneBean.jdField_a_of_type_Int = a();
    if ((!TextUtils.isEmpty(localQQSettingMeLoveZoneBean.jdField_a_of_type_JavaLangString)) && (!"0".equals(localQQSettingMeLoveZoneBean.jdField_a_of_type_JavaLangString))) {
      localQQSettingMeLoveZoneBean.jdField_a_of_type_JavaLangString = a(localQQSettingMeLoveZoneBean.jdField_a_of_type_JavaLangString, localQQSettingMeLoveZoneBean.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (!TextUtils.isEmpty(localQQSettingMeLoveZoneBean.jdField_a_of_type_JavaLangString)) && (!"0".equals(localQQSettingMeLoveZoneBean.jdField_a_of_type_JavaLangString)))
    {
      if (localQQSettingMeLoveZoneBean.jdField_a_of_type_Int == 1)
      {
        k();
        return;
      }
      l();
      return;
    }
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeLoveZoneProcessor
 * JD-Core Version:    0.7.0.1
 */