import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class argf
  implements Handler.Callback
{
  argf(arge paramarge) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = arge.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((argg)((Iterator)localObject).next()).a(paramMessage.arg1);
      }
      localObject = arge.a(this.a).iterator();
      if (((Iterator)localObject).hasNext())
      {
        argg localargg = (argg)((Iterator)localObject).next();
        if (paramMessage.arg1 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localargg.a(bool, (Throwable)paramMessage.obj);
          break;
        }
      }
      localObject = new Intent(arfy.a(arge.a(this.a).c));
      if (paramMessage.arg1 == 0)
      {
        if (arfy.a(arge.a(this.a).c)) {}
        for (int i = 9;; i = 8)
        {
          ((Intent)localObject).putExtra("key_state", i);
          arge.a(this.a).sendBroadcast((Intent)localObject);
          if (argl.a.get(arge.a(this.a)) == null) {
            break;
          }
          argk.b(String.valueOf(((argl)argl.a.get(arge.a(this.a))).f));
          return false;
        }
      }
      if (arfy.a(arge.a(this.a).c)) {
        argk.a("2691708");
      }
      for (;;)
      {
        arft.a((Throwable)paramMessage.obj);
        ((Intent)localObject).putExtra("key_state", 7);
        arge.a(this.a).sendBroadcast((Intent)localObject);
        return false;
        if (arfy.b(arge.a(this.a).c)) {
          argk.a("2597726");
        } else if (argl.a.get(arge.a(this.a)) != null) {
          argk.b(String.valueOf(((argl)argl.a.get(arge.a(this.a))).e));
        }
      }
      paramMessage = new Intent(arfy.a(arge.a(this.a).c));
      paramMessage.putExtra("key_state", 6);
      arge.a(this.a).sendBroadcast(paramMessage);
    } while (argl.a.get(arge.a(this.a)) == null);
    argk.b(String.valueOf(((argl)argl.a.get(arge.a(this.a))).d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     argf
 * JD-Core Version:    0.7.0.1
 */