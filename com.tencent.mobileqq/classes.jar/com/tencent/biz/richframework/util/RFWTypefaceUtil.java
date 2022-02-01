package com.tencent.biz.richframework.util;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.TextView;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.qcircle.cooperation.config.download.QCircleDownloadConfig;
import java.util.concurrent.ConcurrentHashMap;

public class RFWTypefaceUtil
{
  private static final ConcurrentHashMap<String, Typeface> a = new ConcurrentHashMap();
  
  public static Typeface a(Context paramContext, String paramString)
  {
    if (!a.containsKey(paramString))
    {
      int i = 0;
      while (i < 3)
      {
        try
        {
          Typeface localTypeface = Typeface.createFromAsset(paramContext.getAssets(), String.format("fonts/%s.ttf", new Object[] { paramString }));
          a.put(paramString, localTypeface);
          return localTypeface;
        }
        catch (Throwable localThrowable)
        {
          label49:
          break label49;
        }
        i += 1;
      }
    }
    else
    {
      return (Typeface)a.get(paramString);
    }
  }
  
  public static void a(Paint paramPaint, String paramString)
  {
    if (!a.containsKey(paramString))
    {
      RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).download(paramString, new RFWTypefaceUtil.2(paramString, paramPaint));
      return;
    }
    paramPaint.setTypeface((Typeface)a.get(paramString));
  }
  
  public static void a(Paint paramPaint, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramPaint, "https://downv6.qq.com/video_story/qcircle/ttf/qcircle_number_bold_italic.ttf");
      return;
    }
    a(paramPaint, "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf");
  }
  
  public static void a(TextView paramTextView, String paramString)
  {
    if (!a.containsKey(paramString))
    {
      RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).download(paramString, new RFWTypefaceUtil.1(paramString, paramTextView));
      return;
    }
    paramTextView.setTypeface((Typeface)a.get(paramString));
  }
  
  public static void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramTextView, "https://downv6.qq.com/video_story/qcircle/ttf/qcircle_number_bold_italic.ttf");
      return;
    }
    a(paramTextView, "https://downv6.qq.com/video_story/qcircle/ttf/qircle_number_bold.ttf");
  }
  
  public static void a(String paramString)
  {
    if (!a.containsKey(paramString)) {
      RFWDownloaderFactory.getDownloader(QCircleDownloadConfig.a()).download(paramString, new RFWTypefaceUtil.3(paramString));
    }
  }
  
  public static void b(Paint paramPaint, String paramString)
  {
    a(paramPaint, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.util.RFWTypefaceUtil
 * JD-Core Version:    0.7.0.1
 */