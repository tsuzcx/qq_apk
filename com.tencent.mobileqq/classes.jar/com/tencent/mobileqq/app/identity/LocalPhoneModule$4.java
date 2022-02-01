package com.tencent.mobileqq.app.identity;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.servlet.LocalPhoneServlet.IHttpsCallback;
import com.tencent.qphone.base.util.QLog;
import tencent.im.login.GetLocalPhone.GetUrlRsp;
import tencent.im.login.GetLocalPhone.GetUrlRspBody;
import tencent.im.login.GetLocalPhone.Head;

class LocalPhoneModule$4
  implements LocalPhoneServlet.IHttpsCallback
{
  LocalPhoneModule$4(LocalPhoneModule paramLocalPhoneModule, LocalPhoneModule.UrlTokenCallback paramUrlTokenCallback) {}
  
  public void a(int paramInt, String paramString)
  {
    this.a.a(paramInt, new Exception(paramString));
  }
  
  public void a(String paramString)
  {
    paramString = LocalPhoneModule.c(this.b, paramString);
    if (paramString == null)
    {
      QLog.e("LocalPhoneModule", 1, "get url success, but parse url rsp error");
      a(-100003, "parse url rsp error");
      return;
    }
    int i = paramString.msg_head.uint32_err_code.get();
    if (i == 0)
    {
      LocalPhoneModule.a(this.b, (GetLocalPhone.GetUrlRspBody)paramString.msg_get_url_rsp_body.get(), this.a);
      return;
    }
    a(i, paramString.msg_head.str_err_msg.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.LocalPhoneModule.4
 * JD-Core Version:    0.7.0.1
 */