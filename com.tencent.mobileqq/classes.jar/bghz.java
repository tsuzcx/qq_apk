public class bghz
  implements bghv<String>
{
  private int jdField_a_of_type_Int = -1;
  private bgho jdField_a_of_type_Bgho;
  
  public static bghz a(bgho parambgho)
  {
    bghz localbghz = new bghz();
    localbghz.jdField_a_of_type_Bgho = parambgho;
    return localbghz;
  }
  
  public String a()
  {
    this.jdField_a_of_type_Int = 1;
    return (String)this.jdField_a_of_type_Bgho.a(this);
  }
  
  public String a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (parambghl == null) {
      return null;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return "";
    }
    return parambghl.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bghz
 * JD-Core Version:    0.7.0.1
 */