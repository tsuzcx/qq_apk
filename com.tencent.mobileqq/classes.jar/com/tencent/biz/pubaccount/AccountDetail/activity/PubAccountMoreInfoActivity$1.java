package com.tencent.biz.pubaccount.accountdetail.activity;

import android.os.Bundle;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8.GetPublicAccountDetailInfoResponse;

class PubAccountMoreInfoActivity$1
  implements BusinessObserver
{
  PubAccountMoreInfoActivity$1(PubAccountMoreInfoActivity paramPubAccountMoreInfoActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("success:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("PubAccountMoreInfoActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      this.a.a(2131695217);
      return;
    }
    try
    {
      localObject = paramBundle.getByteArray("data");
      paramInt = paramBundle.getInt("type", 0);
      if (localObject == null) {
        break label298;
      }
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
      if (!paramBoolean) {
        break label298;
      }
      if (((mobileqq_mp.RetInfo)paramBundle.ret_info.get()).ret_code.get() == 0)
      {
        if ((this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl != null) && ((!paramBundle.seqno.has()) || (paramBundle.seqno.get() == this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.seqno))) {
          break label298;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("sendPublicAccountDetailInfoRequest: need update local data , new seqno = ");
          ((StringBuilder)localObject).append(paramBundle.seqno.get());
          QLog.d("PubAccountMoreInfoActivity", 2, ((StringBuilder)localObject).toString());
        }
        this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse = paramBundle;
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl = new PublicAccountDetailImpl();
        this.a.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.init(this.a.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse);
        PubAccountMoreInfoActivity.a(this.a);
        return;
      }
      this.a.a(2131695217);
      return;
    }
    catch (Exception paramBundle)
    {
      label289:
      break label289;
    }
    this.a.a(2131695217);
    label298:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.activity.PubAccountMoreInfoActivity.1
 * JD-Core Version:    0.7.0.1
 */