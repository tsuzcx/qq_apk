package com.microrapid.lensFlare;

import com.tencent.filter.CPUFilter;
import com.tencent.filter.QImage;
import java.util.Map;

public class LensFlareCpuFilter
  extends CPUFilter
{
  private float param = 1.0F;
  private int type = 0;
  
  private String getPatternName()
  {
    switch (this.type)
    {
    default: 
      return "lens/01star.jpg";
    case 1: 
      return "lens/02star.jpg";
    case 2: 
      return "lens/03star.jpg";
    case 3: 
      return "lens/04star.jpg";
    case 4: 
      return "lens/05star.jpg";
    case 5: 
      return "lens/06sun.jpg";
    case 6: 
      return "lens/07sun.jpg";
    }
    return "lens/08sun.jpg";
  }
  
  public QImage ApplyFilter(QImage paramQImage)
  {
    try
    {
      LensFlareHandle localLensFlareHandle = new LensFlareHandle();
      localLensFlareHandle.setCrossMode(2);
      localLensFlareHandle.updateOpType(1);
      localLensFlareHandle.updatePatternImage(getPatternName());
      localLensFlareHandle.updateCrossNumStrength(this.param * 0.6F + 0.2F);
      localLensFlareHandle.updateCrossSizeStrength(this.param * 0.6F + 0.2F);
      localLensFlareHandle.processImage(paramQImage);
      localLensFlareHandle.dispose();
      return paramQImage;
    }
    catch (Throwable localThrowable)
    {
      localThrowable = localThrowable;
      localThrowable.printStackTrace();
      return paramQImage;
    }
    finally {}
  }
  
  public boolean isAdjustFilter()
  {
    return true;
  }
  
  public void setAdjustParam(float paramFloat)
  {
    this.param = paramFloat;
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("filterAdjustParam")) {
      this.param = ((Float)paramMap.get("filterAdjustParam")).floatValue();
    }
    if (paramMap.containsKey("effectIndex")) {
      this.type = ((Integer)paramMap.get("effectIndex")).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.lensFlare.LensFlareCpuFilter
 * JD-Core Version:    0.7.0.1
 */