import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import java.util.Map;

class aqmb
  implements Handler.Callback
{
  aqmb(aqma paramaqma) {}
  
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
                } while (aqma.a(this.a) == null);
                aqma.a(this.a).a(0, new Object[] { paramMessage.obj });
                return false;
                i = paramMessage.arg1;
              } while ((i <= aqma.a(this.a)) || (aqma.a(this.a) == null));
              aqma.a(this.a).a(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(aqma.a(this.a)) });
              aqma.a(this.a, i);
              return false;
              if (aqma.a(this.a) != null) {
                aqma.a(this.a).a(2, new Object[] { paramMessage.obj });
              }
            } while (aqme.a.get(aqma.a(this.a)) == null);
            aqmd.b(String.valueOf(((aqme)aqme.a.get(aqma.a(this.a))).b));
            return false;
            if (aqma.a(this.a) != null) {
              aqma.a(this.a).a(3, new Object[] { paramMessage.obj });
            }
          } while (aqme.a.get(aqma.a(this.a)) == null);
          aqmd.b(String.valueOf(((aqme)aqme.a.get(aqma.a(this.a))).c));
          return false;
          InstalledPlugin localInstalledPlugin;
          aqmc localaqmc;
          if (aqma.a(this.a) != null)
          {
            localInstalledPlugin = (InstalledPlugin)paramMessage.obj;
            localaqmc = aqma.a(this.a);
            if (paramMessage.arg1 != 1) {
              break label461;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localaqmc.a(4, new Object[] { localInstalledPlugin, Boolean.valueOf(bool), Long.valueOf(aqma.b(this.a)) });
            aqma.a(this.a, "HuayangPluginNewDownloader", ajjy.a(2131639853) + (System.currentTimeMillis() - aqma.c(this.a)));
            aqma.a(this.a, false);
            return false;
          }
        } while (aqma.a(this.a) == null);
        aqma.a(this.a).a(5, new Object[] { paramMessage.obj });
        return false;
      } while (!(paramMessage.obj instanceof ProgressFuture));
      double d = ((ProgressFuture)paramMessage.obj).getProgress();
      aqma.a(this.a, "HuayangPluginNewDownloader", "收到读取进度的MSG, progress = " + d);
      aqma.a(this.a).sendMessage(Message.obtain(aqma.a(this.a), 1, (int)(d * 100.0D), 0));
      aqma.a(this.a).sendMessageDelayed(Message.obtain(aqma.a(this.a), 4, paramMessage.obj), 300L);
      return false;
    }
    paramMessage = new Intent(aqma.a(this.a), HuayangLoadbackgroudActivity.class);
    paramMessage.putExtra("isPreload", true);
    paramMessage.setFlags(268435456);
    aqma.a(this.a).startActivity(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqmb
 * JD-Core Version:    0.7.0.1
 */