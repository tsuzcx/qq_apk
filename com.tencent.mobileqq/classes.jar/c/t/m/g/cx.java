package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class cx
{
  private static cx a = null;
  private static Context b = null;
  private volatile boolean c = false;
  private cw d = null;
  private Timer e = null;
  
  private cx()
  {
    if ((b == null) || (b.getApplicationContext() == null)) {
      throw new IllegalStateException("Please invoke initial(context,...) first when app started!");
    }
  }
  
  /* Error */
  public static cx a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 24	c/t/m/g/cx:a	Lc/t/m/g/cx;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 24	c/t/m/g/cx:a	Lc/t/m/g/cx;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	c/t/m/g/cx
    //   21: dup
    //   22: invokespecial 51	c/t/m/g/cx:<init>	()V
    //   25: putstatic 24	c/t/m/g/cx:a	Lc/t/m/g/cx;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 24	c/t/m/g/cx:a	Lc/t/m/g/cx;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localcx	cx
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   41	46	46	finally
  }
  
  private void a(long paramLong)
  {
    if (this.e != null)
    {
      Timer localTimer = this.e;
      a locala = new a();
      long l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      localTimer.schedule(locala, l);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramContext.getApplicationContext() == null)) {
      throw new NullPointerException("context cannot be null!");
    }
    paramContext = paramContext.getApplicationContext();
    b = paramContext;
    cz.a(paramContext, paramString1);
    cy.a(paramString1, paramString2);
    new Thread()
    {
      public final void run()
      {
        try
        {
          cx.a();
          cz.a();
          cy.a();
          return;
        }
        catch (Throwable localThrowable) {}
      }
    }.start();
  }
  
  public static void a(String paramString)
  {
    cy.a(paramString);
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    cy.a(paramHashMap);
  }
  
  private void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        int i = cy.a().b("cc_version");
        if (i == -1)
        {
          if (paramBoolean)
          {
            l = 5000L;
            cu.a("CC_", "schedule : first[" + paramBoolean + "],locVer[" + i + "],delayTime[" + l + "]");
            a(l);
          }
        }
        else
        {
          l = f();
          continue;
        }
        long l = 10800000L;
      }
      catch (Throwable localThrowable)
      {
        cu.b("CC_", localThrowable.toString());
        return;
      }
    }
  }
  
  private static long f()
  {
    long l1 = 86400000L;
    long l2 = cy.a().c("cc_req_interval");
    if (l2 > 86400000L) {}
    for (;;)
    {
      if (l1 < 3600000L) {
        return 3600000L;
      }
      return l1;
      l1 = l2;
    }
  }
  
  public final void a(cw paramcw)
  {
    this.d = paramcw;
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	c/t/m/g/cx:c	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 32	c/t/m/g/cx:c	Z
    //   19: ldc 103
    //   21: ldc 161
    //   23: invokestatic 134	c/t/m/g/cu:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: new 57	java/util/Timer
    //   30: dup
    //   31: ldc 163
    //   33: invokespecial 164	java/util/Timer:<init>	(Ljava/lang/String;)V
    //   36: putfield 36	c/t/m/g/cx:e	Ljava/util/Timer;
    //   39: aload_0
    //   40: iconst_1
    //   41: invokespecial 148	c/t/m/g/cx:a	(Z)V
    //   44: goto -33 -> 11
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	cx
    //   6	2	1	bool	boolean
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	44	47	finally
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	c/t/m/g/cx:c	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 32	c/t/m/g/cx:c	Z
    //   19: invokestatic 94	c/t/m/g/cy:a	()Lc/t/m/g/cy;
    //   22: invokevirtual 166	c/t/m/g/cy:c	()V
    //   25: ldc 103
    //   27: ldc 168
    //   29: invokestatic 134	c/t/m/g/cu:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: lconst_0
    //   34: invokespecial 136	c/t/m/g/cx:a	(J)V
    //   37: aload_0
    //   38: getfield 36	c/t/m/g/cx:e	Ljava/util/Timer;
    //   41: ifnull -30 -> 11
    //   44: aload_0
    //   45: getfield 36	c/t/m/g/cx:e	Ljava/util/Timer;
    //   48: astore_2
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 36	c/t/m/g/cx:e	Ljava/util/Timer;
    //   54: aload_2
    //   55: new 8	c/t/m/g/cx$2
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 171	c/t/m/g/cx$2:<init>	(Ljava/util/Timer;)V
    //   63: ldc2_w 172
    //   66: invokevirtual 61	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   69: goto -58 -> 11
    //   72: astore_2
    //   73: ldc 103
    //   75: ldc 175
    //   77: aload_2
    //   78: invokestatic 178	c/t/m/g/cu:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: goto -70 -> 11
    //   84: astore_2
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	cx
    //   6	2	1	bool	boolean
    //   48	12	2	localTimer	Timer
    //   72	6	2	localThrowable	Throwable
    //   84	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	69	72	java/lang/Throwable
    //   2	7	84	finally
    //   14	19	84	finally
    //   19	69	84	finally
    //   73	81	84	finally
  }
  
  final class a
    extends TimerTask
  {
    private final JSONObject a = new JSONObject();
    private cy b = null;
    private cz c = null;
    private String d = "";
    
    public a() {}
    
    private JSONObject a()
    {
      if (cx.c(cx.this) == null) {
        return this.a;
      }
      cu.a("CC_Task", "cc_url:" + "https://cc.map.qq.com/?get_c3");
      for (;;)
      {
        try
        {
          Object localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("cc_version", this.b.e("cc_version"));
          ((JSONObject)localObject1).put("m_module", cy.a);
          ((JSONObject)localObject1).put("m_channel", cy.b);
          ((JSONObject)localObject1).put("m_version", cy.c);
          ((JSONObject)localObject1).put("imei", b());
          localObject1 = cv.a(((JSONObject)localObject1).toString(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
          cu.a("CC_Task", "req:" + (String)localObject1);
          localObject1 = cx.c(cx.this).a("https://cc.map.qq.com/?get_c3", ((String)localObject1).getBytes());
          Object localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new StringBuilder("net work error! res = ");
            if (localObject1 == null)
            {
              localObject1 = "null";
              cu.a("CC_Task", (String)localObject1);
              return this.a;
            }
          }
          else
          {
            cu.a("CC_Task", "res:" + (String)localObject1);
            localObject2 = this.a.toString();
            if (((String)localObject2).equals(localObject1))
            {
              cu.a("CC_Task", "network or server error,response empty json");
              localObject1 = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                return this.a;
              }
            }
            else
            {
              cu.a("CC_Task", "start dec");
              localObject1 = cv.b((String)localObject1, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
              cu.a("CC_Task", "end dec");
              continue;
            }
            localObject1 = new JSONObject((String)localObject1);
            return localObject1;
          }
        }
        catch (Throwable localThrowable)
        {
          cu.a("CC_Task", localThrowable.getMessage(), localThrowable);
          return this.a;
        }
      }
    }
    
    private void a(JSONObject paramJSONObject)
      throws JSONException
    {
      Object localObject = this.c.b();
      if (localObject == null) {
        return;
      }
      int j = this.b.b("cc_version");
      try
      {
        i = Integer.parseInt(paramJSONObject.optString("version", this.b.e("cc_version")));
        if (i == j)
        {
          cu.a("CC_Task", "local version == server version");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        for (;;)
        {
          i = j;
        }
        paramJSONObject = paramJSONObject.optJSONObject("data");
        if (paramJSONObject == null) {
          paramJSONObject = this.a;
        }
        for (;;)
        {
          localObject = ((SharedPreferences)localObject).edit();
          Iterator localIterator = paramJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            try
            {
              String str2 = this.b.e(str1);
              if ((str2 != null) && (str2.length() != 0)) {
                ((SharedPreferences.Editor)localObject).putString(str1, paramJSONObject.optString(str1, str2));
              }
            }
            catch (Exception localException)
            {
              cu.b("CC_Task", localException.getMessage());
            }
          }
        }
        ((SharedPreferences.Editor)localObject).putString("cc_version", String.valueOf(i));
      }
      for (;;)
      {
        try
        {
          l2 = Long.parseLong(paramJSONObject.optString("cc_req_interval", this.b.e("cc_req_interval")));
          if (l2 >= 3600000L) {
            continue;
          }
          l1 = 3600000L;
          ((SharedPreferences.Editor)localObject).putString("cc_req_interval", String.valueOf(l1));
        }
        catch (Throwable paramJSONObject)
        {
          long l2;
          long l1;
          continue;
        }
        ((SharedPreferences.Editor)localObject).apply();
        return;
        l1 = l2;
        if (l2 > 86400000L) {
          l1 = 86400000L;
        }
      }
    }
    
    @SuppressLint({"MissingPermission"})
    private String b()
    {
      if ((TextUtils.isEmpty(this.d)) || ("0123456789ABCDEF".equals(this.d))) {}
      try
      {
        String str1 = ((TelephonyManager)cx.e().getSystemService("phone")).getDeviceId();
        String str3 = str1;
        if (TextUtils.isEmpty(str1)) {
          str3 = "0123456789ABCDEF";
        }
        this.d = str3;
        return this.d;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          String str2 = "";
        }
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 30	c/t/m/g/cx$a:b	Lc/t/m/g/cy;
      //   4: ldc_w 264
      //   7: invokevirtual 266	c/t/m/g/cy:c	(Ljava/lang/String;)J
      //   10: lstore_2
      //   11: invokestatic 272	java/lang/System:currentTimeMillis	()J
      //   14: lload_2
      //   15: lsub
      //   16: invokestatic 278	java/lang/Math:abs	(J)J
      //   19: lstore_2
      //   20: aload_0
      //   21: getfield 20	c/t/m/g/cx$a:e	Lc/t/m/g/cx;
      //   24: astore 5
      //   26: lload_2
      //   27: invokestatic 280	c/t/m/g/cx:d	()J
      //   30: lcmp
      //   31: iflt +295 -> 326
      //   34: aload_0
      //   35: getfield 20	c/t/m/g/cx$a:e	Lc/t/m/g/cx;
      //   38: invokestatic 283	c/t/m/g/cx:a	(Lc/t/m/g/cx;)Z
      //   41: istore 4
      //   43: iload 4
      //   45: ifeq +10 -> 55
      //   48: aload_0
      //   49: getfield 32	c/t/m/g/cx$a:c	Lc/t/m/g/cz;
      //   52: invokevirtual 285	c/t/m/g/cz:c	()V
      //   55: invokestatic 291	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   58: iconst_1
      //   59: invokevirtual 295	java/lang/Thread:setPriority	(I)V
      //   62: aload_0
      //   63: invokespecial 297	c/t/m/g/cx$a:a	()Lorg/json/JSONObject;
      //   66: astore 5
      //   68: aload 5
      //   70: aload_0
      //   71: getfield 28	c/t/m/g/cx$a:a	Lorg/json/JSONObject;
      //   74: if_acmpeq +121 -> 195
      //   77: aload 5
      //   79: ldc_w 299
      //   82: ldc_w 301
      //   85: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   88: invokestatic 175	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   91: istore_1
      //   92: ldc 55
      //   94: new 57	java/lang/StringBuilder
      //   97: dup
      //   98: ldc_w 303
      //   101: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   104: iload_1
      //   105: invokevirtual 306	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   108: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   111: invokestatic 77	c/t/m/g/cu:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   114: iload_1
      //   115: tableswitch	default:+222 -> 337, 0:+117->232
      //   133: aconst_null
      //   134: bipush 65
      //   136: aload_0
      //   137: getfield 32	c/t/m/g/cx$a:c	Lc/t/m/g/cz;
      //   140: invokevirtual 162	c/t/m/g/cz:b	()Landroid/content/SharedPreferences;
      //   143: astore 5
      //   145: aload 5
      //   147: ifnull +34 -> 181
      //   150: aload 5
      //   152: invokeinterface 189 1 0
      //   157: astore 5
      //   159: aload 5
      //   161: ldc_w 264
      //   164: lload_2
      //   165: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   168: invokeinterface 213 3 0
      //   173: pop
      //   174: aload 5
      //   176: invokeinterface 236 1 0
      //   181: ldc2_w 307
      //   184: invokestatic 312	java/lang/Thread:sleep	(J)V
      //   187: ldc 55
      //   189: ldc_w 314
      //   192: invokestatic 77	c/t/m/g/cu:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   195: aload_0
      //   196: getfield 30	c/t/m/g/cx$a:b	Lc/t/m/g/cy;
      //   199: invokevirtual 316	c/t/m/g/cy:b	()V
      //   202: iload 4
      //   204: ifeq +10 -> 214
      //   207: aload_0
      //   208: getfield 32	c/t/m/g/cx$a:c	Lc/t/m/g/cz;
      //   211: invokevirtual 318	c/t/m/g/cz:d	()V
      //   214: aload_0
      //   215: getfield 20	c/t/m/g/cx$a:e	Lc/t/m/g/cx;
      //   218: invokestatic 283	c/t/m/g/cx:a	(Lc/t/m/g/cx;)Z
      //   221: ifeq +10 -> 231
      //   224: aload_0
      //   225: getfield 20	c/t/m/g/cx$a:e	Lc/t/m/g/cx;
      //   228: invokestatic 320	c/t/m/g/cx:b	(Lc/t/m/g/cx;)V
      //   231: return
      //   232: aload 5
      //   234: ldc 167
      //   236: invokevirtual 324	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   239: ifeq -107 -> 132
      //   242: aload_0
      //   243: aload 5
      //   245: invokespecial 326	c/t/m/g/cx$a:a	(Lorg/json/JSONObject;)V
      //   248: goto -116 -> 132
      //   251: astore 5
      //   253: ldc 55
      //   255: aload 5
      //   257: invokevirtual 151	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   260: aload 5
      //   262: invokestatic 154	c/t/m/g/cu:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   265: aload_0
      //   266: getfield 30	c/t/m/g/cx$a:b	Lc/t/m/g/cy;
      //   269: invokevirtual 316	c/t/m/g/cy:b	()V
      //   272: iload 4
      //   274: ifeq -60 -> 214
      //   277: aload_0
      //   278: getfield 32	c/t/m/g/cx$a:c	Lc/t/m/g/cz;
      //   281: invokevirtual 318	c/t/m/g/cz:d	()V
      //   284: goto -70 -> 214
      //   287: astore 5
      //   289: ldc 55
      //   291: aload 5
      //   293: invokevirtual 151	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   296: aload 5
      //   298: invokestatic 154	c/t/m/g/cu:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   301: return
      //   302: astore 5
      //   304: aload_0
      //   305: getfield 30	c/t/m/g/cx$a:b	Lc/t/m/g/cy;
      //   308: invokevirtual 316	c/t/m/g/cy:b	()V
      //   311: iload 4
      //   313: ifeq +10 -> 323
      //   316: aload_0
      //   317: getfield 32	c/t/m/g/cx$a:c	Lc/t/m/g/cz;
      //   320: invokevirtual 318	c/t/m/g/cz:d	()V
      //   323: aload 5
      //   325: athrow
      //   326: ldc 55
      //   328: ldc_w 328
      //   331: invokestatic 77	c/t/m/g/cu:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   334: goto -120 -> 214
      //   337: goto -205 -> 132
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	340	0	this	a
      //   91	24	1	i	int
      //   10	155	2	l	long
      //   41	271	4	bool	boolean
      //   24	220	5	localObject1	Object
      //   251	10	5	localThrowable1	Throwable
      //   287	10	5	localThrowable2	Throwable
      //   302	22	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   48	55	251	java/lang/Throwable
      //   55	114	251	java/lang/Throwable
      //   132	145	251	java/lang/Throwable
      //   150	181	251	java/lang/Throwable
      //   181	195	251	java/lang/Throwable
      //   232	248	251	java/lang/Throwable
      //   0	43	287	java/lang/Throwable
      //   195	202	287	java/lang/Throwable
      //   207	214	287	java/lang/Throwable
      //   214	231	287	java/lang/Throwable
      //   265	272	287	java/lang/Throwable
      //   277	284	287	java/lang/Throwable
      //   304	311	287	java/lang/Throwable
      //   316	323	287	java/lang/Throwable
      //   323	326	287	java/lang/Throwable
      //   326	334	287	java/lang/Throwable
      //   48	55	302	finally
      //   55	114	302	finally
      //   132	145	302	finally
      //   150	181	302	finally
      //   181	195	302	finally
      //   232	248	302	finally
      //   253	265	302	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.cx
 * JD-Core Version:    0.7.0.1
 */