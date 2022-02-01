package com.tencent.mobileqq.activity.shortvideo;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProgressiveUtils
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  public static String[] b = { "MI 3", "Coolpad 8675", "OPPO R7", "Redmi Note 2", "MX4", "vivo X5L", "m3 note", "PRO 6" };
  private static ArrayList<String> c = null;
  private static boolean d = false;
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      if (Integer.valueOf(paramString).intValue() == 0) {
        a.set(false);
      } else {
        a.set(true);
      }
    }
    catch (Exception localException)
    {
      label37:
      StringBuilder localStringBuilder;
      break label37;
    }
    a.set(false);
    break label54;
    a.set(false);
    label54:
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseConfig(): config = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", sProgressiveEnable = ");
      localStringBuilder.append(a.get());
      QLog.d("ShortVideo.ProgressiveUtils", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ProgressiveUtils
 * JD-Core Version:    0.7.0.1
 */