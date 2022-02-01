package com.tencent.luggage.wxa.jw;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.luggage.wxa.rt.i;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class b
{
  private static SimpleDateFormat a;
  
  public static int a(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return 0;
    }
    try
    {
      int i = new ExifInterface(paramInputStream).getAttributeInt("Orientation", 1);
      return i;
    }
    catch (Exception|Error paramInputStream) {}
    return 0;
  }
  
  public static void a(InputStream paramInputStream, String paramString)
  {
    if (paramInputStream != null)
    {
      if (!a(paramString)) {
        return;
      }
      paramString = new ExifInterface(paramString);
      a.a(new ExifInterface(paramInputStream), paramString);
      paramString.setAttribute("Orientation", null);
      paramString.setAttribute("ImageWidth", null);
      paramString.setAttribute("ThumbnailImageWidth", null);
      paramString.saveAttributes();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a(paramString1))
    {
      if (!a(paramString2)) {
        return;
      }
      paramString2 = new ExifInterface(paramString2);
      a.a(new ExifInterface(paramString1), paramString2);
      paramString2.setAttribute("Orientation", null);
      paramString2.setAttribute("ImageWidth", null);
      paramString2.setAttribute("ThumbnailImageWidth", null);
      paramString2.saveAttributes();
    }
  }
  
  private static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new i(paramString).j());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jw.b
 * JD-Core Version:    0.7.0.1
 */