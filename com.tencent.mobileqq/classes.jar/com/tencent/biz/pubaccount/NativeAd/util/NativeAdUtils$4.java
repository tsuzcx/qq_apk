package com.tencent.biz.pubaccount.NativeAd.util;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

final class NativeAdUtils$4
  extends LbsManagerServiceOnLocationChangeListener
{
  NativeAdUtils$4(String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getADPosition doStartADLocation onLocationFinish errCode ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" info = ");
      localStringBuilder.append(paramSosoLbsInfo);
      QLog.d("NativeAdUtils", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.4
 * JD-Core Version:    0.7.0.1
 */