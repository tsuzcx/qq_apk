import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import mqq.app.QQPermissionCallback;

public class amdm
  implements QQPermissionCallback
{
  public amdm(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.denied();
    bbdj.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amdm
 * JD-Core Version:    0.7.0.1
 */