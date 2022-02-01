package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$8$2
  implements Runnable
{
  DoubleVideoCtrlUI$8$2(DoubleVideoCtrlUI.8 param8) {}
  
  public void run()
  {
    boolean bool = this.a.this$0.a(0);
    String str = this.a.this$0.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StartGlassCheck  取消, ret[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.8.2
 * JD-Core Version:    0.7.0.1
 */