import android.annotation.TargetApi;
import android.os.Looper;
import android.support.annotation.NonNull;

@TargetApi(18)
public class axur
  extends axvw
{
  @NonNull
  protected axvy a(Looper paramLooper)
  {
    return new axvy(this, paramLooper, this);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axur
 * JD-Core Version:    0.7.0.1
 */