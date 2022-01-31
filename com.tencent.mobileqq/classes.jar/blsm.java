import android.support.annotation.NonNull;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class blsm
  extends QQUIEventReceiver<blsj, uow>
{
  boolean a = false;
  
  public blsm(@NonNull blsj paramblsj)
  {
    super(paramblsj);
  }
  
  public void a(@NonNull blsj paramblsj, @NonNull uow paramuow)
  {
    if (!this.a)
    {
      paramblsj.b();
      this.a = true;
    }
  }
  
  public Class acceptEventClass()
  {
    return uow.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsm
 * JD-Core Version:    0.7.0.1
 */