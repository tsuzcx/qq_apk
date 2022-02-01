package com.tencent.mobileqq.activity;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QQGamePubAIOHelper;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.utils.VipUtils;
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
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (ChatActivityFacade.a != null) {
        ChatActivityFacade.a.dismiss();
      }
      return;
      ChatActivityFacade.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      if ((((this.a.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) || ((this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity))) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment() != null) && (((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a() != null))
      {
        ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        QQGamePubAIOHelper.a(((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a(), null, new ChatMessage[] { this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage });
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForArkApp)) {
          ArkTipsManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
        }
        if (((StructLongMessageDownloadProcessor.isPALongMsg(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage))) && ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)))
        {
          paramView = (MessageForStructing)this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          StructLongMessageDownloadProcessor.deleteTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView.uniseq);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForApollo))
        {
          paramView = (MessageForApollo)this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
          if (paramView != null)
          {
            ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopTaskByMsg(paramView.uniseq, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "del_msg");
            if ((paramView.mApolloMessage != null) && ((this.a.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)))
            {
              BaseChatPie localBaseChatPie = ((FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext).getChatFragment().a();
              if ((localBaseChatPie != null) && (localBaseChatPie.a != null)) {
                VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "del_success", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localBaseChatPie.a.a), 0, new String[] { Integer.toString(paramView.mApolloMessage.id) });
              }
            }
          }
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForFile))
        {
          paramView = FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(paramView.nSessionId);
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
        }
        paramView = this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isDebugVersion()) {
          QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + paramView + "],targetId[" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.msgUid + "], hashCode:" + this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.hashCode());
        }
        if (TextUtils.isEmpty(paramView)) {}
      }
      try
      {
        long l = Long.parseLong(paramView);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop, l, true);
        ((VasExtensionManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
        continue;
        ThreadManager.post(new ChatActivityFacade.17.1.1(this), 8, null, true);
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          paramView.printStackTrace();
          QLog.e("ChatActivityFacade", 1, paramView.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.17.1
 * JD-Core Version:    0.7.0.1
 */