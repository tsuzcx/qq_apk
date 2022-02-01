import android.graphics.Bitmap;
import android.graphics.Paint.FontMetrics;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class amle
{
  private static TextPaint a;
  private static HashMap<Float, Float> b = new HashMap();
  private static HashMap<String, Integer> c = new HashMap();
  protected HashMap<String, WeakReference<Bitmap>> a;
  
  static
  {
    jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
  }
  
  public amle()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static float a(float paramFloat)
  {
    Float localFloat = (Float)b.get(Float.valueOf(paramFloat));
    Object localObject = localFloat;
    if (localFloat == null)
    {
      if (paramFloat != jdField_a_of_type_AndroidTextTextPaint.getTextSize()) {
        jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
      }
      localObject = jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      float f1 = ((Paint.FontMetrics)localObject).descent;
      float f2 = ((Paint.FontMetrics)localObject).ascent;
      localObject = Float.valueOf(((Paint.FontMetrics)localObject).leading + (f1 - f2));
      b.put(Float.valueOf(paramFloat), localObject);
    }
    return ((Float)localObject).floatValue();
  }
  
  public static float a(amli paramamli1, amli paramamli2)
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (paramamli1 != null)
    {
      f1 = f2;
      if (paramamli2 != null)
      {
        f1 = a(paramamli1.jdField_g_of_type_Float);
        f2 = paramamli1.h * 2;
        f1 = (a(paramamli2.jdField_g_of_type_Float) + paramamli2.h * 2) / (f1 + f2);
      }
    }
    return f1;
  }
  
  /* Error */
  public Bitmap a(amli paramamli)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_1
    //   7: ifnull +17 -> 24
    //   10: aload_1
    //   11: getfield 96	amli:e	I
    //   14: ifeq +10 -> 24
    //   17: aload_1
    //   18: getfield 99	amli:f	I
    //   21: ifne +7 -> 28
    //   24: aconst_null
    //   25: astore_3
    //   26: aload_3
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 101	amle:b	(Lamli;)Landroid/graphics/Bitmap;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +48 -> 83
    //   38: aload_2
    //   39: invokevirtual 107	android/graphics/Bitmap:isRecycled	()Z
    //   42: ifne +41 -> 83
    //   45: aload_2
    //   46: astore_3
    //   47: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq -24 -> 26
    //   53: ldc 114
    //   55: iconst_2
    //   56: new 116	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   63: ldc 119
    //   65: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: getfield 126	amli:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   72: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_2
    //   82: areturn
    //   83: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   86: ifeq +31 -> 117
    //   89: ldc 114
    //   91: iconst_2
    //   92: new 116	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   99: ldc 139
    //   101: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: getfield 126	amli:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   108: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: new 141	android/graphics/Canvas
    //   120: dup
    //   121: invokespecial 142	android/graphics/Canvas:<init>	()V
    //   124: astore 6
    //   126: aload_1
    //   127: getfield 96	amli:e	I
    //   130: aload_1
    //   131: getfield 99	amli:f	I
    //   134: getstatic 148	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   137: invokestatic 152	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   140: astore_3
    //   141: aload 6
    //   143: aload_3
    //   144: invokevirtual 156	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   147: aload 5
    //   149: astore_2
    //   150: aload_1
    //   151: getfield 159	amli:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   154: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +101 -> 258
    //   160: aload_0
    //   161: getfield 34	amle:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   164: aload_1
    //   165: getfield 159	amli:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   168: invokevirtual 45	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   171: checkcast 167	java/lang/ref/WeakReference
    //   174: astore_2
    //   175: aload_2
    //   176: ifnull +12 -> 188
    //   179: aload_2
    //   180: invokevirtual 170	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   183: checkcast 103	android/graphics/Bitmap
    //   186: astore 4
    //   188: aload 4
    //   190: astore_2
    //   191: aload 4
    //   193: ifnonnull +65 -> 258
    //   196: aload 4
    //   198: astore_2
    //   199: new 172	java/io/File
    //   202: dup
    //   203: aload_1
    //   204: getfield 159	amli:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   207: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: invokevirtual 178	java/io/File:exists	()Z
    //   213: ifeq +45 -> 258
    //   216: new 180	java/io/BufferedInputStream
    //   219: dup
    //   220: new 182	java/io/FileInputStream
    //   223: dup
    //   224: aload_1
    //   225: getfield 159	amli:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   228: invokespecial 183	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   231: invokespecial 186	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   234: invokestatic 192	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   237: astore_2
    //   238: aload_0
    //   239: getfield 34	amle:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   242: aload_1
    //   243: getfield 159	amli:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   246: new 167	java/lang/ref/WeakReference
    //   249: dup
    //   250: aload_2
    //   251: invokespecial 195	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   254: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   257: pop
    //   258: aload_2
    //   259: ifnonnull +275 -> 534
    //   262: aload_0
    //   263: getfield 34	amle:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   266: ldc 197
    //   268: invokevirtual 45	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   271: checkcast 167	java/lang/ref/WeakReference
    //   274: astore 4
    //   276: aload 4
    //   278: ifnull +256 -> 534
    //   281: aload 4
    //   283: invokevirtual 170	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   286: checkcast 103	android/graphics/Bitmap
    //   289: astore_2
    //   290: aload_2
    //   291: astore 4
    //   293: aload_2
    //   294: ifnonnull +36 -> 330
    //   297: invokestatic 203	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   300: invokevirtual 209	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   303: ldc 210
    //   305: aconst_null
    //   306: invokestatic 214	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   309: astore 4
    //   311: aload_0
    //   312: getfield 34	amle:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   315: ldc 197
    //   317: new 167	java/lang/ref/WeakReference
    //   320: dup
    //   321: aload 4
    //   323: invokespecial 195	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   326: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   329: pop
    //   330: aload 4
    //   332: invokevirtual 218	android/graphics/Bitmap:getNinePatchChunk	()[B
    //   335: astore_2
    //   336: aload_2
    //   337: ifnull +84 -> 421
    //   340: new 220	android/graphics/NinePatch
    //   343: dup
    //   344: aload 4
    //   346: aload_2
    //   347: aconst_null
    //   348: invokespecial 223	android/graphics/NinePatch:<init>	(Landroid/graphics/Bitmap;[BLjava/lang/String;)V
    //   351: astore_2
    //   352: aload_2
    //   353: ifnull +27 -> 380
    //   356: aload_2
    //   357: aload 6
    //   359: new 225	android/graphics/Rect
    //   362: dup
    //   363: iconst_0
    //   364: iconst_0
    //   365: aload_1
    //   366: getfield 96	amli:e	I
    //   369: aload_1
    //   370: getfield 99	amli:f	I
    //   373: invokespecial 228	android/graphics/Rect:<init>	(IIII)V
    //   376: aconst_null
    //   377: invokevirtual 232	android/graphics/NinePatch:draw	(Landroid/graphics/Canvas;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   380: aload_3
    //   381: astore_2
    //   382: aload_1
    //   383: getfield 235	amli:jdField_a_of_type_AndroidTextStaticLayout	Landroid/text/StaticLayout;
    //   386: ifnull +27 -> 413
    //   389: aload 6
    //   391: aload_1
    //   392: getfield 237	amli:jdField_g_of_type_Int	I
    //   395: i2f
    //   396: aload_1
    //   397: getfield 88	amli:h	I
    //   400: i2f
    //   401: invokevirtual 241	android/graphics/Canvas:translate	(FF)V
    //   404: aload_1
    //   405: getfield 235	amli:jdField_a_of_type_AndroidTextStaticLayout	Landroid/text/StaticLayout;
    //   408: aload 6
    //   410: invokevirtual 246	android/text/StaticLayout:draw	(Landroid/graphics/Canvas;)V
    //   413: aload_0
    //   414: aload_1
    //   415: aload_2
    //   416: invokevirtual 249	amle:a	(Lamli;Landroid/graphics/Bitmap;)V
    //   419: aload_2
    //   420: areturn
    //   421: aload 6
    //   423: aload 4
    //   425: new 225	android/graphics/Rect
    //   428: dup
    //   429: iconst_0
    //   430: iconst_0
    //   431: aload 4
    //   433: invokevirtual 253	android/graphics/Bitmap:getWidth	()I
    //   436: aload 4
    //   438: invokevirtual 256	android/graphics/Bitmap:getHeight	()I
    //   441: invokespecial 228	android/graphics/Rect:<init>	(IIII)V
    //   444: new 225	android/graphics/Rect
    //   447: dup
    //   448: iconst_0
    //   449: iconst_0
    //   450: aload_1
    //   451: getfield 96	amli:e	I
    //   454: aload_1
    //   455: getfield 99	amli:f	I
    //   458: invokespecial 228	android/graphics/Rect:<init>	(IIII)V
    //   461: aconst_null
    //   462: invokevirtual 260	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   465: goto -85 -> 380
    //   468: astore 4
    //   470: aload_3
    //   471: astore_2
    //   472: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq -93 -> 382
    //   478: ldc 114
    //   480: iconst_2
    //   481: aload 4
    //   483: invokevirtual 263	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   486: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: aload_3
    //   490: astore_2
    //   491: goto -109 -> 382
    //   494: astore 4
    //   496: aload_2
    //   497: astore_3
    //   498: aload_3
    //   499: astore_2
    //   500: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq -121 -> 382
    //   506: ldc 114
    //   508: iconst_2
    //   509: aload 4
    //   511: invokevirtual 266	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   514: invokestatic 265	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: aload_3
    //   518: astore_2
    //   519: goto -137 -> 382
    //   522: astore 4
    //   524: goto -26 -> 498
    //   527: astore 4
    //   529: aload_2
    //   530: astore_3
    //   531: goto -61 -> 470
    //   534: goto -244 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	amle
    //   0	537	1	paramamli	amli
    //   33	497	2	localObject1	Object
    //   25	506	3	localObject2	Object
    //   4	433	4	localObject3	Object
    //   468	14	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   494	16	4	localException1	java.lang.Exception
    //   522	1	4	localException2	java.lang.Exception
    //   527	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1	147	5	localObject4	Object
    //   124	298	6	localCanvas	android.graphics.Canvas
    // Exception table:
    //   from	to	target	type
    //   141	147	468	java/lang/OutOfMemoryError
    //   150	175	468	java/lang/OutOfMemoryError
    //   179	188	468	java/lang/OutOfMemoryError
    //   199	258	468	java/lang/OutOfMemoryError
    //   262	276	468	java/lang/OutOfMemoryError
    //   281	290	468	java/lang/OutOfMemoryError
    //   297	330	468	java/lang/OutOfMemoryError
    //   330	336	468	java/lang/OutOfMemoryError
    //   340	352	468	java/lang/OutOfMemoryError
    //   356	380	468	java/lang/OutOfMemoryError
    //   421	465	468	java/lang/OutOfMemoryError
    //   126	141	494	java/lang/Exception
    //   141	147	522	java/lang/Exception
    //   150	175	522	java/lang/Exception
    //   179	188	522	java/lang/Exception
    //   199	258	522	java/lang/Exception
    //   262	276	522	java/lang/Exception
    //   281	290	522	java/lang/Exception
    //   297	330	522	java/lang/Exception
    //   330	336	522	java/lang/Exception
    //   340	352	522	java/lang/Exception
    //   356	380	522	java/lang/Exception
    //   421	465	522	java/lang/Exception
    //   126	141	527	java/lang/OutOfMemoryError
  }
  
  public void a(amli paramamli)
  {
    if ((paramamli == null) || (TextUtils.isEmpty(paramamli.jdField_a_of_type_JavaLangCharSequence)) || (paramamli.jdField_a_of_type_Boolean)) {
      return;
    }
    if (jdField_a_of_type_AndroidTextTextPaint.getTextSize() != paramamli.jdField_g_of_type_Float) {
      jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramamli.jdField_g_of_type_Float);
    }
    jdField_a_of_type_AndroidTextTextPaint.setColor(paramamli.b);
    String str = paramamli.jdField_a_of_type_JavaLangCharSequence + "_" + Float.valueOf(paramamli.jdField_g_of_type_Float);
    Integer localInteger = (Integer)c.get(str);
    Object localObject = localInteger;
    if (localInteger == null)
    {
      localObject = Integer.valueOf((int)Math.ceil(StaticLayout.getDesiredWidth(paramamli.jdField_a_of_type_JavaLangCharSequence, jdField_a_of_type_AndroidTextTextPaint)));
      c.put(str, localObject);
    }
    localObject = new StaticLayout(paramamli.jdField_a_of_type_JavaLangCharSequence, jdField_a_of_type_AndroidTextTextPaint, ((Integer)localObject).intValue(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
    paramamli.e = (((StaticLayout)localObject).getWidth() + paramamli.jdField_g_of_type_Int * 2);
    paramamli.f = (((StaticLayout)localObject).getHeight() + paramamli.h * 2);
    paramamli.jdField_a_of_type_Boolean = true;
    paramamli.jdField_a_of_type_AndroidTextStaticLayout = ((StaticLayout)localObject);
  }
  
  public abstract void a(amli paramamli, Bitmap paramBitmap);
  
  public abstract Bitmap b(amli paramamli);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amle
 * JD-Core Version:    0.7.0.1
 */