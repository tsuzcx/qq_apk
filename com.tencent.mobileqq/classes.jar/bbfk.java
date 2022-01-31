import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import mqq.app.QQPermissionCallback;

public class bbfk
  implements QQPermissionCallback
{
  public bbfk(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdgm.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.a(this.a, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfk
 * JD-Core Version:    0.7.0.1
 */