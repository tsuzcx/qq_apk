package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.MsgUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class RecentItemEcShopAssitant
  extends RecentUserBaseData
{
  long b;
  
  public RecentItemEcShopAssitant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_b_of_type_Int = 2;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_c_of_type_Int > 0)
    {
      this.jdField_d_of_type_JavaLangCharSequence = "[新消息]";
      this.e = paramContext.getResources().getColor(2131494288);
      return;
    }
    this.jdField_d_of_type_JavaLangCharSequence = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    super.a(paramQQAppInterface, paramContext);
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = paramContext.getString(2131437935);
    }
    if (!TextUtils.isEmpty(EcShopAssistantManager.jdField_c_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = EcShopAssistantManager.jdField_c_of_type_JavaLangString;
    }
    Object localObject2 = null;
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
    Object localObject3 = paramQQAppInterface.a();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      EcShopData localEcShopData = localEcShopAssistantManager.a();
      localObject1 = localObject2;
      if (localEcShopData != null) {
        localObject1 = ((QQMessageFacade)localObject3).a(localEcShopData.mUin, 1008);
      }
    }
    localObject3 = super.a();
    int i;
    if (localObject1 != null)
    {
      this.jdField_c_of_type_Int = localEcShopAssistantManager.a(paramQQAppInterface);
      this.jdField_a_of_type_Long = ((QQMessageFacade.Message)localObject1).time;
      localObject2 = localEcShopAssistantManager.a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).frienduin);
      if (localObject1 != null)
      {
        MsgUtils.a(paramContext, paramQQAppInterface, (QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, (MsgSummary)localObject3, (String)localObject2, true, false);
        i = ((QQMessageFacade.Message)localObject1).msgtype;
        if ((i == -3006) || (i == -5004))
        {
          ((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence = "";
          ((MsgSummary)localObject3).b = "";
          localObject2 = XMLMessageUtils.a((MessageRecord)localObject1);
          if ((localObject2 != null) && (((PAMessage)localObject2).items != null) && (((PAMessage)localObject2).items.size() != 0)) {
            break label817;
          }
          a((QQMessageFacade.Message)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.type, paramQQAppInterface, paramContext, (MsgSummary)localObject3);
        }
      }
      label261:
      localObject2 = paramQQAppInterface.getCurrentAccountUin();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "noLogin";
      }
      localObject1 = paramContext.getSharedPreferences("ecshop_sp" + (String)localObject1, 0);
      i = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
      localEcShopAssistantManager.d = false;
      if ((i <= this.jdField_a_of_type_Long) && ((!TextUtils.isEmpty(((MsgSummary)localObject3).b)) || (!TextUtils.isEmpty(((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence)))) {
        break label1051;
      }
      long l = i;
      this.jdField_a_of_type_Long = l;
      this.jdField_b_of_type_Long = l;
      if (this.jdField_a_of_type_ComTencentMobileqqDataRecentUser != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataRecentUser.lastmsgtime = this.jdField_a_of_type_Long;
      }
      localObject2 = ((SharedPreferences)localObject1).getString("str_ecshop_diy", null);
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label946;
      }
      localEcShopAssistantManager.d = true;
      ((MsgSummary)localObject3).b = ((CharSequence)localObject2);
      ((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence = null;
      ((MsgSummary)localObject3).jdField_a_of_type_JavaLangCharSequence = null;
      label438:
      this.e = paramContext.getResources().getColor(2131494288);
      if (!((SharedPreferences)localObject1).contains("PUSH_TYPE_COLOR")) {}
    }
    for (;;)
    {
      try
      {
        this.e = Color.parseColor(((SharedPreferences)localObject1).getString("PUSH_TYPE_COLOR", ""));
        if (((SharedPreferences)localObject1).getBoolean("folder_reddot", false))
        {
          int j = ((SharedPreferences)localObject1).getInt("last_show_time1", 0);
          int k = ((SharedPreferences)localObject1).getInt("reddot_start", 0);
          int m = ((SharedPreferences)localObject1).getInt("reddot_end", 0);
          int n = ((SharedPreferences)localObject1).getInt("max_reddot_time", 0);
          int i1 = (int)(System.currentTimeMillis() / 1000L);
          if ((i1 != 0) && (k != 0) && (m != 0) && (n != 0))
          {
            if ((i1 >= k) && (i1 <= m) && (i1 - j < n))
            {
              localEcShopAssistantManager.e = true;
              if (i > this.jdField_a_of_type_Long) {
                this.jdField_a_of_type_Long = i;
              }
              this.jdField_d_of_type_JavaLangCharSequence = ((SharedPreferences)localObject1).getString("PUSH_TYPE_NAME", "");
            }
          }
          else
          {
            a(paramQQAppInterface, (MsgSummary)localObject3);
            a(paramQQAppInterface, paramContext, (MsgSummary)localObject3);
            if ((this.jdField_c_of_type_Int == 0) && (localEcShopAssistantManager.e)) {
              this.jdField_c_of_type_Int = 1;
            }
            if (AppSetting.b)
            {
              paramQQAppInterface = new StringBuilder();
              paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString).append(",");
              if (this.jdField_c_of_type_Int > 0)
              {
                i = localEcShopAssistantManager.a();
                if ((i != 0) && (!localEcShopAssistantManager.e)) {
                  break label1059;
                }
              }
              if (this.jdField_d_of_type_JavaLangCharSequence != null) {
                paramQQAppInterface.append(this.jdField_d_of_type_JavaLangCharSequence + ",");
              }
              if (this.jdField_c_of_type_Int <= 0) {
                break label1116;
              }
              paramQQAppInterface.append(this.jdField_c_of_type_JavaLangString);
              this.jdField_d_of_type_JavaLangString = paramQQAppInterface.toString();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("EcShop", 2, "first string to show:" + ((MsgSummary)localObject3).jdField_a_of_type_JavaLangCharSequence);
            return;
            label817:
            localObject1 = ((PAMessage.Item)((PAMessage)localObject2).items.get(0)).title;
            if ((((PAMessage.Item)((PAMessage)localObject2).items.get(0)).cover == null) && (((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList != null))
            {
              localObject1 = (String)localObject1 + "：" + (String)((PAMessage.Item)((PAMessage)localObject2).items.get(0)).digestList.get(0);
              ((MsgSummary)localObject3).b = ((CharSequence)localObject1);
              break label261;
            }
            continue;
            this.jdField_c_of_type_Int = 0;
            this.jdField_a_of_type_Long = 0L;
            break label261;
            label946:
            if (!TextUtils.isEmpty(((MsgSummary)localObject3).jdField_c_of_type_JavaLangCharSequence)) {
              break label438;
            }
            ((MsgSummary)localObject3).b = paramContext.getString(2131437936);
            ((MsgSummary)localObject3).jdField_a_of_type_JavaLangCharSequence = null;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("RecentItemEcShopAssitant", 1, "parse color exception.");
        this.e = paramContext.getResources().getColor(2131494288);
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("EcShopAssistantActivity", 2, "reddot out of date!");
        }
        localEcShopAssistantManager.e = false;
        this.jdField_c_of_type_Int = 0;
        this.jdField_d_of_type_JavaLangCharSequence = "";
        continue;
        this.jdField_d_of_type_JavaLangCharSequence = "";
        continue;
      }
      label1051:
      a(paramContext);
      continue;
      label1059:
      if (i == 1)
      {
        paramQQAppInterface.append("有一条未读");
      }
      else if (i == 2)
      {
        paramQQAppInterface.append("有两条未读");
      }
      else if (i > 0)
      {
        paramQQAppInterface.append("有").append(i).append("条未读,");
        continue;
        label1116:
        paramQQAppInterface.append(this.jdField_c_of_type_JavaLangCharSequence).append(",").append(this.jdField_c_of_type_JavaLangString);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MsgSummary paramMsgSummary)
  {
    EcShopData localEcShopData = null;
    this.jdField_a_of_type_Int = 0;
    if (paramMsgSummary != null)
    {
      paramMsgSummary.jdField_a_of_type_Boolean = false;
      paramMsgSummary.jdField_d_of_type_JavaLangCharSequence = null;
    }
    Object localObject = paramQQAppInterface.a();
    if (localObject == null) {}
    do
    {
      EcShopAssistantManager localEcShopAssistantManager;
      do
      {
        do
        {
          return;
          localEcShopAssistantManager = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
          if (localEcShopAssistantManager != null) {
            localEcShopData = localEcShopAssistantManager.a();
          }
        } while ((localEcShopData == null) || (TextUtils.isEmpty(localEcShopData.mUin)) || (this.jdField_a_of_type_Long >= localEcShopData.mLastDraftTime) || (this.jdField_b_of_type_Long > localEcShopData.mLastDraftTime));
        this.jdField_a_of_type_Int = 4;
        localObject = ((QQMessageFacade)localObject).a(localEcShopData.mUin, 1008);
      } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
      this.jdField_a_of_type_Long = ((DraftSummaryInfo)localObject).getTime();
      localObject = ((DraftSummaryInfo)localObject).getSummary();
      paramQQAppInterface = localEcShopAssistantManager.a(paramQQAppInterface, localEcShopData.mUin);
    } while (paramMsgSummary == null);
    paramMsgSummary.jdField_a_of_type_Boolean = true;
    paramMsgSummary.jdField_d_of_type_JavaLangCharSequence = new QQText(paramQQAppInterface + ": " + (String)localObject, 3, 16);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentItemEcShopAssitant
 * JD-Core Version:    0.7.0.1
 */