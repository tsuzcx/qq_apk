package com.huawei.updatesdk.service.c;

import android.content.Context;
import android.os.storage.StorageVolume;
import java.io.File;
import java.lang.reflect.Method;

public class h
{
  private static String[] a = null;
  
  public static String[] a()
  {
    if (a == null) {
      a = a(com.huawei.updatesdk.a.b.a.a.a().b());
    }
    return (String[])a.clone();
  }
  
  private static String[] a(Context paramContext)
  {
    String str = b(paramContext);
    return new String[] { str + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getPackageName() + File.separator + "files" };
  }
  
  /* Error */
  private static String b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 72
    //   3: invokevirtual 76	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 78	android/os/storage/StorageManager
    //   9: astore 4
    //   11: iconst_0
    //   12: anewarray 80	android/os/storage/StorageVolume
    //   15: astore_0
    //   16: ldc 78
    //   18: ldc 82
    //   20: iconst_0
    //   21: anewarray 84	java/lang/Class
    //   24: invokevirtual 88	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   27: astore 5
    //   29: aload 5
    //   31: iconst_1
    //   32: invokevirtual 94	java/lang/reflect/Method:setAccessible	(Z)V
    //   35: aload 5
    //   37: aload 4
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokevirtual 98	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 100	[Landroid/os/storage/StorageVolume;
    //   49: checkcast 100	[Landroid/os/storage/StorageVolume;
    //   52: astore 4
    //   54: aload 4
    //   56: astore_0
    //   57: aload_0
    //   58: ifnull +206 -> 264
    //   61: aload_0
    //   62: arraylength
    //   63: ifle +201 -> 264
    //   66: invokestatic 103	com/huawei/updatesdk/service/c/h:b	()Ljava/lang/reflect/Method;
    //   69: astore 5
    //   71: invokestatic 106	com/huawei/updatesdk/service/c/h:c	()Ljava/lang/reflect/Method;
    //   74: astore 6
    //   76: aload_0
    //   77: arraylength
    //   78: istore_2
    //   79: iconst_0
    //   80: istore_1
    //   81: iload_1
    //   82: iload_2
    //   83: if_icmpge +181 -> 264
    //   86: aload_0
    //   87: iload_1
    //   88: aaload
    //   89: astore 4
    //   91: aload 5
    //   93: ifnull +123 -> 216
    //   96: aload 5
    //   98: aload 4
    //   100: iconst_0
    //   101: anewarray 4	java/lang/Object
    //   104: invokevirtual 98	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 108	java/lang/Boolean
    //   110: invokevirtual 112	java/lang/Boolean:booleanValue	()Z
    //   113: istore_3
    //   114: aload 6
    //   116: aload 4
    //   118: iconst_0
    //   119: anewarray 4	java/lang/Object
    //   122: invokevirtual 98	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   125: checkcast 34	java/lang/String
    //   128: astore 4
    //   130: iload_3
    //   131: ifne +126 -> 257
    //   134: aload 4
    //   136: ldc 114
    //   138: invokevirtual 118	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   141: ifne +116 -> 257
    //   144: aload 4
    //   146: areturn
    //   147: astore 4
    //   149: ldc 120
    //   151: ldc 122
    //   153: aload 4
    //   155: invokestatic 127	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: goto -101 -> 57
    //   161: astore 4
    //   163: ldc 120
    //   165: ldc 122
    //   167: aload 4
    //   169: invokestatic 127	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   172: goto -115 -> 57
    //   175: astore 4
    //   177: ldc 120
    //   179: ldc 122
    //   181: aload 4
    //   183: invokestatic 127	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: goto -129 -> 57
    //   189: astore 7
    //   191: ldc 120
    //   193: ldc 129
    //   195: aload 7
    //   197: invokestatic 127	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: iconst_0
    //   201: istore_3
    //   202: goto -88 -> 114
    //   205: astore 7
    //   207: ldc 120
    //   209: ldc 129
    //   211: aload 7
    //   213: invokestatic 127	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   216: iconst_0
    //   217: istore_3
    //   218: goto -104 -> 114
    //   221: astore 4
    //   223: ldc 120
    //   225: ldc 131
    //   227: aload 4
    //   229: invokestatic 127	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: ldc 133
    //   234: astore 4
    //   236: goto -106 -> 130
    //   239: astore 4
    //   241: ldc 120
    //   243: ldc 131
    //   245: aload 4
    //   247: invokestatic 127	com/huawei/updatesdk/a/a/b/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: ldc 133
    //   252: astore 4
    //   254: goto -124 -> 130
    //   257: iload_1
    //   258: iconst_1
    //   259: iadd
    //   260: istore_1
    //   261: goto -180 -> 81
    //   264: aconst_null
    //   265: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramContext	Context
    //   80	181	1	i	int
    //   78	6	2	j	int
    //   113	105	3	bool	boolean
    //   9	136	4	localObject	Object
    //   147	7	4	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   161	7	4	localIllegalAccessException1	java.lang.IllegalAccessException
    //   175	7	4	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   221	7	4	localIllegalAccessException2	java.lang.IllegalAccessException
    //   234	1	4	str1	String
    //   239	7	4	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   252	1	4	str2	String
    //   27	70	5	localMethod1	Method
    //   74	41	6	localMethod2	Method
    //   189	7	7	localIllegalAccessException3	java.lang.IllegalAccessException
    //   205	7	7	localInvocationTargetException3	java.lang.reflect.InvocationTargetException
    // Exception table:
    //   from	to	target	type
    //   16	54	147	java/lang/NoSuchMethodException
    //   16	54	161	java/lang/IllegalAccessException
    //   16	54	175	java/lang/reflect/InvocationTargetException
    //   96	114	189	java/lang/IllegalAccessException
    //   96	114	205	java/lang/reflect/InvocationTargetException
    //   114	130	221	java/lang/IllegalAccessException
    //   114	130	239	java/lang/reflect/InvocationTargetException
  }
  
  private static Method b()
  {
    try
    {
      localMethod = StorageVolume.class.getMethod("isRemovable", new Class[0]);
      com.huawei.updatesdk.a.a.b.a.a.a.a("StorageManage", "can not find method:isRemovable", localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        localMethod.setAccessible(true);
        return localMethod;
      }
      catch (Exception localException2)
      {
        Method localMethod;
        break label22;
      }
      localException1 = localException1;
      localMethod = null;
    }
    label22:
    return localMethod;
  }
  
  private static Method c()
  {
    try
    {
      localMethod = StorageVolume.class.getMethod("getPath", new Class[0]);
      com.huawei.updatesdk.a.a.b.a.a.a.a("StorageManage", "can not find method:getPath", localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        localMethod.setAccessible(true);
        return localMethod;
      }
      catch (Exception localException2)
      {
        Method localMethod;
        break label22;
      }
      localException1 = localException1;
      localMethod = null;
    }
    label22:
    return localMethod;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.c.h
 * JD-Core Version:    0.7.0.1
 */