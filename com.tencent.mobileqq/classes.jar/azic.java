public class azic
{
  public int a;
  private int b;
  private int c;
  
  public int a()
  {
    int i = this.b;
    this.b = (i + 1);
    return i;
  }
  
  public void a()
  {
    this.b = 0;
    this.a = 0;
    this.c = 0;
  }
  
  public int b()
  {
    int i = this.c;
    this.c = (i + 1);
    return i;
  }
  
  public void b()
  {
    this.b = 0;
    this.a = 0;
    this.c = 0;
  }
  
  public int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azic
 * JD-Core Version:    0.7.0.1
 */