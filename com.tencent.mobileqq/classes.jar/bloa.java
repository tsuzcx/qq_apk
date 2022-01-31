import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bloa
  extends QQUIEventReceiver<blnx, ukn>
{
  boolean a = false;
  
  public bloa(@NonNull blnx paramblnx)
  {
    super(paramblnx);
  }
  
  public void a(@NonNull blnx paramblnx, @NonNull ukn paramukn)
  {
    if (!this.a)
    {
      paramblnx.b();
      this.a = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return ukn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bloa
 * JD-Core Version:    0.7.0.1
 */