public class bhdg
{
  public int a;
  public String a;
  
  public bhdg() {}
  
  public bhdg(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(bhdg parambhdg)
  {
    if (parambhdg != null)
    {
      this.jdField_a_of_type_Int = parambhdg.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = parambhdg.jdField_a_of_type_JavaLangString;
    }
  }
  
  public Object clone()
  {
    return new bhdg(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof bhdg))
    {
      paramObject = (bhdg)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (bhjx.a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdg
 * JD-Core Version:    0.7.0.1
 */