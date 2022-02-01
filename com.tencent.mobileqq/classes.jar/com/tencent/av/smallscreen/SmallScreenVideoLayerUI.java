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
  ZimuViewProxy I;
  private SmallScreenVideoLayerUI.SmallScreenListener J = null;
  private int K = 0;
  
  public SmallScreenVideoLayerUI(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView, SmallScreenVideoLayerUI.SmallScreenListener paramSmallScreenListener)
  {
    super(paramVideoAppInterface, paramContext, paramView);
    this.J = paramSmallScreenListener;
    this.at = 2;
    this.aj = ScreenLayout.a(paramContext, this.Y, this.Z.k().bM, true);
    C();
    A();
    H();
    I();
  }
  
  private int F()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.ae.length; j = k)
    {
      GLVideoView localGLVideoView = this.ae[i];
      String str = (String)localGLVideoView.d(0);
      k = j;
      if (localGLVideoView.b() == 0)
      {
        k = j;
        if (localGLVideoView.O())
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
  
  private void H()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "initGlVideoViewBackground");
    }
  }
  
  private void I()
  {
    if (this.ae != null)
    {
      int i = 1;
      while (i < this.ae.length)
      {
        this.ae[i].c(-1);
        i += 1;
      }
    }
  }
  
  private int J()
  {
    String str1 = this.Y.getCurrentAccountUin();
    int i = 0;
    while (i < this.ae.length)
    {
      GLVideoView localGLVideoView = this.ae[i];
      String str2 = (String)localGLVideoView.d(0);
      if ((localGLVideoView.b() == 0) && (!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void K()
  {
    if (this.ae[0].b() == 0)
    {
      String str1 = this.Y.getCurrentAccountUin();
      String str2 = (String)this.ae[0].d(0);
      if ((str2 != null) && (str2.equals(str1)))
      {
        int i = J();
        if (i > 0) {
          c(0, i);
        }
      }
    }
  }
  
  private static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private void a(long paramLong, GLVideoView paramGLVideoView, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramGLVideoView != null)
    {
      String str = a(paramString, paramInt);
      paramGLVideoView.a(paramString, paramInt);
      paramGLVideoView.a(0);
      paramGLVideoView.a(this.Y.getCurrentAccountUin());
      try
      {
        paramString = paramGLVideoView.B();
        GraphicRenderMgr.getInstance().setAccountUin(this.Y.getCurrentAccountUin());
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
        QLog.w("SmallScreenVideoLayerUI", 1, localStringBuilder.toString());
        return;
      }
      catch (UnsatisfiedLinkError paramGLVideoView)
      {
        paramGLVideoView.printStackTrace();
      }
    }
  }
  
  private void a(String paramString, YUVTexture paramYUVTexture)
  {
    if (!this.Z.ag())
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
    if (this.Z.k().o == 2)
    {
      this.ae[0].a(Boolean.valueOf(true));
      this.ae[1].a(Boolean.valueOf(true));
      this.ae[2].a(Boolean.valueOf(true));
      this.ae[3].a(Boolean.valueOf(true));
      this.ae[4].a(Boolean.valueOf(true));
      if ((this.ae[0].D()) && ((this.au == 0) || (this.au == 180)) && (!this.ae[0].Q()))
      {
        if (this.au == 0) {
          this.ae[0].a(0, 0, 0, this.X.getResources().getDimensionPixelSize(2131298507));
        } else {
          this.ae[0].a(0, this.X.getResources().getDimensionPixelSize(2131298507), 0, 0);
        }
      }
      else {
        this.ae[0].a(paramInt3, paramInt3, paramInt3, paramInt3);
      }
    }
    this.aj.a(this.Z.k(), this.ae, paramInt1, paramInt2, paramBoolean, this.au, this.ac);
  }
  
  private void k(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("closeVideoView index: ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("SmallScreenVideoLayerUI", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ImageView.ScaleType.CENTER_INSIDE;
    int n = this.Z.k().g;
    int m;
    int j;
    float f1;
    int i;
    boolean bool1;
    if (paramInt == 0)
    {
      k = this.ae[0].K();
      float f2 = this.ae[0].J();
      m = this.ae[0].L();
      boolean bool2 = this.ae[0].N();
      j = k;
      f1 = f2;
      i = m;
      bool1 = bool2;
      if (n == 4)
      {
        localObject1 = this.ae[0].P();
        j = k;
        f1 = f2;
        i = m;
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
    int k = paramInt;
    while (k < this.ae.length)
    {
      if (k < this.ae.length - 1)
      {
        localObject2 = this.ae;
        m = k + 1;
        if (localObject2[m].b() == 0)
        {
          int i1 = this.ae[k].j();
          int i2 = this.ae[m].j();
          this.ae[k].c(i2);
          this.ae[m].c(i1);
          localObject2 = this.ae[k];
          this.ae[k] = this.ae[m];
          this.ae[m] = localObject2;
          k = m;
          continue;
        }
      }
      Object localObject2 = this.ae[k];
      ((GLVideoView)localObject2).a(1);
      B();
      ((GLVideoView)localObject2).b(null);
      ((GLVideoView)localObject2).n(true);
      ((GLVideoView)localObject2).l(false);
      ((GLVideoView)localObject2).h(false);
      ((GLVideoView)localObject2).m(true);
      ((GLVideoView)localObject2).a(null, 0);
      ((GLVideoView)localObject2).a("");
    }
    K();
    if (paramInt == 0)
    {
      this.ae[0].i(false);
      this.ae[0].m(j);
      this.ae[0].a(f1);
      this.ae[0].l(i);
      this.ae[0].k(bool1);
      if (n == 4) {
        this.ae[0].a((ImageView.ScaleType)localObject1);
      }
    }
    c(false);
  }
  
  protected void A()
  {
    this.ad = ((GLRootView)this.aa.findViewById(2013331456));
    this.ad.setContentPane(this);
  }
  
  void B()
  {
    int i = F();
    if (this.K != i)
    {
      this.K = i;
      SmallScreenVideoLayerUI.SmallScreenListener localSmallScreenListener = this.J;
      if (localSmallScreenListener != null) {
        localSmallScreenListener.a(this.K);
      }
    }
  }
  
  protected void C()
  {
    super.C();
    int i = 0;
    while (i < this.ae.length)
    {
      this.ae[i].o(true);
      i += 1;
    }
  }
  
  void D()
  {
    if (this.I == null) {
      this.I = new ZimuViewProxy(this.Y, this.X);
    }
  }
  
  public void E()
  {
    super.E();
    if (this.aj != null)
    {
      this.aj.a();
      this.aj = null;
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
    this.ab = paramInt1;
    this.ac = paramInt2;
    c(true);
    if (this.Z.k().g == 4)
    {
      if (!this.Z.k().am)
      {
        int i = 0;
        while (i < this.ae.length)
        {
          localObject = this.ae[i];
          if (i == 0)
          {
            if ((paramInt1 != 0) && (paramInt2 != 0)) {
              ((GLVideoView)localObject).k(false);
            } else {
              ((GLVideoView)localObject).k(true);
            }
          }
          else {
            ((GLVideoView)localObject).k(true);
          }
          i += 1;
        }
      }
      paramInt1 = 0;
      while (paramInt1 < this.ae.length)
      {
        this.ae[paramInt1].k(false);
        paramInt1 += 1;
      }
    }
  }
  
  @TargetApi(11)
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((!this.V) && (!Z()))
    {
      this.as = paramInt;
      return;
    }
    if ((paramInt == this.ar) && (paramInt != this.as)) {
      return;
    }
    int i = this.ar;
    boolean bool = false;
    if (paramInt % 90 != i % 90) {
      this.ag = 0;
    }
    this.ar = paramInt;
    this.as = paramInt;
    i = VideoLayerUI.a("SmallScreenVideoLayerUI", this.X, paramInt, paramBoolean, this.av);
    if ((paramInt == 0) || (paramInt == 90) || (paramInt == 180) || (paramInt == 270))
    {
      paramInt = 0;
      while (paramInt < super.t())
      {
        super.h(paramInt).b(i);
        paramInt += 1;
      }
      this.au = i;
    }
    if (this.Z.k().o == 2)
    {
      if (this.au != 0)
      {
        paramBoolean = bool;
        if (this.au != 180) {}
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
      j = r(0);
      if (j >= 0)
      {
        localGLVideoView = this.ae[j];
        localGLVideoView.a(0);
        B();
        K();
        localGLVideoView.a(0, paramString);
        localGLVideoView.a(1, Integer.valueOf(paramInt));
        localGLVideoView.a(this.Y.getCurrentAccountUin());
        String str = VideoLayerUI.a(paramString, paramInt);
        a(str, null);
        a(str, localGLVideoView.B());
        long l = AudioHelper.c();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setGlRender[setBackground], key[");
        localStringBuilder.append(str);
        localStringBuilder.append("], index[");
        localStringBuilder.append(j);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(l);
        localStringBuilder.append("], ");
        localStringBuilder.append(localGLVideoView.T());
        QLog.w("SmallScreenVideoLayerUI", 1, localStringBuilder.toString());
        boolean bool;
        if ((paramString != null) && (paramString.equals(this.Y.getCurrentAccountUin()))) {
          bool = false;
        } else {
          bool = true;
        }
        this.Z.a(l, this.Z.k().g, false, bool);
      }
      i = j;
      if (paramBoolean2)
      {
        i = j;
        if (j > 0)
        {
          c(0, j);
          i = 0;
        }
      }
    }
    if (i >= 0)
    {
      localGLVideoView = this.ae[i];
      localGLVideoView.a(paramBitmap);
      localGLVideoView.n(paramBoolean1);
      if (!paramBoolean1) {
        localGLVideoView.l(false);
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
      paramString1 = this.ae[i];
      boolean bool = false;
      paramString1.a(0);
      B();
      K();
      paramString1.b(paramString2);
      paramString1.a(paramFloat);
      paramString1.m(paramInt2);
      if (i != 0) {
        bool = true;
      }
      paramString1.i(bool);
      if (i == 0)
      {
        paramString1.l(12);
        return;
      }
      paramString1.l(2147483647);
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    paramInt = a("enableAvatar2D", paramString, paramInt);
    if (paramInt >= 0)
    {
      this.ae[paramInt].c(paramBoolean);
      this.ae[paramInt].m();
    }
    else
    {
      int i = r(0);
      paramInt = i;
      if (i >= 0)
      {
        paramString = this.ae[i];
        paramString.c(paramBoolean);
        paramString.m();
        paramInt = i;
      }
    }
    if (paramInt > 0) {
      c(0, paramInt);
    }
  }
  
  void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    long l = AudioHelper.c();
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
      ((StringBuilder)localObject1).append(this.V);
      ((StringBuilder)localObject1).append("], isFillBlackEdge[");
      ((StringBuilder)localObject1).append(paramBoolean3);
      ((StringBuilder)localObject1).append("], seq[");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append("]");
      QLog.w("SmallScreenVideoLayerUI", 1, ((StringBuilder)localObject1).toString());
    }
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals(this.Y.getCurrentAccountUin())) {
        return;
      }
      if (Utils.a(this.X) == 1) {
        return;
      }
      boolean bool = paramBoolean2;
      if (b(this.Z.k()))
      {
        bool = paramBoolean2;
        if (!paramBoolean2)
        {
          bool = paramBoolean2;
          if (!Y()) {
            bool = true;
          }
        }
      }
      ab();
      if (paramBoolean1)
      {
        i = a("setRemoteHasVideo_open", paramString, paramInt);
        Object localObject2 = VideoLayerUI.a(paramString, paramInt);
        if (i < 0)
        {
          i = r(0);
          if (i >= 0)
          {
            localObject1 = this.ae[i];
            ((GLVideoView)localObject1).a(paramString, paramInt);
            ((GLVideoView)localObject1).a(this.Y.getCurrentAccountUin());
            try
            {
              a((String)localObject2, ((GLVideoView)localObject1).B());
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
            paramString.append(((GLVideoView)localObject1).T());
            QLog.w("SmallScreenVideoLayerUI", 1, paramString.toString());
            localObject2 = this.Z;
            paramInt = this.Z.k().g;
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
            paramInt = this.Z.k().g;
            paramInt = i;
            localObject1 = paramString;
          }
        }
        else
        {
          localObject1 = this.ae[i];
          a((String)localObject2, ((GLVideoView)localObject1).B());
          paramString = new StringBuilder();
          paramString.append("setGlRender[RemoteHasVideo_2], key[");
          paramString.append((String)localObject2);
          paramString.append("], index[");
          paramString.append(i);
          paramString.append("], ");
          paramString.append(((GLVideoView)localObject1).T());
          QLog.w("SmallScreenVideoLayerUI", 1, paramString.toString());
          this.Z.a(l, this.Z.k().g, false, true);
          paramInt = i;
        }
        if (localObject1 != null)
        {
          ((GLVideoView)localObject1).h(paramBoolean3);
          ((GLVideoView)localObject1).a(l, this.aj.e());
          ((GLVideoView)localObject1).l(true);
          ((GLVideoView)localObject1).a(0);
          B();
          if (this.Z.k().g == 4)
          {
            if (paramInt == 0) {
              ((GLVideoView)localObject1).a(ImageView.ScaleType.CENTER_INSIDE);
            } else {
              ((GLVideoView)localObject1).a(ImageView.ScaleType.CENTER_CROP);
            }
          }
          else if (this.Z.k().g == 2) {
            ((GLVideoView)localObject1).a(ImageView.ScaleType.CENTER_INSIDE);
          }
        }
        if ((bool) && (paramInt > 0) && ((this.Z.k().g != 2) || (this.Z.k().G))) {
          c(0, paramInt);
        }
        if (paramInt > 0) {
          K();
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
        this.Z.a(l, this.Z.k().g, true, true);
        k(i);
      }
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    int j = a("enableAvatar2D", paramString, 1);
    int i = j;
    if (j < 0)
    {
      i = r(0);
      if ((!this.Z.k().I) && (!this.Z.k().H)) {
        a(this.Z.k().s, 1, true, false, false);
      }
      if (i >= 0)
      {
        GLVideoView localGLVideoView = this.ae[i];
        a(AudioHelper.c(), this.ae[i], paramString, 1, true);
        localGLVideoView.c(true);
        localGLVideoView.m();
        if (i > 0) {
          c(0, i);
        }
      }
    }
    if (i >= 0)
    {
      this.ae[i].a(paramArrayOfByte);
      this.ae[i].m();
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
      D();
      paramObservable = (SentenceInfo)paramObservable[1];
      this.I.a(paramObservable);
      return;
    }
    i = ((ControlUIObserver.ZimuRequest)ControlUIObserver.a(paramObservable)).b;
  }
  
  boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setLocalHasVideo, isLocalHasVideo[");
      ((StringBuilder)localObject1).append(this.V);
      ((StringBuilder)localObject1).append("->");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append("], forceToBigView[");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append("], seq[");
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append("]");
      QLog.w("SmallScreenVideoLayerUI", 1, ((StringBuilder)localObject1).toString());
    }
    if (Utils.a(this.X) == 1) {
      return false;
    }
    Object localObject1 = null;
    StringBuilder localStringBuilder = null;
    int i;
    Object localObject3;
    Object localObject2;
    if (paramBoolean1)
    {
      if (!this.Z.k().cv) {
        ThreadManager.post(this.ap, 8, null, false);
      }
      String str2 = this.Y.getCurrentAccountUin();
      i = a("setLocalHasVideo_open", str2, 1);
      String str1 = VideoLayerUI.a(str2, 1);
      int j;
      if (i < 0)
      {
        i = r(0);
        if (i >= 0)
        {
          localObject3 = this.ae[i];
          ((GLVideoView)localObject3).a(0, str2);
          ((GLVideoView)localObject3).a(1, Integer.valueOf(1));
          ((GLVideoView)localObject3).a(str2);
          try
          {
            GraphicRenderMgr.getInstance().setAccountUin(str2);
            a(str1, ((GLVideoView)localObject3).B());
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
          localStringBuilder.append(((GLVideoView)localObject3).T());
          QLog.w("SmallScreenVideoLayerUI", 1, localStringBuilder.toString());
          this.Z.a(l, this.Z.k().g, false, false);
          localObject2 = localObject3;
        }
        if (i > 1) {
          j = this.Z.k().g;
        }
      }
      else
      {
        localObject2 = this.ae[i];
        a(str1, ((GLVideoView)localObject2).B());
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("setGlRender[LocalHasVideo_2], key[");
        ((StringBuilder)localObject3).append(str1);
        ((StringBuilder)localObject3).append("], index[");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("], ");
        ((StringBuilder)localObject3).append(((GLVideoView)localObject2).T());
        QLog.w("SmallScreenVideoLayerUI", 1, ((StringBuilder)localObject3).toString());
        this.Z.a(l, this.Z.k().g, false, false);
      }
      if (localObject2 != null)
      {
        ((GLVideoView)localObject2).h(false);
        ((GLVideoView)localObject2).l(false);
        ((GLVideoView)localObject2).n(true);
        ((GLVideoView)localObject2).a(0);
        ((GLVideoView)localObject2).a(ImageView.ScaleType.CENTER_CROP);
        if (CameraUtils.a(this.X).isCameraOpened(l)) {
          ((GLVideoView)localObject2).a(l, CameraUtils.a(this.X).isFrontCamera());
        }
        B();
      }
      if (i == 0)
      {
        j = J();
        if (j > 0) {
          c(i, j);
        }
      }
      c(false);
    }
    else if (!paramBoolean1)
    {
      ThreadManager.post(this.aq, 8, null, false);
      localObject2 = this.Y.getCurrentAccountUin();
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
        this.Z.a(l, this.Z.k().g, true, false);
        k(i);
      }
    }
    this.V = paramBoolean1;
    return true;
  }
  
  public void c(boolean paramBoolean)
  {
    int i = super.g();
    int j = super.h();
    SessionInfo localSessionInfo = this.Z.k();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("layoutVideoView, virtical[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], sessionType[");
      localStringBuilder.append(localSessionInfo.g);
      localStringBuilder.append("], width[");
      localStringBuilder.append(i);
      localStringBuilder.append("], height[");
      localStringBuilder.append(j);
      localStringBuilder.append("]");
      QLog.w("SmallScreenVideoLayerUI", 1, localStringBuilder.toString());
    }
    this.ae[0].a(0, 0, 0, 0);
    this.ae[0].c(0, 0, i, j);
    this.ae[0].e(-15197410);
    if (b(localSessionInfo)) {
      this.aj.a(this.ae, i, j, this.at, this.ab, this.ac, localSessionInfo.B ^ true);
    } else if (c(localSessionInfo)) {
      a(paramBoolean, i, j, 0);
    }
    super.m();
  }
  
  protected boolean c(int paramInt1, int paramInt2)
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
    if ((paramInt1 != paramInt2) && (paramInt1 >= 0) && (paramInt1 < this.ae.length) && (paramInt2 >= 0) && (paramInt2 < this.ae.length))
    {
      d(paramInt1, paramInt2);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "switchVideo index invalid!");
    }
    return false;
  }
  
  public void i(int paramInt)
  {
    super.i(paramInt);
    if (this.aj.b() != paramInt)
    {
      this.aj = ScreenLayout.a(this.X, this.Y, paramInt, true);
      c(true);
      paramInt = 0;
      while (paramInt < this.ae.length)
      {
        this.ae[paramInt].e(this.aj.e());
        a(-1049L, this.ae[paramInt]);
        paramInt += 1;
      }
    }
  }
  
  protected void j(int paramInt)
  {
    this.aj.a(this.ae, g(), h(), paramInt, this.ab, this.ac);
  }
  
  protected void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SmallScreenVideoLayerUI", 2, "onFirstDraw");
    }
    if (this.Y != null) {
      this.Y.a().post(new SmallScreenVideoLayerUI.1(this));
    }
  }
  
  public int z()
  {
    return this.aj.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoLayerUI
 * JD-Core Version:    0.7.0.1
 */