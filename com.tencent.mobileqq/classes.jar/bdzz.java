import java.util.HashMap;

public class bdzz
  extends bdsr
{
  public bdzz(bdzi parambdzi, bdzn parambdzn)
  {
    super(parambdzi, parambdzn);
    this.b = ((bdzq)this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int;
  }
  
  public void aN_()
  {
    f();
  }
  
  void d()
  {
    super.d();
    this.jdField_a_of_type_Bdsv.a(bdzi.a(this.jdField_a_of_type_Bdzn));
    bdzu localbdzu = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Bdzu;
    if (localbdzu != null)
    {
      localbdzu.jdField_a_of_type_Int = -1;
      localbdzu.jdField_a_of_type_Long = this.jdField_j_of_type_Int;
      localbdzu.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      localbdzu.jdField_a_of_type_Bdzn = this.jdField_a_of_type_Bdzn;
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
    bdzu localbdzu = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Bdzu;
    this.jdField_a_of_type_Bdsv.a(bdzi.a(this.jdField_a_of_type_Bdzn));
    if (localbdzu != null)
    {
      localbdzu.jdField_a_of_type_Int = 0;
      localbdzu.jdField_a_of_type_Bdzn = this.jdField_a_of_type_Bdzn;
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
    String str = this.jdField_a_of_type_Bdzn.jdField_e_of_type_JavaLangString;
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = this;
    localbdvs.jdField_a_of_type_JavaLangString = str;
    localbdvs.jdField_a_of_type_Int = 0;
    localbdvs.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Bdzn.jdField_a_of_type_JavaIoOutputStream;
    localbdvs.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Bdzn.h;
    localbdvs.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Bdzn.jdField_a_of_type_Long);
    localbdvs.f = this.jdField_a_of_type_Bdzn.jdField_a_of_type_Int;
    localbdvs.jdField_e_of_type_Int = this.jdField_a_of_type_Bdzn.b;
    localbdvs.jdField_a_of_type_Long = this.b;
    localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbdvs.d = this.jdField_a_of_type_Bdzn.f;
    if (this.jdField_a_of_type_Bdzn.d)
    {
      localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localbdvs.jdField_a_of_type_Long + "-");
      localbdvs.jdField_a_of_type_Bdvv = jdField_a_of_type_Bdvv;
    }
    localbdvs.b = 4;
    localbdvs.jdField_c_of_type_Long = 90000L;
    b("httpDown", " url:" + str + ",downOffset:" + localbdvs.jdField_a_of_type_Long);
    this.jdField_a_of_type_Bdvu.a(localbdvs);
  }
  
  public void onResp(bdwt parambdwt)
  {
    super.onResp(parambdwt);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (parambdwt.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b("onHttpResp", bool);
      this.b += parambdwt.jdField_c_of_type_Long;
      if (parambdwt.jdField_a_of_type_Int != 0) {
        break;
      }
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdzz
 * JD-Core Version:    0.7.0.1
 */