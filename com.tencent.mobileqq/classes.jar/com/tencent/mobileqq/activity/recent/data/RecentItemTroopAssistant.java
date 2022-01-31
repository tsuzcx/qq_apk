package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;

public class RecentItemTroopAssistant
  extends RecentUserBaseData
{
  public RecentItemTroopAssistant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_c_of_type_Int > 0)
    {
      this.jdField_d_of_type_JavaLangCharSequence = String.format(paramContext.getString(2131436704), new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      this.e = paramContext.getResources().getColor(2131494294);
      return;
    }
    this.jdField_d_of_type_JavaLangCharSequence = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    TroopAssistantData localTroopAssistantData = TroopAssistantManager.a().a(paramQQAppInterface);
    if ((localTroopAssistantData == null) || (TextUtils.isEmpty(localTroopAssistantData.troopUin))) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.a(localTroopAssistantData.troopUin, 1);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
    {
      this.jdField_a_of_type_Int = 4;
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = paramContext.getString(2131435202);
    }
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    TroopAssistantManager localTroopAssistantManager;
    Object localObject;
    if (localQQMessageFacade != null)
    {
      localTroopAssistantManager = TroopAssistantManager.a();
      localObject = localTroopAssistantManager.a(paramQQAppInterface);
      if (localObject != null) {
        localObject = localQQMessageFacade.a(((TroopAssistantData)localObject).troopUin, 1);
      }
    }
    for (;;)
    {
      MsgSummary localMsgSummary = a();
      if (localObject != null)
      {
        this.jdField_c_of_type_Int = localTroopAssistantManager.a(localQQMessageFacade);
        if (QLog.isColorLevel()) {
          QLog.i("RecentItemTroopAssistant", 2, "mUnreadNum :" + this.jdField_c_of_type_Int);
        }
        this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject).time;
        a((QQMessageFacade.Message)localObject, 1, paramQQAppInterface, paramContext, localMsgSummary);
        if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775806L)) {
          this.jdField_c_of_type_JavaLangString = TimeManager.a().a(a(), this.jdField_a_of_type_Long);
        }
      }
      for (;;)
      {
        if ((TextUtils.isEmpty(localMsgSummary.b)) && (TextUtils.isEmpty(localMsgSummary.jdField_c_of_type_JavaLangCharSequence)))
        {
          localMsgSummary.jdField_a_of_type_JavaLangCharSequence = null;
          localMsgSummary.b = paramContext.getString(2131435203);
        }
        a(paramQQAppInterface);
        a(paramQQAppInterface, localMsgSummary);
        a(paramQQAppInterface, paramContext, localMsgSummary);
        a(paramContext);
        if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)) && (localObject != null) && (localMsgSummary != null) && (AnonymousChatHelper.a((MessageRecord)localObject))) {
          this.jdField_c_of_type_JavaLangCharSequence = localMsgSummary.a(paramContext, paramContext.getResources().getString(2131430290), -1);
        }
        if (!AppSetting.b) {
          break;
        }
        if (this.jdField_c_of_type_Int <= 0) {
          break label351;
        }
        this.jdField_d_of_type_JavaLangString = String.format("群助手,%d个群有新消息，%s。", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_c_of_type_JavaLangString });
        return;
        this.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Long = 0L;
      }
      label351:
      this.jdField_d_of_type_JavaLangString = String.format("群助手,%s，%s。", new Object[] { this.jdField_c_of_type_JavaLangCharSequence, this.jdField_c_of_type_JavaLangString });
      return;
      localObject = null;
      continue;
      localTroopAssistantManager = null;
      localObject = null;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.a(paramQQAppInterface, paramContext, paramMsgSummary);
    if (this.jdField_c_of_type_Int > 0) {
      this.jdField_c_of_type_JavaLangCharSequence = "";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    if (paramMsgSummary != null)
    {
      paramMsgSummary.jdField_a_of_type_Boolean = false;
      paramMsgSummary.jdField_d_of_type_JavaLangCharSequence = null;
    }
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {}
    TroopAssistantData localTroopAssistantData;
    do
    {
      do
      {
        return;
        localTroopAssistantData = TroopAssistantManager.a().a(paramQQAppInterface);
      } while ((localTroopAssistantData == null) || (TextUtils.isEmpty(localTroopAssistantData.troopUin)) || (this.jdField_a_of_type_Long >= localTroopAssistantData.lastdrafttime));
      localObject = ((QQMessageFacade)localObject).a(localTroopAssistantData.troopUin, 1);
    } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
    this.jdField_a_of_type_Long = ((DraftSummaryInfo)localObject).getTime();
    paramMsgSummary.jdField_a_of_type_Boolean = true;
    localObject = ((DraftSummaryInfo)localObject).getSummary();
    paramQQAppInterface = ContactUtils.a(paramQQAppInterface, localTroopAssistantData.troopUin, true);
    paramMsgSummary.jdField_d_of_type_JavaLangCharSequence = new QQText(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
  
  protected void a(QQMessageFacade.Message paramMessage, int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    String str = ContactUtils.a(paramQQAppInterface, paramMessage.frienduin, true);
    MsgUtils.a(paramContext, paramQQAppInterface, paramMessage, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramMsgSummary, str, false, false);
    if ((paramMessage.istroop == 1) && (MsgProxyUtils.k(paramMessage.msgtype))) {
      paramMsgSummary.jdField_a_of_type_JavaLangCharSequence = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemTroopAssistant
 * JD-Core Version:    0.7.0.1
 */