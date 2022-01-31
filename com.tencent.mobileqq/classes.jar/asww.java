import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import java.util.Map;

class asww
  implements Handler.Callback
{
  asww(aswv paramaswv) {}
  
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
                } while (aswv.a(this.a) == null);
                aswv.a(this.a).a(0, new Object[] { paramMessage.obj });
                return false;
                i = paramMessage.arg1;
              } while ((i <= aswv.a(this.a)) || (aswv.a(this.a) == null));
              aswv.a(this.a).a(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(aswv.a(this.a)) });
              aswv.a(this.a, i);
              return false;
              if (aswv.a(this.a) != null) {
                aswv.a(this.a).a(2, new Object[] { paramMessage.obj });
              }
            } while (aswz.a.get(aswv.a(this.a)) == null);
            aswy.b(String.valueOf(((aswz)aswz.a.get(aswv.a(this.a))).b));
            return false;
            if (aswv.a(this.a) != null) {
              aswv.a(this.a).a(3, new Object[] { paramMessage.obj });
            }
          } while (aswz.a.get(aswv.a(this.a)) == null);
          aswy.b(String.valueOf(((aswz)aswz.a.get(aswv.a(this.a))).c));
          return false;
          InstalledPlugin localInstalledPlugin;
          aswx localaswx;
          if (aswv.a(this.a) != null)
          {
            localInstalledPlugin = (InstalledPlugin)paramMessage.obj;
            localaswx = aswv.a(this.a);
            if (paramMessage.arg1 != 1) {
              break label461;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localaswx.a(4, new Object[] { localInstalledPlugin, Boolean.valueOf(bool), Long.valueOf(aswv.b(this.a)) });
            aswv.a(this.a, "HuayangPluginNewDownloader", alpo.a(2131706021) + (System.currentTimeMillis() - aswv.c(this.a)));
            aswv.a(this.a, false);
            return false;
          }
        } while (aswv.a(this.a) == null);
        aswv.a(this.a).a(5, new Object[] { paramMessage.obj });
        return false;
      } while (!(paramMessage.obj instanceof ProgressFuture));
      double d = ((ProgressFuture)paramMessage.obj).getProgress();
      aswv.a(this.a, "HuayangPluginNewDownloader", "收到读取进度的MSG, progress = " + d);
      aswv.a(this.a).sendMessage(Message.obtain(aswv.a(this.a), 1, (int)(d * 100.0D), 0));
      aswv.a(this.a).sendMessageDelayed(Message.obtain(aswv.a(this.a), 4, paramMessage.obj), 300L);
      return false;
    }
    paramMessage = new Intent(aswv.a(this.a), HuayangLoadbackgroudActivity.class);
    paramMessage.putExtra("isPreload", true);
    paramMessage.setFlags(268435456);
    aswv.a(this.a).startActivity(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asww
 * JD-Core Version:    0.7.0.1
 */