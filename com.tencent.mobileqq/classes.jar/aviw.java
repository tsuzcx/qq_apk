import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class aviw
  implements Handler.Callback
{
  aviw(aviv paramaviv) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = aviv.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((avix)((Iterator)localObject).next()).a(paramMessage.arg1);
      }
      localObject = aviv.a(this.a).iterator();
      if (((Iterator)localObject).hasNext())
      {
        avix localavix = (avix)((Iterator)localObject).next();
        if (paramMessage.arg1 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localavix.a(bool, (Throwable)paramMessage.obj);
          break;
        }
      }
      localObject = new Intent(avip.a(aviv.a(this.a).c));
      if (paramMessage.arg1 == 0)
      {
        if (avip.a(aviv.a(this.a).c)) {}
        for (int i = 9;; i = 8)
        {
          ((Intent)localObject).putExtra("key_state", i);
          aviv.a(this.a).sendBroadcast((Intent)localObject);
          if (avjc.a.get(aviv.a(this.a)) == null) {
            break;
          }
          avjb.b(String.valueOf(((avjc)avjc.a.get(aviv.a(this.a))).f));
          return false;
        }
      }
      if (avip.a(aviv.a(this.a).c)) {
        avjb.a("2691708");
      }
      for (;;)
      {
        avik.a((Throwable)paramMessage.obj);
        ((Intent)localObject).putExtra("key_state", 7);
        aviv.a(this.a).sendBroadcast((Intent)localObject);
        return false;
        if (avip.b(aviv.a(this.a).c)) {
          avjb.a("2597726");
        } else if (avjc.a.get(aviv.a(this.a)) != null) {
          avjb.b(String.valueOf(((avjc)avjc.a.get(aviv.a(this.a))).e));
        }
      }
      paramMessage = new Intent(avip.a(aviv.a(this.a).c));
      paramMessage.putExtra("key_state", 6);
      aviv.a(this.a).sendBroadcast(paramMessage);
    } while (avjc.a.get(aviv.a(this.a)) == null);
    avjb.b(String.valueOf(((avjc)avjc.a.get(aviv.a(this.a))).d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aviw
 * JD-Core Version:    0.7.0.1
 */