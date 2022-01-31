import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class bmsd
  implements URLDrawable.URLDrawableListener
{
  bmsd(bmsc parambmsc, String paramString, bmrn parambmrn) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    wsv.b("InformationFaceAdapter", "applyNormalPaster onLoadFialed path:" + this.jdField_a_of_type_JavaLangString);
    bmsc.a(this.jdField_a_of_type_Bmsc, this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setURLDrawableListener(null);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    wsv.b("InformationFaceAdapter", "applyNormalPaster onLoadSuccessed path:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable.setBounds(0, 0, paramURLDrawable.getIntrinsicWidth(), paramURLDrawable.getIntrinsicHeight());
    bmsc.a(this.jdField_a_of_type_Bmsc).a(this.jdField_a_of_type_JavaLangString, paramURLDrawable);
    bmsc.a(this.jdField_a_of_type_Bmsc, paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bmrn.b, 1);
    paramURLDrawable.setURLDrawableListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmsd
 * JD-Core Version:    0.7.0.1
 */