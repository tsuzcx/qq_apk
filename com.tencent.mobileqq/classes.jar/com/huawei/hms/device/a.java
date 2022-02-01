package com.huawei.hms.device;

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
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString1.toUpperCase(Locale.getDefault());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append("=");
    int i = str.indexOf(localStringBuilder.toString());
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
    //   1: ifnull +247 -> 248
    //   4: aload_1
    //   5: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +6 -> 14
    //   11: goto +237 -> 248
    //   14: ldc 77
    //   16: invokestatic 83	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   19: astore_3
    //   20: aload_0
    //   21: invokevirtual 89	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   24: ldc 91
    //   26: invokevirtual 97	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   29: astore_0
    //   30: aload_0
    //   31: astore_2
    //   32: aload_3
    //   33: aload_0
    //   34: ldc 99
    //   36: invokevirtual 103	java/lang/String:toCharArray	()[C
    //   39: invokevirtual 107	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   42: aload_0
    //   43: astore_2
    //   44: aload_3
    //   45: aload_1
    //   46: invokevirtual 111	java/security/KeyStore:containsAlias	(Ljava/lang/String;)Z
    //   49: ifne +47 -> 96
    //   52: aload_0
    //   53: astore_2
    //   54: new 20	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   61: astore_3
    //   62: aload_0
    //   63: astore_2
    //   64: aload_3
    //   65: ldc 113
    //   67: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_0
    //   72: astore_2
    //   73: aload_3
    //   74: aload_1
    //   75: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_0
    //   80: astore_2
    //   81: ldc 115
    //   83: aload_3
    //   84: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 121	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: invokestatic 127	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_0
    //   97: astore_2
    //   98: aload_3
    //   99: aload_1
    //   100: invokevirtual 131	java/security/KeyStore:getCertificate	(Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   103: astore_1
    //   104: aload_0
    //   105: astore_2
    //   106: aload_1
    //   107: instanceof 133
    //   110: ifeq +22 -> 132
    //   113: aload_0
    //   114: astore_2
    //   115: aload_1
    //   116: checkcast 133	java/security/cert/X509Certificate
    //   119: astore_1
    //   120: aload_0
    //   121: astore_2
    //   122: aload_1
    //   123: invokevirtual 136	java/security/cert/X509Certificate:checkValidity	()V
    //   126: aload_0
    //   127: invokestatic 127	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   130: aload_1
    //   131: areturn
    //   132: aload_0
    //   133: invokestatic 127	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   136: aconst_null
    //   137: areturn
    //   138: astore_2
    //   139: aload_0
    //   140: astore_1
    //   141: aload_2
    //   142: astore_0
    //   143: goto +51 -> 194
    //   146: astore_2
    //   147: aload_0
    //   148: astore_1
    //   149: aload_2
    //   150: astore_0
    //   151: goto +43 -> 194
    //   154: astore_2
    //   155: aload_0
    //   156: astore_1
    //   157: aload_2
    //   158: astore_0
    //   159: goto +35 -> 194
    //   162: astore_2
    //   163: aload_0
    //   164: astore_1
    //   165: aload_2
    //   166: astore_0
    //   167: goto +27 -> 194
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_2
    //   173: goto +69 -> 242
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_1
    //   179: goto +15 -> 194
    //   182: astore_0
    //   183: goto -6 -> 177
    //   186: astore_0
    //   187: goto -10 -> 177
    //   190: astore_0
    //   191: goto -14 -> 177
    //   194: aload_1
    //   195: astore_2
    //   196: new 20	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   203: astore_3
    //   204: aload_1
    //   205: astore_2
    //   206: aload_3
    //   207: ldc 138
    //   209: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_1
    //   214: astore_2
    //   215: aload_3
    //   216: aload_0
    //   217: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   220: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: astore_2
    //   226: ldc 115
    //   228: aload_3
    //   229: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 121	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload_1
    //   236: invokestatic 127	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_0
    //   242: aload_2
    //   243: invokestatic 127	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   246: aload_0
    //   247: athrow
    //   248: ldc 115
    //   250: ldc 145
    //   252: invokestatic 121	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: aconst_null
    //   256: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramContext	Context
    //   0	257	1	paramString	String
    //   31	91	2	localContext	Context
    //   138	4	2	localNoSuchAlgorithmException	NoSuchAlgorithmException
    //   146	4	2	localCertificateException	CertificateException
    //   154	4	2	localIOException	java.io.IOException
    //   162	4	2	localKeyStoreException	java.security.KeyStoreException
    //   172	71	2	str	String
    //   19	210	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	42	138	java/security/NoSuchAlgorithmException
    //   44	52	138	java/security/NoSuchAlgorithmException
    //   54	62	138	java/security/NoSuchAlgorithmException
    //   64	71	138	java/security/NoSuchAlgorithmException
    //   73	79	138	java/security/NoSuchAlgorithmException
    //   81	90	138	java/security/NoSuchAlgorithmException
    //   98	104	138	java/security/NoSuchAlgorithmException
    //   106	113	138	java/security/NoSuchAlgorithmException
    //   115	120	138	java/security/NoSuchAlgorithmException
    //   122	126	138	java/security/NoSuchAlgorithmException
    //   32	42	146	java/security/cert/CertificateException
    //   44	52	146	java/security/cert/CertificateException
    //   54	62	146	java/security/cert/CertificateException
    //   64	71	146	java/security/cert/CertificateException
    //   73	79	146	java/security/cert/CertificateException
    //   81	90	146	java/security/cert/CertificateException
    //   98	104	146	java/security/cert/CertificateException
    //   106	113	146	java/security/cert/CertificateException
    //   115	120	146	java/security/cert/CertificateException
    //   122	126	146	java/security/cert/CertificateException
    //   32	42	154	java/io/IOException
    //   44	52	154	java/io/IOException
    //   54	62	154	java/io/IOException
    //   64	71	154	java/io/IOException
    //   73	79	154	java/io/IOException
    //   81	90	154	java/io/IOException
    //   98	104	154	java/io/IOException
    //   106	113	154	java/io/IOException
    //   115	120	154	java/io/IOException
    //   122	126	154	java/io/IOException
    //   32	42	162	java/security/KeyStoreException
    //   44	52	162	java/security/KeyStoreException
    //   54	62	162	java/security/KeyStoreException
    //   64	71	162	java/security/KeyStoreException
    //   73	79	162	java/security/KeyStoreException
    //   81	90	162	java/security/KeyStoreException
    //   98	104	162	java/security/KeyStoreException
    //   106	113	162	java/security/KeyStoreException
    //   115	120	162	java/security/KeyStoreException
    //   122	126	162	java/security/KeyStoreException
    //   14	30	170	finally
    //   14	30	176	java/security/NoSuchAlgorithmException
    //   14	30	182	java/security/cert/CertificateException
    //   14	30	186	java/io/IOException
    //   14	30	190	java/security/KeyStoreException
    //   32	42	241	finally
    //   44	52	241	finally
    //   54	62	241	finally
    //   64	71	241	finally
    //   73	79	241	finally
    //   81	90	241	finally
    //   98	104	241	finally
    //   106	113	241	finally
    //   115	120	241	finally
    //   122	126	241	finally
    //   196	204	241	finally
    //   206	213	241	finally
    //   215	224	241	finally
    //   226	235	241	finally
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCert failed : ");
      localStringBuilder.append(paramString.getMessage());
      HMSLog.e("X509CertUtil", localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to get cert: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      HMSLog.e("X509CertUtil", localStringBuilder.toString());
    }
    return null;
  }
  
  public static boolean a(X509Certificate paramX509Certificate)
  {
    if (paramX509Certificate == null) {
      return false;
    }
    if (paramX509Certificate.getBasicConstraints() == -1) {
      return false;
    }
    paramX509Certificate = paramX509Certificate.getKeyUsage();
    if (5 < paramX509Certificate.length) {
      return paramX509Certificate[5];
    }
    return false;
  }
  
  public static boolean a(X509Certificate paramX509Certificate, String paramString)
  {
    return b(paramX509Certificate, "CN", paramString);
  }
  
  public static boolean a(X509Certificate paramX509Certificate, String paramString1, String paramString2)
  {
    try
    {
      boolean bool = a(paramX509Certificate, paramString1.getBytes("UTF-8"), Base64.decode(paramString2));
      return bool;
    }
    catch (IllegalArgumentException paramX509Certificate) {}catch (UnsupportedEncodingException paramX509Certificate) {}
    paramString1 = new StringBuilder();
    paramString1.append(" plainText exception: ");
    paramString1.append(paramX509Certificate.getMessage());
    HMSLog.e("X509CertUtil", paramString1.toString());
    return false;
  }
  
  public static boolean a(X509Certificate paramX509Certificate, List<X509Certificate> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
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
        if (!localIterator.hasNext()) {
          break label132;
        }
        X509Certificate localX509Certificate = (X509Certificate)localIterator.next();
        if (localX509Certificate == null) {
          break label130;
        }
        try
        {
          localX509Certificate.checkValidity();
          localX509Certificate.verify(paramX509Certificate);
          paramX509Certificate = localX509Certificate.getPublicKey();
        }
        catch (SignatureException paramX509Certificate) {}catch (NoSuchProviderException paramX509Certificate) {}catch (InvalidKeyException paramX509Certificate) {}catch (NoSuchAlgorithmException paramX509Certificate) {}catch (CertificateException paramX509Certificate) {}
      }
      paramList = new StringBuilder();
      paramList.append("verify failed ");
      paramList.append(paramX509Certificate.getMessage());
      HMSLog.e("X509CertUtil", paramList.toString());
      label130:
      return false;
      label132:
      return a(paramList);
    }
    return false;
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
    catch (InvalidKeyException paramX509Certificate) {}catch (SignatureException paramX509Certificate) {}catch (NoSuchAlgorithmException paramX509Certificate) {}
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append("failed checkSignature : ");
    paramArrayOfByte1.append(paramX509Certificate.getMessage());
    HMSLog.e("X509CertUtil", paramArrayOfByte1.toString());
    return false;
  }
  
  public static boolean a(List<X509Certificate> paramList)
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
  
  public static List<X509Certificate> b(String paramString)
  {
    return b(c(paramString));
  }
  
  public static List<X509Certificate> b(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((String)paramList.next()));
    }
    return localArrayList;
  }
  
  public static boolean b(X509Certificate paramX509Certificate, String paramString)
  {
    return b(paramX509Certificate, "OU", paramString);
  }
  
  public static boolean b(X509Certificate paramX509Certificate, String paramString1, String paramString2)
  {
    if ((paramX509Certificate != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return paramString2.equals(a(paramX509Certificate.getSubjectDN().getName(), paramString1));
    }
    return false;
  }
  
  public static List<String> c(String paramString)
  {
    try
    {
      paramString = new JSONArray(paramString);
      if (paramString.length() <= 1) {
        return Collections.emptyList();
      }
      localObject = new ArrayList(paramString.length());
      int i = 0;
      while (i < paramString.length())
      {
        ((List)localObject).add(paramString.getString(i));
        i += 1;
      }
      return localObject;
    }
    catch (JSONException paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to getCertChain: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      HMSLog.e("X509CertUtil", ((StringBuilder)localObject).toString());
    }
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.device.a
 * JD-Core Version:    0.7.0.1
 */