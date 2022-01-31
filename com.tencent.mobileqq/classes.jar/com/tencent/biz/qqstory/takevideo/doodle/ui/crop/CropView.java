package com.tencent.biz.qqstory.takevideo.doodle.ui.crop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import befq;
import com.tencent.qphone.base.util.QLog;
import urk;
import urq;
import vaj;

public class CropView
  extends View
  implements Handler.Callback, View.OnTouchListener
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_a_of_type_AndroidGraphicsRect;
  befq jdField_a_of_type_Befq;
  vaj jdField_a_of_type_Vaj;
  boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_b_of_type_AndroidGraphicsRect;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int = 8;
  Rect jdField_d_of_type_AndroidGraphicsRect = new Rect();
  boolean jdField_d_of_type_Boolean = true;
  float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 40;
  Rect jdField_e_of_type_AndroidGraphicsRect;
  private boolean jdField_e_of_type_Boolean = true;
  float f;
  float g;
  float h;
  float i;
  float j;
  private float k;
  private float l;
  
  public CropView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private int a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getPointerCount() == 2) {
      return 0;
    }
    int m = this.jdField_e_of_type_Int;
    Rect localRect1 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left - m * 10, this.jdField_a_of_type_AndroidGraphicsRect.top - m * 10, this.jdField_a_of_type_AndroidGraphicsRect.left + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.top + m * 2);
    Rect localRect2 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.top - m * 10, this.jdField_a_of_type_AndroidGraphicsRect.right + m * 10, this.jdField_a_of_type_AndroidGraphicsRect.top + m * 2);
    Rect localRect3 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left - m * 10, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.left + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.bottom + m * 10);
    Rect localRect4 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.right + m * 10, this.jdField_a_of_type_AndroidGraphicsRect.bottom + m * 10);
    Rect localRect5 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left - m * 10, this.jdField_a_of_type_AndroidGraphicsRect.top + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.left + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m * 2);
    Rect localRect6 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.right - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.top + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.right + m * 10, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m * 2);
    Rect localRect7 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.top - m * 10, this.jdField_a_of_type_AndroidGraphicsRect.right - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.top + m * 2);
    Rect localRect8 = new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left + m * 2, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m * 2, this.jdField_a_of_type_AndroidGraphicsRect.right - m * 2, m * 10 + this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    if (localRect1.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 1;
    }
    if (localRect2.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 2;
    }
    if (localRect3.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 3;
    }
    if (localRect4.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 4;
    }
    if (localRect5.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 5;
    }
    if (localRect6.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 7;
    }
    if (localRect7.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 6;
    }
    if (localRect8.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
      return 8;
    }
    return 0;
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  private Bitmap a(int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: getstatic 118	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 10
    //   5: if_icmplt +863 -> 868
    //   8: aload_0
    //   9: getfield 120	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_b_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   12: astore 9
    //   14: new 122	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: invokespecial 123	java/io/ByteArrayOutputStream:<init>	()V
    //   21: astore 10
    //   23: aload 9
    //   25: getstatic 129	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   28: bipush 100
    //   30: aload 10
    //   32: invokevirtual 135	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   35: pop
    //   36: aload 10
    //   38: invokevirtual 139	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   41: astore 9
    //   43: aload 9
    //   45: iconst_0
    //   46: aload 9
    //   48: arraylength
    //   49: iconst_0
    //   50: invokestatic 145	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   53: astore 9
    //   55: aload 9
    //   57: ifnull +811 -> 868
    //   60: aload_0
    //   61: invokevirtual 148	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:a	()[F
    //   64: astore 10
    //   66: ldc 150
    //   68: ldc 152
    //   70: invokestatic 157	urk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   77: ifnonnull +65 -> 142
    //   80: aload_0
    //   81: new 51	android/graphics/Rect
    //   84: dup
    //   85: invokespecial 52	android/graphics/Rect:<init>	()V
    //   88: putfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   91: aload_0
    //   92: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   95: iconst_0
    //   96: putfield 83	android/graphics/Rect:top	I
    //   99: aload_0
    //   100: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   103: iconst_0
    //   104: putfield 80	android/graphics/Rect:left	I
    //   107: aload_0
    //   108: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   111: aload 9
    //   113: invokevirtual 162	android/graphics/BitmapRegionDecoder:getWidth	()I
    //   116: putfield 89	android/graphics/Rect:right	I
    //   119: aload_0
    //   120: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   123: aload 9
    //   125: invokevirtual 165	android/graphics/BitmapRegionDecoder:getHeight	()I
    //   128: putfield 92	android/graphics/Rect:bottom	I
    //   131: aload_0
    //   132: getfield 58	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_d_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   135: aload_0
    //   136: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   139: invokevirtual 169	android/graphics/Rect:set	(Landroid/graphics/Rect;)V
    //   142: aload_0
    //   143: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   146: invokevirtual 172	android/graphics/Rect:width	()I
    //   149: istore 5
    //   151: aload_0
    //   152: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   155: invokevirtual 175	android/graphics/Rect:height	()I
    //   158: istore 6
    //   160: aload_0
    //   161: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   164: aload_0
    //   165: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   168: getfield 83	android/graphics/Rect:top	I
    //   171: i2f
    //   172: iload 6
    //   174: i2f
    //   175: aload 10
    //   177: iconst_1
    //   178: faload
    //   179: fmul
    //   180: fadd
    //   181: f2i
    //   182: putfield 83	android/graphics/Rect:top	I
    //   185: aload_0
    //   186: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   189: aload_0
    //   190: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   193: getfield 92	android/graphics/Rect:bottom	I
    //   196: i2f
    //   197: iload 6
    //   199: i2f
    //   200: aload 10
    //   202: iconst_3
    //   203: faload
    //   204: fmul
    //   205: fsub
    //   206: f2i
    //   207: putfield 92	android/graphics/Rect:bottom	I
    //   210: aload_0
    //   211: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   214: aload_0
    //   215: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   218: getfield 80	android/graphics/Rect:left	I
    //   221: i2f
    //   222: iload 5
    //   224: i2f
    //   225: aload 10
    //   227: iconst_0
    //   228: faload
    //   229: fmul
    //   230: fadd
    //   231: f2i
    //   232: putfield 80	android/graphics/Rect:left	I
    //   235: aload_0
    //   236: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   239: aload_0
    //   240: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   243: getfield 89	android/graphics/Rect:right	I
    //   246: i2f
    //   247: iload 5
    //   249: i2f
    //   250: aload 10
    //   252: iconst_2
    //   253: faload
    //   254: fmul
    //   255: fsub
    //   256: f2i
    //   257: putfield 89	android/graphics/Rect:right	I
    //   260: ldc 150
    //   262: new 177	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   269: ldc 180
    //   271: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload 10
    //   276: iconst_0
    //   277: faload
    //   278: invokevirtual 187	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   281: ldc 189
    //   283: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload 10
    //   288: iconst_1
    //   289: faload
    //   290: invokevirtual 187	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   293: ldc 189
    //   295: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 10
    //   300: iconst_2
    //   301: faload
    //   302: invokevirtual 187	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   305: ldc 189
    //   307: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload 10
    //   312: iconst_3
    //   313: faload
    //   314: invokevirtual 187	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   317: ldc 191
    //   319: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_0
    //   323: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   326: getfield 80	android/graphics/Rect:left	I
    //   329: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc 196
    //   334: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_0
    //   338: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   341: getfield 89	android/graphics/Rect:right	I
    //   344: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: ldc 198
    //   349: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_0
    //   353: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   356: getfield 83	android/graphics/Rect:top	I
    //   359: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: ldc 200
    //   364: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   371: getfield 92	android/graphics/Rect:bottom	I
    //   374: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 206	urk:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: ldc 150
    //   385: new 177	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   392: ldc 208
    //   394: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_0
    //   398: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   401: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 157	urk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: new 213	android/graphics/BitmapFactory$Options
    //   413: dup
    //   414: invokespecial 214	android/graphics/BitmapFactory$Options:<init>	()V
    //   417: astore 10
    //   419: aload 10
    //   421: iconst_1
    //   422: putfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   425: aload 9
    //   427: aload_0
    //   428: getfield 159	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_e_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   431: aload 10
    //   433: invokevirtual 221	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   436: astore 10
    //   438: aload_0
    //   439: getfield 223	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:jdField_c_of_type_Int	I
    //   442: istore 7
    //   444: iload 7
    //   446: ifne +37 -> 483
    //   449: aload 9
    //   451: invokevirtual 226	android/graphics/BitmapRegionDecoder:recycle	()V
    //   454: aload 10
    //   456: areturn
    //   457: astore 9
    //   459: ldc 150
    //   461: ldc 228
    //   463: aload 9
    //   465: invokestatic 231	urk:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   468: aload_1
    //   469: ifnull +8 -> 477
    //   472: aload_1
    //   473: iconst_0
    //   474: bipush 253
    //   476: iastore
    //   477: aconst_null
    //   478: astore 9
    //   480: goto -425 -> 55
    //   483: ldc 150
    //   485: new 177	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   492: ldc 233
    //   494: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: iload 7
    //   499: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 157	urk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: aload 10
    //   510: invokevirtual 234	android/graphics/Bitmap:getWidth	()I
    //   513: istore 6
    //   515: aload 10
    //   517: invokevirtual 235	android/graphics/Bitmap:getHeight	()I
    //   520: istore 5
    //   522: iload 7
    //   524: bipush 90
    //   526: if_icmpeq +11 -> 537
    //   529: iload 7
    //   531: sipush 270
    //   534: if_icmpne +371 -> 905
    //   537: aload 10
    //   539: invokevirtual 235	android/graphics/Bitmap:getHeight	()I
    //   542: istore 6
    //   544: aload 10
    //   546: invokevirtual 234	android/graphics/Bitmap:getWidth	()I
    //   549: istore 5
    //   551: ldc 150
    //   553: new 177	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   560: ldc 237
    //   562: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: iload 6
    //   567: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   570: ldc 239
    //   572: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: iload 5
    //   577: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   580: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 157	urk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: aload_0
    //   587: invokevirtual 243	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:getContext	()Landroid/content/Context;
    //   590: invokevirtual 249	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   593: invokevirtual 255	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   596: getfield 260	android/util/DisplayMetrics:widthPixels	I
    //   599: i2f
    //   600: fstore_2
    //   601: aload_0
    //   602: invokevirtual 243	com/tencent/biz/qqstory/takevideo/doodle/ui/crop/CropView:getContext	()Landroid/content/Context;
    //   605: invokevirtual 249	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   608: invokevirtual 255	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   611: getfield 263	android/util/DisplayMetrics:heightPixels	I
    //   614: i2f
    //   615: fstore_3
    //   616: iload 5
    //   618: i2f
    //   619: iload 6
    //   621: i2f
    //   622: fdiv
    //   623: fstore 4
    //   625: fload_3
    //   626: fload_2
    //   627: fdiv
    //   628: fstore_2
    //   629: ldc 150
    //   631: new 177	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   638: ldc_w 265
    //   641: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: fconst_1
    //   645: invokevirtual 187	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   648: ldc_w 267
    //   651: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: iload 6
    //   656: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   659: ldc_w 269
    //   662: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: iload 5
    //   667: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   670: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 157	urk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: iload 6
    //   678: iload 5
    //   680: getstatic 275	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   683: invokestatic 279	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   686: astore 11
    //   688: new 281	android/graphics/Canvas
    //   691: dup
    //   692: aload 11
    //   694: invokespecial 284	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   697: astore 12
    //   699: new 286	android/graphics/Matrix
    //   702: dup
    //   703: invokespecial 287	android/graphics/Matrix:<init>	()V
    //   706: astore 13
    //   708: iload 7
    //   710: ifeq +28 -> 738
    //   713: aload 13
    //   715: iload 7
    //   717: i2f
    //   718: aload 10
    //   720: invokevirtual 234	android/graphics/Bitmap:getWidth	()I
    //   723: iconst_2
    //   724: idiv
    //   725: i2f
    //   726: aload 10
    //   728: invokevirtual 235	android/graphics/Bitmap:getHeight	()I
    //   731: iconst_2
    //   732: idiv
    //   733: i2f
    //   734: invokevirtual 291	android/graphics/Matrix:postRotate	(FFF)Z
    //   737: pop
    //   738: aload 10
    //   740: invokevirtual 234	android/graphics/Bitmap:getWidth	()I
    //   743: iconst_2
    //   744: idiv
    //   745: istore 7
    //   747: iload 6
    //   749: iconst_2
    //   750: idiv
    //   751: istore 6
    //   753: aload 10
    //   755: invokevirtual 235	android/graphics/Bitmap:getHeight	()I
    //   758: iconst_2
    //   759: idiv
    //   760: istore 8
    //   762: iload 5
    //   764: iconst_2
    //   765: idiv
    //   766: istore 5
    //   768: aload 13
    //   770: iload 7
    //   772: iload 6
    //   774: isub
    //   775: ineg
    //   776: i2f
    //   777: iload 8
    //   779: iload 5
    //   781: isub
    //   782: ineg
    //   783: i2f
    //   784: invokevirtual 295	android/graphics/Matrix:postTranslate	(FF)Z
    //   787: pop
    //   788: aload 12
    //   790: aload 10
    //   792: aload 13
    //   794: aconst_null
    //   795: invokevirtual 299	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   798: ldc 150
    //   800: new 177	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   807: ldc_w 301
    //   810: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: aload 11
    //   815: invokevirtual 305	android/graphics/Bitmap:isMutable	()Z
    //   818: invokevirtual 308	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   821: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: invokestatic 157	urk:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   827: aload_1
    //   828: ifnull +7 -> 835
    //   831: aload_1
    //   832: iconst_0
    //   833: iconst_0
    //   834: iastore
    //   835: aload 9
    //   837: invokevirtual 226	android/graphics/BitmapRegionDecoder:recycle	()V
    //   840: aload 11
    //   842: areturn
    //   843: astore 10
    //   845: ldc 150
    //   847: ldc 228
    //   849: aload 10
    //   851: invokestatic 231	urk:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   854: aload_1
    //   855: ifnull +8 -> 863
    //   858: aload_1
    //   859: iconst_0
    //   860: bipush 254
    //   862: iastore
    //   863: aload 9
    //   865: invokevirtual 226	android/graphics/BitmapRegionDecoder:recycle	()V
    //   868: aconst_null
    //   869: areturn
    //   870: astore 10
    //   872: ldc 150
    //   874: ldc 228
    //   876: aload 10
    //   878: invokestatic 231	urk:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   881: aload_1
    //   882: ifnull +7 -> 889
    //   885: aload_1
    //   886: iconst_0
    //   887: iconst_m1
    //   888: iastore
    //   889: aload 9
    //   891: invokevirtual 226	android/graphics/BitmapRegionDecoder:recycle	()V
    //   894: goto -26 -> 868
    //   897: astore_1
    //   898: aload 9
    //   900: invokevirtual 226	android/graphics/BitmapRegionDecoder:recycle	()V
    //   903: aload_1
    //   904: athrow
    //   905: goto -354 -> 551
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	908	0	this	CropView
    //   0	908	1	paramArrayOfInt	int[]
    //   600	29	2	f1	float
    //   615	11	3	f2	float
    //   623	1	4	f3	float
    //   149	633	5	m	int
    //   158	617	6	n	int
    //   442	333	7	i1	int
    //   760	22	8	i2	int
    //   12	438	9	localObject1	Object
    //   457	7	9	localIOException	java.io.IOException
    //   478	421	9	localObject2	Object
    //   21	770	10	localObject3	Object
    //   843	7	10	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   870	7	10	localException	java.lang.Exception
    //   686	155	11	localBitmap	Bitmap
    //   697	92	12	localCanvas	Canvas
    //   706	87	13	localMatrix	Matrix
    // Exception table:
    //   from	to	target	type
    //   8	55	457	java/io/IOException
    //   425	444	843	java/lang/OutOfMemoryError
    //   483	522	843	java/lang/OutOfMemoryError
    //   537	551	843	java/lang/OutOfMemoryError
    //   551	708	843	java/lang/OutOfMemoryError
    //   713	738	843	java/lang/OutOfMemoryError
    //   738	827	843	java/lang/OutOfMemoryError
    //   425	444	870	java/lang/Exception
    //   483	522	870	java/lang/Exception
    //   537	551	870	java/lang/Exception
    //   551	708	870	java/lang/Exception
    //   713	738	870	java/lang/Exception
    //   738	827	870	java/lang/Exception
    //   425	444	897	finally
    //   483	522	897	finally
    //   537	551	897	finally
    //   551	708	897	finally
    //   713	738	897	finally
    //   738	827	897	finally
    //   845	854	897	finally
    //   872	881	897	finally
  }
  
  private Rect a()
  {
    float f2;
    if (this.jdField_d_of_type_Boolean) {
      f2 = this.k;
    }
    for (float f1 = this.l;; f1 = this.k)
    {
      float f3 = this.jdField_d_of_type_Float / 2.0F;
      float f4 = f2 / 2.0F;
      float f5 = this.jdField_e_of_type_Float / 2.0F;
      float f6 = f1 / 2.0F;
      float f7 = this.jdField_d_of_type_Float / 2.0F;
      f2 /= 2.0F;
      float f8 = this.jdField_e_of_type_Float / 2.0F;
      f1 /= 2.0F;
      return new Rect((int)(f3 - f4 + 0.5F), (int)(f5 - f6 + 0.5F), (int)(f2 + f7 + 0.5F), (int)(f1 + f8 + 0.5F));
      f2 = this.l;
    }
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Befq.removeMessages(1001);
    int m = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + paramFloat1);
    int n = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + paramFloat1);
    int i1 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.top + paramFloat2);
    int i2 = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom + paramFloat2);
    if (m <= this.jdField_b_of_type_AndroidGraphicsRect.left)
    {
      paramFloat1 = this.jdField_b_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.left;
      if (i1 > this.jdField_b_of_type_AndroidGraphicsRect.top) {
        break label204;
      }
      paramFloat2 = this.jdField_b_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.top;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.offset((int)paramFloat1, (int)paramFloat2);
      this.jdField_c_of_type_Boolean = true;
      if ((this.jdField_a_of_type_Vaj != null) && (paramFloat1 > 0.0F) && (paramFloat2 > 0.0F)) {
        this.jdField_a_of_type_Vaj.a(this.jdField_c_of_type_Boolean);
      }
      return;
      if (this.jdField_b_of_type_AndroidGraphicsRect.right > n) {
        break;
      }
      paramFloat1 = this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right;
      break;
      label204:
      if (this.jdField_b_of_type_AndroidGraphicsRect.bottom <= i2) {
        paramFloat2 = this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      }
    }
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Befq.removeMessages(1001);
    int m;
    Rect localRect;
    if (paramInt == 1)
    {
      paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + paramFloat1);
      m = (int)(this.jdField_a_of_type_AndroidGraphicsRect.top + paramFloat2);
      if ((paramInt + 64 < this.jdField_a_of_type_AndroidGraphicsRect.right) && (paramInt >= this.jdField_b_of_type_AndroidGraphicsRect.left))
      {
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.left = ((int)(localRect.left + paramFloat1));
      }
      if ((m + 64 < this.jdField_a_of_type_AndroidGraphicsRect.bottom) && (m >= this.jdField_b_of_type_AndroidGraphicsRect.top))
      {
        localRect = this.jdField_a_of_type_AndroidGraphicsRect;
        localRect.top = ((int)(localRect.top + paramFloat2));
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_Vaj != null) {
        this.jdField_a_of_type_Vaj.a(this.jdField_c_of_type_Boolean);
      }
      return;
      if (paramInt == 2)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + paramFloat1);
        m = (int)(this.jdField_a_of_type_AndroidGraphicsRect.top + paramFloat2);
        if ((paramInt - 64 > this.jdField_a_of_type_AndroidGraphicsRect.left) && (paramInt <= this.jdField_b_of_type_AndroidGraphicsRect.right))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.right = ((int)(localRect.right + paramFloat1));
        }
        if ((m + 64 < this.jdField_a_of_type_AndroidGraphicsRect.bottom) && (m >= this.jdField_b_of_type_AndroidGraphicsRect.top))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.top = ((int)(localRect.top + paramFloat2));
        }
      }
      else if (paramInt == 3)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + paramFloat1);
        m = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom + paramFloat2);
        if ((paramInt + 64 < this.jdField_a_of_type_AndroidGraphicsRect.right) && (paramInt >= this.jdField_b_of_type_AndroidGraphicsRect.left))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.left = ((int)(localRect.left + paramFloat1));
        }
        if ((m - 64 > this.jdField_a_of_type_AndroidGraphicsRect.top) && (m <= this.jdField_b_of_type_AndroidGraphicsRect.bottom))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.bottom = ((int)(localRect.bottom + paramFloat2));
        }
      }
      else if (paramInt == 4)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + paramFloat1);
        m = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom + paramFloat2);
        if ((paramInt - 64 > this.jdField_a_of_type_AndroidGraphicsRect.left) && (paramInt <= this.jdField_b_of_type_AndroidGraphicsRect.right))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.right = ((int)(localRect.right + paramFloat1));
        }
        if ((m - 64 > this.jdField_a_of_type_AndroidGraphicsRect.top) && (m <= this.jdField_b_of_type_AndroidGraphicsRect.bottom))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.bottom = ((int)(localRect.bottom + paramFloat2));
        }
      }
      else if (paramInt == 5)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.left + paramFloat1);
        if ((paramInt + 64 < this.jdField_a_of_type_AndroidGraphicsRect.right) && (paramInt >= this.jdField_b_of_type_AndroidGraphicsRect.left))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.left = ((int)(localRect.left + paramFloat1));
        }
      }
      else if (paramInt == 7)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.right + paramFloat1);
        if ((paramInt - 64 > this.jdField_a_of_type_AndroidGraphicsRect.left) && (paramInt <= this.jdField_b_of_type_AndroidGraphicsRect.right))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.right = ((int)(localRect.right + paramFloat1));
        }
      }
      else if (paramInt == 6)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.top + paramFloat2);
        if ((paramInt + 64 < this.jdField_a_of_type_AndroidGraphicsRect.bottom) && (paramInt >= this.jdField_b_of_type_AndroidGraphicsRect.top))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.top = ((int)(localRect.top + paramFloat2));
        }
      }
      else if (paramInt == 8)
      {
        paramInt = (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom + paramFloat2);
        if ((paramInt - 64 > this.jdField_a_of_type_AndroidGraphicsRect.top) && (paramInt <= this.jdField_b_of_type_AndroidGraphicsRect.bottom))
        {
          localRect = this.jdField_a_of_type_AndroidGraphicsRect;
          localRect.bottom = ((int)(localRect.bottom + paramFloat2));
        }
      }
    }
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(160);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(5.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(255);
    paramCanvas.save();
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      return;
    }
    paramCanvas.clipRect(this.jdField_a_of_type_AndroidGraphicsRect, Region.Op.XOR);
    paramCanvas.drawRect(this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    Path localPath = new Path();
    localPath.moveTo(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top);
    localPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top);
    localPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    localPath.lineTo(this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    localPath.close();
    paramCanvas.drawPath(localPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    int m = (int)(0.07F * this.jdField_b_of_type_AndroidGraphicsRect.width() + 0.5F);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.left + m, this.jdField_a_of_type_AndroidGraphicsRect.top);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.right - m, this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.top + m);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.top + m);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.left + m, this.jdField_a_of_type_AndroidGraphicsRect.bottom + this.jdField_d_of_type_Int);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.right - m, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.bottom + this.jdField_d_of_type_Int);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_c_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.bottom - m, this.jdField_a_of_type_AndroidGraphicsRect.right + this.jdField_d_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    paramCanvas.drawRect(this.jdField_c_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsPaint);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.save();
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(150);
    float f1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    float f2 = this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.height() / 3;
    paramCanvas.drawLine(f1, f2, this.jdField_a_of_type_AndroidGraphicsRect.right, f2, this.jdField_b_of_type_AndroidGraphicsPaint);
    f1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    f2 = this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.height() / 3 * 2;
    paramCanvas.drawLine(f1, f2, this.jdField_a_of_type_AndroidGraphicsRect.right, f2, this.jdField_b_of_type_AndroidGraphicsPaint);
    f1 = this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 3;
    paramCanvas.drawLine(f1, this.jdField_a_of_type_AndroidGraphicsRect.top, f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
    f1 = this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 3 * 2;
    paramCanvas.drawLine(f1, this.jdField_a_of_type_AndroidGraphicsRect.top, f1, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(1.0F, 1.0F);
    float f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    float f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    this.h = Math.min(this.f / f1, this.g / f2);
    urk.b("EditPicActivityCropView", "setBitmap scale : " + this.h);
    this.k = (f1 * this.h);
    this.l = (this.h * f2);
    urk.b("EditPicActivityCropView", "setBitmap image width " + this.k + " image height " + this.l);
    this.jdField_a_of_type_AndroidGraphicsRect = a();
    this.jdField_b_of_type_AndroidGraphicsRect = a();
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.h, this.h);
    this.i = (this.jdField_d_of_type_Float / 2.0F);
    this.j = (this.jdField_e_of_type_Float / 2.0F);
    f1 = this.i;
    f2 = this.k / 2.0F;
    float f3 = this.j;
    float f4 = this.l / 2.0F;
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f1 - f2, f3 - f4);
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_e_of_type_AndroidGraphicsRect = null;
    this.jdField_a_of_type_Befq.removeMessages(1001);
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(1.0F, 1.0F);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      urk.e("EditPicActivityCropView", "cropview rotate bitmap is null..");
    }
    float f1;
    float f2;
    float f3;
    label194:
    label201:
    label228:
    do
    {
      return;
      f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      f2 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      f3 = this.i;
      float f4 = f1 / 2.0F;
      float f5 = this.j;
      float f6 = f2 / 2.0F;
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f3 - f4, f5 - f6);
      this.jdField_b_of_type_Int += paramInt;
      this.jdField_b_of_type_Int %= 360;
      this.jdField_c_of_type_Int += paramInt;
      this.jdField_c_of_type_Int %= 360;
      switch (this.jdField_b_of_type_Int)
      {
      default: 
        if (!this.jdField_d_of_type_Boolean) {
          break label468;
        }
        f3 = f1;
        if (!this.jdField_d_of_type_Boolean) {
          break label474;
        }
        if (f2 / f3 <= this.g / this.f) {
          break label479;
        }
        this.h = (this.g / f2);
        f1 = this.h;
        urk.b("EditPicActivityCropView", "calculate picscale : " + this.h + " final : " + f1);
        this.k = (this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.h);
        this.l = (this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.h);
        this.jdField_a_of_type_AndroidGraphicsRect = a();
        this.jdField_b_of_type_AndroidGraphicsRect = a();
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f1, f1, this.i, this.j);
        invalidate();
      }
    } while (this.jdField_a_of_type_Vaj == null);
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_b_of_type_Int != 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Vaj.a(bool);
      return;
      this.jdField_d_of_type_Boolean = true;
      break;
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(90.0F, this.i, this.j);
      this.jdField_d_of_type_Boolean = false;
      break;
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(180.0F, this.i, this.j);
      this.jdField_d_of_type_Boolean = true;
      break;
      this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(270.0F, this.i, this.j);
      this.jdField_d_of_type_Boolean = false;
      break;
      label468:
      f3 = f2;
      break label194;
      label474:
      f2 = f1;
      break label201;
      label479:
      this.h = (this.f / f3);
      break label228;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_d_of_type_Float = paramInt1;
    this.jdField_e_of_type_Float = paramInt2;
    this.f = (paramInt1 - this.jdField_d_of_type_Int * 2);
    this.g = (paramInt2 - this.jdField_d_of_type_Int * 2);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setOnTouchListener(this);
    this.jdField_d_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131167884);
    this.jdField_e_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131167885);
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_Befq = new befq(Looper.getMainLooper(), this);
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Befq.removeMessages(1001);
    Object localObject = new int[2];
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (this.jdField_e_of_type_AndroidGraphicsRect != null) {
      this.jdField_d_of_type_AndroidGraphicsRect.set(this.jdField_e_of_type_AndroidGraphicsRect);
    }
    if (this.jdField_b_of_type_AndroidGraphicsBitmap == null) {}
    do
    {
      return false;
      localObject = a((int[])localObject);
      if ((localObject != null) && (((Bitmap)localObject).getWidth() >= 64) && (((Bitmap)localObject).getHeight() >= 64)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditPicActivityCropView", 2, "too small " + localObject);
      }
      if (this.jdField_a_of_type_Vaj != null) {
        this.jdField_a_of_type_Vaj.a(7);
      }
    } while (this.jdField_e_of_type_AndroidGraphicsRect == null);
    this.jdField_e_of_type_AndroidGraphicsRect.set(this.jdField_d_of_type_AndroidGraphicsRect);
    return false;
    if (localObject != null) {
      setBitmap((Bitmap)localObject);
    }
    if (this.jdField_a_of_type_Vaj != null) {
      this.jdField_a_of_type_Vaj.a(localBitmap);
    }
    return true;
  }
  
  public float[] a()
  {
    float[] arrayOfFloat = new float[4];
    if (this.jdField_c_of_type_Int == 90)
    {
      arrayOfFloat[3] = ((this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_AndroidGraphicsRect.left) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[0] = ((this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_b_of_type_AndroidGraphicsRect.top) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      arrayOfFloat[1] = ((this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[2] = ((this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      return arrayOfFloat;
    }
    if (this.jdField_c_of_type_Int == 270)
    {
      arrayOfFloat[1] = ((this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_AndroidGraphicsRect.left) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[2] = ((this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_b_of_type_AndroidGraphicsRect.top) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      arrayOfFloat[3] = ((this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[0] = ((this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      return arrayOfFloat;
    }
    if (this.jdField_c_of_type_Int == 180)
    {
      arrayOfFloat[2] = ((this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_AndroidGraphicsRect.left) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[3] = ((this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_b_of_type_AndroidGraphicsRect.top) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      arrayOfFloat[0] = ((this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right) / this.jdField_b_of_type_AndroidGraphicsRect.width());
      arrayOfFloat[1] = ((this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom) / this.jdField_b_of_type_AndroidGraphicsRect.height());
      return arrayOfFloat;
    }
    arrayOfFloat[0] = ((this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_b_of_type_AndroidGraphicsRect.left) / this.jdField_b_of_type_AndroidGraphicsRect.width());
    arrayOfFloat[1] = ((this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_b_of_type_AndroidGraphicsRect.top) / this.jdField_b_of_type_AndroidGraphicsRect.height());
    arrayOfFloat[2] = ((this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.right) / this.jdField_b_of_type_AndroidGraphicsRect.width());
    arrayOfFloat[3] = ((this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.bottom) / this.jdField_b_of_type_AndroidGraphicsRect.height());
    return arrayOfFloat;
  }
  
  public Bitmap b()
  {
    return this.jdField_b_of_type_AndroidGraphicsBitmap;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1001)
    {
      urq.b("0X80075D1");
      a();
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
      a(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2);
    b();
    invalidate();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      do
      {
        return false;
      } while (this.jdField_a_of_type_AndroidGraphicsRect == null);
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
      this.jdField_c_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Int = a(paramMotionEvent);
      urk.b("EditPicActivityCropView", "hitResizeCorner " + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Boolean = a(paramMotionEvent);
      this.jdField_a_of_type_Float = 0.0F;
      this.jdField_e_of_type_Boolean = false;
      return true;
    case 5: 
    case 261: 
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Float = 0.0F;
      this.jdField_c_of_type_Float = 0.0F;
      return true;
    case 6: 
    case 262: 
      this.jdField_a_of_type_Boolean = false;
      return true;
    case 1: 
      this.jdField_e_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(1001, 1000L);
      }
      return true;
    }
    if ((paramMotionEvent.getPointerCount() == 2) && (this.jdField_a_of_type_Int == 0))
    {
      f1 = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      f2 = paramMotionEvent.getY(0) - paramMotionEvent.getY(1);
      f1 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      f2 = (paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F;
      f3 = (paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F;
      if (this.jdField_a_of_type_Float == 0.0F) {
        this.jdField_a_of_type_Float = f1;
      }
    }
    while (paramMotionEvent.getPointerCount() != 1) {
      for (;;)
      {
        return true;
        if (this.jdField_b_of_type_Float == 0.0F)
        {
          this.jdField_b_of_type_Float = f2;
          this.jdField_c_of_type_Float = f3;
        }
        else if ((f1 - this.jdField_a_of_type_Float >= 10.0F) || (f1 - this.jdField_a_of_type_Float <= -10.0F))
        {
          f2 = f1 / this.jdField_a_of_type_Float;
          this.jdField_a_of_type_Float = f1;
          f1 = this.jdField_a_of_type_AndroidGraphicsRect.width() - this.jdField_a_of_type_AndroidGraphicsRect.width() * f2;
          f2 = this.jdField_a_of_type_AndroidGraphicsRect.height() - f2 * this.jdField_a_of_type_AndroidGraphicsRect.height();
          a(1, f1 / 2.0F, f2 / 2.0F);
          a(4, -f1 / 2.0F, -f2 / 2.0F);
          invalidate();
        }
      }
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = f1 - this.jdField_b_of_type_Float;
    float f4 = f2 - this.jdField_c_of_type_Float;
    if (this.jdField_a_of_type_Int != 0) {
      a(this.jdField_a_of_type_Int, f3, f4);
    }
    for (;;)
    {
      this.jdField_b_of_type_Float = f1;
      this.jdField_c_of_type_Float = f2;
      invalidate();
      break;
      if (this.jdField_a_of_type_Boolean) {
        a(f3, f4);
      }
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    if (this.jdField_d_of_type_Float == 0.0F) {
      return;
    }
    b();
    invalidate();
    this.jdField_a_of_type_Befq.removeMessages(1001);
  }
  
  public void setCropListener(vaj paramvaj)
  {
    this.jdField_a_of_type_Vaj = paramvaj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.crop.CropView
 * JD-Core Version:    0.7.0.1
 */