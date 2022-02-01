import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl.2;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl.3;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl.4;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class bibs
  implements bica
{
  private static int jdField_a_of_type_Int;
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  
  private String a(File paramFile1, File paramFile2, String paramString)
  {
    String str1 = paramFile1.getAbsolutePath();
    String str2 = paramFile2.getAbsolutePath() + "_temp";
    long l = IOUtil.getCRC32Value(paramFile1);
    if (l == -1L) {
      return "file not exists";
    }
    if (a(paramFile2, paramString, l))
    {
      bibq.a();
      return "sucess";
    }
    try
    {
      if (new File(str2).exists()) {
        bhmi.a(str2, false);
      }
      bhmi.d(str1, new File(str2, paramString).getAbsolutePath());
      bhmi.a(str1, str2, false);
      if (paramFile2.exists()) {
        bhmi.a(paramFile2.getAbsolutePath(), false);
      }
      QLog.d("GLDrawable", 1, "unzip succ..." + new File(str1).length() + "..." + bjtz.a(str1));
      if ((bhmi.c(str2, paramFile2.getAbsolutePath())) && (a(paramFile2, paramString, l))) {
        return "sucess";
      }
      throw new IOException("unzip file error");
    }
    catch (Exception paramFile1) {}
    try
    {
      if (paramFile2.exists()) {
        bhmi.a(paramFile2.getAbsolutePath(), false);
      }
      QLog.e("GLDrawable", 1, new Object[] { "unzip error, libDir=" + paramFile2, " zipPath=" + str1, paramFile1 });
      return "unzip " + paramFile1.getMessage();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("GLDrawable", 1, new Object[] { "unzip error, libDir=" + paramFile2, " zipPath=" + str1, paramString });
      }
    }
  }
  
  private void a(Context paramContext, String paramString, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    int i = 0;
    try
    {
      int j;
      do
      {
        if (bibq.a(paramContext))
        {
          paramRunnable1.run();
          return;
        }
        if (i == 0) {
          bibq.a();
        }
        j = i + 50;
        Thread.sleep(50L);
        i = j;
      } while (j < 8000);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.e("GLDrawable", 1, "", paramContext);
      }
    }
    paramRunnable2.run();
  }
  
  private boolean a(File paramFile, String paramString, long paramLong)
  {
    boolean bool = true;
    long l = IOUtil.getCRC32Value(new File(paramFile, paramString));
    if (l == -1L) {
      return false;
    }
    int i;
    if (l == paramLong)
    {
      i = 1;
      if ((i == 0) || (!new File(paramFile, "/lib/armeabi-v7a").exists()) || (!new File(paramFile, "/lib/arm64-v8a").exists()) || (!new File(paramFile, "/lib/x86").exists()) || (!new File(paramFile, "/lib/x86_64").exists())) {
        break label116;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label116:
      bool = false;
    }
  }
  
  private void b(bicb parambicb)
  {
    if (parambicb == null) {
      return;
    }
    if (bibw.a())
    {
      parambicb.b();
      return;
    }
    parambicb.c();
  }
  
  private void c(bicb parambicb)
  {
    if (!aroa.c().a()) {
      return;
    }
    Object localObject = new bibu();
    bibw.a((bicc)localObject);
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    String str = bibq.a(localBaseApplicationImpl);
    GLDrawableLoaderImpl.3 local3 = new GLDrawableLoaderImpl.3(this, str, localBaseApplicationImpl, (bibu)localObject, parambicb);
    localObject = new GLDrawableLoaderImpl.4(this, (bibu)localObject, parambicb);
    if (parambicb != null) {
      parambicb.a();
    }
    a(localBaseApplicationImpl, str, local3, (Runnable)localObject);
  }
  
  private boolean c()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return Process.is64Bit();
    }
    try
    {
      if (Build.VERSION.SDK_INT < 21) {
        return false;
      }
      Object localObject1 = Class.forName("dalvik.system.VMRuntime");
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = ((Class)localObject1).getDeclaredMethod("getRuntime", new Class[0]);
      if (localObject2 == null) {
        return false;
      }
      localObject2 = ((Method)localObject2).invoke(null, new Object[0]);
      if (localObject2 == null) {
        return false;
      }
      localObject1 = ((Class)localObject1).getDeclaredMethod("is64Bit", new Class[0]);
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((Method)localObject1).invoke(localObject2, new Object[0]);
      if ((localObject1 instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject1).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GLDrawable", 1, localThrowable, new Object[0]);
    }
    return false;
  }
  
  private boolean d()
  {
    boolean bool1 = VideoEnvironment.c();
    Object localObject = Build.CPU_ABI;
    if ((localObject != null) && (!"".equals(localObject)) && ("x86".equalsIgnoreCase((String)localObject))) {
      return true;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject = Build.SUPPORTED_ABIS;
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          bool2 = bool1;
          if (i >= j) {
            break;
          }
          CharSequence localCharSequence = localObject[i];
          bool2 = bool1;
          if (!TextUtils.isEmpty(localCharSequence))
          {
            bool2 = bool1;
            if (localCharSequence.toLowerCase().contains("x86")) {
              bool2 = true;
            }
          }
          i += 1;
          bool1 = bool2;
        }
      }
    }
    return bool2;
  }
  
  public void a()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    b = true;
    ThreadManagerV2.executeOnSubThread(new GLDrawableLoaderImpl.2(this));
  }
  
  /* Error */
  public void a(bicb parambicb)
  {
    // Byte code:
    //   0: getstatic 184	bibs:jdField_a_of_type_Boolean	Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: iconst_1
    //   8: putstatic 169	bibs:b	Z
    //   11: invokestatic 315	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   14: invokestatic 318	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   17: if_acmpne +3 -> 20
    //   20: getstatic 184	bibs:jdField_a_of_type_Boolean	Z
    //   23: ifne +15 -> 38
    //   26: invokestatic 174	bibw:a	()Z
    //   29: ifne +9 -> 38
    //   32: invokestatic 320	bibw:b	()Z
    //   35: ifeq +13 -> 48
    //   38: aload_0
    //   39: aload_1
    //   40: invokespecial 322	bibs:b	(Lbicb;)V
    //   43: iconst_0
    //   44: putstatic 169	bibs:b	Z
    //   47: return
    //   48: ldc 2
    //   50: monitorenter
    //   51: getstatic 184	bibs:jdField_a_of_type_Boolean	Z
    //   54: ifne +15 -> 69
    //   57: invokestatic 174	bibw:a	()Z
    //   60: ifne +9 -> 69
    //   63: invokestatic 320	bibw:b	()Z
    //   66: ifeq +16 -> 82
    //   69: aload_0
    //   70: aload_1
    //   71: invokespecial 322	bibs:b	(Lbicb;)V
    //   74: ldc 2
    //   76: monitorexit
    //   77: iconst_0
    //   78: putstatic 169	bibs:b	Z
    //   81: return
    //   82: aload_0
    //   83: aload_1
    //   84: invokespecial 324	bibs:c	(Lbicb;)V
    //   87: ldc 2
    //   89: monitorexit
    //   90: iconst_0
    //   91: putstatic 169	bibs:b	Z
    //   94: return
    //   95: astore_1
    //   96: ldc 2
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: iconst_0
    //   103: putstatic 169	bibs:b	Z
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	bibs
    //   0	108	1	parambicb	bicb
    // Exception table:
    //   from	to	target	type
    //   51	69	95	finally
    //   69	77	95	finally
    //   82	90	95	finally
    //   96	99	95	finally
    //   11	20	101	finally
    //   20	38	101	finally
    //   38	43	101	finally
    //   48	51	101	finally
    //   99	101	101	finally
  }
  
  public boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibs
 * JD-Core Version:    0.7.0.1
 */