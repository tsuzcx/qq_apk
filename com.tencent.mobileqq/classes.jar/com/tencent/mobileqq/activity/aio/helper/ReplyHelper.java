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
  private MovementMethod jdField_a_of_type_AndroidTextMethodMovementMethod = null;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForReplyText.SourceMsgInfo jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
  
  public ReplyHelper(AIOContext paramAIOContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramAIOContext.a());
  }
  
  public MessageForReplyText.SourceMsgInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
  }
  
  public MessageForReplyText.SourceMsgInfo a(DraftTextInfo paramDraftTextInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = new MessageForReplyText.SourceMsgInfo();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTroopName = paramDraftTextInfo.sourceMsgTroopName;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq = paramDraftTextInfo.sourceMsgSeq;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText = paramDraftTextInfo.sourceMsgText;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin = paramDraftTextInfo.sourceSenderUin;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgToUin = paramDraftTextInfo.sourceToUin;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTime = paramDraftTextInfo.mSourceMsgTime;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag = paramDraftTextInfo.mSourceSummaryFlag;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = paramDraftTextInfo.mSourceType;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mRichMsg = paramDraftTextInfo.mSourceRichMsg;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAtInfoStr = paramDraftTextInfo.mSourceAtInfoStr;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.origUid = paramDraftTextInfo.mSourceUid;
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
  }
  
  public MessageRecord a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a().a(2131373876) == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
    }
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
    Object localObject = paramMessageRecord;
    if (localSourceMsgInfo != null)
    {
      localObject = paramMessageRecord;
      if (!TextUtils.isEmpty(localSourceMsgInfo.mSourceMsgTroopName)) {
        localObject = ((ForwardMsgManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.getUniSeq());
      }
    }
    paramMessageRecord = (MessageRecord)localObject;
    if (localObject == null)
    {
      paramMessageRecord = (MessageRecord)localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) {
        paramMessageRecord = ReplyMsgUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
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
      MessageForReplyText.SourceMsgInfo localSourceMsgInfo = ReplyMsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramInt, paramLong, paramString);
      if (localSourceMsgInfo == null) {
        return;
      }
      a(localSourceMsgInfo);
      EditTextUI localEditTextUI = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a();
      paramString = (AIODraftHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(111);
      if (TextUtils.isEmpty(localSourceMsgInfo.mSourceMsgTroopName)) {
        paramString = paramString.a;
      } else {
        paramString = null;
      }
      paramInt = localEditTextUI.g();
      int i = localEditTextUI.b();
      paramString = ReplyedMessageSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), localSourceMsgInfo, paramInt - i * 2, localEditTextUI.a(), paramString);
      if (paramString != null)
      {
        localEditTextUI.a(null, paramString.getDrawable(), null, null);
        localEditTextUI.b(20);
        localEditTextUI.a(2131373876, paramString);
        this.jdField_a_of_type_AndroidTextMethodMovementMethod = localEditTextUI.a();
        localEditTextUI.a(ReplyClickMovementMethod.a());
        ((AIOZhituHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(116)).a();
        ((AIOInputRightHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(117)).b();
        localEditTextUI.a(localEditTextUI.b(), localEditTextUI.c(), localEditTextUI.b(), localEditTextUI.d());
        if ((localSourceMsgInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(String.valueOf(localSourceMsgInfo.mSourceMsgSenderUin)))) {
          InputUIUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false);
        }
      }
      else
      {
        paramString = this.jdField_a_of_type_AndroidTextMethodMovementMethod;
        if (paramString != null) {
          localEditTextUI.a(paramString);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().postDelayed(new ReplyHelper.1(this, localEditTextUI), 200L);
      MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), (SessionInfo)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), paramChatMessage);
    }
  }
  
  public void a(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = paramSourceMsgInfo;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null;
  }
  
  public MessageForReplyText.SourceMsgInfo b()
  {
    MessageForReplyText.SourceMsgInfo localSourceMsgInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
    if ((localSourceMsgInfo != null) && (localSourceMsgInfo.mSourceMsgText.length() > BaseChatPie.f))
    {
      localSourceMsgInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
      localSourceMsgInfo.mSourceMsgText = localSourceMsgInfo.mSourceMsgText.substring(0, BaseChatPie.f);
      localSourceMsgInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
      localSourceMsgInfo.mSourceSummaryFlag = 0;
      if (localSourceMsgInfo.mType == -1036) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.oriMsgType = 1;
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
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
      a((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str, paramInt1, l), 0, 0L, null);
    }
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ReplyHelper
 * JD-Core Version:    0.7.0.1
 */