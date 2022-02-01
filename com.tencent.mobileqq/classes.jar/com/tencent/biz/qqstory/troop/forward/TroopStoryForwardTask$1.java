package com.tencent.biz.qqstory.troop.forward;

import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;

class TroopStoryForwardTask$1
  implements Runnable
{
  TroopStoryForwardTask$1(TroopStoryForwardTask paramTroopStoryForwardTask) {}
  
  public void run()
  {
    MessageForTroopStory localMessageForTroopStory = (MessageForTroopStory)MessageRecordFactory.a(-2057);
    MessageRecordFactory.a(this.this$0.c, localMessageForTroopStory, this.this$0.q, this.this$0.s, this.this$0.r);
    localMessageForTroopStory.uid = Long.valueOf(this.this$0.e).longValue();
    localMessageForTroopStory.unionId = this.this$0.f;
    localMessageForTroopStory.md5 = this.this$0.g;
    localMessageForTroopStory.thumbUrl = this.this$0.h;
    localMessageForTroopStory.doodleUrl = this.this$0.i;
    localMessageForTroopStory.videoWidth = this.this$0.j;
    localMessageForTroopStory.videoHeight = this.this$0.k;
    localMessageForTroopStory.sourceName = this.this$0.l;
    localMessageForTroopStory.sourceActionType = this.this$0.m;
    localMessageForTroopStory.sourceActionData = this.this$0.n;
    localMessageForTroopStory.compatibleText = this.this$0.o;
    localMessageForTroopStory.ctrVersion = this.this$0.p;
    localMessageForTroopStory.msg = MessageForTroopStory.MSG_CONTENT;
    localMessageForTroopStory.serial();
    TroopStoryForwardTask localTroopStoryForwardTask = this.this$0;
    localTroopStoryForwardTask.d = localMessageForTroopStory;
    ((ISVIPHandler)localTroopStoryForwardTask.c.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageForTroopStory);
    this.this$0.c.getMsgCache().a(localMessageForTroopStory, 0);
    this.this$0.c.getMessageFacade().a(localMessageForTroopStory, this.this$0.c.getCurrentAccountUin());
    this.this$0.b.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.forward.TroopStoryForwardTask.1
 * JD-Core Version:    0.7.0.1
 */