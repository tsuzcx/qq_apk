import android.os.Bundle;

public abstract class anqq
{
  private static int seed;
  public int key;
  
  public anqq()
  {
    int i = seed;
    seed = i + 1;
    this.key = i;
  }
  
  public abstract void onBindedToClient();
  
  public abstract void onDisconnectWithService();
  
  public abstract void onPushMsg(Bundle paramBundle);
  
  public abstract void onResponse(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anqq
 * JD-Core Version:    0.7.0.1
 */