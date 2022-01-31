package com.tencent.mobileqq.activity.aio.rebuild;

import asek;
import bbkk;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class SaveTextDraftJob
  implements Runnable
{
  private asek jdField_a_of_type_Asek;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private MessageForReplyText.SourceMsgInfo jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<BaseChatPie> jdField_b_of_type_JavaLangRefWeakReference;
  
  public SaveTextDraftJob(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, asek paramasek, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, Object paramObject)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Asek = paramasek;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = paramSourceMsgInfo;
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public SaveTextDraftJob(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, asek paramasek, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, Object paramObject, String paramString2)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Asek = paramasek;
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = paramSourceMsgInfo;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SaveTextDraftJob", 2, "saving text draft");
    }
    Object localObject1 = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {
      if (QLog.isColorLevel()) {
        QLog.i("SaveTextDraftJob", 2, "saving text draft failed with null app");
      }
    }
    Object localObject2;
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.length() <= 2) || (((QQAppInterface)localObject1).a() == null));
        if (this.jdField_a_of_type_Asek == null) {
          this.jdField_a_of_type_Asek = asek.a((QQAppInterface)localObject1);
        }
        localObject2 = this.jdField_a_of_type_Asek.b((QQAppInterface)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      } while (((bbkk.a(this.jdField_a_of_type_JavaLangString)) && (bbkk.a(String.valueOf(this.jdField_a_of_type_JavaLangCharSequence))) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo == null) && (((DraftTextInfo)localObject2).sourceMsgSeq == 0L)) || ((!bbkk.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equals(String.valueOf(this.jdField_a_of_type_JavaLangCharSequence)))));
      if (((this.jdField_a_of_type_JavaLangCharSequence == null) || (this.jdField_a_of_type_JavaLangCharSequence.length() <= 0)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo == null)) {
        break label496;
      }
      localObject2 = new DraftTextInfo();
      ((DraftTextInfo)localObject2).uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      ((DraftTextInfo)localObject2).type = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
      {
        ((DraftTextInfo)localObject2).sourceMsgSeq = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq;
        ((DraftTextInfo)localObject2).sourceSenderUin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin;
        ((DraftTextInfo)localObject2).sourceToUin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgToUin;
        ((DraftTextInfo)localObject2).sourceMsgText = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText;
        ((DraftTextInfo)localObject2).mSourceMsgTime = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTime;
        ((DraftTextInfo)localObject2).mSourceSummaryFlag = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag;
        ((DraftTextInfo)localObject2).mSourceType = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType;
        ((DraftTextInfo)localObject2).mSourceRichMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mRichMsg;
        ((DraftTextInfo)localObject2).mSourceUid = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.origUid;
        ((DraftTextInfo)localObject2).mSourceAtInfoStr = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAtInfoStr;
        ((DraftTextInfo)localObject2).sourceMsgTroopName = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTroopName;
      }
      if (this.jdField_a_of_type_JavaLangCharSequence == null) {
        break;
      }
      ((DraftTextInfo)localObject2).text = this.jdField_a_of_type_JavaLangCharSequence.toString();
      ((DraftTextInfo)localObject2).mAtInfoStr = this.jdField_b_of_type_JavaLangString;
      localBaseChatPie = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    } while (localBaseChatPie == null);
    localBaseChatPie.c = ((DraftTextInfo)localObject2).text;
    ((DraftTextInfo)localObject2).time = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Asek.a((QQAppInterface)localObject1, (DraftTextInfo)localObject2);
    for (;;)
    {
      localObject2 = ((QQAppInterface)localObject1).a();
      localObject1 = this.jdField_a_of_type_Asek.a((QQAppInterface)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (localObject1 == null) {
        break;
      }
      ((QQMessageFacade)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ((DraftSummaryInfo)localObject1).getSummary(), ((DraftSummaryInfo)localObject1).getTime());
      return;
      label496:
      this.jdField_a_of_type_Asek.a((QQAppInterface)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    ((QQMessageFacade)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, "", 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.SaveTextDraftJob
 * JD-Core Version:    0.7.0.1
 */