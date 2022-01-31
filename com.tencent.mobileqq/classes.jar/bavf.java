public class bavf
{
  public int a;
  public String a;
  
  public bavf() {}
  
  public bavf(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(bavf parambavf)
  {
    if (parambavf != null)
    {
      this.jdField_a_of_type_Int = parambavf.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = parambavf.jdField_a_of_type_JavaLangString;
    }
  }
  
  public Object clone()
  {
    return new bavf(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof bavf))
    {
      paramObject = (bavf)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (bbbd.a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bavf
 * JD-Core Version:    0.7.0.1
 */