package com.tencent.av.smallscreen;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.widget.ImageView.ScaleType;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.SentenceInfo;
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.av.business.manager.zimu.ZimuLiveManager;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.ScreenLayout;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.av.ui.funchat.zimu.ZimuViewProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import jps;

public class SmallScreenVideoLayerUI
  extends VideoLayerUIBase
{
  private int jdField_a_of_type_Int;
  private SmallScreenVideoLayerUI.SmallScreenListener jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI$SmallScreenListener;
  ZimuViewProxy jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy;
  
  public SmallScreenVideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView, SmallScreenVideoLayerUI.SmallScreenListener paramSmallScreenListener)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI$SmallScreenListener = paramSmallScreenListener;
    this.h = 2;
    this.jdField_a_of_type_ComTencentAvUiScreenLayout = ScreenLayout.a(paramContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController.a().L, true);
    c();
    n();
    f();
    h();
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[2].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[3].a(Boolean.valueOf(true));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[4].a(Boolean.valueOf(true));
      if ((!this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c()) || ((this.i != 0) && (this.i != 180)) || (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].g())) {
        break label208;
      }
      if (this.i != 0) {
        break label181;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559765));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.jdField_a_of_type_ComTencentAvVideoController.a(), this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, paramInt1, paramInt2, paramBoolean, this.i, this.c);
      return;
      label181:
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559765), 0, 0);
      continue;
      label208:
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(paramInt3, paramInt3, paramInt3, paramInt3);
    }
  }
  
  private int d()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length; j = k)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      String str = (String)localGLVideoView.a(0);
      k = j;
      if (localGLVideoView.f() == 0)
      {
        k = j;
        if (localGLVideoView.f())
        {
          k = j;
          if (!TextUtils.isEmpty(str)) {
            k = j + 1;
          }
        }
      }
      i += 1;
    }
    return j;
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "closeVideoView index: " + paramInt);
    }
    int j = 0;
    float f1 = 0.0F;
    int i = 0;
    boolean bool1 = false;
    Object localObject2 = ImageView.ScaleType.CENTER_INSIDE;
    int n = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
    Object localObject1 = localObject2;
    int m;
    if (paramInt == 0)
    {
      k = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b();
      float f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d();
      m = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c();
      boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].e();
      localObject1 = localObject2;
      bool1 = bool2;
      i = m;
      f1 = f2;
      j = k;
      if (n == 4)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a();
        j = k;
        f1 = f2;
        i = m;
        bool1 = bool2;
      }
    }
    int k = paramInt;
    while (k < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) {
      if ((k < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length - 1) && (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(k + 1)].f() == 0))
      {
        m = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[k].i();
        int i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(k + 1)].i();
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[k].h(i1);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(k + 1)].h(m);
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[k];
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[k] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(k + 1)];
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(k + 1)] = localObject2;
        k += 1;
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[k];
        ((GLVideoView)localObject2).g(1);
        b();
        ((GLVideoView)localObject2).b(null);
        ((GLVideoView)localObject2).i(true);
        ((GLVideoView)localObject2).g(false);
        ((GLVideoView)localObject2).c(false);
        ((GLVideoView)localObject2).h(true);
        ((GLVideoView)localObject2).a(null, 0);
        ((GLVideoView)localObject2).a("");
      }
    }
    j();
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].e(false);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].c(j);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(f1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b(i);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].f(bool1);
      if (n == 4) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a((ImageView.ScaleType)localObject1);
      }
    }
    a(false);
  }
  
  private int e()
  {
    String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      String str2 = (String)localGLVideoView.a(0);
      if ((localGLVideoView.f() == 0) && (!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "initGlVideoViewBackground");
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView != null)
    {
      int i = 1;
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].h(-1);
        i += 1;
      }
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].f() == 0)
    {
      String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      String str2 = (String)this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0);
      if ((str2 != null) && (str2.equals(str1)))
      {
        int i = e();
        if (i > 0) {
          a(0, i);
        }
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAvUiScreenLayout.a();
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setOffset topOffset: " + paramInt1 + ", bottomOffset: " + paramInt2);
    }
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    a(true);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().G)
      {
        int i = 0;
        if (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
          if (i == 0) {
            if ((paramInt1 != 0) && (paramInt2 != 0)) {
              localGLVideoView.f(false);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localGLVideoView.f(true);
            continue;
            localGLVideoView.f(true);
          }
        }
      }
      else
      {
        paramInt1 = 0;
        while (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].f(false);
          paramInt1 += 1;
        }
      }
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.jdField_a_of_type_Boolean) && (!f())) {
      this.g = paramInt;
    }
    label336:
    for (;;)
    {
      return;
      if ((paramInt != this.f) || (paramInt == this.g))
      {
        if (paramInt % 90 != this.f % 90) {
          this.d = 0;
        }
        this.f = paramInt;
        this.g = paramInt;
        int i;
        if (paramBoolean)
        {
          i = this.jdField_a_of_type_AndroidViewDisplay.getRotation();
          CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(true);
          i = (i * 90 + paramInt) % 360;
          switch (paramInt)
          {
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().D != 2) {
            break label336;
          }
          if (this.i != 0)
          {
            paramBoolean = bool;
            if (this.i != 180) {}
          }
          else
          {
            paramBoolean = true;
          }
          a(paramBoolean);
          return;
          CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(false);
          i = paramInt;
          break;
          paramInt = 0;
          while (paramInt < super.j())
          {
            super.a(paramInt).a(i);
            paramInt += 1;
          }
          this.i = i;
          continue;
          paramInt = 0;
          while (paramInt < super.j())
          {
            super.a(paramInt).a(i);
            paramInt += 1;
          }
          this.i = i;
          continue;
          paramInt = 0;
          while (paramInt < super.j())
          {
            super.a(paramInt).a(i);
            paramInt += 1;
          }
          this.i = i;
          continue;
          paramInt = 0;
          while (paramInt < super.j())
          {
            super.a(paramInt).a(i);
            paramInt += 1;
          }
          this.i = i;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    int j = a("setBackground", paramString, paramInt);
    int i = j;
    GLVideoView localGLVideoView;
    if (j < 0)
    {
      j = a(0);
      if (j >= 0)
      {
        localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
        localGLVideoView.g(0);
        b();
        j();
        localGLVideoView.a(0, paramString);
        localGLVideoView.a(1, Integer.valueOf(paramInt));
        localGLVideoView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        String str = VideoLayerUI.a(paramString, paramInt);
        GraphicRenderMgr.getInstance().setGlRender(str, null);
        GraphicRenderMgr.getInstance().setGlRender(str, localGLVideoView.a());
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[setBackground], key[" + str + "], index[" + j + "], " + localGLVideoView.b());
        boolean bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            bool1 = false;
          }
        }
        this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, bool1);
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
    for (;;)
    {
      if (i >= 0)
      {
        localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
        localGLVideoView.b(paramBitmap);
        localGLVideoView.i(paramBoolean1);
        if (!paramBoolean1) {
          localGLVideoView.g(false);
        }
      }
      a(false);
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoLayerUI", 2, "setBackground uin: " + paramString + ", videoSrcType: " + paramInt + ", index: " + i + ", needRenderVideo: " + paramBoolean1);
      }
      return;
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    boolean bool = false;
    int i = a("setText", paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setText uin: " + paramString1 + ", videoSrcType: " + paramInt1 + ", text: " + paramString2 + ", textSize: " + paramFloat + ", textColor: " + paramInt2 + ", index: " + i);
    }
    if (i >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      paramString1.g(0);
      b();
      j();
      paramString1.b(paramString2);
      paramString1.a(paramFloat);
      paramString1.c(paramInt2);
      if (i != 0) {
        bool = true;
      }
      paramString1.e(bool);
      if (i == 0) {
        paramString1.b(12);
      }
    }
    else
    {
      return;
    }
    paramString1.b(2147483647);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setRemoteHasVideo uin: " + paramString + ", videoSrcType: " + paramInt + ", isRemoteHasVideo: " + paramBoolean1 + ", forceToBigView: " + paramBoolean2 + ", mIsLocalHasVideo: " + this.jdField_a_of_type_Boolean + ", isPC: " + paramBoolean3);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))) {
      break label108;
    }
    label108:
    while ((Utils.a(this.jdField_a_of_type_AndroidContentContext) == 1) || (!VcSystemInfo.b())) {
      return;
    }
    boolean bool = paramBoolean2;
    if (a(this.jdField_a_of_type_ComTencentAvVideoController.a()))
    {
      bool = paramBoolean2;
      if (!paramBoolean2)
      {
        bool = paramBoolean2;
        if (!e()) {
          bool = true;
        }
      }
    }
    h();
    int i;
    String str;
    Object localObject;
    if (paramBoolean1)
    {
      i = a("setRemoteHasVideo_open", paramString, paramInt);
      str = VideoLayerUI.a(paramString, paramInt);
      if (i < 0)
      {
        i = a(0);
        if (i < 0) {
          break label719;
        }
        localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
        ((GLVideoView)localObject).a(paramString, paramInt);
        ((GLVideoView)localObject).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
      }
    }
    for (;;)
    {
      try
      {
        GraphicRenderMgr.getInstance().setGlRender(str, ((GLVideoView)localObject).a());
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_1], key[" + str + "], index[" + i + "], " + ((GLVideoView)localObject).b());
        this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, true);
        paramString = (String)localObject;
        if ((i <= 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4)) {
          break label713;
        }
        paramInt = i;
        if (paramString != null)
        {
          paramString.c(paramBoolean3);
          paramString.d(this.jdField_a_of_type_ComTencentAvUiScreenLayout.b());
          paramString.g(true);
          paramString.g(0);
          b();
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4) {
            break label580;
          }
          if (paramInt != 0) {
            break label570;
          }
          paramString.a(ImageView.ScaleType.CENTER_INSIDE);
        }
        if ((bool) && (paramInt > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().e))) {
          a(0, paramInt);
        }
        if (paramInt > 0) {
          j();
        }
        a(false);
        return;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      paramString = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      GraphicRenderMgr.getInstance().setGlRender(str, paramString.a());
      QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_2], key[" + str + "], index[" + i + "], " + paramString.b());
      this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, true);
      paramInt = i;
      continue;
      label570:
      paramString.a(ImageView.ScaleType.CENTER_CROP);
      continue;
      label580:
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2)
      {
        paramString.a(ImageView.ScaleType.CENTER_INSIDE);
        continue;
        i = a("setRemoteHasVideo_close", paramString, paramInt);
        if (i < 0) {
          break;
        }
        paramString = VideoLayerUI.a(paramString, paramInt);
        localObject = GraphicRenderMgr.getInstance();
        ((GraphicRenderMgr)localObject).flushGlRender(paramString);
        ((GraphicRenderMgr)localObject).setGlRender(paramString, null);
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_no], key[" + paramString + "], index[" + i + "]");
        this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().d, true, true);
        d(i);
        return;
        label713:
        paramInt = i;
        continue;
        label719:
        paramString = null;
      }
    }
  }
  
  protected void a(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    default: 
      return;
    case 6007: 
      ((ZimuLiveManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(9)).c();
      return;
    }
    e();
    paramObservable = (SentenceInfo)paramObservable[1];
    this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramObservable);
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "layoutVideoView virtical: " + paramBoolean + ", sessionType: " + this.jdField_a_of_type_ComTencentAvVideoController.a().d);
    }
    int i = super.g();
    int j = super.h();
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, 0, 0, 0);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b(0, 0, i, j);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].i(-16777216);
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (a(localSessionInfo))
    {
      ScreenLayout localScreenLayout = this.jdField_a_of_type_ComTencentAvUiScreenLayout;
      GLVideoView[] arrayOfGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      int k = this.h;
      int m = this.jdField_b_of_type_Int;
      int n = this.c;
      paramBoolean = bool;
      if (!localSessionInfo.jdField_a_of_type_Boolean) {
        paramBoolean = true;
      }
      localScreenLayout.a(arrayOfGLVideoView, i, j, k, m, n, paramBoolean);
      ARZimuTask.b(j, i);
    }
    for (;;)
    {
      super.v();
      return;
      if (b(localSessionInfo)) {
        a(paramBoolean, i, j, 0);
      }
    }
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "switchVideo index1: " + paramInt1 + ", index2: " + paramInt2);
    }
    if ((paramInt1 == paramInt2) || (paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) || (paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SmallScreenVideoLayerUI", 2, "switchVideo index invalid!");
      }
      return false;
    }
    a(paramInt1, paramInt2);
    return true;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setLocalHasVideo isLocalHasVideo: " + paramBoolean1 + ", forceToBigView: " + paramBoolean2 + ", mIsLocalHasVideo: " + this.jdField_a_of_type_Boolean);
    }
    if ((!VcSystemInfo.b()) || (Utils.a(this.jdField_a_of_type_AndroidContentContext) == 1)) {
      return false;
    }
    Object localObject2;
    int i;
    String str;
    if (paramBoolean1)
    {
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
      localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      i = a("setLocalHasVideo_open", (String)localObject2, 1);
      str = VideoLayerUI.a((String)localObject2, 1);
      if (i < 0)
      {
        int j = a(0);
        if (j >= 0)
        {
          localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
          ((GLVideoView)localObject1).a(0, localObject2);
          ((GLVideoView)localObject1).a(1, Integer.valueOf(1));
          ((GLVideoView)localObject1).a((String)localObject2);
          GraphicRenderMgr.getInstance().setAccountUin((String)localObject2);
          GraphicRenderMgr.getInstance().setGlRender(str, ((GLVideoView)localObject1).a());
          QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_1], key[" + str + "], index[" + j + "], " + ((GLVideoView)localObject1).b());
          this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, false);
        }
        i = j;
        localObject2 = localObject1;
        if (j > 1)
        {
          i = j;
          localObject2 = localObject1;
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4) {}
        }
        if (localObject2 != null)
        {
          ((GLVideoView)localObject2).c(false);
          ((GLVideoView)localObject2).g(false);
          ((GLVideoView)localObject2).i(true);
          ((GLVideoView)localObject2).g(0);
          ((GLVideoView)localObject2).a(ImageView.ScaleType.CENTER_CROP);
          if (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).c()) {
            ((GLVideoView)localObject2).d(CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
          }
          b();
        }
        if (i == 0)
        {
          j = e();
          if (j > 0) {
            a(i, j);
          }
        }
        a(false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = paramBoolean1;
      return true;
      localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      GraphicRenderMgr.getInstance().setGlRender(str, ((GLVideoView)localObject2).a());
      QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_2], key[" + str + "], index[" + i + "], " + ((GLVideoView)localObject2).b());
      this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, false);
      break;
      if (!paramBoolean1)
      {
        ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 8, null, false);
        localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        i = a("setLocalHasVideo_close", (String)localObject1, 1);
        if (i >= 0)
        {
          localObject1 = VideoLayerUI.a((String)localObject1, 1);
          localObject2 = GraphicRenderMgr.getInstance();
          ((GraphicRenderMgr)localObject2).flushGlRender((String)localObject1);
          ((GraphicRenderMgr)localObject2).clearCameraFrames();
          ((GraphicRenderMgr)localObject2).setGlRender((String)localObject1, null);
          QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_no], key[" + (String)localObject1 + "], index[" + i + "]");
          this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().d, true, false);
          d(i);
        }
      }
    }
  }
  
  public void b()
  {
    int i = d();
    if (this.jdField_a_of_type_Int != i)
    {
      this.jdField_a_of_type_Int = i;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI$SmallScreenListener != null) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI$SmallScreenListener.a(this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    if (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() != paramInt)
    {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout = ScreenLayout.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramInt, true);
      a(true);
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt].b(this.jdField_a_of_type_ComTencentAvUiScreenLayout.b());
        a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt]);
        paramInt += 1;
      }
    }
  }
  
  protected void c()
  {
    super.c();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].j(true);
      i += 1;
    }
  }
  
  protected void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, g(), h(), paramInt, this.jdField_b_of_type_Int, this.c);
  }
  
  protected void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "onFirstDraw");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new jps(this));
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy == null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy = new ZimuViewProxy(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoLayerUI
 * JD-Core Version:    0.7.0.1
 */