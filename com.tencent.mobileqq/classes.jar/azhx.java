import com.tencent.mobileqq.troop.activity.TroopBarReplyActivity;
import mqq.app.QQPermissionCallback;

public class azhx
  implements QQPermissionCallback
{
  public azhx(TroopBarReplyActivity paramTroopBarReplyActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azhx
 * JD-Core Version:    0.7.0.1
 */