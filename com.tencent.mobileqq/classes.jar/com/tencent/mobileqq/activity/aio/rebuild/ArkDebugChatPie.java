package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.debug.JSDebuggerSoLoader;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkDebugChatPie
  extends BaseChatPie
{
  private ArkAiAppPanel a;
  private QQCustomDialog b;
  private String f;
  private String g;
  
  public ArkDebugChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel = null;
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    bi();
    if ((BaseActivity.sTopActivity instanceof ArkFullScreenAppActivity)) {
      ((ArkFullScreenAppActivity)BaseActivity.sTopActivity).finish();
    }
    an();
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel = null;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_b_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    paramQQAppInterface.getMessageFacade().a(paramSessionInfo);
    return true;
  }
  
  private static void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
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
  }
  
  private void bi()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str, i);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().e(str, i);
    ArkAioContainerWrapper.a(2);
  }
  
  private void bj()
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
  
  private void i(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public void J()
  {
    ArkAppCenter.a(new ArkDebugChatPie.2(this));
    super.J();
  }
  
  public void N()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().clearFlags(128);
    super.N();
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addFlags(128);
    JSDebuggerSoLoader.a(2, null);
    ArkAppCenter.b(true);
    ArkAppCenter.a(new ArkDebugChatPie.1(this));
    return super.a(paramBoolean);
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "ArkDebugChatPie";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie
 * JD-Core Version:    0.7.0.1
 */