import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.qphone.base.util.QLog;

public class bahq
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
    //   1: istore 4
    //   3: invokestatic 60	llq:f	()I
    //   6: istore_2
    //   7: invokestatic 63	bahq:b	()Ljava/lang/String;
    //   10: astore 7
    //   12: ldc 35
    //   14: astore 6
    //   16: iload_2
    //   17: iconst_2
    //   18: if_icmple +34 -> 52
    //   21: new 37	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   28: aload 7
    //   30: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 65
    //   35: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 67
    //   44: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore 6
    //   52: ldc 27
    //   54: monitorenter
    //   55: new 69	java/io/File
    //   58: dup
    //   59: aload 6
    //   61: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: invokevirtual 75	java/io/File:exists	()Z
    //   67: istore_3
    //   68: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +38 -> 109
    //   74: ldc 27
    //   76: iconst_2
    //   77: new 37	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   84: ldc 77
    //   86: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 6
    //   91: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 79
    //   96: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: iload_3
    //   100: invokevirtual 82	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   103: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 33	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_1
    //   110: ldc 84
    //   112: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: istore 5
    //   117: iload 5
    //   119: ifeq +5 -> 124
    //   122: iconst_0
    //   123: istore_3
    //   124: iload_3
    //   125: ifeq +116 -> 241
    //   128: aload 6
    //   130: invokestatic 95	java/lang/System:load	(Ljava/lang/String;)V
    //   133: iconst_1
    //   134: putstatic 97	bahq:a	Z
    //   137: iload 4
    //   139: istore_3
    //   140: ldc 27
    //   142: monitorexit
    //   143: getstatic 97	bahq:a	Z
    //   146: aload_1
    //   147: invokestatic 103	com/tencent/mobileqq/transfile/PttInfoCollector:reportPttSoUpdate	(ZLjava/lang/String;)V
    //   150: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq +40 -> 193
    //   156: ldc 27
    //   158: iconst_2
    //   159: new 37	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   166: ldc 105
    //   168: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 6
    //   173: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: ldc 107
    //   178: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: getstatic 97	bahq:a	Z
    //   184: invokevirtual 82	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   187: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 33	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iload_3
    //   194: ireturn
    //   195: astore 7
    //   197: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +32 -> 232
    //   203: ldc 27
    //   205: iconst_2
    //   206: new 37	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   213: ldc 109
    //   215: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 7
    //   220: invokevirtual 112	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   223: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 33	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aload_0
    //   233: aload_1
    //   234: invokestatic 117	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   237: istore_3
    //   238: goto -98 -> 140
    //   241: invokestatic 25	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +11 -> 255
    //   247: ldc 27
    //   249: iconst_2
    //   250: ldc 119
    //   252: invokestatic 33	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: aload_0
    //   256: aload_1
    //   257: invokestatic 117	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   260: istore_3
    //   261: goto -121 -> 140
    //   264: astore_0
    //   265: ldc 27
    //   267: monitorexit
    //   268: aload_0
    //   269: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramContext	android.content.Context
    //   0	270	1	paramString	String
    //   6	13	2	i	int
    //   67	194	3	bool1	boolean
    //   1	137	4	bool2	boolean
    //   115	3	5	bool3	boolean
    //   14	158	6	str1	String
    //   10	19	7	str2	String
    //   195	24	7	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   128	137	195	java/lang/UnsatisfiedLinkError
    //   55	109	264	finally
    //   109	117	264	finally
    //   128	137	264	finally
    //   140	143	264	finally
    //   197	232	264	finally
    //   232	238	264	finally
    //   241	255	264	finally
    //   255	261	264	finally
    //   265	268	264	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahq
 * JD-Core Version:    0.7.0.1
 */