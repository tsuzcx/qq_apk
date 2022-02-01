package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ActionMode.Callback;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.writetogether.api.IWTStartup;
import com.tencent.mobileqq.writetogether.api.IWriteTogetherConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public class WriteTogetherHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ActionMode.Callback jdField_a_of_type_AndroidViewActionMode$Callback;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  
  public WriteTogetherHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramBaseChatPie.jdField_a_of_type_AndroidContentContext;
    paramHelperProvider.a(this);
  }
  
  private String a()
  {
    String str2 = "";
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      str1 = str2;
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str1)) {}
      return str1;
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        }
      }
    }
  }
  
  public static void a(Context paramContext, BaseChatPie paramBaseChatPie, String paramString1, String paramString2, int paramInt)
  {
    FragmentActivity localFragmentActivity = null;
    if (paramBaseChatPie != null) {
      localFragmentActivity = paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    }
    ((IWTStartup)QRoute.api(IWTStartup.class)).launchEditor(paramContext, localFragmentActivity, paramString1, paramString2, paramInt, 18005);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    a(paramContext, null, paramString1, paramString2, paramInt);
  }
  
  private boolean b()
  {
    Object localObject = a();
    localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a((String)localObject, true);
    return (localObject != null) && (((TroopInfo)localObject).exitTroopReason == 0);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidViewActionMode$Callback != null) {}
    while (Build.VERSION.SDK_INT < 23) {
      return;
    }
    this.jdField_a_of_type_AndroidViewActionMode$Callback = new WriteTogetherHelper.1(this);
  }
  
  private void d()
  {
    ChatXListView localChatXListView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    localChatXListView.setSelectionFromBottom(localChatXListView.getCount() - 1, 0);
  }
  
  public ActionMode.Callback a()
  {
    c();
    return this.jdField_a_of_type_AndroidViewActionMode$Callback;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 18005) {}
    do
    {
      return;
      if ((paramInt2 & 0x1) == 0) {
        break;
      }
      if ((paramInt2 & 0x2) != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
      }
      if ((paramInt2 & 0x4) != 0)
      {
        paramIntent = (FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(24);
        if (paramIntent != null) {
          paramIntent.a(true);
        }
      }
    } while ((paramInt2 & 0x8) == 0);
    d();
    return;
    QLog.e("WriteTogetherHelper", 1, "[onActivityResult] failed code: " + paramInt2);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramString, a(), paramInt);
  }
  
  public boolean a()
  {
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    boolean bool = ((IWriteTogetherConfig)QRoute.api(IWriteTogetherConfig.class)).isAllowShowEntrance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localSessionInfo != null) && (bool)) {
      return (localSessionInfo.jdField_a_of_type_Int == 1) && (b());
    }
    return false;
  }
  
  public void b() {}
  
  public void b(String paramString, int paramInt)
  {
    String str = a();
    ((IWTStartup)QRoute.api(IWTStartup.class)).launchWriteTogetherEditor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString, paramInt, str, 18005);
  }
  
  public String getTag()
  {
    return "WriteTogetherHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 0) {
      a();
    }
    while (paramInt != 14) {
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.WriteTogetherHelper
 * JD-Core Version:    0.7.0.1
 */