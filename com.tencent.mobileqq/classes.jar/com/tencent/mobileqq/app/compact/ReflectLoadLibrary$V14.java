package com.tencent.mobileqq.app.compact;

import java.io.File;
import java.lang.reflect.Field;

final class ReflectLoadLibrary$V14
{
  private static void b(ClassLoader paramClassLoader, File paramFile)
  {
    ShareReflectUtil.a(ShareReflectUtil.a(paramClassLoader, "pathList").get(paramClassLoader), "nativeLibraryDirectories", new File[] { paramFile });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.ReflectLoadLibrary.V14
 * JD-Core Version:    0.7.0.1
 */