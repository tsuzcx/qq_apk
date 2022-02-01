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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class bcvg
  extends Handler
{
  private final float jdField_a_of_type_Float = 0.1F;
  private int jdField_a_of_type_Int;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private bcvh jdField_a_of_type_Bcvh;
  private File jdField_a_of_type_JavaIoFile;
  private Thread jdField_a_of_type_JavaLangThread;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Thread jdField_b_of_type_JavaLangThread;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = true;
  
  public bcvg(SuspendThreadManager paramSuspendThreadManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.d("TSManager", 1, paramString + ",createCheckFile");
      if (!paramBoolean) {
        break label80;
      }
    }
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_JavaIoFile.exists()) {
          this.jdField_a_of_type_JavaIoFile.createNewFile();
        }
        return;
      }
      catch (IOException paramString)
      {
        label80:
        QLog.e("TSManager", 1, "createOrDelSuspendCheckFile failed", paramString);
      }
      QLog.d("TSManager", 1, paramString + ",deleteCheckFile");
      break;
      if (this.jdField_a_of_type_JavaIoFile.exists())
      {
        this.jdField_a_of_type_JavaIoFile.delete();
        return;
      }
    }
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
        e();
        SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_JavaIoFile.exists();
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      this.jdField_a_of_type_JavaIoFile.delete();
    }
  }
  
  private void c()
  {
    SuspendThreadManager.a().a(ThreadManager.getSubThread());
    SuspendThreadManager.a().a(ThreadManager.getRecentThread());
    Thread[] arrayOfThread = SuspendThreadManager.a();
    int j = arrayOfThread.length;
    int i = 0;
    while (i < j)
    {
      Thread localThread = arrayOfThread[i];
      String str = localThread.getName();
      if (("MSF-Receiver".equals(str)) || ("QQ_DB".equals(str)) || ("QQ_FILE_RW".equals(str))) {
        SuspendThreadManager.a().a(localThread);
      }
      i += 1;
    }
  }
  
  private void d()
  {
    try
    {
      System.loadLibrary("threadsuspend");
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("suspend_thread_pref_file", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      this.jdField_a_of_type_JavaIoFile = new File(BaseApplicationImpl.getApplication().getFilesDir().getPath() + File.separator + "suspend_check_file");
      this.jdField_d_of_type_Boolean = bcow.i;
      this.e = bcow.j;
      boolean bool1;
      if ((Build.VERSION.SDK_INT <= 23) && (bcow.h))
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
        if (a())
        {
          this.jdField_a_of_type_Int += 1;
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("notResumeCountNew", this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
          l();
        }
        b();
        if (this.jdField_a_of_type_Int <= SuspendThreadManager.c()) {
          break label690;
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
            break label659;
          }
        }
        label659:
        for (boolean bool2 = true;; bool2 = false)
        {
          this.jdField_c_of_type_Boolean = bool2;
          SuspendThreadManager.a(SuspendThreadManager.a());
          this.jdField_a_of_type_JavaLangThread = Looper.getMainLooper().getThread();
          this.jdField_b_of_type_JavaLangThread = SuspendThreadManager.a().getLooper().getThread();
          this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("suspendWatchdogThread");
          this.jdField_a_of_type_AndroidOsHandlerThread.start();
          this.jdField_a_of_type_Bcvh = new bcvh(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), Thread.currentThread(), this);
          SuspendThreadManager.b(SuspendThreadManager.a(this.jdField_a_of_type_AndroidOsHandlerThread));
          SuspendThreadManager.c(SuspendThreadManager.a(SuspendThreadManager.a()));
          SuspendThreadManager.d(SuspendThreadManager.a(this.jdField_a_of_type_JavaLangThread));
          this.jdField_d_of_type_Int = SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, SuspendThreadManager.b(), SuspendThreadManager.d());
          k();
          SuspendThreadManager.b().add(this.jdField_a_of_type_JavaLangThread);
          SuspendThreadManager.b().add(this.jdField_b_of_type_JavaLangThread);
          SuspendThreadManager.b().add(this.jdField_a_of_type_AndroidOsHandlerThread);
          c();
          SuspendThreadManager.b(bool1);
          QLog.d("TSManager", 1, new Object[] { "init finished:", "mNativeApiSupportValue = ", Integer.valueOf(this.jdField_d_of_type_Int), ",sGuardThreadNativeAddr = ", Integer.valueOf(SuspendThreadManager.d()), ",sMainThreadNativeAddr = ", Integer.valueOf(SuspendThreadManager.e()), ",mFetchMainStackThisTime = ", Boolean.valueOf(this.jdField_c_of_type_Boolean), ",bDalvikVm = ", Boolean.valueOf(SuspendThreadManager.b()), ",sInitedSuccessful = ", Boolean.valueOf(SuspendThreadManager.c()), ",bIsFakeSuspendUser = ", Boolean.valueOf(this.jdField_d_of_type_Boolean), ",bSuspendWhiteListThreadOnly = ", Boolean.valueOf(this.e) });
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
  
  private void e()
  {
    synchronized ()
    {
      SuspendThreadManager.a().clear();
      SuspendThreadManager.a().clear();
      SuspendThreadManager.b().clear();
      a("preSuspendThread", true);
      this.jdField_c_of_type_Int = 0;
      h();
      this.jdField_a_of_type_Bcvh.a();
      return;
    }
  }
  
  private void f()
  {
    SuspendThreadManager.a(0);
    if (SuspendThreadManager.a().size() > 0)
    {
      SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, SuspendThreadManager.d());
      a(1);
    }
  }
  
  private void g()
  {
    if (SuspendThreadManager.a().size() > 0)
    {
      SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, SuspendThreadManager.d());
      a(2);
    }
  }
  
  private void h()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    sendMessageDelayed(localMessage, SuspendThreadManager.a());
  }
  
  private void i()
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
      g();
    }
    label134:
    label320:
    for (;;)
    {
      if (!SuspendThreadManager.a().isEmpty()) {
        h();
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
            g();
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
          g();
          this.jdField_c_of_type_Int = 0;
        }
      }
    }
  }
  
  private void j()
  {
    a(3);
  }
  
  private void k()
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap;
    if (l - this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_report_time", 0L) > 86400000L)
    {
      localHashMap = new HashMap(10);
      localHashMap.put("api_support_cond", String.valueOf(this.jdField_d_of_type_Int));
      localHashMap.put("resume_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("normal_resume_count", 0)));
      localHashMap.put("timeout_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("timeout_resume_count", 0)));
      localHashMap.put("watchdog_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("watchdog_resume_count", 0)));
      localHashMap.put("main_thread_stack", this.jdField_a_of_type_AndroidContentSharedPreferences.getString("main_thread_stack", ""));
      localHashMap.put("not_resume_count", String.valueOf(this.jdField_a_of_type_Int));
      localHashMap.put("crash_count", String.valueOf(this.jdField_b_of_type_Int));
      localHashMap.put("report_time", String.valueOf(System.currentTimeMillis()));
      localHashMap.put("suspend_error_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("suspend_error_count", 0)));
      localHashMap.put("resume_error_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("resume_error_count", 0)));
      if (!this.jdField_d_of_type_Boolean) {
        break label420;
      }
      localObject = "1";
      localHashMap.put("fake_suspend", localObject);
      if (!this.e) {
        break label427;
      }
    }
    label420:
    label427:
    for (Object localObject = "1";; localObject = "-1")
    {
      localHashMap.put("white_list_only", localObject);
      localObject = "";
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
      bctj.a(BaseApplicationImpl.getApplication()).a((String)localObject, "suspendThreadMonitor", true, this.jdField_d_of_type_Int, 0L, localHashMap, null);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("last_report_time", l);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("normal_resume_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("timeout_resume_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_error_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("resume_error_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return;
      localObject = "-1";
      break;
    }
  }
  
  private void l()
  {
    HashMap localHashMap = new HashMap(10);
    localHashMap.put("not_resume_count", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("not_resume_time", String.valueOf(System.currentTimeMillis()));
    if (this.jdField_d_of_type_Boolean)
    {
      localObject = "1";
      localHashMap.put("fake_suspend", localObject);
      if (!this.e) {
        break label130;
      }
    }
    label130:
    for (Object localObject = "1";; localObject = "-1")
    {
      localHashMap.put("white_list_only", localObject);
      localObject = "";
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
      bctj.a(BaseApplicationImpl.getApplication()).a((String)localObject, "suspendThreadNotResume", true, 0L, 0L, localHashMap, null);
      return;
      localObject = "-1";
      break;
    }
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
      this.jdField_a_of_type_Bcvh.b();
      a("afterResumeThread Normal", false);
      continue;
      paramInt = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("timeout_resume_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("timeout_resume_count", paramInt + 1);
      this.jdField_a_of_type_Bcvh.b();
      a("afterResumeThread Timeout", false);
      continue;
      paramInt = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("watchdog_resume_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("watchdog_resume_count", paramInt + 1);
      this.jdField_a_of_type_Bcvh.b();
      if (SuspendThreadManager.f() == 1)
      {
        a("afterResumeThread Watchdog", false);
        SuspendThreadManager.a(0);
      }
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      d();
      return;
    case 2: 
      if (!this.jdField_d_of_type_Boolean)
      {
        a(this.e);
        return;
      }
      a("fake preSuspendThread", true);
      return;
    case 3: 
      if (!this.jdField_d_of_type_Boolean)
      {
        f();
        return;
      }
      a("fake afterResumeThread Normal", false);
      return;
    case 4: 
      if (!this.jdField_d_of_type_Boolean)
      {
        i();
        return;
      }
      a("fake afterResumeThread Timeout", false);
      return;
    }
    if (!this.jdField_d_of_type_Boolean)
    {
      j();
      return;
    }
    a("fake afterResumeThread Watchdog", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvg
 * JD-Core Version:    0.7.0.1
 */