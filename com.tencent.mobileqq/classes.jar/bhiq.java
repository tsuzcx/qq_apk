public class bhiq
{
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private boolean jdField_a_of_type_Boolean;
  
  public bhiq()
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
  
  public bhiq a()
  {
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public bhiq a(int paramInt)
  {
    return a(String.format("%d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public bhiq a(String paramString)
  {
    a();
    paramString = paramString.replace(',', ';');
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    return this;
  }
  
  public bhiq a(byte[] paramArrayOfByte)
  {
    return a(bdcv.a(paramArrayOfByte));
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhiq
 * JD-Core Version:    0.7.0.1
 */