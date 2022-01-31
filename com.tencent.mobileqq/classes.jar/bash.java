public class bash
{
  public int a = 40000;
  public int b = 30000;
  public int c = 20000;
  public int d = 20000;
  public int e = 15000;
  public int f = 10000;
  private int g;
  
  public bash() {}
  
  private bash(bash parambash)
  {
    this.a = parambash.a;
    this.b = parambash.b;
    this.c = parambash.c;
    this.d = parambash.d;
    this.e = parambash.e;
    this.f = parambash.f;
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
  
  public bash a()
  {
    return new bash(this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bash
 * JD-Core Version:    0.7.0.1
 */