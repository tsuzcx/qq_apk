import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class bilg
{
  private static int jdField_a_of_type_Int = -1;
  private static bilg jdField_a_of_type_Bilg;
  String jdField_a_of_type_JavaLangString;
  WeakReference<bili> jdField_a_of_type_JavaLangRefWeakReference;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  String b;
  String c;
  String d;
  String e = "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip";
  String f = "105d1e43c456bc800b4adacd57ac1199";
  
  public static bilg a()
  {
    if (jdField_a_of_type_Bilg == null) {}
    try
    {
      if (jdField_a_of_type_Bilg == null) {
        jdField_a_of_type_Bilg = new bilg();
      }
      return jdField_a_of_type_Bilg;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    jdField_a_of_type_Bilg = null;
  }
  
  public void a(bili parambili)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambili);
  }
  
  public void a(String paramString)
  {
    biko.a().a(paramString);
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
    biko.a().a(1, this.e, this.f);
    biko.a().a(BaseApplicationImpl.getContext(), this.b, this.jdField_a_of_type_JavaLangString, "0", this.c);
    biko.a().a(new bilh(this, paramBoolean1, paramBoolean2));
  }
  
  public void a(boolean paramBoolean)
  {
    biko.a().a(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    biko.a().b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bilg
 * JD-Core Version:    0.7.0.1
 */