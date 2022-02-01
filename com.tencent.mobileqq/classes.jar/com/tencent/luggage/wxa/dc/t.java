package com.tencent.luggage.wxa.dc;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.wxa.fw.a;
import com.tencent.luggage.wxa.qz.r;
import java.io.File;
import java.net.URLEncoder;

public class t
{
  public static String a = "__MAGIC_MD5_SKIP_CHECK__";
  
  static {}
  
  private static String a()
  {
    return b();
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString2)) {
      str = URLEncoder.encode(paramString2);
    }
    paramString2 = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    return new File(paramString2, localStringBuilder.toString()).getAbsolutePath();
  }
  
  private static String b()
  {
    File localFile = new File(r.a().getFilesDir(), "wxapkg");
    localFile.mkdirs();
    return localFile.getAbsolutePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.t
 * JD-Core Version:    0.7.0.1
 */