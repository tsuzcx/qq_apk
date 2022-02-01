package com.huawei.secure.android.common.util;

import java.lang.reflect.Method;
import java.security.PrivilegedAction;

class ScreenUtil$a
  implements PrivilegedAction
{
  Method u;
  
  public ScreenUtil$a(Method paramMethod)
  {
    this.u = paramMethod;
  }
  
  public Object run()
  {
    Method localMethod = this.u;
    if (localMethod == null) {
      return null;
    }
    localMethod.setAccessible(true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.util.ScreenUtil.a
 * JD-Core Version:    0.7.0.1
 */