package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.YuvImage;
import android.text.TextUtils;
import android.widget.ImageView.ScaleType;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLPaint;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.opengl.texture.ResourceTexture;
import com.tencent.av.opengl.texture.StringTexture;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.texture.YuvFboTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.redpacket.ui.GLRedPacketGame;
import com.tencent.av.switchface.SwitchFaceTexture;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import jut;
import juu;

public class GLVideoView
  extends GLView
{
  protected float a;
  public int a;
  public long a;
  protected Context a;
  protected Matrix a;
  protected RectF a;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private GLPaint jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint;
  protected BasicTexture a;
  protected BitmapTexture a;
  protected StringTexture a;
  protected YUVTexture a;
  private GLRedPacketGame jdField_a_of_type_ComTencentAvRedpacketUiGLRedPacketGame;
  private SwitchFaceTexture jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture;
  public Runnable a;
  protected String a;
  protected boolean a;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  public int b;
  long jdField_b_of_type_Long = 0L;
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix;
  protected RectF b;
  protected BasicTexture b;
  protected String b;
  protected boolean b;
  public int c;
  protected RectF c;
  private final String c;
  protected boolean c;
  int d;
  protected boolean d;
  int e;
  protected boolean e;
  private int f;
  public boolean f;
  protected boolean g = true;
  boolean h = false;
  private float jdField_i_of_type_Float = 1.0F;
  boolean jdField_i_of_type_Boolean = true;
  private float j;
  protected boolean j;
  boolean k = false;
  private boolean l = true;
  private boolean m;
  
  public GLVideoView(Context paramContext, VideoAppInterface paramVideoAppInterface, String paramString)
  {
    super(paramContext);
    this.jdField_j_of_type_Float = 5.0F;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_Float = 20.0F;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = 2147483647;
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaLangRunnable = new juu(this);
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = ("GLVideoView_" + paramString);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint = new GLPaint();
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture = new YuvFboTexture(this.jdField_a_of_type_AndroidContentContext, this, paramString);
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(new jut(this, paramVideoAppInterface));
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.CENTER_INSIDE;
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559783);
  }
  
  private void a(GLCanvas paramGLCanvas, int paramInt)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (paramInt % 2 == 0) {
        paramGLCanvas.b(-1.0F, 1.0F, 1.0F);
      }
    }
    else {
      return;
    }
    paramGLCanvas.b(1.0F, -1.0F, 1.0F);
  }
  
  private boolean a(int paramInt)
  {
    if (this.h) {
      if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER_INSIDE) {
        if (!this.jdField_a_of_type_Boolean) {}
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if ((this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.j() % 2 == 0) && (super.g() > super.h())) {
            return false;
          }
        } while ((this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.j() % 2 == 0) || (super.g() >= super.h()));
        return false;
      } while (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != ImageView.ScaleType.CENTER_CROP);
      return false;
      if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != ImageView.ScaleType.CENTER_INSIDE) {
        break;
      }
    } while ((this.jdField_a_of_type_Boolean) || (paramInt % 2 == 0));
    while (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != ImageView.ScaleType.CENTER_CROP) {
      return false;
    }
    return false;
  }
  
  public static int[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
    {
      QLog.d("GLVideoView", 1, "I420toARGB is null nWidth=" + paramInt1 + ", nHeight=" + paramInt2);
      return null;
    }
    int i4;
    int i3;
    if (paramInt2 < 0)
    {
      i4 = -paramInt2;
      i3 = 1;
    }
    for (;;)
    {
      int i6 = 0;
      int i5 = paramInt1;
      if (paramInt1 < 0)
      {
        i5 = -paramInt1;
        i6 = 1;
      }
      int i8 = i5 * i4;
      label345:
      label354:
      label365:
      label368:
      label380:
      for (;;)
      {
        int[] arrayOfInt;
        int i1;
        int n;
        int i2;
        try
        {
          arrayOfInt = new int[i8];
          paramInt1 = 0;
          if (paramInt1 >= i8) {
            break label365;
          }
          paramInt2 = paramInt1 / i5 / 2 * (i5 / 2) + paramInt1 % i5 / 2;
          i1 = paramArrayOfByte[paramInt1] & 0xFF;
          n = paramArrayOfByte[(i8 + paramInt2)] & 0xFF;
          i2 = paramArrayOfByte[(paramInt2 + (i8 / 4 + i8))] & 0xFF;
          paramInt2 = (int)(i1 + 1.8556D * (n - 128));
          n = (int)(i1 - (0.4681D * (i2 - 128) + 0.1872D * (n - 128)));
          i1 = (int)(i1 + 1.5748D * (i2 - 128));
          if (paramInt2 > 255)
          {
            paramInt2 = 255;
            if (n <= 255) {
              break label345;
            }
            n = 255;
            if (i1 <= 255) {
              break label354;
            }
            i1 = 255;
            if (i3 == 0) {
              break label368;
            }
            i2 = (i4 - 1 - paramInt1 / i5) * i5 + paramInt1 % i5;
            int i7 = i2;
            if (i6 != 0) {
              i7 = i2 / i5 * i5 + (i5 - 1) - i2 % i5;
            }
            arrayOfInt[i7] = (i1 << 16 & 0xFF0000 | 0xFF000000 | n << 8 & 0xFF00 | paramInt2 & 0xFF);
            paramInt1 += 1;
            continue;
          }
          if (paramInt2 >= 0) {
            break label380;
          }
        }
        catch (OutOfMemoryError paramArrayOfByte)
        {
          return null;
        }
        paramInt2 = 0;
        continue;
        if (n < 0)
        {
          n = 0;
          continue;
          if (i1 < 0)
          {
            i1 = 0;
            continue;
            return arrayOfInt;
            i2 = paramInt1;
          }
          else {}
        }
        else {}
      }
      i3 = 0;
      i4 = paramInt2;
    }
  }
  
  public float a()
  {
    return this.jdField_i_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap2 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject4 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b();
    if (localObject4 == null)
    {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "getFrameBitmap  get last frame failed");
      return null;
    }
    int n = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.h();
    int i1 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.i();
    int i2 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.k();
    Bitmap localBitmap1;
    YuvImage localYuvImage;
    if (i2 == 0)
    {
      localObject1 = a((byte[])localObject4, n, i1);
      if (localObject1 == null)
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "getFrameBitmap  I420toARGB failed, type=" + i2);
        return null;
      }
      try
      {
        localObject1 = Bitmap.createBitmap((int[])localObject1, n, i1, Bitmap.Config.ARGB_8888);
        if (localObject1 != null) {
          break label399;
        }
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "getFrameBitmap createBitmap failed");
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "getFrameBitmap OOM exception e.stack " + localOutOfMemoryError1.getStackTrace());
          Object localObject2 = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "getFrameBitmap exception e.stack " + localException.getStackTrace());
          localBitmap1 = null;
        }
      }
    }
    else
    {
      localYuvImage = new YuvImage((byte[])localObject4, 17, n, i1, null);
      if (localYuvImage != null)
      {
        localBitmap1 = localBitmap2;
        localObject4 = localObject5;
      }
    }
    label399:
    for (;;)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap1 = localBitmap2;
        localObject4 = localObject5;
        localYuvImage.compressToJpeg(new Rect(0, 0, n, i1), 100, localByteArrayOutputStream);
        localBitmap1 = localBitmap2;
        localObject4 = localObject5;
        localBitmap2 = BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size());
        localBitmap1 = localBitmap2;
        localObject4 = localBitmap2;
        localByteArrayOutputStream.close();
        localBitmap1 = localBitmap2;
      }
      catch (IOException localIOException)
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "getFrameBitmap YuvImage close failed");
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 1, "getFrameBitmap YuvImage close failed OOM");
        Object localObject3 = localIOException;
        continue;
      }
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "getFrameBitmap nWidth=" + n + ", nHeight=" + i1);
      return localBitmap1;
    }
  }
  
  /* Error */
  Bitmap a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_1
    //   8: ifnull +69 -> 77
    //   11: aload_1
    //   12: aload_1
    //   13: invokevirtual 309	android/graphics/Bitmap:getWidth	()I
    //   16: iconst_4
    //   17: idiv
    //   18: aload_1
    //   19: invokevirtual 312	android/graphics/Bitmap:getHeight	()I
    //   22: iconst_4
    //   23: idiv
    //   24: iconst_1
    //   25: invokestatic 316	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   28: astore_2
    //   29: new 318	android/graphics/Canvas
    //   32: dup
    //   33: invokespecial 319	android/graphics/Canvas:<init>	()V
    //   36: astore_3
    //   37: aload_3
    //   38: aload_2
    //   39: invokevirtual 323	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   42: aload_3
    //   43: ldc_w 325
    //   46: invokestatic 331	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   49: getstatic 337	android/graphics/PorterDuff$Mode:LIGHTEN	Landroid/graphics/PorterDuff$Mode;
    //   52: invokevirtual 341	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   55: aload_2
    //   56: bipush 20
    //   58: invokestatic 346	com/tencent/mobileqq/utils/StackBlur:a	(Landroid/graphics/Bitmap;I)V
    //   61: aload_2
    //   62: aload_1
    //   63: invokevirtual 309	android/graphics/Bitmap:getWidth	()I
    //   66: aload_1
    //   67: invokevirtual 312	android/graphics/Bitmap:getHeight	()I
    //   70: iconst_1
    //   71: invokestatic 316	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   74: astore_1
    //   75: aload_1
    //   76: astore_2
    //   77: aload_2
    //   78: areturn
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 103	com/tencent/av/ui/GLVideoView:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   86: iconst_2
    //   87: new 88	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 348
    //   97: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_2
    //   101: invokevirtual 261	java/lang/OutOfMemoryError:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   104: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_1
    //   114: areturn
    //   115: astore_2
    //   116: aload 4
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 103	com/tencent/av/ui/GLVideoView:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   123: iconst_2
    //   124: new 88	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 350
    //   134: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_2
    //   138: invokevirtual 267	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   141: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 207	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_1
    //   151: areturn
    //   152: astore_3
    //   153: aload_2
    //   154: astore_1
    //   155: aload_3
    //   156: astore_2
    //   157: goto -38 -> 119
    //   160: astore_3
    //   161: aload_2
    //   162: astore_1
    //   163: aload_3
    //   164: astore_2
    //   165: goto -83 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	GLVideoView
    //   0	168	1	paramBitmap	Bitmap
    //   6	72	2	localBitmap	Bitmap
    //   79	22	2	localOutOfMemoryError1	OutOfMemoryError
    //   115	39	2	localException1	Exception
    //   156	9	2	localObject1	Object
    //   1	80	3	localCanvas	android.graphics.Canvas
    //   152	4	3	localException2	Exception
    //   160	4	3	localOutOfMemoryError2	OutOfMemoryError
    //   3	114	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   11	29	79	java/lang/OutOfMemoryError
    //   11	29	115	java/lang/Exception
    //   29	75	152	java/lang/Exception
    //   29	75	160	java/lang/OutOfMemoryError
  }
  
  public ImageView.ScaleType a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  }
  
  public YUVTexture a()
  {
    return this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture;
  }
  
  public String a()
  {
    return (String)a(0);
  }
  
  protected void a()
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    super.a();
  }
  
  public void a(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setTextSize textSize: " + paramFloat);
    }
    if (this.jdField_a_of_type_Float != paramFloat)
    {
      this.jdField_a_of_type_Float = paramFloat;
      this.jdField_f_of_type_Boolean = true;
      super.v();
    }
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2)
  {
    int n = super.g();
    int i1 = super.h();
    if (this.jdField_f_of_type_Int == 1) {
      paramInt1 = n - paramInt1;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
      this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(paramFloat, paramFloat, paramInt2, paramInt1);
      this.jdField_b_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
      float f1 = this.jdField_a_of_type_ArrayOfFloat[0];
      float f2 = this.jdField_i_of_type_Float * 1.0F / 1.111111F;
      float f3 = this.jdField_j_of_type_Float;
      if ((f1 <= f2) || (f1 >= f3 * 1.111111F))
      {
        return;
        if (this.jdField_f_of_type_Int == 2)
        {
          paramInt2 = i1 - paramInt2;
          n -= paramInt1;
          paramInt1 = paramInt2;
          paramInt2 = n;
          continue;
        }
        if (this.jdField_f_of_type_Int == 3) {
          paramInt2 = i1 - paramInt2;
        }
      }
      else
      {
        this.jdField_a_of_type_ArrayOfFloat[0] = f1;
        this.jdField_a_of_type_ArrayOfFloat[4] = f1;
        this.jdField_a_of_type_AndroidGraphicsMatrix.setValues(this.jdField_a_of_type_ArrayOfFloat);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setScale scale: " + paramFloat + ", x: " + paramInt2 + ", y: " + paramInt1 + ", newScale: " + f1);
        }
        super.v();
        return;
      }
      n = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = n;
    }
  }
  
  public void a(int paramInt)
  {
    switch (paramInt % 360)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Int != paramInt)
      {
        this.jdField_f_of_type_Int = paramInt;
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        if (f() == 0) {
          super.v();
        }
      }
      return;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 <= 0) || (paramInt3 <= 0))
    {
      if (this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture.a();
        this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture = null;
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture == null)
    {
      this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture = new SwitchFaceTexture();
      int n = g();
      int i1 = h();
      this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture.a(n);
      this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture.b(i1);
    }
    this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setTranslation x: " + paramInt1 + ", y: " + paramInt2 + ", isEnd: " + paramBoolean);
    }
    if (this.jdField_f_of_type_Int == 1) {
      paramInt1 = -paramInt1;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
      float f2 = this.jdField_a_of_type_ArrayOfFloat[2] + paramInt2;
      float f3 = this.jdField_a_of_type_ArrayOfFloat[5] + paramInt1;
      this.jdField_a_of_type_ArrayOfFloat[2] = f2;
      this.jdField_a_of_type_ArrayOfFloat[5] = f3;
      this.jdField_a_of_type_AndroidGraphicsMatrix.setValues(this.jdField_a_of_type_ArrayOfFloat);
      RectF localRectF;
      float f1;
      if (paramBoolean)
      {
        localRectF = new RectF();
        this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
        if ((localRectF.left >= this.jdField_a_of_type_AndroidGraphicsRectF.left) || (localRectF.right >= this.jdField_a_of_type_AndroidGraphicsRectF.right)) {
          break label374;
        }
        if (localRectF.width() <= this.jdField_a_of_type_AndroidGraphicsRectF.width()) {
          break label353;
        }
        f1 = f2 + (this.jdField_a_of_type_AndroidGraphicsRectF.right - localRectF.right);
        label218:
        if ((localRectF.top >= this.jdField_a_of_type_AndroidGraphicsRectF.top) || (localRectF.bottom >= this.jdField_a_of_type_AndroidGraphicsRectF.bottom)) {
          break label546;
        }
        if (localRectF.height() <= this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
          break label525;
        }
        f2 = f3 + (this.jdField_a_of_type_AndroidGraphicsRectF.bottom - localRectF.bottom);
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfFloat[2] = f1;
        this.jdField_a_of_type_ArrayOfFloat[5] = f2;
        this.jdField_a_of_type_AndroidGraphicsMatrix.setValues(this.jdField_a_of_type_ArrayOfFloat);
        super.v();
        return;
        if (this.jdField_f_of_type_Int == 2)
        {
          paramInt1 = -paramInt1;
          n = -paramInt2;
          paramInt2 = paramInt1;
          paramInt1 = n;
          break;
        }
        if (this.jdField_f_of_type_Int != 3) {
          break label697;
        }
        paramInt2 = -paramInt2;
        break;
        label353:
        f1 = f2 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - localRectF.centerX());
        break label218;
        label374:
        if ((localRectF.left > this.jdField_a_of_type_AndroidGraphicsRectF.left) && (localRectF.right > this.jdField_a_of_type_AndroidGraphicsRectF.right))
        {
          if (localRectF.width() > this.jdField_a_of_type_AndroidGraphicsRectF.width())
          {
            f1 = f2 + (this.jdField_a_of_type_AndroidGraphicsRectF.left - localRectF.left);
            break label218;
          }
          f1 = f2 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - localRectF.centerX());
          break label218;
        }
        f1 = f2;
        if (localRectF.left <= this.jdField_a_of_type_AndroidGraphicsRectF.left) {
          break label218;
        }
        f1 = f2;
        if (localRectF.right >= this.jdField_a_of_type_AndroidGraphicsRectF.right) {
          break label218;
        }
        f1 = f2 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - localRectF.centerX());
        break label218;
        label525:
        f2 = f3 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - localRectF.centerY());
        continue;
        label546:
        if ((localRectF.top > this.jdField_a_of_type_AndroidGraphicsRectF.top) && (localRectF.bottom > this.jdField_a_of_type_AndroidGraphicsRectF.bottom))
        {
          if (localRectF.height() > this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
            f2 = f3 + (this.jdField_a_of_type_AndroidGraphicsRectF.top - localRectF.top);
          } else {
            f2 = f3 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - localRectF.centerY());
          }
        }
        else
        {
          f2 = f3;
          if (localRectF.top > this.jdField_a_of_type_AndroidGraphicsRectF.top)
          {
            f2 = f3;
            if (localRectF.bottom < this.jdField_a_of_type_AndroidGraphicsRectF.bottom) {
              f2 = f3 + (this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - localRectF.centerY());
            }
          }
        }
      }
      label697:
      int n = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = n;
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = null;
    }
    this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = new BitmapTexture(paramBitmap);
  }
  
  public void a(ImageView.ScaleType paramScaleType)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setScaleType scaleType: " + paramScaleType);
    }
    ImageView.ScaleType localScaleType = paramScaleType;
    if (paramScaleType == null) {
      localScaleType = ImageView.ScaleType.CENTER_INSIDE;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != localScaleType)
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = localScaleType;
      super.v();
    }
  }
  
  protected void a(GLCanvas paramGLCanvas)
  {
    this.l = true;
    if (!this.jdField_d_of_type_Boolean) {
      this.jdField_d_of_type_Boolean = false;
    }
    int n = super.g();
    int i1 = super.h();
    Rect localRect = super.a();
    int i2 = n - localRect.left - localRect.right;
    int i3 = i1 - localRect.top - localRect.bottom;
    paramGLCanvas.a(-n / 2, -i1 / 2);
    if (this.l)
    {
      this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(-9013642);
      if (localRect.left > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.left);
        paramGLCanvas.a(localRect.left / 2, 0.0F, localRect.left / 2, i1, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
      if (localRect.top > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.top);
        paramGLCanvas.a(0.0F, localRect.top / 2, n, localRect.top / 2, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
      if (localRect.right > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.right);
        paramGLCanvas.a(n - localRect.right / 2, 0.0F, n - localRect.right / 2, i1, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
      if (localRect.bottom > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.bottom);
        paramGLCanvas.a(0.0F, i1 - localRect.bottom / 2, n, i1 - localRect.bottom / 2, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
    }
    paramGLCanvas.a(n / 2, i1 / 2);
    if (this.l) {
      if (((!b()) || (!this.jdField_d_of_type_Boolean)) && (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null)) {
        this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, i2, i3);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_j_of_type_Boolean);
      paramGLCanvas.a(0, 0, i2, i3, this.v);
      return;
      if (((!b()) || (!this.jdField_d_of_type_Boolean)) && (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null))
      {
        this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, n, i1);
        return;
      }
    } while (this.jdField_j_of_type_Boolean);
    paramGLCanvas.a(0.0F, 0.0F, n, i1, this.v);
  }
  
  public void a(Boolean paramBoolean)
  {
    this.l = paramBoolean.booleanValue();
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    a(0, paramString);
    a(1, Integer.valueOf(paramInt));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = g();
    paramInt2 = h();
    try
    {
      if (this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture.a(paramInt1);
        this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture.b(paramInt2);
      }
      if (this.jdField_a_of_type_ComTencentAvRedpacketUiGLRedPacketGame != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketUiGLRedPacketGame.a(paramInt1, paramInt2);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_c_of_type_JavaLangString, 2, "onLayout e = " + localException);
        }
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null) {
        return false;
      }
      Bitmap localBitmap = a();
      bool1 = bool2;
      if (localBitmap != null)
      {
        localBitmap = a(localBitmap);
        if (localBitmap == null)
        {
          QLog.d(this.jdField_c_of_type_JavaLangString, 2, "doStartRenderFouceGround BlurBitmap failed");
          return false;
        }
      }
    }
    catch (Exception localException)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "doStartRenderFouceGround exception e.stack " + localException.getStackTrace());
        return false;
        a(localException);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public float b()
  {
    return this.jdField_j_of_type_Float;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return "TAG[" + this.jdField_c_of_type_JavaLangString + "], uin[" + a() + "], VideoSrcType[" + d() + "], DstRect[" + this.jdField_c_of_type_AndroidGraphicsRectF.width() + ", " + this.jdField_c_of_type_AndroidGraphicsRectF.height() + "], SrcRectF[" + this.jdField_b_of_type_AndroidGraphicsRectF.width() + ", " + this.jdField_b_of_type_AndroidGraphicsRectF.height() + "], " + this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = null;
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setMaxLength maxLength: " + paramInt);
    }
    if ((paramInt > 0) && (this.jdField_c_of_type_Int != paramInt))
    {
      this.jdField_c_of_type_Int = paramInt;
      this.jdField_f_of_type_Boolean = true;
      super.v();
    }
  }
  
  public void b(GLCanvas paramGLCanvas)
  {
    if ((this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) && (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.updateCurFrame()) && (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.canRender()) && (this.jdField_d_of_type_Boolean))
    {
      g(false);
      if ((!this.jdField_a_of_type_Boolean) || (!this.jdField_j_of_type_Boolean)) {
        break label84;
      }
      e(paramGLCanvas);
    }
    for (;;)
    {
      f(paramGLCanvas);
      g(paramGLCanvas);
      if (this.jdField_a_of_type_ComTencentAvRedpacketUiGLRedPacketGame != null) {
        this.jdField_a_of_type_ComTencentAvRedpacketUiGLRedPacketGame.a(paramGLCanvas);
      }
      return;
      label84:
      d(paramGLCanvas);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setText text: " + paramString);
    }
    if (((!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.jdField_a_of_type_JavaLangString))) || (TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_f_of_type_Boolean = true;
      super.v();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) {
      return this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.canRender();
    }
    return false;
  }
  
  public float c()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat[0];
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setTextColor textColor: 0x" + Integer.toHexString(paramInt).toUpperCase());
    }
    if (this.jdField_b_of_type_Int != paramInt)
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_f_of_type_Boolean = true;
      super.v();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setIsPC mIsPC: " + this.jdField_a_of_type_Boolean + ", isPC: " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    super.v();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public float d()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int d()
  {
    Integer localInteger = (Integer)a(1);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  protected void d(GLCanvas paramGLCanvas)
  {
    Rect localRect = super.a();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    int i7 = super.g();
    int i8 = super.h();
    int i2 = i7 - localRect.left - localRect.right;
    int i1 = i8 - localRect.top - localRect.bottom;
    int i6 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.j();
    int n;
    int i4;
    float f2;
    float f5;
    float f6;
    int i3;
    float f1;
    float f4;
    if ((this.jdField_j_of_type_Boolean) && (!h()))
    {
      n = 0;
      i4 = (i6 + n + 4) % 4;
      f2 = localRect.left;
      f3 = localRect.top;
      f5 = i2;
      f6 = i1;
      if (i4 % 2 == 0) {
        break label1286;
      }
      i3 = (int)i2;
      i2 = i1;
      i1 = i3;
      f1 = f3;
      f4 = f6;
    }
    for (float f3 = f5;; f3 = f6)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(f1, f2, i2 + f1, i1 + f2);
      f6 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
      float f7 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
      float f8 = f6 / f7;
      f5 = f4 / f3;
      boolean bool;
      if ((!this.jdField_j_of_type_Boolean) && (a(i4)))
      {
        bool = true;
        label223:
        if (!bool) {
          break label1283;
        }
        if (i4 % 2 != 0) {
          break label876;
        }
        f5 = f4 / f8;
        if (f5 <= f3) {
          break label859;
        }
        f5 = f3 * f8;
        f1 += (f4 - f5) / 2.0F;
        f4 = f5;
        label271:
        f5 = f4 / f3;
      }
      label1283:
      for (;;)
      {
        this.jdField_b_of_type_AndroidGraphicsRectF.set(f1, f2, f4 + f1, f3 + f2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
        label347:
        int i5;
        if (f8 > f5)
        {
          f1 = f7 * f5;
          f2 = (f6 - f1) / 2.0F;
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)f2, 0, (int)f1, (int)f7);
          if (!this.jdField_i_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(0, 0, (int)f6, (int)f7);
          }
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)f6, (int)f7);
          paramGLCanvas.a(2);
          a(paramGLCanvas, n);
          paramGLCanvas.a(i4 * 90, 0.0F, 0.0F, 1.0F);
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)this.jdField_c_of_type_AndroidGraphicsRectF.width());
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b((int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
          i4 = (int)(this.jdField_c_of_type_AndroidGraphicsRectF.left - (this.jdField_b_of_type_AndroidGraphicsRectF.width() - this.jdField_c_of_type_AndroidGraphicsRectF.width()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.left);
          i5 = (int)(this.jdField_c_of_type_AndroidGraphicsRectF.top - (this.jdField_b_of_type_AndroidGraphicsRectF.height() - this.jdField_c_of_type_AndroidGraphicsRectF.height()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.top);
          if (this.h) {
            break label1096;
          }
          if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture == null) {
            break label963;
          }
          this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a(paramGLCanvas, i4, i5, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
          label555:
          AVLog.c(this.jdField_c_of_type_JavaLangString, "rendView:|" + a() + "|" + d() + "|" + this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture + "|" + i4 + "|" + i5 + "|" + (int)this.jdField_c_of_type_AndroidGraphicsRectF.width() + "|" + (int)this.jdField_c_of_type_AndroidGraphicsRectF.height() + "|" + this.jdField_b_of_type_AndroidGraphicsRectF.width() + "|" + this.jdField_b_of_type_AndroidGraphicsRectF.height() + "|" + f6 + "|" + f7 + "|" + this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.c() + "|" + this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.d() + "|" + f8 + "|" + f5 + "|" + bool + "|" + n + "|" + i6 + "|" + this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.j() + "|" + this.jdField_f_of_type_Int);
        }
        for (;;)
        {
          paramGLCanvas.c();
          return;
          n = this.jdField_f_of_type_Int;
          break;
          bool = false;
          break label223;
          label859:
          f2 += (f3 - f5) / 2.0F;
          f3 = f5;
          break label271;
          label876:
          f5 = f3 * f8;
          if (f5 > f4)
          {
            f5 = f4 / f8;
            f2 += (f3 - f5) / 2.0F;
            f3 = f5;
            break label271;
          }
          f1 += (f4 - f5) / 2.0F;
          f4 = f5;
          break label271;
          f1 = f6 / f5;
          f2 = (f7 - f1) / 2.0F;
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(0, (int)f2, (int)f6, (int)f1);
          break label347;
          label963:
          if ((this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture != null) && (this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture.g()))
          {
            paramGLCanvas.a((4 - i6) * 90, 0.0F, 0.0F, 1.0F);
            i1 = (int)this.jdField_c_of_type_AndroidGraphicsRectF.width();
            i2 = (int)this.jdField_c_of_type_AndroidGraphicsRectF.height();
            if (i6 % 2 == 0) {}
            for (;;)
            {
              this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.e();
              this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture.a(paramGLCanvas, i4, i5, i1, i2);
              break;
              i3 = i1;
              i1 = i2;
              i2 = i3;
            }
          }
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, i4, i5, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
          break label555;
          label1096:
          if ((i7 < i8) && (bool))
          {
            f1 = this.jdField_c_of_type_AndroidGraphicsRectF.height();
            if (i6 == 3) {
              f1 = this.jdField_c_of_type_AndroidGraphicsRectF.width();
            }
            n = (int)((i8 - f1) / 2.0F);
            if (n > this.jdField_d_of_type_Int)
            {
              n -= this.jdField_d_of_type_Int;
              if (i6 != 0) {
                break label1209;
              }
              i1 = -n;
              i2 = i4;
            }
            for (;;)
            {
              this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, i2, i1, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
              break;
              n = 0;
              break label1158;
              if (i6 == 2)
              {
                i2 = i4;
                i1 = n;
              }
              else
              {
                i2 = i4;
                i1 = i5;
                if (i6 == 3)
                {
                  i2 = -n;
                  i1 = i5;
                }
              }
            }
          }
          label1158:
          label1209:
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, i4, i5, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
        }
      }
      label1286:
      f4 = f5;
      f1 = f2;
      f2 = f3;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setMirror mMirror: " + this.jdField_b_of_type_Boolean + ", mirror: " + paramBoolean);
    }
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      super.v();
    }
  }
  
  public boolean d()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  protected void e(GLCanvas paramGLCanvas)
  {
    int n = 0;
    int i1 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
    int i2 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
    Rect localRect = super.a();
    int i3 = super.g();
    int i4 = super.h();
    int i5 = ScreenLayoutDoubleScreen.a(i2) / 2;
    int i6 = (i1 - i5) / 2;
    this.jdField_b_of_type_AndroidGraphicsRectF.set(i6, 0, i5 + i6, 0 + i2);
    this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, localRect.top, i3 - localRect.right, i4 - localRect.bottom);
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)this.jdField_b_of_type_AndroidGraphicsRectF.left, (int)this.jdField_b_of_type_AndroidGraphicsRectF.top, (int)this.jdField_b_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_b_of_type_AndroidGraphicsRectF.height());
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(i1, i2);
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)this.jdField_c_of_type_AndroidGraphicsRectF.width());
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b((int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
    paramGLCanvas.a(2);
    if (this.jdField_j_of_type_Boolean)
    {
      a(paramGLCanvas, n);
      if ((this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture == null) || (!this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture.g())) {
        break label398;
      }
      this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture.a(paramGLCanvas, (int)this.jdField_c_of_type_AndroidGraphicsRectF.left, (int)this.jdField_c_of_type_AndroidGraphicsRectF.top, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
    }
    for (;;)
    {
      paramGLCanvas.c();
      AVLog.c(this.jdField_c_of_type_JavaLangString, "renderDoubleScreenOfPC:|" + a() + "|" + d() + "|" + i1 + "|" + i2 + "|" + i3 + "|" + i4 + "|" + this.jdField_b_of_type_AndroidGraphicsRectF.toString() + "|" + this.jdField_c_of_type_AndroidGraphicsRectF.toString());
      return;
      n = this.jdField_f_of_type_Int;
      break;
      label398:
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, (int)this.jdField_c_of_type_AndroidGraphicsRectF.left, (int)this.jdField_c_of_type_AndroidGraphicsRectF.top, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setTextInBottom inBottom: " + paramBoolean);
    }
    if (this.jdField_e_of_type_Boolean != paramBoolean)
    {
      this.jdField_e_of_type_Boolean = paramBoolean;
      super.v();
    }
  }
  
  public boolean e()
  {
    return this.m;
  }
  
  protected void f(GLCanvas paramGLCanvas)
  {
    int n;
    int i1;
    int i3;
    int i2;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture != null))
    {
      this.jdField_a_of_type_Int %= 360;
      n = super.g();
      i1 = super.h();
      i3 = this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.c();
      i2 = this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.d();
      if (i3 <= n) {
        break label134;
      }
    }
    for (;;)
    {
      if (i2 > i1) {}
      for (;;)
      {
        paramGLCanvas.a(2);
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, n, i1);
        paramGLCanvas.c();
        long l1 = System.currentTimeMillis();
        if (l1 - this.jdField_a_of_type_Long >= 80L)
        {
          this.jdField_a_of_type_Long = l1;
          this.jdField_a_of_type_Int += 8;
        }
        return;
        i1 = i2;
      }
      label134:
      n = i3;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "showText showText: " + paramBoolean + ", mShowText: " + this.m);
    }
    if (this.m != paramBoolean)
    {
      this.m = paramBoolean;
      super.v();
    }
  }
  
  public boolean f()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void finalize()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture != null)
      {
        this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture.a();
        this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture = null;
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a();
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture = null;
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.a();
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture = null;
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a();
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture = null;
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a();
        this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = null;
      }
      if (this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture.a();
        this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceTexture = null;
      }
      if (this.jdField_a_of_type_ComTencentAvRedpacketUiGLRedPacketGame != null)
      {
        this.jdField_a_of_type_ComTencentAvRedpacketUiGLRedPacketGame.b();
        this.jdField_a_of_type_ComTencentAvRedpacketUiGLRedPacketGame = null;
      }
      this.jdField_a_of_type_JavaLangRunnable = null;
      this.jdField_c_of_type_Boolean = false;
      this.m = false;
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  protected void g(GLCanvas paramGLCanvas)
  {
    int n;
    int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    if (this.m)
    {
      Rect localRect = super.a();
      if (this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture != null)
      {
        n = super.g();
        super.h();
        i1 = localRect.left;
        i2 = localRect.right;
        i3 = localRect.left;
        i3 = localRect.bottom;
        this.jdField_b_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, n - i1 - i2, 36);
      }
      if (this.jdField_f_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture == null) {
          this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture = new StringTexture();
        }
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a();
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a(this.jdField_a_of_type_Float);
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.e(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.f(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.g(super.g());
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.e();
        this.jdField_f_of_type_Boolean = false;
      }
      if ((this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        i2 = super.g();
        i3 = super.h();
        i4 = this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.c();
        i5 = this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.d();
        if (!this.jdField_e_of_type_Boolean) {
          break label290;
        }
        n = 8;
        i1 = i3 - i5 - 8;
      }
    }
    for (;;)
    {
      paramGLCanvas.a(2);
      paramGLCanvas.a((i4 - i2) / 2, (i5 - i3) / 2);
      this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a(paramGLCanvas, n, i1, i4, i5);
      paramGLCanvas.c();
      return;
      label290:
      if (this.k)
      {
        n = this.jdField_e_of_type_Int;
        i1 = this.jdField_e_of_type_Int;
      }
      else
      {
        n = 30;
        i1 = 70;
      }
    }
  }
  
  public void g(boolean paramBoolean)
  {
    GLRootView localGLRootView;
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "enableLoading loading: " + paramBoolean + ", mLoading: " + this.jdField_c_of_type_Boolean);
      }
      this.jdField_c_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        break label108;
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture == null) {
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture = new ResourceTexture(this.jdField_a_of_type_AndroidContentContext, 2130840351);
      }
      localGLRootView = a();
      if (localGLRootView != null) {
        localGLRootView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    label108:
    do
    {
      return;
      localGLRootView = a();
    } while (localGLRootView == null);
    localGLRootView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public boolean g()
  {
    return this.k;
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.flush(paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean h()
  {
    return this.jdField_b_of_type_JavaLangString.equals(a());
  }
  
  public void i(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setNeedRenderVideo bRender: " + paramBoolean + ", mNeedRenderVideo: " + this.jdField_d_of_type_Boolean);
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    super.v();
  }
  
  public void j(boolean paramBoolean)
  {
    this.k = paramBoolean;
    if (paramBoolean) {
      this.jdField_e_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559947);
    }
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setCameraIsBindData, uin[" + a() + "], VideoSrcType[" + d() + "], isBind[" + paramBoolean + "]");
      }
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.GLVideoView
 * JD-Core Version:    0.7.0.1
 */