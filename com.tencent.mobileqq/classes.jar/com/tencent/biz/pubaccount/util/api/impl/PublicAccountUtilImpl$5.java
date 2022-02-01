package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class PublicAccountUtilImpl$5
  implements BusinessObserver
{
  PublicAccountUtilImpl$5(PublicAccountUtilImpl paramPublicAccountUtilImpl, IPublicAccountObserver paramIPublicAccountObserver, String paramString, boolean paramBoolean, Context paramContext, AppInterface paramAppInterface, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("success:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("PublicAccountUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
      if (paramBundle != null) {
        paramBundle.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean) {
        PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
      }
    }
    else if (!paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        localObject = new mobileqq_mp.FollowResponse();
        ((mobileqq_mp.FollowResponse)localObject).mergeFrom(paramBundle);
        paramInt = ((mobileqq_mp.RetInfo)((mobileqq_mp.FollowResponse)localObject).ret_info.get()).ret_code.get();
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("followUin, retCode=");
          paramBundle.append(paramInt);
          QLog.d("PublicAccountUtil", 2, paramBundle.toString());
        }
        if (paramInt == 0)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.onUpdate(101, true, this.jdField_a_of_type_JavaLangString);
          }
          PublicAccountUtilImpl.access$200(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
          return;
        }
        if (paramInt == 58)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label470;
          }
          PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695212);
          return;
        }
        if (paramInt == 65)
        {
          if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver != null) {
            this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
          }
          if (!this.jdField_a_of_type_Boolean) {
            break label470;
          }
          PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695185);
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label470;
        }
        PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label470;
      }
      PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
      return;
    }
    catch (Exception paramBundle)
    {
      label432:
      label470:
      break label432;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
      return;
      paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver;
      if (paramBundle != null) {
        paramBundle.onUpdate(101, false, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_Boolean) {
        PublicAccountUtilImpl.access$300(this.jdField_a_of_type_AndroidContentContext, 2131695217);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.5
 * JD-Core Version:    0.7.0.1
 */