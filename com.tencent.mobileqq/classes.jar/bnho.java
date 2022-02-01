import android.content.Context;

public class bnho
{
  public static float a;
  private static String jdField_a_of_type_JavaLangString = "";
  private static boolean jdField_a_of_type_Boolean;
  private static String b;
  
  static
  {
    jdField_a_of_type_Float = 1.0F;
  }
  
  /* Error */
  public static String a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 23	bnho:jdField_a_of_type_Boolean	Z
    //   3: ifne +17 -> 20
    //   6: new 25	bnhp
    //   9: dup
    //   10: invokespecial 28	bnhp:<init>	()V
    //   13: invokestatic 34	cooperation/qzone/util/NetworkState:addListener	(Lbnjy;)V
    //   16: iconst_1
    //   17: putstatic 23	bnho:jdField_a_of_type_Boolean	Z
    //   20: getstatic 36	bnho:b	Ljava/lang/String;
    //   23: ifnull +7 -> 30
    //   26: getstatic 36	bnho:b	Ljava/lang/String;
    //   29: areturn
    //   30: aload_0
    //   31: ldc 38
    //   33: invokevirtual 44	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   36: checkcast 46	android/telephony/TelephonyManager
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual 50	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   44: putstatic 36	bnho:b	Ljava/lang/String;
    //   47: getstatic 36	bnho:b	Ljava/lang/String;
    //   50: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +10 -> 63
    //   56: aload_2
    //   57: invokevirtual 59	android/telephony/TelephonyManager:getSimOperator	()Ljava/lang/String;
    //   60: putstatic 36	bnho:b	Ljava/lang/String;
    //   63: iconst_1
    //   64: anewarray 61	java/lang/Class
    //   67: astore 4
    //   69: aload 4
    //   71: iconst_0
    //   72: getstatic 67	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   75: aastore
    //   76: new 63	java/lang/Integer
    //   79: dup
    //   80: iconst_1
    //   81: invokespecial 70	java/lang/Integer:<init>	(I)V
    //   84: astore_3
    //   85: getstatic 36	bnho:b	Ljava/lang/String;
    //   88: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: istore_1
    //   92: iload_1
    //   93: ifeq +42 -> 135
    //   96: aload_2
    //   97: invokevirtual 74	java/lang/Object:getClass	()Ljava/lang/Class;
    //   100: ldc 76
    //   102: aload 4
    //   104: invokevirtual 80	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   107: astore 5
    //   109: aload 5
    //   111: iconst_1
    //   112: invokevirtual 86	java/lang/reflect/Method:setAccessible	(Z)V
    //   115: aload 5
    //   117: aload_2
    //   118: iconst_1
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_3
    //   125: aastore
    //   126: invokevirtual 90	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   129: checkcast 92	java/lang/String
    //   132: putstatic 36	bnho:b	Ljava/lang/String;
    //   135: getstatic 36	bnho:b	Ljava/lang/String;
    //   138: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: istore_1
    //   142: iload_1
    //   143: ifeq +69 -> 212
    //   146: ldc 94
    //   148: invokestatic 98	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   151: astore 5
    //   153: aload_0
    //   154: aload 5
    //   156: ldc 100
    //   158: iconst_2
    //   159: anewarray 61	java/lang/Class
    //   162: dup
    //   163: iconst_0
    //   164: ldc 92
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: getstatic 67	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   172: aastore
    //   173: invokevirtual 103	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   176: aload 5
    //   178: iconst_2
    //   179: anewarray 4	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: ldc 38
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: iconst_1
    //   190: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   193: aastore
    //   194: invokevirtual 90	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   197: checkcast 92	java/lang/String
    //   200: invokevirtual 44	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   203: checkcast 46	android/telephony/TelephonyManager
    //   206: invokevirtual 50	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   209: putstatic 36	bnho:b	Ljava/lang/String;
    //   212: getstatic 36	bnho:b	Ljava/lang/String;
    //   215: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   218: istore_1
    //   219: iload_1
    //   220: ifeq +39 -> 259
    //   223: aload_2
    //   224: invokevirtual 74	java/lang/Object:getClass	()Ljava/lang/Class;
    //   227: ldc 109
    //   229: aload 4
    //   231: invokevirtual 80	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   234: astore_0
    //   235: aload_0
    //   236: iconst_1
    //   237: invokevirtual 86	java/lang/reflect/Method:setAccessible	(Z)V
    //   240: aload_0
    //   241: aload_2
    //   242: iconst_1
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: aload_3
    //   249: aastore
    //   250: invokevirtual 90	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   253: checkcast 92	java/lang/String
    //   256: putstatic 36	bnho:b	Ljava/lang/String;
    //   259: getstatic 36	bnho:b	Ljava/lang/String;
    //   262: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   265: ifeq +8 -> 273
    //   268: ldc 13
    //   270: putstatic 36	bnho:b	Ljava/lang/String;
    //   273: getstatic 36	bnho:b	Ljava/lang/String;
    //   276: areturn
    //   277: astore 5
    //   279: aload 5
    //   281: invokevirtual 112	java/lang/Throwable:printStackTrace	()V
    //   284: ldc 114
    //   286: new 116	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   293: ldc 119
    //   295: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload 5
    //   300: invokevirtual 126	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   303: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 135	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: ldc 13
    //   314: putstatic 36	bnho:b	Ljava/lang/String;
    //   317: goto -182 -> 135
    //   320: astore_0
    //   321: ldc 13
    //   323: putstatic 36	bnho:b	Ljava/lang/String;
    //   326: ldc 13
    //   328: areturn
    //   329: astore_0
    //   330: aload_0
    //   331: invokevirtual 112	java/lang/Throwable:printStackTrace	()V
    //   334: ldc 114
    //   336: new 116	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   343: ldc 137
    //   345: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_0
    //   349: invokevirtual 126	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   352: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 135	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: ldc 13
    //   363: putstatic 36	bnho:b	Ljava/lang/String;
    //   366: goto -154 -> 212
    //   369: astore_0
    //   370: ldc 114
    //   372: new 116	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   379: ldc 139
    //   381: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_0
    //   385: invokevirtual 126	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   388: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 135	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload_0
    //   398: invokevirtual 112	java/lang/Throwable:printStackTrace	()V
    //   401: ldc 13
    //   403: putstatic 36	bnho:b	Ljava/lang/String;
    //   406: goto -147 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	409	0	paramContext	Context
    //   91	129	1	bool	boolean
    //   39	203	2	localTelephonyManager	android.telephony.TelephonyManager
    //   84	165	3	localInteger	java.lang.Integer
    //   67	163	4	arrayOfClass	java.lang.Class[]
    //   107	70	5	localObject	Object
    //   277	22	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   96	135	277	java/lang/Throwable
    //   30	63	320	java/lang/Throwable
    //   63	92	320	java/lang/Throwable
    //   135	142	320	java/lang/Throwable
    //   212	219	320	java/lang/Throwable
    //   259	273	320	java/lang/Throwable
    //   273	277	320	java/lang/Throwable
    //   279	317	320	java/lang/Throwable
    //   330	366	320	java/lang/Throwable
    //   370	406	320	java/lang/Throwable
    //   146	212	329	java/lang/Throwable
    //   223	259	369	java/lang/Throwable
  }
  
  public static String b(Context paramContext)
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnho
 * JD-Core Version:    0.7.0.1
 */