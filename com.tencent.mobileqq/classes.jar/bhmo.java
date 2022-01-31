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

public class bhmo
{
  private static boolean a;
  
  private static String a(bglv parambglv)
  {
    return bgml.a(parambglv).a();
  }
  
  public static void a(bglv parambglv)
  {
    if (a)
    {
      QMLog.w("MorePanel", "Ignore. Already showing");
      return;
    }
    if (parambglv == null)
    {
      QMLog.w("MorePanel", "Failed to show. miniAppContext is null");
      return;
    }
    Activity localActivity = parambglv.a();
    if ((localActivity == null) || (localActivity.isFinishing()))
    {
      QMLog.w("MorePanel", "Failed to show. activity is null");
      return;
    }
    MiniAppInfo localMiniAppInfo = parambglv.a();
    if (localMiniAppInfo == null)
    {
      QMLog.w("MorePanel", "Failed to show. MiniAppInfo is null");
      return;
    }
    ShareState localShareState = bgmj.a(parambglv);
    if (localShareState == null)
    {
      QMLog.w("MorePanel", "Failed to show. shareState is null");
      return;
    }
    Intent localIntent = new Intent();
    Object localObject1 = new bhmn();
    ((bhmn)localObject1).a = localShareState.withShareQQ;
    ((bhmn)localObject1).b = localShareState.withShareQzone;
    ((bhmn)localObject1).c = localShareState.withShareWeChatFriend;
    ((bhmn)localObject1).d = localShareState.withShareWeChatMoment;
    ((bhmn)localObject1).e = localShareState.withShareOthers;
    ((bhmn)localObject1).f = localShareState.showDebug;
    ((bhmn)localObject1).g = localShareState.showMonitor;
    ((bhmn)localObject1).h = true;
    ((bhmn)localObject1).i = true;
    if (parambglv.b()) {}
    for (boolean bool = GameWnsUtils.showRestartButton();; bool = localShareState.showRestart)
    {
      ((bhmn)localObject1).j = bool;
      Object localObject2 = new bhmm().a((bhmn)localObject1);
      localObject1 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      localObject2 = ((MiniAppProxy)localObject1).getMoreItems((bhmm)localObject2);
      localIntent.putExtra("key_orientation_landscape", parambglv.c());
      localIntent.putExtra("key_mini_app_info", localMiniAppInfo);
      localIntent.putParcelableArrayListExtra("key_more_item_list", (ArrayList)localObject2);
      bgnk.a().a(new bhmp(localShareState, (MiniAppProxy)localObject1, parambglv));
      MiniTranslucentFragmentActivity.a(localActivity, localIntent, MoreFragment.class, 9527);
      a(parambglv, "open");
      a = true;
      return;
    }
  }
  
  private static void a(bglv parambglv, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    bhcn.a(parambglv.a(), bhcn.a(parambglv.a()), a(parambglv), "user_click", "more_button", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhmo
 * JD-Core Version:    0.7.0.1
 */