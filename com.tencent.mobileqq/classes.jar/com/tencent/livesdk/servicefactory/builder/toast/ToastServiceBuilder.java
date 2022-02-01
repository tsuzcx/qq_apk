package com.tencent.livesdk.servicefactory.builder.toast;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.toast.ToastComponent;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class ToastServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    return new ToastComponent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.toast.ToastServiceBuilder
 * JD-Core Version:    0.7.0.1
 */