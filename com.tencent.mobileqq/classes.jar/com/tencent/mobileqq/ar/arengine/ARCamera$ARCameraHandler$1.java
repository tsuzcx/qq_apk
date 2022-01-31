package com.tencent.mobileqq.ar.arengine;

import amvz;
import amwb;

public class ARCamera$ARCameraHandler$1
  implements Runnable
{
  public ARCamera$ARCameraHandler$1(amwb paramamwb) {}
  
  public void run()
  {
    amvz localamvz = this.a.a;
    int j = amvz.a(this.a.a) / 2;
    int k = amvz.b(this.a.a) / 2;
    int m = amvz.a(this.a.a);
    int n = amvz.b(this.a.a);
    if (!amvz.a(this.a.a)) {}
    for (int i = amvz.g();; i = amvz.a(this.a.a) * 3 / 4)
    {
      amvz.a(localamvz, j, k, m, n, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1
 * JD-Core Version:    0.7.0.1
 */