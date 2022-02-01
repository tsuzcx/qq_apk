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
    int i;
    if (paramQQAppInterface == null) {
      i = 0;
    }
    while (i != 0)
    {
      this.msgSummary.strContent = paramQQAppInterface.i;
      this.mDisplayTime = paramQQAppInterface.jdField_a_of_type_Long;
      return;
      if (paramQQAppInterface.h >= 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
    this.msgSummary.strContent = "";
    this.mDisplayTime = 0L;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Object localObject2 = null;
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    MsgSummary localMsgSummary = getMsgSummaryTemp();
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    Object localObject3 = paramQQAppInterface.getConversationFacade();
    paramQQAppInterface.getAccount();
    long l2 = ConfessConfig.a(paramQQAppInterface, "redpoint_box_show");
    this.mTitleName = paramContext.getString(2131698643);
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(this.mUser.uin, this.mUser.getType());; localObject1 = null)
    {
      int i;
      if (localObject1 != null)
      {
        if (!TextUtils.isEmpty(((Message)localObject1).getExtInfoFromExtStr("ext_key_confess_info"))) {
          break label557;
        }
        i = 0;
      }
      for (;;)
      {
        label134:
        long l1;
        label145:
        int j;
        label156:
        boolean bool;
        if ((localObject3 != null) && (localObject1 != null))
        {
          this.mUnreadNum = ((ConversationFacade)localObject3).a(((Message)localObject1).frienduin, ((Message)localObject1).istroop);
          if (i == 0) {
            break label251;
          }
          l1 = ((Message)localObject1).time;
          if (l1 >= l2) {
            break label257;
          }
          j = 1;
          if (this.mUnreadNum <= 0) {
            break label263;
          }
          this.mUnreadFlag = 1;
          bool = false;
          label171:
          if (j == 0) {
            break label352;
          }
          localObject1 = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).b();
          if (localObject1 != null) {
            break label342;
          }
          localObject1 = ConfessConfig.c;
          label201:
          localMsgSummary.strContent = ((CharSequence)localObject1);
          this.mDisplayTime = l2;
        }
        for (;;)
        {
          this.mStatus = 0;
          localMsgSummary.bShowDraft = false;
          a(paramQQAppInterface, paramContext, localMsgSummary);
          makeContentDesc();
          return;
          i = 0;
          break;
          this.mUnreadNum = 0;
          break label134;
          label251:
          l1 = 0L;
          break label145;
          label257:
          j = 0;
          break label156;
          label263:
          localObject2 = ((ConfessManager)paramQQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).a();
          if ((localObject2 != null) && (((FrdConfessInfo)localObject2).a()))
          {
            if (!ConfessMsgUtil.a(paramQQAppInterface, false))
            {
              this.mUnreadNum = ((FrdConfessInfo)localObject2).jdField_a_of_type_Int;
              this.mUnreadFlag = 3;
            }
            bool = a((Message)localObject1, (FrdConfessInfo)localObject2);
            break label171;
          }
          this.mUnreadNum = 0;
          this.mUnreadFlag = 1;
          bool = false;
          break label171;
          label342:
          localObject1 = ((ConfessConfig)localObject1).r;
          break label201;
          label352:
          if ((localObject1 != null) && (i != 0) && (!bool))
          {
            localObject2 = ((Message)localObject1).getExtInfoFromExtStr("ext_key_confess_info");
            localObject3 = new ConfessInfo();
            ((ConfessInfo)localObject3).parseFromJsonStr((String)localObject2);
            if (((Message)localObject1).isSend()) {}
            for (localObject2 = "";; localObject2 = ConfessMsgUtil.a(paramQQAppInterface, (ConfessInfo)localObject3, ((Message)localObject1).senderuin))
            {
              MsgUtils.a(paramContext, paramQQAppInterface, (Message)localObject1, this.mUser.getType(), localMsgSummary, (String)localObject2, false, false);
              this.mDisplayTime = ((Message)localObject1).time;
              break;
            }
          }
          if (bool)
          {
            localObject3 = ContactUtils.c(paramQQAppInterface, ((FrdConfessInfo)localObject2).jdField_a_of_type_JavaLangString, true);
            localObject1 = localObject3;
            if (TextUtils.equals((CharSequence)localObject3, ((FrdConfessInfo)localObject2).jdField_a_of_type_JavaLangString))
            {
              localObject1 = localObject3;
              if (!TextUtils.isEmpty(((FrdConfessInfo)localObject2).b)) {
                localObject1 = ((FrdConfessInfo)localObject2).b;
              }
            }
            localMsgSummary.strContent = String.format(HardCodeUtil.a(2131713134), new Object[] { localObject1, ((FrdConfessInfo)localObject2).c });
            this.mDisplayTime = ((FrdConfessInfo)localObject2).jdField_a_of_type_Long;
          }
          else
          {
            b(paramQQAppInterface);
          }
        }
        label557:
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsgBox
 * JD-Core Version:    0.7.0.1
 */