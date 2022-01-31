import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import java.util.Map;

class argg
  implements Handler.Callback
{
  argg(argf paramargf) {}
  
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
                } while (argf.a(this.a) == null);
                argf.a(this.a).a(0, new Object[] { paramMessage.obj });
                return false;
                i = paramMessage.arg1;
              } while ((i <= argf.a(this.a)) || (argf.a(this.a) == null));
              argf.a(this.a).a(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(argf.a(this.a)) });
              argf.a(this.a, i);
              return false;
              if (argf.a(this.a) != null) {
                argf.a(this.a).a(2, new Object[] { paramMessage.obj });
              }
            } while (argj.a.get(argf.a(this.a)) == null);
            argi.b(String.valueOf(((argj)argj.a.get(argf.a(this.a))).b));
            return false;
            if (argf.a(this.a) != null) {
              argf.a(this.a).a(3, new Object[] { paramMessage.obj });
            }
          } while (argj.a.get(argf.a(this.a)) == null);
          argi.b(String.valueOf(((argj)argj.a.get(argf.a(this.a))).c));
          return false;
          InstalledPlugin localInstalledPlugin;
          argh localargh;
          if (argf.a(this.a) != null)
          {
            localInstalledPlugin = (InstalledPlugin)paramMessage.obj;
            localargh = argf.a(this.a);
            if (paramMessage.arg1 != 1) {
              break label461;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localargh.a(4, new Object[] { localInstalledPlugin, Boolean.valueOf(bool), Long.valueOf(argf.b(this.a)) });
            argf.a(this.a, "HuayangPluginNewDownloader", ajyc.a(2131705638) + (System.currentTimeMillis() - argf.c(this.a)));
            argf.a(this.a, false);
            return false;
          }
        } while (argf.a(this.a) == null);
        argf.a(this.a).a(5, new Object[] { paramMessage.obj });
        return false;
      } while (!(paramMessage.obj instanceof ProgressFuture));
      double d = ((ProgressFuture)paramMessage.obj).getProgress();
      argf.a(this.a, "HuayangPluginNewDownloader", "收到读取进度的MSG, progress = " + d);
      argf.a(this.a).sendMessage(Message.obtain(argf.a(this.a), 1, (int)(d * 100.0D), 0));
      argf.a(this.a).sendMessageDelayed(Message.obtain(argf.a(this.a), 4, paramMessage.obj), 300L);
      return false;
    }
    paramMessage = new Intent(argf.a(this.a), HuayangLoadbackgroudActivity.class);
    paramMessage.putExtra("isPreload", true);
    paramMessage.setFlags(268435456);
    argf.a(this.a).startActivity(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     argg
 * JD-Core Version:    0.7.0.1
 */