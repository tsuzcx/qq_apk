import android.net.Network;
import android.support.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;

@RequiresApi(api=21)
class avir
  implements aviq
{
  private Network jdField_a_of_type_AndroidNetNetwork;
  private aviq jdField_a_of_type_Aviq;
  
  avir(aviq paramaviq, Network paramNetwork)
  {
    this.jdField_a_of_type_Aviq = paramaviq;
    this.jdField_a_of_type_AndroidNetNetwork = paramNetwork;
  }
  
  private void a()
  {
    try
    {
      if (avin.b() != null) {
        avin.b().a();
      }
      return;
    }
    finally {}
  }
  
  private boolean a()
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if (avin.b() == null) {
          return true;
        }
        if (!this.jdField_a_of_type_AndroidNetNetwork.equals(avin.b(avin.b()))) {
          return bool;
        }
      }
      finally {}
      bool = false;
    }
  }
  
  public void a(int paramInt, Exception paramException)
  {
    if (a())
    {
      QLog.d("GateWayVerifyManager", 1, "GatewayCallbackWrapper onGetTokenError, but this request is expired");
      return;
    }
    a();
    this.jdField_a_of_type_Aviq.a(paramInt, paramException);
  }
  
  public void a(Exception paramException)
  {
    if (a())
    {
      QLog.d("GateWayVerifyManager", 1, "GatewayCallbackWrapper onChangeNetworkError, but this request is expired");
      return;
    }
    a();
    this.jdField_a_of_type_Aviq.a(paramException);
  }
  
  public void a(String paramString)
  {
    if (a())
    {
      QLog.d("GateWayVerifyManager", 1, "GatewayCallbackWrapper onRedirect, but this request is expired");
      return;
    }
    this.jdField_a_of_type_Aviq.a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (a())
    {
      QLog.d("GateWayVerifyManager", 1, "GatewayCallbackWrapper onResponse, bbut this request is expired");
      return;
    }
    this.jdField_a_of_type_Aviq.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avir
 * JD-Core Version:    0.7.0.1
 */