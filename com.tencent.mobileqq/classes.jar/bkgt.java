import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class bkgt
  implements URLDrawable.URLDrawableListener
{
  bkgt(bkgs parambkgs, String paramString, bkgd parambkgd) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ved.b("InformationFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
    bkgs.a(this.jdField_a_of_type_Bkgs, this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ved.b("InformationFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bkgs.a(this.jdField_a_of_type_Bkgs).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    bkgs.a(this.jdField_a_of_type_Bkgs, paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bkgd.b, 1);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkgt
 * JD-Core Version:    0.7.0.1
 */