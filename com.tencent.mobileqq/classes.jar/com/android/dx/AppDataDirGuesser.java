package com.android.dx;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class AppDataDirGuesser
{
  private String getPathFromThisClassLoader(ClassLoader paramClassLoader, Class<?> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredField("path");
      paramClass.setAccessible(true);
      paramClass = (String)paramClass.get(paramClassLoader);
      return paramClass;
    }
    catch (ClassCastException paramClass)
    {
      return processClassLoaderString(paramClassLoader.toString());
    }
    catch (IllegalAccessException paramClass)
    {
      break label24;
    }
    catch (NoSuchFieldException paramClass)
    {
      label24:
      break label24;
    }
  }
  
  private ClassLoader guessSuitableClassLoader()
  {
    return AppDataDirGuesser.class.getClassLoader();
  }
  
  static String processClassLoaderString(String paramString)
  {
    if (paramString.contains("DexPathList")) {
      return processClassLoaderString43OrLater(paramString);
    }
    return processClassLoaderString42OrEarlier(paramString);
  }
  
  private static String processClassLoaderString42OrEarlier(String paramString)
  {
    int i = paramString.lastIndexOf('[');
    if (i == -1) {}
    for (;;)
    {
      i = paramString.indexOf(']');
      if (i != -1) {
        break;
      }
      return paramString;
      paramString = paramString.substring(i + 1);
    }
    return paramString.substring(0, i);
  }
  
  private static String processClassLoaderString43OrLater(String paramString)
  {
    int j = 0;
    int i = paramString.indexOf("DexPathList") + "DexPathList".length();
    Object localObject = paramString;
    if (paramString.length() > i + 4)
    {
      String str = paramString.substring(i);
      i = str.indexOf(']');
      localObject = paramString;
      if (str.charAt(0) == '[')
      {
        localObject = paramString;
        if (str.charAt(1) == '[')
        {
          localObject = paramString;
          if (i >= 0)
          {
            paramString = str.substring(2, i).split(",");
            i = 0;
            while (i < paramString.length)
            {
              k = paramString[i].indexOf('"');
              int m = paramString[i].lastIndexOf('"');
              if ((k > 0) && (k < m)) {
                paramString[i] = paramString[i].substring(k + 1, m);
              }
              i += 1;
            }
            localObject = new StringBuilder();
            int k = paramString.length;
            i = j;
            while (i < k)
            {
              str = paramString[i];
              if (((StringBuilder)localObject).length() > 0) {
                ((StringBuilder)localObject).append(':');
              }
              ((StringBuilder)localObject).append(str);
              i += 1;
            }
            localObject = ((StringBuilder)localObject).toString();
          }
        }
      }
    }
    return localObject;
  }
  
  static String[] splitPathList(String paramString)
  {
    int i;
    int j;
    if (paramString.startsWith("dexPath="))
    {
      i = "dexPath=".length();
      j = paramString.indexOf(',');
      if (j == -1) {
        paramString = paramString.substring(i);
      }
    }
    for (;;)
    {
      return paramString.split(":");
      paramString = paramString.substring(i, j);
    }
  }
  
  boolean fileOrDirExists(File paramFile)
  {
    return paramFile.exists();
  }
  
  public File guess()
  {
    try
    {
      Object localObject = guessSuitableClassLoader();
      Class localClass = Class.forName("dalvik.system.PathClassLoader");
      localClass.cast(localObject);
      localObject = guessPath(getPathFromThisClassLoader((ClassLoader)localObject, localClass));
      if (localObject.length > 0)
      {
        localObject = localObject[0];
        return localObject;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return null;
    }
    catch (ClassCastException localClassCastException)
    {
      label40:
      break label40;
    }
  }
  
  File[] guessPath(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = splitPathList(paramString);
    int m = paramString.length;
    int i = 0;
    Object localObject;
    int n;
    int j;
    if (i < m)
    {
      localObject = paramString[i];
      if (!((String)localObject).startsWith("/data/app/")) {}
      do
      {
        i += 1;
        break;
        n = "/data/app/".length();
        j = ((String)localObject).lastIndexOf(".apk");
      } while (j != ((String)localObject).length() - 4);
      int k = ((String)localObject).indexOf("-");
      if (k == -1) {
        break label213;
      }
      j = k;
    }
    label213:
    for (;;)
    {
      localObject = ((String)localObject).substring(n, j);
      localObject = new File("/data/data/" + (String)localObject);
      if (!isWriteableDirectory((File)localObject)) {
        break;
      }
      localObject = new File((File)localObject, "cache");
      if (((!fileOrDirExists((File)localObject)) && (!((File)localObject).mkdir())) || (!isWriteableDirectory((File)localObject))) {
        break;
      }
      localArrayList.add(localObject);
      break;
      return (File[])localArrayList.toArray(new File[localArrayList.size()]);
    }
  }
  
  boolean isWriteableDirectory(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.canWrite());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.AppDataDirGuesser
 * JD-Core Version:    0.7.0.1
 */