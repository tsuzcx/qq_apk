import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.ui.MiniTranslucentFragmentActivity;
import com.tencent.qqmini.sdk.ui.MoreFragment;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;
import java.util.ArrayList;

public class bhih
{
  private static boolean a;
  
  private static String a(bgho parambgho)
  {
    return bgie.a(parambgho).a();
  }
  
  public static void a(bgho parambgho)
  {
    if (a)
    {
      QMLog.w("MorePanel", "Ignore. Already showing");
      return;
    }
    if (parambgho == null)
    {
      QMLog.w("MorePanel", "Failed to show. miniAppContext is null");
      return;
    }
    Activity localActivity = parambgho.a();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      QMLog.w("MorePanel", "Failed to show. activity is null");
      return;
    }
    MiniAppInfo localMiniAppInfo = parambgho.a();
    if (localMiniAppInfo == null)
    {
      QMLog.w("MorePanel", "Failed to show. MiniAppInfo is null");
      return;
    }
    ShareState localShareState = bgic.a(parambgho);
    if (localShareState == null)
    {
      QMLog.w("MorePanel", "Failed to show. shareState is null");
      return;
    }
    Intent localIntent = new Intent();
    Object localObject1 = new bhig();
    ((bhig)localObject1).a = localShareState.withShareQQ;
    ((bhig)localObject1).b = localShareState.withShareQzone;
    ((bhig)localObject1).c = localShareState.withShareWeChatFriend;
    ((bhig)localObject1).d = localShareState.withShareWeChatMoment;
    ((bhig)localObject1).e = localShareState.withShareOthers;
    ((bhig)localObject1).f = localShareState.showDebug;
    ((bhig)localObject1).g = localShareState.showMonitor;
    ((bhig)localObject1).h = true;
    ((bhig)localObject1).i = true;
    if (parambgho.b()) {}
    for (boolean bool = GameWnsUtils.showRestartButton();; bool = localShareState.showRestart)
    {
      ((bhig)localObject1).j = bool;
      Object localObject2 = new bhif().a((bhig)localObject1);
      localObject1 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      localObject2 = ((MiniAppProxy)localObject1).getMoreItems((bhif)localObject2);
      localIntent.putExtra("key_orientation_landscape", parambgho.c());
      localIntent.putExtra("key_mini_app_info", localMiniAppInfo);
      localIntent.putParcelableArrayListExtra("key_more_item_list", (ArrayList)localObject2);
      bgjd.a().a(new bhii(localShareState, (MiniAppProxy)localObject1, parambgho));
      MiniTranslucentFragmentActivity.a(localActivity, localIntent, MoreFragment.class, 9527);
      a(parambgho, "open");
      a = true;
      return;
    }
  }
  
  private static void a(bgho parambgho, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    bgyg.a(parambgho.a(), bgyg.a(parambgho.a()), a(parambgho), "user_click", "more_button", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhih
 * JD-Core Version:    0.7.0.1
 */