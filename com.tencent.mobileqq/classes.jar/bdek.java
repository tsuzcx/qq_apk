import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bdek
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = antf.ba + "early";
  private static boolean jdField_a_of_type_Boolean;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.filter.const", "qq.android.native.short.video.filter.const.v1", "qq.android.native.short.video.filter.const.v2", "qq.android.native.short.video.filter.const.v3", "qq.android.native.short.video.filter.const.v4", "qq.android.native.short.video.filter.const.v665", "qq.android.native.short.video.filter.const.v700" };
  private static boolean jdField_b_of_type_Boolean;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.filter.var", "qq.android.native.short.video.filter.var.v1", "qq.android.native.short.video.filter.var.v2", "qq.android.native.short.video.filter.var.v3", "qq.android.native.short.video.filter.var.v665" };
  private static boolean jdField_c_of_type_Boolean;
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString = { "qq.android.native.short.video.x86", "qq.android.native.short.video", "qq.android.native.short.video.v658", "qq.android.native.short.video.v660", "qq.android.native.short.video.v665", "qq.android.native.short.video.v670", "qq.android.native.short.video.v700" };
  private static boolean d;
  private static boolean e;
  private static boolean f;
  
  static {}
  
  public static int a()
  {
    int i;
    if (c()) {
      if (d()) {
        i = 1;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterSoLoad", 2, "getQmcfSoState:" + i);
      }
      return i;
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public static String a()
  {
    return boew.jdField_a_of_type_JavaLangString;
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      ThreadManager.post(new PtvFilterSoLoad.1(), 5, null, false);
    }
  }
  
  public static boolean a()
  {
    int i;
    if ((bdax.e(bdax.w)) || (bdax.b()))
    {
      i = 1;
      if (i == 0) {
        break label28;
      }
    }
    for (;;)
    {
      return false;
      i = 0;
      break;
      label28:
      boolean bool = llk.d();
      try
      {
        Class localClass = Class.forName("android.opengl.EGL14");
        if ((!bool) || (localClass == null) || (Build.VERSION.SDK_INT < 17)) {
          continue;
        }
        return true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  /* Error */
  public static boolean a(bori parambori)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 160	bdek:a	()Z
    //   8: istore_3
    //   9: iload_3
    //   10: ifeq +71 -> 81
    //   13: invokestatic 165	borg:a	()Lborg;
    //   16: getstatic 170	borf:c	Lborf;
    //   19: aload_0
    //   20: iconst_0
    //   21: invokevirtual 173	borg:a	(Lborf;Lbori;Z)V
    //   24: getstatic 170	borf:c	Lborf;
    //   27: invokestatic 178	bork:b	(Lborf;)Z
    //   30: istore_1
    //   31: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +42 -> 76
    //   37: ldc 180
    //   39: iconst_2
    //   40: new 27	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   47: ldc 182
    //   49: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload_1
    //   53: invokevirtual 185	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   56: ldc 187
    //   58: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload_3
    //   62: invokevirtual 185	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   65: ldc 189
    //   67: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: ldc 2
    //   78: monitorexit
    //   79: iload_1
    //   80: ireturn
    //   81: iload_2
    //   82: istore_1
    //   83: aload_0
    //   84: ifnull -53 -> 31
    //   87: aload_0
    //   88: getstatic 170	borf:c	Lborf;
    //   91: aconst_null
    //   92: iconst_0
    //   93: iconst_m1
    //   94: invokeinterface 197 5 0
    //   99: iload_2
    //   100: istore_1
    //   101: goto -70 -> 31
    //   104: astore_0
    //   105: ldc 2
    //   107: monitorexit
    //   108: aload_0
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	parambori	bori
    //   30	71	1	bool1	boolean
    //   1	99	2	bool2	boolean
    //   8	54	3	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   5	9	104	finally
    //   13	31	104	finally
    //   31	76	104	finally
    //   87	99	104	finally
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    try
    {
      boolean bool = a(paramQQAppInterface, paramContext, null);
      return bool;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  /* Error */
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, bori parambori)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: invokestatic 160	bdek:a	()Z
    //   9: istore 5
    //   11: iload 5
    //   13: ifeq +77 -> 90
    //   16: invokestatic 165	borg:a	()Lborg;
    //   19: getstatic 203	borf:b	Lborf;
    //   22: aload_2
    //   23: iconst_0
    //   24: invokevirtual 173	borg:a	(Lborf;Lbori;Z)V
    //   27: aload_0
    //   28: invokestatic 208	bcxo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   31: pop
    //   32: getstatic 203	borf:b	Lborf;
    //   35: invokestatic 178	bork:b	(Lborf;)Z
    //   38: istore_3
    //   39: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +43 -> 85
    //   45: ldc 180
    //   47: iconst_2
    //   48: new 27	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   55: ldc 210
    //   57: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_3
    //   61: invokevirtual 185	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: ldc 187
    //   66: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: iload 5
    //   71: invokevirtual 185	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   74: ldc 189
    //   76: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 192	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: ldc 2
    //   87: monitorexit
    //   88: iload_3
    //   89: ireturn
    //   90: iload 4
    //   92: istore_3
    //   93: aload_2
    //   94: ifnull -55 -> 39
    //   97: aload_2
    //   98: getstatic 203	borf:b	Lborf;
    //   101: aconst_null
    //   102: iconst_0
    //   103: iconst_m1
    //   104: invokeinterface 197 5 0
    //   109: iload 4
    //   111: istore_3
    //   112: goto -73 -> 39
    //   115: astore_0
    //   116: ldc 2
    //   118: monitorexit
    //   119: aload_0
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramQQAppInterface	QQAppInterface
    //   0	121	1	paramContext	Context
    //   0	121	2	parambori	bori
    //   38	74	3	bool1	boolean
    //   1	109	4	bool2	boolean
    //   9	61	5	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   6	11	115	finally
    //   16	39	115	finally
    //   39	85	115	finally
    //   97	109	115	finally
  }
  
  public static String b()
  {
    String str = bcwr.a();
    if (str.equals("artfilter000_0"))
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getValidArtFilterPath:pathVersion=artfilter000_0", null);
      return null;
    }
    return bcwr.b() + str + File.separator;
  }
  
  public static boolean b()
  {
    boolean bool1 = bork.a();
    boolean bool2 = VideoEnvironment.e();
    return (bool1) && (bool2);
  }
  
  public static String c()
  {
    String str = bcye.a();
    if (str.equals("Tracking000_0"))
    {
      VideoEnvironment.a("PtvFilterSoLoad", "getTrackingBasePath:pathVersion=Tracking000_0", null);
      return null;
    }
    return bcye.b() + str + File.separator;
  }
  
  private static void c()
  {
    int k = 0;
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      return;
      localObject = ((File)localObject).getAbsolutePath() + File.separator;
      int i = 0;
      File localFile;
      while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
      {
        localFile = new File((String)localObject + jdField_a_of_type_ArrayOfJavaLangString[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= jdField_b_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        localFile = new File((String)localObject + jdField_b_of_type_ArrayOfJavaLangString[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
      while (j < jdField_c_of_type_ArrayOfJavaLangString.length)
      {
        localFile = new File((String)localObject + jdField_c_of_type_ArrayOfJavaLangString[j]);
        if (localFile.exists()) {
          localFile.delete();
        }
        j += 1;
      }
    }
  }
  
  public static boolean c()
  {
    if (Build.VERSION.SDK_INT < 21) {}
    while (!QmcfManager.getInstance().isQmcfSupported()) {
      return false;
    }
    return true;
  }
  
  public static boolean d()
  {
    return bdel.a();
  }
  
  public static boolean e()
  {
    boolean bool4 = false;
    if (jdField_b_of_type_Boolean) {
      return d;
    }
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 21)
    {
      bool1 = true;
      if (bcxe.b()) {
        break label126;
      }
    }
    label126:
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool5 = bddz.i();
      boolean bool3 = bool4;
      if (bool1)
      {
        bool3 = bool4;
        if (bool2)
        {
          bool3 = bool4;
          if (bool5) {
            bool3 = true;
          }
        }
      }
      d = bool3;
      jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("PtvFilterSoLoad", 2, "isSupportPortarit sdkSupport:" + bool1 + ", whiteList:" + bool2 + ", switchOpen:" + bool5);
      }
      return d;
      bool1 = false;
      break;
    }
  }
  
  public static boolean f()
  {
    boolean bool3 = false;
    if (jdField_c_of_type_Boolean) {
      return e;
    }
    boolean bool4 = bddz.k();
    if (!bdax.d()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool5 = h();
      boolean bool2 = bool3;
      if (bool4)
      {
        bool2 = bool3;
        if (bool1)
        {
          bool2 = bool3;
          if (bool5) {
            bool2 = true;
          }
        }
      }
      e = bool2;
      jdField_c_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("PtvFilterSoLoad", 2, "isSupportARParticle switchOpen:" + bool4 + ", notInBlackList:" + bool1 + ", hasGyroscope:" + bool5 + ", isSupportARParticle:" + e);
      }
      return e;
    }
  }
  
  public static boolean g()
  {
    f = true;
    return f;
  }
  
  private static boolean h()
  {
    return BaseApplicationImpl.getContext().getPackageManager().hasSystemFeature("android.hardware.sensor.gyroscope");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdek
 * JD-Core Version:    0.7.0.1
 */