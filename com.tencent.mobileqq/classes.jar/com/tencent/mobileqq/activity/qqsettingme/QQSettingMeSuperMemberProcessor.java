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
import com.tencent.mobileqq.utils.VasUtils;
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
  public MutableLiveData<QQSettingMeSuperMemberPayButtonBean> b = new MutableLiveData(new QQSettingMeSuperMemberPayButtonBean());
  public MutableLiveData<String> i = new MutableLiveData();
  public MutableLiveData<QQSettingMeDynamicItemBean> j = new MutableLiveData();
  private boolean k;
  private boolean l;
  private final BroadcastReceiver m = new QQSettingMeSuperMemberProcessor.1(this);
  
  private void b(String paramString)
  {
    if (VasUtils.b()) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = this.c;
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
    int i1 = NetworkUtil.getSystemNetwork(this.c.getApp().getApplicationContext());
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject2);
    boolean bool2 = false;
    int n;
    if (bool1)
    {
      localObject2 = l().b;
      n = 1;
    }
    else
    {
      n = 0;
    }
    if (!((String)localObject2).contains("?"))
    {
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("?platform=1&type=20001&networkInfo=");
      ((StringBuilder)localObject3).append(i1);
    }
    else
    {
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("&platform=1&type=20001&networkInfo=");
      ((StringBuilder)localObject3).append(i1);
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
      if (n != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append(paramString);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    if (VasUtil.b().isCanOpenQQVipHippyPage())
    {
      VasUtil.b().openQQVipHippyPage((String)localObject2);
    }
    else
    {
      paramString = new Intent(this.d, QQBrowserActivity.class);
      paramString.putExtra("broadcastAction", "com.tencent.mobileqq.opencenter.vipInfo");
      paramString.putExtra("startOpenPageTime", l1);
      paramString.putExtra("portraitOnly", true);
      paramString.putExtra("uin", this.c.getCurrentAccountUin());
      paramString.putExtra("hide_operation_bar", true);
      paramString.putExtra("hide_more_button", true);
      paramString.putExtra("has_red_dot", bool1);
      paramString.putExtra("leftBtnText", this.d.getResources().getString(2131886137));
      VasWebviewUtil.b(this.d, (String)localObject2, 256L, paramString, false, -1);
      QLog.e("QQSettingRedesign", 1, "VipInfoHandler gotoOpenCenterBrowser");
    }
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
      localIRedTouchManager.reportLevelOneRedInfo(100400, 31);
    }
  }
  
  private void m()
  {
    Object localObject1 = QQSettingConfigManager.a().a((QQAppInterface)this.c);
    Object localObject2 = Integer.valueOf(2);
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
    this.j.postValue(localObject1);
  }
  
  private void n()
  {
    if (QQSettingConfigManager.a().a((QQAppInterface)this.c, 4)) {
      return;
    }
    SharedPreferences localSharedPreferences = this.c.getApplication().getSharedPreferences("vipTitleSpFile", 0);
    MutableLiveData localMutableLiveData = this.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vipTitleSpKey_");
    localStringBuilder.append(this.c.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(LocaleManager.d());
    localMutableLiveData.setValue(localSharedPreferences.getString(localStringBuilder.toString(), ""));
  }
  
  private void o()
  {
    SharedPreferences localSharedPreferences = this.c.getApplication().getSharedPreferences(this.c.getCurrentAccountUin(), 4);
    l().b = localSharedPreferences.getString("VIPCenter_url_key", "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_alpha=0&pay_src=10&_wvx=10&default=1&_proxy=1");
    ThreadManager.getSubThreadHandler().post(new QQSettingMeSuperMemberProcessor.9(this));
  }
  
  private boolean p()
  {
    if (!this.l) {
      return true;
    }
    long l1 = QVipConfigManager.a(this.c, "setting_me_last_request_success_time", 0L);
    int n = QVipConfigManager.a(this.c, "setting_me_vip_sync_freq", 0);
    if (NetConnInfoCenter.getServerTime() - l1 <= n)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ignore the vip info request because current time=");
      localStringBuilder.append(NetConnInfoCenter.getServerTime());
      localStringBuilder.append(" requestTimestamp=");
      localStringBuilder.append(l1);
      localStringBuilder.append(" and updateFrequency=");
      localStringBuilder.append(n);
      QLog.e("QVipSettingMe.QQSettingRedesign", 1, localStringBuilder.toString());
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("need the vip info request because current time=");
    localStringBuilder.append(NetConnInfoCenter.getServerTime());
    localStringBuilder.append(" requestTimestamp=");
    localStringBuilder.append(l1);
    localStringBuilder.append(" and updateFrequency=");
    localStringBuilder.append(n);
    QLog.e("QVipSettingMe.QQSettingRedesign", 1, localStringBuilder.toString());
    return true;
  }
  
  public QQSettingMeSuperMemberPayButtonBean a()
  {
    return (QQSettingMeSuperMemberPayButtonBean)this.b.getValue();
  }
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQSettingRedesign", 2, "enter vip");
    }
    ThreadManager.excute(new QQSettingMeSuperMemberProcessor.6(this), 16, null, true);
    paramView = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
    boolean bool = QQSettingMe.c("d_vip_identity").h();
    int n = VipInfoHandler.a((QQAppInterface)this.c, this.c.getCurrentUin(), bool);
    if (bool) {
      paramView = MobileReportManager.getNewReportInfo(paramView.getAppInfoByPath(String.valueOf(100400)));
    } else {
      paramView = MobileReportManager.getNewDefaultReportInfo("outside", "1");
    }
    ReportController.b(this.c, "dc00898", "", "", "0X800A8BE", "0X800A8BE", n, 0, String.valueOf(n), "", "", "");
    b(paramView);
    ReportController.b(this.c, "CliOper", "", "", "0X8004185", "0X8004185", 0, 0, "", "", "", "");
    MobileReportManager.getInstance().qqSetingMeReport(1, 102, String.valueOf(n));
    if (QQSettingMe.a > 0)
    {
      com.tencent.mobileqq.activity.recent.DrawerFrame.b = 2;
      return;
    }
    com.tencent.mobileqq.activity.recent.DrawerFrame.b = QQSettingMe.a;
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.b.observe(this.e, new QQSettingMeSuperMemberProcessor.2(this, paramQQSettingMe));
    this.j.observe(this.e, new QQSettingMeSuperMemberProcessor.3(this, paramQQSettingMe));
    this.i.observe(this.e, new QQSettingMeSuperMemberProcessor.4(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    QQSettingMeRedTouchUtil.a(paramAppInfo);
    QQSettingMeSuperMemberPayButtonBean localQQSettingMeSuperMemberPayButtonBean = l();
    localQQSettingMeSuperMemberPayButtonBean.a = paramAppInfo;
    if (!this.g) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeSuperMemberProcessor.8(this, localQQSettingMeSuperMemberPayButtonBean));
  }
  
  public String b()
  {
    return "d_vip_identity";
  }
  
  public void c()
  {
    n();
    m();
  }
  
  public void d()
  {
    super.d();
    if (!this.l)
    {
      try
      {
        this.d.registerReceiver(this.m, new IntentFilter("com.tencent.mobileqq.opencenter.vipInfo"));
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
      this.l = true;
    }
    this.k = false;
    m();
    o();
    if (QQSettingMe.b("d_vip_identity").getVisibility() == 0)
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(100400));
      int n = VipInfoHandler.a((QQAppInterface)this.c, this.c.getCurrentUin(), RedTouch.d(localAppInfo));
      ReportController.b(this.c, "dc00898", "", "", "0X800A8C3", "0X800A8C3", n, 0, String.valueOf(n), "", "", "");
      MobileReportManager.getInstance().qqSetingMeReport(1, 101, String.valueOf(n));
    }
  }
  
  public void f()
  {
    if (this.l) {
      try
      {
        this.d.unregisterReceiver(this.m);
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
  
  public void h()
  {
    m();
  }
  
  public void i()
  {
    QQSettingMeSuperMemberPayButtonBean localQQSettingMeSuperMemberPayButtonBean = new QQSettingMeSuperMemberPayButtonBean();
    try
    {
      localQQSettingMeSuperMemberPayButtonBean.c = this.c.getCurrentUin();
      localQQSettingMeSuperMemberPayButtonBean.d = VipInfoHandler.a(localQQSettingMeSuperMemberPayButtonBean.c);
      localQQSettingMeSuperMemberPayButtonBean.e = VipInfoHandler.a((QQAppInterface)this.c, localQQSettingMeSuperMemberPayButtonBean.d, this.k);
      if (localQQSettingMeSuperMemberPayButtonBean.d == null) {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler getPayRule is null");
      } else {
        QLog.e("QQSettingRedesign", 1, new Object[] { "VipInfoHandler getPayRule ", localQQSettingMeSuperMemberPayButtonBean.d.iconText, " needShowPayButton=", Boolean.valueOf(localQQSettingMeSuperMemberPayButtonBean.e), " url=", localQQSettingMeSuperMemberPayButtonBean.d.iconUrl, " exposed:", Boolean.valueOf(this.k) });
      }
      if ((localQQSettingMeSuperMemberPayButtonBean.e) && (!this.k))
      {
        this.k = true;
        ReportController.b(null, "dc00898", "", "", "", "0X800A632", VipInfoHandler.b(localQQSettingMeSuperMemberPayButtonBean.d), 1, 0, "1", localQQSettingMeSuperMemberPayButtonBean.d.advId, "", "");
        VipInfoHandler.a(101, localQQSettingMeSuperMemberPayButtonBean.d.advId);
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
        localQQSettingMeSuperMemberPayButtonBean.a = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(100400));
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VipInfoHandler vipAppinfo: ");
        localStringBuilder.append(((IRedTouchManager)localObject).appToString(localQQSettingMeSuperMemberPayButtonBean.a));
        QLog.d("QQSettingRedesign", 2, localStringBuilder.toString());
      }
      if (((localQQSettingMeSuperMemberPayButtonBean.a != null) && (localQQSettingMeSuperMemberPayButtonBean.a.iNewFlag.get() == 1)) || (localQQSettingMeSuperMemberPayButtonBean.e))
      {
        QLog.e("QQSettingRedesign", 1, "VipInfoHandler PreloadWebService updateVipItemView");
        localObject = new Intent(this.d, PreloadWebService.class);
        try
        {
          this.d.startService((Intent)localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("QQSettingRedesign", 2, "PreloadWebService", localThrowable);
        }
      }
      localQQSettingMeSuperMemberPayButtonBean.f = new QQSettingMeSuperMemberProcessor.7(this, localQQSettingMeSuperMemberPayButtonBean);
    }
    catch (Exception localException)
    {
      QLog.e("QQSettingRedesign", 1, "updateVipItemView: ", localException);
    }
    this.b.setValue(localQQSettingMeSuperMemberPayButtonBean);
  }
  
  @NonNull
  public QQSettingMeSuperMemberPayButtonBean l()
  {
    if (this.b.getValue() == null) {
      return new QQSettingMeSuperMemberPayButtonBean();
    }
    return (QQSettingMeSuperMemberPayButtonBean)this.b.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor
 * JD-Core Version:    0.7.0.1
 */