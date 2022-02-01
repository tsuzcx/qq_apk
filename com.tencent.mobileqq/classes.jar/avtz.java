import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class avtz
  implements Handler.Callback
{
  avtz(avty paramavty) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = avty.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((avua)((Iterator)localObject).next()).a(paramMessage.arg1);
      }
      localObject = avty.a(this.a).iterator();
      if (((Iterator)localObject).hasNext())
      {
        avua localavua = (avua)((Iterator)localObject).next();
        if (paramMessage.arg1 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localavua.a(bool, (Throwable)paramMessage.obj);
          break;
        }
      }
      localObject = new Intent(avts.a(avty.a(this.a).c));
      if (paramMessage.arg1 == 0)
      {
        if (avts.a(avty.a(this.a).c)) {}
        for (int i = 9;; i = 8)
        {
          ((Intent)localObject).putExtra("key_state", i);
          avty.a(this.a).sendBroadcast((Intent)localObject);
          if (avuf.a.get(avty.a(this.a)) == null) {
            break;
          }
          avue.b(String.valueOf(((avuf)avuf.a.get(avty.a(this.a))).f));
          return false;
        }
      }
      if (avts.a(avty.a(this.a).c)) {
        avue.a("2691708");
      }
      for (;;)
      {
        avtn.a((Throwable)paramMessage.obj);
        ((Intent)localObject).putExtra("key_state", 7);
        avty.a(this.a).sendBroadcast((Intent)localObject);
        return false;
        if (avts.b(avty.a(this.a).c)) {
          avue.a("2597726");
        } else if (avuf.a.get(avty.a(this.a)) != null) {
          avue.b(String.valueOf(((avuf)avuf.a.get(avty.a(this.a))).e));
        }
      }
      paramMessage = new Intent(avts.a(avty.a(this.a).c));
      paramMessage.putExtra("key_state", 6);
      avty.a(this.a).sendBroadcast(paramMessage);
    } while (avuf.a.get(avty.a(this.a)) == null);
    avue.b(String.valueOf(((avuf)avuf.a.get(avty.a(this.a))).d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avtz
 * JD-Core Version:    0.7.0.1
 */