package com.google.protobuf;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class UnsafeUtil$1
  implements PrivilegedExceptionAction<Unsafe>
{
  public Unsafe a()
  {
    Field[] arrayOfField = Unsafe.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfField[i];
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      if (Unsafe.class.isInstance(localObject)) {
        return (Unsafe)Unsafe.class.cast(localObject);
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnsafeUtil.1
 * JD-Core Version:    0.7.0.1
 */