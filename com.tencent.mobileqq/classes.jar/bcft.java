import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;

class bcft
  implements MessageQueue.IdleHandler
{
  bcft(bcfs parambcfs) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!bcfs.a().isEmpty())
    {
      localObject = (bcfv)bcfs.a().remove(0);
      i = ((bcfv)localObject).a();
      if (2 == i) {
        bcfs.a().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.a;
      if (bcfs.a().isEmpty()) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((bcfs)localObject).a = bool;
      return this.a.a;
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcft
 * JD-Core Version:    0.7.0.1
 */