final class bktj
  extends bktm
{
  public bkuf a;
  private String jdField_a_of_type_JavaLangString;
  
  public bktj(bkth parambkth, String paramString)
  {
    super(null);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a(String paramString, bkuf parambkuf)
  {
    if (paramString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Bkuf = parambkuf;
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bktj
 * JD-Core Version:    0.7.0.1
 */