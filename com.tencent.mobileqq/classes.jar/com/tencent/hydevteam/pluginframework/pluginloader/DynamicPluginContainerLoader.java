package com.tencent.hydevteam.pluginframework.pluginloader;

import com.tencent.hydevteam.common.annotation.API;
import java.lang.reflect.Field;

@API
public class DynamicPluginContainerLoader
{
  private static Field a()
  {
    ClassLoader localClassLoader1 = Thread.currentThread().getContextClassLoader();
    ClassLoader localClassLoader2 = localClassLoader1.getParent();
    Field[] arrayOfField = ClassLoader.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      try
      {
        boolean bool = localField.isAccessible();
        localField.setAccessible(true);
        Object localObject = localField.get(localClassLoader1);
        localField.setAccessible(bool);
        if (localObject == localClassLoader2) {
          return localField;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        i += 1;
      }
    }
    return null;
  }
  
  private static void a(ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
  {
    Field localField = a();
    if (localField == null) {
      throw new Exception("在ClassLoader.class中没找到类型为ClassLoader的parent域");
    }
    localField.setAccessible(true);
    localField.set(paramClassLoader1, paramClassLoader2);
  }
  
  private static void a(Object paramObject)
  {
    if (paramObject == null) {
      throw new AssertionError();
    }
  }
  
  /* Error */
  @API
  public void load(com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin paramInstalledPlugin)
  {
    // Byte code:
    //   0: aload_1
    //   1: instanceof 73
    //   4: ifeq +72 -> 76
    //   7: aload_1
    //   8: checkcast 73	com/tencent/hydevteam/pluginframework/installedplugin/UseDynamicPluginLoaderInstalledPlugin
    //   11: getfield 77	com/tencent/hydevteam/pluginframework/installedplugin/UseDynamicPluginLoaderInstalledPlugin:dynamicPluginLoaderVersion	Ljava/lang/String;
    //   14: invokestatic 79	com/tencent/hydevteam/pluginframework/pluginloader/DynamicPluginContainerLoader:a	(Ljava/lang/Object;)V
    //   17: aload_1
    //   18: checkcast 73	com/tencent/hydevteam/pluginframework/installedplugin/UseDynamicPluginLoaderInstalledPlugin
    //   21: getfield 83	com/tencent/hydevteam/pluginframework/installedplugin/UseDynamicPluginLoaderInstalledPlugin:dynamicPluginContainerFile	Ljava/io/File;
    //   24: invokestatic 79	com/tencent/hydevteam/pluginframework/pluginloader/DynamicPluginContainerLoader:a	(Ljava/lang/Object;)V
    //   27: aload_1
    //   28: checkcast 73	com/tencent/hydevteam/pluginframework/installedplugin/UseDynamicPluginLoaderInstalledPlugin
    //   31: astore_2
    //   32: invokestatic 20	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   35: invokevirtual 24	java/lang/Thread:getContextClassLoader	()Ljava/lang/ClassLoader;
    //   38: astore_1
    //   39: aload_1
    //   40: new 85	java/lang/StringBuilder
    //   43: dup
    //   44: ldc 87
    //   46: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   49: aload_2
    //   50: getfield 91	com/tencent/hydevteam/pluginframework/installedplugin/UseDynamicPluginLoaderInstalledPlugin:dynamicPluginContainerVersion	Ljava/lang/String;
    //   53: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 103	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   62: pop
    //   63: return
    //   64: astore_1
    //   65: new 105	com/tencent/hydevteam/pluginframework/pluginloader/exceptions/PluginContainerLoadException
    //   68: dup
    //   69: ldc 107
    //   71: aload_1
    //   72: invokespecial 110	com/tencent/hydevteam/pluginframework/pluginloader/exceptions/PluginContainerLoadException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   75: athrow
    //   76: new 105	com/tencent/hydevteam/pluginframework/pluginloader/exceptions/PluginContainerLoadException
    //   79: dup
    //   80: new 85	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   87: aload_1
    //   88: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: ldc 116
    //   93: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 73
    //   98: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokespecial 117	com/tencent/hydevteam/pluginframework/pluginloader/exceptions/PluginContainerLoadException:<init>	(Ljava/lang/String;)V
    //   107: athrow
    //   108: astore_3
    //   109: aload_1
    //   110: ldc 119
    //   112: invokevirtual 103	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   115: invokevirtual 122	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   118: invokevirtual 29	java/lang/ClassLoader:getParent	()Ljava/lang/ClassLoader;
    //   121: astore_3
    //   122: aload_1
    //   123: aload_3
    //   124: invokestatic 124	com/tencent/hydevteam/pluginframework/pluginloader/DynamicPluginContainerLoader:a	(Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)V
    //   127: aload_2
    //   128: getfield 83	com/tencent/hydevteam/pluginframework/installedplugin/UseDynamicPluginLoaderInstalledPlugin:dynamicPluginContainerFile	Ljava/io/File;
    //   131: astore_3
    //   132: aload_2
    //   133: getfield 77	com/tencent/hydevteam/pluginframework/installedplugin/UseDynamicPluginLoaderInstalledPlugin:dynamicPluginLoaderVersion	Ljava/lang/String;
    //   136: astore_2
    //   137: new 126	java/io/File
    //   140: dup
    //   141: aload_3
    //   142: invokevirtual 130	java/io/File:getParentFile	()Ljava/io/File;
    //   145: new 85	java/lang/StringBuilder
    //   148: dup
    //   149: ldc 132
    //   151: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload_2
    //   155: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokespecial 135	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   164: astore_2
    //   165: aload_2
    //   166: invokevirtual 138	java/io/File:mkdirs	()Z
    //   169: pop
    //   170: aload_1
    //   171: new 140	dalvik/system/DexClassLoader
    //   174: dup
    //   175: aload_3
    //   176: invokevirtual 143	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   179: aload_2
    //   180: invokevirtual 143	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   183: aconst_null
    //   184: aload_1
    //   185: invokevirtual 29	java/lang/ClassLoader:getParent	()Ljava/lang/ClassLoader;
    //   188: invokespecial 146	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   191: invokestatic 124	com/tencent/hydevteam/pluginframework/pluginloader/DynamicPluginContainerLoader:a	(Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)V
    //   194: return
    //   195: astore_1
    //   196: new 105	com/tencent/hydevteam/pluginframework/pluginloader/exceptions/PluginContainerLoadException
    //   199: dup
    //   200: aload_1
    //   201: invokespecial 149	com/tencent/hydevteam/pluginframework/pluginloader/exceptions/PluginContainerLoadException:<init>	(Ljava/lang/Throwable;)V
    //   204: athrow
    //   205: astore_3
    //   206: new 105	com/tencent/hydevteam/pluginframework/pluginloader/exceptions/PluginContainerLoadException
    //   209: dup
    //   210: aload_3
    //   211: invokespecial 149	com/tencent/hydevteam/pluginframework/pluginloader/exceptions/PluginContainerLoadException:<init>	(Ljava/lang/Throwable;)V
    //   214: athrow
    //   215: astore_3
    //   216: goto -89 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	DynamicPluginContainerLoader
    //   0	219	1	paramInstalledPlugin	com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin
    //   31	149	2	localObject1	Object
    //   108	1	3	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   121	55	3	localObject2	Object
    //   205	6	3	localException	Exception
    //   215	1	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   7	27	64	java/lang/AssertionError
    //   39	63	108	java/lang/ClassNotFoundException
    //   170	194	195	java/lang/Exception
    //   122	127	205	java/lang/Exception
    //   109	122	215	java/lang/ClassNotFoundException
    //   122	127	215	java/lang/ClassNotFoundException
    //   206	215	215	java/lang/ClassNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginContainerLoader
 * JD-Core Version:    0.7.0.1
 */