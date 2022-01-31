import android.util.Log;
import com.tencent.mobileqq.intervideo.huiyin.FileUploadUtil.1;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class argo
{
  private static String jdField_a_of_type_JavaLangString;
  private static char[] jdField_a_of_type_ArrayOfChar = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private static String b;
  
  private static String a(InputStream paramInputStream, String paramString)
  {
    try
    {
      paramString = new BufferedReader(new InputStreamReader(paramInputStream, paramString));
      StringWriter localStringWriter = new StringWriter();
      char[] arrayOfChar = new char[256];
      for (;;)
      {
        int i = paramString.read(arrayOfChar);
        if (i <= 0) {
          break;
        }
        localStringWriter.write(arrayOfChar, 0, i);
      }
      paramString = localStringWriter.toString();
    }
    finally
    {
      if (paramInputStream != null) {
        paramInputStream.close();
      }
    }
    if (paramInputStream != null) {
      paramInputStream.close();
    }
    return paramString;
  }
  
  private static String a(HttpURLConnection paramHttpURLConnection)
  {
    int i = paramHttpURLConnection.getResponseCode();
    if (i != 200) {
      throw new IOException(ajyc.a(2131704572) + i);
    }
    return b(paramHttpURLConnection);
  }
  
  private static HttpURLConnection a(String paramString)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setDoInput(true);
    paramString.setUseCaches(false);
    paramString.setDoOutput(true);
    paramString.setRequestMethod("POST");
    paramString.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + jdField_a_of_type_JavaLangString);
    paramString.setRequestProperty("Cookie", b + jdField_a_of_type_JavaLangString);
    paramString.setRequestProperty("User-Agent", "Android Client Agent");
    return paramString;
  }
  
  /* Error */
  private static void a(DataOutputStream paramDataOutputStream, java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokevirtual 137	java/io/File:getName	()Ljava/lang/String;
    //   9: astore_3
    //   10: aload_0
    //   11: new 70	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   18: ldc 139
    //   20: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 59	argo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: ldc 146
    //   38: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: new 70	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   49: ldc 148
    //   51: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_3
    //   55: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 150
    //   60: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   69: aload_0
    //   70: ldc 146
    //   72: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: new 70	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   83: ldc 152
    //   85: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokestatic 157	java/net/URLConnection:guessContentTypeFromName	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: ldc 146
    //   104: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: ldc 146
    //   110: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   113: aconst_null
    //   114: astore_3
    //   115: new 159	java/io/FileInputStream
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 162	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   123: astore_1
    //   124: sipush 4096
    //   127: newarray byte
    //   129: astore_3
    //   130: aload_1
    //   131: aload_3
    //   132: invokevirtual 165	java/io/InputStream:read	([B)I
    //   135: istore_2
    //   136: iload_2
    //   137: iconst_m1
    //   138: if_icmpeq +25 -> 163
    //   141: aload_0
    //   142: aload_3
    //   143: iconst_0
    //   144: iload_2
    //   145: invokevirtual 168	java/io/DataOutputStream:write	([BII)V
    //   148: goto -18 -> 130
    //   151: astore_0
    //   152: aload_1
    //   153: ifnull -149 -> 4
    //   156: aload_1
    //   157: invokevirtual 53	java/io/InputStream:close	()V
    //   160: return
    //   161: astore_0
    //   162: return
    //   163: aload_1
    //   164: invokevirtual 53	java/io/InputStream:close	()V
    //   167: aload_0
    //   168: ldc 146
    //   170: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: invokevirtual 171	java/io/DataOutputStream:flush	()V
    //   177: aload_1
    //   178: ifnull -174 -> 4
    //   181: aload_1
    //   182: invokevirtual 53	java/io/InputStream:close	()V
    //   185: return
    //   186: astore_0
    //   187: return
    //   188: astore_0
    //   189: aload_3
    //   190: astore_1
    //   191: aload_1
    //   192: ifnull +7 -> 199
    //   195: aload_1
    //   196: invokevirtual 53	java/io/InputStream:close	()V
    //   199: aload_0
    //   200: athrow
    //   201: astore_1
    //   202: goto -3 -> 199
    //   205: astore_0
    //   206: goto -15 -> 191
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_1
    //   212: goto -60 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramDataOutputStream	DataOutputStream
    //   0	215	1	paramFile	java.io.File
    //   135	10	2	i	int
    //   9	181	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   124	130	151	java/io/IOException
    //   130	136	151	java/io/IOException
    //   141	148	151	java/io/IOException
    //   163	177	151	java/io/IOException
    //   156	160	161	java/lang/Exception
    //   181	185	186	java/lang/Exception
    //   115	124	188	finally
    //   195	199	201	java/lang/Exception
    //   124	130	205	finally
    //   130	136	205	finally
    //   141	148	205	finally
    //   163	177	205	finally
    //   115	124	209	java/io/IOException
  }
  
  private static void a(DataOutputStream paramDataOutputStream, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {}
    for (;;)
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramDataOutputStream.writeBytes("--" + jdField_a_of_type_JavaLangString);
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + (String)localEntry.getKey() + "\"");
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.writeBytes("\r\n");
        paramDataOutputStream.writeBytes((String)localEntry.getValue());
        paramDataOutputStream.writeBytes("\r\n");
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, argp paramargp)
  {
    Log.i("legoupload", paramString1 + "\n" + paramString2 + "\nusername " + paramString5);
    if ((paramString2 == null) || (paramString1 == null))
    {
      Log.e("HuiyinFileUpload", "url null or file path null");
      return;
    }
    new Thread(new FileUploadUtil.1(paramString6, paramString5, paramString3, paramString4, paramString7, paramString8, paramString1, paramString2, paramargp)).start();
  }
  
  private static String b()
  {
    Random localRandom = new Random();
    char[] arrayOfChar = new char[localRandom.nextInt(9) + 12];
    int i = 0;
    while (i < arrayOfChar.length)
    {
      arrayOfChar[i] = jdField_a_of_type_ArrayOfChar[localRandom.nextInt(jdField_a_of_type_ArrayOfChar.length)];
      i += 1;
    }
    return "===AndroidFormBoundary" + new String(arrayOfChar);
  }
  
  private static String b(HttpURLConnection paramHttpURLConnection)
  {
    String str = c(paramHttpURLConnection.getContentType());
    InputStream localInputStream = paramHttpURLConnection.getErrorStream();
    if (localInputStream == null) {
      return a(paramHttpURLConnection.getInputStream(), str);
    }
    return a(localInputStream, str);
  }
  
  /* Error */
  private static void b(String paramString, Map<String, String> paramMap, java.io.File paramFile, argp paramargp)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 273	argo:a	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   7: astore_0
    //   8: new 141	java/io/DataOutputStream
    //   11: dup
    //   12: aload_0
    //   13: invokevirtual 277	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   16: invokespecial 280	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: astore 4
    //   21: aload 4
    //   23: aload_1
    //   24: invokestatic 282	argo:a	(Ljava/io/DataOutputStream;Ljava/util/Map;)V
    //   27: aload 4
    //   29: aload_2
    //   30: invokestatic 284	argo:a	(Ljava/io/DataOutputStream;Ljava/io/File;)V
    //   33: aload 4
    //   35: ldc 146
    //   37: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   40: aload 4
    //   42: new 70	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   49: ldc 139
    //   51: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: getstatic 59	argo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   57: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 139
    //   62: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   71: aload 4
    //   73: ldc 146
    //   75: invokevirtual 144	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   78: aload 4
    //   80: invokevirtual 285	java/io/DataOutputStream:close	()V
    //   83: aload_3
    //   84: iconst_0
    //   85: aload_0
    //   86: invokestatic 287	argo:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   89: invokeinterface 292 3 0
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 295	java/net/HttpURLConnection:disconnect	()V
    //   102: aload 4
    //   104: ifnull +8 -> 112
    //   107: aload 4
    //   109: invokevirtual 285	java/io/DataOutputStream:close	()V
    //   112: return
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 298	java/lang/Exception:printStackTrace	()V
    //   118: return
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_1
    //   122: aload 4
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull +7 -> 133
    //   129: aload_2
    //   130: invokevirtual 295	java/net/HttpURLConnection:disconnect	()V
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 285	java/io/DataOutputStream:close	()V
    //   141: aload_0
    //   142: athrow
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual 298	java/lang/Exception:printStackTrace	()V
    //   148: goto -7 -> 141
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_1
    //   154: aload_0
    //   155: astore_2
    //   156: aload_3
    //   157: astore_0
    //   158: goto -33 -> 125
    //   161: astore_1
    //   162: aload_0
    //   163: astore_2
    //   164: aload_1
    //   165: astore_0
    //   166: aload 4
    //   168: astore_1
    //   169: goto -44 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramString	String
    //   0	172	1	paramMap	Map<String, String>
    //   0	172	2	paramFile	java.io.File
    //   0	172	3	paramargp	argp
    //   1	166	4	localDataOutputStream	DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   107	112	113	java/lang/Exception
    //   3	8	119	finally
    //   137	141	143	java/lang/Exception
    //   8	21	151	finally
    //   21	94	161	finally
  }
  
  private static String c(String paramString)
  {
    String str = "UTF-8";
    String[] arrayOfString = paramString.split(";");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = str;
      if (i < j)
      {
        paramString = arrayOfString[i].trim();
        if (!paramString.startsWith("charset")) {
          break label73;
        }
        arrayOfString = paramString.split("=", 2);
        paramString = str;
        if (arrayOfString.length == 2) {
          paramString = arrayOfString[1].trim();
        }
      }
      return paramString;
      label73:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     argo
 * JD-Core Version:    0.7.0.1
 */