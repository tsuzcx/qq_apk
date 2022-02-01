import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class blto
{
  private static int jdField_a_of_type_Int = -1;
  private static blto jdField_a_of_type_Blto;
  String jdField_a_of_type_JavaLangString;
  WeakReference<bltq> jdField_a_of_type_JavaLangRefWeakReference;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  String b;
  String c;
  String d;
  String e = "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip";
  String f = "105d1e43c456bc800b4adacd57ac1199";
  
  public static blto a()
  {
    if (jdField_a_of_type_Blto == null) {}
    try
    {
      if (jdField_a_of_type_Blto == null) {
        jdField_a_of_type_Blto = new blto();
      }
      return jdField_a_of_type_Blto;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    jdField_a_of_type_Blto = null;
  }
  
  public void a(bltq parambltq)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambltq);
  }
  
  public void a(String paramString)
  {
    blsw.a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.e = paramString1;
    this.f = paramString2;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    blsw.a().a(1, this.e, this.f);
    blsw.a().a(BaseApplicationImpl.getContext(), this.b, this.jdField_a_of_type_JavaLangString, "0", this.c);
    blsw.a().a(new bltp(this, paramBoolean1, paramBoolean2));
  }
  
  public void a(boolean paramBoolean)
  {
    blsw.a().a(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    blsw.a().b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blto
 * JD-Core Version:    0.7.0.1
 */