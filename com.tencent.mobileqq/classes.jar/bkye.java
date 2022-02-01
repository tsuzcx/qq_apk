import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.shell.IAppBrandProxy;

final class bkye
  implements Action<Object>
{
  public Object perform(BaseRuntime paramBaseRuntime)
  {
    AppLoaderFactory.g().getAppBrandProxy().onAppDestroy(paramBaseRuntime.getMiniAppInfo(), (Bundle)null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkye
 * JD-Core Version:    0.7.0.1
 */