package c.t.m.g;

import android.os.Handler;
import java.util.Map;

public final class bw
  extends br
{
  final ae a = new ae();
  
  public bw()
  {
    m.j().post(new bx(this));
  }
  
  static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder("Halley_Cloud_Param_Content_");
    localStringBuilder.append(m.c());
    localStringBuilder.append("_for_SettingsHandler");
    m.b();
    return localStringBuilder.toString();
  }
  
  public final void a(bn parambn)
  {
    String str = this.a.c();
    parambn.a.put("confVersion", str);
  }
  
  /* Error */
  public final void a(org.json.JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 83
    //   3: invokevirtual 89	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +62 -> 70
    //   11: aload_1
    //   12: ldc 91
    //   14: invokevirtual 95	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore_1
    //   18: aload_1
    //   19: invokestatic 101	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +48 -> 70
    //   25: aload_0
    //   26: getfield 15	c/t/m/g/bw:a	Lc/t/m/g/ae;
    //   29: aload_1
    //   30: invokevirtual 103	c/t/m/g/ae:a	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 15	c/t/m/g/bw:a	Lc/t/m/g/ae;
    //   37: invokevirtual 105	c/t/m/g/ae:a	()Ljava/lang/String;
    //   40: astore_1
    //   41: invokestatic 108	c/t/m/g/m:a	()Landroid/content/Context;
    //   44: invokestatic 110	c/t/m/g/bw:d	()Ljava/lang/String;
    //   47: iconst_0
    //   48: invokevirtual 116	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   51: invokeinterface 122 1 0
    //   56: ldc 124
    //   58: aload_1
    //   59: invokeinterface 130 3 0
    //   64: invokeinterface 133 1 0
    //   69: pop
    //   70: invokestatic 21	c/t/m/g/m:j	()Landroid/os/Handler;
    //   73: new 135	c/t/m/g/by
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 136	c/t/m/g/by:<init>	(Lc/t/m/g/bw;)V
    //   81: invokevirtual 32	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   84: pop
    //   85: return
    //   86: astore_1
    //   87: goto +24 -> 111
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 139	java/lang/Throwable:printStackTrace	()V
    //   95: invokestatic 21	c/t/m/g/m:j	()Landroid/os/Handler;
    //   98: new 135	c/t/m/g/by
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 136	c/t/m/g/by:<init>	(Lc/t/m/g/bw;)V
    //   106: invokevirtual 32	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   109: pop
    //   110: return
    //   111: invokestatic 21	c/t/m/g/m:j	()Landroid/os/Handler;
    //   114: new 135	c/t/m/g/by
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 136	c/t/m/g/by:<init>	(Lc/t/m/g/bw;)V
    //   122: invokevirtual 32	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   125: pop
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	bw
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
    m.j().post(new by(this));
  }
  
  public final String c()
  {
    return "settings";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.bw
 * JD-Core Version:    0.7.0.1
 */