package com.tencent.mobileqq.activity.qqsettingme;

import android.net.Uri;
import android.os.Handler;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean.Action;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean.ActionType;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.FakeUrl;

public class QQSettingMeBaseMenuProcessor
  extends QQSettingMeBaseProcessor
{
  public final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> a = new MutableLiveData();
  
  protected void a(View paramView) {}
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.a.observe(this.e, new QQSettingMeBaseMenuProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    boolean bool;
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    QQSettingMeRedTouchUtil.a(paramAppInfo);
    if (!this.g) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeBaseMenuProcessor.2(this, paramBoolean, paramAppInfo, bool));
  }
  
  protected void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    Object localObject = QQSettingMe.a(b());
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, new Object[] { "onClick(), bizId = ", b(), ", bizBean == null" });
      }
      return;
    }
    localObject = ((QQSettingMeBizBean)localObject).g();
    if (Uri.parse(((QQSettingMeBizBean.Action)localObject).b) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, new Object[] { "QQSettingMeBaseMenuProcessor#onClick, ", ((QQSettingMeBizBean.Action)localObject).b, ", uri==null" });
      }
      ((QQSettingMeBizBean.Action)localObject).a = QQSettingMeBizBean.ActionType.DEFAULT;
    }
    FakeUrl localFakeUrl = new FakeUrl();
    localFakeUrl.init(this.d);
    int i = QQSettingMeBaseMenuProcessor.3.a[localObject.a.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          a(paramView);
          return;
        }
        localFakeUrl.gotoH5(this.d, ((QQSettingMeBizBean.Action)localObject).b, false, false);
        return;
      }
      localFakeUrl.gotoMqq(this.d, ((QQSettingMeBizBean.Action)localObject).b);
      return;
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.d, ((QQSettingMeBizBean.Action)localObject).b, 2066, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeBaseMenuProcessor
 * JD-Core Version:    0.7.0.1
 */