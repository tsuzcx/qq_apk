package com.tencent.ilive.floatwindowpermission;

import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface.OnRequestResult;
import com.tencent.falco.utils.ThreadCenter;

class FloatWindowPermission$3
  implements FloatWindowPermissionInterface.OnRequestResult
{
  FloatWindowPermission$3(FloatWindowPermission paramFloatWindowPermission, Runnable paramRunnable) {}
  
  public void onCancel()
  {
    ThreadCenter.postDefaultUITask(this.val$runnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.floatwindowpermission.FloatWindowPermission.3
 * JD-Core Version:    0.7.0.1
 */