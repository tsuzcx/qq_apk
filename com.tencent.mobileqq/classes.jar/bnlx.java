import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class bnlx
  implements URLDrawable.URLDrawableListener
{
  bnlx(bnlw parambnlw, String paramString, bnli parambnli) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    xvv.b("InformationFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
    bnlw.a(this.jdField_a_of_type_Bnlw, this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    xvv.b("InformationFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bnlw.a(this.jdField_a_of_type_Bnlw).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    bnlw.a(this.jdField_a_of_type_Bnlw, paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bnli.b, 1);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnlx
 * JD-Core Version:    0.7.0.1
 */