package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.IOException;
import java.util.Map;

class QShareUtils$2
  implements Runnable
{
  QShareUtils$2(QShareUtils paramQShareUtils, String paramString, boolean paramBoolean, Map paramMap, AppInterface paramAppInterface, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.jdField_a_of_type_JavaLangString), "GET", null, null);
      if (localObject2 == null) {
        break label135;
      }
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length);
      if ((this.jdField_a_of_type_Boolean) || (localObject2.length <= 66000)) {
        break label157;
      }
      int i = ((Bitmap)localObject1).getWidth();
      int j = ((Bitmap)localObject1).getHeight();
      if (i * j <= 8000) {
        break label157;
      }
      double d = Math.sqrt(8000.0D / (i * j));
      localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(i * d), (int)(j * d), true);
      ((Bitmap)localObject1).recycle();
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject1;
      break label135;
    }
    catch (IOException localIOException)
    {
      label135:
      label157:
      for (;;) {}
    }
    if (localObject1 != null) {
      this.jdField_a_of_type_JavaUtilMap.put("image", localObject1);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.QShareUtils.2
 * JD-Core Version:    0.7.0.1
 */