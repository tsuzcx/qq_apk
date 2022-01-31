import java.util.HashMap;

public class axwf
  extends axoo
{
  public axwf(axvo paramaxvo, axvt paramaxvt)
  {
    super(paramaxvo, paramaxvt);
    this.b = ((axvw)this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int;
  }
  
  public void aU_()
  {
    f();
  }
  
  void d()
  {
    super.d();
    this.jdField_a_of_type_Axos.a(axvo.a(this.jdField_a_of_type_Axvt));
    axwa localaxwa = this.jdField_a_of_type_Axvt.jdField_a_of_type_Axwa;
    if (localaxwa != null)
    {
      localaxwa.jdField_a_of_type_Int = -1;
      localaxwa.jdField_a_of_type_Long = this.j;
      localaxwa.jdField_a_of_type_JavaLangString = this.i;
      localaxwa.jdField_a_of_type_Axvt = this.jdField_a_of_type_Axvt;
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
    axwa localaxwa = this.jdField_a_of_type_Axvt.jdField_a_of_type_Axwa;
    this.jdField_a_of_type_Axos.a(axvo.a(this.jdField_a_of_type_Axvt));
    if (localaxwa != null)
    {
      localaxwa.jdField_a_of_type_Int = 0;
      localaxwa.jdField_a_of_type_Axvt = this.jdField_a_of_type_Axvt;
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
    String str = this.jdField_a_of_type_Axvt.jdField_e_of_type_JavaLangString;
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = this;
    localaxro.jdField_a_of_type_JavaLangString = str;
    localaxro.jdField_a_of_type_Int = 0;
    localaxro.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Axvt.jdField_a_of_type_JavaIoOutputStream;
    localaxro.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Axvt.h;
    localaxro.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Axvt.jdField_a_of_type_Long);
    localaxro.g = this.jdField_a_of_type_Axvt.jdField_a_of_type_Int;
    localaxro.f = this.jdField_a_of_type_Axvt.b;
    localaxro.jdField_a_of_type_Long = this.b;
    localaxro.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localaxro.jdField_e_of_type_Int = this.jdField_a_of_type_Axvt.f;
    if (this.jdField_a_of_type_Axvt.d)
    {
      localaxro.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localaxro.jdField_a_of_type_Long + "-");
      localaxro.jdField_a_of_type_Axrs = jdField_a_of_type_Axrs;
    }
    localaxro.jdField_c_of_type_Int = 4;
    localaxro.jdField_c_of_type_Long = 90000L;
    b("httpDown", " url:" + str + ",downOffset:" + localaxro.jdField_a_of_type_Long);
    this.jdField_a_of_type_Axrr.a(localaxro);
  }
  
  public void onResp(axsq paramaxsq)
  {
    super.onResp(paramaxsq);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (paramaxsq.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b("onHttpResp", bool);
      this.b += paramaxsq.jdField_c_of_type_Long;
      if (paramaxsq.jdField_a_of_type_Int != 0) {
        break;
      }
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axwf
 * JD-Core Version:    0.7.0.1
 */