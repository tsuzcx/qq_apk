package com.tencent.mobileqq.ar.ARRecord;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import zuz;
import zva;
import zvb;
import zvc;
import zvd;
import zve;
import zvf;
import zvg;

public class ARVideoRecordUIControllerImpl
  implements Handler.Callback, ARVideoRecordViewPresenter.onMonitorUserOperationListener, VideoRecordController.RecordListener
{
  private final int jdField_a_of_type_Int = 1;
  @Deprecated
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private ARVideoRecordDataSource jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource;
  private ARVideoRecordViewPresenter jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 2;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int = 3;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = 4;
  private boolean jdField_d_of_type_Boolean;
  private final int jdField_e_of_type_Int = 5;
  private boolean jdField_e_of_type_Boolean = true;
  private final int jdField_f_of_type_Int = 6;
  private boolean jdField_f_of_type_Boolean = true;
  private final int g = 7;
  private final int h = 8;
  private final int i = 9;
  private final int j = 10;
  private final int k = 12;
  private final int l = 13;
  private int m = -1;
  
  private ARVideoRecordUIControllerImpl()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "ARVideoRecordUIControllerImpl mIsEnableVideoRecord" + this.jdField_e_of_type_Boolean);
    }
  }
  
  public static ARVideoRecordUIControllerImpl a()
  {
    return zvg.a();
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(paramRunnable);
    }
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  private boolean c()
  {
    return (a()) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a());
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleInterruptARVideoRecord " + paramInt);
    }
    if (c())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.a(0);
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.b();
      }
      if ((paramInt == 2) || (paramInt == 4) || (paramInt == 6) || (paramInt == 1) || (paramInt == 3))
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(false, true);
        this.m = paramInt;
        this.jdField_d_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.i("ARVideoRecordUIControllerImpl", 2, "handleInterruptARVideoRecord normal record running");
        }
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(false, false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ARVideoRecordUIControllerImpl", 2, "error branch ,should not happen");
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource != null) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(false, false);
      }
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordUIControllerImpl", 2, "handleInterruptARVideoRecord other condition");
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleVideoRecordErrorStatus " + paramInt);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.a(0);
      if (!this.jdField_c_of_type_Boolean) {
        if (paramInt == 11) {
          ARRecordUtils.a("录制时间过短，请重新录制。", false);
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_Boolean = false;
        this.m = -1;
        a("0X8008A57");
        return;
        ThreadManager.getUIHandler().post(new zvb(this));
        continue;
        this.jdField_c_of_type_Boolean = false;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.a(0);
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.b();
    }
    if (!this.jdField_c_of_type_Boolean) {
      if (paramInt == 11) {
        ARRecordUtils.a("录制时间过短，请重新录制。", false);
      }
    }
    for (;;)
    {
      this.jdField_d_of_type_Boolean = false;
      n();
      break;
      ThreadManager.getUIHandler().post(new zvc(this));
      continue;
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleDoOnResume");
    }
    this.jdField_d_of_type_Boolean = false;
    this.m = -1;
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleExternalAnimationStart");
    }
    if (!this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a())) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(false, true);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter == null);
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.b();
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleExternalAnimationEnd");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.a();
    }
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleOnPause");
    }
    if ((c()) && (this.m == -1))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(false, false);
      this.m = 5;
      this.jdField_d_of_type_Boolean = false;
      a("0X8008A57");
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordUIControllerImpl", 2, "handleOnPause mInterruptAnimationReason EXTERNAL_INTERRUPT");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.a(0);
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.b();
      }
      return;
      if ((this.m == -1) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource != null)) {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(false, false);
      }
    }
  }
  
  private void n()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("ARVideoRecordUIControllerImpl", 2, "finalizeDestroy " + this.jdField_b_of_type_Boolean);
        }
        if (this.jdField_b_of_type_Boolean)
        {
          boolean bool = this.jdField_d_of_type_Boolean;
          if (!bool) {}
        }
        else
        {
          return;
        }
        if (this.jdField_a_of_type_AndroidOsHandler != null)
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_AndroidOsHandler = null;
        }
        if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
          if (Build.VERSION.SDK_INT >= 18)
          {
            this.jdField_a_of_type_AndroidOsHandlerThread.quitSafely();
            this.jdField_a_of_type_AndroidOsHandlerThread = null;
          }
          else
          {
            try
            {
              this.jdField_a_of_type_AndroidOsHandlerThread.interrupt();
              this.jdField_a_of_type_AndroidOsHandlerThread.quit();
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
      finally {}
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleMonitorUserOperationInternal");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource == null) || (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter == null)) {
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordUIControllerImpl", 2, "handleMonitorUserOperationInternal with value null");
      }
    }
    label141:
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.a() != 0) {
            break label141;
          }
          if (!ARRecordUtils.a(104857600L))
          {
            ARRecordUtils.a("无法录屏", "手机可用存储空间不足，无法录制AR视频，你可以在手机“设置”中管理存储空间。");
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(true)) {
            break;
          }
          ARRecordUtils.a("录制时间过短，请重新录制。", false);
        } while (!QLog.isColorLevel());
        QLog.i("ARVideoRecordUIControllerImpl", 2, "startVideoRecord failed");
        return;
        a("0X8008A54");
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.a(1);
      } while (!QLog.isColorLevel());
      QLog.i("ARVideoRecordUIControllerImpl", 2, "startVideoRecord end");
      return;
      if (c())
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(true, true);
        this.m = 7;
        this.jdField_d_of_type_Boolean = true;
        a("0X8008A55");
        if (QLog.isColorLevel()) {
          QLog.i("ARVideoRecordUIControllerImpl", 2, "stopVideoRecord and doReport");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.a(0);
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordUIControllerImpl", 2, "stopVideoRecord end");
  }
  
  @Deprecated
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "start");
    }
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("ARVideoRecordThread-P", 0);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "startPreRecord " + paramInt);
    }
    if ((!this.jdField_e_of_type_Boolean) || (!this.jdField_f_of_type_Boolean)) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordUpdate duration=%s fileSize=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    a(new zve(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordFinish finishType=%s", new Object[] { Integer.valueOf(paramInt) }));
    a(new zvf(this, paramInt));
  }
  
  @Deprecated
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject == null) || (!this.jdField_e_of_type_Boolean)) {}
    do
    {
      return;
      if ((paramObject instanceof ARVideoRecordViewPresenter))
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter = ((ARVideoRecordViewPresenter)paramObject);
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter.a(this);
        return;
      }
    } while (!(paramObject instanceof ARVideoRecordDataSource));
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource = ((ARVideoRecordDataSource)paramObject);
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(this);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.jdField_e_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordUIControllerImpl", 2, "do nothing apart from return ");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramBoolean != this.jdField_f_of_type_Boolean) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("ARVideoRecordUIControllerImpl", 2, "value equal return value:" + this.jdField_f_of_type_Boolean);
        return;
        this.jdField_f_of_type_Boolean = paramBoolean;
        if (!this.jdField_f_of_type_Boolean) {
          break;
        }
        this.jdField_d_of_type_Boolean = false;
        this.m = -1;
      } while (!QLog.isColorLevel());
      QLog.i("ARVideoRecordUIControllerImpl", 2, "call after onResume, from disable to enable");
      return;
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter = null;
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource = null;
      this.jdField_a_of_type_AndroidContentContext = null;
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordUIControllerImpl", 2, "call after onResume, from enable to disable");
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.b());
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "doOnResume");
    }
    this.jdField_a_of_type_Boolean = true;
    if ((!this.jdField_e_of_type_Boolean) || (!this.jdField_f_of_type_Boolean)) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(12);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "interruptARVideoRecordIfNeed");
    }
    if ((!this.jdField_e_of_type_Boolean) || (!this.jdField_f_of_type_Boolean)) {}
    while ((this.jdField_a_of_type_AndroidOsHandler == null) || (this.jdField_a_of_type_AndroidOsHandlerThread == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public void b(Object paramObject)
  {
    if ((paramObject == null) || (!this.jdField_e_of_type_Boolean)) {}
    do
    {
      return;
      if ((paramObject instanceof ARVideoRecordViewPresenter))
      {
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter = null;
        return;
      }
    } while (!(paramObject instanceof ARVideoRecordDataSource));
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource = null;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource != null) && (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.b()) && (!this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a());
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "showVideoRecordButton");
    }
    if ((!this.jdField_e_of_type_Boolean) || (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    a(new zuz(this));
  }
  
  public void c(int paramInt)
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(8);
      localMessage.arg1 = paramInt;
      localMessage.sendToTarget();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "hideVideoRecordButton");
    }
    if ((!this.jdField_e_of_type_Boolean) || (!this.jdField_f_of_type_Boolean)) {
      return;
    }
    a(new zva(this));
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "recordAnimationStartTimeStamp");
    }
    if ((!this.jdField_e_of_type_Boolean) || (!this.jdField_f_of_type_Boolean)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(System.currentTimeMillis());
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "doOnPause");
    }
    this.jdField_a_of_type_Boolean = false;
    if ((!this.jdField_e_of_type_Boolean) || (!this.jdField_f_of_type_Boolean)) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(13);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(13);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "stop");
    }
    if (!this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordUIControllerImpl", 2, "stop has been refused because of ActivityLifeCircle ERROR");
    return;
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordViewPresenter = null;
    this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_Boolean = true;
    n();
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "onMonitorUserOperation");
    }
    if ((!this.jdField_e_of_type_Boolean) || (!this.jdField_f_of_type_Boolean)) {}
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    case 4: 
    case 5: 
    case 11: 
    default: 
    case 6: 
    case 9: 
    case 10: 
    case 7: 
    case 8: 
    case 1: 
    case 3: 
      do
      {
        do
        {
          return true;
          o();
          return true;
          k();
          return true;
          l();
          return true;
          d(paramMessage.arg1);
          return true;
          e(paramMessage.arg1);
          return true;
        } while ((a()) || (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource == null));
        this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(false);
        return true;
      } while (this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource == null);
      this.jdField_a_of_type_ComTencentMobileqqArARRecordARVideoRecordDataSource.a(false, false);
      return true;
    case 12: 
      j();
      return true;
    }
    m();
    return true;
  }
  
  public void i()
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, "onRecordStart");
    a(new zvd(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl
 * JD-Core Version:    0.7.0.1
 */