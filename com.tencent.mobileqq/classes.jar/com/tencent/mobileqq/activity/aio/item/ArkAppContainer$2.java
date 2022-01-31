package com.tencent.mobileqq.activity.aio.item;

import afdt;
import com.tencent.qphone.base.util.QLog;

public class ArkAppContainer$2
  implements Runnable
{
  public ArkAppContainer$2(afdt paramafdt, String paramString) {}
  
  public void run()
  {
    this.this$0.a.getAppFromLocal = true;
    this.this$0.a.endOfGetApp = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp.ArkAppContainer", 2, String.format("getAppPathByNameFromLocal.in.wrapper: %h", new Object[] { this }));
    }
    this.this$0.a(this.a, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainer.2
 * JD-Core Version:    0.7.0.1
 */