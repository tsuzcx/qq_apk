package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RecentTroopAssistantItem
  extends RecentBaseData
{
  private TroopAssistantData a;
  public long b;
  
  public RecentTroopAssistantItem(TroopAssistantData paramTroopAssistantData)
  {
    this.jdField_b_of_type_Long = 5L;
    if (paramTroopAssistantData == null) {
      throw new NullPointerException("TroopAssistantData is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData = paramTroopAssistantData;
    this.jdField_b_of_type_Int = 3;
  }
  
  public int a()
  {
    return 1;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.lastmsgtime;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.troopUin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    QQMessageFacade.Message localMessage = null;
    String str = a();
    int i = a();
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {
      localMessage = ((QQMessageFacade)localObject1).a(str, i);
    }
    int j;
    if (localMessage != null)
    {
      this.jdField_a_of_type_Long = localMessage.time;
      localObject1 = paramQQAppInterface.a();
      if (localObject1 != null)
      {
        this.jdField_c_of_type_Int = ((ConversationFacade)localObject1).a(localMessage.frienduin, localMessage.istroop);
        if ((TroopNotificationHelper.a(str)) || (TroopNotificationHelper.c(str)))
        {
          this.jdField_d_of_type_JavaLangCharSequence = BaseApplicationImpl.getContext().getString(2131433490);
          this.e = paramContext.getResources().getColor(2131494281);
        }
        j = this.f;
        localObject1 = (TroopManager)paramQQAppInterface.getManager(51);
        if (localObject1 == null) {
          break label908;
        }
      }
    }
    label908:
    for (TroopInfo localTroopInfo = ((TroopManager)localObject1).a(str);; localTroopInfo = null)
    {
      Object localObject3;
      if (localTroopInfo != null)
      {
        localObject3 = localTroopInfo.getTroopName();
        localObject1 = localTroopInfo.troopmemo;
      }
      for (;;)
      {
        this.f = (j & 0xFFFFF0FF | 0x100);
        label212:
        MsgSummary localMsgSummary;
        long l1;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          this.jdField_b_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, str, true);
          localMsgSummary = a();
          if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
            localMessage.nickName = localMessage.senderuin;
          }
          a(localMessage, i, paramQQAppInterface, paramContext, localMsgSummary);
          if ((TextUtils.isEmpty(localMsgSummary.b)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence)))
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = "";
            }
            localMsgSummary.b = ((CharSequence)localObject3);
          }
          a(paramQQAppInterface);
          a(paramQQAppInterface, localMsgSummary);
          a(paramQQAppInterface, paramContext, localMsgSummary);
          l1 = 0L;
        }
        try
        {
          long l2 = Long.parseLong(a());
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label333:
          boolean bool;
          break label333;
        }
        this.jdField_a_of_type_Boolean = paramQQAppInterface.a().c(l1);
        bool = this.jdField_b_of_type_Boolean;
        this.jdField_b_of_type_Boolean = paramQQAppInterface.a().b(l1);
        if (this.jdField_b_of_type_Boolean)
        {
          localObject1 = (TroopVideoManager)paramQQAppInterface.getManager(163);
          if ((localObject1 != null) && (((TroopVideoManager)localObject1).a(a()) == 2)) {
            this.jdField_b_of_type_Boolean = false;
          }
        }
        if ((this.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)))
        {
          this.jdField_d_of_type_JavaLangCharSequence = paramQQAppInterface.getApp().getString(2131430810);
          this.e = paramQQAppInterface.getApp().getResources().getColor(2131494281);
        }
        if ((this.jdField_b_of_type_Boolean) && (!bool))
        {
          localObject1 = String.valueOf(l1);
          ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject1, "" + TroopUtils.a(paramQQAppInterface, (String)localObject1), "", "");
        }
        if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)) && (localMessage != null) && (localMsgSummary != null) && (AnonymousChatHelper.a(localMessage))) {
          this.jdField_c_of_type_JavaLangCharSequence = localMsgSummary.a(paramContext, paramContext.getResources().getString(2131430270), -1);
        }
        if (localTroopInfo != null)
        {
          this.jdField_b_of_type_Long = localTroopInfo.troopCreditLevel;
          if (this.jdField_b_of_type_Long == 0L) {
            this.jdField_b_of_type_Long = 5L;
          }
          if (QLog.isColorLevel()) {
            QLog.i("troop.credit.act", 2, "RecentTroopAssistantItem->update," + str + "," + this.jdField_b_of_type_Long);
          }
        }
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(51);
        this.f &= 0xFFFFFF0F;
        j = this.f;
        if (paramQQAppInterface.b(str))
        {
          i = 32;
          label684:
          this.f = (i | j);
          if (!AppSetting.jdField_b_of_type_Boolean) {
            break;
          }
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
          if (this.jdField_c_of_type_Int != 0) {
            break label825;
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
          this.jdField_a_of_type_Long = 0L;
          this.jdField_c_of_type_Int = 0;
          break;
          this.jdField_b_of_type_JavaLangString = ((String)localObject3);
          break label212;
          i = 16;
          break label684;
          label825:
          if (this.jdField_c_of_type_Int == 1) {
            paramQQAppInterface.append("有一条未读");
          } else if (this.jdField_c_of_type_Int == 2) {
            paramQQAppInterface.append("有两条未读");
          } else if (this.jdField_c_of_type_Int > 0) {
            paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读");
          }
        }
        Object localObject2 = null;
        localObject3 = null;
      }
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopAssistantData.lastdrafttime;
  }
  
  public long c()
  {
    return this.jdField_b_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem
 * JD-Core Version:    0.7.0.1
 */