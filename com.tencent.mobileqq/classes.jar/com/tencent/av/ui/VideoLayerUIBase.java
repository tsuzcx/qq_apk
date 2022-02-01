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
{
  private long jdField_a_of_type_Long = 0L;
  protected Context a;
  protected Display a;
  protected View a;
  protected ImageView a;
  protected VideoController a;
  public VideoAppInterface a;
  protected BitmapTexture a;
  protected GLVideoView a;
  private QavVideoRecordUICtrl jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl = null;
  protected ScreenLayout a;
  protected VideoLayerUIBase.MyDataObserver a;
  MagicfaceViewProxy jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy = null;
  protected WatchTogetherVideoBgRender a;
  protected WatchTogetherVideoRenderHelper a;
  private TextureRender jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender;
  protected Runnable a;
  final String jdField_a_of_type_JavaLangString;
  private float[] jdField_a_of_type_ArrayOfFloat = null;
  public GLVideoView[] a;
  long jdField_b_of_type_Long = 0L;
  protected GLRootView b;
  private RenderBuffer jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer;
  protected Runnable b;
  private boolean c = false;
  private Rect d;
  protected boolean d;
  protected boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private int k = 0;
  protected int q = 0;
  protected int r = 0;
  protected int s = 0;
  public int t = -1;
  protected int u = 0;
  protected int v = 0;
  protected int w = 2;
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(AudioHelper.b());
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate:");
    localStringBuilder.append(this);
    localStringBuilder.append(", VideoAppInterface:");
    localStringBuilder.append(paramVideoAppInterface);
    localStringBuilder.append(", rootView:");
    localStringBuilder.append(paramView);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363122));
    this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase$MyDataObserver = new VideoLayerUIBase.MyDataObserver(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase$MyDataObserver);
  }
  
  public static boolean a(SessionInfo paramSessionInfo)
  {
    int i = paramSessionInfo.d;
    boolean bool = true;
    if (i != 1)
    {
      if (paramSessionInfo.d == 2) {
        return true;
      }
      bool = false;
    }
    return bool;
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
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3))
      {
        x();
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy.a((ViewGroup)this.jdField_a_of_type_AndroidViewView);
        return;
      }
      break;
    case 6101: 
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3))
      {
        x();
        paramObservable = (String)arrayOfObject[1];
        paramObject = (Boolean)arrayOfObject[2];
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy.a((ViewGroup)this.jdField_a_of_type_AndroidViewView, paramObservable, paramObject.booleanValue());
        return;
      }
      break;
    case 6100: 
      paramObservable = (ControlUIObserver.RequestPlayMagicFace)ControlUIObserver.a(arrayOfObject);
      paramObject = (FaceItem)((EffectFaceManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a(paramObservable.c);
      int i = j;
      if (paramObject != null)
      {
        i = j;
        if (paramObject.isInteract()) {
          i = 1;
        }
      }
      if ((i()) || (i == 0))
      {
        x();
        this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy.a(paramObservable.a(), (ViewGroup)this.jdField_a_of_type_AndroidViewView, paramObservable);
      }
      break;
    }
  }
  
  public static boolean b(SessionInfo paramSessionInfo)
  {
    return (paramSessionInfo.d == 3) || (paramSessionInfo.d == 4);
  }
  
  public void B_()
  {
    GLRootView localGLRootView = this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView;
    if (localGLRootView != null) {
      localGLRootView.onResume();
    }
    a(this.v, false);
  }
  
  protected int a(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView == null) {
      return -1;
    }
    int i = paramInt;
    for (;;)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      j = i;
      if (TextUtils.isEmpty(((GLVideoView)localObject).c())) {
        break label66;
      }
      if (((GLVideoView)localObject).a() == 1)
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
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    int j = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299270);
    int i = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299271);
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
    paramInt4 = i();
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
        paramString1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
        if (i >= paramString1.length) {
          break;
        }
        paramString1 = paramString1[i];
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
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      if ((localObject == null) || (i >= localObject.length)) {
        break;
      }
      localObject = localObject[i];
      if ((((GLVideoView)localObject).a() == 0) && (paramString.equals(((GLVideoView)localObject).c()))) {
        return ((GLVideoView)localObject).a();
      }
      i += 1;
    }
    return 0L;
  }
  
  public GLRootView a()
  {
    return this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView;
  }
  
  String a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("]VideoView[5]:\r\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    int i = 0;
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      if (i >= localObject2.length) {
        break;
      }
      localObject2 = localObject2[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("---------index[");
      localStringBuilder.append(i);
      localStringBuilder.append("], size[");
      localStringBuilder.append(((GLVideoView)localObject2).b());
      localStringBuilder.append(", ");
      localStringBuilder.append(((GLVideoView)localObject2).c());
      localStringBuilder.append("], ");
      localStringBuilder.append(((GLVideoView)localObject2).d());
      localStringBuilder.append("\r\n");
      localObject1 = localStringBuilder.toString();
      i += 1;
    }
    return localObject1;
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
    Object localObject2 = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
    Object localObject1 = null;
    int i;
    if ((localObject2 != null) && (((QavVideoRecordUICtrl)localObject2).a()))
    {
      if (!this.c)
      {
        this.c = true;
        this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = new RenderBuffer(paramGLCanvas.a(), paramGLCanvas.b(), 33984);
        this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = new TextureRender();
        this.f = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.b();
        if (this.f)
        {
          localObject2 = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(paramGLCanvas.a(), paramGLCanvas.b(), true);
          this.jdField_a_of_type_ArrayOfFloat = new float[16];
          Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
          this.jdField_a_of_type_ArrayOfFloat[5] = (localObject2[1] * 1.0F / (paramGLCanvas.b() * localObject2[0] / paramGLCanvas.a()));
          localObject2 = this.jdField_a_of_type_ArrayOfFloat;
          localObject2[13] = (1.0F - localObject2[5]);
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a(paramGLCanvas.a(), paramGLCanvas.b(), false);
        }
      }
      a(paramGLCanvas, true);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, paramGLCanvas.a(), paramGLCanvas.b());
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.drawTexture(3553, this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId(), null, null);
      localObject2 = this.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl;
      i = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
      paramGLCanvas = localObject1;
      if (this.f) {
        paramGLCanvas = this.jdField_a_of_type_ArrayOfFloat;
      }
      ((QavVideoRecordUICtrl)localObject2).a(3553, i, paramGLCanvas, null, SystemClock.elapsedRealtimeNanos());
      return;
    }
    if (this.c)
    {
      this.c = false;
      i = this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.getTexId();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer.destroy();
      this.jdField_b_of_type_ComTencentTtpicOpenapiFilterRenderBuffer = null;
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender.release();
      this.jdField_a_of_type_ComTencentTtpicOpenapiFilterTextureRender = null;
      this.jdField_a_of_type_ArrayOfFloat = null;
      GLES20.glDeleteTextures(1, new int[] { i }, 0);
    }
    GLES20.glBindFramebuffer(36160, 0);
    a(paramGLCanvas, false);
    f(paramGLCanvas);
  }
  
  protected void a(GLCanvas paramGLCanvas, boolean paramBoolean)
  {
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
      ScreenLayout localScreenLayout = this.jdField_a_of_type_ComTencentAvUiScreenLayout;
      if ((localScreenLayout != null) && (localScreenLayout.a() == 3)) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((i == 0) && (paramInt == 0))
      {
        if ((this.q != 0) && (this.r != 0))
        {
          paramString.j(false);
          return;
        }
        paramString.j(true);
        return;
      }
      paramString.j(true);
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
    int j = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c(j);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c(i);
    String str2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)
    {
      if (paramInt1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
      }
      else if (paramInt2 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_INSIDE);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
      str2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
      if (((String)localObject).equals(str1)) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
      } else if (((String)localObject).equals(str2)) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      i = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].e();
      f1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
      j = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].f();
      bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].h();
      boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].g();
      int m = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].e();
      f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
      int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].f();
      boolean bool3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].h();
      boolean bool4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].g();
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
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
    String str1 = localObject[paramInt1];
    localObject[paramInt1] = localObject[paramInt2];
    localObject[paramInt2] = str1;
    boolean bool1 = localObject[paramInt1].f();
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].g(bool1);
    bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].f();
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].g(bool1);
    float f1 = UITools.a(BaseApplicationImpl.getContext(), 12.0F);
    float f2 = UITools.a(BaseApplicationImpl.getContext(), 18.0F);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(f2);
    } else {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(f1);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(f2);
    } else {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(f1);
    }
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].a(0, 0, 0, 0);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].b(0, 0, super.b(), super.c());
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0].d(-15197410);
    h();
    localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
    str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
    if (QLog.isColorLevel())
    {
      str2 = this.jdField_a_of_type_JavaLangString;
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post(new VideoLayerUIBase.3(this, (String)localObject, str1));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      for (;;)
      {
        Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        if ((paramString.equals((String)((GLVideoView)localObject).a(0))) && (((GLVideoView)localObject).a() == 0)) {
          ((GLVideoView)localObject).g(paramBoolean);
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
      String str = this.jdField_a_of_type_JavaLangString;
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
  
  protected boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  void b(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo.k == 3000)
    {
      if (k())
      {
        ReportController.b(null, "CliOper", "", "", "0X80041B3", "0X80041B3", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80041B2", "0X80041B2", 0, 0, "", "", "", "");
      return;
    }
    if (paramSessionInfo.k == 1)
    {
      if (k())
      {
        if (paramSessionInfo.j == 10)
        {
          ReportController.b(null, "CliOper", "", "", "0X8005939", "0X8005939", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "CliOper", "", "", "0X80046E0", "0X80046E0", 0, 0, "", "", "", "");
        return;
      }
      if (paramSessionInfo.j == 10)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005938", "0X8005938", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X80046DF", "0X80046DF", 0, 0, "", "", "", "");
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
      localStringBuilder.append(a());
      localObject = localStringBuilder.toString();
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, (String)localObject);
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
      localObject = this.jdField_a_of_type_ComTencentAvVideoController;
      paramString.append(((VideoController)localObject).a(((VideoController)localObject).a().c));
      paramString = paramString.toString();
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, paramString);
    }
  }
  
  public boolean b(String paramString, int paramInt)
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
  
  protected void c(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
    int j = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c(j);
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c(i);
    String str2;
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)
    {
      if (paramInt1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_INSIDE);
      }
      else if (paramInt2 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_INSIDE);
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
      str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
      str2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
      if (((String)localObject).equals(str1)) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(ImageView.ScaleType.CENTER_CROP);
      } else if (((String)localObject).equals(str2)) {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(ImageView.ScaleType.CENTER_CROP);
      }
      i = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].e();
      f1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].d();
      j = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].f();
      bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].h();
      boolean bool2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].g();
      int m = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].e();
      f2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].d();
      int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].f();
      boolean bool3 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].h();
      boolean bool4 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].g();
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
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
    String str1 = localObject[paramInt1];
    localObject[paramInt1] = localObject[paramInt2];
    localObject[paramInt2] = str1;
    boolean bool1 = localObject[paramInt1].f();
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].g(bool1);
    bool1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].f();
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].g(bool1);
    float f1 = UITools.a(BaseApplicationImpl.getContext(), 12.0F);
    float f2 = UITools.a(BaseApplicationImpl.getContext(), 18.0F);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(f2);
    } else {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].a(f1);
    }
    if (paramInt2 == 0) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(f2);
    } else {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].a(f1);
    }
    c(false);
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 2) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().i = k();
    }
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4) {
      b(this.jdField_a_of_type_ComTencentAvVideoController.a());
    }
    localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt1].c();
    str1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[paramInt2].c();
    if (QLog.isColorLevel())
    {
      str2 = this.jdField_a_of_type_JavaLangString;
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
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(8005), localObject, str1 });
  }
  
  public void c(long paramLong, boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCameraOpened_");
    localStringBuilder.append(paramBoolean);
    int i = a(localStringBuilder.toString(), str, 1);
    if (i >= 0) {
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].a(paramLong, paramBoolean);
    }
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if (localObject == null) {
      return;
    }
    int i1 = ((Context)localObject).getResources().getDimensionPixelSize(2131299269);
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299266);
    localObject = super.b();
    int m = ((Rect)localObject).width() - i1;
    int i = ((Rect)localObject).height() - i2;
    int n = paramInt1 + this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().left;
    int j = paramInt2 + this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().top;
    if (n < 0)
    {
      paramInt1 = 0;
    }
    else
    {
      paramInt1 = n;
      if (n > m) {
        paramInt1 = m;
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
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b(paramInt1, paramInt2, i1 + paramInt1, i2 + paramInt2);
  }
  
  protected void d(GLCanvas paramGLCanvas) {}
  
  protected boolean d()
  {
    return false;
  }
  
  protected void f() {}
  
  void f(GLCanvas paramGLCanvas)
  {
    long l1 = this.jdField_b_of_type_Long;
    if (l1 == 0L) {
      return;
    }
    this.jdField_b_of_type_Long = 0L;
    if ((paramGLCanvas instanceof GLES20Canvas))
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramGLCanvas.a(), paramGLCanvas.b(), Bitmap.Config.ARGB_8888);
      long l2 = AudioHelper.c();
      paramGLCanvas.a(localBitmap, paramGLCanvas.a(), paramGLCanvas.b());
      long l3 = AudioHelper.c();
      paramGLCanvas = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryScreenShot, screenShotFlag[");
      localStringBuilder.append(l1);
      localStringBuilder.append("], cost_nanos[");
      localStringBuilder.append(l3 - l2);
      localStringBuilder.append("]");
      QLog.w(paramGLCanvas, 1, localStringBuilder.toString());
      ThreadManager.getSubThreadHandler().post(new VideoLayerUIBase.MyRunnable(this.jdField_a_of_type_JavaLangString, localBitmap, l1, this));
      return;
    }
    paramGLCanvas = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (paramGLCanvas != null) {
      paramGLCanvas.a(new Object[] { Integer.valueOf(20001), Long.valueOf(l1), Boolean.valueOf(false), null });
    }
  }
  
  protected void g() {}
  
  public void g(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a().L = paramInt;
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
    Object localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[0];
    boolean bool;
    if ((((GLVideoView)localObject).a() == 0) && (str.equals(((GLVideoView)localObject).c()))) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      str = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isLocalFront: ");
      ((StringBuilder)localObject).append(bool);
      QLog.d(str, 2, ((StringBuilder)localObject).toString());
    }
    b(String.format("isLocalFront, self isLocalFront[%s]", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  protected void l()
  {
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363123));
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this);
  }
  
  protected boolean l()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    for (;;)
    {
      Object localObject2 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      bool1 = bool2;
      if (i >= localObject2.length) {
        break;
      }
      localObject2 = localObject2[i];
      if ((((GLVideoView)localObject2).a() == 0) && (!((String)localObject1).equals(((GLVideoView)localObject2).c())))
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
  
  public boolean m()
  {
    int i = 0;
    Object localObject;
    boolean bool2;
    for (boolean bool1 = true;; bool1 = bool2)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      bool2 = bool1;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      bool2 = bool1;
      if (((GLVideoView)localObject).a() == 0)
      {
        bool1 = ((GLVideoView)localObject).d();
        bool2 = bool1;
        if (!bool1)
        {
          str = this.jdField_a_of_type_JavaLangString;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doGlassRemoteVideo failed !!!! i=");
          localStringBuilder.append(i);
          localStringBuilder.append(", getVisibility=");
          localStringBuilder.append(((GLVideoView)localObject).a());
          QLog.d(str, 1, localStringBuilder.toString());
          bool2 = bool1;
          break;
        }
      }
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doGlassRemoteVideo i=");
      localStringBuilder.append(i);
      localStringBuilder.append(", getVisibility=");
      localStringBuilder.append(((GLVideoView)localObject).a());
      QLog.d(str, 1, localStringBuilder.toString());
      i += 1;
    }
    if (bool2)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null)
      {
        ((ImageView)localObject).setVisibility(0);
        return false;
      }
    }
    else
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "doGlassRemoteVideo failed and cancel Glass");
      n();
    }
    return false;
  }
  
  protected void n()
  {
    this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView = new GLVideoView[MultiVideoCtrlLayerUIBase.b];
    int j = AIOUtils.b(115.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      i = j - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    }
    j = i;
    if (VideoConstants.c) {
      j = i + 25;
    }
    i = 0;
    for (;;)
    {
      GLVideoView[] arrayOfGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      if (i >= arrayOfGLVideoView.length) {
        break;
      }
      arrayOfGLVideoView[i] = new GLVideoView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, String.format("%s_%s", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(i) }), this.jdField_a_of_type_ComTencentAvVideoController.g());
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].a(1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].h(-1);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].b(2130842225, 2130842224);
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].d(this.jdField_a_of_type_ComTencentAvUiScreenLayout.c());
      if (i == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].c(i * 2);
      }
      else
      {
        arrayOfGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
        arrayOfGLVideoView[i].c((arrayOfGLVideoView.length - i) * 2);
      }
      this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i].i(j);
      a(this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[i]);
      i += 1;
    }
  }
  
  public boolean n()
  {
    int i = 0;
    for (;;)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      if (i >= localObject.length) {
        break;
      }
      localObject = localObject[i];
      if (((GLVideoView)localObject).a() == 0) {
        ((GLVideoView)localObject).h();
      }
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doCancelGlassRemoteVideo i=");
      localStringBuilder.append(i);
      localStringBuilder.append(", getVisibility=");
      localStringBuilder.append(((GLVideoView)localObject).a());
      QLog.d(str, 1, localStringBuilder.toString());
      i += 1;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    return false;
  }
  
  public void o(int paramInt)
  {
    int i2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299269);
    int i3 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299266);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299267);
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299268);
    if (this.r == 0) {
      j = i;
    }
    Object localObject = super.b();
    int n = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().left;
    int i1 = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView[1].b().top;
    int m = 0;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            i = 0;
            j = m;
          }
          else
          {
            j = ((Rect)localObject).height() - j - i3;
          }
        }
        else
        {
          m = ((Rect)localObject).width();
          j = ((Rect)localObject).height() - j - i3;
          i = m - i - i2;
        }
      }
      else
      {
        m = ((Rect)localObject).width();
        j += this.q;
        i = m - i - i2;
      }
    }
    else {
      j += this.q;
    }
    localObject = new VideoLayerUIBase.MoveSmallViewAnimation(this, paramInt, n, i1, i, j, null);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().post((Runnable)localObject);
  }
  
  public void p()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy, mDestroyed[");
      localStringBuilder.append(this.g);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    this.g = true;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUIBase$MyDataObserver);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setOnTouchListener(null);
    this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(null);
    super.i();
    int i = 0;
    for (;;)
    {
      localObject = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      if (i >= localObject.length) {
        break;
      }
      localObject[i].a(1);
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
  }
  
  public void p(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView == null) {
      return;
    }
    int i = AIOUtils.b(paramInt, this.jdField_a_of_type_AndroidContentContext.getResources());
    paramInt = i;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      paramInt = i - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
    }
    i = 0;
    for (;;)
    {
      GLVideoView[] arrayOfGLVideoView = this.jdField_a_of_type_ArrayOfComTencentAvUiGLVideoView;
      if (i >= arrayOfGLVideoView.length) {
        break;
      }
      arrayOfGLVideoView[i].i(paramInt);
      i += 1;
    }
  }
  
  protected void r() {}
  
  public void u()
  {
    GLRootView localGLRootView = this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView;
    if (localGLRootView != null) {
      localGLRootView.setVisibility(0);
    }
  }
  
  public void v()
  {
    GLRootView localGLRootView = this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView;
    if (localGLRootView != null) {
      localGLRootView.setVisibility(8);
    }
  }
  
  public void w()
  {
    GLRootView localGLRootView = this.jdField_b_of_type_ComTencentAvOpenglUiGLRootView;
    if (localGLRootView != null) {
      localGLRootView.onPause();
    }
  }
  
  void x()
  {
    if (this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy == null) {
      this.jdField_a_of_type_ComTencentAvUiFunchatMagicfaceMagicfaceViewProxy = new MagicfaceViewProxy(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoLayerUIBase
 * JD-Core Version:    0.7.0.1
 */