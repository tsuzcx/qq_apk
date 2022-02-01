import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import mqq.app.QQPermissionCallback;

public class bfkb
  implements QQPermissionCallback
{
  public bfkb(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
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
 * Qualified Name:     bfkb
 * JD-Core Version:    0.7.0.1
 */