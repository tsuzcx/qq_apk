import android.content.Context;
import com.tencent.mobileqq.apollo.utils.task.AsyncTask.1;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import java.util.concurrent.ExecutorService;

public abstract class anmo
  extends anmp
{
  public anmo(Context paramContext)
  {
    super(paramContext, 2);
  }
  
  public abstract void a();
  
  public final void b()
  {
    ThreadPools.getComputationThreadPool().execute(new AsyncTask.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmo
 * JD-Core Version:    0.7.0.1
 */