public class bewq
{
  public int a = 40000;
  public int b = 30000;
  public int c = 20000;
  public int d = 20000;
  public int e = 15000;
  public int f = 10000;
  private int g;
  
  public bewq() {}
  
  private bewq(bewq parambewq)
  {
    this.a = parambewq.a;
    this.b = parambewq.b;
    this.c = parambewq.c;
    this.d = parambewq.d;
    this.e = parambewq.e;
    this.f = parambewq.f;
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
  
  public bewq a()
  {
    return new bewq(this);
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
 * Qualified Name:     bewq
 * JD-Core Version:    0.7.0.1
 */