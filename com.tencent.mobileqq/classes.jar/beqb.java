import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class beqb
{
  private static volatile beqb jdField_a_of_type_Beqb;
  private static volatile byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  Context jdField_a_of_type_AndroidContentContext;
  @berd(a="com.tencent.qqmini.sdk.launcher.AppUIProxy")
  private beqv jdField_a_of_type_Beqv;
  private bess jdField_a_of_type_Bess;
  @berd(a="com.tencent.qqmini.sdk.ipc.AppBrandProxy")
  private besv jdField_a_of_type_Besv;
  @berd(a="com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager")
  private besw jdField_a_of_type_Besw;
  @berd(a="com.tencent.qqmini.sdk.core.MiniAppEnv")
  private besy jdField_a_of_type_Besy;
  @berd(a="com.tencent.qqmini.sdk.receiver.MainReceiverProxy")
  private beta jdField_a_of_type_Beta;
  @berd(a="com.tencent.qqmini.sdk.core.log.LogImpl")
  private betb jdField_a_of_type_Betb;
  private String jdField_a_of_type_JavaLangString;
  @berd(a="com.tencent.qqmini.sdk.minigame.ui.GameUIProxy")
  private beqv b;
  
  public static beqb a()
  {
    if (jdField_a_of_type_Beqb == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_Beqb == null) {
        jdField_a_of_type_Beqb = new beqb();
      }
      return jdField_a_of_type_Beqb;
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
      if (!paramField.isAnnotationPresent(berd.class)) {
        break;
      }
      paramField.setAccessible(true);
      str = ((berd)paramField.getAnnotation(berd.class)).a();
      localObject = berg.a().a(str);
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
    //   1: invokevirtual 85	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: invokevirtual 99	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
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
    //   23: ldc 101
    //   25: aload 4
    //   27: invokevirtual 104	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   30: if_acmpne +131 -> 161
    //   33: aload_0
    //   34: aload 4
    //   36: invokespecial 106	beqb:a	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
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
    //   55: ldc 108
    //   57: aload 4
    //   59: invokevirtual 104	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   62: if_acmpne +117 -> 179
    //   65: aload_0
    //   66: aload 4
    //   68: invokespecial 106	beqb:a	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   71: astore 4
    //   73: aload 4
    //   75: ifnull +46 -> 121
    //   78: aload 4
    //   80: invokevirtual 85	java/lang/Object:getClass	()Ljava/lang/Class;
    //   83: invokevirtual 111	java/lang/Class:getName	()Ljava/lang/String;
    //   86: ldc 75
    //   88: invokevirtual 81	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   91: ifeq +30 -> 121
    //   94: aload 4
    //   96: invokevirtual 85	java/lang/Object:getClass	()Ljava/lang/Class;
    //   99: ldc 87
    //   101: invokevirtual 93	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   104: astore 5
    //   106: aload 5
    //   108: iconst_1
    //   109: invokevirtual 54	java/lang/reflect/Field:setAccessible	(Z)V
    //   112: aload 5
    //   114: aload 4
    //   116: aload 4
    //   118: invokevirtual 73	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
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
    //   139: invokespecial 106	beqb:a	(Ljava/lang/reflect/Field;)Ljava/lang/Object;
    //   142: pop
    //   143: iload_1
    //   144: iconst_1
    //   145: iadd
    //   146: istore_1
    //   147: goto -21 -> 126
    //   150: astore 4
    //   152: ldc 113
    //   154: ldc 115
    //   156: aload 4
    //   158: invokestatic 121	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   161: iload_1
    //   162: iconst_1
    //   163: iadd
    //   164: istore_1
    //   165: goto -152 -> 13
    //   168: astore 4
    //   170: ldc 113
    //   172: ldc 123
    //   174: aload 4
    //   176: invokestatic 121	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: iload_1
    //   180: iconst_1
    //   181: iadd
    //   182: istore_1
    //   183: goto -138 -> 45
    //   186: astore 5
    //   188: ldc 113
    //   190: new 125	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   197: ldc 128
    //   199: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 4
    //   204: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: aload 5
    //   212: invokestatic 121	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   215: goto -72 -> 143
    //   218: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	beqb
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
  
  public beqv a(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return null;
    }
    if (paramMiniAppInfo.isEngineTypeMiniGame()) {
      return this.b;
    }
    return this.jdField_a_of_type_Beqv;
  }
  
  public bess a()
  {
    return this.jdField_a_of_type_Bess;
  }
  
  public besv a()
  {
    return this.jdField_a_of_type_Besv;
  }
  
  public besw a()
  {
    return this.jdField_a_of_type_Besw;
  }
  
  public besy a()
  {
    return this.jdField_a_of_type_Besy;
  }
  
  public beta a()
  {
    return this.jdField_a_of_type_Beta;
  }
  
  public Class a(String paramString)
  {
    return berg.a().a(paramString);
  }
  
  public String a()
  {
    int i = Process.myPid();
    String str1 = "";
    String str2 = str1;
    for (;;)
    {
      try
      {
        Iterator localIterator = ((ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        str2 = str1;
        Object localObject = str1;
        if (localIterator.hasNext())
        {
          str2 = str1;
          localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          str2 = str1;
          if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i)
          {
            str2 = str1;
            str1 = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
          }
        }
        else
        {
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        betc.d("minisdk-start", "getCurrentProcessName", localThrowable);
        localObject = str2;
      }
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    berg.a().a(paramContext);
    berg.a().a();
    a();
    betc.a(this.jdField_a_of_type_Betb);
    this.jdField_a_of_type_Besy.init(paramContext);
    this.jdField_a_of_type_Besv.init(paramContext);
  }
  
  public void a(bess parambess)
  {
    if (parambess != null) {
      this.jdField_a_of_type_Bess = parambess;
    }
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
        betc.d("minisdk-start", "getProcessName exception!", localThrowable);
      }
    }
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beqb
 * JD-Core Version:    0.7.0.1
 */