public class azub
{
  public int a;
  public String a;
  
  public azub() {}
  
  public azub(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(azub paramazub)
  {
    if (paramazub != null)
    {
      this.jdField_a_of_type_Int = paramazub.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = paramazub.jdField_a_of_type_JavaLangString;
    }
  }
  
  public Object clone()
  {
    return new azub(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof azub))
    {
      paramObject = (azub)paramObject;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_Int == this.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (azzz.a(paramObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azub
 * JD-Core Version:    0.7.0.1
 */