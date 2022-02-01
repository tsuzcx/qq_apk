package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

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
    if (QLog.isColorLevel()) {
      QLog.d(this.a.TAG, 2, "follow isSuccess:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      this.a.displayToast(2131695222);
    }
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.waitingCount -= 1;
      if (this.a.waitingCount == 0) {
        this.a.removeLoading();
      }
      this.a.followBtn.postDelayed(new EqqAccountDetailActivityImpl.12.1(this), 1000L);
      return;
      Object localObject = new JSONObject();
      ((FriendListHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true, false);
      if (this.a.eqqDetail != null) {}
      try
      {
        ((JSONObject)localObject).put("uin", this.a.eqqDetail.uin);
        ((JSONObject)localObject).put("name", this.a.eqqDetail.name);
        ((JSONObject)localObject).put("summary", this.a.eqqDetail.summary);
        ((JSONObject)localObject).put("certified", this.a.eqqDetail.certifiedGrade);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add("find.mp.qq.com");
        localArrayList.add("post.mp.qq.com");
        localArrayList.add("article.mp.qq.com");
        EventApiPlugin.a("follow", (JSONObject)localObject, localArrayList, null);
        if (!paramBoolean) {
          break label563;
        }
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle == null) {
            continue;
          }
          localObject = new mobileqq_mp.FollowResponse();
          ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
          paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
          if (paramInt == 0)
          {
            this.a.eqqDetail.followType = 1;
            this.a.followBtn.setEnabled(false);
            this.a.setFollowStatus();
            this.a.updateFollowInfo();
            this.a.showAttentionSuccessDlgIfJumpFromOtherApp();
            PublicAccountDetailActivityImpl.reportEvents(this.a.app, this.a.uin, this.a.mIntent);
            if ((TextUtils.isEmpty(this.a.sopType)) || (TextUtils.isEmpty(this.a.sopName))) {
              continue;
            }
            ReportController.b(this.a.app, "CliOper", "", "", this.a.sopType, this.a.sopName, 0, 0, "", "", this.a.app.getCurrentAccountUin(), this.a.uin);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(this.a.TAG, 2, "----[follow report done]----");
          }
        }
        catch (Exception paramBundle) {}
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        if (paramInt == 58)
        {
          this.a.displayToast(2131695218);
          continue;
        }
        if (paramInt == 65)
        {
          this.a.displayToast(2131695193);
          continue;
        }
        if (paramInt == 20)
        {
          this.a.displayToast(2131695194);
          continue;
        }
        this.a.displayToast(2131695222);
      }
      continue;
      label563:
      this.a.displayToast(2131695222);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.12
 * JD-Core Version:    0.7.0.1
 */