import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class bmef
{
  private static int jdField_a_of_type_Int = -1;
  private static bmef jdField_a_of_type_Bmef;
  String jdField_a_of_type_JavaLangString;
  WeakReference<bmeh> jdField_a_of_type_JavaLangRefWeakReference;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  String b;
  String c;
  String d;
  String e = "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip";
  String f = "105d1e43c456bc800b4adacd57ac1199";
  
  public static bmef a()
  {
    if (jdField_a_of_type_Bmef == null) {}
    try
    {
      if (jdField_a_of_type_Bmef == null) {
        jdField_a_of_type_Bmef = new bmef();
      }
      return jdField_a_of_type_Bmef;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    jdField_a_of_type_Bmef = null;
  }
  
  public void a(bmeh parambmeh)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmeh);
  }
  
  public void a(String paramString)
  {
    bmdn.a().a(paramString);
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
    bmdn.a().a(1, this.e, this.f);
    bmdn.a().a(BaseApplicationImpl.getContext(), this.b, this.jdField_a_of_type_JavaLangString, "0", this.c);
    bmdn.a().a(new bmeg(this, paramBoolean1, paramBoolean2));
  }
  
  public void a(boolean paramBoolean)
  {
    bmdn.a().a(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    bmdn.a().b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmef
 * JD-Core Version:    0.7.0.1
 */