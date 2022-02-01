import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import mqq.app.QQPermissionCallback;

public class bfjx
  implements QQPermissionCallback
{
  public bfjx(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfjx
 * JD-Core Version:    0.7.0.1
 */