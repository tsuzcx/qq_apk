public class bghy
  implements bghv<Integer>
{
  private int jdField_a_of_type_Int = -1;
  private bgho jdField_a_of_type_Bgho;
  
  public static bghy a(bgho parambgho)
  {
    bghy localbghy = new bghy();
    localbghy.jdField_a_of_type_Bgho = parambgho;
    return localbghy;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Int = 1;
    return ((Integer)this.jdField_a_of_type_Bgho.a(this)).intValue();
  }
  
  public Integer a(bghl parambghl)
  {
    parambghl = parambghl.a();
    if (parambghl == null) {
      return null;
    }
    int i = -1;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return Integer.valueOf(i);
      i = parambghl.a();
      continue;
      i = parambghl.b();
      continue;
      i = parambghl.c();
    }
  }
  
  public int b()
  {
    this.jdField_a_of_type_Int = 2;
    return ((Integer)this.jdField_a_of_type_Bgho.a(this)).intValue();
  }
  
  public int c()
  {
    this.jdField_a_of_type_Int = 3;
    return ((Integer)this.jdField_a_of_type_Bgho.a(this)).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bghy
 * JD-Core Version:    0.7.0.1
 */