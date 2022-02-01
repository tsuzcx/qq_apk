package com.tencent.mobileqq.activity.aio.helper;

import agiy;
import axeh;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qphone.base.util.QLog;

public class MultiWindowAIOHelper$1
  implements Runnable
{
  public MultiWindowAIOHelper$1(agiy paramagiy) {}
  
  public void run()
  {
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)agiy.a(this.this$0).getHelper(15);
    if ((!BaseChatItemLayout.a) && (!localAIOLongShotHelper.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiWindowAIOHelper", 2, "AIO start multi window!");
      }
      axeh.a(agiy.a(this.this$0).mActivity, agiy.a(this.this$0).sessionInfo.curFriendUin, agiy.a(this.this$0).sessionInfo.curType, agiy.a(this.this$0).sessionInfo.curFriendNick, "open_from_aio");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.MultiWindowAIOHelper.1
 * JD-Core Version:    0.7.0.1
 */