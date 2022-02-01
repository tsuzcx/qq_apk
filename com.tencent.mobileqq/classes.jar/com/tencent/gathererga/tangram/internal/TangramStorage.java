package com.tencent.gathererga.tangram.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.gathererga.ad.AdDeviceInfoService;
import com.tencent.gathererga.core.internal.component.GathererCompContext;
import com.tencent.gathererga.core.internal.component.cache.ProviderResultCache;
import com.tencent.gathererga.core.internal.util.GLog;
import com.tencent.gathererga.core.internal.util.GathererExecutor;
import com.tencent.gathererga.core.internal.util.Md5Util;
import com.tencent.gathererga.core.internal.util.SimpleCrypto;
import com.tencent.gathererga.sdk.GathererSDK;
import java.io.File;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class TangramStorage
  implements ProviderResultCache
{
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private WeakHashMap<Integer, Object> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  private ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  private String b;
  
  private String b(String paramString)
  {
    return this.jdField_a_of_type_AndroidContentContext.getDir(paramString, 0).getAbsolutePath();
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilWeakHashMap.get(Integer.valueOf(paramInt));
  }
  
  public String a(String paramString)
  {
    try
    {
      if (JSONObject.NULL.equals(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)) {
        return null;
      }
      paramString = SimpleCrypto.a(this.b, paramString);
      paramString = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = SimpleCrypto.b(this.b, paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      GLog.d(paramString.getMessage());
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 99	com/tencent/gathererga/tangram/internal/TangramStorage:jdField_a_of_type_Boolean	Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: new 101	com/tencent/gathererga/core/internal/util/AdFile
    //   11: dup
    //   12: aload_0
    //   13: getfield 103	com/tencent/gathererga/tangram/internal/TangramStorage:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: ldc 105
    //   18: ldc 107
    //   20: iconst_1
    //   21: invokespecial 110	com/tencent/gathererga/core/internal/util/AdFile:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 24	com/tencent/gathererga/tangram/internal/TangramStorage:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnull +167 -> 198
    //   34: aload_2
    //   35: invokevirtual 114	java/util/concurrent/ConcurrentHashMap:size	()I
    //   38: ifne +4 -> 42
    //   41: return
    //   42: aload_1
    //   43: invokevirtual 117	com/tencent/gathererga/core/internal/util/AdFile:a	()Z
    //   46: ifne +8 -> 54
    //   49: aload_1
    //   50: invokevirtual 119	com/tencent/gathererga/core/internal/util/AdFile:a	()V
    //   53: return
    //   54: new 60	org/json/JSONObject
    //   57: dup
    //   58: invokespecial 120	org/json/JSONObject:<init>	()V
    //   61: astore_2
    //   62: aload_0
    //   63: getfield 24	com/tencent/gathererga/tangram/internal/TangramStorage:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   66: invokevirtual 124	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   69: invokeinterface 130 1 0
    //   74: astore_3
    //   75: aload_3
    //   76: invokeinterface 135 1 0
    //   81: ifeq +36 -> 117
    //   84: aload_3
    //   85: invokeinterface 139 1 0
    //   90: checkcast 78	java/lang/String
    //   93: astore 4
    //   95: aload_2
    //   96: aload 4
    //   98: aload_0
    //   99: getfield 24	com/tencent/gathererga/tangram/internal/TangramStorage:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   102: aload 4
    //   104: invokevirtual 76	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast 78	java/lang/String
    //   110: invokevirtual 143	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   113: pop
    //   114: goto -39 -> 75
    //   117: getstatic 64	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   120: aload_2
    //   121: invokevirtual 68	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   124: ifne +58 -> 182
    //   127: new 145	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   134: astore_3
    //   135: aload_3
    //   136: ldc 148
    //   138: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_3
    //   143: aload_2
    //   144: invokevirtual 155	org/json/JSONObject:toString	()Ljava/lang/String;
    //   147: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_3
    //   152: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 158	com/tencent/gathererga/core/internal/util/GLog:b	(Ljava/lang/String;)V
    //   158: aload_1
    //   159: aload_2
    //   160: invokevirtual 155	org/json/JSONObject:toString	()Ljava/lang/String;
    //   163: invokevirtual 161	com/tencent/gathererga/core/internal/util/AdFile:a	(Ljava/lang/String;)Z
    //   166: pop
    //   167: goto +15 -> 182
    //   170: astore_2
    //   171: goto +21 -> 192
    //   174: astore_2
    //   175: aload_2
    //   176: invokevirtual 162	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   179: invokestatic 95	com/tencent/gathererga/core/internal/util/GLog:d	(Ljava/lang/String;)V
    //   182: aload_1
    //   183: invokevirtual 119	com/tencent/gathererga/core/internal/util/AdFile:a	()V
    //   186: aload_0
    //   187: iconst_0
    //   188: putfield 99	com/tencent/gathererga/tangram/internal/TangramStorage:jdField_a_of_type_Boolean	Z
    //   191: return
    //   192: aload_1
    //   193: invokevirtual 119	com/tencent/gathererga/core/internal/util/AdFile:a	()V
    //   196: aload_2
    //   197: athrow
    //   198: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	TangramStorage
    //   24	169	1	localAdFile	com.tencent.gathererga.core.internal.util.AdFile
    //   29	131	2	localObject1	Object
    //   170	1	2	localObject2	Object
    //   174	23	2	localThrowable	java.lang.Throwable
    //   74	78	3	localObject3	Object
    //   93	10	4	str	String
    // Exception table:
    //   from	to	target	type
    //   54	75	170	finally
    //   75	114	170	finally
    //   117	167	170	finally
    //   175	182	170	finally
    //   54	75	174	java/lang/Throwable
    //   75	114	174	java/lang/Throwable
    //   117	167	174	java/lang/Throwable
  }
  
  public void a(int paramInt, Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(Integer.valueOf(paramInt), paramObject);
    if (paramBoolean)
    {
      paramObject = ((AdDeviceInfoService)GathererSDK.a(AdDeviceInfoService.class)).a(Integer.valueOf(paramInt), String.valueOf(paramObject));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      a(localStringBuilder.toString(), paramObject);
    }
  }
  
  public void a(Context paramContext)
  {
    GLog.b("TangramStorage onInit");
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = b("gatherer");
    paramContext = new StringBuilder();
    paramContext.append("tangramStorage cache dir = ");
    paramContext.append(this.jdField_a_of_type_JavaLangString);
    GLog.b(paramContext.toString());
    this.b = Md5Util.a(GathererCompContext.a.a());
    GathererExecutor.a().execute(new TangramStorage.1(this));
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = SimpleCrypto.a(this.b, paramString1);
      String str = SimpleCrypto.a(this.b, paramString2);
      if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject)) || (!str.equals(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject))))
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, str);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("save string, key = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", value = ");
        ((StringBuilder)localObject).append(paramString2);
        GLog.b(((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramString1)
    {
      GLog.d(paramString1.getMessage());
    }
  }
  
  public Object b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    return a(localStringBuilder.toString());
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: new 101	com/tencent/gathererga/core/internal/util/AdFile
    //   3: dup
    //   4: aload_0
    //   5: getfield 103	com/tencent/gathererga/tangram/internal/TangramStorage:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: ldc 105
    //   10: ldc 107
    //   12: iconst_1
    //   13: invokespecial 110	com/tencent/gathererga/core/internal/util/AdFile:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual 117	com/tencent/gathererga/core/internal/util/AdFile:a	()Z
    //   21: ifne +8 -> 29
    //   24: aload_1
    //   25: invokevirtual 119	com/tencent/gathererga/core/internal/util/AdFile:a	()V
    //   28: return
    //   29: aload_1
    //   30: invokevirtual 233	com/tencent/gathererga/core/internal/util/AdFile:a	()Ljava/lang/String;
    //   33: astore_2
    //   34: new 145	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   41: astore_3
    //   42: aload_3
    //   43: ldc 235
    //   45: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_3
    //   50: aload_2
    //   51: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 158	com/tencent/gathererga/core/internal/util/GLog:b	(Ljava/lang/String;)V
    //   62: aload_2
    //   63: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifeq +8 -> 74
    //   69: aload_1
    //   70: invokevirtual 119	com/tencent/gathererga/core/internal/util/AdFile:a	()V
    //   73: return
    //   74: new 60	org/json/JSONObject
    //   77: dup
    //   78: aload_2
    //   79: invokespecial 237	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   82: astore_2
    //   83: aload_2
    //   84: invokevirtual 240	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   87: astore_3
    //   88: aload_3
    //   89: invokeinterface 135 1 0
    //   94: ifeq +49 -> 143
    //   97: aload_3
    //   98: invokeinterface 139 1 0
    //   103: checkcast 78	java/lang/String
    //   106: astore 4
    //   108: aload_2
    //   109: aload 4
    //   111: invokevirtual 243	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 5
    //   116: aload_0
    //   117: getfield 24	com/tencent/gathererga/tangram/internal/TangramStorage:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   120: aload 4
    //   122: aload 5
    //   124: invokevirtual 227	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: goto -40 -> 88
    //   131: astore_2
    //   132: goto +16 -> 148
    //   135: astore_2
    //   136: aload_2
    //   137: invokevirtual 89	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: invokestatic 95	com/tencent/gathererga/core/internal/util/GLog:d	(Ljava/lang/String;)V
    //   143: aload_1
    //   144: invokevirtual 119	com/tencent/gathererga/core/internal/util/AdFile:a	()V
    //   147: return
    //   148: aload_1
    //   149: invokevirtual 119	com/tencent/gathererga/core/internal/util/AdFile:a	()V
    //   152: goto +5 -> 157
    //   155: aload_2
    //   156: athrow
    //   157: goto -2 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	TangramStorage
    //   16	133	1	localAdFile	com.tencent.gathererga.core.internal.util.AdFile
    //   33	76	2	localObject1	Object
    //   131	1	2	localObject2	Object
    //   135	21	2	localException	Exception
    //   41	57	3	localObject3	Object
    //   106	15	4	str1	String
    //   114	9	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   74	88	131	finally
    //   88	128	131	finally
    //   136	143	131	finally
    //   74	88	135	java/lang/Exception
    //   88	128	135	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.tangram.internal.TangramStorage
 * JD-Core Version:    0.7.0.1
 */