package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

final class NativeAdUtils$6
  extends LbsManagerServiceOnLocationChangeListener
{
  NativeAdUtils$6(String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation onLocationFinish errCode " + paramInt + " info = " + paramSosoLbsInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.6
 * JD-Core Version:    0.7.0.1
 */