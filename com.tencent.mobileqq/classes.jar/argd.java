import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class argd
  implements Handler.Callback
{
  argd(argc paramargc) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      Object localObject = argc.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((arge)((Iterator)localObject).next()).a(paramMessage.arg1);
      }
      localObject = argc.a(this.a).iterator();
      if (((Iterator)localObject).hasNext())
      {
        arge localarge = (arge)((Iterator)localObject).next();
        if (paramMessage.arg1 == 0) {}
        for (boolean bool = true;; bool = false)
        {
          localarge.a(bool, (Throwable)paramMessage.obj);
          break;
        }
      }
      localObject = new Intent(arfw.a(argc.a(this.a).c));
      if (paramMessage.arg1 == 0)
      {
        if (arfw.a(argc.a(this.a).c)) {}
        for (int i = 9;; i = 8)
        {
          ((Intent)localObject).putExtra("key_state", i);
          argc.a(this.a).sendBroadcast((Intent)localObject);
          if (argj.a.get(argc.a(this.a)) == null) {
            break;
          }
          argi.b(String.valueOf(((argj)argj.a.get(argc.a(this.a))).f));
          return false;
        }
      }
      if (arfw.a(argc.a(this.a).c)) {
        argi.a("2691708");
      }
      for (;;)
      {
        arfr.a((Throwable)paramMessage.obj);
        ((Intent)localObject).putExtra("key_state", 7);
        argc.a(this.a).sendBroadcast((Intent)localObject);
        return false;
        if (arfw.b(argc.a(this.a).c)) {
          argi.a("2597726");
        } else if (argj.a.get(argc.a(this.a)) != null) {
          argi.b(String.valueOf(((argj)argj.a.get(argc.a(this.a))).e));
        }
      }
      paramMessage = new Intent(arfw.a(argc.a(this.a).c));
      paramMessage.putExtra("key_state", 6);
      argc.a(this.a).sendBroadcast(paramMessage);
    } while (argj.a.get(argc.a(this.a)) == null);
    argi.b(String.valueOf(((argj)argj.a.get(argc.a(this.a))).d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     argd
 * JD-Core Version:    0.7.0.1
 */