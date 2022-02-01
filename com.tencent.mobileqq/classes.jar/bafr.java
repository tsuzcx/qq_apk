import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.qphone.base.util.QLog;

class bafr
  extends anuw
{
  bafr(bafq parambafq) {}
  
  protected void onGetAllowSeeLoginDays(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileAccountLevelComponent", 2, String.format("onGetAllowSeeLoginDays isSuccess=%s isAllow=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString }));
    }
    if ((paramBoolean1) && (TextUtils.equals(paramString, ((azxr)bafq.a(this.a)).a.a)))
    {
      bafq.a(this.a, paramBoolean2);
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafr
 * JD-Core Version:    0.7.0.1
 */