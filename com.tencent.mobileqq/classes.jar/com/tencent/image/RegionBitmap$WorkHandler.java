package com.tencent.image;

import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
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
    //   115: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +16 -> 134
    //   121: aload 9
    //   123: ifnonnull +1305 -> 1428
    //   126: ldc 113
    //   128: iconst_2
    //   129: ldc 115
    //   131: invokestatic 119	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: return
    //   135: astore 9
    //   137: aload_2
    //   138: aconst_null
    //   139: putfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   142: new 121	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   149: astore 10
    //   151: aload 10
    //   153: new 121	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   160: aload_0
    //   161: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   164: invokestatic 72	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   167: invokevirtual 126	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   170: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: ldc 132
    //   175: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   182: invokestatic 72	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   185: invokevirtual 138	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   188: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: ldc 140
    //   193: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   206: ifeq +16 -> 222
    //   209: ldc 113
    //   211: iconst_1
    //   212: aload 10
    //   214: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: aload 9
    //   219: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload_2
    //   223: getfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   226: astore 9
    //   228: aload_2
    //   229: aload_1
    //   230: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   233: putfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   236: aload 9
    //   238: ifnull +35 -> 273
    //   241: aload 9
    //   243: invokevirtual 91	android/graphics/Bitmap:isRecycled	()Z
    //   246: ifne +27 -> 273
    //   249: aload_0
    //   250: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   253: invokestatic 95	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   256: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   259: checkcast 103	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   262: astore_1
    //   263: aload_1
    //   264: ifnull +9 -> 273
    //   267: aload_1
    //   268: invokeinterface 106 1 0
    //   273: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq -142 -> 134
    //   279: aload 9
    //   281: ifnonnull +593 -> 874
    //   284: goto -158 -> 126
    //   287: astore 9
    //   289: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +31 -> 323
    //   295: ldc 113
    //   297: iconst_2
    //   298: new 121	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   305: ldc 150
    //   307: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_1
    //   311: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   314: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   317: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 119	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: invokestatic 155	java/lang/System:gc	()V
    //   326: aload_1
    //   327: aload_1
    //   328: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   331: iconst_1
    //   332: ishl
    //   333: putfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   336: aload_2
    //   337: aload_0
    //   338: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   341: invokestatic 72	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   344: aload 8
    //   346: aload_1
    //   347: invokevirtual 78	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   350: putfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   353: aload_2
    //   354: getfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   357: astore 9
    //   359: aload_2
    //   360: aload_1
    //   361: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   364: putfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   367: aload 9
    //   369: ifnull +35 -> 404
    //   372: aload 9
    //   374: invokevirtual 91	android/graphics/Bitmap:isRecycled	()Z
    //   377: ifne +27 -> 404
    //   380: aload_0
    //   381: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   384: invokestatic 95	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   387: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   390: checkcast 103	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   393: astore_1
    //   394: aload_1
    //   395: ifnull +9 -> 404
    //   398: aload_1
    //   399: invokeinterface 106 1 0
    //   404: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq -273 -> 134
    //   410: aload 9
    //   412: ifnonnull +650 -> 1062
    //   415: goto -289 -> 126
    //   418: astore 9
    //   420: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   423: ifeq -70 -> 353
    //   426: ldc 113
    //   428: iconst_1
    //   429: new 121	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   436: ldc 157
    //   438: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_1
    //   442: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   445: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: aload 9
    //   453: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: goto -103 -> 353
    //   459: astore 9
    //   461: aload_2
    //   462: getfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   465: astore 10
    //   467: aload_2
    //   468: aload_1
    //   469: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   472: putfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   475: aload 10
    //   477: ifnull +35 -> 512
    //   480: aload 10
    //   482: invokevirtual 91	android/graphics/Bitmap:isRecycled	()Z
    //   485: ifne +27 -> 512
    //   488: aload_0
    //   489: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   492: invokestatic 95	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   495: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   498: checkcast 103	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   501: astore_1
    //   502: aload_1
    //   503: ifnull +9 -> 512
    //   506: aload_1
    //   507: invokeinterface 106 1 0
    //   512: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   515: ifeq +16 -> 531
    //   518: aload 10
    //   520: ifnonnull +166 -> 686
    //   523: ldc 113
    //   525: iconst_2
    //   526: ldc 115
    //   528: invokestatic 119	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: aload 9
    //   533: athrow
    //   534: astore 9
    //   536: aload_2
    //   537: aconst_null
    //   538: putfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   541: new 121	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   548: astore 10
    //   550: aload 10
    //   552: new 121	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   559: aload_0
    //   560: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   563: invokestatic 72	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   566: invokevirtual 126	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   569: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   572: ldc 132
    //   574: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload_0
    //   578: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   581: invokestatic 72	com/tencent/image/RegionBitmap:access$000	(Lcom/tencent/image/RegionBitmap;)Landroid/graphics/BitmapRegionDecoder;
    //   584: invokevirtual 138	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   587: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: ldc 140
    //   592: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   605: ifeq +16 -> 621
    //   608: ldc 113
    //   610: iconst_1
    //   611: aload 10
    //   613: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: aload 9
    //   618: invokestatic 148	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   621: aload_2
    //   622: getfield 82	com/tencent/image/RegionBitmap$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   625: astore 9
    //   627: aload_2
    //   628: aload_1
    //   629: getfield 68	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   632: putfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   635: aload 9
    //   637: ifnull +35 -> 672
    //   640: aload 9
    //   642: invokevirtual 91	android/graphics/Bitmap:isRecycled	()Z
    //   645: ifne +27 -> 672
    //   648: aload_0
    //   649: getfield 10	com/tencent/image/RegionBitmap$WorkHandler:this$0	Lcom/tencent/image/RegionBitmap;
    //   652: invokestatic 95	com/tencent/image/RegionBitmap:access$200	(Lcom/tencent/image/RegionBitmap;)Ljava/lang/ref/WeakReference;
    //   655: invokevirtual 101	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   658: checkcast 103	com/tencent/image/RegionBitmap$OnUpdateCallback
    //   661: astore_1
    //   662: aload_1
    //   663: ifnull +9 -> 672
    //   666: aload_1
    //   667: invokeinterface 106 1 0
    //   672: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   675: ifeq -541 -> 134
    //   678: aload 9
    //   680: ifnonnull +565 -> 1245
    //   683: goto -557 -> 126
    //   686: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   689: lstore 6
    //   691: new 121	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   698: astore_1
    //   699: aload_1
    //   700: new 121	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   707: ldc 159
    //   709: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: lload 6
    //   714: lload 4
    //   716: lsub
    //   717: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   720: ldc 164
    //   722: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: iload_3
    //   726: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   729: ldc 140
    //   731: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload_1
    //   742: new 121	java/lang/StringBuilder
    //   745: dup
    //   746: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   749: ldc 166
    //   751: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: aload 8
    //   756: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   759: ldc 140
    //   761: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload_1
    //   772: new 121	java/lang/StringBuilder
    //   775: dup
    //   776: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   779: ldc 171
    //   781: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   784: aload_2
    //   785: getfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   788: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   791: ldc 173
    //   793: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload_2
    //   797: getfield 52	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   800: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   803: ldc 140
    //   805: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload_1
    //   816: new 121	java/lang/StringBuilder
    //   819: dup
    //   820: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   823: ldc 175
    //   825: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: aload 8
    //   830: invokevirtual 178	android/graphics/Rect:width	()I
    //   833: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   836: ldc 180
    //   838: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload 8
    //   843: invokevirtual 183	android/graphics/Rect:height	()I
    //   846: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   849: ldc 140
    //   851: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   857: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: ldc 113
    //   863: iconst_2
    //   864: aload_1
    //   865: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokestatic 119	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   871: goto -340 -> 531
    //   874: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   877: lstore 6
    //   879: new 121	java/lang/StringBuilder
    //   882: dup
    //   883: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   886: astore_1
    //   887: aload_1
    //   888: new 121	java/lang/StringBuilder
    //   891: dup
    //   892: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   895: ldc 159
    //   897: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: lload 6
    //   902: lload 4
    //   904: lsub
    //   905: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   908: ldc 164
    //   910: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: iload_3
    //   914: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   917: ldc 140
    //   919: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   925: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload_1
    //   930: new 121	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   937: ldc 166
    //   939: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: aload 8
    //   944: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   947: ldc 140
    //   949: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: pop
    //   959: aload_1
    //   960: new 121	java/lang/StringBuilder
    //   963: dup
    //   964: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   967: ldc 171
    //   969: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: aload_2
    //   973: getfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   976: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   979: ldc 173
    //   981: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: aload_2
    //   985: getfield 52	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   988: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   991: ldc 140
    //   993: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   999: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload_1
    //   1004: new 121	java/lang/StringBuilder
    //   1007: dup
    //   1008: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1011: ldc 175
    //   1013: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: aload 8
    //   1018: invokevirtual 178	android/graphics/Rect:width	()I
    //   1021: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1024: ldc 180
    //   1026: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: aload 8
    //   1031: invokevirtual 183	android/graphics/Rect:height	()I
    //   1034: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1037: ldc 140
    //   1039: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload_1
    //   1050: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1053: astore_1
    //   1054: ldc 113
    //   1056: iconst_2
    //   1057: aload_1
    //   1058: invokestatic 119	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1061: return
    //   1062: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   1065: lstore 6
    //   1067: new 121	java/lang/StringBuilder
    //   1070: dup
    //   1071: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1074: astore_1
    //   1075: aload_1
    //   1076: new 121	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1083: ldc 159
    //   1085: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: lload 6
    //   1090: lload 4
    //   1092: lsub
    //   1093: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1096: ldc 164
    //   1098: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: iload_3
    //   1102: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1105: ldc 140
    //   1107: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1113: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: aload_1
    //   1118: new 121	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1125: ldc 166
    //   1127: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: aload 8
    //   1132: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1135: ldc 140
    //   1137: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1143: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: pop
    //   1147: aload_1
    //   1148: new 121	java/lang/StringBuilder
    //   1151: dup
    //   1152: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1155: ldc 171
    //   1157: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: aload_2
    //   1161: getfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1164: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1167: ldc 173
    //   1169: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: aload_2
    //   1173: getfield 52	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   1176: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1179: ldc 140
    //   1181: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1184: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1187: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: pop
    //   1191: aload_1
    //   1192: new 121	java/lang/StringBuilder
    //   1195: dup
    //   1196: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1199: ldc 175
    //   1201: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: aload 8
    //   1206: invokevirtual 178	android/graphics/Rect:width	()I
    //   1209: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1212: ldc 180
    //   1214: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: aload 8
    //   1219: invokevirtual 183	android/graphics/Rect:height	()I
    //   1222: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1225: ldc 140
    //   1227: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1233: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1236: pop
    //   1237: aload_1
    //   1238: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1241: astore_1
    //   1242: goto -188 -> 1054
    //   1245: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   1248: lstore 6
    //   1250: new 121	java/lang/StringBuilder
    //   1253: dup
    //   1254: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1257: astore_1
    //   1258: aload_1
    //   1259: new 121	java/lang/StringBuilder
    //   1262: dup
    //   1263: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1266: ldc 159
    //   1268: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: lload 6
    //   1273: lload 4
    //   1275: lsub
    //   1276: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1279: ldc 164
    //   1281: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: iload_3
    //   1285: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1288: ldc 140
    //   1290: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: pop
    //   1300: aload_1
    //   1301: new 121	java/lang/StringBuilder
    //   1304: dup
    //   1305: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1308: ldc 166
    //   1310: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1313: aload 8
    //   1315: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1318: ldc 140
    //   1320: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1326: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1329: pop
    //   1330: aload_1
    //   1331: new 121	java/lang/StringBuilder
    //   1334: dup
    //   1335: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1338: ldc 171
    //   1340: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1343: aload_2
    //   1344: getfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1347: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1350: ldc 173
    //   1352: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1355: aload_2
    //   1356: getfield 52	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   1359: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1362: ldc 140
    //   1364: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1370: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: pop
    //   1374: aload_1
    //   1375: new 121	java/lang/StringBuilder
    //   1378: dup
    //   1379: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1382: ldc 175
    //   1384: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1387: aload 8
    //   1389: invokevirtual 178	android/graphics/Rect:width	()I
    //   1392: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1395: ldc 180
    //   1397: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: aload 8
    //   1402: invokevirtual 183	android/graphics/Rect:height	()I
    //   1405: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1408: ldc 140
    //   1410: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1413: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1416: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: pop
    //   1420: aload_1
    //   1421: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1424: astore_1
    //   1425: goto -371 -> 1054
    //   1428: invokestatic 34	android/os/SystemClock:uptimeMillis	()J
    //   1431: lstore 6
    //   1433: new 121	java/lang/StringBuilder
    //   1436: dup
    //   1437: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1440: astore_1
    //   1441: aload_1
    //   1442: new 121	java/lang/StringBuilder
    //   1445: dup
    //   1446: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1449: ldc 159
    //   1451: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1454: lload 6
    //   1456: lload 4
    //   1458: lsub
    //   1459: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1462: ldc 164
    //   1464: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1467: iload_3
    //   1468: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1471: ldc 140
    //   1473: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1476: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1479: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: pop
    //   1483: aload_1
    //   1484: new 121	java/lang/StringBuilder
    //   1487: dup
    //   1488: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1491: ldc 166
    //   1493: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1496: aload 8
    //   1498: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1501: ldc 140
    //   1503: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1509: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: pop
    //   1513: aload_1
    //   1514: new 121	java/lang/StringBuilder
    //   1517: dup
    //   1518: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1521: ldc 171
    //   1523: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: aload_2
    //   1527: getfield 85	com/tencent/image/RegionBitmap$DrawData:mDecodeSample	I
    //   1530: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1533: ldc 173
    //   1535: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1538: aload_2
    //   1539: getfield 52	com/tencent/image/RegionBitmap$DrawData:mDrawRect	Landroid/graphics/Rect;
    //   1542: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1545: ldc 140
    //   1547: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1550: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1553: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: pop
    //   1557: aload_1
    //   1558: new 121	java/lang/StringBuilder
    //   1561: dup
    //   1562: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1565: ldc 175
    //   1567: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1570: aload 8
    //   1572: invokevirtual 178	android/graphics/Rect:width	()I
    //   1575: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1578: ldc 180
    //   1580: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1583: aload 8
    //   1585: invokevirtual 183	android/graphics/Rect:height	()I
    //   1588: invokevirtual 130	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1591: ldc 140
    //   1593: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1599: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1602: pop
    //   1603: aload_1
    //   1604: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1607: astore_1
    //   1608: goto -554 -> 1054
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1611	0	this	WorkHandler
    //   0	1611	1	paramRegionDrawableData	RegionDrawableData
    //   0	1611	2	paramDrawData	RegionBitmap.DrawData
    //   0	1611	3	paramInt	int
    //   3	1454	4	l1	long
    //   689	766	6	l2	long
    //   12	1572	8	localRect	Rect
    //   68	54	9	localBitmap1	android.graphics.Bitmap
    //   135	83	9	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   226	54	9	localBitmap2	android.graphics.Bitmap
    //   287	1	9	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   357	54	9	localBitmap3	android.graphics.Bitmap
    //   418	34	9	localException	Exception
    //   459	73	9	localObject1	Object
    //   534	83	9	localRuntimeException	RuntimeException
    //   625	54	9	localBitmap4	android.graphics.Bitmap
    //   149	463	10	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   47	64	135	java/lang/IllegalArgumentException
    //   47	64	287	java/lang/OutOfMemoryError
    //   323	353	418	java/lang/Exception
    //   47	64	459	finally
    //   137	222	459	finally
    //   289	323	459	finally
    //   323	353	459	finally
    //   420	456	459	finally
    //   536	621	459	finally
    //   47	64	534	java/lang/RuntimeException
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
      if ((QLog.isColorLevel()) && (RegionBitmap.access$000(this.this$0) != null)) {
        QLog.i("RegionDrawable", 2, "origin size " + RegionBitmap.access$000(this.this$0).getWidth() + "x" + RegionBitmap.access$000(this.this$0).getHeight());
      }
      if ((RegionBitmap.access$000(this.this$0) == null) && (QLog.isColorLevel())) {
        QLog.e("RegionBitmap", 2, "BitmapRegionDecoder object is null");
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
          if (QLog.isColorLevel()) {
            QLog.e("RegionBitmap", 2, "Init BitmapRegionDecoder failure", localException1);
          }
          RegionBitmap.access$002(this.this$0, null);
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("RegionBitmap", 2, "Init BitmapRegionDecoder failure", localException2);
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
    label670:
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
              break label670;
            }
            if (QLog.isColorLevel()) {
              QLog.e("RegionBitmap", 2, "decode cancel");
            }
          }
          RegionBitmap.access$702(this.this$0, n);
          RegionBitmap.access$800(this.this$0).set(localRect);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("RegionDrawable", 2, "选取有效块:cost " + (l2 - l1));
          QLog.i("RegionDrawable", 2, "解析有效块:cost " + (SystemClock.uptimeMillis() - l3));
          QLog.i("RegionDrawable", 2, "分块：" + RegionBitmap.access$400(this.this$0).size());
          QLog.i("RegionDrawable", 2, "new block " + i + ", old block not decode " + i + ",old block decode " + i);
          QLog.i("RegionDrawable", 2, "decode rect " + localRect + " sample " + n);
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