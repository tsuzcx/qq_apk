package com.tencent.mobileqq.activity.aio.zhitu;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.datarecv.pb.ZhituReportMsg.ReqBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.securitysdk.utils.MD5;

public class ZhituReportData
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  public String d;
  public String e;
  @Nullable
  public String f;
  @Nullable
  public String g;
  
  public ZhituReportData()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ZhituReportMsg.ReqBody a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    if (this.c == null) {
      this.c = "";
    }
    if (this.b == null) {
      this.b = "";
    }
    if (this.d == null) {
      this.d = "";
    }
    if (this.e == null) {
      this.e = "";
    }
    if (this.f == null) {
      this.f = "";
    }
    if (this.g == null) {
      this.g = "";
    }
    ZhituReportMsg.ReqBody localReqBody = new ZhituReportMsg.ReqBody();
    localReqBody.bytes_pass.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    localReqBody.bytes_pic_id.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqBody.bytes_style.set(ByteStringMicro.copyFromUtf8(this.c));
    localReqBody.uint32_action.set(this.jdField_a_of_type_Int);
    localReqBody.bytes_aio_type.set(ByteStringMicro.copyFromUtf8(this.d));
    localReqBody.bytes_mobile_type.set(ByteStringMicro.copyFromUtf8("android"));
    localReqBody.bytes_current_text.set(ByteStringMicro.copyFromUtf8(this.e));
    return localReqBody;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZhituReportData{pass='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imgId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", styles='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", aioType='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", queryText='");
    Object localObject = this.e;
    String str1 = "null";
    if (localObject != null) {
      localObject = MD5.a((String)localObject);
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastMessage='");
    localObject = this.f;
    if (localObject != null) {
      localObject = MD5.a((String)localObject);
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastTwoMessage='");
    String str2 = this.g;
    localObject = str1;
    if (str2 != null) {
      localObject = MD5.a(str2);
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isReported=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituReportData
 * JD-Core Version:    0.7.0.1
 */