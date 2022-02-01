public class aqye
{
  public int a;
  
  /* Error */
  public static aqye a(aqxa[] paramArrayOfaqxa)
  {
    // Byte code:
    //   0: new 2	aqye
    //   3: dup
    //   4: invokespecial 17	aqye:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: arraylength
    //   11: istore_2
    //   12: iconst_0
    //   13: istore_1
    //   14: goto +112 -> 126
    //   17: aload 5
    //   19: getfield 22	aqxa:a	Ljava/lang/String;
    //   22: astore 5
    //   24: aload 5
    //   26: invokestatic 28	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: istore_3
    //   30: iload_3
    //   31: ifne +110 -> 141
    //   34: new 30	org/json/JSONObject
    //   37: dup
    //   38: aload 5
    //   40: invokespecial 33	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   43: astore 6
    //   45: aload 6
    //   47: ldc 35
    //   49: invokevirtual 39	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   52: ifeq +16 -> 68
    //   55: aload 4
    //   57: aload 6
    //   59: ldc 35
    //   61: iconst_0
    //   62: invokevirtual 43	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   65: putfield 45	aqye:a	I
    //   68: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +70 -> 141
    //   74: ldc 53
    //   76: iconst_2
    //   77: new 55	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   84: ldc 58
    //   86: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 5
    //   91: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: goto +41 -> 141
    //   103: astore_0
    //   104: ldc 53
    //   106: iconst_2
    //   107: ldc 72
    //   109: aload_0
    //   110: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload 4
    //   115: areturn
    //   116: astore 6
    //   118: aload 6
    //   120: invokevirtual 79	org/json/JSONException:printStackTrace	()V
    //   123: goto -55 -> 68
    //   126: iload_1
    //   127: iload_2
    //   128: if_icmpge -15 -> 113
    //   131: aload_0
    //   132: iload_1
    //   133: aaload
    //   134: astore 5
    //   136: aload 5
    //   138: ifnonnull -121 -> 17
    //   141: iload_1
    //   142: iconst_1
    //   143: iadd
    //   144: istore_1
    //   145: goto -19 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramArrayOfaqxa	aqxa[]
    //   13	132	1	i	int
    //   11	118	2	j	int
    //   29	2	3	bool	boolean
    //   7	107	4	localaqye	aqye
    //   17	120	5	localObject	Object
    //   43	15	6	localJSONObject	org.json.JSONObject
    //   116	3	6	localJSONException	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   9	12	103	java/lang/Throwable
    //   17	30	103	java/lang/Throwable
    //   34	68	103	java/lang/Throwable
    //   68	100	103	java/lang/Throwable
    //   118	123	103	java/lang/Throwable
    //   34	68	116	org/json/JSONException
  }
  
  public boolean a()
  {
    return this.a == 1;
  }
  
  public String toString()
  {
    return "RelatedEmotionConfigBean{mOpenRelatedEmoSwitch = " + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqye
 * JD-Core Version:    0.7.0.1
 */