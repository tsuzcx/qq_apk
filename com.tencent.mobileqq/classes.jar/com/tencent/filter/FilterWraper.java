package com.tencent.filter;

public class FilterWraper
  extends BaseFilter
{
  private boolean available = false;
  protected String filter_model = "";
  protected long nativeObj = 0L;
  
  public FilterWraper(String paramString)
  {
    super(GLSLRender.FILTER_SHADER_NONE);
    this.filter_model = paramString;
  }
  
  private void checkavailable()
  {
    if (!this.available) {
      throw new RuntimeException("use bad addr");
    }
  }
  
  private static native void nativeDispose(long paramLong);
  
  private static native int nativeGetOutputText(long paramLong);
  
  private static native long nativeInitialWithString(String paramString);
  
  private static native void nativeRenderContext(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (this.available) {
      nativeDispose(this.nativeObj);
    }
    this.nativeObj = nativeInitialWithString(this.filter_model);
    this.available = true;
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void ClearGLSL()
  {
    if (this.available)
    {
      nativeDispose(this.nativeObj);
      this.available = false;
    }
    super.ClearGLSL();
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.available) {
      nativeRenderContext(this.nativeObj, paramInt1, paramInt2, paramInt3);
    }
    super.beforeRender(paramInt1, paramInt2, paramInt3);
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.available) {
      return super.renderTexture(nativeGetOutputText(this.nativeObj), paramInt2, paramInt3);
    }
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.FilterWraper
 * JD-Core Version:    0.7.0.1
 */