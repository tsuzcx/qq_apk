package com.tencent.biz.qqstory.model.lbs;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

class LbsManager$1
  extends SosoInterfaceOnLocationListener
{
  LbsManager$1(LbsManager paramLbsManager, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    SLog.b("LbsManager", "onLocationFinish.");
    boolean bool;
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      bool = true;
      if (!bool) {
        break label114;
      }
      this.a.b = BasicLocation.a(paramSosoLbsInfo.mLocation);
      SLog.a("LbsManager", "onLocationFinish success, [longitude=%s, latitude=%s]", Integer.valueOf(this.a.b.b), Integer.valueOf(this.a.b.a));
    }
    for (;;)
    {
      if (!LbsManager.a(this.a)) {
        this.a.a(bool, this.a.b);
      }
      this.a.a = false;
      return;
      bool = false;
      break;
      label114:
      SLog.d("LbsManager", "onLocationFinish errorCode = %d", new Object[] { Integer.valueOf(paramInt) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.1
 * JD-Core Version:    0.7.0.1
 */