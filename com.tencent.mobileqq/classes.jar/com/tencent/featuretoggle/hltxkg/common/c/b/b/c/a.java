package com.tencent.featuretoggle.hltxkg.common.c.b.b.c;

import android.os.Handler;
import com.tencent.featuretoggle.hltxkg.common.a.n;
import java.util.Map;

public final class a
  extends com.tencent.featuretoggle.hltxkg.common.c.b.b.b
{
  private final n a = new n();
  
  public a()
  {
    com.tencent.featuretoggle.hltxkg.common.a.i().post(new b(this));
  }
  
  private static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder("Halley_Cloud_Param_Content_");
    localStringBuilder.append(com.tencent.featuretoggle.hltxkg.common.a.c());
    localStringBuilder.append("_for_SettingsHandler");
    String str;
    if (com.tencent.featuretoggle.hltxkg.common.a.b()) {
      str = "_test";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public final void a(com.tencent.featuretoggle.hltxkg.common.c.b.b.a parama)
  {
    String str = this.a.c();
    parama.a.put("confVersion", str);
  }
  
  /* Error */
  public final void a(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 117
    //   3: invokevirtual 123	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +62 -> 70
    //   11: aload_1
    //   12: ldc 125
    //   14: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_1
    //   18: aload_1
    //   19: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +48 -> 70
    //   25: aload_0
    //   26: getfield 15	com/tencent/featuretoggle/hltxkg/common/c/b/b/c/a:a	Lcom/tencent/featuretoggle/hltxkg/common/a/n;
    //   29: aload_1
    //   30: invokevirtual 137	com/tencent/featuretoggle/hltxkg/common/a/n:a	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 15	com/tencent/featuretoggle/hltxkg/common/c/b/b/c/a:a	Lcom/tencent/featuretoggle/hltxkg/common/a/n;
    //   37: invokevirtual 138	com/tencent/featuretoggle/hltxkg/common/a/n:a	()Ljava/lang/String;
    //   40: astore_1
    //   41: invokestatic 73	com/tencent/featuretoggle/hltxkg/common/a:a	()Landroid/content/Context;
    //   44: invokestatic 69	com/tencent/featuretoggle/hltxkg/common/c/b/b/c/a:a	()Ljava/lang/String;
    //   47: iconst_0
    //   48: invokevirtual 79	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   51: invokeinterface 85 1 0
    //   56: ldc 87
    //   58: aload_1
    //   59: invokeinterface 93 3 0
    //   64: invokeinterface 96 1 0
    //   69: pop
    //   70: invokestatic 21	com/tencent/featuretoggle/hltxkg/common/a:i	()Landroid/os/Handler;
    //   73: astore_2
    //   74: new 140	com/tencent/featuretoggle/hltxkg/common/c/b/b/c/c
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 141	com/tencent/featuretoggle/hltxkg/common/c/b/b/c/c:<init>	(Lcom/tencent/featuretoggle/hltxkg/common/c/b/b/c/a;)V
    //   82: astore_1
    //   83: aload_2
    //   84: aload_1
    //   85: invokevirtual 32	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   88: pop
    //   89: return
    //   90: astore_1
    //   91: goto +24 -> 115
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 144	java/lang/Throwable:printStackTrace	()V
    //   99: invokestatic 21	com/tencent/featuretoggle/hltxkg/common/a:i	()Landroid/os/Handler;
    //   102: astore_2
    //   103: new 140	com/tencent/featuretoggle/hltxkg/common/c/b/b/c/c
    //   106: dup
    //   107: aload_0
    //   108: invokespecial 141	com/tencent/featuretoggle/hltxkg/common/c/b/b/c/c:<init>	(Lcom/tencent/featuretoggle/hltxkg/common/c/b/b/c/a;)V
    //   111: astore_1
    //   112: goto -29 -> 83
    //   115: invokestatic 21	com/tencent/featuretoggle/hltxkg/common/a:i	()Landroid/os/Handler;
    //   118: new 140	com/tencent/featuretoggle/hltxkg/common/c/b/b/c/c
    //   121: dup
    //   122: aload_0
    //   123: invokespecial 141	com/tencent/featuretoggle/hltxkg/common/c/b/b/c/c:<init>	(Lcom/tencent/featuretoggle/hltxkg/common/c/b/b/c/a;)V
    //   126: invokevirtual 32	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   129: pop
    //   130: goto +5 -> 135
    //   133: aload_1
    //   134: athrow
    //   135: goto -2 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	a
    //   0	138	1	paramJSONObject	org.json.JSONObject
    //   73	30	2	localHandler	Handler
    // Exception table:
    //   from	to	target	type
    //   0	7	90	finally
    //   11	70	90	finally
    //   95	99	90	finally
    //   0	7	94	java/lang/Throwable
    //   11	70	94	java/lang/Throwable
  }
  
  public final void b()
  {
    com.tencent.featuretoggle.hltxkg.common.a.i().post(new c(this));
  }
  
  public final String c()
  {
    return "settings";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.b.c.a
 * JD-Core Version:    0.7.0.1
 */