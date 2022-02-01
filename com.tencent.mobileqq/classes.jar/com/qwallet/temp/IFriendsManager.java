package com.qwallet.temp;

import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IFriendsManager
  extends IRuntimeService
{
  public abstract Friends findFriendEntityByUin(String paramString);
  
  public abstract boolean isFriend(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qwallet.temp.IFriendsManager
 * JD-Core Version:    0.7.0.1
 */