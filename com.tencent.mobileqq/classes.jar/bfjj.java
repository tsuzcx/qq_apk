import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public final class bfjj
  implements QQPermissionCallback
{
  public bfjj(BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.a.isFinishing()) {
      bhlq.b(this.a);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfjj
 * JD-Core Version:    0.7.0.1
 */