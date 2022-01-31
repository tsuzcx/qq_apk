import android.text.TextUtils;
import java.io.File;

public class bhzz
{
  public static int a(String paramString)
  {
    if (a(paramString)) {}
    int i;
    do
    {
      do
      {
        do
        {
          return 0;
          i = paramString.lastIndexOf(File.separator);
        } while ((i == -1) || (i == paramString.length() - 1));
        paramString = paramString.substring(0, i);
      } while (a(paramString));
      i = paramString.lastIndexOf(File.separator);
    } while ((i == -1) || (i == paramString.length() - 1));
    try
    {
      i = Integer.parseInt(paramString.substring(i + 1));
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_1
    //   12: ifnull +60 -> 72
    //   15: aload 6
    //   17: astore_2
    //   18: aload_1
    //   19: getfield 50	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   22: ifeq +50 -> 72
    //   25: aload 6
    //   27: astore_2
    //   28: new 52	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: new 58	java/io/BufferedInputStream
    //   40: dup
    //   41: aload_0
    //   42: sipush 8192
    //   45: invokespecial 61	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   48: aconst_null
    //   49: aload_1
    //   50: invokestatic 67	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   53: astore_1
    //   54: aload_0
    //   55: astore_2
    //   56: aload_1
    //   57: astore_0
    //   58: aload_0
    //   59: astore_1
    //   60: aload_2
    //   61: ifnull +9 -> 70
    //   64: aload_2
    //   65: invokevirtual 73	java/io/InputStream:close	()V
    //   68: aload_0
    //   69: astore_1
    //   70: aload_1
    //   71: areturn
    //   72: aload 6
    //   74: astore_2
    //   75: new 13	java/io/File
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: invokestatic 80	com/tencent/sharpP/SharpPUtils:isSharpP	(Ljava/io/File;)Z
    //   86: ifeq +43 -> 129
    //   89: aload 6
    //   91: astore_2
    //   92: aload_0
    //   93: invokestatic 84	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   96: astore_0
    //   97: aload_0
    //   98: ifnull +225 -> 323
    //   101: aload 6
    //   103: astore_2
    //   104: aload_1
    //   105: aload_0
    //   106: invokevirtual 89	android/graphics/Bitmap:getHeight	()I
    //   109: putfield 93	android/graphics/BitmapFactory$Options:outHeight	I
    //   112: aload 6
    //   114: astore_2
    //   115: aload_1
    //   116: aload_0
    //   117: invokevirtual 96	android/graphics/Bitmap:getWidth	()I
    //   120: putfield 99	android/graphics/BitmapFactory$Options:outWidth	I
    //   123: aload 5
    //   125: astore_2
    //   126: goto -68 -> 58
    //   129: aload 6
    //   131: astore_2
    //   132: invokestatic 105	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   135: invokevirtual 109	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   138: instanceof 111
    //   141: ifeq +33 -> 174
    //   144: aload 6
    //   146: astore_2
    //   147: invokestatic 117	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   150: invokevirtual 121	com/tencent/component/media/image/ImageManager:getDecoder	()Lcom/tencent/component/media/image/IDecoder;
    //   153: new 13	java/io/File
    //   156: dup
    //   157: aload_0
    //   158: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: aload_1
    //   162: invokeinterface 127 3 0
    //   167: astore_0
    //   168: aload 5
    //   170: astore_2
    //   171: goto -113 -> 58
    //   174: aload 6
    //   176: astore_2
    //   177: aload_0
    //   178: aload_1
    //   179: invokestatic 131	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   182: astore_0
    //   183: aload 5
    //   185: astore_2
    //   186: goto -128 -> 58
    //   189: astore_1
    //   190: aconst_null
    //   191: astore_0
    //   192: aload_3
    //   193: astore_2
    //   194: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +14 -> 211
    //   200: aload_3
    //   201: astore_2
    //   202: ldc 139
    //   204: iconst_2
    //   205: ldc 141
    //   207: aload_1
    //   208: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   211: aload_0
    //   212: astore_1
    //   213: aload_3
    //   214: ifnull -144 -> 70
    //   217: aload_3
    //   218: invokevirtual 73	java/io/InputStream:close	()V
    //   221: aload_0
    //   222: areturn
    //   223: astore_1
    //   224: aload_0
    //   225: areturn
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_0
    //   229: aload 4
    //   231: astore_3
    //   232: aload_3
    //   233: astore_2
    //   234: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   237: ifeq +14 -> 251
    //   240: aload_3
    //   241: astore_2
    //   242: ldc 139
    //   244: iconst_2
    //   245: ldc 141
    //   247: aload_1
    //   248: invokestatic 145	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   251: aload_0
    //   252: astore_1
    //   253: aload_3
    //   254: ifnull -184 -> 70
    //   257: aload_3
    //   258: invokevirtual 73	java/io/InputStream:close	()V
    //   261: aload_0
    //   262: areturn
    //   263: astore_1
    //   264: aload_0
    //   265: areturn
    //   266: astore_0
    //   267: aload_2
    //   268: ifnull +7 -> 275
    //   271: aload_2
    //   272: invokevirtual 73	java/io/InputStream:close	()V
    //   275: aload_0
    //   276: athrow
    //   277: astore_1
    //   278: aload_0
    //   279: areturn
    //   280: astore_1
    //   281: goto -6 -> 275
    //   284: astore_1
    //   285: aload_0
    //   286: astore_2
    //   287: aload_1
    //   288: astore_0
    //   289: goto -22 -> 267
    //   292: astore_1
    //   293: aconst_null
    //   294: astore_2
    //   295: aload_0
    //   296: astore_3
    //   297: aload_2
    //   298: astore_0
    //   299: goto -67 -> 232
    //   302: astore_1
    //   303: aload 4
    //   305: astore_3
    //   306: goto -74 -> 232
    //   309: astore_1
    //   310: aconst_null
    //   311: astore_2
    //   312: aload_0
    //   313: astore_3
    //   314: aload_2
    //   315: astore_0
    //   316: goto -124 -> 192
    //   319: astore_1
    //   320: goto -128 -> 192
    //   323: aload 5
    //   325: astore_2
    //   326: goto -268 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramString	String
    //   0	329	1	paramOptions	android.graphics.BitmapFactory.Options
    //   17	309	2	localObject1	Object
    //   1	313	3	localObject2	Object
    //   3	301	4	localObject3	Object
    //   9	315	5	localObject4	Object
    //   6	169	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   18	25	189	java/lang/OutOfMemoryError
    //   28	37	189	java/lang/OutOfMemoryError
    //   75	89	189	java/lang/OutOfMemoryError
    //   92	97	189	java/lang/OutOfMemoryError
    //   132	144	189	java/lang/OutOfMemoryError
    //   147	168	189	java/lang/OutOfMemoryError
    //   177	183	189	java/lang/OutOfMemoryError
    //   217	221	223	java/io/IOException
    //   18	25	226	java/lang/Exception
    //   28	37	226	java/lang/Exception
    //   75	89	226	java/lang/Exception
    //   92	97	226	java/lang/Exception
    //   132	144	226	java/lang/Exception
    //   147	168	226	java/lang/Exception
    //   177	183	226	java/lang/Exception
    //   257	261	263	java/io/IOException
    //   18	25	266	finally
    //   28	37	266	finally
    //   75	89	266	finally
    //   92	97	266	finally
    //   104	112	266	finally
    //   115	123	266	finally
    //   132	144	266	finally
    //   147	168	266	finally
    //   177	183	266	finally
    //   194	200	266	finally
    //   202	211	266	finally
    //   234	240	266	finally
    //   242	251	266	finally
    //   64	68	277	java/io/IOException
    //   271	275	280	java/io/IOException
    //   37	54	284	finally
    //   37	54	292	java/lang/Exception
    //   104	112	302	java/lang/Exception
    //   115	123	302	java/lang/Exception
    //   37	54	309	java/lang/OutOfMemoryError
    //   104	112	319	java/lang/OutOfMemoryError
    //   115	123	319	java/lang/OutOfMemoryError
  }
  
  public static String a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 4)) {
      return "";
    }
    return paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length() - 4);
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static String b(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      do
      {
        return str;
        i = paramString.lastIndexOf(File.separator);
        str = paramString;
      } while (i == -1);
      if (i == paramString.length() - 1) {
        return "";
      }
      paramString = paramString.substring(0, i);
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      i = paramString.lastIndexOf(File.separator);
      str = paramString;
    } while (i == -1);
    if (i == paramString.length() - 1) {
      return "";
    }
    return paramString.substring(i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhzz
 * JD-Core Version:    0.7.0.1
 */