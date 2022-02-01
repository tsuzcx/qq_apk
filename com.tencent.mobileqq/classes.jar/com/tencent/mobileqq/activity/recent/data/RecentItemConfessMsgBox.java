package com.tencent.mobileqq.activity.recent.data;

import adab;
import android.content.Context;
import android.text.TextUtils;
import anzj;
import aqyl;
import aqyp;
import aqyt;
import aqzb;
import bhlg;
import bhnt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemConfessMsgBox
  extends AbsRecentUserBusinessBaseData
{
  public RecentItemConfessMsgBox(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  private boolean a(QQMessageFacade.Message paramMessage, aqzb paramaqzb)
  {
    return (this.mUnreadNum > 0) || (paramMessage == null) || (paramMessage.msg == null) || (paramMessage.time < paramaqzb.jdField_a_of_type_Long);
  }
  
  private void b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = ((aqyp)paramQQAppInterface.getManager(269)).b();
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
    Object localObject1 = paramQQAppInterface.a();
    Object localObject3 = paramQQAppInterface.a();
    paramQQAppInterface.getAccount();
    long l2 = aqyl.a(paramQQAppInterface, "redpoint_box_show");
    this.mTitleName = paramContext.getString(2131697920);
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(this.mUser.uin, this.mUser.getType());; localObject1 = null)
    {
      int i;
      if (localObject1 != null)
      {
        if (!TextUtils.isEmpty(((QQMessageFacade.Message)localObject1).getExtInfoFromExtStr("ext_key_confess_info"))) {
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
          this.mUnreadNum = ((adab)localObject3).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          if (i == 0) {
            break label251;
          }
          l1 = ((QQMessageFacade.Message)localObject1).time;
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
          localObject1 = ((aqyp)paramQQAppInterface.getManager(269)).b();
          if (localObject1 != null) {
            break label342;
          }
          localObject1 = aqyl.c;
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
          localObject2 = ((aqyp)paramQQAppInterface.getManager(269)).a();
          if ((localObject2 != null) && (((aqzb)localObject2).a()))
          {
            if (!aqyt.a(paramQQAppInterface, false))
            {
              this.mUnreadNum = ((aqzb)localObject2).jdField_a_of_type_Int;
              this.mUnreadFlag = 3;
            }
            bool = a((QQMessageFacade.Message)localObject1, (aqzb)localObject2);
            break label171;
          }
          this.mUnreadNum = 0;
          this.mUnreadFlag = 1;
          bool = false;
          break label171;
          label342:
          localObject1 = ((aqyl)localObject1).r;
          break label201;
          label352:
          if ((localObject1 != null) && (i != 0) && (!bool))
          {
            localObject2 = ((QQMessageFacade.Message)localObject1).getExtInfoFromExtStr("ext_key_confess_info");
            localObject3 = new ConfessInfo();
            ((ConfessInfo)localObject3).parseFromJsonStr((String)localObject2);
            if (((QQMessageFacade.Message)localObject1).isSend()) {}
            for (localObject2 = "";; localObject2 = aqyt.a(paramQQAppInterface, (ConfessInfo)localObject3, ((QQMessageFacade.Message)localObject1).senderuin))
            {
              bhnt.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.mUser.getType(), localMsgSummary, (String)localObject2, false, false);
              this.mDisplayTime = ((QQMessageFacade.Message)localObject1).time;
              break;
            }
          }
          if (bool)
          {
            localObject3 = bhlg.b(paramQQAppInterface, ((aqzb)localObject2).jdField_a_of_type_JavaLangString, true);
            localObject1 = localObject3;
            if (TextUtils.equals((CharSequence)localObject3, ((aqzb)localObject2).jdField_a_of_type_JavaLangString))
            {
              localObject1 = localObject3;
              if (!TextUtils.isEmpty(((aqzb)localObject2).b)) {
                localObject1 = ((aqzb)localObject2).b;
              }
            }
            localMsgSummary.strContent = String.format(anzj.a(2131712059), new Object[] { localObject1, ((aqzb)localObject2).c });
            this.mDisplayTime = ((aqzb)localObject2).jdField_a_of_type_Long;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsgBox
 * JD-Core Version:    0.7.0.1
 */