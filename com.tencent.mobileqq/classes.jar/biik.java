import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;

class biik
  implements MessageQueue.IdleHandler
{
  biik(biij parambiij) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!biij.a().isEmpty())
    {
      localObject = (biim)biij.a().remove(0);
      i = ((biim)localObject).a();
      if (2 == i) {
        biij.a().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.a;
      if (biij.a().isEmpty()) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((biij)localObject).a = bool;
      return this.a.a;
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biik
 * JD-Core Version:    0.7.0.1
 */