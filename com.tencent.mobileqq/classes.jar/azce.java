import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

final class azce
  implements QQPermissionCallback
{
  azce(AppActivity paramAppActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.a.isFinishing()) {
      bbcv.b(this.a);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azce
 * JD-Core Version:    0.7.0.1
 */