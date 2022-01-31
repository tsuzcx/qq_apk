import java.util.HashMap;

public class bayw
  extends bara
{
  public bayw(bayf parambayf, bayk parambayk)
  {
    super(parambayf, parambayk);
    this.b = ((bayn)this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int;
  }
  
  public void aP_()
  {
    f();
  }
  
  void d()
  {
    super.d();
    this.jdField_a_of_type_Bard.a(bayf.a(this.jdField_a_of_type_Bayk));
    bayr localbayr = this.jdField_a_of_type_Bayk.jdField_a_of_type_Bayr;
    if (localbayr != null)
    {
      localbayr.jdField_a_of_type_Int = -1;
      localbayr.jdField_a_of_type_Long = this.jdField_j_of_type_Int;
      localbayr.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      localbayr.jdField_a_of_type_Bayk = this.jdField_a_of_type_Bayk;
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
    bayr localbayr = this.jdField_a_of_type_Bayk.jdField_a_of_type_Bayr;
    this.jdField_a_of_type_Bard.a(bayf.a(this.jdField_a_of_type_Bayk));
    if (localbayr != null)
    {
      localbayr.jdField_a_of_type_Int = 0;
      localbayr.jdField_a_of_type_Bayk = this.jdField_a_of_type_Bayk;
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
    String str = this.jdField_a_of_type_Bayk.jdField_e_of_type_JavaLangString;
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = this;
    localbaub.jdField_a_of_type_JavaLangString = str;
    localbaub.jdField_a_of_type_Int = 0;
    localbaub.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Bayk.jdField_a_of_type_JavaIoOutputStream;
    localbaub.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bayk.h;
    localbaub.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Bayk.jdField_a_of_type_Long);
    localbaub.g = this.jdField_a_of_type_Bayk.jdField_a_of_type_Int;
    localbaub.f = this.jdField_a_of_type_Bayk.b;
    localbaub.jdField_a_of_type_Long = this.b;
    localbaub.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbaub.jdField_e_of_type_Int = this.jdField_a_of_type_Bayk.f;
    if (this.jdField_a_of_type_Bayk.d)
    {
      localbaub.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localbaub.jdField_a_of_type_Long + "-");
      localbaub.jdField_a_of_type_Bauf = jdField_a_of_type_Bauf;
    }
    localbaub.jdField_c_of_type_Int = 4;
    localbaub.jdField_c_of_type_Long = 90000L;
    b("httpDown", " url:" + str + ",downOffset:" + localbaub.jdField_a_of_type_Long);
    this.jdField_a_of_type_Baue.a(localbaub);
  }
  
  public void onResp(bavf parambavf)
  {
    super.onResp(parambavf);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (parambavf.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b("onHttpResp", bool);
      this.b += parambavf.jdField_c_of_type_Long;
      if (parambavf.jdField_a_of_type_Int != 0) {
        break;
      }
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bayw
 * JD-Core Version:    0.7.0.1
 */