package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IHeadMsgRefresher;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.TroopMessageManager.UserActionStateInParallelPullPeriod;
import com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class AttentionHeadMsgRefresher
  implements Handler.Callback, IHeadMsgRefresher
{
  private Scroller jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistScroller;
  private TroopMessageManager.UserActionStateInParallelPullPeriod jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  
  public void a(AIOContext paramAIOContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.d == TroopMessageManager.UserActionStateInParallelPullPeriod.c) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a != null)) {
        paramAIOContext.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a.c, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a.a(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a.d, null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AttentionHeadMsgRefresh.trooptroop_pull_msg", 2, "update,mUserActionState.actionType" + this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.d);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod = null;
      paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().deleteObservers();
    }
  }
  
  public void a(AIOContext paramAIOContext, int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, Runnable paramRunnable)
  {
    Scroller localScroller = paramAIOContext.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistScroller = localScroller;
    MessageRecord localMessageRecord = paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().d(paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong1);
    if ((localMessageRecord != null) && (paramInt2 <= 200))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AttentionHeadMsgRefresh.troop.special_msg", 2, "refreshHeadMessage==>unreadMsgCount:" + paramInt2 + ", fistseq:" + paramLong2 + ", mr.shmsgseq:" + localMessageRecord.shmsgseq);
      }
      if ((int)paramLong2 >= localMessageRecord.shmsgseq + 1L)
      {
        localScroller.a(paramLong2, localMessageRecord.shmsgseq, false);
        localScroller.a(paramInt1, 0, -1, paramRunnable, this.jdField_a_of_type_MqqOsMqqHandler, 6);
      }
    }
    do
    {
      do
      {
        return;
        paramInt2 = paramAIOContext.a().a().c(paramLong1);
      } while (paramInt2 == -1);
      localScroller.a(paramInt1, paramInt2, paramInt2, null, this.jdField_a_of_type_MqqOsMqqHandler, 6);
      return;
      boolean bool = paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().c(paramAIOContext.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("AttentionHeadMsgRefresh.trooptroop_pull_msg", 2, "所要定位的消息还没拉回来本地，并发拉取中...mUserActionState create, natvigateSeq:" + paramLong1 + ",isAioParallelPullMsgDone:" + bool);
      }
      if (!bool) {
        break;
      }
      if ((int)paramLong2 >= 1L + paramLong1)
      {
        localScroller.a(paramLong2, paramLong1, false);
        localScroller.a(paramInt1, 0, -1, paramRunnable, this.jdField_a_of_type_MqqOsMqqHandler, 6);
        return;
      }
      paramInt2 = paramAIOContext.a().a().c(paramLong1);
    } while (paramInt2 == -1);
    localScroller.a(paramInt1, paramInt2, paramInt2, null, this.jdField_a_of_type_MqqOsMqqHandler, 6);
    return;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod = new TroopMessageManager.UserActionStateInParallelPullPeriod();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.d = TroopMessageManager.UserActionStateInParallelPullPeriod.c;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a = TroopAioAgent.Message.a(paramInt1, paramLong1, paramInt2);
    paramAIOContext.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().addObserver(paramAIOContext.a());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 50) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistScroller.a()))
    {
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreuiMsglistScroller.a();
      if (paramMessage.a.get()) {
        paramMessage.a.set(false);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.AttentionHeadMsgRefresher
 * JD-Core Version:    0.7.0.1
 */