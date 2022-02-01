package com.tencent.mobileqq.ar.arengine;

import apmp;
import apmr;

public class ARCamera$ARCameraHandler$1
  implements Runnable
{
  public ARCamera$ARCameraHandler$1(apmr paramapmr) {}
  
  public void run()
  {
    apmp localapmp = this.a.a;
    int j = apmp.a(this.a.a) / 2;
    int k = apmp.b(this.a.a) / 2;
    int m = apmp.a(this.a.a);
    int n = apmp.b(this.a.a);
    if (!apmp.a(this.a.a)) {}
    for (int i = apmp.g();; i = apmp.a(this.a.a) * 3 / 4)
    {
      apmp.a(localapmp, j, k, m, n, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1
 * JD-Core Version:    0.7.0.1
 */