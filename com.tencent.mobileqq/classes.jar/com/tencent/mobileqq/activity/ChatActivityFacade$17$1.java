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
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ChatActivityFacade.b(this.a.c, this.a.b);
      if ((((this.a.a instanceof SplashActivity)) || ((this.a.a instanceof ChatActivity))) && (((BaseActivity)this.a.a).getChatFragment() != null) && (((BaseActivity)this.a.a).getChatFragment().k() != null))
      {
        ((BaseActivity)this.a.a).getChatFragment().k().a(this.a.b);
        QQGamePubAIOHelper.a(((BaseActivity)this.a.a).getChatFragment().k(), null, new ChatMessage[] { this.a.b });
        if ((this.a.b instanceof MessageForArkApp)) {
          ArkTipsManager.b().a(this.a.b.uniseq);
        }
        if (((StructLongMessageDownloadProcessor.isPALongMsg(this.a.b)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(this.a.b))) && ((this.a.b instanceof MessageForStructing)))
        {
          paramView = (MessageForStructing)this.a.b;
          StructLongMessageDownloadProcessor.deleteTask(this.a.c, paramView.uniseq);
        }
        if ((this.a.b instanceof IMessageForApollo)) {
          ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).delMsg(this.a.a, this.a.c, this.a.b);
        }
        if ((this.a.b instanceof MessageForFile))
        {
          paramView = FileManagerUtil.a(this.a.c, (MessageForFile)this.a.b);
          this.a.c.getFileManagerEngine().c(paramView.nSessionId);
          ReportController.b(this.a.c, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
        }
        paramView = this.a.b.getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isDebugVersion())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("del garyTips id[");
          localStringBuilder.append(paramView);
          localStringBuilder.append("],targetId[");
          localStringBuilder.append(this.a.b.msgUid);
          localStringBuilder.append("], hashCode:");
          localStringBuilder.append(this.a.b.hashCode());
          QLog.i("AIOMessageSpreadManager", 1, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty(paramView)) {
          try
          {
            long l = Long.parseLong(paramView);
            this.a.c.getMessageFacade().b(this.a.b.frienduin, this.a.b.istroop, l, true);
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            QLog.e("ChatActivityFacade", 1, paramView.toString());
          }
        }
        ((VasExtensionManager)this.a.c.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).d.b(this.a.b);
      }
      else
      {
        ThreadManager.post(new ChatActivityFacade.17.1.1(this), 8, null, true);
      }
    }
    if (ChatActivityFacade.c != null) {
      ChatActivityFacade.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.17.1
 * JD-Core Version:    0.7.0.1
 */