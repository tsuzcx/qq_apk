public abstract class boju
{
  public static boju a(int paramInt)
  {
    if (paramInt > 0) {
      return new bojv();
    }
    return new bojw();
  }
  
  public abstract int a(int paramInt);
  
  public abstract boolean a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boju
 * JD-Core Version:    0.7.0.1
 */