package com.tencent.biz.richframework.util;

import android.graphics.Paint;
import android.graphics.Typeface;
import com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener;
import java.util.concurrent.ConcurrentHashMap;

final class RFWTypefaceUtil$2
  implements RFWDownloader.RFWDownloadListener
{
  RFWTypefaceUtil$2(String paramString, Paint paramPaint) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onRspCallback(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      int i = 0;
      while (i < 3)
      {
        try
        {
          Typeface localTypeface = Typeface.createFromFile(paramString);
          RFWTypefaceUtil.a().put(this.a, localTypeface);
          this.b.setTypeface(localTypeface);
          return;
        }
        catch (Throwable localThrowable)
        {
          label41:
          break label41;
        }
        i += 1;
      }
    }
    else
    {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.util.RFWTypefaceUtil.2
 * JD-Core Version:    0.7.0.1
 */