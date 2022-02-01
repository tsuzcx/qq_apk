package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.askanonymously.AskAnonymousUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/aio/helper/TroopAskAnonymouslyHelper;", "Lcom/tencent/mobileqq/activity/aio/helper/ILifeCycleHelper;", "Landroid/os/Handler$Callback;", "chatPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "(Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;)V", "mActivity", "Lcom/tencent/mobileqq/app/BaseActivity;", "getMActivity", "()Lcom/tencent/mobileqq/app/BaseActivity;", "setMActivity", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "mAnonymousObserver", "Lcom/tencent/mobileqq/profilecard/bussiness/anonymous/handler/AnonymousObserver;", "mApp", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getMApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "mChatPie", "getMChatPie", "()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mMsgObserver", "Lcom/tencent/mobileqq/app/MessageObserver;", "doOnCreate", "", "doOnDestroy", "filterAndHandleAskAnonymouslyReplyMsg", "msg", "Landroid/os/Message;", "getTag", "", "handleAnonymousSwitch", "handleMessage", "", "interestedIn", "", "onMoveToState", "state", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class TroopAskAnonymouslyHelper
  implements Handler.Callback, ILifeCycleHelper
{
  public static final TroopAskAnonymouslyHelper.Companion a = new TroopAskAnonymouslyHelper.Companion(null);
  @NotNull
  private final BaseChatPie b;
  @NotNull
  private final QQAppInterface c;
  @NotNull
  private BaseActivity d;
  private final MessageObserver e;
  private final AnonymousObserver f;
  @NotNull
  private final Handler g;
  
  public TroopAskAnonymouslyHelper(@NotNull BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "chatPie.app");
    this.c = localQQAppInterface;
    paramBaseChatPie = paramBaseChatPie.aX();
    Intrinsics.checkExpressionValueIsNotNull(paramBaseChatPie, "chatPie.activity");
    this.d = paramBaseChatPie;
    this.g = new Handler(ThreadManager.getSubThreadLooper(), (Handler.Callback)this);
    this.e = ((MessageObserver)new TroopAskAnonymouslyHelper.1(this));
    this.f = ((AnonymousObserver)new TroopAskAnonymouslyHelper.2());
  }
  
  private final void a(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAskAnonymouslyHelper", 2, "filterAndHandleAskAnonymouslyReplyMsg");
    }
    Object localObject = this.b;
    if (((localObject instanceof BaseTroopChatPie)) && (((BaseTroopChatPie)localObject).bG()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAskAnonymouslyHelper", 2, "filterAndHandleAskAnonymouslyReplyMsg current is in anonymous mode");
      }
      return;
    }
    if (paramMessage.getData() != null)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage != null)
      {
        long l1 = ((Long)paramMessage).longValue();
        paramMessage = this.c.getMessageProxy(this.b.F()).b(this.b.ah.b, this.b.F(), l1);
        if ((paramMessage != null) && ((paramMessage instanceof MessageForReplyText)))
        {
          localObject = (MessageForReplyText)paramMessage;
          if ((((MessageForReplyText)localObject).mSourceMsgInfo != null) && (((MessageForReplyText)localObject).mSourceMsgInfo.mSourceMsgSeq > 0L))
          {
            localObject = ReplyTextItemBuilder.a(this.c, paramMessage.frienduin, paramMessage.istroop, ((MessageForReplyText)localObject).mSourceMsgInfo.mSourceMsgSeq);
            if ((localObject != null) && (AskAnonymousUtil.a((MessageRecord)localObject)))
            {
              String str = this.b.ag();
              Intrinsics.checkExpressionValueIsNotNull(str, "mChatPie.curTroopUin");
              l1 = Long.parseLong(str);
              long l2 = AskAnonymousUtil.b((MessageRecord)localObject);
              paramMessage = paramMessage.msg;
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("filterAndHandleAskAnonymouslyReplyMsg groupCode = ");
                ((StringBuilder)localObject).append(l1);
                ((StringBuilder)localObject).append(" questionId = ");
                ((StringBuilder)localObject).append(l2);
                ((StringBuilder)localObject).append(" replyStr = ");
                ((StringBuilder)localObject).append(paramMessage);
                QLog.i("TroopAskAnonymouslyHelper", 2, ((StringBuilder)localObject).toString());
              }
              ReportController.b(null, "dc00899", "Grp_AIO", "", "ask_tab", "ans_send", 0, 0, String.valueOf(l1), "0", paramMessage, "");
              localObject = this.c.getBusinessHandler(BusinessHandlerFactory.ANONYMOUS_ANSWER_HANDLER);
              if (localObject != null)
              {
                ((AnonymousHandler)localObject).replyTroopAskAnonymously(l1, l2, paramMessage);
                return;
              }
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler");
            }
          }
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Long");
      }
    }
  }
  
  @NotNull
  public final BaseChatPie a()
  {
    return this.b;
  }
  
  @NotNull
  public final QQAppInterface b()
  {
    return this.c;
  }
  
  @NotNull
  public final Handler c()
  {
    return this.g;
  }
  
  public final void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAskAnonymouslyHelper", 2, "doOnCreate}");
    }
    this.c.addObserver((BusinessObserver)this.e);
    this.c.addObserver((BusinessObserver)this.f);
  }
  
  public final void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopAskAnonymouslyHelper", 2, "doOnDestroy");
    }
    this.c.removeObserver((BusinessObserver)this.e);
    this.c.removeObserver((BusinessObserver)this.f);
  }
  
  public final void f()
  {
    ThreadManagerV2.executeOnSubThread((Runnable)new TroopAskAnonymouslyHelper.handleAnonymousSwitch.1(this));
  }
  
  @NotNull
  public String getTag()
  {
    return "TroopAskAnonymouslyHelper";
  }
  
  public boolean handleMessage(@Nullable Message paramMessage)
  {
    if (paramMessage != null) {
      if (paramMessage.what != 0) {
        QLog.e("TroopAskAnonymouslyHelper", 2, "handle for unknown message");
      } else {
        a(paramMessage);
      }
    }
    return false;
  }
  
  @NotNull
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAskAnonymouslyHelper
 * JD-Core Version:    0.7.0.1
 */