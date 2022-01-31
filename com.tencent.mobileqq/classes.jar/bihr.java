import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

public class bihr
{
  /* Error */
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_1
    //   1: iload_2
    //   2: getstatic 16	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   5: invokestatic 22	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   8: astore 4
    //   10: aload 4
    //   12: iload_3
    //   13: invokevirtual 26	android/graphics/Bitmap:setPremultiplied	(Z)V
    //   16: new 28	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokestatic 35	bihr:a	(Ljava/io/File;)[B
    //   27: astore_0
    //   28: aload 4
    //   30: invokevirtual 39	android/graphics/Bitmap:getWidth	()I
    //   33: aload 4
    //   35: invokevirtual 42	android/graphics/Bitmap:getHeight	()I
    //   38: imul
    //   39: iconst_4
    //   40: imul
    //   41: invokestatic 48	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   44: astore 5
    //   46: aload 5
    //   48: aload_0
    //   49: invokevirtual 52	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   52: pop
    //   53: aload 5
    //   55: iconst_0
    //   56: invokevirtual 56	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   59: pop
    //   60: aload 4
    //   62: aload 5
    //   64: invokevirtual 60	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   67: aload 4
    //   69: areturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore 4
    //   74: ldc 62
    //   76: iconst_4
    //   77: new 64	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   84: ldc 69
    //   86: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   93: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: aload 4
    //   104: areturn
    //   105: astore_0
    //   106: aconst_null
    //   107: astore 4
    //   109: ldc 62
    //   111: iconst_4
    //   112: ldc 88
    //   114: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload 4
    //   119: areturn
    //   120: astore_0
    //   121: goto -12 -> 109
    //   124: astore_0
    //   125: goto -51 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   0	128	1	paramInt1	int
    //   0	128	2	paramInt2	int
    //   0	128	3	paramBoolean	boolean
    //   8	110	4	localBitmap	Bitmap
    //   44	19	5	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   0	10	70	java/lang/Exception
    //   0	10	105	java/lang/OutOfMemoryError
    //   10	67	120	java/lang/OutOfMemoryError
    //   10	67	124	java/lang/Exception
  }
  
  private static PointF a(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    return new PointF((paramPointF1.x * paramPointF3.x + paramPointF1.y * paramPointF3.y - paramPointF1.x * paramPointF2.x - paramPointF1.y * paramPointF2.y) / (paramPointF1.x * paramPointF1.x + paramPointF1.y * paramPointF1.y), (paramPointF1.x * paramPointF3.y - paramPointF1.y * paramPointF3.x - paramPointF1.x * paramPointF2.y + paramPointF1.y * paramPointF2.x) / (paramPointF1.x * paramPointF1.x + paramPointF1.y * paramPointF1.y));
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      BitmapUtils.saveBitmap2PNG(a(paramString1, paramInt1, paramInt2, false), paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      QLog.d("Util", 4, "saveBitmapRawBytesToFile exception, msg = " + paramString1.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      paramString1.printStackTrace();
      QLog.d("Util", 4, "saveBitmapRawBytesToFile error, msg = " + paramString1.getMessage());
    }
  }
  
  public static void a(String paramString, Bitmap paramBitmap)
  {
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(paramBitmap.getWidth() * paramBitmap.getHeight() * 4);
      paramBitmap.copyPixelsToBuffer(localByteBuffer);
      paramString = new File(paramString);
      if (!paramString.exists()) {
        paramString.createNewFile();
      }
      paramString = new FileOutputStream(paramString);
      paramString.write(localByteBuffer.array());
      paramString.flush();
      paramString.close();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      QLog.d("Util", 4, "saveBitmapRawBytesToFile exception, msg = " + paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      QLog.d("Util", 4, "saveBitmapRawBytesToFile error, msg = " + paramString.getMessage());
    }
  }
  
  public static boolean a(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    PointF localPointF2 = new PointF(((PointF)paramList.get(53)).x - ((PointF)paramList.get(43)).x, ((PointF)paramList.get(53)).y - ((PointF)paramList.get(43)).y);
    float f1 = ((PointF)paramList.get(53)).x;
    float f2 = ((PointF)paramList.get(43)).x;
    float f3 = ((PointF)paramList.get(53)).y;
    PointF localPointF1 = new PointF(0.5F * (f2 + f1), (((PointF)paramList.get(43)).y + f3) * 0.5F);
    if ((localPointF2.x < 0.01D) && (localPointF2.y < 0.01D)) {
      return false;
    }
    f2 = 99999.0F;
    float f4 = 0.0F;
    f3 = 99999.0F;
    f1 = 0.0F;
    int i = 0;
    PointF localPointF3;
    if (i < 83)
    {
      localPointF3 = a(localPointF2, localPointF1, new PointF(((PointF)paramList.get(i)).x, ((PointF)paramList.get(i)).y));
      if (localPointF3.y >= f2) {
        break label736;
      }
      f2 = localPointF3.y;
    }
    label736:
    for (;;)
    {
      if (localPointF3.y > f4) {
        f4 = localPointF3.y;
      }
      for (;;)
      {
        if (localPointF3.x < f3) {
          f3 = localPointF3.x;
        }
        for (;;)
        {
          if (localPointF3.x > f1) {
            f1 = localPointF3.x;
          }
          for (;;)
          {
            i += 1;
            break;
            paramList = b(localPointF2, localPointF1, new PointF((f3 + f1) * 0.5F, (f2 + f4) * 0.5F));
            f1 = Math.max(f1 - f3, f4 - f2);
            localPointF3 = b(localPointF2, localPointF1, new PointF(0.5F * f1, 0.0F));
            localPointF3 = new PointF(localPointF3.x - localPointF1.x, localPointF3.y - localPointF1.y);
            localPointF2 = b(localPointF2, localPointF1, new PointF(0.0F, f1 * 0.5F));
            localPointF1 = new PointF(localPointF2.x - localPointF1.x, localPointF2.y - localPointF1.y);
            paramList = new PointF(paramList.x, paramList.y);
            localPointF2 = new PointF(localPointF3.x, localPointF3.y);
            localPointF1 = new PointF(localPointF1.x, localPointF1.y);
            paramArrayOfFloat[0] = ((paramList.x - localPointF2.x + localPointF1.x) / paramInt1);
            paramArrayOfFloat[1] = (1.0F - (paramList.y - localPointF2.y + localPointF1.y) / paramInt2);
            paramArrayOfFloat[2] = ((paramList.x - localPointF2.x - localPointF1.x) / paramInt1);
            paramArrayOfFloat[3] = (1.0F - (paramList.y - localPointF2.y - localPointF1.y) / paramInt2);
            paramArrayOfFloat[4] = ((paramList.x + localPointF2.x - localPointF1.x) / paramInt1);
            paramArrayOfFloat[5] = (1.0F - (paramList.y + localPointF2.y - localPointF1.y) / paramInt2);
            paramArrayOfFloat[6] = ((paramList.x + localPointF2.x + localPointF1.x) / paramInt1);
            f1 = paramList.y;
            paramArrayOfFloat[7] = (1.0F - (localPointF2.y + f1 + localPointF1.y) / paramInt2);
            return true;
          }
        }
      }
    }
  }
  
  private static byte[] a(File paramFile)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramFile.isFile()) {
      try
      {
        paramFile = new FileInputStream(paramFile);
        byte[] arrayOfByte = new byte[1024];
        localByteArrayOutputStream = new ByteArrayOutputStream();
        for (;;)
        {
          int i = paramFile.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        return null;
      }
      catch (IOException paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    for (;;)
    {
      paramFile = localByteArrayOutputStream.toByteArray();
      return paramFile;
      QLog.d("Util", 4, "file not found, path = " + paramFile.getAbsolutePath());
    }
  }
  
  private static PointF b(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    return new PointF(paramPointF2.x + paramPointF3.x * paramPointF1.x - paramPointF3.y * paramPointF1.y, paramPointF2.y + paramPointF3.x * paramPointF1.y + paramPointF3.y * paramPointF1.x);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bihr
 * JD-Core Version:    0.7.0.1
 */