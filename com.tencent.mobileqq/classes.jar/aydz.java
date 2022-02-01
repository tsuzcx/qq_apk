import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class aydz
  implements URLDrawable.URLDrawableListener
{
  aydz(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, ayeg paramayeg) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    yuk.c("ShortVideoShareUtil", "onLoadCanceled --");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    aydu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, null, this.jdField_a_of_type_Ayeg);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    yuk.c("ShortVideoShareUtil", "onLoadProgressed --" + paramInt);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = aydu.a(paramURLDrawable);
    aydu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, paramURLDrawable, this.jdField_a_of_type_Ayeg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydz
 * JD-Core Version:    0.7.0.1
 */