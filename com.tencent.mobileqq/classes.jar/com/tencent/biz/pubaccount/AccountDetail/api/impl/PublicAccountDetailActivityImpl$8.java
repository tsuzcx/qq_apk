package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountDetailActivityImpl$8
  implements BusinessObserver
{
  PublicAccountDetailActivityImpl$8(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("follow isSuccess:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      this.a.displayToast(2131892951);
    }
    else
    {
      localObject = new JSONObject();
      if (this.a.accountDetail != null) {
        try
        {
          ((JSONObject)localObject).put("uin", this.a.accountDetail.uin);
          ((JSONObject)localObject).put("name", this.a.accountDetail.name);
          ((JSONObject)localObject).put("summary", this.a.accountDetail.summary);
          ((JSONObject)localObject).put("certified", this.a.accountDetail.certifiedGrade);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add("find.mp.qq.com");
          localArrayList.add("post.mp.qq.com");
          localArrayList.add("article.mp.qq.com");
          EventApiPlugin.a("follow", (JSONObject)localObject, localArrayList, null);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      if (!paramBoolean) {}
    }
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label713;
      }
      mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
      localFollowResponse.mergeFrom(paramBundle);
      paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
      if (paramInt != 0) {
        break label651;
      }
      if (!this.a.mIsReportMessage) {
        break label330;
      }
      if (this.a.accountDetail == null) {
        break label772;
      }
      paramBundle = this.a.accountDetail.uin;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        continue;
        paramBundle = "";
      }
    }
    ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", this.a.uin, "mp_msg_sys_12", "scan_via", 0, 0, paramBundle, "", "", this.a.mSendMessage);
    label330:
    this.a.accountDetail.followType = 1;
    this.a.followBtn.setEnabled(false);
    this.a.setFollowStatus();
    this.a.updateFollowInfo();
    this.a.showAttentionSuccessDlgIfJumpFromOtherApp();
    PublicAccountDetailActivityImpl.reportEvents(this.a.app, this.a.uin, this.a.mIntent);
    if ((!TextUtils.isEmpty(this.a.sopType)) && (!TextUtils.isEmpty(this.a.sopName)))
    {
      ReportController.b(this.a.app, "CliOper", "", "", this.a.sopType, this.a.sopName, 0, 0, "", "", this.a.app.getCurrentAccountUin(), this.a.uin);
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "----[follow report done]----");
      }
    }
    if (this.a.fromwhere == 50) {
      PublicAccountDetailActivityImpl.access$400(this.a, 1);
    }
    if ((this.a.mSource == 115) && (this.a.app != null)) {
      ((EcshopReportHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(134247140, this.a.uin, null, null, null, 0L, false);
    }
    if (this.a.mIntent.hasExtra("report_business_tvalue"))
    {
      paramInt = this.a.mIntent.getIntExtra("report_business_tvalue", -1);
      paramBundle = this.a.mIntent.getStringExtra("strp1");
      if (paramInt != -1)
      {
        ((EcshopReportHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(paramInt, this.a.uin, paramBundle, null, null, 0L, false);
        break label713;
        label651:
        if (paramInt == 58)
        {
          this.a.displayToast(2131892946);
        }
        else if (paramInt == 65)
        {
          this.a.displayToast(2131892918);
        }
        else
        {
          this.a.displayToast(2131892951);
          break label713;
          this.a.displayToast(2131892951);
        }
      }
    }
    label713:
    paramBundle = this.a;
    paramBundle.waitingCount -= 1;
    if (this.a.waitingCount == 0) {
      this.a.removeLoading();
    }
    this.a.followBtn.postDelayed(new PublicAccountDetailActivityImpl.8.1(this), 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.8
 * JD-Core Version:    0.7.0.1
 */