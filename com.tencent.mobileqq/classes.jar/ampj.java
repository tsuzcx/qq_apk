final class ampj
{
  public int a;
  public long a;
  public String a;
  public String b;
  private final String c;
  
  public ampj(int paramInt, String paramString1, long paramLong, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramString2;
    this.c = (this.jdField_a_of_type_Int + "-" + this.jdField_a_of_type_JavaLangString + "-" + this.jdField_a_of_type_Long);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ampj)) {}
    do
    {
      return false;
      paramObject = (ampj)paramObject;
    } while ((this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int) || (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != paramObject.jdField_a_of_type_Long));
    return true;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    return "Entry{type=" + this.jdField_a_of_type_Int + ", key='" + this.jdField_a_of_type_JavaLangString + '\'' + ", uin=" + this.jdField_a_of_type_Long + ", path='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ampj
 * JD-Core Version:    0.7.0.1
 */