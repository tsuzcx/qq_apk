import android.os.MessageQueue.IdleHandler;
import java.util.ArrayList;

class bgxs
  implements MessageQueue.IdleHandler
{
  bgxs(bgxr parambgxr) {}
  
  public boolean queueIdle()
  {
    Object localObject;
    int i;
    if (!bgxr.a().isEmpty())
    {
      localObject = (bgxu)bgxr.a().remove(0);
      i = ((bgxu)localObject).a();
      if (2 == i) {
        bgxr.a().add(localObject);
      }
    }
    else
    {
      label38:
      localObject = this.a;
      if (bgxr.a().isEmpty()) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      ((bgxr)localObject).a = bool;
      return this.a.a;
      if (1 != i) {
        break;
      }
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgxs
 * JD-Core Version:    0.7.0.1
 */