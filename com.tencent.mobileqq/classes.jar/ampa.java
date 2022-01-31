import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ampa
{
  amur jdField_a_of_type_Amur = null;
  private amvg jdField_a_of_type_Amvg;
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = null;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_Amur != null)
      {
        if (this.jdField_a_of_type_Amvg != null)
        {
          this.jdField_a_of_type_Amur.b(this.jdField_a_of_type_Amvg);
          this.jdField_a_of_type_Amvg = null;
        }
        if (this.jdField_a_of_type_AndroidContentServiceConnection != null)
        {
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          this.jdField_a_of_type_AndroidContentServiceConnection = null;
        }
        this.jdField_a_of_type_Amur = null;
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.w(ampn.a, 1, "DownloadDependRes.clean, Exception", localException);
    }
  }
  
  void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if (!ArConfigService.e(BaseApplicationImpl.getApplication().getRuntime()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(ampn.a, 1, "tryDownload, so未准备");
      }
      b();
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Amur != null) {
      try
      {
        this.jdField_a_of_type_Amur.c();
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(ampn.a, 2, "downloadArSo Exception", localException);
        return;
      }
    }
    this.jdField_a_of_type_Amvg = new ampb(this);
    this.jdField_a_of_type_AndroidContentServiceConnection = new ampc(this);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ArConfigService.class);
    boolean bool = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    QLog.w(ampn.a, 1, "bindServer, ret[" + bool + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ampa
 * JD-Core Version:    0.7.0.1
 */