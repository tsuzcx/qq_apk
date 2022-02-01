package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;

public class ExposureSupplementManager$ExposureSupplementUtilManager
{
  public SparseArray<ExposureSupplementManager> a = new SparseArray();
  
  public ExposureSupplementManager$ExposureSupplementUtilManager()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExposureSupplementUtil", 2, "create ExposureSupplementUtilManager");
    }
  }
  
  public ExposureSupplementManager a(int paramInt)
  {
    return (ExposureSupplementManager)this.a.get(paramInt);
  }
  
  public void a(int paramInt, ExposureSupplementManager paramExposureSupplementManager)
  {
    this.a.put(paramInt, paramExposureSupplementManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementManager.ExposureSupplementUtilManager
 * JD-Core Version:    0.7.0.1
 */