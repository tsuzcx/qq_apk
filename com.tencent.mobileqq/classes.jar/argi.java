import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import java.util.Map;

class argi
  implements Handler.Callback
{
  argi(argh paramargh) {}
  
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
                } while (argh.a(this.a) == null);
                argh.a(this.a).a(0, new Object[] { paramMessage.obj });
                return false;
                i = paramMessage.arg1;
              } while ((i <= argh.a(this.a)) || (argh.a(this.a) == null));
              argh.a(this.a).a(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(argh.a(this.a)) });
              argh.a(this.a, i);
              return false;
              if (argh.a(this.a) != null) {
                argh.a(this.a).a(2, new Object[] { paramMessage.obj });
              }
            } while (argl.a.get(argh.a(this.a)) == null);
            argk.b(String.valueOf(((argl)argl.a.get(argh.a(this.a))).b));
            return false;
            if (argh.a(this.a) != null) {
              argh.a(this.a).a(3, new Object[] { paramMessage.obj });
            }
          } while (argl.a.get(argh.a(this.a)) == null);
          argk.b(String.valueOf(((argl)argl.a.get(argh.a(this.a))).c));
          return false;
          InstalledPlugin localInstalledPlugin;
          argj localargj;
          if (argh.a(this.a) != null)
          {
            localInstalledPlugin = (InstalledPlugin)paramMessage.obj;
            localargj = argh.a(this.a);
            if (paramMessage.arg1 != 1) {
              break label461;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localargj.a(4, new Object[] { localInstalledPlugin, Boolean.valueOf(bool), Long.valueOf(argh.b(this.a)) });
            argh.a(this.a, "HuayangPluginNewDownloader", ajya.a(2131705649) + (System.currentTimeMillis() - argh.c(this.a)));
            argh.a(this.a, false);
            return false;
          }
        } while (argh.a(this.a) == null);
        argh.a(this.a).a(5, new Object[] { paramMessage.obj });
        return false;
      } while (!(paramMessage.obj instanceof ProgressFuture));
      double d = ((ProgressFuture)paramMessage.obj).getProgress();
      argh.a(this.a, "HuayangPluginNewDownloader", "收到读取进度的MSG, progress = " + d);
      argh.a(this.a).sendMessage(Message.obtain(argh.a(this.a), 1, (int)(d * 100.0D), 0));
      argh.a(this.a).sendMessageDelayed(Message.obtain(argh.a(this.a), 4, paramMessage.obj), 300L);
      return false;
    }
    paramMessage = new Intent(argh.a(this.a), HuayangLoadbackgroudActivity.class);
    paramMessage.putExtra("isPreload", true);
    paramMessage.setFlags(268435456);
    argh.a(this.a).startActivity(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     argi
 * JD-Core Version:    0.7.0.1
 */