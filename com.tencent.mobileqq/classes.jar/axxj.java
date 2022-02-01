import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.QQAppInterface;

final class axxj
  implements URLDrawable.URLDrawableListener
{
  axxj(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, axxq paramaxxq) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    ykq.c("ShortVideoShareUtil", "onLoadCanceled --");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    axxe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, null, this.jdField_a_of_type_Axxq);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    ykq.c("ShortVideoShareUtil", "onLoadProgressed --" + paramInt);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = axxe.a(paramURLDrawable);
    axxe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, paramURLDrawable, this.jdField_a_of_type_Axxq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axxj
 * JD-Core Version:    0.7.0.1
 */