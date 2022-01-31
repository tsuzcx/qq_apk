package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.vas.FriendProfileCardBgInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import ukr;

public class FriendProfileCardBgDrawable
  extends Drawable
  implements Runnable
{
  public int a;
  public Resources a;
  public Bitmap a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public Handler a;
  public FriendProfileCardBgDrawable.DecodeNextFrameTask a;
  private FriendProfileCardBgInfo jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo;
  public Object a;
  public boolean a;
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public int b;
  public Bitmap b;
  private Rect b;
  public boolean b;
  public int c;
  private Bitmap c;
  public boolean c;
  private int jdField_d_of_type_Int;
  private Bitmap jdField_d_of_type_AndroidGraphicsBitmap;
  public boolean d;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int f;
  
  public FriendProfileCardBgDrawable(Resources paramResources, FriendProfileCardBgInfo paramFriendProfileCardBgInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 50;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo = paramFriendProfileCardBgInfo;
    if (paramFriendProfileCardBgInfo != null)
    {
      if (paramFriendProfileCardBgInfo.jdField_a_of_type_ArrayOfJavaLangString != null) {
        this.jdField_d_of_type_Boolean = true;
      }
      a(paramFriendProfileCardBgInfo.jdField_a_of_type_ArrayOfJavaLangString, paramFriendProfileCardBgInfo.jdField_b_of_type_Int, paramFriendProfileCardBgInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  static int a(Bitmap.Config paramConfig)
  {
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramConfig == Bitmap.Config.RGB_565);
      i = j;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo != null) && (this.jdField_d_of_type_Boolean))
    {
      float f1 = this.jdField_e_of_type_Int / paramInt1;
      float f2 = this.f / paramInt2;
      int i = (int)(this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo.jdField_a_of_type_Float * paramInt3);
      paramInt1 = (int)(this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo.jdField_b_of_type_Float * paramInt4);
      paramInt2 = (int)(this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo.c * paramInt3);
      paramInt3 = (int)(this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo.d * paramInt4);
      paramInt4 = (int)(i / f1);
      paramInt1 = (int)(paramInt1 / f2);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramInt4, paramInt1, (int)(paramInt2 / f1) + paramInt4, (int)(paramInt3 / f2) + paramInt1);
    }
  }
  
  /* Error */
  private void a(String[] paramArrayOfString, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 118	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   5: new 120	android/graphics/BitmapFactory$Options
    //   8: dup
    //   9: invokespecial 121	android/graphics/BitmapFactory$Options:<init>	()V
    //   12: astore 13
    //   14: aload 13
    //   16: iconst_1
    //   17: putfield 124	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   20: new 126	java/io/BufferedInputStream
    //   23: dup
    //   24: new 128	java/io/FileInputStream
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   32: invokespecial 134	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore 12
    //   37: aload 12
    //   39: astore_3
    //   40: aload 12
    //   42: aconst_null
    //   43: aload 13
    //   45: invokestatic 140	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   48: pop
    //   49: aload 12
    //   51: astore_3
    //   52: aload 13
    //   54: getfield 143	android/graphics/BitmapFactory$Options:outHeight	I
    //   57: istore 5
    //   59: aload 12
    //   61: astore_3
    //   62: aload 13
    //   64: getfield 146	android/graphics/BitmapFactory$Options:outWidth	I
    //   67: istore 6
    //   69: aload 12
    //   71: astore_3
    //   72: aload_0
    //   73: getfield 58	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_AndroidContentResResources	Landroid/content/res/Resources;
    //   76: invokevirtual 152	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   79: astore 13
    //   81: aload 12
    //   83: astore_3
    //   84: aload 13
    //   86: getfield 157	android/util/DisplayMetrics:widthPixels	I
    //   89: aload 13
    //   91: getfield 160	android/util/DisplayMetrics:heightPixels	I
    //   94: invokestatic 166	java/lang/Math:min	(II)I
    //   97: istore 7
    //   99: aload 12
    //   101: astore_3
    //   102: aload 13
    //   104: getfield 157	android/util/DisplayMetrics:widthPixels	I
    //   107: aload 13
    //   109: getfield 160	android/util/DisplayMetrics:heightPixels	I
    //   112: invokestatic 169	java/lang/Math:max	(II)I
    //   115: istore 8
    //   117: aload 12
    //   119: astore_3
    //   120: iload 7
    //   122: i2f
    //   123: iload 8
    //   125: i2f
    //   126: fdiv
    //   127: fstore 4
    //   129: aload 12
    //   131: astore_3
    //   132: iload 6
    //   134: iload 5
    //   136: i2f
    //   137: fload 4
    //   139: fmul
    //   140: f2i
    //   141: invokestatic 166	java/lang/Math:min	(II)I
    //   144: istore 9
    //   146: aload 12
    //   148: astore_3
    //   149: iload 9
    //   151: i2f
    //   152: fload 4
    //   154: fdiv
    //   155: f2i
    //   156: istore 10
    //   158: aload 12
    //   160: astore_3
    //   161: aload_0
    //   162: iload 9
    //   164: putfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   167: aload 12
    //   169: astore_3
    //   170: aload_0
    //   171: iload 10
    //   173: putfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   176: aload 12
    //   178: astore_3
    //   179: aload_0
    //   180: new 110	android/graphics/Rect
    //   183: dup
    //   184: iconst_0
    //   185: iconst_0
    //   186: iload 7
    //   188: iload 8
    //   190: invokespecial 112	android/graphics/Rect:<init>	(IIII)V
    //   193: putfield 171	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   196: aload 12
    //   198: astore_3
    //   199: aload_0
    //   200: getfield 67	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_Boolean	Z
    //   203: istore 11
    //   205: iload 11
    //   207: ifne +41 -> 248
    //   210: aload 12
    //   212: ifnull +8 -> 220
    //   215: aload 12
    //   217: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   220: return
    //   221: astore_1
    //   222: ldc 176
    //   224: iconst_1
    //   225: new 178	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   232: ldc 181
    //   234: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_1
    //   238: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: return
    //   248: aload 12
    //   250: astore_3
    //   251: aload_0
    //   252: iload 7
    //   254: iload 8
    //   256: iload 6
    //   258: iload 5
    //   260: invokespecial 199	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:a	(IIII)V
    //   263: aload 12
    //   265: astore_3
    //   266: aload_0
    //   267: aload_1
    //   268: arraylength
    //   269: putfield 201	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_Int	I
    //   272: aload 12
    //   274: astore_3
    //   275: aload_0
    //   276: iload_2
    //   277: putfield 32	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_b_of_type_Int	I
    //   280: aload 12
    //   282: astore_3
    //   283: aload_0
    //   284: ldc 202
    //   286: putfield 204	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_c_of_type_Int	I
    //   289: aload 12
    //   291: astore_3
    //   292: aload_0
    //   293: iconst_0
    //   294: putfield 206	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_c_of_type_Boolean	Z
    //   297: aload 12
    //   299: ifnull -79 -> 220
    //   302: aload 12
    //   304: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   307: return
    //   308: astore_1
    //   309: ldc 176
    //   311: iconst_1
    //   312: new 178	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   319: ldc 181
    //   321: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload_1
    //   325: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: return
    //   335: astore 13
    //   337: aconst_null
    //   338: astore_1
    //   339: aload_1
    //   340: astore_3
    //   341: ldc 176
    //   343: iconst_1
    //   344: new 178	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   351: ldc 208
    //   353: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 13
    //   358: invokevirtual 211	java/io/IOException:getMessage	()Ljava/lang/String;
    //   361: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload_1
    //   371: astore_3
    //   372: aload_0
    //   373: invokevirtual 213	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:a	()V
    //   376: aload_1
    //   377: ifnull -157 -> 220
    //   380: aload_1
    //   381: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   384: return
    //   385: astore_1
    //   386: ldc 176
    //   388: iconst_1
    //   389: new 178	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   396: ldc 181
    //   398: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_1
    //   402: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: return
    //   412: astore_1
    //   413: aconst_null
    //   414: astore_3
    //   415: aload_3
    //   416: ifnull +7 -> 423
    //   419: aload_3
    //   420: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   423: aload_1
    //   424: athrow
    //   425: astore_3
    //   426: ldc 176
    //   428: iconst_1
    //   429: new 178	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   436: ldc 181
    //   438: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: aload_3
    //   442: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: goto -28 -> 423
    //   454: astore_1
    //   455: goto -40 -> 415
    //   458: astore 13
    //   460: aload 12
    //   462: astore_1
    //   463: goto -124 -> 339
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	this	FriendProfileCardBgDrawable
    //   0	466	1	paramArrayOfString	String[]
    //   0	466	2	paramInt	int
    //   0	466	3	paramString	String
    //   127	26	4	f1	float
    //   57	202	5	i	int
    //   67	190	6	j	int
    //   97	156	7	k	int
    //   115	140	8	m	int
    //   144	19	9	n	int
    //   156	16	10	i1	int
    //   203	3	11	bool	boolean
    //   35	426	12	localBufferedInputStream	BufferedInputStream
    //   12	96	13	localObject	Object
    //   335	22	13	localIOException1	IOException
    //   458	1	13	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   215	220	221	java/io/IOException
    //   302	307	308	java/io/IOException
    //   0	37	335	java/io/IOException
    //   380	384	385	java/io/IOException
    //   0	37	412	finally
    //   419	423	425	java/io/IOException
    //   40	49	454	finally
    //   52	59	454	finally
    //   62	69	454	finally
    //   72	81	454	finally
    //   84	99	454	finally
    //   102	117	454	finally
    //   120	129	454	finally
    //   132	146	454	finally
    //   149	158	454	finally
    //   161	167	454	finally
    //   170	176	454	finally
    //   179	196	454	finally
    //   199	205	454	finally
    //   251	263	454	finally
    //   266	272	454	finally
    //   275	280	454	finally
    //   283	289	454	finally
    //   292	297	454	finally
    //   341	370	454	finally
    //   372	376	454	finally
    //   40	49	458	java/io/IOException
    //   52	59	458	java/io/IOException
    //   62	69	458	java/io/IOException
    //   72	81	458	java/io/IOException
    //   84	99	458	java/io/IOException
    //   102	117	458	java/io/IOException
    //   120	129	458	java/io/IOException
    //   132	146	458	java/io/IOException
    //   149	158	458	java/io/IOException
    //   161	167	458	java/io/IOException
    //   170	176	458	java/io/IOException
    //   179	196	458	java/io/IOException
    //   199	205	458	java/io/IOException
    //   251	263	458	java/io/IOException
    //   266	272	458	java/io/IOException
    //   275	280	458	java/io/IOException
    //   283	289	458	java/io/IOException
    //   292	297	458	java/io/IOException
  }
  
  @TargetApi(19)
  public static boolean a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      if (paramInt1 * paramInt2 * a(paramBitmap.getConfig()) > paramBitmap.getAllocationByteCount()) {}
    }
    while ((paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2))
    {
      return true;
      return false;
    }
    return false;
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: aload 5
    //   10: astore_2
    //   11: aload_3
    //   12: astore_1
    //   13: aload_0
    //   14: getfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   17: ifnonnull +102 -> 119
    //   20: aload_3
    //   21: astore_1
    //   22: new 178	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   29: ldc 245
    //   31: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   38: getfield 71	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore 6
    //   49: aload_3
    //   50: astore_1
    //   51: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   54: aload 6
    //   56: invokevirtual 257	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   59: checkcast 224	android/graphics/Bitmap
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +64 -> 128
    //   67: aload_3
    //   68: astore_1
    //   69: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +37 -> 109
    //   75: aload_3
    //   76: astore_1
    //   77: ldc 176
    //   79: iconst_2
    //   80: new 178	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 263
    //   90: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_0
    //   94: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   97: getfield 71	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   100: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_3
    //   110: astore_1
    //   111: aload_0
    //   112: aload_2
    //   113: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   116: aload 5
    //   118: astore_2
    //   119: aload_2
    //   120: ifnull +7 -> 127
    //   123: aload_2
    //   124: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   127: return
    //   128: aload_3
    //   129: astore_1
    //   130: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +37 -> 170
    //   136: aload_3
    //   137: astore_1
    //   138: ldc 176
    //   140: iconst_2
    //   141: new 178	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 267
    //   151: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   158: getfield 71	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   161: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_3
    //   171: astore_1
    //   172: new 120	android/graphics/BitmapFactory$Options
    //   175: dup
    //   176: invokespecial 121	android/graphics/BitmapFactory$Options:<init>	()V
    //   179: astore 5
    //   181: aload_3
    //   182: astore_1
    //   183: new 126	java/io/BufferedInputStream
    //   186: dup
    //   187: new 128	java/io/FileInputStream
    //   190: dup
    //   191: aload_0
    //   192: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   195: getfield 71	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   198: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   201: invokespecial 134	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   204: astore_2
    //   205: aload_2
    //   206: aconst_null
    //   207: aload 5
    //   209: invokestatic 140	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   212: astore_1
    //   213: aload 5
    //   215: getfield 146	android/graphics/BitmapFactory$Options:outWidth	I
    //   218: aload_0
    //   219: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   222: if_icmpne +36 -> 258
    //   225: aload 5
    //   227: getfield 143	android/graphics/BitmapFactory$Options:outHeight	I
    //   230: aload_0
    //   231: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   234: if_icmpne +24 -> 258
    //   237: aload_0
    //   238: aload_1
    //   239: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   242: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   245: aload 6
    //   247: aload_0
    //   248: getfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   251: invokevirtual 271	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   254: pop
    //   255: goto -136 -> 119
    //   258: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   261: ifeq +12 -> 273
    //   264: ldc 176
    //   266: iconst_2
    //   267: ldc_w 273
    //   270: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aload_1
    //   274: ifnull +151 -> 425
    //   277: aload_0
    //   278: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   281: ifle +73 -> 354
    //   284: aload_0
    //   285: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   288: ifle +66 -> 354
    //   291: aload_0
    //   292: aload_1
    //   293: iconst_0
    //   294: iconst_0
    //   295: aload_0
    //   296: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   299: aload_0
    //   300: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   303: invokestatic 277	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   306: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   309: aload_1
    //   310: invokevirtual 280	android/graphics/Bitmap:recycle	()V
    //   313: goto -71 -> 242
    //   316: astore_3
    //   317: aload_2
    //   318: astore_1
    //   319: ldc 176
    //   321: iconst_1
    //   322: new 178	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 282
    //   332: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_3
    //   336: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload_2
    //   346: ifnull -219 -> 127
    //   349: aload_2
    //   350: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   353: return
    //   354: aload_0
    //   355: aload_1
    //   356: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   359: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq -53 -> 309
    //   365: ldc 176
    //   367: iconst_2
    //   368: new 178	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   375: ldc_w 284
    //   378: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_0
    //   382: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   385: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: ldc_w 289
    //   391: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_0
    //   395: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   398: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   401: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: goto -98 -> 309
    //   410: astore_3
    //   411: aload_2
    //   412: astore_1
    //   413: aload_3
    //   414: astore_2
    //   415: aload_1
    //   416: ifnull +7 -> 423
    //   419: aload_1
    //   420: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   423: aload_2
    //   424: athrow
    //   425: ldc 176
    //   427: iconst_1
    //   428: ldc_w 291
    //   431: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: goto -192 -> 242
    //   437: astore_2
    //   438: goto -23 -> 415
    //   441: astore_3
    //   442: aload 4
    //   444: astore_2
    //   445: goto -128 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	this	FriendProfileCardBgDrawable
    //   12	408	1	localObject1	Object
    //   10	414	2	localObject2	Object
    //   437	1	2	localObject3	Object
    //   444	1	2	localObject4	Object
    //   4	178	3	localObject5	Object
    //   316	20	3	localThrowable1	java.lang.Throwable
    //   410	4	3	localObject6	Object
    //   441	1	3	localThrowable2	java.lang.Throwable
    //   1	442	4	localObject7	Object
    //   6	220	5	localOptions	BitmapFactory.Options
    //   47	199	6	str	String
    // Exception table:
    //   from	to	target	type
    //   205	242	316	java/lang/Throwable
    //   242	255	316	java/lang/Throwable
    //   258	273	316	java/lang/Throwable
    //   277	309	316	java/lang/Throwable
    //   309	313	316	java/lang/Throwable
    //   354	407	316	java/lang/Throwable
    //   425	434	316	java/lang/Throwable
    //   205	242	410	finally
    //   242	255	410	finally
    //   258	273	410	finally
    //   277	309	410	finally
    //   309	313	410	finally
    //   354	407	410	finally
    //   425	434	410	finally
    //   13	20	437	finally
    //   22	49	437	finally
    //   51	63	437	finally
    //   69	75	437	finally
    //   77	109	437	finally
    //   111	116	437	finally
    //   130	136	437	finally
    //   138	170	437	finally
    //   172	181	437	finally
    //   183	205	437	finally
    //   319	345	437	finally
    //   13	20	441	java/lang/Throwable
    //   22	49	441	java/lang/Throwable
    //   51	63	441	java/lang/Throwable
    //   69	75	441	java/lang/Throwable
    //   77	109	441	java/lang/Throwable
    //   111	116	441	java/lang/Throwable
    //   130	136	441	java/lang/Throwable
    //   138	170	441	java/lang/Throwable
    //   172	181	441	java/lang/Throwable
    //   183	205	441	java/lang/Throwable
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == this.jdField_d_of_type_Int - 1)
    {
      this.jdField_c_of_type_Int -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  public Bitmap a()
  {
    if (this.jdField_d_of_type_AndroidGraphicsBitmap == null) {}
    try
    {
      d();
      return this.jdField_d_of_type_AndroidGraphicsBitmap;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.e("FriendProfileCardBgDrawable", 2, "decode Bg error, e.message = " + localIOException.toString());
      }
    }
  }
  
  @TargetApi(11)
  protected Bitmap a(Object paramObject, int paramInt)
  {
    Object localObject = new BitmapFactory.Options();
    if (this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo != null)
    {
      d();
      if (this.jdField_d_of_type_Boolean) {}
    }
    else
    {
      return null;
    }
    paramObject = (String[])paramObject;
    paramInt = (paramInt + 1) % paramObject.length;
    String str = paramObject[paramInt];
    ((BitmapFactory.Options)localObject).inDensity = 320;
    ((BitmapFactory.Options)localObject).inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
    ((BitmapFactory.Options)localObject).inMutable = true;
    ((BitmapFactory.Options)localObject).inSampleSize = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    paramObject = new BufferedInputStream(new FileInputStream(paramObject[paramInt]));
    BitmapFactory.decodeStream(paramObject, null, localOptions);
    paramObject.close();
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
          break label246;
        }
        paramObject = this.jdField_c_of_type_AndroidGraphicsBitmap;
        this.jdField_c_of_type_AndroidGraphicsBitmap = null;
        if ((paramObject != null) && (Build.VERSION.SDK_INT > 11) && (a(paramObject, localOptions.outWidth, localOptions.outHeight)))
        {
          ((BitmapFactory.Options)localObject).inBitmap = paramObject;
          paramObject = new BufferedInputStream(new FileInputStream(str));
          localObject = BitmapFactory.decodeStream(paramObject, null, (BitmapFactory.Options)localObject);
          paramObject.close();
          return localObject;
        }
      }
      ((BitmapFactory.Options)localObject).inBitmap = null;
      if (paramObject != null)
      {
        paramObject.recycle();
        continue;
        label246:
        paramObject = null;
        continue;
        paramObject = null;
      }
    }
  }
  
  public void a()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      new Handler(Looper.getMainLooper()).post(new ukr(this));
      return;
    }
    b();
  }
  
  /* Error */
  public Bitmap b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   14: ifnonnull +127 -> 141
    //   17: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +12 -> 32
    //   23: ldc 176
    //   25: iconst_2
    //   26: ldc_w 342
    //   29: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_2
    //   33: astore_1
    //   34: new 178	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   41: ldc 245
    //   43: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   50: getfield 71	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   53: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 6
    //   61: aload_2
    //   62: astore_1
    //   63: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   66: aload 6
    //   68: invokevirtual 257	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 224	android/graphics/Bitmap
    //   74: astore 7
    //   76: aload 7
    //   78: ifnull +68 -> 146
    //   81: aload_2
    //   82: astore_1
    //   83: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +37 -> 123
    //   89: aload_2
    //   90: astore_1
    //   91: ldc 176
    //   93: iconst_2
    //   94: new 178	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 344
    //   104: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_0
    //   108: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   111: getfield 71	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   114: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_2
    //   124: astore_1
    //   125: aload_0
    //   126: aload 7
    //   128: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   131: aload_3
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   141: aload_0
    //   142: getfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   145: areturn
    //   146: aload_2
    //   147: astore_1
    //   148: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +37 -> 188
    //   154: aload_2
    //   155: astore_1
    //   156: ldc 176
    //   158: iconst_2
    //   159: new 178	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 346
    //   169: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_0
    //   173: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   176: getfield 71	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload_2
    //   189: astore_1
    //   190: new 120	android/graphics/BitmapFactory$Options
    //   193: dup
    //   194: invokespecial 121	android/graphics/BitmapFactory$Options:<init>	()V
    //   197: astore_3
    //   198: aload_2
    //   199: astore_1
    //   200: new 126	java/io/BufferedInputStream
    //   203: dup
    //   204: new 128	java/io/FileInputStream
    //   207: dup
    //   208: aload_0
    //   209: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   212: getfield 71	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   215: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   218: invokespecial 134	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   221: astore_2
    //   222: aload_2
    //   223: aconst_null
    //   224: aload_3
    //   225: invokestatic 140	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   228: astore_1
    //   229: aload_3
    //   230: getfield 146	android/graphics/BitmapFactory$Options:outWidth	I
    //   233: aload_0
    //   234: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   237: if_icmpne +37 -> 274
    //   240: aload_3
    //   241: getfield 143	android/graphics/BitmapFactory$Options:outHeight	I
    //   244: aload_0
    //   245: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   248: if_icmpne +26 -> 274
    //   251: aload_0
    //   252: aload_1
    //   253: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   256: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   259: aload 6
    //   261: aload_0
    //   262: getfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   265: invokevirtual 271	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   268: pop
    //   269: aload_2
    //   270: astore_1
    //   271: goto -138 -> 133
    //   274: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq +12 -> 289
    //   280: ldc 176
    //   282: iconst_2
    //   283: ldc_w 348
    //   286: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_1
    //   290: ifnull +241 -> 531
    //   293: aload_0
    //   294: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   297: ifle +108 -> 405
    //   300: aload_0
    //   301: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   304: ifle +101 -> 405
    //   307: aload_0
    //   308: aload_1
    //   309: iconst_0
    //   310: iconst_0
    //   311: aload_0
    //   312: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   315: aload_0
    //   316: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   319: invokestatic 277	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   322: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   325: aload_1
    //   326: invokevirtual 280	android/graphics/Bitmap:recycle	()V
    //   329: goto -73 -> 256
    //   332: astore_3
    //   333: aload_2
    //   334: astore_1
    //   335: ldc 176
    //   337: iconst_1
    //   338: new 178	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   345: ldc_w 350
    //   348: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_3
    //   352: invokevirtual 298	java/io/IOException:toString	()Ljava/lang/String;
    //   355: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload_2
    //   365: ifnull -224 -> 141
    //   368: aload_2
    //   369: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   372: goto -231 -> 141
    //   375: astore_1
    //   376: ldc 176
    //   378: iconst_1
    //   379: new 178	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   386: ldc_w 352
    //   389: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_1
    //   393: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: goto -261 -> 141
    //   405: aload_0
    //   406: aload_1
    //   407: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   410: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   413: ifeq -88 -> 325
    //   416: ldc 176
    //   418: iconst_2
    //   419: new 178	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 354
    //   429: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_0
    //   433: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   436: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   439: ldc_w 289
    //   442: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_0
    //   446: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   449: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   452: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: goto -133 -> 325
    //   461: astore_3
    //   462: aload_2
    //   463: astore_1
    //   464: ldc 176
    //   466: iconst_1
    //   467: new 178	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   474: ldc_w 356
    //   477: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: aload_3
    //   481: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: aload_2
    //   491: ifnull -350 -> 141
    //   494: aload_2
    //   495: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   498: goto -357 -> 141
    //   501: astore_1
    //   502: ldc 176
    //   504: iconst_1
    //   505: new 178	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   512: ldc_w 352
    //   515: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload_1
    //   519: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: goto -387 -> 141
    //   531: ldc 176
    //   533: iconst_1
    //   534: ldc_w 358
    //   537: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   540: goto -284 -> 256
    //   543: astore_3
    //   544: aload_2
    //   545: astore_1
    //   546: aload_3
    //   547: astore_2
    //   548: aload_1
    //   549: ifnull +7 -> 556
    //   552: aload_1
    //   553: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   556: aload_2
    //   557: athrow
    //   558: astore_1
    //   559: ldc 176
    //   561: iconst_1
    //   562: new 178	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   569: ldc_w 352
    //   572: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_1
    //   576: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   579: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: goto -444 -> 141
    //   588: astore_1
    //   589: ldc 176
    //   591: iconst_1
    //   592: new 178	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   599: ldc_w 352
    //   602: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload_1
    //   606: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   609: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: goto -59 -> 556
    //   618: astore_2
    //   619: goto -71 -> 548
    //   622: astore_3
    //   623: aload 5
    //   625: astore_2
    //   626: goto -164 -> 462
    //   629: astore_3
    //   630: aload 4
    //   632: astore_2
    //   633: goto -300 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	this	FriendProfileCardBgDrawable
    //   33	302	1	localObject1	Object
    //   375	32	1	localIOException1	IOException
    //   463	1	1	localObject2	Object
    //   501	18	1	localIOException2	IOException
    //   545	8	1	localObject3	Object
    //   558	18	1	localIOException3	IOException
    //   588	18	1	localIOException4	IOException
    //   7	550	2	localObject4	Object
    //   618	1	2	localObject5	Object
    //   625	8	2	localObject6	Object
    //   9	232	3	localOptions	BitmapFactory.Options
    //   332	20	3	localIOException5	IOException
    //   461	20	3	localThrowable1	java.lang.Throwable
    //   543	4	3	localObject7	Object
    //   622	1	3	localThrowable2	java.lang.Throwable
    //   629	1	3	localIOException6	IOException
    //   1	630	4	localObject8	Object
    //   4	620	5	localObject9	Object
    //   59	201	6	str	String
    //   74	53	7	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   222	256	332	java/io/IOException
    //   256	269	332	java/io/IOException
    //   274	289	332	java/io/IOException
    //   293	325	332	java/io/IOException
    //   325	329	332	java/io/IOException
    //   405	458	332	java/io/IOException
    //   531	540	332	java/io/IOException
    //   368	372	375	java/io/IOException
    //   222	256	461	java/lang/Throwable
    //   256	269	461	java/lang/Throwable
    //   274	289	461	java/lang/Throwable
    //   293	325	461	java/lang/Throwable
    //   325	329	461	java/lang/Throwable
    //   405	458	461	java/lang/Throwable
    //   531	540	461	java/lang/Throwable
    //   494	498	501	java/io/IOException
    //   222	256	543	finally
    //   256	269	543	finally
    //   274	289	543	finally
    //   293	325	543	finally
    //   325	329	543	finally
    //   405	458	543	finally
    //   531	540	543	finally
    //   137	141	558	java/io/IOException
    //   552	556	588	java/io/IOException
    //   34	61	618	finally
    //   63	76	618	finally
    //   83	89	618	finally
    //   91	123	618	finally
    //   125	131	618	finally
    //   148	154	618	finally
    //   156	188	618	finally
    //   190	198	618	finally
    //   200	222	618	finally
    //   335	364	618	finally
    //   464	490	618	finally
    //   34	61	622	java/lang/Throwable
    //   63	76	622	java/lang/Throwable
    //   83	89	622	java/lang/Throwable
    //   91	123	622	java/lang/Throwable
    //   125	131	622	java/lang/Throwable
    //   148	154	622	java/lang/Throwable
    //   156	188	622	java/lang/Throwable
    //   190	198	622	java/lang/Throwable
    //   200	222	622	java/lang/Throwable
    //   34	61	629	java/io/IOException
    //   63	76	629	java/io/IOException
    //   83	89	629	java/io/IOException
    //   91	123	629	java/io/IOException
    //   125	131	629	java/io/IOException
    //   148	154	629	java/io/IOException
    //   156	188	629	java/io/IOException
    //   190	198	629	java/io/IOException
    //   200	222	629	java/io/IOException
  }
  
  public void b()
  {
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$DecodeNextFrameTask != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$DecodeNextFrameTask.cancel(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$DecodeNextFrameTask = null;
    }
    if (this.jdField_c_of_type_AndroidGraphicsBitmap != null) {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_c_of_type_AndroidGraphicsBitmap != null)
        {
          this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
          this.jdField_c_of_type_AndroidGraphicsBitmap = null;
        }
        return;
      }
    }
  }
  
  protected void c()
  {
    if (this.jdField_e_of_type_Boolean) {
      QLog.e("FriendProfileCardBgDrawable", 1, "decodeNextFrame, FriendProfileCardBgDrawable has been recycled");
    }
    while ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.jdField_b_of_type_Int;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$DecodeNextFrameTask != null) {
      QLog.e("FriendProfileCardBgDrawable", 1, "decodeNextFrame mTask != null currentFrame = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$DecodeNextFrameTask = new FriendProfileCardBgDrawable.DecodeNextFrameTask(this, this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$DecodeNextFrameTask.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_e_of_type_Boolean) {
      QLog.e("FriendProfileCardBgDrawable", 1, "draw, FriendProfileCardBgDrawable has been recycled");
    }
    do
    {
      do
      {
        return;
        if (this.jdField_d_of_type_Boolean) {
          break;
        }
        if (this.jdField_d_of_type_AndroidGraphicsBitmap == null)
        {
          c();
          return;
        }
      } while (this.jdField_a_of_type_AndroidGraphicsPaint == null);
      if (this.jdField_d_of_type_AndroidGraphicsBitmap.isRecycled())
      {
        this.jdField_d_of_type_AndroidGraphicsBitmap = null;
        QLog.e("FriendProfileCardBgDrawable", 1, "draw, mBackground has been recycled");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardBgDrawable", 2, "draw static background");
      }
    } while (this.jdField_b_of_type_AndroidGraphicsRect == null);
    paramCanvas.drawBitmap(this.jdField_d_of_type_AndroidGraphicsBitmap, null, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    return;
    if ((this.jdField_d_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_d_of_type_AndroidGraphicsBitmap.isRecycled()) && (this.jdField_a_of_type_AndroidGraphicsPaint != null) && (this.jdField_b_of_type_AndroidGraphicsRect != null)) {
      paramCanvas.drawBitmap(this.jdField_d_of_type_AndroidGraphicsBitmap, null, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if ((this.jdField_a_of_type_Int != -1) && (this.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        break label212;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      QLog.e("FriendProfileCardBgDrawable", 1, "draw, mBitmap has been recycled");
    }
    while (this.jdField_c_of_type_Int == 0)
    {
      super.invalidateSelf();
      this.jdField_c_of_type_Boolean = true;
      return;
      label212:
      if ((this.jdField_a_of_type_AndroidGraphicsPaint != null) && (this.jdField_a_of_type_AndroidGraphicsRect != null)) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    c();
  }
  
  public int getIntrinsicHeight()
  {
    return this.f;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void run()
  {
    if (!this.jdField_d_of_type_Boolean)
    {
      super.invalidateSelf();
      this.jdField_a_of_type_Boolean = true;
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_b_of_type_AndroidGraphicsBitmap == null);
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = a(this.jdField_a_of_type_Int);
    } while ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap == this.jdField_b_of_type_AndroidGraphicsBitmap));
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      if (Build.VERSION.SDK_INT <= 11) {
        break label100;
      }
    }
    for (this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;; this.jdField_c_of_type_AndroidGraphicsBitmap = null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      super.invalidateSelf();
      return;
      label100:
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable
 * JD-Core Version:    0.7.0.1
 */