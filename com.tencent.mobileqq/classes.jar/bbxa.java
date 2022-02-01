import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import mqq.app.QQPermissionCallback;

public class bbxa
  implements QQPermissionCallback
{
  public bbxa(ScreenShotFragment paramScreenShotFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.b(ScreenShotFragment.a(this.a), this.a.getString(2131698149));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ScreenShotFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxa
 * JD-Core Version:    0.7.0.1
 */