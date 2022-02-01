package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.MenumItem;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDynamicItemBean;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeKingCardBean;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vip.QQSettingConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class QQSettingMeKingCardProcessor
  extends QQSettingMeBaseMenuProcessor
{
  private static String j = "";
  public MutableLiveData<QQSettingMeKingCardBean> b = new MutableLiveData();
  public MutableLiveData<QQSettingMeDynamicItemBean> i = new MutableLiveData();
  private String k = "";
  
  @NonNull
  private QQSettingMeKingCardBean a()
  {
    if (this.b.getValue() == null) {
      return new QQSettingMeKingCardBean();
    }
    return (QQSettingMeKingCardBean)this.b.getValue();
  }
  
  @NotNull
  private String a(String paramString, SharedPreferences paramSharedPreferences, boolean paramBoolean)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(j))) {
      return j;
    }
    paramSharedPreferences = paramSharedPreferences.getString("drawerUrl", "");
    if (TextUtils.isEmpty(paramSharedPreferences)) {
      QLog.e("QQSettingRedesign", 1, "cuKingCard url = null");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramSharedPreferences);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void c(String paramString)
  {
    if (!VasUtils.b())
    {
      if (this.d == null) {
        return;
      }
      Intent localIntent = new Intent(this.d, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      this.d.startActivity(localIntent);
    }
  }
  
  private void l()
  {
    Object localObject1 = QQSettingConfigManager.a().a((QQAppInterface)this.c);
    Object localObject2 = Integer.valueOf(5);
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
    if (!QQSettingMe.c("d_vip_card").h()) {
      return;
    }
    j = "";
    ArrayList localArrayList = new ArrayList();
    TianShuAdPosItemData localTianShuAdPosItemData = new TianShuAdPosItemData();
    localTianShuAdPosItemData.a = 76;
    localTianShuAdPosItemData.b = 1;
    localArrayList.add(localTianShuAdPosItemData);
    TianShuManager.getInstance().requestAdv(localArrayList, new QQSettingMeKingCardProcessor.3(this));
  }
  
  public void a(View paramView)
  {
    paramView = this.c;
    Object localObject1 = "";
    Object localObject2 = (IRedTouchManager)paramView.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject2).getAppInfoByPath(String.valueOf(100500));
    paramView = (View)localObject1;
    if (localAppInfo != null)
    {
      paramView = (View)localObject1;
      if (localAppInfo.iNewFlag.get() != 0)
      {
        paramView = MobileReportManager.getStringReport2H5(localAppInfo);
        ((IRedTouchManager)localObject2).reportLevelOneRedInfo(100500, 31);
      }
    }
    localObject1 = BaseApplicationImpl.getApplication();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("CUKingCardFile_");
    ((StringBuilder)localObject2).append(this.c.getCurrentAccountUin());
    localObject1 = ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    boolean bool = QQSettingMe.c("d_vip_card").h();
    c(a(paramView, (SharedPreferences)localObject1, bool));
    int m = VipInfoHandler.a((QQAppInterface)this.c, this.c.getCurrentUin(), bool);
    ReportController.b(this.c, "dc00898", "", "", "0X800A8C0", "0X800A8C0", m, 0, String.valueOf(m), this.k, a().e, "");
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    super.a(paramQQSettingMe);
    this.b.observe(this.e, new QQSettingMeKingCardProcessor.1(this, paramQQSettingMe));
    this.i.observe(this.e, new QQSettingMeKingCardProcessor.2(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    super.a(paramAppInfo, paramBoolean);
    m();
  }
  
  public String b()
  {
    return "d_vip_card";
  }
  
  public void c()
  {
    l();
  }
  
  public void d()
  {
    super.d();
    l();
    i();
    int m = VipInfoHandler.a((QQAppInterface)this.c, this.c.getCurrentUin(), false);
    if (QQSettingMe.b("d_vip_card").getVisibility() == 0) {
      ReportController.b(this.c, "dc00898", "", "", "0X800A8C5", "0X800A8C5", m, 0, String.valueOf(m), this.k, a().e, "");
    }
  }
  
  public void h()
  {
    l();
  }
  
  public void i()
  {
    QQSettingMeKingCardBean localQQSettingMeKingCardBean = a();
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CUKingCardFile_");
    localStringBuilder.append(this.c.getCurrentAccountUin());
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    boolean bool2 = false;
    boolean bool3 = ((SharedPreferences)localObject).getBoolean("drawerEnable", false);
    localQQSettingMeKingCardBean.d = QQSettingConfigManager.a().a((QQAppInterface)this.c, 32);
    localQQSettingMeKingCardBean.b = ((SharedPreferences)localObject).getString("drawerText", "");
    localQQSettingMeKingCardBean.c = ((SharedPreferences)localObject).getString("drawerUrl", "");
    localQQSettingMeKingCardBean.e = ((SharedPreferences)localObject).getString("sDrawerTextRuleID", "");
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(localQQSettingMeKingCardBean.b))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(localQQSettingMeKingCardBean.c)) {
          bool1 = true;
        }
      }
    }
    localQQSettingMeKingCardBean.a = bool1;
    if (localQQSettingMeKingCardBean.a) {
      this.k = ((SharedPreferences)localObject).getString("drawerTextID", "");
    } else {
      this.k = "";
    }
    this.b.setValue(localQQSettingMeKingCardBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeKingCardProcessor
 * JD-Core Version:    0.7.0.1
 */