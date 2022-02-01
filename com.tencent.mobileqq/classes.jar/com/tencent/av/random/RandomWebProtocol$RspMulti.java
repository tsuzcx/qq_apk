package com.tencent.av.random;

import org.json.JSONObject;

class RandomWebProtocol$RspMulti
  extends RandomWebProtocol.Response
{
  boolean jdField_a_of_type_Boolean;
  String b;
  String c;
  int f = -1;
  int g = -1;
  
  RandomWebProtocol$RspMulti(RandomWebProtocol paramRandomWebProtocol) {}
  
  void a(String paramString)
  {
    super.a(paramString);
    if ((2 == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      this.f = this.jdField_a_of_type_OrgJsonJSONObject.optInt("ismask", -1);
      this.b = this.jdField_a_of_type_OrgJsonJSONObject.optString("groupids");
      this.g = this.jdField_a_of_type_OrgJsonJSONObject.optInt("businessid", -1);
      this.c = RandomWebProtocol.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("roomowner"));
      this.jdField_a_of_type_Boolean = this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("ownerenable", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.RspMulti
 * JD-Core Version:    0.7.0.1
 */