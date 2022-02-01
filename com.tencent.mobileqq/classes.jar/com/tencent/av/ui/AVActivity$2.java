package com.tencent.av.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.av.tips.TipsUtil;
import com.tencent.mobileqq.widget.QQToast;

class AVActivity$2
  extends Handler
{
  AVActivity$2(AVActivity paramAVActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      TipsUtil.b(this.a.H, 1016);
      return;
    }
    if (paramMessage.arg1 == 1) {
      paramMessage = "开启";
    } else {
      paramMessage = "关闭";
    }
    Context localContext = this.a.getApplicationContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("请求");
    localStringBuilder.append(paramMessage);
    localStringBuilder.append("变身超时，请稍后再试。");
    QQToast.makeText(localContext, localStringBuilder.toString(), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.2
 * JD-Core Version:    0.7.0.1
 */