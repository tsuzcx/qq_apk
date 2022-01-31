public class bfkp
{
  public static char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String a(String paramString)
  {
    return a(a(paramString));
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 16))
    {
      char[] arrayOfChar = new char[32];
      int j = 0;
      while (i < 16)
      {
        int k = paramArrayOfByte[i];
        int m = j + 1;
        arrayOfChar[j] = a[(k >>> 4 & 0xF)];
        j = m + 1;
        arrayOfChar[m] = a[(k & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar);
    }
    return "";
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: ldc 48
    //   8: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   11: astore_1
    //   12: aload_0
    //   13: ldc 56
    //   15: invokevirtual 59	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   18: astore_0
    //   19: aload_1
    //   20: aload_0
    //   21: invokevirtual 63	java/security/MessageDigest:digest	([B)[B
    //   24: areturn
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   30: aconst_null
    //   31: areturn
    //   32: astore_0
    //   33: aload_0
    //   34: invokevirtual 67	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   37: aconst_null
    //   38: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	paramString	String
    //   11	9	1	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   6	12	25	java/lang/Exception
    //   12	19	32	java/io/UnsupportedEncodingException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bfkp
 * JD-Core Version:    0.7.0.1
 */