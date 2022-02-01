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
  public Object a;
  public Bitmap b;
  public Bitmap c;
  public int d = -1;
  public int e = 50;
  public Handler f = new Handler(Looper.getMainLooper());
  public boolean g = true;
  public FriendProfileCardBgDrawable.DecodeNextFrameTask h;
  public boolean i = false;
  public Resources j;
  public int k = 0;
  public boolean l = false;
  public boolean m = false;
  private Paint n = new Paint(6);
  private Bitmap o;
  private Bitmap p;
  private FriendProfileCardBgInfo q;
  private int r = 0;
  private int s;
  private int t;
  private Rect u;
  private Rect v;
  private final byte[] w = new byte[0];
  private boolean x = false;
  
  public FriendProfileCardBgDrawable(Resources paramResources, FriendProfileCardBgInfo paramFriendProfileCardBgInfo)
  {
    this.j = paramResources;
    this.q = paramFriendProfileCardBgInfo;
    if (paramFriendProfileCardBgInfo != null)
    {
      if (paramFriendProfileCardBgInfo.b != null) {
        this.m = true;
      }
      a(paramFriendProfileCardBgInfo.b, paramFriendProfileCardBgInfo.h, paramFriendProfileCardBgInfo.a);
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
    FriendProfileCardBgInfo localFriendProfileCardBgInfo = this.q;
    if ((localFriendProfileCardBgInfo != null) && (this.m))
    {
      float f1 = this.s / paramInt1;
      float f2 = this.t / paramInt2;
      float f4 = localFriendProfileCardBgInfo.c;
      float f3 = paramInt3;
      paramInt3 = (int)(f4 * f3);
      f4 = this.q.d;
      float f5 = paramInt4;
      paramInt4 = (int)(f4 * f5);
      paramInt1 = (int)(this.q.e * f3);
      paramInt2 = (int)(this.q.f * f5);
      paramInt3 = (int)(paramInt3 / f1);
      paramInt4 = (int)(paramInt4 / f2);
      this.u = new Rect(paramInt3, paramInt4, (int)(paramInt1 / f1) + paramInt3, (int)(paramInt2 / f2) + paramInt4);
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
    //   12: putfield 147	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:a	Ljava/lang/Object;
    //   15: aload 14
    //   17: astore 12
    //   19: new 149	android/graphics/BitmapFactory$Options
    //   22: dup
    //   23: invokespecial 150	android/graphics/BitmapFactory$Options:<init>	()V
    //   26: astore 15
    //   28: aload 14
    //   30: astore 12
    //   32: aload 15
    //   34: iconst_1
    //   35: putfield 153	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   38: aload 14
    //   40: astore 12
    //   42: new 155	java/io/BufferedInputStream
    //   45: dup
    //   46: new 157	java/io/FileInputStream
    //   49: dup
    //   50: aload_3
    //   51: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 163	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_3
    //   58: aload_3
    //   59: aconst_null
    //   60: aload 15
    //   62: invokestatic 169	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   65: pop
    //   66: aload 15
    //   68: getfield 172	android/graphics/BitmapFactory$Options:outHeight	I
    //   71: istore 5
    //   73: aload 15
    //   75: getfield 175	android/graphics/BitmapFactory$Options:outWidth	I
    //   78: istore 6
    //   80: aload_0
    //   81: getfield 88	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:j	Landroid/content/res/Resources;
    //   84: invokevirtual 181	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   87: astore 12
    //   89: aload 12
    //   91: getfield 186	android/util/DisplayMetrics:widthPixels	I
    //   94: aload 12
    //   96: getfield 189	android/util/DisplayMetrics:heightPixels	I
    //   99: invokestatic 195	java/lang/Math:min	(II)I
    //   102: istore 7
    //   104: aload 12
    //   106: getfield 186	android/util/DisplayMetrics:widthPixels	I
    //   109: aload 12
    //   111: getfield 189	android/util/DisplayMetrics:heightPixels	I
    //   114: invokestatic 198	java/lang/Math:max	(II)I
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
    //   137: invokestatic 195	java/lang/Math:min	(II)I
    //   140: istore 9
    //   142: iload 9
    //   144: i2f
    //   145: fload 4
    //   147: fdiv
    //   148: f2i
    //   149: istore 10
    //   151: aload_0
    //   152: iload 9
    //   154: putfield 126	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:s	I
    //   157: aload_0
    //   158: iload 10
    //   160: putfield 128	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:t	I
    //   163: aload_0
    //   164: new 139	android/graphics/Rect
    //   167: dup
    //   168: iconst_0
    //   169: iconst_0
    //   170: iload 7
    //   172: iload 8
    //   174: invokespecial 141	android/graphics/Rect:<init>	(IIII)V
    //   177: putfield 200	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:v	Landroid/graphics/Rect;
    //   180: aload_0
    //   181: getfield 75	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:m	Z
    //   184: istore 11
    //   186: iload 11
    //   188: ifne +41 -> 229
    //   191: aload_3
    //   192: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   195: return
    //   196: astore_1
    //   197: new 205	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   204: astore_3
    //   205: aload_3
    //   206: ldc 208
    //   208: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_3
    //   213: aload_1
    //   214: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: ldc 217
    //   220: iconst_1
    //   221: aload_3
    //   222: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: return
    //   229: aload_0
    //   230: iload 7
    //   232: iload 8
    //   234: iload 6
    //   236: iload 5
    //   238: invokespecial 228	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:a	(IIII)V
    //   241: aload_0
    //   242: aload_1
    //   243: arraylength
    //   244: putfield 50	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:r	I
    //   247: aload_0
    //   248: iload_2
    //   249: putfield 52	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:e	I
    //   252: aload_0
    //   253: ldc 229
    //   255: putfield 71	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:k	I
    //   258: aload_0
    //   259: iconst_0
    //   260: putfield 73	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:l	Z
    //   263: aload_3
    //   264: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   267: return
    //   268: astore_1
    //   269: new 205	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 206	java/lang/StringBuilder:<init>	()V
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
    //   308: new 205	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   315: astore 13
    //   317: aload_1
    //   318: astore 12
    //   320: aload 13
    //   322: ldc 231
    //   324: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_1
    //   329: astore 12
    //   331: aload 13
    //   333: aload_3
    //   334: invokevirtual 234	java/io/IOException:getMessage	()Ljava/lang/String;
    //   337: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_1
    //   342: astore 12
    //   344: ldc 217
    //   346: iconst_1
    //   347: aload 13
    //   349: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload_1
    //   356: astore 12
    //   358: aload_0
    //   359: invokevirtual 236	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:a	()V
    //   362: aload_1
    //   363: ifnull +40 -> 403
    //   366: aload_1
    //   367: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   370: return
    //   371: astore_1
    //   372: new 205	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   379: astore_3
    //   380: aload_3
    //   381: ldc 208
    //   383: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_3
    //   388: aload_1
    //   389: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: ldc 217
    //   395: iconst_1
    //   396: aload_3
    //   397: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: return
    //   404: aload_3
    //   405: ifnull +46 -> 451
    //   408: aload_3
    //   409: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   412: goto +39 -> 451
    //   415: astore_3
    //   416: new 205	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   423: astore 12
    //   425: aload 12
    //   427: ldc 208
    //   429: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 12
    //   435: aload_3
    //   436: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: ldc 217
    //   442: iconst_1
    //   443: aload 12
    //   445: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: aload_1
    //   452: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	this	FriendProfileCardBgDrawable
    //   0	453	1	paramArrayOfString	String[]
    //   0	453	2	paramInt	int
    //   0	453	3	paramString	String
    //   126	20	4	f1	float
    //   71	166	5	i1	int
    //   78	157	6	i2	int
    //   102	129	7	i3	int
    //   117	116	8	i4	int
    //   140	13	9	i5	int
    //   149	10	10	i6	int
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
  private void e()
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
    //   14: getfield 123	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:p	Landroid/graphics/Bitmap;
    //   17: ifnonnull +444 -> 461
    //   20: aload_3
    //   21: astore_2
    //   22: new 205	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   29: astore_1
    //   30: aload_3
    //   31: astore_2
    //   32: aload_1
    //   33: ldc_w 268
    //   36: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: astore_2
    //   42: aload_1
    //   43: aload_0
    //   44: getfield 90	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:q	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   47: getfield 100	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:a	Ljava/lang/String;
    //   50: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: astore_2
    //   56: aload_1
    //   57: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 6
    //   62: aload_3
    //   63: astore_2
    //   64: getstatic 273	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   67: aload 6
    //   69: invokevirtual 279	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   72: checkcast 247	android/graphics/Bitmap
    //   75: astore_1
    //   76: aload_1
    //   77: ifnull +74 -> 151
    //   80: aload_3
    //   81: astore_2
    //   82: invokestatic 283	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +53 -> 138
    //   88: aload_3
    //   89: astore_2
    //   90: new 205	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   97: astore 6
    //   99: aload_3
    //   100: astore_2
    //   101: aload 6
    //   103: ldc_w 285
    //   106: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_3
    //   111: astore_2
    //   112: aload 6
    //   114: aload_0
    //   115: getfield 90	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:q	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   118: getfield 100	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:a	Ljava/lang/String;
    //   121: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_3
    //   126: astore_2
    //   127: ldc 217
    //   129: iconst_2
    //   130: aload 6
    //   132: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_3
    //   139: astore_2
    //   140: aload_0
    //   141: aload_1
    //   142: putfield 123	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:p	Landroid/graphics/Bitmap;
    //   145: aload 5
    //   147: astore_1
    //   148: goto +313 -> 461
    //   151: aload_3
    //   152: astore_2
    //   153: invokestatic 283	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +49 -> 205
    //   159: aload_3
    //   160: astore_2
    //   161: new 205	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   168: astore_1
    //   169: aload_3
    //   170: astore_2
    //   171: aload_1
    //   172: ldc_w 289
    //   175: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload_3
    //   180: astore_2
    //   181: aload_1
    //   182: aload_0
    //   183: getfield 90	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:q	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   186: getfield 100	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:a	Ljava/lang/String;
    //   189: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_3
    //   194: astore_2
    //   195: ldc 217
    //   197: iconst_2
    //   198: aload_1
    //   199: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_3
    //   206: astore_2
    //   207: new 149	android/graphics/BitmapFactory$Options
    //   210: dup
    //   211: invokespecial 150	android/graphics/BitmapFactory$Options:<init>	()V
    //   214: astore 5
    //   216: aload_3
    //   217: astore_2
    //   218: new 155	java/io/BufferedInputStream
    //   221: dup
    //   222: new 157	java/io/FileInputStream
    //   225: dup
    //   226: aload_0
    //   227: getfield 90	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:q	Lcom/tencent/mobileqq/vas/FriendProfileCardBgInfo;
    //   230: getfield 100	com/tencent/mobileqq/vas/FriendProfileCardBgInfo:a	Ljava/lang/String;
    //   233: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   236: invokespecial 163	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   239: astore_1
    //   240: aload_1
    //   241: aconst_null
    //   242: aload 5
    //   244: invokestatic 169	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   247: astore_2
    //   248: aload 5
    //   250: getfield 175	android/graphics/BitmapFactory$Options:outWidth	I
    //   253: aload_0
    //   254: getfield 126	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:s	I
    //   257: if_icmpne +23 -> 280
    //   260: aload 5
    //   262: getfield 172	android/graphics/BitmapFactory$Options:outHeight	I
    //   265: aload_0
    //   266: getfield 128	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:t	I
    //   269: if_icmpne +11 -> 280
    //   272: aload_0
    //   273: aload_2
    //   274: putfield 123	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:p	Landroid/graphics/Bitmap;
    //   277: goto +156 -> 433
    //   280: invokestatic 283	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +12 -> 295
    //   286: ldc 217
    //   288: iconst_2
    //   289: ldc_w 291
    //   292: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload_2
    //   296: ifnull +128 -> 424
    //   299: aload_0
    //   300: getfield 126	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:s	I
    //   303: ifle +51 -> 354
    //   306: aload_0
    //   307: getfield 128	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:t	I
    //   310: ifle +44 -> 354
    //   313: aload_0
    //   314: aload_2
    //   315: aload_2
    //   316: invokevirtual 260	android/graphics/Bitmap:getWidth	()I
    //   319: aload_0
    //   320: getfield 126	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:s	I
    //   323: isub
    //   324: iconst_2
    //   325: idiv
    //   326: aload_2
    //   327: invokevirtual 263	android/graphics/Bitmap:getHeight	()I
    //   330: aload_0
    //   331: getfield 128	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:t	I
    //   334: isub
    //   335: iconst_2
    //   336: idiv
    //   337: aload_0
    //   338: getfield 126	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:s	I
    //   341: aload_0
    //   342: getfield 128	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:t	I
    //   345: invokestatic 295	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   348: putfield 123	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:p	Landroid/graphics/Bitmap;
    //   351: goto +66 -> 417
    //   354: aload_0
    //   355: aload_2
    //   356: putfield 123	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:p	Landroid/graphics/Bitmap;
    //   359: invokestatic 283	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +55 -> 417
    //   365: new 205	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   372: astore_3
    //   373: aload_3
    //   374: ldc_w 297
    //   377: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_3
    //   382: aload_0
    //   383: getfield 126	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:s	I
    //   386: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_3
    //   391: ldc_w 302
    //   394: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload_3
    //   399: aload_0
    //   400: getfield 128	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:t	I
    //   403: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: ldc 217
    //   409: iconst_2
    //   410: aload_3
    //   411: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload_2
    //   418: invokevirtual 305	android/graphics/Bitmap:recycle	()V
    //   421: goto +12 -> 433
    //   424: ldc 217
    //   426: iconst_1
    //   427: ldc_w 307
    //   430: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: getstatic 273	com/tencent/mobileqq/app/GlobalImageCache:a	Landroid/support/v4/util/MQLruCache;
    //   436: aload 6
    //   438: aload_0
    //   439: getfield 123	com/tencent/mobileqq/activity/aio/anim/FriendProfileCardBgDrawable:p	Landroid/graphics/Bitmap;
    //   442: invokevirtual 311	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   445: pop
    //   446: goto +15 -> 461
    //   449: astore_3
    //   450: aload_1
    //   451: astore_2
    //   452: aload_3
    //   453: astore_1
    //   454: goto +76 -> 530
    //   457: astore_3
    //   458: goto +20 -> 478
    //   461: aload_1
    //   462: ifnull +67 -> 529
    //   465: aload_1
    //   466: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   469: return
    //   470: astore_1
    //   471: goto +59 -> 530
    //   474: astore_3
    //   475: aload 4
    //   477: astore_1
    //   478: aload_1
    //   479: astore_2
    //   480: new 205	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   487: astore 4
    //   489: aload_1
    //   490: astore_2
    //   491: aload 4
    //   493: ldc_w 313
    //   496: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload_1
    //   501: astore_2
    //   502: aload 4
    //   504: aload_3
    //   505: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   508: pop
    //   509: aload_1
    //   510: astore_2
    //   511: ldc 217
    //   513: iconst_1
    //   514: aload 4
    //   516: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   522: aload_1
    //   523: ifnull +6 -> 529
    //   526: goto -61 -> 465
    //   529: return
    //   530: aload_2
    //   531: ifnull +7 -> 538
    //   534: aload_2
    //   535: invokevirtual 203	java/io/BufferedInputStream:close	()V
    //   538: goto +5 -> 543
    //   541: aload_1
    //   542: athrow
    //   543: goto -2 -> 541
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	546	0	this	FriendProfileCardBgDrawable
    //   10	456	1	localObject1	Object
    //   470	1	1	localObject2	Object
    //   477	65	1	localStringBuilder1	StringBuilder
    //   12	523	2	localObject3	Object
    //   1	410	3	localStringBuilder2	StringBuilder
    //   449	4	3	localObject4	Object
    //   457	1	3	localThrowable1	java.lang.Throwable
    //   474	31	3	localThrowable2	java.lang.Throwable
    //   3	512	4	localStringBuilder3	StringBuilder
    //   6	255	5	localOptions	BitmapFactory.Options
    //   60	377	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   240	277	449	finally
    //   280	295	449	finally
    //   299	351	449	finally
    //   354	417	449	finally
    //   417	421	449	finally
    //   424	433	449	finally
    //   433	446	449	finally
    //   240	277	457	java/lang/Throwable
    //   280	295	457	java/lang/Throwable
    //   299	351	457	java/lang/Throwable
    //   354	417	457	java/lang/Throwable
    //   417	421	457	java/lang/Throwable
    //   424	433	457	java/lang/Throwable
    //   433	446	457	java/lang/Throwable
    //   13	20	470	finally
    //   22	30	470	finally
    //   32	40	470	finally
    //   42	54	470	finally
    //   56	62	470	finally
    //   64	76	470	finally
    //   82	88	470	finally
    //   90	99	470	finally
    //   101	110	470	finally
    //   112	125	470	finally
    //   127	138	470	finally
    //   140	145	470	finally
    //   153	159	470	finally
    //   161	169	470	finally
    //   171	179	470	finally
    //   181	193	470	finally
    //   195	205	470	finally
    //   207	216	470	finally
    //   218	240	470	finally
    //   480	489	470	finally
    //   491	500	470	finally
    //   502	509	470	finally
    //   511	522	470	finally
    //   13	20	474	java/lang/Throwable
    //   22	30	474	java/lang/Throwable
    //   32	40	474	java/lang/Throwable
    //   42	54	474	java/lang/Throwable
    //   56	62	474	java/lang/Throwable
    //   64	76	474	java/lang/Throwable
    //   82	88	474	java/lang/Throwable
    //   90	99	474	java/lang/Throwable
    //   101	110	474	java/lang/Throwable
    //   112	125	474	java/lang/Throwable
    //   127	138	474	java/lang/Throwable
    //   140	145	474	java/lang/Throwable
    //   153	159	474	java/lang/Throwable
    //   161	169	474	java/lang/Throwable
    //   171	179	474	java/lang/Throwable
    //   181	193	474	java/lang/Throwable
    //   195	205	474	java/lang/Throwable
    //   207	216	474	java/lang/Throwable
    //   218	240	474	java/lang/Throwable
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == this.r - 1)
    {
      this.k -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  @TargetApi(11)
  protected Bitmap a(Object paramObject, int paramInt)
  {
    Object localObject = new BitmapFactory.Options();
    String str;
    BitmapFactory.Options localOptions;
    if (this.q != null)
    {
      e();
      if (!this.m) {
        return null;
      }
      paramObject = (String[])paramObject;
      paramInt = (paramInt + 1) % paramObject.length;
      str = paramObject[paramInt];
      ((BitmapFactory.Options)localObject).inDensity = 320;
      ((BitmapFactory.Options)localObject).inTargetDensity = this.j.getDisplayMetrics().densityDpi;
      ((BitmapFactory.Options)localObject).inMutable = true;
      ((BitmapFactory.Options)localObject).inSampleSize = 1;
      localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      paramObject = new BufferedInputStream(new FileInputStream(paramObject[paramInt]));
      BitmapFactory.decodeStream(paramObject, null, localOptions);
      paramObject.close();
      if (this.o == null) {}
    }
    for (;;)
    {
      synchronized (this.w)
      {
        if (this.o == null) {
          break label256;
        }
        paramObject = this.o;
        this.o = null;
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
    this.x = true;
    ??? = this.b;
    if (??? != null)
    {
      ((Bitmap)???).recycle();
      this.b = null;
    }
    ??? = this.c;
    if (??? != null)
    {
      ((Bitmap)???).recycle();
      this.c = null;
    }
    ??? = this.h;
    if (??? != null)
    {
      ((FriendProfileCardBgDrawable.DecodeNextFrameTask)???).cancel(false);
      this.h = null;
    }
    if (this.o != null) {
      synchronized (this.w)
      {
        if (this.o != null)
        {
          this.o.recycle();
          this.o = null;
        }
        return;
      }
    }
  }
  
  protected void c()
  {
    if (this.x)
    {
      QLog.e("FriendProfileCardBgDrawable", 1, "decodeNextFrame, FriendProfileCardBgDrawable has been recycled");
      return;
    }
    if ((this.g) && (!this.i))
    {
      this.g = false;
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.e;
      if (this.h != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeNextFrame mTask != null currentFrame = ");
        localStringBuilder.append(this.d);
        QLog.e("FriendProfileCardBgDrawable", 1, localStringBuilder.toString());
      }
      this.h = new FriendProfileCardBgDrawable.DecodeNextFrameTask(this, this.a);
      this.h.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.d) });
    }
  }
  
  public Bitmap d()
  {
    if (this.p == null) {
      try
      {
        e();
      }
      catch (IOException localIOException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decode Bg error, e.message = ");
        localStringBuilder.append(localIOException.toString());
        QLog.e("FriendProfileCardBgDrawable", 2, localStringBuilder.toString());
      }
    }
    return this.p;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.x)
    {
      QLog.e("FriendProfileCardBgDrawable", 1, "draw, FriendProfileCardBgDrawable has been recycled");
      return;
    }
    Object localObject;
    if (!this.m)
    {
      localObject = this.p;
      if (localObject == null)
      {
        c();
        return;
      }
      if (this.n != null)
      {
        if (((Bitmap)localObject).isRecycled())
        {
          this.p = null;
          QLog.e("FriendProfileCardBgDrawable", 1, "draw, mBackground has been recycled");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendProfileCardBgDrawable", 2, "draw static background");
        }
        localObject = this.v;
        if (localObject != null) {
          paramCanvas.drawBitmap(this.p, null, (Rect)localObject, this.n);
        }
      }
    }
    else
    {
      localObject = this.p;
      Rect localRect;
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        localObject = this.n;
        if (localObject != null)
        {
          localRect = this.v;
          if (localRect != null) {
            paramCanvas.drawBitmap(this.p, null, localRect, (Paint)localObject);
          }
        }
      }
      if (this.d != -1)
      {
        localObject = this.b;
        if (localObject != null) {
          if (((Bitmap)localObject).isRecycled())
          {
            this.b = null;
            QLog.e("FriendProfileCardBgDrawable", 1, "draw, mBitmap has been recycled");
          }
          else
          {
            localObject = this.n;
            if (localObject != null)
            {
              localRect = this.u;
              if (localRect != null) {
                paramCanvas.drawBitmap(this.b, null, localRect, (Paint)localObject);
              }
            }
          }
        }
      }
      if (this.k == 0)
      {
        super.invalidateSelf();
        this.l = true;
        return;
      }
      c();
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.t;
  }
  
  public int getIntrinsicWidth()
  {
    return this.s;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void run()
  {
    if (!this.m)
    {
      super.invalidateSelf();
      this.g = true;
      return;
    }
    if (this.c == null) {
      return;
    }
    this.g = true;
    this.d = a(this.d);
    Bitmap localBitmap1 = this.c;
    if (localBitmap1 != null)
    {
      Bitmap localBitmap2 = this.b;
      if (localBitmap2 != localBitmap1)
      {
        if (localBitmap2 != null) {
          if (Build.VERSION.SDK_INT > 11)
          {
            this.o = this.b;
          }
          else
          {
            this.b.recycle();
            this.o = null;
          }
        }
        this.b = this.c;
        this.c = null;
        super.invalidateSelf();
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.n.getAlpha())
    {
      this.n.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.n.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.n.setDither(paramBoolean);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FriendProfileCardBgDrawable
 * JD-Core Version:    0.7.0.1
 */