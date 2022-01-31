import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;

class bbct
  implements MessageQueue.IdleHandler
{
  bbct(bbcs parambbcs) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!bbcs.a().isEmpty())
    {
      localObject = (bbcv)bbcs.a().remove(0);
      i = ((bbcv)localObject).a();
      if (2 == i) {
        bbcs.a().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.a;
      if (bbcs.a().isEmpty()) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((bbcs)localObject).a = bool;
      return this.a.a;
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbct
 * JD-Core Version:    0.7.0.1
 */