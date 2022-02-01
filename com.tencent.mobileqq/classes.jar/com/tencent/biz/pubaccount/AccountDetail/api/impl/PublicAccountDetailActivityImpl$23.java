package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.os.Bundle;
import com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

class PublicAccountDetailActivityImpl$23
  implements BusinessObserver
{
  PublicAccountDetailActivityImpl$23(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("success:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      if (this.a.isFirst) {
        if (this.a.mAccountDetailAdapter != null)
        {
          this.a.mAccountDetailAdapter.b(false);
          this.a.mAccountDetailAdapter.notifyDataSetChanged();
        }
        else
        {
          this.a.displayToast(2131892951);
        }
      }
    }
    else {
      try
      {
        localObject = paramBundle.getByteArray("data");
        paramInt = paramBundle.getInt("type", 0);
        if (localObject != null)
        {
          paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
          if (paramInt == 0)
          {
            paramBundle.mergeFrom((byte[])localObject);
            paramBoolean = true;
          }
          else
          {
            paramBoolean = PublicAccountUtilImpl.convert0xcf8ToMobileMP((byte[])localObject, localGetPublicAccountDetailInfoResponse, paramBundle);
          }
          if (paramBoolean)
          {
            if (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() == 0)
            {
              if ((this.a.accountDetail != null) && ((!paramBundle.seqno.has()) || (paramBundle.seqno.get() == this.a.accountDetail.seqno)))
              {
                if (QLog.isColorLevel())
                {
                  paramBundle = new StringBuilder();
                  paramBundle.append("sendPublicAccountDetailInfoRequest: seqno is same, no need to update, seqno = ");
                  paramBundle.append(this.a.accountDetail.seqno);
                  QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, paramBundle.toString());
                }
                if ((this.a.mIsSendMessage) && (this.a.accountDetail.followType == 1)) {
                  this.a.gotoChatActivity();
                }
              }
              else
              {
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("sendPublicAccountDetailInfoRequest: need update local data , new seqno = ");
                  ((StringBuilder)localObject).append(paramBundle.seqno.get());
                  QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, ((StringBuilder)localObject).toString());
                }
                this.a.gAccountData = paramBundle;
                paramBundle = new PublicAccountDetailImpl();
                paramBundle.init(this.a.gAccountData);
                if (PublicAccountUtilImpl.isShopOrServiceAccount(paramBundle)) {
                  this.a.send839PublicAccountDetailInfoRequest();
                } else if ((this.a.mIsSendMessage) && (paramBundle.followType == 1)) {
                  this.a.updateDetailInfo(paramBundle, false);
                } else {
                  this.a.updateDetailInfo(paramBundle, true);
                }
              }
            }
            else {
              this.a.displayToast(2131892951);
            }
          }
          else if (this.a.isFirst) {
            if (this.a.mAccountDetailAdapter != null)
            {
              this.a.mAccountDetailAdapter.b(false);
              this.a.mAccountDetailAdapter.notifyDataSetChanged();
            }
            else
            {
              this.a.displayToast(2131892951);
            }
          }
        }
        else if (this.a.isFirst)
        {
          if (this.a.mAccountDetailAdapter != null)
          {
            this.a.mAccountDetailAdapter.b(false);
            this.a.mAccountDetailAdapter.notifyDataSetChanged();
          }
          else
          {
            this.a.displayToast(2131892951);
          }
        }
      }
      catch (Exception paramBundle)
      {
        this.a.displayToast(2131892951);
        QLog.w("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 4, paramBundle.getMessage(), paramBundle);
      }
    }
    paramBundle = this.a;
    paramBundle.waitingCount -= 1;
    if (this.a.waitingCount == 0) {
      this.a.removeLoading();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl.23
 * JD-Core Version:    0.7.0.1
 */