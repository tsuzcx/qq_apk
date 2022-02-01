import android.text.TextUtils;

public class bhyl
{
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 12	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_1
    //   8: iload_1
    //   9: ifeq +7 -> 16
    //   12: ldc 2
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: invokestatic 18	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull -10 -> 12
    //   25: aload_0
    //   26: invokevirtual 22	android/net/Uri:getHost	()Ljava/lang/String;
    //   29: ifnull -17 -> 12
    //   32: aload_0
    //   33: invokevirtual 22	android/net/Uri:getHost	()Ljava/lang/String;
    //   36: invokevirtual 27	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   39: invokestatic 30	bhyl:a	(Ljava/lang/String;)Z
    //   42: ifeq -30 -> 12
    //   45: new 32	bhyk
    //   48: dup
    //   49: invokestatic 37	bhpc:a	()Lbhpc;
    //   52: invokevirtual 40	bhpc:a	()Landroid/content/Context;
    //   55: invokespecial 44	bhyk:<init>	(Landroid/content/Context;)V
    //   58: astore_0
    //   59: new 46	bhyj
    //   62: dup
    //   63: invokespecial 49	bhyj:<init>	()V
    //   66: astore 4
    //   68: aload 4
    //   70: iconst_1
    //   71: invokevirtual 52	bhyj:a	(Z)V
    //   74: invokestatic 37	bhpc:a	()Lbhpc;
    //   77: invokevirtual 55	bhpc:a	()J
    //   80: lstore_2
    //   81: invokestatic 60	biaq:c	()Ljava/lang/String;
    //   84: astore 5
    //   86: invokestatic 37	bhpc:a	()Lbhpc;
    //   89: invokevirtual 62	bhpc:a	()Ljava/lang/String;
    //   92: astore 6
    //   94: aload 4
    //   96: ldc 64
    //   98: new 66	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   105: ldc 69
    //   107: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: lload_2
    //   111: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   114: ldc 78
    //   116: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: ldc 80
    //   121: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc 82
    //   126: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 88	bhyj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 4
    //   137: ldc 64
    //   139: new 66	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   146: ldc 90
    //   148: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload 6
    //   153: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc 78
    //   158: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 80
    //   163: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 82
    //   168: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokevirtual 88	bhyj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload 4
    //   179: ldc 64
    //   181: new 66	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   188: ldc 92
    //   190: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 5
    //   195: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 78
    //   200: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: ldc 80
    //   205: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: ldc 82
    //   210: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokevirtual 88	bhyj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: aload_0
    //   220: invokevirtual 94	bhyk:a	()V
    //   223: goto -211 -> 12
    //   226: astore_0
    //   227: ldc 2
    //   229: monitorexit
    //   230: aload_0
    //   231: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramString	String
    //   7	2	1	bool	boolean
    //   80	31	2	l	long
    //   66	112	4	localbhyj	bhyj
    //   84	110	5	str1	String
    //   92	60	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	8	226	finally
    //   16	21	226	finally
    //   25	223	226	finally
  }
  
  public static boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.endsWith(".qq.com")) || (paramString.endsWith(".myapp.com")) || (paramString.endsWith(".3gqq.com")) || (paramString.endsWith(".qzone.com"))))
    {
      bhzm.c("CookieUtils", "host:" + paramString + " isAuthedDomain:true");
      return true;
    }
    bhzm.c("CookieUtils", "host:" + paramString + " isAuthedDomain:false");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhyl
 * JD-Core Version:    0.7.0.1
 */