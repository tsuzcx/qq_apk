import android.annotation.TargetApi;
import android.os.Looper;
import android.support.annotation.NonNull;

@TargetApi(18)
public class bbll
  extends bbmq
{
  @NonNull
  protected bbms a(Looper paramLooper)
  {
    return new bbms(this, paramLooper, this);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbll
 * JD-Core Version:    0.7.0.1
 */