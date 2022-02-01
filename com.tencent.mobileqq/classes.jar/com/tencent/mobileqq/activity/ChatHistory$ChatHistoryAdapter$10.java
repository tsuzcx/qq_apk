package com.tencent.mobileqq.activity;

import android.database.Cursor;
import android.os.Message;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import mqq.os.MqqHandler;

class ChatHistory$ChatHistoryAdapter$10
  implements Runnable
{
  ChatHistory$ChatHistoryAdapter$10(ChatHistory.ChatHistoryAdapter paramChatHistoryAdapter, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject3 = "ORDER BY shmsgseq";
    Object localObject1 = localObject3;
    if (i != 1)
    {
      localObject1 = localObject3;
      if (i != 3000) {
        localObject1 = "ORDER BY time asc , longMsgIndex asc";
      }
    }
    i = this.b;
    if (i < this.d.f.S)
    {
      this.d.f.R = true;
    }
    else
    {
      this.d.f.R = false;
      i = this.b - this.d.f.S;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("( msgtype ");
    ((StringBuilder)localObject3).append(UinTypeUtil.a());
    ((StringBuilder)localObject3).append(" and isValid=1 ) ");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(" limit ");
    ((StringBuilder)localObject3).append(i);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append(String.valueOf(8));
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = MessageRecord.getTableName(this.c, this.a);
    String str = MessageRecord.getOldTableName(this.c, this.a);
    try
    {
      if (!this.d.f.R)
      {
        localObject1 = this.d.f.a((String)localObject3, str, (String)localObject1);
      }
      else
      {
        if (this.d.f.Q == null) {
          break label307;
        }
        localObject1 = this.d.f.Q.a((String)localObject3, (String)localObject1);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label266:
        continue;
        Object localObject2 = null;
      }
    }
    localObject3 = localObject1;
    if (localObject1 != null)
    {
      ((Cursor)localObject1).getCount();
      localObject3 = localObject1;
      break label266;
      localObject3 = null;
    }
    localObject1 = this.d.f.U.obtainMessage(8);
    ((Message)localObject1).obj = localObject3;
    this.d.f.U.sendMessage((Message)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.10
 * JD-Core Version:    0.7.0.1
 */