import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

final class bbaf
  implements QQPermissionCallback
{
  bbaf(AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.a.isFinishing()) {
      bdcd.b(this.a);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbaf
 * JD-Core Version:    0.7.0.1
 */