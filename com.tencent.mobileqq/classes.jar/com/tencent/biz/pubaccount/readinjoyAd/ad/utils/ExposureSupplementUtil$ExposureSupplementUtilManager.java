package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class ExposureSupplementUtil$ExposureSupplementUtilManager
{
  public SparseArray<ExposureSupplementUtil> a = new SparseArray();
  
  public ExposureSupplementUtil$ExposureSupplementUtilManager()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "create ExposureSupplementUtilManager");
    }
  }
  
  public ExposureSupplementUtil a(int paramInt)
  {
    return (ExposureSupplementUtil)this.a.get(paramInt);
  }
  
  public void a(int paramInt, ExposureSupplementUtil paramExposureSupplementUtil)
  {
    this.a.put(paramInt, paramExposureSupplementUtil);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementUtil.ExposureSupplementUtilManager
 * JD-Core Version:    0.7.0.1
 */