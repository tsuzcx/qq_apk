import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class bkgc
  implements URLDrawable.URLDrawableListener
{
  bkgc(bkgb parambkgb, String paramString, bkfm parambkfm) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    veg.b("InformationFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
    bkgb.a(this.jdField_a_of_type_Bkgb, this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    veg.b("InformationFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bkgb.a(this.jdField_a_of_type_Bkgb).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    bkgb.a(this.jdField_a_of_type_Bkgb, paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bkfm.b, 1);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkgc
 * JD-Core Version:    0.7.0.1
 */