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
    if (paramGLVideoView != null)
    {
      String str = AVGameUtil.a(paramString, paramInt);
      paramGLVideoView.a(paramString, paramInt);
      paramGLVideoView.a(0);
      paramGLVideoView.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
      try
      {
        paramString = paramGLVideoView.a();
        GraphicRenderMgr.getInstance().setAccountUin(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
        GraphicRenderMgr.setGlRender(str, paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setGlRender[initGLVideoViewBasePara], key[");
        localStringBuilder.append(str);
        localStringBuilder.append("], debug[");
        localStringBuilder.append(paramGLVideoView.d());
        localStringBuilder.append("], videoSrcType[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], yuvTexture[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w("AVGameVideoLayer", 1, localStringBuilder.toString());
        QavSDK.a().a().a(paramLong, false, paramBoolean);
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
        QavSDK.a().a().a(paramLong, true, paramBoolean);
      }
    }
  }
  
  private void q()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    int i = 0;
    AVGameVideoView[] arrayOfAVGameVideoView;
    for (;;)
    {
      arrayOfAVGameVideoView = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView;
      if (i >= arrayOfAVGameVideoView.length) {
        break;
      }
      arrayOfAVGameVideoView[i] = new AVGameVideoView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(i) }), 0L);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(localBoolean);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(1);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].h(-1);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].c(i * 2);
      a(this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i]);
      i += 1;
    }
    i = 0;
    for (;;)
    {
      arrayOfAVGameVideoView = this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView;
      if (i >= arrayOfAVGameVideoView.length) {
        break;
      }
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      AVGameAppInterface localAVGameAppInterface = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
      int j = i + 9;
      arrayOfAVGameVideoView[i] = new AVGameVideoView(localContext, localAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(j) }), 0L, false);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(1);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].a(localBoolean);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].h(-1);
      this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].c(j * 2);
      a(this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i]);
      i += 1;
    }
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0] = new AVGameVideoView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, String.format("%s_%s", new Object[] { "AVGameVideoLayer", Integer.valueOf(17) }), 0L, false);
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0].c(81);
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0].a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0].a(localBoolean);
    this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0].a(1);
    a(this.jdField_c_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[0]);
  }
  
  private void r()
  {
    d(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165311));
  }
  
  private void s()
  {
    AVLog.d("AVGameVideoLayer", "doResumeVideo");
    Object localObject1 = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    Object localObject2 = AVGameBusinessCtrl.b().a();
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
      ((StringBuilder)localObject1).append(this.jdField_d_of_type_Boolean);
      AVLog.d("AVGameVideoLayer", ((StringBuilder)localObject1).toString());
      if (bool2)
      {
        localObject1 = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
        if (localObject1 != null) {
          ((AVGameControlUI)localObject1).c();
        }
      }
    }
    else
    {
      int i = j;
      if (GameEngine.a().f())
      {
        i = j;
        if (!GameEngine.a().g()) {
          i = 1;
        }
      }
      if (i != 0) {
        c(true);
      }
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView == null) {
      return -1;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      for (;;)
      {
        Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if ((paramString.equals(((GLVideoView)localObject).c())) && (paramInt == ((GLVideoView)localObject).g()) && (((GLVideoView)localObject).a() == 0)) {
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openSelfVideoView, from[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    QLog.w("AVGameVideoLayer", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    int i = a((String)localObject, 1);
    if (i < 0)
    {
      i = f();
      if (i >= 0)
      {
        paramString = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
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
      paramString = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
      GraphicRenderMgr.setGlRender((String)localObject, paramString.a());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[openSelfVideoView], key[");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("], index[");
      localStringBuilder.append(i);
      localStringBuilder.append("], forceToBigView[");
      localStringBuilder.append(false);
      localStringBuilder.append("], ");
      localStringBuilder.append(paramString.d());
      QLog.w("AVGameVideoLayer", 1, localStringBuilder.toString());
    }
    if (paramString != null)
    {
      paramString.g(false);
      paramString.k(false);
      paramString.a(paramLong, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).isFrontCamera());
      paramString.m(true);
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
      i = f();
      if (i >= 0)
      {
        paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
        a(paramLong, paramString1, paramString2, paramInt, true);
      }
      else
      {
        paramString1 = null;
      }
    }
    else
    {
      paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i];
      GraphicRenderMgr.setGlRender((String)localObject, paramString1.a());
      paramString2 = new StringBuilder();
      paramString2.append("setGlRender[openPeerVideo], key[");
      paramString2.append((String)localObject);
      paramString2.append("], seq[");
      paramString2.append(paramLong);
      paramString2.append("], index[");
      paramString2.append(i);
      paramString2.append("], ");
      paramString2.append(paramString1.d());
      QLog.w("AVGameVideoLayer", 1, paramString2.toString());
    }
    if (paramString1 != null)
    {
      paramString1.k(true);
      paramString1.a(paramLong, false);
      paramString1.a(0);
      paramString1.a(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    AVGameMediaRenderHelper localAVGameMediaRenderHelper = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper;
    if ((localAVGameMediaRenderHelper != null) && (!this.jdField_c_of_type_Boolean))
    {
      localAVGameMediaRenderHelper.a(paramArrayOfByte, paramInt1, paramInt2, paramLong);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("closeSelfVideoView, from[");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], seq[");
    ((StringBuilder)localObject).append(paramLong);
    QLog.w("AVGameVideoLayer", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
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
    AVGameMediaRenderHelper localAVGameMediaRenderHelper = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper;
    if (localAVGameMediaRenderHelper != null) {
      localAVGameMediaRenderHelper.a(paramBoolean);
    }
    b();
  }
  
  public void d(String paramString) {}
  
  public int f()
  {
    int i = 0;
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      j = i;
      if (TextUtils.isEmpty(((GLVideoView)localObject).c())) {
        return j;
      }
      if (((GLVideoView)localObject).a() == 1) {
        return i;
      }
      i += 1;
    }
    int j = -1;
    return j;
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
    for (;;)
    {
      Object localObject = this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      j = i;
      if (TextUtils.isEmpty(((GLVideoView)localObject).c())) {
        return j;
      }
      if (((GLVideoView)localObject).a() == 1) {
        return i;
      }
      i += 1;
    }
    int j = -1;
    return j;
  }
  
  public void g()
  {
    AVGameMediaRenderHelper localAVGameMediaRenderHelper = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper;
    if (localAVGameMediaRenderHelper != null)
    {
      localAVGameMediaRenderHelper.a();
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper = null;
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameScreenLayoutStyle = AVGameScreenLayoutStyle.a(paramInt, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface);
  }
  
  protected void h(GLCanvas paramGLCanvas)
  {
    paramGLCanvas = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameScreenLayoutStyle;
    if (paramGLCanvas != null) {
      paramGLCanvas.a(this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView, this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView, b(), c(), this.jdField_b_of_type_JavaUtilList);
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
    int i = 0;
    int j = 0;
    while (i < k)
    {
      AVGameVideoView localAVGameVideoView = arrayOfAVGameVideoView[i];
      if (localAVGameVideoView.a()) {
        if (str.equalsIgnoreCase(localAVGameVideoView.c()))
        {
          b("VideoLayer_doOnStop", -1L);
          j = 1;
        }
        else
        {
          b("VideoLayer_doOnStop", -1L, localAVGameVideoView.c(), localAVGameVideoView.g());
        }
      }
      i += 1;
    }
    c(false);
    if ((CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).isCameraOpened(-1L)) && (j != 0)) {
      this.jdField_d_of_type_Boolean = true;
    }
    AVGameHandler.a().b().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void o()
  {
    AVLog.d("AVGameVideoLayer", "doOnDestroy");
    int i = 0;
    AVGameVideoView[] arrayOfAVGameVideoView;
    for (;;)
    {
      arrayOfAVGameVideoView = this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView;
      if (i >= arrayOfAVGameVideoView.length) {
        break;
      }
      arrayOfAVGameVideoView[i].a(1);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].m(true);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].k(false);
      this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView[i].g(false);
      i += 1;
    }
    this.jdField_a_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView = null;
    i = 0;
    for (;;)
    {
      arrayOfAVGameVideoView = this.jdField_b_of_type_ArrayOfComTencentAvgameGameroomVideoAVGameVideoView;
      if (i >= arrayOfAVGameVideoView.length) {
        break;
      }
      arrayOfAVGameVideoView[i].a(1);
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
    AVGameMediaRenderHelper localAVGameMediaRenderHelper = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameMediaRenderHelper;
    if (localAVGameMediaRenderHelper != null) {
      localAVGameMediaRenderHelper.a(this.jdField_d_of_type_AndroidGraphicsRect, b(), c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameVideoLayer
 * JD-Core Version:    0.7.0.1
 */