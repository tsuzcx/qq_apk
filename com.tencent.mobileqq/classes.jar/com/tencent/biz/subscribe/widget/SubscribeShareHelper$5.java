package com.tencent.biz.subscribe.widget;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.subscribe.beans.ShareInfoBean;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.IOException;
import java.util.Map;

class SubscribeShareHelper$5
  implements Runnable
{
  SubscribeShareHelper$5(SubscribeShareHelper paramSubscribeShareHelper, Map paramMap, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      if (SubscribeShareHelper.a(this.this$0) == null) {
        return;
      }
      Object localObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), SubscribeShareHelper.a(this.this$0).e(), "GET", null, null);
      if (localObject != null)
      {
        Bitmap localBitmap = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
        if (localBitmap != null)
        {
          int j = localBitmap.getWidth();
          int i = localBitmap.getHeight();
          int k = j * i;
          localObject = localBitmap;
          if (k > 8000)
          {
            double d1 = k;
            Double.isNaN(d1);
            d1 = 8000.0D / d1;
            d1 = Math.sqrt(d1);
            double d2 = j;
            Double.isNaN(d2);
            j = (int)(d2 * d1);
            d2 = i;
            Double.isNaN(d2);
            i = (int)(d2 * d1);
            localObject = Bitmap.createScaledBitmap(localBitmap, j, i, true);
            localBitmap.recycle();
          }
          this.jdField_a_of_type_JavaUtilMap.put("image", localObject);
        }
      }
    }
    catch (IOException|OutOfMemoryError localIOException)
    {
      label171:
      break label171;
    }
    if (this.this$0.a != null) {
      this.this$0.a.runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeShareHelper.5
 * JD-Core Version:    0.7.0.1
 */