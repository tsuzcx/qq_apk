import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;

class birq
  implements MessageQueue.IdleHandler
{
  birq(birp parambirp) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!birp.a().isEmpty())
    {
      localObject = (birs)birp.a().remove(0);
      i = ((birs)localObject).a();
      if (2 == i) {
        birp.a().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.a;
      if (birp.a().isEmpty()) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((birp)localObject).a = bool;
      return this.a.a;
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birq
 * JD-Core Version:    0.7.0.1
 */