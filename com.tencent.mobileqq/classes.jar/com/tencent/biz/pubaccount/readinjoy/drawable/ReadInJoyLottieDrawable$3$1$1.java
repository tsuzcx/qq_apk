package com.tencent.biz.pubaccount.readinjoy.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import out;
import ouw;

public class ReadInJoyLottieDrawable$3$1$1
  implements Runnable
{
  public ReadInJoyLottieDrawable$3$1$1(ouw paramouw, String paramString) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString);
      if (localBitmap != null) {
        out.b().put(this.jdField_a_of_type_JavaLangString, localBitmap);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ReadInJoyLottieDrawable", 2, "loadLottieAnimation path: " + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ReadInJoyLottieDrawable", 2, "loadLottieAnimation oom: " + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.3.1.1
 * JD-Core Version:    0.7.0.1
 */