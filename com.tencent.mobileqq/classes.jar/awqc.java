import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelShareActivity;
import mqq.app.QQPermissionCallback;

public class awqc
  implements QQPermissionCallback
{
  public awqc(PersonalityLabelShareActivity paramPersonalityLabelShareActivity) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bdgm.a(this.a, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PersonalityLabelShareActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awqc
 * JD-Core Version:    0.7.0.1
 */