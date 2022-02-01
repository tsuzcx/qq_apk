public class axhe
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  
  public axhe(axhc paramaxhc) {}
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof axhe))
    {
      paramObject = (axhe)paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axhe
 * JD-Core Version:    0.7.0.1
 */