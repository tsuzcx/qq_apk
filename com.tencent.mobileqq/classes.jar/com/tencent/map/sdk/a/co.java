package com.tencent.map.sdk.a;

import android.os.Handler;
import java.util.Map;

public final class co
  extends cj
{
  final ax a = new ax();
  
  public co()
  {
    ac.h().post(new cp(this));
  }
  
  static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder("Halley_Cloud_Param_Content_");
    localStringBuilder.append(ac.c());
    localStringBuilder.append("_for_SettingsHandler");
    String str;
    if (ac.b()) {
      str = "_test";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public final void a(cf paramcf)
  {
    String str = this.a.c();
    paramcf.a.put("confVersion", str);
  }
  
  /* Error */
  public final void a(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 87
    //   3: invokevirtual 93	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +62 -> 70
    //   11: aload_1
    //   12: ldc 95
    //   14: invokevirtual 99	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_1
    //   18: aload_1
    //   19: invokestatic 105	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +48 -> 70
    //   25: aload_0
    //   26: getfield 15	com/tencent/map/sdk/a/co:a	Lcom/tencent/map/sdk/a/ax;
    //   29: aload_1
    //   30: invokevirtual 107	com/tencent/map/sdk/a/ax:a	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 15	com/tencent/map/sdk/a/co:a	Lcom/tencent/map/sdk/a/ax;
    //   37: invokevirtual 109	com/tencent/map/sdk/a/ax:a	()Ljava/lang/String;
    //   40: astore_1
    //   41: invokestatic 112	com/tencent/map/sdk/a/ac:a	()Landroid/content/Context;
    //   44: invokestatic 114	com/tencent/map/sdk/a/co:d	()Ljava/lang/String;
    //   47: iconst_0
    //   48: invokevirtual 120	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   51: invokeinterface 126 1 0
    //   56: ldc 128
    //   58: aload_1
    //   59: invokeinterface 134 3 0
    //   64: invokeinterface 137 1 0
    //   69: pop
    //   70: invokestatic 21	com/tencent/map/sdk/a/ac:h	()Landroid/os/Handler;
    //   73: new 139	com/tencent/map/sdk/a/cq
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 140	com/tencent/map/sdk/a/cq:<init>	(Lcom/tencent/map/sdk/a/co;)V
    //   81: invokevirtual 32	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   84: pop
    //   85: return
    //   86: astore_1
    //   87: goto +24 -> 111
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 143	java/lang/Throwable:printStackTrace	()V
    //   95: invokestatic 21	com/tencent/map/sdk/a/ac:h	()Landroid/os/Handler;
    //   98: new 139	com/tencent/map/sdk/a/cq
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 140	com/tencent/map/sdk/a/cq:<init>	(Lcom/tencent/map/sdk/a/co;)V
    //   106: invokevirtual 32	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   109: pop
    //   110: return
    //   111: invokestatic 21	com/tencent/map/sdk/a/ac:h	()Landroid/os/Handler;
    //   114: new 139	com/tencent/map/sdk/a/cq
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 140	com/tencent/map/sdk/a/cq:<init>	(Lcom/tencent/map/sdk/a/co;)V
    //   122: invokevirtual 32	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   125: pop
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	co
    //   0	128	1	paramJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	7	86	finally
    //   11	70	86	finally
    //   91	95	86	finally
    //   0	7	90	java/lang/Throwable
    //   11	70	90	java/lang/Throwable
  }
  
  public final void b()
  {
    ac.h().post(new cq(this));
  }
  
  public final String c()
  {
    return "settings";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.co
 * JD-Core Version:    0.7.0.1
 */