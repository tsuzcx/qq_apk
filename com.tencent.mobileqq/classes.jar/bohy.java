import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class bohy
  extends QQUIEventReceiver<bohv, wcx>
{
  boolean a = false;
  
  public bohy(@NonNull bohv parambohv)
  {
    super(parambohv);
  }
  
  public void a(@NonNull bohv parambohv, @NonNull wcx paramwcx)
  {
    if (!this.a)
    {
      parambohv.b();
      this.a = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return wcx.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohy
 * JD-Core Version:    0.7.0.1
 */