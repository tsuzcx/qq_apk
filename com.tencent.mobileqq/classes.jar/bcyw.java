public class bcyw
{
  public int a;
  public String a;
  
  public bcyw() {}
  
  public bcyw(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(bcyw parambcyw)
  {
    if (parambcyw != null)
    {
      this.jdField_a_of_type_Int = parambcyw.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = parambcyw.jdField_a_of_type_JavaLangString;
    }
  }
  
  public Object clone()
  {
    return new bcyw(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof bcyw))
    {
      paramObject = (bcyw)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (bdeu.a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyw
 * JD-Core Version:    0.7.0.1
 */