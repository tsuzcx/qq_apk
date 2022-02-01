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
  private WeakReference<com.tencent.liteav.basic.b.b> u;
  
  /* Error */
  private int a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_m1
    //   4: istore 5
    //   6: aload_0
    //   7: getfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   10: ifnonnull +441 -> 451
    //   13: aload_0
    //   14: getfield 73	com/tencent/liteav/videodecoder/f:k	Landroid/view/Surface;
    //   17: ifnonnull +6 -> 23
    //   20: goto +431 -> 451
    //   23: aload_0
    //   24: iload_3
    //   25: putfield 71	com/tencent/liteav/videodecoder/f:j	Z
    //   28: aload_0
    //   29: getfield 71	com/tencent/liteav/videodecoder/f:j	Z
    //   32: ifeq +12 -> 44
    //   35: aload_0
    //   36: ldc 101
    //   38: putfield 57	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   41: goto +9 -> 50
    //   44: aload_0
    //   45: ldc 55
    //   47: putfield 57	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   50: aload_0
    //   51: getfield 57	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   54: aload_0
    //   55: getfield 59	com/tencent/liteav/videodecoder/f:d	I
    //   58: aload_0
    //   59: getfield 61	com/tencent/liteav/videodecoder/f:e	I
    //   62: invokestatic 107	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   65: astore 7
    //   67: aload_1
    //   68: ifnull +11 -> 79
    //   71: aload 7
    //   73: ldc 109
    //   75: aload_1
    //   76: invokevirtual 113	android/media/MediaFormat:setByteBuffer	(Ljava/lang/String;Ljava/nio/ByteBuffer;)V
    //   79: aload_2
    //   80: ifnull +11 -> 91
    //   83: aload 7
    //   85: ldc 115
    //   87: aload_2
    //   88: invokevirtual 113	android/media/MediaFormat:setByteBuffer	(Ljava/lang/String;Ljava/nio/ByteBuffer;)V
    //   91: aload_0
    //   92: getfield 88	com/tencent/liteav/videodecoder/f:q	Lorg/json/JSONArray;
    //   95: astore_1
    //   96: aload_1
    //   97: ifnull +82 -> 179
    //   100: iconst_0
    //   101: istore 4
    //   103: iload 4
    //   105: aload_1
    //   106: invokevirtual 121	org/json/JSONArray:length	()I
    //   109: if_icmpge +70 -> 179
    //   112: aload_1
    //   113: iload 4
    //   115: invokevirtual 125	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   118: astore_2
    //   119: aload 7
    //   121: aload_2
    //   122: ldc 127
    //   124: invokevirtual 133	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   127: aload_2
    //   128: ldc 135
    //   130: invokevirtual 139	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   133: invokevirtual 143	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   136: iload 4
    //   138: iconst_1
    //   139: iadd
    //   140: istore 4
    //   142: goto -39 -> 103
    //   145: astore_1
    //   146: new 145	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   153: astore_2
    //   154: aload_2
    //   155: ldc 148
    //   157: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_2
    //   162: aload_1
    //   163: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
    //   166: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: ldc 158
    //   172: aload_2
    //   173: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 165	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: getstatic 170	android/os/Build$VERSION:SDK_INT	I
    //   182: bipush 21
    //   184: if_icmplt +99 -> 283
    //   187: aload_0
    //   188: getfield 71	com/tencent/liteav/videodecoder/f:j	Z
    //   191: ifeq +92 -> 283
    //   194: new 172	android/media/MediaCodecList
    //   197: dup
    //   198: iconst_1
    //   199: invokespecial 175	android/media/MediaCodecList:<init>	(I)V
    //   202: aload 7
    //   204: invokevirtual 179	android/media/MediaCodecList:findDecoderForFormat	(Landroid/media/MediaFormat;)Ljava/lang/String;
    //   207: astore_1
    //   208: new 145	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   215: astore_2
    //   216: aload_2
    //   217: ldc 181
    //   219: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_2
    //   224: aload_1
    //   225: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_2
    //   230: ldc 183
    //   232: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_2
    //   237: aload 7
    //   239: invokevirtual 184	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   242: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: ldc 158
    //   248: aload_2
    //   249: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 186	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aload_1
    //   256: ifnull +14 -> 270
    //   259: aload_0
    //   260: aload_1
    //   261: invokestatic 192	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   264: putfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   267: goto +27 -> 294
    //   270: ldc 158
    //   272: ldc 194
    //   274: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   277: aload_0
    //   278: invokespecial 198	com/tencent/liteav/videodecoder/f:e	()V
    //   281: iconst_m1
    //   282: ireturn
    //   283: aload_0
    //   284: aload_0
    //   285: getfield 57	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   288: invokestatic 201	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   291: putfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   294: aload_0
    //   295: getfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   298: aload 7
    //   300: aload_0
    //   301: getfield 73	com/tencent/liteav/videodecoder/f:k	Landroid/view/Surface;
    //   304: aconst_null
    //   305: iconst_0
    //   306: invokevirtual 205	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   309: aload_0
    //   310: getfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   313: iconst_1
    //   314: invokevirtual 208	android/media/MediaCodec:setVideoScalingMode	(I)V
    //   317: aload_0
    //   318: getfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   321: invokevirtual 211	android/media/MediaCodec:start	()V
    //   324: new 145	java/lang/StringBuilder
    //   327: dup
    //   328: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   331: astore_1
    //   332: aload_1
    //   333: ldc 213
    //   335: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload_1
    //   340: aload_0
    //   341: getfield 71	com/tencent/liteav/videodecoder/f:j	Z
    //   344: invokevirtual 216	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload_1
    //   349: ldc 218
    //   351: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload_1
    //   356: aload_0
    //   357: getfield 59	com/tencent/liteav/videodecoder/f:d	I
    //   360: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload_1
    //   365: ldc 223
    //   367: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload_1
    //   372: aload_0
    //   373: getfield 61	com/tencent/liteav/videodecoder/f:e	I
    //   376: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_1
    //   381: ldc 225
    //   383: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_1
    //   388: aload 7
    //   390: invokevirtual 184	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   393: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: ldc 158
    //   399: aload_1
    //   400: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 165	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload_0
    //   407: iconst_0
    //   408: putfield 75	com/tencent/liteav/videodecoder/f:l	I
    //   411: iconst_0
    //   412: ireturn
    //   413: astore_1
    //   414: iconst_4
    //   415: istore 4
    //   417: iconst_0
    //   418: istore 5
    //   420: goto +87 -> 507
    //   423: astore_1
    //   424: iconst_4
    //   425: istore 4
    //   427: goto +80 -> 507
    //   430: astore_1
    //   431: iconst_3
    //   432: istore 4
    //   434: goto +73 -> 507
    //   437: astore_1
    //   438: iconst_2
    //   439: istore 4
    //   441: goto +66 -> 507
    //   444: astore_1
    //   445: iconst_1
    //   446: istore 4
    //   448: goto +59 -> 507
    //   451: new 145	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   458: astore_1
    //   459: aload_1
    //   460: ldc 227
    //   462: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload_1
    //   467: aload_0
    //   468: getfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   471: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload_1
    //   476: ldc 232
    //   478: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload_1
    //   483: aload_0
    //   484: getfield 73	com/tencent/liteav/videodecoder/f:k	Landroid/view/Surface;
    //   487: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: ldc 158
    //   493: aload_1
    //   494: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: iconst_m1
    //   501: ireturn
    //   502: astore_1
    //   503: iload 6
    //   505: istore 4
    //   507: aload_0
    //   508: getfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   511: astore_2
    //   512: aload_2
    //   513: ifnull +69 -> 582
    //   516: aload_2
    //   517: invokevirtual 235	android/media/MediaCodec:release	()V
    //   520: ldc 158
    //   522: ldc 237
    //   524: invokestatic 165	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: aload_0
    //   528: aconst_null
    //   529: putfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   532: goto +50 -> 582
    //   535: astore_1
    //   536: goto +39 -> 575
    //   539: new 145	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   546: astore_2
    //   547: aload_2
    //   548: ldc 239
    //   550: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: aload_2
    //   555: aload_1
    //   556: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
    //   559: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: ldc 158
    //   565: aload_2
    //   566: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   572: goto -45 -> 527
    //   575: aload_0
    //   576: aconst_null
    //   577: putfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   580: aload_1
    //   581: athrow
    //   582: new 145	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   589: astore_2
    //   590: aload_2
    //   591: ldc 241
    //   593: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload_2
    //   598: iload 4
    //   600: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   603: pop
    //   604: aload_2
    //   605: ldc 243
    //   607: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload_2
    //   612: aload_1
    //   613: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
    //   616: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: ldc 158
    //   622: aload_2
    //   623: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload_1
    //   630: invokevirtual 246	java/lang/Exception:printStackTrace	()V
    //   633: aload_0
    //   634: invokespecial 198	com/tencent/liteav/videodecoder/f:e	()V
    //   637: iload 5
    //   639: ireturn
    //   640: astore_2
    //   641: goto -102 -> 539
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	f
    //   0	644	1	paramByteBuffer1	ByteBuffer
    //   0	644	2	paramByteBuffer2	ByteBuffer
    //   0	644	3	paramBoolean	boolean
    //   101	498	4	i1	int
    //   4	634	5	i2	int
    //   1	503	6	i3	int
    //   65	324	7	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   103	136	145	java/lang/Exception
    //   406	411	413	java/lang/Exception
    //   324	406	423	java/lang/Exception
    //   317	324	430	java/lang/Exception
    //   309	317	437	java/lang/Exception
    //   294	309	444	java/lang/Exception
    //   6	20	502	java/lang/Exception
    //   23	41	502	java/lang/Exception
    //   44	50	502	java/lang/Exception
    //   50	67	502	java/lang/Exception
    //   71	79	502	java/lang/Exception
    //   83	91	502	java/lang/Exception
    //   91	96	502	java/lang/Exception
    //   146	179	502	java/lang/Exception
    //   179	255	502	java/lang/Exception
    //   259	267	502	java/lang/Exception
    //   270	281	502	java/lang/Exception
    //   283	294	502	java/lang/Exception
    //   451	500	502	java/lang/Exception
    //   516	527	535	finally
    //   539	572	535	finally
    //   516	527	640	java/lang/Exception
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +260 -> 266
    //   9: aload_1
    //   10: invokevirtual 249	android/media/MediaCodec:stop	()V
    //   13: ldc 158
    //   15: ldc 251
    //   17: invokestatic 165	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   24: invokevirtual 235	android/media/MediaCodec:release	()V
    //   27: ldc 158
    //   29: ldc 253
    //   31: invokestatic 165	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   39: goto +227 -> 266
    //   42: astore_1
    //   43: goto +40 -> 83
    //   46: astore_1
    //   47: new 145	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   54: astore_2
    //   55: aload_2
    //   56: ldc 255
    //   58: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
    //   67: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: ldc 158
    //   73: aload_2
    //   74: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: goto -46 -> 34
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   88: aload_1
    //   89: athrow
    //   90: astore_1
    //   91: goto +103 -> 194
    //   94: astore_1
    //   95: new 145	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   102: astore_2
    //   103: aload_2
    //   104: ldc_w 257
    //   107: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: aload_1
    //   113: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
    //   116: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: ldc 158
    //   122: aload_2
    //   123: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: getfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   133: invokevirtual 235	android/media/MediaCodec:release	()V
    //   136: ldc 158
    //   138: ldc 253
    //   140: invokestatic 165	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: goto -109 -> 34
    //   146: astore_1
    //   147: goto +40 -> 187
    //   150: astore_1
    //   151: new 145	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   158: astore_2
    //   159: aload_2
    //   160: ldc 255
    //   162: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_2
    //   167: aload_1
    //   168: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
    //   171: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: ldc 158
    //   177: aload_2
    //   178: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: goto -150 -> 34
    //   187: aload_0
    //   188: aconst_null
    //   189: putfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   192: aload_1
    //   193: athrow
    //   194: aload_0
    //   195: getfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   198: invokevirtual 235	android/media/MediaCodec:release	()V
    //   201: ldc 158
    //   203: ldc 253
    //   205: invokestatic 165	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_0
    //   209: aconst_null
    //   210: putfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   213: goto +44 -> 257
    //   216: astore_1
    //   217: goto +42 -> 259
    //   220: astore_2
    //   221: new 145	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   228: astore_3
    //   229: aload_3
    //   230: ldc 255
    //   232: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_3
    //   237: aload_2
    //   238: invokevirtual 156	java/lang/Exception:toString	()Ljava/lang/String;
    //   241: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: ldc 158
    //   247: aload_3
    //   248: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 196	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: goto -46 -> 208
    //   257: aload_1
    //   258: athrow
    //   259: aload_0
    //   260: aconst_null
    //   261: putfield 53	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   264: aload_1
    //   265: athrow
    //   266: aload_0
    //   267: getfield 80	com/tencent/liteav/videodecoder/f:m	Ljava/util/ArrayList;
    //   270: invokevirtual 260	java/util/ArrayList:clear	()V
    //   273: aload_0
    //   274: lconst_0
    //   275: putfield 63	com/tencent/liteav/videodecoder/f:f	J
    //   278: aload_0
    //   279: iconst_1
    //   280: putfield 67	com/tencent/liteav/videodecoder/f:h	Z
    //   283: aload_0
    //   284: iconst_0
    //   285: putfield 69	com/tencent/liteav/videodecoder/f:i	Z
    //   288: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	f
    //   4	6	1	localMediaCodec	MediaCodec
    //   42	1	1	localObject1	Object
    //   46	43	1	localException1	Exception
    //   90	1	1	localObject2	Object
    //   94	19	1	localException2	Exception
    //   146	1	1	localObject3	Object
    //   150	43	1	localException3	Exception
    //   216	49	1	localObject4	Object
    //   54	124	2	localStringBuilder1	StringBuilder
    //   220	18	2	localException4	Exception
    //   228	20	3	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   20	34	42	finally
    //   47	80	42	finally
    //   20	34	46	java/lang/Exception
    //   9	20	90	finally
    //   95	129	90	finally
    //   9	20	94	java/lang/Exception
    //   129	143	146	finally
    //   151	184	146	finally
    //   129	143	150	java/lang/Exception
    //   194	208	216	finally
    //   221	254	216	finally
    //   194	208	220	java/lang/Exception
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    this.b.releaseOutputBuffer(paramInt1, true);
    if ((this.a.flags & 0x4) != 0) {
      TXCLog.i("MediaCodecDecoder", "output EOS");
    }
    try
    {
      if (this.r != null) {
        this.r.onDecodeFrame(null, this.d, this.e, paramLong1, paramLong2, paramInt2);
      }
    }
    catch (Exception localException)
    {
      TXCLog.e("MediaCodecDecoder", "onDecodeFrame failed.", localException);
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
    if (this.b == null)
    {
      TXCLog.e("MediaCodecDecoder", "null decoder");
      return;
    }
    TXSNALPacket localTXSNALPacket = (TXSNALPacket)this.m.get(0);
    long l3;
    long l1;
    Object localObject1;
    int i1;
    if ((localTXSNALPacket != null) && (localTXSNALPacket.nalData.length != 0))
    {
      l3 = TXCTimeUtil.getTimeTick();
      l2 = this.o;
      l1 = 0L;
      if (l2 == 0L) {
        this.o = l3;
      }
      localObject1 = null;
      StringBuilder localStringBuilder;
      try
      {
        ByteBuffer[] arrayOfByteBuffer = this.b.getInputBuffers();
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
          i1 = this.b.dequeueInputBuffer(10000L);
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
      this.b.queueInputBuffer(i1, 0, localTXSNALPacket.nalData.length, localTXSNALPacket.pts, 0);
      this.m.remove(0);
    }
    catch (Exception localException2)
    {
      label255:
      Object localObject3;
      Object localObject2;
      break label255;
    }
    f();
    if (this.f == 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decode: input buffer available, dequeueInputBuffer index: ");
      ((StringBuilder)localObject1).append(i1);
      TXCLog.w("MediaCodecDecoder", ((StringBuilder)localObject1).toString());
      break label314;
      TXCLog.w("MediaCodecDecoder", "decode: input buffer not available, dequeueInputBuffer failed");
    }
    try
    {
      label314:
      i1 = this.b.dequeueOutputBuffer(this.a, 10000L);
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
      a(i1, this.a.presentationTimeUs, this.a.presentationTimeUs, localTXSNALPacket.rotation);
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
    long l2 = TXCTimeUtil.getTimeTick();
    this.n.add(Long.valueOf(l2 - l3));
    if (l2 > this.o + 1000L)
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
      this.o = l2;
      this.p = ((int)(l1 * 3L));
    }
    return;
    TXCLog.e("MediaCodecDecoder", "decode: getInputBuffers failed");
    return;
    TXCLog.e("MediaCodecDecoder", "decode: empty buffer");
    this.m.remove(0);
  }
  
  private void c()
  {
    Object localObject = this.b.getOutputFormat();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("decode output format changed: ");
    localStringBuilder2.append(localObject);
    TXCLog.i("MediaCodecDecoder", localStringBuilder2.toString());
    int i1 = Math.abs(((MediaFormat)localObject).getInteger("crop-right") - ((MediaFormat)localObject).getInteger("crop-left"));
    int i2 = Math.abs(((MediaFormat)localObject).getInteger("crop-bottom") - ((MediaFormat)localObject).getInteger("crop-top"));
    int i4 = ((MediaFormat)localObject).getInteger("width");
    int i3 = ((MediaFormat)localObject).getInteger("height");
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
        localObject = this.r;
        if (localObject == null) {
          return;
        }
        ((g)localObject).onVideoSizeChange(i3, i4);
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
    catch (Exception localException)
    {
      TXCLog.e("MediaCodecDecoder", "onVideoSizeChange failed.", localException);
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    boolean bool;
    if (paramTXSNALPacket.codecId == 1) {
      bool = true;
    } else {
      bool = false;
    }
    a(bool);
    if (paramTXSNALPacket.codecId != 1) {
      a(paramTXSNALPacket);
    }
    this.m.add(paramTXSNALPacket);
    int i1;
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
  
  public void setNotifyListener(WeakReference<com.tencent.liteav.basic.b.b> paramWeakReference)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.f
 * JD-Core Version:    0.7.0.1
 */