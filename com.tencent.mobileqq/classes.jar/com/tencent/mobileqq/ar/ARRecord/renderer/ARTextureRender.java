package com.tencent.mobileqq.ar.ARRecord.renderer;

public class ARTextureRender
{
  private GPUBaseFilter a = new GPUBaseFilter();
  private GPUOESBaseFilter b = new GPUOESBaseFilter();
  
  public ARTextureRender()
  {
    this.a.a();
    this.b.a();
  }
  
  public void a()
  {
    this.a.d();
    this.b.d();
  }
  
  public void a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt1 == 36197)
    {
      this.b.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    if (paramInt1 == 3553)
    {
      this.a.a(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.renderer.ARTextureRender
 * JD-Core Version:    0.7.0.1
 */