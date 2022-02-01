package com.tencent.liteav.screencapture;

class a$2
  implements Runnable
{
  a$2(a parama, boolean paramBoolean) {}
  
  public void run()
  {
    a.a locala = a.b(this.b);
    boolean bool1 = this.b.i;
    boolean bool2 = this.a;
    if ((bool1 != bool2) && (locala != null)) {
      if (bool2) {
        locala.onScreenCaptureResumed();
      } else {
        locala.onScreenCapturePaused();
      }
    }
    this.b.i = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a.2
 * JD-Core Version:    0.7.0.1
 */