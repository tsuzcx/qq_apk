import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class bldc
{
  private static int jdField_a_of_type_Int = -1;
  private static bldc jdField_a_of_type_Bldc;
  String jdField_a_of_type_JavaLangString;
  WeakReference<blde> jdField_a_of_type_JavaLangRefWeakReference;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  String b;
  String c;
  String d;
  String e = "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip";
  String f = "105d1e43c456bc800b4adacd57ac1199";
  
  public static bldc a()
  {
    if (jdField_a_of_type_Bldc == null) {}
    try
    {
      if (jdField_a_of_type_Bldc == null) {
        jdField_a_of_type_Bldc = new bldc();
      }
      return jdField_a_of_type_Bldc;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    jdField_a_of_type_Bldc = null;
  }
  
  public void a(blde paramblde)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramblde);
  }
  
  public void a(String paramString)
  {
    blck.a().a(paramString);
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
    blck.a().a(1, this.e, this.f);
    blck.a().a(BaseApplicationImpl.getContext(), this.b, this.jdField_a_of_type_JavaLangString, "0", this.c);
    blck.a().a(new bldd(this, paramBoolean1, paramBoolean2));
  }
  
  public void a(boolean paramBoolean)
  {
    blck.a().a(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    blck.a().b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldc
 * JD-Core Version:    0.7.0.1
 */