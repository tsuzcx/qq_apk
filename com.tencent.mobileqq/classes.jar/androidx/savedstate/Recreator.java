package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"RestrictedApi"})
final class Recreator
  implements GenericLifecycleObserver
{
  static final String CLASSES_KEY = "classes_to_restore";
  static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
  private final SavedStateRegistryOwner mOwner;
  
  Recreator(SavedStateRegistryOwner paramSavedStateRegistryOwner)
  {
    this.mOwner = paramSavedStateRegistryOwner;
  }
  
  /* Error */
  private void reflectiveNew(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: ldc 2
    //   4: invokevirtual 40	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   7: invokestatic 44	java/lang/Class:forName	(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   10: ldc 46
    //   12: invokevirtual 50	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   15: astore_2
    //   16: aload_2
    //   17: iconst_0
    //   18: anewarray 36	java/lang/Class
    //   21: invokevirtual 54	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   24: astore_3
    //   25: aload_3
    //   26: iconst_1
    //   27: invokevirtual 60	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   30: aload_3
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokevirtual 64	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 46	androidx/savedstate/SavedStateRegistry$AutoRecreated
    //   41: astore_2
    //   42: aload_2
    //   43: aload_0
    //   44: getfield 25	androidx/savedstate/Recreator:mOwner	Landroidx/savedstate/SavedStateRegistryOwner;
    //   47: invokeinterface 67 2 0
    //   52: return
    //   53: astore_2
    //   54: new 69	java/lang/RuntimeException
    //   57: dup
    //   58: new 71	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   65: ldc 74
    //   67: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 80
    //   76: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: aload_2
    //   83: invokespecial 87	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: astore_1
    //   88: new 89	java/lang/IllegalStateException
    //   91: dup
    //   92: new 71	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   99: ldc 91
    //   101: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_2
    //   105: invokevirtual 94	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   108: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 96
    //   113: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: aload_1
    //   120: invokespecial 97	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: athrow
    //   124: astore_2
    //   125: new 69	java/lang/RuntimeException
    //   128: dup
    //   129: new 71	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   136: ldc 99
    //   138: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_1
    //   142: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: aload_2
    //   149: invokespecial 87	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	Recreator
    //   0	153	1	paramString	String
    //   15	28	2	localObject	Object
    //   53	52	2	localClassNotFoundException	java.lang.ClassNotFoundException
    //   124	25	2	localException	java.lang.Exception
    //   24	7	3	localConstructor	java.lang.reflect.Constructor
    // Exception table:
    //   from	to	target	type
    //   0	16	53	java/lang/ClassNotFoundException
    //   16	25	87	java/lang/NoSuchMethodException
    //   30	42	124	java/lang/Exception
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    if (paramEvent != Lifecycle.Event.ON_CREATE) {
      throw new AssertionError("Next event must be ON_CREATE");
    }
    paramLifecycleOwner.getLifecycle().removeObserver(this);
    paramLifecycleOwner = this.mOwner.getSavedStateRegistry().consumeRestoredStateForKey("androidx.savedstate.Restarter");
    if (paramLifecycleOwner == null) {}
    for (;;)
    {
      return;
      paramLifecycleOwner = paramLifecycleOwner.getStringArrayList("classes_to_restore");
      if (paramLifecycleOwner == null) {
        throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
      }
      paramLifecycleOwner = paramLifecycleOwner.iterator();
      while (paramLifecycleOwner.hasNext()) {
        reflectiveNew((String)paramLifecycleOwner.next());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.savedstate.Recreator
 * JD-Core Version:    0.7.0.1
 */