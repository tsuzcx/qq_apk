import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;

public class bagi
  extends anyz
{
  public bagi(ProfileCardMoreActivity paramProfileCardMoreActivity) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.a.a != null) && (this.a.a.a.equals(paramString))) {
      this.a.a(paramBoolean, false);
    }
  }
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString)
  {
    if ((paramString != null) && (this.a.a.a != null) && (this.a.a.a.equals(paramString))) {
      this.a.a(paramBoolean, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagi
 * JD-Core Version:    0.7.0.1
 */