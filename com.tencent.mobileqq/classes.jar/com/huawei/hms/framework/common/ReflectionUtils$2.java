package com.huawei.hms.framework.common;

import java.lang.reflect.Field;
import java.security.PrivilegedAction;

final class ReflectionUtils$2
  implements PrivilegedAction
{
  ReflectionUtils$2(Field paramField) {}
  
  public Object run()
  {
    this.val$field.setAccessible(true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.ReflectionUtils.2
 * JD-Core Version:    0.7.0.1
 */