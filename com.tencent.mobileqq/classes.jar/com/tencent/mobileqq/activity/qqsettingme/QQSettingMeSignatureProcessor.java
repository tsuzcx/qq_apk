package com.tencent.mobileqq.activity.qqsettingme;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeRichStatusBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSignatureBean;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.richstatus.IActionListener;
import com.tencent.mobileqq.richstatus.IIconListener;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QQSettingMeSignatureProcessor
  extends QQSettingMeBaseProcessor
{
  public final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> a = new MutableLiveData();
  public MutableLiveData<QQSettingMeSignatureBean> b = new MutableLiveData();
  public MutableLiveData<QQSettingMeRichStatusBean> i = new MutableLiveData();
  private StatusManager j;
  private IStatusListener k;
  private IIconListener l;
  private IActionListener m;
  private boolean n;
  private boolean o;
  
  @NonNull
  private QQSettingMeRichStatusBean a()
  {
    if (this.i.getValue() == null) {
      return new QQSettingMeRichStatusBean();
    }
    return (QQSettingMeRichStatusBean)this.i.getValue();
  }
  
  private void l()
  {
    this.j = ((StatusManager)this.c.getManager(QQManagerFactory.STATUS_MANAGER));
    QQSettingMeSignatureBean localQQSettingMeSignatureBean = new QQSettingMeSignatureBean();
    Object localObject = this.c.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqsettingme_signature");
    localStringBuilder.append(this.c.getAccount());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    localQQSettingMeSignatureBean.b = ((SharedPreferences)localObject).getString("actionText", "");
    localQQSettingMeSignatureBean.a = ((SharedPreferences)localObject).getInt("actionId", 0);
    localQQSettingMeSignatureBean.c = ((SharedPreferences)localObject).getString("dataText", "");
    localQQSettingMeSignatureBean.e = ((SharedPreferences)localObject).getString("plainText", "");
    localQQSettingMeSignatureBean.d = ((SharedPreferences)localObject).getString("topics", "");
    localQQSettingMeSignatureBean.f = ((SharedPreferences)localObject).getString("plainMixTopic", "");
    localQQSettingMeSignatureBean.g = this.j.a(localQQSettingMeSignatureBean.a, 200);
    this.b.setValue(localQQSettingMeSignatureBean);
  }
  
  private void m()
  {
    this.k = new QQSettingMeSignatureProcessor.6(this);
    this.j.a(this.k);
    this.l = new QQSettingMeSignatureProcessor.7(this);
    this.j.a(this.l);
    this.m = new QQSettingMeSignatureProcessor.8(this);
    this.j.a(this.m);
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.b.observe(this.e, new QQSettingMeSignatureProcessor.1(this, paramQQSettingMe));
    this.i.observe(this.e, new QQSettingMeSignatureProcessor.2(this, paramQQSettingMe));
    this.a.observe(this.e, new QQSettingMeSignatureProcessor.3(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (this.o)
    {
      StatusManager localStatusManager = this.j;
      if (localStatusManager != null)
      {
        localStatusManager.b(this.k);
        this.j.b(this.l);
        this.j.b(this.m);
      }
      this.c = paramAppRuntime;
      i();
      return;
    }
    this.c = paramAppRuntime;
  }
  
  public void a(boolean paramBoolean)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(100450));
    QQSettingMeRedTouchUtil.a(localAppInfo);
    if (this.n) {
      ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeSignatureProcessor.5(this, localAppInfo));
    }
  }
  
  public String b()
  {
    return "d_signature";
  }
  
  public void c()
  {
    l();
  }
  
  public void d()
  {
    super.d();
    i();
    this.n = true;
    this.o = true;
  }
  
  public void e()
  {
    super.e();
    this.n = false;
  }
  
  public void f()
  {
    StatusManager localStatusManager = this.j;
    if (localStatusManager != null)
    {
      localStatusManager.b(this.k);
      this.j.b(this.l);
      this.j.b(this.m);
    }
  }
  
  public void i()
  {
    this.j = ((StatusManager)this.c.getManager(QQManagerFactory.STATUS_MANAGER));
    if (this.j == null) {
      return;
    }
    if (this.k == null) {
      m();
    }
    QQSettingMeRichStatusBean localQQSettingMeRichStatusBean = new QQSettingMeRichStatusBean();
    localQQSettingMeRichStatusBean.a = this.j.b(false);
    if ((localQQSettingMeRichStatusBean.a != null) && (!localQQSettingMeRichStatusBean.a.isEmpty()))
    {
      localQQSettingMeRichStatusBean.b = this.j.a(localQQSettingMeRichStatusBean.a.actionId, 200);
      this.i.setValue(localQQSettingMeRichStatusBean);
      return;
    }
    ThreadManager.getFileThreadHandler().post(new QQSettingMeSignatureProcessor.4(this, localQQSettingMeRichStatusBean));
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(100450));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
      ((IRedTouchManager)localObject).reportLevelOneRedInfo(100450, 31);
    }
    localObject = this.j;
    if ((localObject != null) && (!((StatusManager)localObject).b()))
    {
      if (((Boolean)paramView.getTag()).booleanValue())
      {
        paramView = new Bundle();
        paramView.putInt("from_type", 3);
        SignTextEditFragment.a(this.d, a().a, "", paramView, -1);
      }
      com.tencent.mobileqq.activity.recent.DrawerFrame.b = 0;
    }
    ReportController.b(this.c, "CliOper", "", "", "signiture", "set_enter", 0, 0, "", "", "", "");
    ReportController.b(this.c, "CliOper", "", "", "0X80072D8", "0X80072D8", 0, 0, "", "", "", "");
    ReportController.b(this.c, "CliOper", "", "", "0X800A669", "0X800A669", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor
 * JD-Core Version:    0.7.0.1
 */