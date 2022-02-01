import android.content.Context;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqBodySelfPhone;
import tencent.im.login.GatewayVerify.ReqBodySelfPhoneCheckV4;
import tencent.im.login.GatewayVerify.SelfPhoneToken;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

public class awpq
  implements awou
{
  private int jdField_a_of_type_Int;
  private awow jdField_a_of_type_Awow;
  private String jdField_a_of_type_JavaLangString;
  private final GatewayVerify.ReqBody jdField_a_of_type_TencentImLoginGatewayVerify$ReqBody;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public awpq(Context paramContext, String paramString, int paramInt, awow paramawow)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Awow = paramawow;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_TencentImLoginGatewayVerify$ReqBody = new GatewayVerify.ReqBody();
    this.jdField_a_of_type_TencentImLoginGatewayVerify$ReqBody.msg_req_self_phone.msg_req_check_phone_v4.str_msg_id.set(this.jdField_a_of_type_JavaLangString);
    paramString = qcg.a();
    if ((!NetworkUtil.isWifiConnected(paramContext)) && (paramString != null)) {
      this.jdField_a_of_type_TencentImLoginGatewayVerify$ReqBody.msg_req_self_phone.msg_req_check_phone_v4.str_cell_ip.set(paramString);
    }
    this.jdField_a_of_type_TencentImLoginGatewayVerify$ReqBody.msg_req_self_phone.msg_req_check_phone_v4.setHasFlag(true);
    this.jdField_a_of_type_TencentImLoginGatewayVerify$ReqBody.msg_req_self_phone.setHasFlag(true);
    this.jdField_a_of_type_TencentImLoginGatewayVerify$ReqBody.setHasFlag(true);
  }
  
  private void a()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_TencentImLoginGatewayVerify$ReqBody.toByteArray();
    this.jdField_a_of_type_Awow.a(arrayOfByte);
  }
  
  public void a(int paramInt, Exception paramException)
  {
    for (;;)
    {
      try
      {
        boolean bool = a();
        QLog.e("MultiGatewayCallback", 1, new Object[] { "onGetTokenError : ", paramException.getMessage() });
        if (!bool)
        {
          QLog.e("MultiGatewayCallback", 1, "not finish request");
          return;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          QLog.e("MultiGatewayCallback", 1, "no success request");
          this.jdField_a_of_type_Awow.a(paramInt, paramException);
        }
        else
        {
          a();
        }
      }
      finally {}
    }
  }
  
  public void a(Exception paramException)
  {
    for (;;)
    {
      try
      {
        boolean bool = a();
        QLog.e("MultiGatewayCallback", 1, new Object[] { "onChangeNetworkError : ", paramException.getMessage() });
        if (!bool)
        {
          QLog.d("MultiGatewayCallback", 1, "not finish request");
          return;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          QLog.e("MultiGatewayCallback", 1, "no success request");
          this.jdField_a_of_type_Awow.a(paramException);
        }
        else
        {
          a();
        }
      }
      finally {}
    }
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl)
  {
    this.c += 1;
    if (this.c > 5)
    {
      QLog.e("MultiGatewayCallback", 1, "onRedirect time out of max time");
      a(-100000, new Exception("onRedirect time out"));
      return;
    }
    QLog.d("MultiGatewayCallback", 1, "redirect");
    awoq.a().a(paramSelfPhoneUrl, this);
  }
  
  public void a(GatewayVerify.SelfPhoneUrl paramSelfPhoneUrl, String paramString)
  {
    if (paramSelfPhoneUrl == null) {}
    for (;;)
    {
      try
      {
        QLog.e("MultiGatewayCallback", 1, "onResponse, but urlBean is null");
        a(-100001, new Exception("urlBean is null"));
        return;
      }
      finally {}
      this.jdField_a_of_type_Boolean = true;
      boolean bool = a();
      GatewayVerify.SelfPhoneToken localSelfPhoneToken = new GatewayVerify.SelfPhoneToken();
      QLog.d("MultiGatewayCallback", 1, new Object[] { "onResponse, current success request count: ", Integer.valueOf(this.b), " totalCount : ", Integer.valueOf(this.jdField_a_of_type_Int), " request channelId : ", Integer.valueOf(paramSelfPhoneUrl.int32_channel_id.get()) });
      localSelfPhoneToken.str_token.set(paramString);
      localSelfPhoneToken.int32_channel_id.set(paramSelfPhoneUrl.int32_channel_id.get());
      this.jdField_a_of_type_TencentImLoginGatewayVerify$ReqBody.msg_req_self_phone.msg_req_check_phone_v4.rpt_self_phone_token.add(localSelfPhoneToken);
      if (bool) {
        a();
      }
    }
  }
  
  public boolean a()
  {
    this.b += 1;
    return this.b >= this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpq
 * JD-Core Version:    0.7.0.1
 */