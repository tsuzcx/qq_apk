package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;

class ArkFullScreenAppActivity$1
  implements ArkAppContainer.ArkAppModuleCallback
{
  ArkFullScreenAppActivity$1(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public boolean a(ArkAppContainer paramArkAppContainer)
  {
    this.a.finish();
    if (ArkFullScreenAppActivity.a(this.a)) {
      this.a.overridePendingTransition(2130772014, 2130772018);
    }
    return false;
  }
  
  public boolean a(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.1
 * JD-Core Version:    0.7.0.1
 */