import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GVideoProxyService;

public class bilo
{
  bilp jdField_a_of_type_Bilp = null;
  bilq jdField_a_of_type_Bilq = new bilq(this);
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  lqr jdField_a_of_type_Lqr = null;
  
  public bilo(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Lqr == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return 0;
      try
      {
        paramInt = this.jdField_a_of_type_Lqr.a(paramLong, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", localRemoteException);
    return 0;
  }
  
  public void a()
  {
    biln.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Bilq);
    this.jdField_a_of_type_Lqr = null;
    this.jdField_a_of_type_Bilp = null;
  }
  
  public void a(bilp parambilp)
  {
    this.jdField_a_of_type_Bilp = parambilp;
    if (this.jdField_a_of_type_Lqr == null) {
      biln.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, GVideoProxyService.class, this.jdField_a_of_type_Bilq, "com.gvideo.com.tencent.av.service.GVServiceForQQ");
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Lqr == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Lqr.a(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Lqr != null) {}
    try
    {
      this.jdField_a_of_type_Lqr.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bilo
 * JD-Core Version:    0.7.0.1
 */