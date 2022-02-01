package com.tencent.TMG.opengl.glrenderer;

class GLES11Canvas$ConfigState
{
  float mAlpha;
  float[] mMatrix = new float[16];
  ConfigState mNextFree;
  
  public void restore(GLES11Canvas paramGLES11Canvas)
  {
    float f = this.mAlpha;
    if (f >= 0.0F) {
      paramGLES11Canvas.setAlpha(f);
    }
    float[] arrayOfFloat = this.mMatrix;
    if (arrayOfFloat[0] != (1.0F / -1.0F)) {
      System.arraycopy(arrayOfFloat, 0, GLES11Canvas.access$100(paramGLES11Canvas), 0, 16);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.opengl.glrenderer.GLES11Canvas.ConfigState
 * JD-Core Version:    0.7.0.1
 */