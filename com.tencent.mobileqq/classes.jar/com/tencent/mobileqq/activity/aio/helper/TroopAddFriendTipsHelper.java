package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.haoliyou.orion.XorCipher;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public class TroopAddFriendTipsHelper
  implements ILifeCycleHelper, Observer
{
  private QQAppInterface a;
  private Context b;
  private BaseActivity c;
  private BaseChatPie d;
  private SessionInfo e;
  private MqqHandler f;
  private TroopAddFriendTipsHelper.NewMsgRunnable g;
  
  public TroopAddFriendTipsHelper(BaseChatPie paramBaseChatPie)
  {
    this.d = paramBaseChatPie;
    this.a = paramBaseChatPie.d;
    this.b = paramBaseChatPie.e;
    this.c = paramBaseChatPie.f;
    this.e = paramBaseChatPie.ah;
    this.f = paramBaseChatPie.j();
  }
  
  private void a(String paramString)
  {
    Object localObject = (ITroopBatchAddFriendService)this.a.getRuntimeService(ITroopBatchAddFriendService.class, "");
    if (localObject != null)
    {
      localObject = ((ITroopBatchAddFriendService)localObject).getTroopBatchAddFriendMgr();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).t(paramString);
      }
    }
  }
  
  public void a()
  {
    ThreadManager.post(new TroopAddFriendTipsHelper.1(this, this.c.getIntent().getStringExtra("uin")), 2, null, true);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    String str1 = this.e.b;
    if (!str1.equalsIgnoreCase(paramMessageRecord.frienduin)) {
      return;
    }
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((ITroopBatchAddFriendService)this.a.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
    int j = paramMessageRecord.msgtype;
    int i = 1;
    if ((j == -1012) && (localTroopBatchAddFriendMgr.j("newMember")))
    {
      String str2 = paramMessageRecord.getExtInfoFromExtStr("troop_new_member_uin");
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkTipsTriggerInAio update newMemberUin = ");
        localStringBuilder.append(XorCipher.a(str2));
        localStringBuilder.append(" troop:");
        localStringBuilder.append(str1);
        QLog.d("TroopAddFriendTipsHelper", 1, localStringBuilder.toString());
      }
      catch (XorCipherException localXorCipherException)
      {
        localXorCipherException.printStackTrace();
      }
      if ((localTroopBatchAddFriendMgr.i(str1)) && (!RobotUtils.a(this.a, str1))) {
        ThreadManager.getSubThreadHandler().postDelayed(new TroopAddFriendTipsHelper.2(this, str2, str1), 1000L);
      }
    }
    if ((!paramMessageRecord.isSendFromLocal()) && (paramMessageRecord.mMessageInfo != null) && (!AnonymousChatHelper.c(paramMessageRecord)) && ((paramMessageRecord.mMessageInfo.c.b(24)) || (paramMessageRecord.mMessageInfo.c.b(22))) && (localTroopBatchAddFriendMgr.j("atMeOrReplyMe")) && (localTroopBatchAddFriendMgr.q(paramMessageRecord.senderuin))) {
      localTroopBatchAddFriendMgr.a(str1, paramMessageRecord.senderuin, paramMessageRecord.time, paramMessageRecord.shmsgseq);
    }
    if (paramMessageRecord.isSendFromLocal())
    {
      if (paramMessageRecord.atInfoList == null) {
        i = 0;
      }
      if (((paramMessageRecord instanceof MessageForReplyText | i)) && (localTroopBatchAddFriendMgr.j("atMeOrReplyMe"))) {
        localTroopBatchAddFriendMgr.a(paramMessageRecord, str1);
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ThreadManager.postImmediately(new TroopAddFriendTipsHelper.3(this, paramBoolean, paramString), null, true);
  }
  
  public String getTag()
  {
    return "TroopAddFriendTipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (this.e.a == 1) {
      if (paramInt != 4)
      {
        if (paramInt != 9)
        {
          if (paramInt != 15) {
            return;
          }
          a(null);
          if (this.g != null) {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.g);
          }
          if (this.a.getMessageFacade() != null) {
            this.a.getMessageFacade().deleteObserver(this);
          }
        }
        else
        {
          a();
        }
      }
      else
      {
        a(this.e.b);
        this.a.getMessageFacade().addObserver(this);
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof ChatMessage))
    {
      paramObservable = (MessageRecord)paramObject;
      paramObject = this.e;
      if (paramObject != null)
      {
        if (paramObject.b == null) {
          return;
        }
        if ((TextUtils.equals(this.e.b, paramObservable.frienduin)) && (this.e.a == paramObservable.istroop) && (!MessageUtils.b(paramObservable.msgtype)) && (!RobotUtils.a(this.a, paramObservable.senderuin)))
        {
          if (this.g == null) {
            this.g = new TroopAddFriendTipsHelper.NewMsgRunnable(this, null);
          }
          this.g.a(this.e.b);
          ThreadManager.getSubThreadHandler().removeCallbacks(this.g);
          ThreadManager.getSubThreadHandler().post(this.g);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper
 * JD-Core Version:    0.7.0.1
 */