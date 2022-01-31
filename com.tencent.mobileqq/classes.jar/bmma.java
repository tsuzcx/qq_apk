import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class bmma
  extends QQUIEventReceiver<bmlp, bmsd>
{
  public bmma(@NonNull bmlp parambmlp)
  {
    super(parambmlp);
  }
  
  public void a(@NonNull bmlp parambmlp, @NonNull bmsd parambmsd) {}
  
  public Class acceptEventClass()
  {
    return bmsd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmma
 * JD-Core Version:    0.7.0.1
 */