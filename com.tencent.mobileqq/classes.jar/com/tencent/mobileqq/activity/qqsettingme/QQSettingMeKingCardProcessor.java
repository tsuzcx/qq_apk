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
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vip.QQSettingConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.Map;
import mqq.app.AppRuntime;

public class QQSettingMeKingCardProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public MutableLiveData<QQSettingMeKingCardBean> b;
  private String b;
  public MutableLiveData<QQSettingMeDynamicItemBean> c = new MutableLiveData();
  
  public QQSettingMeKingCardProcessor()
  {
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  @NonNull
  private QQSettingMeKingCardBean a()
  {
    if (this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.getValue() == null) {
      return new QQSettingMeKingCardBean();
    }
    return (QQSettingMeKingCardBean)this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.getValue();
  }
  
  private void j()
  {
    Object localObject1 = QQSettingConfigManager.a().a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime);
    Object localObject2 = Integer.valueOf(5);
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
  
  public String a()
  {
    return "d_vip_card";
  }
  
  public void a()
  {
    j();
  }
  
  public void a(View paramView)
  {
    Object localObject = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    paramView = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(100500));
    if ((paramView != null) && (paramView.iNewFlag.get() != 0))
    {
      paramView = MobileReportManager.getStringReport2H5(paramView);
      ((IRedTouchManager)localObject).reportLevelOneRedInfo(100500, 31);
    }
    else
    {
      paramView = "";
    }
    localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CUKingCardFile_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 4).getString("drawerUrl", "");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      QLog.e("QQSettingRedesign", 1, "cuKingCard url = null");
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramView);
    paramView = localStringBuilder.toString();
    localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramView);
    ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject);
    boolean bool = QQSettingMe.a("d_vip_card").c();
    int i = VipInfoHandler.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), bool);
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A8C0", "0X800A8C0", i, 0, String.valueOf(i), this.jdField_b_of_type_JavaLangString, "", "");
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    super.a(paramQQSettingMe);
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeKingCardProcessor.1(this, paramQQSettingMe));
    this.c.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeKingCardProcessor.2(this, paramQQSettingMe));
  }
  
  public void b()
  {
    super.b();
    j();
    g();
    int i = VipInfoHandler.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentUin(), false);
    if (QQSettingMe.a("d_vip_card").getVisibility() == 0) {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A8C5", "0X800A8C5", i, 0, String.valueOf(i), this.jdField_b_of_type_JavaLangString, "", "");
    }
  }
  
  public void f()
  {
    j();
  }
  
  public void g()
  {
    QQSettingMeKingCardBean localQQSettingMeKingCardBean = a();
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CUKingCardFile_");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    boolean bool2 = false;
    boolean bool3 = ((SharedPreferences)localObject).getBoolean("drawerEnable", false);
    localQQSettingMeKingCardBean.jdField_b_of_type_Boolean = QQSettingConfigManager.a().a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, 32);
    localQQSettingMeKingCardBean.jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject).getString("drawerText", "");
    localQQSettingMeKingCardBean.jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject).getString("drawerUrl", "");
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(localQQSettingMeKingCardBean.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(localQQSettingMeKingCardBean.jdField_b_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    localQQSettingMeKingCardBean.jdField_a_of_type_Boolean = bool1;
    if (localQQSettingMeKingCardBean.jdField_a_of_type_Boolean) {
      this.jdField_b_of_type_JavaLangString = ((SharedPreferences)localObject).getString("drawerTextID", "");
    } else {
      this.jdField_b_of_type_JavaLangString = "";
    }
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.setValue(localQQSettingMeKingCardBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeKingCardProcessor
 * JD-Core Version:    0.7.0.1
 */