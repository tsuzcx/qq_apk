import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.1;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.3;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class bcey
{
  public static final LruCache<String, bcey> a;
  public static final AtomicInteger c = new AtomicInteger(1);
  public String a;
  public final CopyOnWriteArrayList<bcfb> a;
  public final AtomicInteger a;
  public final mvs a;
  public final AtomicInteger b = new AtomicInteger(1);
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(8);
  }
  
  bcey(String paramString)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Mvs = mvs.a();
  }
  
  /* Error */
  public static bcey a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifeq +8 -> 19
    //   14: ldc 2
    //   16: monitorexit
    //   17: aload_2
    //   18: areturn
    //   19: aload_0
    //   20: ldc 62
    //   22: invokevirtual 68	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   25: ifne +12 -> 37
    //   28: aload_0
    //   29: ldc 70
    //   31: invokevirtual 68	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   34: ifeq -20 -> 14
    //   37: ldc 72
    //   39: astore_2
    //   40: aload_0
    //   41: invokestatic 78	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   44: astore_3
    //   45: aload_2
    //   46: astore_0
    //   47: aload_3
    //   48: invokevirtual 82	android/net/Uri:isHierarchical	()Z
    //   51: ifeq +10 -> 61
    //   54: aload_3
    //   55: ldc 84
    //   57: invokevirtual 88	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_0
    //   61: aload_0
    //   62: invokestatic 90	bcey:b	(Ljava/lang/String;)Lbcey;
    //   65: astore_2
    //   66: goto -52 -> 14
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   74: aload_2
    //   75: astore_0
    //   76: goto -15 -> 61
    //   79: astore_0
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramString	String
    //   9	2	1	bool	boolean
    //   1	74	2	localObject	Object
    //   44	11	3	localUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   40	45	69	java/lang/Exception
    //   47	61	69	java/lang/Exception
    //   5	10	79	finally
    //   19	28	79	finally
    //   28	37	79	finally
    //   40	45	79	finally
    //   47	61	79	finally
    //   61	66	79	finally
    //   70	74	79	finally
  }
  
  public static bcey b(String paramString)
  {
    Object localObject = null;
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        bcey localbcey = (bcey)jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
        localObject = localbcey;
        if (localbcey == null)
        {
          localObject = new bcey(paramString);
          jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramString, localObject);
        }
      }
      return localObject;
    }
    finally {}
  }
  
  public void a()
  {
    this.b.compareAndSet(2, 3);
    new Handler(Looper.getMainLooper()).post(new SwiftBrowserOfflineHandler.3(this));
  }
  
  public void a(bcfb parambcfb, String paramString)
  {
    if ((this.b.get() == 3) && (parambcfb != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserOfflineHandler", 2, "now offline bid is ready, " + this.jdField_a_of_type_JavaLangString + ", mode is " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
      }
      parambcfb.onCheckOfflineFinish(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
    }
    do
    {
      return;
      if ((parambcfb != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(parambcfb))) {
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(parambcfb);
      }
      parambcfb = new SwiftBrowserOfflineHandler.1(this, paramString);
    } while (!this.b.compareAndSet(1, 2));
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserOfflineHandler", 2, "post thread to check offline, bid = " + this.jdField_a_of_type_JavaLangString);
    }
    ThreadManager.postImmediately(parambcfb, new bcfa(this), false);
  }
  
  public boolean a()
  {
    return this.b.get() == 3;
  }
  
  public void b()
  {
    Object localObject1;
    Object localObject2;
    String str2;
    String str1;
    int i;
    int j;
    if (c.compareAndSet(1, 2))
    {
      localObject1 = this.jdField_a_of_type_Mvs.a("ex_offline", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split(",");
        localObject2 = Build.BRAND;
        str2 = Build.MODEL;
        str1 = Build.VERSION.RELEASE;
        localObject2 = new StringBuffer((String)localObject2);
        ((StringBuffer)localObject2).append(" ").append(str2);
        str2 = ((StringBuffer)localObject2).toString().toLowerCase();
        str1 = (" " + str1).toLowerCase();
        i = 0;
        j = localObject1.length;
      }
    }
    else
    {
      while (i < j)
      {
        localObject2 = localObject1[i].toLowerCase();
        if ((((String)localObject2).contains(str2)) && (str1.startsWith((String)localObject2)))
        {
          QLog.e("SwiftBrowserOfflineHandler", 1, "*****offline can not use!!! " + str1);
          c.compareAndSet(2, 4);
          return;
        }
        i += 1;
      }
    }
    c.compareAndSet(2, 3);
  }
  
  public void c()
  {
    QLog.w("SwiftBrowserOfflineHandler", 1, "now reset bid cache! " + this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
    this.b.set(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcey
 * JD-Core Version:    0.7.0.1
 */