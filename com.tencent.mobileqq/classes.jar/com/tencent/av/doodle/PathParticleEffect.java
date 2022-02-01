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
    //   14: ifeq +187 -> 201
    //   17: aload 6
    //   19: iload_2
    //   20: invokevirtual 52	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   23: astore 7
    //   25: new 54	java/io/BufferedReader
    //   28: dup
    //   29: new 56	java/io/InputStreamReader
    //   32: dup
    //   33: aload 7
    //   35: invokespecial 59	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   38: sipush 512
    //   41: invokespecial 62	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   44: astore 5
    //   46: aload 5
    //   48: astore_1
    //   49: new 30	com/tencent/av/doodle/PathParticleEmitter
    //   52: dup
    //   53: aload 5
    //   55: invokespecial 65	com/tencent/av/doodle/PathParticleEmitter:<init>	(Ljava/io/BufferedReader;)V
    //   58: astore 8
    //   60: aload 5
    //   62: astore_1
    //   63: aload 5
    //   65: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: pop
    //   69: aload 5
    //   71: astore_1
    //   72: aload 5
    //   74: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: pop
    //   78: aload 5
    //   80: astore_1
    //   81: aload 6
    //   83: iload_3
    //   84: invokevirtual 73	android/content/res/Resources:obtainTypedArray	(I)Landroid/content/res/TypedArray;
    //   87: astore 9
    //   89: aload 5
    //   91: astore_1
    //   92: aload 9
    //   94: invokevirtual 78	android/content/res/TypedArray:length	()I
    //   97: istore 4
    //   99: aload 5
    //   101: astore_1
    //   102: iload 4
    //   104: anewarray 80	android/graphics/drawable/BitmapDrawable
    //   107: astore 10
    //   109: iconst_0
    //   110: istore_2
    //   111: iload_2
    //   112: iload 4
    //   114: if_icmpge +26 -> 140
    //   117: aload 5
    //   119: astore_1
    //   120: aload 10
    //   122: iload_2
    //   123: aload 9
    //   125: iload_2
    //   126: invokevirtual 84	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   129: checkcast 80	android/graphics/drawable/BitmapDrawable
    //   132: aastore
    //   133: iload_2
    //   134: iconst_1
    //   135: iadd
    //   136: istore_2
    //   137: goto -26 -> 111
    //   140: aload 5
    //   142: astore_1
    //   143: aload 8
    //   145: aload 10
    //   147: invokevirtual 87	com/tencent/av/doodle/PathParticleEmitter:a	([Landroid/graphics/drawable/BitmapDrawable;)V
    //   150: aload 5
    //   152: astore_1
    //   153: aload 9
    //   155: invokevirtual 90	android/content/res/TypedArray:recycle	()V
    //   158: aload 5
    //   160: astore_1
    //   161: aload_0
    //   162: getfield 18	com/tencent/av/doodle/PathParticleEffect:a	Ljava/util/ArrayList;
    //   165: aload 8
    //   167: invokevirtual 94	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   170: pop
    //   171: aload 5
    //   173: astore_1
    //   174: aload 5
    //   176: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   179: astore 8
    //   181: aload 8
    //   183: ifnonnull +19 -> 202
    //   186: aload 5
    //   188: ifnull +8 -> 196
    //   191: aload 5
    //   193: invokevirtual 97	java/io/BufferedReader:close	()V
    //   196: aload 7
    //   198: invokevirtual 100	java/io/InputStream:close	()V
    //   201: return
    //   202: aload 5
    //   204: astore_1
    //   205: aload 5
    //   207: invokevirtual 69	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   210: astore 8
    //   212: aload 8
    //   214: ifnonnull -168 -> 46
    //   217: goto -31 -> 186
    //   220: astore_1
    //   221: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq -23 -> 201
    //   227: ldc 108
    //   229: iconst_2
    //   230: ldc 110
    //   232: aload_1
    //   233: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   236: return
    //   237: astore 6
    //   239: aconst_null
    //   240: astore 5
    //   242: aload 5
    //   244: astore_1
    //   245: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +16 -> 264
    //   251: aload 5
    //   253: astore_1
    //   254: ldc 108
    //   256: iconst_2
    //   257: ldc 116
    //   259: aload 6
    //   261: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   264: aload 5
    //   266: ifnull +8 -> 274
    //   269: aload 5
    //   271: invokevirtual 97	java/io/BufferedReader:close	()V
    //   274: aload 7
    //   276: invokevirtual 100	java/io/InputStream:close	()V
    //   279: return
    //   280: astore_1
    //   281: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq -83 -> 201
    //   287: ldc 108
    //   289: iconst_2
    //   290: ldc 110
    //   292: aload_1
    //   293: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   296: return
    //   297: astore 5
    //   299: aconst_null
    //   300: astore_1
    //   301: aload_1
    //   302: ifnull +7 -> 309
    //   305: aload_1
    //   306: invokevirtual 97	java/io/BufferedReader:close	()V
    //   309: aload 7
    //   311: invokevirtual 100	java/io/InputStream:close	()V
    //   314: aload 5
    //   316: athrow
    //   317: astore_1
    //   318: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq -7 -> 314
    //   324: ldc 108
    //   326: iconst_2
    //   327: ldc 110
    //   329: aload_1
    //   330: invokestatic 114	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   333: goto -19 -> 314
    //   336: astore 5
    //   338: goto -37 -> 301
    //   341: astore 6
    //   343: goto -101 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	PathParticleEffect
    //   0	346	1	paramContext	android.content.Context
    //   0	346	2	paramInt1	int
    //   0	346	3	paramInt2	int
    //   97	18	4	i	int
    //   44	226	5	localBufferedReader	java.io.BufferedReader
    //   297	18	5	localObject1	Object
    //   336	1	5	localObject2	Object
    //   4	78	6	localResources	android.content.res.Resources
    //   237	23	6	localIOException1	java.io.IOException
    //   341	1	6	localIOException2	java.io.IOException
    //   23	287	7	localInputStream	java.io.InputStream
    //   58	155	8	localObject3	Object
    //   87	67	9	localTypedArray	android.content.res.TypedArray
    //   107	39	10	arrayOfBitmapDrawable	android.graphics.drawable.BitmapDrawable[]
    // Exception table:
    //   from	to	target	type
    //   191	196	220	java/lang/Exception
    //   196	201	220	java/lang/Exception
    //   25	46	237	java/io/IOException
    //   269	274	280	java/lang/Exception
    //   274	279	280	java/lang/Exception
    //   25	46	297	finally
    //   305	309	317	java/lang/Exception
    //   309	314	317	java/lang/Exception
    //   49	60	336	finally
    //   63	69	336	finally
    //   72	78	336	finally
    //   81	89	336	finally
    //   92	99	336	finally
    //   102	109	336	finally
    //   120	133	336	finally
    //   143	150	336	finally
    //   153	158	336	finally
    //   161	171	336	finally
    //   174	181	336	finally
    //   205	212	336	finally
    //   245	251	336	finally
    //   254	264	336	finally
    //   49	60	341	java/io/IOException
    //   63	69	341	java/io/IOException
    //   72	78	341	java/io/IOException
    //   81	89	341	java/io/IOException
    //   92	99	341	java/io/IOException
    //   102	109	341	java/io/IOException
    //   120	133	341	java/io/IOException
    //   143	150	341	java/io/IOException
    //   153	158	341	java/io/IOException
    //   161	171	341	java/io/IOException
    //   174	181	341	java/io/IOException
    //   205	212	341	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.doodle.PathParticleEffect
 * JD-Core Version:    0.7.0.1
 */