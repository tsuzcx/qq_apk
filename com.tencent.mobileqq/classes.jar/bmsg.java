import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bmsg
  extends QQUIEventReceiver<bmsd, voc>
{
  boolean a = false;
  
  public bmsg(@NonNull bmsd parambmsd)
  {
    super(parambmsd);
  }
  
  public void a(@NonNull bmsd parambmsd, @NonNull voc paramvoc)
  {
    if (!this.a)
    {
      parambmsd.b();
      this.a = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return voc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsg
 * JD-Core Version:    0.7.0.1
 */