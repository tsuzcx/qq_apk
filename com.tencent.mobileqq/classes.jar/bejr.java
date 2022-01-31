import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;

class bejr
  implements MessageQueue.IdleHandler
{
  bejr(bejq parambejq) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!bejq.a().isEmpty())
    {
      localObject = (bejt)bejq.a().remove(0);
      i = ((bejt)localObject).a();
      if (2 == i) {
        bejq.a().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.a;
      if (bejq.a().isEmpty()) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((bejq)localObject).a = bool;
      return this.a.a;
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejr
 * JD-Core Version:    0.7.0.1
 */