import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qqmini.sdk.task.AsyncTask.1;

public abstract class bfeq
  extends bfer
{
  public bfeq(Context paramContext, bepv parambepv)
  {
    super(paramContext, 2, parambepv);
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
    beiw.a().post(new AsyncTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfeq
 * JD-Core Version:    0.7.0.1
 */