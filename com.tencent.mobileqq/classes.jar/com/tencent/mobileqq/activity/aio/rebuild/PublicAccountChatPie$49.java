package com.tencent.mobileqq.activity.aio.rebuild;

import aido;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import java.util.Iterator;
import java.util.List;
import okn;

public class PublicAccountChatPie$49
  implements Runnable
{
  public PublicAccountChatPie$49(aido paramaido) {}
  
  public void run()
  {
    if (okn.a().a(this.this$0.app, this.this$0.sessionInfo.curFriendUin) != 0L) {}
    for (;;)
    {
      return;
      Object localObject1 = this.this$0.app.getMessageFacade().getAIOList(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (ChatMessage)((Iterator)localObject1).next();
          if (((localObject2 instanceof MessageForStructing)) || ((localObject2 instanceof MessageForPubAccount)))
          {
            localObject2 = ((ChatMessage)localObject2).getExtInfoFromExtStr("pa_msgId");
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              try
              {
                long l = Long.parseLong((String)localObject2);
                if (l > 0L)
                {
                  okn.a().a(this.this$0.app, this.this$0.sessionInfo.curFriendUin, l);
                  return;
                }
              }
              catch (Exception localException) {}
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.49
 * JD-Core Version:    0.7.0.1
 */