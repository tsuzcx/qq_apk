import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qconn.protofile.fastauthorize.FastAuthorize.AuthorizeResponse;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class arek
  implements BusinessObserver
{
  arek(arei paramarei, arem paramarem, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    new Bundle();
    paramBundle = paramBundle.getByteArray("data");
    if (paramBundle == null) {
      return;
    }
    FastAuthorize.AuthorizeResponse localAuthorizeResponse = new FastAuthorize.AuthorizeResponse();
    try
    {
      localAuthorizeResponse.mergeFrom(paramBundle);
      if ((localAuthorizeResponse.ret.get().equals("0")) && (localAuthorizeResponse.apk_name.has()))
      {
        if (localAuthorizeResponse.access_token.has()) {
          this.jdField_a_of_type_Arei.a.jdField_a_of_type_JavaLangString = localAuthorizeResponse.access_token.get();
        }
        if (localAuthorizeResponse.openid.has()) {
          this.jdField_a_of_type_Arei.a.b = localAuthorizeResponse.openid.get();
        }
        if (localAuthorizeResponse.pay_token.has()) {
          this.jdField_a_of_type_Arei.a.c = localAuthorizeResponse.pay_token.get();
        }
        this.jdField_a_of_type_Arei.a.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Arem.a(this.jdField_a_of_type_JavaLangString, true, 0);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      paramBundle.printStackTrace();
      return;
    }
    QLog.e("XProxy", 2, "获取票据失败");
    try
    {
      this.jdField_a_of_type_Arem.a(this.jdField_a_of_type_JavaLangString, false, Integer.parseInt(localAuthorizeResponse.ret.get()));
      return;
    }
    catch (NumberFormatException paramBundle)
    {
      this.jdField_a_of_type_Arem.a(this.jdField_a_of_type_JavaLangString, false, 0);
      QLog.e("XProxy", 2, "获取票据错误码不为int");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arek
 * JD-Core Version:    0.7.0.1
 */