package com.tencent.av.random;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class RandomWebProtocol$RspDouble
  extends RandomWebProtocol.Response
{
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  byte[] jdField_a_of_type_ArrayOfByte;
  String b;
  String c;
  String d;
  String e;
  int jdField_f_of_type_Int = -1;
  String jdField_f_of_type_JavaLangString;
  int g;
  int h;
  
  void a(String paramString)
  {
    super.a(paramString);
    if ((1 == this.jdField_a_of_type_Int) && (this.jdField_a_of_type_OrgJsonJSONObject != null))
    {
      if (this.jdField_b_of_type_Int != 0) {
        break label205;
      }
      this.jdField_f_of_type_Int = this.jdField_a_of_type_OrgJsonJSONObject.optInt("ismask", -1);
      this.g = this.jdField_a_of_type_OrgJsonJSONObject.optInt("peer_gender");
      this.c = HexUtil.hexString2String(this.jdField_a_of_type_OrgJsonJSONObject.optString("peer_ennick", null));
      this.d = HexUtil.hexString2String(this.jdField_a_of_type_OrgJsonJSONObject.optString("ensessionname", null));
      this.e = this.jdField_a_of_type_OrgJsonJSONObject.optString("headurl", null);
      if (!this.jdField_a_of_type_OrgJsonJSONObject.optBoolean("oldproto", false)) {
        break label164;
      }
      if (QLog.isColorLevel()) {
        QLog.w("RandomWebProtocol", 2, "[1v1] parse method is oldproto");
      }
      this.jdField_b_of_type_JavaLangString = RandomWebProtocol.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("peer_enuin", null));
      this.jdField_a_of_type_ArrayOfByte = RandomWebProtocol.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("vaskey", null));
    }
    label164:
    label205:
    while (this.jdField_b_of_type_Int != 1)
    {
      return;
      this.jdField_b_of_type_JavaLangString = ChatActivityUtils.a(RandomWebProtocol.a(), HexUtil.hexStr2Bytes(this.jdField_a_of_type_OrgJsonJSONObject.optString("peer_enuin", null)));
      this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_OrgJsonJSONObject.optString("vaskey", null));
      return;
    }
    this.h = Math.max(this.jdField_a_of_type_OrgJsonJSONObject.optInt("waittime"), 200);
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_OrgJsonJSONObject.optString("uniqkey", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.random.RandomWebProtocol.RspDouble
 * JD-Core Version:    0.7.0.1
 */