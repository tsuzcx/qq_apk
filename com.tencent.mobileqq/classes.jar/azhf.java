import com.tencent.mobileqq.app.BaseActivity;
import mqq.app.QQPermissionCallback;

public final class azhf
  implements QQPermissionCallback
{
  public azhf(BaseActivity paramBaseActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!this.a.isFinishing()) {
      bbdj.b(this.a);
    }
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azhf
 * JD-Core Version:    0.7.0.1
 */