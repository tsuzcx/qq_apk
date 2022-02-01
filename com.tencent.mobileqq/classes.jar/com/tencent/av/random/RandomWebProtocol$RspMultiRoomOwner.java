package com.tencent.av.random;

import org.json.JSONObject;

class RandomWebProtocol$RspMultiRoomOwner
  extends RandomWebProtocol.Response
{
  String b;
  
  RandomWebProtocol$RspMultiRoomOwner(RandomWebProtocol paramRandomWebProtocol) {}
  
  void a(String paramString)
  {
    super.a(paramString);
    if ((this.jdField_a_of_type_Int == 5) && (this.jdField_a_of_type_OrgJsonJSONObject != null)) {
      this.b = RandomWebProtocol.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("roomowner"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.RspMultiRoomOwner
 * JD-Core Version:    0.7.0.1
 */