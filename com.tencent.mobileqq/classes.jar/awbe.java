import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class awbe
  implements Handler.Callback
{
  awbe(awbd paramawbd) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = awbd.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((awbf)((Iterator)localObject).next()).a(paramMessage.arg1);
      }
      localObject = awbd.a(this.a).iterator();
      if (((Iterator)localObject).hasNext())
      {
        awbf localawbf = (awbf)((Iterator)localObject).next();
        if (paramMessage.arg1 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localawbf.a(bool, (Throwable)paramMessage.obj);
          break;
        }
      }
      localObject = new Intent(awax.a(awbd.a(this.a).c));
      if (paramMessage.arg1 == 0)
      {
        if (awax.a(awbd.a(this.a).c)) {}
        for (int i = 9;; i = 8)
        {
          ((Intent)localObject).putExtra("key_state", i);
          awbd.a(this.a).sendBroadcast((Intent)localObject);
          if (awbk.a.get(awbd.a(this.a)) == null) {
            break;
          }
          awbj.b(String.valueOf(((awbk)awbk.a.get(awbd.a(this.a))).f));
          return false;
        }
      }
      if (awax.a(awbd.a(this.a).c)) {
        awbj.a("2691708");
      }
      for (;;)
      {
        awas.a((Throwable)paramMessage.obj);
        ((Intent)localObject).putExtra("key_state", 7);
        awbd.a(this.a).sendBroadcast((Intent)localObject);
        return false;
        if (awax.b(awbd.a(this.a).c)) {
          awbj.a("2597726");
        } else if (awbk.a.get(awbd.a(this.a)) != null) {
          awbj.b(String.valueOf(((awbk)awbk.a.get(awbd.a(this.a))).e));
        }
      }
      paramMessage = new Intent(awax.a(awbd.a(this.a).c));
      paramMessage.putExtra("key_state", 6);
      awbd.a(this.a).sendBroadcast(paramMessage);
    } while (awbk.a.get(awbd.a(this.a)) == null);
    awbj.b(String.valueOf(((awbk)awbk.a.get(awbd.a(this.a))).d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbe
 * JD-Core Version:    0.7.0.1
 */