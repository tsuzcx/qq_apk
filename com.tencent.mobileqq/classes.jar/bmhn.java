import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class bmhn
  extends QQUIEventReceiver<bmhd, bmnq>
{
  public bmhn(@NonNull bmhd parambmhd)
  {
    super(parambmhd);
  }
  
  public void a(@NonNull bmhd parambmhd, @NonNull bmnq parambmnq) {}
  
  public Class acceptEventClass()
  {
    return bmnq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhn
 * JD-Core Version:    0.7.0.1
 */