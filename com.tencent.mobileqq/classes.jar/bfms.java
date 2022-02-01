public class bfms
{
  public int a;
  public String a;
  
  public bfms() {}
  
  public bfms(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(bfms parambfms)
  {
    if (parambfms != null)
    {
      this.jdField_a_of_type_Int = parambfms.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = parambfms.jdField_a_of_type_JavaLangString;
    }
  }
  
  public Object clone()
  {
    return new bfms(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof bfms))
    {
      paramObject = (bfms)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (bftf.a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfms
 * JD-Core Version:    0.7.0.1
 */