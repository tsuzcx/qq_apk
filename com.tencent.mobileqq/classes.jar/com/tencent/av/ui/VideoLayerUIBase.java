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
import android.util.SparseArray;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.av.VideoConstants;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AVC2CDataHandler;
import com.tencent.av.business.manager.magicface.EffectFaceManager;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.opengl.Tlv;
import com.tencent.av.opengl.TlvUtils;
import com.tencent.av.opengl.effects.AEKitAbilityInfo;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.glrenderer.GLES20Canvas;
import com.tencent.av.opengl.texture.BitmapTexture;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.opengl.ui.GLView;
import com.tencent.av.opengl.ui.GLViewGroup;
import com.tencent.av.ui.funchat.magicface.MagicfaceViewProxy;
import com.tencent.av.utils.UITools;
import com.tencent.av.wtogether.gles.WatchTogetherVideoBgRender;
import com.tencent.av.wtogether.gles.WatchTogetherVideoRenderHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.BitSet;
import java.util.List;
import java.util.Observable;
import mqq.os.MqqHandler;

public class VideoLayerUIBase
  extends GLViewGroup
{
  private long jdField_a_of_type_Long = 0L;
  protected Context a;
  protected Display a;
  public View a;
  protected ImageView a;
  protected VideoController a;
  public VideoAppInterface a;
  protected BitmapTexture a;
  protected GLVideoView a;
  private QavVideoRecordUICtrl jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl = null;
  protected ScreenLayout a;
  protected VideoAfterTreatmentManager a;
  protected VideoLayerUIBase.MyDataObserver a;
  MagicfaceViewProxy jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy = null;
  protected WatchTogetherVideoBgRender a;
  protected WatchTogetherVideoRenderHelper a;
  protected Runnable a;
  final String jdField_a_of_type_JavaLangString = getClass().getSimpleName() + "_" + AudioHelper.b();
  private float[] jdField_a_of_type_ArrayOfFloat = null;
  public GLVideoView[] a;
  long jdField_b_of_type_Long = 0L;
  protected GLRootView b;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  protected Runnable b;
  private TextureRender jdField_c_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  private boolean jdField_c_of_type_Boolean = false;
  private Rect d;
  protected boolean d;
  protected boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private int k = 0;
  public int q = 0;
  public int r = 0;
  protected int s = 0;
  public int t = -1;
  protected int u = 0;
  protected int v = 0;
  public int w = 2;
  protected int x = 0;
  
  public VideoLayerUIBase(VideoAppInterface paramVideoAppInterface, Context paramContext, View paramView)
  {
    super(paramContext);
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = null;
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_d_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_JavaLangRunnable = new VideoLayerUIBase.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new VideoLayerUIBase.2(this);
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "onCreate:" + this + ", VideoAppInterface:" + paramVideoAppInterface + ", rootView:" + paramView);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363182));
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase$MyDataObserver = new VideoLayerUIBase.MyDataObserver(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase$MyDataObserver);
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo.jdField_d_of_type_Int == 1) || (paramSessionInfo.jdField_d_of_type_Int == 2);
  }
  
  private void b(Observable paramObservable, Object paramObject)
  {
    Object[] arrayOfObject = (Object[])paramObject;
    switch (((Integer)arrayOfObject[0]).intValue())
    {
    default: 
      a(paramObservable, paramObject);
    }
    label154:
    label158:
    do
    {
      do
      {
        for (;;)
        {
          return;
          paramObservable = (ControlUIObserver.RequestPlayMagicFace)ControlUIObserver.a(arrayOfObject);
          paramObject = (FaceItem)((EffectFaceManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a(paramObservable.c);
          int i;
          if ((paramObject != null) && (paramObject.isInCreative()))
          {
            i = 1;
            if ((paramObject == null) || (!paramObject.isInteract())) {
              break label154;
            }
          }
          for (int j = 1;; j = 0)
          {
            if ((!i()) && (j != 0) && (i == 0)) {
              break label158;
            }
            y();
            this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy.a(paramObservable.a(), (ViewGroup)this.jdField_a_of_type_AndroidViewView, paramObservable);
            return;
            i = 0;
            break;
          }
        }
      } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3));
      y();
      paramObservable = (String)arrayOfObject[1];
      paramObject = (Boolean)arrayOfObject[2];
      this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy.a((ViewGroup)this.jdField_a_of_type_AndroidViewView, paramObservable, paramObject.booleanValue());
      return;
    } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3));
    y();
    this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy.a((ViewGroup)this.jdField_a_of_type_AndroidViewView);
  }
  
  public static boolean b(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo.jdField_d_of_type_Int == 3) || (paramSessionInfo.jdField_d_of_type_Int == 4);
  }
  
  protected int a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView == null) {
      return -1;
    }
    int i = paramInt;
    if (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      j = i;
      if (!TextUtils.isEmpty(localGLVideoView.c())) {
        if (localGLVideoView.a() != 1) {
          break label94;
        }
      }
    }
    for (int j = i;; j = -1)
    {
      b("getUnusedView, start[" + paramInt + "], result_index[" + j + "]");
      return j;
      label94:
      i += 1;
      break;
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int j = 0;
    int i = 1;
    int n = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299267);
    int m = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299268);
    if (paramInt4 - paramInt2 > n)
    {
      paramInt2 = 1;
      if (paramInt5 - paramInt3 <= m) {
        break label106;
      }
      paramInt4 = 1;
      label65:
      paramInt5 = i();
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
                            paramInt4 = j;
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
                            paramInt3 = i;
                          } while (paramInt1 != 3);
                          if (paramInt2 != 2) {
                            break label164;
                          }
                          paramInt3 = i;
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
                        paramInt3 = i;
                      } while (paramInt1 != 2);
                      if (paramInt2 != 2) {
                        break label225;
                      }
                      paramInt3 = i;
                    } while (paramInt4 != 1);
                    return 4;
                    if (paramInt4 == 1) {
                      return 3;
                    }
                    return 2;
                    if (paramInt5 != 1) {
                      break label299;
                    }
                    paramInt3 = i;
                  } while (paramInt1 == 2);
                  paramInt3 = i;
                } while (paramInt1 == 3);
                paramInt3 = i;
              } while (paramInt1 == 4);
              paramInt3 = i;
            } while (paramInt1 != 1);
            if (paramInt2 == 1)
            {
              if (paramInt4 == 1) {
                return 3;
              }
              return 2;
            }
            paramInt3 = i;
          } while (paramInt4 != 1);
          return 4;
          paramInt3 = i;
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
        paramInt3 = i;
      } while (paramInt1 != 4);
      if (paramInt2 == 1)
      {
        if (paramInt4 == 2) {
          return 2;
        }
        return 3;
      }
      paramInt3 = i;
    } while (paramInt4 == 2);
    label164:
    label174:
    label225:
    label235:
    return 4;
  }
  
  protected int a(String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
        if ((paramString2.equals(paramString1.c())) && (paramInt == paramString1.g()) && (paramString1.a() == 0)) {
          return i;
        }
        i += 1;
      }
    }
    return -1;
  }
  
  public long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    int i = 0;
    GLVideoView localGLVideoView;
    if ((this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView != null) && (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length))
    {
      localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      if ((localGLVideoView.a() != 0) || (!paramString.equals(localGLVideoView.c()))) {}
    }
    for (long l = localGLVideoView.a();; l = 0L)
    {
      return l;
      i += 1;
      break;
    }
  }
  
  public GLRootView a()
  {
    return this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView;
  }
  
  String a()
  {
    String str = "[" + this.jdField_a_of_type_JavaLangString + "]VideoView[5]:\r\n";
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      str = str + "---------index[" + i + "], size[" + localGLVideoView.b() + ", " + localGLVideoView.c() + "], " + localGLVideoView.d() + "\r\n";
      i += 1;
    }
    return str;
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(long paramLong, GLVideoView paramGLVideoView)
  {
    if ((paramGLVideoView != null) && (!paramGLVideoView.c())) {
      paramGLVideoView.a(paramLong, this.jdField_a_of_type_ComTencentAvUiScreenLayout.c());
    }
  }
  
  @RequiresApi(api=17)
  public void a(GLCanvas paramGLCanvas)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) && (this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a()))
    {
      Object localObject;
      if (!this.jdField_c_of_type_Boolean)
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramGLCanvas.a(), paramGLCanvas.b(), 33984);
        this.jdField_c_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        this.f = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.b();
        if (this.f)
        {
          localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(paramGLCanvas.a(), paramGLCanvas.b(), true);
          this.jdField_a_of_type_ArrayOfFloat = new float[16];
          Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
          float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
          float f1 = localObject[1];
          i = paramGLCanvas.b();
          arrayOfFloat[5] = (f1 * 1.0F / (localObject[0] * i / paramGLCanvas.a()));
          this.jdField_a_of_type_ArrayOfFloat[13] = (1.0F - this.jdField_a_of_type_ArrayOfFloat[5]);
        }
      }
      else
      {
        a(paramGLCanvas, true);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, paramGLCanvas.a(), paramGLCanvas.b());
        this.jdField_c_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
        localObject = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
        i = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
        if (!this.f) {
          break label292;
        }
      }
      label292:
      for (paramGLCanvas = this.jdField_a_of_type_ArrayOfFloat;; paramGLCanvas = null)
      {
        ((QavVideoRecordUICtrl)localObject).a(3553, i, paramGLCanvas, null, SystemClock.elapsedRealtimeNanos());
        return;
        this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(paramGLCanvas.a(), paramGLCanvas.b(), false);
        break;
      }
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      i = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_c_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
      this.jdField_a_of_type_ArrayOfFloat = null;
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
    }
    GLES20.glBindFramebuffer(36160, 0);
    a(paramGLCanvas, false);
    f(paramGLCanvas);
  }
  
  protected void a(GLCanvas paramGLCanvas, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null)
    {
      AVC2CDataHandler localAVC2CDataHandler = AVC2CDataHandler.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      if (localAVC2CDataHandler != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
        if (((SessionInfo)localObject).jdField_d_of_type_Int == 2) {}
        for (int i = 1;; i = 0)
        {
          boolean bool = ((SessionInfo)localObject).a.get(5);
          if ((i == 0) || (bool)) {
            break;
          }
          localObject = ((SessionInfo)localObject).jdField_d_of_type_JavaLangString;
          int j = e();
          i = 0;
          while (i < j)
          {
            GLVideoView localGLVideoView = (GLVideoView)a(i);
            if ((localObject != null) && (((String)localObject).equals(localGLVideoView.c())))
            {
              byte[] arrayOfByte = localGLVideoView.a().b();
              localAVC2CDataHandler.a(localGLVideoView.c(), arrayOfByte);
            }
            i += 1;
          }
        }
      }
    }
    if ((paramBoolean) && (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer != null))
    {
      if (!d())
      {
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        super.a(paramGLCanvas);
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
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
    this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl = paramQavVideoRecordUICtrl;
  }
  
  public void a(String paramString, int paramInt)
  {
    int i = a("showNick", paramString, paramInt);
    if (i >= 0)
    {
      paramString = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      if (this.jdField_a_of_type_ComTencentAvUiScreenLayout == null) {
        break label86;
      }
      if (this.jdField_a_of_type_ComTencentAvUiScreenLayout.a() != 3) {
        break label69;
      }
      paramInt = 1;
    }
    for (;;)
    {
      if ((i == 0) && (paramInt == 0))
      {
        if ((this.q != 0) && (this.r != 0))
        {
          paramString.j(false);
          return;
          label69:
          paramInt = 0;
        }
        else
        {
          paramString.j(true);
        }
      }
      else
      {
        paramString.j(true);
        return;
        label86:
        paramInt = 0;
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
    int j = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c(j);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c(i);
    Object localObject;
    String str1;
    String str2;
    label139:
    float f1;
    boolean bool1;
    float f2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (paramInt1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
        str2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
        if (!((String)localObject).equals(str1)) {
          break label700;
        }
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        i = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].e();
        f1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
        j = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].f();
        bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].i();
        boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].h();
        int m = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].e();
        f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
        int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].f();
        boolean bool3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].i();
        boolean bool4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].h();
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].h(bool4);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].k(m);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(f2);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].j(n);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].j(bool3);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].h(bool2);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].k(i);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(f1);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].j(j);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].j(bool1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1];
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2] = localObject;
      bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].f();
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].g(bool1);
      bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].f();
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].g(bool1);
      f1 = UITools.a(BaseApplicationImpl.getContext(), 12.0F);
      f2 = UITools.a(BaseApplicationImpl.getContext(), 18.0F);
      if (paramInt1 != 0) {
        break label725;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(f2);
      label468:
      if (paramInt2 != 0) {
        break label739;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(f2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, 0, 0, 0);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b(0, 0, super.b(), super.c());
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d(-15197410);
      h();
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
      str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
      if (QLog.isColorLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "swapGLVideoView, end, [" + paramInt1 + "]=[" + (String)localObject + "], [" + paramInt2 + "]=[" + str1 + "]=[" + paramString + "]", new Throwable("who call SwapGLVideoView"));
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoLayerUIBase.3(this, (String)localObject, str1));
      return;
      if (paramInt2 != 0) {
        break;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_INSIDE);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      break;
      label700:
      if (!((String)localObject).equals(str2)) {
        break label139;
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      break label139;
      label725:
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(f1);
      break label468;
      label739:
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(f1);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
        if ((paramString.equals((String)localGLVideoView.a(0))) && (localGLVideoView.a() == 0)) {
          localGLVideoView.g(paramBoolean);
        }
        i += 1;
      }
    }
  }
  
  protected void a(Observable paramObservable, Object paramObject) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onLayout|left: " + paramInt1 + ", top: " + paramInt2 + ", right: " + paramInt3 + ", bottom: " + paramInt4);
    }
    c(false);
  }
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  void b(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.j == 3000) {
      if (k()) {
        ReportController.b(null, "CliOper", "", "", "0X80041B3", "0X80041B3", 0, 0, "", "", "", "");
      }
    }
    while (paramSessionInfo.j != 1)
    {
      return;
      ReportController.b(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
      return;
    }
    if (k())
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
  
  void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = "printGLVideoView[" + paramString + "]\r\n";
      str = str + a();
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, str);
    }
    if (QLog.isColorLevel())
    {
      paramString = "printItemList[" + paramString + "]\r\n";
      paramString = paramString + this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.a().c);
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramString);
    }
  }
  
  public boolean b(String paramString, int paramInt)
  {
    int i = a("isBigView", paramString, paramInt);
    b("isBigView, uin[" + paramString + "], videoSrcType[" + paramInt + "], result_index[" + i + "]");
    return i == 0;
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
    int j = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c(j);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c(i);
    Object localObject;
    String str1;
    String str2;
    label139:
    float f1;
    boolean bool1;
    float f2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4)
    {
      if (paramInt1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
        str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
        str2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
        if (!((String)localObject).equals(str1)) {
          break label694;
        }
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        i = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].e();
        f1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
        j = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].f();
        bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].i();
        boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].h();
        int m = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].e();
        f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
        int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].f();
        boolean bool3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].i();
        boolean bool4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].h();
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].h(bool4);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].k(m);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(f2);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].j(n);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].j(bool3);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].h(bool2);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].k(i);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(f1);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].j(j);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].j(bool1);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1];
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1] = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2];
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2] = localObject;
      bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].f();
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].g(bool1);
      bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].f();
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].g(bool1);
      f1 = UITools.a(BaseApplicationImpl.getContext(), 12.0F);
      f2 = UITools.a(BaseApplicationImpl.getContext(), 18.0F);
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
      c(false);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().i = k();
      }
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int == 4) {
        b(this.jdField_a_of_type_ComTencentAvVideoController.a());
      }
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
      str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
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
  
  public void c(long paramLong, boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i = a("onCameraOpened_" + paramBoolean, str, 1);
    if (i >= 0) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].a(paramLong, paramBoolean);
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return;
    }
    int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299266);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299263);
    Rect localRect = super.b();
    int m = localRect.width() - i1;
    int j = localRect.height() - i2;
    int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().left + paramInt1;
    paramInt2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().top + paramInt2;
    if (n < 0)
    {
      paramInt1 = 0;
      if (paramInt2 >= 0) {
        break label146;
      }
      paramInt2 = i;
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
      if (paramInt2 > j) {
        paramInt2 = j;
      }
    }
  }
  
  public void d(GLCanvas paramGLCanvas)
  {
    int i3 = paramGLCanvas.a();
    int i4 = paramGLCanvas.b();
    int[] arrayOfInt = new int[4];
    int[] tmp23_21 = arrayOfInt;
    tmp23_21[0] = -1;
    int[] tmp27_23 = tmp23_21;
    tmp27_23[1] = -1;
    int[] tmp31_27 = tmp27_23;
    tmp31_27[2] = -1;
    int[] tmp35_31 = tmp31_27;
    tmp35_31[3] = -1;
    tmp35_31;
    int i = 0;
    if (this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager != null)
    {
      this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager.a(i3, i4);
      this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager.a();
    }
    int i5 = e();
    int j = 0;
    Object localObject1;
    InputTextureInfo localInputTextureInfo;
    boolean bool1;
    Object localObject2;
    int i1;
    boolean bool2;
    String str;
    int n;
    int m;
    if (j < i5)
    {
      localObject1 = a(j);
      if (!((GLView)localObject1).a()) {
        break label853;
      }
      localInputTextureInfo = ((GLView)localObject1).a(paramGLCanvas);
      bool1 = ((GLView)localObject1).c();
      localObject2 = ((GLVideoView)localObject1).a().b();
      i1 = 0;
      int i2 = 0;
      bool2 = ((GLVideoView)localObject1).g();
      str = null;
      n = i1;
      m = i2;
      localObject1 = str;
      if (localObject2 != null)
      {
        Tlv localTlv = (Tlv)TlvUtils.a((byte[])localObject2).get(6);
        n = i1;
        m = i2;
        localObject1 = str;
        if (localTlv != null)
        {
          localObject1 = localTlv.a();
          m = (short)(localObject1[0] << 8 | localObject1[1] & 0xFF);
          n = (short)(localObject1[2] << 8 | localObject1[3] & 0xFF);
          localObject1 = FaceDetectUtil.parseOrigFaceDataModelJson(new String((byte[])localObject1, 4, localObject1.length - 4));
        }
      }
      if ((bool1) && (localObject2 != null)) {
        if (QLog.isDebugVersion())
        {
          str = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder().append("bufAll self length").append(localObject2.length).append("feature points:detectFaceHeight:=").append(m).append(",detectFaceWidth:=").append(n).append(",faceTextureWidth:=").append(localInputTextureInfo.b).append(",faceTextureHeight:=").append(localInputTextureInfo.c).append("faceModel size:=");
          if (localObject1 != null)
          {
            i1 = ((List)localObject1).size();
            label370:
            QLog.i(str, 2, i1 + ":isMirror:=" + bool2);
          }
        }
        else
        {
          label397:
          arrayOfInt[i] = localInputTextureInfo.a;
          if (this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager != null) {
            this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager.a(arrayOfInt[i], localInputTextureInfo.b, localInputTextureInfo.c, n, m, bool2, (List)localObject1, bool1);
          }
          i += 1;
        }
      }
    }
    label642:
    label663:
    label853:
    for (;;)
    {
      j += 1;
      break;
      i1 = 0;
      break label370;
      if ((localObject2 == null) || (!QLog.isDebugVersion())) {
        break label397;
      }
      str = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("bufAll peer length").append(localObject2.length).append("feature points:detectFaceHeight:=").append(m).append(",detectFaceWidth:=").append(n).append(",faceTextureWidth:=").append(localInputTextureInfo.b).append(",faceTextureHeight:=").append(localInputTextureInfo.c).append("faceModel size:=");
      if (localObject1 != null) {}
      for (i1 = ((List)localObject1).size();; i1 = 0)
      {
        QLog.i(str, 2, i1 + ":isMirror:=" + bool2);
        break;
      }
      paramGLCanvas = null;
      if (this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager != null)
      {
        bool1 = AEKitAbilityInfo.a();
        paramGLCanvas = this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager;
        if (bool1)
        {
          i = 720;
          if (!bool1) {
            break label756;
          }
          j = 1280;
          paramGLCanvas = paramGLCanvas.a(i, j);
        }
      }
      else
      {
        if (!this.jdField_b_of_type_Boolean) {
          break label763;
        }
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.bind();
        if (this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        }
        if (this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender == null) {
          this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        }
        if (paramGLCanvas == null) {
          break label782;
        }
        localObject1 = this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager.a();
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, paramGLCanvas.getTextureId(), null, (float[])localObject1);
        paramGLCanvas.unlock();
      }
      for (;;)
      {
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.unbind();
        }
        return;
        i = 540;
        break;
        label756:
        j = 960;
        break label642;
        label763:
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, i3, i4);
        break label663;
        if (arrayOfInt[0] != -1) {
          this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, arrayOfInt[0], null, null);
        }
        if (arrayOfInt[1] != -1)
        {
          GLES20.glViewport(0, 0, 300, 300);
          this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, arrayOfInt[1], null, null);
          GLES20.glViewport(0, 0, i3, i4);
        }
      }
    }
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager != null) && (this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager.a(this.jdField_a_of_type_ComTencentAvUiScreenLayout));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager.b();
    }
    this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
    this.jdField_b_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
  }
  
  void f(GLCanvas paramGLCanvas)
  {
    if (this.jdField_b_of_type_Long == 0L) {}
    long l1;
    do
    {
      return;
      l1 = this.jdField_b_of_type_Long;
      this.jdField_b_of_type_Long = 0L;
      if ((paramGLCanvas instanceof GLES20Canvas))
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramGLCanvas.a(), paramGLCanvas.b(), Bitmap.Config.ARGB_8888);
        long l2 = AudioHelper.c();
        paramGLCanvas.a(localBitmap, paramGLCanvas.a(), paramGLCanvas.b());
        long l3 = AudioHelper.c();
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "tryScreenShot, screenShotFlag[" + l1 + "], cost_nanos[" + (l3 - l2) + "]");
        ThreadManager.getSubThreadHandler().post(new VideoLayerUIBase.MyRunnable(this.jdField_a_of_type_JavaLangString, localBitmap, l1, this));
        return;
      }
    } while (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(20001), Long.valueOf(l1), Boolean.valueOf(false), null });
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager.c();
    }
  }
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a().N = paramInt;
  }
  
  public int h()
  {
    return this.w;
  }
  
  protected void h(int paramInt) {}
  
  public void h(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public int i()
  {
    Rect localRect = super.b();
    int i = localRect.centerX();
    int j = localRect.centerY();
    int m = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().centerX();
    int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().centerY();
    if ((m < i) && (n < j)) {
      return 1;
    }
    if ((m < i) && (n > j)) {
      return 4;
    }
    if ((m > i) && (n < j)) {
      return 2;
    }
    if ((m > i) && (n > j)) {
      return 3;
    }
    return 0;
  }
  
  public boolean i()
  {
    if (j()) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentAvUiScreenLayout.c();
  }
  
  public boolean j()
  {
    return this.g;
  }
  
  protected boolean k()
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
    if ((localGLVideoView.a() == 0) && (str.equals(localGLVideoView.c()))) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "isLocalFront: " + bool);
      }
      b(String.format("isLocalFront, self isLocalFront[%s]", new Object[] { Boolean.valueOf(bool) }));
      return bool;
    }
  }
  
  protected void l()
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363183));
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this);
  }
  
  protected boolean l()
  {
    boolean bool2 = false;
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
        if ((localGLVideoView.a() == 0) && (!str.equals(localGLVideoView.c()))) {
          bool1 = true;
        }
      }
      else
      {
        b("isRemoteHasVideo, peer isRemoteHasVideo[" + bool1 + "]");
        return bool1;
      }
      i += 1;
    }
  }
  
  protected void m() {}
  
  public boolean m()
  {
    int i = 0;
    boolean bool2;
    for (boolean bool1 = true;; bool1 = bool2)
    {
      bool2 = bool1;
      GLVideoView localGLVideoView;
      if (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
        bool2 = bool1;
        if (localGLVideoView.a() == 0)
        {
          bool1 = localGLVideoView.d();
          bool2 = bool1;
          if (!bool1)
          {
            QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doGlassRemoteVideo failed !!!! i=" + i + ", getVisibility=" + localGLVideoView.a());
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
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doGlassRemoteVideo i=" + i + ", getVisibility=" + localGLVideoView.a());
      i += 1;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doGlassRemoteVideo failed and cancel Glass");
    n();
    return false;
  }
  
  protected void n()
  {
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView = new GLVideoView[MultiVideoCtrlLayerUIBase.b];
    int j = AIOUtils.a(115.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i = j - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    }
    if (VideoConstants.jdField_c_of_type_Boolean) {
      i += 25;
    }
    for (;;)
    {
      j = 0;
      if (j < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j] = new GLVideoView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(j) }), this.jdField_a_of_type_ComTencentAvVideoController.g());
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].a(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].a(1);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].h(-1);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].b(2130842327, 2130842326);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].d(this.jdField_a_of_type_ComTencentAvUiScreenLayout.c());
        if (j == 0) {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].c(j * 2);
        }
        for (;;)
        {
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].i(i);
          a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j]);
          j += 1;
          break;
          this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[j].c((this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length - j) * 2);
        }
      }
      return;
    }
  }
  
  public boolean n()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      GLVideoView localGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i];
      if (localGLVideoView.a() == 0) {
        localGLVideoView.h();
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doCancelGlassRemoteVideo i=" + i + ", getVisibility=" + localGLVideoView.a());
      i += 1;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    return false;
  }
  
  public void o(int paramInt)
  {
    int m = 0;
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299266);
    int i3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299263);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299264);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299265);
    if (this.r == 0) {
      j = i;
    }
    Object localObject = super.b();
    int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().left;
    int i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().top;
    switch (paramInt)
    {
    default: 
      i = 0;
      j = m;
    }
    for (;;)
    {
      localObject = new VideoLayerUIBase.MoveSmallViewAnimation(this, paramInt, n, i1, i, j, null);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post((Runnable)localObject);
      return;
      j += this.q;
      continue;
      m = ((Rect)localObject).width();
      j += this.q;
      i = m - i - i2;
      continue;
      m = ((Rect)localObject).width();
      j = ((Rect)localObject).height() - j - i3;
      i = m - i - i2;
      continue;
      j = ((Rect)localObject).height() - j - i3;
    }
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onDestroy, mDestroyed[" + this.g + "]");
    }
    this.g = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase$MyDataObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setOnTouchListener(null);
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(null);
    super.i();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].a(1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].m(true);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].k(false);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].g(false);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].l(true);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = null;
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView = null;
    if (this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager != null) {
      this.jdField_a_of_type_ComTencentAvUiVideoAfterTreatmentManager.b();
    }
  }
  
  public void p(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView == null) {}
    for (;;)
    {
      return;
      int i = AIOUtils.a(paramInt, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramInt = i;
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        paramInt = i - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
      }
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView.length)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].i(paramInt);
        i += 1;
      }
    }
  }
  
  public void q()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.onResume();
    }
    a(this.v, false);
  }
  
  protected void s() {}
  
  public void v()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setVisibility(0);
    }
  }
  
  public void w()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setVisibility(8);
    }
  }
  
  public void x()
  {
    if (this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.onPause();
    }
  }
  
  void y()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy == null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy = new MagicfaceViewProxy(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase
 * JD-Core Version:    0.7.0.1
 */