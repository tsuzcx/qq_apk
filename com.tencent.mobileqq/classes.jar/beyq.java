import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;

public class beyq
  extends Handler
{
  WeakReference<Context> a;
  
  public beyq(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyq
 * JD-Core Version:    0.7.0.1
 */