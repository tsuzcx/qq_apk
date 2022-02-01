package com.tencent.avgame.gameroom.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView.ScaleType;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
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
import com.tencent.avgame.qav.AVGameMediaPlayerCtrl.PushDecodeMsg;
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.qav.QavSDK;
import com.tencent.qav.controller.multi.IMultiOperator;
import com.tencent.qav.log.AVLog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AVGameVideoLayer
  extends GLViewGroup
  implements GLView.OnTouchListener, AVGameMediaPlayerCtrl.PushDecodeMsg
{
  private Context jdField_a_of_type_AndroidContentContext;
  protected AVGameAppInterface a;
  UserInfoHandler jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler;
  private AVGameControlUI jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
  protected AVGameMediaRenderHelper a;
  private AVGameScreenLayoutStyle jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameScreenLayoutStyle;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AVGameVideoLayer.1(this);
  protected AVGameVideoView[] a;
  protected final List<MemberVideoDisplayInfo> b;
  protected AVGameVideoView[] b;
  protected boolean c;
  protected AVGameVideoView[] c;
  protected volatile Rect d;
  private boolean d;
  
  public AVGameVideoLayer(Context paramContext, AVGameAppInterface paramAVGameAppInterface)
  {
    super(paramContext);
    this.jdField_b_of_type_JavaUtilList = new ArrayList(8);
    this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView = new AVGameVideoView[9];
    this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView = new AVGameVideoView[9];
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView = new AVGameVideoView[1];
    this.jdField_d_of_type_AndroidGraphicsRect = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = ((UserInfoHandler)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getBusinessHandler(HandlerFactory.b));
    q();
    r();
    g(2);
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(long paramLong, GLVideoView paramGLVideoView, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramGLVideoView != null)
    {
      str = AVGameUtils.a(paramString, paramInt);
      paramGLVideoView.a(paramString, paramInt);
      paramGLVideoView.a(0);
      paramGLVideoView.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    }
    try
    {
      paramString = paramGLVideoView.a();
      GraphicRenderMgr.getInstance().setAccountUin(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
      GraphicRenderMgr.getInstance().setGlRender(str, paramString);
      QLog.w("AVGameVideoLayer", 1, "setGlRender[initGLVideoViewBasePara], key[" + str + "], debug[" + paramGLVideoView.d() + "], videoSrcType[" + paramInt + "], yuvTexture[" + paramString + "]");
      QavSDK.a().a().a(paramLong, false, paramBoolean);
      return;
    }
    catch (UnsatisfiedLinkError paramGLVideoView)
    {
      paramGLVideoView.printStackTrace();
    }
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    AVLog.d("AVGameVideoLayer", "closeGLVideoView uin:=" + paramString);
    paramInt = a(paramString, paramInt);
    if (paramInt >= 0)
    {
      paramString = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[paramInt];
      paramString.a(1);
      paramString.b(null);
      paramString.m(true);
      paramString.k(false);
      paramString.g(false);
      paramString.l(true);
      paramString.a(null, 0);
      paramString.a("");
    }
  }
  
  private void a(String paramString1, long paramLong, String paramString2, int paramInt, boolean paramBoolean)
  {
    AVLog.d("AVGameVideoLayer", "closeGLVideoViewBasePara uin:=" + paramString2);
    int i = a(paramString2, paramInt);
    if (i >= 0)
    {
      paramString2 = AVGameUtils.a(paramString2, paramInt);
      GraphicRenderMgr localGraphicRenderMgr = GraphicRenderMgr.getInstance();
      localGraphicRenderMgr.flushGlRender(paramString2);
      if ((!paramBoolean) && (paramInt == 1)) {
        localGraphicRenderMgr.clearCameraFrames();
      }
      localGraphicRenderMgr.setGlRender(paramString2, null);
      QLog.w("AVGameVideoLayer", 1, "setGlRender[closeGLVideoViewBasePara], key[" + paramString2 + "], index[" + i + "], seq[" + paramLong + "], from[" + paramString1 + "]");
      if (paramBoolean) {
        QavSDK.a().a().a(paramLong, true, paramBoolean);
      }
    }
  }
  
  private void q()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i] = new AVGameVideoView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(i) }), 0L);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(Boolean.valueOf(false));
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(1);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].h(-1);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].c(i * 2);
      a(this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i]);
      i += 1;
    }
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView.length)
    {
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i] = new AVGameVideoView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(i + 9) }), 0L, false);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(1);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(Boolean.valueOf(false));
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].h(-1);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].c((i + 9) * 2);
      a(this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i]);
      i += 1;
    }
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0] = new AVGameVideoView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(17) }), 0L, false);
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0].c(81);
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0].a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0].a(Boolean.valueOf(false));
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0].a(1);
    a(this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0]);
  }
  
  private void r()
  {
    d(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165345));
  }
  
  private void s()
  {
    int j = 0;
    AVLog.d("AVGameVideoLayer", "doResumeVideo");
    String str1 = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    Object localObject1 = AVGameBusinessCtrl.b().a();
    Object localObject2;
    boolean bool1;
    boolean bool2;
    String str2;
    if (localObject1 != null)
    {
      localObject2 = new ArrayList();
      ((AVGameSession)localObject1).c((List)localObject2);
      localObject1 = ((List)localObject2).iterator();
      bool1 = false;
      bool2 = false;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AVGameUserInfo)((Iterator)localObject1).next();
        str2 = String.valueOf(((AVGameUserInfo)localObject2).mUin);
        if (str1.equalsIgnoreCase(String.valueOf(((AVGameUserInfo)localObject2).mUin)))
        {
          if (((AVGameUserInfo)localObject2).mVideoOn) {
            a("doResumeVideo", -1L);
          }
          if (!((AVGameUserInfo)localObject2).mSubVideoOn) {
            break label297;
          }
          c(true);
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      break;
      if (((AVGameUserInfo)localObject2).mVideoOn) {
        a("doResumeVideo", -1L, str2, 1);
      }
      if (((AVGameUserInfo)localObject2).mSubVideoOn) {
        a("doResumeVideo", -1L, str2, 2);
      }
      bool2 = true;
      continue;
      AVLog.d("AVGameVideoLayer", "doResumeVideo mNeedRequest:=" + bool2 + ";mHasDoGoOnStage:=" + bool1 + ";mNeedReOpenCamera:=" + this.jdField_d_of_type_Boolean);
      if ((bool2) && (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI != null)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.c();
      }
      int i;
      do
      {
        return;
        i = j;
        if (GameEngine.a().f())
        {
          i = j;
          if (!GameEngine.a().g()) {
            i = 1;
          }
        }
      } while (i == 0);
      c(true);
      return;
      label297:
      bool1 = true;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView == null) {
      return -1;
    }
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = 0;
      if (i < this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView.length)
      {
        AVGameVideoView localAVGameVideoView = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
        if ((!paramString.equals(localAVGameVideoView.c())) || (paramInt != localAVGameVideoView.g()) || (localAVGameVideoView.a() != 0)) {}
      }
    }
    for (;;)
    {
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void a(Rect paramRect)
  {
    QLog.w("AVGameVideoLayer", 1, "setVideoRenderPosition, rect[" + paramRect.toString());
    this.jdField_d_of_type_AndroidGraphicsRect = paramRect;
    b();
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    h(paramGLCanvas);
    f(paramGLCanvas);
  }
  
  public void a(AVGameControlUI paramAVGameControlUI)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI = paramAVGameControlUI;
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong)
  {
    QLog.w("AVGameVideoLayer", 1, "openSelfVideoView, from[" + paramString + "], seq[" + paramLong);
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    paramString = null;
    int i = a(str, 1);
    if (i < 0)
    {
      i = f();
      if (i >= 0)
      {
        paramString = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
        a(paramLong, paramString, str, 1, false);
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramString.g(false);
        paramString.k(false);
        paramString.a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
        paramString.m(true);
        paramString.a(0);
        paramString.a(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      str = AVGameUtils.a(str, 1);
      paramString = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
      GraphicRenderMgr.getInstance().setGlRender(str, paramString.a());
      QLog.w("AVGameVideoLayer", 1, "setGlRender[openSelfVideoView], key[" + str + "], index[" + i + "], forceToBigView[" + false + "], " + paramString.d());
    }
  }
  
  public void a(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    QLog.w("AVGameVideoLayer", 1, "openRemoteVideoView, from[" + paramString1 + "], seq[" + paramLong + "], uin[" + paramString2);
    paramString1 = null;
    int i = a(paramString2, paramInt);
    String str = AVGameUtils.a(paramString2, paramInt);
    if (i < 0)
    {
      i = f();
      if (i >= 0)
      {
        paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
        a(paramLong, paramString1, paramString2, paramInt, true);
      }
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString1.k(true);
        paramString1.a(paramLong, false);
        paramString1.a(0);
        paramString1.a(ImageView.ScaleType.CENTER_CROP);
      }
      return;
      paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
      GraphicRenderMgr.getInstance().setGlRender(str, paramString1.a());
      QLog.w("AVGameVideoLayer", 1, "setGlRender[openPeerVideo], key[" + str + "], seq[" + paramLong + "], index[" + i + "], " + paramString1.d());
    }
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper != null) && (!this.jdField_c_of_type_Boolean))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper.a(paramArrayOfByte, paramInt1, paramInt2, paramLong);
      b();
    }
  }
  
  public boolean a(GLView paramGLView, MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(String paramString) {}
  
  public void b(String paramString, long paramLong)
  {
    QLog.w("AVGameVideoLayer", 1, "closeSelfVideoView, from[" + paramString + "], seq[" + paramLong);
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    if (a(str, 1) >= 0)
    {
      a(paramString, paramLong, str, 1, false);
      a(str, 1, false);
    }
  }
  
  public void b(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    AVLog.d("AVGameVideoLayer", "closeRemoteVideoView uin:=" + paramString2);
    if (a(paramString2, paramInt) >= 0)
    {
      a(paramString1, paramLong, paramString2, paramInt, true);
      a(paramString2, paramInt, true);
    }
  }
  
  public void c(String paramString) {}
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper.a(paramBoolean);
    }
    b();
  }
  
  public void d(String paramString) {}
  
  public int f()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView.length)
    {
      AVGameVideoView localAVGameVideoView = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
      if ((TextUtils.isEmpty(localAVGameVideoView.c())) || (localAVGameVideoView.a() == 1)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper = new AVGameMediaRenderHelper();
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper.a(b(), c());
  }
  
  protected void f(GLCanvas paramGLCanvas)
  {
    super.a(paramGLCanvas);
    p();
  }
  
  public int g()
  {
    int i = 0;
    while (i < this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView.length)
    {
      AVGameVideoView localAVGameVideoView = this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
      if ((TextUtils.isEmpty(localAVGameVideoView.c())) || (localAVGameVideoView.a() == 1)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper.a();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper = null;
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameScreenLayoutStyle = AVGameScreenLayoutStyle.a(paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface);
  }
  
  protected void h(GLCanvas paramGLCanvas)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameScreenLayoutStyle != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameScreenLayoutStyle.a(this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView, this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView, b(), c(), this.jdField_b_of_type_JavaUtilList);
    }
    paramGLCanvas = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView;
    int j = paramGLCanvas.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramGLCanvas[i];
      if ((localObject.a()) && (localObject.g() == 2) && (localObject.c() == 0)) {
        localObject.a((b() - 640) / 2, 40, (b() + 640) / 2, 520);
      }
      i += 1;
    }
  }
  
  public void l() {}
  
  public void m()
  {
    AVLog.d("AVGameVideoLayer", "doOnResume");
    AVGameHandler.a().b().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 500L);
  }
  
  public void n()
  {
    AVLog.d("AVGameVideoLayer", "doOnStop");
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    AVGameVideoView[] arrayOfAVGameVideoView = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView;
    int k = arrayOfAVGameVideoView.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      AVGameVideoView localAVGameVideoView = arrayOfAVGameVideoView[j];
      if (!localAVGameVideoView.a()) {}
      for (;;)
      {
        j += 1;
        break;
        if (str.equalsIgnoreCase(localAVGameVideoView.c()))
        {
          b("VideoLayer_doOnStop", -1L);
          i = 1;
        }
        else
        {
          b("VideoLayer_doOnStop", -1L, localAVGameVideoView.c(), localAVGameVideoView.g());
        }
      }
    }
    c(false);
    if ((CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(-1L)) && (i != 0)) {
      this.jdField_d_of_type_Boolean = true;
    }
    AVGameHandler.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void o()
  {
    AVLog.d("AVGameVideoLayer", "doOnDestroy");
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(1);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].m(true);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].k(false);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].g(false);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView = null;
    i = 0;
    while (i < this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView.length)
    {
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(1);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].m(true);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].k(false);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].g(false);
      i += 1;
    }
    this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView = null;
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
  }
  
  protected void p()
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper.a(this.jdField_d_of_type_AndroidGraphicsRect, b(), c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameVideoLayer
 * JD-Core Version:    0.7.0.1
 */