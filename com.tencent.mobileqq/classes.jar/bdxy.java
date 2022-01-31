import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.task.AsyncTask.1;

public abstract class bdxy
  extends bdxz
{
  public bdxy(Context paramContext, bdlq parambdlq)
  {
    super(paramContext, 2, parambdlq);
  }
  
  public abstract void a();
  
  public boolean b()
  {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
  }
  
  public void d()
  {
    if (!b())
    {
      a();
      return;
    }
    bdew.a().post(new AsyncTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdxy
 * JD-Core Version:    0.7.0.1
 */