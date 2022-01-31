public class bgml
  implements bgmc<bgof>
{
  private int jdField_a_of_type_Int = 1;
  private bglv jdField_a_of_type_Bglv;
  private int b;
  
  public static bgml a(bglv parambglv)
  {
    bgml localbgml = new bgml();
    localbgml.jdField_a_of_type_Bglv = parambglv;
    return localbgml;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Int = 1;
    this.b = 1;
    bgof localbgof = (bgof)this.jdField_a_of_type_Bglv.a(this);
    if (localbgof != null) {
      return localbgof.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public bgof a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (parambgls == null) {
      return null;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    return parambgls.a(this.b);
  }
  
  public String a()
  {
    this.jdField_a_of_type_Int = 1;
    this.b = 2;
    bgof localbgof = (bgof)this.jdField_a_of_type_Bglv.a(this);
    if (localbgof != null) {
      return localbgof.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public int b()
  {
    this.jdField_a_of_type_Int = 1;
    this.b = 8;
    bgof localbgof = (bgof)this.jdField_a_of_type_Bglv.a(this);
    if (localbgof != null) {
      return localbgof.c;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgml
 * JD-Core Version:    0.7.0.1
 */