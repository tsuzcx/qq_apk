package com.tencent.luggage.wxa.qq;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import com.tencent.luggage.wxa.qt.a;
import com.tencent.luggage.wxa.qt.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class e
{
  private static final String[] a = { "#", "?", "&" };
  private static String b = null;
  private static String c = null;
  private static final Pattern d = Pattern.compile("songid=([0-9]+)");
  
  private static int a(char paramChar)
  {
    if ((paramChar >= '1') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return 0;
  }
  
  public static String a(Context paramContext)
  {
    Object localObject2 = r.b();
    Object localObject1 = "";
    if (localObject2 == null) {
      return "";
    }
    try
    {
      localObject2 = paramContext.getPackageManager().getPackageInfo((String)localObject2, 0);
      paramContext = (Context)localObject1;
      if (localObject2 != null)
      {
        paramContext = new StringBuilder();
        paramContext.append("");
        paramContext.append(((PackageInfo)localObject2).versionName);
        paramContext = paramContext.toString();
        try
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramContext);
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(((PackageInfo)localObject2).versionCode);
          localObject1 = ((StringBuilder)localObject1).toString();
          paramContext = (Context)localObject1;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException1)
        {
          break label109;
        }
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      paramContext = "";
      label109:
      o.a("MicroMsg.Music.MusicUrlUtil", localNameNotFoundException2, "", new Object[0]);
    }
    return paramContext;
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean, a parama)
  {
    String str;
    if ((!paramBoolean) && (!af.c(paramString2))) {
      str = paramString2;
    } else {
      str = paramString1;
    }
    if (af.c(str)) {
      return str;
    }
    d locald = new d();
    o.d("MicroMsg.Music.MusicUrlUtil", "url[%s], lowBandUrl[%s], isWifi[%B]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
    paramString1 = b(str);
    if (paramString1 != null)
    {
      if (a(paramString1, paramBoolean, locald)) {
        parama.a = paramBoolean;
      }
    }
    else if (str.contains("wechat_music_url=")) {
      a(str.substring(str.indexOf("wechat_music_url=") + 17), paramBoolean, locald);
    } else {
      locald.a = str;
    }
    return locald.a;
  }
  
  public static boolean a(String paramString)
  {
    if (af.c(paramString)) {
      return false;
    }
    Uri localUri = Uri.parse(paramString);
    String str;
    if (localUri != null) {
      str = localUri.getHost();
    } else {
      str = "";
    }
    if (str != null)
    {
      boolean bool = localUri.getHost().contains(".qq.com");
      o.c("MicroMsg.Music.MusicUrlUtil", "url %s match ? %B", new Object[] { paramString, Boolean.valueOf(bool) });
      return bool;
    }
    o.d("MicroMsg.Music.MusicUrlUtil", "host is null, url is not match .qq.com");
    return false;
  }
  
  private static boolean a(String paramString, boolean paramBoolean, d paramd)
  {
    Object localObject2 = new String(c(paramString));
    int i = ((String)localObject2).indexOf("{");
    Object localObject1 = localObject2;
    if (i != -1) {
      localObject1 = ((String)localObject2).substring(i);
    }
    try
    {
      localObject2 = new JSONObject((String)localObject1);
      localObject1 = ((JSONObject)localObject2).getString("song_WapLiveURL");
      localObject2 = ((JSONObject)localObject2).getString("song_WifiURL");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("waplive: ");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("  wifi:");
      localStringBuilder.append((String)localObject2);
      o.e("MicroMsg.Music.MusicUrlUtil", localStringBuilder.toString());
      if (paramBoolean) {
        localObject1 = localObject2;
      }
      paramd.a = ((String)localObject1);
      return true;
    }
    catch (Exception localException)
    {
      paramd.a = paramString;
      o.a("MicroMsg.Music.MusicUrlUtil", localException, "decodeJson", new Object[0]);
    }
    return false;
  }
  
  private static String b(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    Object localObject1 = b;
    if ((localObject1 != null) && (paramString.equals(localObject1))) {
      return c;
    }
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    localObject1 = null;
    Object localObject2 = "";
    int i = 0;
    for (;;)
    {
      localObject3 = localObject1;
      if (i >= j) {
        break;
      }
      localObject2 = arrayOfString[i];
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("p=");
      localObject2 = ((StringBuilder)localObject3).toString();
      if (paramString.contains((CharSequence)localObject2)) {
        localObject1 = paramString;
      }
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        break;
      }
      i += 1;
    }
    if (localObject3 == null) {
      return null;
    }
    i = ((String)localObject3).indexOf((String)localObject2);
    if (i < 0)
    {
      o.c("MicroMsg.Music.MusicUrlUtil", "pIndex is %d, return", new Object[] { Integer.valueOf(i) });
      return null;
    }
    localObject1 = ((String)localObject3).substring(i + ((String)localObject2).length());
    Object localObject3 = a;
    j = localObject3.length;
    i = 0;
    while (i < j)
    {
      int k = ((String)localObject1).indexOf(localObject3[i]);
      localObject2 = localObject1;
      if (k > 0) {
        localObject2 = ((String)localObject1).substring(0, k);
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      b = paramString;
      c = (String)localObject1;
    }
    return localObject1;
  }
  
  private static byte[] c(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2 + paramString.length() % 2];
    i = 0;
    int j = 0;
    for (;;)
    {
      try
      {
        if (i >= paramString.length()) {
          continue;
        }
        k = i + 1;
        m = a(paramString.charAt(i));
        if (k >= paramString.length()) {
          continue;
        }
        i = k + 1;
        k = a(paramString.charAt(k));
      }
      catch (Exception paramString)
      {
        int m;
        continue;
        i = k;
        int k = 0;
        continue;
      }
      arrayOfByte[j] = ((byte)(m << 4 | k));
      j += 1;
    }
    return arrayOfByte;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qq.e
 * JD-Core Version:    0.7.0.1
 */