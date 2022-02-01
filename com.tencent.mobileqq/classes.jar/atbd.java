public class atbd
  extends atbb
{
  public atbd(atba paramatba, atag paramatag)
  {
    super(paramatba, paramatag);
    this.jdField_a_of_type_Int = 2;
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    this.jdField_a_of_type_Atag.a();
    this.jdField_a_of_type_Atag.a().a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    switch (paramInt1)
    {
    default: 
      return false;
    case 103: 
      this.jdField_a_of_type_Atag.a().a();
    case 104: 
      this.jdField_a_of_type_Atba.a(0, paramInt2);
    case 105: 
      for (;;)
      {
        return true;
        this.jdField_a_of_type_Atba.a(0, paramInt2);
      }
    }
    this.jdField_a_of_type_Atag.a().a();
    this.jdField_a_of_type_Atba.a(0, paramInt2);
    this.jdField_a_of_type_Atba.b(paramInt1, paramInt2);
    return false;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Atag.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbd
 * JD-Core Version:    0.7.0.1
 */