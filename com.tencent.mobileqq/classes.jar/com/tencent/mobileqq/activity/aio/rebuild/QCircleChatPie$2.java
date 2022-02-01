package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

class QCircleChatPie$2
  extends FriendListObserver
{
  QCircleChatPie$2(QCircleChatPie paramQCircleChatPie) {}
  
  public void onAddFriend(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onAddFriend : " + paramString);
    }
    if ((this.a.t()) && (paramString != null) && (paramString.equals(this.a.a.a))) {
      QCircleChatPie.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.QCircleChatPie.2
 * JD-Core Version:    0.7.0.1
 */