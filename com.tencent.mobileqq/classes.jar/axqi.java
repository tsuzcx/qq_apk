import android.annotation.TargetApi;
import android.os.Looper;
import android.support.annotation.NonNull;

@TargetApi(18)
public class axqi
  extends axrn
{
  @NonNull
  protected axrp a(Looper paramLooper)
  {
    return new axrp(this, paramLooper, this);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axqi
 * JD-Core Version:    0.7.0.1
 */