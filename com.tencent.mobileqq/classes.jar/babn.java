import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.ConcurrentLinkedQueue;

public class babn
  implements ThreadExcutor.IThreadListener
{
  private int jdField_a_of_type_Int;
  ConcurrentLinkedQueue<Runnable> jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
  private int b;
  private int c;
  
  public babn(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.b = 0;
  }
  
  public void a()
  {
    if (this.b < this.jdField_a_of_type_Int)
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.poll();
      if (localRunnable != null)
      {
        this.b += 1;
        ThreadManager.excute(localRunnable, this.c, this, false);
      }
    }
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.offer(paramRunnable);
    a();
  }
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    this.b -= 1;
    a();
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babn
 * JD-Core Version:    0.7.0.1
 */