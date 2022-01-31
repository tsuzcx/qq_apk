package com.tencent.gdtad.qqproxy;

import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import qlc;

public enum GdtLocationUtil
{
  INSTANCE;
  
  public final String TAG = GdtLocationUtil.class.getSimpleName();
  public SosoInterface.SosoLocation mLocation = null;
  SosoInterface.OnLocationListener onLocationListener = new qlc(this, 3, true, true, 60000L, false, false, this.TAG);
  
  public int[] getLocation()
  {
    if (this.mLocation == null)
    {
      SosoInterface.a(this.onLocationListener);
      if (SosoInterface.b() != null) {
        return new int[] { (int)(SosoInterface.b().a.a * 1000000.0D), (int)(SosoInterface.b().a.b * 1000000.0D) };
      }
      return null;
    }
    return new int[] { (int)(this.mLocation.a * 1000000.0D), (int)(this.mLocation.b * 1000000.0D) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.qqproxy.GdtLocationUtil
 * JD-Core Version:    0.7.0.1
 */