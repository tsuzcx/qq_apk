package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.forward.ForwardOrderManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.gamecenter.util.RoleIdUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

class ChatActivityFacade$20$1
  implements Runnable
{
  ChatActivityFacade$20$1(ChatActivityFacade.20 param20, MessageForMarketFace paramMessageForMarketFace, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    this.a.sendFaceName = this.this$0.b.name;
    this.a.msgVia = this.this$0.d.s;
    if (this.a.istroop == 1) {
      AnonymousChatHelper.a().a(this.a);
    } else if (AnonymousChatHelper.a().j) {
      AnonymousChatHelper.a().j = false;
    }
    if (UinTypeUtil.e(this.this$0.d.a) == 1032) {
      ConfessMsgUtil.a(this.this$0.a, this.a, this.this$0.d.b, this.this$0.d.a, this.this$0.d.v);
    } else if (this.this$0.d.x) {
      ConfessMsgUtil.a(this.this$0.a, this.a, this.this$0.d.b);
    } else if (this.this$0.d.y) {
      ConfessMsgUtil.b(this.this$0.a, this.a, this.this$0.d.b);
    }
    Object localObject2;
    if (this.this$0.d.a == 10007)
    {
      localObject1 = this.this$0.a;
      localObject2 = this.a;
      RoleIdUtil.a((AppRuntime)localObject1, (MessageRecord)localObject2, ((MessageForMarketFace)localObject2).frienduin, this.a.istroop);
    }
    ForwardOrderManager.a().a(this.a.uniseq, 0L, this.this$0.e);
    this.this$0.a.getMessageFacade().a(this.a, null);
    Object localObject1 = (IEmoticonManagerService)this.this$0.a.getRuntimeService(IEmoticonManagerService.class);
    if (localObject1 != null)
    {
      localObject2 = ((IEmoticonManagerService)localObject1).getKeywordsByEmoticon(this.this$0.b);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(str))
          {
            RecentEmotion localRecentEmotion = new RecentEmotion();
            localRecentEmotion.epId = this.this$0.b.epId;
            localRecentEmotion.eId = this.this$0.b.eId;
            localRecentEmotion.keyword = str.toLowerCase();
            localRecentEmotion.exposeNum = 0;
            ((IEmoticonManagerService)localObject1).addRecentEmotionToCache(localRecentEmotion);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mainRunnable, epId = ");
      ((StringBuilder)localObject1).append(this.b.epId);
      ((StringBuilder)localObject1).append(" ePackage.copywritingType = ");
      ((StringBuilder)localObject1).append(this.b.copywritingType);
      ((StringBuilder)localObject1).append(" currentTime = ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("ChatActivityFacade", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.20.1
 * JD-Core Version:    0.7.0.1
 */