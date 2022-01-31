import cooperation.qzone.util.NetworkState;

public class bgdy
  extends bgds
{
  public static final String a = bgdy.class.getName();
  public int b = -1;
  
  public bgdy(String paramString)
  {
    super(paramString);
  }
  
  public static boolean a()
  {
    if (bgeg.a() == null) {
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
  
  public bgdu a()
  {
    if ((a()) && (this.b == 1)) {
      return bgdu.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgdy
 * JD-Core Version:    0.7.0.1
 */