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
import android.util.Pair;
import android.widget.ImageView.ScaleType;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLPaint;
import com.tencent.av.opengl.texture.BasicTexture;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.opengl.texture.ColorTexture;
import com.tencent.av.opengl.texture.ResourceTexture;
import com.tencent.av.opengl.texture.StringTexture;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.texture.YuvFboTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class GLVideoView
  extends GLView
{
  int A = 70;
  int B = 0;
  private int C = 0;
  protected long a;
  protected Context a;
  protected Matrix a;
  protected RectF a;
  private ImageView.ScaleType jdField_a_of_type_AndroidWidgetImageView$ScaleType;
  private GLPaint jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint;
  protected BitmapTexture a;
  protected ColorTexture a;
  protected StringTexture a;
  protected YUVTexture a;
  GLVideoView.LogInfo jdField_a_of_type_ComTencentAvUiGLVideoView$LogInfo = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new GLVideoView.2(this);
  protected String a;
  private final float[] jdField_a_of_type_ArrayOfFloat = new float[9];
  protected long b;
  private Matrix b;
  protected RectF b;
  protected BitmapTexture b;
  protected String b;
  protected WeakReference<Context> b;
  protected boolean b;
  long jdField_c_of_type_Long = 0L;
  protected RectF c;
  protected BasicTexture c;
  protected BitmapTexture c;
  private final String jdField_c_of_type_JavaLangString;
  protected boolean c;
  protected BasicTexture d;
  protected boolean d;
  protected BasicTexture e;
  protected boolean e;
  protected boolean f = true;
  protected boolean g = true;
  protected float h;
  protected boolean h;
  private float i;
  protected boolean i;
  private float j;
  protected boolean j;
  protected int k;
  protected boolean k;
  protected int l;
  boolean l;
  protected int m;
  protected boolean m;
  protected int n;
  protected boolean n;
  protected int o;
  protected boolean o;
  protected int p;
  protected boolean p;
  protected int q;
  boolean q;
  protected int r;
  private boolean r;
  protected int s;
  private boolean s;
  protected int t = -1;
  protected int u = -1;
  protected int v;
  protected int w;
  int x = 0;
  int y = 0;
  int z = 0;
  
  public GLVideoView(Context paramContext, VideoAppInterface paramVideoAppInterface, String paramString)
  {
    this(paramContext, paramVideoAppInterface, paramString, 0L);
  }
  
  public GLVideoView(Context paramContext, VideoAppInterface paramVideoAppInterface, String paramString, long paramLong)
  {
    this(paramContext, paramVideoAppInterface, paramString, paramLong, true);
  }
  
  public GLVideoView(Context paramContext, VideoAppInterface paramVideoAppInterface, String paramString, long paramLong, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = -1;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = true;
    this.jdField_i_of_type_Float = 1.0F;
    this.jdField_j_of_type_Float = 5.0F;
    this.jdField_m_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_n_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_o_of_type_Int = 255;
    this.jdField_h_of_type_Float = 20.0F;
    this.jdField_p_of_type_Int = -1;
    this.jdField_q_of_type_Int = 2147483647;
    this.jdField_l_of_type_Boolean = true;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_m_of_type_Boolean = false;
    this.jdField_s_of_type_Int = -1;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_c_of_type_JavaLangString = ("GLVideoView_" + paramString);
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "create GLVideoView");
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint = new GLPaint();
    this.v = AIOUtils.a(6.0F, paramContext.getResources());
    this.w = AIOUtils.a(10.0F, paramContext.getResources());
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture = new YuvFboTexture(this.jdField_a_of_type_AndroidContentContext, this, paramString, paramLong);
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(new GLVideoView.1(this, paramVideoAppInterface));
    }
    this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ImageView.ScaleType.CENTER_INSIDE;
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  static int a(int paramInt)
  {
    switch (paramInt % 360)
    {
    default: 
      return 0;
    case 270: 
      return 1;
    case 180: 
      return 2;
    }
    return 3;
  }
  
  static Pair<Integer, Integer> a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 1) {
      paramInt1 = paramInt3 - paramInt1;
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(paramInt2), Integer.valueOf(paramInt1));
      if (paramInt5 == 2)
      {
        paramInt2 = paramInt4 - paramInt2;
        paramInt3 -= paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = paramInt3;
      }
      else if (paramInt5 == 3)
      {
        paramInt2 = paramInt4 - paramInt2;
      }
      else
      {
        paramInt3 = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = paramInt3;
      }
    }
  }
  
  public static int[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
    {
      QLog.d("GLVideoView", 1, "I420toARGB is null nWidth=" + paramInt1 + ", nHeight=" + paramInt2);
      return null;
    }
    int i5;
    int i4;
    if (paramInt2 < 0)
    {
      i5 = -paramInt2;
      i4 = 1;
    }
    for (;;)
    {
      int i7 = 0;
      int i6 = paramInt1;
      if (paramInt1 < 0)
      {
        i6 = -paramInt1;
        i7 = 1;
      }
      int i9 = i6 * i5;
      label386:
      for (;;)
      {
        int[] arrayOfInt;
        int i2;
        int i1;
        int i3;
        try
        {
          arrayOfInt = new int[i9];
          paramInt1 = 0;
          if (paramInt1 >= i9) {
            break label371;
          }
          paramInt2 = paramInt1 / i6 / 2 * (i6 / 2) + paramInt1 % i6 / 2;
          i2 = paramArrayOfByte[paramInt1] & 0xFF;
          i1 = paramArrayOfByte[(i9 + paramInt2)] & 0xFF;
          i3 = paramArrayOfByte[(paramInt2 + (i9 / 4 + i9))] & 0xFF;
          paramInt2 = (int)(i2 + 1.8556D * (i1 - 128));
          i1 = (int)(i2 - (0.4681D * (i3 - 128) + 0.1872D * (i1 - 128)));
          i2 = (int)(i2 + 1.5748D * (i3 - 128));
          if (paramInt2 > 255)
          {
            paramInt2 = 255;
            if (i1 <= 255) {
              break label351;
            }
            i1 = 255;
            if (i2 <= 255) {
              break label360;
            }
            i2 = 255;
            if (i4 == 0) {
              break label374;
            }
            i3 = (i5 - 1 - paramInt1 / i6) * i6 + paramInt1 % i6;
            int i8 = i3;
            if (i7 != 0) {
              i8 = i3 / i6 * i6 + (i6 - 1) - i3 % i6;
            }
            arrayOfInt[i8] = (i2 << 16 & 0xFF0000 | 0xFF000000 | i1 << 8 & 0xFF00 | paramInt2 & 0xFF);
            paramInt1 += 1;
            continue;
          }
          if (paramInt2 >= 0) {
            break label386;
          }
        }
        catch (OutOfMemoryError paramArrayOfByte)
        {
          return null;
        }
        paramInt2 = 0;
        continue;
        label351:
        if (i1 < 0)
        {
          i1 = 0;
          continue;
          label360:
          if (i2 < 0)
          {
            i2 = 0;
            continue;
            label371:
            return arrayOfInt;
            label374:
            i3 = paramInt1;
          }
          else {}
        }
        else {}
      }
      i4 = 0;
      i5 = paramInt2;
    }
  }
  
  private void l(int paramInt)
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {}
    for (;;)
    {
      return;
      StringBuilder localStringBuilder = null;
      Object localObject = localStringBuilder;
      if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
      {
        localObject = localStringBuilder;
        if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)) {
          localObject = (AVActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        }
      }
      if ((localObject != null) && (((AVActivity)localObject).a != null) && ((((AVActivity)localObject).a instanceof MultiVideoCtrlLayerUIBase)))
      {
        localObject = (MultiVideoCtrlLayerUIBase)((AVActivity)localObject).a;
        localStringBuilder = new StringBuilder();
        String str = c();
        try
        {
          localStringBuilder.append(paramInt).append(';');
          paramInt = NetworkUtil.b(BaseApplicationImpl.getApplication());
          if (paramInt == 1)
          {
            paramInt = 1;
            localStringBuilder.append(paramInt).append(';');
            if (((MultiVideoCtrlLayerUIBase)localObject).e != 1) {
              break label290;
            }
          }
          label290:
          for (long l1 = 0L;; l1 = 1L)
          {
            localStringBuilder.append(l1).append(';');
            localStringBuilder.append(((MultiVideoCtrlLayerUIBase)localObject).jdField_b_of_type_Long).append(';');
            localStringBuilder.append(((MultiVideoCtrlLayerUIBase)localObject).a.d());
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_c_of_type_JavaLangString, 2, "doBlackScreenDataReport questionUin:= " + str + ",rommInfo:=" + localStringBuilder.toString());
            }
            ThreadManager.getSubThreadHandler().post(new GLVideoView.3(this, str, localStringBuilder));
            return;
            if (paramInt == 0)
            {
              paramInt = 0;
              break;
            }
            paramInt = 2;
            break;
          }
          if (!QLog.isColorLevel()) {}
        }
        catch (Exception localException) {}
      }
    }
    QLog.d(this.jdField_c_of_type_JavaLangString, 2, "doBlackScreenDataReport Exception" + localException.getMessage());
  }
  
  public float a()
  {
    return this.jdField_i_of_type_Float;
  }
  
  public long a()
  {
    if ((c()) && (g() == 2)) {
      return System.currentTimeMillis();
    }
    return this.jdField_c_of_type_Long;
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap2 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject4 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a();
    if (localObject4 == null)
    {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "getFrameBitmap  get last frame failed");
      return null;
    }
    int i1 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.h();
    int i2 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.i();
    int i3 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.k();
    Bitmap localBitmap1;
    YuvImage localYuvImage;
    if (i3 == 0)
    {
      localObject1 = a((byte[])localObject4, i1, i2);
      if (localObject1 == null)
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "getFrameBitmap  I420toARGB failed, type=" + i3);
        return null;
      }
      try
      {
        localObject1 = Bitmap.createBitmap((int[])localObject1, i1, i2, Bitmap.Config.ARGB_8888);
        if (localObject1 != null) {
          break label403;
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
      localYuvImage = new YuvImage((byte[])localObject4, 17, i1, i2, null);
      if (localYuvImage != null)
      {
        localBitmap1 = localBitmap2;
        localObject4 = localObject5;
      }
    }
    label403:
    for (;;)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localBitmap1 = localBitmap2;
        localObject4 = localObject5;
        localYuvImage.compressToJpeg(new Rect(0, 0, i1, i2), 100, localByteArrayOutputStream);
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
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "getFrameBitmap nWidth=" + i1 + ", nHeight=" + i2);
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
    //   13: invokevirtual 477	android/graphics/Bitmap:getWidth	()I
    //   16: iconst_4
    //   17: idiv
    //   18: aload_1
    //   19: invokevirtual 480	android/graphics/Bitmap:getHeight	()I
    //   22: iconst_4
    //   23: idiv
    //   24: iconst_1
    //   25: invokestatic 484	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   28: astore_2
    //   29: new 486	android/graphics/Canvas
    //   32: dup
    //   33: invokespecial 487	android/graphics/Canvas:<init>	()V
    //   36: astore_3
    //   37: aload_3
    //   38: aload_2
    //   39: invokevirtual 491	android/graphics/Canvas:setBitmap	(Landroid/graphics/Bitmap;)V
    //   42: aload_3
    //   43: ldc_w 493
    //   46: invokestatic 499	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   49: getstatic 505	android/graphics/PorterDuff$Mode:LIGHTEN	Landroid/graphics/PorterDuff$Mode;
    //   52: invokevirtual 509	android/graphics/Canvas:drawColor	(ILandroid/graphics/PorterDuff$Mode;)V
    //   55: aload_2
    //   56: bipush 20
    //   58: invokestatic 514	com/tencent/mobileqq/utils/StackBlur:a	(Landroid/graphics/Bitmap;I)V
    //   61: aload_2
    //   62: aload_1
    //   63: invokevirtual 477	android/graphics/Bitmap:getWidth	()I
    //   66: aload_1
    //   67: invokevirtual 480	android/graphics/Bitmap:getHeight	()I
    //   70: iconst_1
    //   71: invokestatic 484	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   74: astore_1
    //   75: aload_1
    //   76: astore_2
    //   77: aload_2
    //   78: areturn
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: aload_0
    //   83: getfield 182	com/tencent/av/ui/GLVideoView:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   86: iconst_2
    //   87: new 167	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   94: ldc_w 516
    //   97: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_2
    //   101: invokevirtual 429	java/lang/OutOfMemoryError:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   104: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_1
    //   114: areturn
    //   115: astore_2
    //   116: aload 4
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 182	com/tencent/av/ui/GLVideoView:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   123: iconst_2
    //   124: new 167	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   131: ldc_w 518
    //   134: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_2
    //   138: invokevirtual 435	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   141: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public InputTextureInfo a(GLCanvas paramGLCanvas)
  {
    int i2 = 1;
    a(System.currentTimeMillis());
    int i1;
    if (this.f) {
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null)
      {
        i1 = 1;
        if (((i1 & this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.updateCurFrame()) == 0) || (!this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.canRender()) || (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth() == 0) || (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight() == 0)) {
          break label139;
        }
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        this.jdField_c_of_type_Long = System.currentTimeMillis();
        k(false);
        if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null)
        {
          paramGLCanvas = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a(paramGLCanvas);
          i1 = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.e();
          i2 = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.f();
          this.jdField_a_of_type_ComTencentAvUiInputTextureInfo.a(paramGLCanvas[0], i1, i2);
          return this.jdField_a_of_type_ComTencentAvUiInputTextureInfo;
          i1 = 0;
          break;
          label139:
          i1 = 0;
          continue;
        }
        int i3 = paramGLCanvas.a();
        int i4 = paramGLCanvas.b();
        i1 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
        int i7 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
        int i5 = Math.min(i1, i7);
        int i6 = Math.max(i1, i7);
        if ((!c()) && (QLog.isDebugVersion())) {
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "read peer ImgWidth:=" + i1 + ",textureHeight:=" + i7);
        }
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)this.jdField_c_of_type_AndroidGraphicsRectF.width());
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b((int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(0, 0, i1, i7);
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(i1, i7);
        if ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer == null) || ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) && ((this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getWidth() != i5) || (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getHeight() != i6))))
        {
          if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null) {
            this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
          }
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(true, i5, i6, 33984);
        }
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        paramGLCanvas.b();
        paramGLCanvas.a(i5, i6);
        paramGLCanvas.a(i5 / 2, i6 / 2, 0.0F);
        paramGLCanvas.b();
        i7 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.j();
        if (!c())
        {
          i1 = 0;
          i7 = (i7 + i1 + 4) % 4;
          if (i7 % 2 != 0) {
            break label548;
          }
          label449:
          a(paramGLCanvas, i1);
          paramGLCanvas.a(i7 * 90, 0.0F, 0.0F, 1.0F);
          if (i2 == 0) {
            break label553;
          }
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, 0, 0, i5, i6);
        }
        for (;;)
        {
          paramGLCanvas.c();
          paramGLCanvas.c();
          paramGLCanvas.b(i3, i4);
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
          this.jdField_a_of_type_ComTencentAvUiInputTextureInfo.a(this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), i5, i6);
          return this.jdField_a_of_type_ComTencentAvUiInputTextureInfo;
          i1 = this.C;
          break;
          label548:
          i2 = 0;
          break label449;
          label553:
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, 0, 0, i6, i5);
        }
      }
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null))
    {
      paramGLCanvas = this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas);
      i1 = this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.c();
      i2 = this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.d();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "huanxxiao test you have call this mLoadingTexture width:=" + i1);
      }
      this.jdField_a_of_type_ComTencentAvUiInputTextureInfo.a(paramGLCanvas[0], i1, i2);
      return this.jdField_a_of_type_ComTencentAvUiInputTextureInfo;
    }
    this.jdField_a_of_type_ComTencentAvUiInputTextureInfo.a(-1, 0, 0);
    return this.jdField_a_of_type_ComTencentAvUiInputTextureInfo;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_h_of_type_Float != paramFloat)
    {
      this.jdField_h_of_type_Float = paramFloat;
      this.jdField_i_of_type_Boolean = true;
      super.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setTextSize textSize: " + paramFloat);
      }
    }
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2)
  {
    Pair localPair = a(paramInt1, paramInt2, super.b(), super.c(), this.C);
    this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(paramFloat, paramFloat, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
    this.jdField_b_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    float f1 = this.jdField_a_of_type_ArrayOfFloat[0];
    float f2 = this.jdField_i_of_type_Float * 1.0F / 1.111111F;
    float f3 = this.jdField_j_of_type_Float;
    if ((f1 <= f2) || (f1 >= f3 * 1.111111F)) {
      return;
    }
    this.jdField_a_of_type_ArrayOfFloat[0] = f1;
    this.jdField_a_of_type_ArrayOfFloat[4] = f1;
    this.jdField_a_of_type_AndroidGraphicsMatrix.setValues(this.jdField_a_of_type_ArrayOfFloat);
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setScale, scale[" + paramFloat + "->" + f1 + "], x[" + paramInt1 + "->" + localPair.first + "], y[" + paramInt2 + "->" + localPair.second + "], mRotation[" + this.C + "]");
    }
    super.b();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_n_of_type_Int = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = a(paramInt1, paramInt2, 0, 0, this.C);
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setTranslation, isEnd[" + paramBoolean + "], x[" + paramInt1 + "->" + ((Pair)localObject).first + "], y[" + paramInt2 + "->" + ((Pair)localObject).second + "], mRotation[" + this.C + "]");
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    float f1 = this.jdField_a_of_type_ArrayOfFloat[2] + ((Integer)((Pair)localObject).first).intValue();
    float f2 = this.jdField_a_of_type_ArrayOfFloat[5] + ((Integer)((Pair)localObject).second).intValue();
    this.jdField_a_of_type_ArrayOfFloat[2] = f1;
    this.jdField_a_of_type_ArrayOfFloat[5] = f2;
    this.jdField_a_of_type_AndroidGraphicsMatrix.setValues(this.jdField_a_of_type_ArrayOfFloat);
    if (paramBoolean)
    {
      localObject = new RectF();
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect((RectF)localObject, this.jdField_b_of_type_AndroidGraphicsRectF);
      if ((((RectF)localObject).left >= this.jdField_a_of_type_AndroidGraphicsRectF.left) || (((RectF)localObject).right >= this.jdField_a_of_type_AndroidGraphicsRectF.right)) {
        break label406;
      }
      if (((RectF)localObject).width() <= this.jdField_a_of_type_AndroidGraphicsRectF.width()) {
        break label385;
      }
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.right - ((RectF)localObject).right + f1;
    }
    label385:
    label406:
    label716:
    for (;;)
    {
      if ((((RectF)localObject).top < this.jdField_a_of_type_AndroidGraphicsRectF.top) && (((RectF)localObject).bottom < this.jdField_a_of_type_AndroidGraphicsRectF.bottom)) {
        if (((RectF)localObject).height() > this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
          f2 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom - ((RectF)localObject).bottom + f2;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ArrayOfFloat[2] = f1;
        this.jdField_a_of_type_ArrayOfFloat[5] = f2;
        this.jdField_a_of_type_AndroidGraphicsMatrix.setValues(this.jdField_a_of_type_ArrayOfFloat);
        super.b();
        return;
        f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - ((RectF)localObject).centerX() + f1;
        break;
        if ((((RectF)localObject).left > this.jdField_a_of_type_AndroidGraphicsRectF.left) && (((RectF)localObject).right > this.jdField_a_of_type_AndroidGraphicsRectF.right))
        {
          if (((RectF)localObject).width() > this.jdField_a_of_type_AndroidGraphicsRectF.width())
          {
            f1 = this.jdField_a_of_type_AndroidGraphicsRectF.left - ((RectF)localObject).left + f1;
            break;
          }
          f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - ((RectF)localObject).centerX() + f1;
          break;
        }
        if ((((RectF)localObject).left <= this.jdField_a_of_type_AndroidGraphicsRectF.left) || (((RectF)localObject).right >= this.jdField_a_of_type_AndroidGraphicsRectF.right)) {
          break label716;
        }
        f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX() - ((RectF)localObject).centerX() + f1;
        break;
        f2 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - ((RectF)localObject).centerY() + f2;
        continue;
        if ((((RectF)localObject).top > this.jdField_a_of_type_AndroidGraphicsRectF.top) && (((RectF)localObject).bottom > this.jdField_a_of_type_AndroidGraphicsRectF.bottom))
        {
          if (((RectF)localObject).height() > this.jdField_a_of_type_AndroidGraphicsRectF.height()) {
            f2 = this.jdField_a_of_type_AndroidGraphicsRectF.top - ((RectF)localObject).top + f2;
          } else {
            f2 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - ((RectF)localObject).centerY() + f2;
          }
        }
        else if ((((RectF)localObject).top > this.jdField_a_of_type_AndroidGraphicsRectF.top) && (((RectF)localObject).bottom < this.jdField_a_of_type_AndroidGraphicsRectF.bottom)) {
          f2 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY() - ((RectF)localObject).centerY() + f2;
        }
      }
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setMirror, mMirror[" + this.jdField_d_of_type_Boolean + "->" + paramBoolean + "], seq[" + paramLong + "]");
      }
      this.jdField_d_of_type_Boolean = paramBoolean;
      super.b();
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
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
      super.b();
    }
  }
  
  protected void a(GLCanvas paramGLCanvas, int paramInt)
  {
    if (this.jdField_d_of_type_Boolean)
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
  
  public void a(Boolean paramBoolean)
  {
    this.jdField_r_of_type_Boolean = paramBoolean.booleanValue();
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
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected boolean a(int paramInt)
  {
    int i1 = g();
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER_INSIDE) {
      if (!this.jdField_b_of_type_Boolean) {}
    }
    do
    {
      do
      {
        return true;
      } while ((paramInt % 2 == 0) && (!this.jdField_p_of_type_Boolean));
      do
      {
        return false;
      } while (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != ImageView.ScaleType.CENTER_CROP);
    } while (i1 == 2);
    return false;
  }
  
  public float b()
  {
    return this.jdField_j_of_type_Float;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    int i1 = a(paramInt);
    this.jdField_l_of_type_Int = paramInt;
    if ((this.C != i1) && (!c()))
    {
      this.C = i1;
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      if (a() == 0) {
        super.b();
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_ComTencentAvOpenglTextureBitmapTexture != null)
    {
      this.jdField_c_of_type_ComTencentAvOpenglTextureBitmapTexture.a();
      this.jdField_c_of_type_ComTencentAvOpenglTextureBitmapTexture = null;
    }
    this.jdField_c_of_type_ComTencentAvOpenglTextureBitmapTexture = new BitmapTexture(UITools.a(this.jdField_a_of_type_AndroidContentContext, paramInt1));
    this.jdField_c_of_type_ComTencentAvOpenglTextureBitmapTexture.a(false);
    if (this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture != null)
    {
      this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture.a();
      this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture = null;
    }
    this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture = new BitmapTexture(UITools.a(this.jdField_a_of_type_AndroidContentContext, paramInt2));
    this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture.a(false);
  }
  
  public void b(Bitmap paramBitmap)
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
  
  public void b(GLCanvas paramGLCanvas)
  {
    if (!this.f) {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "renderTexture, mNeedRenderVideo is false");
      }
    }
    for (;;)
    {
      f(paramGLCanvas);
      h(paramGLCanvas);
      g(paramGLCanvas);
      i(paramGLCanvas);
      return;
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "renderTexture, mYuvTexture is null");
        }
      }
      else if (!this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.updateCurFrame())
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "renderTexture, updateCurFrame fail");
      }
      else if (!this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.canRender())
      {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "renderTexture, can not Render");
      }
      else
      {
        k(false);
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_n_of_type_Boolean)) {
          e(paramGLCanvas);
        } else {
          d(paramGLCanvas);
        }
      }
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_i_of_type_Boolean = true;
      super.b();
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setText, text[" + this.jdField_a_of_type_JavaLangString + "->" + paramString + "]");
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_m_of_type_Boolean != paramBoolean) {
      this.jdField_m_of_type_Boolean = paramBoolean;
    }
  }
  
  public float c()
  {
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    return this.jdField_a_of_type_ArrayOfFloat[0];
  }
  
  public String c()
  {
    return (String)a(0);
  }
  
  public void c(GLCanvas paramGLCanvas)
  {
    this.jdField_r_of_type_Boolean = true;
    if (!this.f) {
      this.f = false;
    }
    int i1 = super.b();
    int i2 = super.c();
    Rect localRect = super.a();
    int i3 = i1 - localRect.left - localRect.right;
    int i4 = i2 - localRect.top - localRect.bottom;
    paramGLCanvas.a(-i1 / 2, -i2 / 2);
    if (this.jdField_r_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(-9013642);
      if (localRect.left > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.left);
        paramGLCanvas.a(localRect.left / 2, 0.0F, localRect.left / 2, i2, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
      if (localRect.top > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.top);
        paramGLCanvas.a(0.0F, localRect.top / 2, i1, localRect.top / 2, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
      if (localRect.right > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.right);
        paramGLCanvas.a(i1 - localRect.right / 2, 0.0F, i1 - localRect.right / 2, i2, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
      if (localRect.bottom > 0)
      {
        this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint.a(localRect.bottom);
        paramGLCanvas.a(0.0F, i2 - localRect.bottom / 2, i1, i2 - localRect.bottom / 2, this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint);
      }
    }
    paramGLCanvas.a(i1 / 2, i2 / 2);
    if (this.jdField_r_of_type_Boolean) {
      if (((!e()) || (!this.f)) && (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture != null)) {
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, i3, i4);
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_n_of_type_Boolean);
      paramGLCanvas.a(0, 0, i3, i4, this.jdField_i_of_type_Int);
      return;
      if (((!e()) || (!this.f)) && (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture != null))
      {
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, i1, i2);
        return;
      }
    } while (this.jdField_n_of_type_Boolean);
    paramGLCanvas.a(0.0F, 0.0F, i1, i2, this.jdField_i_of_type_Int);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_JavaLangString.equals(c());
  }
  
  public float d()
  {
    return this.jdField_h_of_type_Float;
  }
  
  public String d()
  {
    return "TAG[" + this.jdField_c_of_type_JavaLangString + "], uin[" + c() + "], VST[" + g() + "], LRT[" + a() + "], Drc[" + (int)this.jdField_c_of_type_AndroidGraphicsRectF.width() + ", " + (int)this.jdField_c_of_type_AndroidGraphicsRectF.height() + "], Src[" + (int)this.jdField_b_of_type_AndroidGraphicsRectF.width() + ", " + (int)this.jdField_b_of_type_AndroidGraphicsRectF.height() + "], " + this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a();
  }
  
  public void d()
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    super.d();
  }
  
  protected void d(GLCanvas paramGLCanvas)
  {
    if (this.jdField_b_of_type_Long != 0L)
    {
      this.jdField_b_of_type_Long = 0L;
      this.jdField_n_of_type_Int = 0;
    }
    Object localObject = super.a();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    int i5 = super.b();
    int i6 = super.c();
    int i3 = i5 - ((Rect)localObject).left - ((Rect)localObject).right;
    int i2 = i6 - ((Rect)localObject).top - ((Rect)localObject).bottom;
    boolean bool3 = c();
    int i7 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.j();
    int i1;
    int i8;
    float f2;
    float f5;
    float f6;
    float f3;
    float f4;
    if (((this.jdField_n_of_type_Boolean) && (!bool3)) || (this.jdField_o_of_type_Boolean))
    {
      i1 = 0;
      i8 = (i7 + i1 + 4) % 4;
      f2 = ((Rect)localObject).left;
      f1 = ((Rect)localObject).top;
      f5 = i3;
      f6 = i2;
      if (i8 % 2 == 0) {
        break label1086;
      }
      int i4 = (int)i3;
      i3 = i2;
      i2 = i4;
      f3 = f1;
      f4 = f6;
    }
    for (float f1 = f5;; f1 = f6)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(f3, f2, i3 + f3, i2 + f2);
      float f10 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
      float f11 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
      float f12 = f10 / f11;
      f5 = f4 / f1;
      boolean bool1;
      label259:
      label321:
      label615:
      String str;
      label414:
      boolean bool4;
      if ((!this.jdField_n_of_type_Boolean) && (a(i8)) && (!this.jdField_o_of_type_Boolean))
      {
        bool1 = true;
        float f9 = f1;
        float f8 = f4;
        float f7 = f2;
        f6 = f3;
        if (bool1)
        {
          if (i8 % 2 != 0) {
            break label963;
          }
          f5 = f4 / f12;
          if (f5 <= f1) {
            break label948;
          }
          f5 = f1 * f12;
          f3 += (f4 - f5) / 2.0F;
          f4 = f5;
          f5 = f4 / f1;
          f6 = f3;
          f7 = f2;
          f8 = f4;
          f9 = f1;
        }
        this.jdField_b_of_type_AndroidGraphicsRectF.set(f6, f7, f8 + f6, f9 + f7);
        this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
        if (f12 <= f5) {
          break label1018;
        }
        f1 = f11 * f5;
        f2 = (f10 - f1) / 2.0F;
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)f2, 0, (int)f1, (int)f11);
        if (!this.jdField_l_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(0, 0, (int)f10, (int)f11);
        }
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)f10, (int)f11);
        paramGLCanvas.a(2);
        a(paramGLCanvas, i1);
        paramGLCanvas.a(i8 * 90, 0.0F, 0.0F, 1.0F);
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)this.jdField_c_of_type_AndroidGraphicsRectF.width());
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b((int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
        i2 = (int)(this.jdField_c_of_type_AndroidGraphicsRectF.left - (this.jdField_b_of_type_AndroidGraphicsRectF.width() - this.jdField_c_of_type_AndroidGraphicsRectF.width()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.left);
        i3 = (int)(this.jdField_c_of_type_AndroidGraphicsRectF.top - (this.jdField_b_of_type_AndroidGraphicsRectF.height() - this.jdField_c_of_type_AndroidGraphicsRectF.height()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.top);
        if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture == null) {
          break label1049;
        }
        this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a(paramGLCanvas, i2, i3, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
        {
          this.jdField_c_of_type_Boolean = false;
          QLog.d(this.jdField_c_of_type_JavaLangString, 1, "PC ScreenShare FirstFrameInfo:=<ImgWidth:=" + f10 + ",ImgHeight:=" + f11 + ",YUVImgAngle:=" + i7 + ",mAVSDKNotifyRotationType:=" + this.jdField_k_of_type_Int + ",phoneRotateAngle:=" + this.jdField_l_of_type_Int + ",renderRotation:=" + i8 + ",mDstRectF.width():=" + this.jdField_c_of_type_AndroidGraphicsRectF.width() + ",mDstRectF.height():=" + this.jdField_c_of_type_AndroidGraphicsRectF.height() + ",uiWidth:=" + i5 + ",uiHeight:=" + i6 + ">");
        }
        if (QLog.isColorLevel())
        {
          if (this.jdField_a_of_type_ComTencentAvUiGLVideoView$LogInfo == null) {
            this.jdField_a_of_type_ComTencentAvUiGLVideoView$LogInfo = new GLVideoView.LogInfo();
          }
          localObject = this.jdField_a_of_type_ComTencentAvUiGLVideoView$LogInfo;
          str = this.jdField_c_of_type_JavaLangString;
          bool4 = this.jdField_d_of_type_Boolean;
          if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture == null) {
            break label1080;
          }
        }
      }
      label948:
      label1080:
      for (boolean bool2 = true;; bool2 = false)
      {
        ((GLVideoView.LogInfo)localObject).a(str, bool3, bool4, bool2, bool1, i2, i3, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_b_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_b_of_type_AndroidGraphicsRectF.width(), (int)f10, (int)f11, this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.c(), this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.d(), f12, f5, i1, i7, this.C, i8, this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal());
        paramGLCanvas.c();
        return;
        i1 = this.C;
        break;
        bool1 = false;
        break label259;
        f2 += (f1 - f5) / 2.0F;
        f1 = f5;
        break label321;
        label963:
        f5 = f1 * f12;
        if (f5 > f4)
        {
          f5 = f4 / f12;
          f2 += (f1 - f5) / 2.0F;
          f1 = f5;
          break label321;
        }
        f3 += (f4 - f5) / 2.0F;
        f4 = f5;
        break label321;
        label1018:
        f1 = f10 / f5;
        f2 = (f11 - f1) / 2.0F;
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(0, (int)f2, (int)f10, (int)f1);
        break label414;
        this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, i2, i3, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
        break label615;
      }
      label1049:
      label1086:
      f4 = f5;
      f3 = f2;
      f2 = f1;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_n_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
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
        b(localException);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int e()
  {
    return this.jdField_p_of_type_Int;
  }
  
  protected void e(GLCanvas paramGLCanvas)
  {
    int i1 = 0;
    int i2 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
    int i3 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
    Rect localRect = super.a();
    int i4 = super.b();
    int i5 = super.c();
    int i6 = ScreenLayoutDoubleScreen.a(i3) / 2;
    int i7 = (i2 - i6) / 2;
    this.jdField_b_of_type_AndroidGraphicsRectF.set(i7, 0, i6 + i7, 0 + i3);
    this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, localRect.top, i4 - localRect.right, i5 - localRect.bottom);
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)this.jdField_b_of_type_AndroidGraphicsRectF.left, (int)this.jdField_b_of_type_AndroidGraphicsRectF.top, (int)this.jdField_b_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_b_of_type_AndroidGraphicsRectF.height());
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(i2, i3);
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)this.jdField_c_of_type_AndroidGraphicsRectF.width());
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b((int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
    paramGLCanvas.a(2);
    if (this.jdField_n_of_type_Boolean) {}
    for (;;)
    {
      a(paramGLCanvas, i1);
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, (int)this.jdField_c_of_type_AndroidGraphicsRectF.left, (int)this.jdField_c_of_type_AndroidGraphicsRectF.top, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
      paramGLCanvas.c();
      AVLog.printColorLog(this.jdField_c_of_type_JavaLangString, "renderDoubleScreenOfPC:|" + c() + "|" + g() + "|" + i2 + "|" + i3 + "|" + i4 + "|" + i5 + "|" + this.jdField_b_of_type_AndroidGraphicsRectF.toString() + "|" + this.jdField_c_of_type_AndroidGraphicsRectF.toString());
      return;
      i1 = this.C;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_o_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    boolean bool = false;
    try
    {
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null) {
        bool = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.canRender();
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public int f()
  {
    return this.jdField_q_of_type_Int;
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
  }
  
  protected void f(GLCanvas paramGLCanvas)
  {
    int i1;
    int i2;
    int i4;
    int i3;
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null))
    {
      this.jdField_m_of_type_Int %= 360;
      i1 = super.b();
      i2 = super.c();
      i4 = this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.c();
      i3 = this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.d();
      if (i4 <= i1) {
        break label201;
      }
    }
    for (;;)
    {
      if (i3 > i2) {}
      for (;;)
      {
        paramGLCanvas.a(2);
        this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, i1, i2);
        paramGLCanvas.c();
        long l1 = System.currentTimeMillis();
        if (l1 - this.jdField_a_of_type_Long >= 80L)
        {
          this.jdField_a_of_type_Long = l1;
          this.jdField_m_of_type_Int += 8;
        }
        if (this.jdField_b_of_type_Long == 0L)
        {
          this.jdField_b_of_type_Long = l1;
          this.jdField_n_of_type_Int = 0;
        }
        while ((l1 - this.jdField_b_of_type_Long < 5000L) || (this.jdField_n_of_type_Int >= 2)) {
          return;
        }
        this.jdField_b_of_type_Long = l1;
        l(this.jdField_n_of_type_Int);
        this.jdField_n_of_type_Int += 1;
        return;
        i2 = i3;
      }
      label201:
      i1 = i4;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_p_of_type_Boolean = paramBoolean;
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void finalize()
  {
    try
    {
      if (this.jdField_d_of_type_ComTencentAvOpenglTextureBasicTexture != null)
      {
        this.jdField_d_of_type_ComTencentAvOpenglTextureBasicTexture.a();
        this.jdField_d_of_type_ComTencentAvOpenglTextureBasicTexture = null;
      }
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture != null)
      {
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a();
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture = null;
      }
      if (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null)
      {
        this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a();
        this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = null;
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
      if (this.jdField_e_of_type_ComTencentAvOpenglTextureBasicTexture != null)
      {
        this.jdField_e_of_type_ComTencentAvOpenglTextureBasicTexture.a();
        this.jdField_e_of_type_ComTencentAvOpenglTextureBasicTexture = null;
      }
      this.jdField_a_of_type_JavaLangRunnable = null;
      this.jdField_e_of_type_Boolean = false;
      this.jdField_s_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = null;
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int g()
  {
    Integer localInteger = (Integer)a(1);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  public void g(int paramInt)
  {
    if (this.jdField_r_of_type_Int != paramInt) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureColorTexture = new ColorTexture(paramInt);
    }
  }
  
  protected void g(GLCanvas paramGLCanvas)
  {
    int i1;
    int i2;
    int i3;
    int i4;
    int i6;
    int i5;
    if (this.jdField_s_of_type_Boolean)
    {
      Rect localRect = super.a();
      if (this.jdField_d_of_type_ComTencentAvOpenglTextureBasicTexture != null)
      {
        i1 = super.b();
        super.c();
        i2 = localRect.left;
        i3 = localRect.right;
        i4 = localRect.left;
        i4 = localRect.bottom;
        this.jdField_d_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, i1 - i2 - i3, 36);
      }
      if (this.jdField_i_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture == null) {
          this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture = new StringTexture();
        }
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a();
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a(this.jdField_h_of_type_Float);
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.c(this.jdField_p_of_type_Int);
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.d(this.jdField_q_of_type_Int);
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.e(super.b() - this.w);
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.e();
        this.jdField_i_of_type_Boolean = false;
      }
      if ((this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        i6 = super.b();
        i5 = super.c();
        i3 = this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.c();
        i4 = this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.d();
        if (!this.g) {
          break label312;
        }
        i1 = this.w;
        i2 = i5 - this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.j() - this.v;
      }
    }
    for (;;)
    {
      paramGLCanvas.a(2);
      i6 = (i3 - i6) / 2;
      i5 = (i4 - i5) / 2;
      paramGLCanvas.a(i6, i5);
      this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a(paramGLCanvas, i1, i2, i3, i4);
      paramGLCanvas.c();
      return;
      label312:
      if (this.jdField_q_of_type_Boolean)
      {
        i1 = this.B;
        i2 = this.B;
      }
      else if (this.jdField_h_of_type_Boolean)
      {
        i1 = (i6 - i3) / 2;
        i2 = (i5 - i4) / 2;
      }
      else
      {
        i1 = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        i2 = this.A;
      }
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setIsPC, isPC[" + this.jdField_b_of_type_Boolean + "->" + paramBoolean + "]");
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = true;
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
    super.b();
  }
  
  public boolean g()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = null;
    }
  }
  
  public void h(int paramInt)
  {
    if ((this.jdField_s_of_type_Int == paramInt) || ((this.jdField_s_of_type_Int == 2) && (paramInt == 0))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 1, "refreshMicState, uin[" + c() + ", state[" + this.jdField_s_of_type_Int + "->" + paramInt + "]");
    }
    this.jdField_s_of_type_Int = paramInt;
    b();
  }
  
  protected void h(GLCanvas paramGLCanvas)
  {
    if ((this.jdField_m_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvOpenglTextureColorTexture != null)) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureColorTexture.a(paramGLCanvas, 0, 0, b(), c());
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      super.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setTextInBottom inBottom: " + paramBoolean);
      }
    }
  }
  
  public boolean h()
  {
    return this.g;
  }
  
  public void i()
  {
    this.jdField_i_of_type_Boolean = true;
    super.b();
  }
  
  public void i(int paramInt)
  {
    this.A = paramInt;
  }
  
  protected void i(GLCanvas paramGLCanvas)
  {
    BitmapTexture localBitmapTexture;
    int i3;
    int i4;
    int i5;
    int i6;
    int i1;
    if ((this.jdField_s_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture != null))
    {
      localBitmapTexture = null;
      if (this.jdField_s_of_type_Int != 2) {
        break label168;
      }
      localBitmapTexture = this.jdField_c_of_type_ComTencentAvOpenglTextureBitmapTexture;
      if (localBitmapTexture != null)
      {
        i3 = super.b();
        i4 = super.c();
        i5 = localBitmapTexture.c();
        i6 = localBitmapTexture.d();
        if (!this.g) {
          break label185;
        }
        i1 = i3 - i5 - this.v;
      }
    }
    for (int i2 = i4 - this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.j() - this.v + this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.k() - i6 + (i6 - this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.k()) / 2;; i2 = this.A + this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.k() - i6 + Math.abs((i6 - this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.k()) / 2))
    {
      paramGLCanvas.a(3);
      paramGLCanvas.a((i5 - i3) / 2, (i6 - i4) / 2);
      localBitmapTexture.a(paramGLCanvas, i1, i2, i5, i6);
      paramGLCanvas.c();
      return;
      label168:
      if (this.jdField_s_of_type_Int != 1) {
        break;
      }
      localBitmapTexture = this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture;
      break;
      label185:
      i1 = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.c() + this.w;
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.jdField_h_of_type_Boolean != paramBoolean)
    {
      this.jdField_h_of_type_Boolean = paramBoolean;
      super.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setTextInBottomCenter inBottom: " + paramBoolean);
      }
    }
  }
  
  public boolean i()
  {
    return this.jdField_s_of_type_Boolean;
  }
  
  public void j(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_q_of_type_Int != paramInt))
    {
      this.jdField_q_of_type_Int = paramInt;
      this.jdField_i_of_type_Boolean = true;
      super.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setMaxLength maxLength: " + paramInt);
      }
    }
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.jdField_s_of_type_Boolean != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "showText, show[" + this.jdField_s_of_type_Boolean + "->" + paramBoolean + "]");
      }
      this.jdField_s_of_type_Boolean = paramBoolean;
      super.b();
    }
  }
  
  public boolean j()
  {
    return this.f;
  }
  
  public void k(int paramInt)
  {
    if (this.jdField_p_of_type_Int != paramInt)
    {
      this.jdField_p_of_type_Int = paramInt;
      this.jdField_i_of_type_Boolean = true;
      super.b();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setTextColor textColor: 0x" + Integer.toHexString(paramInt).toUpperCase());
      }
    }
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Boolean != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "enableLoading loading: " + paramBoolean + ", mLoading: " + this.jdField_e_of_type_Boolean);
      }
      this.jdField_e_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        break label108;
      }
      if (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture == null) {
        this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = new ResourceTexture(this.jdField_a_of_type_AndroidContentContext, 2130842474);
      }
      localGLRootView = a();
      if (localGLRootView != null) {
        localGLRootView.post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    return;
    label108:
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_n_of_type_Int = 0;
  }
  
  public boolean k()
  {
    return this.jdField_q_of_type_Boolean;
  }
  
  public void l(boolean paramBoolean)
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
  
  public void m(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "setNeedRenderVideo bRender: " + paramBoolean + ", mNeedRenderVideo: " + this.f);
    }
    this.f = paramBoolean;
    super.b();
  }
  
  public void n(boolean paramBoolean)
  {
    this.jdField_q_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      this.B = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297979);
    }
  }
  
  public void o(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "setCameraIsBindData, uin[" + c() + "], VideoSrcType[" + g() + "], isBind[" + paramBoolean + "]");
      }
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.GLVideoView
 * JD-Core Version:    0.7.0.1
 */