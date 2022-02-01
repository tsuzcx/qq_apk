import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import mqq.app.QQPermissionCallback;

public class bfhf
  implements QQPermissionCallback
{
  public bfhf(TroopAvatarWallPreviewActivity paramTroopAvatarWallPreviewActivity, URLDrawable paramURLDrawable) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAvatarWallPreviewActivity.b(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfhf
 * JD-Core Version:    0.7.0.1
 */