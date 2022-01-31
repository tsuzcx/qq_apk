import android.os.Bundle;

public class apwt
{
  public long a;
  public long b;
  
  public apwt(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public static apwt a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return new apwt(paramBundle.getLong("RPARAM_RECV_SIZE"), paramBundle.getLong("RPARAM_TRANS_SIZE"));
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("RPARAM_RECV_SIZE", this.a);
    localBundle.putLong("RPARAM_TRANS_SIZE", this.b);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apwt
 * JD-Core Version:    0.7.0.1
 */