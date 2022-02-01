package com.tencent.biz.qqstory.model.lbs;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

public abstract class LbsManager$OnLocationListener
  extends SosoInterfaceOnLocationListener
{
  public LbsManager$OnLocationListener(String paramString)
  {
    super(0, true, false, 300000L, false, false, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      LbsManager.a = new BasicLocation((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D), (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      SLog.b("LbsManager", "onLocationFinish success : " + LbsManager.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener
 * JD-Core Version:    0.7.0.1
 */