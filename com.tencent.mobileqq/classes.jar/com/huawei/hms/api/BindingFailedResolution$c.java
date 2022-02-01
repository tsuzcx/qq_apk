package com.huawei.hms.api;

import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.ui.AbstractDialog;
import com.huawei.hms.ui.AbstractDialog.Callback;

class BindingFailedResolution$c
  implements AbstractDialog.Callback
{
  BindingFailedResolution$c(BindingFailedResolution paramBindingFailedResolution) {}
  
  public void onCancel(AbstractDialog paramAbstractDialog)
  {
    BindingFailedResolution.a(this.a, null);
    BindResolveClients.getInstance().unRegisterAll();
    BindingFailedResolution.a(this.a, 8);
  }
  
  public void onDoWork(AbstractDialog paramAbstractDialog)
  {
    BindingFailedResolution.a(this.a, null);
    BindResolveClients.getInstance().unRegisterAll();
    BindingFailedResolution.a(this.a, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.api.BindingFailedResolution.c
 * JD-Core Version:    0.7.0.1
 */