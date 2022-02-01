package com.tencent.ilivesdk.avpreloadservice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.Image;
import android.media.Image.Plane;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import java.nio.ByteBuffer;

public class FrameDecoder
{
  private static FrameDecoder a = new FrameDecoder();
  
  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    float f1 = paramInt1 / j;
    float f2 = paramInt2 / i;
    Object localObject = new Matrix();
    ((Matrix)localObject).postScale(f1, f2);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, j, i, (Matrix)localObject, false);
    if (!paramBitmap.isRecycled()) {
      paramBitmap.recycle();
    }
    return localObject;
  }
  
  private Bitmap a(Image paramImage, Context paramContext)
  {
    Object localObject = paramImage.getPlanes();
    ByteBuffer localByteBuffer1 = localObject[0].getBuffer();
    int i = localObject[0].getPixelStride();
    int j = localObject[0].getRowStride();
    int k = localByteBuffer1.remaining();
    ByteBuffer localByteBuffer2 = localObject[1].getBuffer();
    int i2 = localObject[1].getPixelStride();
    int i3 = localObject[1].getRowStride();
    int m = localByteBuffer2.remaining();
    ByteBuffer localByteBuffer3 = localObject[2].getBuffer();
    int i4 = localObject[2].getPixelStride();
    int i1 = localObject[2].getRowStride();
    int n = localByteBuffer3.remaining();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("yBuffer: ");
    ((StringBuilder)localObject).append(localByteBuffer1.remaining());
    ((StringBuilder)localObject).append(" pixelStride: ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" rowStride: ");
    ((StringBuilder)localObject).append(j);
    Log.i("FrameDecoder", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uBuffer: ");
    ((StringBuilder)localObject).append(localByteBuffer2.remaining());
    ((StringBuilder)localObject).append(" pixelStride: ");
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append(" rowStride: ");
    ((StringBuilder)localObject).append(i3);
    Log.i("FrameDecoder", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("vBuffer: ");
    ((StringBuilder)localObject).append(localByteBuffer3.remaining());
    ((StringBuilder)localObject).append(" pixelStride: ");
    ((StringBuilder)localObject).append(i4);
    ((StringBuilder)localObject).append(" rowStride: ");
    ((StringBuilder)localObject).append(i1);
    Log.i("FrameDecoder", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("image format: ");
    ((StringBuilder)localObject).append(paramImage.getFormat());
    ((StringBuilder)localObject).append("  WxH: ");
    ((StringBuilder)localObject).append(paramImage.getWidth());
    ((StringBuilder)localObject).append("x");
    ((StringBuilder)localObject).append(paramImage.getHeight());
    Log.i("FrameDecoder", ((StringBuilder)localObject).toString());
    localObject = new byte[k + n + m];
    i = 0;
    localByteBuffer1.get((byte[])localObject, 0, k);
    if (j == i1)
    {
      localByteBuffer3.get((byte[])localObject, k, n);
    }
    else
    {
      j = 0;
      while ((i < localObject.length) && (j < m) && (j < n))
      {
        i1 = k + i;
        localObject[i1] = localByteBuffer3.get(j);
        localObject[(i1 + 1)] = localByteBuffer2.get(j);
        j += 1;
        i += 2;
      }
    }
    return NV12ToBitmap.a(paramContext, (byte[])localObject, paramImage.getWidth(), paramImage.getHeight());
  }
  
  private MediaCodec a(int paramInt1, int paramInt2)
  {
    MediaCodec localMediaCodec;
    try
    {
      localMediaCodec = MediaCodec.createDecoderByType("video/avc");
      try
      {
        MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", paramInt1, paramInt2);
        localMediaFormat.setString("mime", "video/avc");
        localMediaFormat.setInteger("max-input-size", paramInt1 * paramInt2);
        localMediaCodec.configure(localMediaFormat, null, null, 0);
        localMediaCodec.start();
        return localMediaCodec;
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      localMediaCodec = null;
    }
    if (localMediaCodec != null) {
      localMediaCodec.release();
    }
    return null;
  }
  
  public static FrameDecoder a()
  {
    return a;
  }
  
  private void a(MediaCodec paramMediaCodec)
  {
    if (paramMediaCodec == null) {
      return;
    }
    try
    {
      paramMediaCodec.stop();
      paramMediaCodec.release();
      return;
    }
    catch (Exception paramMediaCodec)
    {
      paramMediaCodec.printStackTrace();
    }
  }
  
  /* Error */
  public Bitmap a(Context paramContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +457 -> 458
    //   4: aload_2
    //   5: arraylength
    //   6: ifle +452 -> 458
    //   9: iload_3
    //   10: ifgt +6 -> 16
    //   13: goto +445 -> 458
    //   16: iload 4
    //   18: ifle +392 -> 410
    //   21: iload 5
    //   23: ifgt +6 -> 29
    //   26: goto +384 -> 410
    //   29: new 69	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   36: astore 10
    //   38: aload 10
    //   40: ldc 172
    //   42: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 10
    //   48: iload 4
    //   50: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 10
    //   56: ldc 109
    //   58: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 10
    //   64: iload 5
    //   66: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: ldc 85
    //   72: aload 10
    //   74: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 95	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   80: pop
    //   81: aload_0
    //   82: iload 4
    //   84: iload 5
    //   86: invokespecial 174	com/tencent/ilivesdk/avpreloadservice/FrameDecoder:a	(II)Landroid/media/MediaCodec;
    //   89: astore 11
    //   91: aload 11
    //   93: ifnonnull +5 -> 98
    //   96: aconst_null
    //   97: areturn
    //   98: new 176	android/media/MediaCodec$BufferInfo
    //   101: dup
    //   102: invokespecial 177	android/media/MediaCodec$BufferInfo:<init>	()V
    //   105: astore 12
    //   107: sipush 30000
    //   110: i2l
    //   111: lstore 8
    //   113: aload 11
    //   115: lload 8
    //   117: invokevirtual 181	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   120: istore 4
    //   122: aload 11
    //   124: iload 4
    //   126: invokevirtual 185	android/media/MediaCodec:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   129: astore 10
    //   131: aload 10
    //   133: ifnull +198 -> 331
    //   136: aload 10
    //   138: invokevirtual 67	java/nio/ByteBuffer:remaining	()I
    //   141: istore 5
    //   143: iload 5
    //   145: iload_3
    //   146: if_icmpge +20 -> 166
    //   149: aload 10
    //   151: iload_3
    //   152: invokevirtual 189	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   155: pop
    //   156: goto +10 -> 166
    //   159: astore 10
    //   161: aconst_null
    //   162: astore_2
    //   163: goto +194 -> 357
    //   166: aload 10
    //   168: iconst_0
    //   169: invokevirtual 192	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   172: pop
    //   173: aload 10
    //   175: aload_2
    //   176: iconst_0
    //   177: iload_3
    //   178: invokevirtual 195	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   181: pop
    //   182: aload 11
    //   184: iload 4
    //   186: iconst_0
    //   187: iload_3
    //   188: lconst_0
    //   189: iconst_4
    //   190: invokevirtual 199	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   193: aload 11
    //   195: astore 10
    //   197: iconst_0
    //   198: istore_3
    //   199: aload 10
    //   201: aload 12
    //   203: lload 8
    //   205: invokevirtual 203	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   208: istore 4
    //   210: new 69	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   217: astore_2
    //   218: aload_2
    //   219: ldc 205
    //   221: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_2
    //   226: iload 4
    //   228: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: ldc 85
    //   234: aload_2
    //   235: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 95	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   241: pop
    //   242: iload 4
    //   244: iflt +224 -> 468
    //   247: aload 10
    //   249: iload 4
    //   251: invokevirtual 209	android/media/MediaCodec:getOutputImage	(I)Landroid/media/Image;
    //   254: astore_2
    //   255: goto +3 -> 258
    //   258: iload 4
    //   260: iflt +59 -> 319
    //   263: aload_2
    //   264: ifnull +55 -> 319
    //   267: aload_2
    //   268: invokevirtual 104	android/media/Image:getFormat	()I
    //   271: bipush 35
    //   273: if_icmpne +22 -> 295
    //   276: aload_2
    //   277: invokevirtual 50	android/media/Image:getPlanes	()[Landroid/media/Image$Plane;
    //   280: arraylength
    //   281: iconst_3
    //   282: if_icmplt +13 -> 295
    //   285: aload_0
    //   286: aload_2
    //   287: aload_1
    //   288: invokespecial 211	com/tencent/ilivesdk/avpreloadservice/FrameDecoder:a	(Landroid/media/Image;Landroid/content/Context;)Landroid/graphics/Bitmap;
    //   291: astore_1
    //   292: goto +5 -> 297
    //   295: aconst_null
    //   296: astore_1
    //   297: aload 10
    //   299: iload 4
    //   301: iconst_0
    //   302: invokevirtual 215	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   305: aload_2
    //   306: invokevirtual 218	android/media/Image:close	()V
    //   309: goto +55 -> 364
    //   312: astore 10
    //   314: aload_1
    //   315: astore_2
    //   316: goto +41 -> 357
    //   319: aconst_null
    //   320: astore_1
    //   321: goto +43 -> 364
    //   324: goto -125 -> 199
    //   327: astore_1
    //   328: goto +24 -> 352
    //   331: aload_0
    //   332: aload 11
    //   334: invokespecial 220	com/tencent/ilivesdk/avpreloadservice/FrameDecoder:a	(Landroid/media/MediaCodec;)V
    //   337: new 222	java/lang/IllegalAccessError
    //   340: dup
    //   341: ldc 224
    //   343: invokespecial 227	java/lang/IllegalAccessError:<init>	(Ljava/lang/String;)V
    //   346: athrow
    //   347: astore_1
    //   348: goto +4 -> 352
    //   351: astore_1
    //   352: aconst_null
    //   353: astore_2
    //   354: aload_1
    //   355: astore 10
    //   357: aload 10
    //   359: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   362: aload_2
    //   363: astore_1
    //   364: aload_0
    //   365: aload 11
    //   367: invokespecial 220	com/tencent/ilivesdk/avpreloadservice/FrameDecoder:a	(Landroid/media/MediaCodec;)V
    //   370: aload_1
    //   371: ifnonnull +13 -> 384
    //   374: ldc 85
    //   376: ldc 229
    //   378: invokestatic 95	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   381: pop
    //   382: aconst_null
    //   383: areturn
    //   384: aload_1
    //   385: astore_2
    //   386: iload 6
    //   388: ifeq +20 -> 408
    //   391: aload_1
    //   392: astore_2
    //   393: iload 7
    //   395: ifeq +13 -> 408
    //   398: aload_0
    //   399: aload_1
    //   400: iload 6
    //   402: iload 7
    //   404: invokespecial 231	com/tencent/ilivesdk/avpreloadservice/FrameDecoder:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   407: astore_2
    //   408: aload_2
    //   409: areturn
    //   410: new 69	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   417: astore_1
    //   418: aload_1
    //   419: ldc 233
    //   421: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload_1
    //   426: iload 4
    //   428: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: pop
    //   432: aload_1
    //   433: ldc 235
    //   435: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload_1
    //   440: iload 5
    //   442: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: ldc 85
    //   448: aload_1
    //   449: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 95	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   455: pop
    //   456: aconst_null
    //   457: areturn
    //   458: ldc 85
    //   460: ldc 237
    //   462: invokestatic 240	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   465: pop
    //   466: aconst_null
    //   467: areturn
    //   468: iload_3
    //   469: iconst_1
    //   470: iadd
    //   471: istore_3
    //   472: iload_3
    //   473: bipush 10
    //   475: if_icmplt -151 -> 324
    //   478: aconst_null
    //   479: astore_2
    //   480: goto -222 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	this	FrameDecoder
    //   0	483	1	paramContext	Context
    //   0	483	2	paramArrayOfByte	byte[]
    //   0	483	3	paramInt1	int
    //   0	483	4	paramInt2	int
    //   0	483	5	paramInt3	int
    //   0	483	6	paramInt4	int
    //   0	483	7	paramInt5	int
    //   111	93	8	l	long
    //   36	114	10	localObject1	Object
    //   159	15	10	localException1	Exception
    //   195	103	10	localObject2	Object
    //   312	1	10	localException2	Exception
    //   355	3	10	localContext	Context
    //   89	277	11	localMediaCodec	MediaCodec
    //   105	97	12	localBufferInfo	android.media.MediaCodec.BufferInfo
    // Exception table:
    //   from	to	target	type
    //   149	156	159	java/lang/Exception
    //   297	309	312	java/lang/Exception
    //   182	193	327	java/lang/Exception
    //   199	242	347	java/lang/Exception
    //   247	255	347	java/lang/Exception
    //   267	292	347	java/lang/Exception
    //   331	347	347	java/lang/Exception
    //   98	107	351	java/lang/Exception
    //   113	131	351	java/lang/Exception
    //   136	143	351	java/lang/Exception
    //   166	182	351	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.FrameDecoder
 * JD-Core Version:    0.7.0.1
 */