import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GVideoProxyService;

public class bgkq
{
  bgkr jdField_a_of_type_Bgkr = null;
  bgks jdField_a_of_type_Bgks = new bgks(this);
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  loo jdField_a_of_type_Loo = null;
  
  public bgkq(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Loo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return 0;
      try
      {
        paramInt = this.jdField_a_of_type_Loo.a(paramLong, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", localRemoteException);
    return 0;
  }
  
  public void a()
  {
    bgkp.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Bgks);
    this.jdField_a_of_type_Loo = null;
    this.jdField_a_of_type_Bgkr = null;
  }
  
  public void a(bgkr parambgkr)
  {
    this.jdField_a_of_type_Bgkr = parambgkr;
    if (this.jdField_a_of_type_Loo == null) {
      bgkp.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, GVideoProxyService.class, this.jdField_a_of_type_Bgks, "com.gvideo.com.tencent.av.service.GVServiceForQQ");
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Loo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Loo.a(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Loo != null) {}
    try
    {
      this.jdField_a_of_type_Loo.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgkq
 * JD-Core Version:    0.7.0.1
 */