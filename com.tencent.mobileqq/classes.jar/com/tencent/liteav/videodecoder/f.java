package com.tencent.liteav.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

public class f
  implements b
{
  private MediaCodec.BufferInfo a = new MediaCodec.BufferInfo();
  private MediaCodec b = null;
  private String c = "video/avc";
  private int d = 540;
  private int e = 960;
  private long f = 0L;
  private long g = 0L;
  private boolean h = true;
  private boolean i = false;
  private boolean j = false;
  private Surface k = null;
  private int l = 0;
  private ArrayList<TXSNALPacket> m = new ArrayList();
  private ArrayList<Long> n = new ArrayList();
  private long o = 0L;
  private int p = 0;
  private JSONArray q = null;
  private g r;
  private d s = new d();
  private boolean t = false;
  private WeakReference<com.tencent.liteav.basic.c.b> u;
  
  /* Error */
  private int a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   4: astore 7
    //   6: iconst_0
    //   7: istore 6
    //   9: iconst_m1
    //   10: istore 5
    //   12: aload 7
    //   14: ifnonnull +472 -> 486
    //   17: aload_0
    //   18: getfield 73	com/tencent/liteav/videodecoder/f:k	Landroid/view/Surface;
    //   21: ifnonnull +6 -> 27
    //   24: goto +462 -> 486
    //   27: aload_0
    //   28: iload_3
    //   29: putfield 71	com/tencent/liteav/videodecoder/f:j	Z
    //   32: aload_0
    //   33: getfield 71	com/tencent/liteav/videodecoder/f:j	Z
    //   36: ifeq +12 -> 48
    //   39: aload_0
    //   40: ldc 101
    //   42: putfield 57	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   45: goto +9 -> 54
    //   48: aload_0
    //   49: ldc 55
    //   51: putfield 57	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   54: aload_0
    //   55: getfield 57	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   58: aload_0
    //   59: getfield 59	com/tencent/liteav/videodecoder/f:d	I
    //   62: aload_0
    //   63: getfield 61	com/tencent/liteav/videodecoder/f:e	I
    //   66: invokestatic 107	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   69: astore 8
    //   71: aload_1
    //   72: ifnull +11 -> 83
    //   75: aload 8
    //   77: ldc 109
    //   79: aload_1
    //   80: invokevirtual 113	android/media/MediaFormat:setByteBuffer	(Ljava/lang/String;Ljava/nio/ByteBuffer;)V
    //   83: aload_2
    //   84: ifnull +11 -> 95
    //   87: aload 8
    //   89: ldc 115
    //   91: aload_2
    //   92: invokevirtual 113	android/media/MediaFormat:setByteBuffer	(Ljava/lang/String;Ljava/nio/ByteBuffer;)V
    //   95: aload_0
    //   96: getfield 88	com/tencent/liteav/videodecoder/f:q	Lorg/json/JSONArray;
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +82 -> 183
    //   104: iconst_0
    //   105: istore 4
    //   107: iload 4
    //   109: aload_1
    //   110: invokevirtual 121	org/json/JSONArray:length	()I
    //   113: if_icmpge +70 -> 183
    //   116: aload_1
    //   117: iload 4
    //   119: invokevirtual 125	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   122: astore_2
    //   123: aload 8
    //   125: aload_2
    //   126: ldc 127
    //   128: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: aload_2
    //   132: ldc 135
    //   134: invokevirtual 139	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   137: invokevirtual 143	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   140: iload 4
    //   142: iconst_1
    //   143: iadd
    //   144: istore 4
    //   146: goto -39 -> 107
    //   149: astore_1
    //   150: new 145	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   157: astore_2
    //   158: aload_2
    //   159: ldc 148
    //   161: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_2
    //   166: aload_1
    //   167: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
    //   170: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: ldc 158
    //   176: aload_2
    //   177: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 165	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: getstatic 170	android/os/Build$VERSION:SDK_INT	I
    //   186: bipush 21
    //   188: if_icmplt +96 -> 284
    //   191: aload_0
    //   192: getfield 71	com/tencent/liteav/videodecoder/f:j	Z
    //   195: ifeq +89 -> 284
    //   198: new 172	android/media/MediaCodecList
    //   201: dup
    //   202: iconst_1
    //   203: invokespecial 175	android/media/MediaCodecList:<init>	(I)V
    //   206: aload 8
    //   208: invokevirtual 179	android/media/MediaCodecList:findDecoderForFormat	(Landroid/media/MediaFormat;)Ljava/lang/String;
    //   211: astore_1
    //   212: new 145	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   219: astore_2
    //   220: aload_2
    //   221: ldc 181
    //   223: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload_2
    //   228: aload_1
    //   229: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: ldc 183
    //   236: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: aload 8
    //   243: invokevirtual 184	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   246: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: ldc 158
    //   252: aload_2
    //   253: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 186	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_1
    //   260: ifnull +11 -> 271
    //   263: aload_1
    //   264: invokestatic 192	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   267: astore_1
    //   268: goto +24 -> 292
    //   271: ldc 158
    //   273: ldc 194
    //   275: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   278: aload_0
    //   279: invokespecial 198	com/tencent/liteav/videodecoder/f:e	()V
    //   282: iconst_m1
    //   283: ireturn
    //   284: aload_0
    //   285: getfield 57	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   288: invokestatic 201	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   291: astore_1
    //   292: aload_1
    //   293: aload 8
    //   295: aload_0
    //   296: getfield 73	com/tencent/liteav/videodecoder/f:k	Landroid/view/Surface;
    //   299: aconst_null
    //   300: iconst_0
    //   301: invokevirtual 205	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   304: aload_1
    //   305: iconst_1
    //   306: invokevirtual 208	android/media/MediaCodec:setVideoScalingMode	(I)V
    //   309: aload_1
    //   310: invokevirtual 211	android/media/MediaCodec:start	()V
    //   313: new 145	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   320: astore_2
    //   321: aload_2
    //   322: ldc 213
    //   324: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_2
    //   329: aload_0
    //   330: getfield 71	com/tencent/liteav/videodecoder/f:j	Z
    //   333: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_2
    //   338: ldc 218
    //   340: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_2
    //   345: aload_0
    //   346: getfield 59	com/tencent/liteav/videodecoder/f:d	I
    //   349: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_2
    //   354: ldc 223
    //   356: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: aload_2
    //   361: aload_0
    //   362: getfield 61	com/tencent/liteav/videodecoder/f:e	I
    //   365: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload_2
    //   370: ldc 225
    //   372: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_2
    //   377: aload 8
    //   379: invokevirtual 184	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   382: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: ldc 158
    //   388: aload_2
    //   389: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 165	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload_0
    //   396: aload_1
    //   397: putfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   400: aload_0
    //   401: iconst_0
    //   402: putfield 75	com/tencent/liteav/videodecoder/f:l	I
    //   405: iconst_0
    //   406: ireturn
    //   407: astore 7
    //   409: iconst_4
    //   410: istore 4
    //   412: iconst_0
    //   413: istore 5
    //   415: aload_1
    //   416: astore_2
    //   417: aload 7
    //   419: astore_1
    //   420: goto +115 -> 535
    //   423: astore 7
    //   425: iconst_4
    //   426: istore 4
    //   428: aload_1
    //   429: astore_2
    //   430: aload 7
    //   432: astore_1
    //   433: goto +102 -> 535
    //   436: astore 7
    //   438: iconst_3
    //   439: istore 4
    //   441: aload_1
    //   442: astore_2
    //   443: aload 7
    //   445: astore_1
    //   446: goto +89 -> 535
    //   449: astore 7
    //   451: iconst_2
    //   452: istore 4
    //   454: aload_1
    //   455: astore_2
    //   456: aload 7
    //   458: astore_1
    //   459: goto +76 -> 535
    //   462: astore 7
    //   464: iconst_1
    //   465: istore 4
    //   467: aload_1
    //   468: astore_2
    //   469: aload 7
    //   471: astore_1
    //   472: goto +63 -> 535
    //   475: astore_1
    //   476: aload 7
    //   478: astore_2
    //   479: iload 6
    //   481: istore 4
    //   483: goto +52 -> 535
    //   486: new 145	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   493: astore_1
    //   494: aload_1
    //   495: ldc 227
    //   497: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_1
    //   502: aload 7
    //   504: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload_1
    //   509: ldc 232
    //   511: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_1
    //   516: aload_0
    //   517: getfield 73	com/tencent/liteav/videodecoder/f:k	Landroid/view/Surface;
    //   520: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: ldc 158
    //   526: aload_1
    //   527: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: iconst_m1
    //   534: ireturn
    //   535: aload_2
    //   536: ifnull +50 -> 586
    //   539: aload_2
    //   540: invokevirtual 235	android/media/MediaCodec:release	()V
    //   543: ldc 158
    //   545: ldc 237
    //   547: invokestatic 165	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: goto +36 -> 586
    //   553: new 145	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   560: astore_2
    //   561: aload_2
    //   562: ldc 239
    //   564: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: aload_2
    //   569: aload_1
    //   570: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
    //   573: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: ldc 158
    //   579: aload_2
    //   580: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: new 145	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   593: astore_2
    //   594: aload_2
    //   595: ldc 241
    //   597: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload_2
    //   602: iload 4
    //   604: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_2
    //   609: ldc 243
    //   611: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload_2
    //   616: aload_1
    //   617: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
    //   620: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: ldc 158
    //   626: aload_2
    //   627: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload_1
    //   634: invokevirtual 246	java/lang/Exception:printStackTrace	()V
    //   637: aload_0
    //   638: invokespecial 198	com/tencent/liteav/videodecoder/f:e	()V
    //   641: iload 5
    //   643: ireturn
    //   644: astore_2
    //   645: goto -92 -> 553
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	648	0	this	f
    //   0	648	1	paramByteBuffer1	ByteBuffer
    //   0	648	2	paramByteBuffer2	ByteBuffer
    //   0	648	3	paramBoolean	boolean
    //   105	498	4	i1	int
    //   10	632	5	i2	int
    //   7	473	6	i3	int
    //   4	9	7	localMediaCodec	MediaCodec
    //   407	11	7	localException1	Exception
    //   423	8	7	localException2	Exception
    //   436	8	7	localException3	Exception
    //   449	8	7	localException4	Exception
    //   462	41	7	localException5	Exception
    //   69	309	8	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   107	140	149	java/lang/Exception
    //   395	405	407	java/lang/Exception
    //   313	395	423	java/lang/Exception
    //   309	313	436	java/lang/Exception
    //   304	309	449	java/lang/Exception
    //   292	304	462	java/lang/Exception
    //   17	24	475	java/lang/Exception
    //   27	45	475	java/lang/Exception
    //   48	54	475	java/lang/Exception
    //   54	71	475	java/lang/Exception
    //   75	83	475	java/lang/Exception
    //   87	95	475	java/lang/Exception
    //   95	100	475	java/lang/Exception
    //   150	183	475	java/lang/Exception
    //   183	259	475	java/lang/Exception
    //   263	268	475	java/lang/Exception
    //   271	282	475	java/lang/Exception
    //   284	292	475	java/lang/Exception
    //   486	533	475	java/lang/Exception
    //   539	550	644	java/lang/Exception
  }
  
  private void a()
  {
    MediaCodec localMediaCodec = this.b;
    this.b = null;
    if (localMediaCodec != null)
    {
      f.1 local1 = new f.1(this, localMediaCodec);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DecoderReleaseThread-");
      localStringBuilder.append(localMediaCodec.hashCode());
      new Thread(null, local1, localStringBuilder.toString()).start();
    }
    this.m.clear();
    this.f = 0L;
    this.h = true;
    this.i = false;
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    MediaCodec localMediaCodec = this.b;
    if (localMediaCodec != null) {
      try
      {
        localMediaCodec.releaseOutputBuffer(paramInt1, true);
      }
      catch (Exception localException1)
      {
        TXCLog.e("MediaCodecDecoder", "decode: releaseOutputBuffer exception!!", localException1);
      }
    }
    if ((this.a.flags & 0x4) != 0) {
      TXCLog.i("MediaCodecDecoder", "output EOS");
    }
    try
    {
      if (this.r != null) {
        this.r.onDecodeFrame(null, this.d, this.e, paramLong1, paramLong2, paramInt2);
      }
    }
    catch (Exception localException2)
    {
      TXCLog.e("MediaCodecDecoder", "onDecodeFrame failed.", localException2);
    }
    d();
  }
  
  private void a(TXSNALPacket paramTXSNALPacket)
  {
    if (!this.t) {
      return;
    }
    int i1;
    if (paramTXSNALPacket.nalType == 0) {
      i1 = 0;
    }
    for (;;)
    {
      int i2;
      try
      {
        if (i1 >= paramTXSNALPacket.nalData.length) {
          break label394;
        }
        if ((paramTXSNALPacket.nalData[i1] == 0) && (paramTXSNALPacket.nalData[(i1 + 1)] == 0) && (paramTXSNALPacket.nalData[(i1 + 2)] == 0) && (paramTXSNALPacket.nalData[(i1 + 3)] == 1))
        {
          arrayOfByte1 = paramTXSNALPacket.nalData;
          i2 = i1 + 4;
          if ((arrayOfByte1[i2] & 0x1F) == 7)
          {
            i1 = i2;
            continue;
          }
        }
        if ((paramTXSNALPacket.nalData[i1] != 0) || (paramTXSNALPacket.nalData[(i1 + 1)] != 0) || (paramTXSNALPacket.nalData[(i1 + 2)] != 0)) {
          break label385;
        }
        byte[] arrayOfByte1 = paramTXSNALPacket.nalData;
        i2 = i1 + 3;
        if ((arrayOfByte1[i2] & 0x1F) != 7) {
          break label385;
        }
        i1 = i2;
        if (i1 >= 0)
        {
          int i4 = paramTXSNALPacket.nalData.length - i1;
          i2 = i1;
          i3 = i4;
          if (i2 < paramTXSNALPacket.nalData.length)
          {
            if ((paramTXSNALPacket.nalData[i2] == 0) && (paramTXSNALPacket.nalData[(i2 + 1)] == 0) && (paramTXSNALPacket.nalData[(i2 + 2)] == 1)) {
              break label399;
            }
            if ((paramTXSNALPacket.nalData[i2] != 0) || (paramTXSNALPacket.nalData[(i2 + 1)] != 0) || (paramTXSNALPacket.nalData[(i2 + 2)] != 0) || (paramTXSNALPacket.nalData[(i2 + 3)] != 1)) {
              break label407;
            }
            break label399;
          }
          arrayOfByte1 = new byte[i3];
          System.arraycopy(paramTXSNALPacket.nalData, i1, arrayOfByte1, 0, i3);
          arrayOfByte1 = this.s.a(arrayOfByte1);
          if (arrayOfByte1 != null)
          {
            byte[] arrayOfByte2 = new byte[paramTXSNALPacket.nalData.length + arrayOfByte1.length - i3];
            if (i1 > 0) {
              System.arraycopy(paramTXSNALPacket.nalData, 0, arrayOfByte2, 0, i1);
            }
            System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i1, arrayOfByte1.length);
            System.arraycopy(paramTXSNALPacket.nalData, i1 + i3, arrayOfByte2, arrayOfByte1.length + i1, paramTXSNALPacket.nalData.length - i3 - i1);
            paramTXSNALPacket.nalData = arrayOfByte2;
            return;
          }
        }
      }
      catch (Exception paramTXSNALPacket)
      {
        TXCLog.e("MediaCodecDecoder", "modify dec buffer error ", paramTXSNALPacket);
      }
      return;
      label385:
      i1 = i1 + 1 + 1;
      continue;
      label394:
      i1 = -1;
      continue;
      label399:
      int i3 = i2 - i1;
      continue;
      label407:
      i2 += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Video][Decoder] nal data format changed, from:");
      boolean bool = this.j;
      String str = "h265";
      if (bool) {
        localObject = "h265";
      } else {
        localObject = "h264";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" to:");
      if (paramBoolean) {
        localObject = str;
      } else {
        localObject = "h264";
      }
      localStringBuilder.append((String)localObject);
      TXCLog.i("MediaCodecDecoder", localStringBuilder.toString());
      this.j = paramBoolean;
      if ((this.j) && (!e.b(this.d, this.e, 20)))
      {
        a();
        e();
        return;
      }
      a();
      a(null, null, this.j);
      Object localObject = this.r;
      if (localObject != null) {
        ((g)localObject).onDecoderChange(this.c, this.j);
      }
    }
  }
  
  @TargetApi(16)
  private void b()
  {
    MediaCodec localMediaCodec = this.b;
    if (localMediaCodec == null)
    {
      TXCLog.e("MediaCodecDecoder", "null decoder");
      return;
    }
    TXSNALPacket localTXSNALPacket = (TXSNALPacket)this.m.get(0);
    long l2;
    long l1;
    Object localObject1;
    int i1;
    if ((localTXSNALPacket != null) && (localTXSNALPacket.nalData.length != 0))
    {
      l2 = TXCTimeUtil.getTimeTick();
      l3 = this.o;
      l1 = 0L;
      if (l3 == 0L) {
        this.o = l2;
      }
      localObject1 = null;
      StringBuilder localStringBuilder;
      try
      {
        ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
        localObject1 = arrayOfByteBuffer;
      }
      catch (Exception localException3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode: getInputBuffers Exception!! ");
        localStringBuilder.append(localException3.toString());
        TXCLog.e("MediaCodecDecoder", localStringBuilder.toString());
      }
      if ((localObject1 != null) && (localObject1.length != 0))
      {
        try
        {
          i1 = localMediaCodec.dequeueInputBuffer(10000L);
        }
        catch (Exception localException4)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("decode: dequeueInputBuffer Exception!! ");
          localStringBuilder.append(localException4.toString());
          TXCLog.e("MediaCodecDecoder", localStringBuilder.toString());
          i1 = -10000;
        }
        if (i1 >= 0) {
          localObject1[i1].put(localTXSNALPacket.nalData);
        }
      }
    }
    try
    {
      localMediaCodec.queueInputBuffer(i1, 0, localTXSNALPacket.nalData.length, TimeUnit.MILLISECONDS.toMicros(localTXSNALPacket.pts), 0);
      this.m.remove(0);
    }
    catch (Exception localException2)
    {
      label259:
      Object localObject3;
      Object localObject2;
      break label259;
    }
    f();
    if (this.f == 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decode: input buffer available, dequeueInputBuffer index: ");
      ((StringBuilder)localObject1).append(i1);
      TXCLog.w("MediaCodecDecoder", ((StringBuilder)localObject1).toString());
      break label318;
      TXCLog.w("MediaCodecDecoder", "decode: input buffer not available, dequeueInputBuffer failed");
    }
    try
    {
      label318:
      i1 = localMediaCodec.dequeueOutputBuffer(this.a, 10000L);
    }
    catch (Exception localException1)
    {
      f();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("decode: dequeueOutputBuffer exception!!");
      ((StringBuilder)localObject3).append(localException1);
      TXCLog.e("MediaCodecDecoder", ((StringBuilder)localObject3).toString());
      i1 = -10000;
    }
    if (i1 >= 0)
    {
      l3 = TimeUnit.MICROSECONDS.toMillis(this.a.presentationTimeUs);
      a(i1, l3, l3, localTXSNALPacket.rotation);
      this.l = 0;
    }
    else if (i1 == -1)
    {
      try
      {
        Thread.sleep(10L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("decode: no output from decoder available when timeout fail count ");
      ((StringBuilder)localObject2).append(this.l);
      TXCLog.i("MediaCodecDecoder", ((StringBuilder)localObject2).toString());
      f();
    }
    else if (i1 == -3)
    {
      TXCLog.i("MediaCodecDecoder", "decode: output buffers changed");
    }
    else if (i1 == -2)
    {
      c();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("decode: unexpected result from decoder.dequeueOutputBuffer: ");
      ((StringBuilder)localObject2).append(i1);
      TXCLog.e("MediaCodecDecoder", ((StringBuilder)localObject2).toString());
    }
    long l3 = TXCTimeUtil.getTimeTick();
    this.n.add(Long.valueOf(l3 - l2));
    if (l3 > this.o + 1000L)
    {
      localObject2 = this.n.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Long)((Iterator)localObject2).next();
        if (((Long)localObject3).longValue() > l1) {
          l1 = ((Long)localObject3).longValue();
        }
      }
      this.n.clear();
      this.o = l3;
      this.p = ((int)(3L * l1));
    }
    return;
    TXCLog.e("MediaCodecDecoder", "decode: getInputBuffers failed");
    return;
    TXCLog.e("MediaCodecDecoder", "decode: empty buffer");
    this.m.remove(0);
  }
  
  private void c()
  {
    Object localObject1 = this.b;
    Object localObject2;
    if (localObject1 != null) {
      try
      {
        localObject1 = ((MediaCodec)localObject1).getOutputFormat();
      }
      catch (Exception localException1)
      {
        TXCLog.e("MediaCodecDecoder", "get decoder's format failed.", localException1);
      }
    } else {
      localObject2 = null;
    }
    if (localObject2 == null)
    {
      TXCLog.e("MediaCodecDecoder", "get decoder's format failed.");
      return;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("decode output format changed: ");
    localStringBuilder2.append(localObject2);
    TXCLog.i("MediaCodecDecoder", localStringBuilder2.toString());
    int i1 = Math.abs(((MediaFormat)localObject2).getInteger("crop-right") - ((MediaFormat)localObject2).getInteger("crop-left"));
    int i2 = Math.abs(((MediaFormat)localObject2).getInteger("crop-bottom") - ((MediaFormat)localObject2).getInteger("crop-top"));
    int i4 = ((MediaFormat)localObject2).getInteger("width");
    int i3 = ((MediaFormat)localObject2).getInteger("height");
    i1 = Math.min(i1 + 1, i4);
    i2 = Math.min(i2 + 1, i3);
    i3 = this.d;
    if (i1 == i3)
    {
      i4 = this.e;
      if (i2 == i4)
      {
        if (!this.h) {
          return;
        }
        this.h = false;
        localObject2 = this.r;
        if (localObject2 == null) {
          return;
        }
        ((g)localObject2).onVideoSizeChange(i3, i4);
        return;
      }
    }
    if ((this.j) && (!e.b(i1, i2, 20)))
    {
      e();
      Monitor.a(2, String.format(Locale.getDefault(), "outputFormatChange: dynamic change resolution but change to a not support resolution: %s, oldwidth = %d,oldheight = %d, newwidth = %d, newheight=", new Object[] { TXCCommonUtil.getDeviceInfo(), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(i1), Integer.valueOf(i2) }), "", 0);
    }
    this.d = i1;
    this.e = i2;
    try
    {
      if (this.r != null) {
        this.r.onVideoSizeChange(this.d, this.e);
      }
    }
    catch (Exception localException2)
    {
      TXCLog.e("MediaCodecDecoder", "onVideoSizeChange failed.", localException2);
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("decode: video size change to w:");
    localStringBuilder1.append(i1);
    localStringBuilder1.append(",h:");
    localStringBuilder1.append(i2);
    TXCLog.i("MediaCodecDecoder", localStringBuilder1.toString());
  }
  
  private void d()
  {
    if (this.f == 0L) {
      TXCLog.w("MediaCodecDecoder", "decode first frame sucess");
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.f;
    if ((l2 > 0L) && (l1 > l2 + 1000L))
    {
      l2 = this.g;
      if ((l1 > 2000L + l2) && (l2 != 0L))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("frame interval[");
        localStringBuilder.append(l1 - this.f);
        localStringBuilder.append("] > ");
        localStringBuilder.append(1000L);
        TXCLog.e("MediaCodecDecoder", localStringBuilder.toString());
        this.g = l1;
      }
    }
    if (this.g == 0L) {
      this.g = l1;
    }
    this.f = l1;
  }
  
  private void e()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void f()
  {
    int i1 = this.l;
    if (i1 >= 40)
    {
      e();
      this.l = 0;
      return;
    }
    this.l = (i1 + 1);
  }
  
  public int GetDecodeCost()
  {
    return this.p;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.d = paramInt1;
      this.e = paramInt2;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decode: init with video size: ");
      localStringBuilder.append(this.d);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.e);
      TXCLog.w("MediaCodecDecoder", localStringBuilder.toString());
    }
  }
  
  public void a(JSONArray paramJSONArray)
  {
    this.q = paramJSONArray;
  }
  
  public int config(Surface paramSurface)
  {
    if (paramSurface == null) {
      return -1;
    }
    this.k = paramSurface;
    return 0;
  }
  
  public void decode(TXSNALPacket paramTXSNALPacket)
  {
    int i1 = paramTXSNALPacket.codecId;
    boolean bool = true;
    if (i1 != 1) {
      bool = false;
    }
    a(bool);
    if (paramTXSNALPacket.codecId == 0) {
      a(paramTXSNALPacket);
    }
    this.m.add(paramTXSNALPacket);
    do
    {
      if (this.m.isEmpty()) {
        break;
      }
      i1 = this.m.size();
      try
      {
        b();
      }
      catch (Exception paramTXSNALPacket)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode: doDecode Exception!! ");
        localStringBuilder.append(paramTXSNALPacket.toString());
        TXCLog.e("MediaCodecDecoder", localStringBuilder.toString());
      }
    } while (i1 != this.m.size());
  }
  
  public void enableLimitDecCache(boolean paramBoolean)
  {
    this.t = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("decode: enable limit dec cache: ");
    localStringBuilder.append(paramBoolean);
    TXCLog.i("MediaCodecDecoder", localStringBuilder.toString());
  }
  
  public void setListener(g paramg)
  {
    this.r = paramg;
  }
  
  public void setNotifyListener(WeakReference<com.tencent.liteav.basic.c.b> paramWeakReference)
  {
    this.u = paramWeakReference;
  }
  
  public int start(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramByteBuffer1, paramByteBuffer2, paramBoolean2);
  }
  
  public void stop()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.f
 * JD-Core Version:    0.7.0.1
 */