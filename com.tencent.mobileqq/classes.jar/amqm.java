public class amqm
  extends amql
{
  private amrd a;
  
  amqm(String paramString, amrd paramamrd)
  {
    super(paramString);
    this.a = paramamrd;
  }
  
  public amrd a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amqm
 * JD-Core Version:    0.7.0.1
 */