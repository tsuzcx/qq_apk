package com.tencent.filter;

import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.view.RendererUtils;

public abstract class CPUFilter
  extends BaseFilter
{
  public CPUFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    this.mIsGPU = false;
  }
  
  public CPUFilter(int paramInt)
  {
    super(BaseFilter.getFragmentShader(paramInt));
    this.mIsGPU = false;
  }
  
  protected abstract QImage ApplyFilter(QImage paramQImage);
  
  public void RenderProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double paramDouble, Frame paramFrame)
  {
    if (this.mIsPreviewFilter) {
      super.RenderProcess(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramDouble, paramFrame);
    }
    QImage localQImage;
    do
    {
      return;
      paramFrame = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
      localQImage = ApplyFilter(paramFrame);
      GLSLRender.nativeTextImage(localQImage, paramInt6);
      paramFrame.Dispose();
    } while (paramFrame == localQImage);
    localQImage.Dispose();
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.mIsPreviewFilter = paramBoolean;
    if (paramBoolean) {
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.CPUFilter
 * JD-Core Version:    0.7.0.1
 */