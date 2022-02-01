package com.tencent.mobileqq.apollo.view.opengl;

class GLTextureView$FinishDrawing
  implements Runnable
{
  private GLTextureView$FinishDrawing(GLTextureView paramGLTextureView) {}
  
  public void run()
  {
    if (GLTextureView.access$200(this.this$0).a())
    {
      GLTextureView.access$400(this.this$0);
      return;
    }
    GLTextureView.access$200(this.this$0).b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.opengl.GLTextureView.FinishDrawing
 * JD-Core Version:    0.7.0.1
 */