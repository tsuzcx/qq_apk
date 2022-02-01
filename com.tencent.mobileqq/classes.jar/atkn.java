import android.os.Handler.Callback;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class atkn
  implements Handler.Callback
{
  atkn(atkl paramatkl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (List)paramMessage.obj;
      atkl.a(this.a, paramMessage);
      continue;
      paramMessage = atkl.a(this.a).keySet().iterator();
      while (paramMessage.hasNext())
      {
        Integer localInteger = (Integer)paramMessage.next();
        ArrayList localArrayList = (ArrayList)atkl.a(this.a).get(localInteger);
        atkl.a(this.a, new ArrayList(localArrayList), localInteger.intValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atkn
 * JD-Core Version:    0.7.0.1
 */