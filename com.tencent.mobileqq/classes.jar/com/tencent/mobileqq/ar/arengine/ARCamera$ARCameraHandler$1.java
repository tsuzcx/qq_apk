package com.tencent.mobileqq.ar.arengine;

import aoyz;
import aozb;

public class ARCamera$ARCameraHandler$1
  implements Runnable
{
  public ARCamera$ARCameraHandler$1(aozb paramaozb) {}
  
  public void run()
  {
    aoyz localaoyz = this.a.a;
    int j = aoyz.a(this.a.a) / 2;
    int k = aoyz.b(this.a.a) / 2;
    int m = aoyz.a(this.a.a);
    int n = aoyz.b(this.a.a);
    if (!aoyz.a(this.a.a)) {}
    for (int i = aoyz.g();; i = aoyz.a(this.a.a) * 3 / 4)
    {
      aoyz.a(localaoyz, j, k, m, n, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1
 * JD-Core Version:    0.7.0.1
 */