package com.tencent.mobileqq.ar.arengine;

import alfj;
import alfl;

public class ARCamera$ARCameraHandler$1
  implements Runnable
{
  public ARCamera$ARCameraHandler$1(alfl paramalfl) {}
  
  public void run()
  {
    alfj localalfj = this.a.a;
    int j = alfj.a(this.a.a) / 2;
    int k = alfj.b(this.a.a) / 2;
    int m = alfj.a(this.a.a);
    int n = alfj.b(this.a.a);
    if (!alfj.a(this.a.a)) {}
    for (int i = alfj.g();; i = alfj.a(this.a.a) * 3 / 4)
    {
      alfj.a(localalfj, j, k, m, n, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1
 * JD-Core Version:    0.7.0.1
 */