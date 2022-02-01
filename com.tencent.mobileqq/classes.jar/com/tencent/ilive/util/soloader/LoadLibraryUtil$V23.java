package com.tencent.ilive.util.soloader;

import android.util.Log;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class LoadLibraryUtil$V23
{
  private static void install(ClassLoader paramClassLoader, File paramFile)
  {
    Object localObject2 = ReflectUtil.findField(paramClassLoader, "pathList").get(paramClassLoader);
    paramClassLoader = (List)ReflectUtil.findField(localObject2, "nativeLibraryDirectories").get(localObject2);
    if (paramClassLoader == null) {
      paramClassLoader = new ArrayList(2);
    }
    for (;;)
    {
      Object localObject1 = paramClassLoader.iterator();
      while (((Iterator)localObject1).hasNext()) {
        if ((paramFile.equals((File)((Iterator)localObject1).next())) || (paramFile.equals(LoadLibraryUtil.access$300())))
        {
          ((Iterator)localObject1).remove();
          Log.d("soloaderutil", "dq libDirIt.remove() " + paramFile.getAbsolutePath());
        }
      }
      paramClassLoader.add(0, paramFile);
      localObject1 = (List)ReflectUtil.findField(localObject2, "systemNativeLibraryDirectories").get(localObject2);
      paramFile = (File)localObject1;
      if (localObject1 == null) {
        paramFile = new ArrayList(2);
      }
      Log.d("soloaderutil", "dq systemLibDirs,size=" + paramFile.size());
      localObject1 = ReflectUtil.findMethod(localObject2, "makePathElements", new Class[] { List.class, File.class, List.class });
      ArrayList localArrayList = new ArrayList();
      paramClassLoader.addAll(paramFile);
      paramClassLoader = (Object[])((Method)localObject1).invoke(localObject2, new Object[] { paramClassLoader, null, localArrayList });
      paramFile = ReflectUtil.findField(localObject2, "nativeLibraryPathElements");
      paramFile.setAccessible(true);
      paramFile.set(localObject2, paramClassLoader);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.util.soloader.LoadLibraryUtil.V23
 * JD-Core Version:    0.7.0.1
 */