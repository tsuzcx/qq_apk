package com.tencent.mobileqq.activity.troop.config;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.troop.api.config.AbsTroopTokenHandlerProcessor;

public class TroopTokenHandlerProcessor
  extends AbsTroopTokenHandlerProcessor
{
  public void a(@NonNull AppInterface paramAppInterface, @NonNull String paramString, @NonNull Object paramObject)
  {
    paramAppInterface = ((FriendsManager)((QQAppInterface)paramAppInterface).getManager(QQManagerFactory.FRIENDS_MANAGER)).m(paramString);
    if ((paramAppInterface != null) && (paramAppInterface.isFriend()))
    {
      paramString = new AllInOne(paramString, 1);
      paramString.nickname = paramAppInterface.name;
      paramString.remark = paramAppInterface.remark;
      return;
    }
    new AllInOne(paramString, 105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.troop.config.TroopTokenHandlerProcessor
 * JD-Core Version:    0.7.0.1
 */