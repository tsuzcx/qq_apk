import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.now.FileUploadUtil.1;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class awbr
{
  private static String jdField_a_of_type_JavaLangString;
  private static char[] jdField_a_of_type_ArrayOfChar = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  
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
    if (paramHttpURLConnection.getResponseCode() != 200) {
      throw new IOException(anzj.a(2131703471));
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
    //   6: invokevirtual 133	java/io/File:getName	()Ljava/lang/String;
    //   9: astore_3
    //   10: aload_0
    //   11: new 109	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   18: ldc 135
    //   20: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 59	awbr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   26: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: ldc 142
    //   38: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: new 109	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   49: ldc 144
    //   51: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_3
    //   55: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 146
    //   60: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   69: aload_0
    //   70: ldc 142
    //   72: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   75: aload_0
    //   76: new 109	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   83: ldc 148
    //   85: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: invokestatic 153	java/net/URLConnection:guessContentTypeFromName	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   101: aload_0
    //   102: ldc 142
    //   104: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: ldc 142
    //   110: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   113: aconst_null
    //   114: astore_3
    //   115: new 155	java/io/FileInputStream
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 158	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   123: astore_1
    //   124: sipush 4096
    //   127: newarray byte
    //   129: astore_3
    //   130: aload_1
    //   131: aload_3
    //   132: invokevirtual 161	java/io/InputStream:read	([B)I
    //   135: istore_2
    //   136: iload_2
    //   137: iconst_m1
    //   138: if_icmpeq +25 -> 163
    //   141: aload_0
    //   142: aload_3
    //   143: iconst_0
    //   144: iload_2
    //   145: invokevirtual 164	java/io/DataOutputStream:write	([BII)V
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
    //   168: ldc 142
    //   170: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: invokevirtual 167	java/io/DataOutputStream:flush	()V
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
        paramDataOutputStream.writeBytes(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
        paramDataOutputStream.writeBytes("\r\n");
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null))
    {
      Log.e("HttpUtil", "uin null or file path null");
      return;
    }
    ThreadManagerV2.excute(new FileUploadUtil.1(paramString1, paramString2), 128, null, false);
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
  
  private static String b(String paramString)
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
          break label71;
        }
        arrayOfString = paramString.split("=", 2);
        paramString = str;
        if (arrayOfString.length == 2) {
          paramString = arrayOfString[1].trim();
        }
      }
      return paramString;
      label71:
      i += 1;
    }
  }
  
  /* Error */
  private static String b(String paramString, Map<String, String> paramMap, java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 267	awbr:a	(Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   6: astore_0
    //   7: new 137	java/io/DataOutputStream
    //   10: dup
    //   11: aload_0
    //   12: invokevirtual 271	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   15: invokespecial 274	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_3
    //   19: aload_3
    //   20: aload_1
    //   21: invokestatic 276	awbr:a	(Ljava/io/DataOutputStream;Ljava/util/Map;)V
    //   24: aload_3
    //   25: aload_2
    //   26: invokestatic 278	awbr:a	(Ljava/io/DataOutputStream;Ljava/io/File;)V
    //   29: aload_3
    //   30: ldc 142
    //   32: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   35: aload_3
    //   36: new 109	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   43: ldc 135
    //   45: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: getstatic 59	awbr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 135
    //   56: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   65: aload_3
    //   66: ldc 142
    //   68: invokevirtual 140	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   71: aload_3
    //   72: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   75: aload_0
    //   76: invokestatic 281	awbr:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   79: astore_1
    //   80: ldc 215
    //   82: aload_1
    //   83: invokestatic 284	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   86: pop
    //   87: aload_0
    //   88: ifnull +7 -> 95
    //   91: aload_0
    //   92: invokevirtual 287	java/net/HttpURLConnection:disconnect	()V
    //   95: aload_3
    //   96: ifnull +7 -> 103
    //   99: aload_3
    //   100: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   103: aload_1
    //   104: areturn
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   110: aload_1
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_1
    //   115: aload_3
    //   116: astore_2
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 287	java/net/HttpURLConnection:disconnect	()V
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 279	java/io/DataOutputStream:close	()V
    //   133: aload_0
    //   134: athrow
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   140: goto -7 -> 133
    //   143: astore_3
    //   144: aconst_null
    //   145: astore_1
    //   146: aload_0
    //   147: astore_2
    //   148: aload_3
    //   149: astore_0
    //   150: goto -33 -> 117
    //   153: astore_1
    //   154: aload_0
    //   155: astore_2
    //   156: aload_1
    //   157: astore_0
    //   158: aload_3
    //   159: astore_1
    //   160: goto -43 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramString	String
    //   0	163	1	paramMap	Map<String, String>
    //   0	163	2	paramFile	java.io.File
    //   1	115	3	localDataOutputStream	DataOutputStream
    //   143	16	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   99	103	105	java/lang/Exception
    //   2	7	112	finally
    //   129	133	135	java/lang/Exception
    //   7	19	143	finally
    //   19	87	153	finally
  }
  
  private static String b(HttpURLConnection paramHttpURLConnection)
  {
    String str = b(paramHttpURLConnection.getContentType());
    InputStream localInputStream = paramHttpURLConnection.getErrorStream();
    if (localInputStream == null) {
      return a(paramHttpURLConnection.getInputStream(), str);
    }
    return a(localInputStream, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbr
 * JD-Core Version:    0.7.0.1
 */