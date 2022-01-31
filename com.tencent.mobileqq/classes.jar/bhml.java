import cooperation.qzone.util.NetworkState;

public class bhml
  extends bhmf
{
  public static final String a = bhml.class.getName();
  public int b = -1;
  
  public bhml(String paramString)
  {
    super(paramString);
  }
  
  public static boolean a()
  {
    if (bhmt.a() == null) {
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
  
  public bhmh a()
  {
    if ((a()) && (this.b == 1)) {
      return bhmh.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhml
 * JD-Core Version:    0.7.0.1
 */