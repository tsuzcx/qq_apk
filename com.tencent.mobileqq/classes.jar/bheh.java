import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

public class bheh
  implements bgmc<Void>
{
  private int jdField_a_of_type_Int = -1;
  private bglv jdField_a_of_type_Bglv;
  private String jdField_a_of_type_JavaLangString;
  
  public static bheh a(bglv parambglv)
  {
    bheh localbheh = new bheh();
    localbheh.jdField_a_of_type_Bglv = parambglv;
    return localbheh;
  }
  
  public Void a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (!(parambgls instanceof AppBrandPageContainer)) {
      return null;
    }
    parambgls = (AppBrandPageContainer)parambgls;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    parambgls.setNaviBarStyle(this.jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bglv.a(this);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bheh
 * JD-Core Version:    0.7.0.1
 */