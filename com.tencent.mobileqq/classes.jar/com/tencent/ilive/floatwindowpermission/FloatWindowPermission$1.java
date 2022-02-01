package com.tencent.ilive.floatwindowpermission;

import android.app.Dialog;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionAdapter;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface.OnRequestResult;
import com.tencent.falco.base.libapi.hostproxy.ClickEventInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.ilive.dialog.CustomizedDialog.DialogBtn;
import com.tencent.ilive.dialog.CustomizedDialog.OnDialogBtnClickListener;

class FloatWindowPermission$1
  implements CustomizedDialog.OnDialogBtnClickListener
{
  FloatWindowPermission$1(FloatWindowPermission paramFloatWindowPermission, FloatWindowPermissionInterface.OnRequestResult paramOnRequestResult) {}
  
  public void onClick(Dialog paramDialog, CustomizedDialog.DialogBtn paramDialogBtn)
  {
    this.val$onRequestResult.onCancel();
    FloatWindowPermission.access$000(this.this$0).getHostProxy().getClickEventInterface().onClickCancelAuthFloatPermission();
    FloatWindowPermission.access$100(this.this$0, "click", "点击", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.floatwindowpermission.FloatWindowPermission.1
 * JD-Core Version:    0.7.0.1
 */