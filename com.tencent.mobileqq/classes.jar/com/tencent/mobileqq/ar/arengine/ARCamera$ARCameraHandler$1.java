package com.tencent.mobileqq.ar.arengine;

import akqy;
import akra;

public class ARCamera$ARCameraHandler$1
  implements Runnable
{
  public ARCamera$ARCameraHandler$1(akra paramakra) {}
  
  public void run()
  {
    akqy localakqy = this.a.a;
    int j = akqy.a(this.a.a) / 2;
    int k = akqy.b(this.a.a) / 2;
    int m = akqy.a(this.a.a);
    int n = akqy.b(this.a.a);
    if (!akqy.a(this.a.a)) {}
    for (int i = akqy.g();; i = akqy.a(this.a.a) * 3 / 4)
    {
      akqy.a(localakqy, j, k, m, n, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1
 * JD-Core Version:    0.7.0.1
 */