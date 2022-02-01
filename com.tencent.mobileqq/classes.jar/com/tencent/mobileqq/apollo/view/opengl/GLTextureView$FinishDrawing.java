package com.tencent.mobileqq.apollo.view.opengl;

class GLTextureView$FinishDrawing
  implements Runnable
{
  private GLTextureView$FinishDrawing(GLTextureView paramGLTextureView) {}
  
  public void run()
  {
    if (this.this$0.mGLThread.a())
    {
      GLTextureView.access$300(this.this$0);
      return;
    }
    this.this$0.mGLThread.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLTextureView.FinishDrawing
 * JD-Core Version:    0.7.0.1
 */