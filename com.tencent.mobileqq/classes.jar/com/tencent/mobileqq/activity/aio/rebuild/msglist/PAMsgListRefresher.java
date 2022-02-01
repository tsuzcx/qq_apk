package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
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
  
  public void a(int paramInt)
  {
    int i = 0xFFFF0000 & paramInt;
    super.a(paramInt);
    Object localObject = this.a.a();
    QQAppInterface localQQAppInterface = this.a.a();
    if (localObject != null)
    {
      if (((BaseSessionInfo)localObject).jdField_a_of_type_JavaLangString == null) {
        return;
      }
      localObject = localQQAppInterface.getMessageFacade().b(((BaseSessionInfo)localObject).jdField_a_of_type_JavaLangString, ((BaseSessionInfo)localObject).jdField_a_of_type_Int);
      if (((i == 196608) || (i == 131072)) && (((List)localObject).size() > 0))
      {
        i = 0;
        int k = ((List)localObject).size() - 1;
        while (k >= 0)
        {
          ChatMessage localChatMessage = (ChatMessage)((List)localObject).get(k);
          int j = i;
          if (i == 0)
          {
            if ((this.c == 9223372036854775807L) || (localChatMessage.uniseq == this.c)) {
              i = 1;
            }
            j = i;
            if (this.c != 9223372036854775807L) {}
          }
          else if (j == 0)
          {
            i = j;
          }
          else
          {
            if (((localChatMessage instanceof MessageForStructing)) && ((StructLongMessageDownloadProcessor.isPALongMsg(localChatMessage)) || (StructLongMessageDownloadProcessor.needFetchOldLongMsg(localChatMessage))))
            {
              String str = localChatMessage.getExtInfoFromExtStr("longMsg_State");
              if ((str == null) || (!String.valueOf(3).equals(str)))
              {
                localChatMessage.saveExtInfoToExtStr("longMsg_State", String.valueOf(1));
                StructLongMessageDownloadProcessor.getStructLongMessage(localQQAppInterface, (MessageForStructing)localChatMessage);
              }
            }
            this.c = localChatMessage.uniseq;
            i = j;
          }
          k -= 1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.PAMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */