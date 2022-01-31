import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

public class bheg
  implements bgmc<String>
{
  private int jdField_a_of_type_Int = -1;
  private bglv jdField_a_of_type_Bglv;
  
  public static bheg a(bglv parambglv)
  {
    bheg localbheg = new bheg();
    localbheg.jdField_a_of_type_Bglv = parambglv;
    return localbheg;
  }
  
  public String a()
  {
    this.jdField_a_of_type_Int = 1;
    return (String)this.jdField_a_of_type_Bglv.a(this);
  }
  
  public String a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (!(parambgls instanceof AppBrandPageContainer)) {
      return null;
    }
    parambgls = (AppBrandPageContainer)parambgls;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return "";
    }
    return parambgls.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bheg
 * JD-Core Version:    0.7.0.1
 */