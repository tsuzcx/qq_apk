package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import androidx.annotation.NonNull;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputUIUtils;
import com.tencent.mobileqq.activity.aio.reply.ReplyMsgUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.replymsg.ForwardMsgManager;
import com.tencent.mobileqq.troop.text.ReplyClickMovementMethod;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import mqq.os.MqqHandler;

public class ReplyHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  protected MessageForReplyText.SourceMsgInfo a;
  private final QQAppInterface b;
  private final SessionInfo c;
  private final AIOContext d;
  private MovementMethod e = null;
  
  public ReplyHelper(AIOContext paramAIOContext)
  {
    this.d = paramAIOContext;
    this.b = paramAIOContext.a();
    this.c = ((SessionInfo)paramAIOContext.O());
  }
  
  public MessageForReplyText.SourceMsgInfo a()
  {
    return this.a;
  }
  
  public MessageForReplyText.SourceMsgInfo a(DraftTextInfo paramDraftTextInfo)
  {
    this.a = new MessageForReplyText.SourceMsgInfo();
    this.a.mSourceMsgTroopName = paramDraftTextInfo.sourceMsgTroopName;
    this.a.mSourceMsgSeq = paramDraftTextInfo.sourceMsgSeq;
    this.a.mSourceMsgText = paramDraftTextInfo.sourceMsgText;
    this.a.mSourceMsgSenderUin = paramDraftTextInfo.sourceSenderUin;
    this.a.mSourceMsgToUin = paramDraftTextInfo.sourceToUin;
    this.a.mSourceMsgTime = paramDraftTextInfo.mSourceMsgTime;
    this.a.mSourceSummaryFlag = paramDraftTextInfo.mSourceSummaryFlag;
    this.a.mType = paramDraftTextInfo.mSourceType;
    this.a.mRichMsg = paramDraftTextInfo.mSourceRichMsg;
    this.a.mAtInfoStr = paramDraftTextInfo.mSourceAtInfoStr;
    this.a.origUid = paramDraftTextInfo.mSourceUid;
    return this.a;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (this.d.p().d().f().c(2131441550) == null) {
      this.a = null;
    }
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = this.a;
    Object localObject = paramMessageRecord;
    if (localSourceMsgInfo != null)
    {
      localObject = paramMessageRecord;
      if (!TextUtils.isEmpty(localSourceMsgInfo.mSourceMsgTroopName)) {
        localObject = ((ForwardMsgManager)this.d.a().getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).b(this.a.getUniSeq());
      }
    }
    paramMessageRecord = (MessageRecord)localObject;
    if (localObject == null)
    {
      paramMessageRecord = (MessageRecord)localObject;
      if (this.a != null) {
        paramMessageRecord = ReplyMsgUtils.c(this.d.a(), this.d.O(), this.a);
      }
    }
    return paramMessageRecord;
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt, long paramLong, String paramString)
  {
    if (paramChatMessage != null)
    {
      if (paramChatMessage.senderuin == null) {
        return;
      }
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ReplyMsgUtils.a(this.b, paramChatMessage, paramInt, paramLong, paramString);
      if (localSourceMsgInfo == null) {
        return;
      }
      a(localSourceMsgInfo);
      EditTextUI localEditTextUI = this.d.p().d().f();
      paramString = (AIODraftHelper)this.d.a(111);
      if (TextUtils.isEmpty(localSourceMsgInfo.mSourceMsgTroopName)) {
        paramString = paramString.g;
      } else {
        paramString = null;
      }
      paramInt = localEditTextUI.k();
      int i = localEditTextUI.e();
      paramString = ReplyedMessageSpan.a(this.b, this.d.b(), localSourceMsgInfo, paramInt - i * 2, localEditTextUI.l(), paramString);
      if (paramString != null)
      {
        localEditTextUI.a(null, paramString.getDrawable(), null, null);
        localEditTextUI.b(20);
        localEditTextUI.a(2131441550, paramString);
        this.e = localEditTextUI.m();
        localEditTextUI.a(ReplyClickMovementMethod.a());
        ((AIOZhituHelper)this.d.a(116)).a();
        ((AIOInputRightHelper)this.d.a(117)).b();
        localEditTextUI.a(localEditTextUI.e(), localEditTextUI.f(), localEditTextUI.e(), localEditTextUI.g());
        if ((localSourceMsgInfo != null) && (!this.b.getCurrentUin().equals(String.valueOf(localSourceMsgInfo.mSourceMsgSenderUin)))) {
          InputUIUtils.a(this.d, this.c, false);
        }
      }
      else
      {
        paramString = this.e;
        if (paramString != null) {
          localEditTextUI.a(paramString);
        }
      }
      this.d.g().postDelayed(new ReplyHelper.1(this, localEditTextUI), 200L);
      MessageForReplyText.reportReplyMsg(this.d.a(), (SessionInfo)this.d.O(), paramChatMessage);
    }
  }
  
  public void a(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    this.a = paramSourceMsgInfo;
  }
  
  public boolean b()
  {
    return this.a != null;
  }
  
  public MessageForReplyText.SourceMsgInfo c()
  {
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = this.a;
    if ((localSourceMsgInfo != null) && (localSourceMsgInfo.mSourceMsgText.length() > BaseChatPie.bh))
    {
      localSourceMsgInfo = this.a;
      localSourceMsgInfo.mSourceMsgText = localSourceMsgInfo.mSourceMsgText.substring(0, BaseChatPie.bh);
      localSourceMsgInfo = this.a;
      localSourceMsgInfo.mSourceSummaryFlag = 0;
      if (localSourceMsgInfo.mType == -1036) {
        this.a.oriMsgType = 1;
      }
    }
    return this.a;
  }
  
  @NonNull
  public String getTag()
  {
    return "ReplyHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[0];
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 14001) && (paramIntent != null))
    {
      paramInt1 = paramIntent.getIntExtra("uin_type", 0);
      String str = paramIntent.getStringExtra("peeruin");
      long l = paramIntent.getLongExtra("uniseq", 0L);
      a((ChatMessage)this.b.getMessageFacade().a(str, paramInt1, l), 0, 0L, null);
    }
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ReplyHelper
 * JD-Core Version:    0.7.0.1
 */