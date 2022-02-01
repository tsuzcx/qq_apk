package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper;
import com.tencent.mobileqq.apollo.model.IMessageForApollo;
import com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatActivityFacade$17$1
  implements ActionSheet.OnButtonClickListener
{
  ChatActivityFacade$17$1(ChatActivityFacade.17 param17) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ChatActivityFacade.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((((this.a.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))) && (((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() != null) && (((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null))
      {
        ((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        QQGamePubAIOHelper.a(((BaseActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a(), null, new ChatMessage[] { this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage });
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForArkApp)) {
          ArkTipsManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        if (((StructLongMessageDownloadProcessor.isPALongMsg(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
        {
          paramView = (MessageForStructing)this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          StructLongMessageDownloadProcessor.deleteTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uniseq);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof IMessageForApollo)) {
          ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).delMsg(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForFile))
        {
          paramView = FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(paramView.nSessionId);
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
        }
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isDebugVersion())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("del garyTips id[");
          localStringBuilder.append(paramView);
          localStringBuilder.append("],targetId[");
          localStringBuilder.append(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgUid);
          localStringBuilder.append("], hashCode:");
          localStringBuilder.append(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.hashCode());
          QLog.i("AIOMessageSpreadManager", 1, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty(paramView)) {
          try
          {
            long l = Long.parseLong(paramView);
            this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, l, true);
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            QLog.e("ChatActivityFacade", 1, paramView.toString());
          }
        }
        ((VasExtensionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      }
      else
      {
        ThreadManager.post(new ChatActivityFacade.17.1.1(this), 8, null, true);
      }
    }
    if (ChatActivityFacade.a != null) {
      ChatActivityFacade.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.17.1
 * JD-Core Version:    0.7.0.1
 */