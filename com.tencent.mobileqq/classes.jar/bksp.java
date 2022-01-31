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

public class bksp
  implements SurfaceTexture.OnFrameAvailableListener, azga, azhn, azhv
{
  private static final azho jdField_a_of_type_Azho = CameraCaptureView.jdField_a_of_type_Azho;
  public int a;
  private ajrv jdField_a_of_type_Ajrv;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private View jdField_a_of_type_AndroidViewView;
  private axpp jdField_a_of_type_Axpp;
  private axpq jdField_a_of_type_Axpq;
  private azhm jdField_a_of_type_Azhm = new azhm(this.jdField_b_of_type_AndroidOsHandler, this);
  private bksf jdField_a_of_type_Bksf;
  private bkss jdField_a_of_type_Bkss;
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
  
  private bksp()
  {
    this.jdField_a_of_type_Int = 1080;
    this.jdField_b_of_type_Int = 1920;
    if ((this.l == 1) && (!aobe.d())) {
      this.l = 2;
    }
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("AECameraManagerHandlerThread");
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    jdField_a_of_type_Azho.a(this.jdField_a_of_type_Azhm);
    jdField_a_of_type_Azho.e(true);
    this.jdField_a_of_type_Ajrv = new ajrv();
  }
  
  public static bksp a()
  {
    return bkst.a;
  }
  
  private void a(azhj paramazhj)
  {
    this.jdField_c_of_type_Int = paramazhj.jdField_b_of_type_Int;
    this.jdField_d_of_type_Int = paramazhj.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Bkss != null) {
      this.jdField_a_of_type_Bkss.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
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
  
  private void b(bksf parambksf)
  {
    this.jdField_a_of_type_Bksf = parambksf;
  }
  
  private void h()
  {
    blfv.a().a("AECameraManager", "realStartPreview---surfaceWidth=" + this.jdField_a_of_type_Int + ", surfaceHeight=" + this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Bksf.i(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bksf.j(this.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      jdField_a_of_type_Azho.a(new azhj(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int), new azhj(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int), 0, 30, true);
    }
    for (;;)
    {
      jdField_a_of_type_Azho.a(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture, null, this, true);
      this.jdField_h_of_type_Boolean = true;
      this.jdField_f_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_g_of_type_Int = this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Bkss != null) {
        this.jdField_a_of_type_Bkss.i();
      }
      bljn.b("AECameraManager", "### realStartPreview");
      blfv.a().a("startCameraPreview-end");
      return;
      jdField_a_of_type_Azho.a(new azhj(this.jdField_a_of_type_Bksf.b(), this.jdField_a_of_type_Bksf.c()), new azhj(this.jdField_a_of_type_Bksf.d(), this.jdField_a_of_type_Bksf.e()), 0, 30, false);
    }
  }
  
  public int a()
  {
    return this.l;
  }
  
  public Handler a()
  {
    if (jdField_a_of_type_Azho == null) {
      return null;
    }
    return jdField_a_of_type_Azho.a();
  }
  
  public void a()
  {
    blfv.a().a("openCamera-begin");
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
    if (this.jdField_a_of_type_Ajrv != null) {
      this.jdField_a_of_type_Ajrv.a(paramInt2, paramInt1, b(), c());
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (this.l == 1)
    {
      b(paramActivity, paramBoolean);
      return;
    }
    jdField_a_of_type_Azho.c(paramBoolean);
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
  
  public void a(axpp paramaxpp)
  {
    this.jdField_a_of_type_Axpp = paramaxpp;
  }
  
  public void a(axpq paramaxpq)
  {
    this.jdField_a_of_type_Axpq = paramaxpq;
  }
  
  public void a(bksf parambksf)
  {
    this.jdField_a_of_type_Axpp = new axpp();
    b(parambksf);
    this.l = parambksf.g();
    if ((this.l == 1) && (!aobe.d())) {
      this.l = 2;
    }
  }
  
  public void a(bkss parambkss)
  {
    bljn.b("AECameraManager", "### setCameraManagerListener--- listener=" + parambkss);
    this.jdField_a_of_type_Bkss = parambkss;
  }
  
  public void a(AudioCapture paramAudioCapture)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = paramAudioCapture;
  }
  
  public void a(File paramFile, int paramInt, boolean paramBoolean, ajwh paramajwh)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.7(this, paramFile, paramajwh, paramInt, paramBoolean));
  }
  
  public void a(Exception paramException)
  {
    if (paramException != null)
    {
      bljn.a("AECameraManager", "onCameraException---" + paramException.getMessage(), paramException);
      return;
    }
    bljn.d("AECameraManager", "onCameraException---");
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    blfv.a().a("AECameraManager", "【CameraProxy notify】eventId=" + paramInt + ", args=" + Arrays.toString(paramVarArgs));
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
                if (!(paramVarArgs[0] instanceof azhj)) {
                  break;
                }
                a((azhj)paramVarArgs[0]);
              } while (this.jdField_a_of_type_Bkss == null);
              this.jdField_a_of_type_Bkss.a(true, "");
              bljn.b("AECameraManager", "【Camera Open Success】EVENT_SET_CAMERA_PARAM");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bkss == null));
            this.jdField_a_of_type_Bkss.a(false, (String)paramVarArgs[0]);
            bljn.d("AECameraManager", "【Camera Open Error】EVENT_SET_CAMERA_PARAM:" + paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bkss == null));
          this.jdField_a_of_type_Bkss.a(false, (String)paramVarArgs[0]);
          bljn.d("AECameraManager", "【Camera Open Error】EVENT_CREATE_CAMERA:" + paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.jdField_a_of_type_Bkss == null));
        this.jdField_a_of_type_Bkss.a(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        bljn.d("AECameraManager", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof azhj)) {
          break;
        }
        a((azhj)paramVarArgs[0]);
        if (this.jdField_a_of_type_Bkss != null)
        {
          this.jdField_a_of_type_Bkss.a(true, "");
          bljn.b("AECameraManager", "【Camera2 Open Success】EVENT_CAMERA2_PARAMS");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof azhj)));
      paramObject = (azhj)paramVarArgs[1];
      this.j = paramObject.jdField_a_of_type_Int;
      this.k = paramObject.jdField_b_of_type_Int;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bkss == null));
    this.jdField_a_of_type_Bkss.a(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
    bljn.d("AECameraManager", "【Camera2 Open Error】setCamera2 Params error::" + paramVarArgs[0]);
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (paramRuntimeException != null)
    {
      bljn.a("AECameraManager", "onDispatchThreadException---" + paramRuntimeException.getMessage(), paramRuntimeException);
      return;
    }
    bljn.d("AECameraManager", "onDispatchThreadException---");
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
      blfv.a().a("onCameraPreviewFrameData");
    }
    azhg.a().a(true, paramArrayOfByte);
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
      this.jdField_a_of_type_Axpp.a(paramArrayOfByte, m, n, this.jdField_a_of_type_Axpq);
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
    blfv.a().a("startCameraPreview-begin");
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
    return jdField_a_of_type_Azho.jdField_b_of_type_Boolean;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Axpp != null) {
      this.jdField_a_of_type_Axpp.a();
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
    if (this.jdField_a_of_type_Bkss != null) {
      this.jdField_a_of_type_Bkss.a(paramSurfaceTexture);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksp
 * JD-Core Version:    0.7.0.1
 */