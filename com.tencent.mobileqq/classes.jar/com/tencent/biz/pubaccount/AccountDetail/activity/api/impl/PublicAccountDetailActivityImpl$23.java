package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.os.Bundle;
import com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

class PublicAccountDetailActivityImpl$23
  implements BusinessObserver
{
  PublicAccountDetailActivityImpl$23(PublicAccountDetailActivityImpl paramPublicAccountDetailActivityImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "success:" + String.valueOf(paramBoolean));
    }
    if (!paramBoolean) {
      if (this.a.isFirst)
      {
        if (this.a.mAccountDetailAdapter == null) {
          break label112;
        }
        this.a.mAccountDetailAdapter.b(false);
        this.a.mAccountDetailAdapter.notifyDataSetChanged();
      }
    }
    label349:
    label487:
    for (;;)
    {
      paramBundle = this.a;
      paramBundle.waitingCount -= 1;
      if (this.a.waitingCount == 0) {
        this.a.removeLoading();
      }
      return;
      label112:
      this.a.displayToast(2131695222);
      continue;
      for (;;)
      {
        byte[] arrayOfByte;
        oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse localGetPublicAccountDetailInfoResponse;
        try
        {
          arrayOfByte = paramBundle.getByteArray("data");
          paramInt = paramBundle.getInt("type", 0);
          if (arrayOfByte == null) {
            break label555;
          }
          paramBundle = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
          localGetPublicAccountDetailInfoResponse = new oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse();
          if (paramInt != 0) {
            break label349;
          }
          paramBundle.mergeFrom(arrayOfByte);
          paramBoolean = true;
          if (!paramBoolean) {
            break label499;
          }
          if (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() != 0) {
            break label487;
          }
          if ((this.a.accountDetail != null) && ((!paramBundle.seqno.has()) || (paramBundle.seqno.get() == this.a.accountDetail.seqno))) {
            break label413;
          }
          if (QLog.isColorLevel()) {
            QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest: need update local data , new seqno = " + paramBundle.seqno.get());
          }
          this.a.gAccountData = paramBundle;
          paramBundle = new AccountDetail(this.a.gAccountData);
          if (!((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).isShopOrServiceAccount(paramBundle)) {
            break label371;
          }
          this.a.send839PublicAccountDetailInfoRequest();
        }
        catch (Exception paramBundle)
        {
          this.a.displayToast(2131695222);
          QLog.w("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 4, paramBundle.getMessage(), paramBundle);
        }
        break;
        paramBoolean = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).convert0xcf8ToMobileMP(arrayOfByte, localGetPublicAccountDetailInfoResponse, paramBundle);
      }
      label371:
      if ((this.a.mIsSendMessage) && (paramBundle.followType == 1))
      {
        this.a.updateDetailInfo(paramBundle, false);
      }
      else
      {
        this.a.updateDetailInfo(paramBundle, true);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.AccountDetailActivity", 2, "sendPublicAccountDetailInfoRequest: seqno is same, no need to update, seqno = " + this.a.accountDetail.seqno);
        }
        if ((this.a.mIsSendMessage) && (this.a.accountDetail.followType == 1))
        {
          this.a.gotoChatActivity();
          continue;
          this.a.displayToast(2131695222);
          continue;
          label499:
          if (this.a.isFirst) {
            if (this.a.mAccountDetailAdapter != null)
            {
              this.a.mAccountDetailAdapter.b(false);
              this.a.mAccountDetailAdapter.notifyDataSetChanged();
            }
            else
            {
              this.a.displayToast(2131695222);
              continue;
              if (this.a.isFirst) {
                if (this.a.mAccountDetailAdapter != null)
                {
                  this.a.mAccountDetailAdapter.b(false);
                  this.a.mAccountDetailAdapter.notifyDataSetChanged();
                }
                else
                {
                  this.a.displayToast(2131695222);
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.PublicAccountDetailActivityImpl.23
 * JD-Core Version:    0.7.0.1
 */