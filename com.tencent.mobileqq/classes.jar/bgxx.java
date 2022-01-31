import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.APICallback;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import com.tencent.qqmini.sdk.core.plugins.QQFriendJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.minigame.GameRuntimeLoader;
import java.util.HashMap;
import java.util.Map;

public class bgxx
  implements APIProxy
{
  private GameRuntimeLoader a;
  
  public bgxx(GameRuntimeLoader paramGameRuntimeLoader)
  {
    this.a = paramGameRuntimeLoader;
  }
  
  private void a(long paramLong, int paramInt)
  {
    bhck.a(this.a.getGameInfoManager().a(), 1027, null, null, null, paramInt, "1", paramLong, null);
  }
  
  public void doAddFriend(Context paramContext, String paramString, APICallback paramAPICallback)
  {
    QQFriendJsPlugin.doAddFriend(paramContext, this.a.getGameInfoManager().a(), paramString, new bgxz(this, paramAPICallback));
  }
  
  public void gotoPermissionSetting(Activity paramActivity)
  {
    ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).openPermissionSettingsActivity(paramActivity, this.a.getGameInfoManager().a(), this.a.getGameInfoManager().c());
  }
  
  public void httpRequestForImage(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramString2 == null) || ("".equals(paramString2))) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if (paramArrayOfString != null)
    {
      String str = null;
      int i = 0;
      if (i < paramArrayOfString.length)
      {
        if (i % 2 == 0) {
          str = paramArrayOfString[i];
        }
        for (;;)
        {
          i += 1;
          break;
          localHashMap.put(str, paramArrayOfString[i]);
        }
      }
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localHashMap.put("Referer", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localHashMap.put("Cookie", paramString5);
    }
    paramString4 = (RequestProxy)ProxyManager.get(RequestProxy.class);
    long l = System.currentTimeMillis();
    if (paramString3 != null) {}
    for (paramString3 = paramString3.getBytes();; paramString3 = null)
    {
      paramString4.request(paramString1, paramString3, localHashMap, paramString2, 60, new bgxy(this, l, paramLong, paramString1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxx
 * JD-Core Version:    0.7.0.1
 */