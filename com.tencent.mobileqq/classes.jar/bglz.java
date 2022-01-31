import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Environment;
import java.io.File;

public class bglz
{
  public static final String a = Environment.getExternalStorageDirectory() + File.separator;
  public static final String b = a + "Pictures" + File.separator + "QzonePet";
  
  public static Bitmap a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    int i = 0;
    while (i < paramInt2)
    {
      int j = 0;
      while (j < paramInt1)
      {
        arrayOfInt[(i * paramInt1 + j)] = -1;
        j += 1;
      }
      i += 1;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.setPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    return localBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap;
    if (paramBitmap1 == null) {
      localBitmap = null;
    }
    do
    {
      return localBitmap;
      localBitmap = paramBitmap1;
    } while (paramBitmap2 == null);
    int i;
    if (paramInt3 == 0) {
      i = paramBitmap1.getWidth();
    }
    for (paramInt3 = paramBitmap1.getHeight() + paramBitmap2.getHeight();; paramInt3 = Math.max(paramBitmap1.getHeight(), paramBitmap2.getHeight()))
    {
      localBitmap = Bitmap.createBitmap(i, paramInt3, paramBitmap1.getConfig());
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(paramBitmap1, new Matrix(), null);
      localCanvas.drawBitmap(paramBitmap2, paramInt1, paramInt2, null);
      return localBitmap;
      i = Math.max(paramBitmap1.getWidth(), paramBitmap2.getWidth());
    }
  }
  
  /* Error */
  public static String a(String paramString, Bitmap paramBitmap, android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +14 -> 15
    //   4: aload_2
    //   5: ifnull +10 -> 15
    //   8: aload_0
    //   9: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: ldc 108
    //   19: ldc 110
    //   21: invokestatic 116	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: new 26	java/io/File
    //   28: dup
    //   29: getstatic 44	bglz:b	Ljava/lang/String;
    //   32: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 123	java/io/File:exists	()Z
    //   42: ifne +160 -> 202
    //   45: aload 5
    //   47: invokevirtual 126	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: new 26	java/io/File
    //   54: dup
    //   55: new 11	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   62: getstatic 44	bglz:b	Ljava/lang/String;
    //   65: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 29	java/io/File:separator	Ljava/lang/String;
    //   71: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore 7
    //   86: aload 7
    //   88: invokevirtual 123	java/io/File:exists	()Z
    //   91: ifeq +9 -> 100
    //   94: aload 7
    //   96: invokevirtual 129	java/io/File:delete	()Z
    //   99: pop
    //   100: iconst_0
    //   101: istore 4
    //   103: new 131	java/io/FileOutputStream
    //   106: dup
    //   107: aload 7
    //   109: invokespecial 134	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   112: astore 6
    //   114: aload 6
    //   116: astore 5
    //   118: aload_1
    //   119: getstatic 140	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   122: bipush 100
    //   124: aload 6
    //   126: invokevirtual 144	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   129: pop
    //   130: aload 6
    //   132: astore 5
    //   134: aload 6
    //   136: invokevirtual 147	java/io/FileOutputStream:flush	()V
    //   139: aload 6
    //   141: astore 5
    //   143: ldc 108
    //   145: ldc 149
    //   147: invokestatic 152	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   150: pop
    //   151: iload 4
    //   153: istore_3
    //   154: aload 6
    //   156: ifnull +11 -> 167
    //   159: aload 6
    //   161: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   164: iload 4
    //   166: istore_3
    //   167: iload_3
    //   168: ifne -153 -> 15
    //   171: aload_2
    //   172: invokevirtual 161	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   175: aload 7
    //   177: invokevirtual 164	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: aload_0
    //   181: aconst_null
    //   182: invokestatic 170	android/provider/MediaStore$Images$Media:insertImage	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   185: pop
    //   186: aload_2
    //   187: aload 7
    //   189: invokevirtual 164	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   192: invokestatic 176	com/tencent/mobileqq/utils/kapalaiadapter/FileProvider7Helper:savePhotoToSysAlbum	(Landroid/content/Context;Ljava/lang/String;)Landroid/net/Uri;
    //   195: pop
    //   196: aload 7
    //   198: invokevirtual 164	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   201: areturn
    //   202: aload 5
    //   204: invokevirtual 179	java/io/File:isDirectory	()Z
    //   207: ifne -156 -> 51
    //   210: aload 5
    //   212: invokevirtual 129	java/io/File:delete	()Z
    //   215: pop
    //   216: aload 5
    //   218: invokevirtual 126	java/io/File:mkdirs	()Z
    //   221: pop
    //   222: goto -171 -> 51
    //   225: astore_1
    //   226: aload_1
    //   227: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   230: iload 4
    //   232: istore_3
    //   233: goto -66 -> 167
    //   236: astore_1
    //   237: aconst_null
    //   238: astore 6
    //   240: aload 6
    //   242: astore 5
    //   244: aload_1
    //   245: invokevirtual 183	java/io/FileNotFoundException:printStackTrace	()V
    //   248: aload 6
    //   250: ifnull +104 -> 354
    //   253: aload 6
    //   255: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   258: iconst_1
    //   259: istore_3
    //   260: goto -93 -> 167
    //   263: astore_1
    //   264: aload_1
    //   265: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   268: iconst_1
    //   269: istore_3
    //   270: goto -103 -> 167
    //   273: astore_1
    //   274: aconst_null
    //   275: astore 6
    //   277: aload 6
    //   279: astore 5
    //   281: aload_1
    //   282: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   285: aload 6
    //   287: ifnull +67 -> 354
    //   290: aload 6
    //   292: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   295: iconst_1
    //   296: istore_3
    //   297: goto -130 -> 167
    //   300: astore_1
    //   301: aload_1
    //   302: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   305: iconst_1
    //   306: istore_3
    //   307: goto -140 -> 167
    //   310: astore_0
    //   311: aconst_null
    //   312: astore 5
    //   314: aload 5
    //   316: ifnull +8 -> 324
    //   319: aload 5
    //   321: invokevirtual 155	java/io/FileOutputStream:close	()V
    //   324: aload_0
    //   325: athrow
    //   326: astore_1
    //   327: aload_1
    //   328: invokevirtual 182	java/io/IOException:printStackTrace	()V
    //   331: goto -7 -> 324
    //   334: astore_0
    //   335: aload_0
    //   336: invokevirtual 183	java/io/FileNotFoundException:printStackTrace	()V
    //   339: goto -153 -> 186
    //   342: astore_0
    //   343: goto -29 -> 314
    //   346: astore_1
    //   347: goto -70 -> 277
    //   350: astore_1
    //   351: goto -111 -> 240
    //   354: iconst_1
    //   355: istore_3
    //   356: goto -189 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramString	String
    //   0	359	1	paramBitmap	Bitmap
    //   0	359	2	paramContext	android.content.Context
    //   153	203	3	i	int
    //   101	130	4	j	int
    //   35	285	5	localObject	Object
    //   112	179	6	localFileOutputStream	java.io.FileOutputStream
    //   84	113	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   159	164	225	java/io/IOException
    //   103	114	236	java/io/FileNotFoundException
    //   253	258	263	java/io/IOException
    //   103	114	273	java/io/IOException
    //   290	295	300	java/io/IOException
    //   103	114	310	finally
    //   319	324	326	java/io/IOException
    //   171	186	334	java/io/FileNotFoundException
    //   118	130	342	finally
    //   134	139	342	finally
    //   143	151	342	finally
    //   244	248	342	finally
    //   281	285	342	finally
    //   118	130	346	java/io/IOException
    //   134	139	346	java/io/IOException
    //   143	151	346	java/io/IOException
    //   118	130	350	java/io/FileNotFoundException
    //   134	139	350	java/io/FileNotFoundException
    //   143	151	350	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bglz
 * JD-Core Version:    0.7.0.1
 */