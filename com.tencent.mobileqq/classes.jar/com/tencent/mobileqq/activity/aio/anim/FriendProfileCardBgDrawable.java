package com.tencent.mobileqq.activity.aio.anim;

import aeqt;
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
import bdol;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FriendProfileCardBgDrawable
  extends Drawable
  implements Runnable
{
  public int a;
  public aeqt a;
  public Resources a;
  public Bitmap a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  public Handler a;
  private bdol jdField_a_of_type_Bdol;
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
  
  public FriendProfileCardBgDrawable(Resources paramResources, bdol parambdol)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 50;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentResResources = paramResources;
    this.jdField_a_of_type_Bdol = parambdol;
    if (parambdol != null)
    {
      if (parambdol.jdField_a_of_type_ArrayOfJavaLangString != null) {
        this.jdField_d_of_type_Boolean = true;
      }
      a(parambdol.jdField_a_of_type_ArrayOfJavaLangString, parambdol.jdField_b_of_type_Int, parambdol.jdField_a_of_type_JavaLangString);
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
    if ((this.jdField_a_of_type_Bdol != null) && (this.jdField_d_of_type_Boolean))
    {
      float f1 = this.jdField_e_of_type_Int / paramInt1;
      float f2 = this.f / paramInt2;
      int i = (int)(this.jdField_a_of_type_Bdol.jdField_a_of_type_Float * paramInt3);
      paramInt1 = (int)(this.jdField_a_of_type_Bdol.jdField_b_of_type_Float * paramInt4);
      paramInt2 = (int)(this.jdField_a_of_type_Bdol.c * paramInt3);
      paramInt3 = (int)(this.jdField_a_of_type_Bdol.d * paramInt4);
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
    //   35: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Bdol	Lbdol;
    //   38: getfield 71	bdol:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   94: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Bdol	Lbdol;
    //   97: getfield 71	bdol:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   155: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Bdol	Lbdol;
    //   158: getfield 71	bdol:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   192: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Bdol	Lbdol;
    //   195: getfield 71	bdol:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   274: ifnull +171 -> 445
    //   277: aload_0
    //   278: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   281: ifle +93 -> 374
    //   284: aload_0
    //   285: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   288: ifle +86 -> 374
    //   291: aload_0
    //   292: aload_1
    //   293: aload_1
    //   294: invokevirtual 237	android/graphics/Bitmap:getWidth	()I
    //   297: aload_0
    //   298: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   301: isub
    //   302: iconst_2
    //   303: idiv
    //   304: aload_1
    //   305: invokevirtual 240	android/graphics/Bitmap:getHeight	()I
    //   308: aload_0
    //   309: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   312: isub
    //   313: iconst_2
    //   314: idiv
    //   315: aload_0
    //   316: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   319: aload_0
    //   320: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   323: invokestatic 277	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   326: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   329: aload_1
    //   330: invokevirtual 280	android/graphics/Bitmap:recycle	()V
    //   333: goto -91 -> 242
    //   336: astore_3
    //   337: aload_2
    //   338: astore_1
    //   339: ldc 176
    //   341: iconst_1
    //   342: new 178	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 282
    //   352: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_3
    //   356: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload_2
    //   366: ifnull -239 -> 127
    //   369: aload_2
    //   370: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   373: return
    //   374: aload_0
    //   375: aload_1
    //   376: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   379: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq -53 -> 329
    //   385: ldc 176
    //   387: iconst_2
    //   388: new 178	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 284
    //   398: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_0
    //   402: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   405: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   408: ldc_w 289
    //   411: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_0
    //   415: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   418: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: goto -98 -> 329
    //   430: astore_3
    //   431: aload_2
    //   432: astore_1
    //   433: aload_3
    //   434: astore_2
    //   435: aload_1
    //   436: ifnull +7 -> 443
    //   439: aload_1
    //   440: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   443: aload_2
    //   444: athrow
    //   445: ldc 176
    //   447: iconst_1
    //   448: ldc_w 291
    //   451: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: goto -212 -> 242
    //   457: astore_2
    //   458: goto -23 -> 435
    //   461: astore_3
    //   462: aload 4
    //   464: astore_2
    //   465: goto -128 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	FriendProfileCardBgDrawable
    //   12	428	1	localObject1	Object
    //   10	434	2	localObject2	Object
    //   457	1	2	localObject3	Object
    //   464	1	2	localObject4	Object
    //   4	178	3	localObject5	Object
    //   336	20	3	localThrowable1	java.lang.Throwable
    //   430	4	3	localObject6	Object
    //   461	1	3	localThrowable2	java.lang.Throwable
    //   1	462	4	localObject7	Object
    //   6	220	5	localOptions	BitmapFactory.Options
    //   47	199	6	str	String
    // Exception table:
    //   from	to	target	type
    //   205	242	336	java/lang/Throwable
    //   242	255	336	java/lang/Throwable
    //   258	273	336	java/lang/Throwable
    //   277	329	336	java/lang/Throwable
    //   329	333	336	java/lang/Throwable
    //   374	427	336	java/lang/Throwable
    //   445	454	336	java/lang/Throwable
    //   205	242	430	finally
    //   242	255	430	finally
    //   258	273	430	finally
    //   277	329	430	finally
    //   329	333	430	finally
    //   374	427	430	finally
    //   445	454	430	finally
    //   13	20	457	finally
    //   22	49	457	finally
    //   51	63	457	finally
    //   69	75	457	finally
    //   77	109	457	finally
    //   111	116	457	finally
    //   130	136	457	finally
    //   138	170	457	finally
    //   172	181	457	finally
    //   183	205	457	finally
    //   339	365	457	finally
    //   13	20	461	java/lang/Throwable
    //   22	49	461	java/lang/Throwable
    //   51	63	461	java/lang/Throwable
    //   69	75	461	java/lang/Throwable
    //   77	109	461	java/lang/Throwable
    //   111	116	461	java/lang/Throwable
    //   130	136	461	java/lang/Throwable
    //   138	170	461	java/lang/Throwable
    //   172	181	461	java/lang/Throwable
    //   183	205	461	java/lang/Throwable
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
  public Bitmap a(Object paramObject, int paramInt)
  {
    Object localObject = new BitmapFactory.Options();
    if (this.jdField_a_of_type_Bdol != null)
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
      new Handler(Looper.getMainLooper()).post(new FriendProfileCardBgDrawable.1(this));
      return;
    }
    b();
  }
  
  /* Error */
  public Bitmap b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: getfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   8: ifnonnull +112 -> 120
    //   11: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +12 -> 26
    //   17: ldc 176
    //   19: iconst_2
    //   20: ldc_w 342
    //   23: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: new 178	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   33: ldc 245
    //   35: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_0
    //   39: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Bdol	Lbdol;
    //   42: getfield 71	bdol:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   45: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 4
    //   53: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   56: aload 4
    //   58: invokevirtual 257	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 224	android/graphics/Bitmap
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +59 -> 125
    //   69: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +35 -> 107
    //   75: ldc 176
    //   77: iconst_2
    //   78: new 178	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 344
    //   88: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Bdol	Lbdol;
    //   95: getfield 71	bdol:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   98: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: aload_0
    //   108: aload_2
    //   109: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   120: aload_0
    //   121: getfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   124: areturn
    //   125: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +35 -> 163
    //   131: ldc 176
    //   133: iconst_2
    //   134: new 178	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 346
    //   144: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_0
    //   148: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Bdol	Lbdol;
    //   151: getfield 71	bdol:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   154: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: new 120	android/graphics/BitmapFactory$Options
    //   166: dup
    //   167: invokespecial 121	android/graphics/BitmapFactory$Options:<init>	()V
    //   170: astore 5
    //   172: new 126	java/io/BufferedInputStream
    //   175: dup
    //   176: new 128	java/io/FileInputStream
    //   179: dup
    //   180: aload_0
    //   181: getfield 60	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_Bdol	Lbdol;
    //   184: getfield 71	bdol:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   187: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   190: invokespecial 134	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   193: astore_1
    //   194: aload_1
    //   195: astore_2
    //   196: aload_1
    //   197: aconst_null
    //   198: aload 5
    //   200: invokestatic 140	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   203: astore_3
    //   204: aload_1
    //   205: astore_2
    //   206: aload 5
    //   208: getfield 146	android/graphics/BitmapFactory$Options:outWidth	I
    //   211: aload_0
    //   212: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   215: if_icmpne +42 -> 257
    //   218: aload_1
    //   219: astore_2
    //   220: aload 5
    //   222: getfield 143	android/graphics/BitmapFactory$Options:outHeight	I
    //   225: aload_0
    //   226: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   229: if_icmpne +28 -> 257
    //   232: aload_1
    //   233: astore_2
    //   234: aload_0
    //   235: aload_3
    //   236: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   239: aload_1
    //   240: astore_2
    //   241: getstatic 251	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   244: aload 4
    //   246: aload_0
    //   247: getfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   250: invokevirtual 271	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   253: pop
    //   254: goto -142 -> 112
    //   257: aload_1
    //   258: astore_2
    //   259: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +14 -> 276
    //   265: aload_1
    //   266: astore_2
    //   267: ldc 176
    //   269: iconst_2
    //   270: ldc_w 348
    //   273: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_3
    //   277: ifnull +273 -> 550
    //   280: aload_1
    //   281: astore_2
    //   282: aload_0
    //   283: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   286: ifle +132 -> 418
    //   289: aload_1
    //   290: astore_2
    //   291: aload_0
    //   292: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   295: ifle +123 -> 418
    //   298: aload_1
    //   299: astore_2
    //   300: aload_0
    //   301: aload_3
    //   302: aload_3
    //   303: invokevirtual 237	android/graphics/Bitmap:getWidth	()I
    //   306: aload_0
    //   307: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   310: isub
    //   311: iconst_2
    //   312: idiv
    //   313: aload_3
    //   314: invokevirtual 240	android/graphics/Bitmap:getHeight	()I
    //   317: aload_0
    //   318: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   321: isub
    //   322: iconst_2
    //   323: idiv
    //   324: aload_0
    //   325: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   328: aload_0
    //   329: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   332: invokestatic 277	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   335: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   338: aload_1
    //   339: astore_2
    //   340: aload_3
    //   341: invokevirtual 280	android/graphics/Bitmap:recycle	()V
    //   344: goto -105 -> 239
    //   347: astore_2
    //   348: ldc 176
    //   350: iconst_1
    //   351: new 178	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   358: ldc_w 350
    //   361: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload_2
    //   365: invokevirtual 298	java/io/IOException:toString	()Ljava/lang/String;
    //   368: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload_1
    //   378: ifnull -258 -> 120
    //   381: aload_1
    //   382: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   385: goto -265 -> 120
    //   388: astore_1
    //   389: ldc 176
    //   391: iconst_1
    //   392: new 178	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 352
    //   402: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_1
    //   406: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: goto -295 -> 120
    //   418: aload_1
    //   419: astore_2
    //   420: aload_0
    //   421: aload_3
    //   422: putfield 94	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   425: aload_1
    //   426: astore_2
    //   427: invokestatic 261	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq -92 -> 338
    //   433: aload_1
    //   434: astore_2
    //   435: ldc 176
    //   437: iconst_2
    //   438: new 178	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   445: ldc_w 354
    //   448: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_0
    //   452: getfield 97	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   455: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: ldc_w 289
    //   461: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_0
    //   465: getfield 99	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   468: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   471: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: goto -139 -> 338
    //   480: astore_3
    //   481: aload_1
    //   482: astore_2
    //   483: ldc 176
    //   485: iconst_1
    //   486: new 178	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 356
    //   496: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_3
    //   500: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   509: aload_1
    //   510: ifnull -390 -> 120
    //   513: aload_1
    //   514: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   517: goto -397 -> 120
    //   520: astore_1
    //   521: ldc 176
    //   523: iconst_1
    //   524: new 178	java/lang/StringBuilder
    //   527: dup
    //   528: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   531: ldc_w 352
    //   534: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload_1
    //   538: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: goto -427 -> 120
    //   550: aload_1
    //   551: astore_2
    //   552: ldc 176
    //   554: iconst_1
    //   555: ldc_w 358
    //   558: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: goto -322 -> 239
    //   564: astore_1
    //   565: aload_2
    //   566: ifnull +7 -> 573
    //   569: aload_2
    //   570: invokevirtual 174	java/io/BufferedInputStream:close	()V
    //   573: aload_1
    //   574: athrow
    //   575: astore_1
    //   576: ldc 176
    //   578: iconst_1
    //   579: new 178	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   586: ldc_w 352
    //   589: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload_1
    //   593: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   596: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   602: goto -482 -> 120
    //   605: astore_2
    //   606: ldc 176
    //   608: iconst_1
    //   609: new 178	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   616: ldc_w 352
    //   619: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: aload_2
    //   623: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 192	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 197	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: goto -59 -> 573
    //   635: astore_1
    //   636: aconst_null
    //   637: astore_2
    //   638: goto -73 -> 565
    //   641: astore_3
    //   642: aload_1
    //   643: astore_2
    //   644: aload_3
    //   645: astore_1
    //   646: goto -81 -> 565
    //   649: astore_3
    //   650: aconst_null
    //   651: astore_1
    //   652: goto -171 -> 481
    //   655: astore_2
    //   656: aload_3
    //   657: astore_1
    //   658: goto -310 -> 348
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	661	0	this	FriendProfileCardBgDrawable
    //   3	379	1	localBufferedInputStream	BufferedInputStream
    //   388	126	1	localIOException1	IOException
    //   520	31	1	localIOException2	IOException
    //   564	10	1	localObject1	Object
    //   575	18	1	localIOException3	IOException
    //   635	8	1	localObject2	Object
    //   645	13	1	localObject3	Object
    //   64	276	2	localObject4	Object
    //   347	18	2	localIOException4	IOException
    //   419	151	2	localIOException5	IOException
    //   605	18	2	localIOException6	IOException
    //   637	7	2	localObject5	Object
    //   655	1	2	localIOException7	IOException
    //   1	421	3	localBitmap	Bitmap
    //   480	20	3	localThrowable1	java.lang.Throwable
    //   641	4	3	localObject6	Object
    //   649	8	3	localThrowable2	java.lang.Throwable
    //   51	194	4	str	String
    //   170	51	5	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   196	204	347	java/io/IOException
    //   206	218	347	java/io/IOException
    //   220	232	347	java/io/IOException
    //   234	239	347	java/io/IOException
    //   241	254	347	java/io/IOException
    //   259	265	347	java/io/IOException
    //   267	276	347	java/io/IOException
    //   282	289	347	java/io/IOException
    //   291	298	347	java/io/IOException
    //   300	338	347	java/io/IOException
    //   340	344	347	java/io/IOException
    //   420	425	347	java/io/IOException
    //   427	433	347	java/io/IOException
    //   435	477	347	java/io/IOException
    //   552	561	347	java/io/IOException
    //   381	385	388	java/io/IOException
    //   196	204	480	java/lang/Throwable
    //   206	218	480	java/lang/Throwable
    //   220	232	480	java/lang/Throwable
    //   234	239	480	java/lang/Throwable
    //   241	254	480	java/lang/Throwable
    //   259	265	480	java/lang/Throwable
    //   267	276	480	java/lang/Throwable
    //   282	289	480	java/lang/Throwable
    //   291	298	480	java/lang/Throwable
    //   300	338	480	java/lang/Throwable
    //   340	344	480	java/lang/Throwable
    //   420	425	480	java/lang/Throwable
    //   427	433	480	java/lang/Throwable
    //   435	477	480	java/lang/Throwable
    //   552	561	480	java/lang/Throwable
    //   513	517	520	java/io/IOException
    //   196	204	564	finally
    //   206	218	564	finally
    //   220	232	564	finally
    //   234	239	564	finally
    //   241	254	564	finally
    //   259	265	564	finally
    //   267	276	564	finally
    //   282	289	564	finally
    //   291	298	564	finally
    //   300	338	564	finally
    //   340	344	564	finally
    //   420	425	564	finally
    //   427	433	564	finally
    //   435	477	564	finally
    //   483	509	564	finally
    //   552	561	564	finally
    //   116	120	575	java/io/IOException
    //   569	573	605	java/io/IOException
    //   26	65	635	finally
    //   69	107	635	finally
    //   107	112	635	finally
    //   125	163	635	finally
    //   163	194	635	finally
    //   348	377	641	finally
    //   26	65	649	java/lang/Throwable
    //   69	107	649	java/lang/Throwable
    //   107	112	649	java/lang/Throwable
    //   125	163	649	java/lang/Throwable
    //   163	194	649	java/lang/Throwable
    //   26	65	655	java/io/IOException
    //   69	107	655	java/io/IOException
    //   107	112	655	java/io/IOException
    //   125	163	655	java/io/IOException
    //   163	194	655	java/io/IOException
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
    if (this.jdField_a_of_type_Aeqt != null)
    {
      this.jdField_a_of_type_Aeqt.cancel(false);
      this.jdField_a_of_type_Aeqt = null;
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
    if (this.jdField_a_of_type_Aeqt != null) {
      QLog.e("FriendProfileCardBgDrawable", 1, "decodeNextFrame mTask != null currentFrame = " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Aeqt = new aeqt(this, this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_Aeqt.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.jdField_a_of_type_Int) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable
 * JD-Core Version:    0.7.0.1
 */