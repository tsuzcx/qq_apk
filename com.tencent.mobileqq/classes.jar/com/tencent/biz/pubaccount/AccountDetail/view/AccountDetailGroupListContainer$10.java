package com.tencent.biz.pubaccount.accountdetail.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PhotoWallViewForAccountDetail.PhotoWallCallback;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AccountDetailGroupListContainer$10
  implements PhotoWallViewForAccountDetail.PhotoWallCallback
{
  AccountDetailGroupListContainer$10(AccountDetailGroupListContainer paramAccountDetailGroupListContainer) {}
  
  public void a(IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo)
  {
    if (paramPaConfigInfo == null) {
      return;
    }
    String str = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_JavaLangString, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
    if (paramPaConfigInfo.a == 3)
    {
      if (paramPaConfigInfo.jdField_c_of_type_Int == 7)
      {
        if (!TextUtils.isEmpty(paramPaConfigInfo.g))
        {
          if (TextUtils.isEmpty(paramPaConfigInfo.f)) {
            return;
          }
          if (TextUtils.isEmpty(paramPaConfigInfo.b)) {
            return;
          }
          localObject = new Intent((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), QQMapActivity.class);
          ((Intent)localObject).putExtra("lat", paramPaConfigInfo.g);
          ((Intent)localObject).putExtra("lon", paramPaConfigInfo.f);
          ((Intent)localObject).putExtra("loc", paramPaConfigInfo.b);
          ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity((Intent)localObject);
          return;
        }
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 8)
      {
        paramPaConfigInfo = paramPaConfigInfo.h;
        if (!TextUtils.isEmpty(paramPaConfigInfo))
        {
          paramPaConfigInfo = paramPaConfigInfo.trim();
          if (!Pattern.compile("[\\d-]+?").matcher(paramPaConfigInfo).matches()) {
            return;
          }
          AccountDetailGroupListContainer.b(this.a, paramPaConfigInfo);
          return;
        }
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 13) {
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 11)
      {
        paramPaConfigInfo = new Intent();
        paramPaConfigInfo.putExtra("from", this.a.jdField_a_of_type_JavaLangRefWeakReference.getClass().getName());
        RouteUtils.a((Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), paramPaConfigInfo, "/qrscan/scanner");
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 16) {
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 20)
      {
        AccountDetailGroupListContainer.a(this.a);
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 2)
      {
        ShareActionSheet.b((Activity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new ShareActionSheet.Detail(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name, this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary), 1, AccountDetailGroupListContainer.a(this.a));
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 17)
      {
        ShareActionSheet.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new ShareActionSheet.Detail(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name, this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary), 1, AccountDetailGroupListContainer.a(this.a));
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 19)
      {
        ShareActionSheet.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new ShareActionSheet.Detail(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name, this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary), 1, AccountDetailGroupListContainer.a(this.a), 9);
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 18)
      {
        ShareActionSheet.a((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), new ShareActionSheet.Detail(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name, this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.summary), 1, AccountDetailGroupListContainer.a(this.a), 10);
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 21) {
        return;
      }
      if (paramPaConfigInfo.jdField_c_of_type_Int == 22)
      {
        paramPaConfigInfo = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
        AccountDetailGroupListContainer.c(this.a, paramPaConfigInfo);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unhandled event_id: ");
        ((StringBuilder)localObject).append(paramPaConfigInfo.jdField_c_of_type_Int);
        QLog.d("AccountDetailGroupListContainer", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (paramPaConfigInfo.a == 1)
    {
      paramPaConfigInfo = paramPaConfigInfo.jdField_c_of_type_JavaLangString;
      AccountDetailGroupListContainer.c(this.a, paramPaConfigInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.10
 * JD-Core Version:    0.7.0.1
 */