import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qphone.base.util.QLog;

class azzc
  extends CardObserver
{
  azzc(azzb paramazzb) {}
  
  public void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAccountLevelComponent", 2, String.format("onGetAllowSeeLoginDays isSuccess=%s isAllow=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    }
    if ((paramBoolean1) && (TextUtils.equals(paramString, ((azrb)azzb.a(this.a)).a.a)))
    {
      azzb.a(this.a, paramBoolean2);
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzc
 * JD-Core Version:    0.7.0.1
 */