import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import java.util.Map;

class auoh
  implements Handler.Callback
{
  auoh(auog paramauog) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    case 4: 
      label461:
      do
      {
        do
        {
          do
          {
            do
            {
              int i;
              do
              {
                do
                {
                  return false;
                } while (auog.a(this.a) == null);
                auog.a(this.a).a(0, new Object[] { paramMessage.obj });
                return false;
                i = paramMessage.arg1;
              } while ((i <= auog.a(this.a)) || (auog.a(this.a) == null));
              auog.a(this.a).a(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(auog.a(this.a)) });
              auog.a(this.a, i);
              return false;
              if (auog.a(this.a) != null) {
                auog.a(this.a).a(2, new Object[] { paramMessage.obj });
              }
            } while (auok.a.get(auog.a(this.a)) == null);
            auoj.b(String.valueOf(((auok)auok.a.get(auog.a(this.a))).b));
            return false;
            if (auog.a(this.a) != null) {
              auog.a(this.a).a(3, new Object[] { paramMessage.obj });
            }
          } while (auok.a.get(auog.a(this.a)) == null);
          auoj.b(String.valueOf(((auok)auok.a.get(auog.a(this.a))).c));
          return false;
          InstalledPlugin localInstalledPlugin;
          auoi localauoi;
          if (auog.a(this.a) != null)
          {
            localInstalledPlugin = (InstalledPlugin)paramMessage.obj;
            localauoi = auog.a(this.a);
            if (paramMessage.arg1 != 1) {
              break label461;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localauoi.a(4, new Object[] { localInstalledPlugin, Boolean.valueOf(bool), Long.valueOf(auog.b(this.a)) });
            auog.a(this.a, "HuayangPluginNewDownloader", amtj.a(2131704771) + (System.currentTimeMillis() - auog.c(this.a)));
            auog.a(this.a, false);
            return false;
          }
        } while (auog.a(this.a) == null);
        auog.a(this.a).a(5, new Object[] { paramMessage.obj });
        return false;
      } while (!(paramMessage.obj instanceof ProgressFuture));
      double d = ((ProgressFuture)paramMessage.obj).getProgress();
      auog.a(this.a, "HuayangPluginNewDownloader", "收到读取进度的MSG, progress = " + d);
      auog.a(this.a).sendMessage(Message.obtain(auog.a(this.a), 1, (int)(d * 100.0D), 0));
      auog.a(this.a).sendMessageDelayed(Message.obtain(auog.a(this.a), 4, paramMessage.obj), 300L);
      return false;
    }
    paramMessage = new Intent(auog.a(this.a), HuayangLoadbackgroudActivity.class);
    paramMessage.putExtra("isPreload", true);
    paramMessage.setFlags(268435456);
    auog.a(this.a).startActivity(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auoh
 * JD-Core Version:    0.7.0.1
 */