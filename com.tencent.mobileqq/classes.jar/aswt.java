import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class aswt
  implements Handler.Callback
{
  aswt(asws paramasws) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = asws.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((aswu)((Iterator)localObject).next()).a(paramMessage.arg1);
      }
      localObject = asws.a(this.a).iterator();
      if (((Iterator)localObject).hasNext())
      {
        aswu localaswu = (aswu)((Iterator)localObject).next();
        if (paramMessage.arg1 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localaswu.a(bool, (Throwable)paramMessage.obj);
          break;
        }
      }
      localObject = new Intent(aswm.a(asws.a(this.a).c));
      if (paramMessage.arg1 == 0)
      {
        if (aswm.a(asws.a(this.a).c)) {}
        for (int i = 9;; i = 8)
        {
          ((Intent)localObject).putExtra("key_state", i);
          asws.a(this.a).sendBroadcast((Intent)localObject);
          if (aswz.a.get(asws.a(this.a)) == null) {
            break;
          }
          aswy.b(String.valueOf(((aswz)aswz.a.get(asws.a(this.a))).f));
          return false;
        }
      }
      if (aswm.a(asws.a(this.a).c)) {
        aswy.a("2691708");
      }
      for (;;)
      {
        aswh.a((Throwable)paramMessage.obj);
        ((Intent)localObject).putExtra("key_state", 7);
        asws.a(this.a).sendBroadcast((Intent)localObject);
        return false;
        if (aswm.b(asws.a(this.a).c)) {
          aswy.a("2597726");
        } else if (aswz.a.get(asws.a(this.a)) != null) {
          aswy.b(String.valueOf(((aswz)aswz.a.get(asws.a(this.a))).e));
        }
      }
      paramMessage = new Intent(aswm.a(asws.a(this.a).c));
      paramMessage.putExtra("key_state", 6);
      asws.a(this.a).sendBroadcast(paramMessage);
    } while (aswz.a.get(asws.a(this.a)) == null);
    aswy.b(String.valueOf(((aswz)aswz.a.get(asws.a(this.a))).d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswt
 * JD-Core Version:    0.7.0.1
 */