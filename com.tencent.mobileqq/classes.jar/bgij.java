public class bgij
  implements bghv<Void>
{
  private int jdField_a_of_type_Int = -1;
  private bgho jdField_a_of_type_Bgho;
  private int b;
  
  public static bgij a(bgho parambgho)
  {
    bgij localbgij = new bgij();
    localbgij.jdField_a_of_type_Bgho = parambgho;
    return localbgij;
  }
  
  public Void a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (parambghl == null) {
      return null;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 1: 
      parambghl.setTabBarVisibility(this.b);
      return null;
    }
    parambghl.setNaviVisibility(this.b);
    return null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Bgho.a(this);
    this.b = paramInt;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Bgho.a(this);
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgij
 * JD-Core Version:    0.7.0.1
 */