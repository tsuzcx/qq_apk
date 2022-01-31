import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.support.annotation.RequiresApi;

@RequiresApi(api=21)
public class atrc
  implements atrb
{
  private ConnectivityManager.NetworkCallback jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback;
  private ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  private atrb jdField_a_of_type_Atrb;
  
  atrc(ConnectivityManager paramConnectivityManager, ConnectivityManager.NetworkCallback paramNetworkCallback, atrb paramatrb)
  {
    this.jdField_a_of_type_AndroidNetConnectivityManager = paramConnectivityManager;
    this.jdField_a_of_type_Atrb = paramatrb;
    this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback = paramNetworkCallback;
  }
  
  public void a(int paramInt, Exception paramException)
  {
    this.jdField_a_of_type_AndroidNetConnectivityManager.unregisterNetworkCallback(this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
    this.jdField_a_of_type_Atrb.a(paramInt, paramException);
  }
  
  public void a(Exception paramException)
  {
    this.jdField_a_of_type_AndroidNetConnectivityManager.unregisterNetworkCallback(this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
    this.jdField_a_of_type_Atrb.a(paramException);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidNetConnectivityManager.unregisterNetworkCallback(this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
    this.jdField_a_of_type_Atrb.a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidNetConnectivityManager.unregisterNetworkCallback(this.jdField_a_of_type_AndroidNetConnectivityManager$NetworkCallback);
    this.jdField_a_of_type_Atrb.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atrc
 * JD-Core Version:    0.7.0.1
 */