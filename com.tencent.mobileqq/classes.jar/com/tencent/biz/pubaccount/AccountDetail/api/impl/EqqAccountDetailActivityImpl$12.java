package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
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

class EqqAccountDetailActivityImpl$12
  implements BusinessObserver
{
  EqqAccountDetailActivityImpl$12(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.a.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("follow isSuccess:");
      ((StringBuilder)localObject2).append(String.valueOf(paramBoolean));
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (!paramBoolean)
    {
      this.a.displayToast(2131695217);
    }
    else
    {
      localObject1 = new JSONObject();
      ((FriendListHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true, false);
      if (this.a.eqqDetail != null) {
        try
        {
          ((JSONObject)localObject1).put("uin", this.a.eqqDetail.uin);
          ((JSONObject)localObject1).put("name", this.a.eqqDetail.name);
          ((JSONObject)localObject1).put("summary", this.a.eqqDetail.summary);
          ((JSONObject)localObject1).put("certified", this.a.eqqDetail.certifiedGrade);
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add("find.mp.qq.com");
          ((ArrayList)localObject2).add("post.mp.qq.com");
          ((ArrayList)localObject2).add("article.mp.qq.com");
          EventApiPlugin.a("follow", (JSONObject)localObject1, (ArrayList)localObject2, null);
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
        break label533;
      }
      mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
      localFollowResponse.mergeFrom(paramBundle);
      paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
      if (paramInt == 0)
      {
        this.a.eqqDetail.followType = 1;
        this.a.followBtn.setEnabled(false);
        this.a.setFollowStatus();
        this.a.updateFollowInfo();
        this.a.showAttentionSuccessDlgIfJumpFromOtherApp();
        PublicAccountDetailActivityImpl.reportEvents(this.a.app, this.a.uin, this.a.mIntent);
        if ((!TextUtils.isEmpty(this.a.sopType)) && (!TextUtils.isEmpty(this.a.sopName)))
        {
          ReportController.b(this.a.app, "CliOper", "", "", this.a.sopType, this.a.sopName, 0, 0, "", "", this.a.app.getCurrentAccountUin(), this.a.uin);
          if (QLog.isColorLevel()) {
            QLog.d(this.a.TAG, 2, "----[follow report done]----");
          }
        }
      }
      else if (paramInt == 58)
      {
        this.a.displayToast(2131695212);
      }
      else if (paramInt == 65)
      {
        this.a.displayToast(2131695185);
      }
      else if (paramInt == 20)
      {
        this.a.displayToast(2131695186);
      }
      else
      {
        this.a.displayToast(2131695217);
      }
    }
    catch (Exception paramBundle)
    {
      break label533;
    }
    this.a.displayToast(2131695217);
    label533:
    paramBundle = this.a;
    paramBundle.waitingCount -= 1;
    if (this.a.waitingCount == 0) {
      this.a.removeLoading();
    }
    this.a.followBtn.postDelayed(new EqqAccountDetailActivityImpl.12.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.12
 * JD-Core Version:    0.7.0.1
 */