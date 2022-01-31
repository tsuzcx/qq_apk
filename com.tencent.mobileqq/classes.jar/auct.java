import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.qphone.base.util.QLog;

public class auct
{
  public static boolean a;
  
  public static String a()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplicationImpl.sApplication);
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return str + "/UnCompressPttSoTemp/";
  }
  
  /* Error */
  public static boolean a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: invokestatic 60	lbk:f	()I
    //   5: istore_2
    //   6: invokestatic 63	auct:b	()Ljava/lang/String;
    //   9: astore 6
    //   11: ldc 35
    //   13: astore 5
    //   15: iload_2
    //   16: iconst_2
    //   17: if_icmple +34 -> 51
    //   20: new 37	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   27: aload 6
    //   29: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 65
    //   34: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 67
    //   43: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore 5
    //   51: ldc 27
    //   53: monitorenter
    //   54: new 69	java/io/File
    //   57: dup
    //   58: aload 5
    //   60: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: invokevirtual 75	java/io/File:exists	()Z
    //   66: istore 4
    //   68: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +29 -> 100
    //   74: ldc 27
    //   76: iconst_2
    //   77: new 37	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   84: ldc 77
    //   86: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 5
    //   91: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 33	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: iload 4
    //   102: ifeq +113 -> 215
    //   105: aload 5
    //   107: invokestatic 82	java/lang/System:load	(Ljava/lang/String;)V
    //   110: iconst_1
    //   111: putstatic 84	auct:a	Z
    //   114: ldc 27
    //   116: monitorexit
    //   117: getstatic 84	auct:a	Z
    //   120: aload_1
    //   121: invokestatic 89	axte:a	(ZLjava/lang/String;)V
    //   124: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +40 -> 167
    //   130: ldc 27
    //   132: iconst_2
    //   133: new 37	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   140: ldc 91
    //   142: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload 5
    //   147: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: ldc 93
    //   152: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: getstatic 84	auct:a	Z
    //   158: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 33	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   167: iload_3
    //   168: ireturn
    //   169: astore 6
    //   171: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +32 -> 206
    //   177: ldc 27
    //   179: iconst_2
    //   180: new 37	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   187: ldc 98
    //   189: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload 6
    //   194: invokevirtual 101	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 33	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_0
    //   207: aload_1
    //   208: invokestatic 106	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   211: istore_3
    //   212: goto -98 -> 114
    //   215: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +11 -> 229
    //   221: ldc 27
    //   223: iconst_2
    //   224: ldc 108
    //   226: invokestatic 33	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_0
    //   230: aload_1
    //   231: invokestatic 106	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   234: istore_3
    //   235: goto -121 -> 114
    //   238: astore_0
    //   239: ldc 27
    //   241: monitorexit
    //   242: aload_0
    //   243: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramContext	android.content.Context
    //   0	244	1	paramString	String
    //   5	13	2	i	int
    //   1	234	3	bool1	boolean
    //   66	35	4	bool2	boolean
    //   13	133	5	str1	String
    //   9	19	6	str2	String
    //   169	24	6	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   105	114	169	java/lang/UnsatisfiedLinkError
    //   54	100	238	finally
    //   105	114	238	finally
    //   114	117	238	finally
    //   171	206	238	finally
    //   206	212	238	finally
    //   215	229	238	finally
    //   229	235	238	finally
    //   239	242	238	finally
  }
  
  public static String b()
  {
    String str = SoLoadCore.getAppWorkPath(BaseApplicationImpl.sApplication);
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return str + "/txPttlib/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auct
 * JD-Core Version:    0.7.0.1
 */