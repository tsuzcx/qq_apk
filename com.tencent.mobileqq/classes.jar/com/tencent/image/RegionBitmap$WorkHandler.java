package com.tencent.image;

import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;

final class RegionBitmap$WorkHandler
  extends Handler
{
  public RegionBitmap$WorkHandler(RegionBitmap paramRegionBitmap) {}
  
  public RegionBitmap$WorkHandler(RegionBitmap paramRegionBitmap, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  private void decode(RegionDrawableData paramRegionDrawableData, RegionBitmap.DrawData paramDrawData, int paramInt)
  {
    // Byte code:
    //   0: ldc 30
    //   2: astore 10
    //   4: invokestatic 36	android/os/SystemClock:uptimeMillis	()J
    //   7: lstore 4
    //   9: new 38	android/graphics/Rect
    //   12: dup
    //   13: invokespecial 39	android/graphics/Rect:<init>	()V
    //   16: astore 9
    //   18: aload 9
    //   20: aload_1
    //   21: getfield 45	com/tencent/image/RegionDrawableData:mSourceDensity	I
    //   24: aload_1
    //   25: getfield 48	com/tencent/image/RegionDrawableData:mTargetDensity	I
    //   28: aload_2
    //   29: getfield 54	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   32: invokestatic 60	com/tencent/image/RegionBitmap:regionToDecode	(IILandroid/graphics/Rect;)Landroid/graphics/Rect;
    //   35: invokevirtual 64	android/graphics/Rect:set	(Landroid/graphics/Rect;)V
    //   38: new 66	android/graphics/BitmapFactory$Options
    //   41: dup
    //   42: invokespecial 67	android/graphics/BitmapFactory$Options:<init>	()V
    //   45: astore 14
    //   47: aload 14
    //   49: iload_3
    //   50: putfield 70	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   53: aload_2
    //   54: aload_0
    //   55: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   58: invokestatic 74	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   61: aload 9
    //   63: aload 14
    //   65: invokevirtual 80	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   68: putfield 84	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   71: aload_2
    //   72: getfield 84	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   75: astore_1
    //   76: aload_2
    //   77: aload 14
    //   79: getfield 70	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   82: putfield 87	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   85: aload_1
    //   86: ifnull +37 -> 123
    //   89: aload_1
    //   90: invokevirtual 93	android/graphics/Bitmap:isRecycled	()Z
    //   93: ifne +30 -> 123
    //   96: aload_0
    //   97: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   100: invokestatic 97	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   103: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   106: checkcast 105	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   109: astore 10
    //   111: aload 10
    //   113: ifnull +10 -> 123
    //   116: aload 10
    //   118: invokeinterface 108 1 0
    //   123: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   126: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   129: invokeinterface 125 1 0
    //   134: ifeq +1687 -> 1821
    //   137: aload_1
    //   138: ifnonnull +20 -> 158
    //   141: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   144: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   147: ldc 127
    //   149: iconst_2
    //   150: ldc 129
    //   152: invokeinterface 133 4 0
    //   157: return
    //   158: invokestatic 36	android/os/SystemClock:uptimeMillis	()J
    //   161: lstore 6
    //   163: new 135	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   170: astore_1
    //   171: new 135	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   178: astore 10
    //   180: aload 10
    //   182: ldc 138
    //   184: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 10
    //   190: lload 6
    //   192: lload 4
    //   194: lsub
    //   195: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 10
    //   201: ldc 147
    //   203: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 10
    //   209: iload_3
    //   210: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 10
    //   216: ldc 152
    //   218: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_1
    //   223: aload 10
    //   225: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: new 135	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   239: astore 10
    //   241: aload 10
    //   243: ldc 158
    //   245: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 10
    //   251: aload 9
    //   253: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 10
    //   259: ldc 152
    //   261: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_1
    //   266: aload 10
    //   268: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: new 135	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   282: astore 10
    //   284: aload 10
    //   286: ldc 163
    //   288: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 10
    //   294: aload_2
    //   295: getfield 87	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   298: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 10
    //   304: ldc 30
    //   306: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 10
    //   312: aload_2
    //   313: getfield 54	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   316: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 10
    //   322: ldc 152
    //   324: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_1
    //   329: aload 10
    //   331: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: new 135	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   345: astore_2
    //   346: aload_2
    //   347: ldc 165
    //   349: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_2
    //   354: aload 9
    //   356: invokevirtual 169	android/graphics/Rect:width	()I
    //   359: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload_2
    //   364: ldc 171
    //   366: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload_2
    //   371: aload 9
    //   373: invokevirtual 174	android/graphics/Rect:height	()I
    //   376: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_2
    //   381: ldc 152
    //   383: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_1
    //   388: aload_2
    //   389: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   399: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   402: ldc 127
    //   404: iconst_2
    //   405: aload_1
    //   406: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokeinterface 133 4 0
    //   414: return
    //   415: astore 12
    //   417: ldc 165
    //   419: astore 13
    //   421: aload 9
    //   423: astore 11
    //   425: aload 10
    //   427: astore_1
    //   428: aload 13
    //   430: astore 9
    //   432: aload 12
    //   434: astore 10
    //   436: goto +1417 -> 1853
    //   439: astore_1
    //   440: aload_2
    //   441: aconst_null
    //   442: putfield 84	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   445: new 135	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   452: astore 10
    //   454: new 135	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   461: astore 11
    //   463: aload 11
    //   465: aload_0
    //   466: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   469: invokestatic 74	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   472: invokevirtual 177	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   475: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 11
    //   481: ldc 179
    //   483: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 11
    //   489: aload_0
    //   490: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   493: invokestatic 74	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   496: invokevirtual 182	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   499: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload 11
    //   505: ldc 152
    //   507: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload 10
    //   513: aload 11
    //   515: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   525: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   528: invokeinterface 125 1 0
    //   533: ifeq +18 -> 551
    //   536: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   539: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   542: ldc 127
    //   544: iconst_1
    //   545: aload_1
    //   546: invokeinterface 186 4 0
    //   551: aload_2
    //   552: getfield 84	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   555: astore_1
    //   556: aload_2
    //   557: aload 14
    //   559: getfield 70	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   562: putfield 87	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   565: aload_1
    //   566: ifnull +37 -> 603
    //   569: aload_1
    //   570: invokevirtual 93	android/graphics/Bitmap:isRecycled	()Z
    //   573: ifne +30 -> 603
    //   576: aload_0
    //   577: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   580: invokestatic 97	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   583: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   586: checkcast 105	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   589: astore 10
    //   591: aload 10
    //   593: ifnull +10 -> 603
    //   596: aload 10
    //   598: invokeinterface 108 1 0
    //   603: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   606: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   609: invokeinterface 125 1 0
    //   614: ifeq +1207 -> 1821
    //   617: aload_1
    //   618: ifnonnull +20 -> 638
    //   621: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   624: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   627: ldc 127
    //   629: iconst_2
    //   630: ldc 129
    //   632: invokeinterface 133 4 0
    //   637: return
    //   638: invokestatic 36	android/os/SystemClock:uptimeMillis	()J
    //   641: lstore 6
    //   643: new 135	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   650: astore_1
    //   651: new 135	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   658: astore 10
    //   660: aload 10
    //   662: ldc 138
    //   664: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 10
    //   670: lload 6
    //   672: lload 4
    //   674: lsub
    //   675: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload 10
    //   681: ldc 147
    //   683: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload 10
    //   689: iload_3
    //   690: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload 10
    //   696: ldc 152
    //   698: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload_1
    //   703: aload 10
    //   705: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: new 135	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   719: astore 10
    //   721: aload 10
    //   723: ldc 158
    //   725: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: pop
    //   729: aload 10
    //   731: aload 9
    //   733: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   736: pop
    //   737: aload 10
    //   739: ldc 152
    //   741: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload_1
    //   746: aload 10
    //   748: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: new 135	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   762: astore 10
    //   764: aload 10
    //   766: ldc 163
    //   768: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: aload 10
    //   774: aload_2
    //   775: getfield 87	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   778: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   781: pop
    //   782: aload 10
    //   784: ldc 30
    //   786: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload 10
    //   792: aload_2
    //   793: getfield 54	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   796: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: aload 10
    //   802: ldc 152
    //   804: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: pop
    //   808: aload_1
    //   809: aload 10
    //   811: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: new 135	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   825: astore_2
    //   826: aload_2
    //   827: ldc 165
    //   829: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: aload_2
    //   834: aload 9
    //   836: invokevirtual 169	android/graphics/Rect:width	()I
    //   839: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   842: pop
    //   843: aload_2
    //   844: ldc 171
    //   846: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: pop
    //   850: aload_2
    //   851: aload 9
    //   853: invokevirtual 174	android/graphics/Rect:height	()I
    //   856: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: aload_2
    //   861: ldc 152
    //   863: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: pop
    //   867: aload_1
    //   868: aload_2
    //   869: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: pop
    //   876: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   879: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   882: ldc 127
    //   884: iconst_2
    //   885: aload_1
    //   886: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokeinterface 133 4 0
    //   894: return
    //   895: astore 10
    //   897: ldc 30
    //   899: astore_1
    //   900: ldc 165
    //   902: astore 12
    //   904: aload 9
    //   906: astore 11
    //   908: aload 12
    //   910: astore 9
    //   912: goto +941 -> 1853
    //   915: astore 10
    //   917: goto +5 -> 922
    //   920: astore 10
    //   922: ldc 30
    //   924: astore_1
    //   925: ldc 165
    //   927: astore 12
    //   929: aload 9
    //   931: astore 11
    //   933: aload 12
    //   935: astore 9
    //   937: goto +916 -> 1853
    //   940: ldc 165
    //   942: astore 13
    //   944: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   947: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   950: invokeinterface 125 1 0
    //   955: ifeq +63 -> 1018
    //   958: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   961: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   964: astore_1
    //   965: new 135	java/lang/StringBuilder
    //   968: dup
    //   969: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   972: astore 11
    //   974: aload 11
    //   976: ldc 188
    //   978: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: pop
    //   982: aload 11
    //   984: aload 14
    //   986: getfield 70	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   989: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   992: pop
    //   993: aload_1
    //   994: ldc 127
    //   996: iconst_2
    //   997: aload 11
    //   999: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1002: invokeinterface 133 4 0
    //   1007: goto +11 -> 1018
    //   1010: astore 12
    //   1012: aload 10
    //   1014: astore_1
    //   1015: goto +44 -> 1059
    //   1018: invokestatic 193	java/lang/System:gc	()V
    //   1021: aload 14
    //   1023: aload 14
    //   1025: getfield 70	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1028: iconst_1
    //   1029: ishl
    //   1030: putfield 70	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1033: aload_2
    //   1034: aload_0
    //   1035: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   1038: invokestatic 74	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   1041: aload 9
    //   1043: aload 14
    //   1045: invokevirtual 80	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1048: putfield 84	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   1051: goto +45 -> 1096
    //   1054: astore 12
    //   1056: ldc 30
    //   1058: astore_1
    //   1059: ldc 165
    //   1061: astore 13
    //   1063: goto +319 -> 1382
    //   1066: astore_1
    //   1067: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1070: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1073: invokeinterface 125 1 0
    //   1078: ifeq +18 -> 1096
    //   1081: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1084: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1087: ldc 127
    //   1089: iconst_1
    //   1090: aload_1
    //   1091: invokeinterface 186 4 0
    //   1096: aload_2
    //   1097: getfield 84	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   1100: astore_1
    //   1101: aload_2
    //   1102: aload 14
    //   1104: getfield 70	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1107: putfield 87	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1110: aload_1
    //   1111: ifnull +37 -> 1148
    //   1114: aload_1
    //   1115: invokevirtual 93	android/graphics/Bitmap:isRecycled	()Z
    //   1118: ifne +30 -> 1148
    //   1121: aload_0
    //   1122: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   1125: invokestatic 97	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   1128: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1131: checkcast 105	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   1134: astore 10
    //   1136: aload 10
    //   1138: ifnull +10 -> 1148
    //   1141: aload 10
    //   1143: invokeinterface 108 1 0
    //   1148: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1151: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1154: invokeinterface 125 1 0
    //   1159: ifeq +662 -> 1821
    //   1162: aload_1
    //   1163: ifnonnull +6 -> 1169
    //   1166: goto -545 -> 621
    //   1169: invokestatic 36	android/os/SystemClock:uptimeMillis	()J
    //   1172: lstore 6
    //   1174: new 135	java/lang/StringBuilder
    //   1177: dup
    //   1178: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1181: astore_1
    //   1182: new 135	java/lang/StringBuilder
    //   1185: dup
    //   1186: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1189: astore 10
    //   1191: aload 10
    //   1193: ldc 138
    //   1195: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: pop
    //   1199: aload 10
    //   1201: lload 6
    //   1203: lload 4
    //   1205: lsub
    //   1206: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1209: pop
    //   1210: aload 10
    //   1212: ldc 147
    //   1214: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: pop
    //   1218: aload 10
    //   1220: iload_3
    //   1221: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1224: pop
    //   1225: aload 10
    //   1227: ldc 152
    //   1229: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: pop
    //   1233: aload_1
    //   1234: aload 10
    //   1236: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1239: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: pop
    //   1243: new 135	java/lang/StringBuilder
    //   1246: dup
    //   1247: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1250: astore 10
    //   1252: aload 10
    //   1254: ldc 158
    //   1256: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: pop
    //   1260: aload 10
    //   1262: aload 9
    //   1264: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1267: pop
    //   1268: aload 10
    //   1270: ldc 152
    //   1272: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: pop
    //   1276: aload_1
    //   1277: aload 10
    //   1279: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1282: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: pop
    //   1286: new 135	java/lang/StringBuilder
    //   1289: dup
    //   1290: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1293: astore 10
    //   1295: aload 10
    //   1297: ldc 163
    //   1299: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: pop
    //   1303: aload 10
    //   1305: aload_2
    //   1306: getfield 87	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1309: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1312: pop
    //   1313: aload 10
    //   1315: ldc 30
    //   1317: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: pop
    //   1321: aload 10
    //   1323: aload_2
    //   1324: getfield 54	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   1327: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1330: pop
    //   1331: aload 10
    //   1333: ldc 152
    //   1335: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: aload_1
    //   1340: aload 10
    //   1342: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1345: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: pop
    //   1349: new 135	java/lang/StringBuilder
    //   1352: dup
    //   1353: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1356: astore_2
    //   1357: aload_2
    //   1358: ldc 165
    //   1360: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1363: pop
    //   1364: aload_2
    //   1365: aload 9
    //   1367: invokevirtual 169	android/graphics/Rect:width	()I
    //   1370: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1373: pop
    //   1374: goto -531 -> 843
    //   1377: astore 12
    //   1379: aload 10
    //   1381: astore_1
    //   1382: aload 9
    //   1384: astore 11
    //   1386: aload 13
    //   1388: astore 9
    //   1390: aload 12
    //   1392: astore 10
    //   1394: goto +459 -> 1853
    //   1397: astore_1
    //   1398: ldc 163
    //   1400: astore 10
    //   1402: aload_2
    //   1403: aconst_null
    //   1404: putfield 84	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   1407: new 135	java/lang/StringBuilder
    //   1410: dup
    //   1411: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1414: astore 11
    //   1416: new 135	java/lang/StringBuilder
    //   1419: dup
    //   1420: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1423: astore 12
    //   1425: aload 12
    //   1427: aload_0
    //   1428: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   1431: invokestatic 74	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   1434: invokevirtual 177	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   1437: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1440: pop
    //   1441: aload 12
    //   1443: ldc 179
    //   1445: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: pop
    //   1449: aload 12
    //   1451: aload_0
    //   1452: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   1455: invokestatic 74	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   1458: invokevirtual 182	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   1461: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1464: pop
    //   1465: aload 12
    //   1467: ldc 152
    //   1469: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1472: pop
    //   1473: aload 11
    //   1475: aload 12
    //   1477: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1480: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1483: pop
    //   1484: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1487: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1490: invokeinterface 125 1 0
    //   1495: istore 8
    //   1497: iload 8
    //   1499: ifeq +41 -> 1540
    //   1502: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1505: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1508: ldc 127
    //   1510: iconst_1
    //   1511: aload_1
    //   1512: invokeinterface 186 4 0
    //   1517: goto +23 -> 1540
    //   1520: astore 10
    //   1522: ldc 30
    //   1524: astore_1
    //   1525: ldc 165
    //   1527: astore 12
    //   1529: aload 9
    //   1531: astore 11
    //   1533: aload 12
    //   1535: astore 9
    //   1537: goto +316 -> 1853
    //   1540: aload_2
    //   1541: getfield 84	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   1544: astore_1
    //   1545: aload_2
    //   1546: aload 14
    //   1548: getfield 70	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1551: putfield 87	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1554: aload_1
    //   1555: ifnull +37 -> 1592
    //   1558: aload_1
    //   1559: invokevirtual 93	android/graphics/Bitmap:isRecycled	()Z
    //   1562: ifne +30 -> 1592
    //   1565: aload_0
    //   1566: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   1569: invokestatic 97	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   1572: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1575: checkcast 105	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   1578: astore 11
    //   1580: aload 11
    //   1582: ifnull +10 -> 1592
    //   1585: aload 11
    //   1587: invokeinterface 108 1 0
    //   1592: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1595: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1598: invokeinterface 125 1 0
    //   1603: ifeq +218 -> 1821
    //   1606: aload_1
    //   1607: ifnonnull +6 -> 1613
    //   1610: goto -989 -> 621
    //   1613: invokestatic 36	android/os/SystemClock:uptimeMillis	()J
    //   1616: lstore 6
    //   1618: new 135	java/lang/StringBuilder
    //   1621: dup
    //   1622: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1625: astore_1
    //   1626: new 135	java/lang/StringBuilder
    //   1629: dup
    //   1630: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1633: astore 11
    //   1635: aload 11
    //   1637: ldc 138
    //   1639: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1642: pop
    //   1643: aload 11
    //   1645: lload 6
    //   1647: lload 4
    //   1649: lsub
    //   1650: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1653: pop
    //   1654: aload 11
    //   1656: ldc 147
    //   1658: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1661: pop
    //   1662: aload 11
    //   1664: iload_3
    //   1665: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1668: pop
    //   1669: aload 11
    //   1671: ldc 152
    //   1673: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: pop
    //   1677: aload_1
    //   1678: aload 11
    //   1680: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1683: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: pop
    //   1687: new 135	java/lang/StringBuilder
    //   1690: dup
    //   1691: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1694: astore 11
    //   1696: aload 11
    //   1698: ldc 158
    //   1700: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: pop
    //   1704: aload 11
    //   1706: aload 9
    //   1708: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1711: pop
    //   1712: aload 11
    //   1714: ldc 152
    //   1716: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1719: pop
    //   1720: aload_1
    //   1721: aload 11
    //   1723: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1726: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: pop
    //   1730: new 135	java/lang/StringBuilder
    //   1733: dup
    //   1734: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1737: astore 11
    //   1739: aload 11
    //   1741: aload 10
    //   1743: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1746: pop
    //   1747: aload 11
    //   1749: aload_2
    //   1750: getfield 87	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1753: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1756: pop
    //   1757: aload 11
    //   1759: ldc 30
    //   1761: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: pop
    //   1765: aload 11
    //   1767: aload_2
    //   1768: getfield 54	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   1771: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1774: pop
    //   1775: aload 11
    //   1777: ldc 152
    //   1779: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1782: pop
    //   1783: aload_1
    //   1784: aload 11
    //   1786: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1789: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: pop
    //   1793: new 135	java/lang/StringBuilder
    //   1796: dup
    //   1797: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1800: astore_2
    //   1801: aload_2
    //   1802: ldc 165
    //   1804: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1807: pop
    //   1808: aload_2
    //   1809: aload 9
    //   1811: invokevirtual 169	android/graphics/Rect:width	()I
    //   1814: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1817: pop
    //   1818: goto -975 -> 843
    //   1821: return
    //   1822: astore_1
    //   1823: goto +4 -> 1827
    //   1826: astore_1
    //   1827: aload 9
    //   1829: astore 11
    //   1831: goto +8 -> 1839
    //   1834: astore_1
    //   1835: aload 9
    //   1837: astore 11
    //   1839: ldc 30
    //   1841: astore 12
    //   1843: ldc 165
    //   1845: astore 9
    //   1847: aload_1
    //   1848: astore 10
    //   1850: aload 12
    //   1852: astore_1
    //   1853: aload_2
    //   1854: getfield 84	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   1857: astore 12
    //   1859: aload_2
    //   1860: aload 14
    //   1862: getfield 70	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1865: putfield 87	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1868: aload 12
    //   1870: ifnull +38 -> 1908
    //   1873: aload 12
    //   1875: invokevirtual 93	android/graphics/Bitmap:isRecycled	()Z
    //   1878: ifne +30 -> 1908
    //   1881: aload_0
    //   1882: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   1885: invokestatic 97	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   1888: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1891: checkcast 105	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   1894: astore 13
    //   1896: aload 13
    //   1898: ifnull +10 -> 1908
    //   1901: aload 13
    //   1903: invokeinterface 108 1 0
    //   1908: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1911: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1914: invokeinterface 125 1 0
    //   1919: ifeq +288 -> 2207
    //   1922: aload 12
    //   1924: ifnonnull +22 -> 1946
    //   1927: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1930: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1933: ldc 127
    //   1935: iconst_2
    //   1936: ldc 129
    //   1938: invokeinterface 133 4 0
    //   1943: goto +264 -> 2207
    //   1946: invokestatic 36	android/os/SystemClock:uptimeMillis	()J
    //   1949: lstore 6
    //   1951: new 135	java/lang/StringBuilder
    //   1954: dup
    //   1955: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1958: astore 12
    //   1960: new 135	java/lang/StringBuilder
    //   1963: dup
    //   1964: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   1967: astore 13
    //   1969: aload 13
    //   1971: ldc 138
    //   1973: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1976: pop
    //   1977: aload 13
    //   1979: lload 6
    //   1981: lload 4
    //   1983: lsub
    //   1984: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1987: pop
    //   1988: aload 13
    //   1990: ldc 147
    //   1992: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: pop
    //   1996: aload 13
    //   1998: iload_3
    //   1999: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2002: pop
    //   2003: aload 13
    //   2005: ldc 152
    //   2007: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2010: pop
    //   2011: aload 12
    //   2013: aload 13
    //   2015: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2018: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: pop
    //   2022: new 135	java/lang/StringBuilder
    //   2025: dup
    //   2026: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   2029: astore 13
    //   2031: aload 13
    //   2033: ldc 158
    //   2035: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2038: pop
    //   2039: aload 13
    //   2041: aload 11
    //   2043: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2046: pop
    //   2047: aload 13
    //   2049: ldc 152
    //   2051: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2054: pop
    //   2055: aload 12
    //   2057: aload 13
    //   2059: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2062: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2065: pop
    //   2066: new 135	java/lang/StringBuilder
    //   2069: dup
    //   2070: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   2073: astore 13
    //   2075: aload 13
    //   2077: ldc 163
    //   2079: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: pop
    //   2083: aload 13
    //   2085: aload_2
    //   2086: getfield 87	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   2089: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2092: pop
    //   2093: aload 13
    //   2095: aload_1
    //   2096: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2099: pop
    //   2100: aload 13
    //   2102: aload_2
    //   2103: getfield 54	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   2106: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2109: pop
    //   2110: aload 13
    //   2112: ldc 152
    //   2114: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2117: pop
    //   2118: aload 12
    //   2120: aload 13
    //   2122: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2125: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2128: pop
    //   2129: new 135	java/lang/StringBuilder
    //   2132: dup
    //   2133: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   2136: astore_1
    //   2137: aload_1
    //   2138: aload 9
    //   2140: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: pop
    //   2144: aload_1
    //   2145: aload 11
    //   2147: invokevirtual 169	android/graphics/Rect:width	()I
    //   2150: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2153: pop
    //   2154: aload_1
    //   2155: ldc 171
    //   2157: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2160: pop
    //   2161: aload_1
    //   2162: aload 11
    //   2164: invokevirtual 174	android/graphics/Rect:height	()I
    //   2167: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2170: pop
    //   2171: aload_1
    //   2172: ldc 152
    //   2174: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2177: pop
    //   2178: aload 12
    //   2180: aload_1
    //   2181: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2184: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2187: pop
    //   2188: getstatic 114	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   2191: getfield 120	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   2194: ldc 127
    //   2196: iconst_2
    //   2197: aload 12
    //   2199: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2202: invokeinterface 133 4 0
    //   2207: goto +6 -> 2213
    //   2210: aload 10
    //   2212: athrow
    //   2213: goto -3 -> 2210
    //   2216: astore_1
    //   2217: goto -1277 -> 940
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2220	0	this	WorkHandler
    //   0	2220	1	paramRegionDrawableData	RegionDrawableData
    //   0	2220	2	paramDrawData	RegionBitmap.DrawData
    //   0	2220	3	paramInt	int
    //   7	1975	4	l1	long
    //   161	1819	6	l2	long
    //   1495	3	8	bool	boolean
    //   16	2123	9	localObject1	Object
    //   2	808	10	localObject2	Object
    //   895	1	10	localObject3	Object
    //   915	1	10	localObject4	Object
    //   920	93	10	localObject5	Object
    //   1134	267	10	localObject6	Object
    //   1520	222	10	str1	java.lang.String
    //   1848	363	10	localRegionDrawableData	RegionDrawableData
    //   423	1740	11	localObject7	Object
    //   415	18	12	localObject8	Object
    //   902	32	12	str2	java.lang.String
    //   1010	1	12	localObject9	Object
    //   1054	1	12	localObject10	Object
    //   1377	14	12	localObject11	Object
    //   1423	775	12	localObject12	Object
    //   419	1702	13	localObject13	Object
    //   45	1816	14	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   53	71	415	finally
    //   53	71	439	java/lang/RuntimeException
    //   463	551	895	finally
    //   454	463	915	finally
    //   440	454	920	finally
    //   965	974	1010	finally
    //   974	1007	1054	finally
    //   1018	1051	1054	finally
    //   1067	1096	1054	finally
    //   1018	1051	1066	java/lang/Exception
    //   944	965	1377	finally
    //   53	71	1397	java/lang/IllegalArgumentException
    //   1502	1517	1520	finally
    //   1425	1497	1822	finally
    //   1416	1425	1826	finally
    //   1402	1416	1834	finally
    //   53	71	2216	java/lang/OutOfMemoryError
  }
  
  private void initRegionDecoder()
  {
    if (((RegionBitmap.access$000(this.this$0) != null) && (!RegionBitmap.access$000(this.this$0).isRecycled())) || (!TextUtils.isEmpty(RegionBitmap.access$100(this.this$0))))
    {
      for (;;)
      {
        try
        {
          try
          {
            RegionBitmap.access$002(this.this$0, BitmapRegionDecoder.newInstance(RegionBitmap.access$100(this.this$0), true));
            if ((!URLDrawable.depImp.mLog.isColorLevel()) || (RegionBitmap.access$000(this.this$0) == null)) {
              continue;
            }
            ILog localILog = URLDrawable.depImp.mLog;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("origin size ");
            localStringBuilder.append(RegionBitmap.access$000(this.this$0).getWidth());
            localStringBuilder.append("x");
            localStringBuilder.append(RegionBitmap.access$000(this.this$0).getHeight());
            localILog.i("RegionDrawable", 2, localStringBuilder.toString());
          }
          catch (Exception localException1)
          {
            if (URLDrawable.depImp.mLog.isColorLevel()) {
              URLDrawable.depImp.mLog.e("RegionBitmap", 2, "Init BitmapRegionDecoder failure", localException1);
            }
            RegionBitmap.access$002(this.this$0, null);
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          Uri localUri;
          continue;
        }
        try
        {
          localUri = Uri.parse(RegionBitmap.access$100(this.this$0));
          RegionBitmap.access$002(this.this$0, BitmapRegionDecoder.newInstance(localUri.getPath(), true));
        }
        catch (Exception localException2)
        {
          if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.e("RegionBitmap", 2, "Init BitmapRegionDecoder failure", localException2);
          }
          RegionBitmap.access$002(this.this$0, null);
        }
      }
      if ((RegionBitmap.access$000(this.this$0) == null) && (URLDrawable.depImp.mLog.isColorLevel())) {
        URLDrawable.depImp.mLog.e("RegionBitmap", 2, "BitmapRegionDecoder object is null");
      }
      return;
    }
    throw new RuntimeException("Image path is null");
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject1;
    int j;
    long l1;
    Object localObject2;
    long l2;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if ((RegionBitmap.access$000(this.this$0) != null) && (!RegionBitmap.access$000(this.this$0).isRecycled()))
      {
        RegionBitmap.access$000(this.this$0).recycle();
        RegionBitmap.access$002(this.this$0, null);
      }
    }
    else
    {
      initRegionDecoder();
      if (RegionBitmap.access$000(this.this$0) == null) {
        return;
      }
      if (!RegionDrawableData.class.isInstance(paramMessage.obj)) {
        return;
      }
      localObject1 = (RegionDrawableData)paramMessage.obj;
      j = ((RegionDrawableData)localObject1).calcSample();
      if (j == 0) {
        return;
      }
      paramMessage = RegionBitmap.access$300(this.this$0);
      i = 0;
      if (paramMessage == null)
      {
        paramMessage = this.this$0;
        RegionBitmap.access$302(paramMessage, new RegionBitmapBlockHelper(new Rect(0, 0, RegionBitmap.access$000(paramMessage).getWidth(), RegionBitmap.access$000(this.this$0).getHeight()), ((RegionDrawableData)localObject1).mSourceDensity, ((RegionDrawableData)localObject1).mTargetDensity));
      }
      l1 = SystemClock.uptimeMillis();
      paramMessage = RegionBitmap.regionToDecode(((RegionDrawableData)localObject1).mSourceDensity, ((RegionDrawableData)localObject1).mTargetDensity, ((RegionDrawableData)localObject1).mShowArea);
      ??? = RegionBitmap.access$300(this.this$0).getDrawDatas((RegionDrawableData)localObject1, j);
      localObject2 = new RegionDrawDataList();
      ??? = ((LinkedList)???).iterator();
      while (((Iterator)???).hasNext())
      {
        Object localObject4 = (RegionBitmap.DrawData)((Iterator)???).next();
        RegionBitmap.DrawData localDrawData = RegionBitmap.access$400(this.this$0).getRegionData((RegionBitmap.DrawData)localObject4);
        if (localDrawData == null)
        {
          ((RegionDrawDataList)localObject2).add((RegionBitmap.DrawData)localObject4);
          i += 1;
        }
        else
        {
          ((RegionDrawDataList)localObject2).add(localDrawData);
          localObject4 = localDrawData.mBitmap;
        }
      }
      l2 = SystemClock.uptimeMillis();
    }
    synchronized (RegionBitmap.access$500(this.this$0))
    {
      RegionBitmap.access$402(this.this$0, (RegionDrawDataList)localObject2);
      long l3 = SystemClock.uptimeMillis();
      localObject2 = RegionBitmap.access$400(this.this$0).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (RegionBitmap.DrawData)((Iterator)localObject2).next();
        if ((j != ((RegionBitmap.DrawData)???).mDecodeSample) || (((RegionBitmap.DrawData)???).mBitmap == null) || (((RegionBitmap.DrawData)???).mDrawRect == null) || (((RegionBitmap.DrawData)???).mDrawRect.isEmpty()))
        {
          if (RegionBitmap.access$600(this.this$0) != ((RegionDrawableData)localObject1).mTaskTime)
          {
            if (!URLDrawable.depImp.mLog.isColorLevel()) {
              break;
            }
            URLDrawable.depImp.mLog.e("RegionBitmap", 2, "decode cancel");
            break;
          }
          decode((RegionDrawableData)localObject1, (RegionBitmap.DrawData)???, j);
        }
      }
      RegionBitmap.access$702(this.this$0, j);
      RegionBitmap.access$800(this.this$0).set(paramMessage);
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        localObject1 = URLDrawable.depImp.mLog;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("选取有效块:cost ");
        ((StringBuilder)localObject2).append(l2 - l1);
        ((ILog)localObject1).i("RegionDrawable", 2, ((StringBuilder)localObject2).toString());
        localObject1 = URLDrawable.depImp.mLog;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("解析有效块:cost ");
        ((StringBuilder)localObject2).append(SystemClock.uptimeMillis() - l3);
        ((ILog)localObject1).i("RegionDrawable", 2, ((StringBuilder)localObject2).toString());
        localObject1 = URLDrawable.depImp.mLog;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("分块：");
        ((StringBuilder)localObject2).append(RegionBitmap.access$400(this.this$0).size());
        ((ILog)localObject1).i("RegionDrawable", 2, ((StringBuilder)localObject2).toString());
        localObject1 = URLDrawable.depImp.mLog;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("new block ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(", old block not decode ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(",old block decode ");
        ((StringBuilder)localObject2).append(i);
        ((ILog)localObject1).i("RegionDrawable", 2, ((StringBuilder)localObject2).toString());
        localObject1 = URLDrawable.depImp.mLog;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("decode rect ");
        ((StringBuilder)localObject2).append(paramMessage);
        ((StringBuilder)localObject2).append(" sample ");
        ((StringBuilder)localObject2).append(j);
        ((ILog)localObject1).i("RegionDrawable", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    for (;;)
    {
      throw paramMessage;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.RegionBitmap.WorkHandler
 * JD-Core Version:    0.7.0.1
 */