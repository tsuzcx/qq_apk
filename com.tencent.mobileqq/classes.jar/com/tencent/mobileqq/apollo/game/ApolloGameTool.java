package com.tencent.mobileqq.apollo.game;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLDecoder;
import org.json.JSONObject;

public class ApolloGameTool
{
  private static final String[] a = { "http", "https", "GameRes", "GameSandBox" };
  
  public static int a()
  {
    return 5894;
  }
  
  public static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        int i = new JSONObject(paramString).optInt("xyRootSrc");
        return i;
      }
      catch (Throwable paramString)
      {
        QLog.e("[cmshow]ApolloGameTool", 1, paramString, new Object[0]);
      }
    }
    return 0;
  }
  
  /* Error */
  public static String a(android.graphics.Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnull +106 -> 109
    //   6: new 59	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush 1024
    //   13: invokespecial 62	java/io/ByteArrayOutputStream:<init>	(I)V
    //   16: astore_3
    //   17: aload_3
    //   18: astore_2
    //   19: aload_0
    //   20: getstatic 68	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   23: iload_1
    //   24: aload_3
    //   25: invokevirtual 74	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   28: pop
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 78	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   35: iconst_2
    //   36: invokestatic 84	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   39: astore_0
    //   40: aload_3
    //   41: astore_2
    //   42: goto +69 -> 111
    //   45: astore_0
    //   46: goto +12 -> 58
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_2
    //   52: goto +35 -> 87
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_3
    //   58: aload_3
    //   59: astore_2
    //   60: aload_0
    //   61: invokevirtual 87	java/lang/Exception:printStackTrace	()V
    //   64: aload_3
    //   65: ifnull +19 -> 84
    //   68: aload_3
    //   69: invokevirtual 90	java/io/ByteArrayOutputStream:flush	()V
    //   72: aload_3
    //   73: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   76: goto +8 -> 84
    //   79: astore_0
    //   80: aload_0
    //   81: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_0
    //   87: aload_2
    //   88: ifnull +19 -> 107
    //   91: aload_2
    //   92: invokevirtual 90	java/io/ByteArrayOutputStream:flush	()V
    //   95: aload_2
    //   96: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   99: goto +8 -> 107
    //   102: astore_2
    //   103: aload_2
    //   104: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   107: aload_0
    //   108: athrow
    //   109: aconst_null
    //   110: astore_0
    //   111: aload_2
    //   112: ifnull +18 -> 130
    //   115: aload_2
    //   116: invokevirtual 90	java/io/ByteArrayOutputStream:flush	()V
    //   119: aload_2
    //   120: invokevirtual 93	java/io/ByteArrayOutputStream:close	()V
    //   123: aload_0
    //   124: areturn
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   130: aload_0
    //   131: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramBitmap	android.graphics.Bitmap
    //   0	132	1	paramInt	int
    //   1	95	2	localObject	Object
    //   102	18	2	localIOException1	java.io.IOException
    //   125	2	2	localIOException2	java.io.IOException
    //   16	57	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   19	29	45	java/lang/Exception
    //   31	40	45	java/lang/Exception
    //   6	17	49	finally
    //   6	17	55	java/lang/Exception
    //   68	76	79	java/io/IOException
    //   19	29	86	finally
    //   31	40	86	finally
    //   60	64	86	finally
    //   91	99	102	java/io/IOException
    //   115	123	125	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    Object localObject1 = paramString1;
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject5 = null;
    if (bool) {
      return null;
    }
    if (paramString1.length() > 4096)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("[urlToPath] too long ");
        paramString2.append(paramString1.substring(0, 100));
        QLog.d("[cmshow]ApolloGameTool", 2, paramString2.toString());
      }
      return null;
    }
    Object localObject3;
    try
    {
      localObject3 = URLDecoder.decode(paramString1, "UTF-8");
      localObject1 = localObject3;
      int i = ((String)localObject3).indexOf("://");
      if (i == -1) {
        return null;
      }
      paramString1 = (String)localObject3;
      if (paramBoolean)
      {
        localObject1 = localObject3;
        paramString1 = Uri.parse((String)localObject3);
        localObject1 = localObject3;
        localObject4 = paramString1.getHost();
        localObject1 = localObject3;
        j = paramString1.getPort();
        localObject2 = localObject3;
        if (j != 0)
        {
          localObject1 = localObject3;
          paramString1 = new StringBuilder();
          localObject1 = localObject3;
          paramString1.append(":");
          localObject1 = localObject3;
          paramString1.append(j);
          localObject1 = localObject3;
          localObject2 = ((String)localObject3).replace(paramString1.toString(), "");
        }
        paramString1 = (String)localObject2;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = localObject2;
          paramString1 = new StringBuilder();
          localObject1 = localObject2;
          paramString1.append((String)localObject4);
          localObject1 = localObject2;
          paramString1.append("/");
          localObject1 = localObject2;
          paramString1 = paramString1.toString();
          localObject1 = localObject2;
          if (((String)localObject2).contains(paramString1))
          {
            localObject1 = localObject2;
            paramString1 = ((String)localObject2).replace(paramString1, "");
          }
          else
          {
            localObject1 = localObject2;
            paramString1 = ((String)localObject2).replace((CharSequence)localObject4, "");
          }
        }
      }
      Object localObject2 = paramString1;
      localObject1 = paramString1;
      if (paramString1.contains("?"))
      {
        localObject1 = paramString1;
        j = paramString1.indexOf("?");
        if (j == 0) {
          return null;
        }
        localObject2 = paramString1;
        if (j != -1)
        {
          localObject1 = paramString1;
          localObject2 = paramString1.substring(0, j);
        }
      }
      localObject1 = localObject2;
      Object localObject4 = ((String)localObject2).substring(0, i);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        return null;
      }
      localObject1 = localObject2;
      Object localObject6 = a;
      localObject1 = localObject2;
      int j = localObject6.length;
      i = 0;
      for (;;)
      {
        paramString1 = (String)localObject2;
        localObject3 = localObject5;
        if (i >= j) {
          break label849;
        }
        localObject1 = localObject2;
        if (((String)localObject4).equals(localObject6[i])) {
          break;
        }
        i += 1;
      }
      localObject1 = localObject2;
      localObject6 = a(String.valueOf(paramInt));
      localObject1 = localObject2;
      paramString1 = new StringBuilder();
      localObject1 = localObject2;
      paramString1.append((String)localObject4);
      localObject1 = localObject2;
      paramString1.append("://");
      localObject1 = localObject2;
      paramString1 = ((String)localObject2).replace(paramString1.toString(), "");
      localObject4 = paramString1;
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString2))
      {
        localObject1 = localObject2;
        localObject3 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(paramString2);
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append("/");
        localObject1 = localObject2;
        ((StringBuilder)localObject3).append(paramString1);
        localObject1 = localObject2;
        localObject4 = ((StringBuilder)localObject3).toString();
      }
      localObject1 = localObject2;
      paramString1 = (String)localObject2;
      localObject3 = localObject5;
      if (!TextUtils.isEmpty((CharSequence)localObject6))
      {
        localObject1 = localObject2;
        paramString1 = (String)localObject2;
        localObject3 = localObject5;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject1 = localObject2;
          paramString1 = new StringBuilder();
          localObject1 = localObject2;
          paramString1.append((String)localObject6);
          localObject1 = localObject2;
          paramString1.append("/");
          localObject1 = localObject2;
          paramString1.append((String)localObject4);
          localObject1 = localObject2;
          paramString2 = new File(paramString1.toString());
          localObject1 = localObject2;
          localObject4 = new File((String)localObject6);
          localObject1 = localObject2;
          paramString1 = (String)localObject2;
          localObject3 = localObject5;
          if (paramString2.exists())
          {
            localObject1 = localObject2;
            paramString1 = (String)localObject2;
            localObject3 = localObject5;
            if (paramString2.isFile())
            {
              localObject1 = localObject2;
              paramString1 = ((File)localObject4).getCanonicalPath();
              localObject1 = localObject2;
              localObject3 = paramString2.getCanonicalPath();
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(paramString1))
              {
                localObject1 = localObject2;
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  localObject1 = localObject2;
                  if (((String)localObject3).startsWith(paramString1))
                  {
                    paramString1 = (String)localObject2;
                    break label849;
                  }
                }
              }
              localObject1 = localObject2;
              paramString1 = (String)localObject2;
              localObject3 = localObject5;
              if (QLog.isColorLevel())
              {
                localObject1 = localObject2;
                QLog.d("[cmshow]ApolloGameTool", 2, "[urlToPath] path leak");
                paramString1 = (String)localObject2;
                localObject3 = localObject5;
              }
            }
          }
        }
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("[cmshow]ApolloGameTool", 1, paramString1, new Object[0]);
      localObject3 = localObject5;
      paramString1 = (String)localObject1;
    }
    label849:
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("[urlToPath] ");
      paramString2.append(paramString1);
      paramString2.append(" ");
      paramString2.append((String)localObject3);
      QLog.d("[cmshow]ApolloGameTool", 2, paramString2.toString());
    }
    return localObject3;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject(paramString1);
      arrayOfString = ApolloGameConst.Security.a;
      j = arrayOfString.length;
      i = 0;
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        String[] arrayOfString;
        int j;
        int i;
        Object localObject2;
        Object localObject1;
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      localObject2 = arrayOfString[i];
      if (paramString1.has((String)localObject2))
      {
        localObject1 = paramString1.opt((String)localObject2);
        if ((localObject1 != null) && (!localObject1.toString().equals(paramString2)))
        {
          if ((localObject1 instanceof String)) {
            paramString1.put((String)localObject2, paramString2);
          } else if ((localObject1 instanceof Integer)) {
            paramString1.put((String)localObject2, Integer.parseInt(paramString2));
          } else if ((localObject1 instanceof Long)) {
            paramString1.put((String)localObject2, Long.parseLong(paramString2));
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[filterSSOPara] ");
            ((StringBuilder)localObject2).append(localObject1);
            ((StringBuilder)localObject2).append(" ");
            ((StringBuilder)localObject2).append(paramString2);
            QLog.e("[cmshow]ApolloGameTool", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
    }
    else
    {
      paramString1.put("from", "android.H5");
      paramString1 = paramString1.toString();
      return paramString1;
      QLog.e("[cmshow]ApolloGameTool", 1, new Object[0]);
      return null;
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      if (paramActivity.isFinishing()) {
        return;
      }
      paramActivity = paramActivity.getWindow();
      if (paramActivity == null) {
        return;
      }
      paramActivity.getDecorView().setSystemUiVisibility(a());
    }
  }
  
  public static boolean a(String paramString)
  {
    return TextUtils.isEmpty(paramString) ^ true;
  }
  
  public static String b(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        String str = paramString.replace("\\", "\\\\").replace("'", "\\'");
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloGameTool", 1, localThrowable, new Object[0]);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameTool
 * JD-Core Version:    0.7.0.1
 */