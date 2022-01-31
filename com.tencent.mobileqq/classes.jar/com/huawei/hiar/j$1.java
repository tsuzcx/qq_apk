package com.huawei.hiar;

class j$1
  implements HuaweiArApkBase.ICheckAvailabilityCallback
{
  j$1(j paramj) {}
  
  public void onResult(HuaweiArApkBase.ARAvailability paramARAvailability)
  {
    synchronized (this.a)
    {
      j.a(this.a, paramARAvailability);
      j.a(this.a, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.j.1
 * JD-Core Version:    0.7.0.1
 */