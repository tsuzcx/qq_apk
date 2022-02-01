import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity;
import mqq.app.QQPermissionCallback;

public class azxa
  implements QQPermissionCallback
{
  public azxa(PersonalityLabelShareActivity paramPersonalityLabelShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PersonalityLabelShareActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxa
 * JD-Core Version:    0.7.0.1
 */