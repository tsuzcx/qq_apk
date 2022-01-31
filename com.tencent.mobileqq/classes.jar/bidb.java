import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.AppInfo;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadFile.UploadBatch;
import com.tencent.weiyun.transmission.upload.UploadManager;
import cooperation.weiyun.TransmissionHelper.5;
import cooperation.weiyun.upload.WyUploadJob;
import mqq.app.AppRuntime;

public final class bidb
{
  private static String jdField_a_of_type_JavaLangString;
  private static volatile boolean jdField_a_of_type_Boolean;
  
  public static biei a(String paramString1, String paramString2, String paramString3, long paramLong, int paramInt, String paramString4, String paramString5)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString4))) {
      return null;
    }
    if (TextUtils.isEmpty(paramString3)) {
      paramString3 = "0";
    }
    for (;;)
    {
      return biei.a(10, paramString1, paramString2, paramString3, paramLong, paramInt, BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramString4, paramString5);
    }
  }
  
  public static UploadFile a(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramUploadBatch == null) || (paramInt < 0)) {
      return null;
    }
    String str = Build.MODEL;
    paramString = UploadFile.createUploadFile(1, BaseApplicationImpl.getApplication().getRuntime().getAccount(), str, str, str, paramString, false, paramUploadBatch, paramInt);
    paramString.autoBackupFlag = false;
    return paramString;
  }
  
  private static String a()
  {
    if (jdField_a_of_type_JavaLangString == null) {
      jdField_a_of_type_JavaLangString = "V1_AND_WY_VersionName_" + ayuk.a() + "_ChannelId_" + "B";
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static void a(int paramInt)
  {
    new Thread(new TransmissionHelper.5(paramInt)).start();
  }
  
  public static void a(Application paramApplication, boolean paramBoolean)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    WeiyunTransmissionGlobal.AppInfo localAppInfo = new WeiyunTransmissionGlobal.AppInfo(a(), 1000269, "mobileqq", ayuk.a(), 0, "unknown");
    WeiyunTransmissionGlobal localWeiyunTransmissionGlobal = WeiyunTransmissionGlobal.getInstance();
    if (paramBoolean) {}
    for (String str = "weiyun_";; str = "qq_")
    {
      localWeiyunTransmissionGlobal.initTransmission(localAppInfo, paramApplication, new bidh(str), bigg.a());
      WeiyunTransmissionGlobal.getInstance().getUploadManager().setSpareUploader(new WyUploadJob());
      WeiyunTransmissionStatus.getInstance().setTranOnlyWifi(0, true, BaseApplicationImpl.getApplication().getRuntime().getAccount());
      WeiyunTransmissionStatus.getInstance().setLoginStatus(0, BaseApplicationImpl.getApplication().getRuntime().getAccount());
      AppNetConnInfo.registerNetChangeReceiver(null, new bidc());
      biep.a().a(new bidd(), paramApplication);
      biep.a().a(new bidf());
      WeiyunTransmissionGlobal.getInstance().getUploadManager().addGlobalObserver(new bidg());
      jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public static void a(boolean paramBoolean, long paramLong)
  {
    WeiyunTransmissionStatus localWeiyunTransmissionStatus = WeiyunTransmissionStatus.getInstance();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localWeiyunTransmissionStatus.setLoginStatus(i, Long.toString(paramLong));
      bidp.c();
      return;
    }
  }
  
  public static UploadFile b(String paramString, UploadFile.UploadBatch paramUploadBatch, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramUploadBatch == null) || (paramInt < 0)) {
      return null;
    }
    String[] arrayOfString = bidp.a();
    paramString = UploadFile.createUploadFile(0, BaseApplicationImpl.getApplication().getRuntime().getAccount(), "QQ", arrayOfString[1], arrayOfString[0], paramString, false, paramUploadBatch, paramInt);
    paramString.autoBackupFlag = false;
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidb
 * JD-Core Version:    0.7.0.1
 */