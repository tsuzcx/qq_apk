import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.FavoritesActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.RestartActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.ShareActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DebugUtil;

class bkpi
  implements Handler.Callback
{
  bkpi(bkpb parambkpb) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MiniAppProxyImpl", 1, "handleMessage error, msg is null.");
      }
    }
    label480:
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
              if (bkpb.a(this.a) == null)
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
                bkpb.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(1, null));
                return false;
              case 1000: 
                this.a.a();
                return false;
              case 6: 
                bkpb.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(2, null));
                return false;
              case 7: 
                bkpb.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(3, null));
                return false;
              case 8: 
                bkpb.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(4, null));
                return false;
              case 13: 
                bkpb.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(5, paramMessage.getData()));
                return false;
              case 18: 
                bkpb.a(this.a).performAction(ActionBridge.FavoritesActionBridge.obtain(1, null));
                return false;
              case 3: 
                paramMessage = bkpb.a(this.a).getMiniAppInfo();
              }
            } while (paramMessage == null);
            if (DebugUtil.getDebugEnabled(paramMessage)) {
              DebugUtil.setDebugEnabled(paramMessage, false);
            }
            for (;;)
            {
              bkpb.a(bkpb.a(this.a));
              return false;
              DebugUtil.setDebugEnabled(paramMessage, true);
            }
            bkpb.a(ActionBridge.UpdateUIActionBridge.toggleMonitorPanel(bkpb.a(this.a)).booleanValue());
            return false;
            paramMessage = bkpb.a(this.a).getMiniAppInfo();
          } while (paramMessage == null);
          int i;
          bkpb localbkpb;
          IMiniAppContext localIMiniAppContext;
          if (paramMessage.topType == 0)
          {
            i = 1;
            paramMessage.topType = i;
            bkpb.a(this.a, paramMessage);
            localbkpb = this.a;
            localIMiniAppContext = bkpb.a(this.a);
            if (paramMessage.topType != 1) {
              break label480;
            }
          }
          for (paramMessage = "settop_on";; paramMessage = "settop_off")
          {
            bkpb.a(localbkpb, localIMiniAppContext, paramMessage);
            return false;
            i = 0;
            break;
          }
          paramMessage = bkpb.a(this.a).getAttachedActivity();
        } while ((paramMessage == null) || (bkpb.a(this.a).getMiniAppInfo() == null));
        bkrh.a(paramMessage, bkpb.a(this.a).getMiniAppInfo());
        bkpb.a(this.a, bkpb.a(this.a), "add_desktop");
        return false;
        bkpb.a(this.a, bkpb.a(this.a));
        return false;
        paramMessage = bkpb.a(this.a).getMiniAppInfo();
        if ((paramMessage == null) || (!paramMessage.isEngineTypeMiniApp())) {
          break;
        }
        paramMessage = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
      } while (!(paramMessage instanceof bkqp));
      paramMessage = (bkqp)paramMessage;
      bkpb.a(this.a, paramMessage.a());
      return false;
    } while (!(bkpb.a(this.a).getAttachedActivity() instanceof GameActivity1));
    paramMessage = ((GameActivity1)bkpb.a(this.a).getAttachedActivity()).getColorNoteController();
    bkpb.a(this.a, paramMessage);
    return false;
    bkpb.a(this.a).performAction(ActionBridge.RestartActionBridge.obtain());
    return false;
    bkpb.b(this.a, bkpb.a(this.a));
    return false;
    bkpb.c(this.a, bkpb.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkpi
 * JD-Core Version:    0.7.0.1
 */