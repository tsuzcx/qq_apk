import cooperation.qzone.util.NetworkState;

public class bjsu
  extends bjso
{
  public static final String a = bjsu.class.getName();
  public int b = -1;
  
  public bjsu(String paramString)
  {
    super(paramString);
  }
  
  public static boolean a()
  {
    if (bjtc.a() == null) {
      return false;
    }
    return NetworkState.isWap();
  }
  
  public int a(String paramString, int paramInt)
  {
    if (this.b == -1)
    {
      int j = super.a(paramString, paramInt);
      int i = j;
      if (a())
      {
        if (j != 0)
        {
          this.b = 1;
          i = super.a(paramString, paramInt);
        }
      }
      else {
        return i;
      }
      this.b = 0;
      return j;
    }
    return super.a(paramString, paramInt);
  }
  
  public bjsq a()
  {
    if ((a()) && (this.b == 1)) {
      return bjsq.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjsu
 * JD-Core Version:    0.7.0.1
 */