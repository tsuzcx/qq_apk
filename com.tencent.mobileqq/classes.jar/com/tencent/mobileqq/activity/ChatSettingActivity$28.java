package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.DeleteRecordDialog.OnDeleteRecordDialogClickListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;
import mqq.os.MqqHandler;

final class ChatSettingActivity$28
  implements DeleteRecordDialog.OnDeleteRecordDialogClickListener
{
  ChatSettingActivity$28(ChatSettingActivity.DeleteHistoryListener paramDeleteHistoryListener, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Activity paramActivity) {}
  
  public void a(Dialog paramDialog, View paramView, boolean paramBoolean)
  {
    paramDialog = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener;
    if (paramDialog != null)
    {
      if (paramBoolean)
      {
        paramDialog.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    }
    Object localObject = new StringBuilder();
    paramView = (MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    paramView.a(this.jdField_a_of_type_JavaLangString);
    int i = paramView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, (StringBuilder)localObject);
    paramDialog = null;
    if (((StringBuilder)localObject).length() > 0) {
      paramDialog = ((StringBuilder)localObject).toString();
    }
    if (i <= 0)
    {
      QQToast.a(BaseApplication.getContext(), 2, 2131691483, 1).a();
      paramDialog = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener;
      if (paramDialog != null) {
        paramDialog.a(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      long l1;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        if (((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).isSendFromLocal()) {
          l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time + 2L;
        } else {
          l1 = ((MessageRecord)((List)localObject).get(((List)localObject).size() - 1)).time;
        }
      }
      else {
        l1 = 0L;
      }
      if (FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int))
      {
        FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true, false);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      }
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "chat_history_c2c_start_del_msg");
      if (paramBoolean)
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(BaseApplication.getContext(), 2131691480, 1).a();
          return;
        }
        ((MessageRoamManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER)).i();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
        paramView.n();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      if (paramDialog != null)
      {
        long l2;
        try
        {
          l2 = Long.parseLong(paramDialog);
        }
        catch (Exception paramDialog)
        {
          paramDialog.printStackTrace();
          l2 = 0L;
        }
        l1 = Math.max(l2, l1);
        if (l1 > 0L) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, l1);
        }
      }
      paramView.a().c();
      paramView.b();
      if (paramBoolean) {
        paramView.n();
      }
      paramDialog = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (paramDialog != null)
      {
        paramView = paramDialog.obtainMessage(1017);
        paramView.obj = this.jdField_a_of_type_JavaLangString;
        paramView.arg1 = this.jdField_a_of_type_Int;
        paramDialog.sendMessage(paramView);
      }
      paramDialog = this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingActivity$DeleteHistoryListener;
      if (paramDialog != null) {
        paramDialog.a(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.28
 * JD-Core Version:    0.7.0.1
 */