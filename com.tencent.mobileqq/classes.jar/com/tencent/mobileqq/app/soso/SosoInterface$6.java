package com.tencent.mobileqq.app.soso;

final class SosoInterface$6
  implements Runnable
{
  SosoInterface$6(SosoInterface.OnLocationListener paramOnLocationListener, int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    this.val$lis.onLocationFinish(this.val$err, this.val$info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.6
 * JD-Core Version:    0.7.0.1
 */