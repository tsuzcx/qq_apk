import ProfileLogic.QC.setUserProfileRsp;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.qphone.base.util.QLog;

public class amef
  extends akfz
{
  public amef(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public void e(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof setUserProfileRsp)))
    {
      i = ((setUserProfileRsp)paramObject).ret;
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "mSvipObserver: [setUserProfileRsp] ret=" + i);
      }
      if (i == 0)
      {
        if (this.a.app != null)
        {
          paramObject = new ProfileActivity.AllInOne(this.a.app.getCurrentAccountUin(), 0);
          paramObject.g = 1;
          paramObject.h = 8;
          ProfileActivity.b(this.a, paramObject);
          bcpw.a(this.a, 0, 2131720536, 0).a();
        }
        this.a.finish();
      }
    }
    while (!"profilelogic.setUserProfile".equals(paramObject))
    {
      int i;
      return;
      bcpw.a(this.a, 1, 2131720533, 0).a();
      return;
    }
    bcpw.a(this.a, 1, 2131720533, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amef
 * JD-Core Version:    0.7.0.1
 */