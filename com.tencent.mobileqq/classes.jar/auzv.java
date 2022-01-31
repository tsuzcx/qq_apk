public class auzv
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  
  public auzv(auzt paramauzt) {}
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof auzv))
    {
      paramObject = (auzv)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auzv
 * JD-Core Version:    0.7.0.1
 */