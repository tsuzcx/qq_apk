import android.os.Bundle;

public class arpv
{
  public long a;
  public long b;
  
  public arpv(long paramLong1, long paramLong2)
  {
    this.a = paramLong1;
    this.b = paramLong2;
  }
  
  public static arpv a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return new arpv(paramBundle.getLong("RPARAM_RECV_SIZE"), paramBundle.getLong("RPARAM_TRANS_SIZE"));
  }
  
  public Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("RPARAM_RECV_SIZE", this.a);
    localBundle.putLong("RPARAM_TRANS_SIZE", this.b);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arpv
 * JD-Core Version:    0.7.0.1
 */