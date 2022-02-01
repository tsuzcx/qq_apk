package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.activity.qqsettingme.api.IRedTouchTextViewApi;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import java.io.InputStream;

public class RedTouchTextViewApiImpl
  implements IRedTouchTextViewApi
{
  public Drawable getApngURLDrawable(String paramString)
  {
    return VasApngUtil.getApngURLDrawable(paramString, VasApngUtil.VIP_APNG_TAGS, URLDrawableHelperConstants.a);
  }
  
  public double getOptRatio(InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    return ImageUtil.a(paramInputStream, paramInt1, paramInt2);
  }
  
  public Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2)
  {
    return ImageUtil.a(paramBitmap, paramFloat, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.impl.RedTouchTextViewApiImpl
 * JD-Core Version:    0.7.0.1
 */