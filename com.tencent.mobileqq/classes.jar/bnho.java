import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings.System;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
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
import java.util.concurrent.atomic.AtomicInteger;

public class bnho
  implements bcha, bcin, bciv
{
  private int jdField_a_of_type_Int;
  private alkl jdField_a_of_type_Alkl;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private banq jdField_a_of_type_Banq;
  private banr jdField_a_of_type_Banr;
  private final bcio jdField_a_of_type_Bcio = new bcio(null, null);
  private bnhe jdField_a_of_type_Bnhe;
  private bnhr jdField_a_of_type_Bnhr;
  private AudioCapture jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  private final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int g;
  private int h = 1;
  
  public bnho()
  {
    bcim localbcim = new bcim(new Handler(Looper.getMainLooper()), this);
    if (!aqbj.d()) {
      this.h = 2;
    }
    HandlerThread localHandlerThread = new HandlerThread("AECameraManagerHandlerThread");
    localHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(localHandlerThread.getLooper());
    this.jdField_a_of_type_Bcio.a(localbcim);
    this.jdField_a_of_type_Bcio.e(true);
    this.jdField_a_of_type_Alkl = new alkl();
  }
  
  private void a(bcij parambcij)
  {
    this.jdField_a_of_type_Int = parambcij.jdField_b_of_type_Int;
    this.jdField_b_of_type_Int = parambcij.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Bnhr != null) {
      this.jdField_a_of_type_Bnhr.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
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
        this.jdField_d_of_type_Int = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness_mode");
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness_mode", 0);
        this.jdField_e_of_type_Int = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness");
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness", 255);
        this.jdField_d_of_type_Boolean = true;
        return;
      }
      catch (Exception paramActivity)
      {
        do
        {
          this.jdField_d_of_type_Int = 1;
          this.jdField_e_of_type_Int = 100;
        } while (!QLog.isColorLevel());
        QLog.e("AECameraManager", 2, "turn FrontFlash Error ", paramActivity);
        paramActivity.printStackTrace();
        return;
      }
      if (this.jdField_d_of_type_Boolean)
      {
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness", this.jdField_e_of_type_Int);
        Settings.System.putInt(paramActivity.getContentResolver(), "screen_brightness_mode", this.jdField_d_of_type_Int);
        this.jdField_d_of_type_Boolean = false;
      }
    } while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getParent() == null));
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void b(SurfaceTexture paramSurfaceTexture, allk paramallk)
  {
    bnzb.b("AECameraManager", "realStartPreview---ENTER, previewTexture=" + paramSurfaceTexture + ", previewSize=" + paramallk);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(3);
    this.jdField_a_of_type_Bnhe.i(paramallk.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bnhe.j(paramallk.jdField_b_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bcio.a(new bcij(paramallk.jdField_b_of_type_Int, paramallk.jdField_a_of_type_Int), new bcij(paramallk.jdField_a_of_type_Int, paramallk.jdField_b_of_type_Int), 0, 30, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcio.a(paramSurfaceTexture, null, this, true);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(4);
      if (this.jdField_a_of_type_Bnhr != null) {
        this.jdField_a_of_type_Bnhr.a();
      }
      bnzb.b("AECameraManager", "realStartPreview---EXIT");
      bnvd.a().a("startCameraPreview-end");
      return;
      this.jdField_a_of_type_Bcio.a(new bcij(this.jdField_a_of_type_Bnhe.b(), this.jdField_a_of_type_Bnhe.c()), new bcij(this.jdField_a_of_type_Bnhe.d(), this.jdField_a_of_type_Bnhe.e()), 0, 30, false);
    }
  }
  
  private void b(bnhe parambnhe)
  {
    this.jdField_a_of_type_Bnhe = parambnhe;
  }
  
  /* Error */
  private void c(bnhs parambnhs)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 205
    //   4: new 215	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   11: ldc_w 289
    //   14: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokespecial 131	bnho:d	()Z
    //   21: invokevirtual 292	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   24: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 236	bnzb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokespecial 131	bnho:d	()Z
    //   34: ifeq +30 -> 64
    //   37: ldc 205
    //   39: ldc_w 294
    //   42: invokestatic 296	bnzb:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_1
    //   46: ifnull +17 -> 63
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 43	bnho:h	I
    //   54: aload_0
    //   55: invokespecial 131	bnho:d	()Z
    //   58: invokeinterface 301 3 0
    //   63: return
    //   64: aload_0
    //   65: getfield 41	bnho:jdField_a_of_type_Bcio	Lbcio;
    //   68: aload_0
    //   69: invokevirtual 304	bcio:a	(Lbcha;)V
    //   72: aload_0
    //   73: getfield 41	bnho:jdField_a_of_type_Bcio	Lbcio;
    //   76: aload_0
    //   77: getfield 43	bnho:h	I
    //   80: invokevirtual 306	bcio:b	(I)V
    //   83: aload_0
    //   84: getfield 50	bnho:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   87: iconst_2
    //   88: invokevirtual 239	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   91: ldc 205
    //   93: ldc_w 308
    //   96: invokestatic 236	bnzb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 310	bnho:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;
    //   103: ifnull +10 -> 113
    //   106: aload_0
    //   107: getfield 310	bnho:jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture	Lcom/tencent/mobileqq/richmedia/capture/audio/AudioCapture;
    //   110: invokevirtual 314	com/tencent/mobileqq/richmedia/capture/audio/AudioCapture:f	()V
    //   113: aload_0
    //   114: getfield 97	bnho:jdField_a_of_type_Alkl	Lalkl;
    //   117: ifnull +21 -> 138
    //   120: aload_0
    //   121: getfield 97	bnho:jdField_a_of_type_Alkl	Lalkl;
    //   124: astore_3
    //   125: aload_0
    //   126: getfield 43	bnho:h	I
    //   129: iconst_1
    //   130: if_icmpne +43 -> 173
    //   133: aload_3
    //   134: iload_2
    //   135: invokevirtual 316	alkl:a	(Z)V
    //   138: aload_0
    //   139: getfield 43	bnho:h	I
    //   142: putstatic 319	alin:jdField_a_of_type_Int	I
    //   145: invokestatic 271	bnvd:a	()Lbnvd;
    //   148: ldc_w 321
    //   151: invokevirtual 275	bnvd:a	(Ljava/lang/String;)V
    //   154: aload_1
    //   155: ifnull -92 -> 63
    //   158: aload_1
    //   159: aload_0
    //   160: getfield 43	bnho:h	I
    //   163: aload_0
    //   164: invokespecial 131	bnho:d	()Z
    //   167: invokeinterface 301 3 0
    //   172: return
    //   173: iconst_0
    //   174: istore_2
    //   175: goto -42 -> 133
    //   178: astore_3
    //   179: aload_1
    //   180: ifnull +17 -> 197
    //   183: aload_1
    //   184: aload_0
    //   185: getfield 43	bnho:h	I
    //   188: aload_0
    //   189: invokespecial 131	bnho:d	()Z
    //   192: invokeinterface 301 3 0
    //   197: aload_3
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	bnho
    //   0	199	1	parambnhs	bnhs
    //   1	174	2	bool	boolean
    //   124	10	3	localalkl	alkl
    //   178	20	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	45	178	finally
    //   64	113	178	finally
    //   113	133	178	finally
    //   133	138	178	finally
    //   138	154	178	finally
  }
  
  private boolean d()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 1;
  }
  
  private void e(boolean paramBoolean)
  {
    bnzb.b("AECameraManager", "stopCameraInternal---ENTER, cameraCreated=" + d() + ", forceStop=" + paramBoolean);
    if ((!paramBoolean) && (!d()))
    {
      bnzb.d("AECameraManager", "stopCameraInternal---EXIT, not created, do nothing");
      return;
    }
    this.jdField_a_of_type_Bcio.a(false);
    this.jdField_a_of_type_Bcio.b(false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.g();
    }
    this.jdField_a_of_type_Bcio.b(this);
    this.jdField_a_of_type_Bcio.b(PeakAppInterface.a);
    bnzb.b("AECameraManager", "stopCameraInternal---EXIT, normally");
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() >= 3;
  }
  
  public int a()
  {
    return this.h;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_Bcio == null) {
      return null;
    }
    return this.jdField_a_of_type_Bcio.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.6(this));
  }
  
  public void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.8(this, paramFloat1, paramFloat2, paramInt1, paramInt2));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.10(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Alkl != null) {
      this.jdField_a_of_type_Alkl.a(paramInt2, paramInt1, paramInt3, paramInt4);
    }
  }
  
  public void a(int paramInt, bnhs parambnhs)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.4(this, paramInt, parambnhs));
  }
  
  public void a(Activity paramActivity, boolean paramBoolean)
  {
    if (this.h == 1)
    {
      b(paramActivity, paramBoolean);
      return;
    }
    this.jdField_a_of_type_Bcio.c(paramBoolean);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, allk paramallk)
  {
    bnzb.b("AECameraManager", "startCameraPreview ENTER---previewTexture=" + paramSurfaceTexture + ", previewSize=" + paramallk);
    if ((paramSurfaceTexture == null) || (paramallk == null) || (Math.min(paramallk.jdField_a_of_type_Int, paramallk.jdField_b_of_type_Int) <= 0)) {
      return;
    }
    bnvd.a().a("startCameraPreview-begin");
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.5(this, paramSurfaceTexture, paramallk));
  }
  
  public void a(banq parambanq)
  {
    this.jdField_a_of_type_Banq = parambanq;
  }
  
  public void a(banr parambanr)
  {
    this.jdField_a_of_type_Banr = parambanr;
  }
  
  public void a(bnhe parambnhe)
  {
    this.jdField_a_of_type_Banq = new banq();
    b(parambnhe);
    this.h = parambnhe.g();
    if ((this.h == 1) && (!aqbj.d())) {
      this.h = 2;
    }
  }
  
  public void a(bnhr parambnhr)
  {
    bnzb.b("AECameraManager", "### setCameraManagerListener--- listener=" + parambnhr);
    this.jdField_a_of_type_Bnhr = parambnhr;
  }
  
  public void a(bnhs parambnhs)
  {
    bnvd.a().a("openCamera-begin");
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.1(this, parambnhs));
  }
  
  public void a(AudioCapture paramAudioCapture)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = paramAudioCapture;
  }
  
  public void a(File paramFile, int paramInt, boolean paramBoolean, alox paramalox, allk paramallk)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.7(this, paramFile, paramallk, paramalox, paramInt, paramBoolean));
  }
  
  public void a(Exception paramException)
  {
    if (paramException != null)
    {
      bnzb.a("AECameraManager", "onCameraException---" + paramException.getMessage(), paramException);
      return;
    }
    bnzb.d("AECameraManager", "onCameraException---");
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    bnvd.a().a("AECameraManager", "【CameraProxy notify】eventId=" + paramInt + ", args=" + Arrays.toString(paramVarArgs));
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
                if (!(paramVarArgs[0] instanceof bcij)) {
                  break;
                }
                a((bcij)paramVarArgs[0]);
              } while (this.jdField_a_of_type_Bnhr == null);
              this.jdField_a_of_type_Bnhr.a(true, "");
              bnzb.b("AECameraManager", "【Camera Open Success】EVENT_SET_CAMERA_PARAM");
              return;
            } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bnhr == null));
            this.jdField_a_of_type_Bnhr.a(false, (String)paramVarArgs[0]);
            bnzb.d("AECameraManager", "【Camera Open Error】EVENT_SET_CAMERA_PARAM:" + paramVarArgs[0]);
            return;
          } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bnhr == null));
          this.jdField_a_of_type_Bnhr.a(false, (String)paramVarArgs[0]);
          bnzb.d("AECameraManager", "【Camera Open Error】EVENT_CREATE_CAMERA:" + paramVarArgs[0]);
          return;
        } while ((!(paramVarArgs[0] instanceof Integer)) || (this.jdField_a_of_type_Bnhr == null));
        this.jdField_a_of_type_Bnhr.a(false, "[Camera2]openCamera2 error:" + paramVarArgs[0]);
        bnzb.d("AECameraManager", "【Camera2 Open Error】EVENT_CAMERA2_ERROR:" + paramVarArgs[0]);
        return;
        if (!(paramVarArgs[0] instanceof bcij)) {
          break;
        }
        a((bcij)paramVarArgs[0]);
        if (this.jdField_a_of_type_Bnhr != null)
        {
          this.jdField_a_of_type_Bnhr.a(true, "");
          bnzb.b("AECameraManager", "【Camera2 Open Success】EVENT_CAMERA2_PARAMS");
        }
      } while ((paramVarArgs.length < 2) || (!(paramVarArgs[1] instanceof bcij)));
      paramObject = (bcij)paramVarArgs[1];
      this.jdField_f_of_type_Int = paramObject.jdField_a_of_type_Int;
      this.g = paramObject.jdField_b_of_type_Int;
      return;
    } while ((!(paramVarArgs[0] instanceof String)) || (this.jdField_a_of_type_Bnhr == null));
    this.jdField_a_of_type_Bnhr.a(false, "[Camera2]setCamera2 Params error:" + paramVarArgs[0]);
    bnzb.d("AECameraManager", "【Camera2 Open Error】setCamera2 Params error::" + paramVarArgs[0]);
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    if (paramRuntimeException != null)
    {
      bnzb.a("AECameraManager", "onDispatchThreadException---" + paramRuntimeException.getMessage(), paramRuntimeException);
      return;
    }
    bnzb.d("AECameraManager", "onDispatchThreadException---");
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.2(this, paramBoolean));
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = true;
      bnvd.a().a("onCameraPreviewFrameData");
    }
    bcig.a().a(true, paramArrayOfByte);
    if (this.jdField_e_of_type_Boolean)
    {
      int k = this.jdField_a_of_type_Int;
      int m = this.jdField_b_of_type_Int;
      int j = m;
      int i = k;
      if (this.jdField_f_of_type_Int > 0)
      {
        j = m;
        i = k;
        if (this.g > 0)
        {
          i = this.g;
          j = this.jdField_f_of_type_Int;
        }
      }
      this.jdField_a_of_type_Banq.a(paramArrayOfByte, i, j, this.jdField_a_of_type_Banr);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_Boolean) && (!this.jdField_b_of_type_Boolean);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.9(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(bnhs parambnhs)
  {
    if (!aqbj.d())
    {
      bnzb.d("AECameraManager", "toggleCamera---front camera not exists, not support toggle");
      parambnhs.a(this.h, false);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.3(this, parambnhs));
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.h == 1;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Banq != null) {
      this.jdField_a_of_type_Banq.a();
    }
  }
  
  public void c(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 1)) {}
    while ((paramInt == 1) && (!aqbj.d())) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.12(this, paramInt));
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new AECameraManager.11(this));
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnho
 * JD-Core Version:    0.7.0.1
 */