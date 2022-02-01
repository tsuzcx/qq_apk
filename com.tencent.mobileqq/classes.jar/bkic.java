import com.tencent.common.app.BaseApplicationImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class bkic
{
  private static int jdField_a_of_type_Int = -1;
  private static bkic jdField_a_of_type_Bkic;
  String jdField_a_of_type_JavaLangString;
  WeakReference<bkie> jdField_a_of_type_JavaLangRefWeakReference;
  List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  String b;
  String c;
  String d;
  String e = "https://sqimg.qq.com/qq_product_operations/gme_sdk/GME_SDK_V1.zip";
  String f = "105d1e43c456bc800b4adacd57ac1199";
  
  public static bkic a()
  {
    if (jdField_a_of_type_Bkic == null) {}
    try
    {
      if (jdField_a_of_type_Bkic == null) {
        jdField_a_of_type_Bkic = new bkic();
      }
      return jdField_a_of_type_Bkic;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    jdField_a_of_type_Bkic = null;
  }
  
  public void a(bkie parambkie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambkie);
  }
  
  public void a(String paramString)
  {
    bkhk.a().a(paramString);
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
    bkhk.a().a(1, this.e, this.f);
    bkhk.a().a(BaseApplicationImpl.getContext(), this.b, this.jdField_a_of_type_JavaLangString, "0", this.c);
    bkhk.a().a(new bkid(this, paramBoolean1, paramBoolean2));
  }
  
  public void a(boolean paramBoolean)
  {
    bkhk.a().a(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    bkhk.a().b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkic
 * JD-Core Version:    0.7.0.1
 */