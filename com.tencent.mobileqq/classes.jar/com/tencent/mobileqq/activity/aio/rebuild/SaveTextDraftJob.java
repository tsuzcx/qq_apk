package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIODraftHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class SaveTextDraftJob
  implements Runnable
{
  private SessionInfo a;
  private DraftTextManager b;
  private CharSequence c;
  private WeakReference<QQAppInterface> d;
  private String e;
  private MessageForReplyText.SourceMsgInfo f;
  private Object g;
  private WeakReference<BaseChatPie> h;
  private String i;
  private String j;
  
  public SaveTextDraftJob(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, String paramString1, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString2, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, Object paramObject, String paramString3)
  {
    this.h = new WeakReference(paramBaseChatPie);
    this.a = paramSessionInfo;
    this.j = paramString1;
    this.c = paramCharSequence;
    this.d = new WeakReference(paramQQAppInterface);
    this.e = paramString2;
    this.f = paramSourceMsgInfo;
    this.g = paramObject;
    this.i = paramString3;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SaveTextDraftJob", 2, "saving text draft");
    }
    Object localObject1 = (QQAppInterface)this.d.get();
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SaveTextDraftJob", 2, "saving text draft failed with null app");
      }
      return;
    }
    if ((this.a.b != null) && (this.a.b.length() > 2) && (((QQAppInterface)localObject1).getMessageFacade() != null))
    {
      if (this.b == null) {
        this.b = DraftTextManager.a((QQAppInterface)localObject1);
      }
      Object localObject2 = this.b.e((QQAppInterface)localObject1, this.a.b, this.a.a);
      if ((StringUtil.isEmpty(this.e)) && (StringUtil.isEmpty(String.valueOf(this.c))) && (this.f == null) && (((DraftTextInfo)localObject2).sourceMsgSeq == 0L)) {
        return;
      }
      if ((!StringUtil.isEmpty(this.e)) && (this.e.equals(String.valueOf(this.c)))) {
        return;
      }
      localObject2 = this.c;
      if (((localObject2 != null) && (((CharSequence)localObject2).length() > 0)) || (this.f != null))
      {
        localObject2 = new DraftTextInfo();
        ((DraftTextInfo)localObject2).uin = this.a.b;
        ((DraftTextInfo)localObject2).type = this.a.a;
        Object localObject3 = this.f;
        if (localObject3 != null)
        {
          ((DraftTextInfo)localObject2).sourceMsgSeq = ((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgSeq;
          ((DraftTextInfo)localObject2).sourceSenderUin = this.f.mSourceMsgSenderUin;
          ((DraftTextInfo)localObject2).sourceToUin = this.f.mSourceMsgToUin;
          ((DraftTextInfo)localObject2).sourceMsgText = this.f.mSourceMsgText;
          ((DraftTextInfo)localObject2).mSourceMsgTime = this.f.mSourceMsgTime;
          ((DraftTextInfo)localObject2).mSourceSummaryFlag = this.f.mSourceSummaryFlag;
          ((DraftTextInfo)localObject2).mSourceType = this.f.mType;
          ((DraftTextInfo)localObject2).mSourceRichMsg = this.f.mRichMsg;
          ((DraftTextInfo)localObject2).mSourceUid = this.f.origUid;
          ((DraftTextInfo)localObject2).mSourceAtInfoStr = this.f.mAtInfoStr;
          ((DraftTextInfo)localObject2).sourceMsgTroopName = this.f.mSourceMsgTroopName;
        }
        localObject3 = this.c;
        if (localObject3 != null)
        {
          ((DraftTextInfo)localObject2).text = ((CharSequence)localObject3).toString();
          ((DraftTextInfo)localObject2).mixedMsgInfoHtml = this.j;
          ((DraftTextInfo)localObject2).mAtInfoStr = this.i;
          localObject3 = (BaseChatPie)this.h.get();
          if (localObject3 == null) {
            return;
          }
          localObject3 = (AIODraftHelper)((BaseChatPie)localObject3).q(111);
          if (localObject3 == null) {
            return;
          }
          ((AIODraftHelper)localObject3).e = ((DraftTextInfo)localObject2).text;
        }
        ((DraftTextInfo)localObject2).time = NetConnInfoCenter.getServerTimeMillis();
        this.b.a((QQAppInterface)localObject1, (DraftTextInfo)localObject2);
      }
      else
      {
        this.b.c((QQAppInterface)localObject1, this.a.b, this.a.a);
      }
      localObject2 = ((QQAppInterface)localObject1).getMessageFacade();
      localObject1 = this.b.b((QQAppInterface)localObject1, this.a.b, this.a.a);
      if (localObject1 != null)
      {
        ((QQMessageFacade)localObject2).a(this.a.b, this.a.a, this.a.c, ((DraftSummaryInfo)localObject1).getSummary(), ((DraftSummaryInfo)localObject1).getTime());
        return;
      }
      ((QQMessageFacade)localObject2).a(this.a.b, this.a.a, this.a.c, "", 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.SaveTextDraftJob
 * JD-Core Version:    0.7.0.1
 */