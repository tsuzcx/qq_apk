import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GVideoProxyService;

public class bltw
{
  bltx jdField_a_of_type_Bltx = null;
  blty jdField_a_of_type_Blty = new blty(this);
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  loc jdField_a_of_type_Loc = null;
  
  public bltw(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Loc == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return 0;
      try
      {
        paramInt = this.jdField_a_of_type_Loc.a(paramLong, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", localRemoteException);
    return 0;
  }
  
  public void a()
  {
    bltv.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Blty);
    this.jdField_a_of_type_Loc = null;
    this.jdField_a_of_type_Bltx = null;
  }
  
  public void a(bltx parambltx)
  {
    this.jdField_a_of_type_Bltx = parambltx;
    if (this.jdField_a_of_type_Loc == null) {
      bltv.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, GVideoProxyService.class, this.jdField_a_of_type_Blty, "com.gvideo.com.tencent.av.service.GVServiceForQQ");
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Loc == null) {
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoRemoteManager", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_Loc.a(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("GroupVideoRemoteManager", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Loc != null) {}
    try
    {
      this.jdField_a_of_type_Loc.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltw
 * JD-Core Version:    0.7.0.1
 */