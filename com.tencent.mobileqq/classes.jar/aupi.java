import android.os.Handler.Callback;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class aupi
  implements Handler.Callback
{
  aupi(aupf paramaupf) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (List)paramMessage.obj;
      aupf.a(this.a, paramMessage);
      continue;
      paramMessage = aupf.a(this.a).keySet().iterator();
      while (paramMessage.hasNext())
      {
        Integer localInteger = (Integer)paramMessage.next();
        ArrayList localArrayList = (ArrayList)aupf.a(this.a).get(localInteger);
        aupf.a(this.a, new ArrayList(localArrayList), localInteger.intValue());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aupi
 * JD-Core Version:    0.7.0.1
 */