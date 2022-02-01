import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import java.util.Map;

class awbh
  implements Handler.Callback
{
  awbh(awbg paramawbg) {}
  
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
                } while (awbg.a(this.a) == null);
                awbg.a(this.a).a(0, new Object[] { paramMessage.obj });
                return false;
                i = paramMessage.arg1;
              } while ((i <= awbg.a(this.a)) || (awbg.a(this.a) == null));
              awbg.a(this.a).a(1, new Object[] { Integer.valueOf(paramMessage.arg1), Long.valueOf(awbg.a(this.a)) });
              awbg.a(this.a, i);
              return false;
              if (awbg.a(this.a) != null) {
                awbg.a(this.a).a(2, new Object[] { paramMessage.obj });
              }
            } while (awbk.a.get(awbg.a(this.a)) == null);
            awbj.b(String.valueOf(((awbk)awbk.a.get(awbg.a(this.a))).b));
            return false;
            if (awbg.a(this.a) != null) {
              awbg.a(this.a).a(3, new Object[] { paramMessage.obj });
            }
          } while (awbk.a.get(awbg.a(this.a)) == null);
          awbj.b(String.valueOf(((awbk)awbk.a.get(awbg.a(this.a))).c));
          return false;
          InstalledPlugin localInstalledPlugin;
          awbi localawbi;
          if (awbg.a(this.a) != null)
          {
            localInstalledPlugin = (InstalledPlugin)paramMessage.obj;
            localawbi = awbg.a(this.a);
            if (paramMessage.arg1 != 1) {
              break label461;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            localawbi.a(4, new Object[] { localInstalledPlugin, Boolean.valueOf(bool), Long.valueOf(awbg.b(this.a)) });
            awbg.a(this.a, "HuayangPluginNewDownloader", anzj.a(2131704541) + (System.currentTimeMillis() - awbg.c(this.a)));
            awbg.a(this.a, false);
            return false;
          }
        } while (awbg.a(this.a) == null);
        awbg.a(this.a).a(5, new Object[] { paramMessage.obj });
        return false;
      } while (!(paramMessage.obj instanceof ProgressFuture));
      double d = ((ProgressFuture)paramMessage.obj).getProgress();
      awbg.a(this.a, "HuayangPluginNewDownloader", "收到读取进度的MSG, progress = " + d);
      awbg.a(this.a).sendMessage(Message.obtain(awbg.a(this.a), 1, (int)(d * 100.0D), 0));
      awbg.a(this.a).sendMessageDelayed(Message.obtain(awbg.a(this.a), 4, paramMessage.obj), 300L);
      return false;
    }
    paramMessage = new Intent(awbg.a(this.a), HuayangLoadbackgroudActivity.class);
    paramMessage.putExtra("isPreload", true);
    paramMessage.setFlags(268435456);
    awbg.a(this.a).startActivity(paramMessage);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbh
 * JD-Core Version:    0.7.0.1
 */