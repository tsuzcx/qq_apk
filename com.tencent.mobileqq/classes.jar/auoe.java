import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class auoe
  implements Handler.Callback
{
  auoe(auod paramauod) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = auod.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((auof)((Iterator)localObject).next()).a(paramMessage.arg1);
      }
      localObject = auod.a(this.a).iterator();
      if (((Iterator)localObject).hasNext())
      {
        auof localauof = (auof)((Iterator)localObject).next();
        if (paramMessage.arg1 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localauof.a(bool, (Throwable)paramMessage.obj);
          break;
        }
      }
      localObject = new Intent(aunx.a(auod.a(this.a).c));
      if (paramMessage.arg1 == 0)
      {
        if (aunx.a(auod.a(this.a).c)) {}
        for (int i = 9;; i = 8)
        {
          ((Intent)localObject).putExtra("key_state", i);
          auod.a(this.a).sendBroadcast((Intent)localObject);
          if (auok.a.get(auod.a(this.a)) == null) {
            break;
          }
          auoj.b(String.valueOf(((auok)auok.a.get(auod.a(this.a))).f));
          return false;
        }
      }
      if (aunx.a(auod.a(this.a).c)) {
        auoj.a("2691708");
      }
      for (;;)
      {
        auns.a((Throwable)paramMessage.obj);
        ((Intent)localObject).putExtra("key_state", 7);
        auod.a(this.a).sendBroadcast((Intent)localObject);
        return false;
        if (aunx.b(auod.a(this.a).c)) {
          auoj.a("2597726");
        } else if (auok.a.get(auod.a(this.a)) != null) {
          auoj.b(String.valueOf(((auok)auok.a.get(auod.a(this.a))).e));
        }
      }
      paramMessage = new Intent(aunx.a(auod.a(this.a).c));
      paramMessage.putExtra("key_state", 6);
      auod.a(this.a).sendBroadcast(paramMessage);
    } while (auok.a.get(auod.a(this.a)) == null);
    auoj.b(String.valueOf(((auok)auok.a.get(auod.a(this.a))).d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auoe
 * JD-Core Version:    0.7.0.1
 */