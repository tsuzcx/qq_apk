package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgLoader;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.msglist.TroopListUI;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class OneClickJumpMsgFilter
  implements IMsgLoader
{
  public static int a = 0;
  public static long b = -1L;
  
  private void a(@NonNull AIOContext paramAIOContext, List<ChatMessage> paramList, TroopListUI paramTroopListUI, JumpState paramJumpState1, JumpState paramJumpState2, long paramLong)
  {
    if ((paramJumpState1 == JumpState.END) && ((paramJumpState2 == JumpState.GRAY_TIP_ABOVE) || (paramJumpState2 == JumpState.PULL_UP_FAILURE) || (paramJumpState2 == JumpState.JUMP_SUCCESS)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OneClickJumpMsgFilter", 2, "remove useless message from aioMsgPool when change JumpState into END");
      }
      OneClickJumpUtil.a(paramAIOContext.a());
      paramAIOContext.a().getMessageFacade().p().a(paramAIOContext.O().a).a(paramAIOContext.O().b, paramAIOContext.O().a, paramLong);
      paramAIOContext = paramList.iterator();
      while (paramAIOContext.hasNext()) {
        if (((ChatMessage)paramAIOContext.next()).shmsgseq < paramLong) {
          paramAIOContext.remove();
        }
      }
      paramTroopListUI.y().a(JumpState.END);
    }
  }
  
  private void a(@NonNull AIOContext paramAIOContext, List<ChatMessage> paramList, JumpState paramJumpState1, JumpState paramJumpState2, long paramLong)
  {
    int j = paramList.size();
    if ((paramJumpState1 == JumpState.JUMP_SUCCESS) && (paramJumpState2 == JumpState.INACTIVATED) && (b == -1L)) {
      b = paramAIOContext.e().f().a();
    }
    int i;
    if (paramJumpState1 == JumpState.JUMP_SUCCESS) {
      i = 1;
    } else {
      i = 0;
    }
    a = 0;
    int n = j - 1;
    j = n;
    int m;
    for (int k = 0; j >= 0; k = m)
    {
      paramAIOContext = (ChatMessage)paramList.get(j);
      if ((paramAIOContext.uniseq != b) && (a == 0))
      {
        m = k;
        if (ChatActivityUtils.a(paramAIOContext)) {
          m = k + 1;
        }
      }
      else
      {
        m = k;
        if (paramAIOContext.uniseq == b)
        {
          a = n - j - k;
          a = Math.max(0, a);
          m = k;
        }
      }
      if ((i != 0) && (paramAIOContext.shmsgseq >= paramLong))
      {
        paramAIOContext = (ChatMessage)paramList.remove(j);
        if (QLog.isColorLevel()) {
          QLog.d("OneClickJumpMsgFilter", 2, new Object[] { "hideSomeLatestMessage remove aio list msg shmsgseq: ", Long.valueOf(paramAIOContext.shmsgseq) });
        }
      }
      else
      {
        if (paramAIOContext.shmsgseq < paramLong) {
          break;
        }
      }
      j -= 1;
    }
    if (QLog.isColorLevel())
    {
      paramAIOContext = new StringBuilder();
      paramAIOContext.append("UNREAD_COUNT = ");
      paramAIOContext.append(a);
      QLog.d("OneClickJumpMsgFilter", 2, paramAIOContext.toString());
    }
  }
  
  public boolean a(@NonNull AIOContext paramAIOContext, boolean paramBoolean, List<ChatMessage> paramList)
  {
    AioTips localAioTips = paramAIOContext.e().d().f();
    Object localObject = paramAIOContext.e().b();
    if ((localObject instanceof TroopListUI))
    {
      if (localAioTips == null) {
        return false;
      }
      localObject = (TroopListUI)localObject;
      if (((TroopListUI)localObject).y() == null) {
        return false;
      }
      JumpState localJumpState1 = ((TroopListUI)localObject).y().a();
      JumpState localJumpState2 = ((TroopListUI)localObject).y().b();
      long l = localAioTips.h;
      a(paramAIOContext, paramList, localJumpState1, localJumpState2, l);
      a(paramAIOContext, paramList, (TroopListUI)localObject, localJumpState1, localJumpState2, l);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.OneClickJumpMsgFilter
 * JD-Core Version:    0.7.0.1
 */