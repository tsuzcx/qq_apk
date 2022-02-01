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
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class TangramStorage
  implements ProviderResultCache
{
  private volatile boolean a;
  private volatile int b = 0;
  private ConcurrentHashMap<String, String> c = new ConcurrentHashMap();
  private String d;
  private String e;
  private Context f;
  private ConcurrentHashMap<Integer, Object> g = new ConcurrentHashMap();
  
  private String b(String paramString)
  {
    return this.f.getDir(paramString, 0).getAbsolutePath();
  }
  
  public Object a(int paramInt)
  {
    return this.g.get(Integer.valueOf(paramInt));
  }
  
  public String a(String paramString)
  {
    try
    {
      if (JSONObject.NULL.equals(this.c)) {
        return null;
      }
      paramString = SimpleCrypto.a(this.e, paramString);
      paramString = (String)this.c.get(paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = SimpleCrypto.b(this.e, paramString);
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
    //   1: getfield 101	com/tencent/gathererga/tangram/internal/TangramStorage:a	Z
    //   4: ifeq +238 -> 242
    //   7: aload_0
    //   8: getfield 26	com/tencent/gathererga/tangram/internal/TangramStorage:b	I
    //   11: iconst_2
    //   12: if_icmpeq +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 101	com/tencent/gathererga/tangram/internal/TangramStorage:a	Z
    //   22: ifeq +212 -> 234
    //   25: aload_0
    //   26: getfield 26	com/tencent/gathererga/tangram/internal/TangramStorage:b	I
    //   29: iconst_2
    //   30: if_icmpeq +6 -> 36
    //   33: goto +201 -> 234
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield 101	com/tencent/gathererga/tangram/internal/TangramStorage:a	Z
    //   41: aload_0
    //   42: iconst_3
    //   43: invokevirtual 104	com/tencent/gathererga/tangram/internal/TangramStorage:c	(I)V
    //   46: aload_0
    //   47: monitorexit
    //   48: new 106	com/tencent/gathererga/core/internal/util/AdFile
    //   51: dup
    //   52: aload_0
    //   53: getfield 108	com/tencent/gathererga/tangram/internal/TangramStorage:d	Ljava/lang/String;
    //   56: ldc 110
    //   58: ldc 112
    //   60: iconst_1
    //   61: invokespecial 115	com/tencent/gathererga/core/internal/util/AdFile:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 31	com/tencent/gathererga/tangram/internal/TangramStorage:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   69: astore_2
    //   70: aload_2
    //   71: ifnull +162 -> 233
    //   74: aload_2
    //   75: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:size	()I
    //   78: ifne +4 -> 82
    //   81: return
    //   82: aload_1
    //   83: invokevirtual 122	com/tencent/gathererga/core/internal/util/AdFile:a	()Z
    //   86: ifne +8 -> 94
    //   89: aload_1
    //   90: invokevirtual 124	com/tencent/gathererga/core/internal/util/AdFile:b	()V
    //   93: return
    //   94: new 64	org/json/JSONObject
    //   97: dup
    //   98: invokespecial 125	org/json/JSONObject:<init>	()V
    //   101: astore_2
    //   102: aload_0
    //   103: getfield 31	com/tencent/gathererga/tangram/internal/TangramStorage:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   106: invokevirtual 129	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   109: invokeinterface 135 1 0
    //   114: astore_3
    //   115: aload_3
    //   116: invokeinterface 140 1 0
    //   121: ifeq +36 -> 157
    //   124: aload_3
    //   125: invokeinterface 144 1 0
    //   130: checkcast 81	java/lang/String
    //   133: astore 4
    //   135: aload_2
    //   136: aload 4
    //   138: aload_0
    //   139: getfield 31	com/tencent/gathererga/tangram/internal/TangramStorage:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   142: aload 4
    //   144: invokevirtual 60	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   147: checkcast 81	java/lang/String
    //   150: invokevirtual 148	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   153: pop
    //   154: goto -39 -> 115
    //   157: getstatic 68	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   160: aload_2
    //   161: invokevirtual 72	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   164: ifne +58 -> 222
    //   167: new 150	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   174: astore_3
    //   175: aload_3
    //   176: ldc 153
    //   178: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_3
    //   183: aload_2
    //   184: invokevirtual 160	org/json/JSONObject:toString	()Ljava/lang/String;
    //   187: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_3
    //   192: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 163	com/tencent/gathererga/core/internal/util/GLog:b	(Ljava/lang/String;)V
    //   198: aload_1
    //   199: aload_2
    //   200: invokevirtual 160	org/json/JSONObject:toString	()Ljava/lang/String;
    //   203: invokevirtual 166	com/tencent/gathererga/core/internal/util/AdFile:a	(Ljava/lang/String;)Z
    //   206: pop
    //   207: goto +15 -> 222
    //   210: astore_2
    //   211: goto +16 -> 227
    //   214: astore_2
    //   215: aload_2
    //   216: invokevirtual 167	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   219: invokestatic 97	com/tencent/gathererga/core/internal/util/GLog:d	(Ljava/lang/String;)V
    //   222: aload_1
    //   223: invokevirtual 124	com/tencent/gathererga/core/internal/util/AdFile:b	()V
    //   226: return
    //   227: aload_1
    //   228: invokevirtual 124	com/tencent/gathererga/core/internal/util/AdFile:b	()V
    //   231: aload_2
    //   232: athrow
    //   233: return
    //   234: aload_0
    //   235: monitorexit
    //   236: return
    //   237: astore_1
    //   238: aload_0
    //   239: monitorexit
    //   240: aload_1
    //   241: athrow
    //   242: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	TangramStorage
    //   64	164	1	localAdFile	com.tencent.gathererga.core.internal.util.AdFile
    //   237	4	1	localObject1	Object
    //   69	131	2	localObject2	Object
    //   210	1	2	localObject3	Object
    //   214	18	2	localThrowable	java.lang.Throwable
    //   114	78	3	localObject4	Object
    //   133	10	4	str	String
    // Exception table:
    //   from	to	target	type
    //   94	115	210	finally
    //   115	154	210	finally
    //   157	207	210	finally
    //   215	222	210	finally
    //   94	115	214	java/lang/Throwable
    //   115	154	214	java/lang/Throwable
    //   157	207	214	java/lang/Throwable
    //   18	33	237	finally
    //   36	48	237	finally
    //   234	236	237	finally
    //   238	240	237	finally
  }
  
  public void a(int paramInt, Object paramObject, boolean paramBoolean)
  {
    this.g.put(Integer.valueOf(paramInt), paramObject);
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
    if (this.b != 0) {
      return;
    }
    try
    {
      if (this.b != 0) {
        return;
      }
      c(1);
      GLog.b("TangramStorage onInit");
      this.f = paramContext;
      this.d = b("gatherer");
      paramContext = new StringBuilder();
      paramContext.append("tangramStorage cache dir = ");
      paramContext.append(this.d);
      GLog.b(paramContext.toString());
      this.e = Md5Util.a(GathererCompContext.a.a());
      GathererExecutor.a().a(new TangramStorage.1(this));
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = SimpleCrypto.a(this.e, paramString1);
      String str = SimpleCrypto.a(this.e, paramString2);
      if ((!this.c.containsKey(localObject)) || (!str.equals(this.c.get(localObject))))
      {
        this.a = true;
        this.c.put(localObject, str);
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
    //   0: ldc 237
    //   2: invokestatic 163	com/tencent/gathererga/core/internal/util/GLog:b	(Ljava/lang/String;)V
    //   5: new 106	com/tencent/gathererga/core/internal/util/AdFile
    //   8: dup
    //   9: aload_0
    //   10: getfield 108	com/tencent/gathererga/tangram/internal/TangramStorage:d	Ljava/lang/String;
    //   13: ldc 110
    //   15: ldc 112
    //   17: iconst_1
    //   18: invokespecial 115	com/tencent/gathererga/core/internal/util/AdFile:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 122	com/tencent/gathererga/core/internal/util/AdFile:a	()Z
    //   26: ifne +13 -> 39
    //   29: ldc 239
    //   31: invokestatic 163	com/tencent/gathererga/core/internal/util/GLog:b	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokevirtual 124	com/tencent/gathererga/core/internal/util/AdFile:b	()V
    //   38: return
    //   39: aload_1
    //   40: invokevirtual 241	com/tencent/gathererga/core/internal/util/AdFile:c	()Ljava/lang/String;
    //   43: astore_2
    //   44: new 150	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   51: astore_3
    //   52: aload_3
    //   53: ldc 243
    //   55: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_3
    //   60: aload_2
    //   61: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_3
    //   66: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 163	com/tencent/gathererga/core/internal/util/GLog:b	(Ljava/lang/String;)V
    //   72: aload_2
    //   73: invokestatic 87	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifeq +8 -> 84
    //   79: aload_1
    //   80: invokevirtual 124	com/tencent/gathererga/core/internal/util/AdFile:b	()V
    //   83: return
    //   84: new 64	org/json/JSONObject
    //   87: dup
    //   88: aload_2
    //   89: invokespecial 245	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 248	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   97: astore_3
    //   98: aload_3
    //   99: invokeinterface 140 1 0
    //   104: ifeq +49 -> 153
    //   107: aload_3
    //   108: invokeinterface 144 1 0
    //   113: checkcast 81	java/lang/String
    //   116: astore 4
    //   118: aload_2
    //   119: aload 4
    //   121: invokevirtual 251	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   124: astore 5
    //   126: aload_0
    //   127: getfield 31	com/tencent/gathererga/tangram/internal/TangramStorage:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   130: aload 4
    //   132: aload 5
    //   134: invokevirtual 172	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: goto -40 -> 98
    //   141: astore_2
    //   142: goto +16 -> 158
    //   145: astore_2
    //   146: aload_2
    //   147: invokevirtual 92	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   150: invokestatic 97	com/tencent/gathererga/core/internal/util/GLog:d	(Ljava/lang/String;)V
    //   153: aload_1
    //   154: invokevirtual 124	com/tencent/gathererga/core/internal/util/AdFile:b	()V
    //   157: return
    //   158: aload_1
    //   159: invokevirtual 124	com/tencent/gathererga/core/internal/util/AdFile:b	()V
    //   162: goto +5 -> 167
    //   165: aload_2
    //   166: athrow
    //   167: goto -2 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	TangramStorage
    //   21	138	1	localAdFile	com.tencent.gathererga.core.internal.util.AdFile
    //   43	76	2	localObject1	Object
    //   141	1	2	localObject2	Object
    //   145	21	2	localException	Exception
    //   51	57	3	localObject3	Object
    //   116	15	4	str1	String
    //   124	9	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   84	98	141	finally
    //   98	138	141	finally
    //   146	153	141	finally
    //   84	98	145	java/lang/Exception
    //   98	138	145	java/lang/Exception
  }
  
  public void c(int paramInt)
  {
    try
    {
      this.b = paramInt;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.tangram.internal.TangramStorage
 * JD-Core Version:    0.7.0.1
 */