package com.tencent.mobileqq.activity.aio.zhitu;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.datarecv.pb.ZhituReportMsg.ReqBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.securitysdk.utils.MD5;

public class ZhituReportData
{
  public String a;
  public String b;
  public String c;
  public int d;
  public String e;
  public String f;
  @Nullable
  public String g;
  @Nullable
  public String h;
  public boolean i = false;
  
  public ZhituReportMsg.ReqBody a()
  {
    if (this.a == null) {
      this.a = "";
    }
    if (this.c == null) {
      this.c = "";
    }
    if (this.b == null) {
      this.b = "";
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
    if (this.h == null) {
      this.h = "";
    }
    ZhituReportMsg.ReqBody localReqBody = new ZhituReportMsg.ReqBody();
    localReqBody.bytes_pass.set(ByteStringMicro.copyFromUtf8(this.a));
    localReqBody.bytes_pic_id.set(ByteStringMicro.copyFromUtf8(this.b));
    localReqBody.bytes_style.set(ByteStringMicro.copyFromUtf8(this.c));
    localReqBody.uint32_action.set(this.d);
    localReqBody.bytes_aio_type.set(ByteStringMicro.copyFromUtf8(this.e));
    localReqBody.bytes_mobile_type.set(ByteStringMicro.copyFromUtf8("android"));
    localReqBody.bytes_current_text.set(ByteStringMicro.copyFromUtf8(this.f));
    return localReqBody;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ZhituReportData{pass='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", imgId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", styles='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", action=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", aioType='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", queryText='");
    Object localObject = this.f;
    String str1 = "null";
    if (localObject != null) {
      localObject = MD5.b((String)localObject);
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastMessage='");
    localObject = this.g;
    if (localObject != null) {
      localObject = MD5.b((String)localObject);
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('\'');
    localStringBuilder.append(", lastTwoMessage='");
    String str2 = this.h;
    localObject = str1;
    if (str2 != null) {
      localObject = MD5.b(str2);
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isReported=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituReportData
 * JD-Core Version:    0.7.0.1
 */