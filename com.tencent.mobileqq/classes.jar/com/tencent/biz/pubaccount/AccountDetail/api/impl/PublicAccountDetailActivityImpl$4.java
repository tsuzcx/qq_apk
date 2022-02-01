package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.UnFollowResponse;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountDetailActivityImpl$4
  implements BusinessObserver
{
  PublicAccountDetailActivityImpl$4(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unfollow isSuccess:");
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
      if (this.a.uin != null) {
        try
        {
          ((JSONObject)localObject).put("uin", this.a.uin);
          ArrayList localArrayList = new ArrayList();
          localArrayList.add("find.mp.qq.com");
          localArrayList.add("post.mp.qq.com");
          localArrayList.add("article.mp.qq.com");
          EventApiPlugin.a("unfollow", (JSONObject)localObject, localArrayList, null);
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
        break label348;
      }
      mobileqq_mp.UnFollowResponse localUnFollowResponse = new mobileqq_mp.UnFollowResponse();
      localUnFollowResponse.mergeFrom(paramBundle);
      if (((mobileqq_mp.RetInfo)localUnFollowResponse.ret_info.get()).ret_code.get() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "unfollow success");
        }
        this.a.updateUnfollowInfo();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.app, "P_CliOper", "Pb_account_lifeservice", this.a.uin, "0X8005A2D", "0X8005A2D", 0, 0, "", "", "", "", false);
        StructLongMessageDownloadProcessor.deleteTask(this.a.app, this.a.uin);
        if (this.a.accountDetail != null) {
          ((TroopBindPublicAccountMgr)this.a.app.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.a.accountDetail.uin);
        }
      }
      else
      {
        this.a.displayToast(2131892951);
      }
    }
    catch (Exception paramBundle)
    {
      break label348;
    }
    this.a.displayToast(2131892951);
    label348:
    paramBundle = this.a;
    paramBundle.waitingCount -= 1;
    if (this.a.waitingCount == 0) {
      this.a.removeLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.4
 * JD-Core Version:    0.7.0.1
 */