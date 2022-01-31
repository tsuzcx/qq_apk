import android.os.Bundle;

public abstract class aphy
{
  private static int seed;
  public int key;
  
  public aphy()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphy
 * JD-Core Version:    0.7.0.1
 */