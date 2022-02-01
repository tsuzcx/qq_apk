package com.tencent.mobileqq.ar.arengine;

import apje;
import apjg;

public class ARCamera$ARCameraHandler$1
  implements Runnable
{
  public ARCamera$ARCameraHandler$1(apjg paramapjg) {}
  
  public void run()
  {
    apje localapje = this.a.a;
    int j = apje.a(this.a.a) / 2;
    int k = apje.b(this.a.a) / 2;
    int m = apje.a(this.a.a);
    int n = apje.b(this.a.a);
    if (!apje.a(this.a.a)) {}
    for (int i = apje.g();; i = apje.a(this.a.a) * 3 / 4)
    {
      apje.a(localapje, j, k, m, n, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1
 * JD-Core Version:    0.7.0.1
 */