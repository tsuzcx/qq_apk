import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class axgr
{
  axgs jdField_a_of_type_Axgs = null;
  DownloadInfo jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = null;
  boolean jdField_a_of_type_Boolean = false;
  
  axgr()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, "GestureMgrAppDownload in QQAppInterface");
    }
    this.jdField_a_of_type_Axgs = new axgs();
  }
  
  static void a(int paramInt)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Intent localIntent = new Intent("tencent.video.gesturemgr.notify");
    localIntent.setPackage(localBaseApplicationImpl.getPackageName());
    localIntent.putExtra("Event_Progress", paramInt);
    localBaseApplicationImpl.sendBroadcast(localIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, "onEnterBackground");
    }
    a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    axgp.a().a.b(paramQQAppInterface, paramString, paramConfigInfo);
  }
  
  public static void a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    SharedPreferences localSharedPreferences = DownloadInfo.getSP();
    String str;
    if ((paramInt & 0x1) == 1)
    {
      str = paramDownloadInfo.MD5_zip_so;
      localSharedPreferences.edit().putString("so_zip_md5", str).commit();
      a(paramDownloadInfo.so_name);
    }
    if ((paramInt & 0x2) == 2)
    {
      str = paramDownloadInfo.MD5_zip_model;
      localSharedPreferences.edit().putString("model_zip_md5", str).commit();
    }
    if ((paramInt & 0x3) == 3)
    {
      paramDownloadInfo = paramDownloadInfo.MD5_zip_gamemodel;
      localSharedPreferences.edit().putString("gamemodel_zip_md5", paramDownloadInfo).commit();
    }
  }
  
  public static void a(String paramString)
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("so_sp", 4).edit().putString("key_so_version_" + paramString, AppSetting.g()).commit();
  }
  
  public static boolean a()
  {
    return axgp.a().a.b();
  }
  
  void b(QQAppInterface paramQQAppInterface, String paramString, ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = ((DownloadInfo)paramConfigInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
    }
    QLog.w("QavGesture", 1, "handle_QAG_Gesture_Config, configInfo[" + paramConfigInfo + "], mDownloadInfo[" + this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo + "]");
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo != null) {
        a();
      }
    }
  }
  
  boolean b()
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    boolean bool2;
    if ((localObject instanceof QQAppInterface))
    {
      if (((QQAppInterface)localObject).getManager(21) == null)
      {
        QLog.d("QavGesture", 1, "innerDownload, getNetEngine 为空");
        bool2 = false;
        return bool2;
      }
    }
    else
    {
      QLog.d("QavGesture", 1, "appRuntime 不是 QQAppInterface");
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo;
    if (localObject == null)
    {
      this.jdField_a_of_type_Boolean = true;
      return false;
    }
    if (11 == axgw.a((DownloadInfo)localObject)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      return this.jdField_a_of_type_Axgs.a((DownloadInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axgr
 * JD-Core Version:    0.7.0.1
 */