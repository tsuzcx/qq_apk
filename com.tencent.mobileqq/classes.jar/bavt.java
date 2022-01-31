public class bavt
{
  public int a;
  public String a;
  
  public bavt() {}
  
  public bavt(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(bavt parambavt)
  {
    if (parambavt != null)
    {
      this.jdField_a_of_type_Int = parambavt.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = parambavt.jdField_a_of_type_JavaLangString;
    }
  }
  
  public Object clone()
  {
    return new bavt(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof bavt))
    {
      paramObject = (bavt)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (bbbr.a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bavt
 * JD-Core Version:    0.7.0.1
 */