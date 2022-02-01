import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.ipc.BasicTypeDataParcel;
import com.tencent.mobileqq.nearby.ipc.ConnectNearbyProcService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aybl
{
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new aybm(this);
  aybg jdField_a_of_type_Aybg;
  private aybj jdField_a_of_type_Aybj;
  aybo jdField_a_of_type_Aybo = new aybn(this);
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public aybl(AppInterface paramAppInterface, aybj paramaybj)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Aybj = paramaybj;
  }
  
  public Message a(Message paramMessage)
  {
    if ((this.jdField_a_of_type_Aybg == null) || (paramMessage == null)) {}
    for (;;)
    {
      return null;
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_Aybg != null) {
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
    paramMessage = this.jdField_a_of_type_Aybg.a(paramMessage);
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
    return this.jdField_a_of_type_Aybg != null;
  }
  
  public Object[] a(int paramInt)
  {
    return a(paramInt, new Object[0]);
  }
  
  public Object[] a(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_Aybg == null) {}
    for (;;)
    {
      return null;
      try
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_Aybg != null) {
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
    paramVarArgs = this.jdField_a_of_type_Aybg.a(new BasicTypeDataParcel(paramInt, paramVarArgs));
    if (paramVarArgs == null) {
      return null;
    }
    paramVarArgs = paramVarArgs.a;
    return paramVarArgs;
  }
  
  Message b(Message paramMessage)
  {
    if (this.jdField_a_of_type_Aybj != null) {
      return this.jdField_a_of_type_Aybj.a(paramMessage);
    }
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().unbindService(this.jdField_a_of_type_AndroidContentServiceConnection);
  }
  
  Object[] b(int paramInt, Object... paramVarArgs)
  {
    if (this.jdField_a_of_type_Aybj != null) {
      return this.jdField_a_of_type_Aybj.a(paramInt, paramVarArgs);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybl
 * JD-Core Version:    0.7.0.1
 */