import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity;
import mqq.app.QQPermissionCallback;

public class azqk
  implements QQPermissionCallback
{
  public azqk(PersonalityLabelShareActivity paramPersonalityLabelShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhdj.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PersonalityLabelShareActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqk
 * JD-Core Version:    0.7.0.1
 */