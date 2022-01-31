import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class bmho
  extends QQUIEventReceiver<bmhd, bmnr>
{
  public bmho(@NonNull bmhd parambmhd)
  {
    super(parambmhd);
  }
  
  public void a(@NonNull bmhd parambmhd, @NonNull bmnr parambmnr) {}
  
  public Class acceptEventClass()
  {
    return bmnr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmho
 * JD-Core Version:    0.7.0.1
 */