package com.tencent.mobileqq.ark.debug;

import android.widget.TextView;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;

class ArkIDESettingFragment$6
  extends JSDebuggerSoLoader.StatusListener
{
  ArkIDESettingFragment$6(ArkIDESettingFragment paramArkIDESettingFragment) {}
  
  public void a(int paramInt)
  {
    if (ArkIDESettingFragment.a(this.a) != null)
    {
      TextView localTextView = ArkIDESettingFragment.a(this.a);
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkIDESettingFragment.6.1(this, paramInt, localTextView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkIDESettingFragment.6
 * JD-Core Version:    0.7.0.1
 */