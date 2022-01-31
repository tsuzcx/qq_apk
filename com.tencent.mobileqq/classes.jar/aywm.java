import java.util.HashMap;

public class aywm
  extends ayou
{
  public aywm(ayvv paramayvv, aywa paramaywa)
  {
    super(paramayvv, paramaywa);
    this.b = ((aywd)this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int;
  }
  
  public void aR_()
  {
    f();
  }
  
  void d()
  {
    super.d();
    this.jdField_a_of_type_Ayox.a(ayvv.a(this.jdField_a_of_type_Aywa));
    aywh localaywh = this.jdField_a_of_type_Aywa.jdField_a_of_type_Aywh;
    if (localaywh != null)
    {
      localaywh.jdField_a_of_type_Int = -1;
      localaywh.jdField_a_of_type_Long = this.jdField_j_of_type_Int;
      localaywh.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      localaywh.jdField_a_of_type_Aywa = this.jdField_a_of_type_Aywa;
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
    aywh localaywh = this.jdField_a_of_type_Aywa.jdField_a_of_type_Aywh;
    this.jdField_a_of_type_Ayox.a(ayvv.a(this.jdField_a_of_type_Aywa));
    if (localaywh != null)
    {
      localaywh.jdField_a_of_type_Int = 0;
      localaywh.jdField_a_of_type_Aywa = this.jdField_a_of_type_Aywa;
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
    String str = this.jdField_a_of_type_Aywa.jdField_e_of_type_JavaLangString;
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = this;
    localayrv.jdField_a_of_type_JavaLangString = str;
    localayrv.jdField_a_of_type_Int = 0;
    localayrv.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Aywa.jdField_a_of_type_JavaIoOutputStream;
    localayrv.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Aywa.h;
    localayrv.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Aywa.jdField_a_of_type_Long);
    localayrv.g = this.jdField_a_of_type_Aywa.jdField_a_of_type_Int;
    localayrv.f = this.jdField_a_of_type_Aywa.b;
    localayrv.jdField_a_of_type_Long = this.b;
    localayrv.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localayrv.jdField_e_of_type_Int = this.jdField_a_of_type_Aywa.f;
    if (this.jdField_a_of_type_Aywa.d)
    {
      localayrv.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localayrv.jdField_a_of_type_Long + "-");
      localayrv.jdField_a_of_type_Ayrz = jdField_a_of_type_Ayrz;
    }
    localayrv.jdField_c_of_type_Int = 4;
    localayrv.jdField_c_of_type_Long = 90000L;
    b("httpDown", " url:" + str + ",downOffset:" + localayrv.jdField_a_of_type_Long);
    this.jdField_a_of_type_Ayry.a(localayrv);
  }
  
  public void onResp(aysx paramaysx)
  {
    super.onResp(paramaysx);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (paramaysx.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b("onHttpResp", bool);
      this.b += paramaysx.jdField_c_of_type_Long;
      if (paramaysx.jdField_a_of_type_Int != 0) {
        break;
      }
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aywm
 * JD-Core Version:    0.7.0.1
 */