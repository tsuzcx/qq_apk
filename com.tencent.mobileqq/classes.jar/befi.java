import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;

class befi
  implements MessageQueue.IdleHandler
{
  befi(befh parambefh) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!befh.a().isEmpty())
    {
      localObject = (befk)befh.a().remove(0);
      i = ((befk)localObject).a();
      if (2 == i) {
        befh.a().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.a;
      if (befh.a().isEmpty()) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((befh)localObject).a = bool;
      return this.a.a;
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befi
 * JD-Core Version:    0.7.0.1
 */