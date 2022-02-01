import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import java.util.Map;

class avuc
  implements Handler.Callback
{
  avuc(avub paramavub) {}
  
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
                } while (avub.a(this.a) == null);
                avub.a(this.a).a(0, new Object[] { paramMessage.obj });
                return false;
                i = paramMessage.arg1;
              } while ((i <= avub.a(this.a)) || (avub.a(this.a) == null));
              avub.a(this.a).a(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(avub.a(this.a)) });
              avub.a(this.a, i);
              return false;
              if (avub.a(this.a) != null) {
                avub.a(this.a).a(2, new Object[] { paramMessage.obj });
              }
            } while (avuf.a.get(avub.a(this.a)) == null);
            avue.b(String.valueOf(((avuf)avuf.a.get(avub.a(this.a))).b));
            return false;
            if (avub.a(this.a) != null) {
              avub.a(this.a).a(3, new Object[] { paramMessage.obj });
            }
          } while (avuf.a.get(avub.a(this.a)) == null);
          avue.b(String.valueOf(((avuf)avuf.a.get(avub.a(this.a))).c));
          return false;
          InstalledPlugin localInstalledPlugin;
          avud localavud;
          if (avub.a(this.a) != null)
          {
            localInstalledPlugin = (InstalledPlugin)paramMessage.obj;
            localavud = avub.a(this.a);
            if (paramMessage.arg1 != 1) {
              break label461;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localavud.a(4, new Object[] { localInstalledPlugin, Boolean.valueOf(bool), Long.valueOf(avub.b(this.a)) });
            avub.a(this.a, "HuayangPluginNewDownloader", anvx.a(2131705122) + (System.currentTimeMillis() - avub.c(this.a)));
            avub.a(this.a, false);
            return false;
          }
        } while (avub.a(this.a) == null);
        avub.a(this.a).a(5, new Object[] { paramMessage.obj });
        return false;
      } while (!(paramMessage.obj instanceof ProgressFuture));
      double d = ((ProgressFuture)paramMessage.obj).getProgress();
      avub.a(this.a, "HuayangPluginNewDownloader", "收到读取进度的MSG, progress = " + d);
      avub.a(this.a).sendMessage(Message.obtain(avub.a(this.a), 1, (int)(d * 100.0D), 0));
      avub.a(this.a).sendMessageDelayed(Message.obtain(avub.a(this.a), 4, paramMessage.obj), 300L);
      return false;
    }
    paramMessage = new Intent(avub.a(this.a), HuayangLoadbackgroudActivity.class);
    paramMessage.putExtra("isPreload", true);
    paramMessage.setFlags(268435456);
    avub.a(this.a).startActivity(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avuc
 * JD-Core Version:    0.7.0.1
 */