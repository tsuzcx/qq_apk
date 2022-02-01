package com.tencent.avgame.business.handler;

import java.util.HashMap;
import java.util.List;

class UserInfoHandler$1
  implements Runnable
{
  UserInfoHandler$1(UserInfoHandler paramUserInfoHandler, HashMap paramHashMap, List paramList1, List paramList2) {}
  
  public void run()
  {
    UserInfoHandler.a(this.this$0, this.a, this.b, this.c);
    this.this$0.notifyUI(2, true, new Object[] { Integer.valueOf(0), this.a });
    if (this.c.size() > 0) {
      UserInfoHandler.a(this.this$0, 0, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.handler.UserInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */