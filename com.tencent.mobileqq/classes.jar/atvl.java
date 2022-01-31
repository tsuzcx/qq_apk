import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.support.annotation.RequiresApi;

@RequiresApi(api=21)
public class atvl
  implements atvk
{
  private ConnectivityManager.NetworkCallback jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback;
  private ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  private atvk jdField_a_of_type_Atvk;
  
  atvl(ConnectivityManager paramConnectivityManager, ConnectivityManager.NetworkCallback paramNetworkCallback, atvk paramatvk)
  {
    this.jdField_a_of_type_AndroidNetConnectivityManager = paramConnectivityManager;
    this.jdField_a_of_type_Atvk = paramatvk;
    this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback = paramNetworkCallback;
  }
  
  public void a(int paramInt, Exception paramException)
  {
    this.jdField_a_of_type_AndroidNetConnectivityManager.unregisterNetworkCallback(this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
    this.jdField_a_of_type_Atvk.a(paramInt, paramException);
  }
  
  public void a(Exception paramException)
  {
    this.jdField_a_of_type_AndroidNetConnectivityManager.unregisterNetworkCallback(this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
    this.jdField_a_of_type_Atvk.a(paramException);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidNetConnectivityManager.unregisterNetworkCallback(this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
    this.jdField_a_of_type_Atvk.a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidNetConnectivityManager.unregisterNetworkCallback(this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
    this.jdField_a_of_type_Atvk.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atvl
 * JD-Core Version:    0.7.0.1
 */