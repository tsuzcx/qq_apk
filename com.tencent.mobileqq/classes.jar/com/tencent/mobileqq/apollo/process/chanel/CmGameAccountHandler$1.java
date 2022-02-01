package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class CmGameAccountHandler$1
  extends FriendListObserver
{
  CmGameAccountHandler$1(CmGameAccountHandler paramCmGameAccountHandler) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qwe", 2, "onUpdateFriendInfo:" + paramString);
    }
    if ((CmGameAccountHandler.a(this.a) != null) && (CmGameAccountHandler.a(this.a).get(paramString + "nick") != null))
    {
      int i = ((Integer)CmGameAccountHandler.a(this.a).remove(paramString + "nick")).intValue();
      this.a.a(i, paramString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAccountHandler.1
 * JD-Core Version:    0.7.0.1
 */