package com.tencent.biz.richframework.util;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import java.util.Hashtable;

final class RFWTypefaceUtil$1
  implements RFWDownloader.RFWDownloadListener
{
  RFWTypefaceUtil$1(String paramString, TextView paramTextView) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      if (i < 3) {}
      try
      {
        Typeface localTypeface = Typeface.createFromFile(paramString);
        RFWTypefaceUtil.a().put(this.jdField_a_of_type_JavaLangString, localTypeface);
        new Handler(Looper.getMainLooper()).post(new RFWTypefaceUtil.1.1(this, localTypeface));
        return;
      }
      catch (Throwable localThrowable)
      {
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.util.RFWTypefaceUtil.1
 * JD-Core Version:    0.7.0.1
 */