import com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity;
import mqq.app.QQPermissionCallback;

public class aqjp
  implements QQPermissionCallback
{
  public aqjp(BusinessCardEditActivity paramBusinessCardEditActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.denied();
    bhdj.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqjp
 * JD-Core Version:    0.7.0.1
 */