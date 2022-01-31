public class ayui
{
  public int a = 40000;
  public int b = 30000;
  public int c = 20000;
  public int d = 20000;
  public int e = 15000;
  public int f = 10000;
  private int g;
  
  public ayui() {}
  
  private ayui(ayui paramayui)
  {
    this.a = paramayui.a;
    this.b = paramayui.b;
    this.c = paramayui.c;
    this.d = paramayui.d;
    this.e = paramayui.e;
    this.f = paramayui.f;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.a;
    case 1: 
    case 4: 
    case 5: 
      return this.c;
    }
    return this.b;
  }
  
  public ayui a()
  {
    return new ayui(this);
  }
  
  public void a(int paramInt)
  {
    this.g = (paramInt * 2000);
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return this.d + this.g;
    case 1: 
    case 4: 
    case 5: 
      return this.f + this.g;
    }
    return this.e + this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayui
 * JD-Core Version:    0.7.0.1
 */