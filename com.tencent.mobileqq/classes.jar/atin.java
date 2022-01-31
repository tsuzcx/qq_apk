import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class atin
  implements URLDrawable.URLDrawableListener
{
  atin(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, atiu paramatiu) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    ved.c("ShortVideoShareUtil", "onLoadCanceled --");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    atij.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, null, this.jdField_a_of_type_Atiu);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    ved.c("ShortVideoShareUtil", "onLoadProgressed --" + paramInt);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = atij.a(paramURLDrawable);
    atij.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, paramURLDrawable, this.jdField_a_of_type_Atiu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atin
 * JD-Core Version:    0.7.0.1
 */