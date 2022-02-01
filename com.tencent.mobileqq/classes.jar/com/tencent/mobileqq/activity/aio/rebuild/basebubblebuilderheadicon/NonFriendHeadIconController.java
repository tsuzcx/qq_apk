package com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon;

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
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.nearby.profilecard.MiniCardManagerUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.qphone.base.util.QLog;

public class NonFriendHeadIconController
  extends BaseDefaultHeadIconController
{
  private Object a(ChatMessage paramChatMessage, String paramString, FriendsManager paramFriendsManager, HotChatManager paramHotChatManager)
  {
    paramHotChatManager = paramHotChatManager.a(paramChatMessage.frienduin);
    int i = 200;
    if ((paramHotChatManager != null) && (paramHotChatManager.isGameRoom))
    {
      if ((!paramFriendsManager.b(paramString)) && (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        paramChatMessage = FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true);
      } else {
        paramChatMessage = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramString);
      }
    }
    else if (paramChatMessage.istroop == 1001)
    {
      if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(paramString)) {
        i = 202;
      }
      paramChatMessage = FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, paramString, true);
    }
    else
    {
      paramChatMessage = FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 200, paramString, true);
    }
    if (QLog.isColorLevel())
    {
      paramFriendsManager = new StringBuilder();
      paramFriendsManager.append("new head, uin = ");
      paramFriendsManager.append(paramString);
      QLog.d("BaseBubbleBuilder", 2, paramFriendsManager.toString());
    }
    return paramChatMessage;
  }
  
  private void a(Object paramObject, String paramString)
  {
    b(paramObject);
    if (MiniCardManagerUtils.a(paramString))
    {
      paramObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845589);
      ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(this.jdField_a_of_type_ComTencentMobileqqVasAvatarVasAvatar, MiniCardManagerUtils.a(paramString).logo.get(), paramObject, paramObject, null, true);
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == 3007) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == 2007) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == 4007) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == 3019) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d == 2019);
  }
  
  public boolean a()
  {
    String str = BaseBubbleBuilderUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    int i;
    if ((localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((localFriendsManager != null) && (localFriendsManager.b(str))) {
      j = 1;
    } else {
      j = 0;
    }
    int k = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop;
    return ((k == 1010) || (k == 1001) || (k == 10002) || ((i != 0) && ((j == 0) || (str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))) || ((k == 1022) && (b()))) && (localFriendsManager != null) && (!localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
  }
  
  protected void b()
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
    b(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.NonFriendHeadIconController
 * JD-Core Version:    0.7.0.1
 */