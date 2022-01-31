package com.huawei.remoteLoader.client;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.IBinder;
import com.huawei.arengine.remoteLoader.ILoaderProducer;
import com.huawei.arengine.remoteLoader.ILoaderProducer.Stub;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ARRemoteLibraryLoader
{
  private static final String CREATOR_NAME = "com.huawei.arengine.service.LoaderProducer";
  private static final String TAG = ARRemoteLibraryLoader.class.getSimpleName();
  private ILoaderProducer loaderProducer;
  private Context remoteContext;
  private final a targetLibrary;
  
  public ARRemoteLibraryLoader(a parama)
  {
    this.targetLibrary = parama;
  }
  
  public static Context getRemoteContext(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.createPackageContext(paramString, 3);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new ARLoaderException(1);
    }
  }
  
  private static IBinder newBinderInstance(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = (IBinder)paramClassLoader.loadClass(paramString).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return paramClassLoader;
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      if (paramString.length() != 0) {}
      for (paramClassLoader = "No constructor for dynamic class ".concat(paramString);; paramClassLoader = new String("No constructor for dynamic class ")) {
        throw new IllegalStateException(paramClassLoader);
      }
    }
    catch (InvocationTargetException paramClassLoader)
    {
      if (paramString.length() != 0) {}
      for (paramClassLoader = "Unable to invoke constructor of dynamic class ".concat(paramString);; paramClassLoader = new String("Unable to invoke constructor of dynamic class ")) {
        throw new IllegalStateException(paramClassLoader);
      }
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      if (paramString.length() != 0) {}
      for (paramClassLoader = "Unable to find dynamic class ".concat(paramString);; paramClassLoader = new String("Unable to find dynamic class ")) {
        throw new IllegalStateException(paramClassLoader);
      }
    }
    catch (InstantiationException paramClassLoader)
    {
      if (paramString.length() != 0) {}
      for (paramClassLoader = "Unable to instantiate the remote class ".concat(paramString);; paramClassLoader = new String("Unable to instantiate the remote class ")) {
        throw new IllegalStateException(paramClassLoader);
      }
    }
    catch (IllegalAccessException paramClassLoader)
    {
      if (paramString.length() == 0) {}
    }
    for (paramClassLoader = "Unable to call the default constructor of ".concat(paramString);; paramClassLoader = new String("Unable to call the default constructor of ")) {
      throw new IllegalStateException(paramClassLoader);
    }
  }
  
  /* Error */
  public Context getRemoteContext(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 106	com/huawei/remoteLoader/client/ARRemoteLibraryLoader:remoteContext	Landroid/content/Context;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +19 -> 27
    //   11: aload_0
    //   12: aload_1
    //   13: aload_0
    //   14: getfield 32	com/huawei/remoteLoader/client/ARRemoteLibraryLoader:targetLibrary	Lcom/huawei/remoteLoader/client/a;
    //   17: invokevirtual 111	com/huawei/remoteLoader/client/a:a	()Ljava/lang/String;
    //   20: iconst_3
    //   21: invokevirtual 42	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   24: putfield 106	com/huawei/remoteLoader/client/ARRemoteLibraryLoader:remoteContext	Landroid/content/Context;
    //   27: aload_0
    //   28: getfield 106	com/huawei/remoteLoader/client/ARRemoteLibraryLoader:remoteContext	Landroid/content/Context;
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: new 44	com/huawei/remoteLoader/client/ARLoaderException
    //   40: dup
    //   41: iconst_1
    //   42: invokespecial 47	com/huawei/remoteLoader/client/ARLoaderException:<init>	(I)V
    //   45: athrow
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	ARRemoteLibraryLoader
    //   0	51	1	paramContext	Context
    //   6	2	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   11	27	36	android/content/pm/PackageManager$NameNotFoundException
    //   2	7	46	finally
    //   11	27	46	finally
    //   27	32	46	finally
    //   37	46	46	finally
  }
  
  public ILoaderProducer getRemoteCreator(Context paramContext)
  {
    try
    {
      if (this.loaderProducer == null) {
        this.loaderProducer = ILoaderProducer.Stub.asInterface(newBinderInstance(getRemoteContext(paramContext).getClassLoader(), "com.huawei.arengine.service.LoaderProducer"));
      }
      paramContext = this.loaderProducer;
      return paramContext;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.remoteLoader.client.ARRemoteLibraryLoader
 * JD-Core Version:    0.7.0.1
 */