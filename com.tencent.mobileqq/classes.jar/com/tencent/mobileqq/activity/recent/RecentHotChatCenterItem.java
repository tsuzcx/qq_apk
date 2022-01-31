package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.MsgUtils;

public class RecentHotChatCenterItem
  extends RecentUserBaseData
{
  public RecentHotChatCenterItem(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    HotChatItemData localHotChatItemData = ((HotChatCenterManager)paramQQAppInterface.getManager(254)).a();
    if ((localHotChatItemData == null) || (TextUtils.isEmpty(localHotChatItemData.mTroopUin))) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a();
    } while (paramQQAppInterface == null);
    paramQQAppInterface = paramQQAppInterface.a(localHotChatItemData.mTroopUin, 1);
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
      this.jdField_b_of_type_JavaLangString = paramContext.getString(2131439143);
    }
    MsgSummary localMsgSummary = null;
    HotChatCenterManager localHotChatCenterManager = (HotChatCenterManager)paramQQAppInterface.getManager(254);
    HotChatItemData localHotChatItemData = localHotChatCenterManager.a();
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    Object localObject = localMsgSummary;
    if (localQQMessageFacade != null)
    {
      localObject = localMsgSummary;
      if (localHotChatItemData != null) {
        localObject = localQQMessageFacade.a(localHotChatItemData.mTroopUin, 1);
      }
    }
    localMsgSummary = a();
    if (localObject != null)
    {
      this.jdField_c_of_type_Int = localHotChatCenterManager.a();
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
        if ((localHotChatItemData != null) && (localHotChatItemData.mState == 1)) {
          localMsgSummary.b = "房间暂停提醒，点击重新激活";
        }
      }
      a(paramQQAppInterface);
      a(paramQQAppInterface, localMsgSummary);
      a(paramQQAppInterface, paramContext, localMsgSummary);
      b(paramQQAppInterface, paramContext);
      if (!AppSetting.b) {
        break;
      }
      if (this.jdField_c_of_type_Int <= 0) {
        break label298;
      }
      this.jdField_d_of_type_JavaLangString = String.format("热聊房间,%d个热聊房间有新消息，%s。", new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), this.jdField_c_of_type_JavaLangString });
      return;
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Long = 0L;
    }
    label298:
    this.jdField_d_of_type_JavaLangString = String.format("热聊房间,%s，%s。", new Object[] { this.jdField_c_of_type_JavaLangCharSequence, this.jdField_c_of_type_JavaLangString });
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    super.a(paramQQAppInterface, paramContext, paramMsgSummary);
    paramQQAppInterface = ((HotChatCenterManager)paramQQAppInterface.getManager(254)).a();
    if (paramQQAppInterface != null) {
      if ((!paramQQAppInterface.mIsRead4Folder) && (!TextUtils.isEmpty(paramQQAppInterface.mADsContent))) {
        this.jdField_c_of_type_JavaLangCharSequence = (" " + paramQQAppInterface.mADsContent);
      }
    }
    while (this.jdField_c_of_type_Int <= 0)
    {
      do
      {
        return;
        if (paramQQAppInterface.mState == 1)
        {
          this.jdField_c_of_type_JavaLangCharSequence = "房间暂停提醒，点击重新激活";
          return;
        }
      } while (this.jdField_c_of_type_Int <= 0);
      this.jdField_c_of_type_JavaLangCharSequence = "";
      return;
    }
    this.jdField_c_of_type_JavaLangCharSequence = "";
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
    HotChatItemData localHotChatItemData;
    do
    {
      do
      {
        return;
        localHotChatItemData = ((HotChatCenterManager)paramQQAppInterface.getManager(254)).a();
      } while ((localHotChatItemData == null) || (TextUtils.isEmpty(localHotChatItemData.mTroopUin)) || (this.jdField_a_of_type_Long >= localHotChatItemData.mDraftSec));
      localObject = ((QQMessageFacade)localObject).a(localHotChatItemData.mTroopUin, 1);
    } while ((localObject == null) || (TextUtils.isEmpty(((DraftSummaryInfo)localObject).getSummary())));
    this.jdField_a_of_type_Long = ((DraftSummaryInfo)localObject).getTime();
    paramMsgSummary.jdField_a_of_type_Boolean = true;
    localObject = ((DraftSummaryInfo)localObject).getSummary();
    paramQQAppInterface = ContactUtils.a(paramQQAppInterface, localHotChatItemData.mTroopUin, true);
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
  
  public void b(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = ((HotChatCenterManager)paramQQAppInterface.getManager(254)).a();
    if ((paramQQAppInterface != null) && (!paramQQAppInterface.mIsRead4Folder) && (!TextUtils.isEmpty(paramQQAppInterface.mADsContent)))
    {
      this.jdField_d_of_type_JavaLangCharSequence = "[新活动]";
      this.e = paramContext.getResources().getColor(2131494294);
      return;
    }
    if ((this.jdField_c_of_type_Int > 0) && (paramQQAppInterface != null) && (paramQQAppInterface.mState != 1))
    {
      this.jdField_d_of_type_JavaLangCharSequence = String.format(paramContext.getString(2131436705), new Object[] { Integer.valueOf(this.jdField_c_of_type_Int) });
      this.e = paramContext.getResources().getColor(2131494294);
      return;
    }
    this.jdField_d_of_type_JavaLangCharSequence = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentHotChatCenterItem
 * JD-Core Version:    0.7.0.1
 */