package com.tencent.aelight.camera.util;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;

public class ImageLoader
{
  private static ImageLoader a = new ImageLoader();
  
  public static ImageLoader a()
  {
    return a;
  }
  
  public URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
    }
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  public void a(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramImageView != null) && (!TextUtils.isEmpty(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uri:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",width:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",height:");
      localStringBuilder.append(paramInt2);
      SLog.b("ImageLoader", localStringBuilder.toString());
      paramString = a(paramString, paramInt1, paramInt2);
      if (!paramBoolean) {
        paramString = null;
      }
      paramImageView.setImageDrawable(paramString);
      return;
    }
    SLog.e("ImageLoader", "ImageView or uri is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.util.ImageLoader
 * JD-Core Version:    0.7.0.1
 */