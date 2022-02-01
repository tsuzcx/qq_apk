package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class QCircleChatPie$2
  extends FriendListObserver
{
  QCircleChatPie$2(QCircleChatPie paramQCircleChatPie) {}
  
  protected void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAddFriend : ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((this.a.aY()) && (paramString != null) && (paramString.equals(this.a.ah.b))) {
      QCircleChatPie.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.2
 * JD-Core Version:    0.7.0.1
 */