package com.tencent.liteav.basic.license;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.d;
import java.io.File;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LicenceCheck
{
  private static LicenceCheck d;
  private Context a;
  private String b = "YTFaceSDK.licence";
  private String c = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAq4teqkW/TUruU89ElNVd\nKrpSL+HCITruyb6BS9mW6M4mqmxDhazDmQgMKNfsA0d2kxFucCsXTyesFNajaisk\nrAzVJpNGO75bQFap4jYzJYskIuas6fgIS7zSmGXgRcp6i0ZBH3pkVCXcgfLfsVCO\n+sN01jFhFgOC0LY2f1pJ+3jqktAlMIxy8Q9t7XwwL5/n8/Sledp7TwuRdnl2OPl3\nycCTRkXtOIoRNB9vgd9XooTKiEdCXC7W9ryvtwCiAB82vEfHWXXgzhsPC13URuFy\n1JqbWJtTCCcfsCVxuBplhVJAQ7JsF5SMntdJDkp7rJLhprgsaim2CRjcVseNmw97\nbwIDAQAB";
  private LicenceCheck.a e = new LicenceCheck.a(this, "TXUgcSDK.licence");
  private LicenceCheck.a f = new LicenceCheck.a(this, "TXLiveSDK.licence");
  
  private int a(LicenceCheck.a parama, Context paramContext)
  {
    if (parama.g) {
      return 0;
    }
    if (this.a == null) {
      this.a = paramContext;
    }
    if (d(parama) == 0)
    {
      parama.g = true;
      return 0;
    }
    int i = c(parama);
    if (i == 0)
    {
      parama.g = true;
      return 0;
    }
    return i;
  }
  
  private int a(LicenceCheck.a parama, f paramf, Context paramContext)
  {
    int i = a(parama, paramContext);
    if (i != 0) {
      a(parama);
    }
    if (paramf != null) {
      paramf.a = parama.i;
    }
    return i;
  }
  
  private int a(LicenceCheck.a parama, String paramString1, String paramString2)
  {
    Object localObject;
    boolean bool1;
    try
    {
      localObject = a(this.c);
      bool1 = a(Base64.decode(paramString1, 0), Base64.decode(paramString2, 0), (PublicKey)localObject);
    }
    catch (Exception paramString2)
    {
      paramString2.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("verifyLicence, exception is : ");
      ((StringBuilder)localObject).append(paramString2);
      TXCLog.e("LicenceCheck", ((StringBuilder)localObject).toString());
      bool1 = false;
    }
    if (!bool1)
    {
      a(-2);
      TXCLog.e("LicenceCheck", "verifyLicence, signature not pass!");
      return -2;
    }
    paramString1 = c(parama, paramString1);
    if (TextUtils.isEmpty(paramString1))
    {
      a(-3);
      TXCLog.e("LicenceCheck", "verifyLicence, decodeValue is empty!");
      return -3;
    }
    parama.i = paramString1;
    int i;
    int k;
    try
    {
      paramString2 = new JSONObject(paramString1);
      paramString1 = paramString2.getString("pituLicense");
      paramString2 = paramString2.optJSONArray("appData");
      if (paramString2 != null) {
        break label537;
      }
      TXCLog.e("LicenceCheck", "verifyLicence, appDataArray is null!");
      a(-1);
      return -1;
    }
    catch (JSONException parama)
    {
      String str;
      StringBuilder localStringBuilder;
      parama.printStackTrace();
      paramString1 = new StringBuilder();
      paramString1.append("verifyLicence, json format error ! exception = ");
      paramString1.append(parama);
      TXCLog.e("LicenceCheck", paramString1.toString());
      a(-1);
      return -1;
    }
    int m = i;
    int j;
    int n = j;
    boolean bool2 = bool1;
    if (k < paramString2.length())
    {
      localObject = paramString2.getJSONObject(k);
      str = ((JSONObject)localObject).optString("packageName");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("verifyLicence, packageName:");
      localStringBuilder.append(str);
      TXCLog.i("LicenceCheck", localStringBuilder.toString());
      if (!str.equals(this.a.getPackageName()))
      {
        TXCLog.e("LicenceCheck", "verifyLicence, packageName not match!");
      }
      else if (d(((JSONObject)localObject).optString("endDate")))
      {
        i = 1;
      }
      else
      {
        bool1 = a(parama, (JSONObject)localObject, paramString1);
        if (bool1) {
          break label561;
        }
        i = 1;
        j = 1;
      }
    }
    for (;;)
    {
      if (m == 0)
      {
        a(-4);
        return -4;
      }
      if (n == 0)
      {
        a(-5);
        return -5;
      }
      if (!bool2)
      {
        a(-11);
        return -11;
      }
      bool1 = TextUtils.isEmpty(paramString1);
      if (!bool1) {
        try
        {
          parama = Base64.decode(paramString1, 0);
          paramString1 = this.a.getExternalFilesDir(null);
          if (paramString1 == null) {
            return -10;
          }
          paramString1 = paramString1.getAbsolutePath();
          paramString2 = new StringBuilder();
          paramString2.append(paramString1);
          paramString2.append(File.separator);
          paramString2.append(this.b);
          paramString1 = new File(paramString2.toString());
          d.a(paramString1.getAbsolutePath(), parama);
          TXCCommonUtil.setPituLicencePath(paramString1.getAbsolutePath());
        }
        catch (Exception parama)
        {
          paramString1 = new StringBuilder();
          paramString1.append("decode pitu license error:");
          paramString1.append(parama);
          TXCLog.e("LicenceCheck", paramString1.toString());
        }
      }
      TXCDRApi.txReportDAU(this.a, a.aJ);
      return 0;
      label537:
      k = 0;
      i = 0;
      j = 0;
      bool1 = false;
      break;
      k += 1;
      break;
      label561:
      m = 1;
      n = 1;
      bool2 = true;
    }
  }
  
  public static LicenceCheck a()
  {
    if (d == null) {
      d = new LicenceCheck();
    }
    return d;
  }
  
  private static String a(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    TXCDRApi.txReportDAU(this.a, a.aK, paramInt, "");
  }
  
  private void a(LicenceCheck.a parama, Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext != null)
    {
      this.a = paramContext.getApplicationContext();
      TXCCommonUtil.setAppContext(paramContext);
    }
    parama.d = paramString2;
    parama.e = paramString1;
    if ((this.a != null) && (c()))
    {
      paramContext = this.a.getExternalFilesDir(null);
      if (paramContext != null) {
        parama.c = paramContext.getAbsolutePath();
      }
      paramContext = new StringBuilder();
      paramContext.append(parama.c);
      paramContext.append(File.separator);
      paramContext.append(parama.a);
      if (!b(paramContext.toString()))
      {
        TXCLog.i("LicenceCheck", "setLicense, sdcard file not exist, to download");
        b(parama, "");
      }
      a(parama);
    }
  }
  
  private boolean a(LicenceCheck.a parama, JSONObject paramJSONObject, String paramString)
  {
    int i = paramJSONObject.optInt("feature");
    paramJSONObject = this.f;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (parama == paramJSONObject)
    {
      i = i >> 4 & 0xF;
      if (i >= 1)
      {
        parama.h = i;
        bool1 = true;
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("live parseVersionType, mLicenceVersionType = ");
      paramJSONObject.append(parama.h);
      TXCLog.i("LicenceCheck", paramJSONObject.toString());
      return bool1;
    }
    bool1 = bool3;
    if (parama == this.e)
    {
      int j = i & 0xF;
      if (j <= 1)
      {
        if (j != 1)
        {
          bool1 = bool2;
          if (i != 0) {
            break label161;
          }
        }
        if (!TextUtils.isEmpty(paramString)) {
          parama.h = 5;
        } else {
          parama.h = 3;
        }
      }
      else
      {
        parama.h = j;
      }
      bool1 = true;
      label161:
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("ugc parseVersionType, mLicenceVersionType = ");
      paramJSONObject.append(parama.h);
      TXCLog.i("LicenceCheck", paramJSONObject.toString());
    }
    return bool1;
  }
  
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
  {
    Signature localSignature = Signature.getInstance("SHA256WithRSA");
    localSignature.initVerify(paramPublicKey);
    localSignature.update(paramArrayOfByte1);
    return localSignature.verify(paramArrayOfByte2);
  }
  
  private String b(LicenceCheck.a parama)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    localObject = ((Context)localObject).getSharedPreferences("LicenceCheck.lastModified", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parama.a);
    localStringBuilder.append(".lastModified");
    return ((SharedPreferences)localObject).getString(localStringBuilder.toString(), null);
  }
  
  private void b(LicenceCheck.a parama, String paramString)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((Context)localObject).getSharedPreferences("LicenceCheck.lastModified", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parama.a);
    localStringBuilder.append(".lastModified");
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  private boolean b(String paramString)
  {
    return d.a(paramString);
  }
  
  private int c(LicenceCheck.a parama)
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
      return -10;
    }
    Object localObject = this.a.getExternalFilesDir(null);
    if (localObject == null)
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
      return -10;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(parama.a);
    localObject = localStringBuilder.toString();
    if (!b((String)localObject)) {
      return -7;
    }
    String str;
    try
    {
      localObject = d.b((String)localObject);
    }
    catch (Exception localException)
    {
      TXCLog.e("LicenceCheck", "read licence file error: ", localException);
      str = "";
    }
    if (TextUtils.isEmpty(str))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, licenceSdcardStr is empty");
      return -8;
    }
    return a(parama, str);
  }
  
  private static long c(String paramString)
  {
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd").parse(paramString).getTime();
      return l;
    }
    catch (Exception paramString)
    {
      TXCLog.e("LicenceCheck", "time str to millsecond failed.", paramString);
    }
    return -1L;
  }
  
  private String c(LicenceCheck.a parama, String paramString)
  {
    if (TextUtils.isEmpty(parama.d))
    {
      TXCLog.e("LicenceCheck", "decodeLicence, mKey is empty!!!");
      return "";
    }
    Object localObject = parama.d.getBytes();
    parama = new SecretKeySpec((byte[])localObject, "AES");
    localObject = new IvParameterSpec(nativeIvParameterSpec((byte[])localObject));
    paramString = Base64.decode(paramString, 0);
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, parama, (AlgorithmParameterSpec)localObject);
      parama = new String(localCipher.doFinal(paramString), "UTF-8");
      paramString = new StringBuilder();
      paramString.append("decodeLicence : ");
      paramString.append(parama);
      TXCLog.i("LicenceCheck", paramString.toString());
      return parama;
    }
    catch (Exception parama)
    {
      parama.printStackTrace();
    }
    return null;
  }
  
  private boolean c()
  {
    if (!Environment.getExternalStorageState().equals("mounted"))
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, sdcard not mounted yet!");
      return false;
    }
    if (this.a.getExternalFilesDir(null) == null)
    {
      TXCLog.e("LicenceCheck", "checkSdcardLicence, mContext.getExternalFilesDir is null!");
      return false;
    }
    return true;
  }
  
  private int d(LicenceCheck.a parama)
  {
    if (!e(parama)) {
      return -6;
    }
    String str = d.b(this.a, parama.a);
    if (TextUtils.isEmpty(str))
    {
      TXCLog.e("LicenceCheck", "checkAssetLicence, licenceSdcardStr is empty");
      return -8;
    }
    return a(parama, str);
  }
  
  private int d(LicenceCheck.a parama, String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      int i = ((JSONObject)localObject).optInt("appId");
      paramString = ((JSONObject)localObject).getString("encryptedLicense");
      localObject = ((JSONObject)localObject).getString("signature");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("appid:");
      localStringBuilder.append(i);
      TXCLog.i("LicenceCheck", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("encryptedLicense:");
      localStringBuilder.append(paramString);
      TXCLog.i("LicenceCheck", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("signature:");
      localStringBuilder.append((String)localObject);
      TXCLog.i("LicenceCheck", localStringBuilder.toString());
      return a(parama, paramString, (String)localObject);
    }
    catch (JSONException parama)
    {
      parama.printStackTrace();
      a(-1);
    }
    return -1;
  }
  
  private boolean d(String paramString)
  {
    long l = c(paramString);
    if (l < 0L)
    {
      TXCLog.e("LicenceCheck", "checkEndDate, end date millis < 0!");
      return true;
    }
    if (l < System.currentTimeMillis())
    {
      TXCLog.e("LicenceCheck", "checkEndDate, end date expire!");
      return true;
    }
    return false;
  }
  
  private int e(LicenceCheck.a parama, String paramString)
  {
    paramString = e(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      TXCLog.e("LicenceCheck", "verifyOldLicence, decryptStr is empty");
      return -3;
    }
    parama.i = paramString;
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.getString("packagename").equals(a(this.a)))
      {
        TXCLog.e("LicenceCheck", "packagename not match!");
        a(-4);
        return -4;
      }
      boolean bool = d(paramString.getString("enddate"));
      if (bool) {
        return -5;
      }
      parama.h = 5;
      TXCDRApi.txReportDAU(this.a, a.aJ);
      return 0;
    }
    catch (JSONException parama)
    {
      parama.printStackTrace();
      TXCLog.e("LicenceCheck", "verifyOldLicence, json format error !");
      a(-1);
    }
    return -1;
  }
  
  private String e(String paramString)
  {
    try
    {
      localObject = Base64.decode(nativeRSAKey(), 0);
      paramString = new String(h.b(Base64.decode(paramString, 0), (byte[])localObject));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decryptLicenceStr, exception is : ");
      ((StringBuilder)localObject).append(paramString);
      TXCLog.e("LicenceCheck", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private boolean e(LicenceCheck.a parama)
  {
    return d.a(this.a, parama.a);
  }
  
  private void f(LicenceCheck.a parama)
  {
    Object localObject1 = this.a.getExternalFilesDir(null);
    if (localObject1 == null)
    {
      TXCLog.i("LicenceCheck", "saveTempLocal sdcardDir is null");
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(parama.a);
    localObject1 = new File(((StringBuilder)localObject2).toString());
    boolean bool;
    if (((File)localObject1).exists())
    {
      bool = ((File)localObject1).delete();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("delete dst file:");
      ((StringBuilder)localObject2).append(bool);
      TXCLog.i("LicenceCheck", ((StringBuilder)localObject2).toString());
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(parama.c);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(parama.b);
    localObject2 = new File(((StringBuilder)localObject2).toString());
    if (((File)localObject2).exists())
    {
      bool = ((File)localObject2).renameTo((File)localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("rename file:");
      ((StringBuilder)localObject1).append(bool);
      TXCLog.i("LicenceCheck", ((StringBuilder)localObject1).toString());
    }
    parama.g = true;
  }
  
  private int g(LicenceCheck.a parama)
  {
    return parama.h;
  }
  
  private String h(LicenceCheck.a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(parama.c);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(parama.b);
    return d.b(new File(localStringBuilder.toString()).getAbsolutePath());
  }
  
  private native byte[] nativeIvParameterSpec(byte[] paramArrayOfByte);
  
  private native String nativeRSAKey();
  
  public int a(LicenceCheck.a parama, String paramString)
  {
    try
    {
      new JSONObject(paramString);
      int i = d(parama, paramString);
      return i;
    }
    catch (JSONException localJSONException)
    {
      label18:
      break label18;
    }
    if (parama == this.f) {
      return -1;
    }
    return e(parama, paramString);
  }
  
  public int a(f paramf, Context paramContext)
  {
    return a(this.f, paramf, paramContext);
  }
  
  public PublicKey a(String paramString)
  {
    paramString = new X509EncodedKeySpec(Base64.decode(paramString, 0));
    return KeyFactory.getInstance("RSA").generatePublic(paramString);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2)
  {
    a(this.f, paramContext, paramString1, paramString2);
  }
  
  public void a(LicenceCheck.a parama)
  {
    if (TextUtils.isEmpty(parama.e))
    {
      TXCLog.e("LicenceCheck", "downloadLicense, mUrl is empty, ignore!");
      return;
    }
    if (parama.f)
    {
      TXCLog.i("LicenceCheck", "downloadLicense, in downloading, ignore");
      return;
    }
    LicenceCheck.1 local1 = new LicenceCheck.1(this, parama);
    Object localObject = this.a;
    if (localObject == null)
    {
      TXCLog.e("LicenceCheck", "context is NULL !!! Please set context in method:setLicense(Context context, String url, String key)");
      return;
    }
    localObject = ((Context)localObject).getExternalFilesDir(null);
    if (localObject == null)
    {
      TXCLog.e("LicenceCheck", "Please check permission WRITE_EXTERNAL_STORAGE permission has been set !!!");
      return;
    }
    String str = b(parama);
    parama.c = ((File)localObject).getAbsolutePath();
    new Thread(new c(this.a, parama.e, parama.c, parama.b, local1, false, str)).start();
    parama.f = true;
  }
  
  public int b()
  {
    return g(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.license.LicenceCheck
 * JD-Core Version:    0.7.0.1
 */