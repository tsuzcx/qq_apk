import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;

class bhqv
  implements MessageQueue.IdleHandler
{
  bhqv(bhqu parambhqu) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!bhqu.a().isEmpty())
    {
      localObject = (bhqx)bhqu.a().remove(0);
      i = ((bhqx)localObject).a();
      if (2 == i) {
        bhqu.a().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.a;
      if (bhqu.a().isEmpty()) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((bhqu)localObject).a = bool;
      return this.a.a;
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhqv
 * JD-Core Version:    0.7.0.1
 */