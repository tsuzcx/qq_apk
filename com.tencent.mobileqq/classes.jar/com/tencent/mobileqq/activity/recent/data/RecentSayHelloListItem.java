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
import com.tencent.mobileqq.dating.FansEntity;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentSayHelloListItem
  extends RecentBaseData
{
  MessageRecord a;
  public String a;
  public boolean c;
  public boolean d;
  public boolean e;
  public int j = -1;
  public int k = -1;
  public int l = -1;
  public int m = -1;
  public int n = -1;
  public int o;
  public int p;
  
  public RecentSayHelloListItem(MessageRecord paramMessageRecord)
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
    Object localObject1 = paramQQAppInterface.a();
    Object localObject2 = paramQQAppInterface.a();
    if (localObject1 != null) {}
    for (localObject1 = ((QQMessageFacade)localObject1).a(a(), a());; localObject1 = null)
    {
      label78:
      MsgSummary localMsgSummary;
      if (localObject1 != null)
      {
        this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
        if ((localObject2 != null) && (localObject1 != null))
        {
          this.jdField_c_of_type_Int = ((ConversationFacade)localObject2).a(((QQMessageFacade.Message)localObject1).frienduin, ((QQMessageFacade.Message)localObject1).istroop);
          if (MsgProxyUtils.c((MessageRecord)localObject1)) {
            this.jdField_b_of_type_Int = 3;
          }
          localMsgSummary = super.a();
          this.jdField_c_of_type_Boolean = false;
          this.jdField_e_of_type_Int = 0;
          this.jdField_d_of_type_JavaLangCharSequence = null;
          if (!DatingUtil.a(paramQQAppInterface, a(), 1001)) {
            break label366;
          }
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131437897);
          this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494288);
          if (localObject2 != null) {
            localMsgSummary.b = ((ConversationFacade)localObject2).a(a(), 1001, paramContext.getResources().getString(2131437898), 0);
          }
          label171:
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
          super.a(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          super.a(paramQQAppInterface, paramContext, localMsgSummary);
          if (AppSetting.b)
          {
            paramQQAppInterface = new StringBuilder(24);
            paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
            if (this.jdField_c_of_type_Int != 0) {
              break label430;
            }
          }
        }
      }
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
        this.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Long = 0L;
        break label78;
        label366:
        if (DatingUtil.b(paramQQAppInterface, a(), 1001))
        {
          this.jdField_c_of_type_Boolean = true;
          this.jdField_d_of_type_JavaLangCharSequence = paramContext.getResources().getString(2131438802);
          this.jdField_e_of_type_Int = paramContext.getResources().getColor(2131494288);
          break label171;
        }
        super.a((QQMessageFacade.Message)localObject1, a(), paramQQAppInterface, paramContext, localMsgSummary);
        break label171;
        label430:
        if (this.jdField_c_of_type_Int == 1) {
          paramQQAppInterface.append("有一条未读");
        } else if (this.jdField_c_of_type_Int == 2) {
          paramQQAppInterface.append("有两条未读");
        } else if (this.jdField_c_of_type_Int > 0) {
          paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读");
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.a = false;
      paramMsgSummary.jdField_d_of_type_JavaLangCharSequence = null;
    }
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface == null) {}
    long l1;
    do
    {
      do
      {
        return;
        paramQQAppInterface = paramQQAppInterface.a(a(), a());
      } while ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramQQAppInterface.getSummary())));
      l1 = paramQQAppInterface.getTime();
    } while (this.jdField_a_of_type_Long > l1);
    this.jdField_a_of_type_Long = l1;
    paramMsgSummary.a = true;
    paramMsgSummary.jdField_d_of_type_JavaLangCharSequence = new QQText(paramQQAppInterface.getSummary(), 3, 16);
  }
  
  public boolean a(FansEntity paramFansEntity)
  {
    boolean bool = false;
    if ((this.k != paramFansEntity.age) || (this.l != paramFansEntity.gender) || (this.m != paramFansEntity.career) || (this.n != paramFansEntity.constellation) || (this.j != paramFansEntity.vip) || (this.jdField_d_of_type_Boolean != paramFansEntity.charmIcon) || (this.o != paramFansEntity.charmLevel) || (this.p != paramFansEntity.commonId) || (!Utils.a(this.jdField_a_of_type_JavaLangString, paramFansEntity.common)))
    {
      this.k = paramFansEntity.age;
      this.l = paramFansEntity.gender;
      this.m = paramFansEntity.career;
      this.n = paramFansEntity.constellation;
      this.j = paramFansEntity.vip;
      this.jdField_d_of_type_Boolean = paramFansEntity.charmIcon;
      this.jdField_e_of_type_Boolean = true;
      this.o = paramFansEntity.charmLevel;
      this.p = paramFansEntity.commonId;
      this.jdField_a_of_type_JavaLangString = paramFansEntity.common;
      bool = true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.msg_box", 4, "haveChange:" + bool + ",FansEntity:" + paramFansEntity.toString());
    }
    return bool;
  }
  
  public long b()
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem
 * JD-Core Version:    0.7.0.1
 */