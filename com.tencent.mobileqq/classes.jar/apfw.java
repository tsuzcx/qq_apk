import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class apfw
{
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = null;
  apln jdField_a_of_type_Apln = null;
  private apmc jdField_a_of_type_Apmc;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_Apln != null)
      {
        if (this.jdField_a_of_type_Apmc != null)
        {
          this.jdField_a_of_type_Apln.b(this.jdField_a_of_type_Apmc);
          this.jdField_a_of_type_Apmc = null;
        }
        if (this.jdField_a_of_type_AndroidContentServiceConnection != null)
        {
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          this.jdField_a_of_type_AndroidContentServiceConnection = null;
        }
        this.jdField_a_of_type_Apln = null;
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.w(apgj.a, 1, "DownloadDependRes.clean, Exception", localException);
    }
  }
  
  void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if (!ArConfigService.e(BaseApplicationImpl.getApplication().getRuntime()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(apgj.a, 1, "tryDownload, so未准备");
      }
      b();
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Apln != null) {}
    do
    {
      try
      {
        this.jdField_a_of_type_Apln.c();
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(apgj.a, 2, "downloadArSo Exception", localException);
        return;
      }
      this.jdField_a_of_type_Apmc = new apfx(this);
      this.jdField_a_of_type_AndroidContentServiceConnection = new apfy(this);
    } while (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ArConfigService.class);
    boolean bool = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    QLog.w(apgj.a, 1, "bindServer, ret[" + bool + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apfw
 * JD-Core Version:    0.7.0.1
 */