public class bcun
{
  public int a;
  public String a;
  
  public bcun() {}
  
  public bcun(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(bcun parambcun)
  {
    if (parambcun != null)
    {
      this.jdField_a_of_type_Int = parambcun.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = parambcun.jdField_a_of_type_JavaLangString;
    }
  }
  
  public Object clone()
  {
    return new bcun(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof bcun))
    {
      paramObject = (bcun)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (bdal.a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcun
 * JD-Core Version:    0.7.0.1
 */