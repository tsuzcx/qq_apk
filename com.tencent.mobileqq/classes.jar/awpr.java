import android.net.Network;
import android.support.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

@RequiresApi(api=21)
public class awpr
  implements awou
{
  private Network jdField_a_of_type_AndroidNetNetwork;
  private awou jdField_a_of_type_Awou;
  
  awpr(awou paramawou, Network paramNetwork)
  {
    this.jdField_a_of_type_Awou = paramawou;
    this.jdField_a_of_type_AndroidNetNetwork = paramNetwork;
  }
  
  private void a()
  {
    try
    {
      if (!awoq.a()) {
        awoq.a().a();
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
        if (awoq.a()) {
          return true;
        }
        if (!this.jdField_a_of_type_AndroidNetNetwork.equals(awoq.a().a())) {
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
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onGetTokenError, but this request is expired");
      return;
    }
    a();
    this.jdField_a_of_type_Awou.a(paramInt, paramException);
  }
  
  public void a(Exception paramException)
  {
    if (a())
    {
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onChangeNetworkError, but this request is expired");
      return;
    }
    a();
    this.jdField_a_of_type_Awou.a(paramException);
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl)
  {
    if (a())
    {
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onRedirect, but this request is expired");
      return;
    }
    this.jdField_a_of_type_Awou.a(paramSelfPhoneUrl);
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, String paramString)
  {
    if (a())
    {
      QLog.d("GatewayCallbackWrapper", 1, "GatewayCallbackWrapper onResponse, but this request is expired");
      return;
    }
    this.jdField_a_of_type_Awou.a(paramSelfPhoneUrl, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpr
 * JD-Core Version:    0.7.0.1
 */