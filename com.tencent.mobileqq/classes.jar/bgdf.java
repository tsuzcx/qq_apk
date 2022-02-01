public class bgdf
{
  public int a;
  public String a;
  
  public bgdf() {}
  
  public bgdf(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(bgdf parambgdf)
  {
    if (parambgdf != null)
    {
      this.jdField_a_of_type_Int = parambgdf.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = parambgdf.jdField_a_of_type_JavaLangString;
    }
  }
  
  public Object clone()
  {
    return new bgdf(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof bgdf))
    {
      paramObject = (bgdf)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (bgjw.a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgdf
 * JD-Core Version:    0.7.0.1
 */