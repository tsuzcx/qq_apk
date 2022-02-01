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
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return 30;
        }
        return 32;
      }
      return 31;
    }
    return 30;
  }
  
  public void setBitmap(int paramInt, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramBitmap.isRecycled())) {
      return;
    }
    if (paramBitmap == null) {
      return;
    }
    if (paramInt == 0)
    {
      this.filterSourceTexture2 = OpenGlUtils.loadTexture(paramBitmap, this.filterSourceTexture2, false);
      return;
    }
    if (paramInt == 1) {
      this.filterSourceTexture3 = OpenGlUtils.loadTexture(paramBitmap, this.filterSourceTexture3, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.SpecialFilter.QQAVImageTwoCurvePicFilter
 * JD-Core Version:    0.7.0.1
 */