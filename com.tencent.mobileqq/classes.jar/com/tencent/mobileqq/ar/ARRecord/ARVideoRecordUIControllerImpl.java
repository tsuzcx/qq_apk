package com.tencent.mobileqq.ar.ARRecord;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;

public class ARVideoRecordUIControllerImpl
  implements Handler.Callback, ARVideoRecordViewPresenter.onMonitorUserOperationListener, VideoRecordController.RecordListener
{
  public static final String a = HardCodeUtil.a(2131899010);
  public static final String b = HardCodeUtil.a(2131899011);
  public static final String c = HardCodeUtil.a(2131899006);
  public static final String d = HardCodeUtil.a(2131899007);
  public static final String e = HardCodeUtil.a(2131899009);
  public static final String f = HardCodeUtil.a(2131899013);
  public static final String g = HardCodeUtil.a(2131899008);
  public static final String h = HardCodeUtil.a(2131899012);
  private int A = 0;
  private boolean B = false;
  private boolean C = false;
  private int D = -1;
  @Deprecated
  private Context E;
  private boolean F = true;
  private boolean G = true;
  private Activity H;
  private boolean I;
  private final int i = 1;
  private final int j = 2;
  private final int k = 3;
  private final int l = 4;
  private final int m = 5;
  private final int n = 6;
  private final int o = 7;
  private final int p = 8;
  private final int q = 9;
  private final int r = 10;
  private final int s = 12;
  private final int t = 13;
  private boolean u = false;
  private boolean v = false;
  private HandlerThread w = null;
  private Handler x = null;
  private volatile ARVideoRecordViewPresenter y;
  private volatile ARVideoRecordDataSource z;
  
  private ARVideoRecordUIControllerImpl()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ARVideoRecordUIControllerImpl mIsEnableVideoRecord");
      localStringBuilder.append(this.F);
      QLog.i("ARVideoRecordUIControllerImpl", 2, localStringBuilder.toString());
    }
  }
  
  public static ARVideoRecordUIControllerImpl a()
  {
    return ARVideoRecordUIControllerImpl.ARVideoRecordControllerImplHolder.a();
  }
  
  private void a(Runnable paramRunnable)
  {
    Handler localHandler = this.x;
    if (localHandler != null) {
      localHandler.post(paramRunnable);
    }
  }
  
  public static void a(String paramString)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleInterruptARVideoRecord ");
      localStringBuilder.append(paramInt);
      QLog.i("ARVideoRecordUIControllerImpl", 2, localStringBuilder.toString());
    }
    if (p())
    {
      if (this.y != null)
      {
        this.y.a(0);
        this.y.b();
      }
      if ((paramInt != 2) && (paramInt != 4) && (paramInt != 6) && (paramInt != 1) && (paramInt != 3))
      {
        this.z.a(false, false);
        if (QLog.isColorLevel()) {
          QLog.i("ARVideoRecordUIControllerImpl", 2, "error branch ,should not happen");
        }
      }
      else
      {
        this.z.a(false, true);
      }
      this.D = paramInt;
      this.C = true;
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordUIControllerImpl", 2, "handleInterruptARVideoRecord normal record running");
      }
    }
    else
    {
      if (this.y != null) {
        this.y.b();
      }
      if (this.z != null) {
        this.z.a(false, false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordUIControllerImpl", 2, "handleInterruptARVideoRecord other condition");
      }
    }
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleVideoRecordErrorStatus ");
      localStringBuilder.append(paramInt);
      QLog.i("ARVideoRecordUIControllerImpl", 2, localStringBuilder.toString());
    }
    if (this.u)
    {
      this.y.a(0);
      if (!this.B)
      {
        if (paramInt == 11) {
          ARRecordUtils.a(a, false);
        } else {
          ThreadManager.getUIHandler().post(new ARVideoRecordUIControllerImpl.3(this));
        }
      }
      else {
        this.B = false;
      }
      this.C = false;
    }
    else
    {
      if (this.y != null)
      {
        this.y.a(0);
        this.y.b();
      }
      if (!this.B)
      {
        if (paramInt == 11) {
          ARRecordUtils.a(a, false);
        } else {
          ThreadManager.getUIHandler().post(new ARVideoRecordUIControllerImpl.4(this));
        }
      }
      else {
        this.B = false;
      }
      this.C = false;
      r();
    }
    this.D = -1;
    a("0X8008A57");
  }
  
  private void m()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleDoOnResume");
    }
    this.C = false;
    this.D = -1;
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleExternalAnimationStart");
    }
    if (!this.F) {
      return;
    }
    if ((this.z != null) && (this.z.a())) {
      this.z.a(false, true);
    }
    if (this.y != null) {
      this.y.b();
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleExternalAnimationEnd");
    }
    if (this.y != null) {
      this.y.a();
    }
  }
  
  private boolean p()
  {
    return (g()) && (this.z.a());
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleOnPause");
    }
    if ((p()) && (this.D == -1))
    {
      this.z.a(false, false);
      this.D = 5;
      this.C = false;
      a("0X8008A57");
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordUIControllerImpl", 2, "handleOnPause mInterruptAnimationReason EXTERNAL_INTERRUPT");
      }
    }
    else if ((this.D == -1) && (this.z != null))
    {
      this.z.a(false, false);
    }
    ARVideoRecordViewPresenter localARVideoRecordViewPresenter = this.y;
    if (localARVideoRecordViewPresenter != null)
    {
      localARVideoRecordViewPresenter.a(0);
      localARVideoRecordViewPresenter.b();
    }
  }
  
  private void r()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("finalizeDestroy ");
        localStringBuilder.append(this.v);
        QLog.i("ARVideoRecordUIControllerImpl", 2, localStringBuilder.toString());
      }
      if ((this.v) && (!this.C))
      {
        if (this.x != null)
        {
          this.x.removeCallbacksAndMessages(null);
          this.x = null;
        }
        if (this.w != null)
        {
          if (Build.VERSION.SDK_INT >= 18) {
            this.w.quitSafely();
          } else {
            try
            {
              this.w.interrupt();
              this.w.quit();
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
          this.w = null;
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleMonitorUserOperationInternal");
    }
    if ((this.z != null) && (this.y != null))
    {
      if (this.y.c() == 0)
      {
        if (!ARRecordUtils.a(104857600L))
        {
          ARRecordUtils.a(c, d);
          return;
        }
        if (!this.z.a(true, null))
        {
          ARRecordUtils.a(a, false);
          if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "startVideoRecord failed");
          }
          return;
        }
        a("0X8008A54");
        this.y.a(1);
        if (QLog.isColorLevel()) {
          QLog.i("ARVideoRecordUIControllerImpl", 2, "startVideoRecord end");
        }
      }
      else
      {
        if (p())
        {
          this.z.a(true, true);
          this.D = 7;
          this.C = true;
          a("0X8008A55");
          if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordUIControllerImpl", 2, "stopVideoRecord and doReport");
          }
        }
        this.y.a(0);
        if (QLog.isColorLevel()) {
          QLog.i("ARVideoRecordUIControllerImpl", 2, "stopVideoRecord end");
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "handleMonitorUserOperationInternal with value null");
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startPreRecord ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("ARVideoRecordUIControllerImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (this.H == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      paramInt = ((QBaseActivity)this.H).checkSelfPermission("android.permission.RECORD_AUDIO");
    } else {
      paramInt = 0;
    }
    int i1 = paramInt;
    if (paramInt == 0)
    {
      i1 = paramInt;
      if (Build.VERSION.SDK_INT >= 23)
      {
        i1 = ((QBaseActivity)this.H).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        int i2 = ((QBaseActivity)this.H).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
        if (i1 == 0)
        {
          i1 = paramInt;
          if (i2 == 0) {}
        }
        else
        {
          i1 = -1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("startPreRecord permission=%s", new Object[] { Integer.valueOf(i1) }));
    }
    if ((this.F) && (this.G))
    {
      if (i1 != 0) {
        return;
      }
      localObject = this.x;
      if (localObject != null) {
        ((Handler)localObject).sendEmptyMessage(1);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordUpdate duration=%s fileSize=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    a(new ARVideoRecordUIControllerImpl.7(this, paramInt1, paramInt2));
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordFinish finishType=%s", new Object[] { Integer.valueOf(paramInt) }));
    a(new ARVideoRecordUIControllerImpl.8(this, paramInt));
  }
  
  public void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "start");
    }
    if (!this.F) {
      return;
    }
    if (this.w == null)
    {
      this.w = ThreadManager.newFreeHandlerThread("ARVideoRecordThread-P", 0);
      this.w.start();
      this.x = new Handler(this.w.getLooper(), this);
    }
    this.H = paramActivity;
    this.v = false;
  }
  
  @Deprecated
  public void a(Context paramContext)
  {
    this.E = paramContext;
  }
  
  public void a(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!this.F) {
        return;
      }
      if ((paramObject instanceof ARVideoRecordViewPresenter))
      {
        this.y = ((ARVideoRecordViewPresenter)paramObject);
        this.y.a(this);
        return;
      }
      if ((paramObject instanceof ARVideoRecordDataSource))
      {
        this.z = ((ARVideoRecordDataSource)paramObject);
        this.z.a(this);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.F)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordUIControllerImpl", 2, "do nothing apart from return ");
      }
      return;
    }
    if (paramBoolean == this.G)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("value equal return value:");
        localStringBuilder.append(this.G);
        QLog.i("ARVideoRecordUIControllerImpl", 2, localStringBuilder.toString());
      }
      return;
    }
    this.G = paramBoolean;
    if (this.G)
    {
      this.C = false;
      this.D = -1;
      if (QLog.isColorLevel()) {
        QLog.i("ARVideoRecordUIControllerImpl", 2, "call after onResume, from disable to enable");
      }
      return;
    }
    this.y = null;
    this.z = null;
    this.E = null;
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "call after onResume, from enable to disable");
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "doOnResume");
    }
    this.u = true;
    if (this.F)
    {
      if (!this.G) {
        return;
      }
      Handler localHandler = this.x;
      if (localHandler != null)
      {
        localHandler.removeMessages(12);
        this.x.sendEmptyMessage(12);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "interruptARVideoRecordIfNeed");
    }
    if (this.F)
    {
      if (!this.G) {
        return;
      }
      Object localObject = this.x;
      if ((localObject != null) && (this.w != null))
      {
        ((Handler)localObject).removeMessages(7);
        localObject = this.x.obtainMessage(7);
        ((Message)localObject).arg1 = paramInt;
        ((Message)localObject).sendToTarget();
      }
    }
  }
  
  public void b(Object paramObject)
  {
    if ((paramObject != null) && (this.F))
    {
      if (!this.G) {
        return;
      }
      if ((paramObject instanceof ARVideoRecordViewPresenter))
      {
        this.y = null;
        return;
      }
      if ((paramObject instanceof ARVideoRecordDataSource)) {
        this.z = null;
      }
    }
  }
  
  @Deprecated
  public Context c()
  {
    return this.E;
  }
  
  public void c(int paramInt)
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, String.format("onRecordError errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    Object localObject = this.x;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(8);
      ((Message)localObject).arg1 = paramInt;
      ((Message)localObject).sendToTarget();
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "showVideoRecordButton");
    }
    if (this.F)
    {
      if (!this.G) {
        return;
      }
      a(new ARVideoRecordUIControllerImpl.1(this));
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "hideVideoRecordButton");
    }
    if (this.F)
    {
      if (!this.G) {
        return;
      }
      a(new ARVideoRecordUIControllerImpl.2(this));
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "recordAnimationStartTimeStamp");
    }
    if (this.F)
    {
      if (!this.G) {
        return;
      }
      if (this.z != null) {
        this.z.a(System.currentTimeMillis());
      }
    }
  }
  
  public boolean g()
  {
    return (this.z != null) && (this.z.b());
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, "CheckPermission user grant");
    boolean bool = this.I;
  }
  
  public boolean h()
  {
    return (this.z != null) && (this.z.b()) && (!this.z.a());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 3)
      {
        if (i1 != 12)
        {
          if (i1 != 13)
          {
            switch (i1)
            {
            default: 
              return true;
            case 10: 
              o();
              return true;
            case 9: 
              n();
              return true;
            case 8: 
              e(paramMessage.arg1);
              return true;
            case 7: 
              d(paramMessage.arg1);
              return true;
            }
            if (this.y.c() == 0)
            {
              this.I = true;
              QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION UI displayMode normal");
              if (Build.VERSION.SDK_INT >= 23) {
                i1 = ((QBaseActivity)this.H).checkSelfPermission("android.permission.RECORD_AUDIO");
              } else {
                i1 = 0;
              }
              int i2;
              if (Build.VERSION.SDK_INT >= 23) {
                i2 = ((QBaseActivity)this.H).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
              } else {
                i2 = 0;
              }
              int i3;
              if (Build.VERSION.SDK_INT >= 23) {
                i3 = ((QBaseActivity)this.H).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
              } else {
                i3 = 0;
              }
              if ((i1 == 0) && (i2 == 0) && (i3 == 0)) {
                i1 = 0;
              } else {
                i1 = -1;
              }
              if (i1 == 0)
              {
                QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION has permission");
                s();
                return true;
              }
              QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION need request permission");
              ((QBaseActivity)this.H).requestPermissions(new ARVideoRecordUIControllerImpl.5(this), 1, new String[] { "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
              return true;
            }
            QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_NOTIFY_USER_OPERATION UI displayMode pressed");
            s();
            return true;
          }
          q();
          return true;
        }
        m();
        return true;
      }
      if (this.z != null)
      {
        this.z.a(false, false);
        return true;
      }
    }
    else if ((((QBaseActivity)this.H).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) && (((QBaseActivity)this.H).checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) && (((QBaseActivity)this.H).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0))
    {
      if (g()) {
        return true;
      }
      this.I = false;
      if (this.z != null)
      {
        this.z.a(false, null);
        return true;
      }
    }
    else
    {
      QLog.i("ARVideoRecordUIControllerImpl", 1, "MSG_START_PRE_RECORD permmit");
    }
    return true;
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "doOnPause");
    }
    this.u = false;
    if (this.F)
    {
      if (!this.G) {
        return;
      }
      Handler localHandler = this.x;
      if (localHandler != null)
      {
        localHandler.removeMessages(13);
        this.x.sendEmptyMessage(13);
      }
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "stop");
    }
    if (this.F)
    {
      if (!this.G) {
        return;
      }
      if (this.u)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ARVideoRecordUIControllerImpl", 2, "stop has been refused because of ActivityLifeCircle ERROR");
        }
        return;
      }
      this.y = null;
      this.z = null;
      this.E = null;
      this.H = null;
      this.v = true;
      r();
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ARVideoRecordUIControllerImpl", 2, "onMonitorUserOperation");
    }
    if (this.F)
    {
      if (!this.G) {
        return;
      }
      Handler localHandler = this.x;
      if (localHandler != null) {
        localHandler.sendEmptyMessage(6);
      }
    }
  }
  
  public void l()
  {
    QLog.d("ARVideoRecordUIControllerImpl", 2, "onRecordStart");
    a(new ARVideoRecordUIControllerImpl.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordUIControllerImpl
 * JD-Core Version:    0.7.0.1
 */