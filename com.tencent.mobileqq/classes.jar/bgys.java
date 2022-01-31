import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.hardware.Camera;
import android.os.Build;
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
import dov.com.qq.im.AECamera.View.AECameraManager.1;
import dov.com.qq.im.AECamera.View.AECameraManager.10;
import dov.com.qq.im.AECamera.View.AECameraManager.11;
import dov.com.qq.im.AECamera.View.AECameraManager.12;
import dov.com.qq.im.AECamera.View.AECameraManager.2;
import dov.com.qq.im.AECamera.View.AECameraManager.3;
import dov.com.qq.im.AECamera.View.AECameraManager.4;
import dov.com.qq.im.AECamera.View.AECameraManager.5;
import dov.com.qq.im.AECamera.View.AECameraManager.6;
import dov.com.qq.im.AECamera.View.AECameraManager.7;
import dov.com.qq.im.AECamera.View.AECameraManager.8;
import dov.com.qq.im.AECamera.View.AECameraManager.9;
import java.io.File;

public class bgys
  implements SurfaceTexture.OnFrameAvailableListener, awhd, awiq, awiy
{
  private static final awir jdField_a_of_type_Awir = CameraCaptureView.jdField_a_of_type_Awir;
  private static final String jdField_a_of_type_JavaLangString = bgys.class.getSimpleName();
  public int a;
  private ahjh jdField_a_of_type_Ahjh;
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private View jdField_a_of_type_AndroidViewView;
  private autw jdField_a_of_type_Autw;
  private autx jdField_a_of_type_Autx;
  private awip jdField_a_of_type_Awip = new awip(this.jdField_b_of_type_AndroidOsHandler, this);
  private bgxk jdField_a_of_type_Bgxk;
  private bgyv jdField_a_of_type_Bgyv;
  private AudioCapture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  public boolean a;
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
  
  private bgys()
  {
    if ((this.l == 1) && (!alrg.d())) {
      this.l = 2;
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("AECameraManagerHandlerThread");
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    jdField_a_of_type_Awir.a(this.jdField_a_of_type_Awip);
    jdField_a_of_type_Awir.e(true);
    this.jdField_a_of_type_Ahjh = new ahjh();
  }
  
  public static bgys a()
  {
    return bgyw.a;
  }
  
  private void a(awim paramawim)
  {
    this.jdField_c_of_type_Int = paramawim.jdField_b_of_type_Int;
    this.jdField_d_of_type_Int = paramawim.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Bgyv != null) {
      this.jdField_a_of_type_Bgyv.a(this.jdField_c_of_type_Int, this.jdField_d_of_type_Int);
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
        QLog.e(jdField_a_of_type_JavaLangString, 2, "turn FrontFlash Error ", paramActivity);
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
  
  private void b(bgxk parambgxk)
  {
    this.jdField_a_of_type_Bgxk = parambgxk;
  }
  
  public int a()
  {
    return this.l;
  }
  
  public Handler a()
  {
    if (jdField_a_of_type_Awir == null) {
      return null;
    }
    return jdField_a_of_type_Awir.a();
  }
  
  public String a()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "[@] getDefaultFocusMode: Build.MANUFACTURER=" + Build.MANUFACTURER + "VERSION.SDK_INT=" + Build.VERSION.SDK_INT);
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.VERSION.SDK_INT >= 14)) {}
    return "continuous-picture";
  }
  
  public void a()
  {
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
    if (this.jdField_a_of_type_Ahjh != null) {
      this.jdField_a_of_type_Ahjh.a(paramInt2, paramInt1, b(), c());
    }
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (this.l == 1)
    {
      b(paramActivity, paramBoolean);
      return;
    }
    jdField_a_of_type_Awir.c(paramBoolean);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_i_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = paramSurfaceTexture;
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture.setOnFrameAvailableListener(this);
  }
  
  public void a(autw paramautw)
  {
    this.jdField_a_of_type_Autw = paramautw;
  }
  
  public void a(autx paramautx)
  {
    this.jdField_a_of_type_Autx = paramautx;
  }
  
  public void a(bgxk parambgxk)
  {
    this.jdField_a_of_type_Autw = new autw();
    b(parambgxk);
    this.l = parambgxk.g();
    if ((this.l == 1) && (!alrg.d())) {
      this.l = 2;
    }
  }
  
  public void a(bgyv parambgyv)
  {
    String str2;
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      str2 = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder().append("### setCameraManagerListener with ");
      if (parambgyv != null) {
        break label53;
      }
    }
    label53:
    for (String str1 = "null";; str1 = parambgyv.toString())
    {
      QLog.d(str2, 4, str1);
      this.jdField_a_of_type_Bgyv = parambgyv;
      return;
    }
  }
  
  public void a(AudioCapture paramAudioCapture)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = paramAudioCapture;
  }
  
  public void a(File paramFile, int paramInt, boolean paramBoolean, ahns paramahns)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.7(this, paramFile, paramahns, paramInt, paramBoolean));
  }
  
  public void a(Exception paramException) {}
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
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
                if (!(paramVarArgs[0] instanceof awim)) {
                  break;
                }
                a((awim)paramVarArgs[0]);
              } while (this.jdField_a_of_type_Bgyv == null);
              this.jdField_a_of_type_Bgyv.a(true, "");
              bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Camera Open Success】EVENT_SET_CAMERA_PARAM");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bgyv == null));
            this.jdField_a_of_type_Bgyv.a(false, (String)paramVarArgs[0]);
            bhcs.b(jdField_a_of_type_JavaLangString, 1, "【Camera Open Error】EVENT_SET_CAMERA_PARAM:" + paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bgyv == null));
          this.jdField_a_of_type_Bgyv.a(false, (String)paramVarArgs[0]);
          bhcs.b(jdField_a_of_type_JavaLangString, 1, "【Camera Open Error】EVENT_CREATE_CAMERA:" + paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.jdField_a_of_type_Bgyv == null));
        this.jdField_a_of_type_Bgyv.a(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        bhcs.b(jdField_a_of_type_JavaLangString, 1, "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof awim)) {
          break;
        }
        a((awim)paramVarArgs[0]);
        if (this.jdField_a_of_type_Bgyv != null)
        {
          this.jdField_a_of_type_Bgyv.a(true, "");
          bhcs.a(jdField_a_of_type_JavaLangString, 1, "【Camera2 Open Success】EVENT_CAMERA2_PARAMS");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof awim)));
      paramObject = (awim)paramVarArgs[1];
      this.j = paramObject.jdField_a_of_type_Int;
      this.k = paramObject.jdField_b_of_type_Int;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bgyv == null));
    this.jdField_a_of_type_Bgyv.a(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
    bhcs.b(jdField_a_of_type_JavaLangString, 1, "【Camera2 Open Error】setCamera2 Params error::" + paramVarArgs[0]);
  }
  
  public void a(RuntimeException paramRuntimeException) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    awij.a().a(true, paramArrayOfByte);
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
      this.jdField_a_of_type_Autw.a(paramArrayOfByte, m, n, this.jdField_a_of_type_Autx);
    }
  }
  
  public boolean a()
  {
    return this.l == 1;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.2(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_i_of_type_Boolean = true;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    AECameraManager.3 local3 = new AECameraManager.3(this);
    if (this.jdField_a_of_type_AndroidOsHandler.getLooper().getThread().getId() != Thread.currentThread().getId())
    {
      this.jdField_a_of_type_AndroidOsHandler.post(local3);
      return;
    }
    local3.run();
  }
  
  public boolean c()
  {
    return jdField_a_of_type_Awir.jdField_b_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.4(this));
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.5(this));
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.6(this));
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.9(this));
  }
  
  public void h()
  {
    a(null, false);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Autw != null) {
      this.jdField_a_of_type_Autw.a();
    }
  }
  
  public void j()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.11(this));
  }
  
  public void k()
  {
    String str = a();
    if ((!awij.a().a(str)) && (awij.a().a("auto"))) {
      awij.a().a(null);
    }
  }
  
  public void l()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.12(this));
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    if (this.jdField_a_of_type_Bgyv != null) {
      this.jdField_a_of_type_Bgyv.a(paramSurfaceTexture);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgys
 * JD-Core Version:    0.7.0.1
 */