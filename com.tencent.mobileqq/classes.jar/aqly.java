import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class aqly
  implements Handler.Callback
{
  aqly(aqlx paramaqlx) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = aqlx.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((aqlz)((Iterator)localObject).next()).a(paramMessage.arg1);
      }
      localObject = aqlx.a(this.a).iterator();
      if (((Iterator)localObject).hasNext())
      {
        aqlz localaqlz = (aqlz)((Iterator)localObject).next();
        if (paramMessage.arg1 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localaqlz.a(bool, (Throwable)paramMessage.obj);
          break;
        }
      }
      localObject = new Intent(aqlr.a(aqlx.a(this.a).c));
      if (paramMessage.arg1 == 0)
      {
        if (aqlr.a(aqlx.a(this.a).c)) {}
        for (int i = 9;; i = 8)
        {
          ((Intent)localObject).putExtra("key_state", i);
          aqlx.a(this.a).sendBroadcast((Intent)localObject);
          if (aqme.a.get(aqlx.a(this.a)) == null) {
            break;
          }
          aqmd.b(String.valueOf(((aqme)aqme.a.get(aqlx.a(this.a))).f));
          return false;
        }
      }
      if (aqlr.a(aqlx.a(this.a).c)) {
        aqmd.a("2691708");
      }
      for (;;)
      {
        aqlm.a((Throwable)paramMessage.obj);
        ((Intent)localObject).putExtra("key_state", 7);
        aqlx.a(this.a).sendBroadcast((Intent)localObject);
        return false;
        if (aqlr.b(aqlx.a(this.a).c)) {
          aqmd.a("2597726");
        } else if (aqme.a.get(aqlx.a(this.a)) != null) {
          aqmd.b(String.valueOf(((aqme)aqme.a.get(aqlx.a(this.a))).e));
        }
      }
      paramMessage = new Intent(aqlr.a(aqlx.a(this.a).c));
      paramMessage.putExtra("key_state", 6);
      aqlx.a(this.a).sendBroadcast(paramMessage);
    } while (aqme.a.get(aqlx.a(this.a)) == null);
    aqmd.b(String.valueOf(((aqme)aqme.a.get(aqlx.a(this.a))).d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqly
 * JD-Core Version:    0.7.0.1
 */