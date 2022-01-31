package com.tencent.mobileqq.apollo.game;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;

public class ApolloGameTool
{
  private static final String[] a = { "http", "https", "GameRes", "GameSandBox" };
  
  /* Error */
  public static String a(android.graphics.Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_0
    //   6: ifnull +128 -> 134
    //   9: new 31	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: sipush 1024
    //   16: invokespecial 34	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getstatic 40	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: iload_1
    //   27: aload_3
    //   28: invokevirtual 46	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 50	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: iconst_2
    //   39: invokestatic 56	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +13 -> 59
    //   49: aload_3
    //   50: invokevirtual 59	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -22 -> 59
    //   84: aload_3
    //   85: invokevirtual 59	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload_3
    //   89: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 59	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 62	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 65	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore_0
    //   127: goto -23 -> 104
    //   130: astore_0
    //   131: goto -60 -> 71
    //   134: aconst_null
    //   135: astore_3
    //   136: aload_2
    //   137: astore_0
    //   138: goto -95 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramBitmap	android.graphics.Bitmap
    //   0	141	1	paramInt	int
    //   4	56	2	localObject1	Object
    //   61	2	2	localIOException1	java.io.IOException
    //   72	41	2	localObject2	Object
    //   118	19	2	localIOException2	java.io.IOException
    //   19	117	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   1	77	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	61	java/io/IOException
    //   9	20	68	java/lang/Exception
    //   84	92	94	java/io/IOException
    //   9	20	101	finally
    //   108	116	118	java/io/IOException
    //   22	32	126	finally
    //   34	43	126	finally
    //   73	77	126	finally
    //   22	32	130	java/lang/Exception
    //   34	43	130	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    return ApolloGameConst.a + "/" + paramString;
  }
  
  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString1))
    {
      try
      {
        if (paramString1.length() > 4096)
        {
          if (!QLog.isColorLevel()) {
            break label738;
          }
          QLog.d("ApolloGameTool", 2, "[urlToPath] too long " + paramString1.substring(0, 100));
          return null;
        }
        localObject1 = URLDecoder.decode(paramString1, "UTF-8");
        paramString1 = (String)localObject1;
      }
      catch (Throwable paramString2)
      {
        for (;;)
        {
          int i;
          String str;
          int j;
          label151:
          QLog.e("ApolloGameTool", 1, paramString2, new Object[0]);
          localObject1 = paramString1;
          localObject2 = localObject4;
        }
      }
      try
      {
        i = paramString1.indexOf("://");
        localObject1 = paramString1;
        localObject2 = localObject4;
        if (i == -1) {
          break label577;
        }
        if (!paramBoolean) {
          break label725;
        }
        localObject1 = Uri.parse(paramString1);
        str = ((Uri)localObject1).getHost();
        j = ((Uri)localObject1).getPort();
        if (j == 0) {
          break label719;
        }
        localObject1 = paramString1.replace(":" + j, "");
      }
      catch (Throwable paramString2)
      {
        break label680;
        localObject1 = paramString1;
        break label151;
        break label217;
      }
      paramString1 = (String)localObject1;
      localObject2 = localObject1;
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(str))
        {
          localObject2 = localObject1;
          paramString1 = str + "/";
          localObject2 = localObject1;
          if (!((String)localObject1).contains(paramString1)) {
            continue;
          }
          localObject2 = localObject1;
          paramString1 = ((String)localObject1).replace(paramString1, "");
        }
        label217:
        localObject1 = paramString1;
        localObject2 = paramString1;
        if (paramString1.contains("?"))
        {
          localObject2 = paramString1;
          j = paramString1.indexOf("?");
          if (j == 0) {
            break;
          }
          localObject1 = paramString1;
          if (j != -1)
          {
            localObject2 = paramString1;
            localObject1 = paramString1.substring(0, j);
          }
        }
        localObject2 = localObject1;
        paramString1 = ((String)localObject1).substring(0, i);
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        localObject2 = localObject1;
        localObject3 = a;
        localObject2 = localObject1;
        j = localObject3.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        localObject2 = localObject1;
        if (!paramString1.equals(localObject3[i])) {
          continue;
        }
        localObject2 = localObject1;
        str = a(String.valueOf(paramInt));
        localObject2 = localObject1;
        localObject3 = ((String)localObject1).replace(paramString1 + "://", "");
        paramString1 = (String)localObject3;
        localObject2 = localObject1;
        if (!TextUtils.isEmpty(paramString2))
        {
          localObject2 = localObject1;
          paramString1 = paramString2 + "/" + (String)localObject3;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        localObject2 = localObject1;
        paramString1 = new File(str + "/" + paramString1);
        localObject2 = localObject1;
        paramString2 = new File(str);
        localObject2 = localObject1;
        if (!paramString1.exists()) {
          continue;
        }
        localObject2 = localObject1;
        if (!paramString1.isFile()) {
          continue;
        }
        localObject2 = localObject1;
        paramString2 = paramString2.getCanonicalPath();
        localObject2 = localObject1;
        paramString1 = paramString1.getCanonicalPath();
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString2)) {
          continue;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        localObject2 = localObject1;
        paramBoolean = paramString1.startsWith(paramString2);
        if (!paramBoolean) {
          continue;
        }
        localObject2 = paramString1;
      }
      catch (Throwable paramString2)
      {
        label577:
        paramString1 = (String)localObject2;
        label680:
        continue;
        localObject2 = localObject4;
        continue;
      }
      localObject3 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloGameTool", 2, "[urlToPath] " + (String)localObject1 + " " + (String)localObject2);
      return localObject2;
      localObject2 = localObject1;
      paramString1 = ((String)localObject1).replace(str, "");
      continue;
      localObject2 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject2 = localObject1;
        QLog.d("ApolloGameTool", 2, "[urlToPath] path leak");
      }
      paramString1 = null;
      continue;
      i += 1;
      continue;
      label719:
      label725:
      localObject1 = paramString1;
      localObject2 = localObject4;
    }
    label738:
    return localObject3;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    for (;;)
    {
      int i;
      String str;
      try
      {
        paramString1 = new JSONObject(paramString1);
        String[] arrayOfString = ApolloGameConst.Security.a;
        int j = arrayOfString.length;
        i = 0;
        if (i >= j) {
          break label182;
        }
        str = arrayOfString[i];
        if (!paramString1.has(str)) {
          break label198;
        }
        Object localObject = paramString1.opt(str);
        if ((localObject == null) || (localObject.toString().equals(paramString2))) {
          break label198;
        }
        if ((localObject instanceof String))
        {
          paramString1.put(str, paramString2);
          if (!QLog.isColorLevel()) {
            break label198;
          }
          QLog.e("ApolloGameTool", 2, "[filterSSOPara] " + localObject + " " + paramString2);
          break label198;
        }
        if ((localObject instanceof Integer))
        {
          paramString1.put(str, Integer.parseInt(paramString2));
          continue;
        }
        if (!(localObject instanceof Long)) {
          continue;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("ApolloGameTool", 1, new Object[0]);
        return null;
      }
      paramString1.put(str, Long.parseLong(paramString2));
      continue;
      label182:
      paramString1.put("from", "android.H5");
      paramString1 = paramString1.toString();
      return paramString1;
      label198:
      i += 1;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      paramActivity = paramActivity.getWindow();
      if (paramActivity != null) {
        paramActivity.getDecorView().setSystemUiVisibility(5894);
      }
    }
  }
  
  public static boolean a()
  {
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (ApolloGameActivity.a != null) && (ApolloGameActivity.a.get() != null);
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        str = paramString.replace("\\", "\\\\").replace("'", "\\'");
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameTool", 1, localThrowable, new Object[0]);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameTool
 * JD-Core Version:    0.7.0.1
 */