package com.tencent.av.video.effect.core.qqavimage.SpecialFilter;

import android.graphics.Bitmap;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageThreeInputFilter;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;

public class QQAVImageTwoCurvePicFilter
  extends QQAVImageThreeInputFilter
{
  public QQAVImageTwoCurvePicFilter(int paramInt)
  {
    super(String.valueOf(getShaderBySubId(paramInt)));
  }
  
  private static int getShaderBySubId(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 30;
    case 1: 
      return 31;
    }
    return 32;
  }
  
  public void setBitmap(int paramInt, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramBitmap.isRecycled())) {}
    do
    {
      do
      {
        return;
      } while (paramBitmap == null);
      if (paramInt == 0)
      {
        this.filterSourceTexture2 = OpenGlUtils.loadTexture(paramBitmap, this.filterSourceTexture2, false);
        return;
      }
    } while (paramInt != 1);
    this.filterSourceTexture3 = OpenGlUtils.loadTexture(paramBitmap, this.filterSourceTexture3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.SpecialFilter.QQAVImageTwoCurvePicFilter
 * JD-Core Version:    0.7.0.1
 */