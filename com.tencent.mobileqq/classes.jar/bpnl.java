import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bpnl
  extends QQUIEventReceiver<bpni, wmd>
{
  boolean a = false;
  
  public bpnl(@NonNull bpni parambpni)
  {
    super(parambpni);
  }
  
  public void a(@NonNull bpni parambpni, @NonNull wmd paramwmd)
  {
    if (!this.a)
    {
      parambpni.b();
      this.a = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return wmd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpnl
 * JD-Core Version:    0.7.0.1
 */