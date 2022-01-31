public class bfhw
{
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private boolean jdField_a_of_type_Boolean;
  
  public bfhw()
  {
    a();
  }
  
  private void a()
  {
    a(",");
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public bfhw a()
  {
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public bfhw a(int paramInt)
  {
    return a(String.format("%d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public bfhw a(String paramString)
  {
    a();
    paramString = paramString.replace(',', ';');
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    return this;
  }
  
  public bfhw a(byte[] paramArrayOfByte)
  {
    return a(bbea.a(paramArrayOfByte));
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfhw
 * JD-Core Version:    0.7.0.1
 */