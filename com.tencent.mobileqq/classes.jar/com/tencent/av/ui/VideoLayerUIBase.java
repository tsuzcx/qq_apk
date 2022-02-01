package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.av.VideoConstants;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLViewGroup;
import com.tencent.av.ui.funchat.magicface.MagicfaceViewProxy;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.GLTextureCopy;
import com.tencent.av.utils.UITools;
import com.tencent.av.wtogether.gles.WatchTogetherVideoBgRender;
import com.tencent.av.wtogether.gles.WatchTogetherVideoRenderHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Observable;
import mqq.os.MqqHandler;

public class VideoLayerUIBase
  extends GLViewGroup
  implements GLVideoView.Avatar2DListener
{
  private boolean I = false;
  private RenderBuffer J;
  private GLTextureCopy K;
  private TextureRender L;
  private boolean M = false;
  private float[] N = null;
  private long O = 0L;
  private int P = 0;
  private Rect Q = new Rect();
  private boolean R = false;
  final String U;
  protected boolean V = false;
  protected boolean W = false;
  protected Context X = null;
  public VideoAppInterface Y = null;
  protected VideoController Z = null;
  protected View aa = null;
  protected int ab = 0;
  protected int ac = 0;
  protected GLRootView ad = null;
  public GLVideoView[] ae = null;
  protected GLVideoView af;
  protected int ag = 0;
  public int ah = -1;
  protected ImageView ai = null;
  protected ScreenLayout aj;
  protected VideoLayerUIBase.MyDataObserver ak;
  protected QavVideoRecordUICtrl al = null;
  protected WatchTogetherVideoRenderHelper am;
  protected WatchTogetherVideoBgRender an;
  protected BitmapTexture ao;
  protected Runnable ap = new VideoLayerUIBase.1(this);
  protected Runnable aq = new VideoLayerUIBase.2(this);
  protected int ar = 0;
  protected int as = 0;
  protected int at = 2;
  protected int au = 0;
  protected Display av;
  long aw = 0L;
  MagicfaceViewProxy ax = null;
  
  public VideoLayerUIBase(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    super(paramContext);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(AudioHelper.c());
    this.U = ((StringBuilder)localObject).toString();
    localObject = this.U;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate:");
    localStringBuilder.append(this);
    localStringBuilder.append(", VideoAppInterface:");
    localStringBuilder.append(paramVideoAppInterface);
    localStringBuilder.append(", rootView:");
    localStringBuilder.append(paramView);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    this.Y = paramVideoAppInterface;
    this.Z = this.Y.b();
    this.X = paramContext;
    this.aa = paramView;
    this.av = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.ai = ((ImageView)this.aa.findViewById(2131428975));
    this.ak = new VideoLayerUIBase.MyDataObserver(this);
    this.Y.a(this.ak);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    Object[] arrayOfObject = (Object[])paramObject;
    int j = 0;
    switch (((Integer)arrayOfObject[0]).intValue())
    {
    default: 
      a(paramObservable, paramObject);
      return;
    case 6102: 
      if (this.Y.d(3))
      {
        ae();
        this.ax.a((ViewGroup)this.aa);
        return;
      }
      break;
    case 6101: 
      if (this.Y.d(3))
      {
        ae();
        paramObservable = (String)arrayOfObject[1];
        paramObject = (Boolean)arrayOfObject[2];
        this.ax.a((ViewGroup)this.aa, paramObservable, paramObject.booleanValue());
        return;
      }
      break;
    case 6100: 
      paramObservable = (ControlUIObserver.RequestPlayMagicFace)ControlUIObserver.a(arrayOfObject);
      paramObject = (FaceItem)((EffectFaceManager)this.Y.c(3)).b(paramObservable.b);
      int i = j;
      if (paramObject != null)
      {
        i = j;
        if (paramObject.isInteract()) {
          i = 1;
        }
      }
      if ((V()) || (i == 0))
      {
        ae();
        this.ax.a(paramObservable.a(), (ViewGroup)this.aa, paramObservable);
      }
      break;
    }
  }
  
  public static boolean b(SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.g;
    boolean bool = true;
    if (i != 1)
    {
      if (paramSessionInfo.g == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean c(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo.g == 3) || (paramSessionInfo.g == 4);
  }
  
  protected void A()
  {
    this.ad = ((GLRootView)this.aa.findViewById(2131428976));
    this.ad.setContentPane(this);
  }
  
  protected void C()
  {
    this.ae = new GLVideoView[MultiVideoCtrlLayerUIBase.e];
    int j = AIOUtils.b(VideoConstants.u + VideoConstants.v, this.X.getResources());
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(this.X);
    }
    j = i;
    if (VideoConstants.y) {
      j = i + 25;
    }
    i = 0;
    for (;;)
    {
      GLVideoView[] arrayOfGLVideoView = this.ae;
      if (i >= arrayOfGLVideoView.length) {
        break;
      }
      arrayOfGLVideoView[i] = new GLVideoView(this.X, this.Y, String.format("%s_%s", new Object[] { this.U, Integer.valueOf(i) }), this.Z.ay());
      this.ae[i].a(this.X);
      this.ae[i].a(1);
      this.ae[i].i(-1);
      this.ae[i].b(2130843160, 2130843159);
      this.ae[i].e(this.aj.e());
      this.ae[i].a(this);
      if (i == 0)
      {
        this.ae[i].c(i * 2);
      }
      else
      {
        arrayOfGLVideoView = this.ae;
        arrayOfGLVideoView[i].c((arrayOfGLVideoView.length - i) * 2);
      }
      this.ae[i].j(j);
      a(this.ae[i]);
      i += 1;
    }
  }
  
  public void E()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy, mDestroyed[");
      localStringBuilder.append(this.R);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    this.R = true;
    this.Y.b(this.ak);
    this.Y.a().removeCallbacks(this.aq);
    this.ad.setOnTouchListener(null);
    this.ad.setContentPane(null);
    super.v();
    int i = 0;
    for (;;)
    {
      localObject = this.ae;
      if (i >= localObject.length) {
        break;
      }
      localObject[i].a(1);
      this.ae[i].n(true);
      this.ae[i].l(false);
      this.ae[i].h(false);
      this.ae[i].m(true);
      this.ae[i].a(null);
      i += 1;
    }
    this.Y = null;
    this.Z = null;
    this.ai = null;
    this.X = null;
    this.aa = null;
    this.ad = null;
    this.ae = null;
  }
  
  public void G()
  {
    GLRootView localGLRootView = this.ad;
    if (localGLRootView != null) {
      localGLRootView.onResume();
    }
    a(this.as, false);
  }
  
  protected void O() {}
  
  public void S()
  {
    GLRootView localGLRootView = this.ad;
    if (localGLRootView != null) {
      localGLRootView.setVisibility(0);
    }
  }
  
  public void T()
  {
    GLRootView localGLRootView = this.ad;
    if (localGLRootView != null) {
      localGLRootView.setVisibility(8);
    }
  }
  
  String U()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[");
    ((StringBuilder)localObject1).append(this.U);
    ((StringBuilder)localObject1).append("]VideoView[5]:\r\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 0;
    for (;;)
    {
      Object localObject2 = this.ae;
      if (i >= localObject2.length) {
        break;
      }
      localObject2 = localObject2[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("---------index[");
      localStringBuilder.append(i);
      localStringBuilder.append("], size[");
      localStringBuilder.append(((GLVideoView)localObject2).g());
      localStringBuilder.append(", ");
      localStringBuilder.append(((GLVideoView)localObject2).h());
      localStringBuilder.append("], ");
      localStringBuilder.append(((GLVideoView)localObject2).T());
      localStringBuilder.append("\r\n");
      localObject1 = localStringBuilder.toString();
      i += 1;
    }
    return localObject1;
  }
  
  public boolean V()
  {
    if (X()) {
      return false;
    }
    return this.aj.e();
  }
  
  public void W()
  {
    GLRootView localGLRootView = this.ad;
    if (localGLRootView != null) {
      localGLRootView.onPause();
    }
  }
  
  public boolean X()
  {
    return this.R;
  }
  
  protected boolean Y()
  {
    String str = this.Y.getCurrentAccountUin();
    Object localObject = this.ae[0];
    boolean bool;
    if ((((GLVideoView)localObject).b() == 0) && (str.equals(((GLVideoView)localObject).R()))) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      str = this.U;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isLocalFront: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    b(String.format("isLocalFront, self isLocalFront[%s]", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  protected boolean Z()
  {
    Object localObject1 = this.Y.getCurrentAccountUin();
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    for (;;)
    {
      Object localObject2 = this.ae;
      bool1 = bool2;
      if (i >= localObject2.length) {
        break;
      }
      localObject2 = localObject2[i];
      if ((((GLVideoView)localObject2).b() == 0) && (!((String)localObject1).equals(((GLVideoView)localObject2).R())))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("isRemoteHasVideo, peer isRemoteHasVideo[");
    ((StringBuilder)localObject1).append(bool1);
    ((StringBuilder)localObject1).append("]");
    b(((StringBuilder)localObject1).toString());
    return bool1;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int j = this.X.getApplicationContext().getResources().getDimensionPixelSize(2131300026);
    int i = this.X.getApplicationContext().getResources().getDimensionPixelSize(2131300027);
    paramInt2 = paramInt4 - paramInt2;
    paramInt4 = 0;
    if (paramInt2 > j) {
      paramInt2 = 1;
    } else if (paramInt2 < -j) {
      paramInt2 = 2;
    } else {
      paramInt2 = 0;
    }
    paramInt5 -= paramInt3;
    if (paramInt5 > i)
    {
      paramInt3 = 1;
    }
    else
    {
      paramInt3 = paramInt4;
      if (paramInt5 < -i) {
        paramInt3 = 2;
      }
    }
    paramInt4 = ad();
    if (paramInt4 == 3) {
      if (paramInt1 != 1) {}
    }
    for (;;)
    {
      return 3;
      if ((paramInt1 != 2) && (paramInt1 != 4))
      {
        if (paramInt1 != 3) {
          break label320;
        }
        if (paramInt2 == 2)
        {
          if (paramInt3 != 2) {
            break label279;
          }
          return 1;
        }
        if (paramInt3 == 2)
        {
          break label171;
          if (paramInt4 == 2) {
            if (paramInt1 != 1) {}
          }
          label171:
          do
          {
            do
            {
              do
              {
                return 2;
              } while ((paramInt1 == 3) || (paramInt1 == 4));
              if (paramInt1 != 2) {
                break label320;
              }
              if (paramInt2 == 2)
              {
                if (paramInt3 != 1) {
                  break label320;
                }
                break;
              }
            } while (paramInt3 != 1);
            break;
            if (paramInt4 != 1) {
              break label268;
            }
            if (paramInt1 == 2) {
              return 1;
            }
            if (paramInt1 == 3) {
              return 1;
            }
            if (paramInt1 == 4) {
              return 1;
            }
            if (paramInt1 != 1) {
              break label320;
            }
            if (paramInt2 != 1) {
              break label260;
            }
          } while (paramInt3 != 1);
        }
      }
    }
    label260:
    if (paramInt3 == 1) {
      label268:
      if (paramInt4 == 4)
      {
        if (paramInt1 == 1) {}
        label279:
        do
        {
          do
          {
            return 4;
          } while ((paramInt1 == 2) || (paramInt1 == 3));
          if (paramInt1 != 4) {
            break label320;
          }
          if (paramInt2 == 1)
          {
            if (paramInt3 != 2) {
              break;
            }
            break label171;
          }
        } while (paramInt3 != 2);
      }
    }
    label320:
    return 1;
  }
  
  protected int a(String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      int i = 0;
      for (;;)
      {
        paramString1 = this.ae;
        if (i >= paramString1.length) {
          break;
        }
        paramString1 = paramString1[i];
        if ((paramString2.equals(paramString1.R())) && (paramInt == paramString1.S()) && (paramString1.b() == 0)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(long paramLong, GLVideoView paramGLVideoView)
  {
    if ((paramGLVideoView != null) && (!paramGLVideoView.s())) {
      paramGLVideoView.a(paramLong, this.aj.e());
    }
  }
  
  @RequiresApi(api=17)
  public void a(GLCanvas paramGLCanvas)
  {
    Object localObject2 = this.al;
    Object localObject1 = null;
    int i;
    if ((localObject2 != null) && (((QavVideoRecordUICtrl)localObject2).c()))
    {
      if (!this.I)
      {
        this.I = true;
        this.J = new RenderBuffer(paramGLCanvas.b(), paramGLCanvas.c(), 33984);
        this.L = new TextureRender();
        this.M = this.al.d();
        this.K = new GLTextureCopy();
        if (this.M)
        {
          localObject2 = this.al.a(paramGLCanvas.b(), paramGLCanvas.c(), true);
          this.N = new float[16];
          Matrix.setIdentityM(this.N, 0);
          this.N[5] = (localObject2[1] * 1.0F / (paramGLCanvas.c() * localObject2[0] / paramGLCanvas.b()));
          localObject2 = this.N;
          localObject2[13] = (1.0F - localObject2[5]);
        }
        else
        {
          this.al.a(paramGLCanvas.b(), paramGLCanvas.c(), false);
        }
      }
      a(paramGLCanvas, true);
      GLES20.glBindFramebuffer(36161, 0);
      GLES20.glViewport(0, 0, paramGLCanvas.b(), paramGLCanvas.c());
      this.L.drawTexture(3553, this.J.getTexId(), null, null);
      this.J.bind();
      i = this.K.a(this.J.getWidth(), this.J.getHeight());
      this.J.unbind();
      localObject2 = this.al;
      paramGLCanvas = localObject1;
      if (this.M) {
        paramGLCanvas = this.N;
      }
      ((QavVideoRecordUICtrl)localObject2).a(3553, i, paramGLCanvas, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    if (this.I)
    {
      this.I = false;
      i = this.J.getTexId();
      this.J.destroy();
      this.J = null;
      this.L.release();
      this.L = null;
      this.N = null;
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
      this.K.a();
    }
    GLES20.glBindFramebuffer(36160, 0);
    a(paramGLCanvas, false);
    f(paramGLCanvas);
  }
  
  protected void a(GLCanvas paramGLCanvas, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.J != null))
    {
      if (!y())
      {
        this.J.bind();
        super.a(paramGLCanvas);
        this.J.unbind();
        return;
      }
      super.b(true);
      super.a(paramGLCanvas);
      super.b(false);
      return;
    }
    super.a(paramGLCanvas);
  }
  
  public void a(QavVideoRecordUICtrl paramQavVideoRecordUICtrl)
  {
    this.al = paramQavVideoRecordUICtrl;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    int i = this.ae[paramInt1].j();
    int j = this.ae[paramInt2].j();
    this.ae[paramInt1].c(j);
    this.ae[paramInt2].c(i);
    String str2;
    if (this.Z.k().g == 4)
    {
      if (paramInt1 == 0)
      {
        this.ae[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        this.ae[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
      }
      else if (paramInt2 == 0)
      {
        this.ae[paramInt1].a(ImageView.ScaleType.CENTER_INSIDE);
        this.ae[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      localObject = this.Y.getCurrentAccountUin();
      str1 = this.ae[paramInt1].R();
      str2 = this.ae[paramInt2].R();
      if (((String)localObject).equals(str1)) {
        this.ae[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
      } else if (((String)localObject).equals(str2)) {
        this.ae[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      i = this.ae[paramInt1].K();
      f1 = this.ae[paramInt1].J();
      j = this.ae[paramInt1].L();
      bool1 = this.ae[paramInt1].N();
      boolean bool2 = this.ae[paramInt1].M();
      int k = this.ae[paramInt2].K();
      f2 = this.ae[paramInt2].J();
      int m = this.ae[paramInt2].L();
      boolean bool3 = this.ae[paramInt2].N();
      boolean bool4 = this.ae[paramInt2].M();
      this.ae[paramInt1].i(bool4);
      this.ae[paramInt1].m(k);
      this.ae[paramInt1].a(f2);
      this.ae[paramInt1].l(m);
      this.ae[paramInt1].k(bool3);
      this.ae[paramInt2].i(bool2);
      this.ae[paramInt2].m(i);
      this.ae[paramInt2].a(f1);
      this.ae[paramInt2].l(j);
      this.ae[paramInt2].k(bool1);
    }
    Object localObject = this.ae;
    String str1 = localObject[paramInt1];
    localObject[paramInt1] = localObject[paramInt2];
    localObject[paramInt2] = str1;
    boolean bool1 = localObject[paramInt1].D();
    this.ae[paramInt1].h(bool1);
    bool1 = this.ae[paramInt2].D();
    this.ae[paramInt2].h(bool1);
    float f1 = UITools.a(BaseApplicationImpl.getContext(), 12.0F);
    float f2 = UITools.a(BaseApplicationImpl.getContext(), 18.0F);
    if (paramInt1 == 0) {
      this.ae[paramInt1].a(f2);
    } else {
      this.ae[paramInt1].a(f1);
    }
    if (paramInt2 == 0) {
      this.ae[paramInt2].a(f2);
    } else {
      this.ae[paramInt2].a(f1);
    }
    this.ae[0].a(0, 0, 0, 0);
    this.ae[0].c(0, 0, super.g(), super.h());
    this.ae[0].e(-15197410);
    u();
    localObject = this.ae[paramInt1].R();
    str1 = this.ae[paramInt2].R();
    if (QLog.isColorLevel())
    {
      str2 = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("swapGLVideoView, end, [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("]=[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("], [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]=[");
      localStringBuilder.append(str1);
      localStringBuilder.append("]=[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w(str2, 1, localStringBuilder.toString(), new Throwable("who call SwapGLVideoView"));
    }
    this.Y.a().post(new VideoLayerUIBase.3(this, (String)localObject, str1));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      for (;;)
      {
        Object localObject = this.ae;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if ((paramString.equals((String)((GLVideoView)localObject).d(0))) && (((GLVideoView)localObject).b() == 0)) {
          ((GLVideoView)localObject).h(paramBoolean);
        }
        i += 1;
      }
    }
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      String str = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLayout|left: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", top: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", right: ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", bottom: ");
      localStringBuilder.append(paramInt4);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    c(false);
  }
  
  public boolean aa()
  {
    int i = 0;
    Object localObject;
    boolean bool2;
    for (boolean bool1 = true;; bool1 = bool2)
    {
      localObject = this.ae;
      bool2 = bool1;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      bool2 = bool1;
      if (((GLVideoView)localObject).b() == 0)
      {
        bool1 = ((GLVideoView)localObject).v();
        bool2 = bool1;
        if (!bool1)
        {
          str = this.U;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doGlassRemoteVideo failed !!!! i=");
          localStringBuilder.append(i);
          localStringBuilder.append(", getVisibility=");
          localStringBuilder.append(((GLVideoView)localObject).b());
          QLog.d(str, 1, localStringBuilder.toString());
          bool2 = bool1;
          break;
        }
      }
      String str = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doGlassRemoteVideo i=");
      localStringBuilder.append(i);
      localStringBuilder.append(", getVisibility=");
      localStringBuilder.append(((GLVideoView)localObject).b());
      QLog.d(str, 1, localStringBuilder.toString());
      i += 1;
    }
    if (bool2)
    {
      localObject = this.ai;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        return false;
      }
    }
    else
    {
      QLog.d(this.U, 1, "doGlassRemoteVideo failed and cancel Glass");
      ab();
    }
    return false;
  }
  
  public boolean ab()
  {
    int i = 0;
    for (;;)
    {
      localObject = this.ae;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (((GLVideoView)localObject).b() == 0) {
        ((GLVideoView)localObject).x();
      }
      String str = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doCancelGlassRemoteVideo i=");
      localStringBuilder.append(i);
      localStringBuilder.append(", getVisibility=");
      localStringBuilder.append(((GLVideoView)localObject).b());
      QLog.d(str, 1, localStringBuilder.toString());
      i += 1;
    }
    Object localObject = this.ai;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    return false;
  }
  
  public int ac()
  {
    return this.at;
  }
  
  public int ad()
  {
    Rect localRect = super.f();
    int i = localRect.centerX();
    int j = localRect.centerY();
    int k = this.ae[1].f().centerX();
    int m = this.ae[1].f().centerY();
    if ((k < i) && (m < j)) {
      return 1;
    }
    if ((k < i) && (m > j)) {
      return 4;
    }
    if ((k > i) && (m < j)) {
      return 2;
    }
    if ((k > i) && (m > j)) {
      return 3;
    }
    return 0;
  }
  
  void ae()
  {
    if (this.ax == null) {
      this.ax = new MagicfaceViewProxy(this.Y, this.X);
    }
  }
  
  public void ay_()
  {
    Object localObject = this.al;
    if ((localObject != null) && (((QavVideoRecordUICtrl)localObject).c()) && (!y()))
    {
      localObject = this.J;
      if (localObject != null) {
        ((RenderBuffer)localObject).bind();
      }
    }
  }
  
  void b(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("printGLVideoView[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]\r\n");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(U());
      localObject = localStringBuilder.toString();
      QLog.d(this.U, 2, (String)localObject);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("printItemList[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]\r\n");
      localObject = ((StringBuilder)localObject).toString();
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      localObject = this.Z;
      paramString.append(((VideoController)localObject).a(((VideoController)localObject).k().bi));
      paramString = paramString.toString();
      QLog.d(this.U, 2, paramString);
    }
  }
  
  public long c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    int i = 0;
    for (;;)
    {
      Object localObject = this.ae;
      if ((localObject == null) || (i >= localObject.length)) {
        break;
      }
      localObject = localObject[i];
      if ((((GLVideoView)localObject).b() == 0) && (paramString.equals(((GLVideoView)localObject).R()))) {
        return ((GLVideoView)localObject).w();
      }
      i += 1;
    }
    return 0L;
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    String str = this.Y.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCameraOpened_");
    localStringBuilder.append(paramBoolean);
    int i = a(localStringBuilder.toString(), str, 1);
    if (i >= 0) {
      this.ae[i].a(paramLong, paramBoolean);
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  protected boolean c(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean c(String paramString, int paramInt)
  {
    int i = a("isBigView", paramString, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isBigView, uin[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], videoSrcType[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], result_index[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    b(localStringBuilder.toString());
    return i == 0;
  }
  
  protected void d(int paramInt1, int paramInt2)
  {
    int i = this.ae[paramInt1].j();
    int j = this.ae[paramInt2].j();
    this.ae[paramInt1].c(j);
    this.ae[paramInt2].c(i);
    String str2;
    if (this.Z.k().g == 4)
    {
      if (paramInt1 == 0)
      {
        this.ae[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        this.ae[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
      }
      else if (paramInt2 == 0)
      {
        this.ae[paramInt1].a(ImageView.ScaleType.CENTER_INSIDE);
        this.ae[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      localObject = this.Y.getCurrentAccountUin();
      str1 = this.ae[paramInt1].R();
      str2 = this.ae[paramInt2].R();
      if (((String)localObject).equals(str1)) {
        this.ae[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
      } else if (((String)localObject).equals(str2)) {
        this.ae[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      i = this.ae[paramInt1].K();
      f1 = this.ae[paramInt1].J();
      j = this.ae[paramInt1].L();
      bool1 = this.ae[paramInt1].N();
      boolean bool2 = this.ae[paramInt1].M();
      int k = this.ae[paramInt2].K();
      f2 = this.ae[paramInt2].J();
      int m = this.ae[paramInt2].L();
      boolean bool3 = this.ae[paramInt2].N();
      boolean bool4 = this.ae[paramInt2].M();
      this.ae[paramInt1].i(bool4);
      this.ae[paramInt1].m(k);
      this.ae[paramInt1].a(f2);
      this.ae[paramInt1].l(m);
      this.ae[paramInt1].k(bool3);
      this.ae[paramInt2].i(bool2);
      this.ae[paramInt2].m(i);
      this.ae[paramInt2].a(f1);
      this.ae[paramInt2].l(j);
      this.ae[paramInt2].k(bool1);
    }
    Object localObject = this.ae;
    String str1 = localObject[paramInt1];
    localObject[paramInt1] = localObject[paramInt2];
    localObject[paramInt2] = str1;
    boolean bool1 = localObject[paramInt1].D();
    this.ae[paramInt1].h(bool1);
    bool1 = this.ae[paramInt2].D();
    this.ae[paramInt2].h(bool1);
    float f1 = UITools.a(BaseApplicationImpl.getContext(), 12.0F);
    float f2 = UITools.a(BaseApplicationImpl.getContext(), 18.0F);
    if (paramInt1 == 0) {
      this.ae[paramInt1].a(f2);
    } else {
      this.ae[paramInt1].a(f1);
    }
    if (paramInt2 == 0) {
      this.ae[paramInt2].a(f2);
    } else {
      this.ae[paramInt2].a(f1);
    }
    c(false);
    if (this.Z.k().g == 2) {
      this.Z.k().G = Y();
    }
    if (this.Z.k().g == 4) {
      d(this.Z.k());
    }
    localObject = this.ae[paramInt1].R();
    str1 = this.ae[paramInt2].R();
    if (QLog.isColorLevel())
    {
      str2 = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchVideo, end, [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("]=[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("], [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]=[");
      localStringBuilder.append(str1);
      localStringBuilder.append("]");
      QLog.w(str2, 1, localStringBuilder.toString());
    }
    this.Y.a(new Object[] { Integer.valueOf(8005), localObject, str1 });
  }
  
  void d(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.p == 3000)
    {
      if (Y())
      {
        ReportController.b(null, "CliOper", "", "", "0X80041B3", "0X80041B3", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
      return;
    }
    if (paramSessionInfo.p == 1)
    {
      if (Y())
      {
        if (paramSessionInfo.o == 10)
        {
          ReportController.b(null, "CliOper", "", "", "0X8005939", "0X8005939", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X80046E0", "0X80046E0", 0, 0, "", "", "", "");
        return;
      }
      if (paramSessionInfo.o == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005938", "0X8005938", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80046DF", "0X80046DF", 0, 0, "", "", "", "");
    }
  }
  
  protected void d(GLCanvas paramGLCanvas) {}
  
  public void d(String paramString, int paramInt)
  {
    int i = a("showNick", paramString, paramInt);
    if (i >= 0)
    {
      paramString = this.ae[i];
      ScreenLayout localScreenLayout = this.aj;
      if ((localScreenLayout != null) && (localScreenLayout.b() == 3)) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((i == 0) && (paramInt == 0))
      {
        if ((this.ab != 0) && (this.ac != 0))
        {
          paramString.k(false);
          return;
        }
        paramString.k(true);
        return;
      }
      paramString.k(true);
    }
  }
  
  public void e(int paramInt1, int paramInt2)
  {
    Object localObject = this.X;
    if (localObject == null) {
      return;
    }
    int n = ((Context)localObject).getResources().getDimensionPixelSize(2131300025);
    int i1 = this.X.getResources().getDimensionPixelSize(2131300022);
    localObject = super.f();
    int k = ((Rect)localObject).width() - n;
    int i = ((Rect)localObject).height() - i1;
    int m = paramInt1 + this.ae[1].f().left;
    int j = paramInt2 + this.ae[1].f().top;
    if (m < 0)
    {
      paramInt1 = 0;
    }
    else
    {
      paramInt1 = m;
      if (m > k) {
        paramInt1 = k;
      }
    }
    if (j < 0)
    {
      paramInt2 = 0;
    }
    else
    {
      paramInt2 = j;
      if (j > i) {
        paramInt2 = i;
      }
    }
    this.ae[1].c(paramInt1, paramInt2, n + paramInt1, i1 + paramInt2);
  }
  
  void f(GLCanvas paramGLCanvas)
  {
    long l1 = this.aw;
    if (l1 == 0L) {
      return;
    }
    this.aw = 0L;
    if ((paramGLCanvas instanceof GLES20Canvas))
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramGLCanvas.b(), paramGLCanvas.c(), Bitmap.Config.ARGB_8888);
      long l2 = AudioHelper.d();
      paramGLCanvas.a(localBitmap, paramGLCanvas.b(), paramGLCanvas.c());
      long l3 = AudioHelper.d();
      paramGLCanvas = this.U;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryScreenShot, screenShotFlag[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], cost_nanos[");
      localStringBuilder.append(l3 - l2);
      localStringBuilder.append("]");
      QLog.w(paramGLCanvas, 1, localStringBuilder.toString());
      ThreadManager.getSubThreadHandler().post(new VideoLayerUIBase.MyRunnable(this.U, localBitmap, l1, this));
      return;
    }
    paramGLCanvas = this.Y;
    if (paramGLCanvas != null) {
      paramGLCanvas.a(new Object[] { Integer.valueOf(20001), Long.valueOf(l1), Boolean.valueOf(false), null });
    }
  }
  
  public GLRootView i()
  {
    return this.ad;
  }
  
  public void i(int paramInt)
  {
    this.Z.k().bM = paramInt;
  }
  
  public void i(long paramLong)
  {
    this.aw = paramLong;
  }
  
  protected void j(int paramInt) {}
  
  protected void q() {}
  
  protected int r(int paramInt)
  {
    if (this.ae == null) {
      return -1;
    }
    int i = paramInt;
    for (;;)
    {
      localObject = this.ae;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      j = i;
      if (TextUtils.isEmpty(((GLVideoView)localObject).R())) {
        break label66;
      }
      if (((GLVideoView)localObject).b() == 1)
      {
        j = i;
        break label66;
      }
      i += 1;
    }
    int j = -1;
    label66:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getUnusedView, start[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("], result_index[");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("]");
    b(((StringBuilder)localObject).toString());
    return j;
  }
  
  protected void r() {}
  
  public void s(int paramInt)
  {
    int i1 = this.X.getResources().getDimensionPixelSize(2131300025);
    int i2 = this.X.getResources().getDimensionPixelSize(2131300022);
    int i = this.X.getResources().getDimensionPixelSize(2131300023);
    int j = this.X.getResources().getDimensionPixelSize(2131300024);
    if (this.ac == 0) {
      j = i;
    }
    Object localObject = super.f();
    int m = this.ae[1].f().left;
    int n = this.ae[1].f().top;
    int k = 0;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            i = 0;
            j = k;
          }
          else
          {
            j = ((Rect)localObject).height() - j - i2;
          }
        }
        else
        {
          k = ((Rect)localObject).width();
          j = ((Rect)localObject).height() - j - i2;
          i = k - i - i1;
        }
      }
      else
      {
        k = ((Rect)localObject).width();
        j += this.ab;
        i = k - i - i1;
      }
    }
    else {
      j += this.ab;
    }
    localObject = new VideoLayerUIBase.MoveSmallViewAnimation(this, paramInt, m, n, i, j, null);
    this.Y.a().post((Runnable)localObject);
  }
  
  protected boolean y()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase
 * JD-Core Version:    0.7.0.1
 */