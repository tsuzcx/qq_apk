import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import java.util.Map;

class atbf
  implements Handler.Callback
{
  atbf(atbe paramatbe) {}
  
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
                } while (atbe.a(this.a) == null);
                atbe.a(this.a).a(0, new Object[] { paramMessage.obj });
                return false;
                i = paramMessage.arg1;
              } while ((i <= atbe.a(this.a)) || (atbe.a(this.a) == null));
              atbe.a(this.a).a(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(atbe.a(this.a)) });
              atbe.a(this.a, i);
              return false;
              if (atbe.a(this.a) != null) {
                atbe.a(this.a).a(2, new Object[] { paramMessage.obj });
              }
            } while (atbi.a.get(atbe.a(this.a)) == null);
            atbh.b(String.valueOf(((atbi)atbi.a.get(atbe.a(this.a))).b));
            return false;
            if (atbe.a(this.a) != null) {
              atbe.a(this.a).a(3, new Object[] { paramMessage.obj });
            }
          } while (atbi.a.get(atbe.a(this.a)) == null);
          atbh.b(String.valueOf(((atbi)atbi.a.get(atbe.a(this.a))).c));
          return false;
          InstalledPlugin localInstalledPlugin;
          atbg localatbg;
          if (atbe.a(this.a) != null)
          {
            localInstalledPlugin = (InstalledPlugin)paramMessage.obj;
            localatbg = atbe.a(this.a);
            if (paramMessage.arg1 != 1) {
              break label461;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localatbg.a(4, new Object[] { localInstalledPlugin, Boolean.valueOf(bool), Long.valueOf(atbe.b(this.a)) });
            atbe.a(this.a, "HuayangPluginNewDownloader", alud.a(2131706033) + (System.currentTimeMillis() - atbe.c(this.a)));
            atbe.a(this.a, false);
            return false;
          }
        } while (atbe.a(this.a) == null);
        atbe.a(this.a).a(5, new Object[] { paramMessage.obj });
        return false;
      } while (!(paramMessage.obj instanceof ProgressFuture));
      double d = ((ProgressFuture)paramMessage.obj).getProgress();
      atbe.a(this.a, "HuayangPluginNewDownloader", "收到读取进度的MSG, progress = " + d);
      atbe.a(this.a).sendMessage(Message.obtain(atbe.a(this.a), 1, (int)(d * 100.0D), 0));
      atbe.a(this.a).sendMessageDelayed(Message.obtain(atbe.a(this.a), 4, paramMessage.obj), 300L);
      return false;
    }
    paramMessage = new Intent(atbe.a(this.a), HuayangLoadbackgroudActivity.class);
    paramMessage.putExtra("isPreload", true);
    paramMessage.setFlags(268435456);
    atbe.a(this.a).startActivity(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbf
 * JD-Core Version:    0.7.0.1
 */