public abstract class amwq
  extends amxe
{
  private int a = 1;
  private int b = 1;
  
  public amwq(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 5);
  }
  
  public amwq(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static boolean a(amwq paramamwq)
  {
    return (paramamwq != null) && (paramamwq.a());
  }
  
  public int a()
  {
    return this.b;
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwq
 * JD-Core Version:    0.7.0.1
 */