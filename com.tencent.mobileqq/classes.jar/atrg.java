import android.os.Bundle;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x3RspBody;

class atrg
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  private cmd0x345.RspBody.SubCmd0x3RspBody jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody;
  private short jdField_a_of_type_Short;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  public atrg(atrd paramatrd, long paramLong, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, short paramShort, String paramString6, Bundle paramBundle, cmd0x345.RspBody.SubCmd0x3RspBody paramSubCmd0x3RspBody)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.jdField_a_of_type_Short = paramShort;
    this.f = paramString6;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody = paramSubCmd0x3RspBody;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public atrg a()
  {
    if (this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_host.has()) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_host.get();
    }
    if (this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.uint32_port.has()) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.uint32_port.get();
    }
    if (this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_check_sum.has()) {
      this.b = this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_check_sum.get();
    }
    if (this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_cookie.has()) {
      this.c = ("FTN5K=" + this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_cookie.get());
    }
    if (this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.int32_ret_code.has()) {
      this.jdField_a_of_type_Long = this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.int32_ret_code.get();
    }
    if (this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_ret_msg.has()) {
      this.d = this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_ret_msg.get();
    }
    if (this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_suggest_file_name.has())
    {
      this.e = this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_suggest_file_name.get();
      this.e = aunj.a(this.e);
    }
    if (this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_https_domain.has())
    {
      String str = this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_https_domain.get();
      this.jdField_a_of_type_AndroidOsBundle.putString("strHttpsDomain", str);
    }
    if (this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.uint32_https_port.has()) {
      this.jdField_a_of_type_Short = ((short)this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.uint32_https_port.get());
    }
    if (this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_dns.has()) {
      this.f = this.jdField_a_of_type_TencentImCsCmd0x345Cmd0x345$RspBody$SubCmd0x3RspBody.str_dns.get();
    }
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public short a()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atrg
 * JD-Core Version:    0.7.0.1
 */