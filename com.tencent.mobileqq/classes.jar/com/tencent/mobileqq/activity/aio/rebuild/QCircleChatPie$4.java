package com.tencent.mobileqq.activity.aio.rebuild;

import ahkr;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleChatUtil;
import java.util.List;

public class QCircleChatPie$4
  implements Runnable
{
  public QCircleChatPie$4(ahkr paramahkr) {}
  
  public void run()
  {
    List localList = this.this$0.app.getMessageFacade().getAllMessages(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, null, 500);
    if (localList != null) {
      ahkr.a(this.this$0, localList.size());
    }
    if ((localList != null) && (localList.size() > 0))
    {
      ahkr.b(this.this$0, (MessageRecord)localList.get(0));
      ahkr.a(this.this$0, (MessageRecord)localList.get(localList.size() - 1));
    }
    if ((QCircleChatUtil.filterFuelTipsGrayMessage(this.this$0.app, this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, localList)) && (!TextUtils.isEmpty(ahkr.a(this.this$0))))
    {
      ahkr.a(this.this$0, QCircleChatUtil.addShowFuelTipsGrayMessage(this.this$0.app, this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, ahkr.a(this.this$0), ahkr.a(this.this$0)));
      QLog.d(this.this$0.tag, 2, "showFuelTips:" + ahkr.a(this.this$0));
    }
    ahkr.a(this.this$0, this.this$0.sessionInfo.curFriendUin);
    if (!QCircleChatUtil.getIceBreakMsgHasShownFromSp(this.this$0.app, this.this$0.sessionInfo.curFriendUin))
    {
      QLog.d(this.this$0.tag, 2, "showIceBreakMessage");
      ahkr.a(this.this$0, QCircleChatUtil.addIceBreakMessage(this.this$0.app, this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, ahkr.a(this.this$0), ahkr.b(this.this$0)));
      if (ahkr.a(this.this$0) != null) {
        QCircleChatUtil.setIceBreakMsgHasShownToSp(this.this$0.app, this.this$0.sessionInfo.curFriendUin);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.tag, 2, "mAllMsgCount " + ahkr.b(this.this$0));
    }
    this.this$0.refresh(65536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.4
 * JD-Core Version:    0.7.0.1
 */