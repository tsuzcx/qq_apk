import android.content.Context;
import android.os.AsyncTask;

public class bmgw
  extends AsyncTask<String, String, String>
{
  private static boolean jdField_a_of_type_Boolean;
  private Context jdField_a_of_type_AndroidContentContext;
  
  public bmgw(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  /* Error */
  protected String a(String... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 23	bmgw:jdField_a_of_type_Boolean	Z
    //   5: ifeq +8 -> 13
    //   8: ldc 25
    //   10: astore_2
    //   11: aload_2
    //   12: areturn
    //   13: iconst_1
    //   14: putstatic 23	bmgw:jdField_a_of_type_Boolean	Z
    //   17: new 27	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   24: astore_3
    //   25: new 30	java/lang/ProcessBuilder
    //   28: dup
    //   29: iconst_3
    //   30: anewarray 32	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc 34
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: ldc 36
    //   42: aastore
    //   43: dup
    //   44: iconst_2
    //   45: aload_0
    //   46: getfield 15	bmgw:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   49: ldc 38
    //   51: iconst_0
    //   52: invokevirtual 44	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   55: invokevirtual 50	java/io/File:getPath	()Ljava/lang/String;
    //   58: aastore
    //   59: invokespecial 53	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   62: astore_1
    //   63: aload_1
    //   64: iconst_1
    //   65: invokevirtual 57	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   68: pop
    //   69: new 59	java/io/BufferedReader
    //   72: dup
    //   73: new 61	java/io/InputStreamReader
    //   76: dup
    //   77: aload_1
    //   78: invokevirtual 65	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   81: invokevirtual 71	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   84: invokespecial 74	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   87: invokespecial 77	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 80	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   95: astore 4
    //   97: aload 4
    //   99: ifnull +42 -> 141
    //   102: aload 4
    //   104: ldc 38
    //   106: invokevirtual 84	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   109: ifeq -18 -> 91
    //   112: aload_3
    //   113: aload 4
    //   115: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 90
    //   120: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: goto -33 -> 91
    //   127: astore_3
    //   128: aload_1
    //   129: ifnull -118 -> 11
    //   132: aload_1
    //   133: invokevirtual 93	java/io/BufferedReader:close	()V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_1
    //   139: aconst_null
    //   140: areturn
    //   141: ldc 95
    //   143: iconst_1
    //   144: new 27	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   151: ldc 97
    //   153: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_3
    //   157: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 106	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: aload_1
    //   170: ifnull -159 -> 11
    //   173: aload_1
    //   174: invokevirtual 93	java/io/BufferedReader:close	()V
    //   177: aconst_null
    //   178: areturn
    //   179: astore_1
    //   180: aconst_null
    //   181: areturn
    //   182: astore_2
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: ifnull +7 -> 193
    //   189: aload_1
    //   190: invokevirtual 93	java/io/BufferedReader:close	()V
    //   193: aload_2
    //   194: athrow
    //   195: astore_1
    //   196: goto -3 -> 193
    //   199: astore_2
    //   200: goto -15 -> 185
    //   203: astore_1
    //   204: aconst_null
    //   205: astore_1
    //   206: goto -78 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	bmgw
    //   0	209	1	paramVarArgs	String[]
    //   1	11	2	str1	String
    //   182	12	2	localObject1	java.lang.Object
    //   199	1	2	localObject2	java.lang.Object
    //   24	89	3	localStringBuilder	java.lang.StringBuilder
    //   127	30	3	localThrowable	java.lang.Throwable
    //   95	19	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   91	97	127	java/lang/Throwable
    //   102	124	127	java/lang/Throwable
    //   141	169	127	java/lang/Throwable
    //   132	136	138	java/lang/Exception
    //   173	177	179	java/lang/Exception
    //   17	91	182	finally
    //   189	193	195	java/lang/Exception
    //   91	97	199	finally
    //   102	124	199	finally
    //   141	169	199	finally
    //   17	91	203	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgw
 * JD-Core Version:    0.7.0.1
 */