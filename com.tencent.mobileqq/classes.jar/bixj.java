import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;

public class bixj
  extends Handler
{
  WeakReference<Context> a;
  
  public bixj(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixj
 * JD-Core Version:    0.7.0.1
 */