import android.text.TextUtils;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.qphone.base.util.QLog;

public class atvl
  extends ajjh
{
  public atvl(PersonalityLabelGalleryActivity paramPersonalityLabelGalleryActivity) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PersonalityLabelGalleryActivity", 2, "onUpdateFriendInfo refresh UI uin:" + paramString + " suc:" + paramBoolean);
    }
    if ((paramBoolean) && (TextUtils.equals(PersonalityLabelGalleryActivity.a(this.a), paramString)) && (!PersonalityLabelGalleryActivity.a(this.a)))
    {
      PersonalityLabelGalleryActivity.a(this.a, babh.a(this.a.app, PersonalityLabelGalleryActivity.a(this.a)));
      if (!TextUtils.equals(PersonalityLabelGalleryActivity.a(this.a), PersonalityLabelGalleryActivity.b(this.a))) {
        PersonalityLabelGalleryActivity.d(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvl
 * JD-Core Version:    0.7.0.1
 */