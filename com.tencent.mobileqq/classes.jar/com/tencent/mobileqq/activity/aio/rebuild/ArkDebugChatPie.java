package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.FullCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.ArkAiAppPanel;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkDebugChatPie
  extends BaseChatPie
{
  private String bi;
  private String bj;
  private QQCustomDialog bk = null;
  private ArkAiAppPanel bl = null;
  private final String bm = ((IArkEnvironment)QRoute.api(IArkEnvironment.class)).getAppDebugInstallDirectory();
  
  public ArkDebugChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void a()
  {
    Object localObject = this.bk;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.bk = null;
    }
    bz();
    if ((BaseActivity.sTopActivity instanceof ArkFullScreenAppActivity)) {
      ((ArkFullScreenAppActivity)BaseActivity.sTopActivity).finish();
    }
    aw();
    localObject = this.bl;
    if (localObject != null)
    {
      ((ArkAiAppPanel)localObject).d();
      this.bl = null;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.b, paramSessionInfo.c, paramSessionInfo.a, paramArkAppMessage);
    paramQQAppInterface.getMessageFacade().a(paramSessionInfo);
    return true;
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      if (!paramJSONObject.has("forward")) {
        paramJSONObject.put("forward", 1);
      }
      if (!paramJSONObject.has("autosize"))
      {
        paramJSONObject.put("autosize", 1);
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  private void bA()
  {
    long l = NetConnInfoCenter.getServerTime();
    RecentUserProxy localRecentUserProxy = this.d.getProxyManager().g();
    RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.ARK_DEBUG_UIN, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localRecentUserProxy.b(localRecentUser);
    if ((localRecentUserProxy instanceof FullCache)) {
      ((FullCache)localRecentUserProxy).updateCache(localRecentUser);
    }
  }
  
  private void bz()
  {
    String str = this.ah.b;
    int i = this.ah.a;
    this.d.getMessageFacade().c(str, i);
    this.d.getMessageFacade().g(str, i);
    ArkAioContainerWrapper.a(2);
  }
  
  private void e(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public void K()
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToLogicThread(new ArkDebugChatPie.2(this));
    super.K();
  }
  
  public void O()
  {
    this.f.getWindow().clearFlags(128);
    super.O();
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.f.getWindow().addFlags(128);
    JSDebuggerSoLoader.a(2, null);
    ArkMultiProcUtil.a();
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToLogicThread(new ArkDebugChatPie.1(this));
    return super.a(paramBoolean);
  }
  
  protected void h()
  {
    this.c = "ArkDebugChatPie";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie
 * JD-Core Version:    0.7.0.1
 */