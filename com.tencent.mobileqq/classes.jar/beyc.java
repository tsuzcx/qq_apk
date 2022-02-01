public class beyc
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public beyc()
  {
    a();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public beyc a()
  {
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public beyc a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public beyc a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.b = true;
  }
  
  public boolean a()
  {
    return (!this.b) && (!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int != 0);
  }
  
  public beyc b()
  {
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyc
 * JD-Core Version:    0.7.0.1
 */