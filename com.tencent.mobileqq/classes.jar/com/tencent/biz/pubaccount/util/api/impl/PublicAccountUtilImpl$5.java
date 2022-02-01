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
      paramBundle = this.a;
      if (paramBundle != null) {
        paramBundle.onUpdate(101, false, this.b);
      }
      if (this.c) {
        PublicAccountUtilImpl.access$300(this.d, 2131892951);
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
          if (this.a != null) {
            this.a.onUpdate(101, true, this.b);
          }
          PublicAccountUtilImpl.access$200(this.e, this.d, this.b, this.f);
          return;
        }
        if (paramInt == 58)
        {
          if (this.a != null) {
            this.a.onUpdate(101, false, this.b);
          }
          if (!this.c) {
            break label470;
          }
          PublicAccountUtilImpl.access$300(this.d, 2131892946);
          return;
        }
        if (paramInt == 65)
        {
          if (this.a != null) {
            this.a.onUpdate(101, false, this.b);
          }
          if (!this.c) {
            break label470;
          }
          PublicAccountUtilImpl.access$300(this.d, 2131892918);
          return;
        }
        if (this.a != null) {
          this.a.onUpdate(101, false, this.b);
        }
        if (!this.c) {
          break label470;
        }
        PublicAccountUtilImpl.access$300(this.d, 2131892951);
        return;
      }
      if (this.a != null) {
        this.a.onUpdate(101, false, this.b);
      }
      if (!this.c) {
        break label470;
      }
      PublicAccountUtilImpl.access$300(this.d, 2131892951);
      return;
    }
    catch (Exception paramBundle)
    {
      label432:
      label470:
      break label432;
    }
    if (this.a != null) {
      this.a.onUpdate(101, false, this.b);
    }
    if (this.c)
    {
      PublicAccountUtilImpl.access$300(this.d, 2131892951);
      return;
      paramBundle = this.a;
      if (paramBundle != null) {
        paramBundle.onUpdate(101, false, this.b);
      }
      if (this.c) {
        PublicAccountUtilImpl.access$300(this.d, 2131892951);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.5
 * JD-Core Version:    0.7.0.1
 */