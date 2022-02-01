package com.tencent.mobileqq.ar.arengine;

class ARCamera$ARCameraHandler$1
  implements Runnable
{
  ARCamera$ARCameraHandler$1(ARCamera.ARCameraHandler paramARCameraHandler) {}
  
  public void run()
  {
    ARCamera localARCamera = this.a.a;
    int j = ARCamera.a(this.a.a) / 2;
    int k = ARCamera.b(this.a.a) / 2;
    int m = ARCamera.a(this.a.a);
    int n = ARCamera.b(this.a.a);
    int i;
    if (!ARCamera.a(this.a.a)) {
      i = ARCamera.g();
    } else {
      i = ARCamera.a(this.a.a) * 3 / 4;
    }
    ARCamera.a(localARCamera, j, k, m, n, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.ARCameraHandler.1
 * JD-Core Version:    0.7.0.1
 */