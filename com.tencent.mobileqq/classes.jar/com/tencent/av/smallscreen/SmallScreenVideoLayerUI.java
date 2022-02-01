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
import com.tencent.av.business.manager.zimu.ARZimuTask;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.utils.Utils;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.ControlUIObserver.ZimuRequest;
import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.ScreenLayout;
import com.tencent.av.ui.VideoAfterTreatmentManager;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.VideoLayerUIBase;
import com.tencent.av.ui.funchat.zimu.ZimuViewProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
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
    this.jdField_a_of_type_ComTencentAvUiScreenLayout = ScreenLayout.a(paramContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_ComTencentAvVideoController.a().N, true);
    n();
    m();
    l();
    r();
    t();
  }
  
  private void a(String paramString, YUVTexture paramYUVTexture)
  {
    if (!this.jdField_a_of_type_ComTencentAvVideoController.o())
    {
      GraphicRenderMgr.getInstance().setGlRender(paramString, paramYUVTexture);
      QLog.i("SmallScreenVideoLayerUI", 1, "setGlRender[small_screen], key[" + paramString + "], render[" + paramYUVTexture + "]");
    }
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
      if ((!this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].f()) || ((this.x != 0) && (this.x != 180)) || (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].k())) {
        break label208;
      }
      if (this.x != 0) {
        break label181;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, 0, 0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297844));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.jdField_a_of_type_ComTencentAvVideoController.a(), this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, paramInt1, paramInt2, paramBoolean, this.x, this.r);
      return;
      label181:
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131297844), 0, 0);
      continue;
      label208:
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(paramInt3, paramInt3, paramInt3, paramInt3);
    }
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
        if (localGLVideoView.j())
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
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "closeVideoView index: " + paramInt);
    }
    int j = 0;
    float f1 = 0.0F;
    int i = 0;
    boolean bool1 = false;
    Object localObject2 = ImageView.ScaleType.CENTER_INSIDE;
    int i1 = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
    Object localObject1 = localObject2;
    int n;
    if (paramInt == 0)
    {
      m = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].e();
      float f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d();
      n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].f();
      boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].i();
      localObject1 = localObject2;
      bool1 = bool2;
      i = n;
      f1 = f2;
      j = m;
      if (i1 == 4)
      {
        localObject1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a();
        j = m;
        f1 = f2;
        i = n;
        bool1 = bool2;
      }
    }
    int m = paramInt;
    while (m < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length) {
      if ((m < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length - 1) && (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(m + 1)].a() == 0))
      {
        n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[m].d();
        int i2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(m + 1)].d();
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[m].c(i2);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(m + 1)].c(n);
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[m];
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[m] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(m + 1)];
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[(m + 1)] = localObject2;
        m += 1;
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[m];
        ((GLVideoView)localObject2).a(1);
        x_();
        ((GLVideoView)localObject2).b(null);
        ((GLVideoView)localObject2).m(true);
        ((GLVideoView)localObject2).k(false);
        ((GLVideoView)localObject2).g(false);
        ((GLVideoView)localObject2).l(true);
        ((GLVideoView)localObject2).a(null, 0);
        ((GLVideoView)localObject2).a("");
      }
    }
    u();
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
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "initGlVideoViewBackground");
    }
  }
  
  private void t()
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
  
  private void u()
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
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setOffset topOffset: " + paramInt1 + ", bottomOffset: " + paramInt2);
    }
    this.q = paramInt1;
    this.r = paramInt2;
    c(true);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().J)
      {
        int i = 0;
        if (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
          if (i == 0) {
            if ((paramInt1 != 0) && (paramInt2 != 0)) {
              localGLVideoView.j(false);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            localGLVideoView.j(true);
            continue;
            localGLVideoView.j(true);
          }
        }
      }
      else
      {
        paramInt1 = 0;
        while (paramInt1 < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].j(false);
          paramInt1 += 1;
        }
      }
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if ((!this.d) && (!l())) {
      this.v = paramInt;
    }
    for (;;)
    {
      return;
      if ((paramInt != this.u) || (paramInt == this.v))
      {
        if (paramInt % 90 != this.u % 90) {
          this.s = 0;
        }
        this.u = paramInt;
        this.v = paramInt;
        int i = VideoLayerUI.a("SmallScreenVideoLayerUI", this.jdField_a_of_type_AndroidContentContext, paramInt, paramBoolean, this.jdField_a_of_type_AndroidViewDisplay);
        switch (paramInt)
        {
        }
        while (this.jdField_a_of_type_ComTencentAvVideoController.a().D == 2)
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
          return;
          paramInt = 0;
          while (paramInt < super.e())
          {
            super.a(paramInt).b(i);
            paramInt += 1;
          }
          this.x = i;
        }
      }
    }
  }
  
  void a(String paramString, int paramInt, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
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
        localGLVideoView.a(0);
        x_();
        u();
        localGLVideoView.a(0, paramString);
        localGLVideoView.a(1, Integer.valueOf(paramInt));
        localGLVideoView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        String str = VideoLayerUI.a(paramString, paramInt);
        a(str, null);
        a(str, localGLVideoView.a());
        long l = AudioHelper.b();
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[setBackground], key[" + str + "], index[" + j + "], seq[" + l + "], " + localGLVideoView.d());
        boolean bool1 = bool2;
        if (paramString != null)
        {
          bool1 = bool2;
          if (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin())) {
            bool1 = false;
          }
        }
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, bool1);
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
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setBackground uin: " + paramString + ", videoSrcType: " + paramInt + ", index: " + i + ", needRenderVideo: " + paramBoolean1);
    }
  }
  
  void a(String paramString1, int paramInt1, String paramString2, float paramFloat, int paramInt2)
  {
    boolean bool = false;
    int i = a("setText", paramString1, paramInt1);
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "setText uin: " + paramString1 + ", videoSrcType: " + paramInt1 + ", text: " + paramString2 + ", textSize: " + paramFloat + ", textColor: " + paramInt2 + ", index: " + i);
    }
    if (i >= 0)
    {
      paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      paramString1.a(0);
      x_();
      u();
      paramString1.b(paramString2);
      paramString1.a(paramFloat);
      paramString1.k(paramInt2);
      if (i != 0) {
        bool = true;
      }
      paramString1.h(bool);
      if (i == 0) {
        paramString1.j(12);
      }
    }
    else
    {
      return;
    }
    paramString1.j(2147483647);
  }
  
  void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoLayerUI", 1, "setRemoteHasVideo, uin[" + paramString + "], videoSrcType[" + paramInt + "], isRemoteHasVideo[" + paramBoolean1 + "], forceToBigView[" + paramBoolean2 + "], mIsLocalHasVideo[" + this.d + "], isFillBlackEdge[" + paramBoolean3 + "], seq[" + l + "]");
    }
    if ((TextUtils.isEmpty(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))) {
      break label129;
    }
    label129:
    while (Utils.a(this.jdField_a_of_type_AndroidContentContext) == 1) {
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
          break label736;
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
        a(str, ((GLVideoView)localObject).a());
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_1], key[" + str + "], index[" + i + "], " + ((GLVideoView)localObject).d());
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, true);
        paramString = (String)localObject;
        if ((i <= 1) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4)) {
          break label730;
        }
        paramInt = i;
        if (paramString != null)
        {
          paramString.g(paramBoolean3);
          paramString.a(l, this.jdField_a_of_type_ComTencentAvUiScreenLayout.c());
          paramString.k(true);
          paramString.a(0);
          x_();
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4) {
            break label596;
          }
          if (paramInt != 0) {
            break label586;
          }
          paramString.a(ImageView.ScaleType.CENTER_INSIDE);
        }
        if ((bool) && (paramInt > 0) && ((this.jdField_a_of_type_ComTencentAvVideoController.a().d != 2) || (this.jdField_a_of_type_ComTencentAvVideoController.a().i))) {
          a(0, paramInt);
        }
        if (paramInt > 0) {
          u();
        }
        c(false);
        return;
      }
      catch (UnsatisfiedLinkError paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      paramString = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      a(str, paramString.a());
      QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[RemoteHasVideo_2], key[" + str + "], index[" + i + "], " + paramString.d());
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, true);
      paramInt = i;
      continue;
      label586:
      paramString.a(ImageView.ScaleType.CENTER_CROP);
      continue;
      label596:
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
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, true, true);
        i(i);
        return;
        label730:
        paramInt = i;
        continue;
        label736:
        paramString = null;
      }
    }
  }
  
  public void a(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    case 6006: 
    case 6007: 
    default: 
    case 6005: 
      do
      {
        return;
      } while (((ControlUIObserver.ZimuRequest)ControlUIObserver.a(paramObservable)).a != 2);
      return;
    }
    o();
    paramObservable = (SentenceInfo)paramObservable[1];
    this.jdField_a_of_type_ComTencentAvUiFunchatZimuZimuViewProxy.a(paramObservable);
  }
  
  public boolean a(int paramInt1, int paramInt2)
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
    c(paramInt1, paramInt2);
    return true;
  }
  
  boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    Object localObject4 = null;
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoLayerUI", 1, "setLocalHasVideo, isLocalHasVideo[" + this.d + "->" + paramBoolean1 + "], forceToBigView[" + paramBoolean2 + "], seq[" + l + "]");
    }
    if (Utils.a(this.jdField_a_of_type_AndroidContentContext) == 1) {
      return false;
    }
    int i;
    String str1;
    Object localObject3;
    if (paramBoolean1)
    {
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
      String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      i = a("setLocalHasVideo_open", str2, 1);
      str1 = VideoLayerUI.a(str2, 1);
      if (i < 0)
      {
        int j = a(0);
        if (j >= 0)
        {
          localObject3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
          ((GLVideoView)localObject3).a(0, str2);
          ((GLVideoView)localObject3).a(1, Integer.valueOf(1));
          ((GLVideoView)localObject3).a(str2);
        }
        try
        {
          GraphicRenderMgr.getInstance().setAccountUin(str2);
          a(str1, ((GLVideoView)localObject3).a());
          localObject1 = localObject4;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            localObject2 = "UnsatisfiedLinkError" + localUnsatisfiedLinkError.getMessage();
          }
        }
        QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_1], key[" + str1 + "], index[" + j + "], log[" + localObject1 + "], " + ((GLVideoView)localObject3).d());
        this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, false);
        localObject1 = localObject3;
        localObject3 = localObject1;
        i = j;
        if (j <= 1) {
          break label566;
        }
        localObject3 = localObject1;
        i = j;
        if (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 4) {
          break label566;
        }
        i = j;
        if (localObject1 != null)
        {
          localObject1.g(false);
          localObject1.k(false);
          localObject1.m(true);
          localObject1.a(0);
          localObject1.a(ImageView.ScaleType.CENTER_CROP);
          if (CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(l)) {
            localObject1.a(l, CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a());
          }
          x_();
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
    }
    for (;;)
    {
      this.d = paramBoolean1;
      return true;
      localObject3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      a(str1, ((GLVideoView)localObject3).a());
      QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_2], key[" + str1 + "], index[" + i + "], " + ((GLVideoView)localObject3).d());
      this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, false, false);
      label566:
      Object localObject2 = localObject3;
      break;
      if (!paramBoolean1)
      {
        ThreadManager.post(this.b, 8, null, false);
        localObject2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        i = a("setLocalHasVideo_close", (String)localObject2, 1);
        if (i >= 0)
        {
          localObject2 = VideoLayerUI.a((String)localObject2, 1);
          localObject3 = GraphicRenderMgr.getInstance();
          ((GraphicRenderMgr)localObject3).flushGlRender((String)localObject2);
          ((GraphicRenderMgr)localObject3).clearCameraFrames();
          ((GraphicRenderMgr)localObject3).setGlRender((String)localObject2, null);
          QLog.w("SmallScreenVideoLayerUI", 1, "setGlRender[LocalHasVideo_no], key[" + (String)localObject2 + "], index[" + i + "]");
          this.jdField_a_of_type_ComTencentAvVideoController.a(l, this.jdField_a_of_type_ComTencentAvVideoController.a().d, true, false);
          i(i);
        }
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    boolean bool = true;
    int i = super.b();
    int j = super.c();
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (QLog.isColorLevel()) {
      QLog.w("SmallScreenVideoLayerUI", 1, "layoutVideoView, virtical[" + paramBoolean + "], sessionType[" + localSessionInfo.d + "], width[" + i + "], height[" + j + "]");
    }
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, 0, 0, 0);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b(0, 0, i, j);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d(-15197410);
    if (a(localSessionInfo))
    {
      ScreenLayout localScreenLayout = this.jdField_a_of_type_ComTencentAvUiScreenLayout;
      GLVideoView[] arrayOfGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      int m = this.w;
      int n = this.q;
      int i1 = this.r;
      if (!localSessionInfo.e)
      {
        paramBoolean = bool;
        localScreenLayout.a(arrayOfGLVideoView, i, j, m, n, i1, paramBoolean);
        ARZimuTask.b(j, i);
      }
    }
    for (;;)
    {
      super.b();
      return;
      paramBoolean = false;
      break;
      if (b(localSessionInfo)) {
        a(paramBoolean, i, j, 0);
      }
    }
  }
  
  public void e()
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
  
  public void h(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUiScreenLayout.a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView, b(), c(), paramInt, this.q, this.r);
  }
  
  public void m()
  {
    this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager = new VideoAfterTreatmentManager(this.jdField_a_of_type_ComTencentAvVideoController);
  }
  
  public void n()
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
  
  void x_()
  {
    int i = g();
    if (this.k != i)
    {
      this.k = i;
      if (this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI$SmallScreenListener != null) {
        this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenVideoLayerUI$SmallScreenListener.a(this.k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoLayerUI
 * JD-Core Version:    0.7.0.1
 */