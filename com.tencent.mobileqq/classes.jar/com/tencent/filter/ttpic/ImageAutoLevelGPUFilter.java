package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;

public class ImageAutoLevelGPUFilter
  extends BaseFilter
{
  private float p = 1.0F;
  
  public ImageAutoLevelGPUFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    int i = getTheFilterIndex(this);
    BaseFilter localBaseFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
    localBaseFilter.scaleFact = Math.min(100.0F / Math.min(paramFloat2, paramFloat1), 1.0F);
    setNextFilter(localBaseFilter, null);
    localBaseFilter.setNextFilter(new HistogramAutoLevelFilter(this.p), new int[] { i + (this.srcTextureIndex + 1) });
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.filter.ttpic.ImageAutoLevelGPUFilter
 * JD-Core Version:    0.7.0.1
 */