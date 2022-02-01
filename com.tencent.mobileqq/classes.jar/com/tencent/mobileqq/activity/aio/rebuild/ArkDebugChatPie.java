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
  private ArkAiAppPanel jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel = null;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private String d;
  private String e;
  private final String f = ((IArkEnvironment)QRoute.api(IArkEnvironment.class)).getAppDebugInstallDirectory();
  
  public ArkDebugChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, BaseActivity paramBaseActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramBaseActivity, paramContext);
  }
  
  private void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    ao();
    if ((BaseActivity.sTopActivity instanceof ArkFullScreenAppActivity)) {
      ((ArkFullScreenAppActivity)BaseActivity.sTopActivity).finish();
    }
    Q();
    localObject = this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel;
    if (localObject != null)
    {
      ((ArkAiAppPanel)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel = null;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    paramQQAppInterface.getMessageFacade().a(paramSessionInfo);
    return true;
  }
  
  private void ao()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str, i);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(str, i);
    ArkAioContainerWrapper.a(2);
  }
  
  private void ap()
  {
    long l = NetConnInfoCenter.getServerTime();
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.ARK_DEBUG_UIN, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localRecentUserProxy.b(localRecentUser);
    if ((localRecentUserProxy instanceof FullCache)) {
      ((FullCache)localRecentUserProxy).updateCache(localRecentUser);
    }
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
  
  private void d(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(128);
    JSDebuggerSoLoader.a(2, null);
    ArkMultiProcUtil.a();
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToLogicThread(new ArkDebugChatPie.1(this));
    return super.a(paramBoolean);
  }
  
  protected void c()
  {
    this.b = "ArkDebugChatPie";
  }
  
  public void p()
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToLogicThread(new ArkDebugChatPie.2(this));
    super.p();
  }
  
  public void u()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
    super.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie
 * JD-Core Version:    0.7.0.1
 */