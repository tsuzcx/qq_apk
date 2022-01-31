package com.tencent.mobileqq.ar.arengine;

import alfk;
import alfm;

public class ARCamera$ARCameraHandler$1
  implements Runnable
{
  public ARCamera$ARCameraHandler$1(alfm paramalfm) {}
  
  public void run()
  {
    alfk localalfk = this.a.a;
    int j = alfk.a(this.a.a) / 2;
    int k = alfk.b(this.a.a) / 2;
    int m = alfk.a(this.a.a);
    int n = alfk.b(this.a.a);
    if (!alfk.a(this.a.a)) {}
    for (int i = alfk.g();; i = alfk.a(this.a.a) * 3 / 4)
    {
      alfk.a(localalfk, j, k, m, n, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1
 * JD-Core Version:    0.7.0.1
 */