package com.github.henryye.nativeiv;

import android.graphics.Bitmap.Config;
import androidx.annotation.Keep;

@Keep
public class ImageDecodeConfig
{
  @Keep
  public Bitmap.Config mConfig = Bitmap.Config.ARGB_8888;
  @Keep
  public int mPreferredHeight = 0;
  @Keep
  public double mPreferredScale = 0.0D;
  @Keep
  public int mPreferredWidth = 0;
  @Keep
  public boolean mPremultiplyAlpha = true;
  @Keep
  public ImageDecodeConfig.ReferrerPolicy mReferrerPolicy = ImageDecodeConfig.ReferrerPolicy.NOT_SET;
  
  @Keep
  public static ImageDecodeConfig createConfig(Bitmap.Config paramConfig, boolean paramBoolean)
  {
    ImageDecodeConfig localImageDecodeConfig = new ImageDecodeConfig();
    localImageDecodeConfig.mPremultiplyAlpha = paramBoolean;
    localImageDecodeConfig.mConfig = paramConfig;
    return localImageDecodeConfig;
  }
  
  @Keep
  public static Object createConfig(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, double paramDouble)
  {
    ImageDecodeConfig localImageDecodeConfig = new ImageDecodeConfig();
    localImageDecodeConfig.mPremultiplyAlpha = paramBoolean;
    if (paramInt1 == 8) {
      localImageDecodeConfig.mConfig = Bitmap.Config.ALPHA_8;
    } else if (paramInt1 == 4) {
      localImageDecodeConfig.mConfig = Bitmap.Config.RGB_565;
    } else if (paramInt1 == 7) {
      localImageDecodeConfig.mConfig = Bitmap.Config.ARGB_4444;
    } else if (paramInt1 == 1) {
      localImageDecodeConfig.mConfig = Bitmap.Config.ARGB_8888;
    } else {
      localImageDecodeConfig.mConfig = Bitmap.Config.ARGB_8888;
    }
    if (paramInt2 == 0) {
      localImageDecodeConfig.mReferrerPolicy = ImageDecodeConfig.ReferrerPolicy.NOT_SET;
    } else if (paramInt2 == 1) {
      localImageDecodeConfig.mReferrerPolicy = ImageDecodeConfig.ReferrerPolicy.NO_REFERRER;
    } else if (paramInt2 == 2) {
      localImageDecodeConfig.mReferrerPolicy = ImageDecodeConfig.ReferrerPolicy.ORIGIN;
    }
    localImageDecodeConfig.mPreferredWidth = paramInt3;
    localImageDecodeConfig.mPreferredHeight = paramInt4;
    localImageDecodeConfig.mPreferredScale = paramDouble;
    return localImageDecodeConfig;
  }
  
  @Keep
  public int getNativeConfig()
  {
    int i = ImageDecodeConfig.1.a[this.mConfig.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return 1;
          }
          return 8;
        }
        return 7;
      }
      return 4;
    }
    return 1;
  }
  
  @Keep
  public int getNativeReferrerPolicy()
  {
    int j = ImageDecodeConfig.1.b[this.mReferrerPolicy.ordinal()];
    int i = 1;
    if (j != 1)
    {
      i = 2;
      if (j != 2) {
        return 0;
      }
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageDecodeConfig{mConfig=");
    localStringBuilder.append(this.mConfig);
    localStringBuilder.append(", mPremultiplyAlpha=");
    localStringBuilder.append(this.mPremultiplyAlpha);
    localStringBuilder.append(", mReferrerPolicy=");
    localStringBuilder.append(this.mReferrerPolicy);
    localStringBuilder.append(", mPreferredWidth=");
    localStringBuilder.append(this.mPreferredWidth);
    localStringBuilder.append(", mPreferredHeight=");
    localStringBuilder.append(this.mPreferredHeight);
    localStringBuilder.append(", mPreferredScale=");
    localStringBuilder.append(this.mPreferredScale);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.ImageDecodeConfig
 * JD-Core Version:    0.7.0.1
 */