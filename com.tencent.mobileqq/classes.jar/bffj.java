import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import mqq.app.QQPermissionCallback;

public class bffj
  implements QQPermissionCallback
{
  public bffj(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a(this.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffj
 * JD-Core Version:    0.7.0.1
 */