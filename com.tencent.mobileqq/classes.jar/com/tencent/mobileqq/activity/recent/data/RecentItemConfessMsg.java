package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessShareHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import java.util.Locale;

public class RecentItemConfessMsg
  extends RecentBaseData
{
  public QQMessageFacade.Message a;
  public final ConfessInfo a;
  public MessageRecord a;
  public String a;
  public int j;
  
  public RecentItemConfessMsg()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo = new ConfessInfo();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public int a()
  {
    return this.j;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      if ((this.j == 1032) && (TextUtils.equals(this.jdField_a_of_type_JavaLangString, AppConstants.aG)))
      {
        localObject2 = a();
        str = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin, true);
        localObject1 = str;
        if (TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin))
        {
          localObject1 = str;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg2)) {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg2;
          }
        }
        ((MsgSummary)localObject2).b = String.format("有人对%s说：%s", new Object[] { localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg });
        this.jdField_b_of_type_JavaLangString = "好友收到的";
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.longMsgCount;
        this.jdField_b_of_type_Int = 3;
        a(paramQQAppInterface, paramContext, (MsgSummary)localObject2);
        d();
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message == null);
    MsgSummary localMsgSummary = a();
    String str = "";
    if (this.j == 1033)
    {
      localObject2 = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.topic))
      {
        this.jdField_b_of_type_JavaLangString = ((String)localObject2);
        localObject1 = str;
      }
    }
    for (;;)
    {
      this.c = paramQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.j, this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.topicId);
      this.jdField_b_of_type_Int = 1;
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.time;
      this.f = 1;
      this.jdField_a_of_type_Int = 0;
      MsgUtils.a(paramContext, paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop, localMsgSummary, (String)localObject1, false, false);
      localMsgSummary.a = false;
      a(paramQQAppInterface, paramContext, localMsgSummary);
      d();
      return;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 7) {
          localObject1 = ConfessShareHelper.a((String)localObject2, 7.0F);
        }
      }
      this.jdField_b_of_type_JavaLangString = String.format(Locale.getDefault(), "%s—%s", new Object[] { localObject1, this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.topic });
      localObject1 = str;
      continue;
      if (this.j == 1034)
      {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.confessorNick;
        localObject1 = str;
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.msgtype == -2066)
        {
          str = paramQQAppInterface.getCurrentNickname();
          localObject1 = str;
          if (str != null)
          {
            localObject1 = str;
            if (str.length() > 7) {
              localObject1 = ConfessShareHelper.a(str, 7.0F);
            }
          }
        }
      }
      else
      {
        this.jdField_b_of_type_JavaLangString = ContactUtils.b(paramQQAppInterface, this.jdField_a_of_type_JavaLangString, true);
        localObject1 = str;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.reset();
      this.jdField_a_of_type_JavaLangString = "";
      this.j = 0;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 1032) && (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, AppConstants.aG)))
    {
      this.jdField_a_of_type_JavaLangString = AppConstants.aG;
      this.j = 1032;
      return;
    }
    paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("ext_key_confess_info");
    this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.parseFromJsonStr(paramMessageRecord);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
    if (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqConfessConfessInfo.confessorUinStr, paramString)) {}
    for (this.j = 1033;; this.j = 1034)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.selfuin)) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.selfuin = paramString;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message = new QQMessageFacade.Message();
      }
      MessageRecord.copyMessageRecordBaseField(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.istroop = this.j;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.frienduin = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.emoRecentMsg = null;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message.fileType = -1;
      paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$Message);
      return;
    }
  }
  
  public long b()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemConfessMsg
 * JD-Core Version:    0.7.0.1
 */