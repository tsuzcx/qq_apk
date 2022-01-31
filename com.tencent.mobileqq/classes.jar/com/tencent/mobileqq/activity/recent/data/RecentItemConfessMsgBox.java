package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.confess.FrdConfessInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;

public class RecentItemConfessMsgBox
  extends RecentUserBaseData
{
  private ConfessInfo a;
  
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
    long l2 = ConfessConfig.a(paramQQAppInterface, "redpoint_box_show");
    this.jdField_b_of_type_JavaLangString = paramContext.getString(2131439179);
    if (localObject3 != null) {
      localObject2 = ((QQMessageFacade)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.uin, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type);
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
        break label251;
      }
      this.c = ((ConversationFacade)localObject1).a(((QQMessageFacade.Message)localObject2).frienduin, ((QQMessageFacade.Message)localObject2).istroop);
      if (j == 0) {
        break label259;
      }
      l1 = ((QQMessageFacade.Message)localObject2).time;
      if (l1 >= l2) {
        break label265;
      }
      k = 1;
      label162:
      if (this.c <= 0) {
        break label271;
      }
      this.jdField_b_of_type_Int = 1;
      i = 0;
      localObject1 = null;
      label179:
      if (k == 0) {
        break label390;
      }
      localObject1 = ((ConfessManager)paramQQAppInterface.getManager(268)).b();
      if (localObject1 != null) {
        break label380;
      }
      localObject1 = "题库更新啦！快来抢先体验吧！";
      label208:
      localMsgSummary.b = ((CharSequence)localObject1);
      this.jdField_a_of_type_Long = l2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 0;
      localMsgSummary.a = false;
      a(paramQQAppInterface, paramContext, localMsgSummary);
      d();
      return;
      j = 0;
      break;
      label251:
      this.c = 0;
      break label139;
      label259:
      l1 = 0L;
      break label151;
      label265:
      k = 0;
      break label162;
      label271:
      localObject1 = ((ConfessManager)paramQQAppInterface.getManager(268)).a();
      if ((localObject1 != null) && (((FrdConfessInfo)localObject1).a()))
      {
        if (!ConfessMsgUtil.a(paramQQAppInterface, false))
        {
          this.c = ((FrdConfessInfo)localObject1).jdField_a_of_type_Int;
          this.jdField_b_of_type_Int = 3;
        }
        if ((this.c > 0) || (localObject2 == null) || (((QQMessageFacade.Message)localObject2).msg == null) || (((QQMessageFacade.Message)localObject2).time < ((FrdConfessInfo)localObject1).jdField_a_of_type_Long)) {}
        for (i = 1;; i = 0) {
          break;
        }
      }
      this.c = 0;
      this.jdField_b_of_type_Int = 1;
      i = 0;
      break label179;
      label380:
      localObject1 = ((ConfessConfig)localObject1).h;
      break label208;
      label390:
      if ((localObject2 != null) && (j != 0) && (i == 0))
      {
        localObject1 = ((QQMessageFacade.Message)localObject2).getExtInfoFromExtStr("ext_key_confess_info");
        if (this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo = new ConfessInfo();
        }
        this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.parseFromJsonStr((String)localObject1);
        if (((QQMessageFacade.Message)localObject2).isSend()) {}
        for (localObject1 = "";; localObject1 = ConfessMsgUtil.a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo, ((QQMessageFacade.Message)localObject2).senderuin))
        {
          MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject2, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, localMsgSummary, (String)localObject1, false, false);
          this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject2).time;
          break;
        }
      }
      if (i != 0)
      {
        localObject3 = ContactUtils.b(paramQQAppInterface, ((FrdConfessInfo)localObject1).jdField_a_of_type_JavaLangString, true);
        localObject2 = localObject3;
        if (TextUtils.equals((CharSequence)localObject3, ((FrdConfessInfo)localObject1).jdField_a_of_type_JavaLangString))
        {
          localObject2 = localObject3;
          if (!TextUtils.isEmpty(((FrdConfessInfo)localObject1).jdField_b_of_type_JavaLangString)) {
            localObject2 = ((FrdConfessInfo)localObject1).jdField_b_of_type_JavaLangString;
          }
        }
        localMsgSummary.b = String.format("有人对%s说：%s", new Object[] { localObject2, ((FrdConfessInfo)localObject1).c });
        this.jdField_a_of_type_Long = ((FrdConfessInfo)localObject1).jdField_a_of_type_Long;
      }
      else
      {
        localObject1 = ((ConfessManager)paramQQAppInterface.getManager(268)).b();
        if (localObject1 == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label663;
          }
          localMsgSummary.b = ((ConfessConfig)localObject1).jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_Long = ((ConfessConfig)localObject1).jdField_a_of_type_Long;
          break;
          if (((ConfessConfig)localObject1).g >= 1) {
            i = 1;
          } else {
            i = 0;
          }
        }
        label663:
        localMsgSummary.b = "";
        this.jdField_a_of_type_Long = 0L;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsgBox
 * JD-Core Version:    0.7.0.1
 */