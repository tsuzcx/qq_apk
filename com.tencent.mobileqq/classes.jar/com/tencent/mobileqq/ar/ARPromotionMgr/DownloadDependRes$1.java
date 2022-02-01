package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.mobileqq.ar.aidl.IArSoCallback.Stub;
import com.tencent.qphone.base.util.QLog;

class DownloadDependRes$1
  extends IArSoCallback.Stub
{
  DownloadDependRes$1(DownloadDependRes paramDownloadDependRes) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(PromotionUtil.a, 2, "onArSoDownloadSuccess");
    }
    this.a.a();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(PromotionUtil.a, 2, "onArSoDownloadProcess process=" + paramInt);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(PromotionUtil.a, 2, "onArSoDownloadFail");
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.DownloadDependRes.1
 * JD-Core Version:    0.7.0.1
 */