import com.tencent.mobileqq.mini.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.1;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.2;
import com.tencent.qqmini.proxyimpl.ColorNotePlugin.3;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

@JsPlugin
public class bkxc
  extends BaseJsPlugin
{
  private void a(boolean paramBoolean, RequestEvent paramRequestEvent)
  {
    if (this.mMiniAppInfo.isLimitedAccessApp())
    {
      paramRequestEvent.fail();
      return;
    }
    Object localObject;
    if (this.mIsMiniGame)
    {
      if ((this.mMiniAppContext.getAttachedActivity() == null) || (!(this.mMiniAppContext.getAttachedActivity() instanceof GameActivity1))) {
        break label180;
      }
      localObject = ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
    }
    for (;;)
    {
      if (localObject != null)
      {
        if (!((aqre)localObject).c())
        {
          if (((aqre)localObject).b())
          {
            if (paramBoolean)
            {
              AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.1(this, (aqre)localObject, paramRequestEvent));
              return;
              localObject = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
              if ((localObject instanceof bkzk)) {
                localObject = ((bkzk)localObject).a();
              }
            }
            else
            {
              AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.2(this, (aqre)localObject, paramRequestEvent));
            }
          }
          else {
            AppBrandTask.runTaskOnUiThread(new ColorNotePlugin.3(this, (aqre)localObject, paramRequestEvent));
          }
        }
        else {
          paramRequestEvent.ok();
        }
      }
      else
      {
        paramRequestEvent.fail();
        return;
      }
      label180:
      localObject = null;
    }
  }
  
  @JsEvent({"addColorSign"})
  public void addColorSign(RequestEvent paramRequestEvent)
  {
    a(false, paramRequestEvent);
  }
  
  @JsEvent({"addColorSignDirectly"})
  public void addColorSignDirectly(RequestEvent paramRequestEvent)
  {
    a(true, paramRequestEvent);
  }
  
  @JsEvent({"isColorSignExistSync"})
  public String isColorSignExistSync(RequestEvent paramRequestEvent)
  {
    new JSONObject();
    aqre localaqre;
    if (this.mIsMiniGame)
    {
      if ((this.mMiniAppContext.getAttachedActivity() == null) || (!(this.mMiniAppContext.getAttachedActivity() instanceof GameActivity1))) {
        break label142;
      }
      localaqre = ((GameActivity1)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
    }
    for (;;)
    {
      if ((localaqre != null) && (localaqre.c()))
      {
        return ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
        if ((this.mMiniAppContext.getAttachedActivity() != null) && ((this.mMiniAppContext.getAttachedActivity() instanceof AppBrandUI))) {
          localaqre = ((AppBrandUI)this.mMiniAppContext.getAttachedActivity()).getColorNoteController();
        }
      }
      else
      {
        return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
      }
      label142:
      localaqre = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxc
 * JD-Core Version:    0.7.0.1
 */