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
    //   0: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 4
    //   5: new 36	android/graphics/Rect
    //   8: dup
    //   9: invokespecial 37	android/graphics/Rect:<init>	()V
    //   12: astore 8
    //   14: aload 8
    //   16: aload_1
    //   17: getfield 43	com/tencent/image/RegionDrawableData:mSourceDensity	I
    //   20: aload_1
    //   21: getfield 46	com/tencent/image/RegionDrawableData:mTargetDensity	I
    //   24: aload_2
    //   25: getfield 52	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   28: invokestatic 58	com/tencent/image/RegionBitmap:regionToDecode	(IILandroid/graphics/Rect;)Landroid/graphics/Rect;
    //   31: invokevirtual 62	android/graphics/Rect:set	(Landroid/graphics/Rect;)V
    //   34: new 64	android/graphics/BitmapFactory$Options
    //   37: dup
    //   38: invokespecial 65	android/graphics/BitmapFactory$Options:<init>	()V
    //   41: astore_1
    //   42: aload_1
    //   43: iload_3
    //   44: putfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   47: aload_2
    //   48: aload_0
    //   49: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   52: invokestatic 72	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   55: aload 8
    //   57: aload_1
    //   58: invokevirtual 78	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   61: putfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   64: aload_2
    //   65: getfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   68: astore 9
    //   70: aload_2
    //   71: aload_1
    //   72: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   75: putfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   78: aload 9
    //   80: ifnull +35 -> 115
    //   83: aload 9
    //   85: invokevirtual 91	android/graphics/Bitmap:isRecycled	()Z
    //   88: ifne +27 -> 115
    //   91: aload_0
    //   92: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   95: invokestatic 95	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   98: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   101: checkcast 103	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull +9 -> 115
    //   109: aload_1
    //   110: invokeinterface 106 1 0
    //   115: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   118: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   121: invokeinterface 123 1 0
    //   126: ifeq +24 -> 150
    //   129: aload 9
    //   131: ifnonnull +20 -> 151
    //   134: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   137: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   140: ldc 125
    //   142: iconst_2
    //   143: ldc 127
    //   145: invokeinterface 131 4 0
    //   150: return
    //   151: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   154: lstore 6
    //   156: new 133	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   163: astore_1
    //   164: aload_1
    //   165: new 133	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   172: ldc 136
    //   174: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: lload 6
    //   179: lload 4
    //   181: lsub
    //   182: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   185: ldc 145
    //   187: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: iload_3
    //   191: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: ldc 150
    //   196: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_1
    //   207: new 133	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   214: ldc 156
    //   216: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 8
    //   221: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: ldc 150
    //   226: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_1
    //   237: new 133	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   244: ldc 161
    //   246: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_2
    //   250: getfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   253: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   256: ldc 163
    //   258: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_2
    //   262: getfield 52	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   265: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   268: ldc 150
    //   270: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_1
    //   281: new 133	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   288: ldc 165
    //   290: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload 8
    //   295: invokevirtual 169	android/graphics/Rect:width	()I
    //   298: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: ldc 171
    //   303: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: aload 8
    //   308: invokevirtual 174	android/graphics/Rect:height	()I
    //   311: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: ldc 150
    //   316: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   329: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   332: ldc 125
    //   334: iconst_2
    //   335: aload_1
    //   336: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokeinterface 131 4 0
    //   344: return
    //   345: astore 9
    //   347: aload_2
    //   348: aconst_null
    //   349: putfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   352: new 133	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   359: new 133	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   366: aload_0
    //   367: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   370: invokestatic 72	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   373: invokevirtual 177	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   376: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: ldc 179
    //   381: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_0
    //   385: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   388: invokestatic 72	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   391: invokevirtual 182	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   394: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: ldc 150
    //   399: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   412: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   415: invokeinterface 123 1 0
    //   420: ifeq +19 -> 439
    //   423: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   426: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   429: ldc 125
    //   431: iconst_1
    //   432: aload 9
    //   434: invokeinterface 186 4 0
    //   439: aload_2
    //   440: getfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   443: astore 9
    //   445: aload_2
    //   446: aload_1
    //   447: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   450: putfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   453: aload 9
    //   455: ifnull +35 -> 490
    //   458: aload 9
    //   460: invokevirtual 91	android/graphics/Bitmap:isRecycled	()Z
    //   463: ifne +27 -> 490
    //   466: aload_0
    //   467: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   470: invokestatic 95	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   473: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   476: checkcast 103	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   479: astore_1
    //   480: aload_1
    //   481: ifnull +9 -> 490
    //   484: aload_1
    //   485: invokeinterface 106 1 0
    //   490: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   493: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   496: invokeinterface 123 1 0
    //   501: ifeq -351 -> 150
    //   504: aload 9
    //   506: ifnonnull +20 -> 526
    //   509: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   512: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   515: ldc 125
    //   517: iconst_2
    //   518: ldc 127
    //   520: invokeinterface 131 4 0
    //   525: return
    //   526: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   529: lstore 6
    //   531: new 133	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   538: astore_1
    //   539: aload_1
    //   540: new 133	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   547: ldc 136
    //   549: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: lload 6
    //   554: lload 4
    //   556: lsub
    //   557: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   560: ldc 145
    //   562: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: iload_3
    //   566: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   569: ldc 150
    //   571: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload_1
    //   582: new 133	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   589: ldc 156
    //   591: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload 8
    //   596: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   599: ldc 150
    //   601: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload_1
    //   612: new 133	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   619: ldc 161
    //   621: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_2
    //   625: getfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   628: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: ldc 163
    //   633: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_2
    //   637: getfield 52	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   640: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   643: ldc 150
    //   645: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload_1
    //   656: new 133	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   663: ldc 165
    //   665: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload 8
    //   670: invokevirtual 169	android/graphics/Rect:width	()I
    //   673: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   676: ldc 171
    //   678: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload 8
    //   683: invokevirtual 174	android/graphics/Rect:height	()I
    //   686: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   689: ldc 150
    //   691: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   704: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   707: ldc 125
    //   709: iconst_2
    //   710: aload_1
    //   711: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokeinterface 131 4 0
    //   719: return
    //   720: astore 9
    //   722: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   725: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   728: invokeinterface 123 1 0
    //   733: ifeq +39 -> 772
    //   736: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   739: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   742: ldc 125
    //   744: iconst_2
    //   745: new 133	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   752: ldc 188
    //   754: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload_1
    //   758: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   761: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokeinterface 131 4 0
    //   772: invokestatic 193	java/lang/System:gc	()V
    //   775: aload_1
    //   776: aload_1
    //   777: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   780: iconst_1
    //   781: ishl
    //   782: putfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   785: aload_2
    //   786: aload_0
    //   787: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   790: invokestatic 72	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   793: aload 8
    //   795: aload_1
    //   796: invokevirtual 78	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   799: putfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   802: aload_2
    //   803: getfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   806: astore 9
    //   808: aload_2
    //   809: aload_1
    //   810: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   813: putfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   816: aload 9
    //   818: ifnull +35 -> 853
    //   821: aload 9
    //   823: invokevirtual 91	android/graphics/Bitmap:isRecycled	()Z
    //   826: ifne +27 -> 853
    //   829: aload_0
    //   830: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   833: invokestatic 95	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   836: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   839: checkcast 103	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   842: astore_1
    //   843: aload_1
    //   844: ifnull +9 -> 853
    //   847: aload_1
    //   848: invokeinterface 106 1 0
    //   853: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   856: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   859: invokeinterface 123 1 0
    //   864: ifeq -714 -> 150
    //   867: aload 9
    //   869: ifnonnull +146 -> 1015
    //   872: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   875: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   878: ldc 125
    //   880: iconst_2
    //   881: ldc 127
    //   883: invokeinterface 131 4 0
    //   888: return
    //   889: astore 9
    //   891: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   894: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   897: invokeinterface 123 1 0
    //   902: ifeq -100 -> 802
    //   905: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   908: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   911: ldc 125
    //   913: iconst_1
    //   914: aload 9
    //   916: invokeinterface 186 4 0
    //   921: goto -119 -> 802
    //   924: astore 9
    //   926: aload_2
    //   927: getfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   930: astore 10
    //   932: aload_2
    //   933: aload_1
    //   934: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   937: putfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   940: aload 10
    //   942: ifnull +35 -> 977
    //   945: aload 10
    //   947: invokevirtual 91	android/graphics/Bitmap:isRecycled	()Z
    //   950: ifne +27 -> 977
    //   953: aload_0
    //   954: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   957: invokestatic 95	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   960: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   963: checkcast 103	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   966: astore_1
    //   967: aload_1
    //   968: ifnull +9 -> 977
    //   971: aload_1
    //   972: invokeinterface 106 1 0
    //   977: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   980: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   983: invokeinterface 123 1 0
    //   988: ifeq +24 -> 1012
    //   991: aload 10
    //   993: ifnonnull +591 -> 1584
    //   996: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   999: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1002: ldc 125
    //   1004: iconst_2
    //   1005: ldc 127
    //   1007: invokeinterface 131 4 0
    //   1012: aload 9
    //   1014: athrow
    //   1015: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   1018: lstore 6
    //   1020: new 133	java/lang/StringBuilder
    //   1023: dup
    //   1024: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1027: astore_1
    //   1028: aload_1
    //   1029: new 133	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1036: ldc 136
    //   1038: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: lload 6
    //   1043: lload 4
    //   1045: lsub
    //   1046: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1049: ldc 145
    //   1051: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: iload_3
    //   1055: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1058: ldc 150
    //   1060: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1066: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: pop
    //   1070: aload_1
    //   1071: new 133	java/lang/StringBuilder
    //   1074: dup
    //   1075: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1078: ldc 156
    //   1080: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: aload 8
    //   1085: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1088: ldc 150
    //   1090: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1096: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1099: pop
    //   1100: aload_1
    //   1101: new 133	java/lang/StringBuilder
    //   1104: dup
    //   1105: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1108: ldc 161
    //   1110: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: aload_2
    //   1114: getfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1117: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1120: ldc 163
    //   1122: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: aload_2
    //   1126: getfield 52	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   1129: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1132: ldc 150
    //   1134: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1140: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: pop
    //   1144: aload_1
    //   1145: new 133	java/lang/StringBuilder
    //   1148: dup
    //   1149: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1152: ldc 165
    //   1154: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1157: aload 8
    //   1159: invokevirtual 169	android/graphics/Rect:width	()I
    //   1162: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1165: ldc 171
    //   1167: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1170: aload 8
    //   1172: invokevirtual 174	android/graphics/Rect:height	()I
    //   1175: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1178: ldc 150
    //   1180: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: pop
    //   1190: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1193: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1196: ldc 125
    //   1198: iconst_2
    //   1199: aload_1
    //   1200: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1203: invokeinterface 131 4 0
    //   1208: return
    //   1209: astore 9
    //   1211: aload_2
    //   1212: aconst_null
    //   1213: putfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   1216: new 133	java/lang/StringBuilder
    //   1219: dup
    //   1220: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1223: new 133	java/lang/StringBuilder
    //   1226: dup
    //   1227: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1230: aload_0
    //   1231: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   1234: invokestatic 72	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   1237: invokevirtual 177	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   1240: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1243: ldc 179
    //   1245: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: aload_0
    //   1249: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   1252: invokestatic 72	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   1255: invokevirtual 182	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   1258: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1261: ldc 150
    //   1263: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1266: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: pop
    //   1273: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1276: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1279: invokeinterface 123 1 0
    //   1284: ifeq +19 -> 1303
    //   1287: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1290: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1293: ldc 125
    //   1295: iconst_1
    //   1296: aload 9
    //   1298: invokeinterface 186 4 0
    //   1303: aload_2
    //   1304: getfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   1307: astore 9
    //   1309: aload_2
    //   1310: aload_1
    //   1311: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1314: putfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1317: aload 9
    //   1319: ifnull +35 -> 1354
    //   1322: aload 9
    //   1324: invokevirtual 91	android/graphics/Bitmap:isRecycled	()Z
    //   1327: ifne +27 -> 1354
    //   1330: aload_0
    //   1331: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   1334: invokestatic 95	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   1337: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   1340: checkcast 103	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   1343: astore_1
    //   1344: aload_1
    //   1345: ifnull +9 -> 1354
    //   1348: aload_1
    //   1349: invokeinterface 106 1 0
    //   1354: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1357: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1360: invokeinterface 123 1 0
    //   1365: ifeq -1215 -> 150
    //   1368: aload 9
    //   1370: ifnonnull +20 -> 1390
    //   1373: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1376: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1379: ldc 125
    //   1381: iconst_2
    //   1382: ldc 127
    //   1384: invokeinterface 131 4 0
    //   1389: return
    //   1390: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   1393: lstore 6
    //   1395: new 133	java/lang/StringBuilder
    //   1398: dup
    //   1399: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1402: astore_1
    //   1403: aload_1
    //   1404: new 133	java/lang/StringBuilder
    //   1407: dup
    //   1408: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1411: ldc 136
    //   1413: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1416: lload 6
    //   1418: lload 4
    //   1420: lsub
    //   1421: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1424: ldc 145
    //   1426: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1429: iload_3
    //   1430: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1433: ldc 150
    //   1435: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1441: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1444: pop
    //   1445: aload_1
    //   1446: new 133	java/lang/StringBuilder
    //   1449: dup
    //   1450: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1453: ldc 156
    //   1455: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: aload 8
    //   1460: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1463: ldc 150
    //   1465: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1471: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: pop
    //   1475: aload_1
    //   1476: new 133	java/lang/StringBuilder
    //   1479: dup
    //   1480: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1483: ldc 161
    //   1485: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1488: aload_2
    //   1489: getfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1492: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1495: ldc 163
    //   1497: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: aload_2
    //   1501: getfield 52	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   1504: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1507: ldc 150
    //   1509: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1515: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1518: pop
    //   1519: aload_1
    //   1520: new 133	java/lang/StringBuilder
    //   1523: dup
    //   1524: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1527: ldc 165
    //   1529: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: aload 8
    //   1534: invokevirtual 169	android/graphics/Rect:width	()I
    //   1537: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1540: ldc 171
    //   1542: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: aload 8
    //   1547: invokevirtual 174	android/graphics/Rect:height	()I
    //   1550: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1553: ldc 150
    //   1555: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1558: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1561: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1564: pop
    //   1565: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1568: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1571: ldc 125
    //   1573: iconst_2
    //   1574: aload_1
    //   1575: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1578: invokeinterface 131 4 0
    //   1583: return
    //   1584: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   1587: lstore 6
    //   1589: new 133	java/lang/StringBuilder
    //   1592: dup
    //   1593: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1596: astore_1
    //   1597: aload_1
    //   1598: new 133	java/lang/StringBuilder
    //   1601: dup
    //   1602: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1605: ldc 136
    //   1607: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1610: lload 6
    //   1612: lload 4
    //   1614: lsub
    //   1615: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1618: ldc 145
    //   1620: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1623: iload_3
    //   1624: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1627: ldc 150
    //   1629: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1635: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: pop
    //   1639: aload_1
    //   1640: new 133	java/lang/StringBuilder
    //   1643: dup
    //   1644: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1647: ldc 156
    //   1649: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: aload 8
    //   1654: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1657: ldc 150
    //   1659: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1662: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1665: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1668: pop
    //   1669: aload_1
    //   1670: new 133	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1677: ldc 161
    //   1679: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: aload_2
    //   1683: getfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1686: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1689: ldc 163
    //   1691: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: aload_2
    //   1695: getfield 52	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   1698: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1701: ldc 150
    //   1703: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1706: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1709: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1712: pop
    //   1713: aload_1
    //   1714: new 133	java/lang/StringBuilder
    //   1717: dup
    //   1718: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   1721: ldc 165
    //   1723: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1726: aload 8
    //   1728: invokevirtual 169	android/graphics/Rect:width	()I
    //   1731: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1734: ldc 171
    //   1736: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1739: aload 8
    //   1741: invokevirtual 174	android/graphics/Rect:height	()I
    //   1744: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1747: ldc 150
    //   1749: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1752: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1755: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1758: pop
    //   1759: getstatic 112	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1762: getfield 118	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1765: ldc 125
    //   1767: iconst_2
    //   1768: aload_1
    //   1769: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1772: invokeinterface 131 4 0
    //   1777: goto -765 -> 1012
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1780	0	this	WorkHandler
    //   0	1780	1	paramRegionDrawableData	RegionDrawableData
    //   0	1780	2	paramDrawData	RegionBitmap.DrawData
    //   0	1780	3	paramInt	int
    //   3	1610	4	l1	long
    //   154	1457	6	l2	long
    //   12	1728	8	localRect	Rect
    //   68	62	9	localBitmap1	android.graphics.Bitmap
    //   345	88	9	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   443	62	9	localBitmap2	android.graphics.Bitmap
    //   720	1	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   806	62	9	localBitmap3	android.graphics.Bitmap
    //   889	26	9	localException	Exception
    //   924	89	9	localObject	Object
    //   1209	88	9	localRuntimeException	RuntimeException
    //   1307	62	9	localBitmap4	android.graphics.Bitmap
    //   930	62	10	localBitmap5	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   47	64	345	java/lang/IllegalArgumentException
    //   47	64	720	java/lang/OutOfMemoryError
    //   772	802	889	java/lang/Exception
    //   47	64	924	finally
    //   347	439	924	finally
    //   722	772	924	finally
    //   772	802	924	finally
    //   891	921	924	finally
    //   1211	1303	924	finally
    //   47	64	1209	java/lang/RuntimeException
  }
  
  private void initRegionDecoder()
  {
    if ((RegionBitmap.access$000(this.this$0) == null) || (RegionBitmap.access$000(this.this$0).isRecycled())) {
      if (TextUtils.isEmpty(RegionBitmap.access$100(this.this$0))) {
        throw new RuntimeException("Image path is null");
      }
    }
    try
    {
      RegionBitmap.access$002(this.this$0, BitmapRegionDecoder.newInstance(RegionBitmap.access$100(this.this$0), true));
      if ((URLDrawable.depImp.mLog.isColorLevel()) && (RegionBitmap.access$000(this.this$0) != null)) {
        URLDrawable.depImp.mLog.i("RegionDrawable", 2, "origin size " + RegionBitmap.access$000(this.this$0).getWidth() + "x" + RegionBitmap.access$000(this.this$0).getHeight());
      }
      if ((RegionBitmap.access$000(this.this$0) == null) && (URLDrawable.depImp.mLog.isColorLevel())) {
        URLDrawable.depImp.mLog.e("RegionBitmap", 2, "BitmapRegionDecoder object is null");
      }
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        try
        {
          Uri localUri = Uri.parse(RegionBitmap.access$100(this.this$0));
          RegionBitmap.access$002(this.this$0, BitmapRegionDecoder.newInstance(localUri.getPath(), true));
        }
        catch (Exception localException1)
        {
          if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.e("RegionBitmap", 2, "Init BitmapRegionDecoder failure", localException1);
          }
          RegionBitmap.access$002(this.this$0, null);
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.e("RegionBitmap", 2, "Init BitmapRegionDecoder failure", localException2);
        }
        RegionBitmap.access$002(this.this$0, null);
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    label734:
    do
    {
      int n;
      do
      {
        do
        {
          return;
          initRegionDecoder();
        } while ((RegionBitmap.access$000(this.this$0) == null) || (!RegionDrawableData.class.isInstance(paramMessage.obj)));
        paramMessage = (RegionDrawableData)paramMessage.obj;
        n = paramMessage.calcSample();
      } while (n == 0);
      if (RegionBitmap.access$300(this.this$0) == null) {
        RegionBitmap.access$302(this.this$0, new RegionBitmapBlockHelper(new Rect(0, 0, RegionBitmap.access$000(this.this$0).getWidth(), RegionBitmap.access$000(this.this$0).getHeight()), paramMessage.mSourceDensity, paramMessage.mTargetDensity));
      }
      long l1 = SystemClock.uptimeMillis();
      Rect localRect = RegionBitmap.regionToDecode(paramMessage.mSourceDensity, paramMessage.mTargetDensity, paramMessage.mShowArea);
      ??? = RegionBitmap.access$300(this.this$0).getDrawDatas(paramMessage, n);
      Object localObject1 = new RegionDrawDataList();
      ??? = ((LinkedList)???).iterator();
      int i = 0;
      int j = 0;
      int k = 0;
      if (((Iterator)???).hasNext())
      {
        RegionBitmap.DrawData localDrawData1 = (RegionBitmap.DrawData)((Iterator)???).next();
        RegionBitmap.DrawData localDrawData2 = RegionBitmap.access$400(this.this$0).getRegionData(localDrawData1);
        int m;
        if (localDrawData2 == null)
        {
          ((RegionDrawDataList)localObject1).add(localDrawData1);
          m = k;
          k = i + 1;
          i = m;
        }
        for (;;)
        {
          m = k;
          k = i;
          i = m;
          break;
          ((RegionDrawDataList)localObject1).add(localDrawData2);
          if (localDrawData2.mBitmap == null)
          {
            j += 1;
            m = i;
            i = k;
            k = m;
          }
          else
          {
            m = k + 1;
            k = i;
            i = m;
          }
        }
      }
      long l2 = SystemClock.uptimeMillis();
      for (;;)
      {
        synchronized (RegionBitmap.access$500(this.this$0))
        {
          RegionBitmap.access$402(this.this$0, (RegionDrawDataList)localObject1);
          long l3 = SystemClock.uptimeMillis();
          localObject1 = RegionBitmap.access$400(this.this$0).iterator();
          j = 0;
          if (((Iterator)localObject1).hasNext())
          {
            ??? = (RegionBitmap.DrawData)((Iterator)localObject1).next();
            if ((n == ((RegionBitmap.DrawData)???).mDecodeSample) && (((RegionBitmap.DrawData)???).mBitmap != null) && (((RegionBitmap.DrawData)???).mDrawRect != null) && (!((RegionBitmap.DrawData)???).mDrawRect.isEmpty())) {
              continue;
            }
            if (RegionBitmap.access$600(this.this$0) == paramMessage.mTaskTime) {
              break label734;
            }
            if (URLDrawable.depImp.mLog.isColorLevel()) {
              URLDrawable.depImp.mLog.e("RegionBitmap", 2, "decode cancel");
            }
          }
          RegionBitmap.access$702(this.this$0, n);
          RegionBitmap.access$800(this.this$0).set(localRect);
          if (!URLDrawable.depImp.mLog.isColorLevel()) {
            break;
          }
          URLDrawable.depImp.mLog.i("RegionDrawable", 2, "选取有效块:cost " + (l2 - l1));
          URLDrawable.depImp.mLog.i("RegionDrawable", 2, "解析有效块:cost " + (SystemClock.uptimeMillis() - l3));
          URLDrawable.depImp.mLog.i("RegionDrawable", 2, "分块：" + RegionBitmap.access$400(this.this$0).size());
          URLDrawable.depImp.mLog.i("RegionDrawable", 2, "new block " + i + ", old block not decode " + i + ",old block decode " + i);
          URLDrawable.depImp.mLog.i("RegionDrawable", 2, "decode rect " + localRect + " sample " + n);
          return;
        }
        decode(paramMessage, (RegionBitmap.DrawData)???, n);
        j += 1;
      }
    } while ((RegionBitmap.access$000(this.this$0) == null) || (RegionBitmap.access$000(this.this$0).isRecycled()));
    RegionBitmap.access$000(this.this$0).recycle();
    RegionBitmap.access$002(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.RegionBitmap.WorkHandler
 * JD-Core Version:    0.7.0.1
 */