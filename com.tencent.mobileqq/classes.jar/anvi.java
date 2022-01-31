import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;

public class anvi
  implements View.OnClickListener
{
  public anvi(CardPicGalleryActivity paramCardPicGalleryActivity, bhpy parambhpy) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface;
    if (2 == this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.d)
    {
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.app;
      if (!this.jdField_a_of_type_ComTencentMobileqqBusinessCardActivityCardPicGalleryActivity.b) {
        break label63;
      }
    }
    label63:
    for (paramView = "1";; paramView = "2")
    {
      azmj.b(localQQAppInterface, "dc00898", "", "", "0X800A88C", "0X800A88C", 4, 0, paramView, "", "", "");
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvi
 * JD-Core Version:    0.7.0.1
 */