public class bgie
  implements bghv<bgjy>
{
  private int jdField_a_of_type_Int = 1;
  private bgho jdField_a_of_type_Bgho;
  private int b;
  
  public static bgie a(bgho parambgho)
  {
    bgie localbgie = new bgie();
    localbgie.jdField_a_of_type_Bgho = parambgho;
    return localbgie;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Int = 1;
    this.b = 1;
    bgjy localbgjy = (bgjy)this.jdField_a_of_type_Bgho.a(this);
    if (localbgjy != null) {
      return localbgjy.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public bgjy a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (parambghl == null) {
      return null;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    return parambghl.a(this.b);
  }
  
  public String a()
  {
    this.jdField_a_of_type_Int = 1;
    this.b = 2;
    bgjy localbgjy = (bgjy)this.jdField_a_of_type_Bgho.a(this);
    if (localbgjy != null) {
      return localbgjy.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public int b()
  {
    this.jdField_a_of_type_Int = 1;
    this.b = 8;
    bgjy localbgjy = (bgjy)this.jdField_a_of_type_Bgho.a(this);
    if (localbgjy != null) {
      return localbgjy.c;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgie
 * JD-Core Version:    0.7.0.1
 */