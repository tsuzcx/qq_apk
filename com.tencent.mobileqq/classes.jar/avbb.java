import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;

class avbb
  implements atap
{
  avbb(avba paramavba, CardProfile paramCardProfile, ImageView paramImageView) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_Avba.a(this.jdField_a_of_type_ComTencentMobileqqDataCardProfile, this.jdField_a_of_type_AndroidWidgetImageView, paramBoolean);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_Avba.a;
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
      atah.a(localQQAppInterface, "detail_like", paramString, str1, "", "", str2);
      return;
      str1 = "2";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbb
 * JD-Core Version:    0.7.0.1
 */