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
    paramHotChatManager = paramHotChatManager.c(paramChatMessage.frienduin);
    int i = 200;
    if ((paramHotChatManager != null) && (paramHotChatManager.isGameRoom))
    {
      if ((!paramFriendsManager.n(paramString)) && (!paramString.equals(this.b.getCurrentAccountUin()))) {
        paramChatMessage = FaceDrawable.getStrangerFaceDrawable(this.b, 200, paramString, true);
      } else {
        paramChatMessage = FaceDrawable.getFaceDrawable(this.b, 1, paramString);
      }
    }
    else if (paramChatMessage.istroop == 1001)
    {
      if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(paramString)) {
        i = 202;
      }
      paramChatMessage = FaceDrawable.getStrangerFaceDrawable(this.b, i, paramString, true);
    }
    else
    {
      paramChatMessage = FaceDrawable.getStrangerFaceDrawable(this.b, 200, paramString, true);
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
      paramObject = this.c.getResources().getDrawable(2130847053);
      ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(this.e, MiniCardManagerUtils.b(paramString).logo.get(), paramObject, paramObject, null, true);
    }
  }
  
  private boolean k()
  {
    return (this.d.t == 3007) || (this.d.t == 2007) || (this.d.t == 4007) || (this.d.t == 3019) || (this.d.t == 2019);
  }
  
  protected void b()
  {
    String str = BaseBubbleBuilderUtil.a(this.b, this.a);
    Object localObject = (FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
    HotChatManager localHotChatManager = (HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    localObject = a(this.a, str, (FriendsManager)localObject, localHotChatManager);
    if (this.a.istroop == 1001)
    {
      a(localObject, str);
      return;
    }
    b(localObject);
  }
  
  public boolean h()
  {
    String str = BaseBubbleBuilderUtil.a(this.b, this.a);
    FriendsManager localFriendsManager = (FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
    HotChatManager localHotChatManager = (HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    int i;
    if ((localHotChatManager != null) && (localHotChatManager.b(this.a.frienduin))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((localFriendsManager != null) && (localFriendsManager.n(str))) {
      j = 1;
    } else {
      j = 0;
    }
    int k = this.a.istroop;
    return ((k == 1010) || (k == 1001) || (k == 10002) || ((i != 0) && ((j == 0) || (str.equals(this.b.getCurrentAccountUin())))) || ((k == 1022) && (k()))) && (localFriendsManager != null) && (!localFriendsManager.n(this.d.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.basebubblebuilderheadicon.NonFriendHeadIconController
 * JD-Core Version:    0.7.0.1
 */