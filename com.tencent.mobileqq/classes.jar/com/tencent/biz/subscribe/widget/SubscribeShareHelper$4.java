package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.IOException;
import java.util.Map;
import ndd;
import ydo;
import yod;

public class SubscribeShareHelper$4
  implements Runnable
{
  public SubscribeShareHelper$4(yod paramyod, Map paramMap, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      if (yod.a(this.this$0) == null) {
        return;
      }
      localObject = ndd.a(BaseApplicationImpl.getContext(), yod.a(this.this$0).e(), "GET", null, null);
      if (localObject == null) {
        break label132;
      }
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      if (localObject == null) {
        break label132;
      }
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if (i * j <= 8000) {
        break label167;
      }
      double d = Math.sqrt(8000.0D / (i * j));
      Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
      ((Bitmap)localObject).recycle();
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      break label132;
    }
    catch (IOException localIOException)
    {
      label132:
      label167:
      for (;;) {}
    }
    this.jdField_a_of_type_JavaUtilMap.put("image", localObject);
    if (this.this$0.a != null)
    {
      this.this$0.a.runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.4
 * JD-Core Version:    0.7.0.1
 */