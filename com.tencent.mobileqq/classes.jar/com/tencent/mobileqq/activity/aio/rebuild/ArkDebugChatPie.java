package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.ark.ArkAiAppPanel;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import java.io.File;
import vnk;
import vns;

public class ArkDebugChatPie
  extends BaseChatPie
{
  private ArkAiAppPanel a;
  private QQCustomDialog c;
  private final String f = "ArkDebugChatPie";
  private String g;
  private String h;
  
  public ArkDebugChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    super(paramQQAppInterface, paramViewGroup, paramFragmentActivity, paramContext);
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ArkAppMessage paramArkAppMessage)
  {
    paramSessionInfo = MessageRecordFactory.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.b, paramSessionInfo.jdField_a_of_type_Int, paramArkAppMessage);
    paramQQAppInterface.a().b(paramSessionInfo, paramQQAppInterface.getCurrentAccountUin());
    return true;
  }
  
  private void aX()
  {
    if (this.c != null)
    {
      this.c.dismiss();
      this.c = null;
    }
    aY();
    if ((BaseActivity.sTopActivity instanceof ArkFullScreenAppActivity)) {
      ((ArkFullScreenAppActivity)BaseActivity.sTopActivity).finish();
    }
    ai();
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel.c();
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppPanel = null;
    }
  }
  
  private void aY()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, i);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(str, i);
  }
  
  private void aZ()
  {
    long l = NetConnInfoCenter.getServerTime();
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    RecentUser localRecentUser = localRecentUserProxy.a(AppConstants.aD, 1031);
    if (localRecentUser.lastmsgtime < l) {
      localRecentUser.lastmsgtime = l;
    }
    localRecentUserProxy.a(localRecentUser);
    localRecentUserProxy.b(localRecentUser);
  }
  
  private void e(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  protected void D()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().clearFlags(128);
    super.D();
  }
  
  protected boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addFlags(128);
    ArkAppCenter.a(true);
    ArkDispatchTask.getInstance().post(new vnk(this));
    return super.a(paramBoolean);
  }
  
  protected void z()
  {
    ArkDispatchTask.getInstance().post(new vns(this));
    super.z();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ArkDebugChatPie
 * JD-Core Version:    0.7.0.1
 */