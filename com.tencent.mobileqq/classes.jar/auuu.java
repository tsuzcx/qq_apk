import android.os.Bundle;

public class auuu
{
  public long a;
  public long b;
  
  public auuu(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public static auuu a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return new auuu(paramBundle.getLong("RPARAM_RECV_SIZE"), paramBundle.getLong("RPARAM_TRANS_SIZE"));
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
 * Qualified Name:     auuu
 * JD-Core Version:    0.7.0.1
 */