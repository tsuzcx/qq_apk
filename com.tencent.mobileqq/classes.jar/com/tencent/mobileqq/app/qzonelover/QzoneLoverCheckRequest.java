package com.tencent.mobileqq.app.qzonelover;

import SWEET_NEW_BASE.sweet_req_comm;
import SWEET_NEW_ICON.sweet_upgrade_key_notify_req;
import SWEET_NEW_ICON.sweet_upgrade_key_notify_rsp;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QUA;
import cooperation.qzone.QzoneExternalRequest;

public class QzoneLoverCheckRequest
  extends QzoneExternalRequest
{
  private sweet_upgrade_key_notify_req jdField_a_of_type_SWEET_NEW_ICONSweet_upgrade_key_notify_req;
  private String jdField_a_of_type_JavaLangString;
  
  public QzoneLoverCheckRequest() {}
  
  public QzoneLoverCheckRequest(long paramLong)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.needCompress = false;
    this.jdField_a_of_type_SWEET_NEW_ICONSweet_upgrade_key_notify_req = new sweet_upgrade_key_notify_req();
    this.jdField_a_of_type_SWEET_NEW_ICONSweet_upgrade_key_notify_req.req_comm = new sweet_req_comm();
    this.jdField_a_of_type_SWEET_NEW_ICONSweet_upgrade_key_notify_req.req_comm.opuin = paramLong;
    this.jdField_a_of_type_SWEET_NEW_ICONSweet_upgrade_key_notify_req.req_comm.uin = paramLong;
    this.jdField_a_of_type_SWEET_NEW_ICONSweet_upgrade_key_notify_req.req_comm.loveuin = 0L;
    this.jdField_a_of_type_SWEET_NEW_ICONSweet_upgrade_key_notify_req.req_comm.qua = QUA.getQUA3();
    this.jdField_a_of_type_SWEET_NEW_ICONSweet_upgrade_key_notify_req.req_comm.pf = 1;
    this.jdField_a_of_type_SWEET_NEW_ICONSweet_upgrade_key_notify_req.req_comm.src = 3;
    this.jdField_a_of_type_JavaLangString = a();
  }
  
  public static sweet_upgrade_key_notify_rsp a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = (sweet_upgrade_key_notify_rsp)decode(paramArrayOfByte, paramString);
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
    if (TextUtils.isEmpty("SweetQzoneService.sweetKeyNotify")) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = "SweetQzoneService.sweetKeyNotify".split("\\.");
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    return arrayOfString[(arrayOfString.length - 1)];
  }
  
  public String getCmdString()
  {
    return "SweetQzoneService.sweetKeyNotify";
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_SWEET_NEW_ICONSweet_upgrade_key_notify_req;
  }
  
  public String uniKey()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qzonelover.QzoneLoverCheckRequest
 * JD-Core Version:    0.7.0.1
 */