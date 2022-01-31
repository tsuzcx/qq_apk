import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import mqq.app.QQPermissionCallback;

public class ayfz
  implements QQPermissionCallback
{
  public ayfz(ScreenShotFragment paramScreenShotFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdgm.b(ScreenShotFragment.a(this.a), this.a.getString(2131699460));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    ScreenShotFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayfz
 * JD-Core Version:    0.7.0.1
 */