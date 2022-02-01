import cooperation.qzone.util.NetworkState;

public class bnig
  extends bnia
{
  public static final String a = bnig.class.getName();
  public int b = -1;
  
  public bnig(String paramString)
  {
    super(paramString);
  }
  
  public static boolean a()
  {
    if (bnio.a() == null) {
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
  
  public bnic a()
  {
    if ((a()) && (this.b == 1)) {
      return bnic.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnig
 * JD-Core Version:    0.7.0.1
 */