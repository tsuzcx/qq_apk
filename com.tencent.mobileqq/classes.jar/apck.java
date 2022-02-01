import android.content.Intent;
import android.content.ServiceConnection;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ArConfigService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class apck
{
  ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = null;
  apic jdField_a_of_type_Apic = null;
  private apir jdField_a_of_type_Apir;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  void a()
  {
    try
    {
      if (this.jdField_a_of_type_Apic != null)
      {
        if (this.jdField_a_of_type_Apir != null)
        {
          this.jdField_a_of_type_Apic.b(this.jdField_a_of_type_Apir);
          this.jdField_a_of_type_Apir = null;
        }
        if (this.jdField_a_of_type_AndroidContentServiceConnection != null)
        {
          this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
          this.jdField_a_of_type_AndroidContentServiceConnection = null;
        }
        this.jdField_a_of_type_Apic = null;
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.w(apcx.a, 1, "DownloadDependRes.clean, Exception", localException);
    }
  }
  
  void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    if (!ArConfigService.e(BaseApplicationImpl.getApplication().getRuntime()))
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(apcx.a, 1, "tryDownload, so未准备");
      }
      b();
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Apic != null) {}
    do
    {
      try
      {
        this.jdField_a_of_type_Apic.c();
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d(apcx.a, 2, "downloadArSo Exception", localException);
        return;
      }
      this.jdField_a_of_type_Apir = new apcl(this);
      this.jdField_a_of_type_AndroidContentServiceConnection = new apcm(this);
    } while (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null);
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ArConfigService.class);
    boolean bool = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    QLog.w(apcx.a, 1, "bindServer, ret[" + bool + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apck
 * JD-Core Version:    0.7.0.1
 */