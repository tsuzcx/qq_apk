import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import java.util.Map;

class aviz
  implements Handler.Callback
{
  aviz(aviy paramaviy) {}
  
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
                } while (aviy.a(this.a) == null);
                aviy.a(this.a).a(0, new Object[] { paramMessage.obj });
                return false;
                i = paramMessage.arg1;
              } while ((i <= aviy.a(this.a)) || (aviy.a(this.a) == null));
              aviy.a(this.a).a(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(aviy.a(this.a)) });
              aviy.a(this.a, i);
              return false;
              if (aviy.a(this.a) != null) {
                aviy.a(this.a).a(2, new Object[] { paramMessage.obj });
              }
            } while (avjc.a.get(aviy.a(this.a)) == null);
            avjb.b(String.valueOf(((avjc)avjc.a.get(aviy.a(this.a))).b));
            return false;
            if (aviy.a(this.a) != null) {
              aviy.a(this.a).a(3, new Object[] { paramMessage.obj });
            }
          } while (avjc.a.get(aviy.a(this.a)) == null);
          avjb.b(String.valueOf(((avjc)avjc.a.get(aviy.a(this.a))).c));
          return false;
          InstalledPlugin localInstalledPlugin;
          avja localavja;
          if (aviy.a(this.a) != null)
          {
            localInstalledPlugin = (InstalledPlugin)paramMessage.obj;
            localavja = aviy.a(this.a);
            if (paramMessage.arg1 != 1) {
              break label461;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localavja.a(4, new Object[] { localInstalledPlugin, Boolean.valueOf(bool), Long.valueOf(aviy.b(this.a)) });
            aviy.a(this.a, "HuayangPluginNewDownloader", anni.a(2131704434) + (System.currentTimeMillis() - aviy.c(this.a)));
            aviy.a(this.a, false);
            return false;
          }
        } while (aviy.a(this.a) == null);
        aviy.a(this.a).a(5, new Object[] { paramMessage.obj });
        return false;
      } while (!(paramMessage.obj instanceof ProgressFuture));
      double d = ((ProgressFuture)paramMessage.obj).getProgress();
      aviy.a(this.a, "HuayangPluginNewDownloader", "收到读取进度的MSG, progress = " + d);
      aviy.a(this.a).sendMessage(Message.obtain(aviy.a(this.a), 1, (int)(d * 100.0D), 0));
      aviy.a(this.a).sendMessageDelayed(Message.obtain(aviy.a(this.a), 4, paramMessage.obj), 300L);
      return false;
    }
    paramMessage = new Intent(aviy.a(this.a), HuayangLoadbackgroudActivity.class);
    paramMessage.putExtra("isPreload", true);
    paramMessage.setFlags(268435456);
    aviy.a(this.a).startActivity(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aviz
 * JD-Core Version:    0.7.0.1
 */