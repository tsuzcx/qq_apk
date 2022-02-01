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
    String str = paramPaConfigInfo.h;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.b, "P_CliOper", "Pb_account_lifeservice", this.a.g, "0X8005A28", "0X8005A28", 0, 0, (String)localObject, "", "", "", false);
    if (paramPaConfigInfo.a == 3)
    {
      if (paramPaConfigInfo.e == 7)
      {
        if (!TextUtils.isEmpty(paramPaConfigInfo.m))
        {
          if (TextUtils.isEmpty(paramPaConfigInfo.l)) {
            return;
          }
          if (TextUtils.isEmpty(paramPaConfigInfo.c)) {
            return;
          }
          localObject = new Intent((Context)this.a.a.get(), QQMapActivity.class);
          ((Intent)localObject).putExtra("lat", paramPaConfigInfo.m);
          ((Intent)localObject).putExtra("lon", paramPaConfigInfo.l);
          ((Intent)localObject).putExtra("loc", paramPaConfigInfo.c);
          ((BaseActivity)this.a.a.get()).startActivity((Intent)localObject);
          return;
        }
        return;
      }
      if (paramPaConfigInfo.e == 8)
      {
        paramPaConfigInfo = paramPaConfigInfo.n;
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
      if (paramPaConfigInfo.e == 13) {
        return;
      }
      if (paramPaConfigInfo.e == 11)
      {
        paramPaConfigInfo = new Intent();
        paramPaConfigInfo.putExtra("from", this.a.a.getClass().getName());
        RouteUtils.a((Context)this.a.a.get(), paramPaConfigInfo, "/qrscan/scanner");
        return;
      }
      if (paramPaConfigInfo.e == 16) {
        return;
      }
      if (paramPaConfigInfo.e == 20)
      {
        AccountDetailGroupListContainer.a(this.a);
        return;
      }
      if (paramPaConfigInfo.e == 2)
      {
        ShareActionSheet.b((Activity)this.a.a.get(), new ShareActionSheet.Detail(this.a.g, this.a.f.name, this.a.f.summary), 1, AccountDetailGroupListContainer.b(this.a));
        return;
      }
      if (paramPaConfigInfo.e == 17)
      {
        ShareActionSheet.a((BaseActivity)this.a.a.get(), new ShareActionSheet.Detail(this.a.g, this.a.f.name, this.a.f.summary), 1, AccountDetailGroupListContainer.b(this.a));
        return;
      }
      if (paramPaConfigInfo.e == 19)
      {
        ShareActionSheet.a((BaseActivity)this.a.a.get(), new ShareActionSheet.Detail(this.a.g, this.a.f.name, this.a.f.summary), 1, AccountDetailGroupListContainer.b(this.a), 9);
        return;
      }
      if (paramPaConfigInfo.e == 18)
      {
        ShareActionSheet.a((BaseActivity)this.a.a.get(), new ShareActionSheet.Detail(this.a.g, this.a.f.name, this.a.f.summary), 1, AccountDetailGroupListContainer.b(this.a), 10);
        return;
      }
      if (paramPaConfigInfo.e == 21) {
        return;
      }
      if (paramPaConfigInfo.e == 22)
      {
        paramPaConfigInfo = paramPaConfigInfo.h;
        AccountDetailGroupListContainer.c(this.a, paramPaConfigInfo);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("unhandled event_id: ");
        ((StringBuilder)localObject).append(paramPaConfigInfo.e);
        QLog.d("AccountDetailGroupListContainer", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (paramPaConfigInfo.a == 1)
    {
      paramPaConfigInfo = paramPaConfigInfo.h;
      AccountDetailGroupListContainer.c(this.a, paramPaConfigInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.10
 * JD-Core Version:    0.7.0.1
 */