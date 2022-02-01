import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public final class bezd
  implements QQPermissionCallback
{
  public bezd(BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.a.isFinishing()) {
      bhdj.a(this.a);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bezd
 * JD-Core Version:    0.7.0.1
 */