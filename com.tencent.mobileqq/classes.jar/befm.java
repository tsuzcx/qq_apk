import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

final class befm
  implements QQPermissionCallback
{
  befm(AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.a.isFinishing()) {
      bglp.b(this.a);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befm
 * JD-Core Version:    0.7.0.1
 */