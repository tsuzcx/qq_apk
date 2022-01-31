import java.util.HashMap;

public class aywo
  extends ayow
{
  public aywo(ayvx paramayvx, aywc paramaywc)
  {
    super(paramayvx, paramaywc);
    this.b = ((aywf)this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int;
  }
  
  public void aR_()
  {
    f();
  }
  
  void d()
  {
    super.d();
    this.jdField_a_of_type_Ayoz.a(ayvx.a(this.jdField_a_of_type_Aywc));
    aywj localaywj = this.jdField_a_of_type_Aywc.jdField_a_of_type_Aywj;
    if (localaywj != null)
    {
      localaywj.jdField_a_of_type_Int = -1;
      localaywj.jdField_a_of_type_Long = this.jdField_j_of_type_Int;
      localaywj.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      localaywj.jdField_a_of_type_Aywc = this.jdField_a_of_type_Aywc;
    }
    try
    {
      b("notify", "start");
      notifyAll();
      b("notify", "end");
      return;
    }
    finally {}
  }
  
  void e()
  {
    super.e();
    aywj localaywj = this.jdField_a_of_type_Aywc.jdField_a_of_type_Aywj;
    this.jdField_a_of_type_Ayoz.a(ayvx.a(this.jdField_a_of_type_Aywc));
    if (localaywj != null)
    {
      localaywj.jdField_a_of_type_Int = 0;
      localaywj.jdField_a_of_type_Aywc = this.jdField_a_of_type_Aywc;
    }
    try
    {
      b("notify", "start");
      notifyAll();
      b("notify", "end");
      return;
    }
    finally {}
  }
  
  void f()
  {
    String str = this.jdField_a_of_type_Aywc.jdField_e_of_type_JavaLangString;
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = this;
    localayrx.jdField_a_of_type_JavaLangString = str;
    localayrx.jdField_a_of_type_Int = 0;
    localayrx.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Aywc.jdField_a_of_type_JavaIoOutputStream;
    localayrx.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywc.h;
    localayrx.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Aywc.jdField_a_of_type_Long);
    localayrx.g = this.jdField_a_of_type_Aywc.jdField_a_of_type_Int;
    localayrx.f = this.jdField_a_of_type_Aywc.b;
    localayrx.jdField_a_of_type_Long = this.b;
    localayrx.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localayrx.jdField_e_of_type_Int = this.jdField_a_of_type_Aywc.f;
    if (this.jdField_a_of_type_Aywc.d)
    {
      localayrx.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localayrx.jdField_a_of_type_Long + "-");
      localayrx.jdField_a_of_type_Aysb = jdField_a_of_type_Aysb;
    }
    localayrx.jdField_c_of_type_Int = 4;
    localayrx.jdField_c_of_type_Long = 90000L;
    b("httpDown", " url:" + str + ",downOffset:" + localayrx.jdField_a_of_type_Long);
    this.jdField_a_of_type_Aysa.a(localayrx);
  }
  
  public void onResp(aysz paramaysz)
  {
    super.onResp(paramaysz);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (paramaysz.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b("onHttpResp", bool);
      this.b += paramaysz.jdField_c_of_type_Long;
      if (paramaysz.jdField_a_of_type_Int != 0) {
        break;
      }
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aywo
 * JD-Core Version:    0.7.0.1
 */