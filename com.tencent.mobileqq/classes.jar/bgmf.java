public class bgmf
  implements bgmc<Integer>
{
  private int jdField_a_of_type_Int = -1;
  private bglv jdField_a_of_type_Bglv;
  
  public static bgmf a(bglv parambglv)
  {
    bgmf localbgmf = new bgmf();
    localbgmf.jdField_a_of_type_Bglv = parambglv;
    return localbgmf;
  }
  
  public int a()
  {
    this.jdField_a_of_type_Int = 1;
    return ((Integer)this.jdField_a_of_type_Bglv.a(this)).intValue();
  }
  
  public Integer a(bgls parambgls)
  {
    parambgls = parambgls.a();
    if (parambgls == null) {
      return null;
    }
    int i = -1;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return Integer.valueOf(i);
      i = parambgls.a();
      continue;
      i = parambgls.b();
      continue;
      i = parambgls.c();
    }
  }
  
  public int b()
  {
    this.jdField_a_of_type_Int = 2;
    return ((Integer)this.jdField_a_of_type_Bglv.a(this)).intValue();
  }
  
  public int c()
  {
    this.jdField_a_of_type_Int = 3;
    return ((Integer)this.jdField_a_of_type_Bglv.a(this)).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgmf
 * JD-Core Version:    0.7.0.1
 */