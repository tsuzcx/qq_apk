import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class axuv
{
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new axuw(this);
  axuq jdField_a_of_type_Axuq;
  private axut jdField_a_of_type_Axut;
  axuy jdField_a_of_type_Axuy = new axux(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public axuv(AppInterface paramAppInterface, axut paramaxut)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Axut = paramaxut;
  }
  
  public Message a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_Axuq == null) || (paramMessage == null)) {}
    for (;;)
    {
      return null;
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_Axuq != null) {
            break label49;
          }
          return null;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (RemoteException paramMessage) {}
    }
    paramMessage.printStackTrace();
    return null;
    label49:
    paramMessage = this.jdField_a_of_type_Axuq.a(paramMessage);
    return paramMessage;
  }
  
  public void a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ConnectNearbyProcService.class);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
    if (QLog.isColorLevel()) {
      QLog.d("nearby.msgbox.tab", 2, "bindService");
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Axuq != null;
  }
  
  public Object[] a(int paramInt)
  {
    return a(paramInt, new Object[0]);
  }
  
  public Object[] a(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_Axuq == null) {}
    for (;;)
    {
      return null;
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_Axuq != null) {
            break label45;
          }
          return null;
        }
        if (!QLog.isDevelopLevel()) {}
      }
      catch (RemoteException paramVarArgs) {}
    }
    paramVarArgs.printStackTrace();
    return null;
    label45:
    paramVarArgs = this.jdField_a_of_type_Axuq.a(new BasicTypeDataParcel(paramInt, paramVarArgs));
    if (paramVarArgs == null) {
      return null;
    }
    paramVarArgs = paramVarArgs.a;
    return paramVarArgs;
  }
  
  Message b(Message paramMessage)
  {
    if (this.jdField_a_of_type_Axut != null) {
      return this.jdField_a_of_type_Axut.a(paramMessage);
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
  }
  
  Object[] b(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_Axut != null) {
      return this.jdField_a_of_type_Axut.a(paramInt, paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axuv
 * JD-Core Version:    0.7.0.1
 */