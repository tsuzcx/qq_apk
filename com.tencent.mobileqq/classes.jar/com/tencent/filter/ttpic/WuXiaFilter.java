package com.tencent.filter.ttpic;

import com.tencent.filter.Param.TextureResParam;

public class WuXiaFilter
  extends GPUImageLookupFilter
{
  public WuXiaFilter()
  {
    addParam(new Param.TextureResParam("inputImageTexture2", "sh/wuxia_lf.png", 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.WuXiaFilter
 * JD-Core Version:    0.7.0.1
 */