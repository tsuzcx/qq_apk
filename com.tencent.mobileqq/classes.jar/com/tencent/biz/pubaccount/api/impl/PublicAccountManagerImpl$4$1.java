package com.tencent.biz.pubaccount.api.impl;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

class PublicAccountManagerImpl$4$1
  extends SosoInterfaceOnLocationListener
{
  PublicAccountManagerImpl$4$1(PublicAccountManagerImpl.4 param4, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, boolean paramBoolean5)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null)) {}
    try
    {
      if (paramSosoLbsInfo.mLocation != null)
      {
        double d1 = paramSosoLbsInfo.mLocation.mLat02;
        double d2 = paramSosoLbsInfo.mLocation.mLon02;
        String str1 = "";
        if (paramSosoLbsInfo.mLocation.address != null) {
          str1 = "" + paramSosoLbsInfo.mLocation.address;
        }
        String str2 = str1;
        if (paramSosoLbsInfo.mLocation.name != null) {
          str2 = str1 + paramSosoLbsInfo.mLocation.name;
        }
        this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl$4.this$0.reportClickTypeMenuEvent(true, d1, d2, str2, null, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
      }
      return;
    }
    catch (Exception paramSosoLbsInfo)
    {
      paramSosoLbsInfo.printStackTrace();
      this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountManagerImpl$4.this$0.reportClickTypeMenuEvent(false, 0.0D, 0.0D, null, null, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountManagerImpl.4.1
 * JD-Core Version:    0.7.0.1
 */