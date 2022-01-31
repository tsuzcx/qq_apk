import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class asud
  implements URLDrawable.URLDrawableListener
{
  asud(asuc paramasuc, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.e("ImaxAdvertisement", 1, "s_forShare Bitmap onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("ImaxAdvertisement", 1, "s_forShare Bitmap FAILED, no more action ...");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = auzi.a(paramURLDrawable);
    asuc.a(this.jdField_a_of_type_Asuc, this.jdField_a_of_type_JavaLangString, this.b, this.c, paramURLDrawable, this.d, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asud
 * JD-Core Version:    0.7.0.1
 */