import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build;
import com.tencent.image.SafeBitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class bcwc
{
  private static ReferenceQueue<Bitmap> jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private static Map<String, bcwe<Bitmap>> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    int i = 1;
    if ((j > paramInt2) || (k > paramInt1))
    {
      if (k > j) {
        i = Math.round(j / paramInt2);
      }
    }
    else {
      return i;
    }
    return Math.round(k / paramInt1);
  }
  
  public static Bitmap a(Resources paramResources, int paramInt)
  {
    a();
    localbcwd = new bcwd();
    for (;;)
    {
      try
      {
        localObject = new BitmapFactory.Options();
        if (((!"Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) || (!Build.MODEL.toUpperCase().startsWith("MI 2"))) && ((!"BBK".equalsIgnoreCase(Build.MANUFACTURER)) || (!Build.MODEL.toUpperCase().startsWith("VIVO")))) {
          continue;
        }
        ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
        localbcwd.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramResources, paramInt, (BitmapFactory.Options)localObject);
      }
      catch (OutOfMemoryError paramResources)
      {
        Object localObject;
        localbcwd.jdField_a_of_type_Int = 1;
        continue;
      }
      catch (Throwable paramResources)
      {
        localbcwd.jdField_a_of_type_Int = 3;
        continue;
      }
      if (localbcwd.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        localbcwd.jdField_a_of_type_Int = 0;
        paramResources = String.valueOf(localbcwd.jdField_a_of_type_AndroidGraphicsBitmap.hashCode());
        localObject = new bcwe(paramResources, localbcwd.jdField_a_of_type_AndroidGraphicsBitmap, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramResources, localObject);
      }
      return localbcwd.jdField_a_of_type_AndroidGraphicsBitmap;
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
    }
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt2, paramInt3);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, (BitmapFactory.Options)localObject);
    if (paramResources != null)
    {
      localObject = String.valueOf(paramResources.hashCode());
      bcwe localbcwe = new bcwe((String)localObject, paramResources, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(localObject, localbcwe);
    }
    return paramResources;
  }
  
  public static Bitmap a(InputStream paramInputStream, Rect paramRect, int paramInt1, int paramInt2)
  {
    
    if (paramInputStream.markSupported()) {
      paramInputStream.mark(8092);
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.ARGB_8888;
    SafeBitmapFactory.decodeStream(paramInputStream, paramRect, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    try
    {
      paramInputStream.reset();
      paramInputStream = SafeBitmapFactory.decodeStream(paramInputStream, paramRect, (BitmapFactory.Options)localObject);
      if (paramInputStream != null)
      {
        paramRect = String.valueOf(paramInputStream.hashCode());
        localObject = new bcwe(paramRect, paramInputStream, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramRect, localObject);
      }
      return paramInputStream;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    a();
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inSampleSize = a((BitmapFactory.Options)localObject, paramInt1, paramInt2);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    paramString = SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    if (paramString != null)
    {
      localObject = String.valueOf(paramString.hashCode());
      bcwe localbcwe = new bcwe((String)localObject, paramString, jdField_a_of_type_JavaLangRefReferenceQueue);
      jdField_a_of_type_JavaUtilMap.put(localObject, localbcwe);
    }
    return paramString;
  }
  
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    bcwd localbcwd = new bcwd();
    a(paramString, paramOptions, localbcwd);
    return localbcwd.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    a();
    localbcwd = new bcwd();
    for (;;)
    {
      try
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        if ((!"Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) || (!Build.MODEL.toUpperCase().startsWith("MI 2"))) {
          continue;
        }
        localObject = Bitmap.Config.ARGB_8888;
        localOptions.inPreferredConfig = ((Bitmap.Config)localObject);
        localbcwd.jdField_a_of_type_AndroidGraphicsBitmap = SafeBitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        Object localObject;
        localbcwd.jdField_a_of_type_Int = 1;
        continue;
      }
      catch (Throwable paramArrayOfByte)
      {
        localbcwd.jdField_a_of_type_Int = 3;
        continue;
      }
      if (localbcwd.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        localbcwd.jdField_a_of_type_Int = 0;
        paramArrayOfByte = String.valueOf(localbcwd.jdField_a_of_type_AndroidGraphicsBitmap.hashCode());
        localObject = new bcwe(paramArrayOfByte, localbcwd.jdField_a_of_type_AndroidGraphicsBitmap, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramArrayOfByte, localObject);
      }
      return localbcwd.jdField_a_of_type_AndroidGraphicsBitmap;
      localObject = Bitmap.Config.RGB_565;
    }
  }
  
  public static bcwd a(String paramString, BitmapFactory.Options paramOptions)
  {
    bcwd localbcwd = new bcwd();
    a(paramString, paramOptions, localbcwd);
    return localbcwd;
  }
  
  private static void a()
  {
    for (;;)
    {
      bcwe localbcwe = (bcwe)jdField_a_of_type_JavaLangRefReferenceQueue.poll();
      if (localbcwe == null) {
        break;
      }
      jdField_a_of_type_JavaUtilMap.remove(bcwe.a(localbcwe));
    }
  }
  
  /* Error */
  public static void a(String paramString, BitmapFactory.Options paramOptions, bcwd parambcwd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 5
    //   15: aconst_null
    //   16: astore 8
    //   18: invokestatic 53	bcwc:a	()V
    //   21: new 196	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 199	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore 11
    //   31: aload 11
    //   33: ifnull +11 -> 44
    //   36: aload 11
    //   38: invokevirtual 202	java/io/File:exists	()Z
    //   41: ifne +32 -> 73
    //   44: aload_2
    //   45: iconst_2
    //   46: putfield 107	bcwd:jdField_a_of_type_Int	I
    //   49: iconst_0
    //   50: ifeq +11 -> 61
    //   53: new 204	java/lang/NullPointerException
    //   56: dup
    //   57: invokespecial 205	java/lang/NullPointerException:<init>	()V
    //   60: athrow
    //   61: iconst_0
    //   62: ifeq +10 -> 72
    //   65: invokestatic 211	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   68: aconst_null
    //   69: invokevirtual 215	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   72: return
    //   73: new 217	java/io/BufferedInputStream
    //   76: dup
    //   77: new 219	java/io/FileInputStream
    //   80: dup
    //   81: aload 11
    //   83: invokespecial 222	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: invokespecial 225	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   89: astore 4
    //   91: aload 7
    //   93: astore 9
    //   95: aload 6
    //   97: astore 10
    //   99: aload 5
    //   101: astore 8
    //   103: aload 11
    //   105: invokevirtual 229	java/io/File:length	()J
    //   108: l2i
    //   109: istore_3
    //   110: aload 7
    //   112: astore 9
    //   114: aload 6
    //   116: astore 10
    //   118: aload 5
    //   120: astore 8
    //   122: invokestatic 211	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   125: iload_3
    //   126: invokevirtual 233	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   129: astore 7
    //   131: aload 7
    //   133: astore 5
    //   135: aload 4
    //   137: astore 6
    //   139: aload 7
    //   141: astore 9
    //   143: aload 7
    //   145: astore 10
    //   147: aload 7
    //   149: astore 8
    //   151: iload_3
    //   152: aload 4
    //   154: aload 7
    //   156: invokevirtual 237	java/io/InputStream:read	([B)I
    //   159: if_icmpeq +52 -> 211
    //   162: aload 7
    //   164: astore 5
    //   166: aload 4
    //   168: astore 6
    //   170: aload 7
    //   172: astore 9
    //   174: aload 7
    //   176: astore 10
    //   178: aload 7
    //   180: astore 8
    //   182: aload_2
    //   183: iconst_3
    //   184: putfield 107	bcwd:jdField_a_of_type_Int	I
    //   187: aload 4
    //   189: ifnull +8 -> 197
    //   192: aload 4
    //   194: invokevirtual 240	java/io/InputStream:close	()V
    //   197: aload 7
    //   199: ifnull -127 -> 72
    //   202: invokestatic 211	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   205: aload 7
    //   207: invokevirtual 215	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   210: return
    //   211: aload 7
    //   213: astore 5
    //   215: aload 4
    //   217: astore 6
    //   219: aload 7
    //   221: astore 9
    //   223: aload 7
    //   225: astore 10
    //   227: aload 7
    //   229: astore 8
    //   231: aload_2
    //   232: aload 7
    //   234: iconst_0
    //   235: aload 7
    //   237: arraylength
    //   238: aload_1
    //   239: invokestatic 180	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   242: putfield 105	bcwd:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   245: aload 4
    //   247: ifnull +8 -> 255
    //   250: aload 4
    //   252: invokevirtual 240	java/io/InputStream:close	()V
    //   255: aload 7
    //   257: ifnull +11 -> 268
    //   260: invokestatic 211	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   263: aload 7
    //   265: invokevirtual 215	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   268: aload_2
    //   269: getfield 105	bcwd:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   272: ifnull -200 -> 72
    //   275: aload_2
    //   276: iconst_0
    //   277: putfield 107	bcwd:jdField_a_of_type_Int	I
    //   280: new 117	bcwe
    //   283: dup
    //   284: aload_0
    //   285: aload_2
    //   286: getfield 105	bcwd:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   289: getstatic 29	bcwc:jdField_a_of_type_JavaLangRefReferenceQueue	Ljava/lang/ref/ReferenceQueue;
    //   292: invokespecial 120	bcwe:<init>	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V
    //   295: astore_1
    //   296: getstatic 24	bcwc:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   299: aload_0
    //   300: aload_1
    //   301: invokeinterface 126 3 0
    //   306: pop
    //   307: return
    //   308: astore_1
    //   309: aconst_null
    //   310: astore 4
    //   312: aload 8
    //   314: astore 5
    //   316: aload 4
    //   318: astore 6
    //   320: aload_2
    //   321: iconst_2
    //   322: putfield 107	bcwd:jdField_a_of_type_Int	I
    //   325: aload 4
    //   327: ifnull +8 -> 335
    //   330: aload 4
    //   332: invokevirtual 240	java/io/InputStream:close	()V
    //   335: aload 8
    //   337: ifnull -69 -> 268
    //   340: invokestatic 211	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   343: aload 8
    //   345: invokevirtual 215	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   348: goto -80 -> 268
    //   351: astore_1
    //   352: aconst_null
    //   353: astore 4
    //   355: aload 10
    //   357: astore 5
    //   359: aload 4
    //   361: astore 6
    //   363: aload_2
    //   364: iconst_1
    //   365: putfield 107	bcwd:jdField_a_of_type_Int	I
    //   368: aload 4
    //   370: ifnull +8 -> 378
    //   373: aload 4
    //   375: invokevirtual 240	java/io/InputStream:close	()V
    //   378: aload 10
    //   380: ifnull -112 -> 268
    //   383: invokestatic 211	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   386: aload 10
    //   388: invokevirtual 215	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   391: goto -123 -> 268
    //   394: astore_1
    //   395: aconst_null
    //   396: astore 4
    //   398: aload 9
    //   400: astore 5
    //   402: aload 4
    //   404: astore 6
    //   406: aload_2
    //   407: iconst_3
    //   408: putfield 107	bcwd:jdField_a_of_type_Int	I
    //   411: aload 4
    //   413: ifnull +8 -> 421
    //   416: aload 4
    //   418: invokevirtual 240	java/io/InputStream:close	()V
    //   421: aload 9
    //   423: ifnull -155 -> 268
    //   426: invokestatic 211	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   429: aload 9
    //   431: invokevirtual 215	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   434: goto -166 -> 268
    //   437: astore_0
    //   438: aconst_null
    //   439: astore_2
    //   440: aconst_null
    //   441: astore_1
    //   442: aload_2
    //   443: ifnull +7 -> 450
    //   446: aload_2
    //   447: invokevirtual 240	java/io/InputStream:close	()V
    //   450: aload_1
    //   451: ifnull +10 -> 461
    //   454: invokestatic 211	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   457: aload_1
    //   458: invokevirtual 215	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   461: aload_0
    //   462: athrow
    //   463: astore_0
    //   464: goto -403 -> 61
    //   467: astore_0
    //   468: goto -271 -> 197
    //   471: astore_1
    //   472: goto -217 -> 255
    //   475: astore_1
    //   476: goto -141 -> 335
    //   479: astore_1
    //   480: goto -102 -> 378
    //   483: astore_1
    //   484: goto -63 -> 421
    //   487: astore_2
    //   488: goto -38 -> 450
    //   491: astore_0
    //   492: aload 4
    //   494: astore_2
    //   495: aconst_null
    //   496: astore_1
    //   497: goto -55 -> 442
    //   500: astore_0
    //   501: aload 6
    //   503: astore_2
    //   504: aload 5
    //   506: astore_1
    //   507: goto -65 -> 442
    //   510: astore_1
    //   511: goto -113 -> 398
    //   514: astore_1
    //   515: goto -160 -> 355
    //   518: astore_1
    //   519: goto -207 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	522	0	paramString	String
    //   0	522	1	paramOptions	BitmapFactory.Options
    //   0	522	2	parambcwd	bcwd
    //   109	51	3	i	int
    //   89	404	4	localBufferedInputStream	java.io.BufferedInputStream
    //   13	492	5	localObject1	Object
    //   10	492	6	localObject2	Object
    //   7	257	7	arrayOfByte	byte[]
    //   16	328	8	localObject3	Object
    //   4	426	9	localObject4	Object
    //   1	386	10	localObject5	Object
    //   29	75	11	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   21	31	308	java/io/FileNotFoundException
    //   36	44	308	java/io/FileNotFoundException
    //   44	49	308	java/io/FileNotFoundException
    //   73	91	308	java/io/FileNotFoundException
    //   21	31	351	java/lang/OutOfMemoryError
    //   36	44	351	java/lang/OutOfMemoryError
    //   44	49	351	java/lang/OutOfMemoryError
    //   73	91	351	java/lang/OutOfMemoryError
    //   21	31	394	java/lang/Throwable
    //   36	44	394	java/lang/Throwable
    //   44	49	394	java/lang/Throwable
    //   73	91	394	java/lang/Throwable
    //   21	31	437	finally
    //   36	44	437	finally
    //   44	49	437	finally
    //   73	91	437	finally
    //   53	61	463	java/io/IOException
    //   192	197	467	java/io/IOException
    //   250	255	471	java/io/IOException
    //   330	335	475	java/io/IOException
    //   373	378	479	java/io/IOException
    //   416	421	483	java/io/IOException
    //   446	450	487	java/io/IOException
    //   103	110	491	finally
    //   122	131	491	finally
    //   151	162	500	finally
    //   182	187	500	finally
    //   231	245	500	finally
    //   320	325	500	finally
    //   363	368	500	finally
    //   406	411	500	finally
    //   103	110	510	java/lang/Throwable
    //   122	131	510	java/lang/Throwable
    //   151	162	510	java/lang/Throwable
    //   182	187	510	java/lang/Throwable
    //   231	245	510	java/lang/Throwable
    //   103	110	514	java/lang/OutOfMemoryError
    //   122	131	514	java/lang/OutOfMemoryError
    //   151	162	514	java/lang/OutOfMemoryError
    //   182	187	514	java/lang/OutOfMemoryError
    //   231	245	514	java/lang/OutOfMemoryError
    //   103	110	518	java/io/FileNotFoundException
    //   122	131	518	java/io/FileNotFoundException
    //   151	162	518	java/io/FileNotFoundException
    //   182	187	518	java/io/FileNotFoundException
    //   231	245	518	java/io/FileNotFoundException
  }
  
  public static Bitmap b(Resources paramResources, int paramInt)
  {
    a();
    bcwd localbcwd = new bcwd();
    try
    {
      localbcwd.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramResources, paramInt, new BitmapFactory.Options());
      if (localbcwd.jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        localbcwd.jdField_a_of_type_Int = 0;
        paramResources = String.valueOf(localbcwd.jdField_a_of_type_AndroidGraphicsBitmap.hashCode());
        bcwe localbcwe = new bcwe(paramResources, localbcwd.jdField_a_of_type_AndroidGraphicsBitmap, jdField_a_of_type_JavaLangRefReferenceQueue);
        jdField_a_of_type_JavaUtilMap.put(paramResources, localbcwe);
      }
      return localbcwd.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    catch (OutOfMemoryError paramResources)
    {
      for (;;)
      {
        localbcwd.jdField_a_of_type_Int = 1;
      }
    }
    catch (Throwable paramResources)
    {
      for (;;)
      {
        localbcwd.jdField_a_of_type_Int = 3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcwc
 * JD-Core Version:    0.7.0.1
 */