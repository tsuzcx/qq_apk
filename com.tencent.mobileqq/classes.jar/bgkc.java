public class bgkc
{
  public String a;
  public boolean a;
  
  public bgkc()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  /* Error */
  public static bgkc a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +113 -> 114
    //   4: new 2	bgkc
    //   7: dup
    //   8: invokespecial 20	bgkc:<init>	()V
    //   11: astore_2
    //   12: new 22	org/json/JSONObject
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 25	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   20: astore_3
    //   21: aload_3
    //   22: ldc 27
    //   24: invokevirtual 31	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   27: iconst_1
    //   28: if_icmpne +62 -> 90
    //   31: iconst_1
    //   32: istore_1
    //   33: aload_2
    //   34: iload_1
    //   35: putfield 33	bgkc:jdField_a_of_type_Boolean	Z
    //   38: aload_2
    //   39: aload_3
    //   40: ldc 35
    //   42: invokevirtual 39	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: putfield 15	bgkc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   48: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +37 -> 88
    //   54: ldc 47
    //   56: iconst_2
    //   57: new 49	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   64: ldc 52
    //   66: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 58
    //   75: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_2
    //   79: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_2
    //   89: areturn
    //   90: iconst_0
    //   91: istore_1
    //   92: goto -59 -> 33
    //   95: astore_3
    //   96: aconst_null
    //   97: astore_2
    //   98: ldc 47
    //   100: iconst_1
    //   101: ldc 71
    //   103: aload_3
    //   104: invokestatic 74	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: goto -59 -> 48
    //   110: astore_3
    //   111: goto -13 -> 98
    //   114: aconst_null
    //   115: astore_2
    //   116: goto -68 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramString	String
    //   32	60	1	bool	boolean
    //   11	105	2	localbgkc	bgkc
    //   20	20	3	localJSONObject	org.json.JSONObject
    //   95	9	3	localException1	java.lang.Exception
    //   110	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   4	12	95	java/lang/Exception
    //   12	31	110	java/lang/Exception
    //   33	48	110	java/lang/Exception
  }
  
  public String toString()
  {
    return "[displayOrNot:" + this.jdField_a_of_type_Boolean + ",title:" + this.jdField_a_of_type_JavaLangString + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkc
 * JD-Core Version:    0.7.0.1
 */