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

class bkyd
  implements Handler.Callback
{
  bkyd(bkxx parambkxx) {}
  
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
              if (bkxx.a(this.a) == null)
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
                bkxx.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(1, null));
                return false;
              case 1000: 
                this.a.a();
                return false;
              case 6: 
                bkxx.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(2, null));
                return false;
              case 7: 
                bkxx.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(3, null));
                return false;
              case 8: 
                bkxx.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(4, null));
                return false;
              case 13: 
                bkxx.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(5, paramMessage.getData()));
                return false;
              case 3: 
                paramMessage = bkxx.a(this.a).getMiniAppInfo();
              }
            } while (paramMessage == null);
            if (DebugUtil.getDebugEnabled(paramMessage)) {
              DebugUtil.setDebugEnabled(paramMessage, false);
            }
            for (;;)
            {
              bkxx.a(bkxx.a(this.a));
              return false;
              DebugUtil.setDebugEnabled(paramMessage, true);
            }
            bkxx.a(ActionBridge.UpdateUIActionBridge.toggleMonitorPanel(bkxx.a(this.a)).booleanValue());
            return false;
            paramMessage = bkxx.a(this.a).getMiniAppInfo();
          } while (paramMessage == null);
          int i;
          bkxx localbkxx;
          IMiniAppContext localIMiniAppContext;
          if (paramMessage.topType == 0)
          {
            i = 1;
            paramMessage.topType = i;
            bkxx.a(this.a, paramMessage);
            localbkxx = this.a;
            localIMiniAppContext = bkxx.a(this.a);
            if (paramMessage.topType != 1) {
              break label452;
            }
          }
          for (paramMessage = "settop_on";; paramMessage = "settop_off")
          {
            bkxx.a(localbkxx, localIMiniAppContext, paramMessage);
            return false;
            i = 0;
            break;
          }
          paramMessage = bkxx.a(this.a).getAttachedActivity();
        } while ((paramMessage == null) || (bkxx.a(this.a).getMiniAppInfo() == null));
        blaa.a(paramMessage, bkxx.a(this.a).getMiniAppInfo());
        bkxx.a(this.a, bkxx.a(this.a), "add_desktop");
        return false;
        bkxx.a(this.a, bkxx.a(this.a));
        return false;
        paramMessage = bkxx.a(this.a).getMiniAppInfo();
        if ((paramMessage == null) || (!paramMessage.isEngineTypeMiniApp())) {
          break;
        }
        paramMessage = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
      } while (!(paramMessage instanceof bkzk));
      paramMessage = (bkzk)paramMessage;
      bkxx.a(this.a, paramMessage.a());
      return false;
    } while (!(bkxx.a(this.a).getAttachedActivity() instanceof GameActivity1));
    paramMessage = ((GameActivity1)bkxx.a(this.a).getAttachedActivity()).getColorNoteController();
    bkxx.a(this.a, paramMessage);
    return false;
    bkxx.a(this.a).performAction(ActionBridge.RestartActionBridge.obtain());
    return false;
    bkxx.b(this.a, bkxx.a(this.a));
    return false;
    bkxx.c(this.a, bkxx.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyd
 * JD-Core Version:    0.7.0.1
 */