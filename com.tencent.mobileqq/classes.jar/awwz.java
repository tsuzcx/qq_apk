import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;

class awwz
  implements auvz
{
  awwz(awwy paramawwy, CardProfile paramCardProfile, ImageView paramImageView) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Awwy.a(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile, this.jdField_a_of_type_AndroidWidgetImageView, paramBoolean);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Awwy.a;
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataCardProfile.type == 3)
    {
      str1 = "1";
      if (!paramBoolean) {
        break label69;
      }
    }
    label69:
    for (String str2 = "2";; str2 = "1")
    {
      auvr.a(localQQAppInterface, "detail_like", paramString, str1, "", "", str2);
      return;
      str1 = "2";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awwz
 * JD-Core Version:    0.7.0.1
 */