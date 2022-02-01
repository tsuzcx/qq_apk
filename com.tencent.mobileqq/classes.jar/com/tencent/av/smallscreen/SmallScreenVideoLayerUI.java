package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.api.IGraphicRender;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.ControlUIObserver.ZimuRequest;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.ScreenLayout;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.av.ui.funchat.zimu.ZimuViewProxy;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

public class SmallScreenVideoLayerUI
  extends VideoLayerUIBase
{
  private SmallScreenVideoLayerUI.SmallScreenListener jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI$SmallScreenListener = null;
  ZimuViewProxy jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy;
  private int k = 0;
  
  public SmallScreenVideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView, SmallScreenVideoLayerUI.SmallScreenListener paramSmallScreenListener)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI$SmallScreenListener = paramSmallScreenListener;
    this.w = 2;
    this.jdField_a_of_type_ComTencentAvUiScreenLayout = ScreenLayout.a(paramContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController.a().L, true);
    n();
    l();
    q();
    s();
  }
  
  private void a(String paramString, YUVTexture paramYUVTexture)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.n())
    {
      GraphicRenderMgr.setGlRender(paramString, paramYUVTexture);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setGlRender[small_screen], key[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], render[");
      localStringBuilder.append(paramYUVTexture);
      localStringBuilder.append("]");
      QLog.i("SmallScreenVideoLayerUI", 1, localStringBuilder.toString());
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().j == 2)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[2].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[3].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[4].a(Boolean.valueOf(true));
      if ((this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].f()) && ((this.x == 0) || (this.x == 180)) && (!this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].j()))
      {
        if (this.x == 0) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297837));
        } else {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297837), 0, 0);
        }
      }
      else {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(paramInt3, paramInt3, paramInt3, paramInt3);
      }
    }
    this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.jdField_a_of_type_ComTencentAvVideoController.a(), this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, paramInt1, paramInt2, paramBoolean, this.x, this.r);
  }
  
  private int g()
  {
    int i = 0;
    int m;
    for (int j = 0; i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length; j = m)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      String str = (String)localGLVideoView.a(0);
      m = j;
      if (localGLVideoView.a() == 0)
      {
        m = j;
        if (localGLVideoView.i())
        {
          m = j;
          if (!TextUtils.isEmpty(str)) {
            m = j + 1;
          }
        }
      }
      i += 1;
    }
    return j;
  }
  
  private void i(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("closeVideoView index: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("SmallScreenVideoLayerUI", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ImageView.ScaleType.CENTER_INSIDE;
    int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
    int n;
    int j;
    float f1;
    int i;
    boolean bool1;
    if (paramInt == 0)
    {
      m = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].e();
      float f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d();
      n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].f();
      boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].h();
      j = m;
      f1 = f2;
      i = n;
      bool1 = bool2;
      if (i1 == 4)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a();
        j = m;
        f1 = f2;
        i = n;
        bool1 = bool2;
      }
    }
    else
    {
      j = 0;
      f1 = 0.0F;
      i = 0;
      bool1 = false;
    }
    int m = paramInt;
    while (m < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      if (m < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length - 1)
      {
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
        n = m + 1;
        if (localObject2[n].a() == 0)
        {
          int i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[m].d();
          int i3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[n].d();
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[m].c(i3);
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[n].c(i2);
          localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[m];
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[m] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[n];
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[n] = localObject2;
          m = n;
          continue;
        }
      }
      Object localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[m];
      ((GLVideoView)localObject2).a(1);
      m();
      ((GLVideoView)localObject2).b(null);
      ((GLVideoView)localObject2).m(true);
      ((GLVideoView)localObject2).k(false);
      ((GLVideoView)localObject2).g(false);
      ((GLVideoView)localObject2).l(true);
      ((GLVideoView)localObject2).a(null, 0);
      ((GLVideoView)localObject2).a("");
    }
    t();
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].h(false);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].k(j);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].j(i);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].j(bool1);
      if (i1 == 4) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a((ImageView.ScaleType)localObject1);
      }
    }
    c(false);
  }
  
  private int j()
  {
    String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      String str2 = (String)localGLVideoView.a(0);
      if ((localGLVideoView.a() == 0) && (!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "initGlVideoViewBackground");
    }
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView != null)
    {
      int i = 1;
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].c(-1);
        i += 1;
      }
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a() == 0)
    {
      String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      String str2 = (String)this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0);
      if ((str2 != null) && (str2.equals(str1)))
      {
        int i = j();
        if (i > 0) {
          a(0, i);
        }
      }
    }
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setOffset topOffset: ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", bottomOffset: ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("SmallScreenVideoLayerUI", 2, ((StringBuilder)localObject).toString());
    }
    this.q = paramInt1;
    this.r = paramInt2;
    c(true);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().y)
      {
        int i = 0;
        while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
          if (i == 0)
          {
            if ((paramInt1 != 0) && (paramInt2 != 0)) {
              ((GLVideoView)localObject).j(false);
            } else {
              ((GLVideoView)localObject).j(true);
            }
          }
          else {
            ((GLVideoView)localObject).j(true);
          }
          i += 1;
        }
      }
      paramInt1 = 0;
      while (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].j(false);
        paramInt1 += 1;
      }
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((!this.d) && (!l()))
    {
      this.v = paramInt;
      return;
    }
    if ((paramInt == this.u) && (paramInt != this.v)) {
      return;
    }
    int i = this.u;
    boolean bool = false;
    if (paramInt % 90 != i % 90) {
      this.s = 0;
    }
    this.u = paramInt;
    this.v = paramInt;
    i = VideoLayerUI.a("SmallScreenVideoLayerUI", this.jdField_a_of_type_AndroidContentContext, paramInt, paramBoolean, this.jdField_a_of_type_AndroidViewDisplay);
    if ((paramInt == 0) || (paramInt == 90) || (paramInt == 180) || (paramInt == 270))
    {
      paramInt = 0;
      while (paramInt < super.e())
      {
        super.a(paramInt).b(i);
        paramInt += 1;
      }
      this.x = i;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().j == 2)
    {
      if (this.x != 0)
      {
        paramBoolean = bool;
        if (this.x != 180) {}
      }
      else
      {
        paramBoolean = true;
      }
      c(paramBoolean);
    }
  }
  
  void a(String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = a("setBackground", paramString, paramInt);
    int i = j;
    GLVideoView localGLVideoView;
    if (j < 0)
    {
      j = a(0);
      if (j >= 0)
      {
        localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
        localGLVideoView.a(0);
        m();
        t();
        localGLVideoView.a(0, paramString);
        localGLVideoView.a(1, Integer.valueOf(paramInt));
        localGLVideoView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        String str = VideoLayerUI.a(paramString, paramInt);
        a(str, null);
        a(str, localGLVideoView.a());
        long l = AudioHelper.b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setGlRender[setBackground], key[");
        localStringBuilder.append(str);
        localStringBuilder.append("], index[");
        localStringBuilder.append(j);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(l);
        localStringBuilder.append("], ");
        localStringBuilder.append(localGLVideoView.d());
        QLog.w("SmallScreenVideoLayerUI", 1, localStringBuilder.toString());
        boolean bool;
        if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))) {
          bool = false;
        } else {
          bool = true;
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, bool);
      }
      i = j;
      if (paramBoolean2)
      {
        i = j;
        if (j > 0)
        {
          a(0, j);
          i = 0;
        }
      }
    }
    if (i >= 0)
    {
      localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      localGLVideoView.a(paramBitmap);
      localGLVideoView.m(paramBoolean1);
      if (!paramBoolean1) {
        localGLVideoView.k(false);
      }
    }
    c(false);
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("setBackground uin: ");
      paramBitmap.append(paramString);
      paramBitmap.append(", videoSrcType: ");
      paramBitmap.append(paramInt);
      paramBitmap.append(", index: ");
      paramBitmap.append(i);
      paramBitmap.append(", needRenderVideo: ");
      paramBitmap.append(paramBoolean1);
      QLog.d("SmallScreenVideoLayerUI", 2, paramBitmap.toString());
    }
  }
  
  void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    int i = a("setText", paramString1, paramInt1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setText uin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", videoSrcType: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", text: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", textSize: ");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(", textColor: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", index: ");
      localStringBuilder.append(i);
      QLog.d("SmallScreenVideoLayerUI", 2, localStringBuilder.toString());
    }
    if (i >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      boolean bool = false;
      paramString1.a(0);
      m();
      t();
      paramString1.b(paramString2);
      paramString1.a(paramFloat);
      paramString1.k(paramInt2);
      if (i != 0) {
        bool = true;
      }
      paramString1.h(bool);
      if (i == 0)
      {
        paramString1.j(12);
        return;
      }
      paramString1.j(2147483647);
    }
  }
  
  void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l = AudioHelper.b();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setRemoteHasVideo, uin[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("], videoSrcType[");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("], isRemoteHasVideo[");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append("], forceToBigView[");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append("], mIsLocalHasVideo[");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append("], isFillBlackEdge[");
      ((StringBuilder)localObject1).append(paramBoolean3);
      ((StringBuilder)localObject1).append("], seq[");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append("]");
      QLog.w("SmallScreenVideoLayerUI", 1, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
        return;
      }
      if (Utils.a(this.jdField_a_of_type_AndroidContentContext) == 1) {
        return;
      }
      boolean bool = paramBoolean2;
      if (a(this.jdField_a_of_type_ComTencentAvVideoController.a()))
      {
        bool = paramBoolean2;
        if (!paramBoolean2)
        {
          bool = paramBoolean2;
          if (!k()) {
            bool = true;
          }
        }
      }
      n();
      if (paramBoolean1)
      {
        i = a("setRemoteHasVideo_open", paramString, paramInt);
        Object localObject2 = VideoLayerUI.a(paramString, paramInt);
        if (i < 0)
        {
          i = a(0);
          if (i >= 0)
          {
            localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
            ((GLVideoView)localObject1).a(paramString, paramInt);
            ((GLVideoView)localObject1).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
            try
            {
              a((String)localObject2, ((GLVideoView)localObject1).a());
            }
            catch (UnsatisfiedLinkError paramString)
            {
              paramString.printStackTrace();
            }
            paramString = new StringBuilder();
            paramString.append("setGlRender[RemoteHasVideo_1], key[");
            paramString.append((String)localObject2);
            paramString.append("], index[");
            paramString.append(i);
            paramString.append("], ");
            paramString.append(((GLVideoView)localObject1).d());
            QLog.w("SmallScreenVideoLayerUI", 1, paramString.toString());
            localObject2 = this.jdField_a_of_type_ComTencentAvVideoController;
            paramInt = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
            paramString = (String)localObject1;
            ((VideoController)localObject2).a(l, paramInt, false, true);
          }
          else
          {
            paramString = null;
          }
          paramInt = i;
          localObject1 = paramString;
          if (i > 1)
          {
            paramInt = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
            paramInt = i;
            localObject1 = paramString;
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
          a((String)localObject2, ((GLVideoView)localObject1).a());
          paramString = new StringBuilder();
          paramString.append("setGlRender[RemoteHasVideo_2], key[");
          paramString.append((String)localObject2);
          paramString.append("], index[");
          paramString.append(i);
          paramString.append("], ");
          paramString.append(((GLVideoView)localObject1).d());
          QLog.w("SmallScreenVideoLayerUI", 1, paramString.toString());
          this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, true);
          paramInt = i;
        }
        if (localObject1 != null)
        {
          ((GLVideoView)localObject1).g(paramBoolean3);
          ((GLVideoView)localObject1).a(l, this.jdField_a_of_type_ComTencentAvUiScreenLayout.c());
          ((GLVideoView)localObject1).k(true);
          ((GLVideoView)localObject1).a(0);
          m();
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)
          {
            if (paramInt == 0) {
              ((GLVideoView)localObject1).a(ImageView.ScaleType.CENTER_INSIDE);
            } else {
              ((GLVideoView)localObject1).a(ImageView.ScaleType.CENTER_CROP);
            }
          }
          else if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
            ((GLVideoView)localObject1).a(ImageView.ScaleType.CENTER_INSIDE);
          }
        }
        if ((bool) && (paramInt > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().i))) {
          a(0, paramInt);
        }
        if (paramInt > 0) {
          t();
        }
        c(false);
        return;
      }
      int i = a("setRemoteHasVideo_close", paramString, paramInt);
      if (i >= 0)
      {
        paramString = VideoLayerUI.a(paramString, paramInt);
        GraphicRenderMgr.getInstance().flushGlRender(paramString);
        GraphicRenderMgr.setGlRender(paramString, null);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setGlRender[RemoteHasVideo_no], key[");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("], index[");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("]");
        QLog.w("SmallScreenVideoLayerUI", 1, ((StringBuilder)localObject1).toString());
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, true, true);
        i(i);
      }
    }
  }
  
  protected void a(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    int i = ((Integer)paramObservable[0]).intValue();
    if (i != 6005)
    {
      if (i != 6008) {
        return;
      }
      o();
      paramObservable = (SentenceInfo)paramObservable[1];
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramObservable);
      return;
    }
    i = ((ControlUIObserver.ZimuRequest)ControlUIObserver.a(paramObservable)).a;
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("switchVideo index1: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", index2: ");
      localStringBuilder.append(paramInt2);
      QLog.d("SmallScreenVideoLayerUI", 2, localStringBuilder.toString());
    }
    if ((paramInt1 != paramInt2) && (paramInt1 >= 0) && (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) && (paramInt2 >= 0) && (paramInt2 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length))
    {
      c(paramInt1, paramInt2);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "switchVideo index invalid!");
    }
    return false;
  }
  
  boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setLocalHasVideo, isLocalHasVideo[");
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append("->");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append("], forceToBigView[");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append("], seq[");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append("]");
      QLog.w("SmallScreenVideoLayerUI", 1, ((StringBuilder)localObject1).toString());
    }
    if (Utils.a(this.jdField_a_of_type_AndroidContentContext) == 1) {
      return false;
    }
    Object localObject1 = null;
    StringBuilder localStringBuilder = null;
    int i;
    Object localObject3;
    Object localObject2;
    if (paramBoolean1)
    {
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      i = a("setLocalHasVideo_open", str2, 1);
      String str1 = VideoLayerUI.a(str2, 1);
      int j;
      if (i < 0)
      {
        i = a(0);
        if (i >= 0)
        {
          localObject3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
          ((GLVideoView)localObject3).a(0, str2);
          ((GLVideoView)localObject3).a(1, Integer.valueOf(1));
          ((GLVideoView)localObject3).a(str2);
          try
          {
            GraphicRenderMgr.getInstance().setAccountUin(str2);
            a(str1, ((GLVideoView)localObject3).a());
            localObject1 = localStringBuilder;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("UnsatisfiedLinkError");
            localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
            localObject2 = localStringBuilder.toString();
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("setGlRender[LocalHasVideo_1], key[");
          localStringBuilder.append(str1);
          localStringBuilder.append("], index[");
          localStringBuilder.append(i);
          localStringBuilder.append("], log[");
          localStringBuilder.append((String)localObject2);
          localStringBuilder.append("], ");
          localStringBuilder.append(((GLVideoView)localObject3).d());
          QLog.w("SmallScreenVideoLayerUI", 1, localStringBuilder.toString());
          this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, false);
          localObject2 = localObject3;
        }
        if (i > 1) {
          j = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
        a(str1, ((GLVideoView)localObject2).a());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("setGlRender[LocalHasVideo_2], key[");
        ((StringBuilder)localObject3).append(str1);
        ((StringBuilder)localObject3).append("], index[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("], ");
        ((StringBuilder)localObject3).append(((GLVideoView)localObject2).d());
        QLog.w("SmallScreenVideoLayerUI", 1, ((StringBuilder)localObject3).toString());
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, false);
      }
      if (localObject2 != null)
      {
        ((GLVideoView)localObject2).g(false);
        ((GLVideoView)localObject2).k(false);
        ((GLVideoView)localObject2).m(true);
        ((GLVideoView)localObject2).a(0);
        ((GLVideoView)localObject2).a(ImageView.ScaleType.CENTER_CROP);
        if (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).isCameraOpened(l)) {
          ((GLVideoView)localObject2).a(l, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).isFrontCamera());
        }
        m();
      }
      if (i == 0)
      {
        j = j();
        if (j > 0) {
          a(i, j);
        }
      }
      c(false);
    }
    else if (!paramBoolean1)
    {
      ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, false);
      localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      i = a("setLocalHasVideo_close", (String)localObject2, 1);
      if (i >= 0)
      {
        localObject2 = VideoLayerUI.a((String)localObject2, 1);
        localObject3 = GraphicRenderMgr.getInstance();
        ((IGraphicRender)localObject3).flushGlRender((String)localObject2);
        ((IGraphicRender)localObject3).clearCameraFrames();
        GraphicRenderMgr.setGlRender((String)localObject2, null);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("setGlRender[LocalHasVideo_no], key[");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append("], index[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("]");
        QLog.w("SmallScreenVideoLayerUI", 1, ((StringBuilder)localObject3).toString());
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, true, false);
        i(i);
      }
    }
    this.d = paramBoolean1;
    return true;
  }
  
  public void c(boolean paramBoolean)
  {
    int i = super.b();
    int j = super.c();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("layoutVideoView, virtical[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], sessionType[");
      localStringBuilder.append(localSessionInfo.d);
      localStringBuilder.append("], width[");
      localStringBuilder.append(i);
      localStringBuilder.append("], height[");
      localStringBuilder.append(j);
      localStringBuilder.append("]");
      QLog.w("SmallScreenVideoLayerUI", 1, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, 0, 0, 0);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b(0, 0, i, j);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d(-15197410);
    if (a(localSessionInfo)) {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, i, j, this.w, this.q, this.r, localSessionInfo.e ^ true);
    } else if (b(localSessionInfo)) {
      a(paramBoolean, i, j, 0);
    }
    super.b();
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "onFirstDraw");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new SmallScreenVideoLayerUI.1(this));
    }
  }
  
  public int f()
  {
    return this.jdField_a_of_type_ComTencentAvUiScreenLayout.a();
  }
  
  public void g(int paramInt)
  {
    super.g(paramInt);
    if (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() != paramInt)
    {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout = ScreenLayout.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, true);
      c(true);
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt].d(this.jdField_a_of_type_ComTencentAvUiScreenLayout.c());
        a(-1049L, this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt]);
        paramInt += 1;
      }
    }
  }
  
  protected void h(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, b(), c(), paramInt, this.q, this.r);
  }
  
  protected void l()
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)this.jdField_a_of_type_AndroidViewView.findViewById(2013331456));
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this);
  }
  
  void m()
  {
    int i = g();
    if (this.k != i)
    {
      this.k = i;
      SmallScreenVideoLayerUI.SmallScreenListener localSmallScreenListener = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI$SmallScreenListener;
      if (localSmallScreenListener != null) {
        localSmallScreenListener.a(this.k);
      }
    }
  }
  
  protected void n()
  {
    super.n();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].n(true);
      i += 1;
    }
  }
  
  void o()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy == null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy = new ZimuViewProxy(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public void p()
  {
    super.p();
    if (this.jdField_a_of_type_ComTencentAvUiScreenLayout != null)
    {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout.a();
      this.jdField_a_of_type_ComTencentAvUiScreenLayout = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoLayerUI
 * JD-Core Version:    0.7.0.1
 */