package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.rebuild.PAContext;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class PAMsgListRefresher
  extends MsgListRefresher
{
  private long c = 9223372036854775807L;
  
  public PAMsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public int a(int paramInt)
  {
    if ((PublicAccountChatPie.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (((PAContext)this.a).h())) {
      return 0;
    }
    return super.a(paramInt);
  }
  
  public void a(int paramInt)
  {
    int i = 0xFFFF0000 & paramInt;
    super.a(paramInt);
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    QQAppInterface localQQAppInterface = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject == null) || (((SessionInfo)localObject).jdField_a_of_type_JavaLangString == null)) {
      return;
    }
    localObject = localQQAppInterface.getMessageFacade().a(((SessionInfo)localObject).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject).jdField_a_of_type_Int);
    if (((i == 196608) || (i == 131072)) && (((List)localObject).size() > 0))
    {
      i = 0;
      int k = ((List)localObject).size() - 1;
      if (k >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(k);
        int j = i;
        if (i == 0)
        {
          if ((this.c == 9223372036854775807L) || (localChatMessage.uniseq == this.c)) {
            i = 1;
          }
          j = i;
          if (this.c == 9223372036854775807L) {}
        }
        for (;;)
        {
          k -= 1;
          break;
          if (j != 0) {
            break label179;
          }
          i = j;
        }
        label179:
        if (((localChatMessage instanceof MessageForStructing)) && ((StructLongMessageDownloadProcessor.isPALongMsg(localChatMessage)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(localChatMessage))))
        {
          String str = localChatMessage.getExtInfoFromExtStr("longMsg_State");
          if ((str == null) || (!String.valueOf(3).equals(str))) {
            break label243;
          }
        }
        for (;;)
        {
          this.c = localChatMessage.uniseq;
          i = j;
          break;
          label243:
          localChatMessage.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
          StructLongMessageDownloadProcessor.getStructLongMessage(localQQAppInterface, (MessageForStructing)localChatMessage);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("PAMsgListRefresher", 2, "REFRESH_FLAG_RELOAD  to load long message");
      }
    }
    if (paramInt != 131072) {
      this.a.a().sendEmptyMessage(20);
    }
    this.a.a().sendEmptyMessage(37);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.PAMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */