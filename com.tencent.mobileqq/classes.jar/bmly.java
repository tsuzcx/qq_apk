import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

class bmly
  extends QQUIEventReceiver<bmlp, bmsb>
{
  public bmly(@NonNull bmlp parambmlp)
  {
    super(parambmlp);
  }
  
  public void a(@NonNull bmlp parambmlp, @NonNull bmsb parambmsb) {}
  
  public Class acceptEventClass()
  {
    return bmsb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmly
 * JD-Core Version:    0.7.0.1
 */