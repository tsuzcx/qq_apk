package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import bheg;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import qdk;
import qdm;
import qdn;
import tlo;
import tls;
import tlu;
import tlv;
import tlw;
import tmb;
import tmd;
import usq;

public class RunningJob
  implements Runnable
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  DiskCache jdField_a_of_type_ComTencentMobileqqTransfileDiskCache;
  File jdField_a_of_type_JavaIoFile;
  Set<WeakReference<tlu>> jdField_a_of_type_JavaUtilSet = new HashSet();
  tlo jdField_a_of_type_Tlo;
  tlv jdField_a_of_type_Tlv;
  public tlw a;
  usq jdField_a_of_type_Usq;
  
  static
  {
    jdField_a_of_type_JavaLangString = "zimage." + RunningJob.class.getSimpleName();
  }
  
  public RunningJob(tlv paramtlv, tlw paramtlw)
  {
    this.jdField_a_of_type_Tlv = paramtlv;
    this.jdField_a_of_type_Tlw = paramtlw;
    this.jdField_a_of_type_Tlo = paramtlv.jdField_a_of_type_Tlo;
    this.jdField_a_of_type_ComTencentMobileqqTransfileDiskCache = new DiskCache(URLDrawableHelper.diskCachePath);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label42;
          }
          m = j;
        }
      }
    }
    label42:
    int k;
    label66:
    do
    {
      do
      {
        return m;
        j = Math.min(paramOptions.outHeight, 2048);
        k = Math.min(paramOptions.outWidth, 2048);
        m = i;
      } while (j <= paramInt2);
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      i <<= 1;
      k >>= 1;
      j >>= 1;
      break label66;
      n = m;
    }
  }
  
  /* Error */
  private Bitmap a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: iconst_0
    //   7: istore_1
    //   8: aload_0
    //   9: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   12: instanceof 121
    //   15: ifeq +83 -> 98
    //   18: new 123	java/io/ByteArrayInputStream
    //   21: dup
    //   22: aload_0
    //   23: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   26: checkcast 121	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile
    //   29: invokevirtual 127	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile:getBytes	()[B
    //   32: invokespecial 130	java/io/ByteArrayInputStream:<init>	([B)V
    //   35: astore 5
    //   37: aload 5
    //   39: astore 8
    //   41: new 123	java/io/ByteArrayInputStream
    //   44: dup
    //   45: aload_0
    //   46: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   49: checkcast 121	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile
    //   52: invokevirtual 127	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile:getBytes	()[B
    //   55: invokespecial 130	java/io/ByteArrayInputStream:<init>	([B)V
    //   58: astore 7
    //   60: aload_0
    //   61: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   64: checkcast 121	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile
    //   67: invokevirtual 133	com/tencent/biz/pubaccount/readinjoy/imageopt/RIJImageOptBitmapFile:getLength	()J
    //   70: lstore_2
    //   71: aload_0
    //   72: aload 5
    //   74: aload 7
    //   76: lload_2
    //   77: iload_1
    //   78: invokevirtual 136	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;Ljava/io/InputStream;JZ)Landroid/graphics/Bitmap;
    //   81: astore 4
    //   83: aload_0
    //   84: aload 5
    //   86: invokespecial 139	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;)V
    //   89: aload_0
    //   90: aload 7
    //   92: invokespecial 139	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;)V
    //   95: aload 4
    //   97: areturn
    //   98: new 141	java/io/FileInputStream
    //   101: dup
    //   102: aload_0
    //   103: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   106: invokespecial 142	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   109: astore 5
    //   111: aload 5
    //   113: astore 8
    //   115: new 141	java/io/FileInputStream
    //   118: dup
    //   119: aload_0
    //   120: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   123: invokespecial 142	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   126: astore 7
    //   128: aload_0
    //   129: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   132: invokevirtual 147	java/io/File:length	()J
    //   135: lstore_2
    //   136: aload_0
    //   137: invokevirtual 150	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	()Z
    //   140: istore_1
    //   141: goto -70 -> 71
    //   144: astore 6
    //   146: aconst_null
    //   147: astore 5
    //   149: new 152	java/lang/RuntimeException
    //   152: dup
    //   153: new 23	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   160: ldc 154
    //   162: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 6
    //   167: invokevirtual 155	java/lang/Exception:toString	()Ljava/lang/String;
    //   170: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 158	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   179: athrow
    //   180: astore 7
    //   182: aload 5
    //   184: astore 6
    //   186: aload 4
    //   188: astore 5
    //   190: aload 7
    //   192: astore 4
    //   194: aload_0
    //   195: aload 5
    //   197: invokespecial 139	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;)V
    //   200: aload_0
    //   201: aload 6
    //   203: invokespecial 139	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;)V
    //   206: aload 4
    //   208: athrow
    //   209: astore 4
    //   211: aconst_null
    //   212: astore 5
    //   214: goto -20 -> 194
    //   217: astore 4
    //   219: aload 8
    //   221: astore 5
    //   223: goto -29 -> 194
    //   226: astore 4
    //   228: aload 7
    //   230: astore 6
    //   232: goto -38 -> 194
    //   235: astore 4
    //   237: aload 7
    //   239: astore 6
    //   241: goto -47 -> 194
    //   244: astore 4
    //   246: aload 7
    //   248: astore 6
    //   250: goto -56 -> 194
    //   253: astore 6
    //   255: aconst_null
    //   256: astore 7
    //   258: aload 5
    //   260: astore 4
    //   262: aload 7
    //   264: astore 5
    //   266: goto -117 -> 149
    //   269: astore 6
    //   271: aload 5
    //   273: astore 4
    //   275: aload 7
    //   277: astore 5
    //   279: goto -130 -> 149
    //   282: astore 6
    //   284: aconst_null
    //   285: astore 7
    //   287: aload 5
    //   289: astore 4
    //   291: aload 7
    //   293: astore 5
    //   295: goto -146 -> 149
    //   298: astore 6
    //   300: aload 5
    //   302: astore 4
    //   304: aload 7
    //   306: astore 5
    //   308: goto -159 -> 149
    //   311: astore 6
    //   313: aload 5
    //   315: astore 4
    //   317: aload 7
    //   319: astore 5
    //   321: goto -172 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	RunningJob
    //   7	134	1	bool	boolean
    //   70	66	2	l	long
    //   4	203	4	localObject1	Object
    //   209	1	4	localObject2	Object
    //   217	1	4	localObject3	Object
    //   226	1	4	localObject4	Object
    //   235	1	4	localObject5	Object
    //   244	1	4	localObject6	Object
    //   260	56	4	localObject7	Object
    //   35	285	5	localObject8	Object
    //   1	1	6	localObject9	Object
    //   144	22	6	localException1	Exception
    //   184	65	6	localObject10	Object
    //   253	1	6	localException2	Exception
    //   269	1	6	localException3	Exception
    //   282	1	6	localException4	Exception
    //   298	1	6	localException5	Exception
    //   311	1	6	localException6	Exception
    //   58	69	7	localObject11	Object
    //   180	67	7	localObject12	Object
    //   256	62	7	localObject13	Object
    //   39	181	8	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   8	37	144	java/lang/Exception
    //   98	111	144	java/lang/Exception
    //   149	180	180	finally
    //   8	37	209	finally
    //   98	111	209	finally
    //   41	60	217	finally
    //   115	128	217	finally
    //   60	71	226	finally
    //   128	141	235	finally
    //   71	83	244	finally
    //   41	60	253	java/lang/Exception
    //   60	71	269	java/lang/Exception
    //   115	128	282	java/lang/Exception
    //   128	141	298	java/lang/Exception
    //   71	83	311	java/lang/Exception
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (this.jdField_a_of_type_Tlw.jdField_c_of_type_Int == 1) {
      localBitmap = bheg.c(paramBitmap, this.jdField_a_of_type_Tlw.jdField_a_of_type_Int, this.jdField_a_of_type_Tlw.jdField_b_of_type_Int);
    }
    return localBitmap;
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  private Bitmap a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aload 4
    //   8: astore 5
    //   10: iload_1
    //   11: ifeq +299 -> 310
    //   14: aload 4
    //   16: astore 5
    //   18: aload_0
    //   19: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   22: ifnull +288 -> 310
    //   25: aload 4
    //   27: astore 5
    //   29: aload_0
    //   30: getfield 70	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlw	Ltlw;
    //   33: ifnull +277 -> 310
    //   36: aload 4
    //   38: astore 5
    //   40: getstatic 182	android/os/Build$VERSION:SDK_INT	I
    //   43: bipush 19
    //   45: if_icmplt +265 -> 310
    //   48: getstatic 187	qdn:a	Lqdn;
    //   51: aload_0
    //   52: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   55: invokevirtual 190	java/io/File:getPath	()Ljava/lang/String;
    //   58: invokevirtual 193	qdn:a	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   61: astore 5
    //   63: aload 6
    //   65: astore 4
    //   67: aload 5
    //   69: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   72: iconst_m1
    //   73: if_icmpeq +215 -> 288
    //   76: aload 6
    //   78: astore 4
    //   80: aload 5
    //   82: getfield 101	android/graphics/BitmapFactory$Options:outHeight	I
    //   85: iconst_m1
    //   86: if_icmpeq +202 -> 288
    //   89: aload 5
    //   91: aload_0
    //   92: getfield 70	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlw	Ltlw;
    //   95: getfield 165	tlw:jdField_a_of_type_Int	I
    //   98: aload_0
    //   99: getfield 70	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlw	Ltlw;
    //   102: getfield 168	tlw:jdField_b_of_type_Int	I
    //   105: invokestatic 195	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   108: istore_3
    //   109: aload 5
    //   111: getfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   114: iload_3
    //   115: idiv
    //   116: istore_2
    //   117: aload 5
    //   119: getfield 101	android/graphics/BitmapFactory$Options:outHeight	I
    //   122: iload_3
    //   123: idiv
    //   124: istore_3
    //   125: aload 5
    //   127: iload_2
    //   128: putfield 110	android/graphics/BitmapFactory$Options:outWidth	I
    //   131: aload 5
    //   133: iload_3
    //   134: putfield 101	android/graphics/BitmapFactory$Options:outHeight	I
    //   137: aload 5
    //   139: iconst_1
    //   140: putfield 198	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   143: aload 5
    //   145: iconst_1
    //   146: putfield 202	android/graphics/BitmapFactory$Options:inMutable	Z
    //   149: aload_0
    //   150: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlo	Ltlo;
    //   153: aload 5
    //   155: invokevirtual 207	tlo:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   158: astore 6
    //   160: aload 6
    //   162: ifnull +74 -> 236
    //   165: getstatic 43	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: iconst_2
    //   169: new 23	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   176: ldc 209
    //   178: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 6
    //   183: invokevirtual 215	android/graphics/Bitmap:getWidth	()I
    //   186: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: ldc 220
    //   191: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 6
    //   196: invokevirtual 223	android/graphics/Bitmap:getHeight	()I
    //   199: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc 225
    //   204: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: iload_2
    //   208: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc 220
    //   213: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: iload_3
    //   217: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: aload 6
    //   228: iload_2
    //   229: iload_3
    //   230: getstatic 237	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   233: invokevirtual 241	android/graphics/Bitmap:reconfigure	(IILandroid/graphics/Bitmap$Config;)V
    //   236: getstatic 187	qdn:a	Lqdn;
    //   239: aload_0
    //   240: getfield 119	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   243: invokevirtual 190	java/io/File:getPath	()Ljava/lang/String;
    //   246: iload_2
    //   247: iload_3
    //   248: aload 6
    //   250: invokevirtual 244	qdn:a	(Ljava/lang/String;IILandroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   253: astore 5
    //   255: aload 5
    //   257: astore 4
    //   259: aload 6
    //   261: ifnull +27 -> 288
    //   264: aload 5
    //   266: astore 4
    //   268: aload 5
    //   270: aload 6
    //   272: if_acmpeq +16 -> 288
    //   275: getstatic 43	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   278: iconst_2
    //   279: ldc 246
    //   281: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload 5
    //   286: astore 4
    //   288: aload 4
    //   290: astore 5
    //   292: aload 4
    //   294: ifnonnull +16 -> 310
    //   297: getstatic 43	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   300: iconst_1
    //   301: ldc 248
    //   303: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 4
    //   308: astore 5
    //   310: aload 5
    //   312: areturn
    //   313: astore 5
    //   315: aconst_null
    //   316: astore 4
    //   318: getstatic 43	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   321: iconst_1
    //   322: aload 5
    //   324: invokevirtual 251	java/lang/Error:getMessage	()Ljava/lang/String;
    //   327: invokestatic 231	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   330: goto -42 -> 288
    //   333: astore 6
    //   335: aload 5
    //   337: astore 4
    //   339: aload 6
    //   341: astore 5
    //   343: goto -25 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	RunningJob
    //   0	346	1	paramBoolean	boolean
    //   116	131	2	i	int
    //   108	140	3	j	int
    //   1	337	4	localObject1	Object
    //   8	303	5	localObject2	Object
    //   313	23	5	localError1	java.lang.Error
    //   341	1	5	localError2	java.lang.Error
    //   4	267	6	localBitmap	Bitmap
    //   333	7	6	localError3	java.lang.Error
    // Exception table:
    //   from	to	target	type
    //   48	63	313	java/lang/Error
    //   67	76	313	java/lang/Error
    //   80	160	313	java/lang/Error
    //   165	236	313	java/lang/Error
    //   236	255	313	java/lang/Error
    //   275	284	333	java/lang/Error
  }
  
  @TargetApi(11)
  private BitmapFactory.Options a(InputStream paramInputStream)
  {
    byte[] arrayOfByte1 = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    try
    {
      if (this.jdField_a_of_type_Tlo.jdField_a_of_type_JavaUtilList.size() > 0) {
        arrayOfByte1 = (byte[])this.jdField_a_of_type_Tlo.jdField_a_of_type_JavaUtilList.remove(0);
      }
      byte[] arrayOfByte2 = arrayOfByte1;
      if (arrayOfByte1 == null)
      {
        arrayOfByte1 = new byte[16384];
        arrayOfByte2 = arrayOfByte1;
        if (QLog.isColorLevel())
        {
          tmd.a(jdField_a_of_type_JavaLangString, "allocate temp storage");
          arrayOfByte2 = arrayOfByte1;
        }
      }
      localOptions.inTempStorage = arrayOfByte2;
      localOptions.inJustDecodeBounds = true;
      localOptions.inJustDecodeBounds = false;
    }
    finally
    {
      try
      {
        BitmapFactory.decodeStream(new BufferedInputStream(paramInputStream), null, localOptions);
        if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1)) {
          break label184;
        }
        throw new IllegalArgumentException("decode bounds fail");
      }
      catch (OutOfMemoryError paramInputStream)
      {
        this.jdField_a_of_type_Tlo.jdField_a_of_type_JavaUtilList.add(localOptions.inTempStorage);
        throw paramInputStream;
      }
      catch (Exception paramInputStream)
      {
        this.jdField_a_of_type_Tlo.jdField_a_of_type_JavaUtilList.add(localOptions.inTempStorage);
        throw paramInputStream;
      }
      paramInputStream = finally;
    }
    label184:
    localOptions.inDither = true;
    localOptions.inPreferredConfig = this.jdField_a_of_type_Tlw.jdField_a_of_type_AndroidGraphicsBitmap$Config;
    if (Build.VERSION.SDK_INT >= 11) {
      localOptions.inMutable = true;
    }
    localOptions.inSampleSize = a(localOptions, this.jdField_a_of_type_Tlw.jdField_a_of_type_Int, this.jdField_a_of_type_Tlw.jdField_b_of_type_Int);
    return localOptions;
  }
  
  private Rect a(BitmapFactory.Options paramOptions)
  {
    int i = Math.min(paramOptions.outWidth, 2048);
    int j = Math.min(paramOptions.outHeight, 2048);
    int k = (paramOptions.outWidth - i) / 2;
    int m = (paramOptions.outHeight - j) / 2;
    return new Rect(k, m, i + k, j + m);
  }
  
  @NotNull
  private DownloadParams a()
  {
    DownloadParams localDownloadParams = new DownloadParams();
    localDownloadParams.url = this.jdField_a_of_type_Tlw.jdField_a_of_type_JavaNetURL;
    localDownloadParams.urlStr = this.jdField_a_of_type_Tlw.jdField_a_of_type_JavaNetURL.toString();
    localDownloadParams.retryCount = this.jdField_a_of_type_Tlw.jdField_f_of_type_Int;
    return localDownloadParams;
  }
  
  private File a(DownloadParams paramDownloadParams, StringBuilder paramStringBuilder)
  {
    return this.jdField_a_of_type_Usq.loadImageFile(paramDownloadParams, new tmb(this, paramStringBuilder));
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_Tlw != null) {
      this.jdField_a_of_type_Tlw.jdField_e_of_type_Long = paramLong;
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Tlv.a(this.jdField_a_of_type_Tlw);
    paramBitmap = new tls(a(paramBitmap), this.jdField_a_of_type_Tlo.jdField_a_of_type_Tma);
    this.jdField_a_of_type_Tlo.a(this.jdField_a_of_type_Tlw, paramBitmap);
    if (this.jdField_a_of_type_Tlw.jdField_a_of_type_Boolean)
    {
      qdm.a(6, this.jdField_a_of_type_Tlw);
      qdm.a(this.jdField_a_of_type_Tlw, false, "cancelled");
      paramBitmap.a();
      return;
    }
    qdm.a(5, this.jdField_a_of_type_Tlw);
    if (qdk.a.c())
    {
      this.jdField_a_of_type_AndroidOsHandler.postAtFrontOfQueue(new RunningJob.2(this, paramBitmap));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RunningJob.3(this, paramBitmap));
  }
  
  private void a(Bitmap paramBitmap, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Tlw != null)
    {
      this.jdField_a_of_type_Tlw.jdField_f_of_type_Long = paramLong2;
      QLog.d(jdField_a_of_type_JavaLangString, 1, "[decode success](" + paramLong2 + ") total(" + (paramLong1 - this.jdField_a_of_type_Long) + ")" + this.jdField_a_of_type_Tlw + "; size =" + paramBitmap.getByteCount());
    }
  }
  
  private void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramBitmap);
      return;
    }
    d(new RuntimeException("bitmap null"));
  }
  
  private void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, paramInputStream.getMessage());
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    try
    {
      if (c(paramThrowable))
      {
        a(paramThrowable, -3);
        return;
      }
      if (b(paramThrowable))
      {
        c(paramThrowable);
        return;
      }
    }
    catch (Exception paramThrowable)
    {
      d(paramThrowable);
      return;
    }
    if (a(paramThrowable))
    {
      b(paramThrowable);
      return;
    }
    d(paramThrowable);
  }
  
  private void a(Throwable paramThrowable, int paramInt)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "[job fail] failCode:" + paramInt + this.jdField_a_of_type_Tlw + " " + paramThrowable + " retryCount:" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Tlw.jdField_e_of_type_Int == -2) {
      this.jdField_a_of_type_Tlw.jdField_e_of_type_Int = paramInt;
    }
    this.jdField_a_of_type_Tlv.a(this.jdField_a_of_type_Tlw);
    if (this.jdField_a_of_type_Tlw.jdField_a_of_type_Boolean)
    {
      qdm.a(6, this.jdField_a_of_type_Tlw);
      qdm.a(this.jdField_a_of_type_Tlw, false, "cancelled");
    }
    for (;;)
    {
      return;
      Object localObject2;
      if (this.jdField_a_of_type_Tlw.jdField_f_of_type_Int == tlw.g)
      {
        localObject2 = this.jdField_a_of_type_Tlw;
        if (paramThrowable == null) {
          break label166;
        }
      }
      label166:
      for (Object localObject1 = paramThrowable.getMessage();; localObject1 = "")
      {
        qdm.a((tlw)localObject2, false, (String)localObject1);
        if (!e()) {
          break;
        }
        e(paramThrowable);
        return;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeakReference)((Iterator)localObject1).next();
        if (((WeakReference)localObject2).get() != null) {
          this.jdField_a_of_type_AndroidOsHandler.post(new RunningJob.4(this, (WeakReference)localObject2, paramThrowable));
        }
      }
    }
  }
  
  private void a(tls paramtls)
  {
    if (this.jdField_a_of_type_Tlw.jdField_a_of_type_Boolean)
    {
      qdm.a(6, this.jdField_a_of_type_Tlw);
      qdm.a(this.jdField_a_of_type_Tlw, false, "cancelled");
      paramtls.a();
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((tlu)localWeakReference.get()).a(this.jdField_a_of_type_Tlw, paramtls.a());
      }
    }
    paramtls.a();
  }
  
  private static void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("showUseTime", Long.toString(paramLong));
    if (paramBoolean1)
    {
      str = "1";
      localHashMap.put("cached", str);
      if (!paramBoolean2) {
        break label96;
      }
    }
    label96:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("success", str);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actKandianImageShow", paramBoolean2, paramLong, paramInt, localHashMap, "", true);
      return;
      str = "2";
      break;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Bitmap localBitmap = a();
    long l = System.currentTimeMillis();
    paramLong1 = l - paramLong1;
    a(localBitmap, l, paramLong1);
    boolean bool;
    if (localBitmap != null)
    {
      bool = true;
      if ((!bool) || (localBitmap == null)) {
        break label77;
      }
    }
    label77:
    for (int i = localBitmap.getByteCount();; i = 0)
    {
      a(paramBoolean, paramLong1 + paramLong2, i, bool);
      a(localBitmap, bool);
      return;
      bool = false;
      break;
    }
  }
  
  private boolean a(Throwable paramThrowable)
  {
    return (paramThrowable.getMessage() != null) && ((((paramThrowable instanceof RuntimeException)) && (paramThrowable.getMessage().contains("decode fail"))) || (((paramThrowable instanceof IOException)) && (paramThrowable.getMessage().contains("write 0 length file or null File"))));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Tlw.jdField_a_of_type_Boolean) {
      throw new RuntimeException("cancel");
    }
  }
  
  private void b(Throwable paramThrowable)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, paramThrowable.getMessage() + " " + this.jdField_a_of_type_Tlw + " retryCount:" + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_JavaIoFile != null) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
      run();
      return;
    }
    a(paramThrowable, -3);
  }
  
  private boolean b()
  {
    for (;;)
    {
      try
      {
        if (d()) {
          return true;
        }
        this.jdField_a_of_type_Usq = new usq(BaseApplicationImpl.getApplication());
        Object localObject = a();
        boolean bool = this.jdField_a_of_type_Usq.hasDiskFile((DownloadParams)localObject);
        l1 = System.currentTimeMillis();
        this.jdField_a_of_type_JavaIoFile = a((DownloadParams)localObject, new StringBuilder());
        c();
        long l2 = System.currentTimeMillis();
        long l3 = l2 - l1;
        a(l3);
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder().append("[download success](").append(l3).append(")").append(this.jdField_a_of_type_Tlw).append(" fileSize:");
        if (this.jdField_a_of_type_JavaIoFile == null) {
          continue;
        }
        l1 = this.jdField_a_of_type_JavaIoFile.length();
        QLog.d((String)localObject, 2, l1);
        b();
        if (c()) {
          break label193;
        }
        a(bool, l2, l3);
      }
      catch (Throwable localThrowable)
      {
        long l1;
        a(localThrowable);
        continue;
      }
      return false;
      l1 = 0L;
    }
    label193:
    return true;
  }
  
  private boolean b(Throwable paramThrowable)
  {
    return (((paramThrowable instanceof RuntimeException)) || ((paramThrowable instanceof IOException))) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().contains("cancel"));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaIoFile == null) {
      throw new IOException("downloader fail");
    }
  }
  
  private void c(Throwable paramThrowable)
  {
    qdm.a(6, this.jdField_a_of_type_Tlw);
    qdm.a(this.jdField_a_of_type_Tlw, false, paramThrowable.getMessage());
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_Tlw.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilSet.isEmpty()))
    {
      this.jdField_a_of_type_Tlv.a(this.jdField_a_of_type_Tlw);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[preload request]" + this.jdField_a_of_type_Tlw + " no callback, give up decode");
      tlv.a().c(this.jdField_a_of_type_Tlw);
      return true;
    }
    return false;
  }
  
  private boolean c(Throwable paramThrowable)
  {
    return ((paramThrowable instanceof RuntimeException)) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().equals("sharpP decode fail"));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Tlw.d == 0) {
      qdm.b(2, this.jdField_a_of_type_Tlw);
    }
  }
  
  private void d(Throwable paramThrowable)
  {
    a(paramThrowable, -1);
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_Tlw.jdField_a_of_type_Boolean)
    {
      qdm.a(6, this.jdField_a_of_type_Tlw);
      tlv.a().c(this.jdField_a_of_type_Tlw);
      return true;
    }
    return false;
  }
  
  private void e(Throwable paramThrowable)
  {
    tlw localtlw = this.jdField_a_of_type_Tlw;
    localtlw.jdField_f_of_type_Int += 1;
    QLog.d(jdField_a_of_type_JavaLangString, 1, "try count: " + this.jdField_a_of_type_Tlw.jdField_f_of_type_Int + " " + this.jdField_a_of_type_Tlw);
    if (((paramThrowable != null) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().equals("sharpP decode fail"))) || (this.jdField_a_of_type_Tlw.jdField_e_of_type_Int == 400)) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "before convert: " + this.jdField_a_of_type_Tlw.jdField_a_of_type_JavaNetURL);
    }
    try
    {
      this.jdField_a_of_type_Tlw.jdField_a_of_type_JavaNetURL = new URL(qdn.a.b(this.jdField_a_of_type_Tlw.jdField_a_of_type_JavaNetURL.toString(), this.jdField_a_of_type_Tlw.jdField_c_of_type_JavaLangString));
      QLog.d(jdField_a_of_type_JavaLangString, 1, "after convert: " + this.jdField_a_of_type_Tlw.jdField_a_of_type_JavaNetURL);
      ThreadManager.getUIHandler().post(new RunningJob.5(this));
      return;
    }
    catch (Exception paramThrowable)
    {
      for (;;)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, paramThrowable.getMessage());
      }
    }
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_Tlw.jdField_f_of_type_Int < tlw.g;
  }
  
  public Bitmap a(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    if (tmd.a()) {
      return b(paramInputStream1, paramInputStream2, paramLong);
    }
    return c(paramInputStream1, paramInputStream2, paramLong);
  }
  
  protected Bitmap a(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong, boolean paramBoolean)
  {
    Bitmap localBitmap2 = a(paramBoolean);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = a(paramInputStream1, paramInputStream2, paramLong);
    }
    return localBitmap1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      tmd.a(jdField_a_of_type_JavaLangString, "[cancel request]" + this.jdField_a_of_type_Tlw);
    }
    this.jdField_a_of_type_Tlw.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Usq != null) {
      this.jdField_a_of_type_Usq.cancel();
    }
  }
  
  public void a(tlu paramtlu)
  {
    if (paramtlu != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilSet.add(new WeakReference(paramtlu));
      return;
    }
    finally
    {
      paramtlu = finally;
      throw paramtlu;
    }
  }
  
  protected boolean a()
  {
    try
    {
      if ((AVSoUtils.a()) && (qdk.a.g()))
      {
        qdn localqdn = qdn.a;
        if (this.jdField_a_of_type_Tlw.jdField_a_of_type_JavaNetURL != null) {}
        for (String str = this.jdField_a_of_type_Tlw.jdField_a_of_type_JavaNetURL.toString(); (localqdn.a(str)) && (SharpPUtil.isSharpPFile(this.jdField_a_of_type_JavaIoFile)); str = "") {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
    }
    return false;
  }
  
  /* Error */
  @TargetApi(21)
  public Bitmap b(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 713	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   5: astore_2
    //   6: invokestatic 276	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +45 -> 54
    //   12: getstatic 43	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: new 23	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 715
    //   25: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: getfield 70	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlw	Ltlw;
    //   32: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: ldc_w 717
    //   38: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_2
    //   42: getfield 198	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   45: invokevirtual 218	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 283	tmd:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlo	Ltlo;
    //   58: aload_2
    //   59: invokevirtual 207	tlo:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   62: astore 6
    //   64: aload 6
    //   66: ifnull +121 -> 187
    //   69: aload_2
    //   70: aload 6
    //   72: putfield 721	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   75: iconst_1
    //   76: istore 5
    //   78: new 291	java/io/BufferedInputStream
    //   81: dup
    //   82: aload_1
    //   83: invokespecial 293	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_1
    //   87: aload_2
    //   88: invokestatic 724	tmd:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   91: ifeq +58 -> 149
    //   94: aload_1
    //   95: iconst_0
    //   96: invokestatic 730	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   99: aload_0
    //   100: aload_2
    //   101: invokespecial 732	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   104: aload_2
    //   105: invokevirtual 736	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlo	Ltlo;
    //   113: getfield 262	tlo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   116: aload_2
    //   117: getfield 286	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   120: invokeinterface 308 2 0
    //   125: pop
    //   126: iload 5
    //   128: ifeq +57 -> 185
    //   131: aload 6
    //   133: aload_1
    //   134: if_acmpeq +51 -> 185
    //   137: aload_1
    //   138: invokevirtual 739	android/graphics/Bitmap:recycle	()V
    //   141: new 741	java/lang/IllegalStateException
    //   144: dup
    //   145: invokespecial 742	java/lang/IllegalStateException:<init>	()V
    //   148: athrow
    //   149: aload_1
    //   150: aconst_null
    //   151: aload_2
    //   152: invokestatic 299	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   155: astore_1
    //   156: goto -47 -> 109
    //   159: astore_1
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlo	Ltlo;
    //   167: getfield 262	tlo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   170: aload_2
    //   171: getfield 286	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   174: invokeinterface 308 2 0
    //   179: pop
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload_1
    //   184: athrow
    //   185: aload_1
    //   186: areturn
    //   187: iconst_0
    //   188: istore 5
    //   190: goto -112 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	RunningJob
    //   0	193	1	paramInputStream1	InputStream
    //   0	193	2	paramInputStream2	InputStream
    //   0	193	3	paramLong	long
    //   76	113	5	i	int
    //   62	70	6	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   78	109	159	java/lang/OutOfMemoryError
    //   149	156	159	java/lang/OutOfMemoryError
    //   78	109	162	finally
    //   149	156	162	finally
    //   160	162	162	finally
    //   183	185	162	finally
    //   78	109	182	java/lang/RuntimeException
    //   149	156	182	java/lang/RuntimeException
  }
  
  /* Error */
  public Bitmap c(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 8
    //   15: aconst_null
    //   16: astore 9
    //   18: aload_0
    //   19: aload_2
    //   20: invokespecial 713	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   23: astore 13
    //   25: aload 13
    //   27: getstatic 745	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:jdField_a_of_type_Boolean	Z
    //   30: putfield 748	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   33: lload_3
    //   34: l2i
    //   35: istore 5
    //   37: new 291	java/io/BufferedInputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 293	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore 6
    //   47: aload 6
    //   49: astore_2
    //   50: aload 12
    //   52: astore_1
    //   53: aload 11
    //   55: astore 7
    //   57: aload_0
    //   58: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlo	Ltlo;
    //   61: getfield 751	tlo:jdField_a_of_type_Tlq	Ltlq;
    //   64: iload 5
    //   66: invokevirtual 756	tlq:a	(I)[B
    //   69: astore 9
    //   71: aload 6
    //   73: astore_2
    //   74: aload 9
    //   76: astore_1
    //   77: aload 9
    //   79: astore 7
    //   81: aload 9
    //   83: astore 8
    //   85: aload 6
    //   87: aload 9
    //   89: iconst_0
    //   90: iload 5
    //   92: invokevirtual 760	java/io/InputStream:read	([BII)I
    //   95: pop
    //   96: aload 6
    //   98: astore_2
    //   99: aload 9
    //   101: astore_1
    //   102: aload 9
    //   104: astore 7
    //   106: aload 9
    //   108: astore 8
    //   110: aload 13
    //   112: invokestatic 724	tmd:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   115: ifeq +126 -> 241
    //   118: aload 6
    //   120: astore_2
    //   121: aload 9
    //   123: astore_1
    //   124: aload 9
    //   126: astore 7
    //   128: aload 9
    //   130: astore 8
    //   132: aload 9
    //   134: iconst_0
    //   135: iload 5
    //   137: iconst_0
    //   138: invokestatic 763	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   141: aload_0
    //   142: aload 13
    //   144: invokespecial 732	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   147: aload 13
    //   149: invokevirtual 736	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   152: astore 10
    //   154: aload 6
    //   156: astore_2
    //   157: aload 9
    //   159: astore_1
    //   160: aload 9
    //   162: astore 7
    //   164: aload 9
    //   166: astore 8
    //   168: getstatic 745	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:jdField_a_of_type_Boolean	Z
    //   171: ifeq +22 -> 193
    //   174: aload 6
    //   176: astore_2
    //   177: aload 9
    //   179: astore_1
    //   180: aload 9
    //   182: astore 7
    //   184: aload 9
    //   186: astore 8
    //   188: aload 10
    //   190: invokestatic 766	com/tencent/biz/pubaccount/readinjoy/view/imageloader/NativeBitmap:nativePinBitmap	(Landroid/graphics/Bitmap;)V
    //   193: aload 9
    //   195: ifnull +15 -> 210
    //   198: aload_0
    //   199: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlo	Ltlo;
    //   202: getfield 751	tlo:jdField_a_of_type_Tlq	Ltlq;
    //   205: aload 9
    //   207: invokevirtual 768	tlq:a	([B)V
    //   210: aload_0
    //   211: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlo	Ltlo;
    //   214: getfield 262	tlo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   217: aload 13
    //   219: getfield 286	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   222: invokeinterface 308 2 0
    //   227: pop
    //   228: aload 6
    //   230: ifnull +8 -> 238
    //   233: aload 6
    //   235: invokevirtual 457	java/io/InputStream:close	()V
    //   238: aload 10
    //   240: areturn
    //   241: aload 6
    //   243: astore_2
    //   244: aload 9
    //   246: astore_1
    //   247: aload 9
    //   249: astore 7
    //   251: aload 9
    //   253: astore 8
    //   255: aload 9
    //   257: iconst_0
    //   258: iload 5
    //   260: aload 13
    //   262: invokestatic 772	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   265: astore 10
    //   267: goto -113 -> 154
    //   270: astore_1
    //   271: aload_1
    //   272: invokevirtual 775	java/io/IOException:printStackTrace	()V
    //   275: aload 10
    //   277: areturn
    //   278: astore 7
    //   280: aconst_null
    //   281: astore_2
    //   282: aload 9
    //   284: astore_1
    //   285: aload 7
    //   287: athrow
    //   288: astore 7
    //   290: aload_1
    //   291: astore 6
    //   293: aload 7
    //   295: astore_1
    //   296: aload 6
    //   298: ifnull +15 -> 313
    //   301: aload_0
    //   302: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlo	Ltlo;
    //   305: getfield 751	tlo:jdField_a_of_type_Tlq	Ltlq;
    //   308: aload 6
    //   310: invokevirtual 768	tlq:a	([B)V
    //   313: aload_0
    //   314: getfield 75	com/tencent/biz/pubaccount/readinjoy/view/imageloader/RunningJob:jdField_a_of_type_Tlo	Ltlo;
    //   317: getfield 262	tlo:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   320: aload 13
    //   322: getfield 286	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   325: invokeinterface 308 2 0
    //   330: pop
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokevirtual 457	java/io/InputStream:close	()V
    //   339: aload_1
    //   340: athrow
    //   341: astore 8
    //   343: aconst_null
    //   344: astore_2
    //   345: aload 10
    //   347: astore_1
    //   348: aload 8
    //   350: athrow
    //   351: astore_2
    //   352: aload_2
    //   353: invokevirtual 775	java/io/IOException:printStackTrace	()V
    //   356: goto -17 -> 339
    //   359: astore_1
    //   360: aconst_null
    //   361: astore_2
    //   362: aload 7
    //   364: astore 6
    //   366: goto -70 -> 296
    //   369: astore 8
    //   371: aload 6
    //   373: astore_2
    //   374: aload 7
    //   376: astore_1
    //   377: goto -29 -> 348
    //   380: astore 7
    //   382: aload 6
    //   384: astore_2
    //   385: aload 8
    //   387: astore_1
    //   388: goto -103 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	this	RunningJob
    //   0	391	1	paramInputStream1	InputStream
    //   0	391	2	paramInputStream2	InputStream
    //   0	391	3	paramLong	long
    //   35	224	5	i	int
    //   45	338	6	localObject1	Object
    //   4	246	7	localObject2	Object
    //   278	8	7	localOutOfMemoryError1	OutOfMemoryError
    //   288	87	7	localObject3	Object
    //   380	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   13	241	8	localObject4	Object
    //   341	8	8	localException1	Exception
    //   369	17	8	localException2	Exception
    //   16	267	9	arrayOfByte	byte[]
    //   7	339	10	localBitmap	Bitmap
    //   10	44	11	localObject5	Object
    //   1	50	12	localObject6	Object
    //   23	298	13	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   233	238	270	java/io/IOException
    //   37	47	278	java/lang/OutOfMemoryError
    //   57	71	288	finally
    //   85	96	288	finally
    //   110	118	288	finally
    //   132	154	288	finally
    //   168	174	288	finally
    //   188	193	288	finally
    //   255	267	288	finally
    //   285	288	288	finally
    //   348	351	288	finally
    //   37	47	341	java/lang/Exception
    //   335	339	351	java/io/IOException
    //   37	47	359	finally
    //   57	71	369	java/lang/Exception
    //   85	96	369	java/lang/Exception
    //   110	118	369	java/lang/Exception
    //   132	154	369	java/lang/Exception
    //   168	174	369	java/lang/Exception
    //   188	193	369	java/lang/Exception
    //   255	267	369	java/lang/Exception
    //   57	71	380	java/lang/OutOfMemoryError
    //   85	96	380	java/lang/OutOfMemoryError
    //   110	118	380	java/lang/OutOfMemoryError
    //   132	154	380	java/lang/OutOfMemoryError
    //   168	174	380	java/lang/OutOfMemoryError
    //   188	193	380	java/lang/OutOfMemoryError
    //   255	267	380	java/lang/OutOfMemoryError
  }
  
  @TargetApi(12)
  public void run()
  {
    qdm.a(4, this.jdField_a_of_type_Tlw);
    tlv.a().b(this.jdField_a_of_type_Tlw);
    QLog.d(jdField_a_of_type_JavaLangString, 2, "[start request](" + (System.currentTimeMillis() - this.jdField_a_of_type_Long) + ")" + this.jdField_a_of_type_Tlw + " createTs:" + this.jdField_a_of_type_Long);
    if (b()) {
      return;
    }
    tlv.a().c(this.jdField_a_of_type_Tlw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.RunningJob
 * JD-Core Version:    0.7.0.1
 */