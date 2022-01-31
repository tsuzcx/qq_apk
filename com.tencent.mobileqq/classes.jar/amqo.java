public class amqo
  extends amql
{
  private amrf a;
  
  amqo(String paramString, amrf paramamrf)
  {
    super(paramString);
    this.a = paramamrf;
  }
  
  public amrf a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqo
 * JD-Core Version:    0.7.0.1
 */