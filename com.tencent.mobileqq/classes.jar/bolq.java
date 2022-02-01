import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bolq
  extends QQUIEventReceiver<boln, wii>
{
  boolean a = false;
  
  public bolq(@NonNull boln paramboln)
  {
    super(paramboln);
  }
  
  public void a(@NonNull boln paramboln, @NonNull wii paramwii)
  {
    if (!this.a)
    {
      paramboln.b();
      this.a = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return wii.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bolq
 * JD-Core Version:    0.7.0.1
 */