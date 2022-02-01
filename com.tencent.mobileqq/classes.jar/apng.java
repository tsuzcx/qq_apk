public abstract class apng
  extends apnu
{
  private int a = 1;
  private int b = 1;
  
  public apng(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 5);
  }
  
  public apng(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public static boolean a(apng paramapng)
  {
    return (paramapng != null) && (paramapng.a());
  }
  
  public int a()
  {
    return this.b;
  }
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apng
 * JD-Core Version:    0.7.0.1
 */