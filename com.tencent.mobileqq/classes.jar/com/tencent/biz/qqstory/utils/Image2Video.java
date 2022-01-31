package com.tencent.biz.qqstory.utils;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EncodeConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;
import osy;

public class Image2Video
  implements ConvertRunnable.ConvertRunnableListener
{
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + "cache/";
  private Image2Video.EglHandlerThreadEx jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/imagevideo/";
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat, int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 1) || (paramBitmap == null)) {
      paramBitmap = null;
    }
    int i12;
    int i13;
    Bitmap localBitmap;
    do
    {
      return paramBitmap;
      i12 = paramBitmap.getWidth();
      i13 = paramBitmap.getHeight();
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, Math.round(i12 * paramFloat), Math.round(i13 * paramFloat), false);
      localBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
      int i14 = localBitmap.getWidth();
      int i15 = localBitmap.getHeight();
      paramBitmap = new int[i14 * i15];
      localBitmap.getPixels(paramBitmap, 0, i14, 0, 0, i14, i15);
      int i11 = i14 - 1;
      int i16 = i15 - 1;
      int i = i14 * i15;
      int i17 = paramInt + paramInt + 1;
      int[] arrayOfInt1 = new int[i];
      int[] arrayOfInt2 = new int[i];
      int[] arrayOfInt3 = new int[i];
      int[] arrayOfInt4 = new int[Math.max(i14, i15)];
      i = i17 + 1 >> 1;
      int j = i * i;
      int[] arrayOfInt5 = new int[j * 256];
      i = 0;
      while (i < j * 256)
      {
        arrayOfInt5[i] = (i / j);
        i += 1;
      }
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i17, 3 });
      int i18 = paramInt + 1;
      int i7 = 0;
      i = 0;
      int i6 = 0;
      int i8;
      int m;
      int n;
      int i1;
      int i2;
      int i3;
      int i4;
      int i5;
      int k;
      int i9;
      int[] arrayOfInt6;
      int i10;
      int i19;
      while (i6 < i15)
      {
        j = 0;
        i8 = -paramInt;
        m = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        k = 0;
        if (i8 <= paramInt)
        {
          i9 = paramBitmap[(Math.min(i11, Math.max(i8, 0)) + i)];
          arrayOfInt6 = arrayOfInt[(i8 + paramInt)];
          arrayOfInt6[0] = ((0xFF0000 & i9) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i9) >> 8);
          arrayOfInt6[2] = (i9 & 0xFF);
          i9 = i18 - Math.abs(i8);
          i5 += arrayOfInt6[0] * i9;
          i4 += arrayOfInt6[1] * i9;
          i3 += i9 * arrayOfInt6[2];
          if (i8 > 0)
          {
            m += arrayOfInt6[0];
            k += arrayOfInt6[1];
            j += arrayOfInt6[2];
          }
          for (;;)
          {
            i8 += 1;
            break;
            i2 += arrayOfInt6[0];
            i1 += arrayOfInt6[1];
            n += arrayOfInt6[2];
          }
        }
        i8 = i4;
        i10 = 0;
        i4 = paramInt;
        i9 = i5;
        i5 = i3;
        i3 = i10;
        while (i3 < i14)
        {
          arrayOfInt1[i] = arrayOfInt5[i9];
          arrayOfInt2[i] = arrayOfInt5[i8];
          arrayOfInt3[i] = arrayOfInt5[i5];
          arrayOfInt6 = arrayOfInt[((i4 - paramInt + i17) % i17)];
          int i20 = arrayOfInt6[0];
          i19 = arrayOfInt6[1];
          i10 = arrayOfInt6[2];
          if (i6 == 0) {
            arrayOfInt4[i3] = Math.min(i3 + paramInt + 1, i11);
          }
          int i21 = paramBitmap[(arrayOfInt4[i3] + i7)];
          arrayOfInt6[0] = ((0xFF0000 & i21) >> 16);
          arrayOfInt6[1] = ((0xFF00 & i21) >> 8);
          arrayOfInt6[2] = (i21 & 0xFF);
          m += arrayOfInt6[0];
          k += arrayOfInt6[1];
          j += arrayOfInt6[2];
          i9 = i9 - i2 + m;
          i8 = i8 - i1 + k;
          i5 = i5 - n + j;
          i4 = (i4 + 1) % i17;
          arrayOfInt6 = arrayOfInt[(i4 % i17)];
          i2 = i2 - i20 + arrayOfInt6[0];
          i1 = i1 - i19 + arrayOfInt6[1];
          n = n - i10 + arrayOfInt6[2];
          m -= arrayOfInt6[0];
          k -= arrayOfInt6[1];
          j -= arrayOfInt6[2];
          i += 1;
          i3 += 1;
        }
        i7 += i14;
        i6 += 1;
      }
      i = 0;
      while (i < i14)
      {
        i5 = 0;
        i7 = -paramInt * i14;
        i6 = -paramInt;
        i3 = 0;
        n = 0;
        i1 = 0;
        i2 = 0;
        j = 0;
        m = 0;
        k = 0;
        i4 = 0;
        if (i6 <= paramInt)
        {
          i8 = Math.max(0, i7) + i;
          arrayOfInt6 = arrayOfInt[(i6 + paramInt)];
          arrayOfInt6[0] = arrayOfInt1[i8];
          arrayOfInt6[1] = arrayOfInt2[i8];
          arrayOfInt6[2] = arrayOfInt3[i8];
          i9 = i18 - Math.abs(i6);
          i10 = arrayOfInt1[i8];
          i11 = arrayOfInt2[i8];
          i19 = arrayOfInt3[i8];
          if (i6 > 0)
          {
            i3 += arrayOfInt6[0];
            i4 += arrayOfInt6[1];
            i5 += arrayOfInt6[2];
          }
          for (;;)
          {
            i8 = i7;
            if (i6 < i16) {
              i8 = i7 + i14;
            }
            i6 += 1;
            j = i19 * i9 + j;
            m = i11 * i9 + m;
            k = i10 * i9 + k;
            i7 = i8;
            break;
            i2 += arrayOfInt6[0];
            i1 += arrayOfInt6[1];
            n += arrayOfInt6[2];
          }
        }
        i9 = m;
        i10 = k;
        i11 = 0;
        k = i;
        i6 = i5;
        i7 = i4;
        i8 = i3;
        m = n;
        n = i1;
        i1 = i2;
        i2 = paramInt;
        i5 = i10;
        i4 = i9;
        i3 = j;
        j = i11;
        while (j < i15)
        {
          paramBitmap[k] = (0xFF000000 & paramBitmap[k] | arrayOfInt5[i5] << 16 | arrayOfInt5[i4] << 8 | arrayOfInt5[i3]);
          arrayOfInt6 = arrayOfInt[((i2 - paramInt + i17) % i17)];
          i11 = arrayOfInt6[0];
          i10 = arrayOfInt6[1];
          i9 = arrayOfInt6[2];
          if (i == 0) {
            arrayOfInt4[j] = (Math.min(j + i18, i16) * i14);
          }
          i19 = arrayOfInt4[j] + i;
          arrayOfInt6[0] = arrayOfInt1[i19];
          arrayOfInt6[1] = arrayOfInt2[i19];
          arrayOfInt6[2] = arrayOfInt3[i19];
          i8 += arrayOfInt6[0];
          i7 += arrayOfInt6[1];
          i6 += arrayOfInt6[2];
          i5 = i5 - i1 + i8;
          i4 = i4 - n + i7;
          i3 = i3 - m + i6;
          i2 = (i2 + 1) % i17;
          arrayOfInt6 = arrayOfInt[i2];
          i1 = i1 - i11 + arrayOfInt6[0];
          n = n - i10 + arrayOfInt6[1];
          m = m - i9 + arrayOfInt6[2];
          i8 -= arrayOfInt6[0];
          i7 -= arrayOfInt6[1];
          i6 -= arrayOfInt6[2];
          k += i14;
          j += 1;
        }
        i += 1;
      }
      localBitmap.setPixels(paramBitmap, 0, i14, 0, 0, i14, i15);
      paramBitmap = localBitmap;
    } while (!paramBoolean);
    return Bitmap.createScaledBitmap(localBitmap, i12, i13, true);
  }
  
  @TargetApi(16)
  public static MediaFormat a()
  {
    EncodeConfig localEncodeConfig = new EncodeConfig("", 720, 1280, SVParamManager.a().a(1) * 1000, 1, false, 0);
    MediaFormat localMediaFormat = MediaFormat.createVideoFormat("video/avc", 720, 1280);
    localMediaFormat.setInteger("color-format", 2130708361);
    localMediaFormat.setByteBuffer("csd-0", ByteBuffer.wrap(new byte[] { 0, 0, 0, 1, 103, 66, -128, 31, -38, 2, -48, 40, 105, 72, 40, 48, 40, 54, -123, 9, -88 }));
    localMediaFormat.setByteBuffer("csd-1", ByteBuffer.wrap(new byte[] { 0, 0, 0, 1, 104, -50, 6, -30 }));
    localMediaFormat.setInteger("bitrate", localEncodeConfig.c);
    localMediaFormat.setInteger("frame-rate", localEncodeConfig.d);
    localMediaFormat.setInteger("i-frame-interval", localEncodeConfig.e);
    return localMediaFormat;
  }
  
  public static String a()
  {
    String str = jdField_a_of_type_JavaLangString + "/noaudio";
    FileUtils.c(str);
    return str;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.Image2Video", 2, "clearCache start");
    }
    FileUtil.c(b);
  }
  
  private void a(osy paramosy)
  {
    if (paramosy != null)
    {
      localImage2VideoListener = (Image2Video.Image2VideoListener)paramosy.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localImage2VideoListener != null)
      {
        localResultInfo = new Image2Video.ResultInfo();
        localResultInfo.jdField_a_of_type_Long = paramosy.jdField_a_of_type_Long;
        localResultInfo.jdField_a_of_type_Int = 2;
        localResultInfo.b = null;
        localResultInfo.jdField_a_of_type_JavaLangString = paramosy.jdField_a_of_type_JavaLangString;
        localResultInfo.jdField_a_of_type_AndroidMediaMediaFormat = null;
        localImage2VideoListener.a(localResultInfo);
      }
    }
    while (!QLog.isColorLevel())
    {
      Image2Video.Image2VideoListener localImage2VideoListener;
      Image2Video.ResultInfo localResultInfo;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.home.Image2Video", 2, "fireCancelEventByContext, listener is null");
      return;
    }
    QLog.d("Q.qqstory.home.Image2Video", 2, "fireCancelEventByContext, convertcontex is null");
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
        {
          osy localosy = (osy)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
          if (localosy == null) {
            return;
          }
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localosy.jdField_a_of_type_Long), localosy);
          ConvertRunnable localConvertRunnable = new ConvertRunnable(localosy.jdField_a_of_type_Long, localosy.jdField_a_of_type_JavaLangString, localosy.jdField_b_of_type_Int, localosy.c, localosy.jdField_b_of_type_Long, this.jdField_a_of_type_Boolean, this);
          if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx != null)
          {
            localosy.jdField_a_of_type_ComTencentBizQqstoryUtilsConvertRunnable = localConvertRunnable;
            this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx.a().post(localConvertRunnable);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.Image2Video", 2, "tryStartPendingTask, taskid:" + localosy.jdField_a_of_type_Long);
          }
          return;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.Image2Video", 2, "tryStartPendingTask, no pending task:");
      }
    }
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx.a();
  }
  
  /* Error */
  public Image2Video.ResultInfo a(String paramString, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, @javax.annotation.Nonnull Image2Video.Image2VideoListener paramImage2VideoListener)
  {
    // Byte code:
    //   0: new 258	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo
    //   3: dup
    //   4: invokespecial 259	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:<init>	()V
    //   7: astore 8
    //   9: aload 8
    //   11: aload_0
    //   12: getfield 59	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   15: lconst_1
    //   16: invokevirtual 333	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   19: putfield 263	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Long	J
    //   22: aload 8
    //   24: aload_1
    //   25: putfield 268	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   28: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +74 -> 105
    //   34: ldc 232
    //   36: iconst_2
    //   37: new 18	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 335
    //   47: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload 8
    //   52: getfield 263	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Long	J
    //   55: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   58: ldc_w 337
    //   61: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc_w 339
    //   71: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: iload_2
    //   75: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: ldc_w 344
    //   81: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload_3
    //   85: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: ldc_w 346
    //   91: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: lload 4
    //   96: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_0
    //   106: getfield 306	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/utils/Image2Video$EglHandlerThreadEx;
    //   109: ifnonnull +41 -> 150
    //   112: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +12 -> 127
    //   118: ldc 232
    //   120: iconst_2
    //   121: ldc_w 348
    //   124: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload 8
    //   129: iconst_3
    //   130: putfield 265	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Int	I
    //   133: aload 7
    //   135: ifnull +12 -> 147
    //   138: aload 7
    //   140: aload 8
    //   142: invokeinterface 274 2 0
    //   147: aload 8
    //   149: areturn
    //   150: aload_1
    //   151: invokestatic 354	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifeq +41 -> 195
    //   157: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +12 -> 172
    //   163: ldc 232
    //   165: iconst_2
    //   166: ldc_w 356
    //   169: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload 8
    //   174: iconst_4
    //   175: putfield 265	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Int	I
    //   178: aload 7
    //   180: ifnull +12 -> 192
    //   183: aload 7
    //   185: aload 8
    //   187: invokeinterface 274 2 0
    //   192: aload 8
    //   194: areturn
    //   195: aload 8
    //   197: iconst_1
    //   198: putfield 265	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Int	I
    //   201: aload_0
    //   202: monitorenter
    //   203: aload_0
    //   204: getfield 306	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/utils/Image2Video$EglHandlerThreadEx;
    //   207: ifnull +134 -> 341
    //   210: aload_0
    //   211: getfield 69	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   214: invokevirtual 281	java/util/LinkedList:size	()I
    //   217: ifne +129 -> 346
    //   220: aload_0
    //   221: getfield 64	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   224: invokevirtual 357	java/util/HashMap:size	()I
    //   227: iconst_1
    //   228: if_icmpge +118 -> 346
    //   231: new 296	com/tencent/biz/qqstory/utils/ConvertRunnable
    //   234: dup
    //   235: aload 8
    //   237: getfield 263	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Long	J
    //   240: aload_1
    //   241: iload_2
    //   242: iload_3
    //   243: lload 4
    //   245: iload 6
    //   247: aload_0
    //   248: invokespecial 304	com/tencent/biz/qqstory/utils/ConvertRunnable:<init>	(JLjava/lang/String;IIJZLcom/tencent/biz/qqstory/utils/ConvertRunnable$ConvertRunnableListener;)V
    //   251: astore 9
    //   253: new 245	osy
    //   256: dup
    //   257: aload 8
    //   259: getfield 263	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Long	J
    //   262: aload_1
    //   263: iload_2
    //   264: iload_3
    //   265: lload 4
    //   267: aload 9
    //   269: aload 7
    //   271: invokespecial 360	osy:<init>	(JLjava/lang/String;IIJLcom/tencent/biz/qqstory/utils/ConvertRunnable;Lcom/tencent/biz/qqstory/utils/Image2Video$Image2VideoListener;)V
    //   274: astore_1
    //   275: aload_0
    //   276: getfield 64	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   279: aload 8
    //   281: getfield 263	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Long	J
    //   284: invokestatic 290	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   287: aload_1
    //   288: invokevirtual 294	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   291: pop
    //   292: aload_0
    //   293: getfield 306	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/utils/Image2Video$EglHandlerThreadEx;
    //   296: invokevirtual 314	com/tencent/biz/qqstory/utils/Image2Video$EglHandlerThreadEx:a	()Landroid/os/Handler;
    //   299: aload 9
    //   301: invokevirtual 320	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   304: pop
    //   305: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +33 -> 341
    //   311: ldc 232
    //   313: iconst_2
    //   314: new 18	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   321: ldc_w 362
    //   324: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 8
    //   329: getfield 263	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Long	J
    //   332: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   335: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload_0
    //   342: monitorexit
    //   343: aload 8
    //   345: areturn
    //   346: new 245	osy
    //   349: dup
    //   350: aload 8
    //   352: getfield 263	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Long	J
    //   355: aload_1
    //   356: iload_2
    //   357: iload_3
    //   358: lload 4
    //   360: aconst_null
    //   361: aload 7
    //   363: invokespecial 360	osy:<init>	(JLjava/lang/String;IIJLcom/tencent/biz/qqstory/utils/ConvertRunnable;Lcom/tencent/biz/qqstory/utils/Image2Video$Image2VideoListener;)V
    //   366: astore_1
    //   367: aload_0
    //   368: getfield 69	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   371: aload_1
    //   372: invokevirtual 366	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   375: pop
    //   376: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq -38 -> 341
    //   382: ldc 232
    //   384: iconst_2
    //   385: new 18	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   392: ldc_w 368
    //   395: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload 8
    //   400: getfield 263	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Long	J
    //   403: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: goto -71 -> 341
    //   415: astore_1
    //   416: aload_0
    //   417: monitorexit
    //   418: aload_1
    //   419: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	this	Image2Video
    //   0	420	1	paramString	String
    //   0	420	2	paramInt1	int
    //   0	420	3	paramInt2	int
    //   0	420	4	paramLong	long
    //   0	420	6	paramBoolean	boolean
    //   0	420	7	paramImage2VideoListener	Image2Video.Image2VideoListener
    //   7	392	8	localResultInfo	Image2Video.ResultInfo
    //   251	49	9	localConvertRunnable	ConvertRunnable
    // Exception table:
    //   from	to	target	type
    //   203	341	415	finally
    //   341	343	415	finally
    //   346	412	415	finally
    //   416	418	415	finally
  }
  
  /* Error */
  public Image2Video.ResultInfo a(String paramString, Image2Video.Image2VideoListener paramImage2VideoListener)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +23 -> 24
    //   4: aload_0
    //   5: aload_1
    //   6: sipush 720
    //   9: sipush 1280
    //   12: ldc2_w 373
    //   15: aload_0
    //   16: getfield 52	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_Boolean	Z
    //   19: aload_2
    //   20: invokevirtual 376	com/tencent/biz/qqstory/utils/Image2Video:a	(Ljava/lang/String;IIJZLcom/tencent/biz/qqstory/utils/Image2Video$Image2VideoListener;)Lcom/tencent/biz/qqstory/utils/Image2Video$ResultInfo;
    //   23: areturn
    //   24: new 258	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo
    //   27: dup
    //   28: invokespecial 259	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:<init>	()V
    //   31: astore_2
    //   32: new 378	osx
    //   35: dup
    //   36: aload_0
    //   37: aload_2
    //   38: invokespecial 381	osx:<init>	(Lcom/tencent/biz/qqstory/utils/Image2Video;Lcom/tencent/biz/qqstory/utils/Image2Video$ResultInfo;)V
    //   41: astore 4
    //   43: aload_0
    //   44: aload_1
    //   45: sipush 720
    //   48: sipush 1280
    //   51: ldc2_w 373
    //   54: aload_0
    //   55: getfield 52	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_Boolean	Z
    //   58: aload 4
    //   60: invokevirtual 376	com/tencent/biz/qqstory/utils/Image2Video:a	(Ljava/lang/String;IIJZLcom/tencent/biz/qqstory/utils/Image2Video$Image2VideoListener;)Lcom/tencent/biz/qqstory/utils/Image2Video$ResultInfo;
    //   63: astore_1
    //   64: aload_2
    //   65: monitorenter
    //   66: aload_1
    //   67: getfield 265	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Int	I
    //   70: iconst_1
    //   71: if_icmpne +20 -> 91
    //   74: aload_2
    //   75: getfield 265	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Int	I
    //   78: istore_3
    //   79: iload_3
    //   80: iconst_m1
    //   81: if_icmpne +10 -> 91
    //   84: aload_2
    //   85: ldc2_w 382
    //   88: invokevirtual 386	java/lang/Object:wait	(J)V
    //   91: aload_2
    //   92: monitorexit
    //   93: aload_1
    //   94: getfield 263	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Long	J
    //   97: aload_2
    //   98: getfield 263	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Long	J
    //   101: lcmp
    //   102: ifne +3 -> 105
    //   105: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +32 -> 140
    //   111: ldc 232
    //   113: iconst_2
    //   114: new 18	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 388
    //   124: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_1
    //   128: getfield 263	com/tencent/biz/qqstory/utils/Image2Video$ResultInfo:jdField_a_of_type_Long	J
    //   131: invokevirtual 325	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   134: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_2
    //   141: areturn
    //   142: astore_1
    //   143: aload_2
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    //   147: astore 4
    //   149: goto -58 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	Image2Video
    //   0	152	1	paramString	String
    //   0	152	2	paramImage2VideoListener	Image2Video.Image2VideoListener
    //   78	4	3	i	int
    //   41	18	4	localosx	osx
    //   147	1	4	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   66	79	142	finally
    //   84	91	142	finally
    //   91	93	142	finally
    //   143	145	142	finally
    //   84	91	147	java/lang/InterruptedException
  }
  
  public void a(Image2Video.ResultInfo paramResultInfo)
  {
    if (paramResultInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.Image2Video", 2, "onConvertResult, resultinfo is null!!!");
      }
    }
    Object localObject;
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.home.Image2Video", 2, "onConvertResult, taskId:" + paramResultInfo.jdField_a_of_type_Long + ", resultcode:" + paramResultInfo.jdField_a_of_type_Int + ", image:" + paramResultInfo.jdField_a_of_type_JavaLangString + ". destfile:" + paramResultInfo.b);
          }
          try
          {
            localObject = (osy)this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramResultInfo.jdField_a_of_type_Long));
            if (localObject == null)
            {
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.qqstory.home.Image2Video", 2, "onConvertResult, task not exist.");
            }
          }
          finally {}
        }
        if (paramResultInfo.jdField_a_of_type_Int != 7) {
          break;
        }
        if (((osy)localObject).d < osy.jdField_a_of_type_Int)
        {
          ((osy)localObject).d += 1;
          ((osy)localObject).jdField_a_of_type_ComTencentBizQqstoryUtilsConvertRunnable = null;
          try
          {
            this.jdField_a_of_type_JavaUtilLinkedList.add(localObject);
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqstory.home.Image2Video", 2, "onConvertResult, retrytimes:" + ((osy)localObject).d + " , add to pendinglist");
            }
            return;
          }
          finally {}
        }
        localObject = (Image2Video.Image2VideoListener)((osy)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      ((Image2Video.Image2VideoListener)localObject).a(paramResultInfo);
      return;
      if (paramResultInfo.jdField_a_of_type_Int == 0) {
        d();
      }
      localObject = (Image2Video.Image2VideoListener)((osy)localObject).jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject == null);
    ((Image2Video.Image2VideoListener)localObject).a(paramResultInfo);
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 232
    //   8: iconst_2
    //   9: ldc_w 412
    //   12: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: invokevirtual 414	com/tencent/biz/qqstory/utils/Image2Video:b	()V
    //   19: aload_0
    //   20: monitorenter
    //   21: aload_0
    //   22: new 311	com/tencent/biz/qqstory/utils/Image2Video$EglHandlerThreadEx
    //   25: dup
    //   26: ldc_w 416
    //   29: aconst_null
    //   30: aload_0
    //   31: invokespecial 419	com/tencent/biz/qqstory/utils/Image2Video$EglHandlerThreadEx:<init>	(Ljava/lang/String;Landroid/opengl/EGLContext;Ljava/lang/Object;)V
    //   34: putfield 306	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/utils/Image2Video$EglHandlerThreadEx;
    //   37: aload_0
    //   38: getfield 306	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/utils/Image2Video$EglHandlerThreadEx;
    //   41: invokevirtual 422	com/tencent/biz/qqstory/utils/Image2Video$EglHandlerThreadEx:start	()V
    //   44: aload_0
    //   45: getfield 306	com/tencent/biz/qqstory/utils/Image2Video:jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/utils/Image2Video$EglHandlerThreadEx;
    //   48: invokevirtual 424	com/tencent/biz/qqstory/utils/Image2Video$EglHandlerThreadEx:a	()Z
    //   51: istore_1
    //   52: iload_1
    //   53: ifne +10 -> 63
    //   56: aload_0
    //   57: ldc2_w 425
    //   60: invokevirtual 386	java/lang/Object:wait	(J)V
    //   63: aload_0
    //   64: monitorexit
    //   65: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +12 -> 80
    //   71: ldc 232
    //   73: iconst_2
    //   74: ldc_w 428
    //   77: invokestatic 237	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: iconst_1
    //   81: ireturn
    //   82: astore_2
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_2
    //   86: athrow
    //   87: astore_2
    //   88: goto -25 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	Image2Video
    //   51	2	1	bool	boolean
    //   82	4	2	localObject	Object
    //   87	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   21	52	82	finally
    //   56	63	82	finally
    //   63	65	82	finally
    //   83	85	82	finally
    //   56	63	87	java/lang/InterruptedException
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.Image2Video", 2, "uninit..");
    }
    c();
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx.quitSafely();
        this.jdField_a_of_type_ComTencentBizQqstoryUtilsImage2Video$EglHandlerThreadEx = null;
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator;
    osy localosy;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.home.Image2Video", 2, "stopAll, runningTask:" + this.jdField_a_of_type_JavaUtilHashMap.size() + " pendingtask:" + this.jdField_a_of_type_JavaUtilLinkedList.size());
      }
      localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        localosy = (osy)localIterator.next();
        if ((localosy != null) && (localosy.jdField_a_of_type_ComTencentBizQqstoryUtilsConvertRunnable != null)) {
          localosy.jdField_a_of_type_ComTencentBizQqstoryUtilsConvertRunnable.c();
        }
        localLinkedList.add(localosy);
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
      localObject.addAll(this.jdField_a_of_type_JavaUtilLinkedList);
    }
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.home.Image2Video", 2, "stopAll, fireevent count:" + localObject.size());
    }
    if (localObject.size() > 0)
    {
      localIterator = localObject.iterator();
      while (localIterator.hasNext())
      {
        localosy = (osy)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.home.Image2Video", 2, "stopAll, fireevent taskid:" + localosy.jdField_a_of_type_Long);
        }
        a(localosy);
      }
      localObject.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.Image2Video
 * JD-Core Version:    0.7.0.1
 */