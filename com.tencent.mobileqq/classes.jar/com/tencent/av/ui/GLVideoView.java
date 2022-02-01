package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff.Mode;
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
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.qphone.base.util.QLog;
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
  private int D = 10000;
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
  private long d;
  protected BasicTexture d;
  protected boolean d;
  private long e;
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
    this.jdField_d_of_type_Long = -1L;
    this.jdField_e_of_type_Long = -1L;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GLVideoView_");
    localStringBuilder.append(paramString);
    this.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    QLog.w(this.jdField_c_of_type_JavaLangString, 1, "create GLVideoView");
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentAvOpenglGlrendererGLPaint = new GLPaint();
    this.v = AIOUtils.b(6.0F, paramContext.getResources());
    this.w = AIOUtils.b(10.0F, paramContext.getResources());
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
    paramInt %= 360;
    if (paramInt != 90)
    {
      if (paramInt != 180)
      {
        if (paramInt != 270) {
          return 0;
        }
        return 1;
      }
      return 2;
    }
    return 3;
  }
  
  static Pair<Integer, Integer> a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 1) {
      paramInt1 = paramInt3 - paramInt1;
    }
    int i1;
    for (;;)
    {
      paramInt3 = paramInt2;
      i1 = paramInt1;
      break;
      if (paramInt5 == 2)
      {
        paramInt3 -= paramInt1;
        i1 = paramInt4 - paramInt2;
        break;
      }
      paramInt3 = paramInt1;
      i1 = paramInt2;
      if (paramInt5 != 3) {
        break;
      }
      paramInt2 = paramInt4 - paramInt2;
    }
    return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(i1));
  }
  
  private Long a()
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.jdField_d_of_type_Long > this.D)
    {
      this.jdField_d_of_type_Long = l1;
      l1 = this.jdField_e_of_type_Long;
      this.jdField_e_of_type_Long = 0L;
      return new Long(l1);
    }
    this.jdField_e_of_type_Long += 1L;
    return null;
  }
  
  public static int[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("I420toARGB is null nWidth=");
      paramArrayOfByte.append(paramInt1);
      paramArrayOfByte.append(", nHeight=");
      paramArrayOfByte.append(paramInt2);
      QLog.d("GLVideoView", 1, paramArrayOfByte.toString());
      return null;
    }
    int i4;
    int i5;
    if (paramInt2 < 0)
    {
      i4 = -paramInt2;
      i5 = 1;
    }
    else
    {
      i5 = 0;
      i4 = paramInt2;
    }
    int i6;
    int i7;
    if (paramInt1 < 0)
    {
      i6 = -paramInt1;
      i7 = 1;
    }
    else
    {
      i7 = 0;
      i6 = paramInt1;
    }
    int i8 = i6 * i4;
    try
    {
      int[] arrayOfInt = new int[i8];
      paramInt1 = 0;
      while (paramInt1 < i8)
      {
        int i9 = paramInt1 / i6;
        paramInt2 = i9 / 2;
        int i1 = i6 / 2;
        int i10 = paramInt1 % i6;
        int i2 = paramInt2 * i1 + i10 / 2;
        paramInt2 = paramArrayOfByte[paramInt1];
        i1 = paramArrayOfByte[(i8 + i2)];
        i2 = paramArrayOfByte[(i8 / 4 + i8 + i2)];
        double d1 = paramInt2 & 0xFF;
        double d2 = (i1 & 0xFF) - 128;
        Double.isNaN(d2);
        Double.isNaN(d1);
        i1 = (int)(d1 + 1.8556D * d2);
        double d3 = (i2 & 0xFF) - 128;
        Double.isNaN(d3);
        Double.isNaN(d2);
        Double.isNaN(d1);
        i2 = (int)(d1 - (0.4681D * d3 + d2 * 0.1872D));
        Double.isNaN(d3);
        Double.isNaN(d1);
        int i3 = (int)(d1 + d3 * 1.5748D);
        if (i1 > 255)
        {
          paramInt2 = 255;
        }
        else
        {
          paramInt2 = i1;
          if (i1 < 0) {
            paramInt2 = 0;
          }
        }
        if (i2 > 255)
        {
          i1 = 255;
        }
        else
        {
          i1 = i2;
          if (i2 < 0) {
            i1 = 0;
          }
        }
        if (i3 > 255)
        {
          i2 = 255;
        }
        else
        {
          i2 = i3;
          if (i3 < 0) {
            i2 = 0;
          }
        }
        if (i5 != 0) {
          i3 = i10 + (i4 - 1 - i9) * i6;
        } else {
          i3 = paramInt1;
        }
        i9 = i3;
        if (i7 != 0) {
          i9 = i3 / i6 * i6 + (i6 - 1) - i3 % i6;
        }
        arrayOfInt[i9] = (i2 << 16 & 0xFF0000 | 0xFF000000 | 0xFF00 & i1 << 8 | paramInt2 & 0xFF);
        paramInt1 += 1;
      }
      return arrayOfInt;
    }
    catch (OutOfMemoryError paramArrayOfByte) {}
    return null;
  }
  
  private void l(int paramInt)
  {
    Object localObject1 = this.jdField_b_of_type_JavaLangRefWeakReference;
    String str;
    Object localObject2;
    if (localObject1 != null)
    {
      if (((WeakReference)localObject1).get() == null) {
        return;
      }
      str = null;
      localObject1 = str;
      if (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null)
      {
        localObject1 = str;
        if ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof AVActivity)) {
          localObject1 = (AVActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get();
        }
      }
      if ((localObject1 != null) && (((AVActivity)localObject1).a != null))
      {
        if (!(((AVActivity)localObject1).a instanceof MultiVideoCtrlLayerUIBase)) {
          return;
        }
        localObject2 = (MultiVideoCtrlLayerUIBase)((AVActivity)localObject1).a;
        localObject1 = new StringBuilder();
        str = c();
      }
    }
    label386:
    for (;;)
    {
      long l1;
      try
      {
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(';');
        paramInt = NetworkUtil.getNetworkType(BaseApplicationImpl.getApplication());
        if (paramInt != 1) {
          break label372;
        }
        paramInt = 1;
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(';');
        if (((MultiVideoCtrlLayerUIBase)localObject2).e != 1) {
          break label386;
        }
        l1 = 0L;
        ((StringBuilder)localObject1).append(l1);
        ((StringBuilder)localObject1).append(';');
        ((StringBuilder)localObject1).append(((MultiVideoCtrlLayerUIBase)localObject2).jdField_b_of_type_Long);
        ((StringBuilder)localObject1).append(';');
        ((StringBuilder)localObject1).append(((MultiVideoCtrlLayerUIBase)localObject2).a.d());
        if (QLog.isColorLevel())
        {
          localObject2 = this.jdField_c_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("doBlackScreenDataReport questionUin:= ");
          localStringBuilder.append(str);
          localStringBuilder.append(",rommInfo:=");
          localStringBuilder.append(((StringBuilder)localObject1).toString());
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        ThreadManager.getSubThreadHandler().post(new GLVideoView.3(this, str, (StringBuilder)localObject1));
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          str = this.jdField_c_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doBlackScreenDataReport Exception");
          ((StringBuilder)localObject2).append(localException.getMessage());
          QLog.d(str, 2, ((StringBuilder)localObject2).toString());
        }
      }
      return;
      label372:
      if (paramInt == 0)
      {
        paramInt = 0;
      }
      else
      {
        paramInt = 2;
        continue;
        l1 = 1L;
      }
    }
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
    Object localObject1 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a();
    Object localObject5 = null;
    Object localObject4 = null;
    if (localObject1 == null)
    {
      QLog.d(this.jdField_c_of_type_JavaLangString, 2, "getFrameBitmap  get last frame failed");
      return null;
    }
    int i1 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.h();
    int i2 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.i();
    int i3 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.k();
    YuvImage localYuvImage;
    if (i3 == 0)
    {
      localObject1 = a((byte[])localObject1, i1, i2);
      if (localObject1 == null)
      {
        localObject1 = this.jdField_c_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getFrameBitmap  I420toARGB failed, type=");
        ((StringBuilder)localObject3).append(i3);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        return null;
      }
      try
      {
        localObject1 = Bitmap.createBitmap((int[])localObject1, i1, i2, Bitmap.Config.ARGB_8888);
      }
      catch (Exception localException)
      {
        localObject3 = this.jdField_c_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("getFrameBitmap exception e.stack ");
        ((StringBuilder)localObject4).append(localException.getStackTrace());
        QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localObject3 = this.jdField_c_of_type_JavaLangString;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("getFrameBitmap OOM exception e.stack ");
        ((StringBuilder)localObject4).append(localOutOfMemoryError1.getStackTrace());
        QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      localObject2 = null;
      if (localObject2 == null)
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "getFrameBitmap createBitmap failed");
        return null;
      }
    }
    else
    {
      localYuvImage = new YuvImage((byte[])localObject2, 17, i1, i2, null);
      localObject2 = localObject4;
      localObject3 = localObject5;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject2 = localObject4;
      localObject3 = localObject5;
      localYuvImage.compressToJpeg(new Rect(0, 0, i1, i2), 100, localByteArrayOutputStream);
      localObject2 = localObject4;
      localObject3 = localObject5;
      localObject4 = BitmapFactory.decodeByteArray(localByteArrayOutputStream.toByteArray(), 0, localByteArrayOutputStream.size());
      localObject2 = localObject4;
      localObject3 = localObject4;
      localByteArrayOutputStream.close();
      localObject2 = localObject4;
    }
    catch (IOException localIOException)
    {
      break label381;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label363:
      break label363;
    }
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "getFrameBitmap YuvImage close failed OOM");
    Object localObject2 = localObject3;
    break label392;
    label381:
    QLog.d(this.jdField_c_of_type_JavaLangString, 1, "getFrameBitmap YuvImage close failed");
    label392:
    Object localObject3 = this.jdField_c_of_type_JavaLangString;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("getFrameBitmap nWidth=");
    ((StringBuilder)localObject4).append(i1);
    ((StringBuilder)localObject4).append(", nHeight=");
    ((StringBuilder)localObject4).append(i2);
    QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
    return localObject2;
  }
  
  Bitmap a(Bitmap paramBitmap)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramBitmap != null)
    {
      localObject1 = localObject3;
      try
      {
        localObject3 = Bitmap.createScaledBitmap(paramBitmap, paramBitmap.getWidth() / 4, paramBitmap.getHeight() / 4, true);
        localObject2 = localObject3;
        localObject1 = localObject3;
        Canvas localCanvas = new Canvas();
        localObject2 = localObject3;
        localObject1 = localObject3;
        localCanvas.setBitmap((Bitmap)localObject3);
        localObject2 = localObject3;
        localObject1 = localObject3;
        localCanvas.drawColor(Color.parseColor("#10ffffff"), PorterDuff.Mode.LIGHTEN);
        localObject2 = localObject3;
        localObject1 = localObject3;
        StackBlur.a((Bitmap)localObject3, 20);
        localObject2 = localObject3;
        localObject1 = localObject3;
        paramBitmap = Bitmap.createScaledBitmap((Bitmap)localObject3, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
        return paramBitmap;
      }
      catch (Exception paramBitmap)
      {
        localObject1 = this.jdField_c_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("doStartRenderFouceGround BlurBitmap exception e.stack ");
        ((StringBuilder)localObject3).append(paramBitmap.getStackTrace());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        return localObject2;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        localObject2 = this.jdField_c_of_type_JavaLangString;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("doStartRenderFouceGround BlurBitmap OOM exception e.stack ");
        ((StringBuilder)localObject3).append(paramBitmap.getStackTrace());
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    return localObject1;
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
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_h_of_type_Float != paramFloat)
    {
      this.jdField_h_of_type_Float = paramFloat;
      this.jdField_i_of_type_Boolean = true;
      super.b();
      if (QLog.isColorLevel())
      {
        String str = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTextSize textSize: ");
        localStringBuilder.append(paramFloat);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2)
  {
    Pair localPair = a(paramInt1, paramInt2, super.b(), super.c(), this.C);
    this.jdField_b_of_type_AndroidGraphicsMatrix.set(this.jdField_a_of_type_AndroidGraphicsMatrix);
    this.jdField_b_of_type_AndroidGraphicsMatrix.postScale(paramFloat, paramFloat, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
    this.jdField_b_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    Object localObject = this.jdField_a_of_type_ArrayOfFloat;
    float f1 = localObject[0];
    float f2 = this.jdField_i_of_type_Float * 1.0F / 1.111111F;
    float f3 = this.jdField_j_of_type_Float;
    if (f1 > f2)
    {
      if (f1 >= f3 * 1.111111F) {
        return;
      }
      localObject[0] = f1;
      localObject[4] = f1;
      this.jdField_a_of_type_AndroidGraphicsMatrix.setValues((float[])localObject);
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setScale, scale[");
        localStringBuilder.append(paramFloat);
        localStringBuilder.append("->");
        localStringBuilder.append(f1);
        localStringBuilder.append("], x[");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("->");
        localStringBuilder.append(localPair.first);
        localStringBuilder.append("], y[");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("->");
        localStringBuilder.append(localPair.second);
        localStringBuilder.append("], mRotation[");
        localStringBuilder.append(this.C);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      super.b();
    }
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
    if (QLog.isColorLevel())
    {
      String str = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTranslation, isEnd[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], x[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("->");
      localStringBuilder.append(((Pair)localObject).first);
      localStringBuilder.append("], y[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("->");
      localStringBuilder.append(((Pair)localObject).second);
      localStringBuilder.append("], mRotation[");
      localStringBuilder.append(this.C);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.getValues(this.jdField_a_of_type_ArrayOfFloat);
    float f5 = this.jdField_a_of_type_ArrayOfFloat[2] + ((Integer)((Pair)localObject).first).intValue();
    float f4 = this.jdField_a_of_type_ArrayOfFloat[5] + ((Integer)((Pair)localObject).second).intValue();
    localObject = this.jdField_a_of_type_ArrayOfFloat;
    localObject[2] = f5;
    localObject[5] = f4;
    this.jdField_a_of_type_AndroidGraphicsMatrix.setValues((float[])localObject);
    if (paramBoolean)
    {
      localObject = new RectF();
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect((RectF)localObject, this.jdField_b_of_type_AndroidGraphicsRectF);
      float f1;
      float f2;
      if ((((RectF)localObject).left < this.jdField_a_of_type_AndroidGraphicsRectF.left) && (((RectF)localObject).right < this.jdField_a_of_type_AndroidGraphicsRectF.right)) {
        if (((RectF)localObject).width() > this.jdField_a_of_type_AndroidGraphicsRectF.width())
        {
          f1 = this.jdField_a_of_type_AndroidGraphicsRectF.right;
          f2 = ((RectF)localObject).right;
        }
        else
        {
          f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX();
          f2 = ((RectF)localObject).centerX();
        }
      }
      float f3;
      for (;;)
      {
        f3 = f5 + (f1 - f2);
        break;
        if ((((RectF)localObject).left > this.jdField_a_of_type_AndroidGraphicsRectF.left) && (((RectF)localObject).right > this.jdField_a_of_type_AndroidGraphicsRectF.right))
        {
          if (((RectF)localObject).width() > this.jdField_a_of_type_AndroidGraphicsRectF.width())
          {
            f1 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
            f2 = ((RectF)localObject).left;
          }
          else
          {
            f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX();
            f2 = ((RectF)localObject).centerX();
          }
        }
        else
        {
          f3 = f5;
          if (((RectF)localObject).left <= this.jdField_a_of_type_AndroidGraphicsRectF.left) {
            break;
          }
          f3 = f5;
          if (((RectF)localObject).right >= this.jdField_a_of_type_AndroidGraphicsRectF.right) {
            break;
          }
          f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerX();
          f2 = ((RectF)localObject).centerX();
        }
      }
      if ((((RectF)localObject).top < this.jdField_a_of_type_AndroidGraphicsRectF.top) && (((RectF)localObject).bottom < this.jdField_a_of_type_AndroidGraphicsRectF.bottom)) {
        if (((RectF)localObject).height() > this.jdField_a_of_type_AndroidGraphicsRectF.height())
        {
          f1 = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
          f2 = ((RectF)localObject).bottom;
        }
        else
        {
          f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY();
          f2 = ((RectF)localObject).centerY();
        }
      }
      for (;;)
      {
        f1 = f4 + (f1 - f2);
        break;
        if ((((RectF)localObject).top > this.jdField_a_of_type_AndroidGraphicsRectF.top) && (((RectF)localObject).bottom > this.jdField_a_of_type_AndroidGraphicsRectF.bottom))
        {
          if (((RectF)localObject).height() > this.jdField_a_of_type_AndroidGraphicsRectF.height())
          {
            f1 = this.jdField_a_of_type_AndroidGraphicsRectF.top;
            f2 = ((RectF)localObject).top;
          }
          else
          {
            f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY();
            f2 = ((RectF)localObject).centerY();
          }
        }
        else
        {
          f1 = f4;
          if (((RectF)localObject).top <= this.jdField_a_of_type_AndroidGraphicsRectF.top) {
            break;
          }
          f1 = f4;
          if (((RectF)localObject).bottom >= this.jdField_a_of_type_AndroidGraphicsRectF.bottom) {
            break;
          }
          f1 = this.jdField_a_of_type_AndroidGraphicsRectF.centerY();
          f2 = ((RectF)localObject).centerY();
        }
      }
      localObject = this.jdField_a_of_type_ArrayOfFloat;
      localObject[2] = f3;
      localObject[5] = f1;
      this.jdField_a_of_type_AndroidGraphicsMatrix.setValues((float[])localObject);
    }
    super.b();
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        String str = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMirror, mMirror[");
        localStringBuilder.append(this.jdField_d_of_type_Boolean);
        localStringBuilder.append("->");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setScaleType scaleType: ");
      localStringBuilder.append(paramScaleType);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = paramScaleType;
    if (paramScaleType == null) {
      localObject = ImageView.ScaleType.CENTER_INSIDE;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType != localObject)
    {
      this.jdField_a_of_type_AndroidWidgetImageView$ScaleType = ((ImageView.ScaleType)localObject);
      super.b();
    }
  }
  
  protected void a(GLCanvas paramGLCanvas, int paramInt)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      if (paramInt % 2 == 0)
      {
        paramGLCanvas.b(-1.0F, 1.0F, 1.0F);
        return;
      }
      paramGLCanvas.b(1.0F, -1.0F, 1.0F);
    }
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
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected boolean a(int paramInt)
  {
    int i1 = g();
    if (this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER_INSIDE)
    {
      if (this.jdField_b_of_type_Boolean) {
        return true;
      }
      if ((paramInt % 2 == 0) && (!this.jdField_p_of_type_Boolean)) {
        return true;
      }
    }
    else if ((this.jdField_a_of_type_AndroidWidgetImageView$ScaleType == ImageView.ScaleType.CENTER_CROP) && (i1 == 2))
    {
      return true;
    }
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
    BitmapTexture localBitmapTexture = this.jdField_c_of_type_ComTencentAvOpenglTextureBitmapTexture;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.a();
      this.jdField_c_of_type_ComTencentAvOpenglTextureBitmapTexture = null;
    }
    this.jdField_c_of_type_ComTencentAvOpenglTextureBitmapTexture = new BitmapTexture(UITools.a(this.jdField_a_of_type_AndroidContentContext, paramInt1));
    this.jdField_c_of_type_ComTencentAvOpenglTextureBitmapTexture.a(false);
    localBitmapTexture = this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.a();
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
    BitmapTexture localBitmapTexture = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = null;
    }
    this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = new BitmapTexture(paramBitmap);
  }
  
  protected void b(GLCanvas paramGLCanvas)
  {
    if (!this.f)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_c_of_type_JavaLangString, 1, "renderTexture, mNeedRenderVideo is false");
      }
    }
    else
    {
      YUVTexture localYUVTexture = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture;
      if (localYUVTexture == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(this.jdField_c_of_type_JavaLangString, 1, "renderTexture, mYuvTexture is null");
        }
      }
      else if (!localYUVTexture.updateCurFrame())
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
    f(paramGLCanvas);
    h(paramGLCanvas);
    g(paramGLCanvas);
    i(paramGLCanvas);
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_i_of_type_Boolean = true;
      super.b();
      if (QLog.isColorLevel())
      {
        String str = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setText, text[");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append("->");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
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
  
  protected void c(GLCanvas paramGLCanvas)
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
    if (this.jdField_r_of_type_Boolean)
    {
      if (((!e()) || (!this.f)) && (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture != null))
      {
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, i3, i4);
        return;
      }
      if (!this.jdField_n_of_type_Boolean)
      {
        float f1 = 0;
        paramGLCanvas.a(f1, f1, i3, i4, this.jdField_i_of_type_Int);
      }
    }
    else
    {
      if (((!e()) || (!this.f)) && (this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture != null))
      {
        this.jdField_a_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, i1, i2);
        return;
      }
      if (!this.jdField_n_of_type_Boolean) {
        paramGLCanvas.a(0.0F, 0.0F, i1, i2, this.jdField_i_of_type_Int);
      }
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAG[");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("], uin[");
    localStringBuilder.append(c());
    localStringBuilder.append("], VST[");
    localStringBuilder.append(g());
    localStringBuilder.append("], LRT[");
    localStringBuilder.append(a());
    localStringBuilder.append("], Drc[");
    localStringBuilder.append((int)this.jdField_c_of_type_AndroidGraphicsRectF.width());
    localStringBuilder.append(", ");
    localStringBuilder.append((int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
    localStringBuilder.append("], Src[");
    localStringBuilder.append((int)this.jdField_b_of_type_AndroidGraphicsRectF.width());
    localStringBuilder.append(", ");
    localStringBuilder.append((int)this.jdField_b_of_type_AndroidGraphicsRectF.height());
    localStringBuilder.append("], ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a());
    return localStringBuilder.toString();
  }
  
  protected void d()
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
    Object localObject1 = a();
    int i1;
    if (localObject1 != null) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject2 = super.a();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    int i8 = super.b();
    int i9 = super.c();
    int i7 = i8 - ((Rect)localObject2).left - ((Rect)localObject2).right;
    int i3 = i9 - ((Rect)localObject2).top - ((Rect)localObject2).bottom;
    boolean bool3 = c();
    int i5 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.j();
    int i2;
    if (((this.jdField_n_of_type_Boolean) && (!bool3)) || (this.jdField_o_of_type_Boolean)) {
      i2 = 0;
    } else {
      i2 = this.C;
    }
    int i6 = (i5 + i2 + 4) % 4;
    float f1 = ((Rect)localObject2).left;
    float f5 = ((Rect)localObject2).top;
    float f3 = i7;
    float f2 = i3;
    int i10 = i6 % 2;
    float f4;
    float f6;
    if (i10 != 0)
    {
      i4 = (int)f3;
      f4 = f3;
      f3 = f2;
      f2 = f5;
    }
    else
    {
      f6 = f1;
      f4 = f2;
      f1 = f5;
      i4 = i3;
      i3 = i7;
      f2 = f6;
    }
    this.jdField_a_of_type_AndroidGraphicsRectF.set(f2, f1, i3 + f2, i4 + f1);
    float f7 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
    float f8 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
    float f9 = f7 / f8;
    f5 = f3 / f4;
    boolean bool1;
    if ((!this.jdField_n_of_type_Boolean) && (a(i6)) && (!this.jdField_o_of_type_Boolean)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1)
    {
      if (i10 == 0)
      {
        f6 = f3 / f9;
        f5 = f6;
        if (f6 > f4)
        {
          f5 = f4 * f9;
          break label393;
        }
      }
      else
      {
        f6 = f4 * f9;
        f5 = f6;
        if (f6 <= f3) {
          break label393;
        }
        f5 = f3 / f9;
      }
      f1 += (f4 - f5) / 2.0F;
      f4 = f5;
      break label407;
      label393:
      f2 += (f3 - f5) / 2.0F;
      f3 = f5;
      label407:
      f5 = f3 / f4;
    }
    this.jdField_b_of_type_AndroidGraphicsRectF.set(f2, f1, f3 + f2, f4 + f1);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(this.jdField_c_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsRectF);
    if (f9 > f5)
    {
      f1 = f8 * f5;
      f2 = (f7 - f1) / 2.0F;
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)f2, 0, (int)f1, (int)f8);
    }
    else
    {
      f1 = f7 / f5;
      f2 = (f8 - f1) / 2.0F;
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(0, (int)f2, (int)f7, (int)f1);
    }
    if (!this.jdField_l_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(0, 0, (int)f7, (int)f8);
    }
    localObject2 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture;
    i3 = (int)f7;
    int i4 = (int)f8;
    ((YUVTexture)localObject2).a(i3, i4);
    paramGLCanvas.a(2);
    a(paramGLCanvas, i2);
    paramGLCanvas.a(i6 * 90, 0.0F, 0.0F, 1.0F);
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)this.jdField_c_of_type_AndroidGraphicsRectF.width());
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b((int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
    i7 = (int)(this.jdField_c_of_type_AndroidGraphicsRectF.left - (this.jdField_b_of_type_AndroidGraphicsRectF.width() - this.jdField_c_of_type_AndroidGraphicsRectF.width()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.left);
    i10 = (int)(this.jdField_c_of_type_AndroidGraphicsRectF.top - (this.jdField_b_of_type_AndroidGraphicsRectF.height() - this.jdField_c_of_type_AndroidGraphicsRectF.height()) / 2.0F - this.jdField_b_of_type_AndroidGraphicsRectF.top);
    localObject2 = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture;
    if (localObject2 != null) {
      ((BitmapTexture)localObject2).a(paramGLCanvas, i7, i10, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
    } else {
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, i7, i10, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
    }
    if (((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) || (i1 != 0))
    {
      this.jdField_c_of_type_Boolean = false;
      localObject2 = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FrameInfo:=<ImgWidth:=");
      localStringBuilder.append(f7);
      localStringBuilder.append(",ImgHeight:=");
      localStringBuilder.append(f8);
      localStringBuilder.append(",YUVImgAngle:=");
      localStringBuilder.append(i5);
      localStringBuilder.append(",drawUin:=");
      localStringBuilder.append(c());
      localStringBuilder.append(",mIsFillBlackEdge:=");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(",drawCounts:=");
      long l1;
      if (i1 != 0) {
        l1 = ((Long)localObject1).longValue();
      } else {
        l1 = 0L;
      }
      localStringBuilder.append(l1);
      localStringBuilder.append(",mAVSDKNotifyRotationType:=");
      localStringBuilder.append(this.jdField_k_of_type_Int);
      localStringBuilder.append(",phoneRotateAngle:=");
      localStringBuilder.append(this.jdField_l_of_type_Int);
      localStringBuilder.append(",renderRotation:=");
      localStringBuilder.append(i6);
      localStringBuilder.append(",mDstRectF.width():=");
      localStringBuilder.append(this.jdField_c_of_type_AndroidGraphicsRectF.width());
      localStringBuilder.append(",mDstRectF.height():=");
      localStringBuilder.append(this.jdField_c_of_type_AndroidGraphicsRectF.height());
      localStringBuilder.append(",uiWidth:=");
      localStringBuilder.append(i8);
      localStringBuilder.append(",uiHeight:=");
      localStringBuilder.append(i9);
      localStringBuilder.append(">");
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      if (this.jdField_a_of_type_ComTencentAvUiGLVideoView$LogInfo == null) {
        this.jdField_a_of_type_ComTencentAvUiGLVideoView$LogInfo = new GLVideoView.LogInfo();
      }
      localObject1 = this.jdField_a_of_type_ComTencentAvUiGLVideoView$LogInfo;
      localObject2 = this.jdField_c_of_type_JavaLangString;
      boolean bool4 = this.jdField_d_of_type_Boolean;
      boolean bool2;
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ((GLVideoView.LogInfo)localObject1).a((String)localObject2, bool3, bool4, bool2, bool1, i7, i10, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_b_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_b_of_type_AndroidGraphicsRectF.width(), i3, i4, this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.c(), this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.d(), f9, f5, i2, i5, this.C, i6, this.jdField_a_of_type_AndroidWidgetImageView$ScaleType.ordinal());
    }
    paramGLCanvas.c();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_n_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture != null) {
        return false;
      }
      Bitmap localBitmap = a();
      if (localBitmap == null) {
        return false;
      }
      localBitmap = a(localBitmap);
      if (localBitmap == null)
      {
        QLog.d(this.jdField_c_of_type_JavaLangString, 2, "doStartRenderFouceGround BlurBitmap failed");
        return false;
      }
      b(localBitmap);
      return true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        String str = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doStartRenderFouceGround exception e.stack ");
        localStringBuilder.append(localException.getStackTrace());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public int e()
  {
    return this.jdField_p_of_type_Int;
  }
  
  protected void e(GLCanvas paramGLCanvas)
  {
    int i2 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgWidth();
    int i3 = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.getImgHeight();
    Object localObject = super.a();
    int i4 = super.b();
    int i5 = super.c();
    int i6 = ScreenLayoutDoubleScreen.a(i3) / 2;
    int i7 = (i2 - i6) / 2;
    RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
    float f1 = i7;
    int i1 = 0;
    localRectF.set(f1, 0, i7 + i6, i3 + 0);
    this.jdField_c_of_type_AndroidGraphicsRectF.set(0.0F, ((Rect)localObject).top, i4 - ((Rect)localObject).right, i5 - ((Rect)localObject).bottom);
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)this.jdField_b_of_type_AndroidGraphicsRectF.left, (int)this.jdField_b_of_type_AndroidGraphicsRectF.top, (int)this.jdField_b_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_b_of_type_AndroidGraphicsRectF.height());
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(i2, i3);
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a((int)this.jdField_c_of_type_AndroidGraphicsRectF.width());
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.b((int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
    paramGLCanvas.a(2);
    if (!this.jdField_n_of_type_Boolean) {
      i1 = this.C;
    }
    a(paramGLCanvas, i1);
    this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramGLCanvas, (int)this.jdField_c_of_type_AndroidGraphicsRectF.left, (int)this.jdField_c_of_type_AndroidGraphicsRectF.top, (int)this.jdField_c_of_type_AndroidGraphicsRectF.width(), (int)this.jdField_c_of_type_AndroidGraphicsRectF.height());
    paramGLCanvas.c();
    paramGLCanvas = this.jdField_c_of_type_JavaLangString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("renderDoubleScreenOfPC:|");
    ((StringBuilder)localObject).append(c());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(g());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(i2);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(i3);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(i4);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(i5);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidGraphicsRectF.toString());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.jdField_c_of_type_AndroidGraphicsRectF.toString());
    AVLog.printColorLog(paramGLCanvas, ((StringBuilder)localObject).toString());
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_o_of_type_Boolean = paramBoolean;
  }
  
  public boolean e()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null)
      {
        boolean bool = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.canRender();
        return bool;
      }
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
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
  }
  
  protected void f(GLCanvas paramGLCanvas)
  {
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture != null))
    {
      this.jdField_m_of_type_Int %= 360;
      int i1 = super.b();
      int i2 = super.c();
      int i4 = this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.c();
      int i3 = this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.d();
      if (i4 <= i1) {
        i1 = i4;
      }
      if (i3 <= i2) {
        i2 = i3;
      }
      paramGLCanvas.a(2);
      this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture.a(paramGLCanvas, 0, 0, i1, i2);
      paramGLCanvas.c();
      long l1 = System.currentTimeMillis();
      if (l1 - this.jdField_a_of_type_Long >= 80L)
      {
        this.jdField_a_of_type_Long = l1;
        this.jdField_m_of_type_Int += 8;
      }
      long l2 = this.jdField_b_of_type_Long;
      if (l2 == 0L)
      {
        this.jdField_b_of_type_Long = l1;
        this.jdField_n_of_type_Int = 0;
        return;
      }
      if (l1 - l2 >= 5000L)
      {
        i1 = this.jdField_n_of_type_Int;
        if (i1 < 2)
        {
          this.jdField_b_of_type_Long = l1;
          l(i1);
          this.jdField_n_of_type_Int += 1;
        }
      }
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
  
  protected void finalize()
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
    if (this.jdField_s_of_type_Boolean)
    {
      Rect localRect = super.a();
      int i1;
      int i2;
      int i3;
      int i4;
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
        int i6 = super.b();
        int i5 = super.c();
        i3 = this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.c();
        i4 = this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.d();
        if (this.g)
        {
          i1 = this.w;
          i2 = i5 - this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.j() - this.v;
        }
        for (;;)
        {
          break;
          if (this.jdField_q_of_type_Boolean)
          {
            i1 = this.B;
            i2 = i1;
          }
          else
          {
            if (this.jdField_h_of_type_Boolean)
            {
              i1 = (i6 - i3) / 2;
              i2 = (i5 - i4) / 2;
              continue;
            }
            i1 = AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
            i2 = this.A;
          }
        }
        paramGLCanvas.a(2);
        i6 = (i3 - i6) / 2;
        i5 = (i4 - i5) / 2;
        paramGLCanvas.a(i6, i5);
        this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.a(paramGLCanvas, i1, i2, i3, i4);
        paramGLCanvas.c();
      }
    }
  }
  
  public void g(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setIsPC, isPC[");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
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
    return this.g;
  }
  
  public void h()
  {
    BitmapTexture localBitmapTexture = this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.a();
      this.jdField_a_of_type_ComTencentAvOpenglTextureBitmapTexture = null;
    }
  }
  
  public void h(int paramInt)
  {
    int i1 = this.jdField_s_of_type_Int;
    if (i1 != paramInt)
    {
      if ((i1 == 2) && (paramInt == 0)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        String str = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshMicState, uin[");
        localStringBuilder.append(c());
        localStringBuilder.append(", state[");
        localStringBuilder.append(this.jdField_s_of_type_Int);
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.d(str, 1, localStringBuilder.toString());
      }
      this.jdField_s_of_type_Int = paramInt;
      b();
    }
  }
  
  protected void h(GLCanvas paramGLCanvas)
  {
    if (this.jdField_m_of_type_Boolean)
    {
      ColorTexture localColorTexture = this.jdField_a_of_type_ComTencentAvOpenglTextureColorTexture;
      if (localColorTexture != null) {
        localColorTexture.a(paramGLCanvas, 0, 0, b(), c());
      }
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.g != paramBoolean)
    {
      this.g = paramBoolean;
      super.b();
      if (QLog.isColorLevel())
      {
        String str = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTextInBottom inBottom: ");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean h()
  {
    return this.jdField_s_of_type_Boolean;
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
    if ((this.jdField_s_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture != null))
    {
      BitmapTexture localBitmapTexture = null;
      int i1 = this.jdField_s_of_type_Int;
      if (i1 == 2) {
        localBitmapTexture = this.jdField_c_of_type_ComTencentAvOpenglTextureBitmapTexture;
      } else if (i1 == 1) {
        localBitmapTexture = this.jdField_b_of_type_ComTencentAvOpenglTextureBitmapTexture;
      }
      if (localBitmapTexture != null)
      {
        int i4 = super.b();
        int i5 = super.c();
        int i6 = localBitmapTexture.c();
        int i7 = localBitmapTexture.d();
        int i2;
        int i3;
        if (this.g)
        {
          i1 = i4 - i6 - this.v;
          i2 = i5 - this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.j() - this.v + this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.k() - i7;
          i3 = (i7 - this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.k()) / 2;
        }
        else
        {
          i1 = AIOUtils.b(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources()) + this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.c() + this.w;
          i2 = this.A + this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.k() - i7;
          i3 = Math.abs((i7 - this.jdField_a_of_type_ComTencentAvOpenglTextureStringTexture.k()) / 2);
        }
        paramGLCanvas.a(3);
        paramGLCanvas.a((i6 - i4) / 2, (i7 - i5) / 2);
        localBitmapTexture.a(paramGLCanvas, i1, i2 + i3, i6, i7);
        paramGLCanvas.c();
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.jdField_h_of_type_Boolean != paramBoolean)
    {
      this.jdField_h_of_type_Boolean = paramBoolean;
      super.b();
      if (QLog.isColorLevel())
      {
        String str = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTextInBottomCenter inBottom: ");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean i()
  {
    return this.f;
  }
  
  public void j(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_q_of_type_Int != paramInt))
    {
      this.jdField_q_of_type_Int = paramInt;
      this.jdField_i_of_type_Boolean = true;
      super.b();
      if (QLog.isColorLevel())
      {
        String str = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMaxLength maxLength: ");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.jdField_s_of_type_Boolean != paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        String str = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showText, show[");
        localStringBuilder.append(this.jdField_s_of_type_Boolean);
        localStringBuilder.append("->");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.jdField_s_of_type_Boolean = paramBoolean;
      super.b();
    }
  }
  
  public boolean j()
  {
    return this.jdField_q_of_type_Boolean;
  }
  
  public void k(int paramInt)
  {
    if (this.jdField_p_of_type_Int != paramInt)
    {
      this.jdField_p_of_type_Int = paramInt;
      this.jdField_i_of_type_Boolean = true;
      super.b();
      if (QLog.isColorLevel())
      {
        String str = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTextColor textColor: 0x");
        localStringBuilder.append(Integer.toHexString(paramInt).toUpperCase());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.jdField_e_of_type_Boolean != paramBoolean)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enableLoading loading: ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(", mLoading: ");
        localStringBuilder.append(this.jdField_e_of_type_Boolean);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.jdField_e_of_type_Boolean = paramBoolean;
      if (paramBoolean)
      {
        if (this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture == null) {
          this.jdField_c_of_type_ComTencentAvOpenglTextureBasicTexture = new ResourceTexture(this.jdField_a_of_type_AndroidContentContext, 2130842373);
        }
        localObject = a();
        if (localObject != null) {
          ((GLRootView)localObject).post(this.jdField_a_of_type_JavaLangRunnable);
        }
      }
      else
      {
        localObject = a();
        if (localObject != null) {
          ((GLRootView)localObject).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        }
        this.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Long = 0L;
        this.jdField_n_of_type_Int = 0;
      }
    }
  }
  
  public void l(boolean paramBoolean)
  {
    YUVTexture localYUVTexture = this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture;
    if (localYUVTexture != null) {
      try
      {
        localYUVTexture.flush(paramBoolean);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public void m(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_c_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNeedRenderVideo bRender: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", mNeedRenderVideo: ");
      localStringBuilder.append(this.f);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.f = paramBoolean;
    super.b();
  }
  
  public void n(boolean paramBoolean)
  {
    this.jdField_q_of_type_Boolean = paramBoolean;
    if (paramBoolean) {
      this.B = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297973);
    }
  }
  
  public void o(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture != null)
    {
      if (QLog.isColorLevel())
      {
        String str = this.jdField_c_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCameraIsBindData, uin[");
        localStringBuilder.append(c());
        localStringBuilder.append("], VideoSrcType[");
        localStringBuilder.append(g());
        localStringBuilder.append("], isBind[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentAvOpenglTextureYUVTexture.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GLVideoView
 * JD-Core Version:    0.7.0.1
 */