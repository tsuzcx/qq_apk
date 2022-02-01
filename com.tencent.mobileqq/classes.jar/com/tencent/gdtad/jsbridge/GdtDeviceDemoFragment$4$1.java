package com.tencent.gdtad.jsbridge;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

class GdtDeviceDemoFragment$4$1
  extends LbsManagerServiceOnLocationChangeListener
{
  GdtDeviceDemoFragment$4$1(GdtDeviceDemoFragment.4 param4, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    paramSosoLbsInfo = GdtDeviceDemoFragment.a(paramSosoLbsInfo);
    GdtDeviceDemoFragment.a(this.a.a, String.format("LbsManagerService.startLocation end errCode:%d %s", new Object[] { Integer.valueOf(paramInt), paramSosoLbsInfo }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtDeviceDemoFragment.4.1
 * JD-Core Version:    0.7.0.1
 */