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
import android.opengl.GLES20;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView.ScaleType;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.Avatar2DAIDataTransformer;
import com.tencent.av.opengl.effects.PeerAvatar2DAIDataHandler;
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
  protected Context H;
  protected WeakReference<Context> I;
  protected YUVTexture J;
  protected BasicTexture K;
  protected StringTexture L;
  protected BasicTexture M;
  protected boolean N = false;
  protected boolean O = false;
  protected int P = -1;
  protected int Q = -1;
  protected boolean R = false;
  protected Matrix S;
  protected RectF T;
  protected RectF U;
  protected RectF V;
  protected int W = 0;
  protected boolean X = false;
  protected long Y = 0L;
  protected long Z = 0L;
  protected BasicTexture aA;
  int aB = 0;
  int aC = 0;
  int aD = 0;
  GLVideoView.LogInfo aE = null;
  protected boolean aF = false;
  protected boolean aG = false;
  protected boolean aH = false;
  int aI = 70;
  Runnable aJ = new GLVideoView.2(this);
  boolean aK = false;
  int aL = 0;
  private final String aM;
  private GLPaint aN;
  private PeerAvatar2DAIDataHandler aO = null;
  private GLVideoView.Avatar2DListener aP;
  private int aQ = 0;
  private boolean aR = true;
  private ImageView.ScaleType aS;
  private float aT = 1.0F;
  private float aU = 5.0F;
  private final float[] aV = new float[9];
  private Matrix aW;
  private boolean aX = false;
  private long aY = -1L;
  private long aZ = -1L;
  protected int aa = 0;
  protected boolean ab = true;
  protected boolean ac = true;
  protected boolean ad = false;
  protected boolean ae = false;
  protected boolean af = false;
  protected boolean ag = true;
  protected String ah = null;
  protected int ai = 255;
  protected float aj = 20.0F;
  protected int ak = -1;
  protected int al = 2147483647;
  boolean am = true;
  protected String an = "";
  long ao = 0L;
  protected BitmapTexture ap;
  protected boolean aq = false;
  protected int ar;
  protected ColorTexture as;
  protected int at = -1;
  protected int au = -1;
  protected int av = -1;
  protected BitmapTexture aw;
  protected BitmapTexture ax;
  protected int ay;
  protected int az;
  private int ba = 10000;
  private boolean bb = false;
  private VideoAppInterface bc;
  
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GLVideoView_");
    localStringBuilder.append(paramString);
    this.aM = localStringBuilder.toString();
    QLog.w(this.aM, 1, "create GLVideoView");
    this.bc = paramVideoAppInterface;
    this.H = paramContext.getApplicationContext();
    this.aN = new GLPaint();
    this.ay = AIOUtils.b(6.0F, paramContext.getResources());
    this.az = AIOUtils.b(10.0F, paramContext.getResources());
    if (paramBoolean)
    {
      this.J = new YuvFboTexture(this.H, this, paramString, paramLong);
      this.J.a(new GLVideoView.1(this, paramVideoAppInterface));
    }
    this.aS = ImageView.ScaleType.CENTER_INSIDE;
    this.aW = new Matrix();
    this.S = new Matrix();
    this.T = new RectF();
    this.U = new RectF();
    this.V = new RectF();
  }
  
  private void U()
  {
    if (this.bb)
    {
      if (this.aO == null) {
        this.aO = new PeerAvatar2DAIDataHandler(this.bc, R(), i());
      }
    }
    else
    {
      PeerAvatar2DAIDataHandler localPeerAvatar2DAIDataHandler = this.aO;
      if (localPeerAvatar2DAIDataHandler != null)
      {
        localPeerAvatar2DAIDataHandler.a();
        this.aO = null;
      }
    }
  }
  
  private Long V()
  {
    long l = System.currentTimeMillis();
    if (l - this.aY > this.ba)
    {
      this.aY = l;
      l = this.aZ;
      this.aZ = 0L;
      return new Long(l);
    }
    this.aZ += 1L;
    return null;
  }
  
  private boolean W()
  {
    if (this.ae) {
      return true;
    }
    if ((this.L != null) && (!TextUtils.isEmpty(this.ah)))
    {
      boolean bool2 = this.L.w();
      boolean bool1;
      if ((!this.ac) && (!this.aK) && (!this.ad)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      return bool2 != bool1;
    }
    return false;
  }
  
  private boolean X()
  {
    return (!this.ac) && (!this.aK) && (!this.ad);
  }
  
  static Pair<Integer, Integer> a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 1) {
      paramInt1 = paramInt3 - paramInt1;
    }
    int i;
    for (;;)
    {
      paramInt3 = paramInt2;
      i = paramInt1;
      break;
      if (paramInt5 == 2)
      {
        paramInt3 -= paramInt1;
        i = paramInt4 - paramInt2;
        break;
      }
      paramInt3 = paramInt1;
      i = paramInt2;
      if (paramInt5 != 3) {
        break;
      }
      paramInt2 = paramInt4 - paramInt2;
    }
    return new Pair(Integer.valueOf(paramInt3), Integer.valueOf(i));
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
    int m;
    int n;
    if (paramInt2 < 0)
    {
      m = -paramInt2;
      n = 1;
    }
    else
    {
      n = 0;
      m = paramInt2;
    }
    int i1;
    int i2;
    if (paramInt1 < 0)
    {
      i1 = -paramInt1;
      i2 = 1;
    }
    else
    {
      i2 = 0;
      i1 = paramInt1;
    }
    int i3 = i1 * m;
    try
    {
      int[] arrayOfInt = new int[i3];
      paramInt1 = 0;
      while (paramInt1 < i3)
      {
        int i4 = paramInt1 / i1;
        paramInt2 = i4 / 2;
        int i = i1 / 2;
        int i5 = paramInt1 % i1;
        int j = paramInt2 * i + i5 / 2;
        paramInt2 = paramArrayOfByte[paramInt1];
        i = paramArrayOfByte[(i3 + j)];
        j = paramArrayOfByte[(i3 / 4 + i3 + j)];
        double d1 = paramInt2 & 0xFF;
        double d2 = (i & 0xFF) - 128;
        Double.isNaN(d2);
        Double.isNaN(d1);
        i = (int)(d1 + 1.8556D * d2);
        double d3 = (j & 0xFF) - 128;
        Double.isNaN(d3);
        Double.isNaN(d2);
        Double.isNaN(d1);
        j = (int)(d1 - (0.4681D * d3 + d2 * 0.1872D));
        Double.isNaN(d3);
        Double.isNaN(d1);
        int k = (int)(d1 + d3 * 1.5748D);
        if (i > 255)
        {
          paramInt2 = 255;
        }
        else
        {
          paramInt2 = i;
          if (i < 0) {
            paramInt2 = 0;
          }
        }
        if (j > 255)
        {
          i = 255;
        }
        else
        {
          i = j;
          if (j < 0) {
            i = 0;
          }
        }
        if (k > 255)
        {
          j = 255;
        }
        else
        {
          j = k;
          if (k < 0) {
            j = 0;
          }
        }
        if (n != 0) {
          k = i5 + (m - 1 - i4) * i1;
        } else {
          k = paramInt1;
        }
        i4 = k;
        if (i2 != 0) {
          i4 = k / i1 * i1 + (i1 - 1) - k % i1;
        }
        arrayOfInt[i4] = (j << 16 & 0xFF0000 | 0xFF000000 | 0xFF00 & i << 8 | paramInt2 & 0xFF);
        paramInt1 += 1;
      }
      return arrayOfInt;
    }
    catch (OutOfMemoryError paramArrayOfByte) {}
    return null;
  }
  
  static int k(int paramInt)
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
  
  private void o(int paramInt)
  {
    Object localObject1 = this.I;
    String str;
    Object localObject2;
    if (localObject1 != null)
    {
      if (((WeakReference)localObject1).get() == null) {
        return;
      }
      str = null;
      localObject1 = str;
      if (this.I.get() != null)
      {
        localObject1 = str;
        if ((this.I.get() instanceof AVActivity)) {
          localObject1 = (AVActivity)this.I.get();
        }
      }
      if ((localObject1 != null) && (((AVActivity)localObject1).K != null))
      {
        if (!(((AVActivity)localObject1).K instanceof MultiVideoCtrlLayerUIBase)) {
          return;
        }
        localObject2 = (MultiVideoCtrlLayerUIBase)((AVActivity)localObject1).K;
        localObject1 = new StringBuilder();
        str = R();
      }
    }
    label386:
    for (;;)
    {
      long l;
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
        if (((MultiVideoCtrlLayerUIBase)localObject2).h != 1) {
          break label386;
        }
        l = 0L;
        ((StringBuilder)localObject1).append(l);
        ((StringBuilder)localObject1).append(';');
        ((StringBuilder)localObject1).append(((MultiVideoCtrlLayerUIBase)localObject2).j);
        ((StringBuilder)localObject1).append(';');
        ((StringBuilder)localObject1).append(((MultiVideoCtrlLayerUIBase)localObject2).am.ap());
        if (QLog.isColorLevel())
        {
          localObject2 = this.aM;
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
          str = this.aM;
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
        l = 1L;
      }
    }
  }
  
  public String A()
  {
    return this.an;
  }
  
  public YUVTexture B()
  {
    return this.J;
  }
  
  public boolean C()
  {
    try
    {
      if (this.J != null)
      {
        boolean bool = this.J.canRender();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public boolean D()
  {
    return this.N;
  }
  
  public float E()
  {
    return this.aT;
  }
  
  public float F()
  {
    return this.aU;
  }
  
  public float G()
  {
    this.S.getValues(this.aV);
    return this.aV[0];
  }
  
  public void H()
  {
    this.ae = true;
    super.m();
  }
  
  public String I()
  {
    return this.ah;
  }
  
  public float J()
  {
    return this.aj;
  }
  
  public int K()
  {
    return this.ak;
  }
  
  public int L()
  {
    return this.al;
  }
  
  public boolean M()
  {
    return this.ac;
  }
  
  public boolean N()
  {
    return this.aX;
  }
  
  public boolean O()
  {
    return this.ab;
  }
  
  public ImageView.ScaleType P()
  {
    return this.aS;
  }
  
  public boolean Q()
  {
    return this.aK;
  }
  
  public String R()
  {
    return (String)d(0);
  }
  
  public int S()
  {
    Integer localInteger = (Integer)d(1);
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  public String T()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAG[");
    localStringBuilder.append(this.aM);
    localStringBuilder.append("], uin[");
    localStringBuilder.append(R());
    localStringBuilder.append("], VST[");
    localStringBuilder.append(S());
    localStringBuilder.append("], LRT[");
    localStringBuilder.append(w());
    localStringBuilder.append("], Drc[");
    localStringBuilder.append((int)this.V.width());
    localStringBuilder.append(", ");
    localStringBuilder.append((int)this.V.height());
    localStringBuilder.append("], Src[");
    localStringBuilder.append((int)this.U.width());
    localStringBuilder.append(", ");
    localStringBuilder.append((int)this.U.height());
    localStringBuilder.append("], ");
    localStringBuilder.append(this.J.y());
    return localStringBuilder.toString();
  }
  
  public void a(float paramFloat)
  {
    if (this.aj != paramFloat)
    {
      this.aj = paramFloat;
      this.ae = true;
      super.m();
      if (QLog.isColorLevel())
      {
        String str = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTextSize textSize: ");
        localStringBuilder.append(paramFloat);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2)
  {
    Pair localPair = a(paramInt1, paramInt2, super.g(), super.h(), this.aQ);
    this.aW.set(this.S);
    this.aW.postScale(paramFloat, paramFloat, ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
    this.aW.getValues(this.aV);
    Object localObject = this.aV;
    float f1 = localObject[0];
    float f2 = this.aT * 1.0F / 1.111111F;
    float f3 = this.aU;
    if (f1 > f2)
    {
      if (f1 >= f3 * 1.111111F) {
        return;
      }
      localObject[0] = f1;
      localObject[4] = f1;
      this.S.setValues((float[])localObject);
      if (QLog.isColorLevel())
      {
        localObject = this.aM;
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
        localStringBuilder.append(this.aQ);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
      }
      super.m();
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (paramInt == 1)
    {
      this.Y = 0L;
      this.Z = 0L;
      this.aa = 0;
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = a(paramInt1, paramInt2, 0, 0, this.aQ);
    if (QLog.isColorLevel())
    {
      String str = this.aM;
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
      localStringBuilder.append(this.aQ);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.S.getValues(this.aV);
    float f5 = this.aV[2] + ((Integer)((Pair)localObject).first).intValue();
    float f4 = this.aV[5] + ((Integer)((Pair)localObject).second).intValue();
    localObject = this.aV;
    localObject[2] = f5;
    localObject[5] = f4;
    this.S.setValues((float[])localObject);
    if (paramBoolean)
    {
      localObject = new RectF();
      this.S.mapRect((RectF)localObject, this.U);
      float f1;
      float f2;
      if ((((RectF)localObject).left < this.T.left) && (((RectF)localObject).right < this.T.right)) {
        if (((RectF)localObject).width() > this.T.width())
        {
          f1 = this.T.right;
          f2 = ((RectF)localObject).right;
        }
        else
        {
          f1 = this.T.centerX();
          f2 = ((RectF)localObject).centerX();
        }
      }
      float f3;
      for (;;)
      {
        f3 = f5 + (f1 - f2);
        break;
        if ((((RectF)localObject).left > this.T.left) && (((RectF)localObject).right > this.T.right))
        {
          if (((RectF)localObject).width() > this.T.width())
          {
            f1 = this.T.left;
            f2 = ((RectF)localObject).left;
          }
          else
          {
            f1 = this.T.centerX();
            f2 = ((RectF)localObject).centerX();
          }
        }
        else
        {
          f3 = f5;
          if (((RectF)localObject).left <= this.T.left) {
            break;
          }
          f3 = f5;
          if (((RectF)localObject).right >= this.T.right) {
            break;
          }
          f1 = this.T.centerX();
          f2 = ((RectF)localObject).centerX();
        }
      }
      if ((((RectF)localObject).top < this.T.top) && (((RectF)localObject).bottom < this.T.bottom)) {
        if (((RectF)localObject).height() > this.T.height())
        {
          f1 = this.T.bottom;
          f2 = ((RectF)localObject).bottom;
        }
        else
        {
          f1 = this.T.centerY();
          f2 = ((RectF)localObject).centerY();
        }
      }
      for (;;)
      {
        f1 = f4 + (f1 - f2);
        break;
        if ((((RectF)localObject).top > this.T.top) && (((RectF)localObject).bottom > this.T.bottom))
        {
          if (((RectF)localObject).height() > this.T.height())
          {
            f1 = this.T.top;
            f2 = ((RectF)localObject).top;
          }
          else
          {
            f1 = this.T.centerY();
            f2 = ((RectF)localObject).centerY();
          }
        }
        else
        {
          f1 = f4;
          if (((RectF)localObject).top <= this.T.top) {
            break;
          }
          f1 = f4;
          if (((RectF)localObject).bottom >= this.T.bottom) {
            break;
          }
          f1 = this.T.centerY();
          f2 = ((RectF)localObject).centerY();
        }
      }
      localObject = this.aV;
      localObject[2] = f3;
      localObject[5] = f1;
      this.S.setValues((float[])localObject);
    }
    super.m();
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if (this.R != paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        String str = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMirror, mMirror[");
        localStringBuilder.append(this.R);
        localStringBuilder.append("->");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.R = paramBoolean;
      super.m();
    }
  }
  
  public void a(Context paramContext)
  {
    this.I = new WeakReference(paramContext);
  }
  
  public void a(ImageView.ScaleType paramScaleType)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.aM;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setScaleType scaleType: ");
      localStringBuilder.append(paramScaleType);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = paramScaleType;
    if (paramScaleType == null) {
      localObject = ImageView.ScaleType.CENTER_INSIDE;
    }
    if (this.aS != localObject)
    {
      this.aS = ((ImageView.ScaleType)localObject);
      super.m();
    }
  }
  
  protected void a(GLCanvas paramGLCanvas, int paramInt)
  {
    if (this.R)
    {
      if (paramInt % 2 == 0)
      {
        paramGLCanvas.b(-1.0F, 1.0F, 1.0F);
        return;
      }
      paramGLCanvas.b(1.0F, -1.0F, 1.0F);
    }
  }
  
  public void a(GLVideoView.Avatar2DListener paramAvatar2DListener)
  {
    this.aP = paramAvatar2DListener;
  }
  
  public void a(Boolean paramBoolean)
  {
    this.aR = paramBoolean.booleanValue();
  }
  
  public void a(String paramString)
  {
    this.an = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    a(0, paramString);
    a(1, Integer.valueOf(paramInt));
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    PeerAvatar2DAIDataHandler localPeerAvatar2DAIDataHandler = this.aO;
    if (localPeerAvatar2DAIDataHandler == null) {
      return;
    }
    Avatar2DAIDataTransformer.a(localPeerAvatar2DAIDataHandler, paramArrayOfByte);
  }
  
  Bitmap b(Bitmap paramBitmap)
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
        localObject1 = this.aM;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("doStartRenderFouceGround BlurBitmap exception e.stack ");
        ((StringBuilder)localObject3).append(paramBitmap.getStackTrace());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        return localObject2;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        localObject2 = this.aM;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("doStartRenderFouceGround BlurBitmap OOM exception e.stack ");
        ((StringBuilder)localObject3).append(paramBitmap.getStackTrace());
        QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      }
    }
    return localObject1;
  }
  
  public void b(int paramInt)
  {
    int i = k(paramInt);
    this.Q = paramInt;
    if ((this.aQ != i) && (!s()))
    {
      this.aQ = i;
      this.S.reset();
      if (b() == 0) {
        super.m();
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    BitmapTexture localBitmapTexture = this.ax;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.n();
      this.ax = null;
    }
    this.ax = new BitmapTexture(UITools.a(this.H, paramInt1));
    this.ax.b(false);
    localBitmapTexture = this.aw;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.n();
      this.aw = null;
    }
    this.aw = new BitmapTexture(UITools.a(this.H, paramInt2));
    this.aw.b(false);
  }
  
  protected void b(GLCanvas paramGLCanvas)
  {
    if (!this.ab)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.aM, 1, "renderTexture, mNeedRenderVideo is false");
      }
    }
    else
    {
      YUVTexture localYUVTexture = this.J;
      if (localYUVTexture == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w(this.aM, 1, "renderTexture, mYuvTexture is null");
        }
      }
      else if ((!this.bb) && (!localYUVTexture.updateCurFrame()))
      {
        QLog.w(this.aM, 1, "renderTexture, updateCurFrame fail");
      }
      else if ((!this.bb) && (!this.J.canRender()))
      {
        QLog.w(this.aM, 1, "renderTexture, can not Render");
      }
      else
      {
        l(false);
        if ((this.N) && (this.aF)) {
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
    if (!TextUtils.equals(paramString, this.ah))
    {
      this.ah = paramString;
      this.ae = true;
      super.m();
      if (QLog.isColorLevel())
      {
        String str = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setText, text[");
        localStringBuilder.append(this.ah);
        localStringBuilder.append("->");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.aq != paramBoolean) {
      this.aq = paramBoolean;
    }
  }
  
  public void c(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    BitmapTexture localBitmapTexture = this.ap;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.n();
      this.ap = null;
    }
    this.ap = new BitmapTexture(paramBitmap);
  }
  
  protected void c(GLCanvas paramGLCanvas)
  {
    this.aR = true;
    if (!this.ab) {
      this.ab = false;
    }
    int i = super.g();
    int j = super.h();
    Rect localRect = super.e();
    int k = i - localRect.left - localRect.right;
    int m = j - localRect.top - localRect.bottom;
    paramGLCanvas.a(-i / 2, -j / 2);
    if (this.aR)
    {
      this.aN.a(-9013642);
      if (localRect.left > 0)
      {
        this.aN.a(localRect.left);
        paramGLCanvas.a(localRect.left / 2, 0.0F, localRect.left / 2, j, this.aN);
      }
      if (localRect.top > 0)
      {
        this.aN.a(localRect.top);
        paramGLCanvas.a(0.0F, localRect.top / 2, i, localRect.top / 2, this.aN);
      }
      if (localRect.right > 0)
      {
        this.aN.a(localRect.right);
        paramGLCanvas.a(i - localRect.right / 2, 0.0F, i - localRect.right / 2, j, this.aN);
      }
      if (localRect.bottom > 0)
      {
        this.aN.a(localRect.bottom);
        paramGLCanvas.a(0.0F, j - localRect.bottom / 2, i, j - localRect.bottom / 2, this.aN);
      }
    }
    paramGLCanvas.a(i / 2, j / 2);
    if (this.aR)
    {
      if (((!C()) || (!this.ab)) && (this.p != null))
      {
        this.p.a(paramGLCanvas, 0, 0, k, m);
        return;
      }
      if (!this.aF)
      {
        float f = 0;
        paramGLCanvas.a(f, f, k, m, this.r);
      }
    }
    else
    {
      if (((!C()) || (!this.ab)) && (this.p != null))
      {
        this.p.a(paramGLCanvas, 0, 0, i, j);
        return;
      }
      if (!this.aF) {
        paramGLCanvas.a(0.0F, 0.0F, i, j, this.r);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.bb = paramBoolean;
  }
  
  protected void d(GLCanvas paramGLCanvas)
  {
    if (this.Z != 0L)
    {
      this.Z = 0L;
      this.aa = 0;
    }
    Object localObject1 = V();
    int j;
    if (localObject1 != null) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject2 = super.e();
    this.ao = System.currentTimeMillis();
    int i2 = super.g();
    int i3 = super.h();
    int i1 = i2 - ((Rect)localObject2).left - ((Rect)localObject2).right;
    int m = i3 - ((Rect)localObject2).top - ((Rect)localObject2).bottom;
    boolean bool3 = s();
    int i = this.J.z();
    boolean bool1 = this.bb;
    if (bool1) {
      i = 0;
    }
    int k;
    if (((!this.aF) || (bool3)) && (!this.aG) && (!bool1)) {
      k = this.aQ;
    } else {
      k = 0;
    }
    int i4 = (i + k + 4) % 4;
    float f5 = ((Rect)localObject2).left;
    float f1 = ((Rect)localObject2).top;
    float f4 = i1;
    float f2 = m;
    int i5 = i4 % 2;
    int n;
    float f3;
    if (i5 != 0)
    {
      n = (int)f4;
      f3 = f1;
      f1 = f5;
    }
    else
    {
      f3 = f5;
      f5 = f4;
      f4 = f2;
      f2 = f5;
      n = m;
      m = i1;
    }
    localObject2 = this.T;
    float f6 = m;
    float f7 = n;
    ((RectF)localObject2).set(f3, f1, f3 + f6, f1 + f7);
    if (!bool1) {
      f6 = this.J.getImgWidth();
    }
    if (!bool1) {
      f7 = this.J.getImgHeight();
    }
    float f12 = f6 / f7;
    f5 = f2 / f4;
    if ((!this.aF) && (n(i4)) && (!this.aG) && (!bool1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    float f11 = f3;
    float f10 = f1;
    float f9 = f2;
    float f8 = f4;
    if (bool1)
    {
      if (i5 == 0)
      {
        f8 = f2 / f12;
        f5 = f8;
        if (f8 > f4)
        {
          f5 = f4 * f12;
          break label461;
        }
      }
      else
      {
        f8 = f4 * f12;
        f5 = f8;
        if (f8 <= f2) {
          break label461;
        }
        f5 = f2 / f12;
      }
      f1 += (f4 - f5) / 2.0F;
      f4 = f5;
      break label475;
      label461:
      f3 += (f2 - f5) / 2.0F;
      f2 = f5;
      label475:
      f5 = f2 / f4;
      f8 = f4;
      f9 = f2;
      f10 = f1;
      f11 = f3;
    }
    this.U.set(f11, f10, f9 + f11, f8 + f10);
    this.S.mapRect(this.V, this.U);
    if (f12 > f5)
    {
      f1 = f7 * f5;
      f2 = (f6 - f1) / 2.0F;
      this.J.a((int)f2, 0, (int)f1, (int)f7);
    }
    else
    {
      f1 = f6 / f5;
      f2 = (f7 - f1) / 2.0F;
      this.J.a(0, (int)f2, (int)f6, (int)f1);
    }
    if (!this.am) {
      this.J.a(0, 0, (int)f6, (int)f7);
    }
    localObject2 = this.J;
    i1 = (int)f6;
    i5 = (int)f7;
    ((YUVTexture)localObject2).a(i1, i5);
    paramGLCanvas.a(2);
    a(paramGLCanvas, k);
    paramGLCanvas.a(i4 * 90, 0.0F, 0.0F, 1.0F);
    this.J.a((int)this.V.width());
    this.J.b((int)this.V.height());
    int i6 = (int)(this.V.left - (this.U.width() - this.V.width()) / 2.0F - this.U.left);
    int i7 = (int)(this.V.top - (this.U.height() - this.V.height()) / 2.0F - this.U.top);
    localObject2 = this.ap;
    if (localObject2 != null)
    {
      ((BitmapTexture)localObject2).a(paramGLCanvas, i6, i7, (int)this.V.width(), (int)this.V.height());
    }
    else
    {
      U();
      this.J.a(this.bb);
      if (this.bb)
      {
        localObject2 = this.aO;
        if ((localObject2 != null) && (m != 0) && (n != 0))
        {
          m = ((PeerAvatar2DAIDataHandler)localObject2).b(m, n);
          localObject2 = this.aP;
          if (localObject2 != null) {
            ((GLVideoView.Avatar2DListener)localObject2).ay_();
          }
          if (m != -1) {
            this.J.c(m);
          }
          GLES20.glViewport(0, 0, paramGLCanvas.b(), paramGLCanvas.c());
        }
      }
      this.J.a(paramGLCanvas, i6, i7, (int)this.V.width(), (int)this.V.height());
    }
    if (((this.N) && (this.O)) || (j != 0))
    {
      this.O = false;
      localObject2 = this.aM;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FrameInfo:=<ImgWidth:=");
      localStringBuilder.append(f6);
      localStringBuilder.append(",ImgHeight:=");
      localStringBuilder.append(f7);
      localStringBuilder.append(",YUVImgAngle:=");
      localStringBuilder.append(i);
      localStringBuilder.append(",drawUin:=");
      localStringBuilder.append(R());
      localStringBuilder.append(",mIsFillBlackEdge:=");
      localStringBuilder.append(this.N);
      localStringBuilder.append(",drawCounts:=");
      long l;
      if (j != 0) {
        l = ((Long)localObject1).longValue();
      } else {
        l = 0L;
      }
      localStringBuilder.append(l);
      localStringBuilder.append(",mAVSDKNotifyRotationType:=");
      localStringBuilder.append(this.P);
      localStringBuilder.append(",phoneRotateAngle:=");
      localStringBuilder.append(this.Q);
      localStringBuilder.append(",renderRotation:=");
      localStringBuilder.append(i4);
      localStringBuilder.append(",mDstRectF.width():=");
      localStringBuilder.append(this.V.width());
      localStringBuilder.append(",mDstRectF.height():=");
      localStringBuilder.append(this.V.height());
      localStringBuilder.append(",uiWidth:=");
      localStringBuilder.append(i2);
      localStringBuilder.append(",uiHeight:=");
      localStringBuilder.append(i3);
      localStringBuilder.append(">");
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      if (this.aE == null) {
        this.aE = new GLVideoView.LogInfo();
      }
      localObject1 = this.aE;
      localObject2 = this.aM;
      boolean bool4 = this.R;
      boolean bool2;
      if (this.ap != null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ((GLVideoView.LogInfo)localObject1).a((String)localObject2, bool3, bool4, bool2, bool1, i6, i7, (int)this.V.width(), (int)this.V.width(), (int)this.U.width(), (int)this.U.width(), i1, i5, this.J.f(), this.J.g(), f12, f5, k, i, this.aQ, i4, this.aS.ordinal());
    }
    paramGLCanvas.g();
  }
  
  public void d(boolean paramBoolean)
  {
    this.am = paramBoolean;
  }
  
  protected void e(GLCanvas paramGLCanvas)
  {
    int j = this.J.getImgWidth();
    int k = this.J.getImgHeight();
    Object localObject = super.e();
    int m = super.g();
    int n = super.h();
    int i1 = ScreenLayoutDoubleScreen.b(k) / 2;
    int i2 = (j - i1) / 2;
    RectF localRectF = this.U;
    float f = i2;
    int i = 0;
    localRectF.set(f, 0, i2 + i1, k + 0);
    this.V.set(0.0F, ((Rect)localObject).top, m - ((Rect)localObject).right, n - ((Rect)localObject).bottom);
    this.J.a((int)this.U.left, (int)this.U.top, (int)this.U.width(), (int)this.U.height());
    this.J.a(j, k);
    this.J.a((int)this.V.width());
    this.J.b((int)this.V.height());
    paramGLCanvas.a(2);
    if (!this.aF) {
      i = this.aQ;
    }
    a(paramGLCanvas, i);
    this.J.a(paramGLCanvas, (int)this.V.left, (int)this.V.top, (int)this.V.width(), (int)this.V.height());
    paramGLCanvas.g();
    paramGLCanvas = this.aM;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("renderDoubleScreenOfPC:|");
    ((StringBuilder)localObject).append(R());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(S());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(m);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(n);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.U.toString());
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(this.V.toString());
    AVLog.printColorLog(paramGLCanvas, ((StringBuilder)localObject).toString());
  }
  
  public void e(boolean paramBoolean)
  {
    this.aF = paramBoolean;
  }
  
  protected void f(GLCanvas paramGLCanvas)
  {
    if ((this.X) && (this.K != null))
    {
      this.W %= 360;
      int i = super.g();
      int j = super.h();
      int m = this.K.f();
      int k = this.K.g();
      if (m <= i) {
        i = m;
      }
      if (k <= j) {
        j = k;
      }
      paramGLCanvas.a(2);
      this.K.a(paramGLCanvas, 0, 0, i, j);
      paramGLCanvas.g();
      long l1 = System.currentTimeMillis();
      if (l1 - this.Y >= 80L)
      {
        this.Y = l1;
        this.W += 8;
      }
      long l2 = this.Z;
      if (l2 == 0L)
      {
        this.Z = l1;
        this.aa = 0;
        return;
      }
      if (l1 - l2 >= 5000L)
      {
        i = this.aa;
        if (i < 2)
        {
          this.Z = l1;
          o(i);
          this.aa += 1;
        }
      }
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.aG = paramBoolean;
  }
  
  protected void finalize()
  {
    try
    {
      if (this.M != null)
      {
        this.M.n();
        this.M = null;
      }
      if (this.L != null)
      {
        this.L.n();
        this.L = null;
      }
      if (this.K != null)
      {
        this.K.n();
        this.K = null;
      }
      if (this.J != null)
      {
        this.J.n();
        this.J = null;
      }
      if (this.ap != null)
      {
        this.ap.n();
        this.ap = null;
      }
      if (this.aA != null)
      {
        this.aA.n();
        this.aA = null;
      }
      this.aJ = null;
      this.X = false;
      this.aX = false;
      this.ah = null;
      if (this.aO != null)
      {
        this.aO.a();
        this.aO = null;
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  protected void g(GLCanvas paramGLCanvas)
  {
    if (this.aX)
    {
      Rect localRect = super.e();
      int i;
      int j;
      int k;
      int m;
      if (this.M != null)
      {
        i = super.g();
        super.h();
        j = localRect.left;
        k = localRect.right;
        m = localRect.left;
        m = localRect.bottom;
        this.M.a(paramGLCanvas, 0, 0, i - j - k, 36);
      }
      if (W())
      {
        if (this.L == null) {
          this.L = new StringTexture();
        }
        this.L.n();
        this.L.a(this.ah);
        this.L.a(this.aj);
        this.L.c(this.ak);
        this.L.d(this.al);
        this.L.e(super.g() - this.az);
        this.L.a(X());
        this.L.z();
        this.ae = false;
      }
      if ((this.L != null) && (!TextUtils.isEmpty(this.ah)))
      {
        int i1 = super.g();
        int n = super.h();
        k = this.L.f();
        m = this.L.g();
        if (this.ac)
        {
          i = this.az;
          j = n - this.L.x() - this.ay;
        }
        for (;;)
        {
          break;
          if (this.aK)
          {
            i = this.aL;
            j = i;
          }
          else
          {
            if (this.ad)
            {
              i = (i1 - k) / 2;
              j = (n - m) / 2;
              continue;
            }
            i = AIOUtils.b(16.0F, this.H.getResources());
            j = this.aI;
          }
        }
        this.L.a(X());
        paramGLCanvas.a(2);
        i1 = (k - i1) / 2;
        n = (m - n) / 2;
        paramGLCanvas.a(i1, n);
        this.L.a(paramGLCanvas, i, j, k, m);
        paramGLCanvas.g();
      }
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.aH = paramBoolean;
  }
  
  public void h(int paramInt)
  {
    if (this.ar != paramInt) {
      this.as = new ColorTexture(paramInt);
    }
  }
  
  protected void h(GLCanvas paramGLCanvas)
  {
    if (this.aq)
    {
      ColorTexture localColorTexture = this.as;
      if (localColorTexture != null) {
        localColorTexture.a(paramGLCanvas, 0, 0, g(), h());
      }
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.aM;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setIsPC, isPC[");
      localStringBuilder.append(this.N);
      localStringBuilder.append("->");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    this.N = paramBoolean;
    if (this.N) {
      this.O = true;
    }
    this.S.reset();
    super.m();
  }
  
  public void i(int paramInt)
  {
    int i = this.at;
    if (i != paramInt)
    {
      if ((i == 2) && (paramInt == 0)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        String str = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshMicState, uin[");
        localStringBuilder.append(R());
        localStringBuilder.append(", state[");
        localStringBuilder.append(this.at);
        localStringBuilder.append("->");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.d(str, 1, localStringBuilder.toString());
      }
      this.at = paramInt;
      m();
    }
  }
  
  protected void i(GLCanvas paramGLCanvas)
  {
    if ((this.aX) && (this.L != null))
    {
      BitmapTexture localBitmapTexture = null;
      int i = this.at;
      if (i == 2) {
        localBitmapTexture = this.ax;
      } else if (i == 1) {
        localBitmapTexture = this.aw;
      }
      if (localBitmapTexture != null)
      {
        int m = super.g();
        int n = super.h();
        int i1 = localBitmapTexture.f();
        int i2 = localBitmapTexture.g();
        int j;
        int k;
        if (this.ac)
        {
          i = m - i1 - this.ay;
          j = n - this.L.x() - this.ay + this.L.y() - i2;
          k = (i2 - this.L.y()) / 2;
        }
        else
        {
          i = AIOUtils.b(16.0F, this.H.getResources()) + this.L.f() + this.az;
          j = this.aI + this.L.y() - i2;
          k = Math.abs((i2 - this.L.y()) / 2);
        }
        int i3 = AIOUtils.b(1.5F, this.H.getResources());
        paramGLCanvas.a(3);
        paramGLCanvas.a((i1 - m) / 2, (i2 - n) / 2);
        localBitmapTexture.a(paramGLCanvas, i, i3 + (j + k), i1, i2);
        paramGLCanvas.g();
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    if (this.ac != paramBoolean)
    {
      this.ac = paramBoolean;
      super.m();
      if (QLog.isColorLevel())
      {
        String str = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTextInBottom inBottom: ");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void j(int paramInt)
  {
    this.aI = paramInt;
  }
  
  public void j(boolean paramBoolean)
  {
    if (this.ad != paramBoolean)
    {
      this.ad = paramBoolean;
      super.m();
      if (QLog.isColorLevel())
      {
        String str = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTextInBottomCenter inBottom: ");
        localStringBuilder.append(paramBoolean);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void k(boolean paramBoolean)
  {
    if (this.aX != paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        String str = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showText, show[");
        localStringBuilder.append(this.aX);
        localStringBuilder.append("->");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.aX = paramBoolean;
      super.m();
    }
  }
  
  public void l(int paramInt)
  {
    if ((paramInt > 0) && (this.al != paramInt))
    {
      this.al = paramInt;
      this.ae = true;
      super.m();
      if (QLog.isColorLevel())
      {
        String str = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setMaxLength maxLength: ");
        localStringBuilder.append(paramInt);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void l(boolean paramBoolean)
  {
    if (this.X != paramBoolean)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enableLoading loading: ");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append(", mLoading: ");
        localStringBuilder.append(this.X);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.X = paramBoolean;
      if (paramBoolean)
      {
        if (this.K == null) {
          this.K = new ResourceTexture(this.H, 2130843319);
        }
        localObject = i();
        if (localObject != null) {
          ((GLRootView)localObject).post(this.aJ);
        }
      }
      else
      {
        localObject = i();
        if (localObject != null) {
          ((GLRootView)localObject).removeCallbacks(this.aJ);
        }
        this.Y = 0L;
        this.Z = 0L;
        this.aa = 0;
      }
    }
  }
  
  public void m(int paramInt)
  {
    if (this.ak != paramInt)
    {
      this.ak = paramInt;
      this.ae = true;
      super.m();
      if (QLog.isColorLevel())
      {
        String str = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setTextColor textColor: 0x");
        localStringBuilder.append(Integer.toHexString(paramInt).toUpperCase());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void m(boolean paramBoolean)
  {
    YUVTexture localYUVTexture = this.J;
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
  
  public void n(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.aM;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setNeedRenderVideo bRender: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", mNeedRenderVideo: ");
      localStringBuilder.append(this.ab);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.ab = paramBoolean;
    super.m();
  }
  
  protected boolean n(int paramInt)
  {
    int i = S();
    if (this.aS == ImageView.ScaleType.CENTER_INSIDE)
    {
      if (this.N) {
        return true;
      }
      if ((paramInt % 2 == 0) && (!this.aH)) {
        return true;
      }
    }
    else if ((this.aS == ImageView.ScaleType.CENTER_CROP) && (i == 2))
    {
      return true;
    }
    return false;
  }
  
  protected void o()
  {
    GLRootView localGLRootView = i();
    if (localGLRootView != null) {
      localGLRootView.removeCallbacks(this.aJ);
    }
    super.o();
  }
  
  public void o(boolean paramBoolean)
  {
    this.aK = paramBoolean;
    if (paramBoolean) {
      this.aL = this.H.getResources().getDimensionPixelSize(2131298643);
    }
  }
  
  public void p(boolean paramBoolean)
  {
    if (this.J != null)
    {
      if (QLog.isColorLevel())
      {
        String str = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setCameraIsBindData, uin[");
        localStringBuilder.append(R());
        localStringBuilder.append("], VideoSrcType[");
        localStringBuilder.append(S());
        localStringBuilder.append("], isBind[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.J.b(paramBoolean);
    }
  }
  
  protected void q()
  {
    this.b = null;
  }
  
  public boolean s()
  {
    return this.an.equals(R());
  }
  
  public Context t()
  {
    return (Context)this.I.get();
  }
  
  public Bitmap u()
  {
    Object localObject1 = this.J.s();
    Object localObject5 = null;
    Object localObject4 = null;
    if (localObject1 == null)
    {
      QLog.d(this.aM, 2, "getFrameBitmap  get last frame failed");
      return null;
    }
    int i = this.J.t();
    int j = this.J.u();
    int k = this.J.A();
    YuvImage localYuvImage;
    if (k == 0)
    {
      localObject1 = a((byte[])localObject1, i, j);
      if (localObject1 == null)
      {
        localObject1 = this.aM;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getFrameBitmap  I420toARGB failed, type=");
        ((StringBuilder)localObject3).append(k);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        return null;
      }
      try
      {
        localObject1 = Bitmap.createBitmap((int[])localObject1, i, j, Bitmap.Config.ARGB_8888);
      }
      catch (Exception localException)
      {
        localObject3 = this.aM;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("getFrameBitmap exception e.stack ");
        ((StringBuilder)localObject4).append(localException.getStackTrace());
        QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localObject3 = this.aM;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("getFrameBitmap OOM exception e.stack ");
        ((StringBuilder)localObject4).append(localOutOfMemoryError1.getStackTrace());
        QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      localObject2 = null;
      if (localObject2 == null)
      {
        QLog.d(this.aM, 2, "getFrameBitmap createBitmap failed");
        return null;
      }
    }
    else
    {
      localYuvImage = new YuvImage((byte[])localObject2, 17, i, j, null);
      localObject2 = localObject4;
      localObject3 = localObject5;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject2 = localObject4;
      localObject3 = localObject5;
      localYuvImage.compressToJpeg(new Rect(0, 0, i, j), 100, localByteArrayOutputStream);
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
    QLog.d(this.aM, 1, "getFrameBitmap YuvImage close failed OOM");
    Object localObject2 = localObject3;
    break label392;
    label381:
    QLog.d(this.aM, 1, "getFrameBitmap YuvImage close failed");
    label392:
    Object localObject3 = this.aM;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("getFrameBitmap nWidth=");
    ((StringBuilder)localObject4).append(i);
    ((StringBuilder)localObject4).append(", nHeight=");
    ((StringBuilder)localObject4).append(j);
    QLog.d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
    return localObject2;
  }
  
  public boolean v()
  {
    try
    {
      if (this.ap != null) {
        return false;
      }
      Bitmap localBitmap = u();
      if (localBitmap == null) {
        return false;
      }
      localBitmap = b(localBitmap);
      if (localBitmap == null)
      {
        QLog.d(this.aM, 2, "doStartRenderFouceGround BlurBitmap failed");
        return false;
      }
      c(localBitmap);
      return true;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        String str = this.aM;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doStartRenderFouceGround exception e.stack ");
        localStringBuilder.append(localException.getStackTrace());
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  public long w()
  {
    if ((s()) && (S() == 2)) {
      return System.currentTimeMillis();
    }
    return this.ao;
  }
  
  public void x()
  {
    BitmapTexture localBitmapTexture = this.ap;
    if (localBitmapTexture != null)
    {
      localBitmapTexture.n();
      this.ap = null;
    }
  }
  
  public void y()
  {
    PeerAvatar2DAIDataHandler localPeerAvatar2DAIDataHandler = this.aO;
    if (localPeerAvatar2DAIDataHandler != null)
    {
      localPeerAvatar2DAIDataHandler.a();
      c(false);
      this.aO = null;
    }
  }
  
  public boolean z()
  {
    return this.bb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GLVideoView
 * JD-Core Version:    0.7.0.1
 */