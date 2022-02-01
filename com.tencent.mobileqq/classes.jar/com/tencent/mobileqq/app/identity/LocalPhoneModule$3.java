package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.servlet.LocalPhoneServlet.IHttpsCallback;
import com.tencent.qphone.base.util.QLog;
import tencent.im.login.GetLocalPhone.EncryptPhoneData;
import tencent.im.login.GetLocalPhone.GetPhoneRsp;
import tencent.im.login.GetLocalPhone.GetPhoneRspBody;
import tencent.im.login.GetLocalPhone.Head;

class LocalPhoneModule$3
  implements LocalPhoneServlet.IHttpsCallback
{
  LocalPhoneModule$3(LocalPhoneModule paramLocalPhoneModule, LocalPhoneModule.PhoneNumCallback paramPhoneNumCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule$PhoneNumCallback.a(paramInt, new Exception(paramString));
  }
  
  public void a(String paramString)
  {
    paramString = LocalPhoneModule.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule, paramString);
    if (paramString == null)
    {
      QLog.e("LocalPhoneModule", 1, "get phone token success, but parse phone rsp error");
      a(-100005, "parse phone rsp error");
      return;
    }
    int i = paramString.msg_head.uint32_err_code.get();
    if (i == 0)
    {
      paramString = (GetLocalPhone.EncryptPhoneData)paramString.msg_get_phone_rsp_body.msg_encrypt_phone_data.get();
      LocalPhoneModule.a(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule, paramString.str_encypt_phone.get());
      this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule$PhoneNumCallback.a(paramString);
      return;
    }
    a(i, paramString.msg_head.str_err_msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.LocalPhoneModule.3
 * JD-Core Version:    0.7.0.1
 */