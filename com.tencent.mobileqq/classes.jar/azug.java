import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class azug
  extends Handler
{
  private final float jdField_a_of_type_Float = 0.1F;
  private int jdField_a_of_type_Int;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private azuh jdField_a_of_type_Azuh;
  private Thread jdField_a_of_type_JavaLangThread;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Thread jdField_b_of_type_JavaLangThread;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
  public azug(SuspendThreadManager paramSuspendThreadManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(Throwable paramThrowable)
  {
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("suspend_error_count", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_error_count", i + 1);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, SuspendThreadManager.d());
  }
  
  private void a(boolean paramBoolean)
  {
    SuspendThreadManager.a(0);
    try
    {
      if (SuspendThreadManager.a().isEmpty())
      {
        d();
        SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
  }
  
  private void b()
  {
    SuspendThreadManager.a().a(ThreadManager.getSubThread());
    SuspendThreadManager.a().a(ThreadManager.getRecentThread());
    Thread[] arrayOfThread = SuspendThreadManager.a();
    int j = arrayOfThread.length;
    int i = 0;
    while (i < j)
    {
      Thread localThread = arrayOfThread[i];
      if (localThread.getName().equals("MSF-Receiver")) {
        SuspendThreadManager.a().a(localThread);
      }
      i += 1;
    }
  }
  
  private void c()
  {
    try
    {
      System.loadLibrary("threadsuspend");
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("suspend_thread_pref_file", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      boolean bool1;
      if ((Build.VERSION.SDK_INT <= 23) && (aznp.h))
      {
        SuspendThreadManager.jdField_a_of_type_Int |= 0x1;
        bool1 = true;
        this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("suspendCrashCount", 0);
        if (this.jdField_b_of_type_Int > SuspendThreadManager.b())
        {
          SuspendThreadManager.jdField_a_of_type_Int |= 0x8;
          bool1 = false;
        }
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("notResumeCountNew", 0);
        if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("suspend_check_flag", 0) != 0)
        {
          this.jdField_a_of_type_Int += 1;
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("notResumeCountNew", this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_check_flag", 0);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
          k();
        }
        if (this.jdField_a_of_type_Int <= SuspendThreadManager.c()) {
          break label586;
        }
        SuspendThreadManager.jdField_a_of_type_Int |= 0x10;
        bool1 = false;
      }
      for (;;)
      {
        QLog.d("TSManager", 1, "mCurrentNotResumeCount = " + this.jdField_a_of_type_Int + ",mCurrentCrashCount = " + this.jdField_b_of_type_Int + ",tempInitedSuccessful = " + bool1);
        if (bool1)
        {
          Process.setThreadPriority(-2);
          if (Math.random() >= 0.1000000014901161D) {
            break label555;
          }
        }
        label555:
        for (boolean bool2 = true;; bool2 = false)
        {
          this.jdField_c_of_type_Boolean = bool2;
          SuspendThreadManager.a(SuspendThreadManager.a());
          this.jdField_a_of_type_JavaLangThread = Looper.getMainLooper().getThread();
          this.jdField_b_of_type_JavaLangThread = SuspendThreadManager.a().getLooper().getThread();
          this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("suspendWatchdogThread");
          this.jdField_a_of_type_AndroidOsHandlerThread.start();
          this.jdField_a_of_type_Azuh = new azuh(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), Thread.currentThread(), this);
          SuspendThreadManager.b(SuspendThreadManager.a(this.jdField_a_of_type_AndroidOsHandlerThread));
          SuspendThreadManager.c(SuspendThreadManager.a(SuspendThreadManager.a()));
          SuspendThreadManager.d(SuspendThreadManager.a(this.jdField_a_of_type_JavaLangThread));
          this.d = SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, SuspendThreadManager.b(), SuspendThreadManager.d());
          j();
          SuspendThreadManager.b().add(this.jdField_a_of_type_JavaLangThread);
          SuspendThreadManager.b().add(this.jdField_b_of_type_JavaLangThread);
          SuspendThreadManager.b().add(this.jdField_a_of_type_AndroidOsHandlerThread);
          b();
          SuspendThreadManager.b(bool1);
          QLog.i("TSManager", 1, "init finished:mNativeApiSupportValue = " + this.d + ",sGuardThreadNativeAddr = " + SuspendThreadManager.d() + ",sMainThreadNativeAddr = " + SuspendThreadManager.e() + ",mFetchMainStackThisTime = " + this.jdField_c_of_type_Boolean + ",bDalvikVm = " + SuspendThreadManager.b() + ",sInitedSuccessful = " + SuspendThreadManager.c());
          return;
          if (Build.VERSION.SDK_INT >= 24) {
            SuspendThreadManager.jdField_a_of_type_Int |= 0x2;
          }
          bool1 = false;
          break;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TSManager", 1, "libthreadsuspend load failed !!!", localThrowable);
      SuspendThreadManager.b(false);
      SuspendThreadManager.jdField_a_of_type_Int |= 0x20;
      return;
    }
  }
  
  private void d()
  {
    synchronized ()
    {
      SuspendThreadManager.a().clear();
      SuspendThreadManager.a().clear();
      SuspendThreadManager.b().clear();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_check_flag", 1);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      QLog.d("TSManager", 1, "preSuspendThread SUSPEND_CHECK_FLAG = 1");
      this.jdField_c_of_type_Int = 0;
      g();
      this.jdField_a_of_type_Azuh.a();
      return;
    }
  }
  
  private void e()
  {
    SuspendThreadManager.a(0);
    if (SuspendThreadManager.a().size() > 0)
    {
      SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, SuspendThreadManager.d());
      a(1);
    }
  }
  
  private void f()
  {
    if (SuspendThreadManager.a().size() > 0)
    {
      SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, SuspendThreadManager.d());
      a(2);
    }
  }
  
  private void g()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    sendMessageDelayed(localMessage, SuspendThreadManager.a());
  }
  
  private void h()
  {
    SuspendThreadManager.a(0);
    if (SuspendThreadManager.a().size() > 0)
    {
      ??? = this.jdField_a_of_type_JavaLangThread.getState();
      this.jdField_c_of_type_Int += 1;
      if (??? != Thread.State.BLOCKED) {
        break label224;
      }
      if ((!this.jdField_b_of_type_Boolean) && (!SuspendThreadManager.b()) && (!SuspendThreadManager.a().isEmpty())) {
        break label134;
      }
      if (this.jdField_c_of_type_Boolean)
      {
        ??? = SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, this.jdField_a_of_type_JavaLangThread, "Blocked");
        if (this.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null)
        {
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("main_thread_stack", (String)???);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
        }
      }
      f();
    }
    label134:
    label320:
    for (;;)
    {
      if (!SuspendThreadManager.a().isEmpty()) {
        g();
      }
      return;
      int i = SuspendThreadManager.a(SuspendThreadManager.a(), SuspendThreadManager.e());
      Thread localThread1 = (Thread)SuspendThreadManager.a().get(Integer.valueOf(i));
      if ((localThread1 != null) && (SuspendThreadManager.a().contains(localThread1)))
      {
        i = SuspendThreadManager.a(SuspendThreadManager.a(), localThread1, SuspendThreadManager.d());
        if ((1 != i) && (2 != i)) {}
      }
      synchronized (SuspendThreadManager.a())
      {
        SuspendThreadManager.a().remove(localThread1);
        this.jdField_b_of_type_Boolean = true;
      }
      label224:
      if ((??? == Thread.State.WAITING) || (??? == Thread.State.TIMED_WAITING))
      {
        if (this.jdField_a_of_type_Boolean)
        {
          SuspendThreadManager localSuspendThreadManager;
          Thread localThread2;
          if (this.jdField_c_of_type_Boolean)
          {
            localSuspendThreadManager = this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager;
            localThread2 = this.jdField_a_of_type_JavaLangThread;
            if (??? != Thread.State.WAITING) {
              break label320;
            }
          }
          for (??? = "Waiting";; ??? = "TimedWaiting")
          {
            ??? = SuspendThreadManager.a(localSuspendThreadManager, localThread2, (String)???);
            if (this.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null)
            {
              this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("main_thread_stack", (String)???);
              this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
            }
            f();
            break;
          }
        }
        this.jdField_a_of_type_Boolean = true;
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_b_of_type_Boolean = false;
        if (this.jdField_c_of_type_Int * SuspendThreadManager.a() > 1000L)
        {
          f();
          this.jdField_c_of_type_Int = 0;
        }
      }
    }
  }
  
  private void i()
  {
    a(3);
  }
  
  private void j()
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap;
    Object localObject;
    if (l - this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_report_time", 0L) > 86400000L)
    {
      localHashMap = new HashMap(10);
      localHashMap.put("api_support_cond", String.valueOf(this.d));
      localHashMap.put("resume_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("normal_resume_count", 0)));
      localHashMap.put("timeout_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("timeout_resume_count", 0)));
      localHashMap.put("watchdog_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("watchdog_resume_count", 0)));
      localHashMap.put("main_thread_stack", this.jdField_a_of_type_AndroidContentSharedPreferences.getString("main_thread_stack", ""));
      localHashMap.put("not_resume_count", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("crash_count", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("report_time", String.valueOf(System.currentTimeMillis()));
      localHashMap.put("suspend_error_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("suspend_error_count", 0)));
      localHashMap.put("resume_error_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("resume_error_count", 0)));
      localObject = "";
    }
    try
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("TSManager", 1, "getAccount faild ！！！");
      }
    }
    localHashMap.put("qq_num", localObject);
    azri.a(BaseApplicationImpl.getApplication()).a((String)localObject, "suspendThreadMonitor", true, this.d, 0L, localHashMap, null);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("last_report_time", l);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("normal_resume_count", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("timeout_resume_count", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_error_count", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("resume_error_count", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  private void k()
  {
    HashMap localHashMap = new HashMap(10);
    localHashMap.put("not_resume_count", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("not_resume_time", String.valueOf(System.currentTimeMillis()));
    Object localObject = "";
    try
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("TSManager", 1, "getAccount faild ！！！");
      }
    }
    localHashMap.put("qq_num", localObject);
    azri.a(BaseApplicationImpl.getApplication()).a((String)localObject, "suspendThreadNotResume", true, 0L, 0L, localHashMap, null);
  }
  
  public void a()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 5;
    sendMessage(localMessage);
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (SuspendThreadManager.d())
      {
        paramInt = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("resume_error_count", 0);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("resume_error_count", paramInt + 1);
        SuspendThreadManager.c(false);
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return;
      paramInt = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("normal_resume_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("normal_resume_count", paramInt + 1);
      this.jdField_a_of_type_Azuh.b();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_check_flag", 0);
      QLog.d("TSManager", 1, "afterResumeThread Normal SUSPEND_CHECK_FLAG = 0");
      continue;
      paramInt = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("timeout_resume_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("timeout_resume_count", paramInt + 1);
      this.jdField_a_of_type_Azuh.b();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_check_flag", 0);
      QLog.d("TSManager", 1, "afterResumeThread Timeout SUSPEND_CHECK_FLAG = 0, mTimeOutMsgTimes = " + this.jdField_c_of_type_Int);
      continue;
      paramInt = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("watchdog_resume_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("watchdog_resume_count", paramInt + 1);
      this.jdField_a_of_type_Azuh.b();
      if (SuspendThreadManager.f() == 1)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_check_flag", 0);
        SuspendThreadManager.a(0);
      }
      QLog.d("TSManager", 1, "afterResumeThread Watchdog SUSPEND_CHECK_FLAG = 0");
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = false;
    if (paramMessage.obj != null) {
      bool = ((Boolean)paramMessage.obj).booleanValue();
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      c();
      return;
    case 2: 
      a(bool);
      return;
    case 3: 
      e();
      return;
    case 4: 
      h();
      return;
    }
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azug
 * JD-Core Version:    0.7.0.1
 */