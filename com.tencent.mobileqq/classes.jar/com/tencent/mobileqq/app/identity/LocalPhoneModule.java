package com.tencent.mobileqq.app.identity;

import android.util.Base64;
import com.tencent.mobileqq.loginwelcome.GateWayVerifyManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.servlet.LocalPhoneServlet;
import com.tencent.mobileqq.util.DelayReportUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;
import tencent.im.login.GetLocalPhone.GetPhoneReq;
import tencent.im.login.GetLocalPhone.GetPhoneRsp;
import tencent.im.login.GetLocalPhone.GetUrlRsp;
import tencent.im.login.GetLocalPhone.GetUrlRspBody;
import tencent.im.login.GetLocalPhone.LocalPhoneCodeData;
import tencent.im.login.GetLocalPhone.LocalPhoneUploadUrl;

public class LocalPhoneModule
{
  private final int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private final List<GetLocalPhone.LocalPhoneCodeData> jdField_a_of_type_JavaUtilList;
  private final String b;
  private String c;
  private final String d;
  private String e;
  private String f;
  private String g;
  
  public LocalPhoneModule(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.g = paramString3;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    QLog.d("LocalPhoneModule", 1, new Object[] { "LocalPhoneModule init , guid hash is ", Integer.valueOf(this.g.hashCode()) });
  }
  
  private GetLocalPhone.GetPhoneRsp a(String paramString)
  {
    GetLocalPhone.GetPhoneRsp localGetPhoneRsp = new GetLocalPhone.GetPhoneRsp();
    if (Proto2JsonUtil.a(paramString, localGetPhoneRsp)) {
      return localGetPhoneRsp;
    }
    return null;
  }
  
  private GetLocalPhone.GetUrlRsp a(String paramString)
  {
    GetLocalPhone.GetUrlRsp localGetUrlRsp = new GetLocalPhone.GetUrlRsp();
    if (Proto2JsonUtil.a(paramString, localGetUrlRsp)) {
      return localGetUrlRsp;
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2, LocalPhoneModule.UrlTokenCallback paramUrlTokenCallback)
  {
    LocalPhoneServlet.a(b(), LocalPhoneServlet.a(this.jdField_a_of_type_Int, paramString1, paramString2, this.g, ""), new LocalPhoneModule.4(this, paramUrlTokenCallback));
  }
  
  private void a(List<GetLocalPhone.LocalPhoneCodeData> paramList, LocalPhoneModule.MaskPhoneCallback paramMaskPhoneCallback)
  {
    paramList = LocalPhoneServlet.a(this.jdField_a_of_type_Int, this.c, this.b, this.d, this.g, paramList);
    LocalPhoneServlet.a(c(), paramList, new LocalPhoneModule.6(this, paramMaskPhoneCallback));
  }
  
  private void a(List<GetLocalPhone.LocalPhoneCodeData> paramList1, List<GetLocalPhone.LocalPhoneCodeData> paramList2)
  {
    if (paramList1 != null)
    {
      if (paramList1.isEmpty()) {
        return;
      }
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        GetLocalPhone.LocalPhoneCodeData localLocalPhoneCodeData = (GetLocalPhone.LocalPhoneCodeData)paramList1.next();
        if ((paramList2 != null) && (paramList2.contains(localLocalPhoneCodeData)))
        {
          QLog.d("LocalPhoneModule", 1, new Object[] { "current data has been base64 ", Integer.valueOf(localLocalPhoneCodeData.int32_channel_id.get()) });
          DelayReportUtils.a("quickLoginError", "keyQuickLoginError", String.valueOf(1001));
        }
        else
        {
          localLocalPhoneCodeData.str_code_data.set(Base64.encodeToString(localLocalPhoneCodeData.str_code_data.get().getBytes(), 0));
        }
      }
    }
  }
  
  private void a(GetLocalPhone.GetPhoneReq paramGetPhoneReq, LocalPhoneModule.PhoneNumCallback paramPhoneNumCallback)
  {
    LocalPhoneServlet.a(c(), paramGetPhoneReq, new LocalPhoneModule.3(this, paramPhoneNumCallback));
  }
  
  private void a(GetLocalPhone.GetUrlRspBody paramGetUrlRspBody, LocalPhoneModule.UrlTokenCallback paramUrlTokenCallback)
  {
    Object localObject = paramGetUrlRspBody.rpt_local_phone_url.get();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      QLog.d("LocalPhoneModule", 1, new Object[] { "startGetUrlToken, urls size is ", Integer.valueOf(((List)localObject).size()) });
      this.c = paramGetUrlRspBody.str_msg_id.get();
      paramGetUrlRspBody = new LocalPhoneModule.5(this, ((List)localObject).size(), paramUrlTokenCallback);
      paramUrlTokenCallback = ((List)localObject).iterator();
      while (paramUrlTokenCallback.hasNext())
      {
        localObject = (GetLocalPhone.LocalPhoneUploadUrl)paramUrlTokenCallback.next();
        GatewayVerify.SelfPhoneUrl localSelfPhoneUrl = new GatewayVerify.SelfPhoneUrl();
        localSelfPhoneUrl.int32_channel_id.set(((GetLocalPhone.LocalPhoneUploadUrl)localObject).int32_channel_id.get());
        localSelfPhoneUrl.str_upload_url.set(((GetLocalPhone.LocalPhoneUploadUrl)localObject).str_upload_url.get());
        GateWayVerifyManager.a().a(localSelfPhoneUrl, paramGetUrlRspBody);
      }
      return;
    }
    QLog.e("LocalPhoneModule", 1, "startGetUrlToken, urls is empty");
    paramUrlTokenCallback.a(-100006, new Exception("startGetUrlToken, urls is empty"));
  }
  
  private String b()
  {
    return "https://getlocalphone.qq.com/trpc.login.localphone.GetLocalPhone/GetUrlService";
  }
  
  private GetLocalPhone.GetPhoneRsp b(String paramString)
  {
    GetLocalPhone.GetPhoneRsp localGetPhoneRsp = new GetLocalPhone.GetPhoneRsp();
    if (Proto2JsonUtil.a(paramString, localGetPhoneRsp)) {
      return localGetPhoneRsp;
    }
    return null;
  }
  
  private String c()
  {
    return "https://getlocalphone.qq.com/trpc.login.localphone.GetLocalPhone/GetPhoneService";
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    QLog.d("LocalPhoneModule", 1, "destroy module");
    GateWayVerifyManager.a().a();
  }
  
  public void a(LocalPhoneModule.MaskPhoneCallback paramMaskPhoneCallback)
  {
    a(this.b, this.d, new LocalPhoneModule.1(this, paramMaskPhoneCallback));
  }
  
  public void a(LocalPhoneModule.PhoneNumCallback paramPhoneNumCallback)
  {
    a(LocalPhoneServlet.a(this.jdField_a_of_type_Int, this.c, this.b, this.d, this.e, this.f, this.g, this.jdField_a_of_type_JavaUtilList), paramPhoneNumCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.LocalPhoneModule
 * JD-Core Version:    0.7.0.1
 */