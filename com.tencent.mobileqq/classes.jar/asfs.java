import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class asfs
{
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = SafeBitmapFactory.safeDecode(paramString, paramOptions);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (paramInt1 >= paramInt2) {}
      paramOptions.inSampleSize *= 2;
    }
    return localObject;
    return a(paramString, paramOptions, paramInt1 + 1, paramInt2);
  }
  
  /* Error */
  public static String a(Bitmap paramBitmap, String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_3
    //   4: newarray int
    //   6: astore 7
    //   8: aload 7
    //   10: dup
    //   11: iconst_0
    //   12: bipush 60
    //   14: iastore
    //   15: dup
    //   16: iconst_1
    //   17: bipush 40
    //   19: iastore
    //   20: dup
    //   21: iconst_2
    //   22: bipush 20
    //   24: iastore
    //   25: pop
    //   26: new 32	java/io/ByteArrayOutputStream
    //   29: dup
    //   30: invokespecial 33	java/io/ByteArrayOutputStream:<init>	()V
    //   33: astore 6
    //   35: iconst_0
    //   36: istore 4
    //   38: iconst_0
    //   39: istore_3
    //   40: iload_3
    //   41: aload 7
    //   43: arraylength
    //   44: if_icmpge +30 -> 74
    //   47: aload_0
    //   48: aload 6
    //   50: aload 7
    //   52: iload_3
    //   53: iaload
    //   54: invokestatic 36	asfs:a	(Landroid/graphics/Bitmap;Ljava/io/ByteArrayOutputStream;I)Z
    //   57: istore 4
    //   59: iload 4
    //   61: ifeq +54 -> 115
    //   64: aload 6
    //   66: invokevirtual 40	java/io/ByteArrayOutputStream:size	()I
    //   69: ldc 41
    //   71: if_icmpge +44 -> 115
    //   74: iload_3
    //   75: aload 7
    //   77: arraylength
    //   78: if_icmplt +13 -> 91
    //   81: aload_0
    //   82: aload 6
    //   84: bipush 10
    //   86: invokestatic 36	asfs:a	(Landroid/graphics/Bitmap;Ljava/io/ByteArrayOutputStream;I)Z
    //   89: istore 4
    //   91: iload 4
    //   93: ifne +29 -> 122
    //   96: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +14 -> 113
    //   102: ldc 2
    //   104: invokevirtual 53	java/lang/Class:getName	()Ljava/lang/String;
    //   107: iconst_2
    //   108: ldc 55
    //   110: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aconst_null
    //   114: areturn
    //   115: iload_3
    //   116: iconst_1
    //   117: iadd
    //   118: istore_3
    //   119: goto -79 -> 40
    //   122: aload_2
    //   123: iconst_0
    //   124: aload_0
    //   125: invokevirtual 64	android/graphics/Bitmap:getWidth	()I
    //   128: iastore
    //   129: aload_2
    //   130: iconst_1
    //   131: aload_0
    //   132: invokevirtual 67	android/graphics/Bitmap:getHeight	()I
    //   135: iastore
    //   136: new 69	java/io/File
    //   139: dup
    //   140: aload_1
    //   141: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: invokevirtual 73	java/io/File:getName	()Ljava/lang/String;
    //   147: iconst_0
    //   148: invokestatic 78	avsv:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   151: astore_2
    //   152: new 80	java/io/FileOutputStream
    //   155: dup
    //   156: new 69	java/io/File
    //   159: dup
    //   160: aload_2
    //   161: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   164: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   167: astore_1
    //   168: aload_1
    //   169: aload 6
    //   171: invokevirtual 87	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   174: invokevirtual 91	java/io/FileOutputStream:write	([B)V
    //   177: aload_1
    //   178: invokevirtual 94	java/io/FileOutputStream:flush	()V
    //   181: aload_2
    //   182: astore_0
    //   183: aload_1
    //   184: ifnull +9 -> 193
    //   187: aload_1
    //   188: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   191: aload_2
    //   192: astore_0
    //   193: aload_0
    //   194: areturn
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   200: aload_2
    //   201: astore_0
    //   202: goto -9 -> 193
    //   205: astore_0
    //   206: aconst_null
    //   207: astore_0
    //   208: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +14 -> 225
    //   214: ldc 2
    //   216: invokevirtual 53	java/lang/Class:getName	()Ljava/lang/String;
    //   219: iconst_2
    //   220: ldc 102
    //   222: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: aload_0
    //   226: ifnull +62 -> 288
    //   229: aload_0
    //   230: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   233: aconst_null
    //   234: astore_0
    //   235: goto -42 -> 193
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   243: aconst_null
    //   244: astore_0
    //   245: goto -52 -> 193
    //   248: astore_0
    //   249: aload 5
    //   251: astore_1
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   260: aload_0
    //   261: athrow
    //   262: astore_1
    //   263: aload_1
    //   264: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   267: goto -7 -> 260
    //   270: astore_0
    //   271: goto -19 -> 252
    //   274: astore_2
    //   275: aload_0
    //   276: astore_1
    //   277: aload_2
    //   278: astore_0
    //   279: goto -27 -> 252
    //   282: astore_0
    //   283: aload_1
    //   284: astore_0
    //   285: goto -77 -> 208
    //   288: aconst_null
    //   289: astore_0
    //   290: goto -97 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramBitmap	Bitmap
    //   0	293	1	paramString	String
    //   0	293	2	paramArrayOfInt	int[]
    //   39	80	3	i	int
    //   36	56	4	bool	boolean
    //   1	249	5	localObject	Object
    //   33	137	6	localByteArrayOutputStream	ByteArrayOutputStream
    //   6	70	7	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   187	191	195	java/lang/Exception
    //   152	168	205	java/lang/Exception
    //   229	233	238	java/lang/Exception
    //   152	168	248	finally
    //   256	260	262	java/lang/Exception
    //   168	181	270	finally
    //   208	225	274	finally
    //   168	181	282	java/lang/Exception
  }
  
  public static String a(String paramString)
  {
    System.currentTimeMillis();
    try
    {
      String str1 = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      paramString = str1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        paramString = new File(paramString);
        if (!paramString.exists()) {
          break label56;
        }
        try
        {
          String str2 = bhli.a(paramString);
          paramString = str2;
          if (str2 != null) {
            continue;
          }
          return "";
        }
        catch (IOException paramString)
        {
          return "";
        }
      }
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
    }
    return paramString;
    label56:
    return "";
  }
  
  private static boolean a(Bitmap paramBitmap, ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    try
    {
      paramByteArrayOutputStream.reset();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, paramByteArrayOutputStream);
      return true;
    }
    catch (Exception paramBitmap)
    {
      if (QLog.isColorLevel()) {
        QLog.e(asfs.class.getName(), 2, "doCompress Exception:", paramBitmap);
      }
      paramByteArrayOutputStream.reset();
      return false;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      if (QLog.isColorLevel()) {
        QLog.e(asfs.class.getName(), 2, "doCompress OutOfMemoryError:", paramBitmap);
      }
      paramByteArrayOutputStream.reset();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfs
 * JD-Core Version:    0.7.0.1
 */