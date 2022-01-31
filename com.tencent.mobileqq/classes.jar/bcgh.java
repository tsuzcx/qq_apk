import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;

class bcgh
  implements MessageQueue.IdleHandler
{
  bcgh(bcgg parambcgg) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!bcgg.a().isEmpty())
    {
      localObject = (bcgj)bcgg.a().remove(0);
      i = ((bcgj)localObject).a();
      if (2 == i) {
        bcgg.a().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.a;
      if (bcgg.a().isEmpty()) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((bcgg)localObject).a = bool;
      return this.a.a;
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcgh
 * JD-Core Version:    0.7.0.1
 */