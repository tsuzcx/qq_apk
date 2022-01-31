public class beko
  implements bekl<Boolean>
{
  private int a;
  
  public static beko a(int paramInt)
  {
    beko localbeko = new beko();
    localbeko.a = paramInt;
    return localbeko;
  }
  
  public Boolean a(behn parambehn)
  {
    switch (this.a)
    {
    default: 
      return Boolean.valueOf(false);
    case 2: 
      return Boolean.valueOf(parambehn.c());
    }
    return Boolean.valueOf(parambehn.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beko
 * JD-Core Version:    0.7.0.1
 */