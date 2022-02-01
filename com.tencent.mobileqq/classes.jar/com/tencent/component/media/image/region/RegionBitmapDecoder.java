package com.tencent.component.media.image.region;

import android.graphics.Bitmap;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class RegionBitmapDecoder
{
  private static final int MSG_UPDATE_DECODE_REGION = 1;
  private static final String TAG = "RegionBitmapDecoder";
  private WeakReference<RegionBitmapDecoder.OnUpdateCallback> mCallback;
  private long mCurrentTime;
  private HashMap<Rect, RegionBitmapDecoder.DrawData> mDataList = new HashMap();
  private Object mDataLock = new Object();
  private Matrix mExifMatrix;
  private RegionBitmapBlockHelper mHelper;
  private String mImagePath;
  private int mOrgImageWidth;
  private int mOrgimageHeight;
  private BitmapRegionDecoder mRegionDecoder;
  private int mRotation = -1;
  private Rect mTmp = new Rect();
  private RegionBitmapDecoder.WorkHandler mWorkHandler;
  
  public RegionBitmapDecoder(String paramString)
  {
    if (this.mWorkHandler == null) {
      this.mWorkHandler = new RegionBitmapDecoder.WorkHandler(this, ImageManagerEnv.g().getFileThreadLooper());
    }
    this.mImagePath = paramString;
  }
  
  private void caclShowArea(RegionDrawableData paramRegionDrawableData)
  {
    Rect localRect = new Rect(paramRegionDrawableData.mShowArea);
    int j = localRect.width();
    int k = localRect.height();
    int i = ImageManagerEnv.g().getScreenWidth();
    int n = ImageManagerEnv.g().getScreenHeight();
    if ((k <= n) && (j >= i))
    {
      k = Math.abs(localRect.left);
      m = this.mOrgImageWidth;
      f1 = m;
      f2 = k;
      f3 = j;
      j = (int)(f1 * (f2 / f3) + 0.5F);
      k = (int)(m * ((i + k) / f3) + 0.5F);
      i = j;
      if (j < 0) {
        i = 0;
      }
      m = this.mOrgImageWidth;
      j = k;
      if (k > m) {
        j = m;
      }
      paramRegionDrawableData.mShowArea.set(i, 0, j, this.mOrgimageHeight);
      return;
    }
    k = Math.abs(localRect.left);
    int i1 = Math.abs(localRect.top);
    int i2 = this.mOrgImageWidth;
    float f1 = i2;
    float f2 = k;
    float f3 = j;
    j = (int)(f1 * (f2 / f3) + 0.5F);
    k = (int)(i2 * ((i + k) / f3) + 0.5F);
    int m = (int)(i2 * (i1 / f3) + 0.5F);
    n = (int)(i2 * ((n + i1) / f3) + 0.5F);
    i = j;
    if (j < 0) {
      i = 0;
    }
    i1 = this.mOrgImageWidth;
    j = k;
    if (k > i1) {
      j = i1;
    }
    k = m;
    if (m < 0) {
      k = 0;
    }
    i1 = this.mOrgimageHeight;
    m = n;
    if (n > i1) {
      m = i1;
    }
    paramRegionDrawableData.mShowArea.set(i, k, j, m);
  }
  
  /* Error */
  private void decode(RegionBitmapDecoder.DrawData paramDrawData, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	com/tencent/component/media/image/region/RegionBitmapDecoder:mRegionDecoder	Landroid/graphics/BitmapRegionDecoder;
    //   4: astore 7
    //   6: aload 7
    //   8: ifnull +1094 -> 1102
    //   11: aload 7
    //   13: invokevirtual 174	android/graphics/BitmapRegionDecoder:isRecycled	()Z
    //   16: ifeq +6 -> 22
    //   19: goto +1083 -> 1102
    //   22: invokestatic 180	android/os/SystemClock:uptimeMillis	()J
    //   25: lstore_3
    //   26: aload_0
    //   27: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   30: aload_1
    //   31: getfield 185	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mOrgRect	Landroid/graphics/Rect;
    //   34: invokevirtual 187	android/graphics/Rect:set	(Landroid/graphics/Rect;)V
    //   37: new 189	android/graphics/BitmapFactory$Options
    //   40: dup
    //   41: invokespecial 190	android/graphics/BitmapFactory$Options:<init>	()V
    //   44: astore 9
    //   46: aload 9
    //   48: iload_2
    //   49: putfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   52: aload_1
    //   53: aload_0
    //   54: getfield 83	com/tencent/component/media/image/region/RegionBitmapDecoder:mRegionDecoder	Landroid/graphics/BitmapRegionDecoder;
    //   57: aload_0
    //   58: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   61: aload 9
    //   63: invokevirtual 197	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   66: putfield 201	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   69: aload_1
    //   70: getfield 201	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   73: astore 7
    //   75: aload_1
    //   76: aload 9
    //   78: getfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   81: putfield 204	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mDecodeSample	I
    //   84: aload 7
    //   86: ifnull +32 -> 118
    //   89: aload 7
    //   91: invokevirtual 207	android/graphics/Bitmap:isRecycled	()Z
    //   94: ifne +24 -> 118
    //   97: aload_0
    //   98: getfield 209	com/tencent/component/media/image/region/RegionBitmapDecoder:mCallback	Ljava/lang/ref/WeakReference;
    //   101: invokevirtual 215	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   104: checkcast 217	com/tencent/component/media/image/region/RegionBitmapDecoder$OnUpdateCallback
    //   107: astore_1
    //   108: aload_1
    //   109: ifnull +9 -> 118
    //   112: aload_1
    //   113: invokeinterface 220 1 0
    //   118: aload 7
    //   120: ifnonnull +37 -> 157
    //   123: new 222	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   130: astore_1
    //   131: aload_1
    //   132: ldc 225
    //   134: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload_1
    //   139: aload_0
    //   140: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   143: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: ldc 11
    //   149: aload_1
    //   150: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 242	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: return
    //   157: invokestatic 180	android/os/SystemClock:uptimeMillis	()J
    //   160: lload_3
    //   161: lsub
    //   162: lstore_3
    //   163: new 222	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   170: astore_1
    //   171: new 222	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   178: astore 7
    //   180: aload 7
    //   182: ldc 244
    //   184: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 7
    //   190: lload_3
    //   191: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 7
    //   197: ldc 249
    //   199: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 7
    //   205: aload 9
    //   207: getfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   210: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 7
    //   216: ldc 254
    //   218: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 7
    //   224: aload_0
    //   225: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   228: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: aload 7
    //   234: ldc_w 256
    //   237: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 7
    //   243: aload_0
    //   244: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   247: invokevirtual 136	android/graphics/Rect:width	()I
    //   250: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_1
    //   255: aload 7
    //   257: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 11
    //   266: aload_1
    //   267: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 259	com/tencent/component/media/utils/ImageManagerLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: return
    //   274: astore 7
    //   276: ldc_w 256
    //   279: astore 8
    //   281: goto +611 -> 892
    //   284: aload_1
    //   285: aconst_null
    //   286: putfield 201	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   289: new 222	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 261
    //   296: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: astore 7
    //   301: aload_0
    //   302: getfield 83	com/tencent/component/media/image/region/RegionBitmapDecoder:mRegionDecoder	Landroid/graphics/BitmapRegionDecoder;
    //   305: ifnull +77 -> 382
    //   308: new 222	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   315: astore 8
    //   317: aload 8
    //   319: aload_0
    //   320: getfield 83	com/tencent/component/media/image/region/RegionBitmapDecoder:mRegionDecoder	Landroid/graphics/BitmapRegionDecoder;
    //   323: invokevirtual 266	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   326: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 8
    //   332: ldc_w 268
    //   335: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 8
    //   341: aload_0
    //   342: getfield 83	com/tencent/component/media/image/region/RegionBitmapDecoder:mRegionDecoder	Landroid/graphics/BitmapRegionDecoder;
    //   345: invokevirtual 271	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   348: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 8
    //   354: ldc_w 273
    //   357: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 8
    //   363: aload_0
    //   364: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   367: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 7
    //   373: aload 8
    //   375: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: ldc 11
    //   384: aload 7
    //   386: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 242	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload_1
    //   393: getfield 201	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   396: astore 7
    //   398: aload_1
    //   399: aload 9
    //   401: getfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   404: putfield 204	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mDecodeSample	I
    //   407: aload 7
    //   409: ifnull +32 -> 441
    //   412: aload 7
    //   414: invokevirtual 207	android/graphics/Bitmap:isRecycled	()Z
    //   417: ifne +24 -> 441
    //   420: aload_0
    //   421: getfield 209	com/tencent/component/media/image/region/RegionBitmapDecoder:mCallback	Ljava/lang/ref/WeakReference;
    //   424: invokevirtual 215	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   427: checkcast 217	com/tencent/component/media/image/region/RegionBitmapDecoder$OnUpdateCallback
    //   430: astore_1
    //   431: aload_1
    //   432: ifnull +9 -> 441
    //   435: aload_1
    //   436: invokeinterface 220 1 0
    //   441: aload 7
    //   443: ifnonnull +14 -> 457
    //   446: new 222	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   453: astore_1
    //   454: goto -323 -> 131
    //   457: invokestatic 180	android/os/SystemClock:uptimeMillis	()J
    //   460: lload_3
    //   461: lsub
    //   462: lstore_3
    //   463: new 222	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   470: astore_1
    //   471: new 222	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   478: astore 7
    //   480: goto -300 -> 180
    //   483: ldc_w 275
    //   486: ldc_w 277
    //   489: invokestatic 242	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload 9
    //   494: aload 9
    //   496: getfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   499: iconst_1
    //   500: ishl
    //   501: putfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   504: aload_0
    //   505: getfield 83	com/tencent/component/media/image/region/RegionBitmapDecoder:mRegionDecoder	Landroid/graphics/BitmapRegionDecoder;
    //   508: ifnull +20 -> 528
    //   511: aload_1
    //   512: aload_0
    //   513: getfield 83	com/tencent/component/media/image/region/RegionBitmapDecoder:mRegionDecoder	Landroid/graphics/BitmapRegionDecoder;
    //   516: aload_0
    //   517: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   520: aload 9
    //   522: invokevirtual 197	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   525: putfield 201	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   528: aload_1
    //   529: getfield 201	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   532: astore 7
    //   534: aload_1
    //   535: aload 9
    //   537: getfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   540: putfield 204	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mDecodeSample	I
    //   543: aload 7
    //   545: ifnull +32 -> 577
    //   548: aload 7
    //   550: invokevirtual 207	android/graphics/Bitmap:isRecycled	()Z
    //   553: ifne +24 -> 577
    //   556: aload_0
    //   557: getfield 209	com/tencent/component/media/image/region/RegionBitmapDecoder:mCallback	Ljava/lang/ref/WeakReference;
    //   560: invokevirtual 215	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   563: checkcast 217	com/tencent/component/media/image/region/RegionBitmapDecoder$OnUpdateCallback
    //   566: astore_1
    //   567: aload_1
    //   568: ifnull +9 -> 577
    //   571: aload_1
    //   572: invokeinterface 220 1 0
    //   577: aload 7
    //   579: ifnonnull +14 -> 593
    //   582: new 222	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   589: astore_1
    //   590: goto -459 -> 131
    //   593: invokestatic 180	android/os/SystemClock:uptimeMillis	()J
    //   596: lload_3
    //   597: lsub
    //   598: lstore_3
    //   599: new 222	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   606: astore_1
    //   607: new 222	java/lang/StringBuilder
    //   610: dup
    //   611: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   614: astore 7
    //   616: goto -436 -> 180
    //   619: aload_1
    //   620: aconst_null
    //   621: putfield 201	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   624: new 222	java/lang/StringBuilder
    //   627: dup
    //   628: ldc_w 279
    //   631: invokespecial 263	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   634: astore 7
    //   636: aload_0
    //   637: getfield 83	com/tencent/component/media/image/region/RegionBitmapDecoder:mRegionDecoder	Landroid/graphics/BitmapRegionDecoder;
    //   640: ifnull +486 -> 1126
    //   643: new 222	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   650: astore 8
    //   652: aload 8
    //   654: aload_0
    //   655: getfield 83	com/tencent/component/media/image/region/RegionBitmapDecoder:mRegionDecoder	Landroid/graphics/BitmapRegionDecoder;
    //   658: invokevirtual 266	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   661: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   664: pop
    //   665: aload 8
    //   667: ldc_w 268
    //   670: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload 8
    //   676: aload_0
    //   677: getfield 83	com/tencent/component/media/image/region/RegionBitmapDecoder:mRegionDecoder	Landroid/graphics/BitmapRegionDecoder;
    //   680: invokevirtual 271	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   683: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: aload 8
    //   689: ldc_w 273
    //   692: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: aload 8
    //   698: aload_0
    //   699: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   702: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload 7
    //   708: aload 8
    //   710: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   713: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: pop
    //   717: goto +3 -> 720
    //   720: ldc_w 275
    //   723: aload 7
    //   725: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   728: invokestatic 242	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: aload_1
    //   732: getfield 201	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   735: astore 7
    //   737: aload_1
    //   738: aload 9
    //   740: getfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   743: putfield 204	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mDecodeSample	I
    //   746: aload 7
    //   748: ifnull +32 -> 780
    //   751: aload 7
    //   753: invokevirtual 207	android/graphics/Bitmap:isRecycled	()Z
    //   756: ifne +24 -> 780
    //   759: aload_0
    //   760: getfield 209	com/tencent/component/media/image/region/RegionBitmapDecoder:mCallback	Ljava/lang/ref/WeakReference;
    //   763: invokevirtual 215	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   766: checkcast 217	com/tencent/component/media/image/region/RegionBitmapDecoder$OnUpdateCallback
    //   769: astore_1
    //   770: aload_1
    //   771: ifnull +9 -> 780
    //   774: aload_1
    //   775: invokeinterface 220 1 0
    //   780: aload 7
    //   782: ifnonnull +14 -> 796
    //   785: new 222	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   792: astore_1
    //   793: goto -662 -> 131
    //   796: invokestatic 180	android/os/SystemClock:uptimeMillis	()J
    //   799: lstore 5
    //   801: new 222	java/lang/StringBuilder
    //   804: dup
    //   805: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   808: astore_1
    //   809: new 222	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   816: astore 7
    //   818: aload 7
    //   820: ldc 244
    //   822: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: aload 7
    //   828: lload 5
    //   830: lload_3
    //   831: lsub
    //   832: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload 7
    //   838: ldc 249
    //   840: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: pop
    //   844: aload 7
    //   846: aload 9
    //   848: getfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   851: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: aload 7
    //   857: ldc 254
    //   859: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: pop
    //   863: aload 7
    //   865: aload_0
    //   866: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   869: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   872: pop
    //   873: aload 7
    //   875: ldc_w 256
    //   878: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   881: pop
    //   882: goto -641 -> 241
    //   885: astore 7
    //   887: ldc_w 256
    //   890: astore 8
    //   892: aload_1
    //   893: getfield 201	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mBitmap	Landroid/graphics/Bitmap;
    //   896: astore 10
    //   898: aload_1
    //   899: aload 9
    //   901: getfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   904: putfield 204	com/tencent/component/media/image/region/RegionBitmapDecoder$DrawData:mDecodeSample	I
    //   907: aload 10
    //   909: ifnull +32 -> 941
    //   912: aload 10
    //   914: invokevirtual 207	android/graphics/Bitmap:isRecycled	()Z
    //   917: ifne +24 -> 941
    //   920: aload_0
    //   921: getfield 209	com/tencent/component/media/image/region/RegionBitmapDecoder:mCallback	Ljava/lang/ref/WeakReference;
    //   924: invokevirtual 215	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   927: checkcast 217	com/tencent/component/media/image/region/RegionBitmapDecoder$OnUpdateCallback
    //   930: astore_1
    //   931: aload_1
    //   932: ifnull +9 -> 941
    //   935: aload_1
    //   936: invokeinterface 220 1 0
    //   941: aload 10
    //   943: ifnonnull +39 -> 982
    //   946: new 222	java/lang/StringBuilder
    //   949: dup
    //   950: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   953: astore_1
    //   954: aload_1
    //   955: ldc 225
    //   957: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: pop
    //   961: aload_1
    //   962: aload_0
    //   963: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   966: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   969: pop
    //   970: ldc 11
    //   972: aload_1
    //   973: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: invokestatic 242	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   979: goto +120 -> 1099
    //   982: invokestatic 180	android/os/SystemClock:uptimeMillis	()J
    //   985: lstore 5
    //   987: new 222	java/lang/StringBuilder
    //   990: dup
    //   991: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   994: astore_1
    //   995: new 222	java/lang/StringBuilder
    //   998: dup
    //   999: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   1002: astore 10
    //   1004: aload 10
    //   1006: ldc 244
    //   1008: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: pop
    //   1012: aload 10
    //   1014: lload 5
    //   1016: lload_3
    //   1017: lsub
    //   1018: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: aload 10
    //   1024: ldc 249
    //   1026: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: pop
    //   1030: aload 10
    //   1032: aload 9
    //   1034: getfield 193	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1037: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: aload 10
    //   1043: ldc 254
    //   1045: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload 10
    //   1051: aload_0
    //   1052: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   1055: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1058: pop
    //   1059: aload 10
    //   1061: aload 8
    //   1063: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: pop
    //   1067: aload 10
    //   1069: aload_0
    //   1070: getfield 45	com/tencent/component/media/image/region/RegionBitmapDecoder:mTmp	Landroid/graphics/Rect;
    //   1073: invokevirtual 136	android/graphics/Rect:width	()I
    //   1076: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1079: pop
    //   1080: aload_1
    //   1081: aload 10
    //   1083: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: pop
    //   1090: ldc 11
    //   1092: aload_1
    //   1093: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1096: invokestatic 259	com/tencent/component/media/utils/ImageManagerLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1099: aload 7
    //   1101: athrow
    //   1102: ldc 11
    //   1104: ldc_w 281
    //   1107: invokestatic 259	com/tencent/component/media/utils/ImageManagerLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1110: return
    //   1111: astore 7
    //   1113: goto -494 -> 619
    //   1116: astore 7
    //   1118: goto -635 -> 483
    //   1121: astore 7
    //   1123: goto -839 -> 284
    //   1126: goto -406 -> 720
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1129	0	this	RegionBitmapDecoder
    //   0	1129	1	paramDrawData	RegionBitmapDecoder.DrawData
    //   0	1129	2	paramInt	int
    //   25	992	3	l1	long
    //   799	216	5	l2	long
    //   4	252	7	localObject1	Object
    //   274	1	7	localObject2	Object
    //   299	575	7	localObject3	Object
    //   885	215	7	localObject4	Object
    //   1111	1	7	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   1116	1	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1121	1	7	localRuntimeException	RuntimeException
    //   279	783	8	localObject5	Object
    //   44	989	9	localOptions	android.graphics.BitmapFactory.Options
    //   896	186	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   52	69	274	finally
    //   284	382	274	finally
    //   382	392	274	finally
    //   483	528	274	finally
    //   619	652	274	finally
    //   652	717	885	finally
    //   720	731	885	finally
    //   52	69	1111	java/lang/IllegalArgumentException
    //   52	69	1116	java/lang/OutOfMemoryError
    //   52	69	1121	java/lang/RuntimeException
  }
  
  private void initRegionDecoder()
  {
    BitmapRegionDecoder localBitmapRegionDecoder = this.mRegionDecoder;
    if ((localBitmapRegionDecoder == null) || (localBitmapRegionDecoder.isRecycled()))
    {
      if (TextUtils.isEmpty(this.mImagePath)) {
        break label267;
      }
      try
      {
        this.mRegionDecoder = BitmapRegionDecoder.newInstance(this.mImagePath, true);
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Init BitmapRegionDecoder failure exception , is SharpP = ");
        localStringBuilder.append(SharpPUtils.isSharpP(new File(this.mImagePath)));
        ImageManagerLog.e("RegionBitmapDecoder", localStringBuilder.toString());
        this.mRegionDecoder = null;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        ImageManagerLog.e("RegionBitmapDecoder", "Init BitmapRegionDecoder failure FileNotFoundException");
      }
    }
    try
    {
      this.mRegionDecoder = BitmapRegionDecoder.newInstance(Uri.parse(this.mImagePath).getPath(), true);
    }
    catch (Exception localException2)
    {
      label132:
      Object localObject;
      break label132;
    }
    ImageManagerLog.e("RegionBitmapDecoder", "Init BitmapRegionDecoder failure exception");
    this.mRegionDecoder = null;
    localObject = this.mRegionDecoder;
    if (localObject != null)
    {
      this.mOrgImageWidth = ((BitmapRegionDecoder)localObject).getWidth();
      this.mOrgimageHeight = this.mRegionDecoder.getHeight();
      processImageSize();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("origin image size ");
      ((StringBuilder)localObject).append(this.mRegionDecoder.getWidth());
      ((StringBuilder)localObject).append("x");
      ((StringBuilder)localObject).append(this.mRegionDecoder.getHeight());
      ((StringBuilder)localObject).append(" mRotation = ");
      ((StringBuilder)localObject).append(this.mRotation);
      ImageManagerLog.i("RegionBitmapDecoder", ((StringBuilder)localObject).toString());
    }
    if (this.mRegionDecoder == null) {
      ImageManagerLog.e("RegionBitmapDecoder", "BitmapRegionDecoder object is null");
    }
    return;
    label267:
    throw new RuntimeException("Image path is null");
  }
  
  private void processImageSize()
  {
    if ((this.mOrgImageWidth != 0) && (this.mOrgimageHeight != 0))
    {
      if (TextUtils.isEmpty(this.mImagePath)) {
        return;
      }
      if (this.mRotation == -1) {
        this.mRotation = RegionImageUtil.getRotation(this.mImagePath);
      }
      int i = this.mRotation;
      if ((i <= 45) || (i >= 135))
      {
        i = this.mRotation;
        if ((i <= 225) || (i >= 315)) {}
      }
      else
      {
        j = 1;
        break label88;
      }
      int j = 0;
      label88:
      if (j == 0) {
        i = this.mOrgImageWidth;
      } else {
        i = this.mOrgimageHeight;
      }
      if (j == 0) {
        j = this.mOrgimageHeight;
      } else {
        j = this.mOrgImageWidth;
      }
      this.mOrgImageWidth = i;
      this.mOrgimageHeight = j;
    }
  }
  
  private void recycleRegionBitmap()
  {
    Iterator localIterator = this.mDataList.entrySet().iterator();
    while (localIterator.hasNext())
    {
      RegionBitmapDecoder.DrawData localDrawData = (RegionBitmapDecoder.DrawData)((Map.Entry)localIterator.next()).getValue();
      if ((localDrawData != null) && (localDrawData.mBitmap != null))
      {
        localDrawData.mBitmap.recycle();
        localDrawData.mBitmap = null;
      }
    }
    this.mDataList.clear();
  }
  
  private Rect rotateRect(Rect paramRect)
  {
    if (this.mOrgImageWidth != 0)
    {
      if (this.mOrgimageHeight == 0) {
        return paramRect;
      }
      if (this.mRotation == -1) {
        this.mRotation = RegionImageUtil.getRotation(this.mImagePath);
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("rotateRect mRotation = ");
      ((StringBuilder)localObject).append(this.mRotation);
      ImageManagerLog.w("RegionBitmapDecoder", ((StringBuilder)localObject).toString());
      if (this.mExifMatrix == null)
      {
        this.mExifMatrix = new Matrix();
        int i = this.mRotation;
        if (i != -270)
        {
          if (i != -180)
          {
            if (i != -90)
            {
              if (i == 90) {
                break label229;
              }
              if (i == 180) {
                break label197;
              }
              if (i != 270)
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("rotateRect mRotation = ");
                ((StringBuilder)localObject).append(this.mRotation);
                ImageManagerLog.e("RegionBitmapDecoder", ((StringBuilder)localObject).toString());
                break label254;
              }
            }
            this.mExifMatrix.postRotate(90.0F);
            this.mExifMatrix.postTranslate(this.mOrgimageHeight, 0.0F);
            break label254;
          }
          label197:
          this.mExifMatrix.postRotate(180.0F);
          this.mExifMatrix.postTranslate(this.mOrgImageWidth, this.mOrgimageHeight);
          break label254;
        }
        label229:
        this.mExifMatrix.postRotate(-90.0F);
        this.mExifMatrix.postTranslate(0.0F, this.mOrgImageWidth);
      }
      label254:
      if (this.mExifMatrix != null)
      {
        localObject = new RectF(paramRect);
        this.mExifMatrix.mapRect((RectF)localObject);
        ((RectF)localObject).round(paramRect);
      }
    }
    return paramRect;
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    synchronized (this.mDataLock)
    {
      if ((this.mDataList != null) && (!this.mDataList.isEmpty()))
      {
        Iterator localIterator = this.mDataList.entrySet().iterator();
        while (localIterator.hasNext())
        {
          RegionBitmapDecoder.DrawData localDrawData = (RegionBitmapDecoder.DrawData)((Map.Entry)localIterator.next()).getValue();
          if ((localDrawData.mBitmap != null) && (!localDrawData.mBitmap.isRecycled())) {
            paramCanvas.drawBitmap(localDrawData.mBitmap, null, localDrawData.mOrgRect, paramPaint);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramCanvas;
    }
  }
  
  public void recycle()
  {
    synchronized (this.mDataLock)
    {
      if ((this.mRegionDecoder != null) && (!this.mRegionDecoder.isRecycled()))
      {
        ImageManagerLog.i("RegionBitmapDecoder", "mRegionDecoder recycle");
        this.mRegionDecoder.recycle();
        this.mRegionDecoder = null;
      }
      recycleRegionBitmap();
      return;
    }
  }
  
  public void setOnUpdateCallback(RegionBitmapDecoder.OnUpdateCallback paramOnUpdateCallback)
  {
    this.mCallback = new WeakReference(paramOnUpdateCallback);
  }
  
  public void updateRegionBitmap(RegionDrawableData paramRegionDrawableData)
  {
    if (paramRegionDrawableData == null) {
      return;
    }
    if (this.mWorkHandler.hasMessages(1)) {
      this.mWorkHandler.removeMessages(1);
    }
    this.mCurrentTime = System.currentTimeMillis();
    paramRegionDrawableData.mTaskTime = this.mCurrentTime;
    RegionBitmapDecoder.WorkHandler localWorkHandler = this.mWorkHandler;
    localWorkHandler.sendMessage(localWorkHandler.obtainMessage(1, paramRegionDrawableData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionBitmapDecoder
 * JD-Core Version:    0.7.0.1
 */