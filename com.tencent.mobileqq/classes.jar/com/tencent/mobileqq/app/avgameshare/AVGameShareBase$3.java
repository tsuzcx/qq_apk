package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import aoaw;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import nlw;

public class AVGameShareBase$3
  implements Runnable
{
  public AVGameShareBase$3(aoaw paramaoaw, Map paramMap, Runnable paramRunnable) {}
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Bitmap localBitmap = paramBitmap;
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, (int)(i * d), (int)(d * j), true);
        paramBitmap.recycle();
      }
      this.jdField_a_of_type_JavaUtilMap.put("image", localBitmap);
      if (this.this$0.a() != null) {
        this.this$0.a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
  }
  
  public void run()
  {
    try
    {
      QLog.d("AVGameShareBase", 1, "shareLinkToWeChat share url icon");
      byte[] arrayOfByte = nlw.a(this.this$0.a(), this.this$0.e(), "GET", null, null);
      if (arrayOfByte != null) {
        a(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AVGameShareBase", 1, "shareLinkToWeChat  Exception : " + localException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("AVGameShareBase", 1, "shareLinkToWeChat  OutOfMemoryError : " + localOutOfMemoryError.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareBase.3
 * JD-Core Version:    0.7.0.1
 */