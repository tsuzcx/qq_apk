import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity;
import mqq.app.QQPermissionCallback;

public class auuh
  implements QQPermissionCallback
{
  public auuh(PersonalityLabelShareActivity paramPersonalityLabelShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bbdj.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PersonalityLabelShareActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auuh
 * JD-Core Version:    0.7.0.1
 */