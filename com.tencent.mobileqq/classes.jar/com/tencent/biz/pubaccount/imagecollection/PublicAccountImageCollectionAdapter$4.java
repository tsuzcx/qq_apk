package com.tencent.biz.pubaccount.imagecollection;

import android.os.Bundle;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class PublicAccountImageCollectionAdapter$4
  implements BusinessObserver
{
  PublicAccountImageCollectionAdapter$4(PublicAccountImageCollectionAdapter paramPublicAccountImageCollectionAdapter) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        mobileqq_mp.FollowResponse localFollowResponse = new mobileqq_mp.FollowResponse();
        localFollowResponse.mergeFrom(paramBundle);
        paramInt = ((mobileqq_mp.RetInfo)localFollowResponse.ret_info.get()).ret_code.get();
        if (paramInt == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionAdapter", 2, "follow success");
          }
          this.a.a = true;
          PublicAccountImageCollectionAdapter.a(this.a);
          return;
        }
        if (paramInt == 58)
        {
          PublicAccountImageCollectionAdapter.a(this.a, 2131695212);
          return;
        }
        if (paramInt == 65)
        {
          PublicAccountImageCollectionAdapter.a(this.a, 2131695185);
          return;
        }
        PublicAccountImageCollectionAdapter.a(this.a, 2131695217);
        return;
        PublicAccountImageCollectionAdapter.a(this.a, 2131695217);
      }
      return;
    }
    catch (Exception paramBundle) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionAdapter.4
 * JD-Core Version:    0.7.0.1
 */