package com.huawei.hms.framework.common;

import java.lang.reflect.Field;
import java.security.PrivilegedAction;

final class ReflectionUtils$1
  implements PrivilegedAction
{
  ReflectionUtils$1(Field paramField) {}
  
  public Object run()
  {
    this.val$field.setAccessible(true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.ReflectionUtils.1
 * JD-Core Version:    0.7.0.1
 */