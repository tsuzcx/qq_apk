import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.triton.sdk.APICallback;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import com.tencent.mobileqq.triton.sdk.ITSubPackage;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.plugins.QQFriendJsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy;
import java.util.HashMap;
import java.util.Map;

public class bdpe
  implements APIProxy
{
  private ITTEngine a;
  
  public bdpe(ITTEngine paramITTEngine)
  {
    this.a = paramITTEngine;
  }
  
  private void a(long paramLong, int paramInt)
  {
    bdsu.a(bdqa.a().a(), 1027, null, null, null, paramInt, "1", paramLong, null);
  }
  
  public void doAddFriend(Context paramContext, String paramString, APICallback paramAPICallback)
  {
    QQFriendJsPlugin.doAddFriend(paramContext, bdqa.a().a(), paramString, new bdpk(this, paramAPICallback));
  }
  
  public void getUserInfo(boolean paramBoolean, String paramString, APICallback paramAPICallback)
  {
    bdnw.b("APIProxyImpl", "getUserInfo " + bdqa.a().a());
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (!MiniAppEnv.g().getAuthSate(bdqa.a().a()).a("scope.userInfo"))
    {
      bdqe.a().a(bdqa.a().a(), "scope.userInfo", new bdph(this, localChannelProxy, paramBoolean, paramString, paramAPICallback));
      return;
    }
    bdnw.b("APIProxyImpl", "getUserInfo directly");
    localChannelProxy.getUserInfo(bdqa.a().a(), paramBoolean, paramString, new bdpj(this, paramAPICallback));
  }
  
  public void gotoPermissionSetting(Activity paramActivity)
  {
    bddu.a(paramActivity, bdqa.a().a(), bdqa.a().c(), 5);
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
      paramString4.request(paramString1, paramString3, localHashMap, paramString2, 60, new bdpf(this, l, paramLong));
      return;
    }
  }
  
  public void loadSubPackage(long paramLong1, long paramLong2, String paramString, ITSubPackage paramITSubPackage)
  {
    bdpy localbdpy = bdqa.a().a();
    if (localbdpy != null)
    {
      bdrb.a().i("subpackage", "start loadSubPackage:" + paramString + ", gameId:" + localbdpy.d + ", gameName:" + localbdpy.c);
      localbdpy.a(paramString, new bdpg(this, paramString, paramITSubPackage, paramLong1, paramLong2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpe
 * JD-Core Version:    0.7.0.1
 */