import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

final class bfel
  implements QQPermissionCallback
{
  bfel(AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.a.isFinishing()) {
      bhlq.b(this.a);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfel
 * JD-Core Version:    0.7.0.1
 */