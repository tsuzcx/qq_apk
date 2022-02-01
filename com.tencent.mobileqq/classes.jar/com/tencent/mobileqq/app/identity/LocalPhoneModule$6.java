package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.servlet.LocalPhoneServlet.IHttpsCallback;
import com.tencent.qphone.base.util.QLog;
import tencent.im.login.GetLocalPhone.GetPhoneRsp;
import tencent.im.login.GetLocalPhone.GetPhoneRspBody;
import tencent.im.login.GetLocalPhone.Head;
import tencent.im.login.GetLocalPhone.MaskPhoneData;

class LocalPhoneModule$6
  implements LocalPhoneServlet.IHttpsCallback
{
  LocalPhoneModule$6(LocalPhoneModule paramLocalPhoneModule, LocalPhoneModule.MaskPhoneCallback paramMaskPhoneCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule$MaskPhoneCallback.a(paramInt, new Exception(paramString));
  }
  
  public void a(String paramString)
  {
    paramString = LocalPhoneModule.b(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule, paramString);
    if (paramString == null)
    {
      QLog.e("LocalPhoneModule", 1, "get mask phone success, but parse url rsp error");
      a(-100004, "parse mask phone rsp error");
      return;
    }
    int i = paramString.msg_head.uint32_err_code.get();
    if (i == 0)
    {
      paramString = (GetLocalPhone.MaskPhoneData)paramString.msg_get_phone_rsp_body.msg_mask_phone_data.get();
      LocalPhoneModule.b(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule, paramString.str_process_cookies.get());
      LocalPhoneModule.c(this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule, paramString.str_mask_phone.get());
      this.jdField_a_of_type_ComTencentMobileqqAppIdentityLocalPhoneModule$MaskPhoneCallback.a(paramString);
      return;
    }
    a(i, paramString.msg_head.str_err_msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.LocalPhoneModule.6
 * JD-Core Version:    0.7.0.1
 */