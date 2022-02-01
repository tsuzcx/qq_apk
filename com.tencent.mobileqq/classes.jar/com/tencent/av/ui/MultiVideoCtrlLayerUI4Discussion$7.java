package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.util.LogUtil;

class MultiVideoCtrlLayerUI4Discussion$7
  implements Runnable
{
  MultiVideoCtrlLayerUI4Discussion$7(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.b) {
      return;
    }
    String str1 = this.this$0.am.a(String.valueOf(this.a), String.valueOf(this.this$0.j), this.this$0.h);
    this.this$0.a.put(String.valueOf(this.a), str1);
    String str2 = this.this$0.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("refreshUI --> user name mark name=");
    localStringBuilder.append(str1);
    localStringBuilder.append(", mApp.getCurrentAccountUin()=");
    localStringBuilder.append(LogUtil.getSafePrintUin(String.valueOf(this.a)));
    localStringBuilder.append(", mMapNickNameCache.size()=");
    localStringBuilder.append(this.this$0.a.size());
    QLog.d(str2, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.7
 * JD-Core Version:    0.7.0.1
 */