import android.annotation.TargetApi;
import android.os.Looper;
import android.support.annotation.NonNull;

@TargetApi(18)
public class avyj
  extends avzo
{
  @NonNull
  protected avzq a(Looper paramLooper)
  {
    return new avzq(this, paramLooper, this);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avyj
 * JD-Core Version:    0.7.0.1
 */