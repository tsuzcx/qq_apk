import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qphone.base.util.QLog;

class babx
  extends CardObserver
{
  babx(babw parambabw) {}
  
  public void onDelQZonePhotoWall(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePhotoWallComponent", 2, String.format("onDelQZonePhotoWall isSuc=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString }));
    }
    babw.a(this.a, paramBoolean);
  }
  
  public void onGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfilePhotoWallComponent", 2, String.format("onGetQZonePhotoWall isSuc=%s uin=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString2 }));
    }
    babw.a(this.a, paramBoolean, paramString1, parammobile_sub_get_photo_wall_rsp, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babx
 * JD-Core Version:    0.7.0.1
 */