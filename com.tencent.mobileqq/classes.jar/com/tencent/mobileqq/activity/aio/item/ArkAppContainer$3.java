package com.tencent.mobileqq.activity.aio.item;

import com.tencent.qphone.base.util.QLog;

class ArkAppContainer$3
  implements Runnable
{
  ArkAppContainer$3(ArkAppContainer paramArkAppContainer, String paramString) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppContainer.3
 * JD-Core Version:    0.7.0.1
 */