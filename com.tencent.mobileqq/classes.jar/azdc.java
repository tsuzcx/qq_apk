import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import mqq.app.QQPermissionCallback;

public class azdc
  implements QQPermissionCallback
{
  public azdc(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a(this.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azdc
 * JD-Core Version:    0.7.0.1
 */