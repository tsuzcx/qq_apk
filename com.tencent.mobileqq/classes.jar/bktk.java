import android.view.View;
import android.view.ViewStub;
import java.util.LinkedList;
import java.util.Queue;

public abstract class bktk
{
  private final ViewStub jdField_a_of_type_AndroidViewViewStub;
  private Queue<Runnable> jdField_a_of_type_JavaUtilQueue;
  private boolean jdField_a_of_type_Boolean;
  
  public bktk(ViewStub paramViewStub)
  {
    this.jdField_a_of_type_AndroidViewViewStub = paramViewStub;
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
  }
  
  private void b()
  {
    for (;;)
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_JavaUtilQueue.poll();
      if (localRunnable != null) {
        try
        {
          localRunnable.run();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          throw new RuntimeException("doPendingActions encounter an error", localException);
        }
      }
    }
  }
  
  protected final void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    View localView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
    this.jdField_a_of_type_Boolean = true;
    a(localView);
    b();
  }
  
  protected abstract void a(View paramView);
  
  protected void a(Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Boolean) {
      paramRunnable.run();
    }
    while (paramRunnable == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilQueue.add(paramRunnable);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktk
 * JD-Core Version:    0.7.0.1
 */