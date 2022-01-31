import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;

public class bcuy
  extends Handler
{
  WeakReference<Context> a;
  
  public bcuy(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcuy
 * JD-Core Version:    0.7.0.1
 */