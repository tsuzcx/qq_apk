public class bdfw
  implements bdft<Boolean>
{
  private int a;
  
  public static bdfw a(int paramInt)
  {
    bdfw localbdfw = new bdfw();
    localbdfw.a = paramInt;
    return localbdfw;
  }
  
  public Boolean a(bdcw parambdcw)
  {
    switch (this.a)
    {
    default: 
      return Boolean.valueOf(false);
    case 2: 
      return Boolean.valueOf(parambdcw.c());
    }
    return Boolean.valueOf(parambdcw.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdfw
 * JD-Core Version:    0.7.0.1
 */