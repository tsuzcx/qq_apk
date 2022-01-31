package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentSayHelloBoxItem
  extends RecentMsgBoxItem
{
  public Object a;
  public List a;
  public boolean d;
  
  public RecentSayHelloBoxItem(MessageRecord paramMessageRecord)
  {
    super(paramMessageRecord);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilList = new ArrayList(6);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    Object localObject3 = paramQQAppInterface.a(a()).a(a(), a());
    Object localObject1 = paramQQAppInterface.a();
    int i;
    if (localObject3 == null) {
      i = 0;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        this.jdField_c_of_type_Int = ((ConversationFacade)localObject1).a(a(), a());
        if (i > 0)
        {
          localObject3 = ((List)localObject3).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
            if ((((ConversationFacade)localObject1).a(localMessageRecord.senderuin, localMessageRecord.istroop) > 0) && (this.jdField_a_of_type_JavaUtilList.size() < 6)) {
              this.jdField_a_of_type_JavaUtilList.add(localMessageRecord);
            }
            if (this.jdField_a_of_type_JavaUtilList.size() < 6) {
              continue;
            }
          }
        }
        if ((this.jdField_c_of_type_Int == 0) && (!this.jdField_a_of_type_JavaUtilList.isEmpty())) {
          this.jdField_a_of_type_JavaUtilList.clear();
        }
        this.jdField_b_of_type_Int = 3;
        this.jdField_c_of_type_JavaLangCharSequence = "";
        this.e = 0;
        this.jdField_d_of_type_JavaLangCharSequence = "";
        ??? = null;
        localObject3 = paramQQAppInterface.a();
        if (localObject3 != null) {
          ??? = ((QQMessageFacade)localObject3).a(a(), a());
        }
        if (DatingUtil.a(paramQQAppInterface, a(), 1001))
        {
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131437897);
          this.e = paramContext.getResources().getColor(2131494288);
          ??? = a();
          ((MsgSummary)???).b = ((ConversationFacade)localObject1).a(a(), 1001, paramContext.getResources().getString(2131437898), 0);
          a(paramQQAppInterface, (MsgSummary)???);
          a(paramQQAppInterface, paramContext, (MsgSummary)???);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg_box", 2, "boxUin" + a() + ",boxType" + a() + ",HasUnreadRedPacketMsg");
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg_box", 2, "boxUin" + a() + ",boxType" + a() + ",unreadNum:" + this.jdField_c_of_type_Int);
          }
          if (!AppSetting.b) {
            break;
          }
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
          if (this.jdField_c_of_type_Int != 0) {
            break label785;
          }
          label482:
          if (this.jdField_d_of_type_JavaLangCharSequence != null) {
            paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
          }
          paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(' ').append(this.jdField_c_of_type_JavaLangString);
          this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
          return;
          i = ((List)localObject3).size();
        }
      }
      if (DatingUtil.b(paramQQAppInterface, a(), 1001))
      {
        this.jdField_d_of_type_Boolean = true;
        this.jdField_b_of_type_Int = 1;
        this.jdField_d_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131438802);
        this.e = paramContext.getResources().getColor(2131494288);
        this.jdField_c_of_type_JavaLangCharSequence = "";
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg_box", 2, "boxUin" + a() + ",boxType" + a() + ",HasUnreadGiftMsg");
        }
      }
      else
      {
        if (this.jdField_c_of_type_Int <= 0) {
          break label689;
        }
        this.jdField_c_of_type_JavaLangCharSequence = "";
      }
    }
    label689:
    localObject1 = null;
    if (??? != null)
    {
      localObject3 = ContactUtils.q(paramQQAppInterface, ((QQMessageFacade.Message)???).senderuin);
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = ContactUtils.b(paramQQAppInterface, ((QQMessageFacade.Message)???).senderuin, false);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label850;
      }
      localObject1 = "";
    }
    label785:
    label850:
    for (;;)
    {
      localObject3 = a();
      MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)???, a(), (MsgSummary)localObject3, (String)localObject1, false, false);
      a(paramQQAppInterface, (MsgSummary)localObject3);
      a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
      break;
      if (this.jdField_c_of_type_Int == 1)
      {
        paramQQAppInterface.append("有一条未读");
        break label482;
      }
      if (this.jdField_c_of_type_Int == 2)
      {
        paramQQAppInterface.append("有两条未读");
        break label482;
      }
      if (this.jdField_c_of_type_Int <= 0) {
        break label482;
      }
      paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读");
      break label482;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentSayHelloBoxItem
 * JD-Core Version:    0.7.0.1
 */