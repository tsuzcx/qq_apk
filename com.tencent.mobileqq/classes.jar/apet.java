import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import com.tencent.mobileqq.ar.ARGlobalConfigService;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.qphone.base.util.QLog;

public final class apet
{
  private static volatile apet jdField_a_of_type_Apet;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection = new apeu(this);
  private volatile aplt jdField_a_of_type_Aplt;
  
  private apet(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static apet a(Context paramContext)
  {
    if (jdField_a_of_type_Apet == null) {}
    try
    {
      if (jdField_a_of_type_Apet == null) {
        jdField_a_of_type_Apet = new apet(paramContext.getApplicationContext());
      }
      return jdField_a_of_type_Apet;
    }
    finally {}
  }
  
  public ARScanStarFaceConfigInfo a()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.jdField_a_of_type_Aplt != null) {}
    try
    {
      localObject1 = this.jdField_a_of_type_Aplt.a();
      QLog.d("ARGlobalRemoteManager", 2, String.format("getScanStarFaceConfigInfo IService=%s configInfo=%s", new Object[] { this.jdField_a_of_type_Aplt, localObject1 }));
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
      if (this.jdField_a_of_type_Aplt == null)
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
 * Qualified Name:     apet
 * JD-Core Version:    0.7.0.1
 */