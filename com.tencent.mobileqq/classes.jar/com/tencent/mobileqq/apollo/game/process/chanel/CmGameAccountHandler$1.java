package com.tencent.mobileqq.apollo.game.process.chanel;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class CmGameAccountHandler$1
  extends FriendListObserver
{
  CmGameAccountHandler$1(CmGameAccountHandler paramCmGameAccountHandler) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateFriendInfo:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("qwe", 2, ((StringBuilder)localObject).toString());
    }
    if (CmGameAccountHandler.a(this.a) != null)
    {
      localObject = CmGameAccountHandler.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("nick");
      if (((Map)localObject).get(localStringBuilder.toString()) != null)
      {
        localObject = CmGameAccountHandler.a(this.a);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("nick");
        int i = ((Integer)((Map)localObject).remove(localStringBuilder.toString())).intValue();
        this.a.a(i, paramString, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.chanel.CmGameAccountHandler.1
 * JD-Core Version:    0.7.0.1
 */