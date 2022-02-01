package com.tencent.mobileqq.activity.qqsettingme;

import MQQ.MenumItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.av.chatroom.ChatRoomUtil;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeDynamicItemBean;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.QQSettingConfigManager;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQSettingMeDressUpProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public final MutableLiveData<QQSettingMeDynamicItemBean> b = new MutableLiveData();
  
  private void a()
  {
    Object localObject1 = QQSettingConfigManager.a().a((QQAppInterface)this.c);
    Object localObject2 = Integer.valueOf(3);
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
    this.b.postValue(localObject1);
  }
  
  private void b(String paramString)
  {
    if (!VasUtils.b())
    {
      if (this.d == null) {
        return;
      }
      VasWebviewUtil.a(this.d, paramString);
    }
  }
  
  public void a(View paramView)
  {
    paramView = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
    Object localObject = paramView.getAppInfoByPath(String.valueOf(100005));
    int i;
    if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() != 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramView.reportLevelOneRedInfo(100005, 31);
    }
    if (i != 0) {
      paramView = MobileReportManager.getNewReportInfo((BusinessInfoCheckUpdate.AppInfo)localObject);
    } else {
      paramView = MobileReportManager.getNewDefaultReportInfo("outside", "3");
    }
    b(paramView);
    ThreadManager.post(new QQSettingMeDressUpProcessor.2(this), 5, null, true);
    paramView = QQSettingConfigManager.a().a((QQAppInterface)this.c, "key_svip_item_makup_");
    if (paramView != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramView.user_group);
      ((StringBuilder)localObject).append("");
      paramView = ((StringBuilder)localObject).toString();
    }
    else
    {
      paramView = "0";
    }
    MobileReportManager.getInstance().qqSetingMeReport(6, 102, paramView);
    ReportController.b(this.c, "CliOper", "", "", "Trends_tab", "Personality_setting", 0, 0, "", "", "", "");
    com.tencent.mobileqq.activity.recent.DrawerFrame.b = QQSettingMe.a;
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    super.a(paramQQSettingMe);
    this.b.observe(this.e, new QQSettingMeDressUpProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = this.c.getApplication().getSharedPreferences(this.c.getCurrentAccountUin(), 0);
    if ((paramAppInfo != null) && (paramAppInfo.iNewFlag.get() == 1)) {
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", true).commit();
    } else {
      localSharedPreferences.edit().putBoolean("individuationIsForcePullSpKey", false).commit();
    }
    if (this.g) {
      ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeDressUpProcessor.3(this));
    }
    super.a(paramAppInfo, paramBoolean);
  }
  
  public String b()
  {
    return "d_decoration";
  }
  
  public void c()
  {
    a();
  }
  
  public void d()
  {
    super.d();
    Object localObject = QQSettingConfigManager.a().a((QQAppInterface)this.c, "key_svip_item_makup_");
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((MenumItem)localObject).user_group);
      localStringBuilder.append("");
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = "0";
    }
    MobileReportManager.getInstance().qqSetingMeReport(6, 101, (String)localObject);
    a();
  }
  
  public void h()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeDressUpProcessor
 * JD-Core Version:    0.7.0.1
 */