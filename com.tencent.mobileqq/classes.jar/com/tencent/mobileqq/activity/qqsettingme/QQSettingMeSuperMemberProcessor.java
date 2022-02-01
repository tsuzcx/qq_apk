package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.MenumItem;
import MQQ.PayRuleCfg;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDynamicItemBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSuperMemberPayButtonBean;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.QQSettingConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QQSettingMeSuperMemberProcessor
  extends QQSettingMeBaseMenuProcessor
  implements ISuperMemberDataCatcher
{
  private final BroadcastReceiver a;
  public MutableLiveData<QQSettingMeSuperMemberPayButtonBean> b;
  private boolean b;
  public MutableLiveData<String> c;
  private boolean c;
  public MutableLiveData<QQSettingMeDynamicItemBean> d = new MutableLiveData();
  
  public QQSettingMeSuperMemberProcessor()
  {
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData(new QQSettingMeSuperMemberPayButtonBean());
    this.jdField_c_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new QQSettingMeSuperMemberProcessor.1(this);
  }
  
  private boolean a()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return true;
    }
    long l = QVipConfigManager.a(this.jdField_a_of_type_MqqAppAppRuntime, "setting_me_last_request_success_time", 0L);
    int i = QVipConfigManager.a(this.jdField_a_of_type_MqqAppAppRuntime, "setting_me_vip_sync_freq", 0);
    if (NetConnInfoCenter.getServerTime() - l <= i)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ignore the vip info request because current time=");
      localStringBuilder.append(NetConnInfoCenter.getServerTime());
      localStringBuilder.append(" requestTimestamp=");
      localStringBuilder.append(l);
      localStringBuilder.append(" and updateFrequency=");
      localStringBuilder.append(i);
      QLog.e("QVipSettingMe.QQSettingRedesign", 1, localStringBuilder.toString());
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("need the vip info request because current time=");
    localStringBuilder.append(NetConnInfoCenter.getServerTime());
    localStringBuilder.append(" requestTimestamp=");
    localStringBuilder.append(l);
    localStringBuilder.append(" and updateFrequency=");
    localStringBuilder.append(i);
    QLog.e("QVipSettingMe.QQSettingRedesign", 1, localStringBuilder.toString());
    return true;
  }
  
  private void b(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime;
    Object localObject3 = "";
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)((AppRuntime)localObject1).getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath(String.valueOf(100400));
    localObject1 = localObject3;
    if (localAppInfo != null)
    {
      localObject1 = localObject3;
      if (localAppInfo.iNewFlag.get() != 0)
      {
        localObject1 = localObject3;
        if (localAppInfo.exposure_max.get() >= 0)
        {
          localObject1 = localAppInfo.buffer.get();
          try
          {
            localObject1 = new JSONObject((String)localObject1).optString("_jump_url");
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse json exception ");
            localStringBuilder.append(localException);
            QLog.e("QQSettingRedesign", 2, localStringBuilder.toString());
            localObject2 = localObject3;
          }
        }
      }
    }
    localObject3 = new StringBuilder();
    int j = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getApplicationContext());
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject2);
    boolean bool2 = false;
    int i;
    if (bool1)
    {
      localObject2 = b().jdField_a_of_type_JavaLangString;
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (!((String)localObject2).contains("?"))
    {
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("?platform=1&type=20001&networkInfo=");
      ((StringBuilder)localObject3).append(j);
    }
    else
    {
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("&platform=1&type=20001&networkInfo=");
      ((StringBuilder)localObject3).append(j);
    }
    localObject3 = localIRedTouchManager.wrapperRedTouchUrl(((StringBuilder)localObject3).toString(), localAppInfo);
    bool1 = bool2;
    if (localAppInfo != null)
    {
      bool1 = bool2;
      if (localAppInfo.iNewFlag.get() != 0)
      {
        bool1 = bool2;
        if (localAppInfo.type.get() == 0) {
          bool1 = true;
        }
      }
    }
    Object localObject2 = localObject3;
    if (paramString != null)
    {
      localObject2 = localObject3;
      if (i != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append(paramString);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    if (VasUtil.a().isCanOpenQQVipHippyPage())
    {
      VasUtil.a().openQQVipHippyPage();
    }
    else
    {
      paramString = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, QQBrowserActivity.class);
      paramString.putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
      paramString.putExtra("startOpenPageTime", l);
      paramString.putExtra("portraitOnly", true);
      paramString.putExtra("uin", this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      paramString.putExtra("hide_operation_bar", true);
      paramString.putExtra("hide_more_button", true);
      paramString.putExtra("has_red_dot", bool1);
      paramString.putExtra("leftBtnText", this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getString(2131689529));
      VasWebviewUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (String)localObject2, 256L, paramString, false, -1);
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler gotoOpenCenterBrowser");
    }
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
      localIRedTouchManager.reportLevelOneRedInfo(100400, 31);
    }
  }
  
  private void j()
  {
    Object localObject1 = QQSettingConfigManager.a().a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    Object localObject2 = Integer.valueOf(2);
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
    this.d.postValue(localObject1);
  }
  
  private void k()
  {
    if (QQSettingConfigManager.a().a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, 4)) {
      return;
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences("vipTitleSpFile", 0);
    MutableLiveData localMutableLiveData = this.jdField_c_of_type_AndroidxLifecycleMutableLiveData;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vipTitleSpKey_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(LocaleManager.a());
    localMutableLiveData.setValue(localSharedPreferences.getString(localStringBuilder.toString(), ""));
  }
  
  private void l()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getSharedPreferences(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 4);
    b().jdField_a_of_type_JavaLangString = localSharedPreferences.getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
    ThreadManager.getSubThreadHandler().post(new QQSettingMeSuperMemberProcessor.9(this));
  }
  
  public QQSettingMeSuperMemberPayButtonBean a()
  {
    return (QQSettingMeSuperMemberPayButtonBean)this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.getValue();
  }
  
  public String a()
  {
    return "d_vip_identity";
  }
  
  public void a()
  {
    k();
    j();
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQSettingRedesign", 2, "enter vip");
    }
    ThreadManager.excute(new QQSettingMeSuperMemberProcessor.6(this), 16, null, true);
    paramView = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    boolean bool = QQSettingMe.a("d_vip_identity").c();
    int i = VipInfoHandler.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), bool);
    if (bool) {
      paramView = MobileReportManager.getNewReportInfo(paramView.getAppInfoByPath(String.valueOf(100400)));
    } else {
      paramView = MobileReportManager.getNewDefaultReportInfo("outside", "1");
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A8BE", "0X800A8BE", i, 0, String.valueOf(i), "", "", "");
    b(paramView);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
    MobileReportManager.getInstance().qqSetingMeReport(1, 102, String.valueOf(i));
    if (QQSettingMe.a > 0)
    {
      com.tencent.mobileqq.activity.recent.DrawerFrame.a = 2;
      return;
    }
    com.tencent.mobileqq.activity.recent.DrawerFrame.a = QQSettingMe.a;
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeSuperMemberProcessor.2(this, paramQQSettingMe));
    this.d.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeSuperMemberProcessor.3(this, paramQQSettingMe));
    this.jdField_c_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeSuperMemberProcessor.4(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    QQSettingMeRedTouchUtil.a(paramAppInfo);
    QQSettingMeSuperMemberPayButtonBean localQQSettingMeSuperMemberPayButtonBean = b();
    localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = paramAppInfo;
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeSuperMemberProcessor.8(this, localQQSettingMeSuperMemberPayButtonBean));
  }
  
  @NonNull
  public QQSettingMeSuperMemberPayButtonBean b()
  {
    if (this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.getValue() == null) {
      return new QQSettingMeSuperMemberPayButtonBean();
    }
    return (QQSettingMeSuperMemberPayButtonBean)this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.getValue();
  }
  
  public void b()
  {
    super.b();
    if (!this.jdField_c_of_type_Boolean)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.mobileqq.opencenter.vipInfo"));
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initUpdateVipInfoReceiver:");
          localStringBuilder.append(localException.toString());
          QLog.d("QQSettingRedesign", 2, localStringBuilder.toString());
        }
      }
      if (TextUtils.isEmpty(VipGrayConfigHelper.a().b)) {
        ThreadManager.excute(new QQSettingMeSuperMemberProcessor.5(this), 16, null, true);
      }
      this.jdField_c_of_type_Boolean = true;
    }
    this.jdField_b_of_type_Boolean = false;
    j();
    l();
    if (QQSettingMe.a("d_vip_identity").getVisibility() == 0)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(100400));
      int i = VipInfoHandler.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), RedTouch.a(localAppInfo));
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A8C3", "0X800A8C3", i, 0, String.valueOf(i), "", "", "");
      MobileReportManager.getInstance().qqSetingMeReport(1, 101, String.valueOf(i));
    }
  }
  
  public void d()
  {
    if (this.jdField_c_of_type_Boolean) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QQSettingRedesign", 2, localException.toString());
        }
      }
    }
  }
  
  public void f()
  {
    j();
  }
  
  public void g()
  {
    QQSettingMeSuperMemberPayButtonBean localQQSettingMeSuperMemberPayButtonBean = new QQSettingMeSuperMemberPayButtonBean();
    try
    {
      localQQSettingMeSuperMemberPayButtonBean.b = this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin();
      localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_MQQPayRuleCfg = VipInfoHandler.a(localQQSettingMeSuperMemberPayButtonBean.b);
      localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_Boolean = VipInfoHandler.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_MQQPayRuleCfg, this.jdField_b_of_type_Boolean);
      if (localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_MQQPayRuleCfg == null) {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler getPayRule is null");
      } else {
        QLog.e("QQSettingRedesign", 1, new Object[] { "VipInfoHandler getPayRule ", localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_MQQPayRuleCfg.iconText, " needShowPayButton=", Boolean.valueOf(localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_Boolean), " url=", localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_MQQPayRuleCfg.iconUrl, " exposed:", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      }
      if ((localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
      {
        this.jdField_b_of_type_Boolean = true;
        ReportController.b(null, "dc00898", "", "", "", "0X800A632", VipInfoHandler.a(localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_MQQPayRuleCfg), 1, 0, "1", localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_MQQPayRuleCfg.advId, "", "");
        VipInfoHandler.a(101, localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_MQQPayRuleCfg.advId);
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(100400));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VipInfoHandler vipAppinfo: ");
        localStringBuilder.append(((IRedTouchManager)localObject).appToString(localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo));
        QLog.d("QQSettingRedesign", 2, localStringBuilder.toString());
      }
      if (((localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo != null) && (localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo.iNewFlag.get() == 1)) || (localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_Boolean))
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler PreloadWebService updateVipItemView");
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, PreloadWebService.class);
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startService((Intent)localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("QQSettingRedesign", 2, "PreloadWebService", localThrowable);
        }
      }
      localQQSettingMeSuperMemberPayButtonBean.jdField_a_of_type_AndroidViewView$OnClickListener = new QQSettingMeSuperMemberProcessor.7(this, localQQSettingMeSuperMemberPayButtonBean);
    }
    catch (Exception localException)
    {
      QLog.e("QQSettingRedesign", 1, "updateVipItemView: ", localException);
    }
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.setValue(localQQSettingMeSuperMemberPayButtonBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor
 * JD-Core Version:    0.7.0.1
 */