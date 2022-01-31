import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.mobileqq.bubble.QQAnimationDrawable.SerialExecutor.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class amcw
  implements Executor
{
  final amcx<Runnable> jdField_a_of_type_Amcx = new amcx(30);
  Runnable jdField_a_of_type_JavaLangRunnable;
  
  public void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_Amcx.a();
      this.jdField_a_of_type_JavaLangRunnable = localRunnable;
      if (localRunnable != null)
      {
        QLog.d("QQAnimationDrawable", 2, "scheduleNext start");
        QQAnimationDrawable.a.execute(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Amcx.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      QLog.d("QQAnimationDrawable", 2, "SerialExecutor excute");
      this.jdField_a_of_type_Amcx.a(new QQAnimationDrawable.SerialExecutor.1(this, paramRunnable));
      if (this.jdField_a_of_type_JavaLangRunnable == null)
      {
        QLog.d("QQAnimationDrawable", 2, "SerialExecutor mActive == null scheduleNext");
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amcw
 * JD-Core Version:    0.7.0.1
 */