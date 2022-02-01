package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.replymsg.ForwardMsgManager;
import com.tencent.qphone.base.util.QLog;

public class ReplyOnlyHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  
  public ReplyOnlyHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public String getTag()
  {
    return "ReplyOnlyHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 10 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt == 10)
    {
      if ((this.a.a() != null) && (this.a.a().getIntent() != null))
      {
        Intent localIntent = this.a.a().getIntent();
        long l = localIntent.getLongExtra("key_reply_only_uniseq", 0L);
        if (l > 0L)
        {
          ChatMessage localChatMessage = ((ForwardMsgManager)this.a.a.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).a(l);
          Object localObject3 = localIntent.getStringExtra("troop_code");
          Object localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = "0";
          }
          try
          {
            l = Long.parseLong((String)localObject1);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ReplyOnlyHelper", 2, "replyMessageAtInput", localException);
            }
            l = 0L;
          }
          Object localObject2;
          if (l > 0L)
          {
            localObject2 = (TroopManager)this.a.a.getManager(QQManagerFactory.TROOP_MANAGER);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(l);
            ((StringBuilder)localObject3).append("");
            localObject3 = ((StringBuilder)localObject3).toString();
            TroopInfo localTroopInfo = ((TroopManager)localObject2).b((String)localObject3);
            localObject2 = localObject3;
            if (localTroopInfo != null)
            {
              localObject2 = localObject3;
              if (!TextUtils.isEmpty(localTroopInfo.getTroopDisplayName())) {
                localObject2 = localTroopInfo.getTroopDisplayName();
              }
            }
          }
          else
          {
            localObject2 = null;
          }
          ((ReplyHelper)this.a.a(119)).a(localChatMessage, 0, l, (String)localObject2);
        }
        localIntent.removeExtra("key_reply_only_uniseq");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyOnlyHelper", 2, "params is error");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ReplyOnlyHelper
 * JD-Core Version:    0.7.0.1
 */