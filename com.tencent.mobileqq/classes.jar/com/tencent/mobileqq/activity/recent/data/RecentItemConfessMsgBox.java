package com.tencent.mobileqq.activity.recent.data;

import ajyc;
import akpc;
import amnk;
import amno;
import amns;
import amoa;
import android.content.Context;
import android.text.TextUtils;
import bbcl;
import bbet;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.RecentUser;

public class RecentItemConfessMsgBox
  extends RecentUserBaseData
{
  public RecentItemConfessMsgBox(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    MsgSummary localMsgSummary = a();
    Object localObject2 = null;
    Object localObject3 = paramQQAppInterface.a();
    Object localObject1 = paramQQAppInterface.a();
    paramQQAppInterface.getAccount();
    long l2 = amnk.a(paramQQAppInterface, "redpoint_box_show");
    this.mTitleName = paramContext.getString(2131698699);
    if (localObject3 != null) {
      localObject2 = ((QQMessageFacade)localObject3).a(this.mUser.uin, this.mUser.getType());
    }
    int i = 1;
    int j;
    label139:
    long l1;
    label151:
    int k;
    if (localObject2 != null)
    {
      if (TextUtils.isEmpty(((QQMessageFacade.Message)localObject2).getExtInfoFromExtStr("ext_key_confess_info"))) {
        i = 0;
      }
      j = i;
      if ((localObject1 == null) || (localObject2 == null)) {
        break label252;
      }
      this.mUnreadNum = ((akpc)localObject1).a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
      if (j == 0) {
        break label260;
      }
      l1 = ((QQMessageFacade.Message)localObject2).time;
      if (l1 >= l2) {
        break label266;
      }
      k = 1;
      label162:
      if (this.mUnreadNum <= 0) {
        break label272;
      }
      this.mUnreadFlag = 1;
      i = 0;
      localObject1 = null;
      label179:
      if (k == 0) {
        break label391;
      }
      localObject1 = ((amno)paramQQAppInterface.getManager(269)).b();
      if (localObject1 != null) {
        break label381;
      }
      localObject1 = amnk.c;
      label209:
      localMsgSummary.strContent = ((CharSequence)localObject1);
      this.mDisplayTime = l2;
    }
    for (;;)
    {
      this.mStatus = 0;
      localMsgSummary.bShowDraft = false;
      a(paramQQAppInterface, paramContext, localMsgSummary);
      d();
      return;
      j = 0;
      break;
      label252:
      this.mUnreadNum = 0;
      break label139;
      label260:
      l1 = 0L;
      break label151;
      label266:
      k = 0;
      break label162;
      label272:
      localObject1 = ((amno)paramQQAppInterface.getManager(269)).a();
      if ((localObject1 != null) && (((amoa)localObject1).a()))
      {
        if (!amns.a(paramQQAppInterface, false))
        {
          this.mUnreadNum = ((amoa)localObject1).jdField_a_of_type_Int;
          this.mUnreadFlag = 3;
        }
        if ((this.mUnreadNum > 0) || (localObject2 == null) || (((QQMessageFacade.Message)localObject2).msg == null) || (((QQMessageFacade.Message)localObject2).time < ((amoa)localObject1).jdField_a_of_type_Long)) {}
        for (i = 1;; i = 0) {
          break;
        }
      }
      this.mUnreadNum = 0;
      this.mUnreadFlag = 1;
      i = 0;
      break label179;
      label381:
      localObject1 = ((amnk)localObject1).r;
      break label209;
      label391:
      if ((localObject2 != null) && (j != 0) && (i == 0))
      {
        localObject1 = ((QQMessageFacade.Message)localObject2).getExtInfoFromExtStr("ext_key_confess_info");
        localObject3 = new ConfessInfo();
        ((ConfessInfo)localObject3).parseFromJsonStr((String)localObject1);
        if (((QQMessageFacade.Message)localObject2).isSend()) {}
        for (localObject1 = "";; localObject1 = amns.a(paramQQAppInterface, (ConfessInfo)localObject3, ((QQMessageFacade.Message)localObject2).senderuin))
        {
          bbet.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, this.mUser.getType(), localMsgSummary, (String)localObject1, false, false);
          this.mDisplayTime = ((QQMessageFacade.Message)localObject2).time;
          break;
        }
      }
      if (i != 0)
      {
        localObject3 = bbcl.b(paramQQAppInterface, ((amoa)localObject1).jdField_a_of_type_JavaLangString, true);
        localObject2 = localObject3;
        if (TextUtils.equals((CharSequence)localObject3, ((amoa)localObject1).jdField_a_of_type_JavaLangString))
        {
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(((amoa)localObject1).b)) {
            localObject2 = ((amoa)localObject1).b;
          }
        }
        localMsgSummary.strContent = String.format(ajyc.a(2131713176), new Object[] { localObject2, ((amoa)localObject1).c });
        this.mDisplayTime = ((amoa)localObject1).jdField_a_of_type_Long;
      }
      else
      {
        localObject1 = ((amno)paramQQAppInterface.getManager(269)).b();
        if (localObject1 == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label654;
          }
          localMsgSummary.strContent = ((amnk)localObject1).i;
          this.mDisplayTime = ((amnk)localObject1).jdField_a_of_type_Long;
          break;
          if (((amnk)localObject1).h >= 1) {
            i = 1;
          } else {
            i = 0;
          }
        }
        label654:
        localMsgSummary.strContent = "";
        this.mDisplayTime = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsgBox
 * JD-Core Version:    0.7.0.1
 */