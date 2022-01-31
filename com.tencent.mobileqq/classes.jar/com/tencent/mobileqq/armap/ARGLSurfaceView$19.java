package com.tencent.mobileqq.armap;

class ARGLSurfaceView$19
  implements Runnable
{
  ARGLSurfaceView$19(ARGLSurfaceView paramARGLSurfaceView, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    if ((this.val$quaternion != null) && (this.val$quaternion.length >= 4)) {
      this.this$0.native_updateQuaternion(this.val$quaternion[0], this.val$quaternion[1], this.val$quaternion[2], this.val$quaternion[3]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARGLSurfaceView.19
 * JD-Core Version:    0.7.0.1
 */