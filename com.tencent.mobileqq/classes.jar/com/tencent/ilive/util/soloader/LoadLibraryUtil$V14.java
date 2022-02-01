package com.tencent.ilive.util.soloader;

import java.io.File;
import java.lang.reflect.Field;

final class LoadLibraryUtil$V14
{
  private static void install(ClassLoader paramClassLoader, File paramFile)
  {
    ReflectUtil.expandFieldArray(ReflectUtil.findField(paramClassLoader, "pathList").get(paramClassLoader), "nativeLibraryDirectories", new File[] { paramFile });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.util.soloader.LoadLibraryUtil.V14
 * JD-Core Version:    0.7.0.1
 */