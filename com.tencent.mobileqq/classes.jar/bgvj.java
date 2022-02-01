public class bgvj
{
  public int a;
  public String a;
  
  public bgvj() {}
  
  public bgvj(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(bgvj parambgvj)
  {
    if (parambgvj != null)
    {
      this.jdField_a_of_type_Int = parambgvj.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = parambgvj.jdField_a_of_type_JavaLangString;
    }
  }
  
  public Object clone()
  {
    return new bgvj(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof bgvj))
    {
      paramObject = (bgvj)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (bhbx.a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvj
 * JD-Core Version:    0.7.0.1
 */