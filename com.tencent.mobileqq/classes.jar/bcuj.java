import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;

public class bcuj
  extends Handler
{
  WeakReference<Context> a;
  
  public bcuj(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcuj
 * JD-Core Version:    0.7.0.1
 */