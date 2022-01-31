package com.tencent.mobileqq.apollo.activity;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.TroopVideoManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RecentHotchatItem
  extends RecentBaseData
{
  private static RecentHotchatItem jdField_a_of_type_ComTencentMobileqqApolloActivityRecentHotchatItem;
  private AioPushData jdField_a_of_type_ComTencentMobileqqDataAioPushData;
  private HotChatItemData jdField_a_of_type_ComTencentMobileqqDataHotChatItemData;
  public int j = 3;
  
  public RecentHotchatItem(HotChatItemData paramHotChatItemData)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData = paramHotChatItemData;
    if (c() > 0) {}
    for (int i = 2;; i = 1)
    {
      this.j = i;
      return;
    }
  }
  
  public static RecentHotchatItem a()
  {
    if (jdField_a_of_type_ComTencentMobileqqApolloActivityRecentHotchatItem == null)
    {
      jdField_a_of_type_ComTencentMobileqqApolloActivityRecentHotchatItem = new RecentHotchatItem(null);
      jdField_a_of_type_ComTencentMobileqqApolloActivityRecentHotchatItem.j = 4;
    }
    return jdField_a_of_type_ComTencentMobileqqApolloActivityRecentHotchatItem;
  }
  
  public int a()
  {
    return 1;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mLatestMsgSec;
  }
  
  public AioPushData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataAioPushData;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mTroopUin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    b(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("RecentHotchatItem", 2, "[update] " + c() + " " + a() + " " + a() + " " + d());
    }
    QQMessageFacade.Message localMessage = null;
    Object localObject4 = a();
    int i = a();
    Object localObject1 = paramQQAppInterface.a();
    if (localObject1 != null) {
      localMessage = ((QQMessageFacade)localObject1).a((String)localObject4, i);
    }
    label163:
    int k;
    if (localMessage != null)
    {
      this.jdField_a_of_type_Long = localMessage.time;
      localObject1 = paramQQAppInterface.a();
      if (localObject1 != null)
      {
        this.jdField_c_of_type_Int = ((ConversationFacade)localObject1).a(localMessage.frienduin, localMessage.istroop);
        if ((TroopNotificationHelper.a((String)localObject4)) || (TroopNotificationHelper.c((String)localObject4)))
        {
          this.jdField_d_of_type_JavaLangCharSequence = BaseApplicationImpl.getContext().getString(2131433521);
          this.e = paramContext.getResources().getColor(2131494294);
        }
        k = this.f;
        localObject1 = (TroopManager)paramQQAppInterface.getManager(51);
        if (localObject1 == null) {
          break label1197;
        }
      }
    }
    label287:
    label674:
    label751:
    label756:
    label889:
    Object localObject2;
    label408:
    label1197:
    for (localObject1 = ((TroopManager)localObject1).a((String)localObject4);; localObject2 = null)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = ((TroopInfo)localObject1).troopname;
        localObject1 = ((TroopInfo)localObject1).troopmemo;
      }
      for (;;)
      {
        this.f = (k & 0xFFFFF0FF | 0x100);
        long l1;
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          this.jdField_b_of_type_JavaLangString = ContactUtils.a(paramQQAppInterface, (String)localObject4, true);
          localObject4 = a();
          if ((localMessage != null) && (TextUtils.isEmpty(localMessage.nickName))) {
            localMessage.nickName = localMessage.senderuin;
          }
          a(localMessage, i, paramQQAppInterface, paramContext, (MsgSummary)localObject4);
          if ((TextUtils.isEmpty(((MsgSummary)localObject4).b)) && (TextUtils.isEmpty(((MsgSummary)localObject4).jdField_c_of_type_JavaLangCharSequence)))
          {
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = "";
            }
            ((MsgSummary)localObject4).b = ((CharSequence)localObject3);
          }
          a(paramQQAppInterface);
          a(paramQQAppInterface, (MsgSummary)localObject4);
          a(paramQQAppInterface, paramContext, (MsgSummary)localObject4);
          l1 = 0L;
        }
        try
        {
          long l2 = Long.parseLong(a());
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          boolean bool;
          break label408;
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
          this.jdField_d_of_type_JavaLangCharSequence = paramQQAppInterface.getApp().getString(2131430830);
          this.e = paramQQAppInterface.getApp().getResources().getColor(2131494294);
        }
        if ((this.jdField_b_of_type_Boolean) && (!bool))
        {
          localObject1 = String.valueOf(l1);
          ReportController.b(null, "dc00899", "Grp_video", "", "notice", "exp", 0, 0, (String)localObject1, "" + TroopUtils.a(paramQQAppInterface, (String)localObject1), "", "");
        }
        if ((TextUtils.isEmpty(this.jdField_d_of_type_JavaLangCharSequence)) && (localMessage != null) && (localObject4 != null) && (AnonymousChatHelper.a(localMessage))) {
          this.jdField_c_of_type_JavaLangCharSequence = ((MsgSummary)localObject4).a(paramContext, paramContext.getResources().getString(2131430290), -1);
        }
        this.f &= 0xFFFFFF0F;
        k = this.f;
        if (b())
        {
          i = 32;
          this.f = (i | k);
          if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mState != 1) {
            break label1010;
          }
          if ((d()) && ((!d()) || (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mIsRead4List))) {
            break label889;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentHotchatItem", 2, "[update] kicked out");
          }
          ((MsgSummary)localObject4).a();
          this.jdField_c_of_type_JavaLangCharSequence = ((MsgSummary)localObject4).a(paramContext, "房间暂停提醒，点击重新激活", -1);
          this.jdField_b_of_type_Int = 0;
          if (!AppSetting.jdField_b_of_type_Boolean) {
            break label1112;
          }
          paramQQAppInterface = new StringBuilder(24);
          paramQQAppInterface.append(this.jdField_b_of_type_JavaLangString);
          if (this.jdField_c_of_type_Int != 0) {
            break label1114;
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
          break label163;
          this.jdField_a_of_type_Long = 0L;
          this.jdField_c_of_type_Int = 0;
          break label163;
          this.jdField_b_of_type_JavaLangString = ((String)localObject3);
          break label287;
          i = 16;
          break label674;
          if ((!e()) || (c())) {
            break label751;
          }
          this.jdField_d_of_type_JavaLangCharSequence = "[新活动]";
          this.e = paramQQAppInterface.getApp().getResources().getColor(2131494294);
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataAioPushData.wording;
          ((MsgSummary)localObject4).a();
          this.jdField_c_of_type_JavaLangCharSequence = ((MsgSummary)localObject4).a(paramContext, (String)localObject1, -1);
          paramQQAppInterface = (WebProcessManager)paramQQAppInterface.getManager(12);
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a(100);
          }
          if (!QLog.isColorLevel()) {
            break label751;
          }
          QLog.d("RecentHotchatItem", 2, "[update] " + this.jdField_a_of_type_ComTencentMobileqqDataAioPushData);
          break label751;
          label1010:
          if ((e()) && (!c()))
          {
            this.jdField_d_of_type_JavaLangCharSequence = "[新活动]";
            this.e = paramQQAppInterface.getApp().getResources().getColor(2131494294);
            paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqDataAioPushData.wording;
            ((MsgSummary)localObject4).a();
            this.jdField_c_of_type_JavaLangCharSequence = ((MsgSummary)localObject4).a(paramContext, paramQQAppInterface, -1);
            if (QLog.isColorLevel()) {
              QLog.d("RecentHotchatItem", 2, "[update] " + this.jdField_a_of_type_ComTencentMobileqqDataAioPushData);
            }
          }
          this.jdField_b_of_type_Int = 3;
          break label756;
          label1112:
          break;
          label1114:
          if (this.jdField_c_of_type_Int == 1) {
            paramQQAppInterface.append("有一条未读");
          } else if (this.jdField_c_of_type_Int == 2) {
            paramQQAppInterface.append("有两条未读");
          } else if (this.jdField_c_of_type_Int > 0) {
            paramQQAppInterface.append("有").append(this.jdField_c_of_type_Int).append("条未读");
          }
        }
        localObject2 = null;
        localObject3 = null;
      }
    }
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mDraftSec;
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mGameId <= 0) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mHotChatCode)) && (paramQQAppInterface != null))
    {
      Object localObject = (ApolloDaoManager)paramQQAppInterface.getManager(154);
      if (localObject != null)
      {
        localObject = ((ApolloDaoManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mHotChatCode);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mGameId = ((ApolloGameData)localObject).gameId;
        }
      }
    }
    if ((paramQQAppInterface != null) && (c() > 0))
    {
      paramQQAppInterface = (ApolloDaoManager)paramQQAppInterface.getManager(154);
      if (paramQQAppInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqDataAioPushData = paramQQAppInterface.a(c(), c());
      }
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mIsMakeTop);
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData == null) {
      return -1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mGameId;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mHotChatCode;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData.mIsRead4List);
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataHotChatItemData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataAioPushData != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataAioPushData.isShow);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataAioPushData != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.RecentHotchatItem
 * JD-Core Version:    0.7.0.1
 */