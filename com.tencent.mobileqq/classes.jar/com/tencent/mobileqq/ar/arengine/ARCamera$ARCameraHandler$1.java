package com.tencent.mobileqq.ar.arengine;

import aogc;
import aoge;

public class ARCamera$ARCameraHandler$1
  implements Runnable
{
  public ARCamera$ARCameraHandler$1(aoge paramaoge) {}
  
  public void run()
  {
    aogc localaogc = this.a.a;
    int j = aogc.a(this.a.a) / 2;
    int k = aogc.b(this.a.a) / 2;
    int m = aogc.a(this.a.a);
    int n = aogc.b(this.a.a);
    if (!aogc.a(this.a.a)) {}
    for (int i = aogc.g();; i = aogc.a(this.a.a) * 3 / 4)
    {
      aogc.a(localaogc, j, k, m, n, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1
 * JD-Core Version:    0.7.0.1
 */