import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity;
import mqq.app.QQPermissionCallback;

public class awlt
  implements QQPermissionCallback
{
  public awlt(PersonalityLabelShareActivity paramPersonalityLabelShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdcd.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PersonalityLabelShareActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awlt
 * JD-Core Version:    0.7.0.1
 */