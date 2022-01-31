package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.IOException;
import java.util.Map;
import ndd;
import svl;
import syx;

public class GalleryShareHelper$3
  implements Runnable
{
  public GalleryShareHelper$3(svl paramsvl, String paramString, boolean paramBoolean, Map paramMap, syx paramsyx) {}
  
  public void run()
  {
    try
    {
      localObject = ndd.a(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.jdField_a_of_type_JavaLangString), "GET", null, null);
      if (localObject == null) {
        break label129;
      }
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      if (localObject == null) {
        break label129;
      }
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if ((i * j <= 8000.0D) || (this.jdField_a_of_type_Boolean)) {
        break label158;
      }
      double d = Math.sqrt(8000.0D / (i * j));
      Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
      ((Bitmap)localObject).recycle();
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      break label129;
    }
    catch (IOException localIOException)
    {
      label129:
      label158:
      for (;;) {}
    }
    this.jdField_a_of_type_JavaUtilMap.put("image", localObject);
    svl.a(this.this$0).runOnUiThread(new GalleryShareHelper.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.GalleryShareHelper.3
 * JD-Core Version:    0.7.0.1
 */