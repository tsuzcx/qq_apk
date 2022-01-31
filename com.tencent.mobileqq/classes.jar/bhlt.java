import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.task.AsyncTask.1;

public abstract class bhlt
  extends bhlu
{
  public bhlt(Context paramContext, bgun parambgun)
  {
    super(paramContext, 2, parambgun);
  }
  
  public abstract void a();
  
  public boolean b()
  {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
  }
  
  public void f()
  {
    if (!b())
    {
      a();
      return;
    }
    ThreadManager.a().post(new AsyncTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhlt
 * JD-Core Version:    0.7.0.1
 */