import android.graphics.Bitmap;
import android.graphics.Paint.FontMetrics;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class amqt
{
  private static TextPaint a;
  private static HashMap<Float, Float> b = new HashMap();
  private static HashMap<String, Integer> c = new HashMap();
  protected HashMap<String, WeakReference<Bitmap>> a;
  
  static
  {
    jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
  }
  
  public amqt()
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
  
  public static float a(amqx paramamqx1, amqx paramamqx2)
  {
    float f2 = 1.0F;
    float f1 = f2;
    if (paramamqx1 != null)
    {
      f1 = f2;
      if (paramamqx2 != null)
      {
        f1 = a(paramamqx1.jdField_g_of_type_Float);
        f2 = paramamqx1.h * 2;
        f1 = (a(paramamqx2.jdField_g_of_type_Float) + paramamqx2.h * 2) / (f1 + f2);
      }
    }
    return f1;
  }
  
  /* Error */
  public Bitmap a(amqx paramamqx)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_1
    //   7: ifnull +17 -> 24
    //   10: aload_1
    //   11: getfield 96	amqx:e	I
    //   14: ifeq +10 -> 24
    //   17: aload_1
    //   18: getfield 99	amqx:f	I
    //   21: ifne +7 -> 28
    //   24: aconst_null
    //   25: astore_3
    //   26: aload_3
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 101	amqt:b	(Lamqx;)Landroid/graphics/Bitmap;
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
    //   69: getfield 126	amqx:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
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
    //   105: getfield 126	amqx:jdField_a_of_type_JavaLangCharSequence	Ljava/lang/CharSequence;
    //   108: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: new 141	android/graphics/Canvas
    //   120: dup
    //   121: invokespecial 142	android/graphics/Canvas:<init>	()V
    //   124: astore 6
    //   126: aload_1
    //   127: getfield 96	amqx:e	I
    //   130: aload_1
    //   131: getfield 99	amqx:f	I
    //   134: getstatic 148	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   137: invokestatic 152	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   140: astore_3
    //   141: aload 6
    //   143: aload_3
    //   144: invokevirtual 156	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   147: aload 5
    //   149: astore_2
    //   150: aload_1
    //   151: getfield 159	amqx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   154: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +119 -> 276
    //   160: aload_0
    //   161: getfield 34	amqt:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   164: aload_1
    //   165: getfield 159	amqx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   193: ifnonnull +83 -> 276
    //   196: aload 4
    //   198: astore_2
    //   199: new 172	java/io/File
    //   202: dup
    //   203: aload_1
    //   204: getfield 159	amqx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   207: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: invokevirtual 178	java/io/File:exists	()Z
    //   213: ifeq +63 -> 276
    //   216: new 180	java/io/FileInputStream
    //   219: dup
    //   220: aload_1
    //   221: getfield 159	amqx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   224: invokespecial 181	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   227: astore 4
    //   229: new 183	java/io/BufferedInputStream
    //   232: dup
    //   233: aload 4
    //   235: invokespecial 186	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   238: astore 5
    //   240: aload 5
    //   242: invokestatic 192	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   245: astore_2
    //   246: aload_0
    //   247: getfield 34	amqt:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   250: aload_1
    //   251: getfield 159	amqx:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   254: new 167	java/lang/ref/WeakReference
    //   257: dup
    //   258: aload_2
    //   259: invokespecial 195	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   262: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   265: pop
    //   266: aload 5
    //   268: invokevirtual 198	java/io/BufferedInputStream:close	()V
    //   271: aload 4
    //   273: invokevirtual 199	java/io/FileInputStream:close	()V
    //   276: aload_2
    //   277: ifnonnull +275 -> 552
    //   280: aload_0
    //   281: getfield 34	amqt:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   284: ldc 201
    //   286: invokevirtual 45	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   289: checkcast 167	java/lang/ref/WeakReference
    //   292: astore 4
    //   294: aload 4
    //   296: ifnull +256 -> 552
    //   299: aload 4
    //   301: invokevirtual 170	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   304: checkcast 103	android/graphics/Bitmap
    //   307: astore_2
    //   308: aload_2
    //   309: astore 4
    //   311: aload_2
    //   312: ifnonnull +36 -> 348
    //   315: invokestatic 207	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   318: invokevirtual 213	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   321: ldc 214
    //   323: aconst_null
    //   324: invokestatic 218	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   327: astore 4
    //   329: aload_0
    //   330: getfield 34	amqt:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   333: ldc 201
    //   335: new 167	java/lang/ref/WeakReference
    //   338: dup
    //   339: aload 4
    //   341: invokespecial 195	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   344: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: pop
    //   348: aload 4
    //   350: invokevirtual 222	android/graphics/Bitmap:getNinePatchChunk	()[B
    //   353: astore_2
    //   354: aload_2
    //   355: ifnull +84 -> 439
    //   358: new 224	android/graphics/NinePatch
    //   361: dup
    //   362: aload 4
    //   364: aload_2
    //   365: aconst_null
    //   366: invokespecial 227	android/graphics/NinePatch:<init>	(Landroid/graphics/Bitmap;[BLjava/lang/String;)V
    //   369: astore_2
    //   370: aload_2
    //   371: ifnull +27 -> 398
    //   374: aload_2
    //   375: aload 6
    //   377: new 229	android/graphics/Rect
    //   380: dup
    //   381: iconst_0
    //   382: iconst_0
    //   383: aload_1
    //   384: getfield 96	amqx:e	I
    //   387: aload_1
    //   388: getfield 99	amqx:f	I
    //   391: invokespecial 232	android/graphics/Rect:<init>	(IIII)V
    //   394: aconst_null
    //   395: invokevirtual 236	android/graphics/NinePatch:draw	(Landroid/graphics/Canvas;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   398: aload_3
    //   399: astore_2
    //   400: aload_1
    //   401: getfield 239	amqx:jdField_a_of_type_AndroidTextStaticLayout	Landroid/text/StaticLayout;
    //   404: ifnull +27 -> 431
    //   407: aload 6
    //   409: aload_1
    //   410: getfield 241	amqx:jdField_g_of_type_Int	I
    //   413: i2f
    //   414: aload_1
    //   415: getfield 88	amqx:h	I
    //   418: i2f
    //   419: invokevirtual 245	android/graphics/Canvas:translate	(FF)V
    //   422: aload_1
    //   423: getfield 239	amqx:jdField_a_of_type_AndroidTextStaticLayout	Landroid/text/StaticLayout;
    //   426: aload 6
    //   428: invokevirtual 250	android/text/StaticLayout:draw	(Landroid/graphics/Canvas;)V
    //   431: aload_0
    //   432: aload_1
    //   433: aload_2
    //   434: invokevirtual 253	amqt:a	(Lamqx;Landroid/graphics/Bitmap;)V
    //   437: aload_2
    //   438: areturn
    //   439: aload 6
    //   441: aload 4
    //   443: new 229	android/graphics/Rect
    //   446: dup
    //   447: iconst_0
    //   448: iconst_0
    //   449: aload 4
    //   451: invokevirtual 257	android/graphics/Bitmap:getWidth	()I
    //   454: aload 4
    //   456: invokevirtual 260	android/graphics/Bitmap:getHeight	()I
    //   459: invokespecial 232	android/graphics/Rect:<init>	(IIII)V
    //   462: new 229	android/graphics/Rect
    //   465: dup
    //   466: iconst_0
    //   467: iconst_0
    //   468: aload_1
    //   469: getfield 96	amqx:e	I
    //   472: aload_1
    //   473: getfield 99	amqx:f	I
    //   476: invokespecial 232	android/graphics/Rect:<init>	(IIII)V
    //   479: aconst_null
    //   480: invokevirtual 264	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   483: goto -85 -> 398
    //   486: astore 4
    //   488: aload_3
    //   489: astore_2
    //   490: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq -93 -> 400
    //   496: ldc 114
    //   498: iconst_2
    //   499: aload 4
    //   501: invokevirtual 267	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   504: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: aload_3
    //   508: astore_2
    //   509: goto -109 -> 400
    //   512: astore 4
    //   514: aload_2
    //   515: astore_3
    //   516: aload_3
    //   517: astore_2
    //   518: invokestatic 112	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq -121 -> 400
    //   524: ldc 114
    //   526: iconst_2
    //   527: aload 4
    //   529: invokevirtual 270	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   532: invokestatic 269	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: aload_3
    //   536: astore_2
    //   537: goto -137 -> 400
    //   540: astore 4
    //   542: goto -26 -> 516
    //   545: astore 4
    //   547: aload_2
    //   548: astore_3
    //   549: goto -61 -> 488
    //   552: goto -244 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	555	0	this	amqt
    //   0	555	1	paramamqx	amqx
    //   33	515	2	localObject1	Object
    //   25	524	3	localObject2	Object
    //   4	451	4	localObject3	Object
    //   486	14	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   512	16	4	localException1	java.lang.Exception
    //   540	1	4	localException2	java.lang.Exception
    //   545	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1	266	5	localBufferedInputStream	java.io.BufferedInputStream
    //   124	316	6	localCanvas	android.graphics.Canvas
    // Exception table:
    //   from	to	target	type
    //   141	147	486	java/lang/OutOfMemoryError
    //   150	175	486	java/lang/OutOfMemoryError
    //   179	188	486	java/lang/OutOfMemoryError
    //   199	276	486	java/lang/OutOfMemoryError
    //   280	294	486	java/lang/OutOfMemoryError
    //   299	308	486	java/lang/OutOfMemoryError
    //   315	348	486	java/lang/OutOfMemoryError
    //   348	354	486	java/lang/OutOfMemoryError
    //   358	370	486	java/lang/OutOfMemoryError
    //   374	398	486	java/lang/OutOfMemoryError
    //   439	483	486	java/lang/OutOfMemoryError
    //   126	141	512	java/lang/Exception
    //   141	147	540	java/lang/Exception
    //   150	175	540	java/lang/Exception
    //   179	188	540	java/lang/Exception
    //   199	276	540	java/lang/Exception
    //   280	294	540	java/lang/Exception
    //   299	308	540	java/lang/Exception
    //   315	348	540	java/lang/Exception
    //   348	354	540	java/lang/Exception
    //   358	370	540	java/lang/Exception
    //   374	398	540	java/lang/Exception
    //   439	483	540	java/lang/Exception
    //   126	141	545	java/lang/OutOfMemoryError
  }
  
  public void a(amqx paramamqx)
  {
    if ((paramamqx == null) || (TextUtils.isEmpty(paramamqx.jdField_a_of_type_JavaLangCharSequence)) || (paramamqx.jdField_a_of_type_Boolean)) {
      return;
    }
    if (jdField_a_of_type_AndroidTextTextPaint.getTextSize() != paramamqx.jdField_g_of_type_Float) {
      jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramamqx.jdField_g_of_type_Float);
    }
    jdField_a_of_type_AndroidTextTextPaint.setColor(paramamqx.b);
    String str = paramamqx.jdField_a_of_type_JavaLangCharSequence + "_" + Float.valueOf(paramamqx.jdField_g_of_type_Float);
    Integer localInteger = (Integer)c.get(str);
    Object localObject = localInteger;
    if (localInteger == null)
    {
      localObject = Integer.valueOf((int)Math.ceil(StaticLayout.getDesiredWidth(paramamqx.jdField_a_of_type_JavaLangCharSequence, jdField_a_of_type_AndroidTextTextPaint)));
      c.put(str, localObject);
    }
    localObject = new StaticLayout(paramamqx.jdField_a_of_type_JavaLangCharSequence, jdField_a_of_type_AndroidTextTextPaint, ((Integer)localObject).intValue(), Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
    paramamqx.e = (((StaticLayout)localObject).getWidth() + paramamqx.jdField_g_of_type_Int * 2);
    paramamqx.f = (((StaticLayout)localObject).getHeight() + paramamqx.h * 2);
    paramamqx.jdField_a_of_type_Boolean = true;
    paramamqx.jdField_a_of_type_AndroidTextStaticLayout = ((StaticLayout)localObject);
  }
  
  public abstract void a(amqx paramamqx, Bitmap paramBitmap);
  
  public abstract Bitmap b(amqx paramamqx);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqt
 * JD-Core Version:    0.7.0.1
 */