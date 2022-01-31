import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigCorpSimpleInfo;
import com.tencent.qidian.proto.mobileqq_qidian.ConfigInfo;

public class bfvq
{
  public int a;
  public bfvo a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public bfvq()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public bfvq(mobileqq_qidian.ConfigInfo paramConfigInfo)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    if (paramConfigInfo.uint32_type.has()) {
      this.jdField_a_of_type_Int = paramConfigInfo.uint32_type.get();
    }
    if (paramConfigInfo.uint32_event.has()) {
      this.jdField_b_of_type_Int = paramConfigInfo.uint32_event.get();
    }
    if (paramConfigInfo.str_title.has()) {
      this.jdField_a_of_type_JavaLangString = paramConfigInfo.str_title.get();
    }
    if (paramConfigInfo.str_content.has()) {
      this.jdField_b_of_type_JavaLangString = paramConfigInfo.str_content.get();
    }
    if (paramConfigInfo.str_action.has()) {
      this.c = paramConfigInfo.str_action.get();
    }
    if (paramConfigInfo.str_aaction.has()) {
      this.d = paramConfigInfo.str_aaction.get();
    }
    if (paramConfigInfo.msg_corp_simple.has()) {
      this.jdField_a_of_type_Bfvo = new bfvo(paramConfigInfo.msg_corp_simple);
    }
    if (paramConfigInfo.str_url.has()) {
      this.e = paramConfigInfo.str_url.get();
    }
    if (paramConfigInfo.str_lat.has()) {
      this.f = paramConfigInfo.str_lat.get();
    }
    if (paramConfigInfo.str_log.has()) {
      this.g = paramConfigInfo.str_log.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfvq
 * JD-Core Version:    0.7.0.1
 */