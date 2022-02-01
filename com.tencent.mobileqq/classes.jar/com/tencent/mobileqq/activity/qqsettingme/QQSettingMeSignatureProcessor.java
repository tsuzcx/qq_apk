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
  public final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> a;
  private IActionListener jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener;
  private IIconListener jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener;
  private IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  public MutableLiveData<QQSettingMeSignatureBean> b;
  private boolean b;
  public MutableLiveData<QQSettingMeRichStatusBean> c;
  private boolean c;
  
  public QQSettingMeSignatureProcessor()
  {
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
    this.jdField_c_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  @NonNull
  private QQSettingMeRichStatusBean a()
  {
    if (this.jdField_c_of_type_AndroidxLifecycleMutableLiveData.getValue() == null) {
      return new QQSettingMeRichStatusBean();
    }
    return (QQSettingMeRichStatusBean)this.jdField_c_of_type_AndroidxLifecycleMutableLiveData.getValue();
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.STATUS_MANAGER));
    QQSettingMeSignatureBean localQQSettingMeSignatureBean = new QQSettingMeSignatureBean();
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qqsettingme_signature");
    localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    localQQSettingMeSignatureBean.jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject).getString("actionText", "");
    localQQSettingMeSignatureBean.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("actionId", 0);
    localQQSettingMeSignatureBean.b = ((SharedPreferences)localObject).getString("dataText", "");
    localQQSettingMeSignatureBean.d = ((SharedPreferences)localObject).getString("plainText", "");
    localQQSettingMeSignatureBean.c = ((SharedPreferences)localObject).getString("topics", "");
    localQQSettingMeSignatureBean.e = ((SharedPreferences)localObject).getString("plainMixTopic", "");
    localQQSettingMeSignatureBean.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localQQSettingMeSignatureBean.jdField_a_of_type_Int, 200);
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.setValue(localQQSettingMeSignatureBean);
  }
  
  private void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new QQSettingMeSignatureProcessor.6(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener = new QQSettingMeSignatureProcessor.7(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener = new QQSettingMeSignatureProcessor.8(this);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
  }
  
  public String a()
  {
    return "d_signature";
  }
  
  public void a()
  {
    j();
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    this.jdField_b_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeSignatureProcessor.1(this, paramQQSettingMe));
    this.jdField_c_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeSignatureProcessor.2(this, paramQQSettingMe));
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.observe(this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, new QQSettingMeSignatureProcessor.3(this, paramQQSettingMe));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      StatusManager localStatusManager = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
      if (localStatusManager != null)
      {
        localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
        this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
      }
      this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
      g();
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
  }
  
  public void a(boolean paramBoolean)
  {
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath(String.valueOf(100450));
    QQSettingMeRedTouchUtil.a(localAppInfo);
    if (this.jdField_b_of_type_Boolean) {
      ThreadManagerV2.getUIHandlerV2().post(new QQSettingMeSignatureProcessor.5(this, localAppInfo));
    }
  }
  
  public void b()
  {
    super.b();
    g();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void c()
  {
    super.c();
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void d()
  {
    StatusManager localStatusManager = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    if (localStatusManager != null)
    {
      localStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIIconListener);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIActionListener);
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.STATUS_MANAGER));
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener == null) {
      k();
    }
    QQSettingMeRichStatusBean localQQSettingMeRichStatusBean = new QQSettingMeRichStatusBean();
    localQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(false);
    if ((localQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null) && (!localQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.isEmpty()))
    {
      localQQSettingMeRichStatusBean.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localQQSettingMeRichStatusBean.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus.actionId, 200);
      this.jdField_c_of_type_AndroidxLifecycleMutableLiveData.setValue(localQQSettingMeRichStatusBean);
      return;
    }
    ThreadManager.getFileThreadHandler().post(new QQSettingMeSignatureProcessor.4(this, localQQSettingMeRichStatusBean));
  }
  
  public void onClick(View paramView)
  {
    Object localObject = (IRedTouchManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRedTouchManager.class, "");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject).getAppInfoByPath(String.valueOf(100450));
    if ((localAppInfo != null) && (localAppInfo.iNewFlag.get() != 0)) {
      ((IRedTouchManager)localObject).reportLevelOneRedInfo(100450, 31);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
    if ((localObject != null) && (!((StatusManager)localObject).a()))
    {
      if (((Boolean)paramView.getTag()).booleanValue())
      {
        paramView = new Bundle();
        paramView.putInt("from_type", 3);
        SignTextEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, a().jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus, "", paramView, -1);
      }
      com.tencent.mobileqq.activity.recent.DrawerFrame.jdField_a_of_type_Int = 0;
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "signiture", "set_enter", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X80072D8", "0X80072D8", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X800A669", "0X800A669", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSignatureProcessor
 * JD-Core Version:    0.7.0.1
 */