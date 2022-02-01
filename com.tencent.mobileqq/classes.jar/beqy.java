import android.support.annotation.Nullable;
import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mobileqq.abtest.ABTestController.EvtType;

public class beqy
{
  private static beqy jdField_a_of_type_Beqy;
  public static String a;
  private adqg jdField_a_of_type_Adqg;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PhotoMessage";
  }
  
  public beqy()
  {
    a();
  }
  
  public static beqy a()
  {
    if (jdField_a_of_type_Beqy == null) {}
    try
    {
      if (jdField_a_of_type_Beqy == null) {
        jdField_a_of_type_Beqy = new beqy();
      }
      return jdField_a_of_type_Beqy;
    }
    finally {}
  }
  
  @Nullable
  public adqg a()
  {
    if (this.jdField_a_of_type_Adqg != null) {
      ABTestController.a("AIOPicThumbSizeABConfig", this.jdField_a_of_type_Adqg.a());
    }
    return this.jdField_a_of_type_Adqg;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Adqg == null) {
      this.jdField_a_of_type_Adqg = ABTestController.a().a(jdField_a_of_type_JavaLangString, "171819", "171818");
    }
  }
  
  public void a(String paramString)
  {
    adqg localadqg = a();
    if (localadqg != null)
    {
      localadqg.a(jdField_a_of_type_JavaLangString + "_" + paramString);
      ABTestController.a("AIOPicThumbSizeABConfig", localadqg.a());
    }
  }
  
  public void b(String paramString)
  {
    adqg localadqg = a();
    if (localadqg != null)
    {
      localadqg.a(ABTestController.EvtType.CLICK, jdField_a_of_type_JavaLangString + "_" + paramString);
      ABTestController.a("AIOPicThumbSizeABConfig", localadqg.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqy
 * JD-Core Version:    0.7.0.1
 */