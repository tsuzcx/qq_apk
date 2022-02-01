import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.RestartActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.ShareActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DebugUtil;

class bjxb
  implements Handler.Callback
{
  bjxb(bjww parambjww) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MiniAppProxyImpl", 1, "handleMessage error, msg is null.");
      }
    }
    label452:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (bjww.a(this.a) == null)
              {
                QLog.e("MiniAppProxyImpl", 1, "handleMessage error, MiniAppContext is null.");
                return false;
              }
              switch (paramMessage.what)
              {
              case 4: 
              case 10: 
              default: 
                return false;
              case 2: 
                bjww.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(1, null));
                return false;
              case 1000: 
                this.a.a();
                return false;
              case 6: 
                bjww.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(2, null));
                return false;
              case 7: 
                bjww.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(3, null));
                return false;
              case 8: 
                bjww.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(4, null));
                return false;
              case 13: 
                bjww.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(5, paramMessage.getData()));
                return false;
              case 3: 
                paramMessage = bjww.a(this.a).getMiniAppInfo();
              }
            } while (paramMessage == null);
            if (DebugUtil.getDebugEnabled(paramMessage)) {
              DebugUtil.setDebugEnabled(paramMessage, false);
            }
            for (;;)
            {
              bjww.a(bjww.a(this.a));
              return false;
              DebugUtil.setDebugEnabled(paramMessage, true);
            }
            bjww.a(ActionBridge.UpdateUIActionBridge.toggleMonitorPanel(bjww.a(this.a)).booleanValue());
            return false;
            paramMessage = bjww.a(this.a).getMiniAppInfo();
          } while (paramMessage == null);
          int i;
          bjww localbjww;
          IMiniAppContext localIMiniAppContext;
          if (paramMessage.topType == 0)
          {
            i = 1;
            paramMessage.topType = i;
            bjww.a(this.a, paramMessage);
            localbjww = this.a;
            localIMiniAppContext = bjww.a(this.a);
            if (paramMessage.topType != 1) {
              break label452;
            }
          }
          for (paramMessage = "settop_on";; paramMessage = "settop_off")
          {
            bjww.a(localbjww, localIMiniAppContext, paramMessage);
            return false;
            i = 0;
            break;
          }
          paramMessage = bjww.a(this.a).getAttachedActivity();
        } while ((paramMessage == null) || (bjww.a(this.a).getMiniAppInfo() == null));
        bjyw.a(paramMessage, bjww.a(this.a).getMiniAppInfo());
        bjww.a(this.a, bjww.a(this.a), "add_desktop");
        return false;
        bjww.a(this.a, bjww.a(this.a));
        return false;
        paramMessage = bjww.a(this.a).getMiniAppInfo();
        if ((paramMessage == null) || (!paramMessage.isEngineTypeMiniApp())) {
          break;
        }
        paramMessage = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
      } while (!(paramMessage instanceof bjyg));
      paramMessage = (bjyg)paramMessage;
      bjww.a(this.a, paramMessage.a());
      return false;
    } while (!(bjww.a(this.a).getAttachedActivity() instanceof GameActivity1));
    paramMessage = ((GameActivity1)bjww.a(this.a).getAttachedActivity()).getColorNoteController();
    bjww.a(this.a, paramMessage);
    return false;
    bjww.a(this.a).performAction(ActionBridge.RestartActionBridge.obtain());
    return false;
    bjww.b(this.a, bjww.a(this.a));
    return false;
    bjww.c(this.a, bjww.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxb
 * JD-Core Version:    0.7.0.1
 */