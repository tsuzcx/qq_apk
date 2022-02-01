package com.tencent.mobileqq.activity;

import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
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
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("startLocation end, errCode=").append(paramInt).append(" lbsInfo=").append(paramSosoLbsInfo).append(", info.location=");
      if (paramSosoLbsInfo == null) {
        break label103;
      }
    }
    label103:
    for (SosoLocation localSosoLocation = paramSosoLbsInfo.mLocation;; localSosoLocation = null)
    {
      QLog.d("nearby.heart_beat", 2, localSosoLocation);
      if ((!this.a.isFinishing()) && (!this.a.c))
      {
        this.a.c = false;
        this.a.a.a(1, paramSosoLbsInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NearbyActivity.7
 * JD-Core Version:    0.7.0.1
 */