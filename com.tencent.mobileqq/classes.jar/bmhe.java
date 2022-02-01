import cooperation.qzone.util.NetworkState;

public class bmhe
  extends bmgy
{
  public static final String a = bmhe.class.getName();
  public int b = -1;
  
  public bmhe(String paramString)
  {
    super(paramString);
  }
  
  public static boolean a()
  {
    if (bmhm.a() == null) {
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
  
  public bmha a()
  {
    if ((a()) && (this.b == 1)) {
      return bmha.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhe
 * JD-Core Version:    0.7.0.1
 */