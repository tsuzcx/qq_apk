import android.text.TextUtils;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.17.1;
import com.tencent.qphone.base.util.QLog;

public class atoy
  implements alyr
{
  public atoy(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onDownloadUpdate  url:" + paramString + "   progress:" + paramInt);
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.a.p)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onDownloadFinish  url:" + paramString + "   isSuccess:" + paramBoolean1 + "  isFileExist:" + paramBoolean2);
    }
    this.a.runOnUiThread(new NearbyPeopleProfileActivity.17.1(this, paramString, paramBoolean1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atoy
 * JD-Core Version:    0.7.0.1
 */