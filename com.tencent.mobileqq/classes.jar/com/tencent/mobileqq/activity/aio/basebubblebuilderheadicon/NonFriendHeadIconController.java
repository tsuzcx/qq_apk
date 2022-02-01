package com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilderUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.now.utils.ImageLoader;
import com.tencent.mobileqq.nearby.profilecard.MiniCardManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.qphone.base.util.QLog;

public class NonFriendHeadIconController
  extends BaseDefaultHeadIconController
{
  private Object a(ChatMessage paramChatMessage, String paramString, FriendsManager paramFriendsManager, HotChatManager paramHotChatManager)
  {
    int i = 200;
    paramHotChatManager = paramHotChatManager.a(paramChatMessage.frienduin);
    if ((paramHotChatManager != null) && (paramHotChatManager.isGameRoom)) {
      if ((paramFriendsManager.b(paramString)) || (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        paramChatMessage = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseBubbleBuilder", 2, "new head, uin = " + paramString);
      }
      return paramChatMessage;
      paramChatMessage = FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true);
      continue;
      if (paramChatMessage.istroop == 1001)
      {
        if (NearbyCardManager.a(paramString)) {
          i = 202;
        }
        paramChatMessage = FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramString, true);
      }
      else
      {
        paramChatMessage = FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true);
      }
    }
  }
  
  private void a(Object paramObject, String paramString)
  {
    a(paramObject);
    if (MiniCardManager.a(paramString))
    {
      paramObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845716);
      ImageLoader.a().a(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, MiniCardManager.a(paramString).logo.get(), paramObject, paramObject, null, true);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == 3007) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == 2007) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == 4007) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == 3019) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == 2019);
  }
  
  protected void a()
  {
    String str = BaseBubbleBuilderUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, str, (FriendsManager)localObject, localHotChatManager);
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1001)
    {
      a(localObject, str);
      return;
    }
    a(localObject);
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    String str = BaseBubbleBuilderUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    int i;
    if ((localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin)))
    {
      i = 1;
      if ((localFriendsManager == null) || (!localFriendsManager.b(str))) {
        break label198;
      }
    }
    label198:
    for (int j = 1;; j = 0)
    {
      int k = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop;
      boolean bool1;
      if ((k != 1010) && (k != 1001) && (k != 10002) && ((i == 0) || ((j != 0) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))))
      {
        bool1 = bool2;
        if (k == 1022)
        {
          bool1 = bool2;
          if (!b()) {}
        }
      }
      else
      {
        bool1 = bool2;
        if (localFriendsManager != null)
        {
          bool1 = bool2;
          if (!localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) {
            bool1 = true;
          }
        }
      }
      return bool1;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.basebubblebuilderheadicon.NonFriendHeadIconController
 * JD-Core Version:    0.7.0.1
 */