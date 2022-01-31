import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class bmlz
  extends QQUIEventReceiver<bmlp, bmsc>
{
  public bmlz(@NonNull bmlp parambmlp)
  {
    super(parambmlp);
  }
  
  public void a(@NonNull bmlp parambmlp, @NonNull bmsc parambmsc) {}
  
  public Class acceptEventClass()
  {
    return bmsc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlz
 * JD-Core Version:    0.7.0.1
 */