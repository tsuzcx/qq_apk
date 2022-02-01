package com.tencent.livesdk.servicefactory.builder.floatwindowpermission;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilive.floatwindowpermission.FloatWindowPermission;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;

public class FloatWindowPermissionBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    FloatWindowPermission localFloatWindowPermission = new FloatWindowPermission();
    localFloatWindowPermission.init(new FloatWindowPermissionBuilder.1(this, paramServiceAccessor));
    return localFloatWindowPermission;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.floatwindowpermission.FloatWindowPermissionBuilder
 * JD-Core Version:    0.7.0.1
 */