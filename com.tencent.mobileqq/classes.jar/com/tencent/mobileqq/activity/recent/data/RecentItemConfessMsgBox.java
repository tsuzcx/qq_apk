package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.confess.FrdConfessInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;

public class RecentItemConfessMsgBox
  extends AbsRecentUserBusinessBaseData
{
  public RecentItemConfessMsgBox(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private boolean a(Message paramMessage, FrdConfessInfo paramFrdConfessInfo)
  {
    return (this.mUnreadNum > 0) || (paramMessage == null) || (paramMessage.msg == null) || (paramMessage.time < paramFrdConfessInfo.jdField_a_of_type_Long);
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
    int i = 0;
    if ((paramQQAppInterface != null) && (paramQQAppInterface.h >= 1)) {
      i = 1;
    }
    if (i != 0)
    {
      this.msgSummary.strContent = paramQQAppInterface.i;
      this.mDisplayTime = paramQQAppInterface.jdField_a_of_type_Long;
      return;
    }
    this.msgSummary.strContent = "";
    this.mDisplayTime = 0L;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQQAppInterface != null)
    {
      if (paramContext == null) {
        return;
      }
      super.a(paramQQAppInterface, paramContext);
      MsgSummary localMsgSummary = getMsgSummaryTemp();
      Object localObject2 = paramQQAppInterface.getMessageFacade();
      Object localObject3 = paramQQAppInterface.getConversationFacade();
      paramQQAppInterface.getAccount();
      long l2 = ConfessConfig.a(paramQQAppInterface, "redpoint_box_show");
      this.mTitleName = paramContext.getString(2131698709);
      Object localObject1 = null;
      if (localObject2 != null) {
        localObject2 = ((QQMessageFacade)localObject2).getLastMessage(this.mUser.uin, this.mUser.getType());
      } else {
        localObject2 = null;
      }
      boolean bool1;
      if (localObject2 != null) {
        bool1 = TextUtils.isEmpty(((Message)localObject2).getExtInfoFromExtStr("ext_key_confess_info")) ^ true;
      } else {
        bool1 = false;
      }
      if ((localObject3 != null) && (localObject2 != null)) {
        this.mUnreadNum = ((ConversationFacade)localObject3).a(((Message)localObject2).frienduin, ((Message)localObject2).istroop);
      } else {
        this.mUnreadNum = 0;
      }
      long l1;
      if (bool1) {
        l1 = ((Message)localObject2).time;
      } else {
        l1 = 0L;
      }
      int i;
      if (l1 < l2) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.mUnreadNum > 0) {}
      boolean bool2;
      for (this.mUnreadFlag = 1;; this.mUnreadFlag = 1)
      {
        bool2 = false;
        break;
        localObject1 = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
        if ((localObject1 != null) && (((FrdConfessInfo)localObject1).a()))
        {
          if (!ConfessMsgUtil.a(paramQQAppInterface, false))
          {
            this.mUnreadNum = ((FrdConfessInfo)localObject1).jdField_a_of_type_Int;
            this.mUnreadFlag = 3;
          }
          bool2 = a((Message)localObject2, (FrdConfessInfo)localObject1);
          break;
        }
        this.mUnreadNum = 0;
      }
      if (i != 0)
      {
        localObject1 = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
        if (localObject1 == null) {
          localObject1 = ConfessConfig.c;
        } else {
          localObject1 = ((ConfessConfig)localObject1).r;
        }
        localMsgSummary.strContent = ((CharSequence)localObject1);
        this.mDisplayTime = l2;
      }
      else if ((localObject2 != null) && (bool1) && (!bool2))
      {
        localObject1 = ((Message)localObject2).getExtInfoFromExtStr("ext_key_confess_info");
        localObject3 = new ConfessInfo();
        ((ConfessInfo)localObject3).parseFromJsonStr((String)localObject1);
        if (((Message)localObject2).isSend()) {
          localObject1 = "";
        } else {
          localObject1 = ConfessMsgUtil.a(paramQQAppInterface, (ConfessInfo)localObject3, ((Message)localObject2).senderuin);
        }
        MsgUtils.a(paramContext, paramQQAppInterface, (Message)localObject2, this.mUser.getType(), localMsgSummary, (String)localObject1, false, false);
        this.mDisplayTime = ((Message)localObject2).time;
      }
      else if (bool2)
      {
        localObject3 = ContactUtils.a(paramQQAppInterface, ((FrdConfessInfo)localObject1).jdField_a_of_type_JavaLangString, true);
        localObject2 = localObject3;
        if (TextUtils.equals((CharSequence)localObject3, ((FrdConfessInfo)localObject1).jdField_a_of_type_JavaLangString))
        {
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(((FrdConfessInfo)localObject1).b)) {
            localObject2 = ((FrdConfessInfo)localObject1).b;
          }
        }
        localMsgSummary.strContent = String.format(HardCodeUtil.a(2131713109), new Object[] { localObject2, ((FrdConfessInfo)localObject1).c });
        this.mDisplayTime = ((FrdConfessInfo)localObject1).jdField_a_of_type_Long;
      }
      else
      {
        b(paramQQAppInterface);
      }
      this.mStatus = 0;
      localMsgSummary.bShowDraft = false;
      a(paramQQAppInterface, paramContext, localMsgSummary);
      makeContentDesc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsgBox
 * JD-Core Version:    0.7.0.1
 */