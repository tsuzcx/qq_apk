package com.tencent.mobileqq.app.qzonelover;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_ICON.lighting_sweet_key_req;
import SWEET_NEW_ICON.lighting_sweet_key_rsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;

public class QzoneLoverLightingRequest
  extends QzoneExternalRequest
{
  private String a;
  private lighting_sweet_key_req b;
  
  public QzoneLoverLightingRequest() {}
  
  public QzoneLoverLightingRequest(long paramLong)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.needCompress = false;
    this.b = new lighting_sweet_key_req();
    this.b.req_comm = new sweet_req_comm();
    this.b.req_comm.opuin = paramLong;
    this.b.req_comm.uin = paramLong;
    this.b.req_comm.loveuin = 0L;
    this.b.req_comm.qua = QUA.getQUA3();
    this.b.req_comm.pf = 1;
    this.b.req_comm.src = 3;
    this.a = a();
  }
  
  public static lighting_sweet_key_rsp a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = (lighting_sweet_key_rsp)decode(paramArrayOfByte, paramString);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty("SweetQzoneService.lightingSweetKey")) {
      return null;
    }
    String[] arrayOfString = "SweetQzoneService.lightingSweetKey".split("\\.");
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      return arrayOfString[(arrayOfString.length - 1)];
    }
    return null;
  }
  
  public String getCmdString()
  {
    return "SweetQzoneService.lightingSweetKey";
  }
  
  public JceStruct getReq()
  {
    return this.b;
  }
  
  public String uniKey()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qzonelover.QzoneLoverLightingRequest
 * JD-Core Version:    0.7.0.1
 */