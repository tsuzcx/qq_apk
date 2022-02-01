package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.qphone.base.util.QLog;

class HotChatPie$6
  implements AsyncBack
{
  HotChatPie$6(HotChatPie paramHotChatPie) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.b);
      ((StringBuilder)localObject).append("Q.hotchat.aio_post_list_plugin");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkUpByBusinessId:2586|param:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("|code:");
      localStringBuilder.append(paramInt);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    paramString = this.a;
    boolean bool;
    if ((paramInt != 0) && (8 != paramInt) && (5 != paramInt)) {
      bool = false;
    } else {
      bool = true;
    }
    HotChatPie.b(paramString, bool);
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.6
 * JD-Core Version:    0.7.0.1
 */