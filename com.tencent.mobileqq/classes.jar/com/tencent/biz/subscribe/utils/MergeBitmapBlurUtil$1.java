package com.tencent.biz.subscribe.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

final class MergeBitmapBlurUtil$1
  implements Runnable
{
  MergeBitmapBlurUtil$1(String paramString, ImageView paramImageView) {}
  
  public void run()
  {
    try
    {
      Object localObject = CommonImageCacheHelper.a(this.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        MergeBitmapBlurUtil.a((Bitmap)localObject, this.jdField_a_of_type_AndroidWidgetImageView);
        return;
      }
      localObject = new URL(this.jdField_a_of_type_JavaLangString).openConnection();
      int i = ((HttpURLConnection)localObject).getContentLength();
      ((URLConnection)localObject).connect();
      localObject = ((URLConnection)localObject).getInputStream();
      BufferedInputStream localBufferedInputStream = new BufferedInputStream((InputStream)localObject, i);
      Bitmap localBitmap = BitmapFactory.decodeStream(localBufferedInputStream);
      localBufferedInputStream.close();
      ((InputStream)localObject).close();
      MergeBitmapBlurUtil.a(this.jdField_a_of_type_JavaLangString, localBitmap, this.jdField_a_of_type_AndroidWidgetImageView);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.MergeBitmapBlurUtil.1
 * JD-Core Version:    0.7.0.1
 */