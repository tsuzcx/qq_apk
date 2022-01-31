import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.camera.core.AECameraManager.1;
import dov.com.qq.im.ae.camera.core.AECameraManager.10;
import dov.com.qq.im.ae.camera.core.AECameraManager.11;
import dov.com.qq.im.ae.camera.core.AECameraManager.12;
import dov.com.qq.im.ae.camera.core.AECameraManager.2;
import dov.com.qq.im.ae.camera.core.AECameraManager.3;
import dov.com.qq.im.ae.camera.core.AECameraManager.4;
import dov.com.qq.im.ae.camera.core.AECameraManager.5;
import dov.com.qq.im.ae.camera.core.AECameraManager.6;
import dov.com.qq.im.ae.camera.core.AECameraManager.7;
import dov.com.qq.im.ae.camera.core.AECameraManager.8;
import dov.com.qq.im.ae.camera.core.AECameraManager.9;
import java.io.File;
import java.util.Arrays;

public class bijj
  implements SurfaceTexture.OnFrameAvailableListener, axgj, axhw, axie
{
  private static final axhx jdField_a_of_type_Axhx = CameraCaptureView.jdField_a_of_type_Axhx;
  public int a;
  private ahvy jdField_a_of_type_Ahvy;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private View jdField_a_of_type_AndroidViewView;
  private avtf jdField_a_of_type_Avtf;
  private avtg jdField_a_of_type_Avtg;
  private axhv jdField_a_of_type_Axhv = new axhv(this.jdField_b_of_type_AndroidOsHandler, this);
  private biiz jdField_a_of_type_Biiz;
  private bijm jdField_a_of_type_Bijm;
  private AudioCapture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  protected boolean a;
  public int b;
  private Handler jdField_b_of_type_AndroidOsHandler = new Handler();
  private boolean jdField_b_of_type_Boolean;
  protected int c;
  private boolean c;
  protected int d;
  private boolean d;
  public int e;
  private boolean e;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private volatile boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int j;
  private int k;
  private int l = 1;
  
  private bijj()
  {
    this.jdField_a_of_type_Int = 1080;
    this.jdField_b_of_type_Int = 1920;
    if ((this.l == 1) && (!amfw.d())) {
      this.l = 2;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("AECameraManagerHandlerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    jdField_a_of_type_Axhx.a(this.jdField_a_of_type_Axhv);
    jdField_a_of_type_Axhx.e(true);
    this.jdField_a_of_type_Ahvy = new ahvy();
  }
  
  public static bijj a()
  {
    return bijn.a;
  }
  
  private void a(axhs paramaxhs)
  {
    this.jdField_c_of_type_Int = paramaxhs.jdField_b_of_type_Int;
    this.jdField_d_of_type_Int = paramaxhs.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Bijm != null) {
      this.jdField_a_of_type_Bijm.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
    }
  }
  
  private void b(Activity paramActivity, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        this.jdField_a_of_type_AndroidViewView = new View(paramActivity);
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-1);
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.7F);
      if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      paramActivity.addContentView(this.jdField_a_of_type_AndroidViewView, new ViewGroup.LayoutParams(-1, -1));
    }
    do
    {
      try
      {
        this.jdField_h_of_type_Int = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness_mode", 0);
        this.jdField_i_of_type_Int = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness");
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness", 255);
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      catch (Exception paramActivity)
      {
        do
        {
          this.jdField_h_of_type_Int = 1;
          this.jdField_i_of_type_Int = 100;
        } while (!QLog.isColorLevel());
        QLog.e("AECameraManager", 2, "turn FrontFlash Error ", paramActivity);
        paramActivity.printStackTrace();
        return;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness", this.jdField_i_of_type_Int);
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness_mode", this.jdField_h_of_type_Int);
        this.jdField_d_of_type_Boolean = false;
      }
    } while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getParent() == null));
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void b(biiz parambiiz)
  {
    this.jdField_a_of_type_Biiz = parambiiz;
  }
  
  private void h()
  {
    biwd.a().a("AECameraManager", "realStartPreview---surfaceWidth=" + this.jdField_a_of_type_Int + ", surfaceHeight=" + this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Biiz.i(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Biiz.j(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      jdField_a_of_type_Axhx.a(new axhs(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int), new axhs(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int), 0, 30, true);
    }
    for (;;)
    {
      jdField_a_of_type_Axhx.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, null, this, true);
      this.jdField_h_of_type_Boolean = true;
      this.jdField_f_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_g_of_type_Int = this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Bijm != null) {
        this.jdField_a_of_type_Bijm.i();
      }
      bizq.b("AECameraManager", "### realStartPreview");
      biwd.a().a("startCameraPreview-end");
      return;
      jdField_a_of_type_Axhx.a(new axhs(this.jdField_a_of_type_Biiz.b(), this.jdField_a_of_type_Biiz.c()), new axhs(this.jdField_a_of_type_Biiz.d(), this.jdField_a_of_type_Biiz.e()), 0, 30, false);
    }
  }
  
  public int a()
  {
    return this.l;
  }
  
  public Handler a()
  {
    if (jdField_a_of_type_Axhx == null) {
      return null;
    }
    return jdField_a_of_type_Axhx.a();
  }
  
  public void a()
  {
    biwd.a().a("openCamera-begin");
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.1(this));
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.8(this, paramFloat1, paramFloat2));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.10(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ahvy != null) {
      this.jdField_a_of_type_Ahvy.a(paramInt2, paramInt1, b(), c());
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (this.l == 1)
    {
      b(paramActivity, paramBoolean);
      return;
    }
    jdField_a_of_type_Axhx.c(paramBoolean);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this, this.jdField_a_of_type_AndroidOsHandler);
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
  }
  
  public void a(avtf paramavtf)
  {
    this.jdField_a_of_type_Avtf = paramavtf;
  }
  
  public void a(avtg paramavtg)
  {
    this.jdField_a_of_type_Avtg = paramavtg;
  }
  
  public void a(biiz parambiiz)
  {
    this.jdField_a_of_type_Avtf = new avtf();
    b(parambiiz);
    this.l = parambiiz.g();
    if ((this.l == 1) && (!amfw.d())) {
      this.l = 2;
    }
  }
  
  public void a(bijm parambijm)
  {
    bizq.b("AECameraManager", "### setCameraManagerListener--- listener=" + parambijm);
    this.jdField_a_of_type_Bijm = parambijm;
  }
  
  public void a(AudioCapture paramAudioCapture)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = paramAudioCapture;
  }
  
  public void a(File paramFile, int paramInt, boolean paramBoolean, aiak paramaiak)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.7(this, paramFile, paramaiak, paramInt, paramBoolean));
  }
  
  public void a(Exception paramException)
  {
    if (paramException != null)
    {
      bizq.a("AECameraManager", "onCameraException---" + paramException.getMessage(), paramException);
      return;
    }
    bizq.d("AECameraManager", "onCameraException---");
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    biwd.a().a("AECameraManager", "【CameraProxy notify】eventId=" + paramInt + ", args=" + Arrays.toString(paramVarArgs));
    switch (paramInt)
    {
    }
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
                return;
                if (!(paramVarArgs[0] instanceof axhs)) {
                  break;
                }
                a((axhs)paramVarArgs[0]);
              } while (this.jdField_a_of_type_Bijm == null);
              this.jdField_a_of_type_Bijm.a(true, "");
              bizq.b("AECameraManager", "【Camera Open Success】EVENT_SET_CAMERA_PARAM");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bijm == null));
            this.jdField_a_of_type_Bijm.a(false, (String)paramVarArgs[0]);
            bizq.d("AECameraManager", "【Camera Open Error】EVENT_SET_CAMERA_PARAM:" + paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bijm == null));
          this.jdField_a_of_type_Bijm.a(false, (String)paramVarArgs[0]);
          bizq.d("AECameraManager", "【Camera Open Error】EVENT_CREATE_CAMERA:" + paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.jdField_a_of_type_Bijm == null));
        this.jdField_a_of_type_Bijm.a(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        bizq.d("AECameraManager", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof axhs)) {
          break;
        }
        a((axhs)paramVarArgs[0]);
        if (this.jdField_a_of_type_Bijm != null)
        {
          this.jdField_a_of_type_Bijm.a(true, "");
          bizq.b("AECameraManager", "【Camera2 Open Success】EVENT_CAMERA2_PARAMS");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof axhs)));
      paramObject = (axhs)paramVarArgs[1];
      this.j = paramObject.jdField_a_of_type_Int;
      this.k = paramObject.jdField_b_of_type_Int;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bijm == null));
    this.jdField_a_of_type_Bijm.a(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
    bizq.d("AECameraManager", "【Camera2 Open Error】setCamera2 Params error::" + paramVarArgs[0]);
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (paramRuntimeException != null)
    {
      bizq.a("AECameraManager", "onDispatchThreadException---" + paramRuntimeException.getMessage(), paramRuntimeException);
      return;
    }
    bizq.d("AECameraManager", "onDispatchThreadException---");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.2(this, paramBoolean));
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (!this.jdField_i_of_type_Boolean)
    {
      this.jdField_i_of_type_Boolean = true;
      biwd.a().a("onCameraPreviewFrameData");
    }
    axhp.a().a(true, paramArrayOfByte);
    if (this.jdField_e_of_type_Boolean)
    {
      int i1 = this.jdField_c_of_type_Int;
      int i2 = this.jdField_d_of_type_Int;
      int n = i2;
      int m = i1;
      if (this.j > 0)
      {
        n = i2;
        m = i1;
        if (this.k > 0)
        {
          m = this.k;
          n = this.j;
        }
      }
      this.jdField_a_of_type_Avtf.a(paramArrayOfByte, m, n, this.jdField_a_of_type_Avtg);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    biwd.a().a("startCameraPreview-begin");
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.5(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void b(boolean paramBoolean)
  {
    AECameraManager.3 local3 = new AECameraManager.3(this, paramBoolean);
    if (this.jdField_a_of_type_AndroidOsHandler.getLooper().getThread().getId() != Thread.currentThread().getId())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(local3);
      return;
    }
    local3.run();
  }
  
  public boolean b()
  {
    return this.l == 1;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.6(this));
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.12(this, paramInt));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.4(this, paramBoolean));
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.9(this));
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return jdField_a_of_type_Axhx.jdField_b_of_type_Boolean;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Avtf != null) {
      this.jdField_a_of_type_Avtf.a();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = null;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.11(this));
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_Bijm != null) {
      this.jdField_a_of_type_Bijm.a(paramSurfaceTexture);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bijj
 * JD-Core Version:    0.7.0.1
 */