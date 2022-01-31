import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;

public class beuh
  extends Handler
{
  WeakReference<Context> a;
  
  public beuh(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beuh
 * JD-Core Version:    0.7.0.1
 */