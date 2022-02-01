import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import mqq.app.QQPermissionCallback;

public class aqnx
  implements QQPermissionCallback
{
  public aqnx(CardPicGalleryActivity paramCardPicGalleryActivity, URLDrawable paramURLDrawable) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    bhlq.a(this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.b(this.jdField_a_of_type_ComTencentImageURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqnx
 * JD-Core Version:    0.7.0.1
 */