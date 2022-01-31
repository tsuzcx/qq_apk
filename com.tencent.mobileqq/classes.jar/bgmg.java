public class bgmg
  implements bgmc<String>
{
  private int jdField_a_of_type_Int = -1;
  private bglv jdField_a_of_type_Bglv;
  
  public static bgmg a(bglv parambglv)
  {
    bgmg localbgmg = new bgmg();
    localbgmg.jdField_a_of_type_Bglv = parambglv;
    return localbgmg;
  }
  
  public String a()
  {
    this.jdField_a_of_type_Int = 1;
    return (String)this.jdField_a_of_type_Bglv.a(this);
  }
  
  public String a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (parambgls == null) {
      return null;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return "";
    }
    return parambgls.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmg
 * JD-Core Version:    0.7.0.1
 */