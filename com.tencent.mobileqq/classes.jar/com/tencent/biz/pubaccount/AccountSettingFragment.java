package com.tencent.biz.pubaccount;

import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.applets.AppletsHandler;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import mqq.os.MqqHandler;

public class AccountSettingFragment
  extends IphoneTitleBarFragment
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AccountSettingFragment.1(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private Integer jdField_a_of_type_JavaLangInteger;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private String b;
  
  private void a()
  {
    PublicAccountDataManager localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localPublicAccountDataManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = localPublicAccountDataManager.b(this.jdField_a_of_type_JavaLangString);
      b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      PublicAccountStQWebServletWrapper.getAccountDetail(Long.valueOf(Long.parseLong(this.jdField_a_of_type_JavaLangString)), null, new AccountSettingFragment.2(this));
    }
  }
  
  private void a(AccountDetail paramAccountDetail)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.getId() != -1L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IphoneTitleBarFragment", 2, paramAccountDetail.name);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.clone(paramAccountDetail);
      if (!localEntityManager.update(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail)) {
        localEntityManager.drop(AccountDetail.class);
      }
    }
    for (;;)
    {
      localEntityManager.close();
      paramAccountDetail = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (paramAccountDetail != null) {
        paramAccountDetail.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
      localEntityManager.persist(paramAccountDetail);
    }
  }
  
  private void b()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new AccountSettingFragment.3(this));
      return;
    }
    c();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangInteger = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getMessageSetting(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    if ((this.jdField_a_of_type_JavaLangInteger != null) && (this.jdField_a_of_type_JavaLangInteger.intValue() == 1))
    {
      this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(false);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {}
    AppletsHandler localAppletsHandler;
    do
    {
      return;
      localAppletsHandler = (AppletsHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APPLET_PUSH_HANDLER);
    } while (localAppletsHandler == null);
    String str1;
    String str2;
    if (this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked())
    {
      i = 1;
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(i);
      str1 = this.jdField_a_of_type_JavaLangString;
      str2 = this.b;
      if (!this.jdField_a_of_type_ComTencentWidgetSwitch.isChecked()) {
        break label136;
      }
    }
    label136:
    for (int i = 1;; i = 0)
    {
      localAppletsHandler.a(str1, str2, i);
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).setMessageSetting(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, this.jdField_a_of_type_JavaLangInteger.intValue());
      a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
      if (this.jdField_a_of_type_JavaLangInteger.intValue() != 1) {
        break label141;
      }
      OfficialAccountReporter.a.i(this.jdField_a_of_type_JavaLangString);
      return;
      i = 3;
      break;
    }
    label141:
    OfficialAccountReporter.a.j(this.jdField_a_of_type_JavaLangString);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppRuntime());
    }
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)this.mContentView.findViewById(2131362915));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    paramLayoutInflater = getArguments();
    this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getString("uin");
    this.b = paramLayoutInflater.getString("name");
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559763;
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131695253));
    if (!ThemeUtil.a(BaseApplicationImpl.getApplication().getRuntime())) {
      this.vg.changeBg(true);
    }
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountSettingFragment
 * JD-Core Version:    0.7.0.1
 */