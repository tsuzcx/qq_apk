package com.tencent.aelight.camera.aebase;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PointF;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;

public class Util
{
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    localObject2 = null;
    localObject1 = null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject1 = localBitmap;
      localObject2 = localBitmap;
      localBitmap.setPremultiplied(paramBoolean);
      localObject1 = localBitmap;
      localObject2 = localBitmap;
      paramString = a(new File(paramString));
      localObject1 = localBitmap;
      localObject2 = localBitmap;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localBitmap.getWidth() * localBitmap.getHeight() * 4);
      if (paramString != null)
      {
        localObject1 = localBitmap;
        localObject2 = localBitmap;
        localByteBuffer.put(paramString);
      }
      localObject1 = localBitmap;
      localObject2 = localBitmap;
      localByteBuffer.position(0);
      localObject1 = localBitmap;
      localObject2 = localBitmap;
      localBitmap.copyPixelsFromBuffer(localByteBuffer);
      return localBitmap;
    }
    catch (Exception paramString)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("readRawBytesToBitmap exception, msg = ");
      ((StringBuilder)localObject2).append(paramString.getMessage());
      QLog.d("Util", 4, ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    catch (OutOfMemoryError paramString)
    {
      label128:
      break label128;
    }
    QLog.d("Util", 4, "readRawBytesToBitmap OOM");
    return localObject2;
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
    catch (OutOfMemoryError paramString1)
    {
      paramString1.printStackTrace();
      paramString2 = new StringBuilder();
      paramString2.append("saveBitmapRawBytesToFile error, msg = ");
      paramString2.append(paramString1.getMessage());
      QLog.d("Util", 4, paramString2.toString());
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramString2 = new StringBuilder();
      paramString2.append("saveBitmapRawBytesToFile exception, msg = ");
      paramString2.append(paramString1.getMessage());
      QLog.d("Util", 4, paramString2.toString());
    }
  }
  
  /* Error */
  public static void a(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: aload 6
    //   13: astore_2
    //   14: aload_1
    //   15: invokevirtual 43	android/graphics/Bitmap:getWidth	()I
    //   18: aload_1
    //   19: invokevirtual 46	android/graphics/Bitmap:getHeight	()I
    //   22: imul
    //   23: iconst_4
    //   24: imul
    //   25: invokestatic 52	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   28: astore 7
    //   30: aload 6
    //   32: astore_2
    //   33: aload_1
    //   34: aload 7
    //   36: invokevirtual 127	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   39: aload 6
    //   41: astore_2
    //   42: new 33	java/io/File
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_0
    //   51: aload 6
    //   53: astore_2
    //   54: aload_0
    //   55: invokevirtual 131	java/io/File:exists	()Z
    //   58: ifne +11 -> 69
    //   61: aload 6
    //   63: astore_2
    //   64: aload_0
    //   65: invokevirtual 134	java/io/File:createNewFile	()Z
    //   68: pop
    //   69: aload 6
    //   71: astore_2
    //   72: new 136	java/io/FileOutputStream
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 139	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: astore_0
    //   81: aload_0
    //   82: aload 7
    //   84: invokevirtual 143	java/nio/ByteBuffer:array	()[B
    //   87: invokevirtual 147	java/io/FileOutputStream:write	([B)V
    //   90: aload_0
    //   91: invokevirtual 150	java/io/FileOutputStream:flush	()V
    //   94: aload_0
    //   95: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   98: return
    //   99: astore_1
    //   100: aload_0
    //   101: astore_2
    //   102: goto +165 -> 267
    //   105: astore_1
    //   106: goto +18 -> 124
    //   109: astore_1
    //   110: goto +75 -> 185
    //   113: astore_1
    //   114: goto +132 -> 246
    //   117: astore_1
    //   118: goto +149 -> 267
    //   121: astore_1
    //   122: aload_3
    //   123: astore_0
    //   124: aload_0
    //   125: astore_2
    //   126: aload_1
    //   127: invokevirtual 115	java/lang/OutOfMemoryError:printStackTrace	()V
    //   130: aload_0
    //   131: astore_2
    //   132: new 76	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   139: astore_3
    //   140: aload_0
    //   141: astore_2
    //   142: aload_3
    //   143: ldc 117
    //   145: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_0
    //   150: astore_2
    //   151: aload_3
    //   152: aload_1
    //   153: invokevirtual 118	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   156: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_0
    //   161: astore_2
    //   162: ldc 66
    //   164: iconst_4
    //   165: aload_3
    //   166: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: ifnull +93 -> 266
    //   176: aload_0
    //   177: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   180: return
    //   181: astore_1
    //   182: aload 4
    //   184: astore_0
    //   185: aload_0
    //   186: astore_2
    //   187: aload_1
    //   188: invokevirtual 119	java/lang/Exception:printStackTrace	()V
    //   191: aload_0
    //   192: astore_2
    //   193: new 76	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   200: astore_3
    //   201: aload_0
    //   202: astore_2
    //   203: aload_3
    //   204: ldc 121
    //   206: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_0
    //   211: astore_2
    //   212: aload_3
    //   213: aload_1
    //   214: invokevirtual 87	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload_0
    //   222: astore_2
    //   223: ldc 66
    //   225: iconst_4
    //   226: aload_3
    //   227: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: aload_0
    //   234: ifnull +32 -> 266
    //   237: aload_0
    //   238: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   241: return
    //   242: astore_1
    //   243: aload 5
    //   245: astore_0
    //   246: aload_0
    //   247: astore_2
    //   248: aload_1
    //   249: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   252: aload_0
    //   253: ifnull +13 -> 266
    //   256: aload_0
    //   257: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   260: return
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   266: return
    //   267: aload_2
    //   268: ifnull +15 -> 283
    //   271: aload_2
    //   272: invokevirtual 153	java/io/FileOutputStream:close	()V
    //   275: goto +8 -> 283
    //   278: astore_0
    //   279: aload_0
    //   280: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   283: aload_1
    //   284: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramString	String
    //   0	285	1	paramBitmap	Bitmap
    //   13	259	2	localObject1	Object
    //   1	226	3	localStringBuilder	StringBuilder
    //   3	180	4	localObject2	Object
    //   6	238	5	localObject3	Object
    //   9	61	6	localObject4	Object
    //   28	55	7	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   81	94	99	finally
    //   81	94	105	java/lang/OutOfMemoryError
    //   81	94	109	java/lang/Exception
    //   81	94	113	java/io/IOException
    //   14	30	117	finally
    //   33	39	117	finally
    //   42	51	117	finally
    //   54	61	117	finally
    //   64	69	117	finally
    //   72	81	117	finally
    //   126	130	117	finally
    //   132	140	117	finally
    //   142	149	117	finally
    //   151	160	117	finally
    //   162	172	117	finally
    //   187	191	117	finally
    //   193	201	117	finally
    //   203	210	117	finally
    //   212	221	117	finally
    //   223	233	117	finally
    //   248	252	117	finally
    //   14	30	121	java/lang/OutOfMemoryError
    //   33	39	121	java/lang/OutOfMemoryError
    //   42	51	121	java/lang/OutOfMemoryError
    //   54	61	121	java/lang/OutOfMemoryError
    //   64	69	121	java/lang/OutOfMemoryError
    //   72	81	121	java/lang/OutOfMemoryError
    //   14	30	181	java/lang/Exception
    //   33	39	181	java/lang/Exception
    //   42	51	181	java/lang/Exception
    //   54	61	181	java/lang/Exception
    //   64	69	181	java/lang/Exception
    //   72	81	181	java/lang/Exception
    //   14	30	242	java/io/IOException
    //   33	39	242	java/io/IOException
    //   42	51	242	java/io/IOException
    //   54	61	242	java/io/IOException
    //   64	69	242	java/io/IOException
    //   72	81	242	java/io/IOException
    //   94	98	261	java/io/IOException
    //   176	180	261	java/io/IOException
    //   237	241	261	java/io/IOException
    //   256	260	261	java/io/IOException
    //   271	275	278	java/io/IOException
  }
  
  public static boolean a(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    PointF localPointF2 = new PointF(((PointF)paramList.get(53)).x - ((PointF)paramList.get(43)).x, ((PointF)paramList.get(53)).y - ((PointF)paramList.get(43)).y);
    PointF localPointF1 = new PointF((((PointF)paramList.get(53)).x + ((PointF)paramList.get(43)).x) * 0.5F, (((PointF)paramList.get(53)).y + ((PointF)paramList.get(43)).y) * 0.5F);
    if ((localPointF2.x < 0.01D) && (localPointF2.y < 0.01D)) {
      return false;
    }
    int i = 0;
    float f3 = 99999.0F;
    float f1 = 0.0F;
    float f6 = 99999.0F;
    for (float f4 = 0.0F; i < 83; f4 = f5)
    {
      localPointF3 = a(localPointF2, localPointF1, new PointF(((PointF)paramList.get(i)).x, ((PointF)paramList.get(i)).y));
      f2 = f6;
      if (localPointF3.y < f6) {
        f2 = localPointF3.y;
      }
      f5 = f4;
      if (localPointF3.y > f4) {
        f5 = localPointF3.y;
      }
      f4 = f3;
      if (localPointF3.x < f3) {
        f4 = localPointF3.x;
      }
      f6 = f1;
      if (localPointF3.x > f1) {
        f6 = localPointF3.x;
      }
      i += 1;
      f3 = f4;
      f1 = f6;
      f6 = f2;
    }
    paramList = b(localPointF2, localPointF1, new PointF((f3 + f1) * 0.5F, (f6 + f4) * 0.5F));
    f1 = Math.max(f1 - f3, f4 - f6) * 0.5F;
    PointF localPointF3 = b(localPointF2, localPointF1, new PointF(f1, 0.0F));
    localPointF3 = new PointF(localPointF3.x - localPointF1.x, localPointF3.y - localPointF1.y);
    localPointF2 = b(localPointF2, localPointF1, new PointF(0.0F, f1));
    localPointF1 = new PointF(localPointF2.x - localPointF1.x, localPointF2.y - localPointF1.y);
    paramList = new PointF(paramList.x, paramList.y);
    localPointF2 = new PointF(localPointF3.x, localPointF3.y);
    localPointF1 = new PointF(localPointF1.x, localPointF1.y);
    float f2 = paramList.x;
    f3 = localPointF2.x;
    f4 = localPointF1.x;
    f1 = paramInt1;
    paramArrayOfFloat[0] = ((f2 - f3 + f4) / f1);
    f2 = paramList.y;
    f3 = localPointF2.y;
    f4 = localPointF1.y;
    float f5 = paramInt2;
    paramArrayOfFloat[1] = (1.0F - (f2 - f3 + f4) / f5);
    paramArrayOfFloat[2] = ((paramList.x - localPointF2.x - localPointF1.x) / f1);
    paramArrayOfFloat[3] = (1.0F - (paramList.y - localPointF2.y - localPointF1.y) / f5);
    paramArrayOfFloat[4] = ((paramList.x + localPointF2.x - localPointF1.x) / f1);
    paramArrayOfFloat[5] = (1.0F - (paramList.y + localPointF2.y - localPointF1.y) / f5);
    paramArrayOfFloat[6] = ((paramList.x + localPointF2.x + localPointF1.x) / f1);
    paramArrayOfFloat[7] = (1.0F - (paramList.y + localPointF2.y + localPointF1.y) / f5);
    return true;
  }
  
  /* Error */
  private static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 181	java/io/File:isFile	()Z
    //   4: ifeq +133 -> 137
    //   7: new 183	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 184	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: astore_2
    //   16: aload_2
    //   17: astore_0
    //   18: sipush 1024
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_2
    //   25: astore_0
    //   26: new 186	java/io/ByteArrayOutputStream
    //   29: dup
    //   30: invokespecial 187	java/io/ByteArrayOutputStream:<init>	()V
    //   33: astore 4
    //   35: aload_2
    //   36: astore_0
    //   37: aload_2
    //   38: aload_3
    //   39: invokevirtual 191	java/io/FileInputStream:read	([B)I
    //   42: istore_1
    //   43: iload_1
    //   44: iconst_m1
    //   45: if_icmpeq +16 -> 61
    //   48: aload_2
    //   49: astore_0
    //   50: aload 4
    //   52: aload_3
    //   53: iconst_0
    //   54: iload_1
    //   55: invokevirtual 194	java/io/ByteArrayOutputStream:write	([BII)V
    //   58: goto -23 -> 35
    //   61: aload_2
    //   62: astore_0
    //   63: aload 4
    //   65: invokevirtual 197	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   68: astore_3
    //   69: aload_2
    //   70: invokevirtual 198	java/io/FileInputStream:close	()V
    //   73: aload_3
    //   74: areturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   80: aload_3
    //   81: areturn
    //   82: astore_3
    //   83: goto +12 -> 95
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_0
    //   89: goto +30 -> 119
    //   92: astore_3
    //   93: aconst_null
    //   94: astore_2
    //   95: aload_2
    //   96: astore_0
    //   97: aload_3
    //   98: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   101: aload_2
    //   102: ifnull +69 -> 171
    //   105: aload_2
    //   106: invokevirtual 198	java/io/FileInputStream:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_2
    //   119: aload_0
    //   120: ifnull +15 -> 135
    //   123: aload_0
    //   124: invokevirtual 198	java/io/FileInputStream:close	()V
    //   127: goto +8 -> 135
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   135: aload_2
    //   136: athrow
    //   137: new 76	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   144: astore_2
    //   145: aload_2
    //   146: ldc 200
    //   148: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_2
    //   153: aload_0
    //   154: invokevirtual 203	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   157: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: ldc 66
    //   163: iconst_4
    //   164: aload_2
    //   165: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aconst_null
    //   172: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramFile	File
    //   42	13	1	i	int
    //   15	55	2	localFileInputStream	java.io.FileInputStream
    //   86	1	2	localObject1	Object
    //   94	12	2	localObject2	Object
    //   118	18	2	localObject3	Object
    //   144	21	2	localStringBuilder	StringBuilder
    //   23	58	3	arrayOfByte	byte[]
    //   82	1	3	localIOException1	java.io.IOException
    //   92	6	3	localIOException2	java.io.IOException
    //   33	31	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   69	73	75	java/io/IOException
    //   18	24	82	java/io/IOException
    //   26	35	82	java/io/IOException
    //   37	43	82	java/io/IOException
    //   50	58	82	java/io/IOException
    //   63	69	82	java/io/IOException
    //   7	16	86	finally
    //   7	16	92	java/io/IOException
    //   105	109	111	java/io/IOException
    //   18	24	118	finally
    //   26	35	118	finally
    //   37	43	118	finally
    //   50	58	118	finally
    //   63	69	118	finally
    //   97	101	118	finally
    //   123	127	130	java/io/IOException
  }
  
  private static PointF b(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    return new PointF(paramPointF2.x + paramPointF3.x * paramPointF1.x - paramPointF3.y * paramPointF1.y, paramPointF2.y + paramPointF3.x * paramPointF1.y + paramPointF3.y * paramPointF1.x);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.Util
 * JD-Core Version:    0.7.0.1
 */