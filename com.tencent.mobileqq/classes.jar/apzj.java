import android.os.Bundle;

public abstract class apzj
  implements apyu
{
  private final long a;
  private final long b;
  
  public apzj(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("srcAppID", this.a);
    localBundle.putLong("dstAppID", this.b);
    return localBundle;
  }
  
  public String a()
  {
    return "QQ.Login";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzj
 * JD-Core Version:    0.7.0.1
 */