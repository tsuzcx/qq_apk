package com.heytap.mcssdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import com.heytap.mcssdk.f.e;
import com.heytap.mcssdk.f.g;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  implements b
{
  private static final int[] a = { 99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115 };
  private static final int[] b = { 99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69 };
  private static int c = 0;
  private static String d;
  private static boolean e;
  private final Object f = new Object();
  private Context g;
  private List<com.heytap.mcssdk.e.c> h = new ArrayList();
  private List<com.heytap.mcssdk.d.d> i = new ArrayList();
  private String j;
  private String k;
  private String l = null;
  private ICallBackResultService m;
  
  private d()
  {
    try
    {
      if (c <= 0)
      {
        c += 1;
        a(new com.heytap.mcssdk.d.b());
        a(new com.heytap.mcssdk.d.a());
        a(new com.heytap.mcssdk.e.b());
        a(new com.heytap.mcssdk.e.a());
        return;
      }
      throw new RuntimeException("PushService can't create again!");
    }
    finally {}
  }
  
  public static d a()
  {
    return d.a.a();
  }
  
  private String a(Context paramContext)
  {
    Object localObject = new Intent("com.mcs.action.RECEIVE_SDK_MESSAGE");
    localObject = paramContext.getPackageManager().queryIntentServices((Intent)localObject, 8192);
    String str;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext()) {
        str = ((ResolveInfo)((Iterator)localObject).next()).serviceInfo.packageName;
      }
    }
    for (;;)
    {
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        int i1 = 0;
        if ((localPackageManager.getApplicationInfo(str, 0).flags & 0x1) != 1) {
          break label151;
        }
        n = 1;
        int i2 = paramContext.getPackageManager().getPackageUid(str, 0);
        int i3 = paramContext.getPackageManager().getPackageUid("android", 0);
        if (i2 == i3) {
          i1 = 1;
        }
        if ((n == 0) && (i1 == 0)) {
          break;
        }
        return str;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
      return null;
      break;
      label151:
      int n = 0;
    }
  }
  
  private void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    synchronized (this.f)
    {
      paramString = b(paramInt, paramString, paramJSONObject);
      this.g.startService(paramString);
      return;
    }
  }
  
  public static void a(Context paramContext, MessageStat paramMessageStat)
  {
    e.a(paramContext, paramMessageStat);
  }
  
  public static void a(Context paramContext, List<MessageStat> paramList)
  {
    e.a(paramContext, paramList);
  }
  
  private void a(com.heytap.mcssdk.d.d paramd)
  {
    if (paramd != null) {}
    try
    {
      this.i.add(paramd);
    }
    finally {}
  }
  
  private void a(com.heytap.mcssdk.e.c paramc)
  {
    if (paramc != null) {}
    try
    {
      this.h.add(paramc);
    }
    finally {}
  }
  
  /* Error */
  private Intent b(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: new 92	android/content/Intent
    //   3: dup
    //   4: invokespecial 179	android/content/Intent:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: aload_0
    //   12: invokevirtual 182	com/heytap/mcssdk/d:c	()Ljava/lang/String;
    //   15: invokevirtual 186	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   18: pop
    //   19: aload 4
    //   21: aload_0
    //   22: invokevirtual 188	com/heytap/mcssdk/d:b	()Ljava/lang/String;
    //   25: invokevirtual 191	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   28: pop
    //   29: aload 4
    //   31: ldc 193
    //   33: iload_1
    //   34: invokevirtual 197	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   37: pop
    //   38: new 199	org/json/JSONObject
    //   41: dup
    //   42: invokespecial 200	org/json/JSONObject:<init>	()V
    //   45: astore 5
    //   47: aload 5
    //   49: ldc 202
    //   51: aload_0
    //   52: getfield 82	com/heytap/mcssdk/d:g	Landroid/content/Context;
    //   55: aload_0
    //   56: getfield 82	com/heytap/mcssdk/d:g	Landroid/content/Context;
    //   59: invokevirtual 205	android/content/Context:getPackageName	()Ljava/lang/String;
    //   62: invokestatic 210	com/heytap/mcssdk/f/g:c	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   65: invokevirtual 214	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   68: pop
    //   69: aload 5
    //   71: ldc 216
    //   73: aload_0
    //   74: getfield 82	com/heytap/mcssdk/d:g	Landroid/content/Context;
    //   77: aload_0
    //   78: getfield 82	com/heytap/mcssdk/d:g	Landroid/content/Context;
    //   81: invokevirtual 205	android/content/Context:getPackageName	()Ljava/lang/String;
    //   84: invokestatic 219	com/heytap/mcssdk/f/g:b	(Landroid/content/Context;Ljava/lang/String;)I
    //   87: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: invokevirtual 214	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   93: pop
    //   94: aload_3
    //   95: ifnull +64 -> 159
    //   98: aload_3
    //   99: invokevirtual 228	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   102: astore 6
    //   104: aload 6
    //   106: invokeinterface 124 1 0
    //   111: ifeq +48 -> 159
    //   114: aload 6
    //   116: invokeinterface 128 1 0
    //   121: checkcast 230	java/lang/String
    //   124: astore 7
    //   126: aload 5
    //   128: aload 7
    //   130: aload_3
    //   131: aload 7
    //   133: invokevirtual 234	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   136: invokevirtual 214	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   139: pop
    //   140: goto -36 -> 104
    //   143: astore_2
    //   144: aload 4
    //   146: ldc 236
    //   148: aload 5
    //   150: invokevirtual 239	org/json/JSONObject:toString	()Ljava/lang/String;
    //   153: invokevirtual 242	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   156: pop
    //   157: aload_2
    //   158: athrow
    //   159: aload 4
    //   161: ldc 236
    //   163: aload 5
    //   165: invokevirtual 239	org/json/JSONObject:toString	()Ljava/lang/String;
    //   168: invokevirtual 242	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   171: pop
    //   172: aload 4
    //   174: ldc 244
    //   176: aload_2
    //   177: invokevirtual 242	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   180: pop
    //   181: aload 4
    //   183: ldc 246
    //   185: aload_0
    //   186: getfield 82	com/heytap/mcssdk/d:g	Landroid/content/Context;
    //   189: invokevirtual 205	android/content/Context:getPackageName	()Ljava/lang/String;
    //   192: invokevirtual 242	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   195: pop
    //   196: aload 4
    //   198: ldc 248
    //   200: aload_0
    //   201: getfield 250	com/heytap/mcssdk/d:j	Ljava/lang/String;
    //   204: invokevirtual 242	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   207: pop
    //   208: aload 4
    //   210: ldc 252
    //   212: aload_0
    //   213: getfield 254	com/heytap/mcssdk/d:k	Ljava/lang/String;
    //   216: invokevirtual 242	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   219: pop
    //   220: aload 4
    //   222: ldc_w 256
    //   225: aload_0
    //   226: getfield 52	com/heytap/mcssdk/d:l	Ljava/lang/String;
    //   229: invokevirtual 242	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   232: pop
    //   233: aload 4
    //   235: ldc_w 258
    //   238: invokestatic 260	com/heytap/mcssdk/d:j	()Ljava/lang/String;
    //   241: invokevirtual 242	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   244: pop
    //   245: aload 4
    //   247: areturn
    //   248: astore_3
    //   249: goto -90 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	d
    //   0	252	1	paramInt	int
    //   0	252	2	paramString	String
    //   0	252	3	paramJSONObject	JSONObject
    //   7	239	4	localIntent	Intent
    //   45	119	5	localJSONObject	JSONObject
    //   102	13	6	localIterator	Iterator
    //   124	8	7	str	String
    // Exception table:
    //   from	to	target	type
    //   47	94	143	finally
    //   98	104	143	finally
    //   104	140	143	finally
    //   47	94	248	java/lang/Exception
    //   98	104	248	java/lang/Exception
    //   104	140	248	java/lang/Exception
  }
  
  private void b(int paramInt, JSONObject paramJSONObject)
  {
    a(paramInt, "", paramJSONObject);
  }
  
  public static String j()
  {
    return "2.1.0";
  }
  
  private boolean n()
  {
    return this.g != null;
  }
  
  private boolean o()
  {
    return this.l != null;
  }
  
  private boolean p()
  {
    return (n()) && (o());
  }
  
  public d a(Context paramContext, boolean paramBoolean)
  {
    this.g = paramContext.getApplicationContext();
    new com.heytap.mcssdk.b.a().a(this.g);
    com.heytap.mcssdk.f.c.a(paramBoolean);
    return this;
  }
  
  public void a(int paramInt)
  {
    Intent localIntent = b(paramInt, "", null);
    this.g.bindService(localIntent, new d.1(this, localIntent), 1);
  }
  
  public void a(int paramInt, JSONObject paramJSONObject)
  {
    if (p())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      a(12307, localStringBuilder.toString(), paramJSONObject);
      return;
    }
    com.heytap.mcssdk.f.c.a("mcssdk---", "please call the register first!");
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject, ICallBackResultService paramICallBackResultService)
  {
    if (paramContext == null)
    {
      if (paramICallBackResultService != null) {
        paramICallBackResultService.onRegister(-2, null);
      }
      return;
    }
    a(paramContext, new MessageStat(paramContext.getPackageName(), "push_register", null));
    if (!d())
    {
      if (paramICallBackResultService != null) {
        paramICallBackResultService.onRegister(-2, null);
      }
      return;
    }
    this.j = paramString1;
    this.k = paramString2;
    this.g = paramContext.getApplicationContext();
    this.m = paramICallBackResultService;
    b(12289, paramJSONObject);
  }
  
  public void a(ICallBackResultService paramICallBackResultService)
  {
    this.m = paramICallBackResultService;
  }
  
  public void a(DataMessage paramDataMessage, String paramString, int paramInt)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction(c());
      localIntent.setPackage(b());
      localIntent.putExtra("type", 12291);
      localIntent.putExtra("taskID", paramDataMessage.getTaskID());
      localIntent.putExtra("appPackage", paramDataMessage.getAppPackage());
      localIntent.putExtra("messageID", paramDataMessage.getMessageID());
      localIntent.putExtra("messageType", paramInt);
      localIntent.putExtra("eventID", paramString);
      this.g.startService(localIntent);
      return;
    }
    catch (Exception paramDataMessage)
    {
      paramString = new StringBuilder();
      paramString.append("statisticMessage--Exception");
      paramString.append(paramDataMessage.getMessage());
      com.heytap.mcssdk.f.c.b(paramString.toString());
    }
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.j = paramString1;
    this.k = paramString2;
  }
  
  public void a(List<Integer> paramList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, JSONObject paramJSONObject)
  {
    if (p())
    {
      if ((paramList != null) && (paramList.size() > 0) && (paramInt1 >= 0) && (paramInt2 >= 0) && (paramInt3 >= paramInt1) && (paramInt3 <= 23) && (paramInt4 >= paramInt2) && (paramInt4 <= 59)) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("weekDays", com.heytap.mcssdk.c.a.a(paramList));
          localJSONObject.put("startHour", paramInt1);
          localJSONObject.put("startMin", paramInt2);
          localJSONObject.put("endHour", paramInt3);
          localJSONObject.put("endMin", paramInt4);
          a(12298, localJSONObject.toString(), paramJSONObject);
          return;
        }
        catch (JSONException paramList)
        {
          com.heytap.mcssdk.f.c.a("mcssdk---", paramList.getLocalizedMessage());
          return;
        }
      }
      throw new IllegalArgumentException("params are not all right,please check params");
    }
    if (h() != null) {
      h().onSetPushTime(-2, "please call the register first!");
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (n())
    {
      b(12290, paramJSONObject);
      return;
    }
    if (h() != null) {
      h().onUnRegister(-2);
    }
  }
  
  public String b()
  {
    if (d == null)
    {
      String str = a(this.g);
      boolean bool;
      if (str == null)
      {
        d = g.a(a);
        bool = false;
      }
      else
      {
        d = str;
        bool = true;
      }
      e = bool;
    }
    return d;
  }
  
  public void b(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject, ICallBackResultService paramICallBackResultService)
  {
    this.j = paramString1;
    this.k = paramString2;
    this.g = paramContext.getApplicationContext();
    this.m = paramICallBackResultService;
    a(paramJSONObject);
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (n())
    {
      b(12289, paramJSONObject);
      return;
    }
    if (h() != null) {
      h().onRegister(-2, null);
    }
  }
  
  public String c()
  {
    if (d == null) {
      a(this.g);
    }
    if (e) {
      return "com.mcs.action.RECEIVE_SDK_MESSAGE";
    }
    return g.a(b);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    if (p())
    {
      b(12299, paramJSONObject);
      return;
    }
    com.heytap.mcssdk.f.c.a("mcssdk---", "please call the register first!");
  }
  
  public void d(JSONObject paramJSONObject)
  {
    if (p())
    {
      b(12300, paramJSONObject);
      return;
    }
    com.heytap.mcssdk.f.c.a("mcssdk---", "please call the register first!");
  }
  
  public boolean d()
  {
    String str = b();
    return (g.a(this.g, str)) && (g.b(this.g, str) >= 1019) && (g.a(this.g, str, "supportOpenPush"));
  }
  
  public List<com.heytap.mcssdk.d.d> e()
  {
    return this.i;
  }
  
  public void e(JSONObject paramJSONObject)
  {
    if (p())
    {
      b(12309, paramJSONObject);
      return;
    }
    if (h() != null) {
      h().onGetNotificationStatus(-2, 0);
    }
  }
  
  public List<com.heytap.mcssdk.e.c> f()
  {
    return this.h;
  }
  
  public void f(JSONObject paramJSONObject)
  {
    if (p())
    {
      b(12308, paramJSONObject);
      return;
    }
    com.heytap.mcssdk.f.c.a("mcssdk---", "please call the register first!");
  }
  
  public String g()
  {
    return this.l;
  }
  
  public void g(JSONObject paramJSONObject)
  {
    if (p())
    {
      b(12310, paramJSONObject);
      return;
    }
    com.heytap.mcssdk.f.c.a("mcssdk---", "please call the register first!");
  }
  
  public ICallBackResultService h()
  {
    return this.m;
  }
  
  public void i()
  {
    if (p())
    {
      b(12306, null);
      return;
    }
    if (h() != null) {
      h().onGetPushStatus(-2, 0);
    }
  }
  
  public String k()
  {
    if (n()) {
      return g.c(this.g, b());
    }
    return "";
  }
  
  public int l()
  {
    if (n()) {
      return g.b(this.g, b());
    }
    return 0;
  }
  
  public void m()
  {
    if (n())
    {
      a(12313);
      return;
    }
    com.heytap.mcssdk.f.c.a("mcssdk---", "please call the register first!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.d
 * JD-Core Version:    0.7.0.1
 */