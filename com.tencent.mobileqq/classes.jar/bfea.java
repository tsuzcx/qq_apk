import android.os.Bundle;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class bfea
{
  public static String a(Bundle paramBundle)
  {
    Object localObject6 = paramBundle.getString("status_os");
    Object localObject5 = paramBundle.getString("status_machine");
    Object localObject4 = paramBundle.getString("status_version");
    Object localObject3 = paramBundle.getString("sdkv");
    Object localObject2 = paramBundle.getString("client_id");
    Object localObject1 = paramBundle.getString("need_pay");
    String str = paramBundle.getString("pf");
    QLog.d("OpenSdkDESUtils", 1, new Object[] { "os=", localObject6, ", machine=", localObject5, ", version=", localObject4, ", sdkv=", localObject3, ", appId=", localObject2, ", needPay=", localObject1, ", pf=", str });
    StringBuilder localStringBuilder = new StringBuilder();
    paramBundle = (Bundle)localObject6;
    if (localObject6 == null) {
      paramBundle = "";
    }
    localObject6 = localStringBuilder.append(paramBundle);
    if (localObject5 == null)
    {
      paramBundle = "";
      localObject5 = ((StringBuilder)localObject6).append(paramBundle);
      if (localObject4 != null) {
        break label264;
      }
      paramBundle = "";
      label191:
      localObject4 = ((StringBuilder)localObject5).append(paramBundle);
      if (localObject3 != null) {
        break label270;
      }
      paramBundle = "";
      label207:
      localObject3 = ((StringBuilder)localObject4).append(paramBundle);
      if (localObject2 != null) {
        break label276;
      }
      paramBundle = "";
      label222:
      localObject2 = ((StringBuilder)localObject3).append(paramBundle);
      if (localObject1 != null) {
        break label281;
      }
      paramBundle = "";
      label236:
      localObject1 = ((StringBuilder)localObject2).append(paramBundle);
      if (str != null) {
        break label286;
      }
    }
    label264:
    label270:
    label276:
    label281:
    label286:
    for (paramBundle = "";; paramBundle = str)
    {
      return paramBundle;
      paramBundle = (Bundle)localObject5;
      break;
      paramBundle = (Bundle)localObject4;
      break label191;
      paramBundle = (Bundle)localObject3;
      break label207;
      paramBundle = (Bundle)localObject2;
      break label222;
      paramBundle = (Bundle)localObject1;
      break label236;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      QLog.e("OpenSdkDESUtils", 1, "getDecryptPkgName decryptStr==null !!!!!!");
      return "";
    }
    try
    {
      paramString2 = a(paramString2);
      if (paramString2 == null)
      {
        QLog.e("OpenSdkDESUtils", 1, "getDecryptPkgName shaBytes==null !!!!!!");
        return "";
      }
      byte[] arrayOfByte = new byte[8];
      System.arraycopy(paramString2, 5, arrayOfByte, 0, 8);
      Object localObject = new byte[16];
      System.arraycopy(paramString2, 8, localObject, 0, 16);
      localObject = bdcv.a((byte[])localObject);
      paramString2 = (String)localObject;
      if (localObject == null) {
        paramString2 = "";
      }
      paramString1 = a(paramString1, paramString2, arrayOfByte);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("OpenSdkDESUtils", 1, "getDecryptPkgName", paramString1);
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    try
    {
      paramString1 = Base64.decode(paramString1, 0);
      paramArrayOfByte = new IvParameterSpec(paramArrayOfByte);
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/GCM/NoPadding");
      localCipher.init(2, paramString2, paramArrayOfByte);
      paramString1 = new String(localCipher.doFinal(paramString1));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      QLog.e("OpenSdkDESUtils", 1, "decryptAES", paramString1);
    }
    return null;
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes());
      paramString = localMessageDigest.digest();
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("OpenSdkDESUtils", 1, "encryptSha", paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfea
 * JD-Core Version:    0.7.0.1
 */