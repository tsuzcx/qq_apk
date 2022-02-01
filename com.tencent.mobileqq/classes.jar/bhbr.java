import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

public class bhbr
{
  private static int jdField_a_of_type_Int = 1;
  private static Handler jdField_a_of_type_AndroidOsHandler = new bhbs(ThreadManager.getSubThreadLooper());
  private static bkyb<Integer> jdField_a_of_type_Bkyb = new bkyb(40);
  
  public static void a(boolean paramBoolean)
  {
    Handler localHandler = jdField_a_of_type_AndroidOsHandler;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localHandler.sendEmptyMessage(i);
      return;
    }
  }
  
  private static Thread[] a()
  {
    try
    {
      ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup();
      Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
      localThreadGroup.enumerate(arrayOfThread);
      return arrayOfThread;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadPriorityManager", 2, "", localException);
      }
    }
    return new Thread[0];
  }
  
  private static void c()
  {
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 30000L);
    if (jdField_a_of_type_Bkyb.a() > 0) {}
    Thread[] arrayOfThread;
    Thread localThread1;
    Thread localThread2;
    int j;
    int i;
    do
    {
      return;
      arrayOfThread = a();
      if (arrayOfThread.length < 2)
      {
        jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        return;
      }
      localThread1 = Looper.getMainLooper().getThread();
      localThread2 = ThreadManager.getSubThread();
      j = arrayOfThread.length;
      i = 0;
    } while (i >= j);
    Thread localThread3 = arrayOfThread[i];
    if ((localThread3 != null) && (localThread1 != null) && (localThread2 != null) && (localThread3.getId() != localThread2.getId()) && (localThread3.getId() != localThread1.getId()) && (localThread3.isAlive())) {}
    for (;;)
    {
      try
      {
        l = localThread3.getId();
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        try
        {
          jdField_a_of_type_Bkyb.a(l, Integer.valueOf(localThread3.getPriority()));
          localThread3.setPriority(jdField_a_of_type_Int);
          i += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          long l;
          break label171;
        }
        localIllegalArgumentException1 = localIllegalArgumentException1;
        l = -1L;
      }
      label171:
      if (l != -1L) {
        jdField_a_of_type_Bkyb.a(l);
      }
    }
  }
  
  private static void d()
  {
    if (jdField_a_of_type_Bkyb.a() <= 0) {
      return;
    }
    Thread[] arrayOfThread = a();
    int j = arrayOfThread.length;
    int i = 0;
    while (i < j)
    {
      Thread localThread = arrayOfThread[i];
      if ((localThread != null) && (localThread.isAlive()))
      {
        int k = ((Integer)jdField_a_of_type_Bkyb.a(localThread.getId(), Integer.valueOf(0))).intValue();
        if (k != 0) {
          localThread.setPriority(k);
        }
      }
      i += 1;
    }
    jdField_a_of_type_Bkyb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbr
 * JD-Core Version:    0.7.0.1
 */