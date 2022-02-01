import android.graphics.PointF;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.List;

public class bmve
{
  /* Error */
  public static android.graphics.Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
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
    //   24: invokestatic 35	bmve:a	(Ljava/io/File;)[B
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
    //   46: aload_0
    //   47: ifnull +10 -> 57
    //   50: aload 5
    //   52: aload_0
    //   53: invokevirtual 52	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   56: pop
    //   57: aload 5
    //   59: iconst_0
    //   60: invokevirtual 56	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   63: pop
    //   64: aload 4
    //   66: aload 5
    //   68: invokevirtual 60	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   71: aload 4
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: astore 4
    //   78: ldc 62
    //   80: iconst_4
    //   81: new 64	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   88: ldc 69
    //   90: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload 4
    //   108: areturn
    //   109: astore_0
    //   110: aconst_null
    //   111: astore 4
    //   113: ldc 62
    //   115: iconst_4
    //   116: ldc 88
    //   118: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: aload 4
    //   123: areturn
    //   124: astore_0
    //   125: goto -12 -> 113
    //   128: astore_0
    //   129: goto -51 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramString	String
    //   0	132	1	paramInt1	int
    //   0	132	2	paramInt2	int
    //   0	132	3	paramBoolean	boolean
    //   8	114	4	localBitmap	android.graphics.Bitmap
    //   44	23	5	localByteBuffer	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   0	10	74	java/lang/Exception
    //   0	10	109	java/lang/OutOfMemoryError
    //   10	46	124	java/lang/OutOfMemoryError
    //   50	57	124	java/lang/OutOfMemoryError
    //   57	71	124	java/lang/OutOfMemoryError
    //   10	46	128	java/lang/Exception
    //   50	57	128	java/lang/Exception
    //   57	71	128	java/lang/Exception
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
  
  /* Error */
  public static void a(String paramString, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_3
    //   11: aload 6
    //   13: astore_2
    //   14: aload_1
    //   15: invokevirtual 39	android/graphics/Bitmap:getWidth	()I
    //   18: aload_1
    //   19: invokevirtual 42	android/graphics/Bitmap:getHeight	()I
    //   22: imul
    //   23: iconst_4
    //   24: imul
    //   25: invokestatic 48	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   28: astore 7
    //   30: aload 6
    //   32: astore_2
    //   33: aload_1
    //   34: aload 7
    //   36: invokevirtual 126	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   39: aload 6
    //   41: astore_2
    //   42: new 28	java/io/File
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 32	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_0
    //   51: aload 6
    //   53: astore_2
    //   54: aload_0
    //   55: invokevirtual 130	java/io/File:exists	()Z
    //   58: ifne +11 -> 69
    //   61: aload 6
    //   63: astore_2
    //   64: aload_0
    //   65: invokevirtual 133	java/io/File:createNewFile	()Z
    //   68: pop
    //   69: aload 6
    //   71: astore_2
    //   72: new 135	java/io/FileOutputStream
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 138	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   80: astore_0
    //   81: aload_0
    //   82: aload 7
    //   84: invokevirtual 142	java/nio/ByteBuffer:array	()[B
    //   87: invokevirtual 146	java/io/FileOutputStream:write	([B)V
    //   90: aload_0
    //   91: invokevirtual 149	java/io/FileOutputStream:flush	()V
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   102: return
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   108: return
    //   109: astore_1
    //   110: aload_3
    //   111: astore_0
    //   112: aload_0
    //   113: astore_2
    //   114: aload_1
    //   115: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   118: aload_0
    //   119: ifnull -17 -> 102
    //   122: aload_0
    //   123: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   126: return
    //   127: astore_0
    //   128: aload_0
    //   129: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   132: return
    //   133: astore_1
    //   134: aload 4
    //   136: astore_0
    //   137: aload_0
    //   138: astore_2
    //   139: aload_1
    //   140: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   143: aload_0
    //   144: astore_2
    //   145: ldc 62
    //   147: iconst_4
    //   148: new 64	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   155: ldc 116
    //   157: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_1
    //   161: invokevirtual 77	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   164: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: aload_0
    //   174: ifnull -72 -> 102
    //   177: aload_0
    //   178: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   181: return
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   187: return
    //   188: astore_1
    //   189: aload 5
    //   191: astore_0
    //   192: aload_0
    //   193: astore_2
    //   194: aload_1
    //   195: invokevirtual 117	java/lang/OutOfMemoryError:printStackTrace	()V
    //   198: aload_0
    //   199: astore_2
    //   200: ldc 62
    //   202: iconst_4
    //   203: new 64	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   210: ldc 119
    //   212: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 120	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   219: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_0
    //   229: ifnull -127 -> 102
    //   232: aload_0
    //   233: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   236: return
    //   237: astore_0
    //   238: aload_0
    //   239: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   242: return
    //   243: astore_0
    //   244: aload_2
    //   245: ifnull +7 -> 252
    //   248: aload_2
    //   249: invokevirtual 152	java/io/FileOutputStream:close	()V
    //   252: aload_0
    //   253: athrow
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   259: goto -7 -> 252
    //   262: astore_1
    //   263: aload_0
    //   264: astore_2
    //   265: aload_1
    //   266: astore_0
    //   267: goto -23 -> 244
    //   270: astore_1
    //   271: goto -79 -> 192
    //   274: astore_1
    //   275: goto -138 -> 137
    //   278: astore_1
    //   279: goto -167 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramString	String
    //   0	282	1	paramBitmap	android.graphics.Bitmap
    //   13	252	2	localObject1	Object
    //   10	101	3	localObject2	Object
    //   1	134	4	localObject3	Object
    //   4	186	5	localObject4	Object
    //   7	63	6	localObject5	Object
    //   28	55	7	localByteBuffer	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   98	102	103	java/io/IOException
    //   14	30	109	java/io/IOException
    //   33	39	109	java/io/IOException
    //   42	51	109	java/io/IOException
    //   54	61	109	java/io/IOException
    //   64	69	109	java/io/IOException
    //   72	81	109	java/io/IOException
    //   122	126	127	java/io/IOException
    //   14	30	133	java/lang/Exception
    //   33	39	133	java/lang/Exception
    //   42	51	133	java/lang/Exception
    //   54	61	133	java/lang/Exception
    //   64	69	133	java/lang/Exception
    //   72	81	133	java/lang/Exception
    //   177	181	182	java/io/IOException
    //   14	30	188	java/lang/OutOfMemoryError
    //   33	39	188	java/lang/OutOfMemoryError
    //   42	51	188	java/lang/OutOfMemoryError
    //   54	61	188	java/lang/OutOfMemoryError
    //   64	69	188	java/lang/OutOfMemoryError
    //   72	81	188	java/lang/OutOfMemoryError
    //   232	236	237	java/io/IOException
    //   14	30	243	finally
    //   33	39	243	finally
    //   42	51	243	finally
    //   54	61	243	finally
    //   64	69	243	finally
    //   72	81	243	finally
    //   114	118	243	finally
    //   139	143	243	finally
    //   145	173	243	finally
    //   194	198	243	finally
    //   200	228	243	finally
    //   248	252	254	java/io/IOException
    //   81	94	262	finally
    //   81	94	270	java/lang/OutOfMemoryError
    //   81	94	274	java/lang/Exception
    //   81	94	278	java/io/IOException
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
  
  /* Error */
  private static byte[] a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 180	java/io/File:isFile	()Z
    //   7: ifeq +135 -> 142
    //   10: new 182	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 183	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_0
    //   21: sipush 1024
    //   24: newarray byte
    //   26: astore_3
    //   27: aload_2
    //   28: astore_0
    //   29: new 185	java/io/ByteArrayOutputStream
    //   32: dup
    //   33: invokespecial 186	java/io/ByteArrayOutputStream:<init>	()V
    //   36: astore 5
    //   38: aload_2
    //   39: astore_0
    //   40: aload_2
    //   41: aload_3
    //   42: invokevirtual 190	java/io/FileInputStream:read	([B)I
    //   45: istore_1
    //   46: iload_1
    //   47: iconst_m1
    //   48: if_icmpeq +39 -> 87
    //   51: aload_2
    //   52: astore_0
    //   53: aload 5
    //   55: aload_3
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual 193	java/io/ByteArrayOutputStream:write	([BII)V
    //   61: goto -23 -> 38
    //   64: astore_3
    //   65: aload_2
    //   66: astore_0
    //   67: aload_3
    //   68: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   71: aload 4
    //   73: astore_0
    //   74: aload_2
    //   75: ifnull +10 -> 85
    //   78: aload_2
    //   79: invokevirtual 194	java/io/FileInputStream:close	()V
    //   82: aload 4
    //   84: astore_0
    //   85: aload_0
    //   86: areturn
    //   87: aload_2
    //   88: astore_0
    //   89: aload 5
    //   91: invokevirtual 197	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   94: astore_3
    //   95: aload_3
    //   96: astore_0
    //   97: aload_2
    //   98: ifnull -13 -> 85
    //   101: aload_2
    //   102: invokevirtual 194	java/io/FileInputStream:close	()V
    //   105: aload_3
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   112: aload_3
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_2
    //   122: aconst_null
    //   123: astore_0
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 194	java/io/FileInputStream:close	()V
    //   132: aload_2
    //   133: athrow
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   139: goto -7 -> 132
    //   142: ldc 62
    //   144: iconst_4
    //   145: new 64	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   152: ldc 199
    //   154: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: invokevirtual 202	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   161: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 86	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aconst_null
    //   171: areturn
    //   172: astore_2
    //   173: goto -49 -> 124
    //   176: astore_3
    //   177: aconst_null
    //   178: astore_2
    //   179: goto -114 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramFile	java.io.File
    //   45	13	1	i	int
    //   18	84	2	localFileInputStream	java.io.FileInputStream
    //   121	12	2	localObject1	Object
    //   172	1	2	localObject2	Object
    //   178	1	2	localObject3	Object
    //   26	30	3	arrayOfByte1	byte[]
    //   64	4	3	localIOException1	java.io.IOException
    //   94	19	3	arrayOfByte2	byte[]
    //   176	1	3	localIOException2	java.io.IOException
    //   1	82	4	localObject4	Object
    //   36	54	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   21	27	64	java/io/IOException
    //   29	38	64	java/io/IOException
    //   40	46	64	java/io/IOException
    //   53	61	64	java/io/IOException
    //   89	95	64	java/io/IOException
    //   101	105	107	java/io/IOException
    //   78	82	114	java/io/IOException
    //   10	19	121	finally
    //   128	132	134	java/io/IOException
    //   21	27	172	finally
    //   29	38	172	finally
    //   40	46	172	finally
    //   53	61	172	finally
    //   67	71	172	finally
    //   89	95	172	finally
    //   10	19	176	java/io/IOException
  }
  
  private static PointF b(PointF paramPointF1, PointF paramPointF2, PointF paramPointF3)
  {
    return new PointF(paramPointF2.x + paramPointF3.x * paramPointF1.x - paramPointF3.y * paramPointF1.y, paramPointF2.y + paramPointF3.x * paramPointF1.y + paramPointF3.y * paramPointF1.x);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmve
 * JD-Core Version:    0.7.0.1
 */