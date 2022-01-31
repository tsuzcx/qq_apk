import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.ARGlobalConfigService;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.qphone.base.util.QLog;

public final class amnx
{
  private static volatile amnx jdField_a_of_type_Amnx;
  private volatile amux jdField_a_of_type_Amux;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new amny(this);
  
  private amnx(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static amnx a(Context paramContext)
  {
    if (jdField_a_of_type_Amnx == null) {}
    try
    {
      if (jdField_a_of_type_Amnx == null) {
        jdField_a_of_type_Amnx = new amnx(paramContext.getApplicationContext());
      }
      return jdField_a_of_type_Amnx;
    }
    finally {}
  }
  
  public ARScanStarFaceConfigInfo a()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.jdField_a_of_type_Amux != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_Amux.a();
      QLog.d("ARGlobalRemoteManager", 2, String.format("getScanStarFaceConfigInfo IService=%s configInfo=%s", new Object[] { this.jdField_a_of_type_Amux, localObject1 }));
      return localObject1;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        QLog.e("ARGlobalRemoteManager", 1, "getScanStarFaceConfigInfo fail!", localRemoteException);
        Object localObject2 = localObject3;
      }
    }
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Amux == null)
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ARGlobalConfigService.class);
        this.jdField_a_of_type_AndroidContentContext.bindService(localIntent, this.jdField_a_of_type_AndroidContentServiceConnection, 1);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amnx
 * JD-Core Version:    0.7.0.1
 */