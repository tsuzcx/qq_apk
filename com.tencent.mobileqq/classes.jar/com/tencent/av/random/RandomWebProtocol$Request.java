package com.tencent.av.random;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import org.json.JSONObject;

class RandomWebProtocol$Request
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  String c;
  String d;
  String e = "client";
  
  RandomWebProtocol$Request(RandomWebProtocol paramRandomWebProtocol)
  {
    this.jdField_a_of_type_Int = 0;
    String str = RandomWebProtocol.a(paramRandomWebProtocol).getAccount();
    paramRandomWebProtocol = (TicketManager)RandomWebProtocol.a(paramRandomWebProtocol).getManager(2);
    if (paramRandomWebProtocol == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = "8.5.5";
    this.jdField_a_of_type_Boolean = false;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(str);
      this.jdField_b_of_type_JavaLangString = paramRandomWebProtocol.getSkey(str);
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_OrgJsonJSONObject = null;
      this.c = null;
      this.d = null;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("RandomWebProtocol", 2, "[randomWeb] init Req error: failed parse self_uin: " + str);
        }
      }
    }
  }
  
  RandomWebProtocol$Request(RandomWebProtocol paramRandomWebProtocol, Request paramRequest)
  {
    this.jdField_a_of_type_Int = paramRequest.jdField_a_of_type_Int;
    this.jdField_a_of_type_JavaLangString = paramRequest.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Boolean = paramRequest.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Long = paramRequest.jdField_a_of_type_Long;
    this.jdField_b_of_type_JavaLangString = paramRequest.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_Int = paramRequest.jdField_b_of_type_Int;
    this.jdField_a_of_type_OrgJsonJSONObject = paramRequest.jdField_a_of_type_OrgJsonJSONObject;
    this.c = paramRequest.c;
    this.d = paramRequest.d;
    this.e = paramRequest.e;
  }
  
  String a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return "";
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("reqtype", this.jdField_a_of_type_Int).put("qqversion", this.jdField_a_of_type_JavaLangString).put("isdebug", this.jdField_a_of_type_Boolean).put("self_uin", this.jdField_a_of_type_Long).put("self_skey", this.jdField_b_of_type_JavaLangString).put("self_gender", this.jdField_b_of_type_Int).put("reqbody", this.jdField_a_of_type_OrgJsonJSONObject);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.Request
 * JD-Core Version:    0.7.0.1
 */