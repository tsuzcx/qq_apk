package com.tencent.mobileqq.activity;

import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class NearbyActivity$7
  extends LbsManager.OnLocationListener
{
  NearbyActivity$7(NearbyActivity paramNearbyActivity, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startLocation end, errCode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" lbsInfo=");
      localStringBuilder.append(paramSosoLbsInfo);
      localStringBuilder.append(", info.location=");
      if (paramSosoLbsInfo != null) {
        localObject = paramSosoLbsInfo.mLocation;
      } else {
        localObject = null;
      }
      localStringBuilder.append(localObject);
      QLog.d("nearby.heart_beat", 2, localStringBuilder.toString());
    }
    if ((!this.a.isFinishing()) && (!this.a.isStopHeartBeat))
    {
      localObject = this.a;
      ((NearbyActivity)localObject).isStopHeartBeat = false;
      ((NearbyActivity)localObject).mNearbyHandler.a(1, paramSosoLbsInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.7
 * JD-Core Version:    0.7.0.1
 */