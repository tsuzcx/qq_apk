package com.tencent.mobileqq.apollo.game;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class ApolloGameTool
{
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
    //   9: new 17	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: sipush 1024
    //   16: invokespecial 20	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore_3
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: getstatic 26	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   26: iload_1
    //   27: aload_3
    //   28: invokevirtual 32	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   31: pop
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: invokevirtual 36	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: iconst_2
    //   39: invokestatic 42	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: astore_2
    //   45: aload_3
    //   46: ifnull +13 -> 59
    //   49: aload_3
    //   50: invokevirtual 45	java/io/ByteArrayOutputStream:flush	()V
    //   53: aload_3
    //   54: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   57: aload_0
    //   58: astore_2
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: aload_2
    //   63: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 52	java/lang/Exception:printStackTrace	()V
    //   77: aload 4
    //   79: astore_2
    //   80: aload_3
    //   81: ifnull -22 -> 59
    //   84: aload_3
    //   85: invokevirtual 45	java/io/ByteArrayOutputStream:flush	()V
    //   88: aload_3
    //   89: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +11 -> 116
    //   108: aload_2
    //   109: invokevirtual 45	java/io/ByteArrayOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual 51	java/io/IOException:printStackTrace	()V
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
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (ApolloGameActivity.a != null) && (ApolloGameActivity.a.get() != null) && (!((ApolloGameActivity)ApolloGameActivity.a.get()).isFinishing());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloGameTool
 * JD-Core Version:    0.7.0.1
 */