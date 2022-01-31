import android.content.Context;
import android.content.SharedPreferences;

public class bfhl
{
  private static SharedPreferences a;
  
  public static SharedPreferences a()
  {
    if (a == null) {
      a = beqb.a().a().getSharedPreferences("pre_miniapp", 4);
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfhl
 * JD-Core Version:    0.7.0.1
 */