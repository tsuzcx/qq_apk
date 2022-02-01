import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class bexi
  extends beqz
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      localBitmap.setDensity(160);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF = new RectF(new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()));
      float f = paramInt;
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-16777216);
      localCanvas.drawRoundRect(localRectF, f, f, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), localRect, localPaint);
      return localBitmap;
    }
    catch (Exception localException) {}
    return paramBitmap;
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(paramDownloadParams.url.getFile());
  }
  
  public boolean a()
  {
    return false;
  }
  
  /* Error */
  public java.lang.Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: invokestatic 120	bhmi:b	(Ljava/lang/String;)Z
    //   9: ifne +21 -> 30
    //   12: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +11 -> 26
    //   18: ldc 127
    //   20: iconst_2
    //   21: ldc 129
    //   23: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aconst_null
    //   27: astore_2
    //   28: aload_2
    //   29: areturn
    //   30: new 135	android/graphics/BitmapFactory$Options
    //   33: dup
    //   34: invokespecial 136	android/graphics/BitmapFactory$Options:<init>	()V
    //   37: astore_1
    //   38: aload_1
    //   39: sipush 160
    //   42: putfield 140	android/graphics/BitmapFactory$Options:inDensity	I
    //   45: aload_1
    //   46: sipush 160
    //   49: putfield 143	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   52: aload_1
    //   53: sipush 160
    //   56: putfield 146	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   59: aload_1
    //   60: iconst_1
    //   61: putfield 150	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   64: aload_3
    //   65: aload_1
    //   66: invokestatic 155	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   69: pop
    //   70: aload_1
    //   71: iconst_0
    //   72: putfield 150	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   75: aload_1
    //   76: aload_0
    //   77: aload_1
    //   78: aload_2
    //   79: getfield 158	com/tencent/image/DownloadParams:reqWidth	I
    //   82: aload_2
    //   83: getfield 161	com/tencent/image/DownloadParams:reqHeight	I
    //   86: invokevirtual 164	bexi:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   89: putfield 167	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   92: new 169	java/io/BufferedInputStream
    //   95: dup
    //   96: new 171	java/io/FileInputStream
    //   99: dup
    //   100: aload_3
    //   101: invokespecial 172	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   104: invokespecial 175	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   107: astore_3
    //   108: aload_3
    //   109: aconst_null
    //   110: aload_1
    //   111: invokestatic 181	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   114: astore_1
    //   115: aload_2
    //   116: getfield 185	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   119: astore_2
    //   120: aload_2
    //   121: instanceof 187
    //   124: ifeq +102 -> 226
    //   127: aload_2
    //   128: checkcast 187	[I
    //   131: checkcast 187	[I
    //   134: arraylength
    //   135: iconst_3
    //   136: if_icmpne +90 -> 226
    //   139: aload_1
    //   140: aload_2
    //   141: checkcast 187	[I
    //   144: checkcast 187	[I
    //   147: iconst_2
    //   148: iaload
    //   149: invokestatic 189	bexi:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   152: astore_1
    //   153: aload_1
    //   154: astore_2
    //   155: aload_3
    //   156: ifnull -128 -> 28
    //   159: aload_3
    //   160: invokevirtual 192	java/io/BufferedInputStream:close	()V
    //   163: aload_1
    //   164: areturn
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_1
    //   168: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +12 -> 183
    //   174: ldc 127
    //   176: iconst_2
    //   177: ldc 194
    //   179: aload_2
    //   180: invokestatic 198	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 192	java/io/BufferedInputStream:close	()V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_1
    //   194: aconst_null
    //   195: astore_2
    //   196: aload_2
    //   197: ifnull +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 192	java/io/BufferedInputStream:close	()V
    //   204: aload_1
    //   205: athrow
    //   206: astore_1
    //   207: aload_3
    //   208: astore_2
    //   209: goto -13 -> 196
    //   212: astore_3
    //   213: aload_1
    //   214: astore_2
    //   215: aload_3
    //   216: astore_1
    //   217: goto -21 -> 196
    //   220: astore_2
    //   221: aload_3
    //   222: astore_1
    //   223: goto -55 -> 168
    //   226: goto -73 -> 153
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	bexi
    //   0	229	1	paramFile	File
    //   0	229	2	paramDownloadParams	DownloadParams
    //   0	229	3	paramURLDrawableHandler	URLDrawableHandler
    // Exception table:
    //   from	to	target	type
    //   92	108	165	java/lang/OutOfMemoryError
    //   92	108	193	finally
    //   108	153	206	finally
    //   168	183	212	finally
    //   108	153	220	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexi
 * JD-Core Version:    0.7.0.1
 */