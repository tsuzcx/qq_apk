package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AVC2CDataHandler;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLViewGroup;
import com.tencent.av.switchface.SwitchFaceView;
import com.tencent.av.ui.funchat.magicface.MagicfaceViewProxy;
import com.tencent.av.utils.UITools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.TextureRender;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import kek;
import kel;
import kem;
import ken;

public class VideoLayerUIBase
  extends GLViewGroup
{
  public Context a;
  public Display a;
  public View a;
  protected ImageView a;
  public VideoController a;
  public VideoAppInterface a;
  protected GLRootView a;
  private SwitchFaceView jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView;
  private QavVideoRecordUICtrl jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
  public ScreenLayout a;
  MagicfaceViewProxy jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy = null;
  private RenderBuffer jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer;
  private TextureRender jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender;
  public Runnable a;
  public final String a;
  protected ken a;
  public boolean a;
  private float[] jdField_a_of_type_ArrayOfFloat;
  public GLVideoView[] a;
  public int b;
  public Runnable b;
  private boolean b;
  public int c;
  private boolean c;
  public int d;
  public int e = -1;
  public int f;
  public int g;
  public int h = 2;
  public int i;
  
  public VideoLayerUIBase(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaLangRunnable = new kek(this);
    this.jdField_b_of_type_JavaLangRunnable = new kel(this);
    this.jdField_a_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.a());
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onCreate:" + this + ", VideoAppInterface:" + paramVideoAppInterface + ", rootView:" + paramView);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366307));
    this.jdField_a_of_type_Ken = new ken(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Ken);
  }
  
  private void a(GLCanvas paramGLCanvas, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      AVC2CDataHandler localAVC2CDataHandler = AVC2CDataHandler.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (localAVC2CDataHandler != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (((SessionInfo)localObject).d == 2) {}
        for (int j = 1; j != 0; j = 0)
        {
          localObject = ((SessionInfo)localObject).c;
          int k = j();
          j = 0;
          while (j < k)
          {
            GLVideoView localGLVideoView = (GLVideoView)a(j);
            if ((localObject != null) && (((String)localObject).equals(localGLVideoView.a())))
            {
              byte[] arrayOfByte = localGLVideoView.a().c();
              localAVC2CDataHandler.a(localGLVideoView.a(), arrayOfByte);
            }
            j += 1;
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramGLCanvas);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.b();
      super.c(paramGLCanvas);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.c();
      return;
    }
    super.c(paramGLCanvas);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    Object localObject = (Object[])paramObject;
    switch (((Integer)localObject[0]).intValue())
    {
    default: 
      a(paramObservable, paramObject);
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          paramObservable = (String)localObject[1];
          paramObject = (Boolean)localObject[2];
          localObject = (FaceItem)((EffectFaceManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a(paramObservable);
          if ((localObject != null) && (((FaceItem)localObject).isInteract())) {}
          for (int j = 1; (d()) || (j == 0); j = 0)
          {
            p();
            this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy.a((ViewGroup)this.jdField_a_of_type_AndroidViewView, paramObservable, paramObject.booleanValue());
            return;
          }
        }
      } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3));
      p();
      paramObservable = (String)localObject[1];
      paramObject = (Boolean)localObject[2];
      this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy.b((ViewGroup)this.jdField_a_of_type_AndroidViewView, paramObservable, paramObject.booleanValue());
      return;
    } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3));
    p();
    this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy.a((ViewGroup)this.jdField_a_of_type_AndroidViewView);
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView == null) {
      return -1;
    }
    int j = paramInt;
    if (j < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
      k = j;
      if (!TextUtils.isEmpty(localGLVideoView.a())) {
        if (localGLVideoView.f() != 1) {
          break label94;
        }
      }
    }
    for (int k = j;; k = -1)
    {
      b("getUnusedView, start[" + paramInt + "], result_index[" + k + "]");
      return k;
      label94:
      j += 1;
      break;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int k = 0;
    int j = 1;
    int n = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131559761);
    int m = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131559762);
    if (paramInt4 - paramInt2 > n)
    {
      paramInt2 = 1;
      if (paramInt5 - paramInt3 <= m) {
        break label106;
      }
      paramInt4 = 1;
      label65:
      paramInt5 = c();
      if (paramInt5 != 3) {
        break label174;
      }
      if (paramInt1 != 1) {
        break label126;
      }
      paramInt3 = 3;
    }
    label106:
    label126:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return paramInt3;
                            if (paramInt4 - paramInt2 < -n)
                            {
                              paramInt2 = 2;
                              break;
                            }
                            paramInt2 = 0;
                            break;
                            paramInt4 = k;
                            if (paramInt5 - paramInt3 >= -m) {
                              break label65;
                            }
                            paramInt4 = 2;
                            break label65;
                            if (paramInt1 == 2) {
                              return 3;
                            }
                            if (paramInt1 == 4) {
                              return 3;
                            }
                            paramInt3 = j;
                          } while (paramInt1 != 3);
                          if (paramInt2 != 2) {
                            break label164;
                          }
                          paramInt3 = j;
                        } while (paramInt4 == 2);
                        return 4;
                        if (paramInt4 == 2) {
                          return 2;
                        }
                        return 3;
                        if (paramInt5 != 2) {
                          break label235;
                        }
                        if (paramInt1 == 1) {
                          return 2;
                        }
                        if (paramInt1 == 3) {
                          return 2;
                        }
                        if (paramInt1 == 4) {
                          return 2;
                        }
                        paramInt3 = j;
                      } while (paramInt1 != 2);
                      if (paramInt2 != 2) {
                        break label225;
                      }
                      paramInt3 = j;
                    } while (paramInt4 != 1);
                    return 4;
                    if (paramInt4 == 1) {
                      return 3;
                    }
                    return 2;
                    if (paramInt5 != 1) {
                      break label299;
                    }
                    paramInt3 = j;
                  } while (paramInt1 == 2);
                  paramInt3 = j;
                } while (paramInt1 == 3);
                paramInt3 = j;
              } while (paramInt1 == 4);
              paramInt3 = j;
            } while (paramInt1 != 1);
            if (paramInt2 == 1)
            {
              if (paramInt4 == 1) {
                return 3;
              }
              return 2;
            }
            paramInt3 = j;
          } while (paramInt4 != 1);
          return 4;
          paramInt3 = j;
        } while (paramInt5 != 4);
        if (paramInt1 == 1) {
          return 4;
        }
        if (paramInt1 == 2) {
          return 4;
        }
        if (paramInt1 == 3) {
          return 4;
        }
        paramInt3 = j;
      } while (paramInt1 != 4);
      if (paramInt2 == 1)
      {
        if (paramInt4 == 2) {
          return 2;
        }
        return 3;
      }
      paramInt3 = j;
    } while (paramInt4 == 2);
    label164:
    label174:
    label225:
    label235:
    return 4;
  }
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    int j;
    if (!TextUtils.isEmpty(paramString2))
    {
      j = 0;
      if (j < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
        if ((!paramString2.equals(localGLVideoView.a())) || (paramInt != localGLVideoView.d()) || (localGLVideoView.f() != 0)) {}
      }
    }
    for (;;)
    {
      b(paramString1 + ", uin[" + paramString2 + "], videoSrcType[" + paramInt + "], result_index[" + j + "]");
      return j;
      j += 1;
      break;
      j = -1;
    }
  }
  
  public long a(String paramString)
  {
    int j = 0;
    while (j < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
      if ((localGLVideoView.f() == 0) && (paramString.equals(localGLVideoView.a()))) {
        return localGLVideoView.a();
      }
      j += 1;
    }
    return 0L;
  }
  
  public String a()
  {
    String str = "[" + this.jdField_a_of_type_JavaLangString + "]VideoView[5]:\r\n";
    int j = 0;
    while (j < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
      str = str + "---------index[" + j + "], size[" + localGLVideoView.g() + ", " + localGLVideoView.h() + "], " + localGLVideoView.b() + "\r\n";
      j += 1;
    }
    return str;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].i();
    int k = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].i();
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].h(k);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].h(j);
    Object localObject;
    String str1;
    String str2;
    label139:
    float f1;
    boolean bool1;
    float f2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)
    {
      if (paramInt1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a();
        str2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a();
        if (!((String)localObject).equals(str1)) {
          break label694;
        }
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        j = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].b();
        f1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
        k = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
        bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].e();
        boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
        int m = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].b();
        f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
        int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
        boolean bool3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].e();
        boolean bool4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].e(bool4);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c(m);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(f2);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].b(n);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].f(bool3);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].e(bool2);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c(j);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(f1);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].b(k);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].f(bool1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1];
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2] = localObject;
      bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c(bool1);
      bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c(bool1);
      f1 = UITools.a(BaseApplicationImpl.getContext(), 10.0F);
      f2 = UITools.a(BaseApplicationImpl.getContext(), 14.0F);
      if (paramInt1 != 0) {
        break label719;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(f2);
      label465:
      if (paramInt2 != 0) {
        break label732;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(f2);
    }
    for (;;)
    {
      a(false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().e = e();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) {
        a(this.jdField_a_of_type_ComTencentAvVideoController.a());
      }
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a();
      str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a();
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "switchVideo, end, [" + paramInt1 + "]=[" + (String)localObject + "], [" + paramInt2 + "]=[" + str1 + "]");
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8005), localObject, str1 });
      return;
      if (paramInt2 != 0) {
        break;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      break;
      label694:
      if (!((String)localObject).equals(str2)) {
        break label139;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      break label139;
      label719:
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(f1);
      break label465;
      label732:
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(f1);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  void a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.i == 3000) {
      if (e()) {
        ReportController.b(null, "CliOper", "", "", "0X80041B3", "0X80041B3", 0, 0, "", "", "", "");
      }
    }
    while (paramSessionInfo.i != 1)
    {
      return;
      ReportController.b(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
      return;
    }
    if (e())
    {
      if (paramSessionInfo.D == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005939", "0X8005939", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80046E0", "0X80046E0", 0, 0, "", "", "", "");
      return;
    }
    if (paramSessionInfo.D == 10)
    {
      ReportController.b(null, "CliOper", "", "", "0X8005938", "0X8005938", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "CliOper", "", "", "0X80046DF", "0X80046DF", 0, 0, "", "", "", "");
  }
  
  public void a(GLVideoView paramGLVideoView)
  {
    if ((paramGLVideoView != null) && (!paramGLVideoView.h())) {
      if (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() != 2) {
        break label30;
      }
    }
    label30:
    for (boolean bool = true;; bool = false)
    {
      paramGLVideoView.d(bool);
      return;
    }
  }
  
  public void a(QavVideoRecordUICtrl paramQavVideoRecordUICtrl)
  {
    this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl = paramQavVideoRecordUICtrl;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int j = 0;
      while (j < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
        if ((paramString.equals((String)localGLVideoView.a(0))) && (localGLVideoView.f() == 0)) {
          localGLVideoView.c(paramBoolean);
        }
        j += 1;
      }
    }
  }
  
  public void a(Observable paramObservable, Object paramObject) {}
  
  public void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onLayout|left: " + paramInt1 + ", top: " + paramInt2 + ", right: " + paramInt3 + ", bottom: " + paramInt4);
    }
    a(false);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean a(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo.d == 1) || (paramSessionInfo.d == 2);
  }
  
  public int b()
  {
    return this.h;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a().L = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559746);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559747);
    Rect localRect = super.b();
    int m = localRect.width() - i1;
    int k = localRect.height() - i2;
    int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().left + paramInt1;
    paramInt2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().top + paramInt2;
    if (n < 0)
    {
      paramInt1 = 0;
      if (paramInt2 >= 0) {
        break label146;
      }
      paramInt2 = j;
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b(paramInt1, paramInt2, paramInt1 + i1, paramInt2 + i2);
      return;
      paramInt1 = m;
      if (n > m) {
        break;
      }
      paramInt1 = n;
      break;
      label146:
      if (paramInt2 > k) {
        paramInt2 = k;
      }
    }
  }
  
  void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = "printGLVideoView[" + paramString + "]\r\n";
      paramString = paramString + a();
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramString);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    paramInt = a("showNick", paramString, paramInt);
    if (paramInt >= 0)
    {
      paramString = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt];
      if (paramInt != 0) {
        break label51;
      }
      if ((this.jdField_b_of_type_Int != 0) && (this.jdField_c_of_type_Int != 0)) {
        paramString.f(false);
      }
    }
    else
    {
      return;
    }
    paramString.f(true);
    return;
    label51:
    paramString.f(true);
  }
  
  public boolean b(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo.d == 3) || (paramSessionInfo.d == 4);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    int j = a("isBigView", paramString, paramInt);
    b("isBigView, uin[" + paramString + "], videoSrcType[" + paramInt + "], result_index[" + j + "]");
    return j == 0;
  }
  
  public int c()
  {
    Rect localRect = super.b();
    int j = localRect.centerX();
    int k = localRect.centerY();
    int m = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().centerX();
    int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().centerY();
    if ((m < j) && (n < k)) {
      return 1;
    }
    if ((m < j) && (n > k)) {
      return 4;
    }
    if ((m > j) && (n < k)) {
      return 2;
    }
    if ((m > j) && (n > k)) {
      return 3;
    }
    return 0;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView = new GLVideoView[5];
    int j = 0;
    if (j < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j] = new GLVideoView(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(j) }));
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].g(1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].b(this.jdField_a_of_type_ComTencentAvUiScreenLayout.b());
      if (j == 0) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].h(j * 2);
      }
      for (;;)
      {
        a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j]);
        j += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].h((this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length - j) * 2);
      }
    }
  }
  
  public void c(int paramInt) {}
  
  @RequiresApi(api=17)
  protected void c(GLCanvas paramGLCanvas)
  {
    int j;
    if ((this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a()))
    {
      Object localObject;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = new RenderBuffer(paramGLCanvas.a(), paramGLCanvas.b(), 33984);
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = new TextureRender();
        this.jdField_c_of_type_Boolean = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.b();
        if (this.jdField_c_of_type_Boolean)
        {
          localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(paramGLCanvas.a(), paramGLCanvas.b(), true);
          this.jdField_a_of_type_ArrayOfFloat = new float[16];
          Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
          float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
          float f1 = localObject[1];
          j = paramGLCanvas.b();
          arrayOfFloat[5] = (f1 * 1.0F / (localObject[0] * j / paramGLCanvas.a()));
          this.jdField_a_of_type_ArrayOfFloat[13] = (1.0F - this.jdField_a_of_type_ArrayOfFloat[5]);
        }
      }
      else
      {
        a(paramGLCanvas, true);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, paramGLCanvas.a(), paramGLCanvas.b());
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a(3553, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a(), null, null);
        localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
        j = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
        if (!this.jdField_c_of_type_Boolean) {
          break label292;
        }
      }
      label292:
      for (paramGLCanvas = this.jdField_a_of_type_ArrayOfFloat;; paramGLCanvas = null)
      {
        ((QavVideoRecordUICtrl)localObject).a(3553, j, paramGLCanvas, null, SystemClock.elapsedRealtimeNanos());
        return;
        this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(paramGLCanvas.a(), paramGLCanvas.b(), false);
        break;
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      j = this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer.d();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererRenderBuffer = null;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererTextureRender = null;
      this.jdField_a_of_type_ArrayOfFloat = null;
      GLES20.glDeleteTextures(1, new int[] { j }, 0);
    }
    a(paramGLCanvas, false);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentAvUiScreenLayout.b();
  }
  
  public boolean e()
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
    if ((localGLVideoView.f() == 0) && (str.equals(localGLVideoView.a()))) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isLocalFront: " + bool);
      }
      b(String.format("isLocalFront, self isLocalFront[%s]", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int j = a("onCameraOpened_" + paramBoolean, str, 1);
    if (j >= 0) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].d(paramBoolean);
    }
  }
  
  public boolean f()
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int j = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (j < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
        if ((localGLVideoView.f() == 0) && (!str.equals(localGLVideoView.a()))) {
          bool1 = true;
        }
      }
      else
      {
        b("isRemoteHasVideo, peer isRemoteHasVideo[" + bool1 + "]");
        return bool1;
      }
      j += 1;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onDestroy:" + this);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Ken);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setOnTouchListener(null);
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(null);
    super.x();
    int j = 0;
    while (j < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].g(1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].i(true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].g(false);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].c(false);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].h(true);
      j += 1;
    }
    this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView.b();
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = null;
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView = null;
    this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView = null;
  }
  
  public boolean g()
  {
    int j = 0;
    boolean bool2;
    for (boolean bool1 = true;; bool1 = bool2)
    {
      bool2 = bool1;
      GLVideoView localGLVideoView;
      if (j < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
        bool2 = bool1;
        if (localGLVideoView.f() == 0)
        {
          bool1 = localGLVideoView.a();
          bool2 = bool1;
          if (!bool1)
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doGlassRemoteVideo failed !!!! i=" + j + ", getVisibility=" + localGLVideoView.f());
            bool2 = bool1;
          }
        }
      }
      else
      {
        if (!bool2) {
          break;
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        return false;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doGlassRemoteVideo i=" + j + ", getVisibility=" + localGLVideoView.f());
      j += 1;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doGlassRemoteVideo failed and cancel Glass");
    h();
    return false;
  }
  
  public boolean h()
  {
    int j = 0;
    while (j < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j];
      if (localGLVideoView.f() == 0) {
        localGLVideoView.b();
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doCancelGlassRemoteVideo i=" + j + ", getVisibility=" + localGLVideoView.f());
      j += 1;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    return false;
  }
  
  public void i() {}
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setVisibility(0);
    }
  }
  
  public void l(int paramInt)
  {
    int m = 0;
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559746);
    int i3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559747);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559748);
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131559749);
    if (this.jdField_c_of_type_Int == 0) {
      k = j;
    }
    Object localObject = super.b();
    int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().left;
    int i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().top;
    switch (paramInt)
    {
    default: 
      j = 0;
      k = m;
    }
    for (;;)
    {
      localObject = new kem(this, paramInt, n, i1, j, k, null);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post((Runnable)localObject);
      return;
      k += this.jdField_b_of_type_Int;
      continue;
      m = ((Rect)localObject).width();
      k += this.jdField_b_of_type_Int;
      j = m - j - i2;
      continue;
      m = ((Rect)localObject).width();
      k = ((Rect)localObject).height() - k - i3;
      j = m - j - i2;
      continue;
      k = ((Rect)localObject).height() - k - i3;
    }
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setVisibility(8);
    }
  }
  
  public void n()
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366260));
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this);
    this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView = this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.a();
    this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView.a(this);
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onPause();
    }
    if (this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView != null) {
      this.jdField_a_of_type_ComTencentAvSwitchfaceSwitchFaceView.c();
    }
  }
  
  void p()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy == null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy = new MagicfaceViewProxy(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public void q_()
  {
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    }
    a(this.g, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase
 * JD-Core Version:    0.7.0.1
 */