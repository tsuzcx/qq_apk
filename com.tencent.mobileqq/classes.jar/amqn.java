public class amqn
  extends amql
{
  private amre jdField_a_of_type_Amre;
  private amro jdField_a_of_type_Amro;
  
  public amqn(String paramString, amre paramamre, amro paramamro)
  {
    super(paramString);
    this.jdField_a_of_type_Amre = paramamre;
    this.jdField_a_of_type_Amro = paramamro;
  }
  
  public amre a()
  {
    return this.jdField_a_of_type_Amre;
  }
  
  public amro a()
  {
    return this.jdField_a_of_type_Amro;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqn
 * JD-Core Version:    0.7.0.1
 */