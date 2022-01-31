public class blfr
  extends bmes
{
  private bmen<Boolean> a = new bmen();
  private bmen<Boolean> b = new bmen();
  private bmen<Boolean> c = new bmen();
  
  public bmen<Boolean> a()
  {
    return this.a;
  }
  
  public boolean a()
  {
    if (this.b.a() != null) {
      return ((Boolean)this.b.a()).booleanValue();
    }
    return false;
  }
  
  public bmen<Boolean> b()
  {
    return this.b;
  }
  
  public boolean b()
  {
    if (this.c.a() != null) {
      return ((Boolean)this.c.a()).booleanValue();
    }
    return false;
  }
  
  public bmen<Boolean> c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfr
 * JD-Core Version:    0.7.0.1
 */