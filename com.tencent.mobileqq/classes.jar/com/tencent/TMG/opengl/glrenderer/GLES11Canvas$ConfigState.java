package com.tencent.TMG.opengl.glrenderer;

class GLES11Canvas$ConfigState
{
  float mAlpha;
  float[] mMatrix = new float[16];
  ConfigState mNextFree;
  
  public void restore(GLES11Canvas paramGLES11Canvas)
  {
    if (this.mAlpha >= 0.0F) {
      paramGLES11Canvas.setAlpha(this.mAlpha);
    }
    if (this.mMatrix[0] != (1.0F / -1.0F)) {
      System.arraycopy(this.mMatrix, 0, GLES11Canvas.access$100(paramGLES11Canvas), 0, 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.opengl.glrenderer.GLES11Canvas.ConfigState
 * JD-Core Version:    0.7.0.1
 */