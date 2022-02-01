import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.GGMM.3;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.MobileQQ;

public class blch
{
  private static final Set<String> jdField_a_of_type_JavaUtilSet;
  private static final byte[] jdField_a_of_type_ArrayOfByte;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "mc", "md", "mg", "wfm", "sno", "fg", "brd", "hw", "dv", "tm", "ts", "rs", "rc", "rc2" };
  private static final byte[] b;
  
  static
  {
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_ArrayOfByte = new byte[] { 74, 39, 2, -61, -88, -75, -36, 105, -102, 39, 2, 69, -72, -11, -84, 50 };
    b = new byte[] { -86, 39, 34, -61, -88, -75, -84, 105, 74, 39, 2, -61, -88, -75, -68, 105 };
    jdField_a_of_type_JavaUtilSet.add("mg");
    jdField_a_of_type_JavaUtilSet.add("wfm");
  }
  
  private static InputStream a()
  {
    if (!bhjr.a()) {}
    Object localObject;
    do
    {
      return null;
      localObject = new File(d());
    } while ((!((File)localObject).exists()) || (((File)localObject).length() > 102400L));
    try
    {
      IvParameterSpec localIvParameterSpec = new IvParameterSpec(b);
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(jdField_a_of_type_ArrayOfByte, "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
      localCipher.init(2, localSecretKeySpec, localIvParameterSpec);
      localObject = new CipherInputStream(new BufferedInputStream(new FileInputStream((File)localObject)), localCipher);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private static String a()
  {
    String str2 = blbf.b(1);
    String str1 = str2;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() > 0) {
        str1 = ("A" + str2 + "123456789ABCDEF").substring(0, 15);
      }
    }
    return str1;
  }
  
  /* Error */
  private static String a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: new 157	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   9: astore 4
    //   11: new 175	java/security/SecureRandom
    //   14: dup
    //   15: invokespecial 176	java/security/SecureRandom:<init>	()V
    //   18: astore 5
    //   20: iconst_0
    //   21: istore_1
    //   22: aload 4
    //   24: astore_3
    //   25: iload_1
    //   26: iload_0
    //   27: if_icmpge +88 -> 115
    //   30: aload 4
    //   32: aload 5
    //   34: bipush 25
    //   36: invokevirtual 180	java/security/SecureRandom:nextInt	(I)I
    //   39: bipush 65
    //   41: iadd
    //   42: i2c
    //   43: invokevirtual 183	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: iload_1
    //   48: iconst_1
    //   49: iadd
    //   50: istore_1
    //   51: goto -29 -> 22
    //   54: astore_3
    //   55: new 157	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   62: astore 4
    //   64: new 185	java/util/Random
    //   67: dup
    //   68: invokespecial 186	java/util/Random:<init>	()V
    //   71: astore 5
    //   73: aload 5
    //   75: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   78: invokevirtual 195	java/util/Random:setSeed	(J)V
    //   81: iload_2
    //   82: istore_1
    //   83: aload 4
    //   85: astore_3
    //   86: iload_1
    //   87: iload_0
    //   88: if_icmpge +27 -> 115
    //   91: aload 4
    //   93: aload 5
    //   95: bipush 25
    //   97: invokevirtual 196	java/util/Random:nextInt	(I)I
    //   100: bipush 65
    //   102: iadd
    //   103: i2c
    //   104: invokevirtual 183	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: iload_1
    //   109: iconst_1
    //   110: iadd
    //   111: istore_1
    //   112: goto -29 -> 83
    //   115: aload_3
    //   116: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramInt	int
    //   21	91	1	i	int
    //   1	81	2	j	int
    //   24	1	3	localStringBuilder1	StringBuilder
    //   54	1	3	localException	Exception
    //   85	31	3	localStringBuilder2	StringBuilder
    //   9	83	4	localStringBuilder3	StringBuilder
    //   18	76	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	20	54	java/lang/Exception
    //   30	47	54	java/lang/Exception
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new String(Base64.decode(paramString.getBytes(), 2));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static String a(Map<String, String> paramMap, String paramString)
  {
    return (String)paramMap.get(paramString);
  }
  
  public static Map<String, String> a()
  {
    try
    {
      Map localMap = a(new FileInputStream("/proc/cpuinfo"), new blci());
      return localMap;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  private static Map<String, String> a(InputStream paramInputStream, blck paramblck)
  {
    // Byte code:
    //   0: new 233	java/util/HashMap
    //   3: dup
    //   4: invokespecial 234	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: new 236	java/io/BufferedReader
    //   11: dup
    //   12: new 238	java/io/InputStreamReader
    //   15: dup
    //   16: aload_0
    //   17: ldc 240
    //   19: invokespecial 243	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   22: invokespecial 246	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_0
    //   28: aload_2
    //   29: invokevirtual 249	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +61 -> 97
    //   39: aload_2
    //   40: astore_0
    //   41: aload_1
    //   42: aload 4
    //   44: invokeinterface 254 2 0
    //   49: astore 4
    //   51: aload 4
    //   53: ifnull -27 -> 26
    //   56: aload_2
    //   57: astore_0
    //   58: aload_3
    //   59: aload 4
    //   61: getfield 260	android/util/Pair:first	Ljava/lang/Object;
    //   64: aload 4
    //   66: getfield 263	android/util/Pair:second	Ljava/lang/Object;
    //   69: invokevirtual 267	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   72: pop
    //   73: goto -47 -> 26
    //   76: astore_0
    //   77: aload_2
    //   78: astore_1
    //   79: aload_0
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: aload_2
    //   84: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 270	java/io/BufferedReader:close	()V
    //   95: aload_3
    //   96: areturn
    //   97: aload_2
    //   98: ifnull -3 -> 95
    //   101: aload_2
    //   102: invokevirtual 270	java/io/BufferedReader:close	()V
    //   105: aload_3
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   112: aload_3
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   119: aload_3
    //   120: areturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_0
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 270	java/io/BufferedReader:close	()V
    //   132: aload_1
    //   133: athrow
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   139: goto -7 -> 132
    //   142: astore_1
    //   143: goto -19 -> 124
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_1
    //   149: goto -68 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramInputStream	InputStream
    //   0	152	1	paramblck	blck
    //   25	77	2	localObject1	Object
    //   146	1	2	localException	Exception
    //   7	113	3	localHashMap	HashMap
    //   32	33	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	34	76	java/lang/Exception
    //   41	51	76	java/lang/Exception
    //   58	73	76	java/lang/Exception
    //   101	105	107	java/lang/Exception
    //   91	95	114	java/lang/Exception
    //   8	26	121	finally
    //   128	132	134	java/lang/Exception
    //   28	34	142	finally
    //   41	51	142	finally
    //   58	73	142	finally
    //   83	87	142	finally
    //   8	26	146	java/lang/Exception
  }
  
  private static Map<String, String> a(String[] paramArrayOfString)
  {
    Map localMap = c();
    Object localObject2 = null;
    HashMap localHashMap = new HashMap();
    HashSet localHashSet = new HashSet();
    int i1 = paramArrayOfString.length;
    int n = 0;
    int i = 0;
    int j = 0;
    String str;
    Object localObject3;
    Object localObject1;
    if (n < i1)
    {
      str = paramArrayOfString[n];
      if (jdField_a_of_type_JavaUtilSet.contains(str))
      {
        localObject3 = b(localHashMap, str);
        localHashSet.add(str);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localHashMap.put(str, localObject3);
      n += 1;
      localObject2 = localObject1;
      break;
      localObject1 = (String)localMap.get(str);
      localObject3 = localObject1;
      Object localObject4 = localObject2;
      int k = i;
      int m = j;
      if (localObject1 == null)
      {
        j += 1;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = b();
        }
        localObject2 = (String)((Map)localObject1).get(str);
        localObject3 = localObject2;
        localObject4 = localObject1;
        k = i;
        m = j;
        if (localObject2 == null)
        {
          i += 1;
          localObject2 = b(localHashMap, str);
          localObject3 = localObject2;
          localObject4 = localObject1;
          k = i;
          m = j;
          if (str.equals("md"))
          {
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localHashSet.add("md");
              j -= 1;
              i -= 1;
              localObject3 = localObject2;
              continue;
            }
            localObject3 = b();
            continue;
            if (j > 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GGMM", 2, "update to sp.");
              }
              b(localHashSet, localHashMap);
            }
            if ((i > 0) || (a()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("GGMM", 2, "update to sdcard.");
              }
              a(localHashSet, localHashMap);
            }
            return localHashMap;
          }
        }
      }
      j = m;
      localObject1 = localObject4;
      i = k;
    }
  }
  
  public static void a()
  {
    long l1 = 604800000L;
    if (!QSecFramework.a().a(1002).booleanValue()) {
      if (QLog.isColorLevel()) {
        QLog.d("GGMM", 2, "door closed.");
      }
    }
    Object localObject;
    String str;
    do
    {
      do
      {
        return;
        localObject = BaseApplication.getContext().getSharedPreferences("di_time", 0);
      } while (localObject == null);
      str = e();
    } while (str == null);
    long l2 = ((SharedPreferences)localObject).getLong(str, 0L);
    long l3 = new Date().getTime();
    if (l3 - l2 > 604800000L)
    {
      b();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong(str, l3);
      ((SharedPreferences.Editor)localObject).commit();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GGMM", 2, "rpt after: " + l1);
      }
      QSecFramework.a().postDelayed(new GGMM.3(), l1);
      return;
      l1 = 604800000L - l3 + l2;
    }
  }
  
  private static void a(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    if (paramMap1 == null) {}
    for (;;)
    {
      return;
      paramMap1 = paramMap1.entrySet().iterator();
      while (paramMap1.hasNext())
      {
        Object localObject = (Map.Entry)paramMap1.next();
        String str = a((String)((Map.Entry)localObject).getKey());
        localObject = a((String)((Map.Entry)localObject).getValue());
        if ((str != null) && (localObject != null)) {
          paramMap2.put(str, localObject);
        }
      }
    }
  }
  
  /* Error */
  private static void a(Set<String> paramSet, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: invokestatic 87	bhjr:a	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore_3
    //   9: new 107	javax/crypto/spec/IvParameterSpec
    //   12: dup
    //   13: getstatic 72	blch:b	[B
    //   16: invokespecial 110	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   19: astore_2
    //   20: new 112	javax/crypto/spec/SecretKeySpec
    //   23: dup
    //   24: getstatic 67	blch:jdField_a_of_type_ArrayOfByte	[B
    //   27: ldc 114
    //   29: invokespecial 117	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   32: astore 4
    //   34: ldc 119
    //   36: invokestatic 125	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   39: astore 5
    //   41: aload 5
    //   43: iconst_1
    //   44: aload 4
    //   46: aload_2
    //   47: invokevirtual 129	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   50: new 422	javax/crypto/CipherOutputStream
    //   53: dup
    //   54: new 424	java/io/FileOutputStream
    //   57: dup
    //   58: invokestatic 93	blch:d	()Ljava/lang/String;
    //   61: invokespecial 425	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   64: aload 5
    //   66: invokespecial 428	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   69: astore_2
    //   70: aload_1
    //   71: invokeinterface 396 1 0
    //   76: invokeinterface 400 1 0
    //   81: astore_1
    //   82: aload_1
    //   83: invokeinterface 405 1 0
    //   88: ifeq +116 -> 204
    //   91: aload_1
    //   92: invokeinterface 409 1 0
    //   97: checkcast 411	java/util/Map$Entry
    //   100: astore_3
    //   101: aload_0
    //   102: aload_3
    //   103: invokeinterface 414 1 0
    //   108: invokeinterface 278 2 0
    //   113: ifne -31 -> 82
    //   116: aload_2
    //   117: new 157	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   124: aload_3
    //   125: invokeinterface 414 1 0
    //   130: checkcast 14	java/lang/String
    //   133: invokevirtual 201	java/lang/String:getBytes	()[B
    //   136: iconst_2
    //   137: invokestatic 432	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   140: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 434
    //   146: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_3
    //   150: invokeinterface 419 1 0
    //   155: checkcast 14	java/lang/String
    //   158: invokevirtual 201	java/lang/String:getBytes	()[B
    //   161: iconst_2
    //   162: invokestatic 432	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   165: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 436
    //   171: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokevirtual 201	java/lang/String:getBytes	()[B
    //   180: invokevirtual 441	java/io/OutputStream:write	([B)V
    //   183: goto -101 -> 82
    //   186: astore_1
    //   187: aload_2
    //   188: astore_0
    //   189: aload_1
    //   190: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   193: aload_0
    //   194: ifnull -188 -> 6
    //   197: aload_0
    //   198: invokevirtual 442	java/io/OutputStream:close	()V
    //   201: return
    //   202: astore_0
    //   203: return
    //   204: aload_2
    //   205: ifnull -199 -> 6
    //   208: aload_2
    //   209: invokevirtual 442	java/io/OutputStream:close	()V
    //   212: return
    //   213: astore_0
    //   214: return
    //   215: astore_0
    //   216: aconst_null
    //   217: astore_1
    //   218: aload_1
    //   219: ifnull +7 -> 226
    //   222: aload_1
    //   223: invokevirtual 442	java/io/OutputStream:close	()V
    //   226: aload_0
    //   227: athrow
    //   228: astore_1
    //   229: goto -3 -> 226
    //   232: astore_0
    //   233: aload_2
    //   234: astore_1
    //   235: goto -17 -> 218
    //   238: astore_2
    //   239: aload_0
    //   240: astore_1
    //   241: aload_2
    //   242: astore_0
    //   243: goto -25 -> 218
    //   246: astore_1
    //   247: aload_3
    //   248: astore_0
    //   249: goto -60 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramSet	Set<String>
    //   0	252	1	paramMap	Map<String, String>
    //   19	215	2	localObject1	Object
    //   238	4	2	localObject2	Object
    //   8	240	3	localEntry	Map.Entry
    //   32	13	4	localSecretKeySpec	SecretKeySpec
    //   39	26	5	localCipher	Cipher
    // Exception table:
    //   from	to	target	type
    //   70	82	186	java/lang/Exception
    //   82	183	186	java/lang/Exception
    //   197	201	202	java/io/IOException
    //   208	212	213	java/io/IOException
    //   9	70	215	finally
    //   222	226	228	java/io/IOException
    //   70	82	232	finally
    //   82	183	232	finally
    //   189	193	238	finally
    //   9	70	246	java/lang/Exception
  }
  
  private static boolean a()
  {
    File localFile = new File(d());
    return (bhjr.a()) && (!localFile.exists());
  }
  
  private static String b()
  {
    return "A" + a(15);
  }
  
  private static String b(Map<String, String> paramMap, String paramString)
  {
    Object localObject = null;
    if (paramString.equals("wfm")) {
      paramMap = blbf.b(2);
    }
    for (;;)
    {
      paramString = paramMap;
      if (paramMap == null) {
        paramString = "";
      }
      return paramString;
      if (paramString.equals("mc"))
      {
        paramMap = c();
      }
      else if (paramString.equals("md"))
      {
        paramMap = a();
      }
      else if (paramString.equals("mg"))
      {
        paramString = new StringBuilder();
        paramString.append(bhlo.f());
        paramString.append((String)paramMap.get("md"));
        paramString.append(Build.MANUFACTURER + Build.MODEL + (String)paramMap.get("mc"));
        paramMap = "A" + bleb.b(paramString.toString()).substring(0, 15);
      }
      else if (paramString.equals("sno"))
      {
        paramMap = blhc.c();
      }
      else if (paramString.equals("fg"))
      {
        paramMap = Build.FINGERPRINT;
      }
      else if (paramString.equals("brd"))
      {
        paramMap = Build.BOARD;
      }
      else if (paramString.equals("tm"))
      {
        paramMap = Long.toString(bhlo.d());
      }
      else if (paramString.equals("ts"))
      {
        paramMap = Long.toString(bhlo.b()[0]);
      }
      else if (paramString.equals("rs"))
      {
        paramMap = bhlo.l();
      }
      else if (paramString.equals("hw"))
      {
        paramMap = Build.HARDWARE;
      }
      else if (paramString.equals("dv"))
      {
        paramMap = Build.DEVICE;
      }
      else if (paramString.equals("rc"))
      {
        paramMap = a(16);
      }
      else
      {
        paramMap = localObject;
        if (paramString.equals("rc2")) {
          paramMap = a(16);
        }
      }
    }
  }
  
  private static Map<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    InputStream localInputStream = a();
    if (localInputStream == null) {}
    do
    {
      return localHashMap;
      a(a(localInputStream, new blcj()), localHashMap);
    } while (localInputStream == null);
    try
    {
      localInputStream.close();
      return localHashMap;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localHashMap;
  }
  
  private static void b()
  {
    Map localMap = a(jdField_a_of_type_ArrayOfJavaLangString);
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = (String)localMap.get(arrayOfString[i]);
      localStringBuilder.append(",");
      localStringBuilder.append(str.replace(",", "&#44"));
      i += 1;
    }
    blbg.b(localStringBuilder.toString().substring(1), 110);
  }
  
  private static void b(Set<String> paramSet, Map<String, String> paramMap)
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("dfp", 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if (!paramSet.contains(localEntry.getKey())) {
            ((SharedPreferences.Editor)localObject).putString(Base64.encodeToString(((String)localEntry.getKey()).getBytes(), 2), Base64.encodeToString(((String)localEntry.getValue()).getBytes(), 2));
          }
        }
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  private static String c()
  {
    Map localMap = a();
    if (localMap == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(": ");
    localStringBuilder.append(a(localMap, "Features"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(localMap, "Processor"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(localMap, "CPU architecture"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(localMap, "Hardware"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(localMap, "Serial"));
    return localStringBuilder.toString();
  }
  
  private static Map<String, String> c()
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("dfp", 0);
    HashMap localHashMap = new HashMap();
    if (localSharedPreferences != null) {}
    try
    {
      a(localSharedPreferences.getAll(), localHashMap);
      return localHashMap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localHashMap;
  }
  
  private static String d()
  {
    return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/kf2.dat";
  }
  
  private static String e()
  {
    Object localObject = (QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getCurrentAccountUin();
      if (localObject != null) {
        try
        {
          long l = Long.parseLong((String)localObject);
          localObject = Base64.encodeToString((bhlo.c() + "_" + Long.toString(l ^ 0xADCD123)).getBytes(), 2);
          return localObject;
        }
        catch (Exception localException) {}
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blch
 * JD-Core Version:    0.7.0.1
 */