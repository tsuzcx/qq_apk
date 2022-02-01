package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TroopAskAnonymouslyHelper$handleAnonymousSwitch$1
  implements Runnable
{
  TroopAskAnonymouslyHelper$handleAnonymousSwitch$1(TroopAskAnonymouslyHelper paramTroopAskAnonymouslyHelper) {}
  
  public final void run()
  {
    if (this.this$0.a() != null)
    {
      Object localObject = this.this$0.a().a(119);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mChatPie.getHelper(HelperProvider.ID_AIO_REPLY)");
      localObject = (ReplyHelper)localObject;
      if (((ReplyHelper)localObject).a() != null)
      {
        MessageRecord localMessageRecord = ReplyTextItemBuilder.a(this.this$0.a(), this.this$0.a().d(), 1, ((ReplyHelper)localObject).a().mSourceMsgSeq);
        if ((localMessageRecord != null) && (AskAnonymousUtil.a(localMessageRecord))) {
          ThreadManagerV2.getUIHandlerV2().post((Runnable)new TroopAskAnonymouslyHelper.handleAnonymousSwitch.1..special..inlined.let.lambda.3(localMessageRecord, (ReplyHelper)localObject, this));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAskAnonymouslyHelper.handleAnonymousSwitch.1
 * JD-Core Version:    0.7.0.1
 */