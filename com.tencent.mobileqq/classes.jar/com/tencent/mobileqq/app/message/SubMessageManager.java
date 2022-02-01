package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMessageManager.AddMessageContext;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.subaccount.api.ISubAccountConfigApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class SubMessageManager
  extends BaseMessageManager
{
  public SubMessageManager(AppRuntime paramAppRuntime, MsgPool paramMsgPool)
  {
    super(paramAppRuntime, paramMsgPool);
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return 0L;
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, BaseMessageManager.AddMessageContext paramAddMessageContext)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = MessageCache.c();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    a(paramMessageRecord, true, 1);
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle) {}
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SubMessageManager setReaded uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",type=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",needDelMark=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : uin=null");
      }
      return;
    }
    if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : clean all");
      }
      paramString = (ISubAccountService)this.a.getRuntimeService(ISubAccountService.class, "");
      if (paramString != null)
      {
        paramString = paramString.getAllSubUin().iterator();
        while (paramString.hasNext())
        {
          localObject = (String)paramString.next();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            d((String)localObject, paramInt1, paramBoolean1, paramBoolean1);
          }
        }
      }
      return;
    }
    d(paramString, paramInt1, paramBoolean1, paramBoolean2);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext) {}
  
  public void d(String paramString, int paramInt)
  {
    super.d(paramString, paramInt);
    if (((ISubAccountConfigApi)QRoute.api(ISubAccountConfigApi.class)).getIsHideSubAccountTroopMsg()) {
      return;
    }
    this.c.setSubAccountTroopUnReadMsg(paramString, paramInt, 0);
  }
  
  public void d(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (this.c.getUnreadCount(paramString, paramInt) > 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SubMessageManager setReaded clean one uin = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = a(paramInt).e(paramString, paramInt);
      IConversationFacade localIConversationFacade = this.c;
      long l;
      if (localObject != null) {
        l = a((MessageRecord)localObject);
      } else {
        l = 0L;
      }
      localIConversationFacade.cleanUnread(paramString, paramInt, l, paramBoolean1, paramBoolean2);
      d(paramString, paramInt);
      this.b.setChangeAndNotify(this.b.getLastMessage(paramString, paramInt));
      return;
    }
    if (this.c.getUnreadCountFromExtInt2(paramString, paramInt) > 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SubMessageManager setTroopReaded clean one uin = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("Q.msg.BaseMessageManager", 2, ((StringBuilder)localObject).toString());
      }
      d(paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.SubMessageManager
 * JD-Core Version:    0.7.0.1
 */