package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TroopAskAnonymouslyHelper$handleAnonymousSwitch$1
  implements Runnable
{
  TroopAskAnonymouslyHelper$handleAnonymousSwitch$1(TroopAskAnonymouslyHelper paramTroopAskAnonymouslyHelper) {}
  
  public final void run()
  {
    if ((this.this$0.a() != null) && (this.this$0.a().a != null))
    {
      MessageRecord localMessageRecord = ReplyTextItemBuilder.a(this.this$0.a(), this.this$0.a().d(), 1, this.this$0.a().a.mSourceMsgSeq);
      if ((localMessageRecord != null) && (AskAnonymousUtil.a(localMessageRecord))) {
        ThreadManagerV2.getUIHandlerV2().post((Runnable)new TroopAskAnonymouslyHelper.handleAnonymousSwitch.1..special..inlined.let.lambda.3(localMessageRecord, this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAskAnonymouslyHelper.handleAnonymousSwitch.1
 * JD-Core Version:    0.7.0.1
 */