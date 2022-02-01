import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import mqq.app.QQPermissionCallback;

public class bbxk
  implements QQPermissionCallback
{
  public bbxk(ScreenShotFragment paramScreenShotFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(ScreenShotFragment.a(this.a), this.a.getString(2131698610));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ScreenShotFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxk
 * JD-Core Version:    0.7.0.1
 */