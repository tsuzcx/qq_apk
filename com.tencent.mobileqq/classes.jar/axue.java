import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class axue
  extends Handler
{
  private final float jdField_a_of_type_Float = 0.1F;
  private int jdField_a_of_type_Int;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = axnx.a();
  private Thread jdField_a_of_type_JavaLangThread;
  private boolean jdField_a_of_type_Boolean;
  private Thread jdField_b_of_type_JavaLangThread;
  private boolean jdField_b_of_type_Boolean;
  
  public axue(SuspendThreadManager paramSuspendThreadManager, Looper paramLooper)
  {
    super(paramLooper);
    if (Math.random() < 0.1000000014901161D) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a()
  {
    try
    {
      System.loadLibrary("threadsuspend");
      if (Build.VERSION.SDK_INT >= 24) {
        SuspendThreadManager.a(false);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("force_disable_thread_suspend", false)) {
          SuspendThreadManager.a(false);
        }
        this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("notResumeCount", 0);
        if (this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("suspend_check_flag", 0) != 0)
        {
          this.jdField_a_of_type_Int += 1;
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("notResumeCount", this.jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_check_flag", 0);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
        }
        QLog.d("TSManager", 1, "mCurrentNotResumeCount = " + this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Int > SuspendThreadManager.a()) {
          SuspendThreadManager.a(false);
        }
        if (SuspendThreadManager.a()) {
          break;
        }
        return;
        if ((Build.VERSION.SDK_INT <= 23) && (axnx.h)) {
          SuspendThreadManager.a(true);
        }
      }
      SuspendThreadManager.b(SuspendThreadManager.b());
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TSManager", 1, "libthreadsuspend load failed !!!", localThrowable);
      SuspendThreadManager.a(false);
      return;
    }
    SuspendThreadManager.a(SuspendThreadManager.a(SuspendThreadManager.a()));
    this.jdField_a_of_type_JavaLangThread = Looper.getMainLooper().getThread();
    this.jdField_b_of_type_JavaLangThread = SuspendThreadManager.a().getLooper().getThread();
    SuspendThreadManager.a().add(this.jdField_a_of_type_JavaLangThread);
    SuspendThreadManager.a().add(this.jdField_b_of_type_JavaLangThread);
    Process.setThreadPriority(-2);
    int i = SuspendThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager, SuspendThreadManager.c());
    QLog.i("TSManager", 1, "nativeInit return " + i);
    a(i);
  }
  
  private void a(int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("last_report_time", 0L) > 86400000L)
    {
      HashMap localHashMap = new HashMap(10);
      localHashMap.put("api_support_cond", String.valueOf(paramInt));
      localHashMap.put("resume_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("resume_count", 0)));
      localHashMap.put("timeout_count", String.valueOf(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("timeout_count", 0)));
      localHashMap.put("main_thread_stack", this.jdField_a_of_type_AndroidContentSharedPreferences.getString("main_thread_stack", ""));
      localHashMap.put("not_resume_count", String.valueOf(this.jdField_a_of_type_Int));
      axrn.a(BaseApplicationImpl.getApplication()).a(null, "suspendThreadMonitor", true, paramInt, 0L, localHashMap, null);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putLong("last_report_time", l);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("resume_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("timeout_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
  }
  
  private void a(Thread paramThread, String paramString)
  {
    if (paramThread != null)
    {
      paramThread = paramThread.getStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reason:" + paramString + "\n");
      int i = 0;
      while (i < paramThread.length)
      {
        localStringBuilder.append(paramThread[i].toString());
        localStringBuilder.append("\n");
        i += 1;
      }
      if (this.jdField_a_of_type_AndroidContentSharedPreferences$Editor != null)
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("main_thread_stack", localStringBuilder.toString());
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      }
      QLog.i("TSManager", 1, "suspend thread timeout for reason " + paramString + "stack:\n" + localStringBuilder.toString());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int j;
    int i;
    Object localObject;
    try
    {
      Thread[] arrayOfThread = SuspendThreadManager.a();
      SuspendThreadManager.b().clear();
      j = arrayOfThread.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TSManager", 1, "suspendThread error", localThrowable);
      return;
    }
    if ((!SuspendThreadManager.c().contains(localObject)) && (!SuspendThreadManager.a().contains(localObject)) && (!localObject.getName().contains("Binder")) && (!localObject.getName().contains("RenderThread")) && (!localObject.getName().contains("Automator")) && (!localObject.getName().contains("thread_sp"))) {
      if ((localObject.isAlive()) && (paramBoolean) && (SuspendThreadManager.d().contains(localObject)))
      {
        QLog.i("TSManager", 1, "suspendThread  = " + localObject);
        SuspendThreadManager.b().add(localObject);
        SuspendThreadManager.a(SuspendThreadManager.a(), localObject);
      }
      else if ((!paramBoolean) && (localObject.isAlive()))
      {
        QLog.i("TSManager", 1, "suspendThread  = " + localObject);
        SuspendThreadManager.b().add(localObject);
        SuspendThreadManager.a(SuspendThreadManager.a(), localObject);
      }
    }
    label286:
    for (;;)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_check_flag", 1);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return;
      for (;;)
      {
        if (i >= j) {
          break label286;
        }
        localObject = localThrowable[i];
        if (localObject != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  private void b()
  {
    if (SuspendThreadManager.b().size() > 0)
    {
      Iterator localIterator = SuspendThreadManager.b().iterator();
      while (localIterator.hasNext())
      {
        Thread localThread = (Thread)localIterator.next();
        QLog.i("TSManager", 1, "resumeThread  = " + localThread);
        SuspendThreadManager.b(SuspendThreadManager.a(), localThread);
      }
      SuspendThreadManager.b().clear();
      int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("resume_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_check_flag", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("resume_count", i + 1);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    }
  }
  
  private void c()
  {
    if (SuspendThreadManager.b().size() > 0)
    {
      Iterator localIterator = SuspendThreadManager.b().iterator();
      while (localIterator.hasNext())
      {
        Thread localThread = (Thread)localIterator.next();
        QLog.i("TSManager", 1, "suspendTimeout  = " + localThread);
        SuspendThreadManager.b(SuspendThreadManager.a(), localThread);
      }
      int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("timeout_count", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("timeout_count", i + 1);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("suspend_check_flag", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      SuspendThreadManager.b().clear();
    }
  }
  
  private void d()
  {
    QLog.d("TSManager", 1, "sendTimeoutMsg");
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    SuspendThreadManager.a().sendMessageDelayed(localMessage, SuspendThreadManager.a());
  }
  
  private void e()
  {
    Object localObject;
    if (SuspendThreadManager.b().size() > 0)
    {
      localObject = this.jdField_a_of_type_JavaLangThread.getState();
      if (localObject == Thread.State.BLOCKED)
      {
        if (this.jdField_b_of_type_Boolean) {
          a(this.jdField_a_of_type_JavaLangThread, "Blocked");
        }
        c();
      }
    }
    else
    {
      return;
    }
    if ((localObject == Thread.State.WAITING) || (localObject == Thread.State.TIMED_WAITING))
    {
      Thread localThread;
      if (this.jdField_a_of_type_Boolean) {
        if (this.jdField_b_of_type_Boolean)
        {
          localThread = this.jdField_a_of_type_JavaLangThread;
          if (localObject != Thread.State.WAITING) {
            break label107;
          }
        }
      }
      label107:
      for (localObject = "Waiting";; localObject = "TimedWaiting")
      {
        a(localThread, (String)localObject);
        c();
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    }
    this.jdField_a_of_type_Boolean = false;
    d();
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
      a();
      return;
    case 2: 
      a(bool);
      return;
    case 3: 
      b();
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axue
 * JD-Core Version:    0.7.0.1
 */