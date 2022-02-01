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
  private int jdField_d_of_type_Int = 0;
  private Bitmap jdField_d_of_type_AndroidGraphicsBitmap;
  public boolean d;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
  private int f;
  
  public FriendProfileCardBgDrawable(Resources paramResources, FriendProfileCardBgInfo paramFriendProfileCardBgInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 50;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
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
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      return 4;
    }
    if (paramConfig == Bitmap.Config.RGB_565) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ARGB_4444) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ALPHA_8) {}
    return 1;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FriendProfileCardBgInfo localFriendProfileCardBgInfo = this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo;
    if ((localFriendProfileCardBgInfo != null) && (this.jdField_d_of_type_Boolean))
    {
      float f1 = this.jdField_e_of_type_Int / paramInt1;
      float f2 = this.f / paramInt2;
      float f4 = localFriendProfileCardBgInfo.jdField_a_of_type_Float;
      float f3 = paramInt3;
      paramInt3 = (int)(f4 * f3);
      f4 = this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo.jdField_b_of_type_Float;
      float f5 = paramInt4;
      paramInt4 = (int)(f4 * f5);
      paramInt1 = (int)(this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo.c * f3);
      paramInt2 = (int)(this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo.d * f5);
      paramInt3 = (int)(paramInt3 / f1);
      paramInt4 = (int)(paramInt4 / f2);
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramInt3, paramInt4, (int)(paramInt1 / f1) + paramInt3, (int)(paramInt2 / f2) + paramInt4);
    }
  }
  
  /* Error */
  private void a(String[] paramArrayOfString, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 14
    //   6: aload 14
    //   8: astore 12
    //   10: aload_0
    //   11: aload_1
    //   12: putfield 128	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   15: aload 14
    //   17: astore 12
    //   19: new 130	android/graphics/BitmapFactory$Options
    //   22: dup
    //   23: invokespecial 131	android/graphics/BitmapFactory$Options:<init>	()V
    //   26: astore 15
    //   28: aload 14
    //   30: astore 12
    //   32: aload 15
    //   34: iconst_1
    //   35: putfield 134	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   38: aload 14
    //   40: astore 12
    //   42: new 136	java/io/BufferedInputStream
    //   45: dup
    //   46: new 138	java/io/FileInputStream
    //   49: dup
    //   50: aload_3
    //   51: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 144	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_3
    //   58: aload_3
    //   59: aconst_null
    //   60: aload 15
    //   62: invokestatic 150	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 15
    //   68: getfield 153	android/graphics/BitmapFactory$Options:outHeight	I
    //   71: istore 5
    //   73: aload 15
    //   75: getfield 156	android/graphics/BitmapFactory$Options:outWidth	I
    //   78: istore 6
    //   80: aload_0
    //   81: getfield 70	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_AndroidContentResResources	Landroid/content/res/Resources;
    //   84: invokevirtual 162	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   87: astore 12
    //   89: aload 12
    //   91: getfield 167	android/util/DisplayMetrics:widthPixels	I
    //   94: aload 12
    //   96: getfield 170	android/util/DisplayMetrics:heightPixels	I
    //   99: invokestatic 176	java/lang/Math:min	(II)I
    //   102: istore 7
    //   104: aload 12
    //   106: getfield 167	android/util/DisplayMetrics:widthPixels	I
    //   109: aload 12
    //   111: getfield 170	android/util/DisplayMetrics:heightPixels	I
    //   114: invokestatic 179	java/lang/Math:max	(II)I
    //   117: istore 8
    //   119: iload 7
    //   121: i2f
    //   122: iload 8
    //   124: i2f
    //   125: fdiv
    //   126: fstore 4
    //   128: iload 6
    //   130: iload 5
    //   132: i2f
    //   133: fload 4
    //   135: fmul
    //   136: f2i
    //   137: invokestatic 176	java/lang/Math:min	(II)I
    //   140: istore 9
    //   142: iload 9
    //   144: i2f
    //   145: fload 4
    //   147: fdiv
    //   148: f2i
    //   149: istore 10
    //   151: aload_0
    //   152: iload 9
    //   154: putfield 107	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   157: aload_0
    //   158: iload 10
    //   160: putfield 109	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   163: aload_0
    //   164: new 120	android/graphics/Rect
    //   167: dup
    //   168: iconst_0
    //   169: iconst_0
    //   170: iload 7
    //   172: iload 8
    //   174: invokespecial 122	android/graphics/Rect:<init>	(IIII)V
    //   177: putfield 181	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   180: aload_0
    //   181: getfield 57	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_Boolean	Z
    //   184: istore 11
    //   186: iload 11
    //   188: ifne +41 -> 229
    //   191: aload_3
    //   192: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   195: return
    //   196: astore_1
    //   197: new 186	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   204: astore_3
    //   205: aload_3
    //   206: ldc 189
    //   208: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_3
    //   213: aload_1
    //   214: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: ldc 198
    //   220: iconst_1
    //   221: aload_3
    //   222: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: return
    //   229: aload_0
    //   230: iload 7
    //   232: iload 8
    //   234: iload 6
    //   236: iload 5
    //   238: invokespecial 209	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:a	(IIII)V
    //   241: aload_0
    //   242: aload_1
    //   243: arraylength
    //   244: putfield 32	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_Int	I
    //   247: aload_0
    //   248: iload_2
    //   249: putfield 34	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_b_of_type_Int	I
    //   252: aload_0
    //   253: ldc 210
    //   255: putfield 53	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_c_of_type_Int	I
    //   258: aload_0
    //   259: iconst_0
    //   260: putfield 55	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_c_of_type_Boolean	Z
    //   263: aload_3
    //   264: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   267: return
    //   268: astore_1
    //   269: new 186	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   276: astore_3
    //   277: goto +103 -> 380
    //   280: astore_1
    //   281: goto +123 -> 404
    //   284: astore 12
    //   286: aload_3
    //   287: astore_1
    //   288: aload 12
    //   290: astore_3
    //   291: goto +14 -> 305
    //   294: astore_1
    //   295: aload 12
    //   297: astore_3
    //   298: goto +106 -> 404
    //   301: astore_3
    //   302: aload 13
    //   304: astore_1
    //   305: aload_1
    //   306: astore 12
    //   308: new 186	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   315: astore 13
    //   317: aload_1
    //   318: astore 12
    //   320: aload 13
    //   322: ldc 212
    //   324: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_1
    //   329: astore 12
    //   331: aload 13
    //   333: aload_3
    //   334: invokevirtual 215	java/io/IOException:getMessage	()Ljava/lang/String;
    //   337: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: astore 12
    //   344: ldc 198
    //   346: iconst_1
    //   347: aload 13
    //   349: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload_1
    //   356: astore 12
    //   358: aload_0
    //   359: invokevirtual 217	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:a	()V
    //   362: aload_1
    //   363: ifnull +40 -> 403
    //   366: aload_1
    //   367: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   370: return
    //   371: astore_1
    //   372: new 186	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   379: astore_3
    //   380: aload_3
    //   381: ldc 189
    //   383: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_3
    //   388: aload_1
    //   389: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: ldc 198
    //   395: iconst_1
    //   396: aload_3
    //   397: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: return
    //   404: aload_3
    //   405: ifnull +46 -> 451
    //   408: aload_3
    //   409: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   412: goto +39 -> 451
    //   415: astore_3
    //   416: new 186	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   423: astore 12
    //   425: aload 12
    //   427: ldc 189
    //   429: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 12
    //   435: aload_3
    //   436: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: ldc 198
    //   442: iconst_1
    //   443: aload 12
    //   445: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: aload_1
    //   452: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	this	FriendProfileCardBgDrawable
    //   0	453	1	paramArrayOfString	String[]
    //   0	453	2	paramInt	int
    //   0	453	3	paramString	String
    //   126	20	4	f1	float
    //   71	166	5	i	int
    //   78	157	6	j	int
    //   102	129	7	k	int
    //   117	116	8	m	int
    //   140	13	9	n	int
    //   149	10	10	i1	int
    //   184	3	11	bool	boolean
    //   8	102	12	localObject1	Object
    //   284	12	12	localIOException	IOException
    //   306	138	12	localObject2	Object
    //   1	347	13	localStringBuilder	StringBuilder
    //   4	35	14	localObject3	Object
    //   26	48	15	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   191	195	196	java/io/IOException
    //   263	267	268	java/io/IOException
    //   58	186	280	finally
    //   229	263	280	finally
    //   58	186	284	java/io/IOException
    //   229	263	284	java/io/IOException
    //   10	15	294	finally
    //   19	28	294	finally
    //   32	38	294	finally
    //   42	58	294	finally
    //   308	317	294	finally
    //   320	328	294	finally
    //   331	341	294	finally
    //   344	355	294	finally
    //   358	362	294	finally
    //   10	15	301	java/io/IOException
    //   19	28	301	java/io/IOException
    //   32	38	301	java/io/IOException
    //   42	58	301	java/io/IOException
    //   366	370	371	java/io/IOException
    //   408	412	415	java/io/IOException
  }
  
  @TargetApi(19)
  public static boolean a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramInt1 * paramInt2 * a(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount();
    }
    return (paramBitmap.getWidth() == paramInt1) && (paramBitmap.getHeight() == paramInt2);
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aload 5
    //   10: astore_1
    //   11: aload_3
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   17: ifnonnull +443 -> 460
    //   20: aload_3
    //   21: astore_2
    //   22: new 186	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   29: astore_1
    //   30: aload_3
    //   31: astore_2
    //   32: aload_1
    //   33: ldc 249
    //   35: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_3
    //   40: astore_2
    //   41: aload_1
    //   42: aload_0
    //   43: getfield 72	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   46: getfield 81	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   49: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_3
    //   54: astore_2
    //   55: aload_1
    //   56: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 6
    //   61: aload_3
    //   62: astore_2
    //   63: getstatic 254	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   66: aload 6
    //   68: invokevirtual 260	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   71: checkcast 228	android/graphics/Bitmap
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +74 -> 150
    //   79: aload_3
    //   80: astore_2
    //   81: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +53 -> 137
    //   87: aload_3
    //   88: astore_2
    //   89: new 186	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   96: astore 6
    //   98: aload_3
    //   99: astore_2
    //   100: aload 6
    //   102: ldc_w 266
    //   105: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_3
    //   110: astore_2
    //   111: aload 6
    //   113: aload_0
    //   114: getfield 72	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   117: getfield 81	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   120: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_3
    //   125: astore_2
    //   126: ldc 198
    //   128: iconst_2
    //   129: aload 6
    //   131: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: aload_3
    //   138: astore_2
    //   139: aload_0
    //   140: aload_1
    //   141: putfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   144: aload 5
    //   146: astore_1
    //   147: goto +313 -> 460
    //   150: aload_3
    //   151: astore_2
    //   152: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +49 -> 204
    //   158: aload_3
    //   159: astore_2
    //   160: new 186	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   167: astore_1
    //   168: aload_3
    //   169: astore_2
    //   170: aload_1
    //   171: ldc_w 270
    //   174: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_3
    //   179: astore_2
    //   180: aload_1
    //   181: aload_0
    //   182: getfield 72	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   185: getfield 81	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_3
    //   193: astore_2
    //   194: ldc 198
    //   196: iconst_2
    //   197: aload_1
    //   198: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload_3
    //   205: astore_2
    //   206: new 130	android/graphics/BitmapFactory$Options
    //   209: dup
    //   210: invokespecial 131	android/graphics/BitmapFactory$Options:<init>	()V
    //   213: astore 5
    //   215: aload_3
    //   216: astore_2
    //   217: new 136	java/io/BufferedInputStream
    //   220: dup
    //   221: new 138	java/io/FileInputStream
    //   224: dup
    //   225: aload_0
    //   226: getfield 72	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   229: getfield 81	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   232: invokespecial 141	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   235: invokespecial 144	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   238: astore_1
    //   239: aload_1
    //   240: aconst_null
    //   241: aload 5
    //   243: invokestatic 150	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   246: astore_2
    //   247: aload 5
    //   249: getfield 156	android/graphics/BitmapFactory$Options:outWidth	I
    //   252: aload_0
    //   253: getfield 107	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   256: if_icmpne +23 -> 279
    //   259: aload 5
    //   261: getfield 153	android/graphics/BitmapFactory$Options:outHeight	I
    //   264: aload_0
    //   265: getfield 109	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   268: if_icmpne +11 -> 279
    //   271: aload_0
    //   272: aload_2
    //   273: putfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   276: goto +156 -> 432
    //   279: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +12 -> 294
    //   285: ldc 198
    //   287: iconst_2
    //   288: ldc_w 272
    //   291: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   294: aload_2
    //   295: ifnull +128 -> 423
    //   298: aload_0
    //   299: getfield 107	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   302: ifle +51 -> 353
    //   305: aload_0
    //   306: getfield 109	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   309: ifle +44 -> 353
    //   312: aload_0
    //   313: aload_2
    //   314: aload_2
    //   315: invokevirtual 241	android/graphics/Bitmap:getWidth	()I
    //   318: aload_0
    //   319: getfield 107	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   322: isub
    //   323: iconst_2
    //   324: idiv
    //   325: aload_2
    //   326: invokevirtual 244	android/graphics/Bitmap:getHeight	()I
    //   329: aload_0
    //   330: getfield 109	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   333: isub
    //   334: iconst_2
    //   335: idiv
    //   336: aload_0
    //   337: getfield 107	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   340: aload_0
    //   341: getfield 109	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   344: invokestatic 276	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   347: putfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   350: goto +66 -> 416
    //   353: aload_0
    //   354: aload_2
    //   355: putfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   358: invokestatic 264	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +55 -> 416
    //   364: new 186	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   371: astore_3
    //   372: aload_3
    //   373: ldc_w 278
    //   376: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_3
    //   381: aload_0
    //   382: getfield 107	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_e_of_type_Int	I
    //   385: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_3
    //   390: ldc_w 283
    //   393: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload_3
    //   398: aload_0
    //   399: getfield 109	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:f	I
    //   402: invokevirtual 281	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: ldc 198
    //   408: iconst_2
    //   409: aload_3
    //   410: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: aload_2
    //   417: invokevirtual 286	android/graphics/Bitmap:recycle	()V
    //   420: goto +12 -> 432
    //   423: ldc 198
    //   425: iconst_1
    //   426: ldc_w 288
    //   429: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: getstatic 254	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   435: aload 6
    //   437: aload_0
    //   438: getfield 104	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:jdField_d_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   441: invokevirtual 292	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   444: pop
    //   445: goto +15 -> 460
    //   448: astore_3
    //   449: aload_1
    //   450: astore_2
    //   451: aload_3
    //   452: astore_1
    //   453: goto +76 -> 529
    //   456: astore_3
    //   457: goto +20 -> 477
    //   460: aload_1
    //   461: ifnull +67 -> 528
    //   464: aload_1
    //   465: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   468: return
    //   469: astore_1
    //   470: goto +59 -> 529
    //   473: astore_3
    //   474: aload 4
    //   476: astore_1
    //   477: aload_1
    //   478: astore_2
    //   479: new 186	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   486: astore 4
    //   488: aload_1
    //   489: astore_2
    //   490: aload 4
    //   492: ldc_w 294
    //   495: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: aload_1
    //   500: astore_2
    //   501: aload 4
    //   503: aload_3
    //   504: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload_1
    //   509: astore_2
    //   510: ldc 198
    //   512: iconst_1
    //   513: aload 4
    //   515: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 207	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: aload_1
    //   522: ifnull +6 -> 528
    //   525: goto -61 -> 464
    //   528: return
    //   529: aload_2
    //   530: ifnull +7 -> 537
    //   533: aload_2
    //   534: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   537: goto +5 -> 542
    //   540: aload_1
    //   541: athrow
    //   542: goto -2 -> 540
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	545	0	this	FriendProfileCardBgDrawable
    //   10	455	1	localObject1	Object
    //   469	1	1	localObject2	Object
    //   476	65	1	localStringBuilder1	StringBuilder
    //   12	522	2	localObject3	Object
    //   1	409	3	localStringBuilder2	StringBuilder
    //   448	4	3	localObject4	Object
    //   456	1	3	localThrowable1	java.lang.Throwable
    //   473	31	3	localThrowable2	java.lang.Throwable
    //   3	511	4	localStringBuilder3	StringBuilder
    //   6	254	5	localOptions	BitmapFactory.Options
    //   59	377	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   239	276	448	finally
    //   279	294	448	finally
    //   298	350	448	finally
    //   353	416	448	finally
    //   416	420	448	finally
    //   423	432	448	finally
    //   432	445	448	finally
    //   239	276	456	java/lang/Throwable
    //   279	294	456	java/lang/Throwable
    //   298	350	456	java/lang/Throwable
    //   353	416	456	java/lang/Throwable
    //   416	420	456	java/lang/Throwable
    //   423	432	456	java/lang/Throwable
    //   432	445	456	java/lang/Throwable
    //   13	20	469	finally
    //   22	30	469	finally
    //   32	39	469	finally
    //   41	53	469	finally
    //   55	61	469	finally
    //   63	75	469	finally
    //   81	87	469	finally
    //   89	98	469	finally
    //   100	109	469	finally
    //   111	124	469	finally
    //   126	137	469	finally
    //   139	144	469	finally
    //   152	158	469	finally
    //   160	168	469	finally
    //   170	178	469	finally
    //   180	192	469	finally
    //   194	204	469	finally
    //   206	215	469	finally
    //   217	239	469	finally
    //   479	488	469	finally
    //   490	499	469	finally
    //   501	508	469	finally
    //   510	521	469	finally
    //   13	20	473	java/lang/Throwable
    //   22	30	473	java/lang/Throwable
    //   32	39	473	java/lang/Throwable
    //   41	53	473	java/lang/Throwable
    //   55	61	473	java/lang/Throwable
    //   63	75	473	java/lang/Throwable
    //   81	87	473	java/lang/Throwable
    //   89	98	473	java/lang/Throwable
    //   100	109	473	java/lang/Throwable
    //   111	124	473	java/lang/Throwable
    //   126	137	473	java/lang/Throwable
    //   139	144	473	java/lang/Throwable
    //   152	158	473	java/lang/Throwable
    //   160	168	473	java/lang/Throwable
    //   170	178	473	java/lang/Throwable
    //   180	192	473	java/lang/Throwable
    //   194	204	473	java/lang/Throwable
    //   206	215	473	java/lang/Throwable
    //   217	239	473	java/lang/Throwable
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
    if (this.jdField_d_of_type_AndroidGraphicsBitmap == null) {
      try
      {
        d();
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode Bg error, e.message = ");
        localStringBuilder.append(localIOException.toString());
        QLog.e("FriendProfileCardBgDrawable", 2, localStringBuilder.toString());
      }
    }
    return this.jdField_d_of_type_AndroidGraphicsBitmap;
  }
  
  @TargetApi(11)
  protected Bitmap a(Object paramObject, int paramInt)
  {
    Object localObject = new BitmapFactory.Options();
    String str;
    BitmapFactory.Options localOptions;
    if (this.jdField_a_of_type_ComTencentMobileqqVasFriendProfileCardBgInfo != null)
    {
      d();
      if (!this.jdField_d_of_type_Boolean) {
        return null;
      }
      paramObject = (String[])paramObject;
      paramInt = (paramInt + 1) % paramObject.length;
      str = paramObject[paramInt];
      ((BitmapFactory.Options)localObject).inDensity = 320;
      ((BitmapFactory.Options)localObject).inTargetDensity = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().densityDpi;
      ((BitmapFactory.Options)localObject).inMutable = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      paramObject = new BufferedInputStream(new FileInputStream(paramObject[paramInt]));
      BitmapFactory.decodeStream(paramObject, null, localOptions);
      paramObject.close();
      if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {}
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_c_of_type_AndroidGraphicsBitmap == null) {
          break label256;
        }
        paramObject = this.jdField_c_of_type_AndroidGraphicsBitmap;
        this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      }
      paramObject = null;
      if ((paramObject != null) && (Build.VERSION.SDK_INT > 11) && (a(paramObject, localOptions.outWidth, localOptions.outHeight)))
      {
        ((BitmapFactory.Options)localObject).inBitmap = paramObject;
      }
      else
      {
        ((BitmapFactory.Options)localObject).inBitmap = null;
        if (paramObject != null) {
          paramObject.recycle();
        }
      }
      paramObject = new BufferedInputStream(new FileInputStream(str));
      localObject = BitmapFactory.decodeStream(paramObject, null, (BitmapFactory.Options)localObject);
      paramObject.close();
      return localObject;
      return null;
      label256:
      paramObject = null;
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
  
  public void b()
  {
    this.jdField_e_of_type_Boolean = true;
    ??? = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (??? != null)
    {
      ((Bitmap)???).recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    ??? = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (??? != null)
    {
      ((Bitmap)???).recycle();
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    }
    ??? = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$DecodeNextFrameTask;
    if (??? != null)
    {
      ((FriendProfileCardBgDrawable.DecodeNextFrameTask)???).cancel(false);
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
    if (this.jdField_e_of_type_Boolean)
    {
      QLog.e("FriendProfileCardBgDrawable", 1, "decodeNextFrame, FriendProfileCardBgDrawable has been recycled");
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$DecodeNextFrameTask != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeNextFrame mTask != null currentFrame = ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        QLog.e("FriendProfileCardBgDrawable", 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$DecodeNextFrameTask = new FriendProfileCardBgDrawable.DecodeNextFrameTask(this, this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimFriendProfileCardBgDrawable$DecodeNextFrameTask.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_e_of_type_Boolean)
    {
      QLog.e("FriendProfileCardBgDrawable", 1, "draw, FriendProfileCardBgDrawable has been recycled");
      return;
    }
    Object localObject;
    if (!this.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_d_of_type_AndroidGraphicsBitmap;
      if (localObject == null)
      {
        c();
        return;
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint != null)
      {
        if (((Bitmap)localObject).isRecycled())
        {
          this.jdField_d_of_type_AndroidGraphicsBitmap = null;
          QLog.e("FriendProfileCardBgDrawable", 1, "draw, mBackground has been recycled");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardBgDrawable", 2, "draw static background");
        }
        localObject = this.jdField_b_of_type_AndroidGraphicsRect;
        if (localObject != null) {
          paramCanvas.drawBitmap(this.jdField_d_of_type_AndroidGraphicsBitmap, null, (Rect)localObject, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
    }
    else
    {
      localObject = this.jdField_d_of_type_AndroidGraphicsBitmap;
      Rect localRect;
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
        if (localObject != null)
        {
          localRect = this.jdField_b_of_type_AndroidGraphicsRect;
          if (localRect != null) {
            paramCanvas.drawBitmap(this.jdField_d_of_type_AndroidGraphicsBitmap, null, localRect, (Paint)localObject);
          }
        }
      }
      if (this.jdField_a_of_type_Int != -1)
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if (localObject != null) {
          if (((Bitmap)localObject).isRecycled())
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap = null;
            QLog.e("FriendProfileCardBgDrawable", 1, "draw, mBitmap has been recycled");
          }
          else
          {
            localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
            if (localObject != null)
            {
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              if (localRect != null) {
                paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, localRect, (Paint)localObject);
              }
            }
          }
        }
      }
      if (this.jdField_c_of_type_Int == 0)
      {
        super.invalidateSelf();
        this.jdField_c_of_type_Boolean = true;
        return;
      }
      c();
    }
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
      return;
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = a(this.jdField_a_of_type_Int);
    Bitmap localBitmap1 = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (localBitmap1 != null)
    {
      Bitmap localBitmap2 = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localBitmap2 != localBitmap1)
      {
        if (localBitmap2 != null) {
          if (Build.VERSION.SDK_INT > 11)
          {
            this.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
          }
          else
          {
            this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
            this.jdField_c_of_type_AndroidGraphicsBitmap = null;
          }
        }
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_b_of_type_AndroidGraphicsBitmap;
        this.jdField_b_of_type_AndroidGraphicsBitmap = null;
        super.invalidateSelf();
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable
 * JD-Core Version:    0.7.0.1
 */