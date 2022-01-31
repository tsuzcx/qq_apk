package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentMsgBoxItem
  extends RecentBaseData
{
  public MessageRecord a;
  public boolean c;
  
  public RecentMsgBoxItem(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      throw new NullPointerException("RecentDatingBoxItem data is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.senderuin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {}
    Object localObject1;
    Object localObject3;
    label231:
    do
    {
      return;
      localObject1 = null;
      localObject3 = paramQQAppInterface.a();
      Object localObject2 = paramQQAppInterface.a();
      if (localObject3 != null) {
        localObject1 = ((QQMessageFacade)localObject3).a(a(), a());
      }
      if (localObject1 == null) {
        break label471;
      }
      this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      if (localObject2 == null) {
        break;
      }
      this.jdField_c_of_type_Int = ((ConversationFacade)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
      if ((localObject1 != null) && (MsgProxyUtils.c((MessageRecord)localObject1))) {
        this.jdField_b_of_type_Int = 3;
      }
      localObject3 = a();
      this.jdField_c_of_type_Boolean = false;
      if (localObject1 != null)
      {
        if (!DatingUtil.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).senderuin, ((QQMessageFacade.Message)localObject1).istroop)) {
          break label484;
        }
        this.jdField_d_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131437880);
        this.e = paramContext.getResources().getColor(2131494281);
        if (localObject2 != null) {
          ((MsgSummary)localObject3).b = ((ConversationFacade)localObject2).a(a(), 1001, paramContext.getResources().getString(2131437881), 0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_boxitem", 2, "boxUin" + a() + ",boxType" + a() + ",HasUnreadRedPacketMsg");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg_boxitem", 2, "boxUin" + a() + ",boxType" + a() + ",unreadNum:" + this.jdField_c_of_type_Int);
      }
      localObject2 = ContactUtils.q(paramQQAppInterface, a());
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = ContactUtils.b(paramQQAppInterface, a(), false);
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = a();
      }
      this.jdField_b_of_type_JavaLangString = ((String)localObject2);
      this.jdField_d_of_type_Int = 0;
      a(paramQQAppInterface);
      a(paramQQAppInterface, (MsgSummary)localObject3);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
    } while (!AppSetting.b);
    paramQQAppInterface = new StringBuilder(24);
    paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_c_of_type_Int == 0) {}
    for (;;)
    {
      if (this.jdField_d_of_type_JavaLangCharSequence != null) {
        paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
      }
      paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(' ').append(this.jdField_c_of_type_JavaLangString);
      this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
      return;
      this.jdField_c_of_type_Int = 0;
      break;
      label471:
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Long = 0L;
      break;
      label484:
      if (DatingUtil.b(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).senderuin, ((QQMessageFacade.Message)localObject1).istroop))
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_d_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131438784);
        this.e = paramContext.getResources().getColor(2131494281);
        if (!QLog.isColorLevel()) {
          break label231;
        }
        QLog.d("Q.msg_boxitem", 2, "boxUin" + a() + ",boxType" + a() + ",HasUnreadGiftMsg");
        break label231;
      }
      this.jdField_d_of_type_JavaLangCharSequence = "";
      a((QQMessageFacade.Message)localObject1, a(), paramQQAppInterface, paramContext, (MsgSummary)localObject3);
      break label231;
      if (this.jdField_c_of_type_Int == 1) {
        paramQQAppInterface.append("有一条未读");
      } else if (this.jdField_c_of_type_Int == 2) {
        paramQQAppInterface.append("有两条未读");
      } else if (this.jdField_c_of_type_Int > 0) {
        paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary == null) {}
    long l;
    do
    {
      do
      {
        do
        {
          return;
          paramMsgSummary.a = false;
          paramMsgSummary.jdField_d_of_type_JavaLangCharSequence = null;
          paramQQAppInterface = paramQQAppInterface.a();
        } while (paramQQAppInterface == null);
        paramQQAppInterface = paramQQAppInterface.a(a(), a());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l = paramQQAppInterface.getTime();
    } while (this.jdField_a_of_type_Long > l);
    this.jdField_a_of_type_Long = l;
    paramMsgSummary.a = true;
    paramMsgSummary.jdField_d_of_type_JavaLangCharSequence = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public long b()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem
 * JD-Core Version:    0.7.0.1
 */