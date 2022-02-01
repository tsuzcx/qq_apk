package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Message;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import java.util.List;
import mqq.os.MqqHandler;

class MultiForwardChatPie$1
  extends MqqHandler
{
  MultiForwardChatPie$1(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return;
    }
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof List)))
    {
      this.a.b((List)paramMessage.obj);
      if ((MultiForwardChatPie.b(this.a) != null) && (MultiForwardChatPie.b(this.a).size() != 0))
      {
        paramMessage = ChatActivityUtils.a(MultiForwardChatPie.b(this.a), this.a.ah, this.a.d);
        paramMessage = ChatActivityUtils.a(this.a.d, BaseApplicationImpl.getContext(), this.a.ah, paramMessage, -1L);
        MultiForwardChatPie.d(this.a).setVisibility(8);
        MultiForwardChatPie.a(this.a).setVisibility(0);
        MultiForwardChatPie.e(this.a).setVisibility(0);
        MultiForwardChatPie.f(this.a).a(MultiForwardChatPie.b(this.a), paramMessage);
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.doOnCreate, MultiMsg has been downloaded");
        }
      }
      else
      {
        MultiForwardChatPie.a(this.a, System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("MultiMsg_TAG", 2, "MultiForwardActivity.doOnCreate, start requestReceiveMultiMsg");
        }
        this.a.a();
        this.a.bn = new MultiForwardChatPie.1.1(this);
        MultiForwardChatPie.a(this.a).postDelayed(this.a.bn, 60000L);
        ThreadRegulator.a().b(1);
        paramMessage = MultiMsgManager.a();
        QQAppInterface localQQAppInterface = this.a.d;
        String str1 = this.a.bl;
        String str2 = this.a.d.getCurrentAccountUin();
        String str3 = this.a.ah.b;
        String str4 = this.a.ah.b;
        int i = this.a.ah.a;
        long l = this.a.bk;
        MultiForwardChatPie localMultiForwardChatPie = this.a;
        paramMessage.a(localQQAppInterface, str1, str2, str3, str4, i, l, 1035, localMultiForwardChatPie.s(MultiForwardChatPie.i(localMultiForwardChatPie)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.1
 * JD-Core Version:    0.7.0.1
 */