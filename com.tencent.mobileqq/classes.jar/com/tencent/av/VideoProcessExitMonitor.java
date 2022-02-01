package com.tencent.av;

import android.os.Handler;
import android.os.Looper;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class VideoProcessExitMonitor
{
  private static final Object a = new Object();
  private boolean b;
  private VideoAppInterface c;
  private Handler d;
  private int e;
  private Runnable f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  public VideoProcessExitMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.c = paramVideoAppInterface;
    this.d = new Handler(Looper.getMainLooper());
    this.e = 0;
    boolean bool;
    if (QavRecordDpc.a().m == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
    QLog.d("VideoProcessExitMonitor", 1, String.format("VideoProcessExitMonitor mExitProcessEnable=%s", new Object[] { Boolean.valueOf(this.b) }));
  }
  
  private void a(long paramLong)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("startMsfRespTimeoutCheck timeout=%s", new Object[] { Long.valueOf(paramLong) }));
    Runnable localRunnable = this.f;
    if (localRunnable != null)
    {
      this.d.removeCallbacks(localRunnable);
      this.f = null;
    }
    this.f = new VideoProcessExitMonitor.1(this);
    this.d.postDelayed(this.f, paramLong);
  }
  
  private void b(int paramInt)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("sendSetMsfConnStatusReq status=%s", new Object[] { Integer.valueOf(paramInt) }));
    NewIntent localNewIntent = new NewIntent(this.c.getApplication(), VideoServlet.class);
    localNewIntent.putExtra("reqType", 10);
    localNewIntent.putExtra("status", paramInt);
    this.c.startServlet(localNewIntent);
  }
  
  private void c(int paramInt)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("checkExitProcess status=%s", new Object[] { Integer.valueOf(paramInt) }));
    if (this.e == 2) {
      f();
    }
  }
  
  private void e()
  {
    synchronized (a)
    {
      QLog.d("VideoProcessExitMonitor", 1, String.format("receiveMsfSetConnStatusTimeout mCurStatus=%s", new Object[] { Integer.valueOf(this.e) }));
      if (this.e == 1) {
        this.e = 2;
      }
      c(this.e);
      return;
    }
  }
  
  private void f()
  {
    QLog.d("VideoProcessExitMonitor", 1, "exitProcess");
    long l1 = System.currentTimeMillis();
    QLog.flushLog(true);
    this.c.getApplication().otherProcessExit(true);
    QLog.d("VideoProcessExitMonitor", 1, String.format("exitProcess time cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
    this.c.w();
    try
    {
      Thread.sleep(300L);
      label66:
      System.exit(0);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label66;
    }
  }
  
  public void a()
  {
    if (!this.b) {
      return;
    }
    synchronized (a)
    {
      QLog.d("VideoProcessExitMonitor", 1, String.format("processActive mCurStatus=%s", new Object[] { Integer.valueOf(this.e) }));
      if (this.e != 0)
      {
        b(2);
        this.e = 0;
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (a)
    {
      QLog.d("VideoProcessExitMonitor", 1, String.format("receiveMsfSetConnStatusAck mCurStatus=%s status=%s", new Object[] { Integer.valueOf(this.e), Integer.valueOf(paramInt) }));
      if (this.f != null)
      {
        this.d.removeCallbacks(this.f);
        this.f = null;
      }
      if ((paramInt == 1) && (this.e == 1)) {
        this.e = 2;
      }
      c(this.e);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (!this.b)) {
      return;
    }
    synchronized (a)
    {
      QLog.d("VideoProcessExitMonitor", 1, String.format("processDeactive mCurStatus=%s", new Object[] { Integer.valueOf(this.e) }));
      if (this.e == 0)
      {
        b(1);
        a(2000L);
        this.e = 1;
      }
      else
      {
        int m = this.e;
      }
      c(this.e);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setAcceptMultiIncomingCall acceptMultiIncomingCall=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.g = paramBoolean;
  }
  
  public boolean b()
  {
    boolean bool1 = this.g;
    boolean bool2 = false;
    QLog.d("VideoProcessExitMonitor", 1, String.format("canExitProcess mAcceptMultiIncomingCall=%s mSwitch2MultiActive=%s mSwitch2MultiPassive=%s mSwitch2DoubleMeeting=%s mSwitch2OtherTerminal=%s mAllTerminalOffline=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.h), Boolean.valueOf(this.i), Boolean.valueOf(this.j), Boolean.valueOf(this.k), Boolean.valueOf(this.l) }));
    bool1 = bool2;
    if (!this.g)
    {
      bool1 = bool2;
      if (!this.h)
      {
        bool1 = bool2;
        if (!this.i)
        {
          bool1 = bool2;
          if (!this.j)
          {
            bool1 = bool2;
            if (!this.k)
            {
              bool1 = bool2;
              if (!this.l) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void c(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2MultiActive switch2MultiActive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.h = paramBoolean;
  }
  
  public boolean c()
  {
    return this.j;
  }
  
  public void d(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2MultiPassive switch2MultiPassive=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.i = paramBoolean;
  }
  
  public boolean d()
  {
    return this.l;
  }
  
  public void e(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2DoubleMeeting switch2DoubleMeeting=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.j = paramBoolean;
  }
  
  public void f(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setSwitch2OtherTerminal switch2OtherTerminal=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.k = paramBoolean;
  }
  
  public void g(boolean paramBoolean)
  {
    QLog.d("VideoProcessExitMonitor", 1, String.format("setAllTerminalOffline allTerminalOffline=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    this.l = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoProcessExitMonitor
 * JD-Core Version:    0.7.0.1
 */