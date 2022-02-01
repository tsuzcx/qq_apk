package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;

public class PackageManagerHelper
{
  public final PackageManager a;
  
  public PackageManagerHelper(Context paramContext)
  {
    this.a = paramContext.getPackageManager();
  }
  
  public final byte[] a(String paramString)
  {
    try
    {
      paramString = this.a.getPackageInfo(paramString, 64);
      if ((paramString != null) && (paramString.signatures != null) && (paramString.signatures.length > 0))
      {
        paramString = paramString.signatures[0].toByteArray();
        return paramString;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to get application signature certificate fingerprint.");
      localStringBuilder.append(paramString.getMessage());
      HMSLog.e("PackageManagerHelper", localStringBuilder.toString());
      HMSLog.e("PackageManagerHelper", "Failed to get application signature certificate fingerprint.");
    }
    return new byte[0];
  }
  
  public String getPackageSignature(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && (paramString.length != 0)) {
      return HEX.encodeHexString(SHA256.digest(paramString), true);
    }
    return null;
  }
  
  public PackageManagerHelper.PackageStates getPackageStates(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return PackageManagerHelper.PackageStates.NOT_INSTALLED;
    }
    try
    {
      if (this.a.getApplicationInfo(paramString, 0).enabled) {
        return PackageManagerHelper.PackageStates.ENABLED;
      }
      paramString = PackageManagerHelper.PackageStates.DISABLED;
      return paramString;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      label36:
      break label36;
    }
    return PackageManagerHelper.PackageStates.NOT_INSTALLED;
  }
  
  public int getPackageVersionCode(String paramString)
  {
    try
    {
      paramString = this.a.getPackageInfo(paramString, 16);
      if (paramString != null)
      {
        int i = paramString.versionCode;
        return i;
      }
      return 0;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return 0;
  }
  
  public String getPackageVersionName(String paramString)
  {
    try
    {
      paramString = this.a.getPackageInfo(paramString, 16);
      if ((paramString != null) && (paramString.versionName != null))
      {
        paramString = paramString.versionName;
        return paramString;
      }
      return "";
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return "";
  }
  
  public boolean hasProvider(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.a.getPackageInfo(paramString1, 8);
      if ((paramString1 != null) && (paramString1.providers != null))
      {
        paramString1 = paramString1.providers;
        int j = paramString1.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = paramString2.equals(paramString1[i].authority);
          if (bool) {
            return true;
          }
          i += 1;
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramString1) {}
    return false;
  }
  
  /* Error */
  public boolean verifyPackageArchive(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/huawei/hms/utils/PackageManagerHelper:a	Landroid/content/pm/PackageManager;
    //   4: aload_1
    //   5: bipush 64
    //   7: invokevirtual 150	android/content/pm/PackageManager:getPackageArchiveInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   10: astore 6
    //   12: aload 6
    //   14: ifnull +161 -> 175
    //   17: aload 6
    //   19: getfield 35	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   22: arraylength
    //   23: ifle +152 -> 175
    //   26: aload_2
    //   27: aload 6
    //   29: getfield 153	android/content/pm/PackageInfo:packageName	Ljava/lang/String;
    //   32: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   35: ifne +5 -> 40
    //   38: iconst_0
    //   39: ireturn
    //   40: aconst_null
    //   41: astore_2
    //   42: aconst_null
    //   43: astore 5
    //   45: aconst_null
    //   46: astore_1
    //   47: aload 6
    //   49: getfield 35	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   52: iconst_0
    //   53: aaload
    //   54: invokevirtual 41	android/content/pm/Signature:toByteArray	()[B
    //   57: invokestatic 159	com/huawei/hms/utils/IOUtils:toInputStream	([B)Ljava/io/InputStream;
    //   60: astore 6
    //   62: aload 6
    //   64: astore_1
    //   65: aload 6
    //   67: astore_2
    //   68: aload 6
    //   70: astore 5
    //   72: aload_3
    //   73: ldc 161
    //   75: invokestatic 167	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   78: aload 6
    //   80: invokevirtual 171	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   83: invokevirtual 176	java/security/cert/Certificate:getEncoded	()[B
    //   86: invokestatic 75	com/huawei/hms/utils/SHA256:digest	([B)[B
    //   89: iconst_1
    //   90: invokestatic 81	com/huawei/hms/utils/HEX:encodeHexString	([BZ)Ljava/lang/String;
    //   93: invokevirtual 180	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   96: istore 4
    //   98: aload 6
    //   100: invokestatic 184	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   103: iload 4
    //   105: ireturn
    //   106: astore_2
    //   107: goto +62 -> 169
    //   110: astore_3
    //   111: goto +7 -> 118
    //   114: astore_3
    //   115: aload 5
    //   117: astore_2
    //   118: aload_2
    //   119: astore_1
    //   120: new 43	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   127: astore 5
    //   129: aload_2
    //   130: astore_1
    //   131: aload 5
    //   133: ldc 46
    //   135: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_2
    //   140: astore_1
    //   141: aload 5
    //   143: aload_3
    //   144: invokevirtual 187	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_2
    //   152: astore_1
    //   153: ldc 56
    //   155: aload 5
    //   157: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 65	com/huawei/hms/support/log/HMSLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_2
    //   164: invokestatic 184	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   167: iconst_0
    //   168: ireturn
    //   169: aload_1
    //   170: invokestatic 184	com/huawei/hms/utils/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   173: aload_2
    //   174: athrow
    //   175: iconst_0
    //   176: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	PackageManagerHelper
    //   0	177	1	paramString1	String
    //   0	177	2	paramString2	String
    //   0	177	3	paramString3	String
    //   96	8	4	bool	boolean
    //   43	113	5	localObject1	Object
    //   10	89	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   47	62	106	finally
    //   72	98	106	finally
    //   120	129	106	finally
    //   131	139	106	finally
    //   141	151	106	finally
    //   153	163	106	finally
    //   47	62	110	java/security/cert/CertificateException
    //   72	98	110	java/security/cert/CertificateException
    //   47	62	114	java/io/IOException
    //   72	98	114	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.PackageManagerHelper
 * JD-Core Version:    0.7.0.1
 */