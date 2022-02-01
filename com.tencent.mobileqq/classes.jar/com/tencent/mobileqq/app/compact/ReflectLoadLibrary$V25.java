package com.tencent.mobileqq.app.compact;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

final class ReflectLoadLibrary$V25
{
  private static void b(ClassLoader paramClassLoader, File paramFile)
  {
    paramClassLoader = ShareReflectUtil.a(paramClassLoader, "pathList").get(paramClassLoader);
    Object localObject = (List)ShareReflectUtil.a(paramClassLoader, "nativeLibraryDirectories").get(paramClassLoader);
    ((List)localObject).add(0, paramFile);
    paramFile = (List)ShareReflectUtil.a(paramClassLoader, "systemNativeLibraryDirectories").get(paramClassLoader);
    Method localMethod = ShareReflectUtil.a(paramClassLoader, "makePathElements", new Class[] { List.class });
    ((List)localObject).addAll(paramFile);
    paramFile = (Object[])localMethod.invoke(paramClassLoader, new Object[] { localObject });
    localObject = ShareReflectUtil.a(paramClassLoader, "nativeLibraryPathElements");
    ((Field)localObject).setAccessible(true);
    ((Field)localObject).set(paramClassLoader, paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.ReflectLoadLibrary.V25
 * JD-Core Version:    0.7.0.1
 */