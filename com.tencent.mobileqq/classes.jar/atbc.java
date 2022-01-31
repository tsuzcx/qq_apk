import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class atbc
  implements Handler.Callback
{
  atbc(atbb paramatbb) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = atbb.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((atbd)((Iterator)localObject).next()).a(paramMessage.arg1);
      }
      localObject = atbb.a(this.a).iterator();
      if (((Iterator)localObject).hasNext())
      {
        atbd localatbd = (atbd)((Iterator)localObject).next();
        if (paramMessage.arg1 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localatbd.a(bool, (Throwable)paramMessage.obj);
          break;
        }
      }
      localObject = new Intent(atav.a(atbb.a(this.a).c));
      if (paramMessage.arg1 == 0)
      {
        if (atav.a(atbb.a(this.a).c)) {}
        for (int i = 9;; i = 8)
        {
          ((Intent)localObject).putExtra("key_state", i);
          atbb.a(this.a).sendBroadcast((Intent)localObject);
          if (atbi.a.get(atbb.a(this.a)) == null) {
            break;
          }
          atbh.b(String.valueOf(((atbi)atbi.a.get(atbb.a(this.a))).f));
          return false;
        }
      }
      if (atav.a(atbb.a(this.a).c)) {
        atbh.a("2691708");
      }
      for (;;)
      {
        ataq.a((Throwable)paramMessage.obj);
        ((Intent)localObject).putExtra("key_state", 7);
        atbb.a(this.a).sendBroadcast((Intent)localObject);
        return false;
        if (atav.b(atbb.a(this.a).c)) {
          atbh.a("2597726");
        } else if (atbi.a.get(atbb.a(this.a)) != null) {
          atbh.b(String.valueOf(((atbi)atbi.a.get(atbb.a(this.a))).e));
        }
      }
      paramMessage = new Intent(atav.a(atbb.a(this.a).c));
      paramMessage.putExtra("key_state", 6);
      atbb.a(this.a).sendBroadcast(paramMessage);
    } while (atbi.a.get(atbb.a(this.a)) == null);
    atbh.b(String.valueOf(((atbi)atbi.a.get(atbb.a(this.a))).d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbc
 * JD-Core Version:    0.7.0.1
 */