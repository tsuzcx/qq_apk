package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.PttConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.vas.vip.QVipConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class PttAutoToTxtHelper
  implements Handler.Callback, ILifeCycleHelper
{
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  
  public PttAutoToTxtHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private ChatMessage a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    Iterator localIterator = localList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SHOW_FIRST:");
        localStringBuilder.append(localChatMessage.msgtype);
        QLog.d("vip_ptt.helper", 1, localStringBuilder.toString());
      }
      if (localChatMessage.msgtype == -2002)
      {
        QLog.e("vip_ptt.helper", 1, "SHOW_FIRST find the ptt msg");
        i = 1;
      }
    }
    if (i != 0) {
      return (ChatMessage)localList.get(localList.size() - 1);
    }
    return null;
  }
  
  private void a(ChatMessage paramChatMessage, String paramString)
  {
    paramString = new UniteGrayTipParam(paramChatMessage.frienduin, paramChatMessage.selfuin, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, -5020, 655392, paramChatMessage.time);
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    if (paramChatMessage.istroop == 1) {
      localMessageForUniteGrayTip.shmsgseq = paramChatMessage.shmsgseq;
    }
    localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
    QLog.e("vip_ptt.helper", 1, "It is need add gray msg and insert success");
  }
  
  private boolean a()
  {
    if ((QVipAutoPttProcessor.c().a <= 1) && (PttConstants.c)) {
      return QVipConfigManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_add_ptt_gray_msg", false) ^ true;
    }
    return false;
  }
  
  public String getTag()
  {
    return "vip_ptt.helper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    paramMessage = (ChatMessage)paramMessage.obj;
    if (QVipAutoPttProcessor.c().a <= 1)
    {
      a(paramMessage, HardCodeUtil.a(2131708700));
      QVipConfigManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_add_ptt_gray_msg", true);
    }
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 9, 12 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 8)
    {
      if (paramInt != 9)
      {
        if (paramInt != 12) {
          return;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(10102);
        return;
      }
      if (a())
      {
        QLog.e("vip_ptt.helper", 1, "It is need add gray msg");
        ChatMessage localChatMessage = a();
        if (localChatMessage == null)
        {
          QLog.e("vip_ptt.helper", 1, "It is need add gray msg,but this aio not ptt msg");
          return;
        }
        Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
        localHandler.sendMessage(localHandler.obtainMessage(10102, localChatMessage));
      }
    }
    else
    {
      QLog.e("vip_ptt.helper", 1, "SHOW_FIRST_BEGIN");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PttAutoToTxtHelper
 * JD-Core Version:    0.7.0.1
 */