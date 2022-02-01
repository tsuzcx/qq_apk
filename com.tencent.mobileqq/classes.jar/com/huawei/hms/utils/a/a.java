package com.huawei.hms.utils.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

public class a
{
  private static String a(String paramString1, String paramString2)
  {
    int i = paramString1.toUpperCase(Locale.getDefault()).indexOf(paramString2 + "=");
    if (i == -1) {
      return null;
    }
    int j = paramString1.indexOf(",", i);
    if (j != -1) {
      return paramString1.substring(i + paramString2.length() + 1, j);
    }
    return paramString1.substring(i + paramString2.length() + 1);
  }
  
  public static X509Certificate a(Context paramContext)
  {
    return a(paramContext, "052root");
  }
  
  /* Error */
  public static X509Certificate a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +12 -> 20
    //   11: ldc 77
    //   13: ldc 79
    //   15: invokestatic 85	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: aconst_null
    //   19: areturn
    //   20: ldc 87
    //   22: invokestatic 93	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   25: astore 4
    //   27: aload_0
    //   28: invokevirtual 99	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   31: ldc 101
    //   33: invokevirtual 107	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore_2
    //   37: aload_2
    //   38: astore_3
    //   39: aload 4
    //   41: aload_2
    //   42: ldc 109
    //   44: invokevirtual 113	java/lang/String:toCharArray	()[C
    //   47: invokevirtual 117	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   50: aload_2
    //   51: astore_3
    //   52: aload 4
    //   54: aload_1
    //   55: invokevirtual 121	java/security/KeyStore:containsAlias	(Ljava/lang/String;)Z
    //   58: ifne +35 -> 93
    //   61: aload_2
    //   62: astore_3
    //   63: ldc 77
    //   65: new 20	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   72: ldc 123
    //   74: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_1
    //   78: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 85	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_2
    //   88: invokestatic 129	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   91: aconst_null
    //   92: areturn
    //   93: aload_2
    //   94: astore_3
    //   95: aload 4
    //   97: aload_1
    //   98: invokevirtual 133	java/security/KeyStore:getCertificate	(Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   101: astore_0
    //   102: aload_2
    //   103: astore_3
    //   104: aload_0
    //   105: instanceof 135
    //   108: ifeq +22 -> 130
    //   111: aload_2
    //   112: astore_3
    //   113: aload_0
    //   114: checkcast 135	java/security/cert/X509Certificate
    //   117: astore_0
    //   118: aload_2
    //   119: astore_3
    //   120: aload_0
    //   121: invokevirtual 138	java/security/cert/X509Certificate:checkValidity	()V
    //   124: aload_2
    //   125: invokestatic 129	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   128: aload_0
    //   129: areturn
    //   130: aload_2
    //   131: invokestatic 129	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_1
    //   139: aload_1
    //   140: astore_3
    //   141: ldc 77
    //   143: new 20	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   150: ldc 140
    //   152: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_0
    //   156: invokevirtual 145	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 85	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_1
    //   169: invokestatic 129	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   172: goto -38 -> 134
    //   175: astore_0
    //   176: aconst_null
    //   177: astore_3
    //   178: aload_3
    //   179: invokestatic 129	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   182: aload_0
    //   183: athrow
    //   184: astore_0
    //   185: goto -7 -> 178
    //   188: astore_0
    //   189: aload_2
    //   190: astore_1
    //   191: goto -52 -> 139
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_1
    //   197: goto -58 -> 139
    //   200: astore_0
    //   201: aload_2
    //   202: astore_1
    //   203: goto -64 -> 139
    //   206: astore_0
    //   207: aconst_null
    //   208: astore_1
    //   209: goto -70 -> 139
    //   212: astore_0
    //   213: aload_2
    //   214: astore_1
    //   215: goto -76 -> 139
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_1
    //   221: goto -82 -> 139
    //   224: astore_0
    //   225: aload_2
    //   226: astore_1
    //   227: goto -88 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	230	0	paramContext	Context
    //   0	230	1	paramString	String
    //   36	190	2	localInputStream	java.io.InputStream
    //   38	141	3	localObject	Object
    //   25	71	4	localKeyStore	java.security.KeyStore
    // Exception table:
    //   from	to	target	type
    //   20	37	136	java/security/KeyStoreException
    //   20	37	175	finally
    //   39	50	184	finally
    //   52	61	184	finally
    //   63	87	184	finally
    //   95	102	184	finally
    //   104	111	184	finally
    //   113	118	184	finally
    //   120	124	184	finally
    //   141	168	184	finally
    //   39	50	188	java/security/KeyStoreException
    //   52	61	188	java/security/KeyStoreException
    //   63	87	188	java/security/KeyStoreException
    //   95	102	188	java/security/KeyStoreException
    //   104	111	188	java/security/KeyStoreException
    //   113	118	188	java/security/KeyStoreException
    //   120	124	188	java/security/KeyStoreException
    //   20	37	194	java/security/NoSuchAlgorithmException
    //   39	50	200	java/security/NoSuchAlgorithmException
    //   52	61	200	java/security/NoSuchAlgorithmException
    //   63	87	200	java/security/NoSuchAlgorithmException
    //   95	102	200	java/security/NoSuchAlgorithmException
    //   104	111	200	java/security/NoSuchAlgorithmException
    //   113	118	200	java/security/NoSuchAlgorithmException
    //   120	124	200	java/security/NoSuchAlgorithmException
    //   20	37	206	java/security/cert/CertificateException
    //   39	50	212	java/security/cert/CertificateException
    //   52	61	212	java/security/cert/CertificateException
    //   63	87	212	java/security/cert/CertificateException
    //   95	102	212	java/security/cert/CertificateException
    //   104	111	212	java/security/cert/CertificateException
    //   113	118	212	java/security/cert/CertificateException
    //   120	124	212	java/security/cert/CertificateException
    //   20	37	218	java/io/IOException
    //   39	50	224	java/io/IOException
    //   52	61	224	java/io/IOException
    //   63	87	224	java/io/IOException
    //   95	102	224	java/io/IOException
    //   104	111	224	java/io/IOException
    //   113	118	224	java/io/IOException
    //   120	124	224	java/io/IOException
  }
  
  public static X509Certificate a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = a(Base64.decode(paramString));
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      HMSLog.e("X509CertUtil", "getCert failed : " + paramString.getMessage());
    }
    return null;
  }
  
  public static X509Certificate a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (CertificateException paramArrayOfByte)
    {
      HMSLog.e("X509CertUtil", "Failed to get cert: " + paramArrayOfByte.getMessage());
    }
    return null;
  }
  
  public static List<X509Certificate> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((String)paramList.next()));
    }
    return localArrayList;
  }
  
  public static boolean a(X509Certificate paramX509Certificate)
  {
    if (paramX509Certificate == null) {}
    while (paramX509Certificate.getBasicConstraints() == -1) {
      return false;
    }
    return paramX509Certificate.getKeyUsage()[5];
  }
  
  public static boolean a(X509Certificate paramX509Certificate, String paramString)
  {
    return a(paramX509Certificate, "CN", paramString);
  }
  
  public static boolean a(X509Certificate paramX509Certificate, String paramString1, String paramString2)
  {
    if ((paramX509Certificate == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return paramString2.equals(a(paramX509Certificate.getSubjectDN().getName(), paramString1));
  }
  
  public static boolean a(X509Certificate paramX509Certificate, List<X509Certificate> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    if (paramX509Certificate == null)
    {
      HMSLog.e("X509CertUtil", "rootCert is null,verify failed ");
      return false;
    }
    paramX509Certificate = paramX509Certificate.getPublicKey();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      X509Certificate localX509Certificate;
      if (localIterator.hasNext())
      {
        localX509Certificate = (X509Certificate)localIterator.next();
        if (localX509Certificate == null) {}
      }
      try
      {
        localX509Certificate.verify(paramX509Certificate);
        paramX509Certificate = localX509Certificate.getPublicKey();
      }
      catch (NoSuchProviderException paramX509Certificate)
      {
        HMSLog.e("X509CertUtil", "verify failed " + paramX509Certificate.getMessage());
        return false;
        return b(paramList);
      }
      catch (NoSuchAlgorithmException paramX509Certificate)
      {
        break label77;
      }
      catch (CertificateException paramX509Certificate)
      {
        break label77;
      }
      catch (InvalidKeyException paramX509Certificate)
      {
        break label77;
      }
      catch (SignatureException paramX509Certificate)
      {
        label77:
        break label77;
      }
    }
  }
  
  public static boolean a(X509Certificate paramX509Certificate, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      Signature localSignature = Signature.getInstance(paramX509Certificate.getSigAlgName());
      localSignature.initVerify(paramX509Certificate.getPublicKey());
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (NoSuchAlgorithmException paramX509Certificate)
    {
      HMSLog.e("X509CertUtil", "failed checkSignature : " + paramX509Certificate.getMessage());
      return false;
    }
    catch (InvalidKeyException paramX509Certificate)
    {
      break label34;
    }
    catch (SignatureException paramX509Certificate)
    {
      label34:
      break label34;
    }
  }
  
  public static List<X509Certificate> b(String paramString)
  {
    return a(c(paramString));
  }
  
  public static boolean b(X509Certificate paramX509Certificate, String paramString)
  {
    return a(paramX509Certificate, "OU", paramString);
  }
  
  public static boolean b(X509Certificate paramX509Certificate, String paramString1, String paramString2)
  {
    try
    {
      boolean bool = a(paramX509Certificate, paramString1.getBytes("UTF-8"), Base64.decode(paramString2));
      return bool;
    }
    catch (IllegalArgumentException paramX509Certificate)
    {
      HMSLog.e("X509CertUtil", " plainText exception: " + paramX509Certificate.getMessage());
      return false;
    }
    catch (UnsupportedEncodingException paramX509Certificate)
    {
      label19:
      break label19;
    }
  }
  
  public static boolean b(List<X509Certificate> paramList)
  {
    int i = 0;
    while (i < paramList.size() - 1)
    {
      if (!a((X509Certificate)paramList.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static List<String> c(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray(paramString);
      if (localJSONArray.length() <= 1) {
        return Collections.emptyList();
      }
      ArrayList localArrayList = new ArrayList(localJSONArray.length());
      int i = 0;
      for (;;)
      {
        paramString = localArrayList;
        if (i >= localJSONArray.length()) {
          break;
        }
        localArrayList.add(localJSONArray.getString(i));
        i += 1;
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      HMSLog.e("X509CertUtil", "Failed to getCertChain: " + paramString.getMessage());
      paramString = Collections.emptyList();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.utils.a.a
 * JD-Core Version:    0.7.0.1
 */