public class amql
  extends amqk
{
  private amrc a;
  
  amql(String paramString, amrc paramamrc)
  {
    super(paramString);
    this.a = paramamrc;
  }
  
  public amrc a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amql
 * JD-Core Version:    0.7.0.1
 */