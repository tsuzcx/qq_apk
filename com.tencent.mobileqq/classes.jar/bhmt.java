import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;

public class bhmt
  extends Handler
{
  WeakReference<Context> a;
  
  public bhmt(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmt
 * JD-Core Version:    0.7.0.1
 */