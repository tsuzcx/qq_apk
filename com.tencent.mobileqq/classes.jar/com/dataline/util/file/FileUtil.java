package com.dataline.util.file;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileSizeFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil
{
  public static String a(long paramLong)
  {
    return FileSizeFormat.a(paramLong);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    Bitmap localBitmap;
    if (FileManagerUtil.a(paramString) == 0) {
      localBitmap = MediaStoreUtil.a(paramString, 150, 150);
    }
    for (;;)
    {
      if (localBitmap == null)
      {
        return null;
        if (FileManagerUtil.a(paramString) == 2) {
          localBitmap = MediaStoreUtil.c(paramString, 150, 150);
        }
      }
      else
      {
        try
        {
          paramContext = b(paramContext, paramString);
          localBitmap = null;
        }
        catch (FileNotFoundException paramString)
        {
          for (;;)
          {
            try
            {
              com.tencent.mobileqq.filemanager.util.FileUtil.a(localBitmap, paramContext);
              localBitmap.recycle();
              MediaStoreUtil.a(paramContext, MediaStoreUtil.a(paramString));
              return paramContext;
            }
            catch (IOException paramString)
            {
              continue;
            }
            catch (FileNotFoundException paramString)
            {
              continue;
            }
            paramString = paramString;
            paramContext = null;
            paramString.printStackTrace();
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            paramContext = null;
            paramString.printStackTrace();
          }
        }
        catch (OutOfMemoryError paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            paramContext = null;
          }
        }
      }
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new File(Utils.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath() + File.separator + FileManagerUtil.a(paramString1) + "." + paramString2 + ".JPG";
  }
  
  public static void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    paramFile.delete();
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore_2
    //   8: aload_0
    //   9: invokevirtual 119	java/io/File:isFile	()Z
    //   12: ifeq +138 -> 150
    //   15: aload_1
    //   16: invokevirtual 85	java/io/File:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_1
    //   23: invokevirtual 115	java/io/File:delete	()Z
    //   26: pop
    //   27: new 121	java/io/FileOutputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 123	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: astore 4
    //   37: new 125	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 126	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore 5
    //   47: ldc 127
    //   49: newarray byte
    //   51: astore 6
    //   53: aload 5
    //   55: aload 6
    //   57: invokevirtual 131	java/io/FileInputStream:read	([B)I
    //   60: istore_3
    //   61: iload_3
    //   62: iconst_m1
    //   63: if_icmpeq +67 -> 130
    //   66: aload 4
    //   68: aload 6
    //   70: iconst_0
    //   71: iload_3
    //   72: invokevirtual 135	java/io/FileOutputStream:write	([BII)V
    //   75: aload 4
    //   77: invokevirtual 138	java/io/FileOutputStream:flush	()V
    //   80: goto -27 -> 53
    //   83: astore 6
    //   85: aload 5
    //   87: astore_1
    //   88: aload 4
    //   90: astore_0
    //   91: aload 6
    //   93: astore 4
    //   95: aload 4
    //   97: invokevirtual 56	java/io/IOException:printStackTrace	()V
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 142	java/io/FileInputStream:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore 6
    //   120: sipush 4096
    //   123: newarray byte
    //   125: astore 6
    //   127: goto -74 -> 53
    //   130: aload 4
    //   132: ifnull +8 -> 140
    //   135: aload 4
    //   137: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   140: aload 5
    //   142: ifnull +8 -> 150
    //   145: aload 5
    //   147: invokevirtual 142	java/io/FileInputStream:close	()V
    //   150: aload_0
    //   151: invokevirtual 106	java/io/File:isDirectory	()Z
    //   154: ifeq +102 -> 256
    //   157: aload_0
    //   158: invokevirtual 110	java/io/File:listFiles	()[Ljava/io/File;
    //   161: astore_0
    //   162: aload_1
    //   163: invokevirtual 145	java/io/File:mkdir	()Z
    //   166: pop
    //   167: iload_2
    //   168: aload_0
    //   169: arraylength
    //   170: if_icmpge +86 -> 256
    //   173: aload_0
    //   174: iload_2
    //   175: aaload
    //   176: invokevirtual 149	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   179: new 60	java/io/File
    //   182: dup
    //   183: new 62	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   190: aload_1
    //   191: invokevirtual 149	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   194: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   197: getstatic 95	java/io/File:separator	Ljava/lang/String;
    //   200: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_0
    //   204: iload_2
    //   205: aaload
    //   206: invokevirtual 155	java/io/File:getName	()Ljava/lang/String;
    //   209: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   218: invokestatic 157	com/dataline/util/file/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   221: pop
    //   222: iload_2
    //   223: iconst_1
    //   224: iadd
    //   225: istore_2
    //   226: goto -59 -> 167
    //   229: astore_0
    //   230: aconst_null
    //   231: astore 4
    //   233: aload 7
    //   235: astore_1
    //   236: aload 4
    //   238: ifnull +8 -> 246
    //   241: aload 4
    //   243: invokevirtual 141	java/io/FileOutputStream:close	()V
    //   246: aload_1
    //   247: ifnull +7 -> 254
    //   250: aload_1
    //   251: invokevirtual 142	java/io/FileInputStream:close	()V
    //   254: aload_0
    //   255: athrow
    //   256: iconst_1
    //   257: ireturn
    //   258: astore 4
    //   260: goto -120 -> 140
    //   263: astore 4
    //   265: goto -115 -> 150
    //   268: astore_0
    //   269: goto -161 -> 108
    //   272: astore_0
    //   273: iconst_0
    //   274: ireturn
    //   275: astore 4
    //   277: goto -31 -> 246
    //   280: astore_1
    //   281: goto -27 -> 254
    //   284: astore_0
    //   285: aload 7
    //   287: astore_1
    //   288: goto -52 -> 236
    //   291: astore_0
    //   292: aload 5
    //   294: astore_1
    //   295: goto -59 -> 236
    //   298: astore 5
    //   300: aload_0
    //   301: astore 4
    //   303: aload 5
    //   305: astore_0
    //   306: goto -70 -> 236
    //   309: astore 4
    //   311: aconst_null
    //   312: astore_0
    //   313: aload 6
    //   315: astore_1
    //   316: goto -221 -> 95
    //   319: astore_1
    //   320: aload 4
    //   322: astore_0
    //   323: aload_1
    //   324: astore 4
    //   326: aload 6
    //   328: astore_1
    //   329: goto -234 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramFile1	File
    //   0	332	1	paramFile2	File
    //   7	219	2	i	int
    //   60	12	3	j	int
    //   35	207	4	localObject1	Object
    //   258	1	4	localIOException1	IOException
    //   263	1	4	localIOException2	IOException
    //   275	1	4	localIOException3	IOException
    //   301	1	4	localFile1	File
    //   309	12	4	localIOException4	IOException
    //   324	1	4	localFile2	File
    //   45	248	5	localFileInputStream	java.io.FileInputStream
    //   298	6	5	localObject2	Object
    //   4	65	6	arrayOfByte1	byte[]
    //   83	9	6	localIOException5	IOException
    //   118	1	6	localOutOfMemoryError	OutOfMemoryError
    //   125	202	6	arrayOfByte2	byte[]
    //   1	285	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	53	83	java/io/IOException
    //   53	61	83	java/io/IOException
    //   66	80	83	java/io/IOException
    //   120	127	83	java/io/IOException
    //   47	53	118	java/lang/OutOfMemoryError
    //   15	27	229	finally
    //   27	37	229	finally
    //   135	140	258	java/io/IOException
    //   145	150	263	java/io/IOException
    //   104	108	268	java/io/IOException
    //   112	116	272	java/io/IOException
    //   241	246	275	java/io/IOException
    //   250	254	280	java/io/IOException
    //   37	47	284	finally
    //   47	53	291	finally
    //   53	61	291	finally
    //   66	80	291	finally
    //   120	127	291	finally
    //   95	100	298	finally
    //   15	27	309	java/io/IOException
    //   27	37	309	java/io/IOException
    //   37	47	319	java/io/IOException
  }
  
  public static String b(Context paramContext, String paramString)
  {
    paramContext = new File(Utils.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath() + File.separator + FileManagerUtil.a(paramString) + ".JPG";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.dataline.util.file.FileUtil
 * JD-Core Version:    0.7.0.1
 */