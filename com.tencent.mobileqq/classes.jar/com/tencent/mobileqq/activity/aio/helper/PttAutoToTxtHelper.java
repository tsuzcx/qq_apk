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
  private BaseChatPie a;
  private Handler b;
  
  public PttAutoToTxtHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.b = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private void a(ChatMessage paramChatMessage, String paramString)
  {
    paramString = new UniteGrayTipParam(paramChatMessage.frienduin, paramChatMessage.selfuin, paramString, this.a.ah.a, -5020, 655392, paramChatMessage.time);
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    if (paramChatMessage.istroop == 1) {
      localMessageForUniteGrayTip.shmsgseq = paramChatMessage.shmsgseq;
    }
    localMessageForUniteGrayTip.initGrayTipMsg(this.a.d, paramString);
    UniteGrayTipMsgUtil.a(this.a.d, localMessageForUniteGrayTip);
    QLog.e("vip_ptt.helper", 1, "It is need add gray msg and insert success");
  }
  
  private boolean a()
  {
    if ((QVipAutoPttProcessor.e().a <= 1) && (PttConstants.f)) {
      return QVipConfigManager.a(this.a.d, "have_add_ptt_gray_msg", false) ^ true;
    }
    return false;
  }
  
  private ChatMessage b()
  {
    List localList = this.a.V.a();
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
  
  public String getTag()
  {
    return "vip_ptt.helper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    paramMessage = (ChatMessage)paramMessage.obj;
    if (QVipAutoPttProcessor.e().a <= 1)
    {
      a(paramMessage, HardCodeUtil.a(2131906481));
      QVipConfigManager.b(this.a.d, "have_add_ptt_gray_msg", true);
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
        this.b.removeMessages(10102);
        return;
      }
      if (a())
      {
        QLog.e("vip_ptt.helper", 1, "It is need add gray msg");
        ChatMessage localChatMessage = b();
        if (localChatMessage == null)
        {
          QLog.e("vip_ptt.helper", 1, "It is need add gray msg,but this aio not ptt msg");
          return;
        }
        Handler localHandler = this.b;
        localHandler.sendMessage(localHandler.obtainMessage(10102, localChatMessage));
      }
    }
    else
    {
      QLog.e("vip_ptt.helper", 1, "SHOW_FIRST_BEGIN");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PttAutoToTxtHelper
 * JD-Core Version:    0.7.0.1
 */