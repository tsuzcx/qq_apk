package com.tencent.avgame.gameroom.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView.ScaleType;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLView.OnTouchListener;
import com.tencent.av.opengl.ui.GLViewGroup;
import com.tencent.av.ui.GLVideoView;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gameroom.MemberVideoDisplayInfo;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl.PushDecodeMsg;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.qav.QavSDK;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qav.log.AVLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AVGameVideoLayer
  extends GLViewGroup
  implements GLView.OnTouchListener, IAVGameMediaPlayerCtrl.PushDecodeMsg
{
  protected final List<MemberVideoDisplayInfo> I = new ArrayList(8);
  protected AVGameAppInterface J;
  protected AVGameVideoView[] K = new AVGameVideoView[9];
  protected AVGameVideoView[] L = new AVGameVideoView[9];
  protected AVGameVideoView[] M = new AVGameVideoView[1];
  protected volatile Rect N = null;
  protected AVGameMediaRenderHelper O;
  UserInfoHandler P;
  protected boolean Q = false;
  private Context R;
  private boolean S = false;
  private AVGameScreenLayoutStyle T;
  private AVGameControlUI U;
  private Runnable V = new AVGameVideoLayer.1(this);
  
  public AVGameVideoLayer(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext);
    this.R = paramContext;
    this.J = paramAVGameAppInterface;
    this.P = ((UserInfoHandler)this.J.getBusinessHandler(HandlerFactory.b));
    A();
    H();
    i(2);
    this.Q = false;
  }
  
  private void A()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    int i = 0;
    AVGameVideoView[] arrayOfAVGameVideoView;
    for (;;)
    {
      arrayOfAVGameVideoView = this.K;
      if (i >= arrayOfAVGameVideoView.length) {
        break;
      }
      arrayOfAVGameVideoView[i] = new AVGameVideoView(this.R, this.J, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(i) }), 0L);
      this.K[i].a(this.R);
      this.K[i].a(localBoolean);
      this.K[i].a(1);
      this.K[i].i(-1);
      this.K[i].c(i * 2);
      a(this.K[i]);
      i += 1;
    }
    i = 0;
    for (;;)
    {
      arrayOfAVGameVideoView = this.L;
      if (i >= arrayOfAVGameVideoView.length) {
        break;
      }
      Context localContext = this.R;
      AVGameAppInterface localAVGameAppInterface = this.J;
      int j = i + 9;
      arrayOfAVGameVideoView[i] = new AVGameVideoView(localContext, localAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(j) }), 0L, false);
      this.L[i].a(this.R);
      this.L[i].a(1);
      this.L[i].a(localBoolean);
      this.L[i].i(-1);
      this.L[i].c(j * 2);
      a(this.L[i]);
      i += 1;
    }
    this.M[0] = new AVGameVideoView(this.R, this.J, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(17) }), 0L, false);
    this.M[0].c(81);
    this.M[0].a(this.R);
    this.M[0].a(localBoolean);
    this.M[0].a(1);
    a(this.M[0]);
  }
  
  private void H()
  {
    e(this.R.getResources().getColor(2131165547));
  }
  
  private void I()
  {
    AVLog.d("AVGameVideoLayer", "doResumeVideo");
    Object localObject1 = this.J.getCurrentAccountUin();
    Object localObject2 = AVGameBusinessCtrl.b().j();
    int j = 0;
    boolean bool2 = false;
    if (localObject2 != null)
    {
      Object localObject3 = new ArrayList();
      ((AVGameSession)localObject2).c((List)localObject3);
      localObject2 = ((List)localObject3).iterator();
      boolean bool1 = false;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AVGameUserInfo)((Iterator)localObject2).next();
        String str = String.valueOf(((AVGameUserInfo)localObject3).mUin);
        if (((String)localObject1).equalsIgnoreCase(String.valueOf(((AVGameUserInfo)localObject3).mUin)))
        {
          if (((AVGameUserInfo)localObject3).mVideoOn) {
            a("doResumeVideo", -1L);
          }
          if (((AVGameUserInfo)localObject3).mSubVideoOn) {
            c(true);
          }
          bool1 = true;
        }
        else
        {
          if (((AVGameUserInfo)localObject3).mVideoOn) {
            a("doResumeVideo", -1L, str, 1);
          }
          if (((AVGameUserInfo)localObject3).mSubVideoOn) {
            a("doResumeVideo", -1L, str, 2);
          }
          bool2 = true;
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doResumeVideo mNeedRequest:=");
      ((StringBuilder)localObject1).append(bool2);
      ((StringBuilder)localObject1).append(";mHasDoGoOnStage:=");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append(";mNeedReOpenCamera:=");
      ((StringBuilder)localObject1).append(this.S);
      AVLog.d("AVGameVideoLayer", ((StringBuilder)localObject1).toString());
      if (bool2)
      {
        localObject1 = this.U;
        if (localObject1 != null) {
          ((AVGameControlUI)localObject1).e();
        }
      }
    }
    else
    {
      int i = j;
      if (GameEngine.a().A())
      {
        i = j;
        if (!GameEngine.a().B()) {
          i = 1;
        }
      }
      if (i != 0) {
        c(true);
      }
    }
  }
  
  private void a(long paramLong, GLVideoView paramGLVideoView, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramGLVideoView != null)
    {
      String str = AVGameUtil.a(paramString, paramInt);
      paramGLVideoView.a(paramString, paramInt);
      paramGLVideoView.a(0);
      paramGLVideoView.a(this.J.getCurrentAccountUin());
      try
      {
        paramString = paramGLVideoView.B();
        GraphicRenderMgr.getInstance().setAccountUin(this.J.getCurrentAccountUin());
        GraphicRenderMgr.setGlRender(str, paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setGlRender[initGLVideoViewBasePara], key[");
        localStringBuilder.append(str);
        localStringBuilder.append("], debug[");
        localStringBuilder.append(paramGLVideoView.T());
        localStringBuilder.append("], videoSrcType[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], yuvTexture[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w("AVGameVideoLayer", 1, localStringBuilder.toString());
        QavSDK.a().c().a(paramLong, false, paramBoolean);
        return;
      }
      catch (UnsatisfiedLinkError paramGLVideoView)
      {
        paramGLVideoView.printStackTrace();
      }
    }
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeGLVideoView uin:=");
    localStringBuilder.append(paramString);
    AVLog.d("AVGameVideoLayer", localStringBuilder.toString());
    paramInt = a(paramString, paramInt);
    if (paramInt >= 0)
    {
      paramString = this.K[paramInt];
      paramString.a(1);
      paramString.b(null);
      paramString.n(true);
      paramString.l(false);
      paramString.h(false);
      paramString.m(true);
      paramString.a(null, 0);
      paramString.a("");
    }
  }
  
  private void a(String paramString1, long paramLong, String paramString2, int paramInt, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("closeGLVideoViewBasePara uin:=");
    ((StringBuilder)localObject).append(paramString2);
    AVLog.d("AVGameVideoLayer", ((StringBuilder)localObject).toString());
    int i = a(paramString2, paramInt);
    if (i >= 0)
    {
      paramString2 = AVGameUtil.a(paramString2, paramInt);
      localObject = GraphicRenderMgr.getInstance();
      ((IGraphicRender)localObject).flushGlRender(paramString2);
      if ((!paramBoolean) && (paramInt == 1)) {
        ((IGraphicRender)localObject).clearCameraFrames();
      }
      GraphicRenderMgr.setGlRender(paramString2, null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setGlRender[closeGLVideoViewBasePara], key[");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("], index[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], seq[");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("], from[");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("]");
      QLog.w("AVGameVideoLayer", 1, ((StringBuilder)localObject).toString());
      if (paramBoolean) {
        QavSDK.a().c().a(paramLong, true, paramBoolean);
      }
    }
  }
  
  public void B()
  {
    AVLog.d("AVGameVideoLayer", "doOnResume");
    AVGameHandler.a().c().postDelayed(this.V, 500L);
  }
  
  public void C()
  {
    AVLog.d("AVGameVideoLayer", "doOnStop");
    String str = this.J.getCurrentAccountUin();
    AVGameVideoView[] arrayOfAVGameVideoView = this.K;
    int k = arrayOfAVGameVideoView.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      AVGameVideoView localAVGameVideoView = arrayOfAVGameVideoView[i];
      if (localAVGameVideoView.c()) {
        if (str.equalsIgnoreCase(localAVGameVideoView.R()))
        {
          b("VideoLayer_doOnStop", -1L);
          j = 1;
        }
        else
        {
          b("VideoLayer_doOnStop", -1L, localAVGameVideoView.R(), localAVGameVideoView.S());
        }
      }
      i += 1;
    }
    c(false);
    if ((CameraUtils.a(this.R).isCameraOpened(-1L)) && (j != 0)) {
      this.S = true;
    }
    AVGameHandler.a().c().removeCallbacks(this.V);
  }
  
  public void D()
  {
    AVLog.d("AVGameVideoLayer", "doOnDestroy");
    int i = 0;
    AVGameVideoView[] arrayOfAVGameVideoView;
    for (;;)
    {
      arrayOfAVGameVideoView = this.K;
      if (i >= arrayOfAVGameVideoView.length) {
        break;
      }
      arrayOfAVGameVideoView[i].a(1);
      this.K[i].n(true);
      this.K[i].l(false);
      this.K[i].h(false);
      i += 1;
    }
    this.K = null;
    i = 0;
    for (;;)
    {
      arrayOfAVGameVideoView = this.L;
      if (i >= arrayOfAVGameVideoView.length) {
        break;
      }
      arrayOfAVGameVideoView[i].a(1);
      this.L[i].n(true);
      this.L[i].l(false);
      this.L[i].h(false);
      i += 1;
    }
    this.L = null;
    this.M = null;
    this.S = false;
    this.Q = true;
  }
  
  protected void E()
  {
    AVGameMediaRenderHelper localAVGameMediaRenderHelper = this.O;
    if (localAVGameMediaRenderHelper != null) {
      localAVGameMediaRenderHelper.a(this.N, g(), h());
    }
  }
  
  public int F()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.K;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      j = i;
      if (TextUtils.isEmpty(((GLVideoView)localObject).R())) {
        return j;
      }
      if (((GLVideoView)localObject).b() == 1) {
        return i;
      }
      i += 1;
    }
    int j = -1;
    return j;
  }
  
  public int G()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.L;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      j = i;
      if (TextUtils.isEmpty(((GLVideoView)localObject).R())) {
        return j;
      }
      if (((GLVideoView)localObject).b() == 1) {
        return i;
      }
      i += 1;
    }
    int j = -1;
    return j;
  }
  
  public int a(String paramString, int paramInt)
  {
    if (this.K == null) {
      return -1;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      for (;;)
      {
        Object localObject = this.K;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if ((paramString.equals(((GLVideoView)localObject).R())) && (paramInt == ((GLVideoView)localObject).S()) && (((GLVideoView)localObject).b() == 0)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public void a(Rect paramRect)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVideoRenderPosition, rect[");
    localStringBuilder.append(paramRect.toString());
    QLog.w("AVGameVideoLayer", 1, localStringBuilder.toString());
    this.N = paramRect;
    m();
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    h(paramGLCanvas);
    f(paramGLCanvas);
  }
  
  public void a(AVGameControlUI paramAVGameControlUI)
  {
    this.U = paramAVGameControlUI;
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openSelfVideoView, from[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    QLog.w("AVGameVideoLayer", 1, ((StringBuilder)localObject).toString());
    localObject = this.J.getCurrentAccountUin();
    int i = a((String)localObject, 1);
    if (i < 0)
    {
      i = F();
      if (i >= 0)
      {
        paramString = this.K[i];
        a(paramLong, paramString, (String)localObject, 1, false);
      }
      else
      {
        paramString = null;
      }
    }
    else
    {
      localObject = AVGameUtil.a((String)localObject, 1);
      paramString = this.K[i];
      GraphicRenderMgr.setGlRender((String)localObject, paramString.B());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[openSelfVideoView], key[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i);
      localStringBuilder.append("], forceToBigView[");
      localStringBuilder.append(false);
      localStringBuilder.append("], ");
      localStringBuilder.append(paramString.T());
      QLog.w("AVGameVideoLayer", 1, localStringBuilder.toString());
    }
    if (paramString != null)
    {
      paramString.h(false);
      paramString.l(false);
      paramString.a(paramLong, CameraUtils.a(this.R).isFrontCamera());
      paramString.n(true);
      paramString.a(0);
      paramString.a(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openRemoteVideoView, from[");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("], uin[");
    ((StringBuilder)localObject).append(paramString2);
    QLog.w("AVGameVideoLayer", 1, ((StringBuilder)localObject).toString());
    int i = a(paramString2, paramInt);
    localObject = AVGameUtil.a(paramString2, paramInt);
    if (i < 0)
    {
      i = F();
      if (i >= 0)
      {
        paramString1 = this.K[i];
        a(paramLong, paramString1, paramString2, paramInt, true);
      }
      else
      {
        paramString1 = null;
      }
    }
    else
    {
      paramString1 = this.K[i];
      GraphicRenderMgr.setGlRender((String)localObject, paramString1.B());
      paramString2 = new StringBuilder();
      paramString2.append("setGlRender[openPeerVideo], key[");
      paramString2.append((String)localObject);
      paramString2.append("], seq[");
      paramString2.append(paramLong);
      paramString2.append("], index[");
      paramString2.append(i);
      paramString2.append("], ");
      paramString2.append(paramString1.T());
      QLog.w("AVGameVideoLayer", 1, paramString2.toString());
    }
    if (paramString1 != null)
    {
      paramString1.l(true);
      paramString1.a(paramLong, false);
      paramString1.a(0);
      paramString1.a(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    AVGameMediaRenderHelper localAVGameMediaRenderHelper = this.O;
    if ((localAVGameMediaRenderHelper != null) && (!this.Q))
    {
      localAVGameMediaRenderHelper.a(paramArrayOfByte, paramInt1, paramInt2, paramLong);
      m();
    }
  }
  
  public boolean a(GLView paramGLView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(String paramString) {}
  
  public void b(String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("closeSelfVideoView, from[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    QLog.w("AVGameVideoLayer", 1, ((StringBuilder)localObject).toString());
    localObject = this.J.getCurrentAccountUin();
    if (a((String)localObject, 1) >= 0)
    {
      a(paramString, paramLong, (String)localObject, 1, false);
      a((String)localObject, 1, false);
    }
  }
  
  public void b(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeRemoteVideoView uin:=");
    localStringBuilder.append(paramString2);
    AVLog.d("AVGameVideoLayer", localStringBuilder.toString());
    if (a(paramString2, paramInt) >= 0)
    {
      a(paramString1, paramLong, paramString2, paramInt, true);
      a(paramString2, paramInt, true);
    }
  }
  
  public void c(String paramString) {}
  
  public void c(boolean paramBoolean)
  {
    AVGameMediaRenderHelper localAVGameMediaRenderHelper = this.O;
    if (localAVGameMediaRenderHelper != null) {
      localAVGameMediaRenderHelper.a(paramBoolean);
    }
    m();
  }
  
  public void d(String paramString) {}
  
  protected void f(GLCanvas paramGLCanvas)
  {
    super.a(paramGLCanvas);
    E();
  }
  
  protected void h(GLCanvas paramGLCanvas)
  {
    paramGLCanvas = this.T;
    if (paramGLCanvas != null) {
      paramGLCanvas.a(this.K, this.L, g(), h(), this.I);
    }
    paramGLCanvas = this.K;
    int j = paramGLCanvas.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramGLCanvas[i];
      if ((localObject.c()) && (localObject.S() == 2) && (localObject.h() == 0)) {
        localObject.b((g() - 640) / 2, 40, (g() + 640) / 2, 520);
      }
      i += 1;
    }
  }
  
  public void i(int paramInt)
  {
    this.T = AVGameScreenLayoutStyle.a(paramInt, this.R, this.J);
  }
  
  public void q()
  {
    this.O = new AVGameMediaRenderHelper();
    this.O.a(g(), h());
  }
  
  public void r()
  {
    AVGameMediaRenderHelper localAVGameMediaRenderHelper = this.O;
    if (localAVGameMediaRenderHelper != null)
    {
      localAVGameMediaRenderHelper.a();
      this.O = null;
    }
  }
  
  public void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameVideoLayer
 * JD-Core Version:    0.7.0.1
 */