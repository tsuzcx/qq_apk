package com.tencent.mobileqq.app.parser.jumpcontroller.business;

import android.content.Intent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.parser.JumpActivityHelper;

final class ShortCutJumpSmartDeviceResultPlugin$1
  implements Runnable
{
  ShortCutJumpSmartDeviceResultPlugin$1(JumpActivity paramJumpActivity, Intent paramIntent) {}
  
  public void run()
  {
    JumpActivityHelper.a(this.a, this.b.getExtras());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.jumpcontroller.business.ShortCutJumpSmartDeviceResultPlugin.1
 * JD-Core Version:    0.7.0.1
 */