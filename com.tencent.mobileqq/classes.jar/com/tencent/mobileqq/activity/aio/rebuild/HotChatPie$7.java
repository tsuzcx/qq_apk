package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class HotChatPie$7
  implements AsyncBack
{
  HotChatPie$7(HotChatPie paramHotChatPie) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b + "Q.hotchat.aio_post_list_plugin", 2, "checkUpByBusinessId:2586|param:" + paramString + "|code:" + paramInt);
    }
    paramString = this.a;
    if ((paramInt == 0) || (8 == paramInt) || (5 == paramInt)) {}
    for (boolean bool = true;; bool = false)
    {
      HotChatPie.b(paramString, bool);
      return;
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.7
 * JD-Core Version:    0.7.0.1
 */