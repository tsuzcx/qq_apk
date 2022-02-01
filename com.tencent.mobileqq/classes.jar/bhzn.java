import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class bhzn
{
  public static char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  /* Error */
  public static String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 36
    //   2: astore_3
    //   3: aload_3
    //   4: astore_1
    //   5: aload_0
    //   6: ifnull +62 -> 68
    //   9: aload_3
    //   10: astore_1
    //   11: aload_0
    //   12: invokevirtual 42	java/io/File:exists	()Z
    //   15: ifeq +53 -> 68
    //   18: aload_3
    //   19: astore_1
    //   20: aload_0
    //   21: invokevirtual 46	java/io/File:length	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifle +42 -> 68
    //   29: aconst_null
    //   30: astore_2
    //   31: aconst_null
    //   32: astore_1
    //   33: new 48	java/io/BufferedInputStream
    //   36: dup
    //   37: new 50	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 54	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 57	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_0
    //   49: aload_0
    //   50: astore_1
    //   51: aload_0
    //   52: invokestatic 60	bhzn:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   55: astore_2
    //   56: aload_2
    //   57: astore_1
    //   58: aload_0
    //   59: ifnull +9 -> 68
    //   62: aload_0
    //   63: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   66: aload_2
    //   67: astore_1
    //   68: aload_1
    //   69: areturn
    //   70: astore_0
    //   71: aload_0
    //   72: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   75: aload_2
    //   76: areturn
    //   77: astore_2
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: astore_1
    //   82: aload_2
    //   83: invokevirtual 67	java/io/FileNotFoundException:printStackTrace	()V
    //   86: aload_3
    //   87: astore_1
    //   88: aload_0
    //   89: ifnull -21 -> 68
    //   92: aload_0
    //   93: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   96: ldc 36
    //   98: areturn
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   104: ldc 36
    //   106: areturn
    //   107: astore_0
    //   108: aload_1
    //   109: astore_0
    //   110: aload_3
    //   111: astore_1
    //   112: aload_0
    //   113: ifnull -45 -> 68
    //   116: aload_0
    //   117: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   120: ldc 36
    //   122: areturn
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   128: ldc 36
    //   130: areturn
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   142: aload_0
    //   143: athrow
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   149: goto -7 -> 142
    //   152: astore_0
    //   153: goto -19 -> 134
    //   156: astore_1
    //   157: goto -47 -> 110
    //   160: astore_2
    //   161: goto -81 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramFile	java.io.File
    //   4	135	1	localObject	Object
    //   144	2	1	localIOException	IOException
    //   156	1	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   30	46	2	str1	String
    //   77	56	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   160	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   2	109	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   62	66	70	java/io/IOException
    //   33	49	77	java/io/FileNotFoundException
    //   92	96	99	java/io/IOException
    //   33	49	107	java/lang/OutOfMemoryError
    //   116	120	123	java/io/IOException
    //   33	49	131	finally
    //   138	142	144	java/io/IOException
    //   51	56	152	finally
    //   82	86	152	finally
    //   51	56	156	java/lang/OutOfMemoryError
    //   51	56	160	java/io/FileNotFoundException
  }
  
  public static String a(InputStream paramInputStream)
  {
    int i = 0;
    do
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        byte[] arrayOfByte = new byte[4196];
        for (;;)
        {
          int j = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
          if (j == -1) {
            break;
          }
          if (j > 0)
          {
            localMessageDigest.update(arrayOfByte, 0, j);
            i += j;
          }
        }
        paramInputStream = a(localMessageDigest.digest());
        return paramInputStream;
      }
      catch (NoSuchAlgorithmException paramInputStream)
      {
        paramInputStream.printStackTrace();
        return "";
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
        return "";
      }
    } while (i != 0);
    return "";
  }
  
  public static String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return "";
    }
    return a(paramString);
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
  
  public static byte[] a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      return null;
    }
    catch (Exception paramString)
    {
      try
      {
        paramString = paramString.getBytes("UTF-8");
        return localMessageDigest.digest(paramString);
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
        bhzm.e("andygzyu-MD5", "toMD5Byte, source.getBytes crash!");
      }
      paramString = paramString;
      paramString.printStackTrace();
      bhzm.e("andygzyu-MD5", "toMD5Byte, MessageDigest.getInstance crash!");
      return null;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhzn
 * JD-Core Version:    0.7.0.1
 */