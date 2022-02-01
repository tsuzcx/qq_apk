package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.NewPublicAccountObserver.ResponseResultListener;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96.RspBody;

class PublicAccountDetailActivityImpl$9
  extends NewPublicAccountObserver.ResponseResultListener
{
  PublicAccountDetailActivityImpl$9(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public int a()
  {
    return 4;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof oidb_cmd0xc96.RspBody))
    {
      paramObject = (oidb_cmd0xc96.RspBody)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, new Object[] { "0xc96 responseBody success, wording=", paramObject.wording.get() });
      }
      paramObject = new JSONObject();
      if (this.a.accountDetail == null) {}
    }
    try
    {
      paramObject.put("uin", this.a.accountDetail.uin);
      paramObject.put("name", this.a.accountDetail.name);
      paramObject.put("summary", this.a.accountDetail.summary);
      paramObject.put("certified", this.a.accountDetail.certifiedGrade);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("find.mp.qq.com");
      localArrayList.add("post.mp.qq.com");
      localArrayList.add("article.mp.qq.com");
      EventApiPlugin.a("follow", paramObject, localArrayList, null);
      if (this.a.mIsReportMessage)
      {
        if (this.a.accountDetail != null)
        {
          paramObject = this.a.accountDetail.uin;
          ReportController.b(this.a.app, "P_CliOper", "Pb_account_lifeservice", this.a.uin, "mp_msg_sys_12", "scan_via", 0, 0, paramObject, "", "", this.a.mSendMessage);
        }
      }
      else
      {
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
          int i = this.a.mIntent.getIntExtra("report_business_tvalue", -1);
          paramObject = this.a.mIntent.getStringExtra("strp1");
          if (i != -1) {
            ((EcshopReportHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(i, this.a.uin, paramObject, null, null, 0L, false);
          }
        }
        return;
      }
    }
    catch (JSONException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
        continue;
        paramObject = "";
      }
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(Object paramObject)
  {
    this.a.displayToast(2131695222);
  }
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    paramObject = this.a;
    paramObject.waitingCount -= 1;
    if (this.a.waitingCount == 0) {
      this.a.removeLoading();
    }
    this.a.followBtn.postDelayed(new PublicAccountDetailActivityImpl.9.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.9
 * JD-Core Version:    0.7.0.1
 */