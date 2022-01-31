import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class bkmc
{
  @SuppressLint({"InlinedApi"})
  public static final int a;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11) {}
    for (int i = 4;; i = 0)
    {
      a = i;
      return;
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", a).getString(a(paramString1, paramString2), null);
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  public static String a(Iterator<String> paramIterator)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (paramIterator.hasNext())
    {
      String str = (String)paramIterator.next();
      if (!TextUtils.isEmpty(str))
      {
        if (i == 0) {
          localStringBuffer.append(str);
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuffer.append(":").append(str);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static List<String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split(":");
    if ((paramString == null) || (paramString.length <= 0)) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList(paramString.length);
    Collections.addAll(localArrayList, paramString);
    return localArrayList;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", a).edit().remove(a(paramString1, paramString2)).commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", a).edit().putString(a(paramString1, paramString2), paramString3).commit();
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("weiyun.pref.plugin.albumbackup.options", a).getString(a(paramString1, paramString2), null);
    if (paramContext == null) {
      return paramBoolean;
    }
    return Boolean.valueOf(paramContext).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkmc
 * JD-Core Version:    0.7.0.1
 */