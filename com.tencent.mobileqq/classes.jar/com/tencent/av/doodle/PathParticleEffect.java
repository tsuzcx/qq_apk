package com.tencent.av.doodle;

import android.graphics.Canvas;
import android.graphics.PathMeasure;
import java.util.ArrayList;

public class PathParticleEffect
{
  private final ArrayList<PathParticleEmitter> a = new ArrayList(1);
  
  public void a(float paramFloat)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((PathParticleEmitter)this.a.get(i)).a(paramFloat);
      i += 1;
    }
  }
  
  /* Error */
  public void a(android.content.Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 43	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: astore 6
    //   6: aload_0
    //   7: getfield 18	com/tencent/av/doodle/PathParticleEffect:a	Ljava/util/ArrayList;
    //   10: invokevirtual 46	java/util/ArrayList:clear	()V
    //   13: iload_2
    //   14: ifeq +290 -> 304
    //   17: aload 6
    //   19: iload_2
    //   20: invokevirtual 52	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   23: astore 8
    //   25: aconst_null
    //   26: astore 7
    //   28: aconst_null
    //   29: astore_1
    //   30: new 54	java/io/BufferedReader
    //   33: dup
    //   34: new 56	java/io/InputStreamReader
    //   37: dup
    //   38: aload 8
    //   40: invokespecial 59	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   43: sipush 512
    //   46: invokespecial 62	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   49: astore 5
    //   51: new 30	com/tencent/av/doodle/PathParticleEmitter
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 65	com/tencent/av/doodle/PathParticleEmitter:<init>	(Ljava/io/BufferedReader;)V
    //   60: astore_1
    //   61: aload 5
    //   63: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: pop
    //   67: aload 5
    //   69: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   72: pop
    //   73: aload 6
    //   75: iload_3
    //   76: invokevirtual 73	android/content/res/Resources:obtainTypedArray	(I)Landroid/content/res/TypedArray;
    //   79: astore 7
    //   81: aload 7
    //   83: invokevirtual 78	android/content/res/TypedArray:length	()I
    //   86: istore 4
    //   88: iload 4
    //   90: anewarray 80	android/graphics/drawable/BitmapDrawable
    //   93: astore 9
    //   95: iconst_0
    //   96: istore_2
    //   97: iload_2
    //   98: iload 4
    //   100: if_icmpge +23 -> 123
    //   103: aload 9
    //   105: iload_2
    //   106: aload 7
    //   108: iload_2
    //   109: invokevirtual 84	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   112: checkcast 80	android/graphics/drawable/BitmapDrawable
    //   115: aastore
    //   116: iload_2
    //   117: iconst_1
    //   118: iadd
    //   119: istore_2
    //   120: goto -23 -> 97
    //   123: aload_1
    //   124: aload 9
    //   126: invokevirtual 87	com/tencent/av/doodle/PathParticleEmitter:a	([Landroid/graphics/drawable/BitmapDrawable;)V
    //   129: aload 7
    //   131: invokevirtual 90	android/content/res/TypedArray:recycle	()V
    //   134: aload_0
    //   135: getfield 18	com/tencent/av/doodle/PathParticleEffect:a	Ljava/util/ArrayList;
    //   138: aload_1
    //   139: invokevirtual 94	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   142: pop
    //   143: aload 5
    //   145: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   148: ifnonnull +6 -> 154
    //   151: goto +13 -> 164
    //   154: aload 5
    //   156: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   159: astore_1
    //   160: aload_1
    //   161: ifnonnull -110 -> 51
    //   164: aload 5
    //   166: invokevirtual 97	java/io/BufferedReader:close	()V
    //   169: aload 8
    //   171: invokevirtual 100	java/io/InputStream:close	()V
    //   174: return
    //   175: astore_1
    //   176: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +125 -> 304
    //   182: ldc 108
    //   184: iconst_2
    //   185: ldc 110
    //   187: aload_1
    //   188: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   191: return
    //   192: astore_1
    //   193: goto +73 -> 266
    //   196: astore 6
    //   198: goto +20 -> 218
    //   201: astore 6
    //   203: aload_1
    //   204: astore 5
    //   206: aload 6
    //   208: astore_1
    //   209: goto +57 -> 266
    //   212: astore 6
    //   214: aload 7
    //   216: astore 5
    //   218: aload 5
    //   220: astore_1
    //   221: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +16 -> 240
    //   227: aload 5
    //   229: astore_1
    //   230: ldc 108
    //   232: iconst_2
    //   233: ldc 116
    //   235: aload 6
    //   237: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   240: aload 5
    //   242: ifnull +8 -> 250
    //   245: aload 5
    //   247: invokevirtual 97	java/io/BufferedReader:close	()V
    //   250: aload 8
    //   252: invokevirtual 100	java/io/InputStream:close	()V
    //   255: return
    //   256: astore_1
    //   257: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +44 -> 304
    //   263: goto -81 -> 182
    //   266: aload 5
    //   268: ifnull +8 -> 276
    //   271: aload 5
    //   273: invokevirtual 97	java/io/BufferedReader:close	()V
    //   276: aload 8
    //   278: invokevirtual 100	java/io/InputStream:close	()V
    //   281: goto +21 -> 302
    //   284: astore 5
    //   286: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +13 -> 302
    //   292: ldc 108
    //   294: iconst_2
    //   295: ldc 110
    //   297: aload 5
    //   299: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   302: aload_1
    //   303: athrow
    //   304: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	PathParticleEffect
    //   0	305	1	paramContext	android.content.Context
    //   0	305	2	paramInt1	int
    //   0	305	3	paramInt2	int
    //   86	15	4	i	int
    //   49	223	5	localObject1	Object
    //   284	14	5	localException	java.lang.Exception
    //   4	70	6	localResources	android.content.res.Resources
    //   196	1	6	localIOException1	java.io.IOException
    //   201	6	6	localObject2	Object
    //   212	24	6	localIOException2	java.io.IOException
    //   26	189	7	localTypedArray	android.content.res.TypedArray
    //   23	254	8	localInputStream	java.io.InputStream
    //   93	32	9	arrayOfBitmapDrawable	android.graphics.drawable.BitmapDrawable[]
    // Exception table:
    //   from	to	target	type
    //   164	174	175	java/lang/Exception
    //   51	95	192	finally
    //   103	116	192	finally
    //   123	151	192	finally
    //   154	160	192	finally
    //   51	95	196	java/io/IOException
    //   103	116	196	java/io/IOException
    //   123	151	196	java/io/IOException
    //   154	160	196	java/io/IOException
    //   30	51	201	finally
    //   221	227	201	finally
    //   230	240	201	finally
    //   30	51	212	java/io/IOException
    //   245	250	256	java/lang/Exception
    //   250	255	256	java/lang/Exception
    //   271	276	284	java/lang/Exception
    //   276	281	284	java/lang/Exception
  }
  
  public void a(Canvas paramCanvas)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((PathParticleEmitter)this.a.get(i)).a(paramCanvas);
      i += 1;
    }
  }
  
  public void a(PathMeasure paramPathMeasure)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((PathParticleEmitter)this.a.get(i)).a(paramPathMeasure);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEffect
 * JD-Core Version:    0.7.0.1
 */