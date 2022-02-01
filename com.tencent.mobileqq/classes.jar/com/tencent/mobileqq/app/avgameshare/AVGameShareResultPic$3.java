package com.tencent.mobileqq.app.avgameshare;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import aojo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class AVGameShareResultPic$3
  implements Runnable
{
  public AVGameShareResultPic$3(aojo paramaojo, Map paramMap, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      QLog.d("AVGameShareResultPic", 1, "shareToWeChat decodeFile");
      Bitmap localBitmap = BitmapFactory.decodeFile(aojo.a(this.this$0));
      this.jdField_a_of_type_JavaUtilMap.put("image", localBitmap);
      if (this.this$0.a() != null) {
        this.this$0.a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AVGameShareResultPic", 1, "shareToWeChat  Exception : " + localException.getMessage());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("AVGameShareResultPic", 1, "shareToWeChat  OutOfMemoryError : " + localOutOfMemoryError.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareResultPic.3
 * JD-Core Version:    0.7.0.1
 */