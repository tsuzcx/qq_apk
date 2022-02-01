import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import mqq.app.QQPermissionCallback;

public class baqv
  implements QQPermissionCallback
{
  public baqv(ScreenShotFragment paramScreenShotFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bfur.a(ScreenShotFragment.a(this.a), this.a.getString(2131698314));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ScreenShotFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqv
 * JD-Core Version:    0.7.0.1
 */