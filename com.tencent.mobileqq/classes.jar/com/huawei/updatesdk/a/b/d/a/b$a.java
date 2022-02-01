package com.huawei.updatesdk.a.b.d.a;

import java.lang.reflect.Field;
import java.security.PrivilegedAction;

class b$a
  implements PrivilegedAction
{
  private Field a;
  
  b$a(Field paramField)
  {
    this.a = paramField;
  }
  
  public Object run()
  {
    this.a.setAccessible(true);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */