package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;

public class YouJiaLiFilter
  extends BaseFilter
{
  private BaseFilter nextFilter;
  
  public YouJiaLiFilter()
  {
    super("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.nextFilter = new GPUImageLookupFilter();
    this.nextFilter.addParam(new TextureResParam("inputImageTexture2", "sh/youjiali_lf.png", 33986));
    setNextFilter(this.nextFilter, null);
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.YouJiaLiFilter
 * JD-Core Version:    0.7.0.1
 */