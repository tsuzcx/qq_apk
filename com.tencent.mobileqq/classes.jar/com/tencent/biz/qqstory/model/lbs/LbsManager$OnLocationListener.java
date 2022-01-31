package com.tencent.biz.qqstory.model.lbs;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public abstract class LbsManager$OnLocationListener
  extends SosoInterface.OnLocationListener
{
  public LbsManager$OnLocationListener(String paramString)
  {
    super(0, true, false, 300000L, false, false, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      LbsManager.a = new BasicLocation((int)(paramSosoLbsInfo.a.a * 1000000.0D), (int)(paramSosoLbsInfo.a.b * 1000000.0D));
      SLog.b("LbsManager", "onLocationFinish success : " + LbsManager.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener
 * JD-Core Version:    0.7.0.1
 */