import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class bdle
{
  private static volatile bdle jdField_a_of_type_Bdle;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  Context jdField_a_of_type_AndroidContentContext;
  @bdmc(a="com.tencent.qqmini.sdk.launcher.AppUIProxy")
  private bdlu jdField_a_of_type_Bdlu;
  private bdnm jdField_a_of_type_Bdnm;
  @bdmc(a="com.tencent.qqmini.sdk.ipc.AppBrandProxy")
  private bdnp jdField_a_of_type_Bdnp;
  @bdmc(a="com.tencent.qqmini.sdk.core.Build")
  private bdnq jdField_a_of_type_Bdnq;
  @bdmc(a="com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager")
  private bdnr jdField_a_of_type_Bdnr;
  @bdmc(a="com.tencent.qqmini.sdk.core.MiniAppEnv")
  private bdnt jdField_a_of_type_Bdnt;
  @bdmc(a="com.tencent.qqmini.sdk.receiver.MainReceiverProxy")
  private bdnu jdField_a_of_type_Bdnu;
  @bdmc(a="com.tencent.qqmini.sdk.core.log.LogImpl")
  private bdnv jdField_a_of_type_Bdnv;
  private String jdField_a_of_type_JavaLangString;
  @bdmc(a="com.tencent.qqmini.sdk.minigame.ui.GameUIProxy")
  private bdlu b;
  
  public static bdle a()
  {
    if (jdField_a_of_type_Bdle == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Bdle == null) {
        jdField_a_of_type_Bdle = new bdle();
      }
      return jdField_a_of_type_Bdle;
    }
  }
  
  private Object a(Field paramField)
  {
    Object localObject = paramField.get(this);
    if (localObject != null) {
      paramField = localObject;
    }
    String str;
    do
    {
      return paramField;
      if (!paramField.isAnnotationPresent(bdmc.class)) {
        break;
      }
      paramField.setAccessible(true);
      str = ((bdmc)paramField.getAnnotation(bdmc.class)).a();
      localObject = bdmg.a().a(str);
      paramField.set(this, localObject);
      paramField = localObject;
    } while (!str.contains("MiniAppEnv"));
    paramField = localObject.getClass().getDeclaredField("sInstance");
    paramField.setAccessible(true);
    paramField.set(localObject, localObject);
    return localObject;
    return null;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 87	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: invokevirtual 101	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   7: astore_3
    //   8: aload_3
    //   9: arraylength
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_1
    //   13: iload_1
    //   14: iload_2
    //   15: if_icmpge +25 -> 40
    //   18: aload_3
    //   19: iload_1
    //   20: aaload
    //   21: astore 4
    //   23: ldc 103
    //   25: aload 4
    //   27: invokevirtual 106	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   30: if_acmpne +131 -> 161
    //   33: aload_0
    //   34: aload 4
    //   36: invokespecial 108	bdle:a	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   39: pop
    //   40: aload_3
    //   41: arraylength
    //   42: istore_2
    //   43: iconst_0
    //   44: istore_1
    //   45: iload_1
    //   46: iload_2
    //   47: if_icmpge +74 -> 121
    //   50: aload_3
    //   51: iload_1
    //   52: aaload
    //   53: astore 4
    //   55: ldc 110
    //   57: aload 4
    //   59: invokevirtual 106	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   62: if_acmpne +117 -> 179
    //   65: aload_0
    //   66: aload 4
    //   68: invokespecial 108	bdle:a	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   71: astore 4
    //   73: aload 4
    //   75: ifnull +46 -> 121
    //   78: aload 4
    //   80: invokevirtual 87	java/lang/Object:getClass	()Ljava/lang/Class;
    //   83: invokevirtual 113	java/lang/Class:getName	()Ljava/lang/String;
    //   86: ldc 77
    //   88: invokevirtual 83	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   91: ifeq +30 -> 121
    //   94: aload 4
    //   96: invokevirtual 87	java/lang/Object:getClass	()Ljava/lang/Class;
    //   99: ldc 89
    //   101: invokevirtual 95	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   104: astore 5
    //   106: aload 5
    //   108: iconst_1
    //   109: invokevirtual 56	java/lang/reflect/Field:setAccessible	(Z)V
    //   112: aload 5
    //   114: aload 4
    //   116: aload 4
    //   118: invokevirtual 75	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   121: aload_3
    //   122: arraylength
    //   123: istore_2
    //   124: iconst_0
    //   125: istore_1
    //   126: iload_1
    //   127: iload_2
    //   128: if_icmpge +90 -> 218
    //   131: aload_3
    //   132: iload_1
    //   133: aaload
    //   134: astore 4
    //   136: aload_0
    //   137: aload 4
    //   139: invokespecial 108	bdle:a	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   142: pop
    //   143: iload_1
    //   144: iconst_1
    //   145: iadd
    //   146: istore_1
    //   147: goto -21 -> 126
    //   150: astore 4
    //   152: ldc 115
    //   154: ldc 117
    //   156: aload 4
    //   158: invokestatic 123	bdnw:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: iload_1
    //   162: iconst_1
    //   163: iadd
    //   164: istore_1
    //   165: goto -152 -> 13
    //   168: astore 4
    //   170: ldc 115
    //   172: ldc 117
    //   174: aload 4
    //   176: invokestatic 123	bdnw:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: iload_1
    //   180: iconst_1
    //   181: iadd
    //   182: istore_1
    //   183: goto -138 -> 45
    //   186: astore 5
    //   188: ldc 115
    //   190: new 125	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   197: ldc 128
    //   199: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 4
    //   204: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: aload 5
    //   212: invokestatic 123	bdnw:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   215: goto -72 -> 143
    //   218: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	bdle
    //   12	171	1	i	int
    //   10	119	2	j	int
    //   7	125	3	arrayOfField	Field[]
    //   21	117	4	localObject	Object
    //   150	7	4	localThrowable1	Throwable
    //   168	35	4	localThrowable2	Throwable
    //   104	9	5	localField	Field
    //   186	25	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   23	40	150	java/lang/Throwable
    //   55	73	168	java/lang/Throwable
    //   78	121	168	java/lang/Throwable
    //   136	143	186	java/lang/Throwable
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public bdlu a(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    if (paramMiniAppInfo.isEngineTypeMiniGame()) {
      return this.b;
    }
    return this.jdField_a_of_type_Bdlu;
  }
  
  public bdnm a()
  {
    return this.jdField_a_of_type_Bdnm;
  }
  
  public bdnp a()
  {
    return this.jdField_a_of_type_Bdnp;
  }
  
  public bdnq a()
  {
    return this.jdField_a_of_type_Bdnq;
  }
  
  public bdnr a()
  {
    return this.jdField_a_of_type_Bdnr;
  }
  
  public bdnu a()
  {
    return this.jdField_a_of_type_Bdnu;
  }
  
  public Class a(String paramString)
  {
    return bdmg.a().a(paramString);
  }
  
  public String a()
  {
    int i = Process.myPid();
    String str = "";
    Object localObject2 = (ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity");
    Object localObject1 = str;
    if (localObject2 != null)
    {
      localObject1 = str;
      if (((ActivityManager)localObject2).getRunningAppProcesses() != null)
      {
        localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses().iterator();
        localObject1 = str;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
          if (((ActivityManager.RunningAppProcessInfo)localObject1).pid != i) {
            break label91;
          }
          str = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
        }
      }
    }
    label91:
    for (;;)
    {
      break;
      return localObject1;
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    bdmg.a().a(paramContext);
    bdmg.a().a();
    a();
    bdnw.a(this.jdField_a_of_type_Bdnv);
    this.jdField_a_of_type_Bdnt.init(paramContext);
    this.jdField_a_of_type_Bdnp.init(paramContext);
  }
  
  public void a(bdnm parambdnm)
  {
    if (parambdnm == null) {}
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getPackageName().equals(a());
  }
  
  public String b()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    try
    {
      Object localObject = (ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity");
      int i = Process.myPid();
      localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if (localRunningAppProcessInfo.pid == i) {
          this.jdField_a_of_type_JavaLangString = localRunningAppProcessInfo.processName;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bdnw.d("minisdk-start", "getProcessName exception!", localThrowable);
      }
    }
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdle
 * JD-Core Version:    0.7.0.1
 */