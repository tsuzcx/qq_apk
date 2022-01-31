import com.tencent.qqmini.sdk.runtime.core.page.AppBrandPageContainer;

public class bhaa
  implements bghv<Void>
{
  private int jdField_a_of_type_Int = -1;
  private bgho jdField_a_of_type_Bgho;
  private String jdField_a_of_type_JavaLangString;
  
  public static bhaa a(bgho parambgho)
  {
    bhaa localbhaa = new bhaa();
    localbhaa.jdField_a_of_type_Bgho = parambgho;
    return localbhaa;
  }
  
  public Void a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (!(parambghl instanceof AppBrandPageContainer)) {
      return null;
    }
    parambghl = (AppBrandPageContainer)parambghl;
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    parambghl.setNaviBarStyle(this.jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bgho.a(this);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhaa
 * JD-Core Version:    0.7.0.1
 */