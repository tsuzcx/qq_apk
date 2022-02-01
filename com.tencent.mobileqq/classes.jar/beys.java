import java.util.HashMap;

public class beys
  extends berj
{
  public beys(beyb parambeyb, beyg parambeyg)
  {
    super(parambeyb, parambeyg);
    this.b = ((beyj)this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int;
  }
  
  public void aN_()
  {
    f();
  }
  
  void d()
  {
    super.d();
    this.jdField_a_of_type_Bern.a(beyb.a(this.jdField_a_of_type_Beyg));
    beyn localbeyn = this.jdField_a_of_type_Beyg.jdField_a_of_type_Beyn;
    if (localbeyn != null)
    {
      localbeyn.jdField_a_of_type_Int = -1;
      localbeyn.jdField_a_of_type_Long = this.k;
      localbeyn.jdField_a_of_type_JavaLangString = this.j;
      localbeyn.jdField_a_of_type_Beyg = this.jdField_a_of_type_Beyg;
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
    beyn localbeyn = this.jdField_a_of_type_Beyg.jdField_a_of_type_Beyn;
    this.jdField_a_of_type_Bern.a(beyb.a(this.jdField_a_of_type_Beyg));
    if (localbeyn != null)
    {
      localbeyn.jdField_a_of_type_Int = 0;
      localbeyn.jdField_a_of_type_Beyg = this.jdField_a_of_type_Beyg;
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
    String str = this.jdField_a_of_type_Beyg.jdField_e_of_type_JavaLangString;
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = this;
    localbeum.jdField_a_of_type_JavaLangString = str;
    localbeum.jdField_a_of_type_Int = 0;
    localbeum.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Beyg.jdField_a_of_type_JavaIoOutputStream;
    localbeum.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Beyg.h;
    localbeum.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Beyg.jdField_a_of_type_Long);
    localbeum.f = this.jdField_a_of_type_Beyg.jdField_a_of_type_Int;
    localbeum.jdField_e_of_type_Int = this.jdField_a_of_type_Beyg.b;
    localbeum.jdField_a_of_type_Long = this.b;
    localbeum.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbeum.d = this.jdField_a_of_type_Beyg.f;
    if (this.jdField_a_of_type_Beyg.jdField_e_of_type_Boolean)
    {
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localbeum.jdField_a_of_type_Long + "-");
      localbeum.jdField_a_of_type_Beup = jdField_a_of_type_Beup;
    }
    localbeum.b = 4;
    localbeum.jdField_c_of_type_Long = 90000L;
    b("httpDown", " url:" + str + ",downOffset:" + localbeum.jdField_a_of_type_Long);
    this.jdField_a_of_type_Beuo.a(localbeum);
  }
  
  public void onResp(bevm parambevm)
  {
    super.onResp(parambevm);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (parambevm.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b("onHttpResp", bool);
      this.b += parambevm.jdField_c_of_type_Long;
      if (parambevm.jdField_a_of_type_Int != 0) {
        break;
      }
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beys
 * JD-Core Version:    0.7.0.1
 */