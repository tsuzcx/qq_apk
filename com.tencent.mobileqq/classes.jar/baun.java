import java.util.HashMap;

public class baun
  extends bamr
{
  public baun(batw parambatw, baub parambaub)
  {
    super(parambatw, parambaub);
    this.b = ((baue)this.jdField_a_of_type_Baub.jdField_a_of_type_JavaLangObject).jdField_a_of_type_Int;
  }
  
  public void aS_()
  {
    f();
  }
  
  void d()
  {
    super.d();
    this.jdField_a_of_type_Bamu.a(batw.a(this.jdField_a_of_type_Baub));
    baui localbaui = this.jdField_a_of_type_Baub.jdField_a_of_type_Baui;
    if (localbaui != null)
    {
      localbaui.jdField_a_of_type_Int = -1;
      localbaui.jdField_a_of_type_Long = this.jdField_j_of_type_Int;
      localbaui.jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      localbaui.jdField_a_of_type_Baub = this.jdField_a_of_type_Baub;
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
    baui localbaui = this.jdField_a_of_type_Baub.jdField_a_of_type_Baui;
    this.jdField_a_of_type_Bamu.a(batw.a(this.jdField_a_of_type_Baub));
    if (localbaui != null)
    {
      localbaui.jdField_a_of_type_Int = 0;
      localbaui.jdField_a_of_type_Baub = this.jdField_a_of_type_Baub;
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
    String str = this.jdField_a_of_type_Baub.jdField_e_of_type_JavaLangString;
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = this;
    localbaps.jdField_a_of_type_JavaLangString = str;
    localbaps.jdField_a_of_type_Int = 0;
    localbaps.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_Baub.jdField_a_of_type_JavaIoOutputStream;
    localbaps.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_Baub.h;
    localbaps.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Baub.jdField_a_of_type_Long);
    localbaps.g = this.jdField_a_of_type_Baub.jdField_a_of_type_Int;
    localbaps.f = this.jdField_a_of_type_Baub.b;
    localbaps.jdField_a_of_type_Long = this.b;
    localbaps.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localbaps.jdField_e_of_type_Int = this.jdField_a_of_type_Baub.f;
    if (this.jdField_a_of_type_Baub.d)
    {
      localbaps.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + localbaps.jdField_a_of_type_Long + "-");
      localbaps.jdField_a_of_type_Bapw = jdField_a_of_type_Bapw;
    }
    localbaps.jdField_c_of_type_Int = 4;
    localbaps.jdField_c_of_type_Long = 90000L;
    b("httpDown", " url:" + str + ",downOffset:" + localbaps.jdField_a_of_type_Long);
    this.jdField_a_of_type_Bapv.a(localbaps);
  }
  
  public void onResp(baqw parambaqw)
  {
    super.onResp(parambaqw);
    StringBuilder localStringBuilder = new StringBuilder().append(" result:");
    if (parambaqw.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      b("onHttpResp", bool);
      this.b += parambaqw.jdField_c_of_type_Long;
      if (parambaqw.jdField_a_of_type_Int != 0) {
        break;
      }
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baun
 * JD-Core Version:    0.7.0.1
 */